package com.tencent.p177mm.p249m;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.m.f */
public final class C18559f extends C37885a {
    private static String TAG = "MicroMsg.NotificationConfig";

    /* renamed from: bL */
    public static void m28888bL(boolean z) {
        AppMethodBeat.m2504i(77664);
        C37885a.m63971Mz().edit().putBoolean("settings_new_msg_notification", z).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(77664);
    }

    /* renamed from: bM */
    public static void m28889bM(boolean z) {
        AppMethodBeat.m2504i(77665);
        C37885a.m63971Mz().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(77665);
    }

    /* renamed from: bN */
    public static void m28890bN(boolean z) {
        AppMethodBeat.m2504i(77666);
        C37885a.m63971Mz().edit().putBoolean("settings_show_detail", z).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(77666);
    }

    /* renamed from: bO */
    public static void m28891bO(boolean z) {
        AppMethodBeat.m2504i(77667);
        C37885a.m63971Mz().edit().putBoolean("settings_sound", z).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(77667);
    }

    /* renamed from: bP */
    public static void m28892bP(boolean z) {
        AppMethodBeat.m2504i(77668);
        C37885a.m63971Mz().edit().putBoolean("settings_shake", z).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(77668);
    }

    /* renamed from: kA */
    public static void m28903kA(String str) {
        AppMethodBeat.m2504i(77669);
        C37885a.m63973kA(str);
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", str);
        AppMethodBeat.m2505o(77669);
    }

    /* renamed from: bQ */
    public static void m28893bQ(boolean z) {
        AppMethodBeat.m2504i(77670);
        C37885a.m63971Mz().edit().putBoolean("settings_special_scene_sound", z).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(77670);
    }

    /* renamed from: bR */
    public static void m28894bR(boolean z) {
        AppMethodBeat.m2504i(77671);
        C37885a.m63971Mz().edit().putBoolean("settings_special_scene_shake", z).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(77671);
    }

    /* renamed from: bS */
    public static void m28895bS(boolean z) {
        AppMethodBeat.m2504i(77672);
        C37885a.m63971Mz().edit().putBoolean("settings_voip_scene_sound", z).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(77672);
    }

    /* renamed from: bT */
    public static void m28897bT(boolean z) {
        AppMethodBeat.m2504i(77673);
        C37885a.m63971Mz().edit().putBoolean("settings_voip_scene_shake", z).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(77673);
    }

    /* renamed from: bU */
    public static void m28899bU(boolean z) {
        AppMethodBeat.m2504i(77674);
        C37885a.m63971Mz().edit().putBoolean("settings_active_time_full", z).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(77674);
    }

    /* renamed from: bT */
    public static void m28896bT(int i, int i2) {
        AppMethodBeat.m2504i(77675);
        SharedPreferences Mz = C37885a.m63971Mz();
        Mz.edit().putInt("settings_active_begin_time_hour", i).commit();
        Mz.edit().putInt("settings_active_begin_time_min", i2).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(77675);
    }

    /* renamed from: bU */
    public static void m28898bU(int i, int i2) {
        AppMethodBeat.m2504i(77676);
        SharedPreferences Mz = C37885a.m63971Mz();
        Mz.edit().putInt("settings_active_end_time_hour", i).commit();
        Mz.edit().putInt("settings_active_end_time_min", i2).commit();
        C4990ab.m7417i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(77676);
    }

    /* renamed from: iZ */
    public static void m28901iZ(int i) {
        AppMethodBeat.m2504i(77678);
        C37885a.m63971Mz().edit().putInt("notification.status.webonline.push.open", i).commit();
        AppMethodBeat.m2505o(77678);
    }

    /* renamed from: No */
    public static boolean m28882No() {
        AppMethodBeat.m2504i(77679);
        boolean ku = C1853r.m3855ku(C37885a.m63971Mz().getInt("notification.status.webonline.push.open", 0));
        AppMethodBeat.m2505o(77679);
        return ku;
    }

    /* renamed from: ja */
    public static boolean m28902ja(int i) {
        return i == 50 || i == 53;
    }

    /* renamed from: kD */
    public static boolean m28904kD(String str) {
        AppMethodBeat.m2504i(77680);
        C26250ui c26250ui = new C26250ui();
        c26250ui.cQx.cAd = 1;
        c26250ui.cQx.content = str;
        C4879a.xxA.mo10055m(c26250ui);
        if (c26250ui.cQy.type == 2 || str.equals(C7620bi.xZc)) {
            AppMethodBeat.m2505o(77680);
            return true;
        }
        AppMethodBeat.m2505o(77680);
        return false;
    }

