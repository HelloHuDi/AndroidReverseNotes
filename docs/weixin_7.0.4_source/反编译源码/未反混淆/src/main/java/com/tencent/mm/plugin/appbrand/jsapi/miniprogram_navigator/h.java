package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.b;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONObject;

public class h implements c {
    static final h hQV = new h();

    static {
        AppMethodBeat.i(101993);
        AppMethodBeat.o(101993);
    }

    public boolean a(d dVar, LaunchParcel launchParcel, b bVar) {
        return false;
    }

    public c<AppBrandInitConfigLU> a(d dVar, LaunchParcel launchParcel) {
        AppMethodBeat.i(101991);
        c cU = f.cU(null);
        AppMethodBeat.o(101991);
        return cU;
    }

    public final void a(final d dVar, String str, int i, String str2, a aVar, JSONObject jSONObject, JSONObject jSONObject2, final c.c cVar) {
        u uVar;
        String str3;
        AppMethodBeat.i(101992);
        String str4 = "MicroMsg.MiniProgramNavigator";
        String str5 = "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d";
        Object[] objArr = new Object[3];
        objArr[0] = dVar.getAppId();
        objArr[1] = str;
        objArr[2] = Integer.valueOf(aVar != null ? aVar.cvp : 0);
        ab.i(str4, str5, objArr);
        str4 = "";
        if (dVar instanceof u) {
            uVar = (u) dVar;
        } else {
            uVar = ((q) dVar).getCurrentPageView();
        }
        if (uVar != null) {
            str4 = uVar.aBm();
        }
        com.tencent.luggage.sdk.b.b bVar = (com.tencent.luggage.sdk.b.b) dVar.getRuntime();
        str5 = dVar.getAppId() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bVar.ya().xz() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + (bVar.ya().bQe + 1000);
        AppBrandStatObject appBrandStatObject = bVar.ya().bQn;
        AppBrandStatObject appBrandStatObject2 = new AppBrandStatObject();
        int i2 = (aVar == null || aVar.scene == 0) ? FilterEnum4Shaka.MIC_SHAKA_ADD2_2 : aVar.scene;
        appBrandStatObject2.scene = i2;
        appBrandStatObject2.cOo = appBrandStatObject.cOo;
        if (aVar == null || aVar.scene == 0 || bo.isNullOrNil(aVar.cst)) {
            str3 = str5;
        } else {
            str3 = String.format("%s:%s", new Object[]{str5, aVar.cst});
        }
        appBrandStatObject2.cst = str3;
        appBrandStatObject2.cOq = aVar != null ? aVar.cOq : 0;
        appBrandStatObject2.cOr = aVar != null ? aVar.cOr : null;
        appBrandStatObject2.hQF = aVar != null ? aVar.hQF : null;
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.appId = dVar.getAppId();
        appBrandLaunchReferrer.cFM = jSONObject == null ? "{}" : jSONObject.toString();
        appBrandLaunchReferrer.hgR = jSONObject2 == null ? "{}" : jSONObject2.toString();
        appBrandLaunchReferrer.hgQ = 1;
        appBrandLaunchReferrer.url = str4;
        appBrandLaunchReferrer.cvp = aVar != null ? aVar.cvp : 0;
        appBrandLaunchReferrer.hgS = aVar != null ? aVar.hgS : null;
        appBrandLaunchReferrer.businessType = aVar != null ? aVar.businessType : null;
        long anU = bo.anU();
        final LaunchParcel launchParcel = new LaunchParcel();
        launchParcel.username = null;
        launchParcel.appId = str;
        launchParcel.version = 0;
        launchParcel.har = i;
        launchParcel.hgC = str2;
        launchParcel.ijy = appBrandStatObject2;
        launchParcel.hgF = appBrandLaunchReferrer;
        launchParcel.ijz = null;
        launchParcel.ijA = anU;
        final d dVar2 = dVar;
        final String str6 = str;
        final String str7 = str2;
        f.dMn().f(new com.tencent.mm.vending.c.a<Boolean, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(101990);
                final com.tencent.mm.vending.g.b dMo = f.dMo();
                if (!h.this.a(dVar, launchParcel, new b() {
                    public final void proceed() {
                        AppMethodBeat.i(101988);
                        dMo.B(Boolean.TRUE);
                        AppMethodBeat.o(101988);
                    }

                    public final void cancel() {
                        AppMethodBeat.i(101989);
                        dMo.cR(new Exception("canceled"));
                        AppMethodBeat.o(101989);
                    }
                })) {
                    dMo.B(Boolean.TRUE);
                }
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(101990);
                return bool;
            }
        }).f(new com.tencent.mm.vending.c.a<AppBrandInitConfigLU, Boolean>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(101987);
                n.xb(dVar2.getAppId()).gPg = str6;
                n.xb(dVar2.getAppId()).gPh = str7;
                n.xb(str6).gPl = false;
                n.xb(str6).gPn = false;
                n.xb(str6).gPm = false;
                f.a(h.this.a(dVar2, launchParcel));
                AppMethodBeat.o(101987);
                return null;
            }
        }).f(new com.tencent.mm.vending.c.a<Void, AppBrandInitConfigLU>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(101986);
                AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) obj;
                if (appBrandInitConfigLU == null) {
                    f.dMj().cR(new Exception("get attrs failed"));
                } else if (TextUtils.isEmpty(appBrandInitConfigLU.appId)) {
                    f.dMj().cR(new Exception("get invalid appId"));
                } else if (dVar.isRunning()) {
                    com.tencent.luggage.sdk.b.b bVar = (com.tencent.luggage.sdk.b.b) dVar.getRuntime();
                    ((com.tencent.luggage.sdk.b.a) bVar.gNz).a(bVar, appBrandInitConfigLU, launchParcel.ijy);
                    if (cVar != null) {
                        cVar.dY(true);
                    }
                } else {
                    f.dMj().cR(new Exception("fail:interrupted"));
                }
                AppMethodBeat.o(101986);
                return null;
            }
        }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
            public final void bi(Object obj) {
                AppMethodBeat.i(101985);
                if (cVar != null) {
                    cVar.dY(false);
                }
                AppMethodBeat.o(101985);
            }
        });
        AppMethodBeat.o(101992);
    }
}
