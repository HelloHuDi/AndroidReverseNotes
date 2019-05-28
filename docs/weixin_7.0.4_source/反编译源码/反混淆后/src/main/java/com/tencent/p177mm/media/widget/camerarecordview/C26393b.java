package com.tencent.p177mm.media.widget.camerarecordview;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.p255h.C45432d;
import com.tencent.p177mm.media.p255h.p256b.C1786a;
import com.tencent.p177mm.media.p255h.p256b.C37898e;
import com.tencent.p177mm.media.p255h.p256b.C6629c;
import com.tencent.p177mm.media.widget.camerarecordview.preview.C1791c;
import com.tencent.p177mm.media.widget.p257b.C1788b;
import com.tencent.p177mm.media.widget.p257b.C6630c;
import com.tencent.p177mm.media.widget.p257b.C6643d;
import com.tencent.p177mm.media.widget.p868a.C26390e;
import com.tencent.p177mm.media.widget.p868a.C32765b;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C21299i;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J@\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory;", "", "()V", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getAudioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "sampleRate", "", "bitrate", "getCPUMediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "recordType", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getGPUMediaRecorder", "videoTransPara", "eglContext", "Landroid/opengl/EGLContext;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "useCPUCrop", "", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.camerarecordview.b */
public final class C26393b {
    private static C37897a eXm;
    public static final C26393b fbR = new C26393b();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.b$a */
    public static final class C18599a extends C37897a {
        C18599a() {
            super(1, 0, 0, 0, 62);
        }

        /* renamed from: Vc */
        public final C1786a mo20940Vc() {
            AppMethodBeat.m2504i(13249);
            C1786a c37898e = new C37898e(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.m2505o(13249);
            return c37898e;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$4", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.b$b */
    public static final class C18600b extends C37897a {
        C18600b() {
            super(3, 0, 0, 0, 62);
        }

        /* renamed from: Vc */
        public final C1786a mo20940Vc() {
            AppMethodBeat.m2504i(13250);
            C1786a c37898e = new C37898e(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.m2505o(13250);
            return c37898e;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.b$c */
    public static final class C26392c extends C45432d {
        final /* synthetic */ boolean fbS;

        C26392c(boolean z) {
            this.fbS = z;
        }

        /* renamed from: Vc */
        public final C1786a mo20940Vc() {
            AppMethodBeat.m2504i(13251);
            C1786a c37898e;
            if (this.fbS) {
                c37898e = new C37898e(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
                AppMethodBeat.m2505o(13251);
                return c37898e;
            }
            c37898e = new C6629c(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.m2505o(13251);
            return c37898e;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$3", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.b$d */
    public static final class C26394d extends C37897a {
        C26394d() {
            super(3, 0, 0, 0, 62);
        }

        /* renamed from: Vc */
        public final C1786a mo20940Vc() {
            AppMethodBeat.m2504i(13252);
            C1786a c37898e = new C37898e(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.m2505o(13252);
            return c37898e;
        }
    }

    static {
        AppMethodBeat.m2504i(13256);
        AppMethodBeat.m2505o(13256);
    }

    private C26393b() {
    }

    /* renamed from: Wv */
    public static void m42007Wv() {
        eXm = null;
    }

    public static C37897a getRenderer() {
        return eXm;
    }

    /* renamed from: a */
    public static C1788b m42008a(int i, VideoTransPara videoTransPara, C26390e c26390e, EGLContext eGLContext, C1791c c1791c, boolean z, C37897a c37897a) {
        AppMethodBeat.m2504i(13253);
        C25052j.m39376p(videoTransPara, "videoTransPara");
        C25052j.m39376p(c26390e, "camera");
        C25052j.m39376p(eGLContext, "eglContext");
        C25052j.m39376p(c1791c, "view");
        C37897a c37897a2;
        C1788b c6630c;
        if (i == 2) {
            if (c37897a == null) {
                eXm = new C26392c(z);
            } else {
                eXm = c37897a;
            }
            c37897a2 = eXm;
            if (!(c37897a2 == null || c26390e.mo33840Wq() == null)) {
                c37897a2.mo60641ch(C32765b.getPreviewWidth(), C32765b.getPreviewHeight());
                c37897a2.mo60646ka(C32765b.m53502Wi());
                c37897a2.mo60644ct(C32765b.m53505Wl());
            }
            c6630c = new C6630c(videoTransPara, eXm, eGLContext, c1791c.getPreviewTextureId());
            AppMethodBeat.m2505o(13253);
            return c6630c;
        }
        if (c37897a == null) {
            eXm = new C26394d();
        } else {
            eXm = c37897a;
        }
        c37897a2 = eXm;
        if (!(c37897a2 == null || c26390e.mo33840Wq() == null)) {
            Point Wm = C32765b.m53506Wm();
            c37897a2.mo60641ch(Wm.x, Wm.y);
            c37897a2.mo60646ka(C32765b.m53502Wi());
            c37897a2.mo60644ct(C32765b.m53505Wl());
        }
        C6643d c6643d = new C6643d(videoTransPara, eXm);
        c26390e.mo33843a(c6643d.getFrameDataCallback());
        c6630c = c6643d;
        AppMethodBeat.m2505o(13253);
        return c6630c;
    }

    /* renamed from: a */
    public static C1788b m42009a(int i, VideoTransPara videoTransPara, C26390e c26390e, C37897a c37897a) {
        AppMethodBeat.m2504i(13254);
        C25052j.m39376p(videoTransPara, "videoPara");
        C25052j.m39376p(c26390e, "camera");
        C37897a c37897a2;
        Point Wm;
        C1788b c1788b;
        if (i == 2) {
            if (c37897a == null) {
                eXm = new C18599a();
            } else {
                eXm = c37897a;
            }
            c37897a2 = eXm;
            if (!(c37897a2 == null || c26390e.mo33840Wq() == null)) {
                Wm = C32765b.m53506Wm();
                c37897a2.mo60641ch(Wm.x, Wm.y);
                c37897a2.mo60646ka(C32765b.m53502Wi());
                c37897a2.mo60644ct(C32765b.m53505Wl());
            }
            C6630c c6630c = new C6630c(videoTransPara, eXm);
            c26390e.mo33843a(c6630c.getFrameDataCallback());
            c1788b = c6630c;
            AppMethodBeat.m2505o(13254);
            return c1788b;
        }
        if (c37897a == null) {
            eXm = new C18600b();
        } else {
            eXm = c37897a;
        }
        c37897a2 = eXm;
        if (!(c37897a2 == null || c26390e.mo33840Wq() == null)) {
            Wm = C32765b.m53506Wm();
            c37897a2.mo60641ch(Wm.x, Wm.y);
            c37897a2.mo60646ka(C32765b.m53502Wi());
            c37897a2.mo60644ct(C32765b.m53505Wl());
        }
        C6643d c6643d = new C6643d(videoTransPara, eXm);
        c26390e.mo33843a(c6643d.getFrameDataCallback());
        c1788b = c6643d;
        AppMethodBeat.m2505o(13254);
        return c1788b;
    }

    /* renamed from: cl */
    public static C43303c m42010cl(int i, int i2) {
        AppMethodBeat.m2504i(13255);
        C43303c c21299i = new C21299i(i, i2);
        AppMethodBeat.m2505o(13255);
        return c21299i;
    }
}
