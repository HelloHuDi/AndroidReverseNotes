package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class z {
    public static NetworkInfo a(Context context) {
        AppMethodBeat.i(101244);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            AppMethodBeat.o(101244);
            return null;
        }
        AppMethodBeat.o(101244);
        return activeNetworkInfo;
    }
}
