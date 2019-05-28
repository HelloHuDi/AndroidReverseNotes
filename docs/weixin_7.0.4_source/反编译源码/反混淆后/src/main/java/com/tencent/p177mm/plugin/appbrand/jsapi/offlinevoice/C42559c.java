package com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice.IPCSetCurrentPaySpeech.IPCSetCurrentPaySpeechParam;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c */
public final class C42559c extends C10296a {
    public static final int CTRL_INDEX = 634;
    public static final String NAME = "setCurrentPaySpeech";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131374);
        C4990ab.m7416i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "invoke JsApiSetCurrentPaySpeech!");
        if (c2241c == null) {
            C4990ab.m7412e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:component is null");
            AppMethodBeat.m2505o(131374);
        } else if (c2241c.getContext() == null) {
            C4990ab.m7412e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:context is null");
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131374);
        } else {
            String optString = jSONObject.optString("dialectPackId");
            String optString2 = jSONObject.optString("tempFilePath");
            C4990ab.m7411d("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "tempFilePath:%s dialectPackId:%s md5Sum:%s isOnlyDownload:%s", optString2, optString, jSONObject.optString("md5Sum"), Boolean.valueOf(jSONObject.optBoolean("isOnlyDownload")));
            String str = "";
            if (!C5046bo.isNullOrNil(optString2)) {
                File yg = c2241c.asE().mo34314yg(optString2);
                if (yg == null || !yg.exists()) {
                    C4990ab.m7416i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:tempFile no exist");
                    c2241c.mo6107M(i, mo73394j("fail", null));
                    AppMethodBeat.m2505o(131374);
                    return;
                }
                str = yg.getAbsolutePath();
            }
            C9549f.m17012a("com.tencent.mm", new IPCSetCurrentPaySpeechParam(optString, optString2, str, r4, r5), IPCSetCurrentPaySpeech.class, new C18507c<IPCBoolean>() {
                /* renamed from: ao */
                public final /* synthetic */ void mo5960ao(Object obj) {
                    AppMethodBeat.m2504i(131373);
                    C4990ab.m7417i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "onCallback() data.value:%s", Boolean.valueOf(((IPCBoolean) obj).value));
                    if (((IPCBoolean) obj).value) {
                        c2241c.mo6107M(i, C42559c.this.mo73394j("ok", null));
                        AppMethodBeat.m2505o(131373);
                        return;
                    }
                    c2241c.mo6107M(i, C42559c.this.mo73394j("fail", null));
                    AppMethodBeat.m2505o(131373);
                }
            });
            AppMethodBeat.m2505o(131374);
        }
    }
}
