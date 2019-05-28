package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s {
    public static l Hw(String str) {
        int i = 1;
        AppMethodBeat.i(88947);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData jsonContent is null");
            AppMethodBeat.o(88947);
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("list");
            if (optJSONObject == null) {
                ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData resultJson is null");
                AppMethodBeat.o(88947);
                return null;
            }
            int i2;
            l lVar = new l();
            lVar.kfI = optJSONObject.optString("local_city");
            lVar.kfG = Hx(optJSONObject.optString("local_city_list"));
            lVar.kfH = Hx(optJSONObject.optString("other_city_list"));
            lVar.kfJ = optJSONObject.optBoolean("local_end");
            lVar.kfK = optJSONObject.optBoolean("other_end");
            lVar.cML = optJSONObject.optBoolean("show_red_dot");
            lVar.cMM = optJSONObject.optBoolean("show_new");
            lVar.kfM = optJSONObject.optString("tips");
            lVar.kfL = Hy(optJSONObject.optString("icons"));
            lVar.kfN = optJSONObject.optInt("newest_sharecard_time_second");
            String str2 = "MicroMsg.ShareCardLayoutDataParser";
            String str3 = "localEnd:%d, otherEnd:%d, showRedDot:%d, showNew:%d, tips:%s";
            Object[] objArr = new Object[5];
            if (lVar.kfJ) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(lVar.kfK ? 1 : 0);
            objArr[2] = Integer.valueOf(lVar.cML ? 1 : 0);
            if (!lVar.cMM) {
                i = 0;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = lVar.kfM;
            ab.i(str2, str3, objArr);
            AppMethodBeat.o(88947);
            return lVar;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            AppMethodBeat.o(88947);
            return null;
        }
    }

    private static LinkedList<m> Hx(String str) {
        AppMethodBeat.i(88948);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem jsonContent is null");
            AppMethodBeat.o(88948);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(b.ITEM_LIST);
            if (optJSONArray == null || optJSONArray.length() == 0) {
                ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem itemListJson is null");
                AppMethodBeat.o(88948);
                return null;
            }
            LinkedList<m> linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                m mVar = new m();
                mVar.cMC = optJSONObject.optString("card_id");
                mVar.kbU = optJSONObject.optString("card_tp_id");
                mVar.kfO = optJSONObject.optString("announcement");
                mVar.kfP = (long) optJSONObject.optInt("end_time", 0);
                mVar.kfQ = (long) optJSONObject.optInt("update_time", 0);
                mVar.kfR = optJSONObject.optInt("item_type", 0);
                mVar.top = optJSONObject.optInt("top", 0);
                ab.i("MicroMsg.ShareCardLayoutDataParser", "ljd: card_tp_id:" + mVar.kbU + " top:" + mVar.top);
                linkedList.add(mVar);
            }
            AppMethodBeat.o(88948);
            return linkedList;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            AppMethodBeat.o(88948);
            return null;
        }
    }

    private static LinkedList<String> Hy(String str) {
        AppMethodBeat.i(88949);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons jsonContent is null");
            AppMethodBeat.o(88949);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons itemListJson is null");
                AppMethodBeat.o(88949);
                return null;
            }
            LinkedList<String> linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(jSONArray.optString(i));
            }
            AppMethodBeat.o(88949);
            return linkedList;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            AppMethodBeat.o(88949);
            return null;
        }
    }
}
