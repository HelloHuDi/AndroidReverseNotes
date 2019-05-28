package com.tencent.p177mm.splash;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.splash.g */
public final class C5108g {
    /* renamed from: wY */
    public static final boolean f1294wY = C5108g.m7761F(System.getProperty("java.vm.version"));

    static {
        AppMethodBeat.m2504i(114827);
        AppMethodBeat.m2505o(114827);
    }

    /* renamed from: F */
    private static boolean m7761F(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(114826);
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        C4990ab.m7416i("MicroMsg.MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        AppMethodBeat.m2505o(114826);
        return z;
    }
}
