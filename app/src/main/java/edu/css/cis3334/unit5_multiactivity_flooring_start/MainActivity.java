package edu.css.cis3334.unit5_multiactivity_flooring_start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    EditText length;
    EditText width;
    double doubleLength;
    double doubleWidth;
    double totalArea;
    String outputString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activityButton = (Button) findViewById(R.id.btnShowResults);
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*This takes the text fields and sets them to the "EditText" variables
                 length and width*/
                length = (EditText) findViewById(R.id.etLength);
                width = (EditText) findViewById(R.id.etWidth);

                //This converts them to Strings
                String lengthString = length.getText().toString();//
                doubleLength = Double.parseDouble(lengthString);

                String widthString = width.getText().toString();
                doubleWidth = Double.parseDouble(widthString);

                totalArea = doubleLength * doubleWidth;

                outputString = "Width is " + doubleWidth + " and length is " + doubleLength +
                        " and flooring needed is " + totalArea;

                Intent startIntent = new Intent(getApplicationContext(),
                        Main2Activity.class);
                startIntent.putExtra("edu.css.MESSAGE", outputString );
                startActivity(startIntent);
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
