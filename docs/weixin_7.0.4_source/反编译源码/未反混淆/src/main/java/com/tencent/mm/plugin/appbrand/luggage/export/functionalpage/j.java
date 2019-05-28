package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.v;
import android.app.Activity;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.ci.g;
import com.tencent.mm.plugin.appbrand.ab;
import com.tencent.mm.plugin.appbrand.backgroundfetch.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.plugin.appbrand.media.record.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.s.s;
import com.tencent.mm.plugin.appbrand.ui.q;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends o {
    volatile c ikA;
    private volatile e ikz;

    public j(Activity activity, ab abVar) {
        super(activity, abVar);
    }

    public final q ata() {
        AppMethodBeat.i(132146);
        g gVar = new g(atM());
        AppMethodBeat.o(132146);
        return gVar;
    }

    public final void onCreate() {
        AppMethodBeat.i(132147);
        atE();
        a.o(this);
        a((b) new b() {
            public final void prepare() {
                AppMethodBeat.i(132145);
                g.dOW().h(new com.tencent.mm.vending.c.a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(132144);
                        Void asR = asR();
                        AppMethodBeat.o(132144);
                        return asR;
                    }

                    private Void asR() {
                        AppMethodBeat.i(132143);
                        j.c(j.this);
                        j jVar = j.this;
                        AppBrandInitConfigWC atI = jVar.atI();
                        if (atI == null || atI.hgF == null || atI.hgF.hgQ != 7) {
                            d.i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
                        } else {
                            d.d("MicroMsg.OpenSdkJsApiProcessor", "openapiInvokeData:%s", atI.hgF.hgT);
                            try {
                                JSONObject jSONObject = new JSONObject(atI.hgF.hgT);
                                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("args"));
                                com.tencent.mm.plugin.appbrand.r.j jVar2 = new com.tencent.mm.plugin.appbrand.r.j();
                                if (jVar.atG().a(jVar2) == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                                    Iterator keys = jSONObject2.keys();
                                    while (keys.hasNext()) {
                                        String str = (String) keys.next();
                                        String string = jSONObject2.getString(str);
                                        if (s.Ek(string)) {
                                            jSONObject2.put(str, s.a(jVar, (String) jVar2.value, string));
                                        } else if (s.El(string)) {
                                            JSONArray jSONArray = new JSONArray(string);
                                            JSONArray jSONArray2 = new JSONArray();
                                            for (int i = 0; i < jSONArray.length(); i++) {
                                                String string2 = jSONArray.getString(i);
                                                if (s.Ek(string2)) {
                                                    jSONArray2.put(s.a(jVar, (String) jVar2.value, string2));
                                                } else {
                                                    jSONArray2.put(string2);
                                                }
                                            }
                                            jSONObject2.put(str, jSONArray2.toString());
                                        }
                                    }
                                    jSONObject.put("args", jSONObject2.toString());
                                    atI.hgF.hgT = jSONObject.toString();
                                    d.d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", r5);
                                }
                            } catch (JSONException e) {
                                d.c("MicroMsg.OpenSdkJsApiProcessor", "", e);
                            }
                        }
                        Void voidR = zXH;
                        AppMethodBeat.o(132143);
                        return voidR;
                    }
                }).b(new com.tencent.mm.vending.c.a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(132142);
                        j.this.ikA = new c(j.this);
                        AnonymousClass1.this.wL();
                        Void voidR = zXH;
                        AppMethodBeat.o(132142);
                        return voidR;
                    }
                });
                AppMethodBeat.o(132145);
            }
        });
        atF();
        this.gPp.a(this.mAppId, atI().gVs, com.tencent.mm.plugin.appbrand.task.g.c(atI()));
        com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
        c.onCreate();
        com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.k(this);
        f.k(this);
        AppMethodBeat.o(132147);
    }

    /* JADX WARNING: Missing block: B:43:0x011a, code skipped:
            r6.iko++;
            r4 = r6.iko;
            r6.ikp.put(r4, new com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.n(r8));
            r1.aHR().invokeHandler(r2, r3, r4);
     */
    /* JADX WARNING: Missing block: B:44:0x0133, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(132148);
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReady() {
        AppMethodBeat.i(132148);
        c cVar = this.ikA;
        String str = atI().hgF.hgT;
        a.f.b.j.p(str, "invokeData");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke with appId(" + cVar.ikq.mAppId + ") data(" + str + ')');
        try {
            i iVar = new i(str);
            String optString = iVar.optString("name");
            String optString2 = iVar.optString("args");
            String optString3 = iVar.optString("transitiveData");
            CharSequence charSequence = optString;
            Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
            if (obj == null) {
                charSequence = optString2;
                obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
                if (obj == null) {
                    str = iVar.optString("jsapiType");
                    if (str != null) {
                        m mVar;
                        v vVar;
                        switch (str.hashCode()) {
                            case 1224424441:
                                if (str.equals("webview")) {
                                    r atJ = cVar.ikq.atJ();
                                    a.f.b.j.o(atJ, "runtime.pageContainer");
                                    u pageView = atJ.getPageView();
                                    if (pageView != null) {
                                        mVar = (i) pageView;
                                        break;
                                    }
                                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
                                    AppMethodBeat.o(132148);
                                    throw vVar;
                                }
                                break;
                            case 1452004724:
                                if (str.equals("appservice")) {
                                    com.tencent.mm.plugin.appbrand.s atK = cVar.ikq.atK();
                                    if (atK != null) {
                                        mVar = (d) atK;
                                        break;
                                    }
                                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
                                    AppMethodBeat.o(132148);
                                    throw vVar;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    cVar.cy(optString3, "fail invalid args");
                    Throwable runtimeException = new RuntimeException();
                    AppMethodBeat.o(132148);
                    throw runtimeException;
                }
            }
            cVar.cy(optString3, "fail invalid args");
            AppMethodBeat.o(132148);
        } catch (com.tencent.mm.aa.g e) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke, json parse e = ".concat(String.valueOf(e)));
            AppMethodBeat.o(132148);
        } catch (RuntimeException e2) {
            AppMethodBeat.o(132148);
        }
    }

    public final com.tencent.mm.plugin.appbrand.j.a asX() {
        AppMethodBeat.i(132149);
        com.tencent.mm.plugin.appbrand.j.a.c cVar = new com.tencent.mm.plugin.appbrand.j.a.c();
        AppMethodBeat.o(132149);
        return cVar;
    }

    public final e xY() {
        return this.ikz;
    }

    public final /* synthetic */ com.tencent.mm.plugin.appbrand.page.q ati() {
        AppMethodBeat.i(132150);
        h hVar = new h(this);
        AppMethodBeat.o(132150);
        return hVar;
    }

    public final /* synthetic */ com.tencent.mm.plugin.appbrand.q ath() {
        AppMethodBeat.i(132151);
        d dVar = new d();
        AppMethodBeat.o(132151);
        return dVar;
    }

    static /* synthetic */ void c(j jVar) {
        AppMethodBeat.i(132152);
        AppBrandSysConfigWC a = e.a(jVar);
        if (a == null) {
            jVar.finish();
            AppMethodBeat.o(132152);
            return;
        }
        com.tencent.mm.plugin.appbrand.config.d.a(a);
        jVar.gNI.add(a);
        jVar.a(e.b(jVar));
        jVar.ikz = new e(jVar, -1, true);
        jVar.asY();
        jVar.atO();
        AppMethodBeat.o(132152);
    }
}
