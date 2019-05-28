package com.tencent.p177mm.p249m;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.p057v4.app.C17432y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.m.a */
public class C37885a {
    private static int evN = -1;
    public static final String evO = null;
    private static String evP = "";
    private static SharedPreferences evQ = null;
    private static NotificationChannel evR;
    private static String evS = evO;
    private static boolean evT = false;
    private static boolean evU = false;

    /* renamed from: My */
    private static String m63970My() {
        AppMethodBeat.m2504i(77630);
        if (C5046bo.isNullOrNil(evP)) {
            evP = C1668a.m3382Mz().getString("message_channel_id", "message_channel_new_id");
        }
        String str = evP;
        AppMethodBeat.m2505o(77630);
        return str;
    }

    /* renamed from: Mz */
    protected static SharedPreferences m63971Mz() {
        AppMethodBeat.m2504i(77631);
        SharedPreferences sharedPreferences;
        if (evQ != null) {
            sharedPreferences = evQ;
            AppMethodBeat.m2505o(77631);
            return sharedPreferences;
        }
        sharedPreferences = C1668a.m3382Mz();
        evQ = sharedPreferences;
        AppMethodBeat.m2505o(77631);
        return sharedPreferences;
    }

    /* renamed from: MA */
    public static SharedPreferences m63948MA() {
        AppMethodBeat.m2504i(77632);
        SharedPreferences anh = C1892aa.anh();
        AppMethodBeat.m2505o(77632);
        return anh;
    }

    /* renamed from: MB */
    public static boolean m63949MB() {
        AppMethodBeat.m2504i(77633);
        if (C1443d.m3068iW(26)) {
            AppMethodBeat.m2505o(77633);
            return true;
        }
        AppMethodBeat.m2505o(77633);
        return false;
    }

    /* renamed from: MC */
    public static boolean m63950MC() {
        AppMethodBeat.m2504i(77634);
        boolean z = C37885a.m63971Mz().getBoolean("settings_new_msg_notification", true);
        AppMethodBeat.m2505o(77634);
        return z;
    }

