package com.tencent.p177mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.plugin.voip.model.l */
public final class C29500l {
    private static C29500l sPJ = new C29500l();
    private ReentrantLock cbR = new ReentrantLock();
    private C14047k sPK;

    static {
        AppMethodBeat.m2504i(4435);
        AppMethodBeat.m2505o(4435);
    }

    private C29500l() {
        AppMethodBeat.m2504i(4433);
        AppMethodBeat.m2505o(4433);
    }

    public static C14047k cIW() {
        AppMethodBeat.m2504i(4434);
        if (sPJ.sPK == null) {
            sPJ.cbR.lock();
            try {
                if (sPJ.sPK == null) {
                    sPJ.sPK = new C14047k();
                }
                sPJ.cbR.unlock();
            } catch (Throwable th) {
                sPJ.cbR.unlock();
                AppMethodBeat.m2505o(4434);
            }
        }
        C14047k c14047k = sPJ.sPK;
        AppMethodBeat.m2505o(4434);
        return c14047k;
    }
}
