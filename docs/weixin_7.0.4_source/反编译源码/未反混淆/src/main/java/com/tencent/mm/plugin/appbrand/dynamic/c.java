package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.f.g;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.c.e;
import java.util.Set;

public final class c implements com.tencent.mm.plugin.appbrand.canvas.widget.b {
    String Kg;
    boolean apg;
    String appId;
    volatile e eIn;
    String eIq;
    String hcl;
    int hlj;
    boolean hlk;
    com.tencent.mm.plugin.appbrand.widget.e hll;
    String hlm;
    volatile boolean hln;
    volatile boolean hlo;
    private volatile boolean hlp;
    boolean hlq = false;
    boolean hlr = false;
    private com.tencent.mm.ipcinvoker.wx_extension.b.a hls;
    Runnable hlt;
    Context mContext;
    String mUrl;

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(10666);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("widgetId");
            String string2 = bundle.getString("respData");
            if (!bo.isNullOrNil(string)) {
                IPCDynamicPageView Ak = com.tencent.mm.plugin.appbrand.dynamic.h.a.aAb().Ak(string);
                if (Ak != null) {
                    AnonymousClass1 anonymousClass1 = new t() {
                        public final void b(boolean z, String str, Bundle bundle) {
                        }
                    };
                    if (Ak.hpp == null) {
                        anonymousClass1.b(false, "listener is null", null);
                        AppMethodBeat.o(10666);
                        return;
                    }
                    ae aeVar = (ae) Ak.hpp.px("OnDataPush");
                    if (aeVar == null) {
                        anonymousClass1.b(false, "listener is null", null);
                        AppMethodBeat.o(10666);
                        return;
                    }
                    aeVar.aq(string, string2);
                }
            }
            AppMethodBeat.o(10666);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(10667);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("widgetId");
            String string2 = bundle.getString("data");
            String string3 = bundle.getString(NativeProtocol.WEB_DIALOG_ACTION);
            if (!bo.isNullOrNil(string)) {
                IPCDynamicPageView Ak = com.tencent.mm.plugin.appbrand.dynamic.h.a.aAb().Ak(string);
                if (!(Ak == null || !"onWidgetJsError".equals(string3) || Ak.hpp == null)) {
                    aa aaVar = (aa) Ak.hpp.px("onWxaWidgetJsError");
                    if (aaVar != null) {
                        aaVar.pw(string2);
                    }
                }
            }
            AppMethodBeat.o(10667);
        }
    }

    public c(Context context) {
        AppMethodBeat.i(10668);
        this.mContext = context;
        this.hls = new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
                AppMethodBeat.i(10660);
                ab.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                com.tencent.mm.plugin.appbrand.widget.e eVar = c.this.hll;
                ad eZ;
                if (i == 0 && i2 == 0) {
                    if (c.this.hlj == 1 && !c.this.hlq) {
                        c.this.hlq = true;
                        v.kT(17);
                        eZ = new ad().eZ(u.pr(c.this.eIq));
                        eZ.cYw = (long) u.pq(c.this.eIq);
                        eZ.cYs = 10;
                        eZ.cYu = 1;
                        eZ = eZ.eY(c.this.eIq);
                        eZ.cYt = System.currentTimeMillis();
                        eZ.fa(at.gB(ah.getContext())).ajK();
                    }
                    xs xsVar = (xs) bVar.fsH.fsP;
                    String dlY = xsVar.wdt != null ? xsVar.wdt.dlY() : "";
                    if (eVar == null) {
                        AppMethodBeat.o(10660);
                        return;
                    }
                    if (!bo.isNullOrNil(dlY)) {
                        eVar.field_data = dlY;
                    } else if (c.this.hll == null || TextUtils.isEmpty(c.this.hll.field_data)) {
                        j.azE().E(c.this.eIq, ag.CTRL_INDEX, 4);
                    }
                    eVar.field_interval = xsVar.eCL;
                    eVar.field_updateTime = System.currentTimeMillis();
                    Bundle bundle = (Bundle) f.a("com.tencent.mm", eVar.Hl(), com.tencent.mm.plugin.appbrand.dynamic.j.b.b.class);
                    if (bundle != null) {
                        bundle.getBoolean("result", false);
                    }
                    if (c.this.apg) {
                        c.this.a(c.this.eIn, eVar);
                        if (c.this.hlj == 1 && !c.this.hlr) {
                            c.this.hlr = true;
                        }
                        if (eVar.field_interval > 0) {
                            c.this.azx();
                        }
                        AppMethodBeat.o(10660);
                        return;
                    }
                    ab.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
                    AppMethodBeat.o(10660);
                    return;
                }
                h.pYm.a(638, 0, 1, false);
                if (c.this.hlj == 1 && !c.this.hlq) {
                    v.kT(18);
                    eZ = new ad().eZ(u.pr(c.this.eIq));
                    eZ.cYw = (long) u.pq(c.this.eIq);
                    eZ.cYs = 10;
                    eZ.cYu = 2;
                    eZ = eZ.eY(c.this.eIq);
                    eZ.cYt = System.currentTimeMillis();
                    eZ.fa(at.gB(ah.getContext())).ajK();
                }
                b.j(c.this.hlt, (eVar != null ? (long) eVar.field_interval : 10) * 1000);
                if (c.this.hll == null || TextUtils.isEmpty(c.this.hll.field_data)) {
                    j.azE().E(c.this.eIq, ag.CTRL_INDEX, 2);
                }
                AppMethodBeat.o(10660);
            }
        };
        this.hlt = new Runnable() {
            public final void run() {
                AppMethodBeat.i(10661);
                c.this.azx();
                AppMethodBeat.o(10661);
            }
        };
        AppMethodBeat.o(10668);
    }

    public final boolean bJ(String str, String str2) {
        AppMethodBeat.i(10669);
        if (this.eIn == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(10669);
            return false;
        }
        boolean R = this.eIn.R(str, str2);
        AppMethodBeat.o(10669);
        return R;
    }

    /* Access modifiers changed, original: final */
    public final void cleanup() {
        AppMethodBeat.i(10670);
        if (this.hll != null) {
            ab.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", this.hll.field_id, this.hll.field_appId);
        } else {
            ab.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
        }
        if (this.eIn != null) {
            this.eIn.onStop();
        }
        AppMethodBeat.o(10670);
    }

    /* Access modifiers changed, original: final */
    public final void azx() {
        AppMethodBeat.i(10671);
        u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
        if (this.hlk) {
            AppMethodBeat.o(10671);
            return;
        }
        com.tencent.mm.plugin.appbrand.widget.e eVar = this.hll;
        if (eVar == null || !this.apg) {
            boolean z;
            String str = "MicroMsg.DynamicPageViewIPCProxy";
            String str2 = "cacheData %b, mRunning %b";
            Object[] objArr = new Object[2];
            if (eVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Boolean.valueOf(this.apg);
            u.i(str, str2, objArr);
            AppMethodBeat.o(10671);
        } else if (this.hlo) {
            u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
            this.hlp = true;
            AppMethodBeat.o(10671);
        } else if (bo.isNullOrNil(eVar.field_appId)) {
            ab.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", this.eIq);
            AppMethodBeat.o(10671);
        } else {
            this.hlp = false;
            long currentTimeMillis = (eVar.field_updateTime + (((long) eVar.field_interval) * 1000)) - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", Long.valueOf(currentTimeMillis));
                b.j(this.hlt, currentTimeMillis);
                AppMethodBeat.o(10671);
                return;
            }
            u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", this.hll.field_id, this.hll.field_appId);
            if (this.hlj == 1 && !this.hlq) {
                v.kT(16);
                ad eZ = new ad().eZ(u.pr(this.eIq));
                eZ.cYw = (long) u.pq(this.eIq);
                eZ.cYs = 9;
                eZ = eZ.eY(this.eIq);
                eZ.cYt = System.currentTimeMillis();
                eZ.fa(at.gB(ah.getContext())).ajK();
            }
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsI = 1193;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
            xr xrVar = new xr();
            xrVar.csB = eVar.field_appId;
            xrVar.key = eVar.field_cacheKey;
            xrVar.scene = this.hlj;
            xrVar.query = this.Kg;
            xrVar.url = this.mUrl;
            aVar.fsJ = xrVar;
            aVar.fsK = new xs();
            com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.acD(), this.hls);
            AppMethodBeat.o(10671);
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(e eVar, com.tencent.mm.plugin.appbrand.widget.e eVar2) {
        boolean z = false;
        AppMethodBeat.i(10672);
        String str;
        if (eVar == null || eVar2 == null || bo.isNullOrNil(eVar2.field_data)) {
            str = "MicroMsg.DynamicPageViewIPCProxy";
            String str2 = "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(eVar == null);
            if (eVar2 == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            AppMethodBeat.o(10672);
            return;
        }
        u.i("MicroMsg.DynamicPageViewIPCProxy", "pushData %s", eVar2.field_id);
        com.tencent.mm.plugin.appbrand.dynamic.f.c cVar = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
        cVar.data = eVar2.field_data;
        eVar.a(cVar, new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(10665);
                u.i("MicroMsg.DynamicPageViewIPCProxy", "onDataPush event dispatch result %s", (String) obj);
                AppMethodBeat.o(10665);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", eVar2.field_id);
        bundle.putString("respData", eVar2.field_data);
        str = i.azC().zV(eVar2.field_id);
        u.i("MicroMsg.DynamicPageViewIPCProxy", "dispatch onDataPush event to view proce %s", str);
        if (str == null) {
            ToolsProcessIPCService.b(bundle, a.class);
            AppMethodBeat.o(10672);
            return;
        }
        f.a(str, bundle, a.class, null);
        AppMethodBeat.o(10672);
    }

    public final void q(Bundle bundle) {
        AppMethodBeat.i(10673);
        if (bundle == null) {
            AppMethodBeat.o(10673);
            return;
        }
        if (this.eIn != null) {
            com.tencent.mm.model.v.b Qy = this.eIn.Qy();
            if (Qy == null) {
                AppMethodBeat.o(10673);
                return;
            }
            Set<String> keySet = bundle.keySet();
            if (keySet == null || Qy == null) {
                AppMethodBeat.o(10673);
                return;
            }
            for (String str : keySet) {
                Qy.j(str, bundle.get(str));
            }
        }
        AppMethodBeat.o(10673);
    }

    public final void onResume() {
        AppMethodBeat.i(10674);
        ab.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", this.eIq);
        boolean z = this.hln;
        if (this.eIn != null) {
            e eVar = this.eIn;
            g gVar = new g();
            eVar.QA();
        }
        this.hln = false;
        z = this.hlo;
        this.hlo = false;
        if (z && this.hlp) {
            azx();
        }
        AppMethodBeat.o(10674);
    }

    public final boolean isPaused() {
        return this.hln;
    }
}
