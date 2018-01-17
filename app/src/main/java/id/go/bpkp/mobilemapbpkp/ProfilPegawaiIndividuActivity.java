package id.go.bpkp.mobilemapbpkp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProfilPegawaiIndividuActivity extends AppCompatActivity {

    String empId, empName, empNipbaru, empNiplama, empPangkat, empJabatan, empUnit, empFoto;
    TextView nameView, nipbaruView, unitView;
    ImageView profic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_pegawai_individu);
        Intent i = getIntent();
        empFoto = i.getStringExtra(konfigurasi.EMP_FOTO);
        empName = i.getStringExtra(konfigurasi.EMP_NAMA);
        empNipbaru = i.getStringExtra(konfigurasi.EMP_NIPBARU);
        empUnit = i.getStringExtra(konfigurasi.EMP_UNIT);

        profic = (ImageView) findViewById(R.id.individu_profic);
        nameView = (TextView) findViewById(R.id.individu_nama);
        nipbaruView = (TextView) findViewById(R.id.individu_nipbaru);
        unitView = (TextView) findViewById(R.id.individu_unit);

        Picasso.with(ProfilPegawaiIndividuActivity.this).load(empFoto).into(profic);

        nameView.setText(empName);
        nipbaruView.setText(empNipbaru);
        unitView.setText(empUnit);
    }
}
