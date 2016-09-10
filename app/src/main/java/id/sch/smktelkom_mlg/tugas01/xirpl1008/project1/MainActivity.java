package id.sch.smktelkom_mlg.tugas01.xirpl1008.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etAsal;
    RadioGroup rgJK;
    Spinner spJurusan;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNama = (EditText) findViewById(R.id.editTextNama);
        etAsal = (EditText) findViewById(R.id.editTextAsal);
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        spJurusan = (Spinner) findViewById(R.id.spinnerProvinsi);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bOK.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String asal = etAsal.getText().toString();
        String jurusan = spJurusan.getSelectedItem().toString();
        String hasil = null;

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
        } else {
            etNama.setError(null);
        }
        if (asal.isEmpty()) {
            etAsal.setError("Asal SMP belum diisi");
        } else {
            etAsal.setError(null);
        }
        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        tvHasil.setText("Nama : " + nama + "\n" + "Asal SMP : " + asal + "\n" +
                "Jenis Kelamin : " + hasil + "\nJurusan : " + jurusan);
    }
}
