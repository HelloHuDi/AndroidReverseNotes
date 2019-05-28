package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t {
    public static ArrayList<od> Hz(String str) {
        AppMethodBeat.i(88950);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(88950);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("used_store_list");
            if (jSONArray == null || jSONArray.length() == 0) {
                AppMethodBeat.o(88950);
                return null;
            }
            ArrayList<od> arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject == null) {
                    obj = null;
                } else {
                    obj = new od();
                    obj.name = jSONObject.optString("name");
                    obj.descriptor = jSONObject.optString("descriptor");
                    obj.kck = jSONObject.optString("phone");
                    obj.country = jSONObject.optString(UserDataStore.COUNTRY);
                    obj.duc = jSONObject.optString("province");
                    obj.dud = jSONObject.optString("city");
                    obj.fBg = jSONObject.optString("address");
                    obj.qVo = (float) jSONObject.optDouble("distance");
                    obj.cGm = (float) jSONObject.optDouble("longitude");
                    obj.cEB = (float) jSONObject.optDouble("latitude");
                    obj.kdF = jSONObject.optString("jump_url");
                    obj.vTL = jSONObject.optString("app_brand_user_name");
                    obj.vTM = jSONObject.optString("app_brand_pass");
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            AppMethodBeat.o(88950);
            return arrayList;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.ShopInfoItemParser", e, "", new Object[0]);
            AppMethodBeat.o(88950);
            return null;
        }
    }
}
