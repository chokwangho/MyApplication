package com.example.myapplication;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends Activity {

        EditText edit1, edit2;
        Button btadd, btsub, btmul, btdiv, btrdm;
        TextView textresult;
        String num1, num2;
        Integer result;
        Button numbutton[] = new Button[10];
        Integer numbuttonid[] = {R.id.bt0, R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4,R.id.bt5,
                R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9};
        int i;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("simple calculate");

            edit1 = (EditText) findViewById(R.id.edit1);
            edit2 = (EditText) findViewById(R.id.edit2);
            btadd = (Button) findViewById(R.id.btadd);
            btsub = (Button) findViewById(R.id.btsub);
            btmul = (Button) findViewById(R.id.btmul);
            btdiv = (Button) findViewById(R.id.btdiv);

            textresult = (TextView) findViewById(R.id.textresult);

            for(i=0; i< numbuttonid.length; i++)
            {
                numbutton[i] = (Button) findViewById(numbuttonid[i]);
            }

            for(i=0; i< numbuttonid.length; i++)
            {
                final int index;
                index = i;

                numbutton[index].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(edit1.isFocused() == true)
                        {
                            num1 = edit1.getText().toString() + numbutton[index].getText().toString();
                            edit1.setText(num1);
                        }
                        else if(edit2.isFocused() == true)
                        {
                            num2 = edit2.getText().toString() + numbutton[index].getText().toString();
                            edit2.setText(num2);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "input value", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            btadd.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) throws NumberFormatException{
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if((edit1.getText().toString() == null) || (edit2.getText().toString() == null)) {
                        Toast.makeText(getApplicationContext(), "input value", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        try {
                            result = Integer.parseInt(num1) + Integer.parseInt(num2);
                            textresult.setText("result : " + result.toString());
                        }
                        catch (NumberFormatException e)
                        {
                            Toast.makeText(getApplicationContext(), "input value", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

            btsub.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if((edit1.getText().toString() == null) || (edit2.getText().toString() == null)) {
                        Toast.makeText(getApplicationContext(), "input value", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        try {
                            result = Integer.parseInt(num1) - Integer.parseInt(num2);
                            textresult.setText("result : " + result.toString());
                        }
                        catch (NumberFormatException e)
                        {
                            Toast.makeText(getApplicationContext(), "input value", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

            btmul.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if((edit1.getText().toString() == null) || (edit2.getText().toString() == null)) {
                        Toast.makeText(getApplicationContext(), "input value", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        try {
                            result = Integer.parseInt(num1) * Integer.parseInt(num2);
                            String num = String.format("%d", result);
                            textresult.setText("result : " + num);
                        }
                        catch (NumberFormatException e)
                        {
                            Toast.makeText(getApplicationContext(), "input value", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

            btdiv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();

                    if((edit1.getText().toString() == null) || (edit2.getText().toString() == null)) {
                        Toast.makeText(getApplicationContext(), "input value", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        try {
                            if(Double.parseDouble(num2) == 0) {
                                Toast.makeText(getApplicationContext(), "num2 value = 0 error", Toast.LENGTH_LONG).show();
                                textresult.setText("result : infinity");
                            }
                            else {
                                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                                String num = String.format("%d", result);
                                textresult.setText("result : " + num); //num ´ë½Å result.toString()
                            }
                        }
                        catch (NumberFormatException e)
                        {
                            Toast.makeText(getApplicationContext(), "input value", Toast.LENGTH_LONG).show();
                        }
                    }
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
