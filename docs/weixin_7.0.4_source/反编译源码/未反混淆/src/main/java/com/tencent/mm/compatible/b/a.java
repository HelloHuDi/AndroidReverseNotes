package com.tencent.mm.compatible.b;

import android.app.NotificationManager;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a {
    public static void a(AudioManager audioManager, int i, int i2) {
        AppMethodBeat.i(92826);
        if (d.iW(24)) {
            ab.i("MicroMsg.AudioAdaptNHelp", "adjustStreamVolume()");
            try {
                audioManager.adjustStreamVolume(i, i2, 5);
                AppMethodBeat.o(92826);
                return;
            } catch (SecurityException e) {
                ab.e("MicroMsg.AudioAdaptNHelp", "adjustStreamVolume() Exception: %s", e.getMessage());
                requestPermission();
                AppMethodBeat.o(92826);
                return;
            }
        }
        audioManager.adjustStreamVolume(i, i2, 5);
        AppMethodBeat.o(92826);
    }

    public static void b(AudioManager audioManager, int i, int i2) {
        AppMethodBeat.i(92827);
        if (d.iW(24)) {
            ab.i("MicroMsg.AudioAdaptNHelp", "setStreamVolume()");
            try {
                audioManager.setStreamVolume(i, i2, 0);
                AppMethodBeat.o(92827);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.AudioAdaptNHelp", "setStreamVolume() Exception:%s", e.getMessage());
                requestPermission();
                AppMethodBeat.o(92827);
                return;
            }
        }
        audioManager.setStreamVolume(i, i2, 0);
        AppMethodBeat.o(92827);
    }

    private static void requestPermission() {
        AppMethodBeat.i(92828);
        ab.i("MicroMsg.AudioAdaptNHelp", "requestPermission() result:%s", Boolean.valueOf(((NotificationManager) ah.getContext().getSystemService("notification")).isNotificationPolicyAccessGranted()));
        if (!((NotificationManager) ah.getContext().getSystemService("notification")).isNotificationPolicyAccessGranted()) {
            try {
                Intent intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", ah.getPackageName());
                ah.getContext().startActivity(intent);
                AppMethodBeat.o(92828);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.AudioAdaptNHelp", "requestPermission() Exception:%s", e.getMessage());
            }
        }
        AppMethodBeat.o(92828);
    }
}
