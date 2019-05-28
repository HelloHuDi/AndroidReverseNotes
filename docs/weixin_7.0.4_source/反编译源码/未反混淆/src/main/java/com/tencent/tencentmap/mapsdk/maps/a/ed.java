package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ed extends dy {
    private final cl a = new cl();

    public ed() {
        AppMethodBeat.i(98776);
        bt.j().post(new ee(this));
        AppMethodBeat.o(98776);
    }

    private static String d() {
        AppMethodBeat.i(98777);
        String str = "Halley_Cloud_Param_Content_" + bt.c() + "_for_SettingsHandler" + (bt.b() ? "_test" : "");
        AppMethodBeat.o(98777);
        return str;
    }

    public final String c() {
        return "settings";
    }

    public final void b() {
        AppMethodBeat.i(98778);
        bt.j().post(new ef(this));
        AppMethodBeat.o(98778);
    }

    public final void a(du duVar) {
        AppMethodBeat.i(98779);
        String c = this.a.c();
        duVar.a.put("confVersion", c);
        AppMethodBeat.o(98779);
    }

    public final void a(JSONObject jSONObject) {
        AppMethodBeat.i(98780);
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("Setting");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    this.a.a(optString);
                    bt.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", this.a.a()).commit();
                }
            }
            bt.j().post(new ef(this));
            AppMethodBeat.o(98780);
        } catch (Throwable th) {
            bt.j().post(new ef(this));
            AppMethodBeat.o(98780);
            throw th;
        }
    }

    static /* synthetic */ void a(ed edVar, String str) {
        AppMethodBeat.i(98782);
        bt.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", str).commit();
        AppMethodBeat.o(98782);
    }
}
