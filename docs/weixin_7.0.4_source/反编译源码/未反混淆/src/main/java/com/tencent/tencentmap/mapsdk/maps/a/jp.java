package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.w;

public class jp {
    private static int a = 0;

    public static void a(Context context) {
        AppMethodBeat.i(100088);
        synchronized (jp.class) {
            try {
                a = w.a(context).b("handDrawMapVer");
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100088);
            }
        }
    }

    public static void a(Context context, int i) {
        AppMethodBeat.i(100089);
        synchronized (jp.class) {
            try {
                a = i;
                w.a(context).a("handDrawMapVer", i);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100089);
            }
        }
    }

    public static int a() {
        int i;
        synchronized (jp.class) {
            i = a;
        }
        return i;
    }
}
