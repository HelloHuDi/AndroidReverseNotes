package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.sdk.platformtools.ab;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/GetSycConfigTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
final class l implements i<IPCString, AppBrandSysConfigWC> {
    public final /* synthetic */ Object am(Object obj) {
        AppMethodBeat.i(134750);
        AppBrandSysConfigWC a = a((IPCString) obj);
        AppMethodBeat.o(134750);
        return a;
    }

    private static AppBrandSysConfigWC a(IPCString iPCString) {
        AppMethodBeat.i(134749);
        ab.i("MicroMsg.AppBrand.FunctionalConfigAssembler", "invoke GetSycConfigTask with ".concat(String.valueOf(iPCString)));
        if (iPCString == null) {
            try {
                j.dWJ();
            } catch (Exception e) {
                AppMethodBeat.o(134749);
                return null;
            }
        }
        if (g.RN().QY()) {
            AppBrandSysConfigWC zj = p.zj(iPCString.value);
            if (zj != null) {
                zj.bQO = AppBrandGlobalSystemConfig.ayC();
                AppMethodBeat.o(134749);
                return zj;
            }
        }
        AppMethodBeat.o(134749);
        return null;
    }
}
