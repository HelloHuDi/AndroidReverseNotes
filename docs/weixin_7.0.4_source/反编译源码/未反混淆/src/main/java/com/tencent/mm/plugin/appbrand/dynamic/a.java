package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.n;
import com.tencent.mm.d.a.p;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.dynamic.c.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.dynamic.c.AnonymousClass4;
import com.tencent.mm.plugin.appbrand.h.x;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    public String eIq;
    public String hkV;
    h hkW;

    public static class f implements i<Bundle, IPCBoolean> {
        private f() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(10653);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("id");
            String string2 = bundle.getString("event");
            String string3 = bundle.getString("data");
            c zR = d.azy().zR(string);
            if (zR == null) {
                ab.e("MicroMsg.IPCInvoke_PublishJsEvent", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                IPCBoolean iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(10653);
                return iPCBoolean;
            }
            Object iPCBoolean2 = new IPCBoolean(zR.bJ(string2, string3));
            AppMethodBeat.o(10653);
            return iPCBoolean2;
        }
    }

    public static class d implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private d() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(10650);
            final c zR = d.azy().zR(((Bundle) obj).getString("id"));
            if (zR == null) {
                ab.e("MicroMsg.IPCInvoke_OnPause", "get DynamicPageViewIPCProxy(id : %s) return null.", r0);
                AppMethodBeat.o(10650);
                return;
            }
            b.E(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10649);
                    ab.i("MicroMsg.DynamicPageViewIPCProxy", "onPause(%s)", zR.eIq);
                    r0.hlo = true;
                    AppMethodBeat.o(10649);
                }
            });
            AppMethodBeat.o(10650);
        }
    }

    public static class e implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private e() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(10652);
            final c zR = d.azy().zR(((Bundle) obj).getString("id"));
            if (zR == null) {
                ab.e("MicroMsg.IPCInvoke_OnResume", "get DynamicPageViewIPCProxy(id : %s) return null.", r0);
                AppMethodBeat.o(10652);
                return;
            }
            b.E(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10651);
                    zR.onResume();
                    AppMethodBeat.o(10651);
                }
            });
            AppMethodBeat.o(10652);
        }
    }

    public static class g implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private g() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(10654);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("id");
            Bundle bundle2 = bundle.getBundle("__env_args");
            if (bundle2 == null) {
                ab.i("MicroMsg.IPCInvoke_UpdateEnvArgs", "envArgs is null.");
                AppMethodBeat.o(10654);
                return;
            }
            c zR = d.azy().zR(string);
            if (zR == null) {
                ab.e("MicroMsg.IPCInvoke_UpdateEnvArgs", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.o(10654);
                return;
            }
            zR.q(bundle2);
            AppMethodBeat.o(10654);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$2 */
    public class AnonymousClass2 implements com.tencent.mm.ipcinvoker.c<Bundle> {
        final /* synthetic */ String val$id;

        public AnonymousClass2(String str) {
            this.val$id = str;
        }

        public final /* synthetic */ void ao(Object obj) {
            AppMethodBeat.i(10641);
            k.Ab(this.val$id);
            AppMethodBeat.o(10641);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$1 */
    public class AnonymousClass1 implements com.tencent.mm.ipcinvoker.c<Bundle> {
        final /* synthetic */ String hkX;
        final /* synthetic */ Bundle hkY;
        final /* synthetic */ String val$appId;
        final /* synthetic */ String val$id;

        public AnonymousClass1(String str, String str2, String str3, Bundle bundle) {
            this.hkX = str;
            this.val$id = str2;
            this.val$appId = str3;
            this.hkY = bundle;
        }

        public final /* synthetic */ void ao(Object obj) {
            AppMethodBeat.i(10640);
            Bundle bundle = (Bundle) obj;
            if (this.hkX.equals(a.this.hkV)) {
                int i = bundle.getInt("op");
                if (i == 0) {
                    a.this.hkW.cleanup();
                    AppMethodBeat.o(10640);
                    return;
                } else if (i == 1) {
                    h.pYm.a(635, 0, 1, false);
                    WxaWidgetContext wxaWidgetContext = (WxaWidgetContext) bundle.getParcelable("fwContext");
                    if (!bundle.getBoolean("success", false) || wxaWidgetContext == null) {
                        ab.i("MicroMsg.DynamicIPCJsBridge", "init widget running context(%s) failed", this.val$id);
                        u.i("MicroMsg.DynamicIPCJsBridge", "init widget running context(%s) failed", this.val$id);
                        a.this.hkW.nK(1);
                        h.pYm.a(635, 2, 1, false);
                        AppMethodBeat.o(10640);
                        return;
                    } else if (wxaWidgetContext.azJ() != 1) {
                        ab.i("MicroMsg.DynamicIPCJsBridge", "abort init widget running context(%s), server banned", this.val$id);
                        u.i("MicroMsg.DynamicIPCJsBridge", "abort init widget running context(%s), server banned", this.val$id);
                        a.this.hkW.nK(2);
                        h.pYm.a(635, 2, 1, false);
                        AppMethodBeat.o(10640);
                        return;
                    } else {
                        u.i("MicroMsg.DynamicIPCJsBridge", " putContext ", this.val$id);
                        k.a(this.val$id, wxaWidgetContext);
                        a.this.hkW.d(this.val$id, this.val$appId, this.hkY);
                        h.pYm.a(635, 1, 1, false);
                    }
                }
            }
            AppMethodBeat.o(10640);
        }
    }

    public static class b implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, final com.tencent.mm.ipcinvoker.c cVar) {
            c cVar2 = null;
            AppMethodBeat.i(10645);
            final String string = ((Bundle) obj).getString("id");
            d azy = d.azy();
            if (bo.isNullOrNil(string)) {
                ab.w("MicroMsg.DynamicPageViewIPCProxyManager", "remove IPCProxy from manager failed, key is null or nil.");
            } else {
                Integer valueOf;
                c cVar3 = (c) azy.hlx.remove(string);
                String str = "MicroMsg.DynamicPageViewIPCProxyManager";
                String str2 = "remove IPCProxy success.(key : %s, ref : %s)";
                Object[] objArr = new Object[2];
                objArr[0] = string;
                if (cVar3 != null) {
                    valueOf = Integer.valueOf(cVar3.hashCode());
                } else {
                    valueOf = null;
                }
                objArr[1] = valueOf;
                ab.d(str, str2, objArr);
                if (cVar3 != null) {
                    cVar2 = cVar3;
                }
            }
            if (cVar2 == null) {
                ab.e("MicroMsg.IPCInvoke_Detach", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.o(10645);
                return;
            }
            b.E(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10644);
                    c cVar = cVar2;
                    ab.i("MicroMsg.DynamicPageViewIPCProxy", "detach(%s)", cVar.eIq);
                    cVar.apg = false;
                    cVar.cleanup();
                    cVar.eIn = null;
                    cVar.hll = null;
                    cVar.eIq = null;
                    cVar.hcl = null;
                    k.Ab(string);
                    cVar.ao(null);
                    f azA = f.azA();
                    String str = string;
                    if (azA.hlB.containsKey(str)) {
                        com.tencent.mm.plugin.appbrand.dynamic.f.b bVar = (com.tencent.mm.plugin.appbrand.dynamic.f.b) azA.hlB.get(str);
                        ab.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", bVar.hlF.toString());
                        if (bVar.hlF.size() > 0) {
                            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                            aVar.fsI = 2653;
                            aVar.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
                            ctb ctb = new ctb();
                            ctb.csB = u.pr(str);
                            ctb.id = bVar.fmr;
                            ctb.xqi = bVar.hlF;
                            ctb.query = bVar.query;
                            aVar.fsJ = ctb;
                            aVar.fsK = new ctc();
                            com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.acD(), azA.hlC);
                        }
                        AppMethodBeat.o(10644);
                        return;
                    }
                    ab.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", str);
                    AppMethodBeat.o(10644);
                }
            });
            AppMethodBeat.o(10645);
        }
    }

    public static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(10643);
            Bundle bundle = (Bundle) obj;
            final String string = bundle.getString("id");
            final String string2 = bundle.getString("appId");
            final Bundle bundle2 = bundle.getBundle("extData");
            final c zR = d.azy().zR(string);
            if (zR == null) {
                ab.e("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                u.e("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.o(10643);
                return;
            }
            u.i("MicroMsg.IPCInvoke_AttachTo", "IPCInvoke_AttachTo invoke", new Object[0]);
            b.E(new Runnable() {
                public final void run() {
                    String string;
                    long j;
                    Object obj;
                    AppMethodBeat.i(10642);
                    u.i("MicroMsg.IPCInvoke_AttachTo", "ui thread attach", new Object[0]);
                    c cVar = zR;
                    String str = string;
                    String str2 = string2;
                    Bundle bundle = bundle2;
                    Assert.assertNotNull(str);
                    if (!(str.equals(cVar.eIq) || cVar.eIn == null)) {
                        cVar.cleanup();
                        cVar.apg = false;
                        cVar.eIn = null;
                    }
                    cVar.eIq = str;
                    cVar.appId = str2;
                    String str3 = "";
                    if (bundle != null) {
                        string = bundle.getString("cache_key", "");
                        cVar.Kg = bundle.getString(SearchIntents.EXTRA_QUERY);
                        cVar.hlk = bundle.getBoolean("is_testing_ui");
                        cVar.mUrl = bundle.getString("url");
                        cVar.hlj = bundle.getInt("widget_type");
                        cVar.hlm = bundle.getString("search_id");
                        cVar.hcl = bundle.getString("__session_id");
                        j = bundle.getLong("__on_bind_nano_time");
                        if (!bo.isNullOrNil(cVar.hcl)) {
                            com.tencent.mm.plugin.appbrand.collector.c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
                        }
                        str3 = string;
                    } else {
                        j = 0;
                    }
                    u.i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s)", str, str2);
                    Object obj2 = 1;
                    if (cVar.hlj == 1) {
                        obj2 = null;
                    } else {
                        cVar.hll = com.tencent.mm.plugin.appbrand.dynamic.j.b.Am(str);
                    }
                    if (cVar.hll == null) {
                        cVar.hll = new com.tencent.mm.plugin.appbrand.widget.e();
                        obj = null;
                    } else {
                        obj = obj2;
                    }
                    cVar.hll.field_id = str;
                    cVar.hll.field_cacheKey = str3;
                    cVar.hll.field_appId = u.pr(cVar.eIq);
                    com.tencent.mm.z.c.e eVar;
                    com.tencent.mm.plugin.appbrand.dynamic.f.f fVar;
                    com.tencent.mm.plugin.appbrand.dynamic.f.g gVar;
                    if (cVar.eIn == null) {
                        u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge is null", new Object[0]);
                        com.tencent.mm.plugin.appbrand.collector.c.bD(cVar.hcl, "before_init_js_engine");
                        Context context = cVar.mContext;
                        string = cVar.eIq;
                        WxaWidgetContext Aa = k.Aa(string);
                        if (Aa == null || bundle == null) {
                            ab.w("MicroMsg.WxaWidgetInitializer", "FwContext is null(id : %s)", string);
                            eVar = null;
                        } else {
                            ab.i("MicroMsg.WxaWidgetInitializer", "initJsBridge(%s)", string);
                            eVar = com.tencent.mm.plugin.appbrand.dynamic.h.e.a(context, Aa, new com.tencent.mm.plugin.appbrand.dynamic.d.c.a(string, Aa.azI()), bundle);
                        }
                        cVar.eIn = eVar;
                        com.tencent.mm.plugin.appbrand.collector.c.bD(cVar.hcl, "after_init_js_engine");
                        cVar.eIn.eIq = cVar.eIq;
                        if (cVar.eIn.eIt instanceof com.tencent.mm.plugin.appbrand.dynamic.e.a) {
                            com.tencent.mm.plugin.appbrand.dynamic.e.a aVar = (com.tencent.mm.plugin.appbrand.dynamic.e.a) cVar.eIn.eIt;
                            AnonymousClass3 anonymousClass3 = new com.tencent.mm.plugin.appbrand.h.h() {
                                public final void C(String str, String str2) {
                                    AppMethodBeat.i(10662);
                                    u.i("MicroMsg.DynamicPageViewIPCProxy", "js error msg %s, stackTrace %s", str, str2);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("widgetId", c.this.eIq);
                                    bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "onWidgetJsError");
                                    bundle.putString("data", str2);
                                    String zV = i.azC().zV(c.this.eIq);
                                    if (zV == null) {
                                        ToolsProcessIPCService.b(bundle, b.class);
                                        AppMethodBeat.o(10662);
                                        return;
                                    }
                                    f.a(zV, bundle, b.class, null);
                                    AppMethodBeat.o(10662);
                                }
                            };
                            if (aVar.hoa != null) {
                                aVar.hoa.setJsExceptionHandler(anonymousClass3);
                            }
                            aVar = (com.tencent.mm.plugin.appbrand.dynamic.e.a) cVar.eIn.eIt;
                            AnonymousClass4 anonymousClass4 = new x() {
                                public final void onError(String str) {
                                    AppMethodBeat.i(10663);
                                    u.i("MicroMsg.DynamicPageViewIPCProxy", "console js error stackTrace %s", str);
                                    if (!TextUtils.isEmpty(str) && str.contains("widgetThirdScriptError")) {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("widgetId", c.this.eIq);
                                        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "onWidgetJsError");
                                        bundle.putString("data", str);
                                        String zV = i.azC().zV(c.this.eIq);
                                        if (zV == null) {
                                            ToolsProcessIPCService.b(bundle, b.class);
                                            AppMethodBeat.o(10663);
                                            return;
                                        }
                                        f.a(zV, bundle, b.class, null);
                                    }
                                    AppMethodBeat.o(10663);
                                }
                            };
                            com.tencent.mm.plugin.appbrand.h.c cVar2 = aVar.hoa;
                            if (cVar2.ieS != null) {
                                Iterator it = cVar2.ieS.chQ.iterator();
                                while (it.hasNext()) {
                                    n nVar = (n) it.next();
                                    if (nVar instanceof p) {
                                        ((p) nVar).cij = anonymousClass4;
                                    }
                                }
                            }
                        }
                        if (bundle != null) {
                            cVar.q(bundle.getBundle("__env_args"));
                        }
                        cVar.eIn.onStart();
                        if (cVar.hln) {
                            eVar = cVar.eIn;
                            fVar = new com.tencent.mm.plugin.appbrand.dynamic.f.f();
                            eVar.Qz();
                        } else {
                            eVar = cVar.eIn;
                            gVar = new com.tencent.mm.plugin.appbrand.dynamic.f.g();
                            eVar.QA();
                        }
                        u.i("MicroMsg.DynamicPageViewIPCProxy", "before dispatch onCanvasInsertJsEvent", new Object[0]);
                        com.tencent.mm.z.c.e eVar2 = cVar.eIn;
                        str2 = "";
                        string = "";
                        String str4 = "";
                        Map map = null;
                        int i = 0;
                        int i2 = 0;
                        if (bundle != null) {
                            i = bundle.getInt("view_init_width");
                            i2 = bundle.getInt("view_init_height");
                            str2 = bundle.getString("cache_key", "");
                            string = bundle.getString("msg_title", "");
                            String string2 = bundle.getString("msg_path", "");
                            str4 = com.tencent.luggage.g.h.bO(string2);
                            map = com.tencent.luggage.g.h.bP(string2);
                        }
                        com.tencent.mm.plugin.appbrand.dynamic.f.b bVar = new com.tencent.mm.plugin.appbrand.dynamic.f.b();
                        bVar.cacheKey = str2;
                        bVar.title = string;
                        bVar.path = str4;
                        bVar.hod = map;
                        bVar.hoe = i;
                        bVar.hof = i2;
                        eVar2.a(bVar, new ValueCallback<String>() {
                            public final /* synthetic */ void onReceiveValue(Object obj) {
                                AppMethodBeat.i(10664);
                                u.i("MicroMsg.DynamicPageViewIPCProxy", "dispatch canvasInsert event result %s", (String) obj);
                                AppMethodBeat.o(10664);
                            }
                        });
                        u.i("MicroMsg.DynamicPageViewIPCProxy", "after dispatch onCanvasInsertJsEvent", new Object[0]);
                        ad eZ = new ad().eZ(u.pr(str));
                        eZ.cYw = (long) u.pq(str);
                        eZ.cYs = 8;
                        eZ = eZ.eY(str);
                        eZ.cYt = System.currentTimeMillis();
                        eZ.fa(at.gB(ah.getContext())).ajK();
                        if (j > 0) {
                            j = (System.nanoTime() - j) / 1000000;
                            i2 = 22;
                            if (j <= 50) {
                                i2 = 0;
                            } else if (j <= 100) {
                                i2 = 1;
                            } else if (j <= 200) {
                                i2 = 2;
                            } else if (j <= 300) {
                                i2 = 3;
                            } else if (j <= 400) {
                                i2 = 4;
                            } else if (j <= 500) {
                                i2 = 5;
                            } else if (j <= 600) {
                                i2 = 6;
                            } else if (j <= 1000) {
                                i2 = 17;
                            } else if (j <= 1500) {
                                i2 = 18;
                            } else if (j <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                                i2 = 19;
                            } else if (j <= 2500) {
                                i2 = 20;
                            } else if (j <= 3000) {
                                i2 = 21;
                            }
                            h.pYm.a(677, (long) i2, 1, false);
                            h.pYm.a(677, 8, 1, false);
                        }
                        com.tencent.mm.plugin.appbrand.collector.c.bD(cVar.hcl, "init_finish");
                        com.tencent.mm.plugin.appbrand.collector.c.print(cVar.hcl);
                        u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge init complete", new Object[0]);
                    } else {
                        u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge not null", new Object[0]);
                        com.tencent.mm.plugin.appbrand.collector.c.yI(cVar.hcl);
                        if (bundle != null) {
                            cVar.q(bundle.getBundle("__env_args"));
                        }
                        cVar.eIn.onStart();
                        if (cVar.hln) {
                            eVar = cVar.eIn;
                            fVar = new com.tencent.mm.plugin.appbrand.dynamic.f.f();
                            eVar.Qz();
                        } else {
                            eVar = cVar.eIn;
                            gVar = new com.tencent.mm.plugin.appbrand.dynamic.f.g();
                            eVar.QA();
                        }
                    }
                    cVar.apg = true;
                    if (obj != null) {
                        cVar.a(cVar.eIn, cVar.hll);
                    } else if (cVar.hlk) {
                        cVar.hll.field_data = bundle.getString("init_data");
                        cVar.a(cVar.eIn, cVar.hll);
                    }
                    cVar.azx();
                    AppMethodBeat.o(10642);
                }
            });
            AppMethodBeat.o(10643);
        }
    }

    public static class c implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private c() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(10648);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("id");
            String string2 = bundle.getString("appId");
            int i = bundle.getInt("wxaPkgType");
            int i2 = bundle.getInt("pkgVersion");
            int i3 = bundle.getInt("scene");
            String string3 = bundle.getString("searchId");
            int i4 = bundle.getInt("widgetType");
            int i5 = bundle.getInt("serviceType");
            bundle.getString("wxa_unique_id");
            String string4 = bundle.getString("preloadLaunchData", "");
            String string5 = bundle.getString("preload_download_data", "");
            if (d.azy().zR(string) == null) {
                c cVar2 = new c(ah.getContext());
                d azy = d.azy();
                if (bo.isNullOrNil(string)) {
                    ab.w("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy into manager failed, key is null or nil.");
                } else {
                    if (((c) azy.hlx.put(string, cVar2)) != null) {
                        ab.i("MicroMsg.DynamicPageViewIPCProxyManager", "add a new IPCProxy and remove old one with key : %s.", string);
                    }
                    ab.d("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy success.(%s)", string);
                }
            }
            i.azC().bK(string, bundle.getString("view_process_name"));
            f azA = f.azA();
            String string6 = bundle.getString(SearchIntents.EXTRA_QUERY);
            String string7 = bundle.getString("cache_key", string6);
            if (azA.hlB.containsKey(string)) {
                ab.w("MicroMsg.DynamicPageViewStateMonitor", "OnAttach with same widgetId[%s]", string);
                azA.hlB.remove(string);
            }
            azA.hlB.put(string, new com.tencent.mm.plugin.appbrand.dynamic.f.b(string, string2, i5, string7));
            j azE = j.azE();
            int i6 = i + 1;
            string6 = bundle.getString(SearchIntents.EXTRA_QUERY);
            string6 = bundle.getString("cache_key", string6);
            if (azE.hlB.containsKey(string)) {
                com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnAttach with same widgetId[%s]", string);
                azE.hlB.remove(string);
            }
            com.tencent.mm.plugin.appbrand.dynamic.j.b bVar = new com.tencent.mm.plugin.appbrand.dynamic.j.b(string, string2, i6, string6, i5);
            azE.hlB.put(string, bVar);
            Bundle toBundle = bVar.toBundle();
            com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", toBundle, a.class, null);
            com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:support", toBundle, a.class, null);
            com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", toBundle, a.class, null);
            azE.E(string, JsApiShowImageOperateSheet.CTRL_INDEX, 0);
            final com.tencent.mm.ipcinvoker.c cVar3 = cVar;
            String str = string;
            b.D(new com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.AnonymousClass1(str, com.tencent.mm.plugin.appbrand.dynamic.k.b.cX(i4, i), i2, string2, i4, i3, string4, i5, new com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.a() {
                public final void bI(String str, String str2) {
                    AppMethodBeat.i(10646);
                    Bundle bundle = new Bundle();
                    bundle.putInt("op", 0);
                    bundle.putString("id", str);
                    bundle.putString("appId", str2);
                    cVar3.ao(bundle);
                    AppMethodBeat.o(10646);
                }

                public final void a(String str, String str2, boolean z, WxaWidgetContext wxaWidgetContext) {
                    AppMethodBeat.i(10647);
                    Bundle bundle = new Bundle();
                    bundle.putInt("op", 1);
                    bundle.putString("id", str);
                    bundle.putString("appId", str2);
                    bundle.putBoolean("success", z);
                    if (wxaWidgetContext != null) {
                        u.i("MicroMsg.DynamicIPCJsBridge", " OnInitializeCallback.onInitialized putContext %s", str);
                        bundle.putParcelable("fwContext", wxaWidgetContext);
                        k.a(str, wxaWidgetContext);
                    }
                    cVar3.ao(bundle);
                    AppMethodBeat.o(10647);
                }
            }, string3, string5));
            AppMethodBeat.o(10648);
        }
    }

    public a(h hVar) {
        this.hkW = hVar;
    }

    public final void aY(String str, int i) {
        AppMethodBeat.i(10655);
        if (this.eIq == null || this.eIq.length() == 0) {
            AppMethodBeat.o(10655);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putInt("widgetState", i);
        com.tencent.mm.ipcinvoker.f.a(i.azC().zV(str), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
        AppMethodBeat.o(10655);
    }
}
