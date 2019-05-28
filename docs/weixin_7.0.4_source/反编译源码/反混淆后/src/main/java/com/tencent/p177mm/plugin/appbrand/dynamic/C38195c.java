package com.tencent.p177mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C26438t;
import com.tencent.p177mm.modelappbrand.C26439v;
import com.tencent.p177mm.modelappbrand.C36699aa;
import com.tencent.p177mm.modelappbrand.C36702ae;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p232b.p233a.C26273ad;
import com.tencent.p177mm.p652z.p653c.C30909e;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C26824b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1220f.C19184c;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1220f.C42427g;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C38202a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C33166b.C19199b;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42466ag;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.plugin.appbrand.p297h.C42453x;
import com.tencent.p177mm.plugin.appbrand.widget.C44718e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C15397xs;
import com.tencent.p177mm.protocal.protobuf.C30243xr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c */
public final class C38195c implements C26824b {
    /* renamed from: Kg */
    String f16148Kg;
    boolean apg;
    String appId;
    volatile C30909e eIn;
    String eIq;
    String hcl;
    int hlj;
    boolean hlk;
    C44718e hll;
    String hlm;
    volatile boolean hln;
    volatile boolean hlo;
    private volatile boolean hlp;
    boolean hlq = false;
    boolean hlr = false;
    private C9557a hls;
    Runnable hlt;
    Context mContext;
    String mUrl;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c$5 */
    class C191725 implements ValueCallback<String> {
        C191725() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(10664);
            C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "dispatch canvasInsert event result %s", (String) obj);
            AppMethodBeat.m2505o(10664);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c$6 */
    class C191736 implements ValueCallback<String> {
        C191736() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(10665);
            C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "onDataPush event dispatch result %s", (String) obj);
            AppMethodBeat.m2505o(10665);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c$a */
    static class C19174a implements C37866a<Bundle, Bundle> {

        /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c$a$1 */
        class C191751 implements C26438t {
            C191751() {
            }

            /* renamed from: b */
            public final void mo5959b(boolean z, String str, Bundle bundle) {
            }
        }

        private C19174a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10666);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("widgetId");
            String string2 = bundle.getString("respData");
            if (!C5046bo.isNullOrNil(string)) {
                IPCDynamicPageView Ak = C38202a.aAb().mo60935Ak(string);
                if (Ak != null) {
                    C191751 c191751 = new C191751();
                    if (Ak.hpp == null) {
                        c191751.mo5959b(false, "listener is null", null);
                        AppMethodBeat.m2505o(10666);
                        return;
                    }
                    C36702ae c36702ae = (C36702ae) Ak.hpp.mo53363px("OnDataPush");
                    if (c36702ae == null) {
                        c191751.mo5959b(false, "listener is null", null);
                        AppMethodBeat.m2505o(10666);
                        return;
                    }
                    c36702ae.mo9591aq(string, string2);
                }
            }
            AppMethodBeat.m2505o(10666);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c$b */
    static class C19176b implements C37866a<Bundle, Bundle> {
        private C19176b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10667);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("widgetId");
            String string2 = bundle.getString("data");
            String string3 = bundle.getString(NativeProtocol.WEB_DIALOG_ACTION);
            if (!C5046bo.isNullOrNil(string)) {
                IPCDynamicPageView Ak = C38202a.aAb().mo60935Ak(string);
                if (!(Ak == null || !"onWidgetJsError".equals(string3) || Ak.hpp == null)) {
                    C36699aa c36699aa = (C36699aa) Ak.hpp.mo53363px("onWxaWidgetJsError");
                    if (c36699aa != null) {
                        c36699aa.mo9589pw(string2);
                    }
                }
            }
            AppMethodBeat.m2505o(10667);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c$2 */
    class C381882 implements Runnable {
        C381882() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10661);
            C38195c.this.azx();
            AppMethodBeat.m2505o(10661);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c$4 */
    class C381894 implements C42453x {
        C381894() {
        }

        public final void onError(String str) {
            AppMethodBeat.m2504i(10663);
            C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "console js error stackTrace %s", str);
            if (!TextUtils.isEmpty(str) && str.contains("widgetThirdScriptError")) {
                Bundle bundle = new Bundle();
                bundle.putString("widgetId", C38195c.this.eIq);
                bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "onWidgetJsError");
                bundle.putString("data", str);
                String zV = C33164i.azC().mo53694zV(C38195c.this.eIq);
                if (zV == null) {
                    ToolsProcessIPCService.m63914b(bundle, C19176b.class);
                    AppMethodBeat.m2505o(10663);
                    return;
                }
                C9549f.m17012a(zV, bundle, C19176b.class, null);
            }
            AppMethodBeat.m2505o(10663);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c$1 */
    class C381961 implements C9557a {
        C381961() {
        }

