package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.s;

public final class c {

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.c$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Runnable eGq;

        AnonymousClass1(Runnable runnable) {
            this.eGq = runnable;
        }

        public final void run() {
            AppMethodBeat.i(14142);
            Runnable runnable = this.eGq;
            if (c.aWu()) {
                if (runnable != null) {
                    al.d(runnable);
                }
                AppMethodBeat.o(14142);
                return;
            }
            s.pp(false);
            if (runnable != null) {
                al.d(runnable);
            }
            AppMethodBeat.o(14142);
        }
    }

    public static boolean aWu() {
        AppMethodBeat.i(14143);
        if ((((Integer) g.RP().Ry().get(a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() & 2) > 0) {
            AppMethodBeat.o(14143);
            return true;
        }
        AppMethodBeat.o(14143);
        return false;
    }
}
