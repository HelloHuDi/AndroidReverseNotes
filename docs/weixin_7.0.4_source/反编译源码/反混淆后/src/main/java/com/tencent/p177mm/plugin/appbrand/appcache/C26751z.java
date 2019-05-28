package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.z */
public final class C26751z {
    private static final Set<C26750b> gTB = new HashSet();

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.z$a */
    public interface C19074a {
        /* renamed from: a */
        void mo34289a(C40432m c40432m);

        void avp();

        void avq();

        void avr();

        void avs();

        void avt();

        void avu();

        void avv();

        /* renamed from: dA */
        void mo34297dA(boolean z);

        /* renamed from: dz */
        void mo34298dz(boolean z);

        /* renamed from: nq */
        void mo34299nq(int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.z$b */
    public interface C26750b {
        /* renamed from: a */
        C19074a mo44527a(C10065a c10065a);
    }

    static {
        AppMethodBeat.m2504i(59444);
        AppMethodBeat.m2505o(59444);
    }

    /* renamed from: a */
    public static void m42581a(C26750b c26750b) {
        AppMethodBeat.m2504i(59442);
        synchronized (gTB) {
            try {
                gTB.add(c26750b);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59442);
            }
        }
    }

    /* renamed from: a */
    static C19074a m42580a(C10065a c10065a) {
        AppMethodBeat.m2504i(59443);
        synchronized (gTB) {
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59443);
            }
        }
        for (Object obj : gTB.toArray()) {
            C19074a a = ((C26750b) obj).mo44527a(c10065a);
            if (a != null) {
                return a;
            }
        }
        AppMethodBeat.m2505o(59443);
        return null;
    }
}
