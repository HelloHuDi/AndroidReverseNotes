package com.tencent.p177mm.plugin.card.p931d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.model.C45785f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.d.i */
public final class C27576i {
    /* renamed from: Hl */
    public static C45785f m43809Hl(String str) {
        AppMethodBeat.m2504i(88876);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardMallItemParser", "parseCardMallItem jsonContent is null");
            AppMethodBeat.m2505o(88876);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C45785f c45785f = new C45785f();
            c45785f.kdj = jSONObject.optString("empty_tips");
            c45785f.kdk = jSONObject.optString("shoppingmall_title");
            c45785f.kdl = jSONObject.optString("shoppingmall_url");
            c45785f.kdm = jSONObject.optInt("is_show") != 0;
            AppMethodBeat.m2505o(88876);
            return c45785f;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardMallItemParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(88876);
            return null;
        }
    }
}
