package com.tencent.p177mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bwx;
import com.tencent.p177mm.protocal.protobuf.bwy;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.d */
public final class C41250d extends C37440a<bwy> {
    public C41250d(String str, String str2) {
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "mobile");
        AppMethodBeat.m2504i(134781);
        bwx bwx = new bwx();
        bwx.csB = str;
        bwx.cFl = str2;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(bwx);
        c1196a.mo4446b(new bwy());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode");
        c1196a.mo4447kU(2695);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        mo60331a(c1196a.acD());
        AppMethodBeat.m2505o(134781);
    }
}
