package com.tencent.p177mm.plugin.appbrand.jsapi.p309j;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C33836j;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C45814a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.c */
public final class C36724c extends C33330d {
    public static final int CTRL_INDEX = 521;
    public static final String NAME = "updateVoIPChatMuteConfig";
    boolean hTk = false;
    boolean hTl = false;

    /* renamed from: b */
    public final void mo6169b(final C38492q c38492q, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131397);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("muteConfig");
            final boolean z = jSONObject2.getBoolean("muteMicrophone");
            C45124d.m82930i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: muteMicroPhone:%b, muteEarPhone:%b", Boolean.valueOf(z), Boolean.valueOf(jSONObject2.getBoolean("muteEarphone")));
            C33836j.kzW.mo54395a(r0, new C45814a<String>() {
                /* renamed from: a */
                public final /* synthetic */ void mo6170a(int i, int i2, String str, Object obj) {
                    AppMethodBeat.m2504i(131395);
                    C45124d.m82930i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: earphone done! %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        C36724c.this.hTl = true;
                        C36724c.m60920a(C36724c.this, c38492q, i);
                        AppMethodBeat.m2505o(131395);
                        return;
                    }
                    c38492q.mo6107M(i, C36724c.this.mo73394j("fail: ".concat(String.valueOf(str)), null));
                    AppMethodBeat.m2505o(131395);
                }
            });
            C33836j.kzW.mo54396b(z, new C45814a<String>() {
                /* renamed from: a */
                public final /* synthetic */ void mo6170a(int i, int i2, String str, Object obj) {
                    boolean z = true;
                    AppMethodBeat.m2504i(131396);
                    C45124d.m82930i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: microphone done! %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        C36724c.this.hTk = true;
                        C36724c c36724c = C36724c.this;
                        if (z) {
                            z = false;
                        }
                        c36724c.mo53837dU(z);
                        C36724c.m60920a(C36724c.this, c38492q, i);
                        AppMethodBeat.m2505o(131396);
                        return;
                    }
                    c38492q.mo6107M(i, C36724c.this.mo73394j("fail: ".concat(String.valueOf(str)), null));
                    AppMethodBeat.m2505o(131396);
                }
            });
            AppMethodBeat.m2505o(131397);
        } catch (JSONException e) {
            C45124d.printErrStackTrace("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", e, "", new Object[0]);
            AppMethodBeat.m2505o(131397);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m60920a(C36724c c36724c, C38492q c38492q, int i) {
        AppMethodBeat.m2504i(131398);
        if (c36724c.hTk && c36724c.hTl) {
            c38492q.mo6107M(i, c36724c.mo73394j("ok", null));
        }
        AppMethodBeat.m2505o(131398);
    }
}
