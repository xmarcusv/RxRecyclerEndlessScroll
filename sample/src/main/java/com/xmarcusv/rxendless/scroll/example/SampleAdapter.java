package com.xmarcusv.rxendless.scroll.example;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleViewHolder> {

    private List<String> items;

    SampleAdapter(List<String> items) {
        this.items = items;
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new SampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {
        holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class SampleViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        SampleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.sample_text);
        }
    }
}
