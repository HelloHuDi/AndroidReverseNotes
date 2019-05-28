package com.google.firebase.iid;

import com.google.firebase.a;
import com.google.firebase.components.b;
import com.google.firebase.components.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class g implements d {
    static final d bvI = new g();

    static {
        AppMethodBeat.i(108725);
        AppMethodBeat.o(108725);
    }

    private g() {
    }

    public final Object a(b bVar) {
        AppMethodBeat.i(108724);
        FirebaseInstanceId firebaseInstanceId = new FirebaseInstanceId((a) bVar.x(a.class));
        AppMethodBeat.o(108724);
        return firebaseInstanceId;
    }
}
