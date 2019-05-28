package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

public abstract class a {
    protected p tipDialog;
    protected boolean xuX = true;
    protected com.tencent.mm.roomsdk.a.b.a xuY;
    protected com.tencent.mm.roomsdk.a.b.a xuZ;
    protected com.tencent.mm.roomsdk.a.b.a xva;

    public abstract void a(Context context, String str, boolean z, OnCancelListener onCancelListener);

    public abstract void cancel();

    public abstract void dmX();

    public final boolean dmW() {
        return this.xuX;
    }

    public static b pa(boolean z) {
        return new b(z);
    }

    public static c pb(boolean z) {
        return new c(z);
    }

    public final a b(com.tencent.mm.roomsdk.a.b.a aVar) {
        this.xuY = aVar;
        return this;
    }

    public final a c(com.tencent.mm.roomsdk.a.b.a aVar) {
        this.xuZ = aVar;
        return this;
    }

    public final a d(com.tencent.mm.roomsdk.a.b.a aVar) {
        this.xva = aVar;
        return this;
    }
}
