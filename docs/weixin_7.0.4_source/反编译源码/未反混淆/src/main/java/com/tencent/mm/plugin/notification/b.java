package com.tencent.mm.plugin.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bo.a;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class b {
    public static boolean a(Context context, NotificationManager notificationManager, boolean z, boolean z2, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(125788);
        if (com.tencent.mm.sdk.h.b.dqw()) {
            String My = a.My();
            NotificationChannel a = a(notificationManager, My);
            if (a == null) {
                a(context, notificationManager, My, z, z2, sharedPreferences);
            } else if (a.getSound() == null) {
                try {
                    notificationManager.deleteNotificationChannel(a.getId());
                    a(context, notificationManager, "message_channel_compatibility_id", z, z2, sharedPreferences);
                    a.aii("message_channel_compatibility_id");
                } catch (Exception e) {
                    ab.e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", e.getMessage());
                }
            } else {
                a(context, notificationManager, My, z, z2, sharedPreferences);
            }
            AppMethodBeat.o(125788);
            return true;
        }
        AppMethodBeat.o(125788);
        return false;
    }

    public static boolean b(Context context, NotificationManager notificationManager, boolean z, boolean z2, SharedPreferences sharedPreferences) {
        boolean z3;
        boolean z4;
        AppMethodBeat.i(138323);
        String toLowerCase = (getProperty("ro.build.version.emui")).toLowerCase();
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
            String My = a.My();
            NotificationChannel a = a(notificationManager, My);
            if (a == null) {
                a(context, notificationManager, My, z4, z3, z, z2, sharedPreferences);
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
                            f.kA(a.getSound().toString());
                        }
                        notificationManager.deleteNotificationChannel(a.getId());
                        a(context, notificationManager, "message_channel_compatibility_id", true, false, z, z2, sharedPreferences);
                        a.aii("message_channel_compatibility_id");
                    } catch (Exception e) {
                        ab.e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", e.getMessage());
                    }
                } else {
                    a(context, notificationManager, My, z4, z3, z, z2, sharedPreferences);
                }
            }
            AppMethodBeat.o(138323);
            return true;
        }
        AppMethodBeat.o(138323);
        return false;
    }

    private static void a(Context context, NotificationManager notificationManager, String str, boolean z, boolean z2, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(125790);
        NotificationChannel notificationChannel = new NotificationChannel(str, context.getString(R.string.d9j), 4);
        notificationChannel.setDescription(context.getString(R.string.d9i));
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setVibrationPattern(bo.gjH);
        notificationChannel.enableVibration(z);
        if (z2) {
            String string = sharedPreferences.getString("settings.ringtone", com.tencent.mm.m.a.evO);
            if (!bo.isNullOrNil(string)) {
                ab.e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s", Uri.parse(string));
                notificationChannel.setSound(Uri.parse(string), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        sharedPreferences.edit().putString("message_channel_id", str).commit();
        notificationManager.createNotificationChannel(notificationChannel);
        AppMethodBeat.o(125790);
    }

    private static void a(Context context, NotificationManager notificationManager, String str, boolean z, boolean z2, boolean z3, boolean z4, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(138324);
        NotificationChannel notificationChannel = new NotificationChannel(str, context.getString(R.string.d9j), 4);
        notificationChannel.setDescription(context.getString(R.string.d9i));
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setVibrationPattern(bo.gjH);
        if (z) {
            notificationChannel.enableVibration(true);
        } else {
            notificationChannel.enableVibration(z3);
        }
        if (z) {
            if (z4) {
                a(notificationChannel, sharedPreferences);
            }
        } else if (z2) {
            if (z4) {
                a(notificationChannel, sharedPreferences);
            } else {
                notificationChannel.setSound(System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        sharedPreferences.edit().putString("message_channel_id", str).commit();
        notificationManager.createNotificationChannel(notificationChannel);
        AppMethodBeat.o(138324);
    }

    private static void a(NotificationChannel notificationChannel, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(125792);
        String string = sharedPreferences.getString("settings.ringtone", com.tencent.mm.m.a.evO);
        if (!bo.isNullOrNil(string)) {
            ab.e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s", Uri.parse(string));
            notificationChannel.setSound(Uri.parse(string), Notification.AUDIO_ATTRIBUTES_DEFAULT);
        }
        AppMethodBeat.o(125792);
    }

    private static String getProperty(String str) {
        String str2;
        AppMethodBeat.i(125793);
        String str3 = "unknown";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, str3});
        } catch (Exception e) {
            ab.e("MicroMsg.NotificationManufacturerCompatibility", "getProperty() Exception:%s", e.getMessage());
            str2 = str3;
        }
        AppMethodBeat.o(125793);
        return str2;
    }

    private static NotificationChannel a(NotificationManager notificationManager, String str) {
        AppMethodBeat.i(125794);
        try {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null) {
                AppMethodBeat.o(125794);
                return null;
            } else if (notificationChannels.size() <= 0) {
                AppMethodBeat.o(125794);
                return null;
            } else {
                for (NotificationChannel notificationChannel : notificationChannels) {
                    if (notificationChannel != null && notificationChannel.getId() != null && bo.isEqual(notificationChannel.getId(), str)) {
                        AppMethodBeat.o(125794);
                        return notificationChannel;
                    }
                }
                AppMethodBeat.o(125794);
                return null;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.NotificationManufacturerCompatibility", "deleteNoNumberNotification exception:%s", e.getMessage());
        }
    }
}
