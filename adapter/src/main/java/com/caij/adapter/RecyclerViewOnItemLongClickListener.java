package com.caij.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Caij on 2015/11/5.
 */
public interface RecyclerViewOnItemLongClickListener {

    boolean onItemLongClick(RecyclerView.ViewHolder baseViewHolder, View view, int position);

}
