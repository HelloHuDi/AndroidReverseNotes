package com.tencent.p177mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.blink.C1311a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p229f.C1523a;
import com.tencent.p177mm.plugin.fcm.C3111d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.splash.C5103b;
import com.tencent.p177mm.splash.C5104c;
import com.tencent.p177mm.splash.C5107f;
import com.tencent.p177mm.splash.C5115h;
import com.tencent.p177mm.splash.C5122m;
import com.tencent.p177mm.xlog.app.XLogSetup;

/* renamed from: com.tencent.mm.app.w */
public final class C1273w {
    public static C6624h cfw;

    /* renamed from: com.tencent.mm.app.w$1 */
    static class C12741 implements C5104c {
        C12741() {
        }

        /* renamed from: a */
        public final void mo4565a(Throwable th, String str) {
            AppMethodBeat.m2504i(137940);
            C4990ab.printErrStackTrace("WxSplash.WeChatSplash", th, str, new Object[0]);
            if (str == null) {
                str = "";
            }
            C5115h.drh().xHG.add(str + "  " + Log.getStackTraceString(th));
            AppMethodBeat.m2505o(137940);
        }

        /* renamed from: g */
        public final void mo4566g(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(137941);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(137941);
        }

        /* renamed from: n */
        public final void mo4567n(Activity activity) {
            AppMethodBeat.m2504i(137939);
            if (C1273w.cfw != null && C1273w.cfw.mo5181SG()) {
                SharedPreferences sharedPreferences = activity.getSharedPreferences("system_config_prefs", C1448h.m3078Mu());
                if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                    sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                    XLogSetup.realSetupXlog();
                }
            }
            AppMethodBeat.m2505o(137939);
        }
    }

    /* renamed from: com.tencent.mm.app.w$2 */
    static class C12752 implements C5103b {
        C12752() {
        }

        /* renamed from: aZ */
        public final boolean mo4568aZ(Context context) {
            AppMethodBeat.m2504i(137954);
            boolean bk = C1523a.m3164bk(context);
            AppMethodBeat.m2505o(137954);
            return bk;
        }

        /* renamed from: ba */
        public final boolean mo4569ba(Context context) {
            AppMethodBeat.m2504i(137955);
            boolean ba = C1523a.m3162ba(context);
            AppMethodBeat.m2505o(137955);
            return ba;
        }

        /* renamed from: bb */
        public final void mo4570bb(Context context) {
            AppMethodBeat.m2504i(137956);
            C1523a.m3163bb(context);
            AppMethodBeat.m2505o(137956);
        }
    }

    /* renamed from: com.tencent.mm.app.w$3 */
    static class C12763 implements C5107f {
        C12763() {
        }

        /* renamed from: BO */
        public final void mo4571BO() {
            AppMethodBeat.m2504i(137968);
            C1311a.m2791BO();
            AppMethodBeat.m2505o(137968);
        }

        /* renamed from: cZ */
        public final void mo4573cZ(String str) {
            AppMethodBeat.m2504i(137969);
            C1311a.m2801cZ(str);
            AppMethodBeat.m2505o(137969);
        }

        /* renamed from: BP */
        public final void mo4572BP() {
            AppMethodBeat.m2504i(137970);
            C1311a.m2806ig(1);
            AppMethodBeat.m2505o(137970);
        }
    }

    /* renamed from: BN */
    private static void m2738BN() {
        AppMethodBeat.m2504i(137946);
        C5115h.m7767a(new C12741());
        C5115h.m7766a(new C12752());
        C5115h.m7770a(new C12763());
        AppMethodBeat.m2505o(137946);
    }

    /* renamed from: a */
    public static void m2739a(C6624h c6624h, String str) {
        AppMethodBeat.m2504i(137947);
        cfw = c6624h;
        C1273w.m2738BN();
        if (str == null) {
            C4990ab.m7416i("WxSplash.WeChatSplash", "splash callback class is null, return.");
            AppMethodBeat.m2505o(137947);
            return;
        }
        C1311a.m2811t(c6624h.eMz.getApplicationStartMillisTime(), c6624h.eMz.getApplicationStartElapsedTime());
        C5115h.aob(C4996ah.doy());
        C5115h.m7775ay(WeChatSplashActivity.class);
        C5115h.m7776az(WeChatSplashFallbackActivity.class);
        if (C3111d.m5354e(c6624h)) {
            C5115h.aoa("com.google.firebase.provider.FirebaseInitProvider");
        }
        C5122m.m7789a(c6624h.f1233cc, c6624h.eHT, str);
        AppMethodBeat.m2505o(137947);
    }
}
