package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class g {
    private static Class[] yOI = new Class[]{t.class, q.class, c.class, ae.class, ap.class, f.class, ao.class, ac.class, am.class, o.class, e.class, aj.class, aa.class, as.class, j.class, u.class, s.class, k.class, ar.class, ag.class, z.class, an.class, b.class, ah.class, y.class, m.class, ad.class, ai.class, n.class, aq.class, af.class, ab.class, p.class, d.class, r.class, al.class};
    private static List<a> yOJ;

    public static class a {
        public Class<? extends v> aIl;
        public Class<? extends v> yOK;

        public a(Class<? extends v> cls, Class<? extends v> cls2) {
            this.aIl = cls;
            this.yOK = cls2;
        }

        public final v dDK() {
            AppMethodBeat.i(31287);
            try {
                v vVar = (v) this.yOK.newInstance();
                AppMethodBeat.o(31287);
                return vVar;
            } catch (InstantiationException e) {
                ab.printErrStackTrace("ChattingComponentFactory", e, "", new Object[0]);
                AppMethodBeat.o(31287);
                return null;
            } catch (IllegalAccessException e2) {
                ab.printErrStackTrace("ChattingComponentFactory", e2, "", new Object[0]);
                AppMethodBeat.o(31287);
                return null;
            }
        }
    }

    public static List<a> getComponents() {
        AppMethodBeat.i(31288);
        if (yOJ == null) {
            yOJ = new LinkedList();
            for (Class cls : yOI) {
                if (cls.isAnnotationPresent(com.tencent.mm.ui.chatting.c.a.a.class)) {
                    com.tencent.mm.ui.chatting.c.a.a aVar = (com.tencent.mm.ui.chatting.c.a.a) cls.getAnnotation(com.tencent.mm.ui.chatting.c.a.a.class);
                    if (aVar.dFp() == com.tencent.mm.ui.chatting.c.a.a.a.class) {
                        yOJ.add(new a(cls, cls));
                    } else {
                        yOJ.add(new a(aVar.dFp(), cls));
                    }
                } else {
                    yOJ.add(new a(cls, cls));
                }
            }
        }
        List list = yOJ;
        AppMethodBeat.o(31288);
        return list;
    }
}
