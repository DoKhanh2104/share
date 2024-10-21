package com.example.shared_preferences;



import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edta,edtb,edtkq;
    Button btntong,btnclear;
    TextView txt_lichsu;
    String lichsu="";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ánh xạ
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtkq = findViewById(R.id.edtkq);
        txt_lichsu = findViewById(R.id.txt_lichsu) ;
        btntong = findViewById(R.id.btntong);
        btnclear = findViewById(R.id.btnclear);

        //doc lai du lieu
        SharedPreferences mypref = getSharedPreferences("mysave",MODE_PRIVATE);
        lichsu = mypref.getString("ls","");
        txt_lichsu.setText(lichsu);
        //xu li click
        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int kq= a+b;
                edtkq.setText(kq+"");
                lichsu += a + " + " + b + " = " +kq;
                txt_lichsu.setText(lichsu);
                lichsu += "\n";
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lichsu="";
                txt_lichsu.setText(lichsu);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mypref = getSharedPreferences("mysave",MODE_PRIVATE);
        SharedPreferences.Editor myedit = mypref.edit();
        myedit.putString("ls",lichsu);
        myedit.commit();
    }
}