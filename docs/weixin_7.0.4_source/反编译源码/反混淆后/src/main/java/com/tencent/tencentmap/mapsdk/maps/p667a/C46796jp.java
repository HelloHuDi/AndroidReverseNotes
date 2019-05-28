package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C31016w;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jp */
public class C46796jp {
    /* renamed from: a */
    private static int f18240a = 0;

    /* renamed from: a */
    public static void m88980a(Context context) {
        AppMethodBeat.m2504i(100088);
        synchronized (C46796jp.class) {
            try {
                f18240a = C31016w.m49806a(context).mo65087b("handDrawMapVer");
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100088);
            }
        }
    }

    /* renamed from: a */
    public static void m88981a(Context context, int i) {
        AppMethodBeat.m2504i(100089);
        synchronized (C46796jp.class) {
            try {
                f18240a = i;
                C31016w.m49806a(context).mo65082a("handDrawMapVer", i);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100089);
            }
        }
    }

    /* renamed from: a */
    public static int m88979a() {
        int i;
        synchronized (C46796jp.class) {
            i = f18240a;
        }
        return i;
    }
}
