package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.components.b;
import com.google.firebase.components.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class a implements d {
    static final d buN = new a();

    static {
        AppMethodBeat.i(67877);
        AppMethodBeat.o(67877);
    }

    private a() {
    }

    public final Object a(b bVar) {
        AppMethodBeat.i(67876);
        com.google.firebase.analytics.connector.a an = com.google.firebase.analytics.connector.b.an((Context) bVar.x(Context.class));
        AppMethodBeat.o(67876);
        return an;
    }
}
