package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class eb implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ byte[] b;
    private /* synthetic */ ea c;

    eb(ea eaVar, String str, byte[] bArr) {
        this.c = eaVar;
        this.a = str;
        this.b = bArr;
    }

    public final void run() {
        AppMethodBeat.i(98761);
        String str = this.a;
        byte[] bArr = this.b;
        if (eu.a(str) || eu.a(bArr)) {
            ce.e();
            str = ce.b();
            bArr = this.c.a.a(str);
        }
        ec.c().d().a(str, bArr, null);
        AppMethodBeat.o(98761);
    }
}
