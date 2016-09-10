package id.sch.smktelkom_mlg.tugas01.xirpl1008.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    EditText etAsal;
    RadioGroup rgJK;
    Spinner spJurusan;
    CheckBox cbBas, cbVol, cbFut, cbPas;
    Button bOK;
    TextView tvHasil, tvEks;
    int nEks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAsal = (EditText) findViewById(R.id.editTextAsal);
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        spJurusan = (Spinner) findViewById(R.id.spinnerProvinsi);
        cbBas = (CheckBox) findViewById(R.id.checkBoxBas);
        cbVol = (CheckBox) findViewById(R.id.checkBoxVol);
        cbFut = (CheckBox) findViewById(R.id.checkBoxFut);
        cbPas = (CheckBox) findViewById(R.id.checkBoxPas);
        cbBas.setOnCheckedChangeListener(this);
        cbVol.setOnCheckedChangeListener(this);
        cbFut.setOnCheckedChangeListener(this);
        cbPas.setOnCheckedChangeListener(this);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvEks = (TextView) findViewById(R.id.textViewEks);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String asal = etAsal.getText().toString();
        String hasil = null;
        String jurusan = spJurusan.getSelectedItem().toString();
        String ekstra = "\nEkstrakurikuler         : ";

        int startlen = ekstra.length();
        if (cbBas.isChecked()) ekstra += cbBas.getText() + ",";
        if (cbVol.isChecked()) ekstra += cbVol.getText() + ",";
        if (cbFut.isChecked()) ekstra += cbFut.getText() + ",";
        if (cbPas.isChecked()) ekstra += cbPas.getText();

        if (ekstra.length() == startlen) ekstra += "Tidak ada pada pilihan";

        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
        } else {
            etNama.setError(null);
        }

        if (asal.isEmpty()) {
            etAsal.setError("Asal SMP Belum Diisi");
        } else {
            etAsal.setError(null);
        }
        tvHasil.setText("Nama       : " + nama + "\n" + "\n" + "Asal SMP        : " + asal + "\n" + "\n" +
                "Jenis Kelamin      : " + hasil + "\n" + "\nJurusan      : " + jurusan + "\n" + ekstra);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nEks += 1;
        else nEks -= 1;
        tvEks.setText("Hobi " + nEks + " terpilih)");
    }
}
