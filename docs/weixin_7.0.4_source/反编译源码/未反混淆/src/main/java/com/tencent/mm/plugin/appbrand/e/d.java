package com.tencent.mm.plugin.appbrand.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Locale;
import org.json.JSONObject;

public final class d {
    public static String bc(String str, int i) {
        AppMethodBeat.i(117339);
        String format = String.format(Locale.US, "%s#%d", new Object[]{str, Integer.valueOf(i)});
        AppMethodBeat.o(117339);
        return format;
    }

    public static void a(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(117340);
        b(jSONObject, "useXWebVideo", Boolean.valueOf(z));
        b(jSONObject, "XWebVideoMinVersion", Integer.valueOf(300));
        AppMethodBeat.o(117340);
    }

    public static void b(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(117341);
        b(jSONObject, "useXWebMap", Boolean.valueOf(z));
        AppMethodBeat.o(117341);
    }

    private static void b(JSONObject jSONObject, String str, Object obj) {
        AppMethodBeat.i(117342);
        try {
            jSONObject.put(str, obj);
            AppMethodBeat.o(117342);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginUtil", "build json object fail", e);
            AppMethodBeat.o(117342);
        }
    }
}
