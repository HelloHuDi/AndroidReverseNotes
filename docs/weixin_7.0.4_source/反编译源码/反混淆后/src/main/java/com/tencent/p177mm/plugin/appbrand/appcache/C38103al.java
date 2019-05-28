package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.al */
final class C38103al extends C10065a {
    final int gTP;
    final int gTQ;
    final C2057a gTR;

    /* renamed from: t */
    static String m64444t(String str, int i, int i2) {
        AppMethodBeat.m2504i(59477);
        String format = String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        AppMethodBeat.m2505o(59477);
        return format;
    }

    C38103al(String str, int i, int i2, String str2, C2057a c2057a) {
        boolean z = false;
        String t = C38103al.m64444t(str, i, i2);
        String str3 = C10072ap.avY() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        super(t, str3, str2, str, 0, i2);
        AppMethodBeat.m2504i(59478);
        this.gTP = i;
        this.gTQ = i2;
        this.gTR = c2057a;
        if (!"@LibraryAppId".equals(str)) {
            z = true;
        }
        this.gVz = z;
        AppMethodBeat.m2505o(59478);
    }

    public final String avR() {
        AppMethodBeat.m2504i(59479);
        String aq = C2050aq.m4207aq(this.appId, this.gTQ);
        AppMethodBeat.m2505o(59479);
        return aq;
    }
}
