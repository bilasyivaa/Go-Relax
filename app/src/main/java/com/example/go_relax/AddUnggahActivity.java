package com.example.go_relax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
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

    private void addUnggah(String user_Id, String Nama, String Alamat, int Number, int Info, int checkin, int checkout) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.addGoRelax(user_Id, Nama, Alamat, Number, Info, checkin, checkout);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.code() == 200) {
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        Toast.makeText(AddUnggahActivity.this, message, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddUnggahActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddUnggahActivity.this, "Response " + response.code(), Toast.LENGTH_SHORT);
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

