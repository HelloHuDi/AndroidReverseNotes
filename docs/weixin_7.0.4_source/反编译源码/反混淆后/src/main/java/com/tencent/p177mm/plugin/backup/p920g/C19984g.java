package com.tencent.p177mm.plugin.backup.p920g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.vfs.C5730e;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.plugin.backup.g.g */
public final class C19984g {
    static long endTime;
    static long jxH;
    static long jxI;
    static long startTime;
    private SimpleDateFormat juL = new SimpleDateFormat("yyyyMMdd");
    C7564ap jxJ;

    public C19984g() {
        AppMethodBeat.m2504i(17667);
        AppMethodBeat.m2505o(17667);
    }

    static void init() {
        startTime = 0;
        endTime = 0;
        jxH = 0;
        jxI = 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo35232a(int i, long j, long j2, boolean z) {
        AppMethodBeat.m2504i(17668);
        if (j2 == 0) {
            C4990ab.m7412e("MicroMsg.BackupLogManager", "reportKv logSize is 0, skip report");
            AppMethodBeat.m2505o(17668);
            return;
        }
        long j3 = j2 / (j / 1000);
        C4990ab.m7417i("MicroMsg.BackupLogManager", "reportKv, backupMode[%d], time[%d ms], logSize[%d KB], aveLogSize[%d B/s]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        switch (i) {
            case 11:
                if (z) {
                    C7060h.pYm.mo8378a(400, 83, j2 / 1024, false);
                    AppMethodBeat.m2505o(17668);
                    return;
                }
                C7060h.pYm.mo8378a(400, 81, j2 / 1024, false);
                if (j != 0) {
                    C7060h.pYm.mo8378a(400, 82, j3, false);
                }
                m30899rA(i);
                AppMethodBeat.m2505o(17668);
                return;
            case 12:
                if (z) {
                    C7060h.pYm.mo8378a(400, 88, j2 / 1024, false);
                    AppMethodBeat.m2505o(17668);
                    return;
                }
                C7060h.pYm.mo8378a(400, 86, j2 / 1024, false);
                if (j != 0) {
                    C7060h.pYm.mo8378a(400, 87, j3, false);
                }
                m30899rA(i);
                AppMethodBeat.m2505o(17668);
                return;
            case 21:
                if (z) {
                    C7060h.pYm.mo8378a(485, 93, j2 / 1024, false);
                    AppMethodBeat.m2505o(17668);
                    return;
                }
                C7060h.pYm.mo8378a(485, 91, j2 / 1024, false);
                if (j != 0) {
                    C7060h.pYm.mo8378a(485, 92, j3, false);
                }
                m30899rA(i);
                AppMethodBeat.m2505o(17668);
                return;
            case 22:
                if (z) {
                    C7060h.pYm.mo8378a(485, 98, j2 / 1024, false);
                    break;
                }
                C7060h.pYm.mo8378a(485, 96, j2 / 1024, false);
                if (j != 0) {
                    C7060h.pYm.mo8378a(485, 97, j3, false);
                }
                m30899rA(i);
                AppMethodBeat.m2505o(17668);
                return;
        }
        AppMethodBeat.m2505o(17668);
    }

    /* renamed from: rA */
    private void m30899rA(final int i) {
        AppMethodBeat.m2504i(17669);
        final Long valueOf = Long.valueOf(C5046bo.anU());
        final Long valueOf2 = Long.valueOf(mo35233gy(C5046bo.anU()));
        if (valueOf.longValue() == 0 || valueOf2.longValue() == 0) {
            C4990ab.m7413e("MicroMsg.BackupLogManager", "startLogAfterTimeHandler is zero, startAfterLogTime[%d], startAfterLogSize[%d], skip", valueOf, valueOf2);
            AppMethodBeat.m2505o(17669);
            return;
        }
        this.jxJ = new C7564ap(Looper.getMainLooper(), new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(17666);
                Long valueOf = Long.valueOf(C5046bo.anU());
                Long valueOf2 = Long.valueOf(C19984g.this.mo35231B(valueOf.longValue(), valueOf.longValue()));
                C4990ab.m7417i("MicroMsg.BackupLogManager", "backupAfterLogTimeHandler, backupMode[%d], endAfterLogTime[%d], startAfterLogTime[%d], endAfterLogSize[%d], startAfterLogSize[%d]", Integer.valueOf(i), valueOf, valueOf, valueOf2, valueOf2);
                if (valueOf2.longValue() != 0 && valueOf2.longValue() > valueOf2.longValue()) {
                    C19984g.this.mo35232a(i, valueOf.longValue() - valueOf.longValue(), valueOf2.longValue() - valueOf2.longValue(), true);
                }
                AppMethodBeat.m2505o(17666);
                return false;
            }
        }, false);
        this.jxJ.mo16770ae(300000, 300000);
        AppMethodBeat.m2505o(17669);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: B */
    public final long mo35231B(long j, long j2) {
        AppMethodBeat.m2504i(17670);
        long j3 = 0;
        while (j <= j2 + 86400000) {
            j3 += mo35233gy(j);
            j += 86400000;
        }
        AppMethodBeat.m2505o(17670);
        return j3;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: gy */
    public final long mo35233gy(long j) {
        AppMethodBeat.m2504i(17671);
        String format = this.juL.format(new Date(j));
        String str = C5128ac.xIE + "/MM_" + format + ".xlog";
        long asZ;
        if (C5730e.m8628ct(str)) {
            asZ = C5730e.asZ(str);
            AppMethodBeat.m2505o(17671);
            return asZ;
        }
        format = C6457e.euX + "/MM_" + format + ".xlog";
        if (C5730e.m8628ct(format)) {
            asZ = C5730e.asZ(format);
            AppMethodBeat.m2505o(17671);
            return asZ;
        }
        AppMethodBeat.m2505o(17671);
        return 0;
    }
}
