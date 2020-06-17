package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class displayflights extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayflights);
        CardView card_view1= (CardView) findViewById(R.id.cardView5); // creating a CardView and assigning a value.
        CardView card_view2= (CardView) findViewById(R.id.cardView6);
        CardView card_view3= (CardView) findViewById(R.id.cardView7);
        CardView card_view4= (CardView) findViewById(R.id.cardView8);
        final TextView txt1=(TextView)findViewById(R.id.td1);
        final TextView txt2=(TextView)findViewById(R.id.td4);
        final TextView txt3=(TextView)findViewById(R.id.td2);
        final TextView txt4=(TextView)findViewById(R.id.td5);
        final TextView txt5=(TextView)findViewById(R.id.td3);
        final TextView txt6=(TextView)findViewById(R.id.td6);
        final TextView txt7=(TextView)findViewById(R.id.td30);
        final TextView txt8=(TextView)findViewById(R.id.td60);

        final TextView text1 = (TextView)findViewById(R.id.txt70);
        Intent intent1 = getIntent();
        String str1 = intent1.getStringExtra("dept");
        text1.setText(str1);
        final TextView text2 = (TextView)findViewById(R.id.txt71);
        Intent inten = getIntent();
        String str2 = inten.getStringExtra("arr");
        text2.setText(str2);
        final TextView text3 = (TextView)findViewById(R.id.txt72);
        Intent intent3 = getIntent();
        String str3 = intent3.getStringExtra("dept");
        text3.setText(str3);
        final TextView text4 = (TextView)findViewById(R.id.txt73);
        Intent inten4 = getIntent();
        String str4 = inten4.getStringExtra("arr");
        text4.setText(str4);
        final TextView text5 = (TextView)findViewById(R.id.txt74);
        Intent intent5 = getIntent();
        String str5 = intent5.getStringExtra("dept");
        text5.setText(str5);
        final TextView text6 = (TextView)findViewById(R.id.txt75);
        Intent inten6 = getIntent();
        String str6 = inten6.getStringExtra("arr");
        text6.setText(str6);
        final TextView text7 = (TextView)findViewById(R.id.txt76);
        Intent intent7 = getIntent();
        String str7 = intent7.getStringExtra("dept");
        text7.setText(str7);
        final TextView text8 = (TextView)findViewById(R.id.txt77);
        Intent inten8 = getIntent();
        String str8 = inten8.getStringExtra("arr");
        text8.setText(str8);
        final TextView text9 = (TextView)findViewById(R.id.txt78);
        Intent inten9 = getIntent();
        String str9 = inten9.getStringExtra("datet");
        text9.setText(str9);

        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  dest = text1.getText().toString();
                String  arr = text2.getText().toString();
                String str = txt1.getText().toString();
                String str1 = txt2.getText().toString();
                String  dateof = text9.getText().toString();
                Intent intent = new Intent(getApplicationContext(), preview.class);
                intent.putExtra("message", str);
                intent.putExtra("message1", str1);
                intent.putExtra("dept", dest);
                intent.putExtra("arr", arr);
                intent.putExtra("datet", dateof);
                startActivity(intent);
            }
        });
        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  dest = text3.getText().toString();
                String  arr = text4.getText().toString();
                String str = txt3.getText().toString();
                String str1 = txt4.getText().toString();
                String  dateof = text9.getText().toString();
                Intent intent = new Intent(getApplicationContext(), preview.class);
                intent.putExtra("message", str);
                intent.putExtra("message1", str1);
                intent.putExtra("dept", dest);
                intent.putExtra("arr", arr);
                intent.putExtra("datet", dateof);
                startActivity(intent);
            }
        });
        card_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  dest = text5.getText().toString();
                String  arr = text6.getText().toString();
                String str = txt5.getText().toString();
                String str1 = txt6.getText().toString();
                String  dateof = text9.getText().toString();
                Intent intent = new Intent(getApplicationContext(), preview.class);
                intent.putExtra("message", str);
                intent.putExtra("message1", str1);
                intent.putExtra("dept", dest);
                intent.putExtra("arr", arr);
                intent.putExtra("datet", dateof);
                startActivity(intent);
            }
        });
        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  dest = text7.getText().toString();
                String  arr = text8.getText().toString();
                String str = txt7.getText().toString();
                String str1 = txt8.getText().toString();
                String  dateof = text9.getText().toString();
                Intent intent = new Intent(getApplicationContext(), preview.class);
                intent.putExtra("message", str);
                intent.putExtra("message1", str1);
                intent.putExtra("dept", dest);
                intent.putExtra("arr", arr);
                intent.putExtra("datet", dateof);
                startActivity(intent);
            }
        });
    }
}
