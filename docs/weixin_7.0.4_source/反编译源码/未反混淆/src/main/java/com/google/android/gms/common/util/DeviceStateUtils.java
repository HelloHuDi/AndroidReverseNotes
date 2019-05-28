package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.stable.zzg;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.WMElement;

public final class DeviceStateUtils {
    private static final IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzzw;
    private static float zzzx = Float.NaN;

    static {
        AppMethodBeat.i(90195);
        AppMethodBeat.o(90195);
    }

    private DeviceStateUtils() {
    }

    @TargetApi(20)
    public static int getDeviceState(Context context) {
        int i = 1;
        AppMethodBeat.i(90188);
        if (context == null || context.getApplicationContext() == null) {
            AppMethodBeat.o(90188);
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, filter);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            AppMethodBeat.o(90188);
            return -1;
        }
        int i3 = (isInteractive(powerManager) ? 1 : 0) << 1;
        if (i2 == 0) {
            i = 0;
        }
        i3 |= i;
        AppMethodBeat.o(90188);
        return i3;
    }

    public static synchronized float getPowerPercentage(Context context) {
        float f;
        synchronized (DeviceStateUtils.class) {
            AppMethodBeat.i(90191);
            if (SystemClock.elapsedRealtime() - zzzw >= 60000 || Float.isNaN(zzzx)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, filter);
                if (registerReceiver != null) {
                    zzzx = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra(WMElement.ANIMATE_TYPE_SCALE, -1));
                }
                zzzw = SystemClock.elapsedRealtime();
                f = zzzx;
                AppMethodBeat.o(90191);
            } else {
                f = zzzx;
                AppMethodBeat.o(90191);
            }
        }
        return f;
    }

    public static boolean hasConsentedNlp(Context context) {
        AppMethodBeat.i(90194);
        if (zzg.getInt(context.getContentResolver(), "network_location_opt_in", -1) == 1) {
            AppMethodBeat.o(90194);
            return true;
        }
        AppMethodBeat.o(90194);
        return false;
    }

    public static boolean isCallActive(Context context) {
        AppMethodBeat.i(90192);
        if (((AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getMode() == 2) {
            AppMethodBeat.o(90192);
            return true;
        }
        AppMethodBeat.o(90192);
        return false;
    }

    public static boolean isInteractive(Context context) {
        AppMethodBeat.i(90189);
        boolean isInteractive = isInteractive((PowerManager) context.getSystemService("power"));
        AppMethodBeat.o(90189);
        return isInteractive;
    }

    @TargetApi(20)
    public static boolean isInteractive(PowerManager powerManager) {
        AppMethodBeat.i(90190);
        boolean isInteractive;
        if (PlatformVersion.isAtLeastKitKatWatch()) {
            isInteractive = powerManager.isInteractive();
            AppMethodBeat.o(90190);
            return isInteractive;
        }
        isInteractive = powerManager.isScreenOn();
        AppMethodBeat.o(90190);
        return isInteractive;
    }

    public static boolean isUserSetupComplete(Context context) {
        AppMethodBeat.i(90193);
        if (VERSION.SDK_INT < 23 || Secure.getInt(context.getContentResolver(), "user_setup_complete", -1) == 1) {
            AppMethodBeat.o(90193);
            return true;
        }
        AppMethodBeat.o(90193);
        return false;
    }

    @VisibleForTesting
    public static synchronized void resetForTest() {
        synchronized (DeviceStateUtils.class) {
            zzzw = 0;
            zzzx = Float.NaN;
        }
    }
}
