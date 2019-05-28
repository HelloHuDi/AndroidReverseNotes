package com.tencent.p177mm.compatible.p221e;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.compatible.e.y */
public final class C18172y {
    private static C18172y eud = null;

    /* renamed from: Me */
    public static int m28611Me() {
        AppMethodBeat.m2504i(93018);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.m2505o(93018);
            return 0;
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.m2505o(93018);
            return 1;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 7:
            case 11:
                AppMethodBeat.m2505o(93018);
                return 2;
            case 3:
            case 4:
            case 5:
            case 6:
            case 12:
            case 17:
                AppMethodBeat.m2505o(93018);
                return 3;
            case 13:
            case 14:
            case 15:
                AppMethodBeat.m2505o(93018);
                return 4;
            default:
                AppMethodBeat.m2505o(93018);
                return 0;
        }
    }
}