    /* renamed from: MD */
    public static boolean m63951MD() {
        AppMethodBeat.m2504i(77635);
        if (C17432y.m27074L(C4996ah.getContext()).areNotificationsEnabled()) {
            if (C1443d.m3068iW(26)) {
                if (evR == null) {
                    evR = ((NotificationManager) C4996ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(C37885a.m63970My());
                }
                if (evR != null && evR.getImportance() <= 0) {
                    AppMethodBeat.m2505o(77635);
                    return false;
                }
            }
            AppMethodBeat.m2505o(77635);
            return true;
        }
        AppMethodBeat.m2505o(77635);
        return false;
    }

    /* renamed from: ME */
    public static boolean m63952ME() {
        AppMethodBeat.m2504i(77636);
        boolean z = C37885a.m63971Mz().getBoolean("settings_new_voip_msg_notification", true);
        AppMethodBeat.m2505o(77636);
        return z;
    }

    /* renamed from: MF */
    public static boolean m63953MF() {
        AppMethodBeat.m2504i(77637);
        boolean z = C37885a.m63971Mz().getBoolean("settings_show_detail", true);
        AppMethodBeat.m2505o(77637);
        return z;
    }

    /* renamed from: MG */
    public static boolean m63954MG() {
        boolean z;
        AppMethodBeat.m2504i(77638);
        boolean z2 = C37885a.m63971Mz().getBoolean("settings_sound", true);
        if (!C1443d.m3068iW(26)) {
            z = z2;
        } else if (evN == 0) {
            z = C37885a.m63955MH();
            if (z2 != z) {
                C18559f.m28891bO(z);
            }
        } else {
            z = C37885a.m63959ML();
        }
        AppMethodBeat.m2505o(77638);
        return z;
    }

    /* renamed from: MH */
    public static boolean m63955MH() {
        AppMethodBeat.m2504i(77639);
        if (C1443d.m3068iW(26)) {
            NotificationChannel notificationChannel = ((NotificationManager) C4996ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(C37885a.m63970My());
            if (notificationChannel != null && notificationChannel.getImportance() < 3) {
                AppMethodBeat.m2505o(77639);
                return false;
            } else if (notificationChannel != null && notificationChannel.getSound() == null) {
                AppMethodBeat.m2505o(77639);
                return false;
            }
        }
        int importance = C17432y.m27074L(C4996ah.getContext()).getImportance();
        if (importance < 3 && importance != -1000) {
            AppMethodBeat.m2505o(77639);
            return false;
        }
        AppMethodBeat.m2505o(77639);
        return true;
    }

    /* renamed from: MI */
    public static boolean m63956MI() {
        boolean z;
        AppMethodBeat.m2504i(77640);
        boolean z2 = C37885a.m63971Mz().getBoolean("settings_shake", true);
        if (!C1443d.m3068iW(26)) {
            z = z2;
        } else if (evN == 0) {
            z = C37885a.m63957MJ();
            if (z != z2) {
                C18559f.m28892bP(z);
            }
        } else {
            z = C37885a.m63960MM();
        }
        AppMethodBeat.m2505o(77640);
        return z;
    }

    /* renamed from: MJ */
    public static boolean m63957MJ() {
        AppMethodBeat.m2504i(77641);
        if (C1443d.m3068iW(26)) {
            NotificationChannel notificationChannel = ((NotificationManager) C4996ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(C37885a.m63970My());
            if (notificationChannel != null && (notificationChannel.getImportance() < 3 || !notificationChannel.shouldVibrate())) {
                AppMethodBeat.m2505o(77641);
                return false;
            }
        }
        int importance = C17432y.m27074L(C4996ah.getContext()).getImportance();
        if (importance < 3 && importance != -1000) {
            AppMethodBeat.m2505o(77641);
            return false;
        }
        AppMethodBeat.m2505o(77641);
        return true;
    }

    /* renamed from: MK */
    public static String m63958MK() {
        AppMethodBeat.m2504i(77642);
        String str;
        if (C1443d.m3068iW(26)) {
            NotificationChannel notificationChannel = ((NotificationManager) C4996ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(C37885a.m63970My());
            if (notificationChannel == null || notificationChannel.getSound() == null) {
                str = "";
                AppMethodBeat.m2505o(77642);
                return str;
            }
            str = notificationChannel.getSound().toString();
            AppMethodBeat.m2505o(77642);
            return str;
        }
        str = C37885a.m63971Mz().getString("settings.ringtone", evO);
        if (!(str == evO || str.equals(evS))) {
            RingtoneManager ringtoneManager = new RingtoneManager(C4996ah.getContext());
            ringtoneManager.setType(2);
            try {
                if (ringtoneManager.getRingtonePosition(Uri.parse(str)) < 0) {
                    str = evO;
                    C37885a.m63973kA(str);
                    C4990ab.m7416i("MicroMsg.BaseNotificationConfig", "reset ringTone");
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.BaseNotificationConfig", e, "ringTone() Exception:%s", e.getMessage());
            }
            evS = str;
        }
        AppMethodBeat.m2505o(77642);
        return str;
    }

    /* renamed from: kA */
    static void m63973kA(String str) {
        AppMethodBeat.m2504i(77643);
        C37885a.m63971Mz().edit().putString("settings.ringtone", str).commit();
        AppMethodBeat.m2505o(77643);
    }

    /* renamed from: ML */
    public static boolean m63959ML() {
        AppMethodBeat.m2504i(77644);
        SharedPreferences Mz = C37885a.m63971Mz();
        boolean z = Mz.getBoolean("settings_special_scene_sound", Mz.getBoolean("settings_sound", true));
        AppMethodBeat.m2505o(77644);
        return z;
    }

    /* renamed from: MM */
    public static boolean m63960MM() {
        AppMethodBeat.m2504i(77645);
        SharedPreferences Mz = C37885a.m63971Mz();
        boolean z = Mz.getBoolean("settings_special_scene_shake", Mz.getBoolean("settings_shake", true));
        AppMethodBeat.m2505o(77645);
        return z;
    }

    /* renamed from: MN */
    public static boolean m63961MN() {
        AppMethodBeat.m2504i(77646);
        SharedPreferences Mz = C37885a.m63971Mz();
        boolean z = Mz.getBoolean("settings_voip_scene_sound", C37885a.m63954MG());
        if (!evT) {
            evT = true;
            Mz.edit().putBoolean("settings_voip_scene_sound", z).commit();
        }
        AppMethodBeat.m2505o(77646);
        return z;
    }

    /* renamed from: MO */
    public static boolean m63962MO() {
        AppMethodBeat.m2504i(77647);
        SharedPreferences Mz = C37885a.m63971Mz();
        boolean z = Mz.getBoolean("settings_voip_scene_shake", C37885a.m63956MI());
        if (!evU) {
            evU = true;
            Mz.edit().putBoolean("settings_voip_scene_shake", z).commit();
        }
        AppMethodBeat.m2505o(77647);
        return z;
    }

    /* renamed from: MP */
    public static int m63963MP() {
        return evN;
    }

    /* renamed from: MQ */
    public static void m63964MQ() {
        AppMethodBeat.m2504i(77648);
        if (C4971b.dqw()) {
            evN = 1;
            C4990ab.m7417i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() mSpecialSceneSwitchEnable:%s", Integer.valueOf(evN));
            AppMethodBeat.m2505o(77648);
            return;
        }
        int i = C37885a.m63971Mz().getInt("special_scene_enable", -1);
        if (C5046bo.m7563gW(i, -1)) {
            evN = 0;
        } else {
            evN = i;
        }
        C4990ab.m7417i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() sceneEnable:%s mSpecialSceneSwitchEnable:%s", Integer.valueOf(i), Integer.valueOf(evN));
        AppMethodBeat.m2505o(77648);
    }

    /* renamed from: MR */
    public static boolean m63965MR() {
        AppMethodBeat.m2504i(77649);
        boolean z = C37885a.m63971Mz().getBoolean("settings_active_time_full", true);
        AppMethodBeat.m2505o(77649);
        return z;
    }

    /* renamed from: MS */
    public static int m63966MS() {
        AppMethodBeat.m2504i(77650);
        int i = C37885a.m63971Mz().getInt("settings_active_begin_time_hour", 8);
        AppMethodBeat.m2505o(77650);
        return i;
    }

    /* renamed from: MT */
    public static int m63967MT() {
        AppMethodBeat.m2504i(77651);
        int i = C37885a.m63971Mz().getInt("settings_active_end_time_hour", 23);
        AppMethodBeat.m2505o(77651);
        return i;
    }

    /* renamed from: MU */
    public static int m63968MU() {
        AppMethodBeat.m2504i(77652);
        int i = C37885a.m63971Mz().getInt("settings_active_begin_time_min", 0);
        AppMethodBeat.m2505o(77652);
        return i;
    }

    /* renamed from: MV */
    public static int m63969MV() {
        AppMethodBeat.m2504i(77653);
        int i = C37885a.m63971Mz().getInt("settings_active_end_time_min", 0);
        AppMethodBeat.m2505o(77653);
        return i;
    }

    /* renamed from: bS */
    public static boolean m63972bS(int i, int i2) {
        AppMethodBeat.m2504i(77654);
        if (C37885a.m63965MR()) {
            AppMethodBeat.m2505o(77654);
            return true;
        }
        int MS = C37885a.m63966MS();
        int MU = C37885a.m63968MU();
        int MT = C37885a.m63967MT();
        int MV = C37885a.m63969MV();
        if (MS == MT && MU == MV) {
            AppMethodBeat.m2505o(77654);
            return false;
        } else if (MS != MT || MU >= MV) {
            if (MT > MS) {
                if ((i <= MS || i >= MT) && ((i != MS || i2 <= MU) && (i != MT || i2 >= MV))) {
                    AppMethodBeat.m2505o(77654);
                    return false;
                }
                AppMethodBeat.m2505o(77654);
                return true;
            } else if (MT >= MS && (MS != MT || MU <= MV)) {
                AppMethodBeat.m2505o(77654);
                return true;
            } else if ((i <= MS || i > 23) && ((i != MS || i2 <= MU) && ((i != MT || i2 >= MV) && (i <= 0 || i >= MT)))) {
                AppMethodBeat.m2505o(77654);
                return false;
            } else {
                AppMethodBeat.m2505o(77654);
                return true;
            }
        } else if (i != MS || i2 <= MU || i2 >= MV) {
            AppMethodBeat.m2505o(77654);
            return false;
        } else {
            AppMethodBeat.m2505o(77654);
            return true;
        }
    }
}
