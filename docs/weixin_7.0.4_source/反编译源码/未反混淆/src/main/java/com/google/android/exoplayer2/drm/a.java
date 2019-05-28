package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;

@TargetApi(16)
public interface a<T extends c> {

    public static class a extends Exception {
    }

    int getState();

    a qT();

    T qU();
}
