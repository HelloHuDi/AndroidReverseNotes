package com.tencent.p177mm.openim.p1210a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.openim.a.c */
public final class C32875c {
    public List<C18734a> geU = new LinkedList();

    /* renamed from: com.tencent.mm.openim.a.c$a */
    public static class C18734a {
        public List<C26514b> geV = new LinkedList();
        public String title = "";

        public C18734a() {
            AppMethodBeat.m2504i(128605);
            AppMethodBeat.m2505o(128605);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: f */
        public final C18734a mo33999f(JSONObject jSONObject) {
            AppMethodBeat.m2504i(128606);
            this.title = jSONObject.optString("title", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("detail");
            if (optJSONArray == null) {
                AppMethodBeat.m2505o(128606);
            } else {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    C26514b c26514b = new C26514b();
                    List list = this.geV;
                    c26514b.cIY = jSONObject2.optString("icon");
                    c26514b.desc = jSONObject2.optString("desc");
                    c26514b.geW = jSONObject2.optInt("desc_type");
                    c26514b.action = jSONObject2.optInt(NativeProtocol.WEB_DIALOG_ACTION);
                    c26514b.geX = jSONObject2.optString("action_param");
                    list.add(c26514b);
                }
                AppMethodBeat.m2505o(128606);
            }
            return this;
        }
    }

    /* renamed from: com.tencent.mm.openim.a.c$b */
    public static class C26514b {
        public int action;
        public String cIY;
        String desc;
        public int geW;
        public String geX;

        /* renamed from: vk */
        public final String mo44297vk(String str) {
            AppMethodBeat.m2504i(128607);
            String ba;
            if (this.geW == 1) {
                ba = ((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(str, this.desc);
                AppMethodBeat.m2505o(128607);
                return ba;
            }
            ba = this.desc;
            AppMethodBeat.m2505o(128607);
            return ba;
        }
    }

    public C32875c() {
        AppMethodBeat.m2504i(128608);
        AppMethodBeat.m2505o(128608);
    }

    /* renamed from: vj */
    public final C32875c mo53440vj(String str) {
        AppMethodBeat.m2504i(128609);
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("custom_info");
            if (optJSONArray == null) {
                AppMethodBeat.m2505o(128609);
                return this;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                this.geU.add(new C18734a().mo33999f(jSONObject));
            }
            AppMethodBeat.m2505o(128609);
            return this;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.OpenIMCustomDetail", e, "parse", new Object[0]);
        }
    }
}
