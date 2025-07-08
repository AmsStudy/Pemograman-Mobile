package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {

    EditText angka1, angka2, hasil;
    RadioButton tambah, kurang, kali, bagi;
    RadioGroup operasiGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        angka1 = findViewById(R.id.nilai1);
        angka2 = findViewById(R.id.nilai2);
        hasil  = findViewById(R.id.hasil);

        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.Kurang);
        kali   = findViewById(R.id.Kali);
        bagi   = findViewById(R.id.Bagi);
        operasiGroup = findViewById(R.id.operasiGroup);

        TextWatcher watcher = new TextWatcher() {
            public void afterTextChanged(Editable s) { hitung(); }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        };

        angka1.addTextChangedListener(watcher);
        angka2.addTextChangedListener(watcher);

        operasiGroup.setOnCheckedChangeListener((group, checkedId) -> hitung());
    }

    private void hitung() {
        try {
            double num1 = Double.parseDouble(angka1.getText().toString());
            double num2 = Double.parseDouble(angka2.getText().toString());
            double hasilHitung = 0;

            if (tambah.isChecked()) hasilHitung = num1 + num2;
            else if (kurang.isChecked()) hasilHitung = num1 - num2;
            else if (kali.isChecked()) hasilHitung = num1 * num2;
            else if (bagi.isChecked()) {
                if (num2 == 0) {
                    hasil.setText("Error: Tidak bisa dibagi 0");
                    return;
                } else {
                    hasilHitung = num1 / num2;
                }
            }

            hasil.setText(String.valueOf(hasilHitung));
        } catch (NumberFormatException e) {
            hasil.setText("");
        }
    }
}
