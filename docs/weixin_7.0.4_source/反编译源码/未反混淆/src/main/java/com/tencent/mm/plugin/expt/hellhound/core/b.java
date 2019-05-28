package com.tencent.mm.plugin.expt.hellhound.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.regex.Pattern;

public final class b {
    public static boolean bqo() {
        AppMethodBeat.i(73345);
        Context context = ah.getContext();
        String str = ((h) g.RM().Rn()).eHT;
        if (str == null) {
            AppMethodBeat.o(73345);
            return false;
        }
        boolean equals = context.getPackageName().equals(str);
        AppMethodBeat.o(73345);
        return equals;
    }

    public static boolean KN(String str) {
        AppMethodBeat.i(73346);
        boolean matches = Pattern.matches("^(" + "com.tencent.mm.plugin.appbrand.ui.AppBrandUI" + ")[0-9]*$", str);
        AppMethodBeat.o(73346);
        return matches;
    }
}
