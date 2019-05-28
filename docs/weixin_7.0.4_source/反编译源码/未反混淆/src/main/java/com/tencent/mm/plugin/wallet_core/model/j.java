package com.tencent.mm.plugin.wallet_core.model;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    public String content;
    public String title;
    public String tzh;
    public List<a> tzi;

    public static class a {
        public int id;
        public ShowInfo tzj;

        public static a az(JSONObject jSONObject) {
            AppMethodBeat.i(46764);
            if (jSONObject == null) {
                AppMethodBeat.o(46764);
                return null;
            }
            a aVar = new a();
            aVar.id = jSONObject.optInt("id");
            JSONObject optJSONObject = jSONObject.optJSONObject("show_info");
            if (optJSONObject != null) {
                ShowInfo showInfo = new ShowInfo();
                showInfo.name = optJSONObject.optString("name");
                showInfo.value = optJSONObject.optString("value");
                showInfo.tBK = optJSONObject.optInt("value_attr");
                showInfo.mVA = optJSONObject.optString("name_color");
                showInfo.tBF = optJSONObject.optString("value_color");
                aVar.tzj = showInfo;
            }
            AppMethodBeat.o(46764);
            return aVar;
        }
    }

    public static j ay(JSONObject jSONObject) {
        AppMethodBeat.i(46765);
        if (jSONObject == null) {
            AppMethodBeat.o(46765);
            return null;
        }
        j jVar = new j();
        jVar.title = jSONObject.optString("title");
        jVar.content = jSONObject.optString(b.CONTENT);
        jVar.tzh = jSONObject.optString("content_not_enough");
        jVar.tzi = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("show_infos");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                a az = a.az(optJSONArray.optJSONObject(i));
                if (az != null) {
                    jVar.tzi.add(az);
                }
            }
        }
        AppMethodBeat.o(46765);
        return jVar;
    }
}
