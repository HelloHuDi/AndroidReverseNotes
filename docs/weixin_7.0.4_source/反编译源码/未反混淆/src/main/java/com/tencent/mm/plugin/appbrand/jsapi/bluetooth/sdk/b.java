package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a;

public final class b {
    private Context context;
    public c hDY;
    public a hDZ;

    public b(Context context) {
        AppMethodBeat.i(94219);
        this.context = context;
        this.hDY = new c(context);
        this.hDZ = new a(context);
        AppMethodBeat.o(94219);
    }
}
