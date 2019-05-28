package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final /* synthetic */ class c {
    @KeepForSdk
    public static Object a(b bVar, Class cls) {
        AppMethodBeat.i(10609);
        a z = bVar.z(cls);
        if (z == null) {
            AppMethodBeat.o(10609);
            return null;
        }
        Object obj = z.get();
        AppMethodBeat.o(10609);
        return obj;
    }
}
