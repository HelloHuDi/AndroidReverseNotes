package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C26798h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.c */
public final class C19482c extends C10296a {
    public static final int CTRL_INDEX = 522;
    public static final String NAME = "getBackgroundFetchData";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131483);
        if (c2241c == null) {
            C4990ab.m7420w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:component is null");
            AppMethodBeat.m2505o(131483);
        } else if (jSONObject == null) {
            C4990ab.m7420w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:data is null");
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(131483);
        } else {
            String optString = jSONObject.optString("fetchType");
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7420w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:fetchType is null");
                c2241c.mo6107M(i, mo73394j("fail:fetchType is null", null));
                AppMethodBeat.m2505o(131483);
                return;
            }
            String appId = c2241c.getAppId();
            if (C5046bo.isNullOrNil(appId)) {
                C4990ab.m7420w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:appid is null");
                c2241c.mo6107M(i, mo73394j("fail:appid is null", null));
                AppMethodBeat.m2505o(131483);
                return;
            }
            AppBrandBackgroundFetchDataParcel aR = ((C26798h) C1720g.m3528K(C26798h.class)).mo21501aR(appId, optString.equals("periodic") ? 1 : 0);
            if (aR == null) {
                C4990ab.m7420w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "worker fail:record is null");
                c2241c.mo6107M(i, mo73394j("fail:record is null", null));
                AppMethodBeat.m2505o(131483);
            } else if (aR.data == null) {
                C4990ab.m7420w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "worker fail:fetched data is null");
                c2241c.mo6107M(i, mo73394j("fail:fetched data is null", null));
                AppMethodBeat.m2505o(131483);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("fetchedData", aR.data);
                hashMap.put("path", aR.path);
                hashMap.put(SearchIntents.EXTRA_QUERY, aR.query);
                hashMap.put("scene", Integer.valueOf(aR.scene));
                hashMap.put("timeStamp", Long.valueOf(aR.updateTime));
                C4990ab.m7417i("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "JsApiGetBackgroundFetchData, app(%s_%d)", appId, Integer.valueOf(r1));
                c2241c.mo6107M(i, mo73394j("ok", hashMap));
                AppMethodBeat.m2505o(131483);
            }
        }
    }
}
