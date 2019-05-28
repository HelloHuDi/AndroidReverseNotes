package com.tencent.p177mm.plugin.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C24672an;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.notification.PluginNotification */
public class PluginNotification extends C7597f implements C46115a {
    private C24672an oVw;

    static {
        AppMethodBeat.m2504i(125798);
        if (C1443d.m3068iW(26)) {
            Context context = C4996ah.getContext();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            SharedPreferences Mz = C1668a.m3382Mz();
            boolean z = Mz.getBoolean("settings_sound", true);
            boolean z2 = Mz.getBoolean("settings_shake", true);
            PluginNotification.deleteNoWeChatSetNotification(notificationManager);
            PluginNotification.deleteNoNumberNotification(notificationManager, C45186a.m83261My(), "message_channel");
            C4990ab.m7417i("MicroMsg.PluginNotification", "isEnableMsgNotification:%s isSysEnableMsgNotification:%s sound:%s vibration:%s", Boolean.valueOf(C37885a.m63950MC()), Boolean.valueOf(C37885a.m63951MD()), Boolean.valueOf(z), Boolean.valueOf(z2));
            boolean b = C34626b.m56803b(context, notificationManager, z2, z, Mz);
            boolean a = C34626b.m56802a(context, notificationManager, z2, z, Mz);
            if (!(b || a)) {
                NotificationChannel notificationChannel = new NotificationChannel(C45186a.m83261My(), context.getString(C25738R.string.d9j), 4);
                notificationChannel.setDescription(context.getString(C25738R.string.d9i));
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.setVibrationPattern(C5046bo.gjH);
                notificationChannel.enableVibration(z2);
                if (z) {
                    String string = Mz.getString("settings.ringtone", C37885a.evO);
                    if (!C5046bo.isNullOrNil(string)) {
                        C4990ab.m7413e("MicroMsg.PluginNotification", "sound = %s", Uri.parse(string));
                        notificationChannel.setSound(Uri.parse(string), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                    }
                } else {
                    notificationChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
                Mz.edit().putString("message_channel_id", C45186a.m83261My()).commit();
                notificationManager.createNotificationChannel(notificationChannel);
            }
            NotificationChannel notificationChannel2 = new NotificationChannel("reminder_channel_id", context.getString(C25738R.string.d9u), 2);
            notificationChannel2.setDescription(context.getString(C25738R.string.d9t));
            notificationManager.createNotificationChannel(notificationChannel2);
            if (!C37885a.m63965MR()) {
                notificationChannel2 = new NotificationChannel("message_dnd_mode_channel_id", context.getString(C25738R.string.d9l), 4);
                notificationChannel2.setDescription(context.getString(C25738R.string.d9k));
                notificationChannel2.enableLights(true);
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.enableVibration(false);
                notificationChannel2.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                notificationManager.createNotificationChannel(notificationChannel2);
            }
        }
        AppMethodBeat.m2505o(125798);
    }

    public void execute(C1681g c1681g) {
    }

    public void setNotification(C24672an c24672an) {
        this.oVw = c24672an;
        C34633c.oVm = c24672an;
    }

    public C24672an getNotification() {
        return this.oVw;
    }

    private static void deleteNoNumberNotification(NotificationManager notificationManager, String str, String str2) {
        AppMethodBeat.m2504i(125795);
        try {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null) {
                AppMethodBeat.m2505o(125795);
            } else if (notificationChannels.size() <= 0) {
                AppMethodBeat.m2505o(125795);
            } else {
                for (NotificationChannel notificationChannel : notificationChannels) {
                    if (!(notificationChannel == null || notificationChannel.getId() == null || !notificationChannel.getId().startsWith(str2) || C5046bo.isEqual(notificationChannel.getId(), str))) {
                        notificationManager.deleteNotificationChannel(notificationChannel.getId());
                    }
                }
                AppMethodBeat.m2505o(125795);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.PluginNotification", "deleteNoNumberNotification exception:%s", e.getMessage());
            AppMethodBeat.m2505o(125795);
        }
    }

    private static void deleteNoWeChatSetNotification(NotificationManager notificationManager) {
        AppMethodBeat.m2504i(125796);
        try {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null) {
                AppMethodBeat.m2505o(125796);
            } else if (notificationChannels.size() <= 0) {
                AppMethodBeat.m2505o(125796);
            } else {
                for (NotificationChannel notificationChannel : notificationChannels) {
                    if (!(notificationChannel == null || notificationChannel.getId() == null || C5046bo.isEqual(notificationChannel.getId(), "message_dnd_mode_channel_id") || C5046bo.isEqual(notificationChannel.getId(), "reminder_channel_id") || notificationChannel.getId().startsWith("message_channel"))) {
                        C4990ab.m7417i("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification id:%s", notificationChannel.getId());
                        notificationManager.deleteNotificationChannel(notificationChannel.getId());
                    }
                }
                AppMethodBeat.m2505o(125796);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification exception:%s", e.getMessage());
            AppMethodBeat.m2505o(125796);
        }
    }

    public static void createActiveTimeNotification() {
        AppMethodBeat.m2504i(125797);
        if (C1443d.m3068iW(26)) {
            Context context = C4996ah.getContext();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (notificationManager.getNotificationChannel("message_dnd_mode_channel_id") == null) {
                NotificationChannel notificationChannel = new NotificationChannel("message_dnd_mode_channel_id", context.getString(C25738R.string.d9l), 4);
                notificationChannel.setDescription(context.getString(C25738R.string.d9k));
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        AppMethodBeat.m2505o(125797);
    }
}
