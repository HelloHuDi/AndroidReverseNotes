package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a {
    private static SimpleDateFormat krM = null;

    public static void cjM() {
        AppMethodBeat.i(24570);
        ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
        if (cjN()) {
            ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
            if (!ckh()) {
                ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.FALSE);
            }
            AppMethodBeat.o(24570);
            return;
        }
        ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
        if (ckh()) {
            aw.ZK();
            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.TRUE);
            ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
            AppMethodBeat.o(24570);
            return;
        }
        ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
        AppMethodBeat.o(24570);
    }

    public static boolean cjN() {
        AppMethodBeat.i(24571);
        if (aw.RK()) {
            boolean booleanValue;
            aw.ZK();
            Object obj = c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.FALSE);
            if (obj != null) {
                booleanValue = ((Boolean) obj).booleanValue();
            } else {
                booleanValue = false;
            }
            AppMethodBeat.o(24571);
            return booleanValue;
        }
        ab.e("MicroMsg.ShakeCardUtil", "acc is not ready");
        AppMethodBeat.o(24571);
        return false;
    }

    private static boolean ckh() {
        AppMethodBeat.i(24572);
        int cki = cki();
        int ckj = ckj();
        ab.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + cki + " end time : " + ckj);
        if (cki <= 0) {
            ab.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + cki + " , invalid");
            AppMethodBeat.o(24572);
            return false;
        } else if (ckj <= 0) {
            ab.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + ckj + " , invalid");
            AppMethodBeat.o(24572);
            return false;
        } else if (cki >= ckj) {
            ab.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
            AppMethodBeat.o(24572);
            return false;
        } else {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            ab.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : ".concat(String.valueOf(currentTimeMillis)));
            if (currentTimeMillis < cki || currentTimeMillis > ckj) {
                ab.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
                AppMethodBeat.o(24572);
                return false;
            }
            ab.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
            AppMethodBeat.o(24572);
            return true;
        }
    }

    private static int cki() {
        AppMethodBeat.i(24573);
        aw.ZK();
        int intValue = ((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(0))).intValue();
        AppMethodBeat.o(24573);
        return intValue;
    }

    private static int ckj() {
        AppMethodBeat.i(24574);
        aw.ZK();
        int intValue = ((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(0))).intValue();
        AppMethodBeat.o(24574);
        return intValue;
    }

    public static int ckk() {
        AppMethodBeat.i(24575);
        aw.ZK();
        int intValue = ((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        AppMethodBeat.o(24575);
        return intValue;
    }

    public static String ckl() {
        AppMethodBeat.i(24576);
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, (Object) "");
        AppMethodBeat.o(24576);
        return str;
    }

    public static String ckm() {
        AppMethodBeat.i(24577);
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, (Object) "");
        AppMethodBeat.o(24577);
        return str;
    }

    public static String ckn() {
        AppMethodBeat.i(24578);
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, (Object) "");
        AppMethodBeat.o(24578);
        return str;
    }

    public static String cko() {
        AppMethodBeat.i(24579);
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, (Object) "");
        AppMethodBeat.o(24579);
        return str;
    }

    public static String ckp() {
        AppMethodBeat.i(24580);
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, (Object) "");
        AppMethodBeat.o(24580);
        return str;
    }

    public static String ckq() {
        AppMethodBeat.i(24581);
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, (Object) "");
        AppMethodBeat.o(24581);
        return str;
    }

    public static boolean Cw(int i) {
        return i >= 0 && i <= 5;
    }

    public static int ckr() {
        AppMethodBeat.i(24582);
        aw.ZK();
        int currentTimeMillis = (int) (System.currentTimeMillis() % 10);
        int nextInt = (new Random((long) c.QF()).nextInt(10) + currentTimeMillis) % 10;
        ab.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(nextInt)));
        AppMethodBeat.o(24582);
        return nextInt;
    }

    public static int Cx(int i) {
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

    public static int Cy(int i) {
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

    public static int Hn(String str) {
        AppMethodBeat.i(24583);
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            ab.e("MicroMsg.ShakeCardUtil", "string format error");
            AppMethodBeat.o(24583);
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
                AppMethodBeat.o(24583);
            } catch (Exception e) {
                ab.e("MicroMsg.ShakeCardUtil", e.toString());
                AppMethodBeat.o(24583);
            }
        }
        return rgb;
    }

    public static String fQ(long j) {
        AppMethodBeat.i(24584);
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (krM == null) {
            krM = new SimpleDateFormat("yyyy.MM.dd");
        }
        String format = krM.format(new Date(j2));
        AppMethodBeat.o(24584);
        return format;
    }

    public static void u(Context context, String str, String str2) {
        AppMethodBeat.i(24585);
        ab.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
        Intent intent = new Intent();
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_card_ext", str2);
        intent.putExtra("key_from_scene", 15);
        d.b(context, "card", ".ui.CardDetailUI", intent);
        AppMethodBeat.o(24585);
    }

    public static boolean cks() {
        AppMethodBeat.i(24586);
        if (cjN() && aa.don()) {
            AppMethodBeat.o(24586);
            return true;
        }
        AppMethodBeat.o(24586);
        return false;
    }

    public static void cjO() {
        AppMethodBeat.i(24587);
        ab.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i = 86400 + currentTimeMillis;
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(currentTimeMillis));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(i));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, (Object) "");
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(0));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, Integer.valueOf(1));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, Integer.valueOf(6));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, (Object) "");
        com.tencent.mm.x.c.PK().y(262154, true);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, String.valueOf(currentTimeMillis));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, (Object) "hello");
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "shake card");
        AppMethodBeat.o(24587);
    }

    public static void cjP() {
        AppMethodBeat.i(24588);
        ab.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(0));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(0));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, (Object) "");
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(0));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, Integer.valueOf(0));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, Integer.valueOf(0));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, (Object) "");
        com.tencent.mm.x.c.PK().y(262154, false);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, (Object) "");
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, (Object) "");
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
        AppMethodBeat.o(24588);
    }
}
