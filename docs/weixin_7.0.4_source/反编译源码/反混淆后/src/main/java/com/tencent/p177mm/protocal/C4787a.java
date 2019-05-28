package com.tencent.p177mm.protocal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.protocal.a */
public class C4787a {
    public static int dlZ() {
        if (C4872b.foreground) {
            return 1;
        }
        return 2;
    }

    public static int getNetType(Context context) {
        AppMethodBeat.m2504i(58787);
        int i;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(58787);
                return 0;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getType() == 1) {
                i = 1;
            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                i = 4;
            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                i = 3;
            } else if (subtype == 1 || subtype == 2) {
                i = 2;
            } else {
                i = 0;
            }
            AppMethodBeat.m2505o(58787);
            return i;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.BgFgBase", "getNetType: %s", C5046bo.m7574l(e));
            i = 1;
        }
    }
}
