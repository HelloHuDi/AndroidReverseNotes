package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b.e */
public final class C39530e {
    public String cRS;
    public int fws;
    /* renamed from: id */
    public String f16178id;
    public String key;
    public String name;
    public List<C39530e> pqE;
    public int type;
    public String value;

    /* renamed from: ai */
    public static C39530e m67547ai(JSONObject jSONObject) {
        AppMethodBeat.m2504i(23948);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.ServiceInfo", "json is null, err");
            AppMethodBeat.m2505o(23948);
            return null;
        }
        C39530e c39530e = new C39530e();
        try {
            c39530e.f16178id = jSONObject.optString("id", "");
            c39530e.type = jSONObject.optInt("type");
            c39530e.name = jSONObject.optString("name");
            c39530e.key = jSONObject.optString("key");
            c39530e.value = jSONObject.optString("value");
            c39530e.fws = jSONObject.optInt("acttype", -1);
            c39530e.cRS = jSONObject.optString("native_url");
            c39530e.pqE = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("sub_button_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C39530e ai = C39530e.m67547ai(optJSONArray.optJSONObject(i));
                    if (ai != null) {
                        c39530e.pqE.add(ai);
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7408b("MicroMsg.ServiceInfo", "", e);
        }
        AppMethodBeat.m2505o(23948);
        return c39530e;
    }
}
