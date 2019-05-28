package com.tencent.p177mm.plugin.appbrand.p896i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3472n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.i.f */
public enum C45567f implements C3472n {
    ;

    private C45567f(String str) {
    }

    static {
        AppMethodBeat.m2505o(132305);
    }

    /* renamed from: a */
    public final C1198b mo7932a(String str, Map<String, String> map, C1197a c1197a) {
        AppMethodBeat.m2504i(132302);
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
                            C42340f.m74880xH().mo53682bG(C45567f.m84063cG(str5, "copypath"), String.valueOf((Long.valueOf(str3).longValue() * 1000) + System.currentTimeMillis()));
                            break;
                    }
                }
                C4990ab.m7417i("MicroMsg.WxaWeAppPushCommandMgr", "[consumeNewXml] index = %d, appId =%s, cmdType=%s, expireSeconds = %s", Integer.valueOf(i), str5, str4, str3);
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
        AppMethodBeat.m2505o(132302);
        return null;
    }

    /* renamed from: cF */
    public static Long m84062cF(String str, String str2) {
        AppMethodBeat.m2504i(132303);
        String str3 = C42340f.m74880xH().get(C45567f.m84063cG(str, str2), "");
        if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.m2505o(132303);
            return null;
        }
        if (Long.valueOf(str3).longValue() < System.currentTimeMillis()) {
            C42340f.m74880xH().mo53684pI(C45567f.m84063cG(str, str2));
            C4990ab.m7416i("MicroMsg.WxaWeAppPushCommandMgr", "delete data app id=".concat(String.valueOf(str)));
        }
        Long valueOf = Long.valueOf(str3);
        AppMethodBeat.m2505o(132303);
        return valueOf;
    }

    /* renamed from: cG */
    private static String m84063cG(String str, String str2) {
        AppMethodBeat.m2504i(132304);
        String str3 = str + "#WxaWeAppPushCommandMgr#" + str2;
        AppMethodBeat.m2505o(132304);
        return str3;
    }
}
