package com.tencent.mm.media.widget.camerarecordview.preview.a;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\rJ\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010 \u001a\u00020\tJ(\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\t2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010&J\u0010\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)J \u0010*\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tJ\u001a\u0010-\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010.\u001a\u0004\u0018\u00010/J\u0006\u00100\u001a\u00020\rJ-\u00101\u001a\u00020\r2#\u00102\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u000e\u00104\u001a\u00020\r2\u0006\u00105\u001a\u000206R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0004¨\u00067"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "eglContext", "Landroid/opengl/EGLContext;", "frameDrawCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "texture", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "setView", "clearFrame", "drawFrame", "data", "", "getEGLContext", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getTextureId", "initRender", "createSurfaceTexture", "", "frameRotate", "afterInitRender", "Lkotlin/Function0;", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setOnDrawListener", "frameAvailableListener", "setRender", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "plugin-mediaeditor_release"})
public abstract class a {
    public com.tencent.mm.media.h.a eXm;
    public EGLContext fag;
    public a.f.a.b<? super Integer, y> fct;
    public com.tencent.mm.media.widget.camerarecordview.preview.c fcu;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends k implements a.f.a.a<y> {
        final /* synthetic */ a fcv;
        final /* synthetic */ com.tencent.mm.media.h.a fcz;

        c(a aVar, com.tencent.mm.media.h.a aVar2) {
            this.fcv = aVar;
            this.fcz = aVar2;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13309);
            a.f.a.b bVar = this.fcv.fct;
            if (bVar != null) {
                bVar.am(Integer.valueOf(this.fcz.eYN));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13309);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ a fcv;
        final /* synthetic */ a.f.a.a fcw;
        final /* synthetic */ boolean fcx = true;
        final /* synthetic */ int fcy;

        public a(a aVar, a.f.a.a aVar2, int i) {
            this.fcv = aVar;
            this.fcw = aVar2;
            this.fcy = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13307);
            com.tencent.mm.media.h.a aVar = this.fcv.eXm;
            a.f.a.a aVar2;
            if (aVar == null || !aVar.eYV) {
                aVar = this.fcv.eXm;
                if (aVar != null) {
                    aVar.release();
                }
                ab.c("MicroMsg.CameraPreviewGLSurfaceView", "initRender, generateExternalTexture: " + this.fcx, new Object[0]);
                aVar = this.fcv.eXm;
                if (aVar != null) {
                    aVar.cs(this.fcx);
                }
                aVar = this.fcv.eXm;
                if (aVar != null) {
                    aVar.eYR = this.fcy;
                }
                this.fcv.fag = EGL14.eglGetCurrentContext();
                aVar2 = this.fcw;
                if (aVar2 != null) {
                    aVar2.invoke();
                }
            } else {
                aVar2 = this.fcw;
                if (aVar2 != null) {
                    aVar2.invoke();
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13307);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ a fcv;

        b(a aVar) {
            this.fcv = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13308);
            ab.c("MicroMsg.CameraPreviewGLSurfaceView", "release", new Object[0]);
            com.tencent.mm.media.h.a aVar = this.fcv.eXm;
            if (aVar != null) {
                aVar.release();
            }
            this.fcv.fag = null;
            y yVar = y.AUy;
            AppMethodBeat.o(13308);
            return yVar;
        }
    }

    public a(com.tencent.mm.media.widget.camerarecordview.preview.c cVar) {
        j.p(cVar, "view");
        this.fcu = cVar;
    }

    public f getFrameDataCallback() {
        return null;
    }

    public void a(com.tencent.mm.media.h.a aVar) {
        j.p(aVar, "renderer");
        this.eXm = aVar;
        com.tencent.mm.media.h.a aVar2 = this.eXm;
        if (aVar2 != null) {
            aVar2.eYU = new c(this, aVar);
        }
    }

    public final void a(com.tencent.mm.media.widget.a.b bVar) {
        j.p(bVar, "cameraConfig");
        ab.c("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig: ".concat(String.valueOf(bVar)), new Object[0]);
        Point Wm = com.tencent.mm.media.widget.a.b.Wm();
        com.tencent.mm.media.h.a aVar = this.eXm;
        if (aVar != null) {
            aVar.ch(Wm.x, Wm.y);
        }
        com.tencent.mm.media.h.a aVar2 = this.eXm;
        if (aVar2 != null) {
            aVar2.ka(com.tencent.mm.media.widget.a.b.Wi());
        }
        aVar2 = this.eXm;
        if (aVar2 != null) {
            aVar2.ct(com.tencent.mm.media.widget.a.b.Wl());
        }
    }

    public final SurfaceTexture getSurfaceTexture() {
        com.tencent.mm.media.h.a aVar = this.eXm;
        if (aVar != null) {
            return aVar.bsb;
        }
        return null;
    }

    public final void WB() {
        com.tencent.mm.media.h.a aVar = this.eXm;
        if (aVar != null) {
            aVar.eYO = true;
        }
    }

    public final void release() {
        this.fcu.c(new b(this));
    }
}
