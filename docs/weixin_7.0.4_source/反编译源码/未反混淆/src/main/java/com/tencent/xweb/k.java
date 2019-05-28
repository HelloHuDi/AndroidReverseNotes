package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.util.f;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class k {
    static a AMn;
    static a AMo;

    public interface a {
        void a(Context context, HashMap<String, String> hashMap);

        boolean isBusy();
    }

    static {
        AppMethodBeat.i(3817);
        com.tencent.xweb.c.k.a f = com.tencent.xweb.c.k.f(d.WV_KIND_CW);
        AMn = (a) f.excute("STR_CMD_GET_UPDATER", null);
        AMo = (a) f.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
        AppMethodBeat.o(3817);
    }

    public static void dTX() {
        AppMethodBeat.i(3814);
        if (AMn != null) {
            Log.i("WCWebUpdater", "start check runtime update");
            HashMap hashMap = new HashMap();
            hashMap.put("UpdaterCheckType", "2");
            AMn.a(XWalkEnvironment.getApplicationContext(), hashMap);
            AppMethodBeat.o(3814);
            return;
        }
        Log.e("WCWebUpdater", "no sWebviewUpdater");
        AppMethodBeat.o(3814);
    }

    public static void dTY() {
        AppMethodBeat.i(3815);
        if (AMn != null) {
            Log.i("WCWebUpdater", "start check runtime update");
            new HashMap().put("UpdaterCheckType", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            AMn.a(XWalkEnvironment.getApplicationContext(), null);
            AppMethodBeat.o(3815);
            return;
        }
        Log.e("WCWebUpdater", "no sWebviewUpdater");
        AppMethodBeat.o(3815);
    }

    public static boolean isBusy() {
        boolean isBusy;
        AppMethodBeat.i(3816);
        if (AMn != null) {
            isBusy = AMn.isBusy();
        } else {
            Log.e("WCWebUpdater", "check is busy : no sWebviewUpdater");
            isBusy = false;
        }
        boolean isBusy2;
        if (AMo != null) {
            isBusy2 = AMo.isBusy();
        } else {
            Log.e("WCWebUpdater", "check is busy : no sPluginUpdater");
            isBusy2 = false;
        }
        if (isBusy || isBusy2) {
            AppMethodBeat.o(3816);
            return true;
        }
        AppMethodBeat.o(3816);
        return false;
    }

    public static void a(Context context, HashMap<String, String> hashMap) {
        AppMethodBeat.i(3813);
        f.dVw();
        if (AMn != null) {
            Log.i("WCWebUpdater", "start check runtime update");
            AMn.a(context, hashMap);
        } else {
            Log.e("WCWebUpdater", "no sWebviewUpdater");
        }
        if (AMo != null) {
            f.dVl();
            AMo.a(context, hashMap);
            AppMethodBeat.o(3813);
            return;
        }
        Log.e("WCWebUpdater", "no sPluginUpdater");
        AppMethodBeat.o(3813);
    }
}
