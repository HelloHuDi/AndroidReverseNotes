package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.k.d;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.bt.b;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awd;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONStringer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiGetAllPhone;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "appId", "", "apiName", "withCredentials", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "jsonStringer", "plugin-appbrand-integration_release"})
public final class c extends a<awd> {
    public c(String str, String str2, boolean z) {
        j.p(str, "appId");
        j.p(str2, "apiName");
        AppMethodBeat.i(134780);
        String ap = ap(str2, z);
        awc awc = new awc();
        awc.fKh = str;
        Charset charset = d.UTF_8;
        if (ap == null) {
            v vVar = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(134780);
            throw vVar;
        }
        byte[] bytes = ap.getBytes(charset);
        j.o(bytes, "(this as java.lang.String).getBytes(charset)");
        awc.jBi = new b(bytes);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(awc);
        aVar.b(new awd());
        aVar.qq("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone");
        aVar.kU(2536);
        aVar.kV(0);
        aVar.kW(0);
        a(aVar.acD());
        AppMethodBeat.o(134780);
    }

    private static String ap(String str, boolean z) {
        AppMethodBeat.i(134779);
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("api_name");
            jSONStringer.value(str);
            jSONStringer.key("with_credentials");
            jSONStringer.value(z);
            jSONStringer.endObject();
        } catch (JSONException e) {
            com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.JsApiGetPhoneNumberNew", e, "", new Object[0]);
        }
        String jSONStringer2 = jSONStringer.toString();
        j.o(jSONStringer2, "jsonStringer.toString()");
        AppMethodBeat.o(134779);
        return jSONStringer2;
    }
}
