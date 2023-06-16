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
        binding.etCheckIn.setText(unggah.getCheck_in());
        binding.etCheckOut.setText(unggah.getCheck_out());
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nama = binding.etNama.getText().toString();
                String Alamat = binding.etAlamat.getText().toString();
                int Number = Integer.parseInt(binding.etNumber.getText().toString());
                int Info = Integer.parseInt(binding.etInfo.getText().toString());
                int CheckIn = Integer.parseInt(binding.etCheckIn.getText().toString());
                int CheckOut = Integer.parseInt(binding.etCheckOut.getText().toString());

                boolean AddUpdate = true;
                if (TextUtils.isEmpty(Nama)) {
                    AddUpdate = false;
                    binding.etNama.setError("Nama Harus Diisi !");
                }
                if (TextUtils.isEmpty(Alamat)) {
                    AddUpdate = false;
                    binding.etAlamat.setError("Alamat Harus Diisi !");
                }
                if (Number == 0 ) {
                    AddUpdate = false;
                    binding.etNumber.setError("No Telepon Harus Diisi !");
                }
                if (Info == 0) {
                    AddUpdate = false;
                    binding.etInfo.setError("No Kamar Harus Diisi !");
                }
                if (CheckIn == 0) {
                    AddUpdate = false;
                    binding.etCheckIn.setError("Tanggal Harus Diisi!");
                }
                if (CheckOut == 0) {
                    AddUpdate = false;
                    binding.etCheckOut.setError("Tanggal Harus Diisi !");
                }
                if (AddUpdate) {
                    UpdateAdd(Id, Nama, Alamat, Number, Info, CheckIn, CheckOut);
                }

            }


        });
    }
    private void UpdateAdd(String UserId, String Nama, String Alamat, int Number, int Info, int CheckIn, int CheckOut) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.updateUnggah(UserId, Nama, Alamat, Number, Info, CheckIn, CheckOut);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.code() == 200) {
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        Toast.makeText(UpdateActivity.this, message, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(UpdateActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(UpdateActivity.this, "Response" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(UpdateActivity.this, " Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

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
