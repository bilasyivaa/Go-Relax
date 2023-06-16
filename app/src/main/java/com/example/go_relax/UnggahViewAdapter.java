package com.example.go_relax;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.go_relax.databinding.ItemUnggahBinding;

import java.util.ArrayList;
import java.util.List;

public class UnggahViewAdapter extends RecyclerView.Adapter<UnggahViewAdapter.ViewHolder> {
    private List<Unggah> data = new ArrayList<>();
    private OnItemLongClickListener onItemLongClickListener;

    public void setData (List<Unggah>data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public static void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }


    @NonNull
    @Override
    public UnggahViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemUnggahBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UnggahViewAdapter.ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        Unggah unggah = data.get(pos);
        holder.itemUnggahBinding.tvNama.setText(unggah.getNama());
        holder.itemUnggahBinding.tvAlamat.setText(unggah.getAlamat());
        holder.itemUnggahBinding.tvNumber.setText(String.valueOf(unggah.getNumber()));
        holder.itemUnggahBinding.tvInfo.setText(String.valueOf(unggah.getInfo()));
        holder.itemUnggahBinding.tvCheckIn.setText(String.valueOf(unggah.getCheck_in()));
        holder.itemUnggahBinding.tvCheckOut.setText(String.valueOf(unggah.getCheck_out()));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemUnggahBinding itemUnggahBinding;
        public ViewHolder(@NonNull ItemUnggahBinding itemView) {
            super(itemView.getRoot());
            itemUnggahBinding = itemView;
        }
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View v, Unggah unggah, int position);
    }
}




