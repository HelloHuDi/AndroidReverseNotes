package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONObject;

public final class bn {
    public static bn fnk = new bn();
    private SharedPreferences fnl = ah.getContext().getSharedPreferences(ah.doA() + "_register_history", 0);

    static {
        AppMethodBeat.i(58117);
        AppMethodBeat.o(58117);
    }

    private bn() {
        AppMethodBeat.i(58114);
        AppMethodBeat.o(58114);
    }

    public final void g(String str, Map<String, String> map) {
        AppMethodBeat.i(58115);
        try {
            if (map.isEmpty()) {
                ab.i("MicroMsg.RegisterAccountInfo", "kv map is null or empty!");
                AppMethodBeat.o(58115);
                return;
            }
            JSONObject jSONObject;
            if (this.fnl.contains(str)) {
                String string = this.fnl.getString(str, "");
                if (bo.isNullOrNil(string)) {
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
            ab.i("MicroMsg.RegisterAccountInfo", "put json str %s", jSONObject.toString());
            this.fnl.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
            AppMethodBeat.o(58115);
        } catch (Exception e) {
            ab.e("MicroMsg.RegisterAccountInfo", "save account info about %s failed, error: %s", str, e.getMessage());
            AppMethodBeat.o(58115);
        }
    }

    public final String getString(String str, String str2) {
        String string;
        AppMethodBeat.i(58116);
        try {
            ab.i("MicroMsg.RegisterAccountInfo", "get %s, %s", str, str2);
            if (this.fnl.contains(str)) {
                String str3 = new String(Base64.decode(this.fnl.getString(str, ""), 0));
                if (!bo.isNullOrNil(str3)) {
                    ab.i("MicroMsg.RegisterAccountInfo", "get json str %s", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.has(str2)) {
                        string = jSONObject.getString(str2);
                        AppMethodBeat.o(58116);
                        return string;
                    }
                }
            }
            ab.w("MicroMsg.RegisterAccountInfo", "register info about %s is not found!", str);
        } catch (Exception e) {
            ab.e("MicroMsg.RegisterAccountInfo", "get register info %s about %s failed, error: %s", str2, str, e.getMessage());
        }
        string = "";
        AppMethodBeat.o(58116);
        return string;
    }
}
