package com.tencent.p177mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.config.C38163a.C19155e;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.m */
public final class C19662m {
    private static final List<String> ixd = Arrays.asList(new String[]{"scope.userLocation"});

    static {
        AppMethodBeat.m2504i(102310);
        AppMethodBeat.m2505o(102310);
    }

    /* renamed from: a */
    public static boolean m30459a(String str, C16597h c16597h) {
        AppMethodBeat.m2504i(102308);
        if (ixd.contains(str)) {
            boolean z = true;
            switch (str.hashCode()) {
                case -653473286:
                    if (str.equals("scope.userLocation")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    boolean z2 = c16597h.hgZ;
                    AppMethodBeat.m2505o(102308);
                    return z2;
                default:
                    AppMethodBeat.m2505o(102308);
                    return false;
            }
        }
        AppMethodBeat.m2505o(102308);
        return false;
    }

    /* renamed from: a */
    public static String m30458a(String str, C6750i c6750i) {
        AppMethodBeat.m2504i(102309);
        C19155e yS = c6750i.getAppConfig().mo60904yS(str);
        if (yS == null) {
            AppMethodBeat.m2505o(102309);
            return null;
        }
        String str2 = yS.desc;
        AppMethodBeat.m2505o(102309);
        return str2;
    }
}
