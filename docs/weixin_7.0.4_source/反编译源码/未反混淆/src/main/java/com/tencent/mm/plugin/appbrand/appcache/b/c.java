package com.tencent.mm.plugin.appbrand.appcache.b;

import a.a.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.service.h;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "TAG", "", "onRegister", "", "onUnregister", "triggerPreDownload", "username", "plugin-appbrand-integration_release"})
public final class c implements b, h {
    private final String TAG = "MicroMsg.AppBrand.PreDownloadServiceExportImpl";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c gVN;

        a(c cVar) {
            this.gVN = cVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134472);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            if (aVar != null) {
                ab.i(this.gVN.TAG, "onCgiBack errType[" + aVar.errType + "], errCode[" + aVar.errCode + "], errMsg[" + aVar.aIm + ']');
                if (com.tencent.mm.plugin.appbrand.k.a.b(aVar)) {
                    blc blc = (blc) aVar.fsy;
                    if (blc != null) {
                        cgb cgb = blc.wOc;
                        if (cgb != null) {
                            d.aB(k.listOf(cgb));
                        }
                    }
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(134472);
            return yVar;
        }
    }

    public final void xO(String str) {
        AppMethodBeat.i(134473);
        String[] strArr = AppBrandGlobalSystemConfig.ayC().hgh;
        String[] strArr2;
        if (strArr == null) {
            strArr2 = new String[0];
        } else {
            strArr2 = strArr;
        }
        for (String str2 : strArr2) {
            CharSequence charSequence = str2;
            int i = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
            if (i == 0 && str2.equals(str)) {
                ab.i(this.TAG, "username[" + str + "] blacklist, just return");
                AppMethodBeat.o(134473);
                return;
            }
        }
        new b(str).acy().h(new a(this)).dMk();
        AppMethodBeat.o(134473);
    }

    public final void SH() {
    }

    public final void SI() {
    }
}
