package com.tencent.p177mm.p198aw;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.aw.b */
public final class C45176b {
    public static boolean aij() {
        AppMethodBeat.m2504i(137254);
        if (!C37494a.aig() || C37494a.aie()) {
            AppMethodBeat.m2505o(137254);
            return false;
        }
        C37494a.m63278KY();
        AppMethodBeat.m2505o(137254);
        return true;
    }

    public static boolean aik() {
        AppMethodBeat.m2504i(137255);
        if (C37494a.aie()) {
            C37494a.m63277KX();
            AppMethodBeat.m2505o(137255);
            return true;
        }
        AppMethodBeat.m2505o(137255);
        return false;
    }

    public static boolean ail() {
        AppMethodBeat.m2504i(137256);
        if (C37494a.aig()) {
            C37494a.aic();
            AppMethodBeat.m2505o(137256);
            return true;
        }
        AppMethodBeat.m2505o(137256);
        return false;
    }

    /* renamed from: sT */
    public static boolean m83211sT(String str) {
        AppMethodBeat.m2504i(137257);
        C9058e aih = C37494a.aih();
        if (aih == null || !aih.fKa.equals(str)) {
            AppMethodBeat.m2505o(137257);
            return false;
        }
        AppMethodBeat.m2505o(137257);
        return true;
    }
}