        /* renamed from: a */
        public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
            AppMethodBeat.m2504i(10660);
            C4990ab.m7417i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", Integer.valueOf(i), Integer.valueOf(i2), str);
            C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", Integer.valueOf(i), Integer.valueOf(i2), str);
            C44718e c44718e = C38195c.this.hll;
            C26273ad eZ;
            if (i == 0 && i2 == 0) {
                if (C38195c.this.hlj == 1 && !C38195c.this.hlq) {
                    C38195c.this.hlq = true;
                    C26439v.m42099kT(17);
                    eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(C38195c.this.eIq));
                    eZ.cYw = (long) C18652u.m29153pq(C38195c.this.eIq);
                    eZ.cYs = 10;
                    eZ.cYu = 1;
                    eZ = eZ.mo43950eY(C38195c.this.eIq);
                    eZ.cYt = System.currentTimeMillis();
                    eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                }
                C15397xs c15397xs = (C15397xs) c7472b.fsH.fsP;
                String dlY = c15397xs.wdt != null ? c15397xs.wdt.dlY() : "";
                if (c44718e == null) {
                    AppMethodBeat.m2505o(10660);
                    return;
                }
                if (!C5046bo.isNullOrNil(dlY)) {
                    c44718e.field_data = dlY;
                } else if (C38195c.this.hll == null || TextUtils.isEmpty(C38195c.this.hll.field_data)) {
                    C38203j.azE().mo60938E(C38195c.this.eIq, C42466ag.CTRL_INDEX, 4);
                }
                c44718e.field_interval = c15397xs.eCL;
                c44718e.field_updateTime = System.currentTimeMillis();
                Bundle bundle = (Bundle) C9549f.m17010a("com.tencent.mm", c44718e.mo10098Hl(), C19199b.class);
                if (bundle != null) {
                    bundle.getBoolean("result", false);
                }
                if (C38195c.this.apg) {
                    C38195c.this.mo60928a(C38195c.this.eIn, c44718e);
                    if (C38195c.this.hlj == 1 && !C38195c.this.hlr) {
                        C38195c.this.hlr = true;
                    }
                    if (c44718e.field_interval > 0) {
                        C38195c.this.azx();
                    }
                    AppMethodBeat.m2505o(10660);
                    return;
                }
                C4990ab.m7416i("MicroMsg.DynamicPageViewIPCProxy", "not running");
                AppMethodBeat.m2505o(10660);
                return;
            }
            C7060h.pYm.mo8378a(638, 0, 1, false);
            if (C38195c.this.hlj == 1 && !C38195c.this.hlq) {
                C26439v.m42099kT(18);
                eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(C38195c.this.eIq));
                eZ.cYw = (long) C18652u.m29153pq(C38195c.this.eIq);
                eZ.cYs = 10;
                eZ.cYu = 2;
                eZ = eZ.mo43950eY(C38195c.this.eIq);
                eZ.cYt = System.currentTimeMillis();
                eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
            }
            C45539b.m83989j(C38195c.this.hlt, (c44718e != null ? (long) c44718e.field_interval : 10) * 1000);
            if (C38195c.this.hll == null || TextUtils.isEmpty(C38195c.this.hll.field_data)) {
                C38203j.azE().mo60938E(C38195c.this.eIq, C42466ag.CTRL_INDEX, 2);
            }
            AppMethodBeat.m2505o(10660);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c$3 */
    class C381973 implements C33211h {
        C381973() {
        }

        /* renamed from: C */
        public final void mo5989C(String str, String str2) {
            AppMethodBeat.m2504i(10662);
            C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "js error msg %s, stackTrace %s", str, str2);
            Bundle bundle = new Bundle();
            bundle.putString("widgetId", C38195c.this.eIq);
            bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "onWidgetJsError");
            bundle.putString("data", str2);
            String zV = C33164i.azC().mo53694zV(C38195c.this.eIq);
            if (zV == null) {
                ToolsProcessIPCService.m63914b(bundle, C19176b.class);
                AppMethodBeat.m2505o(10662);
                return;
            }
            C9549f.m17012a(zV, bundle, C19176b.class, null);
            AppMethodBeat.m2505o(10662);
        }
    }

    public C38195c(Context context) {
        AppMethodBeat.m2504i(10668);
        this.mContext = context;
        this.hls = new C381961();
        this.hlt = new C381882();
        AppMethodBeat.m2505o(10668);
    }

    /* renamed from: bJ */
    public final boolean mo60930bJ(String str, String str2) {
        AppMethodBeat.m2504i(10669);
        if (this.eIn == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(10669);
            return false;
        }
        boolean R = this.eIn.mo49448R(str, str2);
        AppMethodBeat.m2505o(10669);
        return R;
    }

    /* Access modifiers changed, original: final */
    public final void cleanup() {
        AppMethodBeat.m2504i(10670);
        if (this.hll != null) {
            C4990ab.m7417i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", this.hll.field_id, this.hll.field_appId);
        } else {
            C4990ab.m7416i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
        }
        if (this.eIn != null) {
            this.eIn.onStop();
        }
        AppMethodBeat.m2505o(10670);
    }

    /* Access modifiers changed, original: final */
    public final void azx() {
        AppMethodBeat.m2504i(10671);
        C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
        if (this.hlk) {
            AppMethodBeat.m2505o(10671);
            return;
        }
        C44718e c44718e = this.hll;
        if (c44718e == null || !this.apg) {
            boolean z;
            String str = "MicroMsg.DynamicPageViewIPCProxy";
            String str2 = "cacheData %b, mRunning %b";
            Object[] objArr = new Object[2];
            if (c44718e == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Boolean.valueOf(this.apg);
            C18652u.m29151i(str, str2, objArr);
            AppMethodBeat.m2505o(10671);
        } else if (this.hlo) {
            C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
            this.hlp = true;
            AppMethodBeat.m2505o(10671);
        } else if (C5046bo.isNullOrNil(c44718e.field_appId)) {
            C4990ab.m7413e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", this.eIq);
            AppMethodBeat.m2505o(10671);
        } else {
            this.hlp = false;
            long currentTimeMillis = (c44718e.field_updateTime + (((long) c44718e.field_interval) * 1000)) - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", Long.valueOf(currentTimeMillis));
                C45539b.m83989j(this.hlt, currentTimeMillis);
                AppMethodBeat.m2505o(10671);
                return;
            }
            C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", this.hll.field_id, this.hll.field_appId);
            if (this.hlj == 1 && !this.hlq) {
                C26439v.m42099kT(16);
                C26273ad eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(this.eIq));
                eZ.cYw = (long) C18652u.m29153pq(this.eIq);
                eZ.cYs = 9;
                eZ = eZ.mo43950eY(this.eIq);
                eZ.cYt = System.currentTimeMillis();
                eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
            }
            C1196a c1196a = new C1196a();
            c1196a.fsI = 1193;
            c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
            C30243xr c30243xr = new C30243xr();
            c30243xr.csB = c44718e.field_appId;
            c30243xr.key = c44718e.field_cacheKey;
            c30243xr.scene = this.hlj;
            c30243xr.query = this.f16148Kg;
            c30243xr.url = this.mUrl;
            c1196a.fsJ = c30243xr;
            c1196a.fsK = new C15397xs();
            C42146b.m74301a(c1196a.acD(), this.hls);
            AppMethodBeat.m2505o(10671);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo60928a(C30909e c30909e, C44718e c44718e) {
        boolean z = false;
        AppMethodBeat.m2504i(10672);
        String str;
        if (c30909e == null || c44718e == null || C5046bo.isNullOrNil(c44718e.field_data)) {
            str = "MicroMsg.DynamicPageViewIPCProxy";
            String str2 = "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(c30909e == null);
            if (c44718e == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(10672);
            return;
        }
        C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "pushData %s", c44718e.field_id);
        C19184c c19184c = new C19184c();
        c19184c.data = c44718e.field_data;
        c30909e.mo49450a(c19184c, new C191736());
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", c44718e.field_id);
        bundle.putString("respData", c44718e.field_data);
        str = C33164i.azC().mo53694zV(c44718e.field_id);
        C18652u.m29151i("MicroMsg.DynamicPageViewIPCProxy", "dispatch onDataPush event to view proce %s", str);
        if (str == null) {
            ToolsProcessIPCService.m63914b(bundle, C19174a.class);
            AppMethodBeat.m2505o(10672);
            return;
        }
        C9549f.m17012a(str, bundle, C19174a.class, null);
        AppMethodBeat.m2505o(10672);
    }

    /* renamed from: q */
    public final void mo60932q(Bundle bundle) {
        AppMethodBeat.m2504i(10673);
        if (bundle == null) {
            AppMethodBeat.m2505o(10673);
            return;
        }
        if (this.eIn != null) {
            C32800b Qy = this.eIn.mo49446Qy();
            if (Qy == null) {
                AppMethodBeat.m2505o(10673);
                return;
            }
            Set<String> keySet = bundle.keySet();
            if (keySet == null || Qy == null) {
                AppMethodBeat.m2505o(10673);
                return;
            }
            for (String str : keySet) {
                Qy.mo53356j(str, bundle.get(str));
            }
        }
        AppMethodBeat.m2505o(10673);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(10674);
        C4990ab.m7417i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", this.eIq);
        boolean z = this.hln;
        if (this.eIn != null) {
            C30909e c30909e = this.eIn;
            C42427g c42427g = new C42427g();
            c30909e.mo49445QA();
        }
        this.hln = false;
        z = this.hlo;
        this.hlo = false;
        if (z && this.hlp) {
            azx();
        }
        AppMethodBeat.m2505o(10674);
    }

    public final boolean isPaused() {
        return this.hln;
    }
}
