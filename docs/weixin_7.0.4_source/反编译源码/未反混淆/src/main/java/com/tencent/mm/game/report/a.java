package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.game.report.api.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class a extends b {
    private HashMap<Long, com.tencent.mm.game.report.api.a> eBw = new HashMap();

    public a() {
        AppMethodBeat.i(59566);
        AppMethodBeat.o(59566);
    }

    public final void a(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(59567);
        long currentTimeMillis = System.currentTimeMillis();
        c.a(d.b(10737, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis), Integer.valueOf(1), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(0), str2, "", str3, Integer.valueOf(com.tencent.mm.game.report.b.a.getNetworkType(ah.getContext())), Integer.valueOf(0), Integer.valueOf(1), str4, str5));
        AppMethodBeat.o(59567);
    }

    public final void a(String str, int i, int i2, long j, long j2, long j3, String str2, int i3, int i4, String str3, long j4, int i5, long j5, String str4, int i6) {
        AppMethodBeat.i(59568);
        if (j2 < 0) {
            j2 = 0;
        }
        if (j4 < 0) {
            j4 = 0;
        }
        ab.i("MicroMsg.GameDownloadReportImpl", "report_14567, appId = %s, scene = %d, opId = %d, startSize = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d, downloadId = %d, extInfo = %s", str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j5), str4);
        c.a(d.b(14567, str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), com.tencent.mm.game.report.b.a.kY(str2), Integer.valueOf(com.tencent.mm.game.report.b.a.getNetworkType(ah.getContext())), Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j5), str4, com.tencent.mm.game.report.b.a.getDeviceInfo(), Long.valueOf(j), Integer.valueOf(i6)));
        h.pYm.e(15015, str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), com.tencent.mm.game.report.b.a.kY(str2), Integer.valueOf(com.tencent.mm.game.report.b.a.getNetworkType(ah.getContext())), Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j5), str4);
        AppMethodBeat.o(59568);
    }

    public final void j(final String str, final long j) {
        AppMethodBeat.i(59569);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59569);
        } else if ("appid_is_empty".equals(str)) {
            h.pYm.a(860, j, 1, false);
            AppMethodBeat.o(59569);
        } else {
            com.tencent.mm.ce.a.post(new Runnable() {
                final /* synthetic */ long eBy = 1;

                public final void run() {
                    AppMethodBeat.i(59565);
                    f bS = g.bS(str, false);
                    if (bS != null && bS.xy()) {
                        h.pYm.a(860, j, this.eBy, false);
                    }
                    AppMethodBeat.o(59565);
                }
            });
            AppMethodBeat.o(59569);
        }
    }

    public final void a(long j, com.tencent.mm.game.report.api.a aVar) {
        AppMethodBeat.i(59570);
        this.eBw.put(Long.valueOf(j), aVar);
        AppMethodBeat.o(59570);
    }

    public final com.tencent.mm.game.report.api.a eZ(long j) {
        AppMethodBeat.i(59571);
        if (this.eBw.containsKey(Long.valueOf(j))) {
            com.tencent.mm.game.report.api.a aVar = (com.tencent.mm.game.report.api.a) this.eBw.remove(Long.valueOf(j));
            AppMethodBeat.o(59571);
            return aVar;
        }
        AppMethodBeat.o(59571);
        return null;
    }
}
