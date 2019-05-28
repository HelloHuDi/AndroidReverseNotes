package com.tencent.p177mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.LaunchParamsOptional;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.launching.C42611l;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.j */
public final class C26850j implements C3473o {
    public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
        AppMethodBeat.m2504i(129946);
        if (map != null) {
            String str2 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.AppID");
            String str3 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.UserName");
            String str4 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.Path");
            String str5 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.URL");
            String str6 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.MD5");
            String str7 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.ExtInfo");
            C4990ab.m7417i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "onNewXmlReceived appId %s, userName %s, path %s, url %s, md5 %s, extInfo %s", str2, str3, str4, str5, str6, str7);
            if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str5)) {
                C4990ab.m7417i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "appId = %s, username = %s, codeURL = %s, invalid, return", str2, str3, str5);
                AppMethodBeat.m2505o(129946);
                return;
            }
            if (C42340f.auV().mo60848a(str2, 1, str5, str6, 0, C5046bo.anT() + 7200)) {
                C45694h.m84422bt(str2, 1);
            }
            LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
            launchParamsOptional.fpI = str7;
            ((C42611l) C42340f.m74878E(C42611l.class)).mo68053n(str2, 1, str7);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1101;
            appBrandStatObject.cst = str2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str3;
            AppBrandLaunchProxyUI.m25693a(C4996ah.getContext(), str3, str4, 1, -1, appBrandStatObject, null, launchParamsOptional);
        }
        AppMethodBeat.m2505o(129946);
    }
}
