package com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C32601ne;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.d */
public final class C19463d {
    public static final String hSQ = (C6457e.eSi + "files/wxofflinevoice/");
    private static C19463d hSS;
    private Set<String> hSR;
    private Object lock = new Object();

    public C19463d() {
        AppMethodBeat.m2504i(131375);
        AppMethodBeat.m2505o(131375);
    }

    static {
        AppMethodBeat.m2504i(131382);
        AppMethodBeat.m2505o(131382);
    }

    /* renamed from: cn */
    public final boolean mo34592cn(String str, String str2) {
        boolean z;
        AppMethodBeat.m2504i(131376);
        synchronized (this.lock) {
            try {
                if (this.hSR == null) {
                    this.hSR = new HashSet();
                    String str3 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, (Object) "");
                    if (!C5046bo.isNullOrNil(str3)) {
                        for (Object add : str3.split(",")) {
                            this.hSR.add(add);
                        }
                    }
                }
                C5018as.amF("voice_offline_res").edit().putString(str, str2);
                if (this.hSR.contains(str)) {
                    z = true;
                    AppMethodBeat.m2505o(131376);
                } else {
                    StringBuilder stringBuilder = new StringBuilder((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, (Object) ""));
                    if (this.hSR.size() <= 0) {
                        stringBuilder.append(str);
                    } else {
                        stringBuilder.append(",").append(str);
                    }
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, stringBuilder.toString());
                    z = this.hSR.add(str);
                }
            } finally {
                AppMethodBeat.m2505o(131376);
            }
        }
        return z;
    }

    public static String aED() {
        AppMethodBeat.m2504i(131377);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_VOICE_OFFLINE_RES_IDS_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(131377);
        return str;
    }

    /* renamed from: BG */
    public static void m30137BG(String str) {
        AppMethodBeat.m2504i(131378);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, (Object) str);
        C4879a.xxA.mo10055m(new C32601ne());
        AppMethodBeat.m2505o(131378);
    }

    public static String aEE() {
        AppMethodBeat.m2504i(131380);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.m2505o(131380);
        return str;
    }

    public static C19463d aEF() {
        AppMethodBeat.m2504i(131381);
        if (hSS == null) {
            hSS = new C19463d();
        }
        C19463d c19463d = hSS;
        AppMethodBeat.m2505o(131381);
        return c19463d;
    }

    /* renamed from: BH */
    public static String m30138BH(String str) {
        AppMethodBeat.m2504i(131379);
        String string = C5018as.amF("voice_offline_res").getString(str, "");
        AppMethodBeat.m2505o(131379);
        return string;
    }
}
