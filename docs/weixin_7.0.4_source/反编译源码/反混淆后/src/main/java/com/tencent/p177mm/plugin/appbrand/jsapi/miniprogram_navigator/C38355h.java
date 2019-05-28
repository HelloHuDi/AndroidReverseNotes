package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.p148b.C0993a;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2320c.C2321b;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2320c.C2322a;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2320c.C2323c;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7361c;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h */
public class C38355h implements C2320c {
    static final C38355h hQV = new C38355h();

    static {
        AppMethodBeat.m2504i(101993);
        AppMethodBeat.m2505o(101993);
    }

    /* renamed from: a */
    public boolean mo21858a(C2119d c2119d, LaunchParcel launchParcel, C2321b c2321b) {
        return false;
    }

    /* renamed from: a */
    public C7361c<AppBrandInitConfigLU> mo44722a(C2119d c2119d, LaunchParcel launchParcel) {
        AppMethodBeat.m2504i(101991);
        C7361c cU = C5698f.m8559cU(null);
        AppMethodBeat.m2505o(101991);
        return cU;
    }

    /* renamed from: a */
    public final void mo6194a(final C2119d c2119d, String str, int i, String str2, C2322a c2322a, JSONObject jSONObject, JSONObject jSONObject2, final C2323c c2323c) {
        C44709u c44709u;
        String str3;
        AppMethodBeat.m2504i(101992);
        String str4 = "MicroMsg.MiniProgramNavigator";
        String str5 = "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d";
        Object[] objArr = new Object[3];
        objArr[0] = c2119d.getAppId();
        objArr[1] = str;
        objArr[2] = Integer.valueOf(c2322a != null ? c2322a.cvp : 0);
        C4990ab.m7417i(str4, str5, objArr);
        str4 = "";
        if (c2119d instanceof C44709u) {
            c44709u = (C44709u) c2119d;
        } else {
            c44709u = ((C38492q) c2119d).getCurrentPageView();
        }
        if (c44709u != null) {
            str4 = c44709u.aBm();
        }
        C25697b c25697b = (C25697b) c2119d.getRuntime();
        str5 = c2119d.getAppId() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c25697b.mo43491ya().mo32993xz() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + (c25697b.mo43491ya().bQe + 1000);
        AppBrandStatObject appBrandStatObject = c25697b.mo43491ya().bQn;
        AppBrandStatObject appBrandStatObject2 = new AppBrandStatObject();
        int i2 = (c2322a == null || c2322a.scene == 0) ? FilterEnum4Shaka.MIC_SHAKA_ADD2_2 : c2322a.scene;
        appBrandStatObject2.scene = i2;
        appBrandStatObject2.cOo = appBrandStatObject.cOo;
        if (c2322a == null || c2322a.scene == 0 || C5046bo.isNullOrNil(c2322a.cst)) {
            str3 = str5;
        } else {
            str3 = String.format("%s:%s", new Object[]{str5, c2322a.cst});
        }
        appBrandStatObject2.cst = str3;
        appBrandStatObject2.cOq = c2322a != null ? c2322a.cOq : 0;
        appBrandStatObject2.cOr = c2322a != null ? c2322a.cOr : null;
        appBrandStatObject2.hQF = c2322a != null ? c2322a.hQF : null;
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.appId = c2119d.getAppId();
        appBrandLaunchReferrer.cFM = jSONObject == null ? "{}" : jSONObject.toString();
        appBrandLaunchReferrer.hgR = jSONObject2 == null ? "{}" : jSONObject2.toString();
        appBrandLaunchReferrer.hgQ = 1;
        appBrandLaunchReferrer.url = str4;
        appBrandLaunchReferrer.cvp = c2322a != null ? c2322a.cvp : 0;
        appBrandLaunchReferrer.hgS = c2322a != null ? c2322a.hgS : null;
        appBrandLaunchReferrer.businessType = c2322a != null ? c2322a.businessType : null;
        long anU = C5046bo.anU();
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
        final C2119d c2119d2 = c2119d;
        final String str6 = str;
        final String str7 = str2;
        C5698f.dMn().mo15896f(new C5681a<Boolean, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(101990);
                final C5688b dMo = C5698f.dMo();
                if (!C38355h.this.mo21858a(c2119d, launchParcel, new C2321b() {
                    public final void proceed() {
                        AppMethodBeat.m2504i(101988);
                        dMo.mo11581B(Boolean.TRUE);
                        AppMethodBeat.m2505o(101988);
                    }

                    public final void cancel() {
                        AppMethodBeat.m2504i(101989);
                        dMo.mo11582cR(new Exception("canceled"));
                        AppMethodBeat.m2505o(101989);
                    }
                })) {
                    dMo.mo11581B(Boolean.TRUE);
                }
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.m2505o(101990);
                return bool;
            }
        }).mo15896f(new C5681a<AppBrandInitConfigLU, Boolean>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(101987);
                C38450n.m65049xb(c2119d2.getAppId()).gPg = str6;
                C38450n.m65049xb(c2119d2.getAppId()).gPh = str7;
                C38450n.m65049xb(str6).gPl = false;
                C38450n.m65049xb(str6).gPn = false;
                C38450n.m65049xb(str6).gPm = false;
                C5698f.m8557a(C38355h.this.mo44722a(c2119d2, launchParcel));
                AppMethodBeat.m2505o(101987);
                return null;
            }
        }).mo15896f(new C5681a<Void, AppBrandInitConfigLU>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(101986);
                AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) obj;
                if (appBrandInitConfigLU == null) {
                    C5698f.dMj().mo11582cR(new Exception("get attrs failed"));
                } else if (TextUtils.isEmpty(appBrandInitConfigLU.appId)) {
                    C5698f.dMj().mo11582cR(new Exception("get invalid appId"));
                } else if (c2119d.isRunning()) {
                    C25697b c25697b = (C25697b) c2119d.getRuntime();
                    ((C0993a) c25697b.gNz).mo3964a(c25697b, appBrandInitConfigLU, launchParcel.ijy);
                    if (c2323c != null) {
                        c2323c.mo6193dY(true);
                    }
                } else {
                    C5698f.dMj().mo11582cR(new Exception("fail:interrupted"));
                }
                AppMethodBeat.m2505o(101986);
                return null;
            }
        }).mo11586a((C5690a) new C5690a() {
            /* renamed from: bi */
            public final void mo9345bi(Object obj) {
                AppMethodBeat.m2504i(101985);
                if (c2323c != null) {
                    c2323c.mo6193dY(false);
                }
                AppMethodBeat.m2505o(101985);
            }
        });
        AppMethodBeat.m2505o(101992);
    }
}
