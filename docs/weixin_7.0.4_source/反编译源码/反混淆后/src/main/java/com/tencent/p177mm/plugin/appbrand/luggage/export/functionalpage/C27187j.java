package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C26719ab;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i.C6764b;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C33113f;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C33135d;
import com.tencent.p177mm.plugin.appbrand.jsapi.h5_interact.C41232a;
import com.tencent.p177mm.plugin.appbrand.media.p325a.C19600a;
import com.tencent.p177mm.plugin.appbrand.media.record.C45654c;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a.C42459c;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p329s.C38508s;
import com.tencent.p177mm.plugin.appbrand.p336ui.C27333q;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.C45665r;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j */
public class C27187j extends C41243o {
    volatile C33442c ikA;
    private volatile C33491e ikz;

    /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j$1 */
    class C271881 extends C6764b {

        /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j$1$2 */
        class C195952 implements C5681a<Void, Void> {
            C195952() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(132144);
                Void asR = asR();
                AppMethodBeat.m2505o(132144);
                return asR;
            }

            private Void asR() {
                AppMethodBeat.m2504i(132143);
                C27187j.m43201c(C27187j.this);
                C27187j c27187j = C27187j.this;
                AppBrandInitConfigWC atI = c27187j.atI();
                if (atI == null || atI.hgF == null || atI.hgF.hgQ != 7) {
                    C45124d.m82929i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
                } else {
                    C45124d.m82926d("MicroMsg.OpenSdkJsApiProcessor", "openapiInvokeData:%s", atI.hgF.hgT);
                    try {
                        JSONObject jSONObject = new JSONObject(atI.hgF.hgT);
                        JSONObject jSONObject2 = new JSONObject(jSONObject.getString("args"));
                        C19681j c19681j = new C19681j();
                        if (c27187j.atG().mo5833a(c19681j) == C45518j.OK) {
                            Iterator keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String str = (String) keys.next();
                                String string = jSONObject2.getString(str);
                                if (C38508s.m65174Ek(string)) {
                                    jSONObject2.put(str, C38508s.m65176a(c27187j, (String) c19681j.value, string));
                                } else if (C38508s.m65175El(string)) {
                                    JSONArray jSONArray = new JSONArray(string);
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        String string2 = jSONArray.getString(i);
                                        if (C38508s.m65174Ek(string2)) {
                                            jSONArray2.put(C38508s.m65176a(c27187j, (String) c19681j.value, string2));
                                        } else {
                                            jSONArray2.put(string2);
                                        }
                                    }
                                    jSONObject2.put(str, jSONArray2.toString());
                                }
                            }
                            jSONObject.put("args", jSONObject2.toString());
                            atI.hgF.hgT = jSONObject.toString();
                            C45124d.m82926d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", r5);
                        }
                    } catch (JSONException e) {
                        C45124d.m82924c("MicroMsg.OpenSdkJsApiProcessor", "", e);
                    }
                }
                Void voidR = zXH;
                AppMethodBeat.m2505o(132143);
                return voidR;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j$1$1 */
        class C271891 implements C5681a<Void, Void> {
            C271891() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(132142);
                C27187j.this.ikA = new C33442c(C27187j.this);
                C271881.this.mo15047wL();
                Void voidR = zXH;
                AppMethodBeat.m2505o(132142);
                return voidR;
            }
        }

        C271881() {
        }

        public final void prepare() {
            AppMethodBeat.m2504i(132145);
            C41930g.dOW().mo60492h(new C195952()).mo60487b(new C271891());
            AppMethodBeat.m2505o(132145);
        }
    }

    public C27187j(Activity activity, C26719ab c26719ab) {
        super(activity, c26719ab);
    }

    public final C27333q ata() {
        AppMethodBeat.m2504i(132146);
        C31320g c31320g = new C31320g(atM());
        AppMethodBeat.m2505o(132146);
        return c31320g;
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(132147);
        atE();
        C27285a.m43324o(this);
        mo14983a((C6764b) new C271881());
        atF();
        this.gPp.mo73483a(this.mAppId, atI().gVs, C38519g.m65221c(atI()));
        C19600a.onCreate(this.mAppId);
        C45654c.onCreate();
        C41232a.m71771k(this);
        C33113f.m54128k(this);
        AppMethodBeat.m2505o(132147);
    }

    /* JADX WARNING: Missing block: B:43:0x011a, code skipped:
            r6.iko++;
            r4 = r6.iko;
            r6.ikp.put(r4, new com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage.C45647n(r8));
            r1.aHR().invokeHandler(r2, r3, r4);
     */
    /* JADX WARNING: Missing block: B:44:0x0133, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(132148);
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReady() {
        AppMethodBeat.m2504i(132148);
        C33442c c33442c = this.ikA;
        String str = atI().hgF.hgT;
        C25052j.m39376p(str, "invokeData");
        C4990ab.m7416i("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke with appId(" + c33442c.ikq.mAppId + ") data(" + str + ')');
        try {
            C41726i c41726i = new C41726i(str);
            String optString = c41726i.optString("name");
            String optString2 = c41726i.optString("args");
            String optString3 = c41726i.optString("transitiveData");
            CharSequence charSequence = optString;
            Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
            if (obj == null) {
                charSequence = optString2;
                obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
                if (obj == null) {
                    str = c41726i.optString("jsapiType");
                    if (str != null) {
                        C38436m c38436m;
                        C44941v c44941v;
                        switch (str.hashCode()) {
                            case 1224424441:
                                if (str.equals("webview")) {
                                    C45665r atJ = c33442c.ikq.atJ();
                                    C25052j.m39375o(atJ, "runtime.pageContainer");
                                    C44709u pageView = atJ.getPageView();
                                    if (pageView != null) {
                                        c38436m = (C31321i) pageView;
                                        break;
                                    }
                                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
                                    AppMethodBeat.m2505o(132148);
                                    throw c44941v;
                                }
                                break;
                            case 1452004724:
                                if (str.equals("appservice")) {
                                    C19722s atK = c33442c.ikq.atK();
                                    if (atK != null) {
                                        c38436m = (C33443d) atK;
                                        break;
                                    }
                                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
                                    AppMethodBeat.m2505o(132148);
                                    throw c44941v;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    c33442c.mo53935cy(optString3, "fail invalid args");
                    Throwable runtimeException = new RuntimeException();
                    AppMethodBeat.m2505o(132148);
                    throw runtimeException;
                }
            }
            c33442c.mo53935cy(optString3, "fail invalid args");
            AppMethodBeat.m2505o(132148);
        } catch (C41724g e) {
            C4990ab.m7412e("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke, json parse e = ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(132148);
        } catch (RuntimeException e2) {
            AppMethodBeat.m2505o(132148);
        }
    }

    public final C42458a asX() {
        AppMethodBeat.m2504i(132149);
        C42459c c42459c = new C42459c();
        AppMethodBeat.m2505o(132149);
        return c42459c;
    }

    /* renamed from: xY */
    public final C33491e mo43488xY() {
        return this.ikz;
    }

    public final /* synthetic */ C38470q ati() {
        AppMethodBeat.m2504i(132150);
        C10610h c10610h = new C10610h(this);
        AppMethodBeat.m2505o(132150);
        return c10610h;
    }

    public final /* synthetic */ C38492q ath() {
        AppMethodBeat.m2504i(132151);
        C33443d c33443d = new C33443d();
        AppMethodBeat.m2505o(132151);
        return c33443d;
    }

    /* renamed from: c */
    static /* synthetic */ void m43201c(C27187j c27187j) {
        AppMethodBeat.m2504i(132152);
        AppBrandSysConfigWC a = C45646e.m84290a(c27187j);
        if (a == null) {
            c27187j.finish();
            AppMethodBeat.m2505o(132152);
            return;
        }
        C33135d.m54169a(a);
        c27187j.gNI.add(a);
        c27187j.mo14982a(C45646e.m84291b(c27187j));
        c27187j.ikz = new C33491e(c27187j, -1, true);
        c27187j.asY();
        c27187j.atO();
        AppMethodBeat.m2505o(132152);
    }
}
