package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.IPCSetCurrentPaySpeech.IPCSetCurrentPaySpeechParam;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 634;
    public static final String NAME = "setCurrentPaySpeech";

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131374);
        ab.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "invoke JsApiSetCurrentPaySpeech!");
        if (cVar == null) {
            ab.e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:component is null");
            AppMethodBeat.o(131374);
        } else if (cVar.getContext() == null) {
            ab.e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:context is null");
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(131374);
        } else {
            String optString = jSONObject.optString("dialectPackId");
            String optString2 = jSONObject.optString("tempFilePath");
            ab.d("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "tempFilePath:%s dialectPackId:%s md5Sum:%s isOnlyDownload:%s", optString2, optString, jSONObject.optString("md5Sum"), Boolean.valueOf(jSONObject.optBoolean("isOnlyDownload")));
            String str = "";
            if (!bo.isNullOrNil(optString2)) {
                File yg = cVar.asE().yg(optString2);
                if (yg == null || !yg.exists()) {
                    ab.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:tempFile no exist");
                    cVar.M(i, j("fail", null));
                    AppMethodBeat.o(131374);
                    return;
                }
                str = yg.getAbsolutePath();
            }
            f.a("com.tencent.mm", new IPCSetCurrentPaySpeechParam(optString, optString2, str, r4, r5), IPCSetCurrentPaySpeech.class, new com.tencent.mm.ipcinvoker.c<IPCBoolean>() {
                public final /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(131373);
                    ab.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "onCallback() data.value:%s", Boolean.valueOf(((IPCBoolean) obj).value));
                    if (((IPCBoolean) obj).value) {
                        cVar.M(i, c.this.j("ok", null));
                        AppMethodBeat.o(131373);
                        return;
                    }
                    cVar.M(i, c.this.j("fail", null));
                    AppMethodBeat.o(131373);
                }
            });
            AppMethodBeat.o(131374);
        }
    }
}
