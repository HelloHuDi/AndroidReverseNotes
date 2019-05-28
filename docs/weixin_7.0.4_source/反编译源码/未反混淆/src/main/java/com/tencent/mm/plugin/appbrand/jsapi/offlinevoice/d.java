package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.HashSet;
import java.util.Set;

public final class d {
    public static final String hSQ = (e.eSi + "files/wxofflinevoice/");
    private static d hSS;
    private Set<String> hSR;
    private Object lock = new Object();

    public d() {
        AppMethodBeat.i(131375);
        AppMethodBeat.o(131375);
    }

    static {
        AppMethodBeat.i(131382);
        AppMethodBeat.o(131382);
    }

    public final boolean cn(String str, String str2) {
        boolean z;
        AppMethodBeat.i(131376);
        synchronized (this.lock) {
            try {
                if (this.hSR == null) {
                    this.hSR = new HashSet();
                    String str3 = (String) g.RP().Ry().get(a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, (Object) "");
                    if (!bo.isNullOrNil(str3)) {
                        for (Object add : str3.split(",")) {
                            this.hSR.add(add);
                        }
                    }
                }
                as.amF("voice_offline_res").edit().putString(str, str2);
                if (this.hSR.contains(str)) {
                    z = true;
                    AppMethodBeat.o(131376);
                } else {
                    StringBuilder stringBuilder = new StringBuilder((String) g.RP().Ry().get(a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, (Object) ""));
                    if (this.hSR.size() <= 0) {
                        stringBuilder.append(str);
                    } else {
                        stringBuilder.append(",").append(str);
                    }
                    g.RP().Ry().set(a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, stringBuilder.toString());
                    z = this.hSR.add(str);
                }
            } finally {
                AppMethodBeat.o(131376);
            }
        }
        return z;
    }

    public static String aED() {
        AppMethodBeat.i(131377);
        String str = (String) g.RP().Ry().get(a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, (Object) "");
        AppMethodBeat.o(131377);
        return str;
    }

    public static void BG(String str) {
        AppMethodBeat.i(131378);
        g.RP().Ry().set(a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, (Object) str);
        com.tencent.mm.sdk.b.a.xxA.m(new ne());
        AppMethodBeat.o(131378);
    }

    public static String aEE() {
        AppMethodBeat.i(131380);
        String str = (String) g.RP().Ry().get(a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(131380);
        return str;
    }

    public static d aEF() {
        AppMethodBeat.i(131381);
        if (hSS == null) {
            hSS = new d();
        }
        d dVar = hSS;
        AppMethodBeat.o(131381);
        return dVar;
    }

    public static String BH(String str) {
        AppMethodBeat.i(131379);
        String string = as.amF("voice_offline_res").getString(str, "");
        AppMethodBeat.o(131379);
        return string;
    }
}
