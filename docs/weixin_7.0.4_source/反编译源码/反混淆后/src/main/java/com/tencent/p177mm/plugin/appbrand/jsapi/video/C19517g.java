package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C19520j;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C27133k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.g */
public final class C19517g extends C10296a {
    public static final int CTRL_INDEX = 483;
    public static final String NAME = "loadVideoResource";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126561);
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data nil", null));
            C4990ab.m7420w("MicroMsg.JsApiLoadVideoResource", "data is null");
            AppMethodBeat.m2505o(126561);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            C4990ab.m7420w("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
            c2241c.mo6107M(i, mo73394j("fail:dataArr nil", null));
            AppMethodBeat.m2505o(126561);
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
            C4990ab.m7411d("MicroMsg.JsApiLoadVideoResource", "preLoadVideo videoUrl:%s", optString);
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7420w("MicroMsg.JsApiLoadVideoResource", "videoUrl i nil");
                i2++;
            } else {
                i3 = ((C38401e) C37384e.m62985B(C38401e.class)).mo61110a(optString, new C38398c() {
                    /* renamed from: cv */
                    public final void mo34713cv(String str, String str2) {
                        AppMethodBeat.m2504i(126559);
                        C4990ab.m7417i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadSucc save_path = %s, url = %s", str2, str);
                        C2241c c2241c = c2241c;
                        HashMap hashMap = new HashMap();
                        hashMap.put("resource", str);
                        new C27133k().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                        AppMethodBeat.m2505o(126559);
                    }

                    /* renamed from: bj */
                    public final void mo34712bj(String str, int i) {
                        AppMethodBeat.m2504i(126560);
                        C4990ab.m7417i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadFail err_code = %s, url = %s", Integer.valueOf(i), str);
                        C19517g.m30242a(c2241c, str, -5, i);
                        AppMethodBeat.m2505o(126560);
                    }
                });
                if (i3 != 0) {
                    C4990ab.m7417i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo genPreLoad fail ret = %s, videoUrl = %s", Integer.valueOf(i3), optString);
                    C19517g.m30242a(c2241c, optString, i3, 0);
                    i2++;
                }
            }
            i3 = i4 + 1;
        }
        if (i2 != 0 && i2 == optJSONArray.length()) {
            c2241c.mo6107M(i, mo73394j("fail", null));
        }
        AppMethodBeat.m2505o(126561);
    }

    /* renamed from: a */
    static void m30242a(C2241c c2241c, String str, int i, int i2) {
        AppMethodBeat.m2504i(126562);
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
        new C19520j().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
        AppMethodBeat.m2505o(126562);
    }
}
