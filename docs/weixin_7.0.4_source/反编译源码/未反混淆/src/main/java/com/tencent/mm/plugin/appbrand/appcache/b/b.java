package com.tencent.mm.plugin.appbrand.appcache.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.plugin.appbrand.launching.h;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.cga;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/CgiPreDownloadCode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "username", "", "(Ljava/lang/String;)V", "TAG", "getUsername", "()Ljava/lang/String;", "createSingleReqInfo", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class b extends com.tencent.mm.ai.a<blc> {
    private final String TAG = "MicroMsg.AppBrand.CgiPreDownloadCode";
    private final String username;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret> implements com.tencent.mm.vending.g.c.a<_Var> {
        final /* synthetic */ b gVM;

        a(b bVar) {
            this.gVM = bVar;
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.i(134469);
            com.tencent.mm.ai.a.a a = com.tencent.mm.ai.a.a.a(3, -2, "EMPTY USERNAME", new blc(), null, this.gVM);
            AppMethodBeat.o(134469);
            return a;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(String str) {
        WxaAttributes wxaAttributes;
        cga cga;
        int i = 0;
        AppMethodBeat.i(134471);
        this.username = str;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        blb blb = new blb();
        String str2 = this.username;
        cga cga2 = new cga();
        cga2.xfb = str2;
        CharSequence charSequence = str2;
        int i2 = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
        if (i2 != 0) {
            wxaAttributes = null;
        } else {
            wxaAttributes = f.auO().d(str2, new String[0]);
        }
        if (wxaAttributes != null) {
            e ayL = wxaAttributes.ayL();
            if (ayL != null) {
                i2 = ayL.axy;
                cga2.xfc = i2;
                if (wxaAttributes != null) {
                    String str3 = wxaAttributes.field_appId;
                    if (str3 != null) {
                        WxaPkgWrappingInfo bm = h.bm(str3, 0);
                        if (bm != null) {
                            i = bm.gVu;
                        }
                        cga = cga2;
                        cga.xfd = i;
                        blb.wOb = cga2;
                        aVar.a(blb);
                        aVar.b(new blc());
                        aVar.qq("/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode");
                        aVar.kU(1479);
                        a(aVar.acD());
                        AppMethodBeat.o(134471);
                    }
                }
                cga = cga2;
                cga.xfd = i;
                blb.wOb = cga2;
                aVar.a(blb);
                aVar.b(new blc());
                aVar.qq("/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode");
                aVar.kU(1479);
                a(aVar.acD());
                AppMethodBeat.o(134471);
            }
        }
        i2 = 0;
        cga2.xfc = i2;
        if (wxaAttributes != null) {
        }
        cga = cga2;
        cga.xfd = i;
        blb.wOb = cga2;
        aVar.a(blb);
        aVar.b(new blc());
        aVar.qq("/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode");
        aVar.kU(1479);
        a(aVar.acD());
        AppMethodBeat.o(134471);
    }

    public final com.tencent.mm.ci.f<com.tencent.mm.ai.a.a<blc>> acy() {
        AppMethodBeat.i(134470);
        CharSequence charSequence = this.username;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            com.tencent.mm.ci.f c = g.c(new a(this));
            j.o(c, "pipelineExt {\n          …          )\n            }");
            AppMethodBeat.o(134470);
            return c;
        }
        com.tencent.mm.ci.f<com.tencent.mm.ai.a.a<blc>> acy = super.acy();
        j.o(acy, "super.run()");
        AppMethodBeat.o(134470);
        return acy;
    }
}
