package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.stats.LoggingConstants;
import com.google.android.gms.common.stats.StatsUtils;
import com.google.android.gms.common.stats.WakeLockTracker;
import javax.annotation.Nonnull;

public abstract class GCoreWakefulBroadcastReceiver extends WakefulBroadcastReceiver {
    private static String TAG = "GCoreWakefulBroadcastReceiver";

    @SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
    public static boolean completeWakefulIntent(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context != null) {
            WakeLockTracker.getInstance().registerReleaseEvent(context, intent);
        } else {
            String str = "context shouldn't be null. intent: ";
            String valueOf = String.valueOf(intent.toUri(0));
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                valueOf = new String(str);
            }
        }
        return WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public static ComponentName startWakefulService(Context context, Intent intent) {
        ComponentName zza = zza(context, intent);
        if (zza == null) {
            return null;
        }
        WakeLockTracker instance = WakeLockTracker.getInstance();
        String str = "wake:";
        String valueOf = String.valueOf(zza.flattenToShortString());
        instance.registerAcquireEvent(context, intent, valueOf.length() != 0 ? str.concat(valueOf) : new String(str), TAG, null, 1, "com.google.android.gms");
        return zza;
    }

    public static ComponentName startWakefulService(Context context, Intent intent, @Nonnull String str) {
        return startWakefulService(context, intent, str, context.getPackageName());
    }

    public static ComponentName startWakefulService(Context context, Intent intent, @Nonnull String str, String str2) {
        ComponentName zza = zza(context, intent);
        if (zza == null) {
            return null;
        }
        WakeLockTracker.getInstance().registerAcquireEvent(context, intent, str, TAG, null, 1, str2);
        return zza;
    }

    @SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
    private static ComponentName zza(Context context, Intent intent) {
        intent.putExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY, StatsUtils.getEventKey(context, intent));
        return WakefulBroadcastReceiver.startWakefulService(context, intent);
    }
}
