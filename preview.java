package com.example.travel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class preview extends AppCompatActivity {
    final String MESSAGE_KEY ="message_key";
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        TextView text = (TextView)findViewById(R.id.dept);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        text.setText(str);

        TextView text1 = (TextView)findViewById(R.id.arriv);
        Intent intent1 = getIntent();
        String str1 = intent1.getStringExtra("message1");
        text1.setText(str1);
        TextView text2 = (TextView)findViewById(R.id.from);
        Intent intent2 = getIntent();
        String str2 = intent2.getStringExtra("dept");
        text2.setText(str2);
        TextView text3 = (TextView)findViewById(R.id.tx);
        Intent intent3 = getIntent();
        String str3 = intent3.getStringExtra("arr");
        text3.setText(str3);
        TextView text4 = (TextView)findViewById(R.id.classe);
        Intent intent4 = getIntent();
        String str4= intent4.getStringExtra("datet");
        text4.setText(str4);
        Random objGenerator = new Random();
        TextView text5 = (TextView)findViewById(R.id.flight);
        text5.setText("S"+Integer.toString( objGenerator.nextInt(1000)));


        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(preview.this);

                    // set the custom layout
                    final View customLayout = getLayoutInflater().inflate(R.layout.customdialog, null);
                    builder.setView(customLayout);        // add a button}
                    // create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();}});

        }
}
