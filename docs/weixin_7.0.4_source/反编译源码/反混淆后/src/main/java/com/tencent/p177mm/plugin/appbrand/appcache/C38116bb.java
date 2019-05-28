package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.bb */
public final class C38116bb extends C10065a {
    /* renamed from: b */
    private static String m64487b(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(59546);
        String format = String.format(Locale.US, "WxaPage_%s_%d_%d_%d", new Object[]{str2, Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(str.hashCode())});
        AppMethodBeat.m2505o(59546);
        return format;
    }

    C38116bb(String str, String str2, int i, int i2) {
        super(C38116bb.m64487b(str, str2, i, i2), C2050aq.m4208xz(C38116bb.m64487b(str, str2, i, i2)), str, str2, i, i2);
        AppMethodBeat.m2504i(59547);
        AppMethodBeat.m2505o(59547);
    }
}
