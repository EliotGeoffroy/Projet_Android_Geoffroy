package com.projet.geoffroy.projet_android_geoffroy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final TextView mTxtDisplay = (TextView) findViewById(R.id.listString);

        Intent intent = getIntent();
        String txtJSON = intent.getStringExtra("response");
        mTxtDisplay.setText(txtJSON.substring(0, 500));



    }
}
