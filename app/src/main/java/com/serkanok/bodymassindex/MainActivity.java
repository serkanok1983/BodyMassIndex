package com.serkanok.bodymassindex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double boy;
    double kilo;
    double vucutKitleEndeks;
    EditText vke;
    TextView durum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ana_ekran);
        boy = 0.0;
        kilo = 0.0;
        EditText boyGirdi = findViewById(R.id.BoyGirdi);
        EditText kiloGirdi = findViewById(R.id.KiloGirdi);
        vke = findViewById(R.id.VKEGirdi);
        vke.setEnabled(false);
        durum = findViewById(R.id.Durum);
        boyGirdi.addTextChangedListener(boyDegerIzleyici);
        kiloGirdi.addTextChangedListener(kiloDegerIzleyici);
    }

    private void sonucGoster() {
        vucutKitleEndeks = kilo / (boy * boy);
        vke.setText(String.format("%.2f", vucutKitleEndeks));
        if (vucutKitleEndeks < 20) {
            durum.setText(R.string.zayif);
        } else {
            if (vucutKitleEndeks < 25) {
                durum.setText(R.string.normal);
            } else {
                if (vucutKitleEndeks < 30) {
                    durum.setText(R.string.hafifSisman);
                } else {
                    if (vucutKitleEndeks < 35) {
                        durum.setText(R.string.sisman);
                    } else {
                        if (vucutKitleEndeks < 45) {
                            durum.setText(R.string.onemliDerecedeSisman);
                        } else {
                            if (vucutKitleEndeks < 50) {
                                durum.setText(R.string.asiriSisman);
                            } else {
                                durum.setText(R.string.olumculSisman);
                            }
                        }
                    }
                }
            }
        }
    }

    private TextWatcher boyDegerIzleyici = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                boy = Double.parseDouble(s.toString());
                sonucGoster();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher kiloDegerIzleyici = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                kilo = Double.parseDouble(s.toString());
                sonucGoster();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
