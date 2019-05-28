package com.tencent.luggage.sdk.p148b;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.C31311k;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26836a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26839b;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.task.C38520i;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42740n;
import java.util.Iterator;

/* renamed from: com.tencent.luggage.sdk.b.a */
public class C0993a extends C31311k {

    /* renamed from: com.tencent.luggage.sdk.b.a$2 */
    class C09952 implements C26836a {
        C09952() {
        }

        /* renamed from: a */
        public final void mo3966a(C26839b c26839b, boolean z) {
            AppMethodBeat.m2504i(101683);
            C45124d.m82929i("Luggage.AppBrandRuntimeContainerLU", "onOrientationChanged");
            if (!z) {
                String str;
                String str2 = "Luggage.AppBrandRuntimeContainerLU";
                String str3 = "OnOrientationChanged failure  ret:[%s]";
                Object[] objArr = new Object[1];
                if (c26839b == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c26839b.name();
                }
                objArr[0] = str;
                C45124d.m82928e(str2, str3, objArr);
            }
            AppMethodBeat.m2505o(101683);
        }
    }

    public C0993a(C38520i c38520i, Class<? extends C6750i> cls) {
        super(c38520i, cls);
    }

    /* renamed from: a */
    public final void mo3964a(final C6750i c6750i, final AppBrandInitConfigLU appBrandInitConfigLU, final AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(101684);
        if (appBrandInitConfigLU == null || appBrandStatObject == null) {
            AppMethodBeat.m2505o(101684);
            return;
        }
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                C6750i c6750i;
                AppMethodBeat.m2504i(101682);
                C42740n.m75745w(C0993a.this.gNy);
                if (c6750i == null) {
                    C0993a.this.atx();
                }
                C0993a c0993a = C0993a.this;
                String str = appBrandInitConfigLU.appId;
                Iterator it = c0993a.gOB.iterator();
                while (it.hasNext()) {
                    c6750i = (C6750i) it.next();
                    if (c6750i.mAppId.equals(str)) {
                        break;
                    }
                }
                c6750i = (C6750i) c0993a.gOC.get(str);
                c6750i = (C25697b) c6750i;
                appBrandInitConfigLU.bQn = appBrandStatObject;
                if (c6750i == null) {
                    c6750i = (C25697b) C0993a.this.mo34757e((AppBrandInitConfig) appBrandInitConfigLU);
                    c0993a = C0993a.this;
                    AppBrandInitConfigLU appBrandInitConfigLU = appBrandInitConfigLU;
                    if (!TextUtils.isEmpty(appBrandInitConfigLU.hfh)) {
                        Activity context = c0993a.gOD.getContext();
                        if (!(context == null || context.isFinishing())) {
                            C45124d.m82930i("Luggage.AppBrandRuntimeContainerLU", "tryRequestOrientation appId[%s] orientation[%s]", appBrandInitConfigLU.appId, appBrandInitConfigLU.hfh);
                            C26835a.m42717t(context).mo44609a(C26835a.m42716g(appBrandInitConfigLU), new C09952());
                        }
                    }
                    C0993a.this.mo34753a(c6750i, c6750i, appBrandInitConfigLU);
                } else if (c6750i == c6750i) {
                    C0993a.this.mo34755b(null, c6750i, (AppBrandInitConfig) appBrandInitConfigLU);
                    C0993a.this.onResume();
                } else {
                    C0993a.this.mo34755b(c6750i, c6750i, (AppBrandInitConfig) appBrandInitConfigLU);
                }
                if (C0993a.this.mo51269e(c6750i) && c6750i.asU() != null) {
                    c6750i.gNS = true;
                }
                AppMethodBeat.m2505o(101682);
            }
        });
        AppMethodBeat.m2505o(101684);
    }
}
