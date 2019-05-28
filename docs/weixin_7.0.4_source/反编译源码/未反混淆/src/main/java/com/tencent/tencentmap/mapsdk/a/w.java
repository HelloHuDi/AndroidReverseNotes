package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ic;

public class w extends s {
    private static volatile w b;

    public static w a(Context context) {
        AppMethodBeat.i(98290);
        if (b == null) {
            synchronized (w.class) {
                try {
                    if (b == null) {
                        b = new w(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(98290);
                    }
                }
            }
        }
        w wVar = b;
        AppMethodBeat.o(98290);
        return wVar;
    }

    private w(Context context) {
        AppMethodBeat.i(98291);
        if (context == null) {
            AppMethodBeat.o(98291);
            return;
        }
        this.a = context.getSharedPreferences("com.tencent.tencentmap.mapsdk.maps.offlinemap", 0);
        c();
        AppMethodBeat.o(98291);
    }

    private void c() {
        AppMethodBeat.i(98292);
        if (b == null) {
            AppMethodBeat.o(98292);
            return;
        }
        a(new String[]{"taiwanClearCacheVersion", "taiwanStyle", "taiwanVersion", "mapPoiIcon"});
        String a = a("sdkVersion");
        if (a == null) {
            AppMethodBeat.o(98292);
            return;
        }
        if (ic.b("4.1.0", a) > 0) {
            a();
        }
        AppMethodBeat.o(98292);
    }
}
