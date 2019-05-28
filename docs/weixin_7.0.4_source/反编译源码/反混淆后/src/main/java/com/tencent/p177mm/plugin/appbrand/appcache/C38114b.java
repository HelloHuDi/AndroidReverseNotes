package com.tencent.p177mm.plugin.appbrand.appcache;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b */
public final class C38114b {
    private static final SparseIntArray gSe;

    static {
        AppMethodBeat.m2504i(129321);
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        gSe = sparseIntArray;
        sparseIntArray.put(0, C25738R.string.f9104pl);
        gSe.put(1, C25738R.string.f8838go);
        gSe.put(2, C25738R.string.f8837gn);
        AppMethodBeat.m2505o(129321);
    }

    /* renamed from: xm */
    public static String m64486xm(String str) {
        AppMethodBeat.m2504i(129320);
        String Cm = LaunchParcel.m30355Cm(str);
        AppMethodBeat.m2505o(129320);
        return Cm;
    }

    /* renamed from: no */
    public static String m64485no(int i) {
        AppMethodBeat.m2504i(129319);
        String string = C4996ah.getResources().getString(gSe.get(i, C25738R.string.f9104pl));
        AppMethodBeat.m2505o(129319);
        return string;
    }
}
