package com.tencent.p177mm.plugin.appbrand.jsapi.p309j;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C33836j;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C33836j.C33839a;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C45814a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.a */
public final class C2294a extends C33330d {
    public static final int CTRL_INDEX = 517;
    public static final String NAME = "exitVoIPChat";

    /* renamed from: b */
    public final void mo6169b(C38492q c38492q, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131384);
        C45124d.m82929i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: invoke JsApiCloudVoiceExitVoIPChat");
        mo53837dU(false);
        final String appId = c38492q.getAppId();
        final long yz = C5046bo.m7588yz();
        final C38492q c38492q2 = c38492q;
        final int i2 = i;
        C33836j.kzW.mo54394a(new C45814a<String>() {
            /* renamed from: a */
            public final /* synthetic */ void mo6170a(int i, int i2, String str, Object obj) {
                AppMethodBeat.m2504i(131383);
                String str2 = (String) obj;
                long az = C5046bo.m7525az(yz);
                C45124d.m82930i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: exit conference result %d, %d, %s, %s, using %d ms", Integer.valueOf(i), Integer.valueOf(i2), str, str2, Long.valueOf(az));
                C7060h.pYm.mo8381e(16093, appId, Integer.valueOf(i2), Long.valueOf(az));
                if (i == 0 && i2 == 0) {
                    C7060h.pYm.mo15419k(935, 2, 1);
                    c38492q2.mo6107M(i2, C2294a.this.mo73394j("ok", null));
                    AppMethodBeat.m2505o(131383);
                    return;
                }
                C7060h.pYm.mo15419k(935, 3, 1);
                c38492q2.mo6107M(i2, C2294a.this.mo73394j("fail: ".concat(String.valueOf(str)), null));
                AppMethodBeat.m2505o(131383);
            }
        }, C33839a.kBf);
        AppMethodBeat.m2505o(131384);
    }
}
