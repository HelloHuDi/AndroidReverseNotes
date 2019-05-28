package com.tencent.mm.media.widget.camerarecordview;

import a.f.b.j;
import a.l;
import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.b.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.i;

@l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J@\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory;", "", "()V", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getAudioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "sampleRate", "", "bitrate", "getCPUMediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "recordType", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getGPUMediaRecorder", "videoTransPara", "eglContext", "Landroid/opengl/EGLContext;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "useCPUCrop", "", "plugin-mediaeditor_release"})
public final class b {
    private static com.tencent.mm.media.h.a eXm;
    public static final b fbR = new b();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    public static final class a extends com.tencent.mm.media.h.a {
        a() {
            super(1, 0, 0, 0, 62);
        }

        public final com.tencent.mm.media.h.b.a Vc() {
            AppMethodBeat.i(13249);
            com.tencent.mm.media.h.b.a eVar = new e(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.o(13249);
            return eVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$4", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    public static final class b extends com.tencent.mm.media.h.a {
        b() {
            super(3, 0, 0, 0, 62);
        }

        public final com.tencent.mm.media.h.b.a Vc() {
            AppMethodBeat.i(13250);
            com.tencent.mm.media.h.b.a eVar = new e(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.o(13250);
            return eVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    public static final class c extends com.tencent.mm.media.h.d {
        final /* synthetic */ boolean fbS;

        c(boolean z) {
            this.fbS = z;
        }

        public final com.tencent.mm.media.h.b.a Vc() {
            AppMethodBeat.i(13251);
            com.tencent.mm.media.h.b.a eVar;
            if (this.fbS) {
                eVar = new e(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
                AppMethodBeat.o(13251);
                return eVar;
            }
            eVar = new com.tencent.mm.media.h.b.c(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.o(13251);
            return eVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$3", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    public static final class d extends com.tencent.mm.media.h.a {
        d() {
            super(3, 0, 0, 0, 62);
        }

        public final com.tencent.mm.media.h.b.a Vc() {
            AppMethodBeat.i(13252);
            com.tencent.mm.media.h.b.a eVar = new e(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.o(13252);
            return eVar;
        }
    }

    static {
        AppMethodBeat.i(13256);
        AppMethodBeat.o(13256);
    }

    private b() {
    }

    public static void Wv() {
        eXm = null;
    }

    public static com.tencent.mm.media.h.a getRenderer() {
        return eXm;
    }

    public static com.tencent.mm.media.widget.b.b a(int i, VideoTransPara videoTransPara, com.tencent.mm.media.widget.a.e eVar, EGLContext eGLContext, com.tencent.mm.media.widget.camerarecordview.preview.c cVar, boolean z, com.tencent.mm.media.h.a aVar) {
        AppMethodBeat.i(13253);
        j.p(videoTransPara, "videoTransPara");
        j.p(eVar, "camera");
        j.p(eGLContext, "eglContext");
        j.p(cVar, "view");
        com.tencent.mm.media.h.a aVar2;
        com.tencent.mm.media.widget.b.b cVar2;
        if (i == 2) {
            if (aVar == null) {
                eXm = new c(z);
            } else {
                eXm = aVar;
            }
            aVar2 = eXm;
            if (!(aVar2 == null || eVar.Wq() == null)) {
                aVar2.ch(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
                aVar2.ka(com.tencent.mm.media.widget.a.b.Wi());
                aVar2.ct(com.tencent.mm.media.widget.a.b.Wl());
            }
            cVar2 = new com.tencent.mm.media.widget.b.c(videoTransPara, eXm, eGLContext, cVar.getPreviewTextureId());
            AppMethodBeat.o(13253);
            return cVar2;
        }
        if (aVar == null) {
            eXm = new d();
        } else {
            eXm = aVar;
        }
        aVar2 = eXm;
        if (!(aVar2 == null || eVar.Wq() == null)) {
            Point Wm = com.tencent.mm.media.widget.a.b.Wm();
            aVar2.ch(Wm.x, Wm.y);
            aVar2.ka(com.tencent.mm.media.widget.a.b.Wi());
            aVar2.ct(com.tencent.mm.media.widget.a.b.Wl());
        }
        com.tencent.mm.media.widget.b.d dVar = new com.tencent.mm.media.widget.b.d(videoTransPara, eXm);
        eVar.a(dVar.getFrameDataCallback());
        cVar2 = dVar;
        AppMethodBeat.o(13253);
        return cVar2;
    }

    public static com.tencent.mm.media.widget.b.b a(int i, VideoTransPara videoTransPara, com.tencent.mm.media.widget.a.e eVar, com.tencent.mm.media.h.a aVar) {
        AppMethodBeat.i(13254);
        j.p(videoTransPara, "videoPara");
        j.p(eVar, "camera");
        com.tencent.mm.media.h.a aVar2;
        Point Wm;
        com.tencent.mm.media.widget.b.b bVar;
        if (i == 2) {
            if (aVar == null) {
                eXm = new a();
            } else {
                eXm = aVar;
            }
            aVar2 = eXm;
            if (!(aVar2 == null || eVar.Wq() == null)) {
                Wm = com.tencent.mm.media.widget.a.b.Wm();
                aVar2.ch(Wm.x, Wm.y);
                aVar2.ka(com.tencent.mm.media.widget.a.b.Wi());
                aVar2.ct(com.tencent.mm.media.widget.a.b.Wl());
            }
            com.tencent.mm.media.widget.b.c cVar = new com.tencent.mm.media.widget.b.c(videoTransPara, eXm);
            eVar.a(cVar.getFrameDataCallback());
            bVar = cVar;
            AppMethodBeat.o(13254);
            return bVar;
        }
        if (aVar == null) {
            eXm = new b();
        } else {
            eXm = aVar;
        }
        aVar2 = eXm;
        if (!(aVar2 == null || eVar.Wq() == null)) {
            Wm = com.tencent.mm.media.widget.a.b.Wm();
            aVar2.ch(Wm.x, Wm.y);
            aVar2.ka(com.tencent.mm.media.widget.a.b.Wi());
            aVar2.ct(com.tencent.mm.media.widget.a.b.Wl());
        }
        com.tencent.mm.media.widget.b.d dVar = new com.tencent.mm.media.widget.b.d(videoTransPara, eXm);
        eVar.a(dVar.getFrameDataCallback());
        bVar = dVar;
        AppMethodBeat.o(13254);
        return bVar;
    }

    public static com.tencent.mm.plugin.mmsight.model.a.c cl(int i, int i2) {
        AppMethodBeat.i(13255);
        com.tencent.mm.plugin.mmsight.model.a.c iVar = new i(i, i2);
        AppMethodBeat.o(13255);
        return iVar;
    }
}
