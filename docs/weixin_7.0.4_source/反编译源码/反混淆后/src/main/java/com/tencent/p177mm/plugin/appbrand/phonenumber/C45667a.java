package com.tencent.p177mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44164sd;
import com.tencent.p177mm.protocal.protobuf.C44165se;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "appId", "", "mobile", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.a */
public final class C45667a extends C37440a<C44165se> {
    public C45667a(String str, String str2, String str3) {
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "mobile");
        C25052j.m39376p(str3, TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
        AppMethodBeat.m2504i(134777);
        C44164sd c44164sd = new C44164sd();
        c44164sd.csB = str;
        c44164sd.cFl = str2;
        c44164sd.tCi = str3;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(c44164sd);
        c1196a.mo4446b(new C44165se());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode");
        c1196a.mo4447kU(2775);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        mo60331a(c1196a.acD());
        AppMethodBeat.m2505o(134777);
    }
}
