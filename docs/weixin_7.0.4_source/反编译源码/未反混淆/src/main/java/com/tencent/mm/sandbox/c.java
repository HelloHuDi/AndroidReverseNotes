package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static c xvk = null;
    private static Map<Integer, Boolean> xvl = new HashMap();

    static {
        AppMethodBeat.i(28778);
        AppMethodBeat.o(28778);
    }

    public static void l(int i, Object obj) {
        AppMethodBeat.i(28776);
        ab.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + i + ", class=%s", obj.getClass().getName());
        xvl.put(Integer.valueOf(i), Boolean.TRUE);
        ab.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + xvl.size());
        AppMethodBeat.o(28776);
    }

    public static void m(int i, Object obj) {
        AppMethodBeat.i(28777);
        ab.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + i + ", class=%s", obj.getClass().getName());
        xvl.remove(Integer.valueOf(i));
        ab.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + xvl.size());
        if (xvl.size() == 0) {
            Process.killProcess(Process.myPid());
            ab.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
            ab.dou();
        }
        AppMethodBeat.o(28777);
    }
}
