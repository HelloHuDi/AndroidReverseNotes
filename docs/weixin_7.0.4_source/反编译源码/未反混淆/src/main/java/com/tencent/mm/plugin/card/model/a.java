package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
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

    public static LinkedList<a> Gs(String str) {
        LinkedList<a> linkedList = null;
        AppMethodBeat.i(87772);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(87772);
        } else {
            try {
                linkedList = a(new JSONObject(str).optJSONArray("available_cards"), false);
                AppMethodBeat.o(87772);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.AvailableCardItem", e, "", new Object[0]);
                AppMethodBeat.o(87772);
            }
        }
        return linkedList;
    }

    public static LinkedList<a> Gt(String str) {
        LinkedList<a> linkedList = null;
        AppMethodBeat.i(87773);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(87773);
        } else {
            try {
                linkedList = a(new JSONObject(str).optJSONArray("available_share_cards"), true);
                AppMethodBeat.o(87773);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.AvailableCardItem", e, "", new Object[0]);
                AppMethodBeat.o(87773);
            }
        }
        return linkedList;
    }

    private static LinkedList<a> a(JSONArray jSONArray, boolean z) {
        AppMethodBeat.i(87774);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(87774);
            return null;
        }
        LinkedList<a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            a aVar = new a();
            aVar.kbU = jSONObject.optString("card_tp_id");
            aVar.iAd = jSONObject.optInt("card_type");
            aVar.color = jSONObject.optString("color");
            aVar.kbV = jSONObject.optString("logo_url");
            aVar.title = jSONObject.optString("title");
            aVar.kbW = jSONObject.optString("sub_title");
            aVar.kbX = jSONObject.optString("aux_title");
            aVar.kbY = jSONObject.optString("encrypt_code");
            aVar.userName = jSONObject.optString("from_user_name");
            aVar.app_id = jSONObject.optString("app_id");
            aVar.kbZ = jSONObject.optInt("end_time");
            aVar.kca = jSONObject.optString("card_user_id");
            aVar.kcb = jSONObject.optInt("choose_optional");
            aVar.kcd = jSONObject.optString("invoice_item");
            aVar.kce = jSONObject.optString("invoice_status");
            aVar.kcc = jSONObject.optString("invoice_title");
            aVar.kcf = z;
            linkedList.add(aVar);
        }
        AppMethodBeat.o(87774);
        return linkedList;
    }
}
