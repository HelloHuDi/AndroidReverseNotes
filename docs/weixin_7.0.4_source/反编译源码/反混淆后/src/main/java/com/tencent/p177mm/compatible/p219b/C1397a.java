package com.tencent.p177mm.compatible.p219b;

import android.app.NotificationManager;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.compatible.b.a */
public final class C1397a {
    /* renamed from: a */
    public static void m2943a(AudioManager audioManager, int i, int i2) {
        AppMethodBeat.m2504i(92826);
        if (C1443d.m3068iW(24)) {
            C4990ab.m7416i("MicroMsg.AudioAdaptNHelp", "adjustStreamVolume()");
            try {
                audioManager.adjustStreamVolume(i, i2, 5);
                AppMethodBeat.m2505o(92826);
                return;
            } catch (SecurityException e) {
                C4990ab.m7413e("MicroMsg.AudioAdaptNHelp", "adjustStreamVolume() Exception: %s", e.getMessage());
                C1397a.requestPermission();
                AppMethodBeat.m2505o(92826);
                return;
            }
        }
        audioManager.adjustStreamVolume(i, i2, 5);
        AppMethodBeat.m2505o(92826);
    }

    /* renamed from: b */
    public static void m2944b(AudioManager audioManager, int i, int i2) {
        AppMethodBeat.m2504i(92827);
        if (C1443d.m3068iW(24)) {
            C4990ab.m7416i("MicroMsg.AudioAdaptNHelp", "setStreamVolume()");
            try {
                audioManager.setStreamVolume(i, i2, 0);
                AppMethodBeat.m2505o(92827);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AudioAdaptNHelp", "setStreamVolume() Exception:%s", e.getMessage());
                C1397a.requestPermission();
                AppMethodBeat.m2505o(92827);
                return;
            }
        }
        audioManager.setStreamVolume(i, i2, 0);
        AppMethodBeat.m2505o(92827);
    }

    private static void requestPermission() {
        AppMethodBeat.m2504i(92828);
        C4990ab.m7417i("MicroMsg.AudioAdaptNHelp", "requestPermission() result:%s", Boolean.valueOf(((NotificationManager) C4996ah.getContext().getSystemService("notification")).isNotificationPolicyAccessGranted()));
        if (!((NotificationManager) C4996ah.getContext().getSystemService("notification")).isNotificationPolicyAccessGranted()) {
            try {
                Intent intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", C4996ah.getPackageName());
                C4996ah.getContext().startActivity(intent);
                AppMethodBeat.m2505o(92828);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AudioAdaptNHelp", "requestPermission() Exception:%s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(92828);
    }
}
