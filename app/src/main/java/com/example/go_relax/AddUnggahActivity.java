package com.example.go_relax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.go_relax.databinding.ActivityAddUnggahBinding;

public class AddUnggahActivity extends AppCompatActivity {

    private ActivityAddUnggahBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddUnggahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nama = binding.etNama.getText().toString();
                String Alamat = binding.etAlamat.getText().toString();
                int Number = Integer.parseInt(binding.etNumber.getText().toString());
                int Info = Integer.parseInt(binding.etInfo.getText().toString());
                int checkin = Integer.parseInt(binding.etCheckOut.getText().toString());
                int checkout = Integer.parseInt(binding.etCheckOut.getText().toString());

                boolean bolehUnggah = true;

                if (TextUtils.isEmpty(Nama)) {
                    bolehUnggah = false;
                    binding.etNama.setError("Nama Harus Diisi !");
                }

                if (TextUtils.isEmpty(Alamat)) {
                    bolehUnggah = false;
                    binding.etAlamat.setError("Alamat Harus Diisi !");
                }

                if (Number == 0) {
                    bolehUnggah = false;
                    binding.etNumber.setError("No Telepon Harus Diisi !");
                }

                if (Info == 0) {
                    bolehUnggah = false;
                    binding.etInfo.setError("No Kamar Harus Diisi !");
                }

                if (checkin == 0) {
                    bolehUnggah = false;
                    binding.etCheckIn.setError("Tanggal Harus Diisi !");
                }

                if (checkout == 0) {
                    bolehUnggah = false;
                    binding.etCheckOut.setError("Tanggal Harus Diisi !");
                }


                if (bolehUnggah) {
                    String userId = utilities.getValue(AddUnggahActivity.this, "xUserId");
                    addUnggah(userId, Nama, Alamat, Number, Info, checkin, checkout);
                }




            }
        });
    }

    private void addUnggah(String userId, String Nama, String Alamat, Integer Number, Integer Info, Integer checkin, Integer checkout) {
        binding.progressBar.setVisibility(View.VISIBLE);
        // proses untuk mengunggah konten ....
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

