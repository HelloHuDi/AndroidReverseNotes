package com.tencent.luggage.bridge.impl.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d.a;
import com.tencent.mm.plugin.appbrand.d.a.c;
import java.util.LinkedList;
import java.util.List;

public class b implements a {
    private final List<com.tencent.mm.plugin.appbrand.d.a.b> bOX = new LinkedList();

    public b() {
        AppMethodBeat.i(90762);
        a(new c());
        AppMethodBeat.o(90762);
    }

    public final Bitmap bB(String str) {
        AppMethodBeat.i(90763);
        Bitmap a = a(str, null, null);
        AppMethodBeat.o(90763);
        return a;
    }

    public final Bitmap a(String str, Rect rect, c cVar) {
        AppMethodBeat.i(90764);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(90764);
            return null;
        }
        for (com.tencent.mm.plugin.appbrand.d.a.b bVar : this.bOX) {
            if (bVar.match(str)) {
                Bitmap b = bVar.b(str, rect, cVar);
                AppMethodBeat.o(90764);
                return b;
            }
        }
        AppMethodBeat.o(90764);
        return null;
    }

    public final void a(com.tencent.mm.plugin.appbrand.d.a.b bVar) {
        AppMethodBeat.i(90765);
        if (this.bOX.contains(bVar)) {
            this.bOX.remove(bVar);
        }
        this.bOX.add(bVar);
        AppMethodBeat.o(90765);
    }

    public final void a(String str, a.a aVar) {
        AppMethodBeat.i(90766);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(90766);
            return;
        }
        for (com.tencent.mm.plugin.appbrand.d.a.b bVar : this.bOX) {
            if (bVar.match(str)) {
                bVar.a(str, aVar);
            }
        }
        AppMethodBeat.o(90766);
    }
}
