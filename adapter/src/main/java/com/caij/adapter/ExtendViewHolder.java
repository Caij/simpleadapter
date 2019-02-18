package com.caij.adapter;

import android.content.Context;
import android.view.View;

/**
 * Created by Ca1j on 2017/5/5.
 */

public abstract class ExtendViewHolder<E> extends BaseViewHolder {

    public ExtendViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(E e, Object ui, Context context);

}
