package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C45512ao;
import com.tencent.p177mm.plugin.appbrand.appstorage.C33102s;
import com.tencent.p177mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.l */
public class C44695l extends C42473k {
    /* renamed from: f */
    public final String mo67977f(C2241c c2241c, String str) {
        String absolutePath;
        AppMethodBeat.m2504i(74739);
        try {
            if (c2241c.asE() instanceof C33102s) {
                C45512ao findAppropriateModuleInfo = ((IWxaFileSystemWithModularizing) ((C33102s) c2241c.asE()).mo53654ae(IWxaFileSystemWithModularizing.class)).findAppropriateModuleInfo(str);
                if (findAppropriateModuleInfo != null) {
                    absolutePath = findAppropriateModuleInfo.gUc.getAbsolutePath();
                    AppMethodBeat.m2505o(74739);
                    return absolutePath;
                }
            }
        } catch (Exception e) {
            C45124d.m82928e("MicroMsg.JsApiSetAudioStateWxaApp", "getPkgPath with audioSrc(%s), e=%s", str, e);
        }
        C16597h c16597h = (C16597h) c2241c.mo5937aa(C16597h.class);
        if (c16597h == null) {
            C4990ab.m7412e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig() is null");
            absolutePath = "";
            AppMethodBeat.m2505o(74739);
            return absolutePath;
        } else if (c16597h.hhd == null) {
            C4990ab.m7412e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig().appPkgInfo is null");
            absolutePath = "";
            AppMethodBeat.m2505o(74739);
            return absolutePath;
        } else {
            C4990ab.m7411d("MicroMsg.WxaAudioUtils", "getPkgPath:%s", c16597h.hhd.gSP);
            absolutePath = c16597h.hhd.gSP;
            AppMethodBeat.m2505o(74739);
            return absolutePath;
        }
    }
}
