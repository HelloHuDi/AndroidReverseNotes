package com.tencent.mm.ui.e.b;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private static b zxp = null;

    public static void a(b bVar) {
        zxp = bVar;
    }

    public static Drawable io(String str, String str2) {
        AppMethodBeat.i(107322);
        if (zxp != null) {
            a dG = zxp.dG(str, str2);
            if (dG instanceof Drawable) {
                Drawable drawable = (Drawable) dG;
                AppMethodBeat.o(107322);
                return drawable;
            }
            AppMethodBeat.o(107322);
            return null;
        }
        AppMethodBeat.o(107322);
        return null;
    }
}
