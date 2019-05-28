package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.eb */
final class C5867eb implements Runnable {
    /* renamed from: a */
    private /* synthetic */ String f1575a;
    /* renamed from: b */
    private /* synthetic */ byte[] f1576b;
    /* renamed from: c */
    private /* synthetic */ C5866ea f1577c;

    C5867eb(C5866ea c5866ea, String str, byte[] bArr) {
        this.f1577c = c5866ea;
        this.f1575a = str;
        this.f1576b = bArr;
    }

    public final void run() {
        AppMethodBeat.m2504i(98761);
        String str = this.f1575a;
        byte[] bArr = this.f1576b;
        if (C24373eu.m37738a(str) || C24373eu.m37739a(bArr)) {
            C31029ce.m49850e();
            str = C31029ce.m49847b();
            bArr = this.f1577c.f1574a.mo40566a(str);
        }
        C5868ec.m9044c().mo12422d().mo50366a(str, bArr, null);
        AppMethodBeat.m2505o(98761);
    }
}
