package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {


    private CheckBox chkSE, chkAI, chkNET;
    private TextView txtHasil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        chkSE = findViewById(R.id.chk_se);
        chkAI = findViewById(R.id.chk_ai);
        chkNET = findViewById(R.id.chk_net);
        txtHasil = findViewById(R.id.txt_hasil);
    }

    public void selectAllClick(View view) {
        chkSE.setChecked(true);
        chkAI.setChecked(true);
        chkNET.setChecked(true);
    }
    public void clearClick(View view) {
        chkSE.setChecked(false);
        chkAI.setChecked(false);
        chkNET.setChecked(false);
    }

    public void okClick(View view){
        String hasil = "Hasil :\n";

        if(chkSE.isChecked())
            hasil += "-Sofware Engineer \n";
        if(chkAI.isChecked())
            hasil += "-Artificial Intelligence \n";
        if(chkNET.isChecked())
            hasil += "-Computer Network \n";

        txtHasil.setText(hasil);
    }
}
