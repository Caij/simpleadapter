package com.caij.adapter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Caij on 2015/9/22.
 */
public abstract class BaseAdapter<E, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> implements IAdapter<E>, ItemTouchCallback.ItemTouchAdapter {

    private static final String TAG = "BaseAdapter";

    private List<E> mEntities;

    public BaseAdapter() {
        this(null);
    }

    public BaseAdapter(List<E> entities) {
        mEntities = entities;
    }

    public E getItem(int i) {
        if (mEntities != null && inArray(i)) {
            return mEntities.get(i);
        }
        return null;
    }

    public void setEntities(List<E> entities) {
        mEntities = entities;
    }

    public void addEntities(List<E> entities) {
        if (mEntities == null) {
            mEntities = entities;
        } else {
            mEntities.addAll(entities);
        }
    }

    public List<E> getEntities() {
        return mEntities;
    }

    public void addEntity(E entity) {
        if (mEntities == null) {
            mEntities = new ArrayList<>();
        }
        mEntities.add(entity);
    }

    public void removeEntity(E entity) {
        if (mEntities != null) {
            mEntities.remove(entity);
        }
    }

    public E removeEntity(int index) {
        if (mEntities != null) {
            return mEntities.remove(index);
        }
        return null;
    }

    public void removeEntities(List<E> entities) {
        if (mEntities != null) {
            mEntities.removeAll(entities);
        }
    }

    public void clearEntities() {
        if (mEntities != null) {
            mEntities.clear();
        }
    }

    @Override
    public int getItemCount() {
        return mEntities == null ? 0 : mEntities.size();
    }

    public void addEntity(int index, E entity) {
        mEntities.add(index, entity);
    }

    public void addEntities(int index, List<E> entities) {
        if (mEntities == null) {
            mEntities = entities;
        } else {
            mEntities.addAll(index, entities);
        }
    }

    private boolean inArray(int position) {
        if (position >= 0 && position < mEntities.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mEntities, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mEntities, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onSwiped(int position) {
        mEntities.remove(position);
        notifyItemRemoved(position);
    }
}
