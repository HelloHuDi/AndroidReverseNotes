package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 635;
    public static final String NAME = "loadPaySpeechDialectConfig";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131372);
        ab.i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "invoke JsApiLoadPaySpeechDialectConfig!");
        if (cVar == null) {
            ab.e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:component is null");
            AppMethodBeat.o(131372);
        } else if (cVar.getContext() == null) {
            ab.e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:context is null");
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(131372);
        } else {
            f.a("com.tencent.mm", null, a.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
                public final /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(131371);
                    Bundle bundle = (Bundle) obj;
                    HashMap hashMap = new HashMap();
                    String string = bundle.getString("idsStr", "");
                    if (!bo.isNullOrNil(string)) {
                        HashSet hashSet = new HashSet();
                        for (Object add : string.split(",")) {
                            hashSet.add(add);
                        }
                        if (hashSet.size() > 0) {
                            hashMap.put("downloadedPackId", new JSONArray(hashSet));
                            ab.i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "downloadedPackId:%s", new JSONArray(hashSet).toString());
                        }
                    }
                    ab.i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "resId:%s", bundle.getString("resId", ""));
                    hashMap.put("dialectPackId", string);
                    cVar.M(i, b.this.j("ok", hashMap));
                    AppMethodBeat.o(131371);
                }
            });
            AppMethodBeat.o(131372);
        }
    }
}
