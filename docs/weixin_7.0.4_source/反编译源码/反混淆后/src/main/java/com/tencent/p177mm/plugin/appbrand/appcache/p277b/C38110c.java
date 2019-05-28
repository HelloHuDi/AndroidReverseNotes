package com.tencent.p177mm.plugin.appbrand.appcache.p277b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1695b;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.p904k.C42597a;
import com.tencent.p177mm.plugin.appbrand.service.C19732h;
import com.tencent.p177mm.protocal.protobuf.blc;
import com.tencent.p177mm.protocal.protobuf.cgb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25033k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "TAG", "", "onRegister", "", "onUnregister", "triggerPreDownload", "username", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.c */
public final class C38110c implements C1695b, C19732h {
    private final String TAG = "MicroMsg.AppBrand.PreDownloadServiceExportImpl";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.c$a */
    static final class C38111a<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ C38110c gVN;

        C38111a(C38110c c38110c) {
            this.gVN = c38110c;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134472);
            C37441a c37441a = (C37441a) obj;
            if (c37441a != null) {
                C4990ab.m7416i(this.gVN.TAG, "onCgiBack errType[" + c37441a.errType + "], errCode[" + c37441a.errCode + "], errMsg[" + c37441a.aIm + ']');
                if (C42597a.m75415b(c37441a)) {
                    blc blc = (blc) c37441a.fsy;
                    if (blc != null) {
                        cgb cgb = blc.wOc;
                        if (cgb != null) {
                            C42354d.m74909aB(C25033k.listOf(cgb));
                        }
                    }
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134472);
            return c37091y;
        }
    }

    /* renamed from: xO */
    public final void mo34966xO(String str) {
        AppMethodBeat.m2504i(134473);
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
                C4990ab.m7416i(this.TAG, "username[" + str + "] blacklist, just return");
                AppMethodBeat.m2505o(134473);
                return;
            }
        }
        new C19048b(str).acy().mo60492h(new C38111a(this)).dMk();
        AppMethodBeat.m2505o(134473);
    }

    /* renamed from: SH */
    public final void mo5202SH() {
    }

    /* renamed from: SI */
    public final void mo5203SI() {
    }
}
