package com.tencent.p177mm.plugin.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.notification.b */
public final class C34626b {
    /* renamed from: a */
    public static boolean m56802a(Context context, NotificationManager notificationManager, boolean z, boolean z2, SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(125788);
        if (C4971b.dqw()) {
            String My = C45186a.m83261My();
            NotificationChannel a = C34626b.m56798a(notificationManager, My);
            if (a == null) {
                C34626b.m56800a(context, notificationManager, My, z, z2, sharedPreferences);
            } else if (a.getSound() == null) {
                try {
                    notificationManager.deleteNotificationChannel(a.getId());
                    C34626b.m56800a(context, notificationManager, "message_channel_compatibility_id", z, z2, sharedPreferences);
                    C45186a.aii("message_channel_compatibility_id");
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", e.getMessage());
                }
            } else {
                C34626b.m56800a(context, notificationManager, My, z, z2, sharedPreferences);
            }
            AppMethodBeat.m2505o(125788);
            return true;
        }
        AppMethodBeat.m2505o(125788);
        return false;
    }

    /* renamed from: b */
    public static boolean m56803b(Context context, NotificationManager notificationManager, boolean z, boolean z2, SharedPreferences sharedPreferences) {
        boolean z3;
        boolean z4;
        AppMethodBeat.m2504i(138323);
        String toLowerCase = (C34626b.getProperty("ro.build.version.emui")).toLowerCase();
        if (toLowerCase.startsWith("EmotionUI_8".toLowerCase())) {
            z3 = false;
            z4 = true;
        } else if (toLowerCase.startsWith("EmotionUI_9".toLowerCase())) {
            z3 = true;
            z4 = false;
        } else {
            z3 = false;
            z4 = false;
        }
        if (z4 || z3) {
            String My = C45186a.m83261My();
            NotificationChannel a = C34626b.m56798a(notificationManager, My);
            if (a == null) {
                C34626b.m56801a(context, notificationManager, My, z4, z3, z, z2, sharedPreferences);
            } else {
                int i;
                if (!z4 || (a.shouldVibrate() && a.getSound() != null)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    try {
                        if (a.getSound() != null) {
                            C18559f.m28903kA(a.getSound().toString());
                        }
                        notificationManager.deleteNotificationChannel(a.getId());
                        C34626b.m56801a(context, notificationManager, "message_channel_compatibility_id", true, false, z, z2, sharedPreferences);
                        C45186a.aii("message_channel_compatibility_id");
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", e.getMessage());
                    }
                } else {
                    C34626b.m56801a(context, notificationManager, My, z4, z3, z, z2, sharedPreferences);
                }
            }
            AppMethodBeat.m2505o(138323);
            return true;
        }
        AppMethodBeat.m2505o(138323);
        return false;
    }

    /* renamed from: a */
    private static void m56800a(Context context, NotificationManager notificationManager, String str, boolean z, boolean z2, SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(125790);
        NotificationChannel notificationChannel = new NotificationChannel(str, context.getString(C25738R.string.d9j), 4);
        notificationChannel.setDescription(context.getString(C25738R.string.d9i));
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setVibrationPattern(C5046bo.gjH);
        notificationChannel.enableVibration(z);
        if (z2) {
            String string = sharedPreferences.getString("settings.ringtone", C37885a.evO);
            if (!C5046bo.isNullOrNil(string)) {
                C4990ab.m7413e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s", Uri.parse(string));
                notificationChannel.setSound(Uri.parse(string), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        sharedPreferences.edit().putString("message_channel_id", str).commit();
        notificationManager.createNotificationChannel(notificationChannel);
        AppMethodBeat.m2505o(125790);
    }

    /* renamed from: a */
    private static void m56801a(Context context, NotificationManager notificationManager, String str, boolean z, boolean z2, boolean z3, boolean z4, SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(138324);
        NotificationChannel notificationChannel = new NotificationChannel(str, context.getString(C25738R.string.d9j), 4);
        notificationChannel.setDescription(context.getString(C25738R.string.d9i));
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setVibrationPattern(C5046bo.gjH);
        if (z) {
            notificationChannel.enableVibration(true);
        } else {
            notificationChannel.enableVibration(z3);
        }
        if (z) {
            if (z4) {
                C34626b.m56799a(notificationChannel, sharedPreferences);
            }
        } else if (z2) {
            if (z4) {
                C34626b.m56799a(notificationChannel, sharedPreferences);
            } else {
                notificationChannel.setSound(System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        sharedPreferences.edit().putString("message_channel_id", str).commit();
        notificationManager.createNotificationChannel(notificationChannel);
        AppMethodBeat.m2505o(138324);
    }

    /* renamed from: a */
    private static void m56799a(NotificationChannel notificationChannel, SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(125792);
        String string = sharedPreferences.getString("settings.ringtone", C37885a.evO);
        if (!C5046bo.isNullOrNil(string)) {
            C4990ab.m7413e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s", Uri.parse(string));
            notificationChannel.setSound(Uri.parse(string), Notification.AUDIO_ATTRIBUTES_DEFAULT);
        }
        AppMethodBeat.m2505o(125792);
    }

    private static String getProperty(String str) {
        String str2;
        AppMethodBeat.m2504i(125793);
        String str3 = "unknown";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, str3});
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NotificationManufacturerCompatibility", "getProperty() Exception:%s", e.getMessage());
            str2 = str3;
        }
        AppMethodBeat.m2505o(125793);
        return str2;
    }

    /* renamed from: a */
    private static NotificationChannel m56798a(NotificationManager notificationManager, String str) {
        AppMethodBeat.m2504i(125794);
        try {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null) {
                AppMethodBeat.m2505o(125794);
                return null;
            } else if (notificationChannels.size() <= 0) {
                AppMethodBeat.m2505o(125794);
                return null;
            } else {
                for (NotificationChannel notificationChannel : notificationChannels) {
                    if (notificationChannel != null && notificationChannel.getId() != null && C5046bo.isEqual(notificationChannel.getId(), str)) {
                        AppMethodBeat.m2505o(125794);
                        return notificationChannel;
                    }
                }
                AppMethodBeat.m2505o(125794);
                return null;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NotificationManufacturerCompatibility", "deleteNoNumberNotification exception:%s", e.getMessage());
        }
    }
}
