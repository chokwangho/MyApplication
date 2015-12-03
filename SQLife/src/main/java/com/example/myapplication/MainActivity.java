package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    myDBHelper myHelper;
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect,btnChange, btnDel;
    SQLiteDatabase sqlDB;


    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context){
            super(context,"groupDB",null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE groupTBL(gName CHAR(20) PRIMARY KEY, gNumber integer);");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHelper = new myDBHelper(this);
        btnInit = (Button)findViewById(R.id.btnInit);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnSelect = (Button)findViewById(R.id.btnSelect);
        btnChange = (Button)findViewById(R.id.btnChange);
        btnDel = (Button)findViewById(R.id.btnDel);
        edtName = (EditText)findViewById(R.id.edtName);
        edtNumber = (EditText)findViewById(R.id.edtNumber);
        edtNameResult = (EditText)findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText)findViewById(R.id.edtNumberResult);

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB,1,2);
                sqlDB.close();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("insert into groupTBL values('"+edtName.getText().toString()+"',"
                        + edtNumber.getText().toString()+");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"ÀÔ·ÂµÊ",Toast.LENGTH_SHORT).show();

            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("select * from groupTBL;",null);
                String strNames = "±×·ì ÀÌ¸§" + "\r\n" + "-------" + "\r\n";
                String strNumbers = "ÀÎ¿ø"+"\r\n" + "-------" + "\r\n";
                while(cursor.moveToNext()){
                    strNames += cursor.getString(0)+ "\r\n";
                    strNumbers += cursor.getString(1)+ "\r\n";
                }
                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();


            }
        });
        btnDel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName='" + edtName.getText().toString() + "';");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"»èÁ¦µÊ",Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();
            }
        });
        btnChange.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqlDB= myHelper.getWritableDatabase();
                sqlDB.execSQL("UPDATE groupTBL SET gNumber="+edtNumber.getText().toString()+ " WHERE gName='"
                        +edtName.getText().toString()+"';");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"¼öÁ¤µÊ",Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
