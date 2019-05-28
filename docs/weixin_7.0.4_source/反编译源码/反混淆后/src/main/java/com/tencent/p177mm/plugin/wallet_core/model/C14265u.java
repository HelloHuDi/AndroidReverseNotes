package com.tencent.p177mm.plugin.wallet_core.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18480fc;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C43791d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.u */
public final class C14265u extends C18480fc {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: aC */
    public static void m22455aC(JSONObject jSONObject) {
        boolean z = true;
        int i = 0;
        AppMethodBeat.m2504i(46891);
        C43791d cPM = C14241r.cPM();
        boolean z2;
        StringBuilder append;
        if (jSONObject == null || cPM == null) {
            String str = "MicroMsg.WalletBulletin";
            StringBuilder stringBuilder = new StringBuilder("json==null?");
            if (jSONObject == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            append = stringBuilder.append(z2).append("  stg==null?");
            if (cPM != null) {
                z = false;
            }
            C4990ab.m7412e(str, append.append(z).toString());
            AppMethodBeat.m2505o(46891);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("banner_map");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_content_array");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (optJSONArray == null || optJSONArray2 == null) {
            String str2 = "MicroMsg.WalletBulletin";
            StringBuilder stringBuilder2 = new StringBuilder("scenes==null?");
            if (optJSONArray == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            append = stringBuilder2.append(z2).append("  contents==null?");
            if (optJSONArray2 != null) {
                z = false;
            }
            C4990ab.m7412e(str2, append.append(z).toString());
            AppMethodBeat.m2505o(46891);
            return;
        }
        int i2;
        JSONObject optJSONObject;
        int length = optJSONArray.length();
        for (i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
            if (optJSONObject2 != null) {
                String optString = optJSONObject2.optString("banner_type");
                String optString2 = optJSONObject2.optString("banner_template_id");
                C4990ab.m7416i("MicroMsg.WalletBulletin", "sceneid=" + optString + "; contentid=" + optString2);
                if (!(C5046bo.isNullOrNil(optString) || C5046bo.isNullOrNil(optString2))) {
                    hashMap.put(optString, optString2);
                    C4990ab.m7416i("MicroMsg.WalletBulletin", "sceneid:" + optString + " map contentid:" + optString2);
                }
            }
        }
        i2 = optJSONArray2.length();
        while (i < i2) {
            optJSONObject = optJSONArray2.optJSONObject(i);
            if (optJSONObject != null) {
                hashMap2.put(optJSONObject.optString("banner_template_id"), Integer.valueOf(i));
            }
            i++;
        }
        if (hashMap.size() > 0) {
            for (String str3 : hashMap.keySet()) {
                String str4 = (String) hashMap.get(str3);
                if (hashMap2.containsKey(str4)) {
                    C4990ab.m7416i("MicroMsg.WalletBulletin", "find contentid:" + str4 + "in contentMap");
                    optJSONObject = optJSONArray2.optJSONObject(((Integer) hashMap2.get(str4)).intValue());
                    C14265u c14265u = new C14265u();
                    c14265u.field_bulletin_scene = str3;
                    c14265u.field_bulletin_content = optJSONObject.optString(C8741b.CONTENT);
                    c14265u.field_bulletin_url = optJSONObject.optString("url");
                    cPM.mo10101b((C4925c) c14265u);
                } else {
                    C4990ab.m7412e("MicroMsg.WalletBulletin", "can not find contentid:" + str4 + "in contentMap");
                }
            }
        }
        AppMethodBeat.m2505o(46891);
    }

    static {
        AppMethodBeat.m2504i(46892);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "bulletin_scene";
        c4924a.xDd.put("bulletin_scene", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bulletin_scene TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "bulletin_scene";
        c4924a.columns[1] = "bulletin_content";
        c4924a.xDd.put("bulletin_content", "TEXT");
        stringBuilder.append(" bulletin_content TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "bulletin_url";
        c4924a.xDd.put("bulletin_url", "TEXT");
        stringBuilder.append(" bulletin_url TEXT");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(46892);
    }
}
