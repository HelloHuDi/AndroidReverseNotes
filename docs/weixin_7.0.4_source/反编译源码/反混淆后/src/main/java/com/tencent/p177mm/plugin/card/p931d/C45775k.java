package com.tencent.p177mm.plugin.card.p931d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C44152oj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.d.k */
public final class C45775k {
    /* renamed from: bR */
    public static LinkedList<C44152oj> m84636bR(String str, int i) {
        AppMethodBeat.m2504i(88882);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray jsonContent is null");
            AppMethodBeat.m2505o(88882);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                C4990ab.m7412e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
                AppMethodBeat.m2505o(88882);
                return null;
            }
            LinkedList<C44152oj> linkedList = new LinkedList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                C44152oj c44152oj = new C44152oj();
                c44152oj.kbU = optJSONObject.optString(i == 26 ? "cardId" : "card_id");
                c44152oj.code = optJSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                c44152oj.vUJ = optJSONObject.optString("openCardParams");
                linkedList.add(c44152oj);
            }
            AppMethodBeat.m2505o(88882);
            return linkedList;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(88882);
            return null;
        }
    }
}
