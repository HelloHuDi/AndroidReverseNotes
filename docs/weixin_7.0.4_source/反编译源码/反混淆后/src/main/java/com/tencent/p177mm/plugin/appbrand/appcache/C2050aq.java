package com.tencent.p177mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.tencent.mm.plugin.appbrand.appcache.aq */
public class C2050aq extends C10065a {
    /* renamed from: aq */
    public static String m4207aq(String str, int i) {
        AppMethodBeat.m2504i(59510);
        String str2 = C10072ap.avY() + String.format("_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i)});
        AppMethodBeat.m2505o(59510);
        return str2;
    }

    /* renamed from: xz */
    static String m4208xz(String str) {
        AppMethodBeat.m2504i(59511);
        String str2 = C10072ap.avY() + String.format("_%s.wxapkg", new Object[]{str});
        AppMethodBeat.m2505o(59511);
        return str2;
    }

    C2050aq(String str, int i, int i2, String str2) {
        this(String.format("WxaPkg_%s_%d", new Object[]{str, Integer.valueOf(i2)}), C2050aq.m4207aq(str, i2), str2, str, i2, i);
        AppMethodBeat.m2504i(59512);
        AppMethodBeat.m2505o(59512);
    }

    private C2050aq(String str, String str2, String str3, String str4, int i, int i2) {
        super(str, str2, str3, str4, i, i2);
    }
}
