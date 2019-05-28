package com.tencent.p177mm.kernel;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.kernel.l */
public final class C1737l {
    /* renamed from: m */
    public static void m3593m(Context context, boolean z) {
        AppMethodBeat.m2504i(58020);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
            AppMethodBeat.m2505o(58020);
            return;
        }
        context.getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).edit().putBoolean("settings_fully_exit", z).commit();
        C4990ab.m7416i("MicroMsg.WeChatAppStatus", "editFullExitStatus to ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(58020);
    }

    /* renamed from: bL */
    public static boolean m3591bL(Context context) {
        AppMethodBeat.m2504i(58021);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
            AppMethodBeat.m2505o(58021);
            return false;
        }
        boolean z = context.getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getBoolean("settings_fully_exit", true);
        AppMethodBeat.m2505o(58021);
        return z;
    }

    /* renamed from: n */
    public static void m3594n(Context context, boolean z) {
        AppMethodBeat.m2504i(58022);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
            AppMethodBeat.m2505o(58022);
            return;
        }
        context.getSharedPreferences("system_config_prefs_showdown", C1448h.m3078Mu()).edit().putBoolean("shut_down_weixin", z).commit();
        C4990ab.m7416i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(58022);
    }

    /* renamed from: bM */
    public static boolean m3592bM(Context context) {
        AppMethodBeat.m2504i(58023);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
            AppMethodBeat.m2505o(58023);
            return false;
        }
        boolean z = context.getSharedPreferences("system_config_prefs_showdown", C1448h.m3078Mu()).getBoolean("shut_down_weixin", false);
        AppMethodBeat.m2505o(58023);
        return z;
    }
}
