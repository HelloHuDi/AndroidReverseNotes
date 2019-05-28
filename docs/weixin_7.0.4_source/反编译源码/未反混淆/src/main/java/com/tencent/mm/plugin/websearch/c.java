package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.bt.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class c implements n {
    private int tZq;
    private Map<String, String> tZr = new HashMap();

    public c() {
        AppMethodBeat.i(91352);
        AppMethodBeat.o(91352);
    }

    public final void HM(int i) {
        this.tZq = i;
    }

    public final int cUM() {
        return this.tZq;
    }

    public final void bw(int i, String str) {
        AppMethodBeat.i(91353);
        axc axc = new axc();
        axc.wBd = i;
        axc.wBl = (int) (System.currentTimeMillis() / 1000);
        axc.jBv = 1;
        axc.wBe = new b(str.getBytes());
        a aVar = new a();
        aVar.fsJ = new bq();
        aVar.fsK = new br();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.fsI = 1802;
        com.tencent.mm.ai.b acD = aVar.acD();
        bq bqVar = (bq) acD.fsG.fsP;
        axb axb = new axb();
        axb.vOz = d.vxj;
        axb.vOA = d.vxi;
        axb.vOB = d.vxl;
        axb.vOC = d.vxm;
        axb.vOD = aa.dor();
        axb.wBk = (int) (System.currentTimeMillis() / 1000);
        bqVar.vDV = axb;
        bqVar.vDW.add(axc);
        w.a(acD, new w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(91351);
                ab.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (!(i == 0 && i2 == 0)) {
                    h.pYm.a(457, 1, 1, false);
                }
                AppMethodBeat.o(91351);
                return 0;
            }
        });
        AppMethodBeat.o(91353);
    }

    public final String cUN() {
        AppMethodBeat.i(91354);
        String aLD = com.tencent.mm.plugin.websearch.a.a.aLD();
        AppMethodBeat.o(91354);
        return aLD;
    }

    public final void gQ(String str, String str2) {
        AppMethodBeat.i(91355);
        this.tZr.put(str, str2);
        AppMethodBeat.o(91355);
    }

    public final String adC(String str) {
        AppMethodBeat.i(91356);
        String str2 = (String) this.tZr.get(str);
        AppMethodBeat.o(91356);
        return str2;
    }
}
