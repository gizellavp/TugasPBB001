package id.sch.smktelkom_mlg.tugas01.xirpl4014.pendaftaranekstra1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Etnama;
    Button bok;
    TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Etnama = (EditText) findViewById(R.id.editTextNama);
        bok = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess()
            }
        });
    }

    private void doProcess() {
        if(isValid()){
            String nama = Etnama.getText().toString();
            tvHasil.setText(" Nama Siswa : " + nama);
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
