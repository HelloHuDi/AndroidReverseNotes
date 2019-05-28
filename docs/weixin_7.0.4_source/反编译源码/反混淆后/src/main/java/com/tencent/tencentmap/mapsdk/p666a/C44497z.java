package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.z */
public class C44497z {
    /* renamed from: a */
    public static NetworkInfo m80698a(Context context) {
        AppMethodBeat.m2504i(101244);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            AppMethodBeat.m2505o(101244);
            return null;
        }
        AppMethodBeat.m2505o(101244);
        return activeNetworkInfo;
    }
}
