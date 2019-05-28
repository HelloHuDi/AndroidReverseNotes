package com.tencent.mm.plugin.appbrand.jsapi.b;

import a.f.b.j;
import a.l;
import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.facebook.share.internal.ShareConstants;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import java.util.HashMap;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0015R2\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007R\u00020\u00000\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007R\u00020\u0000`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseInsertViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "requestMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lkotlin/collections/HashMap;", "getViewId", "data", "Lorg/json/JSONObject;", "inflateView", "Landroid/view/View;", "component", "viewId", "isAsyncCallback", "", "onInsertViewWithAsyncCallback", "", "view", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "Companion", "Request", "SurfaceAvailableListener", "plugin-appbrand-integration_release"})
public final class g extends com.tencent.mm.plugin.appbrand.jsapi.base.a<w> {
    public static final int CTRL_INDEX = 594;
    public static final String NAME = "insertWebGLCanvas";
    public static final a hHD = new a();
    private final HashMap<Integer, b> hHC = new HashMap();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onForeground"})
    static final class d implements com.tencent.mm.plugin.appbrand.jsapi.f.d {
        final /* synthetic */ MBRuntime hHI;
        final /* synthetic */ com.tencent.magicbrush.b hHJ;

        d(MBRuntime mBRuntime, com.tencent.magicbrush.b bVar) {
            this.hHI = mBRuntime;
            this.hHJ = bVar;
        }

        public final void wU() {
            AppMethodBeat.i(134667);
            com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "foreground");
            com.tencent.magicbrush.c.b mBRuntimeView = this.hHI.getMBRuntimeView();
            if (mBRuntimeView != null && j.j(mBRuntimeView, this.hHJ.getTextureView())) {
                com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "foreground, really");
                this.hHJ.yx();
            }
            AppMethodBeat.o(134667);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$SurfaceAvailableListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "request", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;)V", "getRequest", "()Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-appbrand-integration_release"})
    static final class c implements SurfaceTextureListener {
        private final b hHH;

        public c(b bVar) {
            j.p(bVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            AppMethodBeat.i(134666);
            this.hHH = bVar;
            AppMethodBeat.o(134666);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.i(134665);
            b bVar = this.hHH;
            bVar.hHE = true;
            if (bVar.hHF != null) {
                bVar.aDt();
            }
            AppMethodBeat.o(134665);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "", "id", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;I)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;)V", "getId", "()I", "", "isViewReady", "()Z", "setViewReady", "(Z)V", "invoke", "", "plugin-appbrand-integration_release"})
    final class b {
        boolean hHE;
        com.tencent.mm.plugin.appbrand.jsapi.base.g hHF;
        private final int id;

        public b(int i) {
            this.id = i;
        }

        /* Access modifiers changed, original: final */
        public final void aDt() {
            AppMethodBeat.i(134664);
            if (this.hHE) {
                com.tencent.mm.plugin.appbrand.jsapi.base.g gVar = this.hHF;
                if (gVar == null) {
                    j.dWJ();
                }
                gVar.AR(g.this.AK("ok"));
                g.this.hHC.remove(Integer.valueOf(this.id));
                com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.id + ']');
                AppMethodBeat.o(134664);
                return;
            }
            Throwable illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(134664);
            throw illegalStateException;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onViewWillDisappear"})
    static final class f implements com.tencent.mm.plugin.appbrand.jsapi.f.f {
        final /* synthetic */ MBRuntime hHI;
        final /* synthetic */ com.tencent.magicbrush.b hHJ;

        f(MBRuntime mBRuntime, com.tencent.magicbrush.b bVar) {
            this.hHI = mBRuntime;
            this.hHJ = bVar;
        }

        public final void aCf() {
            AppMethodBeat.i(134669);
            com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "disappear");
            com.tencent.magicbrush.c.b mBRuntimeView = this.hHI.getMBRuntimeView();
            if (mBRuntimeView != null && j.j(mBRuntimeView, this.hHJ.getTextureView())) {
                com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "disappear, really");
                this.hHI.setMBRuntimeView(null);
            }
            AppMethodBeat.o(134669);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onDestroy"})
    static final class g implements com.tencent.mm.plugin.appbrand.jsapi.f.c {
        final /* synthetic */ MBRuntime hHI;
        final /* synthetic */ com.tencent.magicbrush.b hHJ;

        g(MBRuntime mBRuntime, com.tencent.magicbrush.b bVar) {
            this.hHI = mBRuntime;
            this.hHJ = bVar;
        }

        public final void onDestroy() {
            AppMethodBeat.i(134670);
            com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "destroy");
            com.tencent.magicbrush.c.b mBRuntimeView = this.hHI.getMBRuntimeView();
            if (mBRuntimeView != null && j.j(mBRuntimeView, this.hHJ.getTextureView())) {
                com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "destroy, really");
                this.hHI.setMBRuntimeView(null);
            }
            AppMethodBeat.o(134670);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onBackground"})
    static final class e implements com.tencent.mm.plugin.appbrand.jsapi.f.b {
        final /* synthetic */ MBRuntime hHI;
        final /* synthetic */ com.tencent.magicbrush.b hHJ;

        e(MBRuntime mBRuntime, com.tencent.magicbrush.b bVar) {
            this.hHI = mBRuntime;
            this.hHJ = bVar;
        }

        public final void wW() {
            AppMethodBeat.i(134668);
            com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "background");
            com.tencent.magicbrush.c.b mBRuntimeView = this.hHI.getMBRuntimeView();
            if (mBRuntimeView != null && j.j(mBRuntimeView, this.hHJ.getTextureView())) {
                com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "background, really");
                this.hHJ.yy();
            }
            AppMethodBeat.o(134668);
        }
    }

    static {
        AppMethodBeat.i(134675);
        AppMethodBeat.o(134675);
    }

    public g() {
        AppMethodBeat.i(134674);
        AppMethodBeat.o(134674);
    }

    public final /* synthetic */ View a(com.tencent.mm.plugin.appbrand.jsapi.e eVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(134671);
        w wVar = (w) eVar;
        j.p(wVar, "component");
        j.p(jSONObject, "data");
        com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + i + ']');
        s atK = wVar.atK();
        if (atK != null) {
            MBRuntime aum = atK.aum();
            if (aum != null) {
                j.o(aum, "component.service?.magicBrush ?: return null");
                if (aum.getMBRuntimeView() != null) {
                    com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + i + "], failed");
                    AppMethodBeat.o(134671);
                    return null;
                }
                b bVar = new b(i);
                this.hHC.put(Integer.valueOf(i), bVar);
                com.tencent.magicbrush.b bVar2 = new com.tencent.magicbrush.b(wVar.getContext());
                bVar2.setSurfaceTextureListener(new c(bVar));
                bVar2.setMBRuntime(aum);
                wVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.d) new d(aum, bVar2));
                if (wVar.aJt()) {
                    com.tencent.luggage.g.d.i("JsApiInsertHTMLCanvasElement", "manually foreground");
                    bVar2.yx();
                }
                wVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.b) new e(aum, bVar2));
                wVar.iqN.a((com.tencent.mm.plugin.appbrand.jsapi.f.f) new f(aum, bVar2));
                wVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.c) new g(aum, bVar2));
                View view = bVar2;
                AppMethodBeat.o(134671);
                return view;
            }
        }
        AppMethodBeat.o(134671);
        return null;
    }

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.e eVar, int i, View view, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.jsapi.base.g gVar) {
        AppMethodBeat.i(138155);
        j.p((w) eVar, "component");
        j.p(view, "view");
        j.p(jSONObject, "data");
        j.p(gVar, "callback");
        Object obj = this.hHC.get(Integer.valueOf(i));
        if (obj == null) {
            j.dWJ();
        }
        b bVar = (b) obj;
        if ((gVar != null ? 1 : null) == null) {
            Throwable illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(138155);
            throw illegalStateException;
        }
        bVar.hHF = gVar;
        if (bVar.hHE) {
            bVar.aDt();
        }
        AppMethodBeat.o(138155);
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(134672);
        j.p(jSONObject, "data");
        int i = jSONObject.getInt("canvasId");
        AppMethodBeat.o(134672);
        return i;
    }

    public final boolean aCE() {
        return true;
    }
}
