package com.tencent.p177mm.plugin.wallet_core.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.ShowInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.j */
public final class C29631j {
    public String content;
    public String title;
    public String tzh;
    public List<C29632a> tzi;

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.j$a */
    public static class C29632a {
        /* renamed from: id */
        public int f13717id;
        public ShowInfo tzj;

        /* renamed from: az */
        public static C29632a m47000az(JSONObject jSONObject) {
            AppMethodBeat.m2504i(46764);
            if (jSONObject == null) {
                AppMethodBeat.m2505o(46764);
                return null;
            }
            C29632a c29632a = new C29632a();
            c29632a.f13717id = jSONObject.optInt("id");
            JSONObject optJSONObject = jSONObject.optJSONObject("show_info");
            if (optJSONObject != null) {
                ShowInfo showInfo = new ShowInfo();
                showInfo.name = optJSONObject.optString("name");
                showInfo.value = optJSONObject.optString("value");
                showInfo.tBK = optJSONObject.optInt("value_attr");
                showInfo.mVA = optJSONObject.optString("name_color");
                showInfo.tBF = optJSONObject.optString("value_color");
                c29632a.tzj = showInfo;
            }
            AppMethodBeat.m2505o(46764);
            return c29632a;
        }
    }

    /* renamed from: ay */
    public static C29631j m46999ay(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46765);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(46765);
            return null;
        }
        C29631j c29631j = new C29631j();
        c29631j.title = jSONObject.optString("title");
        c29631j.content = jSONObject.optString(C8741b.CONTENT);
        c29631j.tzh = jSONObject.optString("content_not_enough");
        c29631j.tzi = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("show_infos");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                C29632a az = C29632a.m47000az(optJSONArray.optJSONObject(i));
                if (az != null) {
                    c29631j.tzi.add(az);
                }
            }
        }
        AppMethodBeat.m2505o(46765);
        return c29631j;
    }
}
