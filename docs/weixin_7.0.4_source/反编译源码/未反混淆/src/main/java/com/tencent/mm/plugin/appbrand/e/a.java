package com.tencent.mm.plugin.appbrand.e;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.i.a.d;
import com.tencent.luggage.i.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public final class a implements f {
    private d<g> hpG;
    private ConcurrentHashMap<String, g> hpH = new ConcurrentHashMap();
    private ConcurrentHashMap<String, ConcurrentLinkedQueue<b>> hpI = new ConcurrentHashMap();
    private e hpJ;

    public a() {
        AppMethodBeat.i(117330);
        AppMethodBeat.o(117330);
    }

    public final e yp() {
        return this.hpJ;
    }

    public final void a(e eVar) {
        this.hpJ = eVar;
    }

    public final void a(d<g> dVar) {
        this.hpG = dVar;
    }

    public final String a(String str, int i, c cVar, JSONObject jSONObject, m mVar, int i2) {
        AppMethodBeat.i(117331);
        String bc = d.bc(str, i);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "handleJsApi, key:%s, jsapi:%s", bc, mVar.getName());
        g gVar = (g) this.hpH.get(bc);
        String str2;
        if (gVar == null) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "handleJsApi, handler is null");
            a(bc, mVar, cVar, jSONObject, i2);
            str2 = "";
            AppMethodBeat.o(117331);
            return str2;
        } else if (gVar.a(mVar)) {
            gVar.a(cVar, jSONObject, mVar, i2);
            str2 = "";
            AppMethodBeat.o(117331);
            return str2;
        } else {
            a(bc, mVar, cVar, jSONObject, i2);
            str2 = "";
            AppMethodBeat.o(117331);
            return str2;
        }
    }

    public final void onPluginReady(String str, int i, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(117332);
        String bc = d.bc(str, i);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, key:%s", bc);
        g gVar = (g) this.hpH.get(bc);
        if (gVar != null) {
            ab.w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, handle plugin ready again");
            gVar.d(surfaceTexture);
            a(bc, gVar);
            AppMethodBeat.o(117332);
            return;
        }
        if (this.hpG != null) {
            gVar = (g) this.hpG.bS(str);
            if (gVar != null) {
                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, created new plugin handler");
                gVar.setId(i);
                gVar.setType(str);
                gVar.a((f) this);
                this.hpH.put(bc, gVar);
                gVar.d(surfaceTexture);
                a(bc, gVar);
                AppMethodBeat.o(117332);
                return;
            }
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, no handler for this view?");
        }
        AppMethodBeat.o(117332);
    }

    public final void onPluginDestroy(String str, int i) {
        AppMethodBeat.i(117333);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginDestroy, key:%s", d.bc(str, i));
        g gVar = (g) this.hpH.get(r0);
        if (gVar == null) {
            ab.w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginDestroy, do you forget to call ready before?");
            AppMethodBeat.o(117333);
            return;
        }
        gVar.yr();
        AppMethodBeat.o(117333);
    }

    public final void onPluginTouch(String str, int i, MotionEvent motionEvent) {
        AppMethodBeat.i(117334);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginTouch, key:%s", d.bc(str, i));
        g gVar = (g) this.hpH.get(r0);
        if (gVar == null) {
            ab.w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginTouch, no handler created for this key?");
            AppMethodBeat.o(117334);
            return;
        }
        gVar.m(motionEvent);
        AppMethodBeat.o(117334);
    }

    private void a(String str, m mVar, c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(117335);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", ">>>>>> savePendingJsApi start, key:%s, jsapi:%s", str, mVar.getName());
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.hpI.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            this.hpI.put(str, concurrentLinkedQueue);
        }
        concurrentLinkedQueue.add(new b(jSONObject, mVar, cVar, i));
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "<<<<<< savePendingJsApi end");
        AppMethodBeat.o(117335);
    }

    private void a(String str, g gVar) {
        AppMethodBeat.i(117336);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", ">>>>>> flushPendingJsApis start, key:%s", str);
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.hpI.get(str);
        if (!(concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty())) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                gVar.a(bVar.hvw, bVar.hnx, bVar.hwj, bVar.hwi);
            }
        }
        this.hpI.remove(str);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "<<<<<< flushPendingJsApis end");
        AppMethodBeat.o(117336);
    }
}
