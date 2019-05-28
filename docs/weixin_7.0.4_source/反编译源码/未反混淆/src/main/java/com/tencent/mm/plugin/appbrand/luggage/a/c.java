package com.tencent.mm.plugin.appbrand.luggage.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.d.b;

public final class c implements e {
    public final Bitmap a(d dVar, String str) {
        AppMethodBeat.i(132092);
        Bitmap a = a(dVar, str, null);
        AppMethodBeat.o(132092);
        return a;
    }

    public final Bitmap a(d dVar, String str, a aVar) {
        AppMethodBeat.i(132093);
        Bitmap a = a(dVar, str, null, aVar);
        AppMethodBeat.o(132093);
        return a;
    }

    public final Bitmap a(final d dVar, final String str, Rect rect, final a aVar) {
        AppMethodBeat.i(132094);
        com.tencent.mm.plugin.appbrand.jsapi.c cVar = dVar.hcM;
        Bitmap a = ((com.tencent.mm.plugin.appbrand.d.a) cVar.B(com.tencent.mm.plugin.appbrand.d.a.class)).a(((b) cVar.B(b.class)).b(cVar, str), rect, new com.tencent.mm.plugin.appbrand.d.a.c() {
            public final void E(Bitmap bitmap) {
                AppMethodBeat.i(132091);
                if (aVar == null || bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.o(132091);
                    return;
                }
                aVar.a(dVar);
                AppMethodBeat.o(132091);
            }
        });
        AppMethodBeat.o(132094);
        return a;
    }
}
