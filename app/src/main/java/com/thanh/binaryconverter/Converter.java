package com.thanh.binaryconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Converter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTitle("The Decipher");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        Button convertButton = (Button)findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = ((EditText) (findViewById(R.id.input))).getText().toString();
                String output = convertBinaryToDecimal(input);
                display(output);
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
    }

    private void display(String output) {
        ((TextView)findViewById(R.id.outputView)).setText(output);
    }

    private String convertBinaryToDecimal(String binaryString) {
        String result = "";
        for(int index = binaryString.length() - 1; index > 0; index = index - 8) {
            if(index < 7) {
                result = (char)(Integer.parseInt(binaryString.substring(0, index + 1), 2)) + result;
            } else {
                result = (char)(Integer.parseInt(binaryString.substring(index - 7, index+ 1), 2)) + result;
            }
        }
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_converter, menu);
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
