package com.tencent.p177mm.booter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.booter.c */
public final class C45270c {
    /* renamed from: ii */
    public static void m83437ii(int i) {
        AppMethodBeat.m2504i(57746);
        C45270c.m83433Ii().edit().putInt("huawei_switch", i).commit();
        C4990ab.m7417i("MicroMsg.CoreServiceUtil", "setTarget26StartServiceHuawei() enable: %s", Integer.valueOf(i));
        AppMethodBeat.m2505o(57746);
    }

    /* renamed from: Ih */
    public static void m83432Ih() {
        AppMethodBeat.m2504i(57749);
        Context context = C4996ah.getContext();
        Intent className = new Intent().setClassName(context, "com.tencent.mm.pluginsdk.permission.PermissionActivity");
        className.putExtra("scene", 4);
        context.startActivity(className);
        C4990ab.m7416i("MicroMsg.CoreServiceUtil", "ignoreBatteryOptimizations()");
        AppMethodBeat.m2505o(57749);
    }

    /* renamed from: bn */
    public static boolean m83435bn(Context context) {
        AppMethodBeat.m2504i(57750);
        if (VERSION.SDK_INT >= 23) {
            C4990ab.m7417i("MicroMsg.CoreServiceUtil", "ifIgnoreBatteryOptimizations() result=%s", Boolean.valueOf(((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName())));
            AppMethodBeat.m2505o(57750);
            return ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
        }
        AppMethodBeat.m2505o(57750);
        return true;
    }

    /* renamed from: Ii */
    private static SharedPreferences m83433Ii() {
        AppMethodBeat.m2504i(57751);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("service_launch_way", C1448h.m3078Mu());
        AppMethodBeat.m2505o(57751);
        return sharedPreferences;
    }

    /* renamed from: Ij */
    public static boolean m83434Ij() {
        AppMethodBeat.m2504i(57752);
        if (C1443d.m3068iW(26)) {
            C4990ab.m7417i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() huaweiEnable:%s", Integer.valueOf(C45270c.m83433Ii().getInt("huawei_switch", 0)));
            if (C5046bo.m7563gW(C45270c.m83433Ii().getInt("huawei_switch", 0), 0)) {
                C4990ab.m7416i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true (huawei)");
                AppMethodBeat.m2505o(57752);
                return true;
            }
        }
        if (!C1443d.m3068iW(26) || C45270c.m83431Ig()) {
            C4990ab.m7416i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() false");
            AppMethodBeat.m2505o(57752);
            return false;
        }
        C4990ab.m7416i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true");
        AppMethodBeat.m2505o(57752);
        return true;
    }

    /* renamed from: Ig */
    private static boolean m83431Ig() {
        AppMethodBeat.m2504i(57747);
        C4990ab.m7417i("MicroMsg.CoreServiceUtil", "ifTarget26StartService() result:%s", Boolean.valueOf(C5018as.amF("service_launch_way").getBoolean("target26_start_service", false)));
        AppMethodBeat.m2505o(57747);
        return C5018as.amF("service_launch_way").getBoolean("target26_start_service", false);
    }

    /* renamed from: bu */
    public static void m83436bu(boolean z) {
        AppMethodBeat.m2504i(57748);
        C5018as.amF("service_launch_way").edit().putBoolean("target26_start_service", z).commit();
        C4990ab.m7417i("MicroMsg.CoreServiceUtil", "setTarget26StartService() enable: %s", Boolean.valueOf(z));
        AppMethodBeat.m2505o(57748);
    }
}
