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

    public void setData(List<Unggah> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUnggahBinding binding = ItemUnggahBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Unggah unggah = data.get(position);
        holder.bind(unggah);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION && onItemLongClickListener != null) {
                    onItemLongClickListener.onItemLongClick(v, unggah, adapterPosition);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemUnggahBinding binding;

        public ViewHolder(@NonNull ItemUnggahBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Unggah unggah) {
            binding.tvNama.setText(unggah.getNama());
            binding.tvAlamat.setText(unggah.getAlamat());
            binding.tvNumber.setText(unggah.getNumber());
            binding.tvInfo.setText(unggah.getInfo());
            binding.tvCheckIn.setText(unggah.getCheckIn());
            binding.tvCheckOut.setText(unggah.getCheckOut());
        }
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View v, Unggah unggah, int position);
    }
}









