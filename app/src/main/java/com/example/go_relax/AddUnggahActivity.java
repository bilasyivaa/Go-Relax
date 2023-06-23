package com.example.go_relax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.go_relax.databinding.ActivityAddUnggahBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                String nama = binding.etNama.getText().toString();
                String alamat = binding.etAlamat.getText().toString();
                String number = binding.etNumber.getText().toString();
                String info = binding.etInfo.getText().toString();
                String checkin = binding.etCheckIn.getText().toString();
                String checkout = binding.etCheckOut.getText().toString();

                boolean bolehUnggah = true;

                if (TextUtils.isEmpty(nama)) {
                    bolehUnggah = false;
                    binding.etNama.setError("Nama Harus Diisi !");
                }

                if (TextUtils.isEmpty(alamat)) {
                    bolehUnggah = false;
                    binding.etAlamat.setError("Alamat Harus Diisi !");
                }

                if (TextUtils.isEmpty(number)) {
                    bolehUnggah = false;
                    binding.etNumber.setError("No Telepon Harus Diisi !");
                }

                if (TextUtils.isEmpty(info)) {
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

                if (bolehUnggah) {
                    String userId = utilities.getValue(AddUnggahActivity.this, "xUserId");
                    addUnggah(userId,nama, alamat, number, info, checkin, checkout);
                }
            }
        });
    }

    private void addUnggah(String User_id, String nama, String alamat, String number, String info, String checkin, String checkout) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.addGoRelax(User_id,nama, alamat, number, info, checkin, checkout);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    ValueNoData value = response.body();
                    if (value != null) {
                        int success = value.getSuccess();
                        String message = value.getMessage();

                        if (success == 1) {
                            Toast.makeText(AddUnggahActivity.this, message, Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(AddUnggahActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(AddUnggahActivity.this, "Response " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(AddUnggahActivity.this, "Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
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


