package com.tencent.mm.plugin.wallet_core.model;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fc;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class u extends fc {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    public static void aC(JSONObject jSONObject) {
        boolean z = true;
        int i = 0;
        AppMethodBeat.i(46891);
        d cPM = r.cPM();
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
            ab.e(str, append.append(z).toString());
            AppMethodBeat.o(46891);
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
            ab.e(str2, append.append(z).toString());
            AppMethodBeat.o(46891);
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
                ab.i("MicroMsg.WalletBulletin", "sceneid=" + optString + "; contentid=" + optString2);
                if (!(bo.isNullOrNil(optString) || bo.isNullOrNil(optString2))) {
                    hashMap.put(optString, optString2);
                    ab.i("MicroMsg.WalletBulletin", "sceneid:" + optString + " map contentid:" + optString2);
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
                    ab.i("MicroMsg.WalletBulletin", "find contentid:" + str4 + "in contentMap");
                    optJSONObject = optJSONArray2.optJSONObject(((Integer) hashMap2.get(str4)).intValue());
                    u uVar = new u();
                    uVar.field_bulletin_scene = str3;
                    uVar.field_bulletin_content = optJSONObject.optString(b.CONTENT);
                    uVar.field_bulletin_url = optJSONObject.optString("url");
                    cPM.b((c) uVar);
                } else {
                    ab.e("MicroMsg.WalletBulletin", "can not find contentid:" + str4 + "in contentMap");
                }
            }
        }
        AppMethodBeat.o(46891);
    }

    static {
        AppMethodBeat.i(46892);
        a aVar = new a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bulletin_scene";
        aVar.xDd.put("bulletin_scene", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bulletin_scene TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "bulletin_scene";
        aVar.columns[1] = "bulletin_content";
        aVar.xDd.put("bulletin_content", "TEXT");
        stringBuilder.append(" bulletin_content TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "bulletin_url";
        aVar.xDd.put("bulletin_url", "TEXT");
        stringBuilder.append(" bulletin_url TEXT");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(46892);
    }
}
