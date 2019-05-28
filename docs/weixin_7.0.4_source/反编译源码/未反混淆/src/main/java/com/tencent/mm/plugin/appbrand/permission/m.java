package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.i;
import java.util.Arrays;
import java.util.List;

public final class m {
    private static final List<String> ixd = Arrays.asList(new String[]{"scope.userLocation"});

    static {
        AppMethodBeat.i(102310);
        AppMethodBeat.o(102310);
    }

    public static boolean a(String str, h hVar) {
        AppMethodBeat.i(102308);
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
                    boolean z2 = hVar.hgZ;
                    AppMethodBeat.o(102308);
                    return z2;
                default:
                    AppMethodBeat.o(102308);
                    return false;
            }
        }
        AppMethodBeat.o(102308);
        return false;
    }

    public static String a(String str, i iVar) {
        AppMethodBeat.i(102309);
        e yS = iVar.getAppConfig().yS(str);
        if (yS == null) {
            AppMethodBeat.o(102309);
            return null;
        }
        String str2 = yS.desc;
        AppMethodBeat.o(102309);
        return str2;
    }
}
