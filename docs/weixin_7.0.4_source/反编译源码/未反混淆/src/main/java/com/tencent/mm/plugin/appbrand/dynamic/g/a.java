package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.protocal.protobuf.cyc;

public final class a extends com.tencent.mm.ai.a<axt> {
    private int cBc;
    public final b ehh;
    public j hoA;
    private int hog;

    public final /* bridge */ /* synthetic */ void a(int i, int i2, String str, btd btd, m mVar) {
        AppMethodBeat.i(10938);
        a(i, i2, str, (axt) btd);
        AppMethodBeat.o(10938);
    }

    public a(String str, boolean z, cyc cyc) {
        AppMethodBeat.i(10936);
        axs axs = new axs();
        axs.fKh = str;
        axs.wBO = cyc;
        axs.wsv = z ? 1 : 2;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = 1181;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
        aVar.fsJ = axs;
        aVar.fsK = new axt();
        b acD = aVar.acD();
        this.ehh = acD;
        this.ehh = acD;
        this.hog = cyc.xtw;
        this.cBc = com.tencent.mm.plugin.appbrand.dynamic.k.b.cX(this.hog, cyc.wzF);
        AppMethodBeat.o(10936);
    }

    private String getAppId() {
        return ((axs) this.ehh.fsG.fsP).fKh;
    }

    public final void a(int i, int i2, String str, axt axt) {
        AppMethodBeat.i(10937);
        u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", Integer.valueOf(i), Integer.valueOf(i2), str, getAppId());
        if (i == 0 && i2 == 0 && axt != null) {
            String appId = getAppId();
            this.hoA = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.K(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auQ().a(appId, this.cBc, this.hog, axt);
            if (axt.wBQ != null) {
                String at = ((d) g.K(d.class)).xF().at(appId, this.cBc);
                cwv cwv = new cwv();
                cwv.xsy = at;
                cwv.vMG = axt.wBQ.vMG;
                if (this.cBc == 10102) {
                    cwv.xsx = axt.wBQ.xrR;
                    ((d) g.K(d.class)).xF().a(appId, cwv, this.cBc);
                    AppMethodBeat.o(10937);
                    return;
                } else if (this.cBc == 10002) {
                    cwv.xsx = axt.wBQ.xrQ;
                    ((d) g.K(d.class)).xF().a(appId, cwv, this.cBc);
                }
            }
            AppMethodBeat.o(10937);
            return;
        }
        com.tencent.mm.plugin.appbrand.dynamic.j.azE().zX(getAppId());
        this.hoA = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.K(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auQ().L(getAppId(), this.cBc, this.hog);
        AppMethodBeat.o(10937);
    }
}
