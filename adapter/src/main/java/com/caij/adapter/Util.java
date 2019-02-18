package com.caij.adapter;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/**
 * Created by Ca1j on 2017/5/5.
 */

public class Util {

    public static Context getContentForObject(Object aOrf) {
        Context context;
        if (aOrf instanceof FragmentActivity) {
            context = (Context) aOrf;
        } else if (aOrf instanceof Activity) {
            context = (Context) aOrf;
        } else if (aOrf instanceof Fragment) {
            context = ((Fragment) aOrf).getActivity();
        } else if (aOrf instanceof android.app.Fragment) {
            context = ((android.app.Fragment) aOrf).getActivity();
        } else if (aOrf instanceof Context) {
            context = (Context) aOrf;
        } else {
            throw new IllegalArgumentException("Object must be fragment or content");
        }
        return context;
    }
}
