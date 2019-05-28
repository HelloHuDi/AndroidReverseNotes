package com.tencent.p177mm.roomsdk.p1086a.p1342c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;

/* renamed from: com.tencent.mm.roomsdk.a.c.a */
public abstract class C46610a {
    protected C44275p tipDialog;
    protected boolean xuX = true;
    protected C46609a xuY;
    protected C46609a xuZ;
    protected C46609a xva;

    /* renamed from: a */
    public abstract void mo48450a(Context context, String str, boolean z, OnCancelListener onCancelListener);

    public abstract void cancel();

    public abstract void dmX();

    public final boolean dmW() {
        return this.xuX;
    }

    /* renamed from: pa */
    public static C40603b m88143pa(boolean z) {
        return new C40603b(z);
    }

    /* renamed from: pb */
    public static C30263c m88144pb(boolean z) {
        return new C30263c(z);
    }

    /* renamed from: b */
    public final C46610a mo74753b(C46609a c46609a) {
        this.xuY = c46609a;
        return this;
    }

    /* renamed from: c */
    public final C46610a mo74754c(C46609a c46609a) {
        this.xuZ = c46609a;
        return this;
    }

    /* renamed from: d */
    public final C46610a mo74755d(C46609a c46609a) {
        this.xva = c46609a;
        return this;
    }
}
