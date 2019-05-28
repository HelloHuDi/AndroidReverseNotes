package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {
    public static void ii(int i) {
        AppMethodBeat.i(57746);
        Ii().edit().putInt("huawei_switch", i).commit();
        ab.i("MicroMsg.CoreServiceUtil", "setTarget26StartServiceHuawei() enable: %s", Integer.valueOf(i));
        AppMethodBeat.o(57746);
    }

    public static void Ih() {
        AppMethodBeat.i(57749);
        Context context = ah.getContext();
        Intent className = new Intent().setClassName(context, "com.tencent.mm.pluginsdk.permission.PermissionActivity");
        className.putExtra("scene", 4);
        context.startActivity(className);
        ab.i("MicroMsg.CoreServiceUtil", "ignoreBatteryOptimizations()");
        AppMethodBeat.o(57749);
    }

    public static boolean bn(Context context) {
        AppMethodBeat.i(57750);
        if (VERSION.SDK_INT >= 23) {
            ab.i("MicroMsg.CoreServiceUtil", "ifIgnoreBatteryOptimizations() result=%s", Boolean.valueOf(((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName())));
            AppMethodBeat.o(57750);
            return ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
        }
        AppMethodBeat.o(57750);
        return true;
    }

    private static SharedPreferences Ii() {
        AppMethodBeat.i(57751);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("service_launch_way", h.Mu());
        AppMethodBeat.o(57751);
        return sharedPreferences;
    }

    public static boolean Ij() {
        AppMethodBeat.i(57752);
        if (d.iW(26)) {
            ab.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() huaweiEnable:%s", Integer.valueOf(Ii().getInt("huawei_switch", 0)));
            if (bo.gW(Ii().getInt("huawei_switch", 0), 0)) {
                ab.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true (huawei)");
                AppMethodBeat.o(57752);
                return true;
            }
        }
        if (!d.iW(26) || Ig()) {
            ab.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() false");
            AppMethodBeat.o(57752);
            return false;
        }
        ab.i("MicroMsg.CoreServiceUtil", "ifUseOnlyBindToCoreService() true");
        AppMethodBeat.o(57752);
        return true;
    }

    private static boolean Ig() {
        AppMethodBeat.i(57747);
        ab.i("MicroMsg.CoreServiceUtil", "ifTarget26StartService() result:%s", Boolean.valueOf(as.amF("service_launch_way").getBoolean("target26_start_service", false)));
        AppMethodBeat.o(57747);
        return as.amF("service_launch_way").getBoolean("target26_start_service", false);
    }

    public static void bu(boolean z) {
        AppMethodBeat.i(57748);
        as.amF("service_launch_way").edit().putBoolean("target26_start_service", z).commit();
        ab.i("MicroMsg.CoreServiceUtil", "setTarget26StartService() enable: %s", Boolean.valueOf(z));
        AppMethodBeat.o(57748);
    }
}
