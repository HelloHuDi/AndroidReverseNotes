package com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.p890a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.C45542b;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b */
public final class C26860b implements C42421e<String> {
    private String hnX;

    /* renamed from: bs */
    public final /* bridge */ /* synthetic */ void mo21616bs(Object obj) {
        this.hnX = (String) obj;
    }

    /* renamed from: a */
    public final void mo21614a(C45542b c45542b) {
        AppMethodBeat.m2504i(10892);
        c45542b.run();
        AppMethodBeat.m2505o(10892);
    }

    /* renamed from: Ai */
    public final boolean mo21612Ai(String str) {
        AppMethodBeat.m2504i(10893);
        if (this.hnX == null) {
            AppMethodBeat.m2505o(10893);
            return true;
        } else if (TextUtils.isEmpty(str) || str.hashCode() == this.hnX.hashCode()) {
            AppMethodBeat.m2505o(10893);
            return false;
        } else {
            AppMethodBeat.m2505o(10893);
            return true;
        }
    }

    public final void reset() {
        this.hnX = null;
    }

    public final int azV() {
        return 1;
    }

    /* renamed from: F */
    public final void mo21613F(Runnable runnable) {
        AppMethodBeat.m2504i(10894);
        runnable.run();
        AppMethodBeat.m2505o(10894);
    }

    public final void azU() {
    }

    /* renamed from: d */
    public final /* synthetic */ Object mo21618d(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(10895);
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.m2505o(10895);
        return jSONObject2;
    }
}
