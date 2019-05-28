package com.tencent.mm.cj;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class c {
    public static void aNX() {
        AppMethodBeat.i(80409);
        atE("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        atF("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
        AppMethodBeat.o(80409);
    }

    public static void atD(String str) {
        AppMethodBeat.i(80410);
        atE(str);
        atF(str);
        AppMethodBeat.o(80410);
    }

    public static void aZ(Intent intent) {
        AppMethodBeat.i(80411);
        intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        ah.getContext().sendBroadcast(intent);
        if (d.Qb()) {
            AppMethodBeat.o(80411);
            return;
        }
        intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(80411);
    }

    private static void atE(String str) {
        AppMethodBeat.i(80412);
        if (!"com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(str) || ah.amz(ah.getPackageName() + ":tools")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", str);
            ah.getContext().sendBroadcast(intent);
            AppMethodBeat.o(80412);
            return;
        }
        AppMethodBeat.o(80412);
    }

    public static void atF(String str) {
        AppMethodBeat.i(80413);
        if (d.Qb()) {
            AppMethodBeat.o(80413);
        } else if (!"com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(str) || ah.amz(ah.getPackageName() + ":toolsmp")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", str);
            ah.getContext().sendBroadcast(intent);
            AppMethodBeat.o(80413);
        } else {
            AppMethodBeat.o(80413);
        }
    }

    public static boolean iv(Context context) {
        AppMethodBeat.i(80414);
        if (!WebView.isX5() || WebView.getUsingTbsCoreVersion(context) > 36541) {
            AppMethodBeat.o(80414);
            return true;
        }
        ab.i("XWebUtil", "lower version of x5 not support source type ");
        AppMethodBeat.o(80414);
        return false;
    }

    public static void a(WebView.d dVar) {
        AppMethodBeat.i(80415);
        a(dVar, new com.tencent.xweb.WebView.c() {
            public final void onCoreInitFinished() {
                AppMethodBeat.i(80407);
                ab.i("XWebUtil", "onCoreInitFinished");
                AppMethodBeat.o(80407);
            }

            public final void BH() {
                AppMethodBeat.i(80408);
                ab.i("XWebUtil", "onCoreInitFailed");
                AppMethodBeat.o(80408);
            }
        });
        AppMethodBeat.o(80415);
    }

    public static void a(WebView.d dVar, com.tencent.xweb.WebView.c cVar) {
        AppMethodBeat.i(80416);
        a(ah.getContext(), dVar, cVar);
        AppMethodBeat.o(80416);
    }

    private static void a(Context context, WebView.d dVar, com.tencent.xweb.WebView.c cVar) {
        AppMethodBeat.i(80417);
        if (context == null) {
            context = ah.getContext();
        }
        iw(context);
        WebView.initWebviewCore(context, dVar, a.dOY(), cVar);
        if (dPa()) {
            XWalkEnvironment.setUsingCustomContext(true);
        }
        AppMethodBeat.o(80417);
    }

    public static void iw(Context context) {
        AppMethodBeat.i(80418);
        if (context == null) {
            context = ah.getContext();
        }
        x.a(context, a.AiA, a.AiD, a.AiB, a.AiC);
        if (com.tencent.mm.protocal.d.vxo <= 654312495 && com.tencent.mm.protocal.d.vxo >= 654312448) {
            MMWebView.zNr = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_mar_test.xml";
        }
        XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.zNr);
        XWalkEnvironment.setIsForbidDownloadCode(g.dnY());
        dOZ();
        if (g.dnY()) {
            com.tencent.xweb.x5.sdk.d.forceSysWebView();
        }
        AppMethodBeat.o(80418);
    }

    private static void dOZ() {
        AppMethodBeat.i(80419);
        HashMap hashMap = new HashMap();
        hashMap.put(XWalkEnvironment.XWALK_ENV_MAP_KEY_ISGPVERSION, Boolean.valueOf(g.dnY()));
        hashMap.put(XWalkEnvironment.XWALK_ENV_MAP_KEY_PROCESSNAME, ah.getProcessName());
        XWalkEnvironment.setXWebInitArgs(hashMap);
        AppMethodBeat.o(80419);
    }

    public static boolean dPa() {
        AppMethodBeat.i(80420);
        if (WebView.getCurWebType() == WebView.d.WV_KIND_CW) {
            boolean isCurrentVersionSupportCustomContext = XWalkEnvironment.isCurrentVersionSupportCustomContext();
            AppMethodBeat.o(80420);
            return isCurrentVersionSupportCustomContext;
        }
        AppMethodBeat.o(80420);
        return false;
    }
}
