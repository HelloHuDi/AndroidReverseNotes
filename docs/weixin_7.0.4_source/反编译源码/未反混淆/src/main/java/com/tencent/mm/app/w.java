package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.fcm.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.splash.b;
import com.tencent.mm.splash.c;
import com.tencent.mm.splash.f;
import com.tencent.mm.splash.m;
import com.tencent.mm.xlog.app.XLogSetup;

public final class w {
    public static h cfw;

    private static void BN() {
        AppMethodBeat.i(137946);
        com.tencent.mm.splash.h.a(new c() {
            public final void a(Throwable th, String str) {
                AppMethodBeat.i(137940);
                ab.printErrStackTrace("WxSplash.WeChatSplash", th, str, new Object[0]);
                if (str == null) {
                    str = "";
                }
                com.tencent.mm.splash.h.drh().xHG.add(str + "  " + Log.getStackTraceString(th));
                AppMethodBeat.o(137940);
            }

            public final void g(String str, String str2, Object... objArr) {
                AppMethodBeat.i(137941);
                ab.i(str, str2, objArr);
                AppMethodBeat.o(137941);
            }

            public final void n(Activity activity) {
                AppMethodBeat.i(137939);
                if (w.cfw != null && w.cfw.SG()) {
                    SharedPreferences sharedPreferences = activity.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mu());
                    if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                        sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                        XLogSetup.realSetupXlog();
                    }
                }
                AppMethodBeat.o(137939);
            }
        });
        com.tencent.mm.splash.h.a(new b() {
            public final boolean aZ(Context context) {
                AppMethodBeat.i(137954);
                boolean bk = a.bk(context);
                AppMethodBeat.o(137954);
                return bk;
            }

            public final boolean ba(Context context) {
                AppMethodBeat.i(137955);
                boolean ba = a.ba(context);
                AppMethodBeat.o(137955);
                return ba;
            }

            public final void bb(Context context) {
                AppMethodBeat.i(137956);
                a.bb(context);
                AppMethodBeat.o(137956);
            }
        });
        com.tencent.mm.splash.h.a(new f() {
            public final void BO() {
                AppMethodBeat.i(137968);
                com.tencent.mm.blink.a.BO();
                AppMethodBeat.o(137968);
            }

            public final void cZ(String str) {
                AppMethodBeat.i(137969);
                com.tencent.mm.blink.a.cZ(str);
                AppMethodBeat.o(137969);
            }

            public final void BP() {
                AppMethodBeat.i(137970);
                com.tencent.mm.blink.a.ig(1);
                AppMethodBeat.o(137970);
            }
        });
        AppMethodBeat.o(137946);
    }

    public static void a(h hVar, String str) {
        AppMethodBeat.i(137947);
        cfw = hVar;
        BN();
        if (str == null) {
            ab.i("WxSplash.WeChatSplash", "splash callback class is null, return.");
            AppMethodBeat.o(137947);
            return;
        }
        com.tencent.mm.blink.a.t(hVar.eMz.getApplicationStartMillisTime(), hVar.eMz.getApplicationStartElapsedTime());
        com.tencent.mm.splash.h.aob(ah.doy());
        com.tencent.mm.splash.h.ay(WeChatSplashActivity.class);
        com.tencent.mm.splash.h.az(WeChatSplashFallbackActivity.class);
        if (d.e(hVar)) {
            com.tencent.mm.splash.h.aoa("com.google.firebase.provider.FirebaseInitProvider");
        }
        m.a(hVar.cc, hVar.eHT, str);
        AppMethodBeat.o(137947);
    }
}
