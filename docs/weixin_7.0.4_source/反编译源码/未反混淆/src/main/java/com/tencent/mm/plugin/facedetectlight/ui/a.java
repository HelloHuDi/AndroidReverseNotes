package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class a {
    protected ViewGroup BE;
    public String TAG = "FaceReflectBaseUI";
    protected com.tencent.mm.plugin.facedetectlight.ui.container.a mds;

    public abstract int btU();

    public abstract void initView();

    public a(ViewGroup viewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a aVar) {
        this.BE = viewGroup;
        this.mds = aVar;
        this.TAG = getClass().getSimpleName();
        LayoutInflater.from(this.BE.getContext()).inflate(btU(), this.BE, true);
        initView();
    }

    public final View findViewById(int i) {
        return this.BE.findViewById(i);
    }

    public final void setVisibility(int i) {
        this.BE.setVisibility(i);
    }
}
