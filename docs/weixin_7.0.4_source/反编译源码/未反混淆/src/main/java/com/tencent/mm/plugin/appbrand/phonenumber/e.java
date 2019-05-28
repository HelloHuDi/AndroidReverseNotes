package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bwy;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCodeWxaPhone;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
public final class e extends a<bwy> {
    public e(String str, String str2) {
        j.p(str, "appId");
        j.p(str2, "mobile");
        AppMethodBeat.i(134782);
        bwx bwx = new bwx();
        bwx.csB = str;
        bwx.cFl = str2;
        b.a aVar = new b.a();
        aVar.a(bwx);
        aVar.b(new bwy());
        aVar.qq("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode");
        aVar.kU(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        aVar.kV(0);
        aVar.kW(0);
        a(aVar.acD());
        AppMethodBeat.o(134782);
    }
}
