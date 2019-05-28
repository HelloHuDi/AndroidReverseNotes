package com.tencent.p177mm.plugin.card.p931d;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C23422od;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.d.t */
public final class C45779t {
    /* renamed from: Hz */
    public static ArrayList<C23422od> m84650Hz(String str) {
        AppMethodBeat.m2504i(88950);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(88950);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("used_store_list");
            if (jSONArray == null || jSONArray.length() == 0) {
                AppMethodBeat.m2505o(88950);
                return null;
            }
            ArrayList<C23422od> arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject == null) {
                    obj = null;
                } else {
                    obj = new C23422od();
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
            AppMethodBeat.m2505o(88950);
            return arrayList;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.ShopInfoItemParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(88950);
            return null;
        }
    }
}
