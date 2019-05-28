package com.tencent.p177mm.plugin.appbrand.p904k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.protocal.protobuf.btd;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.k.a */
public final class C42597a {
    /* renamed from: a */
    public static boolean m75414a(int i, int i2, btd btd) {
        return i == 0 && i2 == 0 && btd != null;
    }

    /* renamed from: b */
    public static boolean m75415b(C37441a<?> c37441a) {
        AppMethodBeat.m2504i(132307);
        if (c37441a == null || !C42597a.m75414a(c37441a.errType, c37441a.errCode, c37441a.fsy)) {
            AppMethodBeat.m2505o(132307);
            return false;
        }
        AppMethodBeat.m2505o(132307);
        return true;
    }

    /* renamed from: c */
    public static String m75416c(C37441a c37441a) {
        AppMethodBeat.m2504i(132308);
        String str;
        if (c37441a == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(132308);
            return str;
        }
        str = String.format(Locale.US, "%d %d %s", new Object[]{Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm});
        AppMethodBeat.m2505o(132308);
        return str;
    }
}
