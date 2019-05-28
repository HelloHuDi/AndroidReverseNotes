package com.tencent.p177mm.plugin.card.p931d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.model.C38744e;
import com.tencent.p177mm.protocal.protobuf.C35941nx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* renamed from: com.tencent.mm.plugin.card.d.h */
public final class C20135h {
    /* renamed from: bP */
    public static ArrayList<C35941nx> m31152bP(String str, int i) {
        AppMethodBeat.m2504i(88873);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
            AppMethodBeat.m2505o(88873);
            return null;
        }
        JSONArray optJSONArray;
        if (i == 8 || i == 0) {
            try {
                optJSONArray = new JSONObject(str).optJSONArray("card_list");
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
                AppMethodBeat.m2505o(88873);
                return null;
            }
        } else if (i == 26) {
            optJSONArray = new JSONArray(str);
        } else {
            optJSONArray = new JSONArray(str);
        }
        if (optJSONArray == null || optJSONArray.length() == 0) {
            C4990ab.m7412e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
            AppMethodBeat.m2505o(88873);
            return null;
        }
        ArrayList<C35941nx> arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            C35941nx c35941nx = new C35941nx();
            c35941nx.kbU = optJSONObject.optString(i == 26 ? "cardId" : "card_id");
            c35941nx.cMD = optJSONObject.optString(i == 26 ? "cardExt" : "card_ext");
            arrayList.add(c35941nx);
        }
        AppMethodBeat.m2505o(88873);
        return arrayList;
    }

    /* renamed from: a */
    public static String m31151a(LinkedList<C38744e> linkedList, boolean z, int i) {
        AppMethodBeat.m2504i(88874);
        String str;
        if (linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.CardListItemParser", "parseCardListItemToJson list == null || list.size() == 0");
            str = "";
            AppMethodBeat.m2505o(88874);
            return str;
        }
        C4990ab.m7416i("MicroMsg.CardListItemParser", "parseCardListItemToJson is_succ:" + z + " scene:" + i);
        JSONStringer jSONStringer = new JSONStringer();
        if (i == 8) {
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
                str = "";
                AppMethodBeat.m2505o(88874);
                return str;
            }
        }
        jSONStringer.array();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C38744e c38744e = (C38744e) it.next();
            jSONStringer.object();
            jSONStringer.key(i == 26 ? "cardId" : "card_id");
            jSONStringer.value(c38744e.kbU);
            jSONStringer.key(i == 26 ? "cardExt" : "card_ext");
            jSONStringer.value(c38744e.cMD == null ? "" : c38744e.cMD);
            jSONStringer.key(i == 26 ? "isSuccess" : "is_succ");
            if (z) {
                jSONStringer.value(i == 26 ? Boolean.TRUE : Integer.valueOf(1));
            } else {
                jSONStringer.value(i == 26 ? Boolean.FALSE : Integer.valueOf(0));
            }
            jSONStringer.key(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            jSONStringer.value(c38744e.code == null ? "" : c38744e.code);
            jSONStringer.endObject();
        }
        jSONStringer.endArray();
        if (i == 8) {
            jSONStringer.endObject();
        }
        str = jSONStringer.toString();
        AppMethodBeat.m2505o(88874);
        return str;
    }

    /* renamed from: bQ */
    public static String m31153bQ(String str, int i) {
        AppMethodBeat.m2504i(88875);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
            AppMethodBeat.m2505o(88875);
            return null;
        }
        String jSONStringer;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                C4990ab.m7412e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
                AppMethodBeat.m2505o(88875);
                return null;
            }
            JSONStringer jSONStringer2 = new JSONStringer();
            jSONStringer2.array();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                jSONStringer2.object();
                jSONStringer2.key(i == 26 ? "cardId" : "card_id");
                jSONStringer2.value(optJSONObject.optString("card_id"));
                jSONStringer2.key(i == 26 ? "cardExt" : "card_ext");
                jSONStringer2.value(optJSONObject.optString("card_ext"));
                jSONStringer2.key(i == 26 ? "isSuccess" : "is_succ");
                if (i != 26) {
                    jSONStringer2.value((long) optJSONObject.optInt("is_succ"));
                } else if (optJSONObject.optInt("is_succ") == 1) {
                    jSONStringer2.value(true);
                } else {
                    jSONStringer2.value(false);
                }
                jSONStringer2.key(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                if (TextUtils.isEmpty(optJSONObject.optString("encrypt_code"))) {
                    jSONStringer2.value(optJSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE));
                } else {
                    jSONStringer2.value(optJSONObject.optString("encrypt_code"));
                }
                jSONStringer2.endObject();
                C4990ab.m7416i("MicroMsg.CardListItemParser", "parseJsonToArray item" + i2 + "  is_succ:" + optJSONObject.optInt(i == 26 ? "isSuccess" : "is_succ"));
            }
            jSONStringer2.endArray();
            jSONStringer = jSONStringer2.toString();
            AppMethodBeat.m2505o(88875);
            return jSONStringer;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
            jSONStringer = "";
            AppMethodBeat.m2505o(88875);
            return jSONStringer;
        }
    }
}
