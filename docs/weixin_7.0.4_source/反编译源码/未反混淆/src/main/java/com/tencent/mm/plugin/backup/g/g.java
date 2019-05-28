package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class g {
    static long endTime;
    static long jxH;
    static long jxI;
    static long startTime;
    private SimpleDateFormat juL = new SimpleDateFormat("yyyyMMdd");
    ap jxJ;

    public g() {
        AppMethodBeat.i(17667);
        AppMethodBeat.o(17667);
    }

    static void init() {
        startTime = 0;
        endTime = 0;
        jxH = 0;
        jxI = 0;
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, long j, long j2, boolean z) {
        AppMethodBeat.i(17668);
        if (j2 == 0) {
            ab.e("MicroMsg.BackupLogManager", "reportKv logSize is 0, skip report");
            AppMethodBeat.o(17668);
            return;
        }
        long j3 = j2 / (j / 1000);
        ab.i("MicroMsg.BackupLogManager", "reportKv, backupMode[%d], time[%d ms], logSize[%d KB], aveLogSize[%d B/s]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        switch (i) {
            case 11:
                if (z) {
                    h.pYm.a(400, 83, j2 / 1024, false);
                    AppMethodBeat.o(17668);
                    return;
                }
                h.pYm.a(400, 81, j2 / 1024, false);
                if (j != 0) {
                    h.pYm.a(400, 82, j3, false);
                }
                rA(i);
                AppMethodBeat.o(17668);
                return;
            case 12:
                if (z) {
                    h.pYm.a(400, 88, j2 / 1024, false);
                    AppMethodBeat.o(17668);
                    return;
                }
                h.pYm.a(400, 86, j2 / 1024, false);
                if (j != 0) {
                    h.pYm.a(400, 87, j3, false);
                }
                rA(i);
                AppMethodBeat.o(17668);
                return;
            case 21:
                if (z) {
                    h.pYm.a(485, 93, j2 / 1024, false);
                    AppMethodBeat.o(17668);
                    return;
                }
                h.pYm.a(485, 91, j2 / 1024, false);
                if (j != 0) {
                    h.pYm.a(485, 92, j3, false);
                }
                rA(i);
                AppMethodBeat.o(17668);
                return;
            case 22:
                if (z) {
                    h.pYm.a(485, 98, j2 / 1024, false);
                    break;
                }
                h.pYm.a(485, 96, j2 / 1024, false);
                if (j != 0) {
                    h.pYm.a(485, 97, j3, false);
                }
                rA(i);
                AppMethodBeat.o(17668);
                return;
        }
        AppMethodBeat.o(17668);
    }

    private void rA(final int i) {
        AppMethodBeat.i(17669);
        final Long valueOf = Long.valueOf(bo.anU());
        final Long valueOf2 = Long.valueOf(gy(bo.anU()));
        if (valueOf.longValue() == 0 || valueOf2.longValue() == 0) {
            ab.e("MicroMsg.BackupLogManager", "startLogAfterTimeHandler is zero, startAfterLogTime[%d], startAfterLogSize[%d], skip", valueOf, valueOf2);
            AppMethodBeat.o(17669);
            return;
        }
        this.jxJ = new ap(Looper.getMainLooper(), new a() {
            public final boolean BI() {
                AppMethodBeat.i(17666);
                Long valueOf = Long.valueOf(bo.anU());
                Long valueOf2 = Long.valueOf(g.this.B(valueOf.longValue(), valueOf.longValue()));
                ab.i("MicroMsg.BackupLogManager", "backupAfterLogTimeHandler, backupMode[%d], endAfterLogTime[%d], startAfterLogTime[%d], endAfterLogSize[%d], startAfterLogSize[%d]", Integer.valueOf(i), valueOf, valueOf, valueOf2, valueOf2);
                if (valueOf2.longValue() != 0 && valueOf2.longValue() > valueOf2.longValue()) {
                    g.this.a(i, valueOf.longValue() - valueOf.longValue(), valueOf2.longValue() - valueOf2.longValue(), true);
                }
                AppMethodBeat.o(17666);
                return false;
            }
        }, false);
        this.jxJ.ae(300000, 300000);
        AppMethodBeat.o(17669);
    }

    /* Access modifiers changed, original: final */
    public final long B(long j, long j2) {
        AppMethodBeat.i(17670);
        long j3 = 0;
        while (j <= j2 + 86400000) {
            j3 += gy(j);
            j += 86400000;
        }
        AppMethodBeat.o(17670);
        return j3;
    }

    /* Access modifiers changed, original: final */
    public final long gy(long j) {
        AppMethodBeat.i(17671);
        String format = this.juL.format(new Date(j));
        String str = ac.xIE + "/MM_" + format + ".xlog";
        long asZ;
        if (e.ct(str)) {
            asZ = e.asZ(str);
            AppMethodBeat.o(17671);
            return asZ;
        }
        format = com.tencent.mm.compatible.util.e.euX + "/MM_" + format + ".xlog";
        if (e.ct(format)) {
            asZ = e.asZ(format);
            AppMethodBeat.o(17671);
            return asZ;
        }
        AppMethodBeat.o(17671);
        return 0;
    }
}
