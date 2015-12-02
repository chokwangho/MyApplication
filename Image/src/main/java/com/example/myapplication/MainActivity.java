package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    TextView tv1,tv2;
    Switch sw1;
    RadioGroup rg1;
    RadioButton rbjb,rbkk,rblp;
    ImageView imv;
    Button bexit,binitial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("select view");

        tv1 = (TextView) findViewById(R.id.text1);
        tv2 = (TextView) findViewById(R.id.text2);
        sw1 = (Switch) findViewById(R.id.swt);
        rg1 = (RadioGroup) findViewById(R.id.radiog1);
        rbjb = (RadioButton) findViewById(R.id.rbjb);
        rbkk = (RadioButton) findViewById(R.id.rbkk);
        rblp = (RadioButton) findViewById(R.id.rblp);
        imv = (ImageView) findViewById(R.id.img1);
        bexit = (Button) findViewById(R.id.but1);
        binitial = (Button) findViewById(R.id.but2);

        rg1.setVisibility(View.INVISIBLE);
        rblp.setVisibility(View.INVISIBLE);
        rbkk.setVisibility(View.INVISIBLE);
        rbjb.setVisibility(View.INVISIBLE);
        imv.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        bexit.setVisibility(View.INVISIBLE);
        binitial.setVisibility(View.INVISIBLE);

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    rg1.setVisibility(View.VISIBLE);
                    rblp.setVisibility(View.VISIBLE);
                    rbkk.setVisibility(View.VISIBLE);
                    rbjb.setVisibility(View.VISIBLE);
                    imv.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    bexit.setVisibility(View.VISIBLE);
                    binitial.setVisibility(View.VISIBLE);
                }
                else
                {
                    rg1.setVisibility(View.INVISIBLE);
                    rblp.setVisibility(View.INVISIBLE);
                    rbkk.setVisibility(View.INVISIBLE);
                    rbjb.setVisibility(View.INVISIBLE);
                    imv.setVisibility(View.INVISIBLE);
                    rbjb.setChecked(false);
                    rbkk.setChecked(false);
                    rblp.setChecked(false);
                    imv.setVisibility(View.INVISIBLE);
                    imv.setImageResource(0);
                    tv2.setVisibility(View.INVISIBLE);
                    bexit.setVisibility(View.INVISIBLE);
                    binitial.setVisibility(View.INVISIBLE);
                }
            }
        });

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbjb:
                        imv.setImageResource(R.drawable.jelly);
                        break;
                    case R.id.rbkk:
                        imv.setImageResource(R.drawable.kitkat);
                        break;
                    case R.id.rblp:
                        imv.setImageResource(R.drawable.lollipop);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "select radio button", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        binitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbjb.setChecked(false);
                rbkk.setChecked(false);
                rblp.setChecked(false);
                imv.setImageResource(0);
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
