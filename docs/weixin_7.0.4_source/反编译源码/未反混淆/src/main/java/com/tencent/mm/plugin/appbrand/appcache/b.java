package com.tencent.mm.plugin.appbrand.appcache;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ah;

public final class b {
    private static final SparseIntArray gSe;

    static {
        AppMethodBeat.i(129321);
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        gSe = sparseIntArray;
        sparseIntArray.put(0, R.string.pl);
        gSe.put(1, R.string.go);
        gSe.put(2, R.string.gn);
        AppMethodBeat.o(129321);
    }

    public static String xm(String str) {
        AppMethodBeat.i(129320);
        String Cm = LaunchParcel.Cm(str);
        AppMethodBeat.o(129320);
        return Cm;
    }

    public static String no(int i) {
        AppMethodBeat.i(129319);
        String string = ah.getResources().getString(gSe.get(i, R.string.pl));
        AppMethodBeat.o(129319);
        return string;
    }
}
