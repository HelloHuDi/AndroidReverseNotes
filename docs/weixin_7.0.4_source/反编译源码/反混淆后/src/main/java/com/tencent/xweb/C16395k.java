package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.p1115c.C44581k;
import com.tencent.xweb.p1115c.C44581k.C44580a;
import com.tencent.xweb.util.C24532f;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.k */
public final class C16395k {
    static C16394a AMn;
    static C16394a AMo;

    /* renamed from: com.tencent.xweb.k$a */
    public interface C16394a {
        /* renamed from: a */
        void mo30119a(Context context, HashMap<String, String> hashMap);

        boolean isBusy();
    }

    static {
        AppMethodBeat.m2504i(3817);
        C44580a f = C44581k.m80968f(C44570d.WV_KIND_CW);
        AMn = (C16394a) f.excute("STR_CMD_GET_UPDATER", null);
        AMo = (C16394a) f.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
        AppMethodBeat.m2505o(3817);
    }

    public static void dTX() {
        AppMethodBeat.m2504i(3814);
        if (AMn != null) {
            Log.m81049i("WCWebUpdater", "start check runtime update");
            HashMap hashMap = new HashMap();
            hashMap.put("UpdaterCheckType", "2");
            AMn.mo30119a(XWalkEnvironment.getApplicationContext(), hashMap);
            AppMethodBeat.m2505o(3814);
            return;
        }
        Log.m81046e("WCWebUpdater", "no sWebviewUpdater");
        AppMethodBeat.m2505o(3814);
    }

    public static void dTY() {
        AppMethodBeat.m2504i(3815);
        if (AMn != null) {
            Log.m81049i("WCWebUpdater", "start check runtime update");
            new HashMap().put("UpdaterCheckType", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            AMn.mo30119a(XWalkEnvironment.getApplicationContext(), null);
            AppMethodBeat.m2505o(3815);
            return;
        }
        Log.m81046e("WCWebUpdater", "no sWebviewUpdater");
        AppMethodBeat.m2505o(3815);
    }

    public static boolean isBusy() {
        boolean isBusy;
        AppMethodBeat.m2504i(3816);
        if (AMn != null) {
            isBusy = AMn.isBusy();
        } else {
            Log.m81046e("WCWebUpdater", "check is busy : no sWebviewUpdater");
            isBusy = false;
        }
        boolean isBusy2;
        if (AMo != null) {
            isBusy2 = AMo.isBusy();
        } else {
            Log.m81046e("WCWebUpdater", "check is busy : no sPluginUpdater");
            isBusy2 = false;
        }
        if (isBusy || isBusy2) {
            AppMethodBeat.m2505o(3816);
            return true;
        }
        AppMethodBeat.m2505o(3816);
        return false;
    }

    /* renamed from: a */
    public static void m25215a(Context context, HashMap<String, String> hashMap) {
        AppMethodBeat.m2504i(3813);
        C24532f.dVw();
        if (AMn != null) {
            Log.m81049i("WCWebUpdater", "start check runtime update");
            AMn.mo30119a(context, hashMap);
        } else {
            Log.m81046e("WCWebUpdater", "no sWebviewUpdater");
        }
        if (AMo != null) {
            C24532f.dVl();
            AMo.mo30119a(context, hashMap);
            AppMethodBeat.m2505o(3813);
            return;
        }
        Log.m81046e("WCWebUpdater", "no sPluginUpdater");
        AppMethodBeat.m2505o(3813);
    }
}
