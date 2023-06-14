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
                String Number = binding.etNumber.getText().to();
                String Info = binding.etInfo.getText().to();
                String checkin = binding.etCheckIn.getText().to();
                String checkout = binding.etCheckOut.getText().to();
                String createddate = binding.etCreatedDate.getText().to();

                boolean bolehUnggah = true;

                if (TextUtils.isEmpty(Nama)) {
                    bolehUnggah = false;
                    binding.etNama.setError("Nama Harus Diisi !");
                }

                if (TextUtils.isEmpty(Alamat)) {
                    bolehUnggah = false;
                    binding.etAlamat.setError("Alamat Harus Diisi !");
                }

                if (TextUtils.isEmpty(Number)) {
                    bolehUnggah = false;
                    binding.etNumber.setError("No Telepon Harus Diisi !");
                }

                if (TextUtils.isEmpty(Info)) {
                    bolehUnggah = false;
                    binding.etInfo.setError("No Kamar Harus Diisi !");
                }

                if (TextUtils.isEmpty(checkin)) {
                    bolehUnggah = false;
                    binding.etCheckIn.setError("Tanggal Harus Diisi !");
                }

                if (TextUtils.isEmpty(checkout)) {
                    bolehUnggah = false;
                    binding.etCheckOut.setError("Tanggal Harus Diisi !");
                }

                if (TextUtils.isEmpty(createddate)) {
                    bolehUnggah = false;
                    binding.etCreatedDate.setError("Tanggal Harus Diisi !");
                }

                if (bolehUnggah) {
                    String userId = utilities.getValue(AddUnggahActivity.this, "xUserId");
                    addUnggah(userId, Nama);
                }

                if (bolehUnggah) {
                    String userId = utilities.getValue(AddUnggahActivity.this, "xUserId");
                    addUnggah(userId, Alamat);
                }
                if (bolehUnggah) {
                    String userId = utilities.getValue(AddUnggahActivity.this, "xUserId");
                    addUnggah(userId, Number);
                }

                if (bolehUnggah) {
                    String userId = utilities.getValue(AddUnggahActivity.this, "xUserId");
                    addUnggah(userId, Info);
                }

                if (bolehUnggah) {
                    String userId = utilities.getValue(AddUnggahActivity.this, "xUserId");
                    addUnggah(userId, checkin);
                }

                if (bolehUnggah) {
                    String userId = utilities.getValue(AddUnggahActivity.this, "xUserId");
                    addUnggah(userId, checkout);
                }

                if (bolehUnggah) {
                    String userId = utilities.getValue(AddUnggahActivity.this, "xUserId");
                    addUnggah(userId, createddate);
                }
            }
        });
    }

    private void addUnggah(String userId, String Nama) {
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

