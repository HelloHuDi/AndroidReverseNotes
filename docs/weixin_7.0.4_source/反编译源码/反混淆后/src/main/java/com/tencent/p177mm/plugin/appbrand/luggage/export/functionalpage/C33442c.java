package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import android.util.SparseArray;
import com.tencent.luggage.sdk.launching.C17829b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalAPIInvokeManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "performInvoke", "invokeData", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.c */
public final class C33442c {
    int iko;
    final SparseArray<C2384a> ikp = new SparseArray();
    final C27187j ikq;

    public C33442c(C27187j c27187j) {
        C25052j.m39376p(c27187j, "runtime");
        AppMethodBeat.m2504i(134734);
        this.ikq = c27187j;
        AppMethodBeat.m2505o(134734);
    }

    /* renamed from: a */
    public final void mo53934a(C38436m c38436m, int i, String str) {
        AppMethodBeat.m2504i(134732);
        C25052j.m39376p(c38436m, "component");
        C25052j.m39376p(str, "data");
        C2384a c2384a = (C2384a) this.ikp.get(i, null);
        if (c2384a instanceof C45647n) {
            this.ikp.remove(i);
            mo53935cy(((C45647n) c2384a).hgU, str);
            AppMethodBeat.m2505o(134732);
            return;
        }
        if (c2384a instanceof C38437o) {
            this.ikp.remove(i);
            this.ikq.finish();
        }
        AppMethodBeat.m2505o(134732);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cy */
    public final void mo53935cy(String str, String str2) {
        AppMethodBeat.m2504i(134733);
        C17829b c17829b = this.ikq.atI().bQm;
        if (c17829b == null) {
            this.iko++;
            int i = this.iko;
            C41726i c41726i = new C41726i();
            C41726i c41726i2 = new C41726i();
            c41726i2.mo67475g("data", str2);
            c41726i2.mo67475g("transitiveData", str);
            c41726i.mo67475g("extraData", c41726i2);
            String c41726i3 = c41726i.toString();
            C25052j.m39375o(c41726i3, "JSONObject().apply {\n   …   )\n        }.toString()");
            this.ikp.put(i, C38437o.ikE);
            this.ikq.atK().mo53814n(JsApiNavigateBackApplication.NAME, c41726i3, i);
            AppMethodBeat.m2505o(134733);
        } else if (c17829b == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.luggage.sdk.launching.OnWXAppResultListener<com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult>");
            AppMethodBeat.m2505o(134733);
            throw c44941v;
        } else {
            c17829b.mo20080a(new ByRuntimeQrcodeResult(str2, str));
            this.ikq.finish();
            AppMethodBeat.m2505o(134733);
        }
    }
}
