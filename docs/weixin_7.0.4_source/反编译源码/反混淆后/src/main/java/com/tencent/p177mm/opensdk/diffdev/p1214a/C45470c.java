package com.tencent.p177mm.opensdk.diffdev.p1214a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.c */
final class C45470c implements Runnable {
    /* renamed from: g */
    final /* synthetic */ C37980b f17879g;

    C45470c(C37980b c37980b) {
        this.f17879g = c37980b;
    }

    public final void run() {
        AppMethodBeat.m2504i(128044);
        ArrayList<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.f17879g.f16125f.f17170c);
        for (OAuthListener onQrcodeScanned : arrayList) {
            onQrcodeScanned.onQrcodeScanned();
        }
        AppMethodBeat.m2505o(128044);
    }
}
