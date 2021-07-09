package com.caij.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;

/**
 * Created by Ca1j on 2017/5/5.
 */

public abstract class ExtendBaseAdapter<E, VH extends BaseViewHolder> extends BaseAdapter<E, VH> {

    protected OnItemPartViewClickListener mOnItemPartViewClickListener;
    private RecyclerViewOnItemClickListener mOnItemClickListener;
    private RecyclerViewOnItemLongClickListener mRecyclerViewOnItemLongClickListener;
    private OnItemPartViewLongClickListener onItemPartViewLongClickListener;

    protected Object mUI;
    protected Context mContext;
    protected LayoutInflater mInflater;

    public ExtendBaseAdapter(Object ui) {
        this(ui, null);
    }

    public ExtendBaseAdapter(Object ui, List<E> entities) {
        super(entities);
        this.mUI = ui;
        this.mContext = Util.getContentForObject(ui);
        if (mContext != null) {
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
    }

    public void setOnItemPartViewClickListener(OnItemPartViewClickListener onItemPartViewClickListener) {
        mOnItemPartViewClickListener = onItemPartViewClickListener;
    }

    @NonNull
    @Override
    public final VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VH vh = onCreateViewHolderInner(parent, viewType);
        onViewHolderCreated(vh, vh.getConvertView(), viewType);
        return vh;
    }

    @Override
    public final void onBindViewHolder(@NonNull VH holder, int position) {
        holder.mInOnClickListener.mRecyclerViewOnItemLongClickListener = mRecyclerViewOnItemLongClickListener;
        holder.mInOnClickListener.mOnItemClickListener = mOnItemClickListener;
        holder.mInOnClickListener.mOnItemPartViewClickListener = mOnItemPartViewClickListener;
        holder.mInOnClickListener.onItemPartViewLongClickListener = onItemPartViewLongClickListener;
        onBindViewHolderInner(holder, position);
    }

    @Deprecated
    public void onBindViewHolderInner(@NonNull VH holder, E e, int viewType){

    }

    public void onBindViewHolderInner(@NonNull VH holder, int position){
        onBindViewHolderInner(holder, getItem(position), getItemViewType(position));
    }

    protected View getView(ViewGroup viewGroup, int layoutId) {
        return mInflater.inflate(layoutId, viewGroup, false);
    }

    protected abstract VH onCreateViewHolderInner(ViewGroup parent, int viewType);

    public void onViewHolderCreated(final VH baseViewHolder, View itemView, int viewType) {
        if (this.mOnItemClickListener != null) {
            itemView.setOnClickListener(baseViewHolder.mInOnClickListener);
        }

        if (this.mRecyclerViewOnItemLongClickListener != null) {
            itemView.setOnLongClickListener(baseViewHolder.mInOnClickListener);
        }
    }

    public void setOnItemClickListener(RecyclerViewOnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(RecyclerViewOnItemLongClickListener longClickListener) {
        this.mRecyclerViewOnItemLongClickListener = longClickListener;
    }


    public void setOnItemPartViewLongClickListener(OnItemPartViewLongClickListener onItemPartViewLongClickListener) {
        this.onItemPartViewLongClickListener = onItemPartViewLongClickListener;
    }
}
