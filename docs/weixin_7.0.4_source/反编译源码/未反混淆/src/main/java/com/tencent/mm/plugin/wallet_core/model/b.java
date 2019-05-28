package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public double pPt = 0.0d;
    public int tgO = 0;
    public int tgP = 0;
    public int tgQ = 0;
    public double tgR = 0.0d;
    public String twA;
    public a twB;
    public String twx;
    public LinkedList<b> twy;
    public String twz;

    public static class b {
        public String key;
        public String value;
    }

    public static class a {
        public String twC = "";
        public c[] twD = new c[0];

        public a() {
            AppMethodBeat.i(46700);
            AppMethodBeat.o(46700);
        }
    }

    public static class c {
        public String desc;
        public String kbV;
        public String kdF;
        public String title;
        public int ttd;
    }

    public static a aq(JSONObject jSONObject) {
        AppMethodBeat.i(46701);
        a aVar = new a();
        if (jSONObject != null) {
            try {
                aVar.twC = jSONObject.optString("sector_title", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("label");
                if (optJSONArray != null) {
                    aVar.twD = new c[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        c cVar = new c();
                        cVar.title = jSONObject2.optString("title", "");
                        cVar.desc = jSONObject2.optString("desc", "");
                        cVar.kbV = jSONObject2.optString("logo_url", "");
                        cVar.ttd = jSONObject2.optInt("jump_type");
                        cVar.kdF = jSONObject2.optString("jump_url", "");
                        aVar.twD[i] = cVar;
                    }
                }
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.o(46701);
        return aVar;
    }
}
