package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r {
    public static j Hv(String str) {
        AppMethodBeat.i(88946);
        ab.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()");
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser json is empty");
            AppMethodBeat.o(88946);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            j jVar = new j();
            jVar.kfD = jSONObject.optString("consumed_box_id");
            jVar.kfE = jSONObject.optString("subscribe_wording");
            jVar.kfF = jSONObject.optString("subscribe_app_username");
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                ab.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser cardItemListJson is null");
                AppMethodBeat.o(88946);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                q qVar = new q();
                qVar.cMD = optJSONObject.optString("card_ext");
                qVar.kcY = f.I(optJSONObject.optJSONObject("card_tp_info"));
                arrayList.add(qVar);
            }
            jVar.ckx = arrayList;
            ab.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser() tempList size is" + arrayList.size());
            if (TextUtils.isEmpty(jVar.kfD)) {
                ab.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  consumed_box_id is empty");
            }
            if (TextUtils.isEmpty(jVar.kfE)) {
                ab.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  subscribe_wording is empty");
            }
            AppMethodBeat.o(88946);
            return jVar;
        } catch (JSONException e) {
            ab.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser exception:" + e.getMessage());
            ab.printErrStackTrace("MicroMsg.ShareCardConsumedInfoParser", e, "", new Object[0]);
            AppMethodBeat.o(88946);
            return null;
        }
    }
}
