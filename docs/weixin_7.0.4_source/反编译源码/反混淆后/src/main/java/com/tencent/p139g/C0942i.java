package com.tencent.p139g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p139g.p1166b.C25637b;
import com.tencent.p139g.p1166b.C25638d;
import com.tencent.p139g.p809a.C41673b;
import com.tencent.p659pb.common.p1102c.C44443c;

/* renamed from: com.tencent.g.i */
public final class C0942i {
    private static C0942i AHM;
    /* renamed from: Gn */
    private Context f1038Gn;
    private boolean mStarted;

    private static C0942i dSH() {
        AppMethodBeat.m2504i(127762);
        if (AHM == null) {
            synchronized (C0942i.class) {
                try {
                    if (AHM == null) {
                        AHM = new C0942i();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(127762);
                    }
                }
            }
        }
        C0942i c0942i = AHM;
        AppMethodBeat.m2505o(127762);
        return c0942i;
    }

    /* renamed from: dM */
    public static void m2117dM(Context context) {
        AppMethodBeat.m2504i(127763);
        C0942i dSH = C0942i.dSH();
        if (!dSH.mStarted) {
            dSH.f1038Gn = context;
            try {
                C25637b a = C0938f.m2110a(new C25638d("EventCenter", C41673b.class.getName()));
                if (a != null) {
                    a.start();
                }
                AppMethodBeat.m2505o(127763);
                return;
            } catch (Throwable th) {
                C44443c.m80392w("service", th);
            }
        }
        AppMethodBeat.m2505o(127763);
    }
}
