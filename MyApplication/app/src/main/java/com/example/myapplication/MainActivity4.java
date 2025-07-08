package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    private RadioGroup rgProdi;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rgProdi = findViewById(R.id.rg_prodi);
        txtHasil = findViewById(R.id.txt_hasil);

        rgProdi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                tampil();
            }
        });
    }

    private void tampil() {
        String hasil = "Hasil : \n";
        int rbID = rgProdi.getCheckedRadioButtonId();

        if (rbID == R.id.rb_ti) {
            hasil += "Teknik Informatika";
        } else if (rbID == R.id.rb_si) {
            hasil += "Sistem Informasi";
        } else {
            hasil += "Belum dipilih";
        }

        txtHasil.setText(hasil);
    }

    public void onClick(View view) {
        tampil();
    }

    public void okClick(View view) {
        tampil();
    }
}
