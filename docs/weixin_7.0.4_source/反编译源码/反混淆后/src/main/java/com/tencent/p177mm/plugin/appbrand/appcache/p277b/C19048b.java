package com.tencent.p177mm.plugin.appbrand.appcache.p277b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31283e;
import com.tencent.p177mm.plugin.appbrand.launching.C19573h;
import com.tencent.p177mm.protocal.protobuf.blb;
import com.tencent.p177mm.protocal.protobuf.blc;
import com.tencent.p177mm.protocal.protobuf.cga;
import com.tencent.p177mm.vending.p641g.C7361c.C5689a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/CgiPreDownloadCode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "username", "", "(Ljava/lang/String;)V", "TAG", "getUsername", "()Ljava/lang/String;", "createSingleReqInfo", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b */
public final class C19048b extends C37440a<blc> {
    private final String TAG = "MicroMsg.AppBrand.CgiPreDownloadCode";
    private final String username;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b$a */
    static final class C19049a<_Ret> implements C5689a<_Var> {
        final /* synthetic */ C19048b gVM;

        C19049a(C19048b c19048b) {
            this.gVM = c19048b;
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.m2504i(134469);
            C37441a a = C37441a.m63107a(3, -2, "EMPTY USERNAME", new blc(), null, this.gVM);
            AppMethodBeat.m2505o(134469);
            return a;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C19048b(String str) {
        WxaAttributes wxaAttributes;
        cga cga;
        int i = 0;
        AppMethodBeat.m2504i(134471);
        this.username = str;
        C1196a c1196a = new C1196a();
        blb blb = new blb();
        String str2 = this.username;
        cga cga2 = new cga();
        cga2.xfb = str2;
        CharSequence charSequence = str2;
        int i2 = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
        if (i2 != 0) {
            wxaAttributes = null;
        } else {
            wxaAttributes = C42340f.auO().mo21572d(str2, new String[0]);
        }
        if (wxaAttributes != null) {
            C31283e ayL = wxaAttributes.ayL();
            if (ayL != null) {
                i2 = ayL.axy;
                cga2.xfc = i2;
                if (wxaAttributes != null) {
                    String str3 = wxaAttributes.field_appId;
                    if (str3 != null) {
                        WxaPkgWrappingInfo bm = C19573h.m30345bm(str3, 0);
                        if (bm != null) {
                            i = bm.gVu;
                        }
                        cga = cga2;
                        cga.xfd = i;
                        blb.wOb = cga2;
                        c1196a.mo4444a(blb);
                        c1196a.mo4446b(new blc());
                        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode");
                        c1196a.mo4447kU(1479);
                        mo60331a(c1196a.acD());
                        AppMethodBeat.m2505o(134471);
                    }
                }
                cga = cga2;
                cga.xfd = i;
                blb.wOb = cga2;
                c1196a.mo4444a(blb);
                c1196a.mo4446b(new blc());
                c1196a.mo4450qq("/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode");
                c1196a.mo4447kU(1479);
                mo60331a(c1196a.acD());
                AppMethodBeat.m2505o(134471);
            }
        }
        i2 = 0;
        cga2.xfc = i2;
        if (wxaAttributes != null) {
        }
        cga = cga2;
        cga.xfd = i;
        blb.wOb = cga2;
        c1196a.mo4444a(blb);
        c1196a.mo4446b(new blc());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode");
        c1196a.mo4447kU(1479);
        mo60331a(c1196a.acD());
        AppMethodBeat.m2505o(134471);
    }

    public final C37654f<C37441a<blc>> acy() {
        AppMethodBeat.m2504i(134470);
        CharSequence charSequence = this.username;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            C37654f c = C41930g.m74066c(new C19049a(this));
            C25052j.m39375o(c, "pipelineExt {\n          …          )\n            }");
            AppMethodBeat.m2505o(134470);
            return c;
        }
        C37654f<C37441a<blc>> acy = super.acy();
        C25052j.m39375o(acy, "super.run()");
        AppMethodBeat.m2505o(134470);
        return acy;
    }
}
