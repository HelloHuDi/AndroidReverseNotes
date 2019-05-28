package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.w;
import org.json.JSONArray;

public class lq {
    private static int a = lr.a;
    private static int b = 1000;
    private static int c = lr.b;
    private static int d = 0;
    private static volatile boolean e = false;
    private static int f = 0;
    private static String g = null;
    private static String h = null;
    private static int[] i = new int[0];
    private static byte[] j = new byte[0];

    public static void a(int i, int i2, int i3, int i4, String str, int[] iArr, String str2) {
        synchronized (j) {
            a = i;
            b = i2;
            c = i3;
            d = i4;
            g = str;
            i = iArr;
            h = str2;
        }
    }

    public static int a() {
        int i;
        synchronized (j) {
            i = b;
        }
        return i;
    }

    public static int b() {
        int i;
        synchronized (j) {
            i = a;
        }
        return i;
    }

    public static int c() {
        int i;
        synchronized (j) {
            i = c;
        }
        return i;
    }

    public static boolean d() {
        boolean z;
        synchronized (j) {
            z = e;
        }
        return z;
    }

    public static void a(boolean z) {
        synchronized (j) {
            e = z;
        }
    }

    public static String e() {
        String str;
        synchronized (j) {
            str = g;
        }
        return str;
    }

    public static int f() {
        int i;
        synchronized (j) {
            i = d;
        }
        return i;
    }

    public static String g() {
        String str;
        synchronized (j) {
            str = h;
        }
        return str;
    }

    public static int[] h() {
        int[] iArr;
        synchronized (j) {
            iArr = i;
        }
        return iArr;
    }

    public static void a(Context context) {
        int i = 0;
        AppMethodBeat.i(100467);
        if (context == null) {
            AppMethodBeat.o(100467);
            return;
        }
        w a = w.a(context);
        int b = a.b("worldMapFrontierVersion");
        int b2 = a.b("worldMapStyle");
        int b3 = a.b("worldMapScene");
        int b4 = a.b("worldMapVersion");
        int b5 = a.b("worldMapProtocolVersion");
        boolean c = a.c("worldMapEnabled");
        String a2 = a.a("worldMapTileUrlRegex");
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(a.a("worldMapTileUrlRangeJson"));
            iArr = new int[jSONArray.length()];
            while (i < iArr.length) {
                iArr[i] = jSONArray.getInt(i);
                i++;
            }
        } catch (Exception e) {
        }
        String a3 = a.a("worldMapLogoChangeRuleJson");
        synchronized (j) {
            try {
                b = b2;
                a = b3;
                c = b4;
                d = b5;
                e = c;
                g = a2;
                i = iArr;
                h = a3;
                f = b;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100467);
            }
        }
    }
}
