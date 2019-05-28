package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/GetSycConfigTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l */
final class C46896l implements C45413i<IPCString, AppBrandSysConfigWC> {
    /* renamed from: am */
    public final /* synthetic */ Object mo4785am(Object obj) {
        AppMethodBeat.m2504i(134750);
        AppBrandSysConfigWC a = C46896l.m89257a((IPCString) obj);
        AppMethodBeat.m2505o(134750);
        return a;
    }

    /* renamed from: a */
    private static AppBrandSysConfigWC m89257a(IPCString iPCString) {
        AppMethodBeat.m2504i(134749);
        C4990ab.m7416i("MicroMsg.AppBrand.FunctionalConfigAssembler", "invoke GetSycConfigTask with ".concat(String.valueOf(iPCString)));
        if (iPCString == null) {
            try {
                C25052j.dWJ();
            } catch (Exception e) {
                AppMethodBeat.m2505o(134749);
                return null;
            }
        }
        if (C1720g.m3534RN().mo5161QY()) {
            AppBrandSysConfigWC zj = C26842p.m42737zj(iPCString.value);
            if (zj != null) {
                zj.bQO = AppBrandGlobalSystemConfig.ayC();
                AppMethodBeat.m2505o(134749);
                return zj;
            }
        }
        AppMethodBeat.m2505o(134749);
        return null;
    }
}
