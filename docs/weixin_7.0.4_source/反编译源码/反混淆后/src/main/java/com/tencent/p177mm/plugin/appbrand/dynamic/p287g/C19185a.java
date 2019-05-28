package com.tencent.p177mm.plugin.appbrand.dynamic.p287g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38203j;
import com.tencent.p177mm.plugin.appbrand.dynamic.p892k.C33167b;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.plugin.appbrand.widget.C27420j;
import com.tencent.p177mm.plugin.appbrand.widget.p1473a.C33574a;
import com.tencent.p177mm.protocal.protobuf.axs;
import com.tencent.p177mm.protocal.protobuf.axt;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.cwv;
import com.tencent.p177mm.protocal.protobuf.cyc;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.g.a */
public final class C19185a extends C37440a<axt> {
    private int cBc;
    public final C7472b ehh;
    public C27420j hoA;
    private int hog;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.g.a$1 */
    public class C21451 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(10935);
            C19185a.this.acy();
            AppMethodBeat.m2505o(10935);
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
        AppMethodBeat.m2504i(10938);
        mo34419a(i, i2, str, (axt) btd);
        AppMethodBeat.m2505o(10938);
    }

    public C19185a(String str, boolean z, cyc cyc) {
        AppMethodBeat.m2504i(10936);
        axs axs = new axs();
        axs.fKh = str;
        axs.wBO = cyc;
        axs.wsv = z ? 1 : 2;
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1181;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
        c1196a.fsJ = axs;
        c1196a.fsK = new axt();
        C7472b acD = c1196a.acD();
        this.ehh = acD;
        this.ehh = acD;
        this.hog = cyc.xtw;
        this.cBc = C33167b.m54217cX(this.hog, cyc.wzF);
        AppMethodBeat.m2505o(10936);
    }

    private String getAppId() {
        return ((axs) this.ehh.fsG.fsP).fKh;
    }

    /* renamed from: a */
    public final void mo34419a(int i, int i2, String str, axt axt) {
        AppMethodBeat.m2504i(10937);
        C18652u.m29151i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", Integer.valueOf(i), Integer.valueOf(i2), str, getAppId());
        if (i == 0 && i2 == 0 && axt != null) {
            String appId = getAppId();
            this.hoA = ((C33574a) C1720g.m3528K(C33574a.class)).auQ().mo35081a(appId, this.cBc, this.hog, axt);
            if (axt.wBQ != null) {
                String at = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60852at(appId, this.cBc);
                cwv cwv = new cwv();
                cwv.xsy = at;
                cwv.vMG = axt.wBQ.vMG;
                if (this.cBc == 10102) {
                    cwv.xsx = axt.wBQ.xrR;
                    ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60850a(appId, cwv, this.cBc);
                    AppMethodBeat.m2505o(10937);
                    return;
                } else if (this.cBc == 10002) {
                    cwv.xsx = axt.wBQ.xrQ;
                    ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60850a(appId, cwv, this.cBc);
                }
            }
            AppMethodBeat.m2505o(10937);
            return;
        }
        C38203j.azE().mo60940zX(getAppId());
        this.hoA = ((C33574a) C1720g.m3528K(C33574a.class)).auQ().mo35080L(getAppId(), this.cBc, this.hog);
        AppMethodBeat.m2505o(10937);
    }
}
