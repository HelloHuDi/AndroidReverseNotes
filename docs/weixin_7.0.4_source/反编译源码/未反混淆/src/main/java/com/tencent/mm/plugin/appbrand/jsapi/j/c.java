package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends d {
    public static final int CTRL_INDEX = 521;
    public static final String NAME = "updateVoIPChatMuteConfig";
    boolean hTk = false;
    boolean hTl = false;

    public final void b(final q qVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131397);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("muteConfig");
            final boolean z = jSONObject2.getBoolean("muteMicrophone");
            d.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: muteMicroPhone:%b, muteEarPhone:%b", Boolean.valueOf(z), Boolean.valueOf(jSONObject2.getBoolean("muteEarphone")));
            j.kzW.a(r0, new a<String>() {
                public final /* synthetic */ void a(int i, int i2, String str, Object obj) {
                    AppMethodBeat.i(131395);
                    d.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: earphone done! %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        c.this.hTl = true;
                        c.a(c.this, qVar, i);
                        AppMethodBeat.o(131395);
                        return;
                    }
                    qVar.M(i, c.this.j("fail: ".concat(String.valueOf(str)), null));
                    AppMethodBeat.o(131395);
                }
            });
            j.kzW.b(z, new a<String>() {
                public final /* synthetic */ void a(int i, int i2, String str, Object obj) {
                    boolean z = true;
                    AppMethodBeat.i(131396);
                    d.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: microphone done! %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        c.this.hTk = true;
                        c cVar = c.this;
                        if (z) {
                            z = false;
                        }
                        cVar.dU(z);
                        c.a(c.this, qVar, i);
                        AppMethodBeat.o(131396);
                        return;
                    }
                    qVar.M(i, c.this.j("fail: ".concat(String.valueOf(str)), null));
                    AppMethodBeat.o(131396);
                }
            });
            AppMethodBeat.o(131397);
        } catch (JSONException e) {
            d.printErrStackTrace("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", e, "", new Object[0]);
            AppMethodBeat.o(131397);
        }
    }

    static /* synthetic */ void a(c cVar, q qVar, int i) {
        AppMethodBeat.i(131398);
        if (cVar.hTk && cVar.hTl) {
            qVar.M(i, cVar.j("ok", null));
        }
        AppMethodBeat.o(131398);
    }
}
