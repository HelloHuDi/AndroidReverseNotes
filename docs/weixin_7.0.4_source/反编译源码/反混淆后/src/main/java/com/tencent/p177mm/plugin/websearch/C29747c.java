package com.tencent.p177mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C43852n;
import com.tencent.p177mm.plugin.websearch.p1663a.C46398a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C15322bq;
import com.tencent.p177mm.protocal.protobuf.C30171br;
import com.tencent.p177mm.protocal.protobuf.axb;
import com.tencent.p177mm.protocal.protobuf.axc;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.websearch.c */
public final class C29747c implements C43852n {
    private int tZq;
    private Map<String, String> tZr = new HashMap();

    /* renamed from: com.tencent.mm.plugin.websearch.c$1 */
    class C227611 implements C1224a {
        C227611() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(91351);
            C4990ab.m7411d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (!(i == 0 && i2 == 0)) {
                C7060h.pYm.mo8378a(457, 1, 1, false);
            }
            AppMethodBeat.m2505o(91351);
            return 0;
        }
    }

    public C29747c() {
        AppMethodBeat.m2504i(91352);
        AppMethodBeat.m2505o(91352);
    }

    /* renamed from: HM */
    public final void mo47993HM(int i) {
        this.tZq = i;
    }

    public final int cUM() {
        return this.tZq;
    }

    /* renamed from: bw */
    public final void mo47995bw(int i, String str) {
        AppMethodBeat.m2504i(91353);
        axc axc = new axc();
        axc.wBd = i;
        axc.wBl = (int) (System.currentTimeMillis() / 1000);
        axc.jBv = 1;
        axc.wBe = new C1332b(str.getBytes());
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15322bq();
        c1196a.fsK = new C30171br();
        c1196a.uri = "/cgi-bin/mmux-bin/adlog";
        c1196a.fsI = 1802;
        C7472b acD = c1196a.acD();
        C15322bq c15322bq = (C15322bq) acD.fsG.fsP;
        axb axb = new axb();
        axb.vOz = C7243d.vxj;
        axb.vOA = C7243d.vxi;
        axb.vOB = C7243d.vxl;
        axb.vOC = C7243d.vxm;
        axb.vOD = C4988aa.dor();
        axb.wBk = (int) (System.currentTimeMillis() / 1000);
        c15322bq.vDV = axb;
        c15322bq.vDW.add(axc);
        C1226w.m2654a(acD, new C227611());
        AppMethodBeat.m2505o(91353);
    }

    public final String cUN() {
        AppMethodBeat.m2504i(91354);
        String aLD = C46398a.aLD();
        AppMethodBeat.m2505o(91354);
        return aLD;
    }

    /* renamed from: gQ */
    public final void mo47998gQ(String str, String str2) {
        AppMethodBeat.m2504i(91355);
        this.tZr.put(str, str2);
        AppMethodBeat.m2505o(91355);
    }

    public final String adC(String str) {
        AppMethodBeat.m2504i(91356);
        String str2 = (String) this.tZr.get(str);
        AppMethodBeat.m2505o(91356);
        return str2;
    }
}
