package com.tencent.p177mm.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.model.bn */
public final class C45438bn {
    public static C45438bn fnk = new C45438bn();
    private SharedPreferences fnl = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_register_history", 0);

    static {
        AppMethodBeat.m2504i(58117);
        AppMethodBeat.m2505o(58117);
    }

    private C45438bn() {
        AppMethodBeat.m2504i(58114);
        AppMethodBeat.m2505o(58114);
    }

    /* renamed from: g */
    public final void mo73242g(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(58115);
        try {
            if (map.isEmpty()) {
                C4990ab.m7416i("MicroMsg.RegisterAccountInfo", "kv map is null or empty!");
                AppMethodBeat.m2505o(58115);
                return;
            }
            JSONObject jSONObject;
            if (this.fnl.contains(str)) {
                String string = this.fnl.getString(str, "");
                if (C5046bo.isNullOrNil(string)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(new String(Base64.decode(string, 0)));
                }
            } else {
                jSONObject = new JSONObject();
            }
            for (String str2 : map.keySet()) {
                jSONObject.put(str2, map.get(str2));
            }
            C4990ab.m7417i("MicroMsg.RegisterAccountInfo", "put json str %s", jSONObject.toString());
            this.fnl.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
            AppMethodBeat.m2505o(58115);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RegisterAccountInfo", "save account info about %s failed, error: %s", str, e.getMessage());
            AppMethodBeat.m2505o(58115);
        }
    }

    public final String getString(String str, String str2) {
        String string;
        AppMethodBeat.m2504i(58116);
        try {
            C4990ab.m7417i("MicroMsg.RegisterAccountInfo", "get %s, %s", str, str2);
            if (this.fnl.contains(str)) {
                String str3 = new String(Base64.decode(this.fnl.getString(str, ""), 0));
                if (!C5046bo.isNullOrNil(str3)) {
                    C4990ab.m7417i("MicroMsg.RegisterAccountInfo", "get json str %s", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.has(str2)) {
                        string = jSONObject.getString(str2);
                        AppMethodBeat.m2505o(58116);
                        return string;
                    }
                }
            }
            C4990ab.m7421w("MicroMsg.RegisterAccountInfo", "register info about %s is not found!", str);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RegisterAccountInfo", "get register info %s about %s failed, error: %s", str2, str, e.getMessage());
        }
        string = "";
        AppMethodBeat.m2505o(58116);
        return string;
    }
}
