package com.tencent.p177mm.plugin.appbrand.p893e;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.p817i.p818a.C37401e;
import com.tencent.luggage.p817i.p818a.C45125d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.C42590b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.e.a */
public final class C10224a implements C19213f {
    private C45125d<C24693g> hpG;
    private ConcurrentHashMap<String, C24693g> hpH = new ConcurrentHashMap();
    private ConcurrentHashMap<String, ConcurrentLinkedQueue<C42590b>> hpI = new ConcurrentHashMap();
    private C37401e hpJ;

    public C10224a() {
        AppMethodBeat.m2504i(117330);
        AppMethodBeat.m2505o(117330);
    }

    /* renamed from: yp */
    public final C37401e mo20076yp() {
        return this.hpJ;
    }

    /* renamed from: a */
    public final void mo20072a(C37401e c37401e) {
        this.hpJ = c37401e;
    }

    /* renamed from: a */
    public final void mo21634a(C45125d<C24693g> c45125d) {
        this.hpG = c45125d;
    }

    /* renamed from: a */
    public final String mo21633a(String str, int i, C2241c c2241c, JSONObject jSONObject, C45608m c45608m, int i2) {
        AppMethodBeat.m2504i(117331);
        String bc = C45551d.m84007bc(str, i);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "handleJsApi, key:%s, jsapi:%s", bc, c45608m.getName());
        C24693g c24693g = (C24693g) this.hpH.get(bc);
        String str2;
        if (c24693g == null) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "handleJsApi, handler is null");
            m17864a(bc, c45608m, c2241c, jSONObject, i2);
            str2 = "";
            AppMethodBeat.m2505o(117331);
            return str2;
        } else if (c24693g.mo41593a(c45608m)) {
            c24693g.mo41591a(c2241c, jSONObject, c45608m, i2);
            str2 = "";
            AppMethodBeat.m2505o(117331);
            return str2;
        } else {
            m17864a(bc, c45608m, c2241c, jSONObject, i2);
            str2 = "";
            AppMethodBeat.m2505o(117331);
            return str2;
        }
    }

    public final void onPluginReady(String str, int i, SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(117332);
        String bc = C45551d.m84007bc(str, i);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, key:%s", bc);
        C24693g c24693g = (C24693g) this.hpH.get(bc);
        if (c24693g != null) {
            C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, handle plugin ready again");
            c24693g.mo32980d(surfaceTexture);
            m17863a(bc, c24693g);
            AppMethodBeat.m2505o(117332);
            return;
        }
        if (this.hpG != null) {
            c24693g = (C24693g) this.hpG.mo60948bS(str);
            if (c24693g != null) {
                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, created new plugin handler");
                c24693g.setId(i);
                c24693g.setType(str);
                c24693g.mo41592a((C19213f) this);
                this.hpH.put(bc, c24693g);
                c24693g.mo32980d(surfaceTexture);
                m17863a(bc, c24693g);
                AppMethodBeat.m2505o(117332);
                return;
            }
            C4990ab.m7412e("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, no handler for this view?");
        }
        AppMethodBeat.m2505o(117332);
    }

    public final void onPluginDestroy(String str, int i) {
        AppMethodBeat.m2504i(117333);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginDestroy, key:%s", C45551d.m84007bc(str, i));
        C24693g c24693g = (C24693g) this.hpH.get(r0);
        if (c24693g == null) {
            C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginDestroy, do you forget to call ready before?");
            AppMethodBeat.m2505o(117333);
            return;
        }
        c24693g.mo32982yr();
        AppMethodBeat.m2505o(117333);
    }

    public final void onPluginTouch(String str, int i, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(117334);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginTouch, key:%s", C45551d.m84007bc(str, i));
        C24693g c24693g = (C24693g) this.hpH.get(r0);
        if (c24693g == null) {
            C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginTouch, no handler created for this key?");
            AppMethodBeat.m2505o(117334);
            return;
        }
        c24693g.mo32981m(motionEvent);
        AppMethodBeat.m2505o(117334);
    }

    /* renamed from: a */
    private void m17864a(String str, C45608m c45608m, C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(117335);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", ">>>>>> savePendingJsApi start, key:%s, jsapi:%s", str, c45608m.getName());
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.hpI.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            this.hpI.put(str, concurrentLinkedQueue);
        }
        concurrentLinkedQueue.add(new C42590b(jSONObject, c45608m, c2241c, i));
        C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "<<<<<< savePendingJsApi end");
        AppMethodBeat.m2505o(117335);
    }

    /* renamed from: a */
    private void m17863a(String str, C24693g c24693g) {
        AppMethodBeat.m2504i(117336);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", ">>>>>> flushPendingJsApis start, key:%s", str);
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.hpI.get(str);
        if (!(concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty())) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                C42590b c42590b = (C42590b) it.next();
                c24693g.mo41591a(c42590b.hvw, c42590b.hnx, c42590b.hwj, c42590b.hwi);
            }
        }
        this.hpI.remove(str);
        C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "<<<<<< flushPendingJsApis end");
        AppMethodBeat.m2505o(117336);
    }
}
