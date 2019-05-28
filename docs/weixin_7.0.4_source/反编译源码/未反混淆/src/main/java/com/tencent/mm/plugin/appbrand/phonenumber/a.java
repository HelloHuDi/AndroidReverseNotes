package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.sd;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "appId", "", "mobile", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
public final class a extends com.tencent.mm.ai.a<se> {
    public a(String str, String str2, String str3) {
        j.p(str, "appId");
        j.p(str2, "mobile");
        j.p(str3, TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
        AppMethodBeat.i(134777);
        sd sdVar = new sd();
        sdVar.csB = str;
        sdVar.cFl = str2;
        sdVar.tCi = str3;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(sdVar);
        aVar.b(new se());
        aVar.qq("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode");
        aVar.kU(2775);
        aVar.kV(0);
        aVar.kW(0);
        a(aVar.acD());
        AppMethodBeat.o(134777);
    }
}
