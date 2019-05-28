package com.tencent.p177mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ckg;
import com.tencent.p177mm.protocal.protobuf.ckh;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "appId", "", "mobile", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.f */
public final class C10698f extends C37440a<ckh> {
    public static final C10699a ixf = new C10699a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone$Companion;", "", "()V", "ADD", "", "DELETE", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.f$a */
    public static final class C10699a {
        private C10699a() {
        }

        public /* synthetic */ C10699a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(134784);
        AppMethodBeat.m2505o(134784);
    }

    public C10698f(String str, String str2, int i) {
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "mobile");
        AppMethodBeat.m2504i(134783);
        ckg ckg = new ckg();
        ckg.csB = str;
        ckg.cFl = str2;
        ckg.type = i;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(ckg);
        c1196a.mo4446b(new ckh());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone");
        c1196a.mo4447kU(2932);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        mo60331a(c1196a.acD());
        AppMethodBeat.m2505o(134783);
    }
}
