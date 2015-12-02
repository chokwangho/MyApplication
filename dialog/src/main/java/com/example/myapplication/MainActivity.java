package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText user, email;
    EditText diaedit1, diaedit2;
    Button button;
    TextView toasttext;
    View toastview, diaview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.user);
        email = (EditText) findViewById(R.id.email);
        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                diaview = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("user informaint input");
                dlg.setIcon(R.drawable.star);
                dlg.setView(diaview);
                diaedit1 = (EditText) diaview.findViewById(R.id.diaedit1);
                diaedit2 = (EditText) diaview.findViewById(R.id.diaedit2);
                diaedit1.setText(user.getText().toString());
                diaedit2.setText(email.getText().toString());

                dlg.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        user.setText(diaedit1.getText().toString());
                        email.setText(diaedit2.getText().toString());
                    }
                });
                dlg.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        toastview = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xoffset = (int) (Math.random() * display.getWidth());
                        int yoffset = (int) (Math.random() * display.getHeight());


                        toasttext = (TextView) toastview.findViewById(R.id.toasttext);
                        toasttext.setText("cancel");
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, xoffset, yoffset);
                        toast.setView(toastview);
                        toast.show();
                    }
                });
                dlg.show();
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
