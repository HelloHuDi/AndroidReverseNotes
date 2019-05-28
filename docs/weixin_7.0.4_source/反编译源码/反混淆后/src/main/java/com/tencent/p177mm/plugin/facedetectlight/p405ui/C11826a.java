package com.tencent.p177mm.plugin.facedetectlight.p405ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.container.C20670a;

/* renamed from: com.tencent.mm.plugin.facedetectlight.ui.a */
public abstract class C11826a {
    /* renamed from: BE */
    protected ViewGroup f2906BE;
    public String TAG = "FaceReflectBaseUI";
    protected C20670a mds;

    public abstract int btU();

    public abstract void initView();

    public C11826a(ViewGroup viewGroup, C20670a c20670a) {
        this.f2906BE = viewGroup;
        this.mds = c20670a;
        this.TAG = getClass().getSimpleName();
        LayoutInflater.from(this.f2906BE.getContext()).inflate(btU(), this.f2906BE, true);
        initView();
    }

    public final View findViewById(int i) {
        return this.f2906BE.findViewById(i);
    }

    public final void setVisibility(int i) {
        this.f2906BE.setVisibility(i);
    }
}
