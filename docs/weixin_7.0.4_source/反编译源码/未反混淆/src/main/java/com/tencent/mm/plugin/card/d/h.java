package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class h {
    public static ArrayList<nx> bP(String str, int i) {
        AppMethodBeat.i(88873);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
            AppMethodBeat.o(88873);
            return null;
        }
        JSONArray optJSONArray;
        if (i == 8 || i == 0) {
            try {
                optJSONArray = new JSONObject(str).optJSONArray("card_list");
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
                AppMethodBeat.o(88873);
                return null;
            }
        } else if (i == 26) {
            optJSONArray = new JSONArray(str);
        } else {
            optJSONArray = new JSONArray(str);
        }
        if (optJSONArray == null || optJSONArray.length() == 0) {
            ab.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
            AppMethodBeat.o(88873);
            return null;
        }
        ArrayList<nx> arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            nx nxVar = new nx();
            nxVar.kbU = optJSONObject.optString(i == 26 ? "cardId" : "card_id");
            nxVar.cMD = optJSONObject.optString(i == 26 ? "cardExt" : "card_ext");
            arrayList.add(nxVar);
        }
        AppMethodBeat.o(88873);
        return arrayList;
    }

    public static String a(LinkedList<e> linkedList, boolean z, int i) {
        AppMethodBeat.i(88874);
        String str;
        if (linkedList.size() == 0) {
            ab.e("MicroMsg.CardListItemParser", "parseCardListItemToJson list == null || list.size() == 0");
            str = "";
            AppMethodBeat.o(88874);
            return str;
        }
        ab.i("MicroMsg.CardListItemParser", "parseCardListItemToJson is_succ:" + z + " scene:" + i);
        JSONStringer jSONStringer = new JSONStringer();
        if (i == 8) {
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
                str = "";
                AppMethodBeat.o(88874);
                return str;
            }
        }
        jSONStringer.array();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            jSONStringer.object();
            jSONStringer.key(i == 26 ? "cardId" : "card_id");
            jSONStringer.value(eVar.kbU);
            jSONStringer.key(i == 26 ? "cardExt" : "card_ext");
            jSONStringer.value(eVar.cMD == null ? "" : eVar.cMD);
            jSONStringer.key(i == 26 ? "isSuccess" : "is_succ");
            if (z) {
                jSONStringer.value(i == 26 ? Boolean.TRUE : Integer.valueOf(1));
            } else {
                jSONStringer.value(i == 26 ? Boolean.FALSE : Integer.valueOf(0));
            }
            jSONStringer.key(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            jSONStringer.value(eVar.code == null ? "" : eVar.code);
            jSONStringer.endObject();
        }
        jSONStringer.endArray();
        if (i == 8) {
            jSONStringer.endObject();
        }
        str = jSONStringer.toString();
        AppMethodBeat.o(88874);
        return str;
    }

    public static String bQ(String str, int i) {
        AppMethodBeat.i(88875);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
            AppMethodBeat.o(88875);
            return null;
        }
        String jSONStringer;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                ab.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
                AppMethodBeat.o(88875);
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
                ab.i("MicroMsg.CardListItemParser", "parseJsonToArray item" + i2 + "  is_succ:" + optJSONObject.optInt(i == 26 ? "isSuccess" : "is_succ"));
            }
            jSONStringer2.endArray();
            jSONStringer = jSONStringer2.toString();
            AppMethodBeat.o(88875);
            return jSONStringer;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
            jSONStringer = "";
            AppMethodBeat.o(88875);
            return jSONStringer;
        }
    }
}
