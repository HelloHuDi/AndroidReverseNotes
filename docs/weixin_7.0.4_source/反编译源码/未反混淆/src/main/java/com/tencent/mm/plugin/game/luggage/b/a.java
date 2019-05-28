package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a {
    private static LinkedList<Class<? extends com.tencent.luggage.d.a>> kOz;

    public static synchronized LinkedList<Class<? extends com.tencent.luggage.d.a>> biH() {
        LinkedList linkedList;
        synchronized (a.class) {
            AppMethodBeat.i(135864);
            kOz = new LinkedList();
            ao(d.class);
            ao(f.class);
            ao(g.class);
            ao(h.class);
            ao(i.class);
            ao(l.class);
            ao(m.class);
            ao(n.class);
            ao(q.class);
            ao(o.class);
            ao(p.class);
            ao(j.class);
            ao(c.class);
            ao(b.class);
            ao(k.class);
            ao(e.class);
            linkedList = kOz;
            AppMethodBeat.o(135864);
        }
        return linkedList;
    }

    private static void ao(Class<? extends com.tencent.luggage.d.a> cls) {
        AppMethodBeat.i(135865);
        kOz.add(cls);
        AppMethodBeat.o(135865);
    }
}
