package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.cjx;
import com.tencent.p177mm.protocal.protobuf.cjy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateRuntimeQrcodeResponse;", "uuid", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b */
public final class C10608b extends C37440a<cjy> {
    public static final C10609a ikn = new C10609a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode$Companion;", "", "()V", "CANCELLED", "", "CONFIRMED", "SCANNED", "TAG", "", "cancel", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "uuid", "confirm", "respData", "scanned", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b$a */
    public static final class C10609a {
        private C10609a() {
        }

        public /* synthetic */ C10609a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(134728);
        AppMethodBeat.m2505o(134728);
    }

    private C10608b(String str, int i, String str2) {
        AppMethodBeat.m2504i(134727);
        C1196a c1196a = new C1196a();
        cjx cjx = new cjx();
        cjx.eCq = str;
        cjx.status = i;
        cjx.xik = str2;
        c1196a.mo4444a(cjx);
        c1196a.mo4446b(new cjy());
        c1196a.mo4447kU(2578);
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/wxabusiness/updateruntimeqrcode");
        mo60331a(c1196a.acD());
        AppMethodBeat.m2505o(134727);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
        AppMethodBeat.m2504i(134726);
        C4990ab.m7416i("MicroMsg.CgiUpdateRuntimeQrcode", "onCgiBack errType[" + i + "] errCode[" + i2 + "] errMsg[" + str + ']');
        AppMethodBeat.m2505o(134726);
    }

    /* renamed from: Cp */
    public static final C10608b m18290Cp(String str) {
        AppMethodBeat.m2504i(134729);
        C25052j.m39376p(str, "uuid");
        C10608b c10608b = new C10608b(str, 4);
        AppMethodBeat.m2505o(134729);
        return c10608b;
    }

    /* renamed from: Cq */
    public static final C10608b m18291Cq(String str) {
        AppMethodBeat.m2504i(134730);
        C25052j.m39376p(str, "uuid");
        C10608b c10608b = new C10608b(str, 1);
        AppMethodBeat.m2505o(134730);
        return c10608b;
    }

    /* renamed from: cx */
    public static final C10608b m18292cx(String str, String str2) {
        AppMethodBeat.m2504i(134731);
        C25052j.m39376p(str, "uuid");
        C25052j.m39376p(str2, "respData");
        C10608b c10608b = new C10608b(str, str2);
        AppMethodBeat.m2505o(134731);
        return c10608b;
    }
}
