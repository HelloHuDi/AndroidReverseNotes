package com.tencent.mm.kernel;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class l {
    public static void m(Context context, boolean z) {
        AppMethodBeat.i(58020);
        if (context == null) {
            ab.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
            AppMethodBeat.o(58020);
            return;
        }
        context.getSharedPreferences("system_config_prefs", h.Mu()).edit().putBoolean("settings_fully_exit", z).commit();
        ab.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to ".concat(String.valueOf(z)));
        AppMethodBeat.o(58020);
    }

    public static boolean bL(Context context) {
        AppMethodBeat.i(58021);
        if (context == null) {
            ab.e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
            AppMethodBeat.o(58021);
            return false;
        }
        boolean z = context.getSharedPreferences("system_config_prefs", h.Mu()).getBoolean("settings_fully_exit", true);
        AppMethodBeat.o(58021);
        return z;
    }

    public static void n(Context context, boolean z) {
        AppMethodBeat.i(58022);
        if (context == null) {
            ab.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
            AppMethodBeat.o(58022);
            return;
        }
        context.getSharedPreferences("system_config_prefs_showdown", h.Mu()).edit().putBoolean("shut_down_weixin", z).commit();
        ab.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to ".concat(String.valueOf(z)));
        AppMethodBeat.o(58022);
    }

    public static boolean bM(Context context) {
        AppMethodBeat.i(58023);
        if (context == null) {
            ab.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
            AppMethodBeat.o(58023);
            return false;
        }
        boolean z = context.getSharedPreferences("system_config_prefs_showdown", h.Mu()).getBoolean("shut_down_weixin", false);
        AppMethodBeat.o(58023);
        return z;
    }
}
