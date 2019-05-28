package com.tencent.p177mm.plugin.appbrand.launching.p907c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C42095ce;
import com.tencent.p177mm.p230g.p232b.p233a.C42095ce.C42094a;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C10173c;
import com.tencent.p177mm.plugin.appbrand.report.C42674j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.c.a */
public final class C10595a {
    private String appId;
    private int axy;
    private String bIy;
    private int css;
    private int ijY;
    public boolean ijZ;
    private List<Integer> ika = new ArrayList();

    public C10595a(String str, int i, int i2, List<C10173c> list) {
        AppMethodBeat.m2504i(132084);
        this.appId = str;
        this.axy = i;
        switch (i2) {
            case 0:
                this.css = 1;
                break;
            case 1:
                this.css = 2;
                break;
            case 2:
                this.css = 3;
                break;
        }
        if (list != null && list.size() > 0) {
            this.bIy = ((C10173c) list.get(0)).bIy;
            this.ijY = ((C10173c) list.get(0)).version;
        }
        C4990ab.m7417i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "appid:%s,appVersion:%s,appState:%s", str, Integer.valueOf(i), Integer.valueOf(this.css));
        AppMethodBeat.m2505o(132084);
    }

    /* renamed from: pc */
    public static void m18272pc(int i) {
        AppMethodBeat.m2504i(132085);
        C4990ab.m7417i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "idkeyReport id:%d,key:%d", Integer.valueOf(1027), Integer.valueOf(i));
        C7060h.pYm.mo8378a(1027, (long) i, 1, false);
        AppMethodBeat.m2505o(132085);
    }

    /* renamed from: pd */
    public final void mo22109pd(int i) {
        AppMethodBeat.m2504i(132086);
        if (C5046bo.isNullOrNil(this.appId) || C5046bo.isNullOrNil(this.bIy)) {
            C4990ab.m7416i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "kvReportStatis appId or provider null!");
            AppMethodBeat.m2505o(132086);
            return;
        }
        this.ika.add(Integer.valueOf(i));
        AppMethodBeat.m2505o(132086);
    }

    /* renamed from: IF */
    public final void mo22108IF() {
        AppMethodBeat.m2504i(132087);
        if (!this.ijZ) {
            C4990ab.m7416i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "hot startUp!");
        } else if (this.ika != null && this.ika.size() > 0) {
            for (Integer intValue : this.ika) {
                int intValue2 = intValue.intValue();
                C42095ce c42095ce = new C42095ce();
                c42095ce.mo67651gW(this.appId);
                c42095ce.ddd = (long) this.axy;
                c42095ce.dfv = C42094a.m74190he(this.css);
                c42095ce.ddz = 1004;
                c42095ce.mo67652gX(this.bIy);
                c42095ce.dfx = (long) this.ijY;
                c42095ce.dfy = (long) intValue2;
                c42095ce.mo67653gY(C42674j.m75576cW(C4996ah.getContext()));
                c42095ce.ajK();
                C4990ab.m7417i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "kvReportStatis report:%s", c42095ce.mo4983Fk());
            }
            AppMethodBeat.m2505o(132087);
            return;
        }
        AppMethodBeat.m2505o(132087);
    }
}
