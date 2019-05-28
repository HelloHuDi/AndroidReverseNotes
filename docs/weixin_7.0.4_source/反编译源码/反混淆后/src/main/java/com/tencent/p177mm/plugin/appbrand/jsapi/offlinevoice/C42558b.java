package com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b */
public final class C42558b extends C10296a {
    public static final int CTRL_INDEX = 635;
    public static final String NAME = "loadPaySpeechDialectConfig";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131372);
        C4990ab.m7416i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "invoke JsApiLoadPaySpeechDialectConfig!");
        if (c2241c == null) {
            C4990ab.m7412e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:component is null");
            AppMethodBeat.m2505o(131372);
        } else if (c2241c.getContext() == null) {
            C4990ab.m7412e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:context is null");
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131372);
        } else {
            C9549f.m17012a("com.tencent.mm", null, C42556a.class, new C18507c<Bundle>() {
                /* renamed from: ao */
                public final /* synthetic */ void mo5960ao(Object obj) {
                    AppMethodBeat.m2504i(131371);
                    Bundle bundle = (Bundle) obj;
                    HashMap hashMap = new HashMap();
                    String string = bundle.getString("idsStr", "");
                    if (!C5046bo.isNullOrNil(string)) {
                        HashSet hashSet = new HashSet();
                        for (Object add : string.split(",")) {
                            hashSet.add(add);
                        }
                        if (hashSet.size() > 0) {
                            hashMap.put("downloadedPackId", new JSONArray(hashSet));
                            C4990ab.m7417i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "downloadedPackId:%s", new JSONArray(hashSet).toString());
                        }
                    }
                    C4990ab.m7417i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "resId:%s", bundle.getString("resId", ""));
                    hashMap.put("dialectPackId", string);
                    c2241c.mo6107M(i, C42558b.this.mo73394j("ok", hashMap));
                    AppMethodBeat.m2505o(131371);
                }
            });
            AppMethodBeat.m2505o(131372);
        }
    }
}
