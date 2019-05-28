package com.tencent.p177mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.network.aa */
public final class C1892aa {
    private static C1892aa gdW;
    private static boolean gef = false;
    private static boolean hasInit = false;
    private C32871t ebz;
    private C32856ab gdX;
    private C32858ac gdY;
    private Context gdZ;
    private C1893a gea;
    private C37973z geb;
    private C45463y gec;
    private Looper ged;
    private C9762w gee;
    private C7306ak handler;

    /* renamed from: com.tencent.mm.network.aa$a */
    public interface C1893a {
        /* renamed from: bt */
        void mo5479bt(boolean z);
    }

    private C1892aa() {
    }

    private static C1892aa anf() {
        AppMethodBeat.m2504i(58657);
        if (gdW == null) {
            gdW = new C1892aa();
        }
        C1892aa c1892aa = gdW;
        AppMethodBeat.m2505o(58657);
        return c1892aa;
    }

    private static SharedPreferences ang() {
        AppMethodBeat.m2504i(58658);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("notify_key_pref_no_account", C1448h.m3078Mu());
        AppMethodBeat.m2505o(58658);
        return sharedPreferences;
    }

    public static SharedPreferences anh() {
        AppMethodBeat.m2504i(58659);
        Object string = C1892aa.ang().getString("login_weixin_username", "");
        if (C5046bo.isNullOrNil(string)) {
            string = C6665av.fly.mo5292T("login_weixin_username", "");
            if (!C5046bo.isNullOrNil(string)) {
                C1892aa.ang().edit().putString("login_weixin_username", string).commit();
            }
        }
        if (string != null) {
            string = string.replace("[\\/\\\\]", "#").trim();
        }
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(string)), C1448h.m3078Mu());
        AppMethodBeat.m2505o(58659);
        return sharedPreferences;
    }

    public static void ani() {
        AppMethodBeat.m2504i(58660);
        if (!hasInit) {
            SharedPreferences anh = C1892aa.anh();
            long j = anh.getLong("wakeup_alarm_last_tick", 0);
            int i = anh.getInt("wakeup_alarm_last_cnt", 0);
            if (j == 0 || j > C5046bo.anU()) {
                C4990ab.m7417i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", Integer.valueOf(i));
                anh.edit().putLong("wakeup_alarm_last_tick", C5046bo.anU()).commit();
                anh.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                AppMethodBeat.m2505o(58660);
                return;
            } else if (C5046bo.m7566gb(j) > 86400000) {
                anh.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
                anh.edit().putLong("wakeup_alarm_last_tick", C5046bo.anU()).commit();
                anh.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                C4990ab.m7417i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", Integer.valueOf(i));
            } else {
                anh.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
                C4990ab.m7417i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", Integer.valueOf(i + 1));
            }
        }
        hasInit = true;
        AppMethodBeat.m2505o(58660);
    }

    public static boolean anj() {
        AppMethodBeat.m2504i(58661);
        Object T = C6665av.fly.mo5292T("login_user_name", "");
        if (T != null) {
            T = T.replaceAll("[/\\\\]", "#").trim();
        }
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(T)), C1448h.m3078Mu());
        C4990ab.m7417i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0)), Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_last_cnt", 0)));
        int i = (i > 10 ? 1 : 0) | (sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0) > 10 ? 1 : 0);
        AppMethodBeat.m2505o(58661);
        return i;
    }

    public static C32856ab ank() {
        AppMethodBeat.m2504i(58662);
        C32856ab c32856ab = C1892aa.anf().gdX;
        AppMethodBeat.m2505o(58662);
        return c32856ab;
    }

    /* renamed from: a */
    public static void m4007a(C32856ab c32856ab) {
        AppMethodBeat.m2504i(58663);
        C1892aa.anf().gdX = c32856ab;
        AppMethodBeat.m2505o(58663);
    }

    public static C32858ac anl() {
        AppMethodBeat.m2504i(58664);
        C32858ac c32858ac = C1892aa.anf().gdY;
        AppMethodBeat.m2505o(58664);
        return c32858ac;
    }

    /* renamed from: a */
    public static void m4008a(C32858ac c32858ac) {
        AppMethodBeat.m2504i(58665);
        C1892aa.anf().gdY = c32858ac;
        AppMethodBeat.m2505o(58665);
    }

    public static Context getContext() {
        AppMethodBeat.m2504i(58666);
        Context context = C1892aa.anf().gdZ;
        AppMethodBeat.m2505o(58666);
        return context;
    }

    public static void setContext(Context context) {
        AppMethodBeat.m2504i(58667);
        C1892aa.anf().gdZ = context;
        AppMethodBeat.m2505o(58667);
    }

    public static C7306ak anm() {
        AppMethodBeat.m2504i(58668);
        C7306ak c7306ak = C1892aa.anf().handler;
        AppMethodBeat.m2505o(58668);
        return c7306ak;
    }

    /* renamed from: a */
    public static void m4012a(C7306ak c7306ak) {
        AppMethodBeat.m2504i(58669);
        C1892aa.anf().handler = c7306ak;
        AppMethodBeat.m2505o(58669);
    }

    public static C1893a ann() {
        AppMethodBeat.m2504i(58670);
        C1893a c1893a = C1892aa.anf().gea;
        AppMethodBeat.m2505o(58670);
        return c1893a;
    }

    /* renamed from: a */
    public static void m4006a(C1893a c1893a) {
        AppMethodBeat.m2504i(58671);
        C1892aa.anf().gea = c1893a;
        AppMethodBeat.m2505o(58671);
    }

    public static C32871t ano() {
        AppMethodBeat.m2504i(58672);
        C32871t c32871t = C1892aa.anf().ebz;
        AppMethodBeat.m2505o(58672);
        return c32871t;
    }

    /* renamed from: b */
    public static void m4013b(C32871t c32871t) {
        AppMethodBeat.m2504i(58673);
        C1892aa.anf().ebz = c32871t;
        AppMethodBeat.m2505o(58673);
    }

    public static C37973z anp() {
        AppMethodBeat.m2504i(58674);
        C37973z c37973z = C1892aa.anf().geb;
        AppMethodBeat.m2505o(58674);
        return c37973z;
    }

    /* renamed from: a */
    public static void m4011a(C37973z c37973z) {
        AppMethodBeat.m2504i(58675);
        C1892aa.anf().geb = c37973z;
        AppMethodBeat.m2505o(58675);
    }

    public static C45463y anq() {
        AppMethodBeat.m2504i(58676);
        C45463y c45463y = C1892aa.anf().gec;
        AppMethodBeat.m2505o(58676);
        return c45463y;
    }

    /* renamed from: a */
    public static void m4010a(C45463y c45463y) {
        AppMethodBeat.m2504i(58677);
        C1892aa.anf().gec = c45463y;
        AppMethodBeat.m2505o(58677);
    }

    public static Looper anr() {
        AppMethodBeat.m2504i(58678);
        if (C1892aa.anf().ged == null) {
            HandlerThread anM = C7305d.anM("MMPushCore_handlerThread");
            anM.start();
            C1892aa.anf().ged = anM.getLooper();
        }
        Looper looper = C1892aa.anf().ged;
        AppMethodBeat.m2505o(58678);
        return looper;
    }

    public static C9762w ans() {
        AppMethodBeat.m2504i(58679);
        C9762w c9762w = C1892aa.anf().gee;
        AppMethodBeat.m2505o(58679);
        return c9762w;
    }

    /* renamed from: a */
    public static void m4009a(C9762w c9762w) {
        AppMethodBeat.m2504i(58680);
        C1892aa.anf().gee = c9762w;
        AppMethodBeat.m2505o(58680);
    }
}
