package com.example.go_relax;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.go_relax.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UnggahViewAdapter unggahViewAdapter;
    private List<Unggah> data;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (!utilities.checkValue(MainActivity.this, "xUserId")) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        unggahViewAdapter = new UnggahViewAdapter();
        binding.rvUnggah.setLayoutManager(new LinearLayoutManager(this));
        binding.rvUnggah.setAdapter(unggahViewAdapter);
        UnggahViewAdapter.setOnItemLongClickListener(new UnggahViewAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View v, Unggah unggah, int position) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.inflate(R.menu.menu_popup);
                popupMenu.setGravity(Gravity.RIGHT);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int idMenu = item.getItemId();
                        if (idMenu == R.id.action_edit) {
                            Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                            intent.putExtra("EXTRA_DATA", unggah);
                            startActivity(intent);
                            return true;
                        } else if (idMenu == R.id.action_delete) {
                            String id = unggah.getId();
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Konfirmasi");
                            builder.setMessage("Apakah yakin ingin menghapus Unggah" + data.get(position).getId() + " '?");
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    deleteUnggah(id);
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });

        binding.fabInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddUnggahActivity.class);
                startActivity(intent);
            }
        });

    }

    private void deleteUnggah(String id) {

        };


    @Override
    protected void onResume() {
        super.onResume();
            getAllUnggah();
    }

    private void getAllUnggah() {

    }


}



