package com.tencent.soter.core.p665a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1351c.C44476d;

/* renamed from: com.tencent.soter.core.a.c */
public final class C30970c {
    static boolean isSystemHasAntiBruteForce() {
        return VERSION.SDK_INT >= 23;
    }

    static int getCurrentFailTime(Context context) {
        AppMethodBeat.m2504i(72996);
        Integer valueOf = Integer.valueOf(C30970c.getCurrentFailTimeInDB(context));
        C44476d.m80484i("Soter.SoterAntiBruteForceStrategy", "soter: current retry time: ".concat(String.valueOf(valueOf)), new Object[0]);
        int intValue = valueOf.intValue();
        AppMethodBeat.m2505o(72996);
        return intValue;
    }

    static void setCurrentFailTime(Context context, int i) {
        AppMethodBeat.m2504i(72997);
        C44476d.m80484i("Soter.SoterAntiBruteForceStrategy", "soter: setting to time: ".concat(String.valueOf(i)), new Object[0]);
        if (i < 0) {
            C44476d.m80486w("Soter.SoterAntiBruteForceStrategy", "soter: illegal fail time", new Object[0]);
            AppMethodBeat.m2505o(72997);
            return;
        }
        C30970c.setCurrentFailTimeInDB(context, i);
        AppMethodBeat.m2505o(72997);
    }

    private static void setLastFreezeTime(Context context, long j) {
        AppMethodBeat.m2504i(72999);
        C44476d.m80484i("Soter.SoterAntiBruteForceStrategy", "soter: setting last freeze time: ".concat(String.valueOf(j)), new Object[0]);
        if (j < -1) {
            C44476d.m80486w("Soter.SoterAntiBruteForceStrategy", "soter: illegal setLastFreezeTime", new Object[0]);
            AppMethodBeat.m2505o(72999);
        } else if (context == null) {
            C44476d.m80483e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
            AppMethodBeat.m2505o(72999);
        } else {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putLong("key_last_freeze_time", j);
            edit.apply();
            AppMethodBeat.m2505o(72999);
        }
    }

    static void freeze(Context context) {
        AppMethodBeat.m2504i(73000);
        C30970c.setCurrentFailTime(context, 6);
        C30970c.setLastFreezeTime(context, System.currentTimeMillis());
        AppMethodBeat.m2505o(73000);
    }

    static void unFreeze(Context context) {
        AppMethodBeat.m2504i(73001);
        C30970c.setLastFreezeTime(context, -1);
        C30970c.setCurrentFailTime(context, 0);
        AppMethodBeat.m2505o(73001);
    }

    public static boolean isCurrentTweenTimeAvailable(Context context) {
        AppMethodBeat.m2504i(73002);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - C30970c.getLastFreezeTime(context)) / 1000);
        C44476d.m80484i("Soter.SoterAntiBruteForceStrategy", "soter: tween sec after last freeze: ".concat(String.valueOf(currentTimeMillis)), new Object[0]);
        if (currentTimeMillis > 30) {
            C44476d.m80482d("Soter.SoterAntiBruteForceStrategy", "soter: after last freeze", new Object[0]);
            AppMethodBeat.m2505o(73002);
            return true;
        }
        AppMethodBeat.m2505o(73002);
        return false;
    }

    public static boolean isCurrentFailTimeAvailable(Context context) {
        AppMethodBeat.m2504i(73003);
        if (C30970c.getCurrentFailTime(context) < 5) {
            C44476d.m80484i("Soter.SoterAntiBruteForceStrategy", "soter: fail time available", new Object[0]);
            AppMethodBeat.m2505o(73003);
            return true;
        }
        AppMethodBeat.m2505o(73003);
        return false;
    }

    private static void setCurrentFailTimeInDB(Context context, int i) {
        AppMethodBeat.m2504i(73004);
        if (context == null) {
            C44476d.m80483e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
            AppMethodBeat.m2505o(73004);
            return;
        }
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("key_fail_times", i);
        edit.apply();
        AppMethodBeat.m2505o(73004);
    }

    private static int getCurrentFailTimeInDB(Context context) {
        AppMethodBeat.m2504i(73005);
        int i = PreferenceManager.getDefaultSharedPreferences(context).getInt("key_fail_times", 0);
        AppMethodBeat.m2505o(73005);
        return i;
    }

    private static long getLastFreezeTime(Context context) {
        AppMethodBeat.m2504i(72998);
        Long valueOf = Long.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getLong("key_last_freeze_time", -1));
        C44476d.m80484i("Soter.SoterAntiBruteForceStrategy", "soter: current last freeze time: ".concat(String.valueOf(valueOf)), new Object[0]);
        long longValue = valueOf.longValue();
        AppMethodBeat.m2505o(72998);
        return longValue;
    }
}
