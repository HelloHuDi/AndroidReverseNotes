package com.tencent.p177mm.plugin.shake.p506c.p1411c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.shake.c.c.a */
public final class C28999a {
    private static SimpleDateFormat krM = null;

    public static void cjM() {
        AppMethodBeat.m2504i(24570);
        C4990ab.m7416i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
        if (C28999a.cjN()) {
            C4990ab.m7416i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
            if (!C28999a.ckh()) {
                C4990ab.m7416i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.FALSE);
            }
            AppMethodBeat.m2505o(24570);
            return;
        }
        C4990ab.m7416i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
        if (C28999a.ckh()) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.TRUE);
            C4990ab.m7416i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
            AppMethodBeat.m2505o(24570);
            return;
        }
        C4990ab.m7416i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
        AppMethodBeat.m2505o(24570);
    }

    public static boolean cjN() {
        AppMethodBeat.m2504i(24571);
        if (C9638aw.m17179RK()) {
            boolean booleanValue;
            C9638aw.m17190ZK();
            Object obj = C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.FALSE);
            if (obj != null) {
                booleanValue = ((Boolean) obj).booleanValue();
            } else {
                booleanValue = false;
            }
            AppMethodBeat.m2505o(24571);
            return booleanValue;
        }
        C4990ab.m7412e("MicroMsg.ShakeCardUtil", "acc is not ready");
        AppMethodBeat.m2505o(24571);
        return false;
    }

    private static boolean ckh() {
        AppMethodBeat.m2504i(24572);
        int cki = C28999a.cki();
        int ckj = C28999a.ckj();
        C4990ab.m7416i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + cki + " end time : " + ckj);
        if (cki <= 0) {
            C4990ab.m7412e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + cki + " , invalid");
            AppMethodBeat.m2505o(24572);
            return false;
        } else if (ckj <= 0) {
            C4990ab.m7412e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + ckj + " , invalid");
            AppMethodBeat.m2505o(24572);
            return false;
        } else if (cki >= ckj) {
            C4990ab.m7412e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
            AppMethodBeat.m2505o(24572);
            return false;
        } else {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            C4990ab.m7416i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : ".concat(String.valueOf(currentTimeMillis)));
            if (currentTimeMillis < cki || currentTimeMillis > ckj) {
                C4990ab.m7412e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
                AppMethodBeat.m2505o(24572);
                return false;
            }
            C4990ab.m7412e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
            AppMethodBeat.m2505o(24572);
            return true;
        }
    }

    private static int cki() {
        AppMethodBeat.m2504i(24573);
        C9638aw.m17190ZK();
        int intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(0))).intValue();
        AppMethodBeat.m2505o(24573);
        return intValue;
    }

    private static int ckj() {
        AppMethodBeat.m2504i(24574);
        C9638aw.m17190ZK();
        int intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(0))).intValue();
        AppMethodBeat.m2505o(24574);
        return intValue;
    }

    public static int ckk() {
        AppMethodBeat.m2504i(24575);
        C9638aw.m17190ZK();
        int intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        AppMethodBeat.m2505o(24575);
        return intValue;
    }

    public static String ckl() {
        AppMethodBeat.m2504i(24576);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(24576);
        return str;
    }

    public static String ckm() {
        AppMethodBeat.m2504i(24577);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(24577);
        return str;
    }

    public static String ckn() {
        AppMethodBeat.m2504i(24578);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(24578);
        return str;
    }

    public static String cko() {
        AppMethodBeat.m2504i(24579);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(24579);
        return str;
    }

    public static String ckp() {
        AppMethodBeat.m2504i(24580);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(24580);
        return str;
    }

    public static String ckq() {
        AppMethodBeat.m2504i(24581);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(24581);
        return str;
    }

    /* renamed from: Cw */
    public static boolean m46033Cw(int i) {
        return i >= 0 && i <= 5;
    }

    public static int ckr() {
        AppMethodBeat.m2504i(24582);
        C9638aw.m17190ZK();
        int currentTimeMillis = (int) (System.currentTimeMillis() % 10);
        int nextInt = (new Random((long) C18628c.m29064QF()).nextInt(10) + currentTimeMillis) % 10;
        C4990ab.m7416i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(nextInt)));
        AppMethodBeat.m2505o(24582);
        return nextInt;
    }

    /* renamed from: Cx */
    public static int m46034Cx(int i) {
        switch (i) {
            case 1:
                return 10;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 120;
            case 5:
                return 240;
            default:
                return 0;
        }
    }

    /* renamed from: Cy */
    public static int m46035Cy(int i) {
        switch (i) {
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 90;
            case 5:
                return 120;
            case 6:
                return 150;
            case 7:
                return 180;
            case 8:
                return 240;
            case 9:
                return 300;
            default:
                return 10;
        }
    }

    /* renamed from: Hn */
    public static int m46036Hn(String str) {
        AppMethodBeat.m2504i(24583);
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            C4990ab.m7412e("MicroMsg.ShakeCardUtil", "string format error");
            AppMethodBeat.m2505o(24583);
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
                AppMethodBeat.m2505o(24583);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.ShakeCardUtil", e.toString());
                AppMethodBeat.m2505o(24583);
            }
        }
        return rgb;
    }

    /* renamed from: fQ */
    public static String m46037fQ(long j) {
        AppMethodBeat.m2504i(24584);
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (krM == null) {
            krM = new SimpleDateFormat("yyyy.MM.dd");
        }
        String format = krM.format(new Date(j2));
        AppMethodBeat.m2505o(24584);
        return format;
    }

    /* renamed from: u */
    public static void m46038u(Context context, String str, String str2) {
        AppMethodBeat.m2504i(24585);
        C4990ab.m7416i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
        Intent intent = new Intent();
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_card_ext", str2);
        intent.putExtra("key_from_scene", 15);
        C25985d.m41467b(context, "card", ".ui.CardDetailUI", intent);
        AppMethodBeat.m2505o(24585);
    }

    public static boolean cks() {
        AppMethodBeat.m2504i(24586);
        if (C28999a.cjN() && C4988aa.don()) {
            AppMethodBeat.m2505o(24586);
            return true;
        }
        AppMethodBeat.m2505o(24586);
        return false;
    }

    public static void cjO() {
        AppMethodBeat.m2504i(24587);
        C4990ab.m7416i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i = 86400 + currentTimeMillis;
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(currentTimeMillis));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(i));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, (Object) "");
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(0));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, Integer.valueOf(1));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, Integer.valueOf(6));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, (Object) "");
        C16112c.m24429PK().mo28557y(262154, true);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, String.valueOf(currentTimeMillis));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, (Object) "hello");
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "shake card");
        AppMethodBeat.m2505o(24587);
    }

    public static void cjP() {
        AppMethodBeat.m2504i(24588);
        C4990ab.m7416i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(0));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(0));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, (Object) "");
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(0));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, Integer.valueOf(0));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, Integer.valueOf(0));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, (Object) "");
        C16112c.m24429PK().mo28557y(262154, false);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, (Object) "");
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, (Object) "");
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(24588);
    }
}
