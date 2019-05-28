package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public final class b extends c {
    public final String TAG = "MicroMsg.FileTrafficStatsInspector";
    private Timer oGr = null;
    private TimerTask sJN = null;
    private boolean started;

    public final void cHB() {
        AppMethodBeat.i(114757);
        if (this.started) {
            AppMethodBeat.o(114757);
            return;
        }
        this.currentIndex = 0;
        a.init(this.id);
        a.reset(this.id);
        a.update(this.id);
        this.sJN = new TimerTask() {
            public final void run() {
                long j;
                long j2;
                long j3;
                long j4;
                long j5;
                AppMethodBeat.i(114756);
                a.update(b.this.id);
                long j6 = 0;
                long j7 = 0;
                int i = b.this.type;
                long currentTimeMillis = System.currentTimeMillis();
                as eg = as.eg("trafficmonitor", 1);
                long amI = eg.amI("trafficmonitor_" + b.this.interval);
                long j8 = currentTimeMillis - amI;
                eg.encode("trafficmonitor_" + b.this.interval, currentTimeMillis);
                long FT;
                if (i == 0) {
                    j6 = a.FU(b.this.id);
                    FT = a.FT(b.this.id);
                    j = j6 + FT;
                    j2 = j;
                    j3 = 0;
                    j4 = j;
                    j7 = FT;
                } else if (i == 1) {
                    j = a.FS(b.this.id) + a.FR(b.this.id);
                    j2 = j;
                    j3 = j;
                    j4 = 0;
                } else if (i == 2) {
                    j6 = a.FU(b.this.id);
                    FT = a.FT(b.this.id);
                    j5 = j6 + FT;
                    j = a.FS(b.this.id) + a.FR(b.this.id);
                    j2 = j + j5;
                    j3 = j;
                    j4 = j5;
                    j7 = FT;
                } else {
                    AppMethodBeat.o(114756);
                    return;
                }
                j = a.FQ(b.this.id);
                j5 = a.FP(b.this.id);
                if (j < j6 || j5 < j7) {
                    AppMethodBeat.o(114756);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                i = TrafficClickFlowReceiver.a(b.this.currentIndex, currentTimeMillis - b.this.interval, arrayList);
                if (i == -1) {
                    AppMethodBeat.o(114756);
                    return;
                }
                b.this.currentIndex = i;
                if (c.lG(amI)) {
                    ab.i("MicroMsg.FileTrafficStatsInspector", "isDownloadAndNormal");
                    b.this.cHD();
                    AppMethodBeat.o(114756);
                    return;
                }
                ab.i("MicroMsg.FileTrafficStatsInspector", "wxTotalTraffic : %d , interval : %d", Long.valueOf(j2), Long.valueOf(b.this.interval));
                if (b.this.sJZ.a(arrayList, j2, b.this.interval, j8)) {
                    Double valueOf = Double.valueOf(b.this.sJZ.sKf);
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
                    ab.i("MicroMsg.FileTrafficStatsInspector", "Traffic Execced ExceedIndex : %s", valueOf2);
                    e.pXa.a(877, (long) i, 1, true);
                    e.pXa.e(15856, Long.valueOf(b.this.interval), arrayList.toString(), Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(b.this.sJZ.sKe), valueOf2, Integer.valueOf(round));
                }
                b.this.cHD();
                AppMethodBeat.o(114756);
            }
        };
        this.oGr = new Timer();
        this.oGr.schedule(this.sJN, 0, this.interval);
        this.started = true;
        AppMethodBeat.o(114757);
    }
}
