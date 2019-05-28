package com.tencent.mm.plugin.appbrand.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

public enum f implements n {
    ;

    private f(String str) {
    }

    static {
        AppMethodBeat.o(132305);
    }

    public final b a(String str, Map<String, String> map, a aVar) {
        AppMethodBeat.i(132302);
        if ("WeAppPushCommand".equals(str)) {
            String str2 = ".sysmsg.WeAppPushCommand.weapp";
            String str3 = str2;
            int i = 0;
            while (true) {
                Object obj;
                String str4 = (String) map.get(str3 + ".$cmdtype");
                String str5 = (String) map.get(str3 + ".$appid");
                str3 = (String) map.get(str3 + ".expireSeconds");
                if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5) || TextUtils.isEmpty(str3) || !TextUtils.isDigitsOnly(str3)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    obj = -1;
                    switch (str4.hashCode()) {
                        case -505130726:
                            if (str4.equals("copypath")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            com.tencent.mm.plugin.appbrand.app.f.xH().bG(cG(str5, "copypath"), String.valueOf((Long.valueOf(str3).longValue() * 1000) + System.currentTimeMillis()));
                            break;
                    }
                }
                ab.i("MicroMsg.WxaWeAppPushCommandMgr", "[consumeNewXml] index = %d, appId =%s, cmdType=%s, expireSeconds = %s", Integer.valueOf(i), str5, str4, str3);
                int i2 = i + 1;
                if (i2 == 0) {
                    str4 = str2;
                } else {
                    str4 = str2 + i2;
                }
                if (map.containsKey(str4)) {
                    str3 = str4;
                    i = i2;
                }
            }
        }
        AppMethodBeat.o(132302);
        return null;
    }

    public static Long cF(String str, String str2) {
        AppMethodBeat.i(132303);
        String str3 = com.tencent.mm.plugin.appbrand.app.f.xH().get(cG(str, str2), "");
        if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(132303);
            return null;
        }
        if (Long.valueOf(str3).longValue() < System.currentTimeMillis()) {
            com.tencent.mm.plugin.appbrand.app.f.xH().pI(cG(str, str2));
            ab.i("MicroMsg.WxaWeAppPushCommandMgr", "delete data app id=".concat(String.valueOf(str)));
        }
        Long valueOf = Long.valueOf(str3);
        AppMethodBeat.o(132303);
        return valueOf;
    }

    private static String cG(String str, String str2) {
        AppMethodBeat.i(132304);
        String str3 = str + "#WxaWeAppPushCommandMgr#" + str2;
        AppMethodBeat.o(132304);
        return str3;
    }
}
