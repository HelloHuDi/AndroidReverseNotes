package com.tencent.p177mm.plugin.appbrand.p893e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.e.d */
public final class C45551d {
    /* renamed from: bc */
    public static String m84007bc(String str, int i) {
        AppMethodBeat.m2504i(117339);
        String format = String.format(Locale.US, "%s#%d", new Object[]{str, Integer.valueOf(i)});
        AppMethodBeat.m2505o(117339);
        return format;
    }

    /* renamed from: a */
    public static void m84004a(boolean z, JSONObject jSONObject) {
        AppMethodBeat.m2504i(117340);
        C45551d.m84005b(jSONObject, "useXWebVideo", Boolean.valueOf(z));
        C45551d.m84005b(jSONObject, "XWebVideoMinVersion", Integer.valueOf(300));
        AppMethodBeat.m2505o(117340);
    }

    /* renamed from: b */
    public static void m84006b(boolean z, JSONObject jSONObject) {
        AppMethodBeat.m2504i(117341);
        C45551d.m84005b(jSONObject, "useXWebMap", Boolean.valueOf(z));
        AppMethodBeat.m2505o(117341);
    }

    /* renamed from: b */
    private static void m84005b(JSONObject jSONObject, String str, Object obj) {
        AppMethodBeat.m2504i(117342);
        try {
            jSONObject.put(str, obj);
            AppMethodBeat.m2505o(117342);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginUtil", "build json object fail", e);
            AppMethodBeat.m2505o(117342);
        }
    }
}
