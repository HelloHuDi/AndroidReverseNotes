package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C46883co;
import com.tencent.p177mm.p230g.p232b.p233a.C46883co.C45383a;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45571aj.C2201a;
import com.tencent.p177mm.plugin.appbrand.report.model.C2445j;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J,\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b*\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\fH\u0002¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b*\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\fH\u0002¢\u0006\u0002\u0010\r¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRectWithReport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "invoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "data", "Lorg/json/JSONObject;", "component1", "L", "R", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ak */
public final class C19287ak extends C45571aj {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRectWithReport$invoke$1$1"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ak$a */
    static final class C19288a implements Runnable {
        final /* synthetic */ long hwW;
        final /* synthetic */ C2201a hwX;
        final /* synthetic */ String hwY;
        final /* synthetic */ C19287ak hwZ;
        final /* synthetic */ C38492q hxa;
        final /* synthetic */ long hxb;

        C19288a(long j, C2201a c2201a, String str, C19287ak c19287ak, C38492q c38492q, long j2) {
            this.hwW = j;
            this.hwX = c2201a;
            this.hwY = str;
            this.hwZ = c19287ak;
            this.hxa = c38492q;
            this.hxb = j2;
        }

        public final void run() {
            AppMethodBeat.m2504i(134640);
            C46883co c46883co = new C46883co();
            QualitySessionRuntime DG = C27285a.m43319DG(this.hxa.getAppId());
            if (DG == null) {
                AppMethodBeat.m2505o(134640);
                return;
            }
            long j;
            c46883co.mo76075hu(DG.appId);
            c46883co.mo76070a(C45383a.m83560ho(DG.iCZ));
            c46883co.mo76071ev((long) DG.apptype);
            c46883co.mo76072ew(this.hwW);
            c46883co.mo76073ex((long) DG.scene);
            C2201a c2201a = this.hwX;
            if (c2201a != null) {
                switch (C26916al.eQZ[c2201a.ordinal()]) {
                    case 1:
                        j = 1;
                        break;
                    case 2:
                        j = 2;
                        break;
                }
            }
            j = 0;
            c46883co.mo76074ey(j);
            c46883co.mo76076hv(C2445j.m4682DE(this.hwY));
            c46883co.ajK();
            AppMethodBeat.m2505o(134640);
        }
    }

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(134642);
        String c = mo34479c((C38492q) c2241c);
        AppMethodBeat.m2505o(134642);
        return c;
    }

    /* renamed from: c */
    public final String mo34479c(C38492q c38492q) {
        AppMethodBeat.m2504i(134641);
        long yz = C5046bo.m7588yz();
        Pair d = super.mo73377d(c38492q);
        C25052j.m39376p(d, "receiver$0");
        String str = (String) d.first;
        C25052j.m39376p(d, "receiver$0");
        C2201a c2201a = (C2201a) d.second;
        if (c38492q != null) {
            C7305d.xDG.execute(new C19288a(C5046bo.m7588yz() - yz, c2201a, str, this, c38492q, yz));
        }
        Object obj = d.first;
        C25052j.m39375o(obj, "super.invokeImpl(env, da…       }\n\n        }.first");
        String str2 = (String) obj;
        AppMethodBeat.m2505o(134641);
        return str2;
    }
}