    /* renamed from: kE */
    public static boolean m28905kE(String str) {
        AppMethodBeat.m2504i(77681);
        C26250ui c26250ui = new C26250ui();
        c26250ui.cQx.cAd = 1;
        c26250ui.cQx.content = str;
        C4879a.xxA.mo10055m(c26250ui);
        if (c26250ui.cQy.type == 3 || str.equals(C7620bi.xZb)) {
            AppMethodBeat.m2505o(77681);
            return true;
        }
        AppMethodBeat.m2505o(77681);
        return false;
    }

    /* renamed from: Np */
    public static int m28883Np() {
        AppMethodBeat.m2504i(77682);
        if (C1720g.m3531RK()) {
            int nS = C32798u.m53586nS(C1855t.fkP);
            AppMethodBeat.m2505o(77682);
            return nS;
        }
        C4990ab.m7420w(TAG, "getUnReadTalkerCount, but mmcore not ready");
        AppMethodBeat.m2505o(77682);
        return 0;
    }

    /* renamed from: Nq */
    public static List<String> m28884Nq() {
        AppMethodBeat.m2504i(77683);
        List P = C32798u.m53579P(C1855t.fkP, -1);
        AppMethodBeat.m2505o(77683);
        return P;
    }

    /* renamed from: Nr */
    public static int m28885Nr() {
        AppMethodBeat.m2504i(77684);
        if (C1720g.m3531RK()) {
            String str = C1855t.fkP;
            ArrayList arrayList = new ArrayList();
            if (C1720g.m3531RK()) {
                if (!C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    arrayList.add("notifymessage");
                    C4990ab.m7410d(TAG, "add service notify message into show unread count blacklist.");
                }
                if (!C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    arrayList.add("appbrandcustomerservicemsg");
                    C4990ab.m7410d(TAG, "add wxa custom session notify message into show unread count blacklist.");
                }
            } else {
                C4990ab.m7420w(TAG, "getUnReadTalkerCount, but mmcore not ready");
            }
            int e = C32798u.m53584e(str, arrayList);
            AppMethodBeat.m2505o(77684);
            return e;
        }
        C4990ab.m7420w(TAG, "getUnReadMsgCoun, but mmcore not ready");
        AppMethodBeat.m2505o(77684);
        return 0;
    }

    /* renamed from: kF */
    public static int m28906kF(String str) {
        AppMethodBeat.m2504i(77685);
        int ac = C32798u.m53582ac(str, null);
        AppMethodBeat.m2505o(77685);
        return ac;
    }

    /* renamed from: kG */
    public static boolean m28907kG(String str) {
        AppMethodBeat.m2504i(77686);
        boolean mR = C7616ad.m13548mR(str);
        AppMethodBeat.m2505o(77686);
        return mR;
    }

    /* renamed from: kH */
    public static boolean m28908kH(String str) {
        AppMethodBeat.m2504i(77687);
        boolean mN = C1855t.m3901mN(str);
        AppMethodBeat.m2505o(77687);
        return mN;
    }

    /* renamed from: kI */
    public static boolean m28909kI(String str) {
        AppMethodBeat.m2504i(77688);
        if (C1855t.m3928nN(str) || ((C1855t.m3896kH(str) && !C1855t.m3927nM(str)) || (C1855t.m3903mP(str) && !C1855t.m3927nM(str)))) {
            AppMethodBeat.m2505o(77688);
            return true;
        }
        AppMethodBeat.m2505o(77688);
        return false;
    }

    /* renamed from: kJ */
    public static int m28910kJ(String str) {
        AppMethodBeat.m2504i(77689);
        int apo = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apo(str);
        AppMethodBeat.m2505o(77689);
        return apo;
    }

    /* renamed from: i */
    public static boolean m28900i(C7620bi c7620bi) {
        AppMethodBeat.m2504i(77690);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(77690);
            return false;
        }
        boolean apB = c7620bi.apB(C1853r.m3846Yz());
        AppMethodBeat.m2505o(77690);
        return apB;
    }

    /* renamed from: Ns */
    public static boolean m28886Ns() {
        AppMethodBeat.m2504i(77691);
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(73217, Boolean.TRUE)).booleanValue();
        AppMethodBeat.m2505o(77691);
        return booleanValue;
    }

    /* renamed from: Nt */
    public static boolean m28887Nt() {
        AppMethodBeat.m2504i(77692);
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(73218, Boolean.TRUE)).booleanValue();
        AppMethodBeat.m2505o(77692);
        return booleanValue;
    }

    /* renamed from: Nn */
    public static boolean m28881Nn() {
        AppMethodBeat.m2504i(77677);
        boolean jP = C1668a.m3404jP(C1668a.m3394QW());
        AppMethodBeat.m2505o(77677);
        return jP;
    }
}
