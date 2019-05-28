package com.tencent.p177mm.plugin.product.p481b;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.product.b.n */
public final class C12813n {
    public String name;
    public List<C3596a> phz = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.product.b.n$a */
    public static class C3596a {
        public String data;
        public String iconUrl;
        public String title;
        public int type;
        public String url;
    }

    public C12813n() {
        AppMethodBeat.m2504i(44007);
        AppMethodBeat.m2505o(44007);
    }

    public static List<C12813n> parse(String str) {
        AppMethodBeat.m2504i(44008);
        List<C12813n> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("group_list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C12813n c12813n = new C12813n();
                c12813n.name = jSONObject.getString("name");
                JSONArray jSONArray2 = jSONObject.getJSONArray(C8741b.ITEM_LIST);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    C3596a c3596a = new C3596a();
                    c3596a.title = jSONObject2.getString("title");
                    c3596a.type = jSONObject2.getInt("jump_type");
                    c3596a.data = jSONObject2.getString("native_url_args");
                    c3596a.iconUrl = jSONObject2.getString("icon_url");
                    c3596a.url = jSONObject2.getString("h5_url");
                    c12813n.phz.add(c3596a);
                }
                arrayList.add(c12813n);
            }
            AppMethodBeat.m2505o(44008);
            return arrayList;
        } catch (Exception e) {
            AppMethodBeat.m2505o(44008);
            return null;
        }
    }
}
