package com.tencent.p177mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C45406d;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.adf;
import com.tencent.p177mm.protocal.protobuf.adg;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.game.report.c */
final class C18488c {
    private static LinkedList<C45406d> eBA = new LinkedList();
    private static boolean eBB;
    private static String eBC = "log_id";
    private static String eBD = "log_ext";

    /* renamed from: com.tencent.mm.game.report.c$a */
    static class C18487a implements C37866a<Bundle, Bundle> {
        private C18487a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(59586);
            Bundle bundle = (Bundle) obj;
            C18488c.m28787a(new C45406d(bundle.getInt(C18488c.eBC), bundle.getString(C18488c.eBD)));
            c18507c.mo5960ao(null);
            AppMethodBeat.m2505o(59586);
        }
    }

    /* renamed from: com.tencent.mm.game.report.c$1 */
    static class C184891 implements C1224a {
        C184891() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(59585);
            C4990ab.m7417i("MicroMsg.ReportService", "tryDoScene, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            C18488c.eBB = false;
            C18488c.access$100();
            AppMethodBeat.m2505o(59585);
            return 0;
        }
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.m2504i(59590);
        C18488c.m28785Pt();
        AppMethodBeat.m2505o(59590);
    }

    static {
        AppMethodBeat.m2504i(59591);
        AppMethodBeat.m2505o(59591);
    }

    /* renamed from: a */
    public static void m28787a(C45406d c45406d) {
        AppMethodBeat.m2504i(59587);
        if (C4996ah.bqo()) {
            C18488c.m28788b(c45406d);
            AppMethodBeat.m2505o(59587);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(eBC, c45406d.eBH);
        bundle.putString(eBD, c45406d.eBI);
        C9549f.m17012a("com.tencent.mm", bundle, C18487a.class, null);
        AppMethodBeat.m2505o(59587);
    }

    /* renamed from: b */
    private static synchronized void m28788b(C45406d c45406d) {
        synchronized (C18488c.class) {
            AppMethodBeat.m2504i(59588);
            if (!C1720g.m3534RN().mo5161QY() || C1668a.m3393QT()) {
                C4990ab.m7420w("MicroMsg.ReportService", "report, account not ready");
                AppMethodBeat.m2505o(59588);
            } else if (c45406d == null) {
                AppMethodBeat.m2505o(59588);
            } else {
                eBA.add(c45406d);
                C18488c.m28785Pt();
                AppMethodBeat.m2505o(59588);
            }
        }
    }

    /* renamed from: Pt */
    private static synchronized void m28785Pt() {
        synchronized (C18488c.class) {
            AppMethodBeat.m2504i(59589);
            if (eBB) {
                C4990ab.m7416i("MicroMsg.ReportService", "tryDoScene isBusy");
                AppMethodBeat.m2505o(59589);
            } else if (C5046bo.m7548ek(eBA)) {
                C4990ab.m7416i("MicroMsg.ReportService", "waitingList is null");
                AppMethodBeat.m2505o(59589);
            } else {
                C45406d c45406d = (C45406d) eBA.remove(0);
                if (c45406d != null) {
                    eBB = true;
                    C1196a c1196a = new C1196a();
                    c1196a.uri = "/cgi-bin/micromsg-bin/gamereportkv";
                    c1196a.fsI = v2helper.EMethodPcMicLevel;
                    c1196a.fsL = 0;
                    c1196a.fsM = 0;
                    adf adf = new adf();
                    adf.vOz = C7243d.vxj;
                    adf.vOA = C7243d.vxi;
                    adf.vOB = C7243d.vxl;
                    adf.vOC = C7243d.vxm;
                    adf.vOD = C4988aa.dor();
                    adf.pXL = c45406d.eBH;
                    adf.vOE = c45406d.eBI;
                    c1196a.fsJ = adf;
                    c1196a.fsK = new adg();
                    C1226w.m2654a(c1196a.acD(), new C184891());
                    AppMethodBeat.m2505o(59589);
                } else {
                    C18488c.m28785Pt();
                    AppMethodBeat.m2505o(59589);
                }
            }
        }
    }
}
