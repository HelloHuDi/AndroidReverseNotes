package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.z.c.g;
import com.tencent.view.d;

public class a {
    private static volatile g hob;
    private static volatile g hoc;

    public static g nN(int i) {
        AppMethodBeat.i(10908);
        g azX;
        if (i == 1) {
            azX = azX();
            AppMethodBeat.o(10908);
            return azX;
        }
        azX = azW();
        AppMethodBeat.o(10908);
        return azX;
    }

    private static g azW() {
        g gVar;
        AppMethodBeat.i(10909);
        if (hob == null) {
            synchronized (a.class) {
                try {
                    if (hob == null) {
                        gVar = new g();
                        gVar.a(new b(302));
                        gVar.a(new c(303));
                        gVar.a(new d(308));
                        gVar.a(new f());
                        gVar.a(new g());
                        hob = gVar;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10909);
                    }
                }
            }
        }
        gVar = hob;
        AppMethodBeat.o(10909);
        return gVar;
    }

    private static g azX() {
        g gVar;
        AppMethodBeat.i(10910);
        if (hoc == null) {
            synchronized (a.class) {
                try {
                    if (hoc == null) {
                        gVar = new g();
                        gVar.a(new b(d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM));
                        gVar.a(new c(d.MIC_PTU_ZIPAI_GRADIENT_FASHION));
                        gVar.a(new d(d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI));
                        gVar.a(new f());
                        gVar.a(new g());
                        gVar.a(new e((byte) 0));
                        hoc = gVar;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10910);
                    }
                }
            }
        }
        gVar = hoc;
        AppMethodBeat.o(10910);
        return gVar;
    }
}
