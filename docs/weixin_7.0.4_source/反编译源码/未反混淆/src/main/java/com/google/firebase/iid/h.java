package com.google.firebase.iid;

import com.google.firebase.components.b;
import com.google.firebase.components.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class h implements d {
    static final d bvI = new h();

    static {
        AppMethodBeat.i(108727);
        AppMethodBeat.o(108727);
    }

    private h() {
    }

    public final Object a(b bVar) {
        AppMethodBeat.i(108726);
        a aVar = new a((FirebaseInstanceId) bVar.x(FirebaseInstanceId.class));
        AppMethodBeat.o(108726);
        return aVar;
    }
}
