package com.tencent.p177mm.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.model.cb */
public final class C1839cb {
    private static long fnM = 0;

    public static long aaD() {
        long j = 0;
        AppMethodBeat.m2504i(58137);
        if (C4996ah.bqo()) {
            C1720g.m3537RQ();
            if (C1720g.m3534RN().mo5161QY()) {
                try {
                    j = C1839cb.aaE();
                    AppMethodBeat.m2505o(58137);
                } catch (Throwable th) {
                    C4990ab.m7412e("MicroMsg.TimeHelper", th.getMessage());
                    AppMethodBeat.m2505o(58137);
                }
                return j;
            }
        }
        AppMethodBeat.m2505o(58137);
        return j;
    }

    /* renamed from: fo */
    public static void m3785fo(long j) {
        AppMethodBeat.m2504i(58138);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        fnM = Math.max(j, fnM);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CLIENT_SERVER_TIME_LONG, Long.valueOf(fnM));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CLIENT_SERVER_ELAPSED_TIME_LONG, Long.valueOf(elapsedRealtime));
        C4990ab.m7411d("MicroMsg.TimeHelper", "[updateSyncServerTime] elapsedTime:%s SLastSyncServerTimeMs:%s", Long.valueOf(elapsedRealtime), Long.valueOf(fnM));
        AppMethodBeat.m2505o(58138);
    }

    public static long aaE() {
        AppMethodBeat.m2504i(58139);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C1720g.m3537RQ();
        long a = C1720g.m3536RP().mo5239Ry().mo16814a(C5127a.USERINFO_CLIENT_SERVER_ELAPSED_TIME_LONG, elapsedRealtime);
        C1720g.m3537RQ();
        long a2 = C1720g.m3536RP().mo5239Ry().mo16814a(C5127a.USERINFO_CLIENT_SERVER_TIME_LONG, 0);
        elapsedRealtime = Math.max(0, elapsedRealtime - a);
        C4990ab.m7410d("MicroMsg.TimeHelper", "[getSyncServerTimeMs] SyncServerTime:" + fnM + " offset:" + elapsedRealtime);
        if (0 < a2) {
            elapsedRealtime += a2;
            AppMethodBeat.m2505o(58139);
            return elapsedRealtime;
        }
        elapsedRealtime = System.currentTimeMillis();
        AppMethodBeat.m2505o(58139);
        return elapsedRealtime;
    }

    public static int aaF() {
        AppMethodBeat.m2504i(58140);
        int aaE = (int) (C1839cb.aaE() / 1000);
        AppMethodBeat.m2505o(58140);
        return aaE;
    }

    /* renamed from: fp */
    public static long m3786fp(long j) {
        AppMethodBeat.m2504i(58141);
        long aaE = (C1839cb.aaE() / 1000) - j;
        AppMethodBeat.m2505o(58141);
        return aaE;
    }
}
