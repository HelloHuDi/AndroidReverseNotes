package com.tencent.p177mm.view.p645a;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.p177mm.view.p1097f.C16067a;

/* renamed from: com.tencent.mm.view.a.a */
public abstract class C16041a extends BaseAdapter implements C36374g {
    public int Aab;
    public C16067a Aal;
    public int Abd;
    public int Abe;
    public String Abf;
    public int Abg;
    public int emW;
    public Context mContext;
    public int njC;
    public int zZZ;

    public C16041a(Context context, C16067a c16067a) {
        this.mContext = context;
        this.Aal = c16067a;
    }

    /* renamed from: b */
    public final void mo28408b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zZZ = i;
        this.emW = i2;
        this.Abd = i3;
        this.Aab = i4;
        this.Abe = i5;
        this.Abg = i6;
        this.njC = i7;
    }

    /* renamed from: ui */
    public boolean mo28409ui(int i) {
        return true;
    }
}
