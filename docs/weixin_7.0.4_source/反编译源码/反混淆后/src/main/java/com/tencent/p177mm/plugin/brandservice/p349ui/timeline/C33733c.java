package com.tencent.p177mm.plugin.brandservice.p349ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.c */
public final class C33733c {

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.c$1 */
    class C337341 implements Runnable {
        final /* synthetic */ Runnable eGq;

        C337341(Runnable runnable) {
            this.eGq = runnable;
        }

        public final void run() {
            AppMethodBeat.m2504i(14142);
            Runnable runnable = this.eGq;
            if (C33733c.aWu()) {
                if (runnable != null) {
                    C5004al.m7441d(runnable);
                }
                AppMethodBeat.m2505o(14142);
                return;
            }
            C30309s.m48275pp(false);
            if (runnable != null) {
                C5004al.m7441d(runnable);
            }
            AppMethodBeat.m2505o(14142);
        }
    }

    public static boolean aWu() {
        AppMethodBeat.m2504i(14143);
        if ((((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() & 2) > 0) {
            AppMethodBeat.m2505o(14143);
            return true;
        }
        AppMethodBeat.m2505o(14143);
        return false;
    }
}
