package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateRuntimeQrcodeResponse;", "uuid", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-appbrand-integration_release"})
public final class b extends com.tencent.mm.ai.a<cjy> {
    public static final a ikn = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode$Companion;", "", "()V", "CANCELLED", "", "CONFIRMED", "SCANNED", "TAG", "", "cancel", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "uuid", "confirm", "respData", "scanned", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(134728);
        AppMethodBeat.o(134728);
    }

    private b(String str, int i, String str2) {
        AppMethodBeat.i(134727);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        cjx cjx = new cjx();
        cjx.eCq = str;
        cjx.status = i;
        cjx.xik = str2;
        aVar.a(cjx);
        aVar.b(new cjy());
        aVar.kU(2578);
        aVar.qq("/cgi-bin/mmbiz-bin/wxabusiness/updateruntimeqrcode");
        a(aVar.acD());
        AppMethodBeat.o(134727);
    }

    public final /* synthetic */ void a(int i, int i2, String str, btd btd, m mVar) {
        AppMethodBeat.i(134726);
        ab.i("MicroMsg.CgiUpdateRuntimeQrcode", "onCgiBack errType[" + i + "] errCode[" + i2 + "] errMsg[" + str + ']');
        AppMethodBeat.o(134726);
    }

    public static final b Cp(String str) {
        AppMethodBeat.i(134729);
        j.p(str, "uuid");
        b bVar = new b(str, 4);
        AppMethodBeat.o(134729);
        return bVar;
    }

    public static final b Cq(String str) {
        AppMethodBeat.i(134730);
        j.p(str, "uuid");
        b bVar = new b(str, 1);
        AppMethodBeat.o(134730);
        return bVar;
    }

    public static final b cx(String str, String str2) {
        AppMethodBeat.i(134731);
        j.p(str, "uuid");
        j.p(str2, "respData");
        b bVar = new b(str, str2);
        AppMethodBeat.o(134731);
        return bVar;
    }
}
