package com.tencent.mm.media.widget.camerarecordview.preview;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001IB#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bB\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\b\u0010*\u001a\u00020\u0014H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0014H\u0002J\"\u00101\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u00010\u00132\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0016J\u0012\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u00107\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u00010\u00132\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0016J\u0016\u00108\u001a\u00020\u00142\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140#H\u0016J\b\u0010:\u001a\u00020\u0014H\u0002J\b\u0010;\u001a\u00020\u0014H\u0016J\b\u0010<\u001a\u00020\u0014H\u0016J-\u0010=\u001a\u00020\u00142#\u0010>\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0016J\u0018\u0010A\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u000eH\u0016J \u0010C\u001a\u00020\u00142\u0016\u0010D\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0016J\b\u0010E\u001a\u00020\u0014H\u0016J\u0010\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020HH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140#`$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTextureId", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public class CameraPreviewGLTextureView extends ObservableTextureView implements SurfaceTextureListener, c {
    public static final a fcq = new a();
    private Surface aOO;
    private HandlerThread eXa;
    private ak eXb;
    private com.tencent.mm.media.h.a eXm;
    private a.f.a.b<? super SurfaceTexture, y> fcd;
    private com.tencent.mm.media.widget.camerarecordview.preview.a.a fce;
    private boolean fcg;
    private com.tencent.mm.media.i.b.b fcl;
    private SurfaceTexture fcm;
    private int fcn;
    private int fco;
    private ArrayList<a.f.a.a<y>> fcp = new ArrayList();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends k implements a.f.a.a<y> {
        final /* synthetic */ CameraPreviewGLTextureView fcr;

        c(CameraPreviewGLTextureView cameraPreviewGLTextureView) {
            this.fcr = cameraPreviewGLTextureView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13284);
            com.tencent.mm.media.h.a renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.release();
            }
            com.tencent.mm.media.i.b.b c = this.fcr.fcl;
            if (c != null) {
                EGL14.eglDestroyContext(c.fae, c.fag);
                EGL14.eglDestroySurface(c.fae, c.faf);
                SurfaceTexture d = this.fcr.fcm;
                if (d != null) {
                    d.release();
                }
                CameraPreviewGLTextureView.e(this.fcr);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13284);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ int eXr;
        final /* synthetic */ int eXs;
        final /* synthetic */ CameraPreviewGLTextureView fcr;

        d(CameraPreviewGLTextureView cameraPreviewGLTextureView, int i, int i2) {
            this.fcr = cameraPreviewGLTextureView;
            this.eXr = i;
            this.eXs = i2;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13285);
            this.fcr.fcn = this.eXr;
            this.fcr.fco = this.eXs;
            com.tencent.mm.media.h.a renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.ci(this.fcr.fcn, this.fcr.fco);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13285);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ CameraPreviewGLTextureView fcr;

        e(CameraPreviewGLTextureView cameraPreviewGLTextureView) {
            this.fcr = cameraPreviewGLTextureView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13286);
            com.tencent.mm.media.widget.camerarecordview.preview.a.a i = this.fcr.fce;
            if (i != null) {
                SurfaceTexture surfaceTexture = i.getSurfaceTexture();
                if (surfaceTexture != null) {
                    surfaceTexture.updateTexImage();
                }
            }
            com.tencent.mm.media.h.a renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.onDrawFrame(null);
            }
            com.tencent.mm.media.i.b.b c = this.fcr.fcl;
            if (c != null) {
                EGLExt.eglPresentationTimeANDROID(c.fae, c.faf, System.nanoTime());
                EGL14.eglSwapBuffers(c.fae, c.faf);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13286);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView$onSurfaceTextureAvailable$1$1"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ int eVY;
        final /* synthetic */ int eVZ;
        final /* synthetic */ SurfaceTexture fbP;
        final /* synthetic */ CameraPreviewGLTextureView fcr;
        final /* synthetic */ SurfaceTexture fcs;

        b(SurfaceTexture surfaceTexture, CameraPreviewGLTextureView cameraPreviewGLTextureView, int i, int i2, SurfaceTexture surfaceTexture2) {
            this.fbP = surfaceTexture;
            this.fcr = cameraPreviewGLTextureView;
            this.eVY = i;
            this.eVZ = i2;
            this.fcs = surfaceTexture2;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object obj = null;
            AppMethodBeat.i(13283);
            this.fcr.fcm = this.fbP;
            this.fcr.fcn = this.eVY;
            this.fcr.fco = this.eVZ;
            this.fcr.aOO = new Surface(this.fcr.fcm);
            CameraPreviewGLTextureView cameraPreviewGLTextureView = this.fcr;
            com.tencent.mm.media.i.b.a aVar = com.tencent.mm.media.i.b.fad;
            cameraPreviewGLTextureView.fcl = com.tencent.mm.media.i.b.a.b(this.fcr.aOO, 0, 0);
            com.tencent.mm.media.h.a renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.onSurfaceCreated(null, null);
            }
            renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.ci(this.eVY, this.eVZ);
            }
            renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.cs(true);
            }
            CameraPreviewGLTextureView.a(this.fcr, this.fcs, this.eVY, this.eVZ);
            this.fcr.fcg = true;
            ab.i("MicroMsg.CameraPreviewGLTextureView", "previewCallback?.invoke");
            a.f.a.b h = this.fcr.fcd;
            if (h != null) {
                com.tencent.mm.media.widget.camerarecordview.preview.a.a i = this.fcr.fce;
                if (i != null) {
                    obj = i.getSurfaceTexture();
                }
                h.am(obj);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13283);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(13304);
        AppMethodBeat.o(13304);
    }

    public static final /* synthetic */ void a(CameraPreviewGLTextureView cameraPreviewGLTextureView, SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(13306);
        super.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        AppMethodBeat.o(13306);
    }

    public CameraPreviewGLTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(13301);
        setSurfaceTextureListener(this);
        WC();
        AppMethodBeat.o(13301);
    }

    public CameraPreviewGLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(13302);
        setSurfaceTextureListener(this);
        WC();
        AppMethodBeat.o(13302);
    }

    public CameraPreviewGLTextureView(Context context) {
        super(context);
        AppMethodBeat.i(13303);
        setSurfaceTextureListener(this);
        WC();
        AppMethodBeat.o(13303);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.media.h.a getRenderer() {
        return this.eXm;
    }

    /* Access modifiers changed, original: protected|final */
    public final void setRenderer(com.tencent.mm.media.h.a aVar) {
        this.eXm = aVar;
    }

    public final void a(com.tencent.mm.media.widget.a.b bVar) {
        AppMethodBeat.i(13288);
        j.p(bVar, "cameraConfig");
        ab.i("MicroMsg.CameraPreviewGLTextureView", "updateCameraConfig: ".concat(String.valueOf(bVar)));
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar != null) {
            aVar.a(bVar);
            AppMethodBeat.o(13288);
            return;
        }
        AppMethodBeat.o(13288);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(13289);
        super.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        ab.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:" + surfaceTexture + ", width:" + i + ", height:" + i2);
        c((a.f.a.a) new d(this, i, i2));
        AppMethodBeat.o(13289);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(13290);
        super.onSurfaceTextureDestroyed(surfaceTexture);
        ab.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
        this.fcg = false;
        c((a.f.a.a) new c(this));
        AppMethodBeat.o(13290);
        return false;
    }

    public final void release() {
        AppMethodBeat.i(13291);
        setSurfaceTextureListener(null);
        AppMethodBeat.o(13291);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(13292);
        ab.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:" + surfaceTexture + ", width:" + i + ", height:" + i2 + ", handler: " + this.eXb);
        if (this.eXb == null) {
            WC();
        }
        if (surfaceTexture != null) {
            c((a.f.a.a) new b(surfaceTexture, this, i, i2, surfaceTexture));
            AppMethodBeat.o(13292);
            return;
        }
        AppMethodBeat.o(13292);
    }

    public final void b(a.f.a.b<? super SurfaceTexture, y> bVar) {
        AppMethodBeat.i(13293);
        ab.c("MicroMsg.CameraPreviewGLTextureView", "tryCameraPreview canPreview:" + this.fcg, new Object[0]);
        if (this.fcg) {
            com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
            bVar.am(aVar != null ? aVar.getSurfaceTexture() : null);
            AppMethodBeat.o(13293);
            return;
        }
        this.fcd = bVar;
        AppMethodBeat.o(13293);
    }

    public final void WA() {
        AppMethodBeat.i(13294);
        ab.c("MicroMsg.CameraPreviewGLTextureView", "tryStopCameraPreview", new Object[0]);
        this.fcd = null;
        AppMethodBeat.o(13294);
    }

    public EGLContext getEGLContext() {
        com.tencent.mm.media.i.b.b bVar = this.fcl;
        if (bVar != null) {
            return bVar.fag;
        }
        return null;
    }

    public void setOnDrawListener(a.f.a.b<? super Integer, y> bVar) {
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar != null) {
            aVar.fct = bVar;
        }
    }

    public int getPreviewTextureId() {
        com.tencent.mm.media.h.a aVar = this.eXm;
        if (aVar != null) {
            return aVar.eYN;
        }
        return -1;
    }

    public final void a(com.tencent.mm.media.h.a aVar, boolean z) {
        AppMethodBeat.i(13295);
        j.p(aVar, "renderer");
        ab.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer:" + aVar.hashCode() + "  cpuCrop:" + z);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar2 = this.fce;
        if (aVar2 != null) {
            aVar2.release();
        }
        if (z) {
            aVar2 = new com.tencent.mm.media.widget.camerarecordview.preview.a.b(this);
        } else {
            aVar2 = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
        }
        this.fce = aVar2;
        aVar2 = this.fce;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
        this.eXm = aVar;
        AppMethodBeat.o(13295);
    }

    public void requestRender() {
        AppMethodBeat.i(13296);
        c((a.f.a.a) new e(this));
        AppMethodBeat.o(13296);
    }

    public final void c(a.f.a.a<y> aVar) {
        AppMethodBeat.i(13297);
        j.p(aVar, "r");
        if (this.eXb != null) {
            ak akVar = this.eXb;
            if (akVar != null) {
                akVar.post(new b(aVar));
                AppMethodBeat.o(13297);
                return;
            }
            AppMethodBeat.o(13297);
            return;
        }
        this.fcp.add(aVar);
        AppMethodBeat.o(13297);
    }

    public f getFrameDataCallback() {
        AppMethodBeat.i(13298);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar != null) {
            f frameDataCallback = aVar.getFrameDataCallback();
            AppMethodBeat.o(13298);
            return frameDataCallback;
        }
        AppMethodBeat.o(13298);
        return null;
    }

    public final void WB() {
        AppMethodBeat.i(13299);
        com.tencent.mm.media.widget.camerarecordview.preview.a.a aVar = this.fce;
        if (aVar != null) {
            aVar.WB();
            AppMethodBeat.o(13299);
            return;
        }
        AppMethodBeat.o(13299);
    }

    private final void WC() {
        AppMethodBeat.i(13300);
        HandlerThread ek = com.tencent.mm.sdk.g.d.ek("CameraPreviewTextureView_renderThread", -2);
        ek.start();
        this.eXb = new ak(ek.getLooper());
        ArrayList<a.f.a.a> arrayList = new ArrayList();
        arrayList.addAll(this.fcp);
        this.fcp.clear();
        for (a.f.a.a c : arrayList) {
            c(c);
        }
        this.eXa = ek;
        AppMethodBeat.o(13300);
    }

    public static final /* synthetic */ void e(CameraPreviewGLTextureView cameraPreviewGLTextureView) {
        AppMethodBeat.i(13305);
        HandlerThread handlerThread = cameraPreviewGLTextureView.eXa;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        cameraPreviewGLTextureView.eXa = null;
        cameraPreviewGLTextureView.eXb = null;
        AppMethodBeat.o(13305);
    }
}
