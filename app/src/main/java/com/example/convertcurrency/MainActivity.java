package com.example.convertcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final double USD2VND  = 25000.0;

    private EditText editUSD, editVND;
    private Button buttonClear, buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUSD = findViewById(R.id.editUSD);
        editVND = findViewById(R.id.editVND);

        buttonClear = findViewById(R.id.buttonClear);
        buttonConvert = findViewById(R.id.buttonConvert);

        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editUSD.setText("");
                editVND.setText("");
            }
        });

        buttonConvert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (editUSD.hasFocus()){
                    String textUSD = editUSD.getText().toString();
                    if (textUSD==null||textUSD.isEmpty()) return;
                    double usd = Double.parseDouble(textUSD);
                    double vnd = usd*USD2VND;
                    editVND.setText(String.format("%.0f", vnd));
                }
                else{
                    String textVND = editVND.getText().toString();
                    if (textVND==null||textVND.isEmpty()) return;
                    double vnd = Double.parseDouble(textVND);
                    double usd = vnd/USD2VND;
                    editUSD.setText(String.format("%.2f", usd));
                }
            }
        });
    }
}