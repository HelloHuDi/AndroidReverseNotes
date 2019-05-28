package com.tencent.p177mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.model.a */
public final class C27584a {
    public String app_id;
    public String color;
    public int iAd;
    public String jKR;
    public String kbU;
    public String kbV;
    public String kbW;
    public String kbX;
    public String kbY;
    public int kbZ;
    public String kca;
    public int kcb;
    public String kcc;
    public String kcd;
    public String kce;
    public boolean kcf;
    public String title;
    public String userName;

    /* renamed from: Gs */
    public static LinkedList<C27584a> m43812Gs(String str) {
        LinkedList<C27584a> linkedList = null;
        AppMethodBeat.m2504i(87772);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(87772);
        } else {
            try {
                linkedList = C27584a.m43814a(new JSONObject(str).optJSONArray("available_cards"), false);
                AppMethodBeat.m2505o(87772);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.AvailableCardItem", e, "", new Object[0]);
                AppMethodBeat.m2505o(87772);
            }
        }
        return linkedList;
    }

    /* renamed from: Gt */
    public static LinkedList<C27584a> m43813Gt(String str) {
        LinkedList<C27584a> linkedList = null;
        AppMethodBeat.m2504i(87773);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(87773);
        } else {
            try {
                linkedList = C27584a.m43814a(new JSONObject(str).optJSONArray("available_share_cards"), true);
                AppMethodBeat.m2505o(87773);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.AvailableCardItem", e, "", new Object[0]);
                AppMethodBeat.m2505o(87773);
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    private static LinkedList<C27584a> m43814a(JSONArray jSONArray, boolean z) {
        AppMethodBeat.m2504i(87774);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.m2505o(87774);
            return null;
        }
        LinkedList<C27584a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            C27584a c27584a = new C27584a();
            c27584a.kbU = jSONObject.optString("card_tp_id");
            c27584a.iAd = jSONObject.optInt("card_type");
            c27584a.color = jSONObject.optString("color");
            c27584a.kbV = jSONObject.optString("logo_url");
            c27584a.title = jSONObject.optString("title");
            c27584a.kbW = jSONObject.optString("sub_title");
            c27584a.kbX = jSONObject.optString("aux_title");
            c27584a.kbY = jSONObject.optString("encrypt_code");
            c27584a.userName = jSONObject.optString("from_user_name");
            c27584a.app_id = jSONObject.optString("app_id");
            c27584a.kbZ = jSONObject.optInt("end_time");
            c27584a.kca = jSONObject.optString("card_user_id");
            c27584a.kcb = jSONObject.optInt("choose_optional");
            c27584a.kcd = jSONObject.optString("invoice_item");
            c27584a.kce = jSONObject.optString("invoice_status");
            c27584a.kcc = jSONObject.optString("invoice_title");
            c27584a.kcf = z;
            linkedList.add(c27584a);
        }
        AppMethodBeat.m2505o(87774);
        return linkedList;
    }
}
