package com.tencent.mm.openim.a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public List<a> geU = new LinkedList();

    public static class a {
        public List<b> geV = new LinkedList();
        public String title = "";

        public a() {
            AppMethodBeat.i(128605);
            AppMethodBeat.o(128605);
        }

        /* Access modifiers changed, original: final */
        public final a f(JSONObject jSONObject) {
            AppMethodBeat.i(128606);
            this.title = jSONObject.optString("title", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("detail");
            if (optJSONArray == null) {
                AppMethodBeat.o(128606);
            } else {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    b bVar = new b();
                    List list = this.geV;
                    bVar.cIY = jSONObject2.optString("icon");
                    bVar.desc = jSONObject2.optString("desc");
                    bVar.geW = jSONObject2.optInt("desc_type");
                    bVar.action = jSONObject2.optInt(NativeProtocol.WEB_DIALOG_ACTION);
                    bVar.geX = jSONObject2.optString("action_param");
                    list.add(bVar);
                }
                AppMethodBeat.o(128606);
            }
            return this;
        }
    }

    public static class b {
        public int action;
        public String cIY;
        String desc;
        public int geW;
        public String geX;

        public final String vk(String str) {
            AppMethodBeat.i(128607);
            String ba;
            if (this.geW == 1) {
                ba = ((b) g.K(b.class)).ba(str, this.desc);
                AppMethodBeat.o(128607);
                return ba;
            }
            ba = this.desc;
            AppMethodBeat.o(128607);
            return ba;
        }
    }

    public c() {
        AppMethodBeat.i(128608);
        AppMethodBeat.o(128608);
    }

    public final c vj(String str) {
        AppMethodBeat.i(128609);
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("custom_info");
            if (optJSONArray == null) {
                AppMethodBeat.o(128609);
                return this;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                this.geU.add(new a().f(jSONObject));
            }
            AppMethodBeat.o(128609);
            return this;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.OpenIMCustomDetail", e, "parse", new Object[0]);
        }
    }
}
