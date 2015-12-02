package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {
    Integer[] posterId = {
            R.drawable.mov1 , R.drawable.mov2, R.drawable.mov3,
            R.drawable.mov4, R.drawable.mov5, R.drawable.mov6,
            R.drawable.mov7, R.drawable.mov8, R.drawable.mov9,
            R.drawable.mov10 };
    String []postername = {
            "New World", "The Host", "Blades Of Blood", "MATRIX", "Secretly Greatly",
            "Hindsight", "Vacance", "Into The White Night", "The Incompetent", "Bad Guy"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gv = (GridView) findViewById(R.id.gridview1);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gv.setAdapter(gridAdapter);
    }

    public class MyGridAdapter extends BaseAdapter
    {
        Context context;
        public MyGridAdapter(Context c)
        {
            context = c;
        }
        public int getCount()
        {
            return posterId.length;
        }

        public Object getItem(int arg0)
        {
            return null;
        }

        public  long getItemId(int arg0)
        {
            return 0;
        }

        public View getView(int position, View convertview, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ImageView imageView;
            TextView textView;

            final int pos = position;
            if(convertview == null) {
                convertview = getLayoutInflater().inflate(R.layout.dialog, null);
                convertview.setLayoutParams(new GridView.LayoutParams(100, 150));
                convertview.setPadding(5, 5, 5, 5);
            }
            imageView = (ImageView) convertview.findViewById(R.id.ivposter);
            textView = (TextView) convertview.findViewById(R.id.text);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageResource(posterId[position]);

            textView.setText(postername[position]);



            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogview = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivposter = (ImageView) dialogview.findViewById(R.id.ivposter);
                    TextView textView1 = (TextView) dialogview.findViewById(R.id.text);
                    ivposter.setScaleType(ImageView.ScaleType.FIT_XY);

                    Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.drawable.mov1); // 비트맵 이미지를 만든다.
                    int width=300; // 가로 사이즈 지정
                    int height=450; // 세로 사이즈 지정
                    Bitmap resizedbitmap= Bitmap.createScaledBitmap(bmp, width, height, true); // 이미지 사이즈 조정
                    ivposter.setImageBitmap(resizedbitmap); // 이미지뷰에 조정한 이미지 넣기

                    ivposter.setImageResource(posterId[pos]);

                    textView1.setVisibility(View.INVISIBLE);
                    dlg.setTitle(postername[pos]);
                    //   dlg.setIcon(R.drawable.ic_lancher);
                    dlg.setView(dialogview);
                    dlg.setNegativeButton("close", null);
                    dlg.show();
                }
            });



            /*
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(100, 150));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);
            imageview.setImageResource(posterId[position]);
            TextView textView = new TextView(context);
            textView.setLayoutParams(new GridView.LayoutParams(100, 150));
            textView.setText(postername[position]);
*/

            return convertview;
        }
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
