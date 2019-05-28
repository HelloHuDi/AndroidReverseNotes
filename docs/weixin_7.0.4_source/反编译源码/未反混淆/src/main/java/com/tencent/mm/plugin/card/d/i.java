package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    public static f Hl(String str) {
        AppMethodBeat.i(88876);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardMallItemParser", "parseCardMallItem jsonContent is null");
            AppMethodBeat.o(88876);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            fVar.kdj = jSONObject.optString("empty_tips");
            fVar.kdk = jSONObject.optString("shoppingmall_title");
            fVar.kdl = jSONObject.optString("shoppingmall_url");
            fVar.kdm = jSONObject.optInt("is_show") != 0;
            AppMethodBeat.o(88876);
            return fVar;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardMallItemParser", e, "", new Object[0]);
            AppMethodBeat.o(88876);
            return null;
        }
    }
}
