package com.tencent.soter.core.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public final class c {
    static boolean isSystemHasAntiBruteForce() {
        return VERSION.SDK_INT >= 23;
    }

    static int getCurrentFailTime(Context context) {
        AppMethodBeat.i(72996);
        Integer valueOf = Integer.valueOf(getCurrentFailTimeInDB(context));
        d.i("Soter.SoterAntiBruteForceStrategy", "soter: current retry time: ".concat(String.valueOf(valueOf)), new Object[0]);
        int intValue = valueOf.intValue();
        AppMethodBeat.o(72996);
        return intValue;
    }

    static void setCurrentFailTime(Context context, int i) {
        AppMethodBeat.i(72997);
        d.i("Soter.SoterAntiBruteForceStrategy", "soter: setting to time: ".concat(String.valueOf(i)), new Object[0]);
        if (i < 0) {
            d.w("Soter.SoterAntiBruteForceStrategy", "soter: illegal fail time", new Object[0]);
            AppMethodBeat.o(72997);
            return;
        }
        setCurrentFailTimeInDB(context, i);
        AppMethodBeat.o(72997);
    }

    private static void setLastFreezeTime(Context context, long j) {
        AppMethodBeat.i(72999);
        d.i("Soter.SoterAntiBruteForceStrategy", "soter: setting last freeze time: ".concat(String.valueOf(j)), new Object[0]);
        if (j < -1) {
            d.w("Soter.SoterAntiBruteForceStrategy", "soter: illegal setLastFreezeTime", new Object[0]);
            AppMethodBeat.o(72999);
        } else if (context == null) {
            d.e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
            AppMethodBeat.o(72999);
        } else {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putLong("key_last_freeze_time", j);
            edit.apply();
            AppMethodBeat.o(72999);
        }
    }

    static void freeze(Context context) {
        AppMethodBeat.i(73000);
        setCurrentFailTime(context, 6);
        setLastFreezeTime(context, System.currentTimeMillis());
        AppMethodBeat.o(73000);
    }

    static void unFreeze(Context context) {
        AppMethodBeat.i(73001);
        setLastFreezeTime(context, -1);
        setCurrentFailTime(context, 0);
        AppMethodBeat.o(73001);
    }

    public static boolean isCurrentTweenTimeAvailable(Context context) {
        AppMethodBeat.i(73002);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - getLastFreezeTime(context)) / 1000);
        d.i("Soter.SoterAntiBruteForceStrategy", "soter: tween sec after last freeze: ".concat(String.valueOf(currentTimeMillis)), new Object[0]);
        if (currentTimeMillis > 30) {
            d.d("Soter.SoterAntiBruteForceStrategy", "soter: after last freeze", new Object[0]);
            AppMethodBeat.o(73002);
            return true;
        }
        AppMethodBeat.o(73002);
        return false;
    }

    public static boolean isCurrentFailTimeAvailable(Context context) {
        AppMethodBeat.i(73003);
        if (getCurrentFailTime(context) < 5) {
            d.i("Soter.SoterAntiBruteForceStrategy", "soter: fail time available", new Object[0]);
            AppMethodBeat.o(73003);
            return true;
        }
        AppMethodBeat.o(73003);
        return false;
    }

    private static void setCurrentFailTimeInDB(Context context, int i) {
        AppMethodBeat.i(73004);
        if (context == null) {
            d.e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
            AppMethodBeat.o(73004);
            return;
        }
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("key_fail_times", i);
        edit.apply();
        AppMethodBeat.o(73004);
    }

    private static int getCurrentFailTimeInDB(Context context) {
        AppMethodBeat.i(73005);
        int i = PreferenceManager.getDefaultSharedPreferences(context).getInt("key_fail_times", 0);
        AppMethodBeat.o(73005);
        return i;
    }

    private static long getLastFreezeTime(Context context) {
        AppMethodBeat.i(72998);
        Long valueOf = Long.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getLong("key_last_freeze_time", -1));
        d.i("Soter.SoterAntiBruteForceStrategy", "soter: current last freeze time: ".concat(String.valueOf(valueOf)), new Object[0]);
        long longValue = valueOf.longValue();
        AppMethodBeat.o(72998);
        return longValue;
    }
}
