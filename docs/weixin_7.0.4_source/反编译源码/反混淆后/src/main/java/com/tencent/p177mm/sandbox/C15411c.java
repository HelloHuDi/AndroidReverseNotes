package com.tencent.p177mm.sandbox;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.sandbox.c */
public final class C15411c {
    private static C15411c xvk = null;
    private static Map<Integer, Boolean> xvl = new HashMap();

    static {
        AppMethodBeat.m2504i(28778);
        AppMethodBeat.m2505o(28778);
    }

    /* renamed from: l */
    public static void m23691l(int i, Object obj) {
        AppMethodBeat.m2504i(28776);
        C4990ab.m7417i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + i + ", class=%s", obj.getClass().getName());
        xvl.put(Integer.valueOf(i), Boolean.TRUE);
        C4990ab.m7416i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + xvl.size());
        AppMethodBeat.m2505o(28776);
    }

    /* renamed from: m */
    public static void m23692m(int i, Object obj) {
        AppMethodBeat.m2504i(28777);
        C4990ab.m7417i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + i + ", class=%s", obj.getClass().getName());
        xvl.remove(Integer.valueOf(i));
        C4990ab.m7416i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + xvl.size());
        if (xvl.size() == 0) {
            Process.killProcess(Process.myPid());
            C4990ab.m7420w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
            C4990ab.dou();
        }
        AppMethodBeat.m2505o(28777);
    }
}
