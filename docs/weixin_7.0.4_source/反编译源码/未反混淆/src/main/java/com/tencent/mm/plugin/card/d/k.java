package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
    public static LinkedList<oj> bR(String str, int i) {
        AppMethodBeat.i(88882);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray jsonContent is null");
            AppMethodBeat.o(88882);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                ab.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
                AppMethodBeat.o(88882);
                return null;
            }
            LinkedList<oj> linkedList = new LinkedList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                oj ojVar = new oj();
                ojVar.kbU = optJSONObject.optString(i == 26 ? "cardId" : "card_id");
                ojVar.code = optJSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                ojVar.vUJ = optJSONObject.optString("openCardParams");
                linkedList.add(ojVar);
            }
            AppMethodBeat.o(88882);
            return linkedList;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
            AppMethodBeat.o(88882);
            return null;
        }
    }
}
