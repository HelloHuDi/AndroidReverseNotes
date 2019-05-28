package com.tencent.p177mm.media.widget.camerarecordview.preview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.p255h.p1204a.C18593b;
import com.tencent.p177mm.media.p255h.p1204a.C32759a;
import com.tencent.p177mm.media.widget.camerarecordview.preview.p870a.C16538b;
import com.tencent.p177mm.media.widget.camerarecordview.preview.p870a.C26396c;
import com.tencent.p177mm.media.widget.camerarecordview.preview.p870a.C9627a;
import com.tencent.p177mm.media.widget.camerarecordview.preview.p870a.C9627a.C9629a;
import com.tencent.p177mm.media.widget.p868a.C32765b;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0016\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J-\u0010\u001c\u001a\u00020\u000f2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0016J \u0010%\u001a\u00020\u000f2\u0016\u0010&\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "canPreview", "", "frameRotate", "", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTextureId", "queueEvent", "r", "Lkotlin/Function0;", "release", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView */
public final class CameraPreviewGLSurfaceView extends GLSurfaceView implements C1791c {
    public static final C26395a fch = new C26395a();
    private C17126b<? super SurfaceTexture, C37091y> fcd;
    private C9627a fce;
    private int fcf;
    private boolean fcg;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView$a */
    public static final class C26395a {
        private C26395a() {
        }

        public /* synthetic */ C26395a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView$1", "Landroid/opengl/GLSurfaceView$Renderer;", "onDrawFrame", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView$1 */
    public static final class C421771 implements Renderer {
        final /* synthetic */ CameraPreviewGLSurfaceView fci;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView$1$a */
        static final class C1790a extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ int eXr;
            final /* synthetic */ int eXs;
            final /* synthetic */ C421771 fcj;
            final /* synthetic */ GL10 fck;

            C1790a(C421771 c421771, GL10 gl10, int i, int i2) {
                this.fcj = c421771;
                this.fck = gl10;
                this.eXr = i;
                this.eXs = i2;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                Object obj = null;
                AppMethodBeat.m2504i(13267);
                C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "previewController initRender  " + (this.fcj.fci.fcd == null), new Object[0]);
                C9627a a = this.fcj.fci.fce;
                if (a != null) {
                    GL10 gl10 = this.fck;
                    int i = this.eXr;
                    int i2 = this.eXs;
                    C37897a c37897a = a.eXm;
                    if (c37897a != null) {
                        c37897a.onSurfaceChanged(gl10, i, i2);
                    }
                }
                this.fcj.fci.fcg = true;
                if (this.fcj.fci.fcd != null) {
                    Object surfaceTexture;
                    String str = "MicroMsg.CameraPreviewGLSurfaceView";
                    StringBuilder stringBuilder = new StringBuilder("callback.invoke  ");
                    a = this.fcj.fci.fce;
                    if (a != null) {
                        surfaceTexture = a.getSurfaceTexture();
                    } else {
                        surfaceTexture = null;
                    }
                    C4990ab.m7409c(str, stringBuilder.append(surfaceTexture).toString(), new Object[0]);
                    C17126b c = this.fcj.fci.fcd;
                    if (c != null) {
                        C9627a a2 = this.fcj.fci.fce;
                        if (a2 != null) {
                            obj = a2.getSurfaceTexture();
                        }
                        c.mo50am(obj);
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(13267);
                return c37091y;
            }
        }

        C421771(CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView) {
            this.fci = cameraPreviewGLSurfaceView;
        }

        public final void onDrawFrame(GL10 gl10) {
            AppMethodBeat.m2504i(13268);
            C9627a a = this.fci.fce;
            if (a != null) {
                C37897a c37897a = a.eXm;
                if (c37897a != null) {
                    c37897a.onDrawFrame(gl10);
                    AppMethodBeat.m2505o(13268);
                    return;
                }
                AppMethodBeat.m2505o(13268);
                return;
            }
            AppMethodBeat.m2505o(13268);
        }

        public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
            AppMethodBeat.m2504i(13269);
            C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceChanged width:" + i + " height:" + i2, new Object[0]);
            C9627a a = this.fci.fce;
            if (a != null) {
                C31214a c1790a = new C1790a(this, gl10, i, i2);
                a.fcu.mo5344c(new C9629a(a, c1790a, this.fci.fcf));
                AppMethodBeat.m2505o(13269);
                return;
            }
            AppMethodBeat.m2505o(13269);
        }

