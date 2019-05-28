package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.g.b.a.cf.b;
import com.tencent.mm.g.b.a.cf.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.f;
import com.tencent.mm.plugin.appbrand.launching.d.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class e extends d {
    private ak ifQ = null;
    private final String ifR;

    public e(LaunchParcel launchParcel, String str, a aVar) {
        super(launchParcel, aVar);
        this.ifR = str;
    }

    public final void run() {
        AppMethodBeat.i(131729);
        Pair aHc = aHc();
        WxaAttributes wxaAttributes = (WxaAttributes) aHc.first;
        if (wxaAttributes == null) {
            ab.i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
            onError();
            AppMethodBeat.o(131729);
        } else if (e(wxaAttributes)) {
            onError();
            AppMethodBeat.o(131729);
        } else {
            AppBrandInitConfigWC b = f.ayD().b(wxaAttributes);
            b.gVs = this.har;
            this.appId = b.appId;
            b.hgN = new QualitySession(this.ifR, b, this.ifO);
            if (((Boolean) aHc.second).booleanValue()) {
                b.hgO = true;
                cf a = g.a(b.hgN);
                a.dfE = c.ok;
                a = a.ec(this.ifQ.iil).ed(this.ifQ.iim).ea(this.ifQ.iin);
                a.dfF = b.sync;
                a.cXm = (long) g.getNetworkType();
                a.ajK();
            } else {
                b.hgO = false;
            }
            JSONObject jSONObject;
            if (this.har == 0) {
                b.hfh = wxaAttributes.ayL().hij;
                b.bQk = wxaAttributes.ayL().bQk;
                jSONObject = wxaAttributes.ayL().hik;
                if (jSONObject != null) {
                    b.hgL = jSONObject.optString("url");
                    b.hgM = jSONObject.optString("progressbar_color");
                }
            } else {
                b.extInfo = ((l) com.tencent.mm.plugin.appbrand.app.f.E(l.class)).bn(this.appId, this.har);
                try {
                    jSONObject = h.lw(b.extInfo);
                    b.hfh = jSONObject.optString("device_orientation");
                    b.bQk = jSONObject.optString("client_js_ext_info");
                    b.bQf = jSONObject.optBoolean("open_remote", false);
                    jSONObject = jSONObject.optJSONObject("loading_image_info");
                    if (jSONObject != null) {
                        b.hgL = jSONObject.optString("url");
                        b.hgM = jSONObject.optString("progressbar_color");
                    }
                } catch (Exception e) {
                }
            }
            b.bQg = d.Cf(b.bQk);
            if (this.ifO == null) {
                this.ifO = new AppBrandStatObject();
            }
            a(b, this.ifO);
            AppMethodBeat.o(131729);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final Pair<WxaAttributes, Boolean> aHc() {
        Pair<WxaAttributes, Boolean> pair;
        AppMethodBeat.i(131730);
        Pair<WxaAttributes, Boolean> pair2 = new Pair(null, Boolean.FALSE);
        try {
            ak akVar = new ak(this.username, this.appId, this.har, this.gVu, this.ifO == null ? 0 : this.ifO.scene, this.hgC);
            this.ifQ = akVar;
            pair = (Pair) akVar.aHy();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", e, "get attr ", new Object[0]);
            pair = pair2;
        }
        AppMethodBeat.o(131730);
        return pair;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean e(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(131731);
        String str = wxaAttributes.field_appId;
        if (new ad(str).aHv()) {
            AppMethodBeat.o(131731);
            return true;
        } else if (2 == this.har && !al.an(str, com.tencent.mm.plugin.appbrand.task.h.DS(str))) {
            AppMethodBeat.o(131731);
            return true;
        } else if (this.har != 0 || al.a(wxaAttributes, this.ifP)) {
            AppMethodBeat.o(131731);
            return false;
        } else {
            AppMethodBeat.o(131731);
            return true;
        }
    }
}
