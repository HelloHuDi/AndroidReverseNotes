package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class be {
    private static LinkedList<Class<? extends a>> kOz;

    public static synchronized LinkedList<Class<? extends a>> biH() {
        LinkedList linkedList;
        synchronized (be.class) {
            AppMethodBeat.i(6390);
            kOz = new LinkedList();
            ao(ag.class);
            ao(ap.class);
            ao(ax.class);
            ao(ai.class);
            ao(ab.class);
            ao(a.class);
            ao(ah.class);
            ao(ao.class);
            ao(o.class);
            ao(al.class);
            ao(t.class);
            ao(af.class);
            ao(q.class);
            ao(p.class);
            ao(k.class);
            ao(b.class);
            ao(c.class);
            ao(e.class);
            ao(f.class);
            ao(g.class);
            ao(h.class);
            ao(i.class);
            ao(j.class);
            ao(m.class);
            ao(n.class);
            ao(r.class);
            ao(u.class);
            ao(v.class);
            ao(w.class);
            ao(z.class);
            ao(aa.class);
            ao(ad.class);
            ao(aj.class);
            ao(am.class);
            ao(aq.class);
            ao(ar.class);
            ao(at.class);
            ao(au.class);
            ao(av.class);
            ao(aw.class);
            ao(ay.class);
            ao(az.class);
            ao(bb.class);
            ao(ba.class);
            ao(s.class);
            ao(d.class);
            ao(l.class);
            ao(ac.class);
            ao(ae.class);
            ao(x.class);
            ao(ak.class);
            ao(as.class);
            ao(y.class);
            ao(an.class);
            linkedList = kOz;
            AppMethodBeat.o(6390);
        }
        return linkedList;
    }

    private static void ao(Class<? extends a> cls) {
        AppMethodBeat.i(6391);
        kOz.add(cls);
        AppMethodBeat.o(6391);
    }
}
