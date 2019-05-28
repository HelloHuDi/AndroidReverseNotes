package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.protocal.protobuf.ckh;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "appId", "", "mobile", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "plugin-appbrand-integration_release"})
public final class f extends com.tencent.mm.ai.a<ckh> {
    public static final a ixf = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone$Companion;", "", "()V", "ADD", "", "DELETE", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(134784);
        AppMethodBeat.o(134784);
    }

    public f(String str, String str2, int i) {
        j.p(str, "appId");
        j.p(str2, "mobile");
        AppMethodBeat.i(134783);
        ckg ckg = new ckg();
        ckg.csB = str;
        ckg.cFl = str2;
        ckg.type = i;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(ckg);
        aVar.b(new ckh());
        aVar.qq("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone");
        aVar.kU(2932);
        aVar.kV(0);
        aVar.kW(0);
        a(aVar.acD());
        AppMethodBeat.o(134783);
    }
}
