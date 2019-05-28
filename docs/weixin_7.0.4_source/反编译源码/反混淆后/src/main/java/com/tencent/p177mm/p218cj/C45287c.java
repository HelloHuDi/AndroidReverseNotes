package com.tencent.p177mm.p218cj;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5510e.C5505l;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.xweb.C46838x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.WebView.C46828c;
import com.tencent.xweb.p685x5.sdk.C24544d;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.cj.c */
public final class C45287c {

    /* renamed from: com.tencent.mm.cj.c$1 */
    static class C452881 implements C46828c {
        C452881() {
        }

        public final void onCoreInitFinished() {
            AppMethodBeat.m2504i(80407);
            C4990ab.m7416i("XWebUtil", "onCoreInitFinished");
            AppMethodBeat.m2505o(80407);
        }

        /* renamed from: BH */
        public final void mo4528BH() {
            AppMethodBeat.m2504i(80408);
            C4990ab.m7416i("XWebUtil", "onCoreInitFailed");
            AppMethodBeat.m2505o(80408);
        }
    }

    public static void aNX() {
        AppMethodBeat.m2504i(80409);
        C45287c.atE("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        C45287c.atF("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
        AppMethodBeat.m2505o(80409);
    }

    public static void atD(String str) {
        AppMethodBeat.m2504i(80410);
        C45287c.atE(str);
        C45287c.atF(str);
        AppMethodBeat.m2505o(80410);
    }

    /* renamed from: aZ */
    public static void m83504aZ(Intent intent) {
        AppMethodBeat.m2504i(80411);
        intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        C4996ah.getContext().sendBroadcast(intent);
        if (C25985d.m41450Qb()) {
            AppMethodBeat.m2505o(80411);
            return;
        }
        intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(80411);
    }

    private static void atE(String str) {
        AppMethodBeat.m2504i(80412);
        if (!"com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(str) || C4996ah.amz(C4996ah.getPackageName() + ":tools")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", str);
            C4996ah.getContext().sendBroadcast(intent);
            AppMethodBeat.m2505o(80412);
            return;
        }
        AppMethodBeat.m2505o(80412);
    }

    public static void atF(String str) {
        AppMethodBeat.m2504i(80413);
        if (C25985d.m41450Qb()) {
            AppMethodBeat.m2505o(80413);
        } else if (!"com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(str) || C4996ah.amz(C4996ah.getPackageName() + ":toolsmp")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", str);
            C4996ah.getContext().sendBroadcast(intent);
            AppMethodBeat.m2505o(80413);
        } else {
            AppMethodBeat.m2505o(80413);
        }
    }

    /* renamed from: iv */
    public static boolean m83505iv(Context context) {
        AppMethodBeat.m2504i(80414);
        if (!WebView.isX5() || WebView.getUsingTbsCoreVersion(context) > 36541) {
            AppMethodBeat.m2505o(80414);
            return true;
        }
        C4990ab.m7416i("XWebUtil", "lower version of x5 not support source type ");
        AppMethodBeat.m2505o(80414);
        return false;
    }

    /* renamed from: a */
    public static void m83502a(C44570d c44570d) {
        AppMethodBeat.m2504i(80415);
        C45287c.m83503a(c44570d, new C452881());
        AppMethodBeat.m2505o(80415);
    }

    /* renamed from: a */
    public static void m83503a(C44570d c44570d, C46828c c46828c) {
        AppMethodBeat.m2504i(80416);
        C45287c.m83501a(C4996ah.getContext(), c44570d, c46828c);
        AppMethodBeat.m2505o(80416);
    }

    /* renamed from: a */
    private static void m83501a(Context context, C44570d c44570d, C46828c c46828c) {
        AppMethodBeat.m2504i(80417);
        if (context == null) {
            context = C4996ah.getContext();
        }
        C45287c.m83506iw(context);
        WebView.initWebviewCore(context, c44570d, C1390a.dOY(), c46828c);
        if (C45287c.dPa()) {
            XWalkEnvironment.setUsingCustomContext(true);
        }
        AppMethodBeat.m2505o(80417);
    }

    /* renamed from: iw */
    public static void m83506iw(Context context) {
        AppMethodBeat.m2504i(80418);
        if (context == null) {
            context = C4996ah.getContext();
        }
        C46838x.m89073a(context, C1390a.AiA, C1390a.AiD, C1390a.AiB, C1390a.AiC);
        if (C7243d.vxo <= 654312495 && C7243d.vxo >= 654312448) {
            MMWebView.zNr = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_mar_test.xml";
        }
        XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.zNr);
        XWalkEnvironment.setIsForbidDownloadCode(C5059g.dnY());
        C45287c.dOZ();
        if (C5059g.dnY()) {
            C24544d.forceSysWebView();
        }
        AppMethodBeat.m2505o(80418);
    }

    private static void dOZ() {
        AppMethodBeat.m2504i(80419);
        HashMap hashMap = new HashMap();
        hashMap.put(XWalkEnvironment.XWALK_ENV_MAP_KEY_ISGPVERSION, Boolean.valueOf(C5059g.dnY()));
        hashMap.put(XWalkEnvironment.XWALK_ENV_MAP_KEY_PROCESSNAME, C4996ah.getProcessName());
        XWalkEnvironment.setXWebInitArgs(hashMap);
        AppMethodBeat.m2505o(80419);
    }

    public static boolean dPa() {
        AppMethodBeat.m2504i(80420);
        if (WebView.getCurWebType() == C44570d.WV_KIND_CW) {
            boolean isCurrentVersionSupportCustomContext = XWalkEnvironment.isCurrentVersionSupportCustomContext();
            AppMethodBeat.m2505o(80420);
            return isCurrentVersionSupportCustomContext;
        }
        AppMethodBeat.m2505o(80420);
        return false;
    }
}
