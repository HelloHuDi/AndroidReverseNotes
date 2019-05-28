package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.m;
import java.util.HashSet;
import java.util.Set;

public final class z {
    private static final Set<b> gTB = new HashSet();

    public interface a {
        void a(m mVar);

        void avp();

        void avq();

        void avr();

        void avs();

        void avt();

        void avu();

        void avv();

        void dA(boolean z);

        void dz(boolean z);

        void nq(int i);
    }

    public interface b {
        a a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar);
    }

    static {
        AppMethodBeat.i(59444);
        AppMethodBeat.o(59444);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(59442);
        synchronized (gTB) {
            try {
                gTB.add(bVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(59442);
            }
        }
    }

    static a a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(59443);
        synchronized (gTB) {
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.o(59443);
            }
        }
        for (Object obj : gTB.toArray()) {
            a a = ((b) obj).a(aVar);
            if (a != null) {
                return a;
            }
        }
        AppMethodBeat.o(59443);
        return null;
    }
}