        public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            AppMethodBeat.m2504i(13270);
            C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceCreated", new Object[0]);
            C9627a a = this.fci.fce;
            if (a != null) {
                C37897a c37897a = a.eXm;
                if (c37897a != null) {
                    c37897a.onSurfaceCreated(gl10, eGLConfig);
                    AppMethodBeat.m2505o(13270);
                    return;
                }
                AppMethodBeat.m2505o(13270);
                return;
            }
            AppMethodBeat.m2505o(13270);
        }
    }

    static {
        AppMethodBeat.m2504i(13282);
        AppMethodBeat.m2505o(13282);
    }

    public CameraPreviewGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(13281);
        getHolder().addCallback(this);
        try {
            getHolder().setType(2);
        } catch (Exception e) {
            try {
                getHolder().setType(1);
            } catch (Exception e2) {
                try {
                    getHolder().setType(0);
                } catch (Exception e3) {
                }
            }
        }
        setEGLContextFactory(new C18593b());
        setEGLContextClientVersion(2);
        setEGLConfigChooser(new C32759a());
        setPreserveEGLContextOnPause(false);
        setRenderer(new C421771(this));
        setRenderMode(0);
        C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "init create CameraPreviewGLSurfaceView", new Object[0]);
        AppMethodBeat.m2505o(13281);
    }

    /* renamed from: a */
    public final void mo5341a(C37897a c37897a, boolean z) {
        AppMethodBeat.m2504i(13272);
        C25052j.m39376p(c37897a, "renderer");
        C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "setPreviewRenderer cpuCrop:".concat(String.valueOf(z)), new Object[0]);
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            c9627a.release();
        }
        if (z) {
            c9627a = new C16538b(this);
        } else {
            c9627a = new C26396c(this);
        }
        this.fce = c9627a;
        c9627a = this.fce;
        if (c9627a != null) {
            c9627a.mo20948a(c37897a);
            AppMethodBeat.m2505o(13272);
            return;
        }
        AppMethodBeat.m2505o(13272);
    }

    /* renamed from: a */
    public final void mo5342a(C32765b c32765b) {
        AppMethodBeat.m2504i(13273);
        C25052j.m39376p(c32765b, "cameraConfig");
        C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig:".concat(String.valueOf(c32765b)), new Object[0]);
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            c9627a.mo20949a(c32765b);
            AppMethodBeat.m2505o(13273);
            return;
        }
        AppMethodBeat.m2505o(13273);
    }

    /* renamed from: b */
    public final void mo5343b(C17126b<? super SurfaceTexture, C37091y> c17126b) {
        Object obj = null;
        AppMethodBeat.m2504i(13274);
        C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "tryCameraPreview  canPreview:" + this.fcg, new Object[0]);
        if (this.fcg) {
            String str = "MicroMsg.CameraPreviewGLSurfaceView";
            StringBuilder stringBuilder = new StringBuilder("callback.invoke  ");
            C9627a c9627a = this.fce;
            C4990ab.m7409c(str, stringBuilder.append(c9627a != null ? c9627a.getSurfaceTexture() : null).toString(), new Object[0]);
            c9627a = this.fce;
            if (c9627a != null) {
                obj = c9627a.getSurfaceTexture();
            }
            c17126b.mo50am(obj);
            AppMethodBeat.m2505o(13274);
            return;
        }
        this.fcd = c17126b;
        AppMethodBeat.m2505o(13274);
    }

    /* renamed from: WA */
    public final void mo5339WA() {
        AppMethodBeat.m2504i(13275);
        C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "tryStopCameraPreview", new Object[0]);
        this.fcg = false;
        this.fcd = null;
        AppMethodBeat.m2505o(13275);
    }

    public final void setOnDrawListener(C17126b<? super Integer, C37091y> c17126b) {
        AppMethodBeat.m2504i(13276);
        C4990ab.m7409c("MicroMsg.CameraPreviewGLSurfaceView", "setOnDrawListener", new Object[0]);
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            c9627a.fct = c17126b;
            AppMethodBeat.m2505o(13276);
            return;
        }
        AppMethodBeat.m2505o(13276);
    }

    public final int getPreviewTextureId() {
        C9627a c9627a = this.fce;
        if (c9627a == null) {
            return -1;
        }
        C37897a c37897a = c9627a.eXm;
        if (c37897a != null) {
            return c37897a.eYN;
        }
        return -1;
    }

    public final EGLContext getEGLContext() {
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            return c9627a.fag;
        }
        return null;
    }

    public final void release() {
        AppMethodBeat.m2504i(13277);
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            c9627a.release();
            AppMethodBeat.m2505o(13277);
            return;
        }
        AppMethodBeat.m2505o(13277);
    }

    /* renamed from: WB */
    public final void mo5340WB() {
        AppMethodBeat.m2504i(13278);
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            c9627a.mo20947WB();
            AppMethodBeat.m2505o(13278);
            return;
        }
        AppMethodBeat.m2505o(13278);
    }

    public final C39387f getFrameDataCallback() {
        AppMethodBeat.m2504i(13279);
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            C39387f frameDataCallback = c9627a.getFrameDataCallback();
            AppMethodBeat.m2505o(13279);
            return frameDataCallback;
        }
        AppMethodBeat.m2505o(13279);
        return null;
    }

    /* renamed from: c */
    public final void mo5344c(C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(13280);
        C25052j.m39376p(c31214a, "r");
        queueEvent(new C32769a(c31214a));
        AppMethodBeat.m2505o(13280);
    }
}
