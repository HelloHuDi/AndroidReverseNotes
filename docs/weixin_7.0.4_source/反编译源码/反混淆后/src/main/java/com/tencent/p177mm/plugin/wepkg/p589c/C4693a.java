package com.tencent.p177mm.plugin.wepkg.p589c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.wepkg.c.a */
public final class C4693a {
    private Map<String, C4694b> uXQ;

    /* renamed from: com.tencent.mm.plugin.wepkg.c.a$b */
    public class C4694b {
        long fVz;
        int uXS;
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.c.a$a */
    public static class C4695a {
        private static C4693a uXR = new C4693a();

        static {
            AppMethodBeat.m2504i(63606);
            AppMethodBeat.m2505o(63606);
        }
    }

    /* synthetic */ C4693a(byte b) {
        this();
    }

    private C4693a() {
        AppMethodBeat.m2504i(63607);
        this.uXQ = new ConcurrentHashMap();
        AppMethodBeat.m2505o(63607);
    }

    /* renamed from: l */
    public final void mo9814l(Set<String> set) {
        AppMethodBeat.m2504i(63608);
        if (set.isEmpty()) {
            C7060h.pYm.mo8378a(859, 20, 1, false);
            AppMethodBeat.m2505o(63608);
            return;
        }
        C7060h.pYm.mo8378a(859, 21, 1, false);
        C4694b c4694b = new C4694b();
        c4694b.uXS = set.size();
        c4694b.fVz = 0;
        for (String put : set) {
            this.uXQ.put(put, c4694b);
        }
        AppMethodBeat.m2505o(63608);
    }

    /* renamed from: n */
    public final void mo9815n(String str, String str2, long j) {
        AppMethodBeat.m2504i(63609);
        C4694b c4694b = (C4694b) this.uXQ.remove(C4995ag.m7428ck(str + str2));
        if (c4694b != null) {
            c4694b.uXS--;
            c4694b.fVz += j;
            if (c4694b.uXS == 0) {
                C4990ab.m7417i("MicroMsg.Wepkg.BatchUpdateReporter", "batch update size: %s", Long.valueOf(c4694b.fVz));
                C37860c.eBG.mo60581g(1, "", String.valueOf(c4694b.fVz));
            }
        }
        AppMethodBeat.m2505o(63609);
    }
}
