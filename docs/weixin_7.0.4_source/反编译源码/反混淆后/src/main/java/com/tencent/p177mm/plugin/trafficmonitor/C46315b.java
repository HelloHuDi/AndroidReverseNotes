package com.tencent.p177mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.trafficmonitor.b */
public final class C46315b extends C40012c {
    public final String TAG = "MicroMsg.FileTrafficStatsInspector";
    private Timer oGr = null;
    private TimerTask sJN = null;
    private boolean started;

    /* renamed from: com.tencent.mm.plugin.trafficmonitor.b$1 */
    class C294711 extends TimerTask {
        C294711() {
        }

        public final void run() {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            AppMethodBeat.m2504i(114756);
            C40011a.update(C46315b.this.f16189id);
            long j6 = 0;
            long j7 = 0;
            int i = C46315b.this.type;
            long currentTimeMillis = System.currentTimeMillis();
            C5018as eg = C5018as.m7465eg("trafficmonitor", 1);
            long amI = eg.amI("trafficmonitor_" + C46315b.this.interval);
            long j8 = currentTimeMillis - amI;
            eg.encode("trafficmonitor_" + C46315b.this.interval, currentTimeMillis);
            long FT;
            if (i == 0) {
                j6 = C40011a.m68517FU(C46315b.this.f16189id);
                FT = C40011a.m68516FT(C46315b.this.f16189id);
                j = j6 + FT;
                j2 = j;
                j3 = 0;
                j4 = j;
                j7 = FT;
            } else if (i == 1) {
                j = C40011a.m68515FS(C46315b.this.f16189id) + C40011a.m68514FR(C46315b.this.f16189id);
                j2 = j;
                j3 = j;
                j4 = 0;
            } else if (i == 2) {
                j6 = C40011a.m68517FU(C46315b.this.f16189id);
                FT = C40011a.m68516FT(C46315b.this.f16189id);
                j5 = j6 + FT;
                j = C40011a.m68515FS(C46315b.this.f16189id) + C40011a.m68514FR(C46315b.this.f16189id);
                j2 = j + j5;
                j3 = j;
                j4 = j5;
                j7 = FT;
            } else {
                AppMethodBeat.m2505o(114756);
                return;
            }
            j = C40011a.m68513FQ(C46315b.this.f16189id);
            j5 = C40011a.m68512FP(C46315b.this.f16189id);
            if (j < j6 || j5 < j7) {
                AppMethodBeat.m2505o(114756);
                return;
            }
            ArrayList arrayList = new ArrayList();
            i = TrafficClickFlowReceiver.m34121a(C46315b.this.currentIndex, currentTimeMillis - C46315b.this.interval, arrayList);
            if (i == -1) {
                AppMethodBeat.m2505o(114756);
                return;
            }
            C46315b.this.currentIndex = i;
            if (C40012c.m68518lG(amI)) {
                C4990ab.m7416i("MicroMsg.FileTrafficStatsInspector", "isDownloadAndNormal");
                C46315b.this.cHD();
                AppMethodBeat.m2505o(114756);
                return;
            }
            C4990ab.m7417i("MicroMsg.FileTrafficStatsInspector", "wxTotalTraffic : %d , interval : %d", Long.valueOf(j2), Long.valueOf(C46315b.this.interval));
            if (C46315b.this.sJZ.mo47717a(arrayList, j2, C46315b.this.interval, j8)) {
                Double valueOf = Double.valueOf(C46315b.this.sJZ.sKf);
                String valueOf2 = String.valueOf(valueOf);
                int round = (int) Math.round(valueOf.doubleValue());
                i = 0;
                if (round > 3 && round <= 4) {
                    i = 60;
                } else if (round > 4 && round <= 5) {
                    i = 61;
                } else if (round > 5 && round <= 6) {
                    i = 62;
                } else if (round > 6 && round <= 7) {
                    i = 63;
                } else if (round > 7) {
                    i = 64;
                }
                C4990ab.m7417i("MicroMsg.FileTrafficStatsInspector", "Traffic Execced ExceedIndex : %s", valueOf2);
                C7053e.pXa.mo8378a(877, (long) i, 1, true);
                C7053e.pXa.mo8381e(15856, Long.valueOf(C46315b.this.interval), arrayList.toString(), Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(C46315b.this.sJZ.sKe), valueOf2, Integer.valueOf(round));
            }
            C46315b.this.cHD();
            AppMethodBeat.m2505o(114756);
        }
    }

    public final void cHB() {
        AppMethodBeat.m2504i(114757);
        if (this.started) {
            AppMethodBeat.m2505o(114757);
            return;
        }
        this.currentIndex = 0;
        C40011a.init(this.f16189id);
        C40011a.reset(this.f16189id);
        C40011a.update(this.f16189id);
        this.sJN = new C294711();
        this.oGr = new Timer();
        this.oGr.schedule(this.sJN, 0, this.interval);
        this.started = true;
        AppMethodBeat.m2505o(114757);
    }
}
