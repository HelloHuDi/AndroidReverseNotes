package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.er */
public final class C24370er {
    /* renamed from: a */
    private static String f4677a = "";
    /* renamed from: b */
    private static String f4678b = "";

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.er$a */
    public static class C24369a {
        /* renamed from: a */
        public String f4671a;
        /* renamed from: b */
        public boolean f4672b = false;
        /* renamed from: c */
        public boolean f4673c = false;
        /* renamed from: d */
        public String f4674d = "";
        /* renamed from: e */
        public Bundle f4675e;
        /* renamed from: f */
        private int f4676f;

        public C24369a(int i, String str, boolean z, boolean z2, String str2, Bundle bundle) {
            this.f4676f = i;
            this.f4671a = str;
            this.f4672b = z;
            this.f4673c = z2;
            this.f4674d = str2;
            this.f4675e = bundle;
        }

        public final String toString() {
            AppMethodBeat.m2504i(98812);
            String str = "appid:" + this.f4676f + "," + this.f4671a + "," + this.f4672b + "," + this.f4673c + "," + this.f4674d;
            AppMethodBeat.m2505o(98812);
            return str;
        }
    }

    /* renamed from: a */
    public static int m37704a(Context context, String str) {
        int i = -407;
        AppMethodBeat.m2504i(98824);
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                AppMethodBeat.m2505o(98824);
                return i;
            } else if (applicationInfo.metaData == null) {
                AppMethodBeat.m2505o(98824);
                return -408;
            } else {
                i = applicationInfo.metaData.getInt("halley_appid", 0);
                if (i <= 0) {
                    AppMethodBeat.m2505o(98824);
                    return -408;
                }
                AppMethodBeat.m2505o(98824);
                return i;
            }
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(98824);
            return i;
        }
    }

    /* renamed from: a */
    public static C24369a m37705a(int i, Context context, String str, String str2) {
        AppMethodBeat.m2504i(98814);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(98814);
            return null;
        }
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(str, str2), 128);
            if (serviceInfo != null) {
                C24369a c24369a = new C24369a(i, str, serviceInfo.enabled, serviceInfo.exported, serviceInfo.processName, serviceInfo.metaData);
                AppMethodBeat.m2505o(98814);
                return c24369a;
            }
        } catch (NameNotFoundException e) {
        }
        AppMethodBeat.m2505o(98814);
        return null;
    }

    /* renamed from: a */
    public static String m37707a(int i) {
        return i == 2 ? "2g" : i == 3 ? "3g" : i == 4 ? "4g" : i == 1 ? "wifi" : "";
    }

    /* renamed from: a */
    public static String m37708a(Context context) {
        AppMethodBeat.m2504i(98813);
        String a;
        if (TextUtils.isEmpty(f4677a)) {
            String packageName = context.getPackageName();
            a = C24373eu.m37733a(Process.myPid());
            if (TextUtils.isEmpty(a) || !a.startsWith(packageName)) {
                a = C24373eu.m37735a(context, Process.myPid());
            }
            f4677a = a;
            AppMethodBeat.m2505o(98813);
            return a;
        }
        a = f4677a;
        AppMethodBeat.m2505o(98813);
        return a;
    }

    /* renamed from: a */
    private static String m37709a(boolean z) {
        AppMethodBeat.m2504i(98815);
        String str = "HalleyServicePreferences_" + C46772bt.m88739c() + (C46772bt.m88738b() ? "_test" : "");
        if (z) {
            str = str + "_" + C46772bt.m88745i();
        }
        AppMethodBeat.m2505o(98815);
        return str;
    }

    /* renamed from: a */
    public static void m37711a(String str, int i, boolean z) {
        AppMethodBeat.m2504i(98822);
        C46772bt.m88735a().getSharedPreferences(C24370er.m37709a(false), 0).edit().putInt(str, i).commit();
        AppMethodBeat.m2505o(98822);
    }

    /* renamed from: a */
    public static void m37712a(String str, long j, boolean z) {
        AppMethodBeat.m2504i(98820);
        C46772bt.m88735a().getSharedPreferences(C24370er.m37709a(false), 0).edit().putLong(str, j).commit();
        AppMethodBeat.m2505o(98820);
    }

    /* renamed from: a */
    public static void m37713a(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(98818);
        C46772bt.m88735a().getSharedPreferences(C24370er.m37709a(z), 0).edit().putString(str, str2).commit();
        AppMethodBeat.m2505o(98818);
    }

    /* renamed from: b */
    public static int m37714b(String str, int i, boolean z) {
        AppMethodBeat.m2504i(98823);
        int i2 = C46772bt.m88735a().getSharedPreferences(C24370er.m37709a(false), 0).getInt(str, 0);
        AppMethodBeat.m2505o(98823);
        return i2;
    }

    /* renamed from: b */
    public static long m37715b(String str, long j, boolean z) {
        AppMethodBeat.m2504i(98821);
        long j2 = C46772bt.m88735a().getSharedPreferences(C24370er.m37709a(false), 0).getLong(str, 0);
        AppMethodBeat.m2505o(98821);
        return j2;
    }

    /* renamed from: b */
    public static String m37716b(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(98819);
        String string = C46772bt.m88735a().getSharedPreferences(C24370er.m37709a(z), 0).getString(str, str2);
        AppMethodBeat.m2505o(98819);
        return string;
    }

    /* renamed from: a */
    public static void m37710a(String str) {
        AppMethodBeat.m2504i(98816);
        C46772bt.m88735a().getSharedPreferences(C24370er.m37709a(false), 0).edit().putString("deviceid", str).commit();
        f4678b = str;
        AppMethodBeat.m2505o(98816);
    }

    /* renamed from: a */
    public static String m37706a() {
        AppMethodBeat.m2504i(98817);
        String string;
        if (TextUtils.isEmpty(f4678b)) {
            string = C46772bt.m88735a().getSharedPreferences(C24370er.m37709a(false), 0).getString("deviceid", "");
            f4678b = string;
            AppMethodBeat.m2505o(98817);
            return string;
        }
        string = f4678b;
        AppMethodBeat.m2505o(98817);
        return string;
    }
}
