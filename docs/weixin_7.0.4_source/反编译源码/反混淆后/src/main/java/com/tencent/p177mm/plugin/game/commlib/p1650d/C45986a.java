package com.tencent.p177mm.plugin.game.commlib.p1650d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vending.p642h.C5707g;

/* renamed from: com.tencent.mm.plugin.game.commlib.d.a */
public final class C45986a {
    private static volatile C5004al ftB;
    private static final Object iRa = new Object();

    static {
        AppMethodBeat.m2504i(59425);
        AppMethodBeat.m2505o(59425);
    }

    public static void aNR() {
        AppMethodBeat.m2504i(59424);
        if (ftB == null) {
            AppMethodBeat.m2505o(59424);
            return;
        }
        synchronized (iRa) {
            try {
                if (ftB != null) {
                    C5707g.asT("GameCommLib#WorkThread");
                    ftB.oAl.quit();
                    ftB = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59424);
            }
        }
    }
}
