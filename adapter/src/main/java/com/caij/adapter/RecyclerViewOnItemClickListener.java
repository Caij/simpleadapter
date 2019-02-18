package com.caij.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Caij on 2015/11/5.
 */
public interface RecyclerViewOnItemClickListener {

    void onItemClick(RecyclerView.ViewHolder baseViewHolder, View view, int position);

}
