package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class b implements e<String> {
    private String hnX;

    public final /* bridge */ /* synthetic */ void bs(Object obj) {
        this.hnX = (String) obj;
    }

    public final void a(com.tencent.mm.plugin.appbrand.dynamic.d.b.b bVar) {
        AppMethodBeat.i(10892);
        bVar.run();
        AppMethodBeat.o(10892);
    }

    public final boolean Ai(String str) {
        AppMethodBeat.i(10893);
        if (this.hnX == null) {
            AppMethodBeat.o(10893);
            return true;
        } else if (TextUtils.isEmpty(str) || str.hashCode() == this.hnX.hashCode()) {
            AppMethodBeat.o(10893);
            return false;
        } else {
            AppMethodBeat.o(10893);
            return true;
        }
    }

    public final void reset() {
        this.hnX = null;
    }

    public final int azV() {
        return 1;
    }

    public final void F(Runnable runnable) {
        AppMethodBeat.i(10894);
        runnable.run();
        AppMethodBeat.o(10894);
    }

    public final void azU() {
    }

    public final /* synthetic */ Object d(JSONObject jSONObject, String str) {
        AppMethodBeat.i(10895);
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(10895);
        return jSONObject2;
    }
}
