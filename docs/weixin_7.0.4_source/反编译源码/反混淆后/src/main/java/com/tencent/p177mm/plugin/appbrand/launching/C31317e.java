package com.tencent.p177mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.p230g.p232b.p233a.C46882cf;
import com.tencent.p177mm.p230g.p232b.p233a.C46882cf.C26283c;
import com.tencent.p177mm.p230g.p232b.p233a.C46882cf.C9510b;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C7488f;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.launching.C27164d.C27163a;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2453g;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.e */
public final class C31317e extends C27164d {
    private C19562ak ifQ = null;
    private final String ifR;

    public C31317e(LaunchParcel launchParcel, String str, C27163a c27163a) {
        super(launchParcel, c27163a);
        this.ifR = str;
    }

    public final void run() {
        AppMethodBeat.m2504i(131729);
        Pair aHc = aHc();
        WxaAttributes wxaAttributes = (WxaAttributes) aHc.first;
        if (wxaAttributes == null) {
            C4990ab.m7416i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
            onError();
            AppMethodBeat.m2505o(131729);
        } else if (mo44838e(wxaAttributes)) {
            onError();
            AppMethodBeat.m2505o(131729);
        } else {
            AppBrandInitConfigWC b = C7488f.ayD().mo16715b(wxaAttributes);
            b.gVs = this.har;
            this.appId = b.appId;
            b.hgN = new QualitySession(this.ifR, b, this.ifO);
            if (((Boolean) aHc.second).booleanValue()) {
                b.hgO = true;
                C46882cf a = C2453g.m4693a(b.hgN);
                a.dfE = C26283c.ok;
                a = a.mo76066ec(this.ifQ.iil).mo76067ed(this.ifQ.iim).mo76064ea(this.ifQ.iin);
                a.dfF = C9510b.sync;
                a.cXm = (long) C2453g.getNetworkType();
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
                b.extInfo = ((C42611l) C42340f.m74878E(C42611l.class)).mo68052bn(this.appId, this.har);
                try {
                    jSONObject = C41725h.m73457lw(b.extInfo);
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
            b.bQg = C27164d.m43171Cf(b.bQk);
            if (this.ifO == null) {
                this.ifO = new AppBrandStatObject();
            }
            mo44835a(b, this.ifO);
            AppMethodBeat.m2505o(131729);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final Pair<WxaAttributes, Boolean> aHc() {
        Pair<WxaAttributes, Boolean> pair;
        AppMethodBeat.m2504i(131730);
        Pair<WxaAttributes, Boolean> pair2 = new Pair(null, Boolean.FALSE);
        try {
            C19562ak c19562ak = new C19562ak(this.username, this.appId, this.har, this.gVu, this.ifO == null ? 0 : this.ifO.scene, this.hgC);
            this.ifQ = c19562ak;
            pair = (Pair) c19562ak.aHy();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", e, "get attr ", new Object[0]);
            pair = pair2;
        }
        AppMethodBeat.m2505o(131730);
        return pair;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: e */
    public final boolean mo44838e(WxaAttributes wxaAttributes) {
        AppMethodBeat.m2504i(131731);
        String str = wxaAttributes.field_appId;
        if (new C10581ad(str).aHv()) {
            AppMethodBeat.m2505o(131731);
            return true;
        } else if (2 == this.har && !C19563al.m30336an(str, C45694h.m84416DS(str))) {
            AppMethodBeat.m2505o(131731);
            return true;
        } else if (this.har != 0 || C19563al.m30335a(wxaAttributes, this.ifP)) {
            AppMethodBeat.m2505o(131731);
            return false;
        } else {
            AppMethodBeat.m2505o(131731);
            return true;
        }
    }
}
