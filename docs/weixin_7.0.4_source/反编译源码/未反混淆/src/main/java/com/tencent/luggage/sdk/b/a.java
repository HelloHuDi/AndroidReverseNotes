package com.tencent.luggage.sdk.b;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import java.util.Iterator;

public class a extends k {
    public a(i iVar, Class<? extends com.tencent.mm.plugin.appbrand.i> cls) {
        super(iVar, cls);
    }

    public final void a(final com.tencent.mm.plugin.appbrand.i iVar, final AppBrandInitConfigLU appBrandInitConfigLU, final AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(101684);
        if (appBrandInitConfigLU == null || appBrandStatObject == null) {
            AppMethodBeat.o(101684);
            return;
        }
        m.runOnUiThread(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.appbrand.i iVar;
                AppMethodBeat.i(101682);
                n.w(a.this.gNy);
                if (iVar == null) {
                    a.this.atx();
                }
                a aVar = a.this;
                String str = appBrandInitConfigLU.appId;
                Iterator it = aVar.gOB.iterator();
                while (it.hasNext()) {
                    iVar = (com.tencent.mm.plugin.appbrand.i) it.next();
                    if (iVar.mAppId.equals(str)) {
                        break;
                    }
                }
                iVar = (com.tencent.mm.plugin.appbrand.i) aVar.gOC.get(str);
                iVar = (b) iVar;
                appBrandInitConfigLU.bQn = appBrandStatObject;
                if (iVar == null) {
                    iVar = (b) a.this.e((AppBrandInitConfig) appBrandInitConfigLU);
                    aVar = a.this;
                    AppBrandInitConfigLU appBrandInitConfigLU = appBrandInitConfigLU;
                    if (!TextUtils.isEmpty(appBrandInitConfigLU.hfh)) {
                        Activity context = aVar.gOD.getContext();
                        if (!(context == null || context.isFinishing())) {
                            d.i("Luggage.AppBrandRuntimeContainerLU", "tryRequestOrientation appId[%s] orientation[%s]", appBrandInitConfigLU.appId, appBrandInitConfigLU.hfh);
                            com.tencent.mm.plugin.appbrand.config.a.a.t(context).a(com.tencent.mm.plugin.appbrand.config.a.a.g(appBrandInitConfigLU), new com.tencent.mm.plugin.appbrand.config.a.a.a() {
                                public final void a(b bVar, boolean z) {
                                    AppMethodBeat.i(101683);
                                    d.i("Luggage.AppBrandRuntimeContainerLU", "onOrientationChanged");
                                    if (!z) {
                                        String str;
                                        String str2 = "Luggage.AppBrandRuntimeContainerLU";
                                        String str3 = "OnOrientationChanged failure  ret:[%s]";
                                        Object[] objArr = new Object[1];
                                        if (bVar == null) {
                                            str = BuildConfig.COMMAND;
                                        } else {
                                            str = bVar.name();
                                        }
                                        objArr[0] = str;
                                        d.e(str2, str3, objArr);
                                    }
                                    AppMethodBeat.o(101683);
                                }
                            });
                        }
                    }
                    a.this.a(iVar, iVar, appBrandInitConfigLU);
                } else if (iVar == iVar) {
                    a.this.b(null, iVar, (AppBrandInitConfig) appBrandInitConfigLU);
                    a.this.onResume();
                } else {
                    a.this.b(iVar, iVar, (AppBrandInitConfig) appBrandInitConfigLU);
                }
                if (a.this.e(iVar) && iVar.asU() != null) {
                    iVar.gNS = true;
                }
                AppMethodBeat.o(101682);
            }
        });
        AppMethodBeat.o(101684);
    }
}
