package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class er {
    private static String a = "";
    private static String b = "";

    public static class a {
        public String a;
        public boolean b = false;
        public boolean c = false;
        public String d = "";
        public Bundle e;
        private int f;

        public a(int i, String str, boolean z, boolean z2, String str2, Bundle bundle) {
            this.f = i;
            this.a = str;
            this.b = z;
            this.c = z2;
            this.d = str2;
            this.e = bundle;
        }

        public final String toString() {
            AppMethodBeat.i(98812);
            String str = "appid:" + this.f + "," + this.a + "," + this.b + "," + this.c + "," + this.d;
            AppMethodBeat.o(98812);
            return str;
        }
    }

    public static int a(Context context, String str) {
        int i = -407;
        AppMethodBeat.i(98824);
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                AppMethodBeat.o(98824);
                return i;
            } else if (applicationInfo.metaData == null) {
                AppMethodBeat.o(98824);
                return -408;
            } else {
                i = applicationInfo.metaData.getInt("halley_appid", 0);
                if (i <= 0) {
                    AppMethodBeat.o(98824);
                    return -408;
                }
                AppMethodBeat.o(98824);
                return i;
            }
        } catch (NameNotFoundException e) {
            AppMethodBeat.o(98824);
            return i;
        }
    }

    public static a a(int i, Context context, String str, String str2) {
        AppMethodBeat.i(98814);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(98814);
            return null;
        }
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(str, str2), 128);
            if (serviceInfo != null) {
                a aVar = new a(i, str, serviceInfo.enabled, serviceInfo.exported, serviceInfo.processName, serviceInfo.metaData);
                AppMethodBeat.o(98814);
                return aVar;
            }
        } catch (NameNotFoundException e) {
        }
        AppMethodBeat.o(98814);
        return null;
    }

    public static String a(int i) {
        return i == 2 ? "2g" : i == 3 ? "3g" : i == 4 ? "4g" : i == 1 ? "wifi" : "";
    }

    public static String a(Context context) {
        AppMethodBeat.i(98813);
        String a;
        if (TextUtils.isEmpty(a)) {
            String packageName = context.getPackageName();
            a = eu.a(Process.myPid());
            if (TextUtils.isEmpty(a) || !a.startsWith(packageName)) {
                a = eu.a(context, Process.myPid());
            }
            a = a;
            AppMethodBeat.o(98813);
            return a;
        }
        a = a;
        AppMethodBeat.o(98813);
        return a;
    }

    private static String a(boolean z) {
        AppMethodBeat.i(98815);
        String str = "HalleyServicePreferences_" + bt.c() + (bt.b() ? "_test" : "");
        if (z) {
            str = str + "_" + bt.i();
        }
        AppMethodBeat.o(98815);
        return str;
    }

    public static void a(String str, int i, boolean z) {
        AppMethodBeat.i(98822);
        bt.a().getSharedPreferences(a(false), 0).edit().putInt(str, i).commit();
        AppMethodBeat.o(98822);
    }

    public static void a(String str, long j, boolean z) {
        AppMethodBeat.i(98820);
        bt.a().getSharedPreferences(a(false), 0).edit().putLong(str, j).commit();
        AppMethodBeat.o(98820);
    }

    public static void a(String str, String str2, boolean z) {
        AppMethodBeat.i(98818);
        bt.a().getSharedPreferences(a(z), 0).edit().putString(str, str2).commit();
        AppMethodBeat.o(98818);
    }

    public static int b(String str, int i, boolean z) {
        AppMethodBeat.i(98823);
        int i2 = bt.a().getSharedPreferences(a(false), 0).getInt(str, 0);
        AppMethodBeat.o(98823);
        return i2;
    }

    public static long b(String str, long j, boolean z) {
        AppMethodBeat.i(98821);
        long j2 = bt.a().getSharedPreferences(a(false), 0).getLong(str, 0);
        AppMethodBeat.o(98821);
        return j2;
    }

    public static String b(String str, String str2, boolean z) {
        AppMethodBeat.i(98819);
        String string = bt.a().getSharedPreferences(a(z), 0).getString(str, str2);
        AppMethodBeat.o(98819);
        return string;
    }

    public static void a(String str) {
        AppMethodBeat.i(98816);
        bt.a().getSharedPreferences(a(false), 0).edit().putString("deviceid", str).commit();
        b = str;
        AppMethodBeat.o(98816);
    }

    public static String a() {
        AppMethodBeat.i(98817);
        String string;
        if (TextUtils.isEmpty(b)) {
            string = bt.a().getSharedPreferences(a(false), 0).getString("deviceid", "");
            b = string;
            AppMethodBeat.o(98817);
            return string;
        }
        string = b;
        AppMethodBeat.o(98817);
        return string;
    }
}
