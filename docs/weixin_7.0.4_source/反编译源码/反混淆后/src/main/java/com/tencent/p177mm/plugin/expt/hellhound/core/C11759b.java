package com.tencent.p177mm.plugin.expt.hellhound.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.b */
public final class C11759b {
    public static boolean bqo() {
        AppMethodBeat.m2504i(73345);
        Context context = C4996ah.getContext();
        String str = ((C6624h) C1720g.m3533RM().mo5224Rn()).eHT;
        if (str == null) {
            AppMethodBeat.m2505o(73345);
            return false;
        }
        boolean equals = context.getPackageName().equals(str);
        AppMethodBeat.m2505o(73345);
        return equals;
    }

    /* renamed from: KN */
    public static boolean m19573KN(String str) {
        AppMethodBeat.m2504i(73346);
        boolean matches = Pattern.matches("^(" + "com.tencent.mm.plugin.appbrand.ui.AppBrandUI" + ")[0-9]*$", str);
        AppMethodBeat.m2505o(73346);
        return matches;
    }
}
