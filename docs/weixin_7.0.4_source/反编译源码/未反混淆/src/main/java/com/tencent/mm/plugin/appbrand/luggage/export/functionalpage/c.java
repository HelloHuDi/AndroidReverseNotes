package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import a.l;
import a.v;
import android.util.SparseArray;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalAPIInvokeManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "callbackContextMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CallbackContext;", "callbackIdGenerator", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "navigateBack", "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "performInvoke", "invokeData", "plugin-appbrand-integration_release"})
public final class c {
    int iko;
    final SparseArray<a> ikp = new SparseArray();
    final j ikq;

    public c(j jVar) {
        j.p(jVar, "runtime");
        AppMethodBeat.i(134734);
        this.ikq = jVar;
        AppMethodBeat.o(134734);
    }

    public final void a(m mVar, int i, String str) {
        AppMethodBeat.i(134732);
        j.p(mVar, "component");
        j.p(str, "data");
        a aVar = (a) this.ikp.get(i, null);
        if (aVar instanceof n) {
            this.ikp.remove(i);
            cy(((n) aVar).hgU, str);
            AppMethodBeat.o(134732);
            return;
        }
        if (aVar instanceof o) {
            this.ikp.remove(i);
            this.ikq.finish();
        }
        AppMethodBeat.o(134732);
    }

    /* Access modifiers changed, original: final */
    public final void cy(String str, String str2) {
        AppMethodBeat.i(134733);
        b bVar = this.ikq.atI().bQm;
        if (bVar == null) {
            this.iko++;
            int i = this.iko;
            i iVar = new i();
            i iVar2 = new i();
            iVar2.g("data", str2);
            iVar2.g("transitiveData", str);
            iVar.g("extraData", iVar2);
            String iVar3 = iVar.toString();
            j.o(iVar3, "JSONObject().apply {\n   …   )\n        }.toString()");
            this.ikp.put(i, o.ikE);
            this.ikq.atK().n(JsApiNavigateBackApplication.NAME, iVar3, i);
            AppMethodBeat.o(134733);
        } else if (bVar == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.launching.OnWXAppResultListener<com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult>");
            AppMethodBeat.o(134733);
            throw vVar;
        } else {
            bVar.a(new ByRuntimeQrcodeResult(str2, str));
            this.ikq.finish();
            AppMethodBeat.o(134733);
        }
    }
}
