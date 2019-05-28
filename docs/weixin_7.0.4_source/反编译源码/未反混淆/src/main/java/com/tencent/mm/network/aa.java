package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.av;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class aa {
    private static aa gdW;
    private static boolean gef = false;
    private static boolean hasInit = false;
    private t ebz;
    private ab gdX;
    private ac gdY;
    private Context gdZ;
    private a gea;
    private z geb;
    private y gec;
    private Looper ged;
    private w gee;
    private ak handler;

    public interface a {
        void bt(boolean z);
    }

    private aa() {
    }

    private static aa anf() {
        AppMethodBeat.i(58657);
        if (gdW == null) {
            gdW = new aa();
        }
        aa aaVar = gdW;
        AppMethodBeat.o(58657);
        return aaVar;
    }

    private static SharedPreferences ang() {
        AppMethodBeat.i(58658);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("notify_key_pref_no_account", h.Mu());
        AppMethodBeat.o(58658);
        return sharedPreferences;
    }

    public static SharedPreferences anh() {
        AppMethodBeat.i(58659);
        Object string = ang().getString("login_weixin_username", "");
        if (bo.isNullOrNil(string)) {
            string = av.fly.T("login_weixin_username", "");
            if (!bo.isNullOrNil(string)) {
                ang().edit().putString("login_weixin_username", string).commit();
            }
        }
        if (string != null) {
            string = string.replace("[\\/\\\\]", "#").trim();
        }
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(string)), h.Mu());
        AppMethodBeat.o(58659);
        return sharedPreferences;
    }

    public static void ani() {
        AppMethodBeat.i(58660);
        if (!hasInit) {
            SharedPreferences anh = anh();
            long j = anh.getLong("wakeup_alarm_last_tick", 0);
            int i = anh.getInt("wakeup_alarm_last_cnt", 0);
            if (j == 0 || j > bo.anU()) {
                ab.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", Integer.valueOf(i));
                anh.edit().putLong("wakeup_alarm_last_tick", bo.anU()).commit();
                anh.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                AppMethodBeat.o(58660);
                return;
            } else if (bo.gb(j) > 86400000) {
                anh.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
                anh.edit().putLong("wakeup_alarm_last_tick", bo.anU()).commit();
                anh.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                ab.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", Integer.valueOf(i));
            } else {
                anh.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
                ab.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", Integer.valueOf(i + 1));
            }
        }
        hasInit = true;
        AppMethodBeat.o(58660);
    }

    public static boolean anj() {
        AppMethodBeat.i(58661);
        Object T = av.fly.T("login_user_name", "");
        if (T != null) {
            T = T.replaceAll("[/\\\\]", "#").trim();
        }
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(T)), h.Mu());
        ab.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0)), Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_last_cnt", 0)));
        int i = (i > 10 ? 1 : 0) | (sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0) > 10 ? 1 : 0);
        AppMethodBeat.o(58661);
        return i;
    }

    public static ab ank() {
        AppMethodBeat.i(58662);
        ab abVar = anf().gdX;
        AppMethodBeat.o(58662);
        return abVar;
    }

    public static void a(ab abVar) {
        AppMethodBeat.i(58663);
        anf().gdX = abVar;
        AppMethodBeat.o(58663);
    }

    public static ac anl() {
        AppMethodBeat.i(58664);
        ac acVar = anf().gdY;
        AppMethodBeat.o(58664);
        return acVar;
    }

    public static void a(ac acVar) {
        AppMethodBeat.i(58665);
        anf().gdY = acVar;
        AppMethodBeat.o(58665);
    }

    public static Context getContext() {
        AppMethodBeat.i(58666);
        Context context = anf().gdZ;
        AppMethodBeat.o(58666);
        return context;
    }

    public static void setContext(Context context) {
        AppMethodBeat.i(58667);
        anf().gdZ = context;
        AppMethodBeat.o(58667);
    }

    public static ak anm() {
        AppMethodBeat.i(58668);
        ak akVar = anf().handler;
        AppMethodBeat.o(58668);
        return akVar;
    }

    public static void a(ak akVar) {
        AppMethodBeat.i(58669);
        anf().handler = akVar;
        AppMethodBeat.o(58669);
    }

    public static a ann() {
        AppMethodBeat.i(58670);
        a aVar = anf().gea;
        AppMethodBeat.o(58670);
        return aVar;
    }

    public static void a(a aVar) {
        AppMethodBeat.i(58671);
        anf().gea = aVar;
        AppMethodBeat.o(58671);
    }

    public static t ano() {
        AppMethodBeat.i(58672);
        t tVar = anf().ebz;
        AppMethodBeat.o(58672);
        return tVar;
    }

    public static void b(t tVar) {
        AppMethodBeat.i(58673);
        anf().ebz = tVar;
        AppMethodBeat.o(58673);
    }

    public static z anp() {
        AppMethodBeat.i(58674);
        z zVar = anf().geb;
        AppMethodBeat.o(58674);
        return zVar;
    }

    public static void a(z zVar) {
        AppMethodBeat.i(58675);
        anf().geb = zVar;
        AppMethodBeat.o(58675);
    }

    public static y anq() {
        AppMethodBeat.i(58676);
        y yVar = anf().gec;
        AppMethodBeat.o(58676);
        return yVar;
    }

    public static void a(y yVar) {
        AppMethodBeat.i(58677);
        anf().gec = yVar;
        AppMethodBeat.o(58677);
    }

    public static Looper anr() {
        AppMethodBeat.i(58678);
        if (anf().ged == null) {
            HandlerThread anM = d.anM("MMPushCore_handlerThread");
            anM.start();
            anf().ged = anM.getLooper();
        }
        Looper looper = anf().ged;
        AppMethodBeat.o(58678);
        return looper;
    }

    public static w ans() {
        AppMethodBeat.i(58679);
        w wVar = anf().gee;
        AppMethodBeat.o(58679);
        return wVar;
    }

    public static void a(w wVar) {
        AppMethodBeat.i(58680);
        anf().gee = wVar;
        AppMethodBeat.o(58680);
    }
}
