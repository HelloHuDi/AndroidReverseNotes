package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public String cRS;
    public int fws;
    public String id;
    public String key;
    public String name;
    public List<e> pqE;
    public int type;
    public String value;

    public static e ai(JSONObject jSONObject) {
        AppMethodBeat.i(23948);
        if (jSONObject == null) {
            ab.e("MicroMsg.ServiceInfo", "json is null, err");
            AppMethodBeat.o(23948);
            return null;
        }
        e eVar = new e();
        try {
            eVar.id = jSONObject.optString("id", "");
            eVar.type = jSONObject.optInt("type");
            eVar.name = jSONObject.optString("name");
            eVar.key = jSONObject.optString("key");
            eVar.value = jSONObject.optString("value");
            eVar.fws = jSONObject.optInt("acttype", -1);
            eVar.cRS = jSONObject.optString("native_url");
            eVar.pqE = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("sub_button_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    e ai = ai(optJSONArray.optJSONObject(i));
                    if (ai != null) {
                        eVar.pqE.add(ai);
                    }
                }
            }
        } catch (Exception e) {
            ab.b("MicroMsg.ServiceInfo", "", e);
        }
        AppMethodBeat.o(23948);
        return eVar;
    }
}
