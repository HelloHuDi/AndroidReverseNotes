package com.tencent.p177mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p224d.p225a.C18182p;
import com.tencent.p177mm.p224d.p225a.C9265n;
import com.tencent.p177mm.p230g.p232b.p233a.C26273ad;
import com.tencent.p177mm.p652z.p653c.C30909e;
import com.tencent.p177mm.plugin.appbrand.collector.C2107c;
import com.tencent.p177mm.plugin.appbrand.collector.CollectSession;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f.C10213a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f.C10214b;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38195c.C191725;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38195c.C381894;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38195c.C381973;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38203j.C38204a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38203j.C38205b;
import com.tencent.p177mm.plugin.appbrand.dynamic.WxaWidgetInitializer.C101921;
import com.tencent.p177mm.plugin.appbrand.dynamic.WxaWidgetInitializer.C26854a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1220f.C19183b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1220f.C42426f;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1220f.C42427g;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p1469c.C33153a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C26864e;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C33166b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p891e.C10209a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p892k.C33167b;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.p177mm.plugin.appbrand.p297h.C17090c;
import com.tencent.p177mm.plugin.appbrand.widget.C44718e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.ctb;
import com.tencent.p177mm.protocal.protobuf.ctc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a */
public final class C38183a {
    public String eIq;
    public String hkV;
    C2150h hkW;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$f */
    public static class C2125f implements C45413i<Bundle, IPCBoolean> {
        private C2125f() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(10653);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("id");
            String string2 = bundle.getString("event");
            String string3 = bundle.getString("data");
            C38195c zR = C33159d.azy().mo53689zR(string);
            if (zR == null) {
                C4990ab.m7413e("MicroMsg.IPCInvoke_PublishJsEvent", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                IPCBoolean iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.m2505o(10653);
                return iPCBoolean;
            }
            Object iPCBoolean2 = new IPCBoolean(zR.mo60930bJ(string2, string3));
            AppMethodBeat.m2505o(10653);
            return iPCBoolean2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$d */
    public static class C10194d implements C37866a<Bundle, Bundle> {
        private C10194d() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10650);
            final C38195c zR = C33159d.azy().mo53689zR(((Bundle) obj).getString("id"));
            if (zR == null) {
                C4990ab.m7413e("MicroMsg.IPCInvoke_OnPause", "get DynamicPageViewIPCProxy(id : %s) return null.", r0);
                AppMethodBeat.m2505o(10650);
                return;
            }
            C45539b.m83988E(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(10649);
                    C4990ab.m7417i("MicroMsg.DynamicPageViewIPCProxy", "onPause(%s)", zR.eIq);
                    r0.hlo = true;
                    AppMethodBeat.m2505o(10649);
                }
            });
            AppMethodBeat.m2505o(10650);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$e */
    public static class C10196e implements C37866a<Bundle, Bundle> {
        private C10196e() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10652);
            final C38195c zR = C33159d.azy().mo53689zR(((Bundle) obj).getString("id"));
            if (zR == null) {
                C4990ab.m7413e("MicroMsg.IPCInvoke_OnResume", "get DynamicPageViewIPCProxy(id : %s) return null.", r0);
                AppMethodBeat.m2505o(10652);
                return;
            }
            C45539b.m83988E(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(10651);
                    zR.onResume();
                    AppMethodBeat.m2505o(10651);
                }
            });
            AppMethodBeat.m2505o(10652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$g */
    public static class C10198g implements C37866a<Bundle, Bundle> {
        private C10198g() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10654);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("id");
            Bundle bundle2 = bundle.getBundle("__env_args");
            if (bundle2 == null) {
                C4990ab.m7416i("MicroMsg.IPCInvoke_UpdateEnvArgs", "envArgs is null.");
                AppMethodBeat.m2505o(10654);
                return;
            }
            C38195c zR = C33159d.azy().mo53689zR(string);
            if (zR == null) {
                C4990ab.m7413e("MicroMsg.IPCInvoke_UpdateEnvArgs", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.m2505o(10654);
                return;
            }
            zR.mo60932q(bundle2);
            AppMethodBeat.m2505o(10654);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$2 */
    public class C246902 implements C18507c<Bundle> {
        final /* synthetic */ String val$id;

        public C246902(String str) {
            this.val$id = str;
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(10641);
            C45548k.m83999Ab(this.val$id);
            AppMethodBeat.m2505o(10641);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$1 */
    public class C331421 implements C18507c<Bundle> {
        final /* synthetic */ String hkX;
        final /* synthetic */ Bundle hkY;
        final /* synthetic */ String val$appId;
        final /* synthetic */ String val$id;

        public C331421(String str, String str2, String str3, Bundle bundle) {
            this.hkX = str;
            this.val$id = str2;
            this.val$appId = str3;
            this.hkY = bundle;
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(10640);
            Bundle bundle = (Bundle) obj;
            if (this.hkX.equals(C38183a.this.hkV)) {
                int i = bundle.getInt("op");
                if (i == 0) {
                    C38183a.this.hkW.cleanup();
                    AppMethodBeat.m2505o(10640);
                    return;
                } else if (i == 1) {
                    C7060h.pYm.mo8378a(635, 0, 1, false);
                    WxaWidgetContext wxaWidgetContext = (WxaWidgetContext) bundle.getParcelable("fwContext");
                    if (!bundle.getBoolean("success", false) || wxaWidgetContext == null) {
                        C4990ab.m7417i("MicroMsg.DynamicIPCJsBridge", "init widget running context(%s) failed", this.val$id);
                        C18652u.m29151i("MicroMsg.DynamicIPCJsBridge", "init widget running context(%s) failed", this.val$id);
                        C38183a.this.hkW.mo5972nK(1);
                        C7060h.pYm.mo8378a(635, 2, 1, false);
                        AppMethodBeat.m2505o(10640);
                        return;
                    } else if (wxaWidgetContext.azJ() != 1) {
                        C4990ab.m7417i("MicroMsg.DynamicIPCJsBridge", "abort init widget running context(%s), server banned", this.val$id);
                        C18652u.m29151i("MicroMsg.DynamicIPCJsBridge", "abort init widget running context(%s), server banned", this.val$id);
                        C38183a.this.hkW.mo5972nK(2);
                        C7060h.pYm.mo8378a(635, 2, 1, false);
                        AppMethodBeat.m2505o(10640);
                        return;
                    } else {
                        C18652u.m29151i("MicroMsg.DynamicIPCJsBridge", " putContext ", this.val$id);
                        C45548k.m84000a(this.val$id, wxaWidgetContext);
                        C38183a.this.hkW.mo5971d(this.val$id, this.val$appId, this.hkY);
                        C7060h.pYm.mo8378a(635, 1, 1, false);
                    }
                }
            }
            AppMethodBeat.m2505o(10640);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$b */
    public static class C38184b implements C37866a<Bundle, Bundle> {
        private C38184b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            C38195c c38195c = null;
            AppMethodBeat.m2504i(10645);
            final String string = ((Bundle) obj).getString("id");
            C33159d azy = C33159d.azy();
            if (C5046bo.isNullOrNil(string)) {
                C4990ab.m7420w("MicroMsg.DynamicPageViewIPCProxyManager", "remove IPCProxy from manager failed, key is null or nil.");
            } else {
                Integer valueOf;
                C38195c c38195c2 = (C38195c) azy.hlx.remove(string);
                String str = "MicroMsg.DynamicPageViewIPCProxyManager";
                String str2 = "remove IPCProxy success.(key : %s, ref : %s)";
                Object[] objArr = new Object[2];
                objArr[0] = string;
                if (c38195c2 != null) {
                    valueOf = Integer.valueOf(c38195c2.hashCode());
                } else {
                    valueOf = null;
                }
                objArr[1] = valueOf;
                C4990ab.m7411d(str, str2, objArr);
                if (c38195c2 != null) {
                    c38195c = c38195c2;
                }
            }
            if (c38195c == null) {
                C4990ab.m7413e("MicroMsg.IPCInvoke_Detach", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.m2505o(10645);
                return;
            }
            C45539b.m83988E(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(10644);
                    C38195c c38195c = c38195c;
                    C4990ab.m7417i("MicroMsg.DynamicPageViewIPCProxy", "detach(%s)", c38195c.eIq);
                    c38195c.apg = false;
                    c38195c.cleanup();
                    c38195c.eIn = null;
                    c38195c.hll = null;
                    c38195c.eIq = null;
                    c38195c.hcl = null;
                    C45548k.m83999Ab(string);
                    c18507c.mo5960ao(null);
                    C10211f azA = C10211f.azA();
                    String str = string;
                    if (azA.hlB.containsKey(str)) {
                        C10214b c10214b = (C10214b) azA.hlB.get(str);
                        C4990ab.m7417i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", c10214b.hlF.toString());
                        if (c10214b.hlF.size() > 0) {
                            C1196a c1196a = new C1196a();
                            c1196a.fsI = 2653;
                            c1196a.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
                            ctb ctb = new ctb();
                            ctb.csB = C18652u.m29154pr(str);
                            ctb.f2980id = c10214b.fmr;
                            ctb.xqi = c10214b.hlF;
                            ctb.query = c10214b.query;
                            c1196a.fsJ = ctb;
                            c1196a.fsK = new ctc();
                            C42146b.m74301a(c1196a.acD(), azA.hlC);
                        }
                        AppMethodBeat.m2505o(10644);
                        return;
                    }
                    C4990ab.m7421w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", str);
                    AppMethodBeat.m2505o(10644);
                }
            });
            AppMethodBeat.m2505o(10645);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$a */
    public static class C38185a implements C37866a<Bundle, Bundle> {
        private C38185a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10643);
            Bundle bundle = (Bundle) obj;
            final String string = bundle.getString("id");
            final String string2 = bundle.getString("appId");
            final Bundle bundle2 = bundle.getBundle("extData");
            final C38195c zR = C33159d.azy().mo53689zR(string);
            if (zR == null) {
                C4990ab.m7413e("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                C18652u.m29150e("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.m2505o(10643);
                return;
            }
            C18652u.m29151i("MicroMsg.IPCInvoke_AttachTo", "IPCInvoke_AttachTo invoke", new Object[0]);
            C45539b.m83988E(new Runnable() {
                public final void run() {
                    String string;
                    long j;
                    Object obj;
                    AppMethodBeat.m2504i(10642);
                    C18652u.m29151i("MicroMsg.IPCInvoke_AttachTo", "ui thread attach", new Object[0]);
                    C38195c c38195c = zR;
                    String str = string;
                    String str2 = string2;
                    Bundle bundle = bundle2;
                    Assert.assertNotNull(str);
                    if (!(str.equals(c38195c.eIq) || c38195c.eIn == null)) {
                        c38195c.cleanup();
                        c38195c.apg = false;
                        c38195c.eIn = null;
                    }
                    c38195c.eIq = str;
                    c38195c.appId = str2;
                    String str3 = "";
                    if (bundle != null) {
                        string = bundle.getString("cache_key", "");
                        c38195c.f16148Kg = bundle.getString(SearchIntents.EXTRA_QUERY);
                        c38195c.hlk = bundle.getBoolean("is_testing_ui");
                        c38195c.mUrl = bundle.getString("url");
                        c38195c.hlj = bundle.getInt("widget_type");
                        c38195c.hlm = bundle.getString("search_id");
                        c38195c.hcl = bundle.getString("__session_id");
                        j = bundle.getLong("__on_bind_nano_time");
                        if (!C5046bo.isNullOrNil(c38195c.hcl)) {
                            C2107c.m4311a((CollectSession) bundle.getParcelable("__cost_time_session"));
                        }
                        str3 = string;
                    } else {
                        j = 0;
                    }
                    C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s)", str, str2);
                    Object obj2 = 1;
                    if (c38195c.hlj == 1) {
                        obj2 = null;
                    } else {
                        c38195c.hll = C33166b.m54215Am(str);
                    }
                    if (c38195c.hll == null) {
                        c38195c.hll = new C44718e();
                        obj = null;
                    } else {
                        obj = obj2;
                    }
                    c38195c.hll.field_id = str;
                    c38195c.hll.field_cacheKey = str3;
                    c38195c.hll.field_appId = C18652u.m29154pr(c38195c.eIq);
                    C30909e c30909e;
                    C42426f c42426f;
                    C42427g c42427g;
                    if (c38195c.eIn == null) {
                        C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge is null", new Object[0]);
                        C2107c.m4312bD(c38195c.hcl, "before_init_js_engine");
                        Context context = c38195c.mContext;
                        string = c38195c.eIq;
                        WxaWidgetContext Aa = C45548k.m83998Aa(string);
                        if (Aa == null || bundle == null) {
                            C4990ab.m7421w("MicroMsg.WxaWidgetInitializer", "FwContext is null(id : %s)", string);
                            c30909e = null;
                        } else {
                            C4990ab.m7417i("MicroMsg.WxaWidgetInitializer", "initJsBridge(%s)", string);
                            c30909e = C26864e.m42792a(context, Aa, new C33153a(string, Aa.azI()), bundle);
                        }
                        c38195c.eIn = c30909e;
                        C2107c.m4312bD(c38195c.hcl, "after_init_js_engine");
                        c38195c.eIn.eIq = c38195c.eIq;
                        if (c38195c.eIn.eIt instanceof C10209a) {
                            C10209a c10209a = (C10209a) c38195c.eIn.eIt;
                            C381973 c381973 = new C381973();
                            if (c10209a.hoa != null) {
                                c10209a.hoa.setJsExceptionHandler(c381973);
                            }
                            c10209a = (C10209a) c38195c.eIn.eIt;
                            C381894 c381894 = new C381894();
                            C17090c c17090c = c10209a.hoa;
                            if (c17090c.ieS != null) {
                                Iterator it = c17090c.ieS.chQ.iterator();
                                while (it.hasNext()) {
                                    C9265n c9265n = (C9265n) it.next();
                                    if (c9265n instanceof C18182p) {
                                        ((C18182p) c9265n).cij = c381894;
                                    }
                                }
                            }
                        }
                        if (bundle != null) {
                            c38195c.mo60932q(bundle.getBundle("__env_args"));
                        }
                        c38195c.eIn.onStart();
                        if (c38195c.hln) {
                            c30909e = c38195c.eIn;
                            c42426f = new C42426f();
                            c30909e.mo49447Qz();
                        } else {
                            c30909e = c38195c.eIn;
                            c42427g = new C42427g();
                            c30909e.mo49445QA();
                        }
                        C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "before dispatch onCanvasInsertJsEvent", new Object[0]);
                        C30909e c30909e2 = c38195c.eIn;
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
                            str4 = C8874h.m15847bO(string2);
                            map = C8874h.m15848bP(string2);
                        }
                        C19183b c19183b = new C19183b();
                        c19183b.cacheKey = str2;
                        c19183b.title = string;
                        c19183b.path = str4;
                        c19183b.hod = map;
                        c19183b.hoe = i;
                        c19183b.hof = i2;
                        c30909e2.mo49450a(c19183b, new C191725());
                        C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "after dispatch onCanvasInsertJsEvent", new Object[0]);
                        C26273ad eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(str));
                        eZ.cYw = (long) C18652u.m29153pq(str);
                        eZ.cYs = 8;
                        eZ = eZ.mo43950eY(str);
                        eZ.cYt = System.currentTimeMillis();
                        eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
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
                            C7060h.pYm.mo8378a(677, (long) i2, 1, false);
                            C7060h.pYm.mo8378a(677, 8, 1, false);
                        }
                        C2107c.m4312bD(c38195c.hcl, "init_finish");
                        C2107c.print(c38195c.hcl);
                        C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge init complete", new Object[0]);
                    } else {
                        C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge not null", new Object[0]);
                        C2107c.m4319yI(c38195c.hcl);
                        if (bundle != null) {
                            c38195c.mo60932q(bundle.getBundle("__env_args"));
                        }
                        c38195c.eIn.onStart();
                        if (c38195c.hln) {
                            c30909e = c38195c.eIn;
                            c42426f = new C42426f();
                            c30909e.mo49447Qz();
                        } else {
                            c30909e = c38195c.eIn;
                            c42427g = new C42427g();
                            c30909e.mo49445QA();
                        }
                    }
                    c38195c.apg = true;
                    if (obj != null) {
                        c38195c.mo60928a(c38195c.eIn, c38195c.hll);
                    } else if (c38195c.hlk) {
                        c38195c.hll.field_data = bundle.getString("init_data");
                        c38195c.mo60928a(c38195c.eIn, c38195c.hll);
                    }
                    c38195c.azx();
                    AppMethodBeat.m2505o(10642);
                }
            });
            AppMethodBeat.m2505o(10643);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$c */
    public static class C38186c implements C37866a<Bundle, Bundle> {
        private C38186c() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10648);
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
            if (C33159d.azy().mo53689zR(string) == null) {
                C38195c c38195c = new C38195c(C4996ah.getContext());
                C33159d azy = C33159d.azy();
                if (C5046bo.isNullOrNil(string)) {
                    C4990ab.m7420w("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy into manager failed, key is null or nil.");
                } else {
                    if (((C38195c) azy.hlx.put(string, c38195c)) != null) {
                        C4990ab.m7417i("MicroMsg.DynamicPageViewIPCProxyManager", "add a new IPCProxy and remove old one with key : %s.", string);
                    }
                    C4990ab.m7411d("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy success.(%s)", string);
                }
            }
            C33164i.azC().mo53693bK(string, bundle.getString("view_process_name"));
            C10211f azA = C10211f.azA();
            String string6 = bundle.getString(SearchIntents.EXTRA_QUERY);
            String string7 = bundle.getString("cache_key", string6);
            if (azA.hlB.containsKey(string)) {
                C4990ab.m7421w("MicroMsg.DynamicPageViewStateMonitor", "OnAttach with same widgetId[%s]", string);
                azA.hlB.remove(string);
            }
            azA.hlB.put(string, new C10214b(string, string2, i5, string7));
            C38203j azE = C38203j.azE();
            int i6 = i + 1;
            string6 = bundle.getString(SearchIntents.EXTRA_QUERY);
            string6 = bundle.getString("cache_key", string6);
            if (azE.hlB.containsKey(string)) {
                C26340b.m41918w("WidgetReporter_14443", "OnAttach with same widgetId[%s]", string);
                azE.hlB.remove(string);
            }
            C38205b c38205b = new C38205b(string, string2, i6, string6, i5);
            azE.hlB.put(string, c38205b);
            Bundle toBundle = c38205b.toBundle();
            C9549f.m17012a("com.tencent.mm", toBundle, C38204a.class, null);
            C9549f.m17012a("com.tencent.mm:support", toBundle, C38204a.class, null);
            C9549f.m17012a("com.tencent.mm:tools", toBundle, C38204a.class, null);
            azE.mo60938E(string, JsApiShowImageOperateSheet.CTRL_INDEX, 0);
            final C18507c c18507c2 = c18507c;
            String str = string;
            C45539b.m83987D(new C101921(str, C33167b.m54217cX(i4, i), i2, string2, i4, i3, string4, i5, new C26854a() {
                /* renamed from: bI */
                public final void mo44626bI(String str, String str2) {
                    AppMethodBeat.m2504i(10646);
                    Bundle bundle = new Bundle();
                    bundle.putInt("op", 0);
                    bundle.putString("id", str);
                    bundle.putString("appId", str2);
                    c18507c2.mo5960ao(bundle);
                    AppMethodBeat.m2505o(10646);
                }

                /* renamed from: a */
                public final void mo44625a(String str, String str2, boolean z, WxaWidgetContext wxaWidgetContext) {
                    AppMethodBeat.m2504i(10647);
                    Bundle bundle = new Bundle();
                    bundle.putInt("op", 1);
                    bundle.putString("id", str);
                    bundle.putString("appId", str2);
                    bundle.putBoolean("success", z);
                    if (wxaWidgetContext != null) {
                        C18652u.m29151i("MicroMsg.DynamicIPCJsBridge", " OnInitializeCallback.onInitialized putContext %s", str);
                        bundle.putParcelable("fwContext", wxaWidgetContext);
                        C45548k.m84000a(str, wxaWidgetContext);
                    }
                    c18507c2.mo5960ao(bundle);
                    AppMethodBeat.m2505o(10647);
                }
            }, string3, string5));
            AppMethodBeat.m2505o(10648);
        }
    }

    public C38183a(C2150h c2150h) {
        this.hkW = c2150h;
    }

    /* renamed from: aY */
    public final void mo60922aY(String str, int i) {
        AppMethodBeat.m2504i(10655);
        if (this.eIq == null || this.eIq.length() == 0) {
            AppMethodBeat.m2505o(10655);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putInt("widgetState", i);
        C9549f.m17012a(C33164i.azC().mo53694zV(str), bundle, C10213a.class, null);
        AppMethodBeat.m2505o(10655);
    }
}
