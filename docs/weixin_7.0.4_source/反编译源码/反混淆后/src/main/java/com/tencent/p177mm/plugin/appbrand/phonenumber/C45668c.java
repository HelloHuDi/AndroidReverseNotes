package com.tencent.p177mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.awc;
import com.tencent.p177mm.protocal.protobuf.awd;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONStringer;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiGetAllPhone;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "appId", "", "apiName", "withCredentials", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "jsonStringer", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.c */
public final class C45668c extends C37440a<awd> {
    public C45668c(String str, String str2, boolean z) {
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "apiName");
        AppMethodBeat.m2504i(134780);
        String ap = C45668c.m84358ap(str2, z);
        awc awc = new awc();
        awc.fKh = str;
        Charset charset = C17355d.UTF_8;
        if (ap == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.m2505o(134780);
            throw c44941v;
        }
        byte[] bytes = ap.getBytes(charset);
        C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
        awc.jBi = new C1332b(bytes);
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(awc);
        c1196a.mo4446b(new awd());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone");
        c1196a.mo4447kU(2536);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        mo60331a(c1196a.acD());
        AppMethodBeat.m2505o(134780);
    }

    /* renamed from: ap */
    private static String m84358ap(String str, boolean z) {
        AppMethodBeat.m2504i(134779);
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("api_name");
            jSONStringer.value(str);
            jSONStringer.key("with_credentials");
            jSONStringer.value(z);
            jSONStringer.endObject();
        } catch (JSONException e) {
            C45124d.printErrStackTrace("MicroMsg.JsApiGetPhoneNumberNew", e, "", new Object[0]);
        }
        String jSONStringer2 = jSONStringer.toString();
        C25052j.m39375o(jSONStringer2, "jsonStringer.toString()");
        AppMethodBeat.m2505o(134779);
        return jSONStringer2;
    }
}
