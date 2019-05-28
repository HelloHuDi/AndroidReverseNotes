package com.tencent.p177mm.network;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.p265a.C1889b;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.network.ab */
public final class C32856ab {
    public C1889b geg = null;
    public boolean geh = false;

    /* renamed from: cg */
    public static boolean m53749cg(Context context) {
        AppMethodBeat.m2504i(58681);
        if (context == null || C5023at.isWap(context)) {
            AppMethodBeat.m2505o(58681);
            return false;
        }
        AppMethodBeat.m2505o(58681);
        return true;
    }

    /* renamed from: ch */
    public static boolean m53750ch(Context context) {
        AppMethodBeat.m2504i(58682);
        if (context == null || !C5023at.isWifi(context)) {
            AppMethodBeat.m2505o(58682);
            return false;
        }
        AppMethodBeat.m2505o(58682);
        return true;
    }
}
