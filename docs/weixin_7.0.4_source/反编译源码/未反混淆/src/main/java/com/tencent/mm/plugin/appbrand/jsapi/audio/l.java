package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;

public class l extends k {
    public final String f(c cVar, String str) {
        String absolutePath;
        AppMethodBeat.i(74739);
        try {
            if (cVar.asE() instanceof s) {
                ao findAppropriateModuleInfo = ((IWxaFileSystemWithModularizing) ((s) cVar.asE()).ae(IWxaFileSystemWithModularizing.class)).findAppropriateModuleInfo(str);
                if (findAppropriateModuleInfo != null) {
                    absolutePath = findAppropriateModuleInfo.gUc.getAbsolutePath();
                    AppMethodBeat.o(74739);
                    return absolutePath;
                }
            }
        } catch (Exception e) {
            d.e("MicroMsg.JsApiSetAudioStateWxaApp", "getPkgPath with audioSrc(%s), e=%s", str, e);
        }
        h hVar = (h) cVar.aa(h.class);
        if (hVar == null) {
            ab.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig() is null");
            absolutePath = "";
            AppMethodBeat.o(74739);
            return absolutePath;
        } else if (hVar.hhd == null) {
            ab.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig().appPkgInfo is null");
            absolutePath = "";
            AppMethodBeat.o(74739);
            return absolutePath;
        } else {
            ab.d("MicroMsg.WxaAudioUtils", "getPkgPath:%s", hVar.hhd.gSP);
            absolutePath = hVar.hhd.gSP;
            AppMethodBeat.o(74739);
            return absolutePath;
        }
    }
}
