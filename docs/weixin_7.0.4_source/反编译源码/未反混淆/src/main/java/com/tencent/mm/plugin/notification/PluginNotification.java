package com.tencent.mm.plugin.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.an;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class PluginNotification extends f implements a {
    private an oVw;

    static {
        AppMethodBeat.i(125798);
        if (d.iW(26)) {
            Context context = ah.getContext();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            SharedPreferences Mz = com.tencent.mm.kernel.a.Mz();
            boolean z = Mz.getBoolean("settings_sound", true);
            boolean z2 = Mz.getBoolean("settings_shake", true);
            deleteNoWeChatSetNotification(notificationManager);
            deleteNoNumberNotification(notificationManager, com.tencent.mm.bo.a.My(), "message_channel");
            ab.i("MicroMsg.PluginNotification", "isEnableMsgNotification:%s isSysEnableMsgNotification:%s sound:%s vibration:%s", Boolean.valueOf(com.tencent.mm.m.a.MC()), Boolean.valueOf(com.tencent.mm.m.a.MD()), Boolean.valueOf(z), Boolean.valueOf(z2));
            boolean b = b.b(context, notificationManager, z2, z, Mz);
            boolean a = b.a(context, notificationManager, z2, z, Mz);
            if (!(b || a)) {
                NotificationChannel notificationChannel = new NotificationChannel(com.tencent.mm.bo.a.My(), context.getString(R.string.d9j), 4);
                notificationChannel.setDescription(context.getString(R.string.d9i));
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.setVibrationPattern(bo.gjH);
                notificationChannel.enableVibration(z2);
                if (z) {
                    String string = Mz.getString("settings.ringtone", com.tencent.mm.m.a.evO);
                    if (!bo.isNullOrNil(string)) {
                        ab.e("MicroMsg.PluginNotification", "sound = %s", Uri.parse(string));
                        notificationChannel.setSound(Uri.parse(string), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                    }
                } else {
                    notificationChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
                Mz.edit().putString("message_channel_id", com.tencent.mm.bo.a.My()).commit();
                notificationManager.createNotificationChannel(notificationChannel);
            }
            NotificationChannel notificationChannel2 = new NotificationChannel("reminder_channel_id", context.getString(R.string.d9u), 2);
            notificationChannel2.setDescription(context.getString(R.string.d9t));
            notificationManager.createNotificationChannel(notificationChannel2);
            if (!com.tencent.mm.m.a.MR()) {
                notificationChannel2 = new NotificationChannel("message_dnd_mode_channel_id", context.getString(R.string.d9l), 4);
                notificationChannel2.setDescription(context.getString(R.string.d9k));
                notificationChannel2.enableLights(true);
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.enableVibration(false);
                notificationChannel2.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                notificationManager.createNotificationChannel(notificationChannel2);
            }
        }
        AppMethodBeat.o(125798);
    }

    public void execute(g gVar) {
    }

    public void setNotification(an anVar) {
        this.oVw = anVar;
        c.oVm = anVar;
    }

    public an getNotification() {
        return this.oVw;
    }

    private static void deleteNoNumberNotification(NotificationManager notificationManager, String str, String str2) {
        AppMethodBeat.i(125795);
        try {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null) {
                AppMethodBeat.o(125795);
            } else if (notificationChannels.size() <= 0) {
                AppMethodBeat.o(125795);
            } else {
                for (NotificationChannel notificationChannel : notificationChannels) {
                    if (!(notificationChannel == null || notificationChannel.getId() == null || !notificationChannel.getId().startsWith(str2) || bo.isEqual(notificationChannel.getId(), str))) {
                        notificationManager.deleteNotificationChannel(notificationChannel.getId());
                    }
                }
                AppMethodBeat.o(125795);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.PluginNotification", "deleteNoNumberNotification exception:%s", e.getMessage());
            AppMethodBeat.o(125795);
        }
    }

    private static void deleteNoWeChatSetNotification(NotificationManager notificationManager) {
        AppMethodBeat.i(125796);
        try {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null) {
                AppMethodBeat.o(125796);
            } else if (notificationChannels.size() <= 0) {
                AppMethodBeat.o(125796);
            } else {
                for (NotificationChannel notificationChannel : notificationChannels) {
                    if (!(notificationChannel == null || notificationChannel.getId() == null || bo.isEqual(notificationChannel.getId(), "message_dnd_mode_channel_id") || bo.isEqual(notificationChannel.getId(), "reminder_channel_id") || notificationChannel.getId().startsWith("message_channel"))) {
                        ab.i("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification id:%s", notificationChannel.getId());
                        notificationManager.deleteNotificationChannel(notificationChannel.getId());
                    }
                }
                AppMethodBeat.o(125796);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification exception:%s", e.getMessage());
            AppMethodBeat.o(125796);
        }
    }

    public static void createActiveTimeNotification() {
        AppMethodBeat.i(125797);
        if (d.iW(26)) {
            Context context = ah.getContext();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (notificationManager.getNotificationChannel("message_dnd_mode_channel_id") == null) {
                NotificationChannel notificationChannel = new NotificationChannel("message_dnd_mode_channel_id", context.getString(R.string.d9l), 4);
                notificationChannel.setDescription(context.getString(R.string.d9k));
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        AppMethodBeat.o(125797);
    }
}
