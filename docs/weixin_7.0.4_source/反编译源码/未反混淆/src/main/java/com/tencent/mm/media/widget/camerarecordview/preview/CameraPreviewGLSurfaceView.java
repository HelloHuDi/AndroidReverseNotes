package com.tencent.mm.media.widget.camerarecordview.preview;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.a.c;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(dWo = {1, 1, 13}, dWp = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0016\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J-\u0010\u001c\u001a\u00020\u000f2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0016J \u0010%\u001a\u00020\u000f2\u0016\u0010&\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "canPreview", "", "frameRotate", "", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTextureId", "queueEvent", "r", "Lkotlin/Function0;", "release", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public final class CameraPreviewGLSurfaceView extends GLSurfaceView implements c {
    public static final a fch = new a();
    private b<? super SurfaceTexture, y> fcd;
    private com.tencent.mm.media.widget.camerarecordview.preview.a.a fce;
    private int fcf;
    private boolean fcg;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView$1", "Landroid/opengl/GLSurfaceView$Renderer;", "onDrawFrame", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView$1 */
    public static final class AnonymousClass1 implements Renderer {
        final /* synthetic */ CameraPreviewGLSurfaceView fci;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends k implements a.f.a.a<y> {
            final /* synthetic */ int eXr;
            final /* synthetic */ int eXs;
            final /* synthetic */ AnonymousClass1 fcj;
            final /* synthetic */ GL10 fck;

            a(AnonymousClass1 anonymousClass1, GL10 gl10, int i, int i2) {
                this.fcj = anonymousClass1;
                this.fck = gl10;
                this.eXr = i;
                this.eXs = i2;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                Object obj = null;
                AppMethodBeat.i(13267);
                ab.c("MicroMsg.CameraPreviewGLSurfaceView", "previewController initRender  " + (this.fcj.fci.fcd == null), new Object[0]);
                com.tencent.mm.media.widget.camerarecordview.preview.a.a a = this.fcj.fci.fce;
                if (a != null) {
                    GL10 gl10 = this.fck;
                    int i = this.eXr;
                    int i2 = this.eXs;
                    com.tencent.mm.media.h.a aVar = a.eXm;
                    if (aVar != null) {
                        aVar.onSurfaceChanged(gl10, i, i2);
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
                    ab.c(str, stringBuilder.append(surfaceTexture).toString(), new Object[0]);
                    b c = this.fcj.fci.fcd;
                    if (c != null) {
                        com.tencent.mm.media.widget.camerarecordview.preview.a.a a2 = this.fcj.fci.fce;
                        if (a2 != null) {
                            obj = a2.getSurfaceTexture();
                        }
                        c.am(obj);
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(13267);
                return yVar;
            }
        }

        AnonymousClass1(CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView) {
            this.fci = cameraPreviewGLSurfaceView;
        }

        public final void onDrawFrame(GL10 gl10) {
            AppMethodBeat.i(13268);
            com.tencent.mm.media.widget.camerarecordview.preview.a.a a = this.fci.fce;
            if (a != null) {
                com.tencent.mm.media.h.a aVar = a.eXm;
                if (aVar != null) {
                    aVar.onDrawFrame(gl10);
                    AppMethodBeat.o(13268);
                    return;
                }
                AppMethodBeat.o(13268);
                return;
            }
            AppMethodBeat.o(13268);
        }

        public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
            AppMethodBeat.i(13269);
            ab.c("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceChanged width:" + i + " height:" + i2, new Object[0]);
            com.tencent.mm.media.widget.camerarecordview.preview.a.a a = this.fci.fce;
            if (a != null) {
                a.f.a.a aVar = new a(this, gl10, i, i2);
                a.fcu.c(new com.tencent.mm.media.widget.camerarecordview.preview.a.a.a(a, aVar, this.fci.fcf));
                AppMethodBeat.o(13269);
                return;
            }
            AppMethodBeat.o(13269);
        }

        public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            AppMethodBeat.i(13270);
            ab.c("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceCreated", new Object[0]);
            com.tencent.mm.media.widget.camerarecordview.preview.a.a a = this.fci.fce;
            if (a != null) {
                com.tencent.mm.media.h.a aVar = a.eXm;
                if (aVar != null) {
                    aVar.onSurfaceCreated(gl10, eGLConfig);
                    AppMethodBeat.o(13270);
                    return;
                }
                AppMethodBeat.o(13270);
                return;
            }
            AppMethodBeat.o(13270);
        }
    }

    static {
        AppMethodBeat.i(13282);
        AppMethodBeat.o(13282);
    }

    public CameraPreviewGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(13281);
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
        setEGLContextFactory(new com.tencent.mm.media.h.a.b());
        setEGLContextClientVersion(2);
        setEGLConfigChooser(new com.tencent.mm.media.h.a.a());
        setPreserveEGLContextOnPause(false);
        setRenderer(new AnonymousClass1(this));
        setRenderMode(0);
        ab.c("MicroMsg.CameraPreviewGLSurfaceView", "init create CameraPreviewGLSurfaceView", new Object[0]);
        AppMethodBeat.o(13281);
    }

    public final void a(com.tencent.mm.media.h.a aVar, boolean z) {
        AppMethodBeat.i(13272);
        j.p(aVar, "renderer");
        ab.c("MicroMsg.CameraPreviewGLSurfaceView", "setPreviewRenderer cpuCrop:".concat(String.valueOf(z)), new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.fce;
        if (aVar2 != null) {
            aVar2.release();
        }
        if (z) {
            aVar2 = new com.tencent.mm.media.widget.camerarecordview.preview.a.b(this);
        } else {
            aVar2 = new c(this);
        }
        this.fce = aVar2;
        aVar2 = this.fce;
        if (aVar2 != null) {
            aVar2.a(aVar);
            AppMethodBeat.o(13272);
            return;
        }
        AppMethodBeat.o(13272);
    }

    public final void a(com.tencent.mm.media.widget.a.b bVar) {
        AppMethodBeat.i(13273);
        j.p(bVar, "cameraConfig");
        ab.c("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig:".concat(String.valueOf(bVar)), new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar != null) {
            aVar.a(bVar);
            AppMethodBeat.o(13273);
            return;
        }
        AppMethodBeat.o(13273);
    }

    public final void b(b<? super SurfaceTexture, y> bVar) {
        Object obj = null;
        AppMethodBeat.i(13274);
        ab.c("MicroMsg.CameraPreviewGLSurfaceView", "tryCameraPreview  canPreview:" + this.fcg, new Object[0]);
        if (this.fcg) {
            String str = "MicroMsg.CameraPreviewGLSurfaceView";
            StringBuilder stringBuilder = new StringBuilder("callback.invoke  ");
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
            ab.c(str, stringBuilder.append(aVar != null ? aVar.getSurfaceTexture() : null).toString(), new Object[0]);
            aVar = this.fce;
            if (aVar != null) {
                obj = aVar.getSurfaceTexture();
            }
            bVar.am(obj);
            AppMethodBeat.o(13274);
            return;
        }
        this.fcd = bVar;
        AppMethodBeat.o(13274);
    }

    public final void WA() {
        AppMethodBeat.i(13275);
        ab.c("MicroMsg.CameraPreviewGLSurfaceView", "tryStopCameraPreview", new Object[0]);
        this.fcg = false;
        this.fcd = null;
        AppMethodBeat.o(13275);
    }

    public final void setOnDrawListener(b<? super Integer, y> bVar) {
        AppMethodBeat.i(13276);
        ab.c("MicroMsg.CameraPreviewGLSurfaceView", "setOnDrawListener", new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar != null) {
            aVar.fct = bVar;
            AppMethodBeat.o(13276);
            return;
        }
        AppMethodBeat.o(13276);
    }

    public final int getPreviewTextureId() {
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar == null) {
            return -1;
        }
        com.tencent.mm.media.h.a aVar2 = aVar.eXm;
        if (aVar2 != null) {
            return aVar2.eYN;
        }
        return -1;
    }

    public final EGLContext getEGLContext() {
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar != null) {
            return aVar.fag;
        }
        return null;
    }

    public final void release() {
        AppMethodBeat.i(13277);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar != null) {
            aVar.release();
            AppMethodBeat.o(13277);
            return;
        }
        AppMethodBeat.o(13277);
    }

    public final void WB() {
        AppMethodBeat.i(13278);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar != null) {
            aVar.WB();
            AppMethodBeat.o(13278);
            return;
        }
        AppMethodBeat.o(13278);
    }

    public final f getFrameDataCallback() {
        AppMethodBeat.i(13279);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar != null) {
            f frameDataCallback = aVar.getFrameDataCallback();
            AppMethodBeat.o(13279);
            return frameDataCallback;
        }
        AppMethodBeat.o(13279);
        return null;
    }

    public final void c(a.f.a.a<y> aVar) {
        AppMethodBeat.i(13280);
        j.p(aVar, "r");
        queueEvent(new a(aVar));
        AppMethodBeat.o(13280);
    }
}
