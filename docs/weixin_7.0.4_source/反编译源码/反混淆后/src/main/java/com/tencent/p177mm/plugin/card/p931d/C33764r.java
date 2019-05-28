package com.tencent.p177mm.plugin.card.p931d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.sharecard.model.C20154j;
import com.tencent.p177mm.plugin.card.sharecard.model.C42860q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.d.r */
public final class C33764r {
    /* renamed from: Hv */
    public static C20154j m55182Hv(String str) {
        AppMethodBeat.m2504i(88946);
        C4990ab.m7416i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()");
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser json is empty");
            AppMethodBeat.m2505o(88946);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C20154j c20154j = new C20154j();
            c20154j.kfD = jSONObject.optString("consumed_box_id");
            c20154j.kfE = jSONObject.optString("subscribe_wording");
            c20154j.kfF = jSONObject.optString("subscribe_app_username");
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                C4990ab.m7412e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser cardItemListJson is null");
                AppMethodBeat.m2505o(88946);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                C42860q c42860q = new C42860q();
                c42860q.cMD = optJSONObject.optString("card_ext");
                c42860q.kcY = C27575f.m43795I(optJSONObject.optJSONObject("card_tp_info"));
                arrayList.add(c42860q);
            }
            c20154j.ckx = arrayList;
            C4990ab.m7416i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser() tempList size is" + arrayList.size());
            if (TextUtils.isEmpty(c20154j.kfD)) {
                C4990ab.m7416i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  consumed_box_id is empty");
            }
            if (TextUtils.isEmpty(c20154j.kfE)) {
                C4990ab.m7416i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  subscribe_wording is empty");
            }
            AppMethodBeat.m2505o(88946);
            return c20154j;
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser exception:" + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ShareCardConsumedInfoParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(88946);
            return null;
        }
    }
}
