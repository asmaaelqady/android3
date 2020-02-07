package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button but ;
    ArrayList<String> messages;
    int count  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but = (Button) findViewById(R.id.button1);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 messages = new ArrayList<String>();
                messages.add("One");
                messages.add("Two");
                messages.add("asmaa");
                buildAlertDialog(messages.size(), messages.get(0));

        }
    });

} private void buildAlertDialog(int length, String message) {
        if (count != length) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage(message);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            count++;
                            buildAlertDialog (3,"asmaa");
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            count++;
                            buildAlertDialog(messages.size(), messages.get(3-count+1));
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }

    }
}



