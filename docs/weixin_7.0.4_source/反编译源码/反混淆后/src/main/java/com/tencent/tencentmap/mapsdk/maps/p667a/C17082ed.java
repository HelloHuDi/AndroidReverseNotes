package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ed */
public final class C17082ed extends C16219dy {
    /* renamed from: a */
    private final C31030cl f3584a = new C31030cl();

    public C17082ed() {
        AppMethodBeat.m2504i(98776);
        C46772bt.m88746j().post(new C36499ee(this));
        AppMethodBeat.m2505o(98776);
    }

    /* renamed from: d */
    private static String m26424d() {
        AppMethodBeat.m2504i(98777);
        String str = "Halley_Cloud_Param_Content_" + C46772bt.m88739c() + "_for_SettingsHandler" + (C46772bt.m88738b() ? "_test" : "");
        AppMethodBeat.m2505o(98777);
        return str;
    }

    /* renamed from: c */
    public final String mo12417c() {
        return "settings";
    }

    /* renamed from: b */
    public final void mo12421b() {
        AppMethodBeat.m2504i(98778);
        C46772bt.m88746j().post(new C36500ef(this));
        AppMethodBeat.m2505o(98778);
    }

    /* renamed from: a */
    public final void mo12415a(C41043du c41043du) {
        AppMethodBeat.m2504i(98779);
        String c = this.f3584a.mo50355c();
        c41043du.f16467a.put("confVersion", c);
        AppMethodBeat.m2505o(98779);
    }

    /* renamed from: a */
    public final void mo12416a(JSONObject jSONObject) {
        AppMethodBeat.m2504i(98780);
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("Setting");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    this.f3584a.mo50353a(optString);
                    C46772bt.m88735a().getSharedPreferences(C17082ed.m26424d(), 0).edit().putString("halley_cloud_param_content", this.f3584a.mo50351a()).commit();
                }
            }
            C46772bt.m88746j().post(new C36500ef(this));
            AppMethodBeat.m2505o(98780);
        } catch (Throwable th) {
            C46772bt.m88746j().post(new C36500ef(this));
            AppMethodBeat.m2505o(98780);
            throw th;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m26422a(C17082ed c17082ed, String str) {
        AppMethodBeat.m2504i(98782);
        C46772bt.m88735a().getSharedPreferences(C17082ed.m26424d(), 0).edit().putString("halley_cloud_param_content", str).commit();
        AppMethodBeat.m2505o(98782);
    }
}
