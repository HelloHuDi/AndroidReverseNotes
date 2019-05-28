package com.tencent.p177mm.media.widget.camerarecordview.preview.p870a;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.widget.camerarecordview.preview.C1791c;
import com.tencent.p177mm.media.widget.p868a.C32765b;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\rJ\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010 \u001a\u00020\tJ(\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\t2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010&J\u0010\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)J \u0010*\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tJ\u001a\u0010-\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010.\u001a\u0004\u0018\u00010/J\u0006\u00100\u001a\u00020\rJ-\u00101\u001a\u00020\r2#\u00102\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u000e\u00104\u001a\u00020\r2\u0006\u00105\u001a\u000206R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0004¨\u00067"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "eglContext", "Landroid/opengl/EGLContext;", "frameDrawCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "texture", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "setView", "clearFrame", "drawFrame", "data", "", "getEGLContext", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getTextureId", "initRender", "createSurfaceTexture", "", "frameRotate", "afterInitRender", "Lkotlin/Function0;", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setOnDrawListener", "frameAvailableListener", "setRender", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.a.a */
public abstract class C9627a {
    public C37897a eXm;
    public EGLContext fag;
    public C17126b<? super Integer, C37091y> fct;
    public C1791c fcu;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.a.a$c */
    static final class C9628c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9627a fcv;
        final /* synthetic */ C37897a fcz;

        C9628c(C9627a c9627a, C37897a c37897a) {
            this.fcv = c9627a;
            this.fcz = c37897a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13309);
            C17126b c17126b = this.fcv.fct;
            if (c17126b != null) {
                c17126b.mo50am(Integer.valueOf(this.fcz.eYN));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13309);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.a.a$a */
    public static final class C9629a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9627a fcv;
        final /* synthetic */ C31214a fcw;
        final /* synthetic */ boolean fcx = true;
        final /* synthetic */ int fcy;

        public C9629a(C9627a c9627a, C31214a c31214a, int i) {
            this.fcv = c9627a;
            this.fcw = c31214a;
            this.fcy = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13307);
            C37897a c37897a = this.fcv.eXm;
            C31214a c31214a;
            if (c37897a == null || !c37897a.eYV) {
                c37897a = this.fcv.eXm;
                if (c37897a != null) {
                    c37897a.release();
                }
                C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "initRender, generateExternalTexture: " + this.fcx, new Object[0]);
                c37897a = this.fcv.eXm;
                if (c37897a != null) {
                    c37897a.mo60643cs(this.fcx);
                }
                c37897a = this.fcv.eXm;
                if (c37897a != null) {
                    c37897a.eYR = this.fcy;
                }
                this.fcv.fag = EGL14.eglGetCurrentContext();
                c31214a = this.fcw;
                if (c31214a != null) {
                    c31214a.invoke();
                }
            } else {
                c31214a = this.fcw;
                if (c31214a != null) {
                    c31214a.invoke();
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13307);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.a.a$b */
    static final class C9630b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9627a fcv;

        C9630b(C9627a c9627a) {
            this.fcv = c9627a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13308);
            C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "release", new Object[0]);
            C37897a c37897a = this.fcv.eXm;
            if (c37897a != null) {
                c37897a.release();
            }
            this.fcv.fag = null;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13308);
            return c37091y;
        }
    }

    public C9627a(C1791c c1791c) {
        C25052j.m39376p(c1791c, "view");
        this.fcu = c1791c;
    }

    public C39387f getFrameDataCallback() {
        return null;
    }

    /* renamed from: a */
    public void mo20948a(C37897a c37897a) {
        C25052j.m39376p(c37897a, "renderer");
        this.eXm = c37897a;
        C37897a c37897a2 = this.eXm;
        if (c37897a2 != null) {
            c37897a2.eYU = new C9628c(this, c37897a);
        }
    }

    /* renamed from: a */
    public final void mo20949a(C32765b c32765b) {
        C25052j.m39376p(c32765b, "cameraConfig");
        C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig: ".concat(String.valueOf(c32765b)), new Object[0]);
        Point Wm = C32765b.m53506Wm();
        C37897a c37897a = this.eXm;
        if (c37897a != null) {
            c37897a.mo60641ch(Wm.x, Wm.y);
        }
        C37897a c37897a2 = this.eXm;
        if (c37897a2 != null) {
            c37897a2.mo60646ka(C32765b.m53502Wi());
        }
        c37897a2 = this.eXm;
        if (c37897a2 != null) {
            c37897a2.mo60644ct(C32765b.m53505Wl());
        }
    }

    public final SurfaceTexture getSurfaceTexture() {
        C37897a c37897a = this.eXm;
        if (c37897a != null) {
            return c37897a.bsb;
        }
        return null;
    }

    /* renamed from: WB */
    public final void mo20947WB() {
        C37897a c37897a = this.eXm;
        if (c37897a != null) {
            c37897a.eYO = true;
        }
    }

    public final void release() {
        this.fcu.mo5344c(new C9630b(this));
    }
}
