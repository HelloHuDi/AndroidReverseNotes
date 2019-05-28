package com.tencent.mm.m;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class a {
    private static int evN = -1;
    public static final String evO = null;
    private static String evP = "";
    private static SharedPreferences evQ = null;
    private static NotificationChannel evR;
    private static String evS = evO;
    private static boolean evT = false;
    private static boolean evU = false;

    private static String My() {
        AppMethodBeat.i(77630);
        if (bo.isNullOrNil(evP)) {
            evP = com.tencent.mm.kernel.a.Mz().getString("message_channel_id", "message_channel_new_id");
        }
        String str = evP;
        AppMethodBeat.o(77630);
        return str;
    }

    protected static SharedPreferences Mz() {
        AppMethodBeat.i(77631);
        SharedPreferences sharedPreferences;
        if (evQ != null) {
            sharedPreferences = evQ;
            AppMethodBeat.o(77631);
            return sharedPreferences;
        }
        sharedPreferences = com.tencent.mm.kernel.a.Mz();
        evQ = sharedPreferences;
        AppMethodBeat.o(77631);
        return sharedPreferences;
    }

    public static SharedPreferences MA() {
        AppMethodBeat.i(77632);
        SharedPreferences anh = aa.anh();
        AppMethodBeat.o(77632);
        return anh;
    }

    public static boolean MB() {
        AppMethodBeat.i(77633);
        if (d.iW(26)) {
            AppMethodBeat.o(77633);
            return true;
        }
        AppMethodBeat.o(77633);
        return false;
    }

    public static boolean MC() {
        AppMethodBeat.i(77634);
        boolean z = Mz().getBoolean("settings_new_msg_notification", true);
        AppMethodBeat.o(77634);
        return z;
    }

    public static boolean MD() {
        AppMethodBeat.i(77635);
        if (y.L(ah.getContext()).areNotificationsEnabled()) {
            if (d.iW(26)) {
                if (evR == null) {
                    evR = ((NotificationManager) ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(My());
                }
                if (evR != null && evR.getImportance() <= 0) {
                    AppMethodBeat.o(77635);
                    return false;
                }
            }
            AppMethodBeat.o(77635);
            return true;
        }
        AppMethodBeat.o(77635);
        return false;
    }

    public static boolean ME() {
        AppMethodBeat.i(77636);
        boolean z = Mz().getBoolean("settings_new_voip_msg_notification", true);
        AppMethodBeat.o(77636);
        return z;
    }

    public static boolean MF() {
        AppMethodBeat.i(77637);
        boolean z = Mz().getBoolean("settings_show_detail", true);
        AppMethodBeat.o(77637);
        return z;
    }

    public static boolean MG() {
        boolean z;
        AppMethodBeat.i(77638);
        boolean z2 = Mz().getBoolean("settings_sound", true);
        if (!d.iW(26)) {
            z = z2;
        } else if (evN == 0) {
            z = MH();
            if (z2 != z) {
                f.bO(z);
            }
        } else {
            z = ML();
        }
        AppMethodBeat.o(77638);
        return z;
    }

    public static boolean MH() {
        AppMethodBeat.i(77639);
        if (d.iW(26)) {
            NotificationChannel notificationChannel = ((NotificationManager) ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(My());
            if (notificationChannel != null && notificationChannel.getImportance() < 3) {
                AppMethodBeat.o(77639);
                return false;
            } else if (notificationChannel != null && notificationChannel.getSound() == null) {
                AppMethodBeat.o(77639);
                return false;
            }
        }
        int importance = y.L(ah.getContext()).getImportance();
        if (importance < 3 && importance != -1000) {
            AppMethodBeat.o(77639);
            return false;
        }
        AppMethodBeat.o(77639);
        return true;
    }

    public static boolean MI() {
        boolean z;
        AppMethodBeat.i(77640);
        boolean z2 = Mz().getBoolean("settings_shake", true);
        if (!d.iW(26)) {
            z = z2;
        } else if (evN == 0) {
            z = MJ();
            if (z != z2) {
                f.bP(z);
            }
        } else {
            z = MM();
        }
        AppMethodBeat.o(77640);
        return z;
    }

    public static boolean MJ() {
        AppMethodBeat.i(77641);
        if (d.iW(26)) {
            NotificationChannel notificationChannel = ((NotificationManager) ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(My());
            if (notificationChannel != null && (notificationChannel.getImportance() < 3 || !notificationChannel.shouldVibrate())) {
                AppMethodBeat.o(77641);
                return false;
            }
        }
        int importance = y.L(ah.getContext()).getImportance();
        if (importance < 3 && importance != -1000) {
            AppMethodBeat.o(77641);
            return false;
        }
        AppMethodBeat.o(77641);
        return true;
    }

    public static String MK() {
        AppMethodBeat.i(77642);
        String str;
        if (d.iW(26)) {
            NotificationChannel notificationChannel = ((NotificationManager) ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(My());
            if (notificationChannel == null || notificationChannel.getSound() == null) {
                str = "";
                AppMethodBeat.o(77642);
                return str;
            }
            str = notificationChannel.getSound().toString();
            AppMethodBeat.o(77642);
            return str;
        }
        str = Mz().getString("settings.ringtone", evO);
        if (!(str == evO || str.equals(evS))) {
            RingtoneManager ringtoneManager = new RingtoneManager(ah.getContext());
            ringtoneManager.setType(2);
            try {
                if (ringtoneManager.getRingtonePosition(Uri.parse(str)) < 0) {
                    str = evO;
                    kA(str);
                    ab.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.BaseNotificationConfig", e, "ringTone() Exception:%s", e.getMessage());
            }
            evS = str;
        }
        AppMethodBeat.o(77642);
        return str;
    }

    static void kA(String str) {
        AppMethodBeat.i(77643);
        Mz().edit().putString("settings.ringtone", str).commit();
        AppMethodBeat.o(77643);
    }

    public static boolean ML() {
        AppMethodBeat.i(77644);
        SharedPreferences Mz = Mz();
        boolean z = Mz.getBoolean("settings_special_scene_sound", Mz.getBoolean("settings_sound", true));
        AppMethodBeat.o(77644);
        return z;
    }

    public static boolean MM() {
        AppMethodBeat.i(77645);
        SharedPreferences Mz = Mz();
        boolean z = Mz.getBoolean("settings_special_scene_shake", Mz.getBoolean("settings_shake", true));
        AppMethodBeat.o(77645);
        return z;
    }

    public static boolean MN() {
        AppMethodBeat.i(77646);
        SharedPreferences Mz = Mz();
        boolean z = Mz.getBoolean("settings_voip_scene_sound", MG());
        if (!evT) {
            evT = true;
            Mz.edit().putBoolean("settings_voip_scene_sound", z).commit();
        }
        AppMethodBeat.o(77646);
        return z;
    }

    public static boolean MO() {
        AppMethodBeat.i(77647);
        SharedPreferences Mz = Mz();
        boolean z = Mz.getBoolean("settings_voip_scene_shake", MI());
        if (!evU) {
            evU = true;
            Mz.edit().putBoolean("settings_voip_scene_shake", z).commit();
        }
        AppMethodBeat.o(77647);
        return z;
    }

    public static int MP() {
        return evN;
    }

    public static void MQ() {
        AppMethodBeat.i(77648);
        if (b.dqw()) {
            evN = 1;
            ab.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() mSpecialSceneSwitchEnable:%s", Integer.valueOf(evN));
            AppMethodBeat.o(77648);
            return;
        }
        int i = Mz().getInt("special_scene_enable", -1);
        if (bo.gW(i, -1)) {
            evN = 0;
        } else {
            evN = i;
        }
        ab.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() sceneEnable:%s mSpecialSceneSwitchEnable:%s", Integer.valueOf(i), Integer.valueOf(evN));
        AppMethodBeat.o(77648);
    }

    public static boolean MR() {
        AppMethodBeat.i(77649);
        boolean z = Mz().getBoolean("settings_active_time_full", true);
        AppMethodBeat.o(77649);
        return z;
    }

    public static int MS() {
        AppMethodBeat.i(77650);
        int i = Mz().getInt("settings_active_begin_time_hour", 8);
        AppMethodBeat.o(77650);
        return i;
    }

    public static int MT() {
        AppMethodBeat.i(77651);
        int i = Mz().getInt("settings_active_end_time_hour", 23);
        AppMethodBeat.o(77651);
        return i;
    }

    public static int MU() {
        AppMethodBeat.i(77652);
        int i = Mz().getInt("settings_active_begin_time_min", 0);
        AppMethodBeat.o(77652);
        return i;
    }

    public static int MV() {
        AppMethodBeat.i(77653);
        int i = Mz().getInt("settings_active_end_time_min", 0);
        AppMethodBeat.o(77653);
        return i;
    }

    public static boolean bS(int i, int i2) {
        AppMethodBeat.i(77654);
        if (MR()) {
            AppMethodBeat.o(77654);
            return true;
        }
        int MS = MS();
        int MU = MU();
        int MT = MT();
        int MV = MV();
        if (MS == MT && MU == MV) {
            AppMethodBeat.o(77654);
            return false;
        } else if (MS != MT || MU >= MV) {
            if (MT > MS) {
                if ((i <= MS || i >= MT) && ((i != MS || i2 <= MU) && (i != MT || i2 >= MV))) {
                    AppMethodBeat.o(77654);
                    return false;
                }
                AppMethodBeat.o(77654);
                return true;
            } else if (MT >= MS && (MS != MT || MU <= MV)) {
                AppMethodBeat.o(77654);
                return true;
            } else if ((i <= MS || i > 23) && ((i != MS || i2 <= MU) && ((i != MT || i2 >= MV) && (i <= 0 || i >= MT)))) {
                AppMethodBeat.o(77654);
                return false;
            } else {
                AppMethodBeat.o(77654);
                return true;
            }
        } else if (i != MS || i2 <= MU || i2 >= MV) {
            AppMethodBeat.o(77654);
            return false;
        } else {
            AppMethodBeat.o(77654);
            return true;
        }
    }
}
