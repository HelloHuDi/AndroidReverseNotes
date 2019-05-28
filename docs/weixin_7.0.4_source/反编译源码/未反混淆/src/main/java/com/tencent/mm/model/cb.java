package com.tencent.mm.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;

public final class cb {
    private static long fnM = 0;

    public static long aaD() {
        long j = 0;
        AppMethodBeat.i(58137);
        if (ah.bqo()) {
            g.RQ();
            if (g.RN().QY()) {
                try {
                    j = aaE();
                    AppMethodBeat.o(58137);
                } catch (Throwable th) {
                    ab.e("MicroMsg.TimeHelper", th.getMessage());
                    AppMethodBeat.o(58137);
                }
                return j;
            }
        }
        AppMethodBeat.o(58137);
        return j;
    }

    public static void fo(long j) {
        AppMethodBeat.i(58138);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        fnM = Math.max(j, fnM);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_CLIENT_SERVER_TIME_LONG, Long.valueOf(fnM));
        g.RQ();
        g.RP().Ry().set(a.USERINFO_CLIENT_SERVER_ELAPSED_TIME_LONG, Long.valueOf(elapsedRealtime));
        ab.d("MicroMsg.TimeHelper", "[updateSyncServerTime] elapsedTime:%s SLastSyncServerTimeMs:%s", Long.valueOf(elapsedRealtime), Long.valueOf(fnM));
        AppMethodBeat.o(58138);
    }

    public static long aaE() {
        AppMethodBeat.i(58139);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        g.RQ();
        long a = g.RP().Ry().a(a.USERINFO_CLIENT_SERVER_ELAPSED_TIME_LONG, elapsedRealtime);
        g.RQ();
        long a2 = g.RP().Ry().a(a.USERINFO_CLIENT_SERVER_TIME_LONG, 0);
        elapsedRealtime = Math.max(0, elapsedRealtime - a);
        ab.d("MicroMsg.TimeHelper", "[getSyncServerTimeMs] SyncServerTime:" + fnM + " offset:" + elapsedRealtime);
        if (0 < a2) {
            elapsedRealtime += a2;
            AppMethodBeat.o(58139);
            return elapsedRealtime;
        }
        elapsedRealtime = System.currentTimeMillis();
        AppMethodBeat.o(58139);
        return elapsedRealtime;
    }

    public static int aaF() {
        AppMethodBeat.i(58140);
        int aaE = (int) (aaE() / 1000);
        AppMethodBeat.o(58140);
        return aaE;
    }

    public static long fp(long j) {
        AppMethodBeat.i(58141);
        long aaE = (aaE() / 1000) - j;
        AppMethodBeat.o(58141);
        return aaE;
    }
}
