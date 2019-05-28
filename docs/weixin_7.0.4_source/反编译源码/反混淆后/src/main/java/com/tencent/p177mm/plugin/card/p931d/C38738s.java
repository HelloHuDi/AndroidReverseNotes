package com.tencent.p177mm.plugin.card.p931d;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.sharecard.model.C27593l;
import com.tencent.p177mm.plugin.card.sharecard.model.C38752m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.d.s */
public final class C38738s {
    /* renamed from: Hw */
    public static C27593l m65737Hw(String str) {
        int i = 1;
        AppMethodBeat.m2504i(88947);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData jsonContent is null");
            AppMethodBeat.m2505o(88947);
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("list");
            if (optJSONObject == null) {
                C4990ab.m7412e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData resultJson is null");
                AppMethodBeat.m2505o(88947);
                return null;
            }
            int i2;
            C27593l c27593l = new C27593l();
            c27593l.kfI = optJSONObject.optString("local_city");
            c27593l.kfG = C38738s.m65738Hx(optJSONObject.optString("local_city_list"));
            c27593l.kfH = C38738s.m65738Hx(optJSONObject.optString("other_city_list"));
            c27593l.kfJ = optJSONObject.optBoolean("local_end");
            c27593l.kfK = optJSONObject.optBoolean("other_end");
            c27593l.cML = optJSONObject.optBoolean("show_red_dot");
            c27593l.cMM = optJSONObject.optBoolean("show_new");
            c27593l.kfM = optJSONObject.optString("tips");
            c27593l.kfL = C38738s.m65739Hy(optJSONObject.optString("icons"));
            c27593l.kfN = optJSONObject.optInt("newest_sharecard_time_second");
            String str2 = "MicroMsg.ShareCardLayoutDataParser";
            String str3 = "localEnd:%d, otherEnd:%d, showRedDot:%d, showNew:%d, tips:%s";
            Object[] objArr = new Object[5];
            if (c27593l.kfJ) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(c27593l.kfK ? 1 : 0);
            objArr[2] = Integer.valueOf(c27593l.cML ? 1 : 0);
            if (!c27593l.cMM) {
                i = 0;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = c27593l.kfM;
            C4990ab.m7417i(str2, str3, objArr);
            AppMethodBeat.m2505o(88947);
            return c27593l;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(88947);
            return null;
        }
    }

    /* renamed from: Hx */
    private static LinkedList<C38752m> m65738Hx(String str) {
        AppMethodBeat.m2504i(88948);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem jsonContent is null");
            AppMethodBeat.m2505o(88948);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(C8741b.ITEM_LIST);
            if (optJSONArray == null || optJSONArray.length() == 0) {
                C4990ab.m7412e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem itemListJson is null");
                AppMethodBeat.m2505o(88948);
                return null;
            }
            LinkedList<C38752m> linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                C38752m c38752m = new C38752m();
                c38752m.cMC = optJSONObject.optString("card_id");
                c38752m.kbU = optJSONObject.optString("card_tp_id");
                c38752m.kfO = optJSONObject.optString("announcement");
                c38752m.kfP = (long) optJSONObject.optInt("end_time", 0);
                c38752m.kfQ = (long) optJSONObject.optInt("update_time", 0);
                c38752m.kfR = optJSONObject.optInt("item_type", 0);
                c38752m.top = optJSONObject.optInt("top", 0);
                C4990ab.m7416i("MicroMsg.ShareCardLayoutDataParser", "ljd: card_tp_id:" + c38752m.kbU + " top:" + c38752m.top);
                linkedList.add(c38752m);
            }
            AppMethodBeat.m2505o(88948);
            return linkedList;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(88948);
            return null;
        }
    }

    /* renamed from: Hy */
    private static LinkedList<String> m65739Hy(String str) {
        AppMethodBeat.m2504i(88949);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons jsonContent is null");
            AppMethodBeat.m2505o(88949);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                C4990ab.m7412e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons itemListJson is null");
                AppMethodBeat.m2505o(88949);
                return null;
            }
            LinkedList<String> linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(jSONArray.optString(i));
            }
            AppMethodBeat.m2505o(88949);
            return linkedList;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(88949);
            return null;
        }
    }
}
