package com.tencent.mm.plugin.downloader_app.detail.a;

import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.ah;
import com.tencent.mm.plugin.webview.luggage.jsapi.o;
import com.tencent.mm.plugin.webview.luggage.jsapi.w;
import java.util.LinkedList;

public final class d {
    private static LinkedList<Class<? extends a>> kOz;

    public static synchronized LinkedList<Class<? extends a>> biH() {
        LinkedList linkedList;
        synchronized (d.class) {
            AppMethodBeat.i(136072);
            kOz = new LinkedList();
            ao(a.class);
            ao(e.class);
            ao(g.class);
            ao(ah.class);
            ao(w.class);
            ao(o.class);
            ao(c.class);
            ao(b.class);
            ao(f.class);
            linkedList = kOz;
            AppMethodBeat.o(136072);
        }
        return linkedList;
    }

    private static void ao(Class<? extends a> cls) {
        AppMethodBeat.i(136073);
        kOz.add(cls);
        AppMethodBeat.o(136073);
    }
}
