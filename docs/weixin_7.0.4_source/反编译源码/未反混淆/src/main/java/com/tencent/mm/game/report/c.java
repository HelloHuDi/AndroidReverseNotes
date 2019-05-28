package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.game.report.api.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;

final class c {
    private static LinkedList<d> eBA = new LinkedList();
    private static boolean eBB;
    private static String eBC = "log_id";
    private static String eBD = "log_ext";

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(59586);
            Bundle bundle = (Bundle) obj;
            c.a(new d(bundle.getInt(c.eBC), bundle.getString(c.eBD)));
            cVar.ao(null);
            AppMethodBeat.o(59586);
        }
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(59590);
        Pt();
        AppMethodBeat.o(59590);
    }

    static {
        AppMethodBeat.i(59591);
        AppMethodBeat.o(59591);
    }

    public static void a(d dVar) {
        AppMethodBeat.i(59587);
        if (ah.bqo()) {
            b(dVar);
            AppMethodBeat.o(59587);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(eBC, dVar.eBH);
        bundle.putString(eBD, dVar.eBI);
        f.a("com.tencent.mm", bundle, a.class, null);
        AppMethodBeat.o(59587);
    }

    private static synchronized void b(d dVar) {
        synchronized (c.class) {
            AppMethodBeat.i(59588);
            if (!g.RN().QY() || com.tencent.mm.kernel.a.QT()) {
                ab.w("MicroMsg.ReportService", "report, account not ready");
                AppMethodBeat.o(59588);
            } else if (dVar == null) {
                AppMethodBeat.o(59588);
            } else {
                eBA.add(dVar);
                Pt();
                AppMethodBeat.o(59588);
            }
        }
    }

    private static synchronized void Pt() {
        synchronized (c.class) {
            AppMethodBeat.i(59589);
            if (eBB) {
                ab.i("MicroMsg.ReportService", "tryDoScene isBusy");
                AppMethodBeat.o(59589);
            } else if (bo.ek(eBA)) {
                ab.i("MicroMsg.ReportService", "waitingList is null");
                AppMethodBeat.o(59589);
            } else {
                d dVar = (d) eBA.remove(0);
                if (dVar != null) {
                    eBB = true;
                    com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                    aVar.uri = "/cgi-bin/micromsg-bin/gamereportkv";
                    aVar.fsI = v2helper.EMethodPcMicLevel;
                    aVar.fsL = 0;
                    aVar.fsM = 0;
                    adf adf = new adf();
                    adf.vOz = com.tencent.mm.protocal.d.vxj;
                    adf.vOA = com.tencent.mm.protocal.d.vxi;
                    adf.vOB = com.tencent.mm.protocal.d.vxl;
                    adf.vOC = com.tencent.mm.protocal.d.vxm;
                    adf.vOD = aa.dor();
                    adf.pXL = dVar.eBH;
                    adf.vOE = dVar.eBI;
                    aVar.fsJ = adf;
                    aVar.fsK = new adg();
                    w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
                        public final int a(int i, int i2, String str, b bVar, m mVar) {
                            AppMethodBeat.i(59585);
                            ab.i("MicroMsg.ReportService", "tryDoScene, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                            c.eBB = false;
                            c.access$100();
                            AppMethodBeat.o(59585);
                            return 0;
                        }
                    });
                    AppMethodBeat.o(59589);
                } else {
                    Pt();
                    AppMethodBeat.o(59589);
                }
            }
        }
    }
}
