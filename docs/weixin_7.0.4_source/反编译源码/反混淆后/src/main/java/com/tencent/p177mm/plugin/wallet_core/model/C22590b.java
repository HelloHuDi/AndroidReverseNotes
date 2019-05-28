package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.b */
public final class C22590b {
    public double pPt = 0.0d;
    public int tgO = 0;
    public int tgP = 0;
    public int tgQ = 0;
    public double tgR = 0.0d;
    public String twA;
    public C14234a twB;
    public String twx;
    public LinkedList<C4393b> twy;
    public String twz;

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.b$b */
    public static class C4393b {
        public String key;
        public String value;
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.b$a */
    public static class C14234a {
        public String twC = "";
        public C14235c[] twD = new C14235c[0];

        public C14234a() {
            AppMethodBeat.m2504i(46700);
            AppMethodBeat.m2505o(46700);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.b$c */
    public static class C14235c {
        public String desc;
        public String kbV;
        public String kdF;
        public String title;
        public int ttd;
    }

    /* renamed from: aq */
    public static C14234a m34291aq(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46701);
        C14234a c14234a = new C14234a();
        if (jSONObject != null) {
            try {
                c14234a.twC = jSONObject.optString("sector_title", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("label");
                if (optJSONArray != null) {
                    c14234a.twD = new C14235c[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        C14235c c14235c = new C14235c();
                        c14235c.title = jSONObject2.optString("title", "");
                        c14235c.desc = jSONObject2.optString("desc", "");
                        c14235c.kbV = jSONObject2.optString("logo_url", "");
                        c14235c.ttd = jSONObject2.optInt("jump_type");
                        c14235c.kdF = jSONObject2.optString("jump_url", "");
                        c14234a.twD[i] = c14235c;
                    }
                }
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.m2505o(46701);
        return c14234a;
    }
}
