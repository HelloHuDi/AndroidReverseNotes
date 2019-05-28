package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel;
import com.tencent.mm.plugin.appbrand.backgroundfetch.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 522;
    public static final String NAME = "getBackgroundFetchData";

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131483);
        if (cVar == null) {
            ab.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:component is null");
            AppMethodBeat.o(131483);
        } else if (jSONObject == null) {
            ab.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:data is null");
            cVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(131483);
        } else {
            String optString = jSONObject.optString("fetchType");
            if (bo.isNullOrNil(optString)) {
                ab.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:fetchType is null");
                cVar.M(i, j("fail:fetchType is null", null));
                AppMethodBeat.o(131483);
                return;
            }
            String appId = cVar.getAppId();
            if (bo.isNullOrNil(appId)) {
                ab.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "fail:appid is null");
                cVar.M(i, j("fail:appid is null", null));
                AppMethodBeat.o(131483);
                return;
            }
            AppBrandBackgroundFetchDataParcel aR = ((h) g.K(h.class)).aR(appId, optString.equals("periodic") ? 1 : 0);
            if (aR == null) {
                ab.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "worker fail:record is null");
                cVar.M(i, j("fail:record is null", null));
                AppMethodBeat.o(131483);
            } else if (aR.data == null) {
                ab.w("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "worker fail:fetched data is null");
                cVar.M(i, j("fail:fetched data is null", null));
                AppMethodBeat.o(131483);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("fetchedData", aR.data);
                hashMap.put("path", aR.path);
                hashMap.put(SearchIntents.EXTRA_QUERY, aR.query);
                hashMap.put("scene", Integer.valueOf(aR.scene));
                hashMap.put("timeStamp", Long.valueOf(aR.updateTime));
                ab.i("MicroMsg.JsApiGetBackgroundFetchData.javayhu", "JsApiGetBackgroundFetchData, app(%s_%d)", appId, Integer.valueOf(r1));
                cVar.M(i, j("ok", hashMap));
                AppMethodBeat.o(131483);
            }
        }
    }
}
