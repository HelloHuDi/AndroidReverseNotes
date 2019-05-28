package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.Callable;

public final class a implements Callable<j> {
    final String appId;
    final int axy;
    final int cBc;
    final int hog;
    final String hoh;
    final int scene;

    public final /* synthetic */ Object call() {
        AppMethodBeat.i(10918);
        j azY = azY();
        AppMethodBeat.o(10918);
        return azY;
    }

    public a(String str, int i, int i2, int i3, int i4, String str2) {
        this.appId = str;
        this.cBc = i;
        this.axy = i2;
        this.scene = i3;
        this.hog = i4;
        this.hoh = str2;
    }

    public final j azY() {
        AppMethodBeat.i(10917);
        j jVar = new j();
        jVar.field_appId = this.appId;
        i auQ = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.K(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auQ();
        if (auQ == null) {
            AppMethodBeat.o(10917);
            return null;
        }
        cyc cyc = new cyc();
        cyc.wzF = b.nO(this.cBc);
        cyc.vMG = this.axy;
        cyc.xtw = this.hog;
        cyc.Scene = this.scene;
        cyc.xtx = 0;
        if (auQ.a(jVar, "appId", "pkgType", "widgetType")) {
            int i;
            if (jVar.field_jsApiInfo != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (!(i == 0 || jVar.field_launchAction == null || 1 != jVar.field_launchAction.vAS || jVar.field_versionInfo == null || jVar.field_versionInfo.vMG < this.axy)) {
                com.tencent.mm.ce.a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(10935);
                        a.this.acy();
                        AppMethodBeat.o(10935);
                    }
                });
                AppMethodBeat.o(10917);
                return jVar;
            }
        }
        if (this.hoh != null && this.hoh.length() > 0) {
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
            try {
                axt axt = new axt();
                axt.parseFrom(Base64.decode(this.hoh, 0));
                String str = "MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo";
                String str2 = "preload launch info versioninfo is null %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(axt.wBQ == null);
                u.i(str, str2, objArr);
                jVar = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.K(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auQ().a(this.appId, this.cBc, this.hog, axt);
                if (axt.wBQ != null) {
                    String at = ((d) g.K(d.class)).xF().at(this.appId, this.cBc);
                    cwv cwv = new cwv();
                    cwv.xsy = at;
                    cwv.vMG = axt.wBQ.vMG;
                    if (this.cBc == 10102) {
                        cwv.xsx = axt.wBQ.xrR;
                        ((d) g.K(d.class)).xF().a(this.appId, cwv, this.cBc);
                    } else if (this.cBc == 10002) {
                        cwv.xsx = axt.wBQ.xrQ;
                        ((d) g.K(d.class)).xF().a(this.appId, cwv, this.cBc);
                    }
                }
                AppMethodBeat.o(10917);
                return jVar;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", this.hoh);
            }
        }
        com.tencent.mm.plugin.appbrand.dynamic.g.a aVar = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, cyc);
        com.tencent.mm.ai.a.a c = x.c(aVar.ehh);
        aVar.a(c.errType, c.errCode, c.aIm, (axt) c.fsy);
        j jVar2 = aVar.hoA;
        AppMethodBeat.o(10917);
        return jVar2;
    }
}
