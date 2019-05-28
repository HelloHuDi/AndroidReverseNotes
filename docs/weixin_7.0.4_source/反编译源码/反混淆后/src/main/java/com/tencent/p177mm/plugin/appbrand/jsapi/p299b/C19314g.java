package com.tencent.p177mm.plugin.appbrand.jsapi.p299b;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.magicbrush.C32197b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.p149c.C1006b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C38290f;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C26932g;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import java.util.HashMap;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0015R2\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007R\u00020\u00000\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u0007R\u00020\u0000`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseInsertViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "requestMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lkotlin/collections/HashMap;", "getViewId", "data", "Lorg/json/JSONObject;", "inflateView", "Landroid/view/View;", "component", "viewId", "isAsyncCallback", "", "onInsertViewWithAsyncCallback", "", "view", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "Companion", "Request", "SurfaceAvailableListener", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.g */
public final class C19314g extends C45577a<C27242w> {
    public static final int CTRL_INDEX = 594;
    public static final String NAME = "insertWebGLCanvas";
    public static final C19313a hHD = new C19313a();
    private final HashMap<Integer, C19315b> hHC = new HashMap();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onForeground"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.g$d */
    static final class C2230d implements C10381d {
        final /* synthetic */ MBRuntime hHI;
        final /* synthetic */ C32197b hHJ;

        C2230d(MBRuntime mBRuntime, C32197b c32197b) {
            this.hHI = mBRuntime;
            this.hHJ = c32197b;
        }

        /* renamed from: wU */
        public final void mo6095wU() {
            AppMethodBeat.m2504i(134667);
            C45124d.m82929i("JsApiInsertHTMLCanvasElement", "foreground");
            C1006b mBRuntimeView = this.hHI.getMBRuntimeView();
            if (mBRuntimeView != null && C25052j.m39373j(mBRuntimeView, this.hHJ.getTextureView())) {
                C45124d.m82929i("JsApiInsertHTMLCanvasElement", "foreground, really");
                this.hHJ.mo52862yx();
            }
            AppMethodBeat.m2505o(134667);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$SurfaceAvailableListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "request", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;)V", "getRequest", "()Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.g$c */
    static final class C10331c implements SurfaceTextureListener {
        private final C19315b hHH;

        public C10331c(C19315b c19315b) {
            C25052j.m39376p(c19315b, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            AppMethodBeat.m2504i(134666);
            this.hHH = c19315b;
            AppMethodBeat.m2505o(134666);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(134665);
            C19315b c19315b = this.hHH;
            c19315b.hHE = true;
            if (c19315b.hHF != null) {
                c19315b.aDt();
            }
            AppMethodBeat.m2505o(134665);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.g$a */
    public static final class C19313a {
        private C19313a() {
        }

        public /* synthetic */ C19313a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "", "id", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;I)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;)V", "getId", "()I", "", "isViewReady", "()Z", "setViewReady", "(Z)V", "invoke", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.g$b */
    final class C19315b {
        boolean hHE;
        C26932g hHF;
        /* renamed from: id */
        private final int f4350id;

        public C19315b(int i) {
            this.f4350id = i;
        }

        /* Access modifiers changed, original: final */
        public final void aDt() {
            AppMethodBeat.m2504i(134664);
            if (this.hHE) {
                C26932g c26932g = this.hHF;
                if (c26932g == null) {
                    C25052j.dWJ();
                }
                c26932g.mo44674AR(C19314g.this.mo73392AK("ok"));
                C19314g.this.hHC.remove(Integer.valueOf(this.f4350id));
                C45124d.m82929i("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.f4350id + ']');
                AppMethodBeat.m2505o(134664);
                return;
            }
            Throwable illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.m2505o(134664);
            throw illegalStateException;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onViewWillDisappear"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.g$f */
    static final class C19316f implements C38290f {
        final /* synthetic */ MBRuntime hHI;
        final /* synthetic */ C32197b hHJ;

        C19316f(MBRuntime mBRuntime, C32197b c32197b) {
            this.hHI = mBRuntime;
            this.hHJ = c32197b;
        }

        public final void aCf() {
            AppMethodBeat.m2504i(134669);
            C45124d.m82929i("JsApiInsertHTMLCanvasElement", "disappear");
            C1006b mBRuntimeView = this.hHI.getMBRuntimeView();
            if (mBRuntimeView != null && C25052j.m39373j(mBRuntimeView, this.hHJ.getTextureView())) {
                C45124d.m82929i("JsApiInsertHTMLCanvasElement", "disappear, really");
                this.hHI.setMBRuntimeView(null);
            }
            AppMethodBeat.m2505o(134669);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onDestroy"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.g$g */
    static final class C19317g implements C10380c {
        final /* synthetic */ MBRuntime hHI;
        final /* synthetic */ C32197b hHJ;

        C19317g(MBRuntime mBRuntime, C32197b c32197b) {
            this.hHI = mBRuntime;
            this.hHJ = c32197b;
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(134670);
            C45124d.m82929i("JsApiInsertHTMLCanvasElement", "destroy");
            C1006b mBRuntimeView = this.hHI.getMBRuntimeView();
            if (mBRuntimeView != null && C25052j.m39373j(mBRuntimeView, this.hHJ.getTextureView())) {
                C45124d.m82929i("JsApiInsertHTMLCanvasElement", "destroy, really");
                this.hHI.setMBRuntimeView(null);
            }
            AppMethodBeat.m2505o(134670);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onBackground"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.g$e */
    static final class C19318e implements C10379b {
        final /* synthetic */ MBRuntime hHI;
        final /* synthetic */ C32197b hHJ;

        C19318e(MBRuntime mBRuntime, C32197b c32197b) {
            this.hHI = mBRuntime;
            this.hHJ = c32197b;
        }

        /* renamed from: wW */
        public final void mo21857wW() {
            AppMethodBeat.m2504i(134668);
            C45124d.m82929i("JsApiInsertHTMLCanvasElement", "background");
            C1006b mBRuntimeView = this.hHI.getMBRuntimeView();
            if (mBRuntimeView != null && C25052j.m39373j(mBRuntimeView, this.hHJ.getTextureView())) {
                C45124d.m82929i("JsApiInsertHTMLCanvasElement", "background, really");
                this.hHJ.mo52863yy();
            }
            AppMethodBeat.m2505o(134668);
        }
    }

    static {
        AppMethodBeat.m2504i(134675);
        AppMethodBeat.m2505o(134675);
    }

    public C19314g() {
        AppMethodBeat.m2504i(134674);
        AppMethodBeat.m2505o(134674);
    }

    /* renamed from: a */
    public final /* synthetic */ View mo34491a(C33303e c33303e, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(134671);
        C27242w c27242w = (C27242w) c33303e;
        C25052j.m39376p(c27242w, "component");
        C25052j.m39376p(jSONObject, "data");
        C45124d.m82929i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + i + ']');
        C19722s atK = c27242w.atK();
        if (atK != null) {
            MBRuntime aum = atK.aum();
            if (aum != null) {
                C25052j.m39375o(aum, "component.service?.magicBrush ?: return null");
                if (aum.getMBRuntimeView() != null) {
                    C45124d.m82929i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + i + "], failed");
                    AppMethodBeat.m2505o(134671);
                    return null;
                }
                C19315b c19315b = new C19315b(i);
                this.hHC.put(Integer.valueOf(i), c19315b);
                C32197b c32197b = new C32197b(c27242w.getContext());
                c32197b.setSurfaceTextureListener(new C10331c(c19315b));
                c32197b.setMBRuntime(aum);
                c27242w.mo53829a((C10381d) new C2230d(aum, c32197b));
                if (c27242w.aJt()) {
                    C45124d.m82929i("JsApiInsertHTMLCanvasElement", "manually foreground");
                    c32197b.mo52862yx();
                }
                c27242w.mo53827a((C10379b) new C19318e(aum, c32197b));
                c27242w.iqN.mo53831a((C38290f) new C19316f(aum, c32197b));
                c27242w.mo53828a((C10380c) new C19317g(aum, c32197b));
                View view = c32197b;
                AppMethodBeat.m2505o(134671);
                return view;
            }
        }
        AppMethodBeat.m2505o(134671);
        return null;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo6127a(C33303e c33303e, int i, View view, JSONObject jSONObject, C26932g c26932g) {
        AppMethodBeat.m2504i(138155);
        C25052j.m39376p((C27242w) c33303e, "component");
        C25052j.m39376p(view, "view");
        C25052j.m39376p(jSONObject, "data");
        C25052j.m39376p(c26932g, "callback");
        Object obj = this.hHC.get(Integer.valueOf(i));
        if (obj == null) {
            C25052j.dWJ();
        }
        C19315b c19315b = (C19315b) obj;
        if ((c26932g != null ? 1 : null) == null) {
            Throwable illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.m2505o(138155);
            throw illegalStateException;
        }
        c19315b.hHF = c26932g;
        if (c19315b.hHE) {
            c19315b.aDt();
        }
        AppMethodBeat.m2505o(138155);
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(134672);
        C25052j.m39376p(jSONObject, "data");
        int i = jSONObject.getInt("canvasId");
        AppMethodBeat.m2505o(134672);
        return i;
    }

    public final boolean aCE() {
        return true;
    }
}
