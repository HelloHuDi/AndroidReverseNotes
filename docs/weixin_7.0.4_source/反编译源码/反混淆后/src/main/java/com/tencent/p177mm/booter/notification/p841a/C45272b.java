package com.tencent.p177mm.booter.notification.p841a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.notification.p841a.C9192f.C9196a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p612ui.C5510e.C5502i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.booter.notification.a.b */
public final class C45272b {
    public int eel = 0;

    /* renamed from: a */
    public final int mo73171a(Context context, boolean z, boolean z2, Notification notification, String str) {
        AppMethodBeat.m2504i(16006);
        int a;
        if (C37885a.m63949MB()) {
            a = m83438a(context, z, z2, notification);
            AppMethodBeat.m2505o(16006);
            return a;
        }
        a = m83439b(context, z, z2, notification, str);
        AppMethodBeat.m2505o(16006);
        return a;
    }

    /* renamed from: a */
    private int m83438a(Context context, boolean z, boolean z2, Notification notification) {
        int i;
        AppMethodBeat.m2504i(16007);
        if (notification == null) {
            notification = new Notification();
        }
        C4990ab.m7417i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), C25977g.m41436b(notification.vibrate), notification.sound);
        if (z2) {
            notification.vibrate = C5046bo.gjH;
        }
        if (z) {
            String MK = C37885a.m63958MK();
            if (C45272b.m83440bw(context)) {
                notification.sound = null;
                i = 0;
            } else if (MK == null || MK == C5502i.evO) {
                i = 1;
            } else {
                notification.sound = Uri.parse(MK);
                i = 0;
            }
        } else {
            i = 0;
        }
        C4990ab.m7417i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", Integer.valueOf(i), C25977g.m41436b(notification.vibrate), notification.sound);
        this.eel = i;
        i = this.eel;
        AppMethodBeat.m2505o(16007);
        return i;
    }

    /* renamed from: b */
    private int m83439b(Context context, boolean z, boolean z2, Notification notification, String str) {
        boolean z3;
        boolean z4;
        int i;
        boolean z5;
        int i2;
        boolean z6;
        AppMethodBeat.m2504i(16008);
        C4990ab.m7417i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), notification.vibrate, notification.sound);
        int i3 = 0;
        boolean z7 = false;
        boolean z8 = false;
        if (!z) {
            z3 = false;
        } else if (C45272b.m83440bw(context)) {
            z3 = true;
        } else {
            i3 = 1;
            z3 = false;
        }
        if (z2) {
            i3 |= 2;
        }
        String MK = C37885a.m63958MK();
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7410d("MicroMsg.NotificationDefaults", "msgContent is null");
        }
        if (MK != null && new File(MK).exists()) {
            MK = C5502i.evO;
        }
        if (C1427q.etn.esd != 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            if (C45272b.m83441ir(i3)) {
                i = i3 & -3;
                C5046bo.m7589z(context, true);
                z7 = true;
            } else {
                i = i3;
            }
            if (!C45272b.m83442is(i) || z3) {
                z5 = z7;
            } else {
                i &= -2;
                C9196a.eey.mo20593jT(MK);
                z8 = true;
                z5 = z7;
            }
        } else {
            z5 = false;
            i = i3;
        }
        if (z3) {
            i2 = i & -2;
            C9196a.eey.mo20593jT(MK);
            z6 = true;
        } else if (!C45272b.m83442is(i) || MK == null) {
            z6 = z8;
            i2 = i;
        } else {
            i2 = i & -2;
            notification.sound = Uri.parse(MK);
            z6 = z8;
        }
        this.eel = i2;
        C4990ab.m7417i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, DeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", Integer.valueOf(notification.defaults), C25977g.m41436b(notification.vibrate), notification.sound, MK, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6));
        i3 = this.eel;
        AppMethodBeat.m2505o(16008);
        return i3;
    }

    /* renamed from: ir */
    private static boolean m83441ir(int i) {
        return (i & 2) > 0;
    }

    /* renamed from: is */
    private static boolean m83442is(int i) {
        return (i & 1) > 0;
    }

    /* renamed from: bw */
    private static boolean m83440bw(Context context) {
        AppMethodBeat.m2504i(16009);
        AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (audioManager == null) {
            AppMethodBeat.m2505o(16009);
            return false;
        }
        boolean isWiredHeadsetOn = audioManager.isWiredHeadsetOn();
        AppMethodBeat.m2505o(16009);
        return isWiredHeadsetOn;
    }
}
