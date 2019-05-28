package com.tencent.mm.view.a;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class a extends BaseAdapter implements g {
    public int Aab;
    public com.tencent.mm.view.f.a Aal;
    public int Abd;
    public int Abe;
    public String Abf;
    public int Abg;
    public int emW;
    public Context mContext;
    public int njC;
    public int zZZ;

    public a(Context context, com.tencent.mm.view.f.a aVar) {
        this.mContext = context;
        this.Aal = aVar;
    }

    public final void b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zZZ = i;
        this.emW = i2;
        this.Abd = i3;
        this.Aab = i4;
        this.Abe = i5;
        this.Abg = i6;
        this.njC = i7;
    }

    public boolean ui(int i) {
        return true;
    }
}
