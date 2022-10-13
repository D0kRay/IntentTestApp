package com.example.intenttestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.intents, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void onClick(View view) {
        int position = spinner.getSelectedItemPosition();
        Intent intent = null;
        switch (position) {
            case 0: //open browser
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.thu.de"));
                break;
            case 1:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+49)7306922425"));
                break;
            case 2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:55.133,18.3434?z=19"));
                break;
            case 3:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Bellenberg"));
                break;
            case 4:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                break;
            case 5:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                break;
        }
        if(intent != null) {
            startActivity(intent);
        }
    }
}