package com.caij.adapter;

import java.util.List;

/**
 * Created by Caij on 2015/9/23.
 */
public interface IAdapter<E> {
    void addEntity(E entity);
    void removeEntity(E entiry);
    void removeEntities(List<E> entities);
    void addEntities(List<E> entities);
}
