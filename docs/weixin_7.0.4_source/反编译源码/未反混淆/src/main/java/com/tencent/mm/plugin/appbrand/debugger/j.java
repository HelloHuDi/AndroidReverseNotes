package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.l;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;

public final class j implements o {
    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        AppMethodBeat.i(129946);
        if (map != null) {
            String str2 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.AppID");
            String str3 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.UserName");
            String str4 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.Path");
            String str5 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.URL");
            String str6 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.MD5");
            String str7 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.ExtInfo");
            ab.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "onNewXmlReceived appId %s, userName %s, path %s, url %s, md5 %s, extInfo %s", str2, str3, str4, str5, str6, str7);
            if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || bo.isNullOrNil(str5)) {
                ab.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "appId = %s, username = %s, codeURL = %s, invalid, return", str2, str3, str5);
                AppMethodBeat.o(129946);
                return;
            }
            if (f.auV().a(str2, 1, str5, str6, 0, bo.anT() + 7200)) {
                h.bt(str2, 1);
            }
            LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
            launchParamsOptional.fpI = str7;
            ((l) f.E(l.class)).n(str2, 1, str7);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1101;
            appBrandStatObject.cst = str2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str3;
            AppBrandLaunchProxyUI.a(ah.getContext(), str3, str4, 1, -1, appBrandStatObject, null, launchParamsOptional);
        }
        AppMethodBeat.o(129946);
    }
}
