package com.tencent.p177mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37859a;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.game.report.api.C45406d;
import com.tencent.p177mm.game.report.p1382b.C26319a;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.game.report.a */
public final class C37858a extends C45405b {
    private HashMap<Long, C37859a> eBw = new HashMap();

    public C37858a() {
        AppMethodBeat.m2504i(59566);
        AppMethodBeat.m2505o(59566);
    }

    /* renamed from: a */
    public final void mo60569a(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(59567);
        long currentTimeMillis = System.currentTimeMillis();
        C18488c.m28787a(C45406d.m83611b(10737, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis), Integer.valueOf(1), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(0), str2, "", str3, Integer.valueOf(C26319a.getNetworkType(C4996ah.getContext())), Integer.valueOf(0), Integer.valueOf(1), str4, str5));
        AppMethodBeat.m2505o(59567);
    }

    /* renamed from: a */
    public final void mo60568a(String str, int i, int i2, long j, long j2, long j3, String str2, int i3, int i4, String str3, long j4, int i5, long j5, String str4, int i6) {
        AppMethodBeat.m2504i(59568);
        if (j2 < 0) {
            j2 = 0;
        }
        if (j4 < 0) {
            j4 = 0;
        }
        C4990ab.m7417i("MicroMsg.GameDownloadReportImpl", "report_14567, appId = %s, scene = %d, opId = %d, startSize = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d, downloadId = %d, extInfo = %s", str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j5), str4);
        C18488c.m28787a(C45406d.m83611b(14567, str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), C26319a.m41875kY(str2), Integer.valueOf(C26319a.getNetworkType(C4996ah.getContext())), Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j5), str4, C26319a.getDeviceInfo(), Long.valueOf(j), Integer.valueOf(i6)));
        C7060h.pYm.mo8381e(15015, str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), C26319a.m41875kY(str2), Integer.valueOf(C26319a.getNetworkType(C4996ah.getContext())), Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j5), str4);
        AppMethodBeat.m2505o(59568);
    }

    /* renamed from: j */
    public final void mo60571j(final String str, final long j) {
        AppMethodBeat.m2504i(59569);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59569);
        } else if ("appid_is_empty".equals(str)) {
            C7060h.pYm.mo8378a(860, j, 1, false);
            AppMethodBeat.m2505o(59569);
        } else {
            C26006a.post(new Runnable() {
                final /* synthetic */ long eBy = 1;

                public final void run() {
                    AppMethodBeat.m2504i(59565);
                    C40439f bS = C46494g.m87738bS(str, false);
                    if (bS != null && bS.mo63847xy()) {
                        C7060h.pYm.mo8378a(860, j, this.eBy, false);
                    }
                    AppMethodBeat.m2505o(59565);
                }
            });
            AppMethodBeat.m2505o(59569);
        }
    }

    /* renamed from: a */
    public final void mo60567a(long j, C37859a c37859a) {
        AppMethodBeat.m2504i(59570);
        this.eBw.put(Long.valueOf(j), c37859a);
        AppMethodBeat.m2505o(59570);
    }

    /* renamed from: eZ */
    public final C37859a mo60570eZ(long j) {
        AppMethodBeat.m2504i(59571);
        if (this.eBw.containsKey(Long.valueOf(j))) {
            C37859a c37859a = (C37859a) this.eBw.remove(Long.valueOf(j));
            AppMethodBeat.m2505o(59571);
            return c37859a;
        }
        AppMethodBeat.m2505o(59571);
        return null;
    }
}
