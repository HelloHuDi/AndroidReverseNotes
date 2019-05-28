package com.tencent.mm.compatible.e;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class y {
    private static y eud = null;

    public static int Me() {
        AppMethodBeat.i(93018);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(93018);
            return 0;
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(93018);
            return 1;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 7:
            case 11:
                AppMethodBeat.o(93018);
                return 2;
            case 3:
            case 4:
            case 5:
            case 6:
            case 12:
            case 17:
                AppMethodBeat.o(93018);
                return 3;
            case 13:
            case 14:
            case 15:
                AppMethodBeat.o(93018);
                return 4;
            default:
                AppMethodBeat.o(93018);
                return 0;
        }
    }
}
