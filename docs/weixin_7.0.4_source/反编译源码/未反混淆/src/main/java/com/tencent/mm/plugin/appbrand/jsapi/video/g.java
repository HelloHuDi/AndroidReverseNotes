package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 483;
    public static final String NAME = "loadVideoResource";

    public final void a(final c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126561);
        if (jSONObject == null) {
            cVar.M(i, j("fail:data nil", null));
            ab.w("MicroMsg.JsApiLoadVideoResource", "data is null");
            AppMethodBeat.o(126561);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            ab.w("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
            cVar.M(i, j("fail:dataArr nil", null));
            AppMethodBeat.o(126561);
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= optJSONArray.length()) {
                break;
            }
            String optString = optJSONArray.optString(i4, "");
            ab.d("MicroMsg.JsApiLoadVideoResource", "preLoadVideo videoUrl:%s", optString);
            if (bo.isNullOrNil(optString)) {
                ab.w("MicroMsg.JsApiLoadVideoResource", "videoUrl i nil");
                i2++;
            } else {
                i3 = ((e) e.B(e.class)).a(optString, new c() {
                    public final void cv(String str, String str2) {
                        AppMethodBeat.i(126559);
                        ab.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadSucc save_path = %s, url = %s", str2, str);
                        c cVar = cVar;
                        HashMap hashMap = new HashMap();
                        hashMap.put("resource", str);
                        new k().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                        AppMethodBeat.o(126559);
                    }

                    public final void bj(String str, int i) {
                        AppMethodBeat.i(126560);
                        ab.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadFail err_code = %s, url = %s", Integer.valueOf(i), str);
                        g.a(cVar, str, -5, i);
                        AppMethodBeat.o(126560);
                    }
                });
                if (i3 != 0) {
                    ab.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo genPreLoad fail ret = %s, videoUrl = %s", Integer.valueOf(i3), optString);
                    a(cVar, optString, i3, 0);
                    i2++;
                }
            }
            i3 = i4 + 1;
        }
        if (i2 != 0 && i2 == optJSONArray.length()) {
            cVar.M(i, j("fail", null));
        }
        AppMethodBeat.o(126561);
    }

    static void a(c cVar, String str, int i, int i2) {
        AppMethodBeat.i(126562);
        Object obj = "";
        switch (i) {
            case -5:
                obj = "cdn download fail errCode:".concat(String.valueOf(i2));
                break;
            case -4:
                obj = "create file fail";
                break;
            case -3:
                obj = "start download fail";
                break;
            case -2:
                obj = "downloading";
                break;
            case -1:
                obj = "args illegal";
                break;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", obj);
        hashMap.put("resource", str);
        new j().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
        AppMethodBeat.o(126562);
    }
}
