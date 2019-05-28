package com.tencent.p177mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.plugin.appbrand.dynamic.p287g.C19185a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p287g.C19185a.C21451;
import com.tencent.p177mm.plugin.appbrand.dynamic.p892k.C33167b;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.plugin.appbrand.widget.C19858i;
import com.tencent.p177mm.plugin.appbrand.widget.C27420j;
import com.tencent.p177mm.plugin.appbrand.widget.p1473a.C33574a;
import com.tencent.p177mm.protocal.protobuf.axt;
import com.tencent.p177mm.protocal.protobuf.cwv;
import com.tencent.p177mm.protocal.protobuf.cyc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.Callable;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.launching.a */
public final class C38207a implements Callable<C27420j> {
    final String appId;
    final int axy;
    final int cBc;
    final int hog;
    final String hoh;
    final int scene;

    public final /* synthetic */ Object call() {
        AppMethodBeat.m2504i(10918);
        C27420j azY = azY();
        AppMethodBeat.m2505o(10918);
        return azY;
    }

    public C38207a(String str, int i, int i2, int i3, int i4, String str2) {
        this.appId = str;
        this.cBc = i;
        this.axy = i2;
        this.scene = i3;
        this.hog = i4;
        this.hoh = str2;
    }

    public final C27420j azY() {
        AppMethodBeat.m2504i(10917);
        C27420j c27420j = new C27420j();
        c27420j.field_appId = this.appId;
        C19858i auQ = ((C33574a) C1720g.m3528K(C33574a.class)).auQ();
        if (auQ == null) {
            AppMethodBeat.m2505o(10917);
            return null;
        }
        cyc cyc = new cyc();
        cyc.wzF = C33167b.m54218nO(this.cBc);
        cyc.vMG = this.axy;
        cyc.xtw = this.hog;
        cyc.Scene = this.scene;
        cyc.xtx = 0;
        if (auQ.mo35082a(c27420j, "appId", "pkgType", "widgetType")) {
            int i;
            if (c27420j.field_jsApiInfo != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (!(i == 0 || c27420j.field_launchAction == null || 1 != c27420j.field_launchAction.vAS || c27420j.field_versionInfo == null || c27420j.field_versionInfo.vMG < this.axy)) {
                C26006a.post(new C21451());
                AppMethodBeat.m2505o(10917);
                return c27420j;
            }
        }
        if (this.hoh != null && this.hoh.length() > 0) {
            C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
            try {
                axt axt = new axt();
                axt.parseFrom(Base64.decode(this.hoh, 0));
                String str = "MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo";
                String str2 = "preload launch info versioninfo is null %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(axt.wBQ == null);
                C18652u.m29151i(str, str2, objArr);
                c27420j = ((C33574a) C1720g.m3528K(C33574a.class)).auQ().mo35081a(this.appId, this.cBc, this.hog, axt);
                if (axt.wBQ != null) {
                    String at = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60852at(this.appId, this.cBc);
                    cwv cwv = new cwv();
                    cwv.xsy = at;
                    cwv.vMG = axt.wBQ.vMG;
                    if (this.cBc == 10102) {
                        cwv.xsx = axt.wBQ.xrR;
                        ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60850a(this.appId, cwv, this.cBc);
                    } else if (this.cBc == 10002) {
                        cwv.xsx = axt.wBQ.xrQ;
                        ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60850a(this.appId, cwv, this.cBc);
                    }
                }
                AppMethodBeat.m2505o(10917);
                return c27420j;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", this.hoh);
            }
        }
        C19185a c19185a = new C19185a(this.appId, true, cyc);
        C37441a c = C8920x.m16082c(c19185a.ehh);
        c19185a.mo34419a(c.errType, c.errCode, c.aIm, (axt) c.fsy);
        C27420j c27420j2 = c19185a.hoA;
        AppMethodBeat.m2505o(10917);
        return c27420j2;
    }
}
