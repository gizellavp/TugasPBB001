package id.sch.smktelkom_mlg.tugas01.xirpl4014.pendaftaranekstra1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Etnama;
    Button bok;
    RadioGroup rg;
    CheckBox x1,x2,x3,x4,x5,x6,x7;
    Spinner sp;
    TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Etnama = (EditText) findViewById(R.id.editTextNama);
        rg = (RadioGroup) findViewById(R.id.RadioGrup);
        bok = (Button) findViewById(R.id.buttonOk);
        x1 = (CheckBox) findViewById(R.id.checkBox);
        x2 = (CheckBox) findViewById(R.id.checkBox2);
        x3 = (CheckBox) findViewById(R.id.checkBox3);
        x4 = (CheckBox) findViewById(R.id.checkBox4);
        x5 = (CheckBox) findViewById(R.id.checkBox5);
        x6 = (CheckBox) findViewById(R.id.checkBox6);
        x7 = (CheckBox) findViewById(R.id.checkBox7);
        sp = (Spinner) findViewById(R.id.spinner);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        if(isValid()){
            String nama = Etnama.getText().toString();
            String hasil = null;
            if(rg.getCheckedRadioButtonId()!=-1)
            {
                RadioButton rb = (RadioButton)
                        findViewById(rg.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            String hsl ="\n Ekstrakurikuler Yang Di Pilih : \n";
            int startlen = hasil.length();
            if(x1.isChecked()) hsl+=x1.getText()+"\n";
            if(x2.isChecked()) hsl+=x2.getText()+"\n";
            if(x3.isChecked()) hsl+=x3.getText()+"\n";
            if(x4.isChecked()) hsl+=x4.getText()+"\n";
            if(x5.isChecked()) hsl+=x5.getText()+"\n";
            if(x6.isChecked()) hsl+=x6.getText()+"\n";
            if(x7.isChecked()) hsl+=x7.getText()+"\n";
            if(hsl.length()==startlen) hsl+="Tidak ada pilihan";
            tvHasil.setText(" Nama Siswa : " + nama + "\n Jenis Kelamin : " + hasil
            + hsl + "\n Kelas : " +sp.getSelectedItem().toString());
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = Etnama.getText().toString();
        if(nama.isEmpty())
        {
            Etnama.setError("Nama Belum Diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            Etnama.setError("Nama minimal 3 karakter");
            valid = false;
        }
        return valid;
    }
}
