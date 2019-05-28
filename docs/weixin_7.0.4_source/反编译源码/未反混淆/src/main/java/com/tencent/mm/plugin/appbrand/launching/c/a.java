package com.tencent.mm.plugin.appbrand.launching.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private String appId;
    private int axy;
    private String bIy;
    private int css;
    private int ijY;
    public boolean ijZ;
    private List<Integer> ika = new ArrayList();

    public a(String str, int i, int i2, List<c> list) {
        AppMethodBeat.i(132084);
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
            this.bIy = ((c) list.get(0)).bIy;
            this.ijY = ((c) list.get(0)).version;
        }
        ab.i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "appid:%s,appVersion:%s,appState:%s", str, Integer.valueOf(i), Integer.valueOf(this.css));
        AppMethodBeat.o(132084);
    }

    public static void pc(int i) {
        AppMethodBeat.i(132085);
        ab.i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "idkeyReport id:%d,key:%d", Integer.valueOf(1027), Integer.valueOf(i));
        h.pYm.a(1027, (long) i, 1, false);
        AppMethodBeat.o(132085);
    }

    public final void pd(int i) {
        AppMethodBeat.i(132086);
        if (bo.isNullOrNil(this.appId) || bo.isNullOrNil(this.bIy)) {
            ab.i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "kvReportStatis appId or provider null!");
            AppMethodBeat.o(132086);
            return;
        }
        this.ika.add(Integer.valueOf(i));
        AppMethodBeat.o(132086);
    }

    public final void IF() {
        AppMethodBeat.i(132087);
        if (!this.ijZ) {
            ab.i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "hot startUp!");
        } else if (this.ika != null && this.ika.size() > 0) {
            for (Integer intValue : this.ika) {
                int intValue2 = intValue.intValue();
                ce ceVar = new ce();
                ceVar.gW(this.appId);
                ceVar.ddd = (long) this.axy;
                ceVar.dfv = com.tencent.mm.g.b.a.ce.a.he(this.css);
                ceVar.ddz = 1004;
                ceVar.gX(this.bIy);
                ceVar.dfx = (long) this.ijY;
                ceVar.dfy = (long) intValue2;
                ceVar.gY(j.cW(ah.getContext()));
                ceVar.ajK();
                ab.i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "kvReportStatis report:%s", ceVar.Fk());
            }
            AppMethodBeat.o(132087);
            return;
        }
        AppMethodBeat.o(132087);
    }
}
