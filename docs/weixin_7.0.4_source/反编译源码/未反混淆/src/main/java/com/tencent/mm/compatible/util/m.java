package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ab;

public final class m {
    public static boolean Mx() {
        AppMethodBeat.i(93106);
        String str = ab.get("ro.mediatek.platform");
        if (str == null || !(str.startsWith("MT") || str.startsWith("mt"))) {
            AppMethodBeat.o(93106);
            return false;
        }
        AppMethodBeat.o(93106);
        return true;
    }
}
