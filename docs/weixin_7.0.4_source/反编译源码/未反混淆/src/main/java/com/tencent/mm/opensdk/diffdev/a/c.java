package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;

final class c implements Runnable {
    final /* synthetic */ b g;

    c(b bVar) {
        this.g = bVar;
    }

    public final void run() {
        AppMethodBeat.i(128044);
        ArrayList<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.g.f.c);
        for (OAuthListener onQrcodeScanned : arrayList) {
            onQrcodeScanned.onQrcodeScanned();
        }
        AppMethodBeat.o(128044);
    }
}
