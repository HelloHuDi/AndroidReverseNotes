package com.tencent.soter.core.biometric;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1351c.C44476d;

public class SoterBiometricAntiBruteForceStrategy {
    private static final long DEFAULT_FREEZE_TIME = -1;
    private static final int FREEZE_SECOND = 30;
    private static final String KEY_FAIL_TIMES = "key_fail_times";
    private static final String KEY_LAST_FREEZE_TIME = "key_last_freeze_time";
    private static final int MAX_FAIL_NUM = 5;
    private static final String TAG = "Soter.SoterBiometricAntiBruteForceStrategy";

    static boolean isSystemHasAntiBruteForce() {
        return VERSION.SDK_INT >= 23;
    }

    private static int getCurrentFailTime(Context context) {
        AppMethodBeat.m2504i(72961);
        Integer valueOf = Integer.valueOf(getCurrentFailTimeInDB(context));
        C44476d.m80484i(TAG, "soter: current retry time: ".concat(String.valueOf(valueOf)), new Object[0]);
        int intValue = valueOf.intValue();
        AppMethodBeat.m2505o(72961);
        return intValue;
    }

    private static void setCurrentFailTime(Context context, int i) {
        AppMethodBeat.m2504i(72962);
        C44476d.m80484i(TAG, "soter: setting to time: ".concat(String.valueOf(i)), new Object[0]);
        if (i < 0) {
            C44476d.m80486w(TAG, "soter: illegal fail time", new Object[0]);
            AppMethodBeat.m2505o(72962);
            return;
        }
        setCurrentFailTimeInDB(context, i);
        AppMethodBeat.m2505o(72962);
    }

    private static long getLastFreezeTime(Context context) {
        AppMethodBeat.m2504i(72963);
        Long valueOf = Long.valueOf(getLastFreezeTimeInDB(context));
        C44476d.m80484i(TAG, "soter: current last freeze time: ".concat(String.valueOf(valueOf)), new Object[0]);
        long longValue = valueOf.longValue();
        AppMethodBeat.m2505o(72963);
        return longValue;
    }

    private static void setLastFreezeTime(Context context, long j) {
        AppMethodBeat.m2504i(72964);
        C44476d.m80484i(TAG, "soter: setting last freeze time: ".concat(String.valueOf(j)), new Object[0]);
        if (j < -1) {
            C44476d.m80486w(TAG, "soter: illegal setLastFreezeTime", new Object[0]);
            AppMethodBeat.m2505o(72964);
            return;
        }
        setLastFreezeTimeInDB(context, j);
        AppMethodBeat.m2505o(72964);
    }

    static void freeze(Context context) {
        AppMethodBeat.m2504i(72965);
        setCurrentFailTime(context, 6);
        setLastFreezeTime(context, System.currentTimeMillis());
        AppMethodBeat.m2505o(72965);
    }

    static void unFreeze(Context context) {
        AppMethodBeat.m2504i(72966);
        setLastFreezeTime(context, -1);
        setCurrentFailTime(context, 0);
        AppMethodBeat.m2505o(72966);
    }

    static void addFailTime(Context context) {
        AppMethodBeat.m2504i(72967);
        setCurrentFailTime(context, Integer.valueOf(getCurrentFailTime(context)).intValue() + 1);
        AppMethodBeat.m2505o(72967);
    }

    static boolean isCurrentTweenTimeAvailable(Context context) {
        AppMethodBeat.m2504i(72968);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - getLastFreezeTime(context)) / 1000);
        C44476d.m80484i(TAG, "soter: tween sec after last freeze: ".concat(String.valueOf(currentTimeMillis)), new Object[0]);
        if (currentTimeMillis > 30) {
            C44476d.m80482d(TAG, "soter: after last freeze", new Object[0]);
            AppMethodBeat.m2505o(72968);
            return true;
        }
        AppMethodBeat.m2505o(72968);
        return false;
    }

    static boolean isCurrentFailTimeAvailable(Context context) {
        AppMethodBeat.m2504i(72969);
        if (getCurrentFailTime(context) < 5) {
            C44476d.m80484i(TAG, "soter: fail time available", new Object[0]);
            AppMethodBeat.m2505o(72969);
            return true;
        }
        AppMethodBeat.m2505o(72969);
        return false;
    }

    private static void setCurrentFailTimeInDB(Context context, int i) {
        AppMethodBeat.m2504i(72970);
        if (context == null) {
            C44476d.m80483e(TAG, "soter: context is null", new Object[0]);
            AppMethodBeat.m2505o(72970);
            return;
        }
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(KEY_FAIL_TIMES, i);
        edit.apply();
        AppMethodBeat.m2505o(72970);
    }

    private static int getCurrentFailTimeInDB(Context context) {
        AppMethodBeat.m2504i(72971);
        int i = PreferenceManager.getDefaultSharedPreferences(context).getInt(KEY_FAIL_TIMES, 0);
        AppMethodBeat.m2505o(72971);
        return i;
    }

    private static long getLastFreezeTimeInDB(Context context) {
        AppMethodBeat.m2504i(72972);
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong(KEY_LAST_FREEZE_TIME, -1);
        AppMethodBeat.m2505o(72972);
        return j;
    }

    private static void setLastFreezeTimeInDB(Context context, long j) {
        AppMethodBeat.m2504i(72973);
        if (context == null) {
            C44476d.m80483e(TAG, "soter: context is null", new Object[0]);
            AppMethodBeat.m2505o(72973);
            return;
        }
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(KEY_LAST_FREEZE_TIME, j);
        edit.apply();
        AppMethodBeat.m2505o(72973);
    }
}
