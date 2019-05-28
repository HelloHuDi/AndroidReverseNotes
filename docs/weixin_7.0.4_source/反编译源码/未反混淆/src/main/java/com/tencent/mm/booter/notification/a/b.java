package com.tencent.mm.booter.notification.a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.m.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.i;
import java.io.File;

public final class b {
    public int eel = 0;

    public final int a(Context context, boolean z, boolean z2, Notification notification, String str) {
        AppMethodBeat.i(16006);
        int a;
        if (a.MB()) {
            a = a(context, z, z2, notification);
            AppMethodBeat.o(16006);
            return a;
        }
        a = b(context, z, z2, notification, str);
        AppMethodBeat.o(16006);
        return a;
    }

    private int a(Context context, boolean z, boolean z2, Notification notification) {
        int i;
        AppMethodBeat.i(16007);
        if (notification == null) {
            notification = new Notification();
        }
        ab.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), g.b(notification.vibrate), notification.sound);
        if (z2) {
            notification.vibrate = bo.gjH;
        }
        if (z) {
            String MK = a.MK();
            if (bw(context)) {
                notification.sound = null;
                i = 0;
            } else if (MK == null || MK == i.evO) {
                i = 1;
            } else {
                notification.sound = Uri.parse(MK);
                i = 0;
            }
        } else {
            i = 0;
        }
        ab.i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", Integer.valueOf(i), g.b(notification.vibrate), notification.sound);
        this.eel = i;
        i = this.eel;
        AppMethodBeat.o(16007);
        return i;
    }

    private int b(Context context, boolean z, boolean z2, Notification notification, String str) {
        boolean z3;
        boolean z4;
        int i;
        boolean z5;
        int i2;
        boolean z6;
        AppMethodBeat.i(16008);
        ab.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), notification.vibrate, notification.sound);
        int i3 = 0;
        boolean z7 = false;
        boolean z8 = false;
        if (!z) {
            z3 = false;
        } else if (bw(context)) {
            z3 = true;
        } else {
            i3 = 1;
            z3 = false;
        }
        if (z2) {
            i3 |= 2;
        }
        String MK = a.MK();
        if (bo.isNullOrNil(str)) {
            ab.d("MicroMsg.NotificationDefaults", "msgContent is null");
        }
        if (MK != null && new File(MK).exists()) {
            MK = i.evO;
        }
        if (q.etn.esd != 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            if (ir(i3)) {
                i = i3 & -3;
                bo.z(context, true);
                z7 = true;
            } else {
                i = i3;
            }
            if (!is(i) || z3) {
                z5 = z7;
            } else {
                i &= -2;
                a.eey.jT(MK);
                z8 = true;
                z5 = z7;
            }
        } else {
            z5 = false;
            i = i3;
        }
        if (z3) {
            i2 = i & -2;
            a.eey.jT(MK);
            z6 = true;
        } else if (!is(i) || MK == null) {
            z6 = z8;
            i2 = i;
        } else {
            i2 = i & -2;
            notification.sound = Uri.parse(MK);
            z6 = z8;
        }
        this.eel = i2;
        ab.i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, DeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", Integer.valueOf(notification.defaults), g.b(notification.vibrate), notification.sound, MK, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6));
        i3 = this.eel;
        AppMethodBeat.o(16008);
        return i3;
    }

    private static boolean ir(int i) {
        return (i & 2) > 0;
    }

    private static boolean is(int i) {
        return (i & 1) > 0;
    }

    private static boolean bw(Context context) {
        AppMethodBeat.i(16009);
        AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (audioManager == null) {
            AppMethodBeat.o(16009);
            return false;
        }
        boolean isWiredHeadsetOn = audioManager.isWiredHeadsetOn();
        AppMethodBeat.o(16009);
        return isWiredHeadsetOn;
    }
}
