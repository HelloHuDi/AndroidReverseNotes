package com.tencent.mm.m;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    private static String TAG = "MicroMsg.NotificationConfig";

    public static void bL(boolean z) {
        AppMethodBeat.i(77664);
        a.Mz().edit().putBoolean("settings_new_msg_notification", z).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", Boolean.valueOf(z));
        AppMethodBeat.o(77664);
    }

    public static void bM(boolean z) {
        AppMethodBeat.i(77665);
        a.Mz().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", Boolean.valueOf(z));
        AppMethodBeat.o(77665);
    }

    public static void bN(boolean z) {
        AppMethodBeat.i(77666);
        a.Mz().edit().putBoolean("settings_show_detail", z).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", Boolean.valueOf(z));
        AppMethodBeat.o(77666);
    }

    public static void bO(boolean z) {
        AppMethodBeat.i(77667);
        a.Mz().edit().putBoolean("settings_sound", z).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", Boolean.valueOf(z));
        AppMethodBeat.o(77667);
    }

    public static void bP(boolean z) {
        AppMethodBeat.i(77668);
        a.Mz().edit().putBoolean("settings_shake", z).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", Boolean.valueOf(z));
        AppMethodBeat.o(77668);
    }

    public static void kA(String str) {
        AppMethodBeat.i(77669);
        a.kA(str);
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", str);
        AppMethodBeat.o(77669);
    }

    public static void bQ(boolean z) {
        AppMethodBeat.i(77670);
        a.Mz().edit().putBoolean("settings_special_scene_sound", z).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", Boolean.valueOf(z));
        AppMethodBeat.o(77670);
    }

    public static void bR(boolean z) {
        AppMethodBeat.i(77671);
        a.Mz().edit().putBoolean("settings_special_scene_shake", z).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", Boolean.valueOf(z));
        AppMethodBeat.o(77671);
    }

    public static void bS(boolean z) {
        AppMethodBeat.i(77672);
        a.Mz().edit().putBoolean("settings_voip_scene_sound", z).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", Boolean.valueOf(z));
        AppMethodBeat.o(77672);
    }

    public static void bT(boolean z) {
        AppMethodBeat.i(77673);
        a.Mz().edit().putBoolean("settings_voip_scene_shake", z).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", Boolean.valueOf(z));
        AppMethodBeat.o(77673);
    }

    public static void bU(boolean z) {
        AppMethodBeat.i(77674);
        a.Mz().edit().putBoolean("settings_active_time_full", z).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", Boolean.valueOf(z));
        AppMethodBeat.o(77674);
    }

    public static void bT(int i, int i2) {
        AppMethodBeat.i(77675);
        SharedPreferences Mz = a.Mz();
        Mz.edit().putInt("settings_active_begin_time_hour", i).commit();
        Mz.edit().putInt("settings_active_begin_time_min", i2).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(77675);
    }

    public static void bU(int i, int i2) {
        AppMethodBeat.i(77676);
        SharedPreferences Mz = a.Mz();
        Mz.edit().putInt("settings_active_end_time_hour", i).commit();
        Mz.edit().putInt("settings_active_end_time_min", i2).commit();
        ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(77676);
    }

    public static void iZ(int i) {
        AppMethodBeat.i(77678);
        a.Mz().edit().putInt("notification.status.webonline.push.open", i).commit();
        AppMethodBeat.o(77678);
    }

    public static boolean No() {
        AppMethodBeat.i(77679);
        boolean ku = r.ku(a.Mz().getInt("notification.status.webonline.push.open", 0));
        AppMethodBeat.o(77679);
        return ku;
    }

    public static boolean ja(int i) {
        return i == 50 || i == 53;
    }

    public static boolean kD(String str) {
        AppMethodBeat.i(77680);
        ui uiVar = new ui();
        uiVar.cQx.cAd = 1;
        uiVar.cQx.content = str;
        a.xxA.m(uiVar);
        if (uiVar.cQy.type == 2 || str.equals(bi.xZc)) {
            AppMethodBeat.o(77680);
            return true;
        }
        AppMethodBeat.o(77680);
        return false;
    }

    public static boolean kE(String str) {
        AppMethodBeat.i(77681);
        ui uiVar = new ui();
        uiVar.cQx.cAd = 1;
        uiVar.cQx.content = str;
        a.xxA.m(uiVar);
        if (uiVar.cQy.type == 3 || str.equals(bi.xZb)) {
            AppMethodBeat.o(77681);
            return true;
        }
        AppMethodBeat.o(77681);
        return false;
    }

    public static int Np() {
        AppMethodBeat.i(77682);
        if (g.RK()) {
            int nS = u.nS(t.fkP);
            AppMethodBeat.o(77682);
            return nS;
        }
        ab.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
        AppMethodBeat.o(77682);
        return 0;
    }

    public static List<String> Nq() {
        AppMethodBeat.i(77683);
        List P = u.P(t.fkP, -1);
        AppMethodBeat.o(77683);
        return P;
    }

    public static int Nr() {
        AppMethodBeat.i(77684);
        if (g.RK()) {
            String str = t.fkP;
            ArrayList arrayList = new ArrayList();
            if (g.RK()) {
                if (!g.RP().Ry().getBoolean(ac.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    arrayList.add("notifymessage");
                    ab.d(TAG, "add service notify message into show unread count blacklist.");
                }
                if (!g.RP().Ry().getBoolean(ac.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    arrayList.add("appbrandcustomerservicemsg");
                    ab.d(TAG, "add wxa custom session notify message into show unread count blacklist.");
                }
            } else {
                ab.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
            }
            int e = u.e(str, arrayList);
            AppMethodBeat.o(77684);
            return e;
        }
        ab.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
        AppMethodBeat.o(77684);
        return 0;
    }

    public static int kF(String str) {
        AppMethodBeat.i(77685);
        int ac = u.ac(str, null);
        AppMethodBeat.o(77685);
        return ac;
    }

    public static boolean kG(String str) {
        AppMethodBeat.i(77686);
        boolean mR = ad.mR(str);
        AppMethodBeat.o(77686);
        return mR;
    }

    public static boolean kH(String str) {
        AppMethodBeat.i(77687);
        boolean mN = t.mN(str);
        AppMethodBeat.o(77687);
        return mN;
    }

    public static boolean kI(String str) {
        AppMethodBeat.i(77688);
        if (t.nN(str) || ((t.kH(str) && !t.nM(str)) || (t.mP(str) && !t.nM(str)))) {
            AppMethodBeat.o(77688);
            return true;
        }
        AppMethodBeat.o(77688);
        return false;
    }

    public static int kJ(String str) {
        AppMethodBeat.i(77689);
        int apo = ((j) g.K(j.class)).XR().apo(str);
        AppMethodBeat.o(77689);
        return apo;
    }

    public static boolean i(bi biVar) {
        AppMethodBeat.i(77690);
        if (biVar == null) {
            AppMethodBeat.o(77690);
            return false;
        }
        boolean apB = biVar.apB(r.Yz());
        AppMethodBeat.o(77690);
        return apB;
    }

    public static boolean Ns() {
        AppMethodBeat.i(77691);
        boolean booleanValue = ((Boolean) g.RP().Ry().get(73217, Boolean.TRUE)).booleanValue();
        AppMethodBeat.o(77691);
        return booleanValue;
    }

    public static boolean Nt() {
        AppMethodBeat.i(77692);
        boolean booleanValue = ((Boolean) g.RP().Ry().get(73218, Boolean.TRUE)).booleanValue();
        AppMethodBeat.o(77692);
        return booleanValue;
    }

    public static boolean Nn() {
        AppMethodBeat.i(77677);
        boolean jP = com.tencent.mm.kernel.a.jP(com.tencent.mm.kernel.a.QW());
        AppMethodBeat.o(77677);
        return jP;
    }
}
