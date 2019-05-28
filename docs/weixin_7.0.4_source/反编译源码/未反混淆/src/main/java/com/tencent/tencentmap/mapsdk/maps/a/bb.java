package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.c;
import com.tencent.tencentmap.mapsdk.a.e;

public final class bb extends az {
    public bb(Context context) {
        super(context, 0, 100);
    }

    public final void b(boolean z) {
    }

    public final aa a() {
        AppMethodBeat.i(98542);
        try {
            aa a = e.a(c(), c.m(), "".getBytes(), -1, -1);
            if (a != null) {
                AppMethodBeat.o(98542);
                return a;
            }
            AppMethodBeat.o(98542);
            return null;
        } catch (Throwable th) {
            ag.a(th);
            ag.d("encode2RequestPackage failed", new Object[0]);
            AppMethodBeat.o(98542);
            return null;
        }
    }
}
