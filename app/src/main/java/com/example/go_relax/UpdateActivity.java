package com.example.go_relax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.go_relax.databinding.ActivityUpdateBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
    private ActivityUpdateBinding binding;
    private Unggah unggah;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        unggah = getIntent().getParcelableExtra("EXTRA_DATA");
        String Id = unggah.getId();
        binding.etNama.setText(unggah.getNama());
        binding.etAlamat.setText(unggah.getAlamat());
        binding.etNumber.setText(unggah.getNumber());
        binding.etInfo.setText(unggah.getInfo());
        binding.etCheckIn.setText(unggah.getCheckIn());
        binding.etCheckOut.setText(unggah.getCheckOut());
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nama = binding.etNama.getText().toString();
                String Alamat = binding.etAlamat.getText().toString();
                String Number = binding.etNumber.getText().toString();
                String Info = binding.etInfo.getText().toString();
                String CheckIn = binding.etCheckIn.getText().toString();
                String CheckOut = binding.etCheckOut.getText().toString();

                boolean AddUpdate = true;
                if (TextUtils.isEmpty(Nama)) {
                    AddUpdate = false;
                    binding.etNama.setError("Nama Harus Diisi !");
                }
                if (TextUtils.isEmpty(Alamat)) {
                    AddUpdate = false;
                    binding.etAlamat.setError("Alamat Harus Diisi !");
                }
                if (TextUtils.isEmpty(Number)) {
                    AddUpdate = false;
                    binding.etNumber.setError("No Telepon Harus Diisi !");
                }
                if (TextUtils.isEmpty(Info)) {
                    AddUpdate = false;
                    binding.etInfo.setError("No Kamar Harus Diisi !");
                }
                if (TextUtils.isEmpty(CheckIn)) {
                    AddUpdate = false;
                    binding.etCheckIn.setError("Tanggal Harus Diisi!");
                }
                if (TextUtils.isEmpty(CheckOut)) {
                    AddUpdate = false;
                    binding.etCheckOut.setError("Tanggal Harus Diisi !");
                }
                if (AddUpdate) {
                    UpdateAdd("6495633089f9ba5b8fc17239", Nama, Alamat, Number, Info, CheckIn, CheckOut);
                }
            }
        });
    }

    private void UpdateAdd(String id, String Nama, String Alamat, String Number, String Info, String CheckIn, String CheckOut) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.updateUnggah(id, Nama, Alamat, Number, Info, CheckIn, CheckOut);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    ValueNoData valueNoData = response.body();
                    if (valueNoData != null && valueNoData.getSuccess() == 1) {
                        Toast.makeText(UpdateActivity.this, valueNoData.getMessage(), Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(UpdateActivity.this, "Update failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(UpdateActivity.this, "Response code: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(UpdateActivity.this, "Retrofit Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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

