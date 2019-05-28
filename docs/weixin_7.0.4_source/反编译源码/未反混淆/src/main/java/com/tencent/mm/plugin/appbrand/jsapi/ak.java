package com.tencent.mm.plugin.appbrand.jsapi;

import a.l;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.co;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.model.j;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J,\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b*\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\fH\u0002¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b*\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\fH\u0002¢\u0006\u0002\u0010\r¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRectWithReport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "invoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "data", "Lorg/json/JSONObject;", "component1", "L", "R", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "plugin-appbrand-integration_release"})
public final class ak extends aj {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRectWithReport$invoke$1$1"})
    static final class a implements Runnable {
        final /* synthetic */ long hwW;
        final /* synthetic */ a hwX;
        final /* synthetic */ String hwY;
        final /* synthetic */ ak hwZ;
        final /* synthetic */ q hxa;
        final /* synthetic */ long hxb;

        a(long j, a aVar, String str, ak akVar, q qVar, long j2) {
            this.hwW = j;
            this.hwX = aVar;
            this.hwY = str;
            this.hwZ = akVar;
            this.hxa = qVar;
            this.hxb = j2;
        }

        public final void run() {
            AppMethodBeat.i(134640);
            co coVar = new co();
            QualitySessionRuntime DG = com.tencent.mm.plugin.appbrand.report.quality.a.DG(this.hxa.getAppId());
            if (DG == null) {
                AppMethodBeat.o(134640);
                return;
            }
            long j;
            coVar.hu(DG.appId);
            coVar.a(com.tencent.mm.g.b.a.co.a.ho(DG.iCZ));
            coVar.ev((long) DG.apptype);
            coVar.ew(this.hwW);
            coVar.ex((long) DG.scene);
            a aVar = this.hwX;
            if (aVar != null) {
                switch (al.eQZ[aVar.ordinal()]) {
                    case 1:
                        j = 1;
                        break;
                    case 2:
                        j = 2;
                        break;
                }
            }
            j = 0;
            coVar.ey(j);
            coVar.hv(j.DE(this.hwY));
            coVar.ajK();
            AppMethodBeat.o(134640);
        }
    }

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(134642);
        String c = c((q) cVar);
        AppMethodBeat.o(134642);
        return c;
    }

    public final String c(q qVar) {
        AppMethodBeat.i(134641);
        long yz = bo.yz();
        Pair d = super.d(qVar);
        a.f.b.j.p(d, "receiver$0");
        String str = (String) d.first;
        a.f.b.j.p(d, "receiver$0");
        a aVar = (a) d.second;
        if (qVar != null) {
            d.xDG.execute(new a(bo.yz() - yz, aVar, str, this, qVar, yz));
        }
        Object obj = d.first;
        a.f.b.j.o(obj, "super.invokeImpl(env, da…       }\n\n        }.first");
        String str2 = (String) obj;
        AppMethodBeat.o(134641);
        return str2;
    }
}
