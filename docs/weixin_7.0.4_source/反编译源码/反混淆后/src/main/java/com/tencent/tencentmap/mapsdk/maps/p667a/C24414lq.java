package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C31016w;
import org.json.JSONArray;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lq */
public class C24414lq {
    /* renamed from: a */
    private static int f4855a = C36532lr.f15447a;
    /* renamed from: b */
    private static int f4856b = 1000;
    /* renamed from: c */
    private static int f4857c = C36532lr.f15448b;
    /* renamed from: d */
    private static int f4858d = 0;
    /* renamed from: e */
    private static volatile boolean f4859e = false;
    /* renamed from: f */
    private static int f4860f = 0;
    /* renamed from: g */
    private static String f4861g = null;
    /* renamed from: h */
    private static String f4862h = null;
    /* renamed from: i */
    private static int[] f4863i = new int[0];
    /* renamed from: j */
    private static byte[] f4864j = new byte[0];

    /* renamed from: a */
    public static void m37988a(int i, int i2, int i3, int i4, String str, int[] iArr, String str2) {
        synchronized (f4864j) {
            f4855a = i;
            f4856b = i2;
            f4857c = i3;
            f4858d = i4;
            f4861g = str;
            f4863i = iArr;
            f4862h = str2;
        }
    }

    /* renamed from: a */
    public static int m37987a() {
        int i;
        synchronized (f4864j) {
            i = f4856b;
        }
        return i;
    }

    /* renamed from: b */
    public static int m37991b() {
        int i;
        synchronized (f4864j) {
            i = f4855a;
        }
        return i;
    }

    /* renamed from: c */
    public static int m37992c() {
        int i;
        synchronized (f4864j) {
            i = f4857c;
        }
        return i;
    }

    /* renamed from: d */
    public static boolean m37993d() {
        boolean z;
        synchronized (f4864j) {
            z = f4859e;
        }
        return z;
    }

    /* renamed from: a */
    public static void m37990a(boolean z) {
        synchronized (f4864j) {
            f4859e = z;
        }
    }

    /* renamed from: e */
    public static String m37994e() {
        String str;
        synchronized (f4864j) {
            str = f4861g;
        }
        return str;
    }

    /* renamed from: f */
    public static int m37995f() {
        int i;
        synchronized (f4864j) {
            i = f4858d;
        }
        return i;
    }

    /* renamed from: g */
    public static String m37996g() {
        String str;
        synchronized (f4864j) {
            str = f4862h;
        }
        return str;
    }

    /* renamed from: h */
    public static int[] m37997h() {
        int[] iArr;
        synchronized (f4864j) {
            iArr = f4863i;
        }
        return iArr;
    }

    /* renamed from: a */
    public static void m37989a(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(100467);
        if (context == null) {
            AppMethodBeat.m2505o(100467);
            return;
        }
        C31016w a = C31016w.m49806a(context);
        int b = a.mo65087b("worldMapFrontierVersion");
        int b2 = a.mo65087b("worldMapStyle");
        int b3 = a.mo65087b("worldMapScene");
        int b4 = a.mo65087b("worldMapVersion");
        int b5 = a.mo65087b("worldMapProtocolVersion");
        boolean c = a.mo65089c("worldMapEnabled");
        String a2 = a.mo65080a("worldMapTileUrlRegex");
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(a.mo65080a("worldMapTileUrlRangeJson"));
            iArr = new int[jSONArray.length()];
            while (i < iArr.length) {
                iArr[i] = jSONArray.getInt(i);
                i++;
            }
        } catch (Exception e) {
        }
        String a3 = a.mo65080a("worldMapLogoChangeRuleJson");
        synchronized (f4864j) {
            try {
                f4856b = b2;
                f4855a = b3;
                f4857c = b4;
                f4858d = b5;
                f4859e = c;
                f4861g = a2;
                f4863i = iArr;
                f4862h = a3;
                f4860f = b;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100467);
            }
        }
    }
}
