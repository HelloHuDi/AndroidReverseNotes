package com.tencent.p177mm.media.widget.camerarecordview.preview;

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
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.p867i.C42175b;
import com.tencent.p177mm.media.p867i.C42175b.C26386a;
import com.tencent.p177mm.media.p867i.C42175b.C9609b;
import com.tencent.p177mm.media.widget.camerarecordview.preview.p870a.C16538b;
import com.tencent.p177mm.media.widget.camerarecordview.preview.p870a.C26396c;
import com.tencent.p177mm.media.widget.camerarecordview.preview.p870a.C9627a;
import com.tencent.p177mm.media.widget.p868a.C32765b;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import com.tencent.p177mm.plugin.video.ObservableTextureView;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001IB#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bB\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\b\u0010*\u001a\u00020\u0014H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0014H\u0002J\"\u00101\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u00010\u00132\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0016J\u0012\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u00107\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u00010\u00132\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0016J\u0016\u00108\u001a\u00020\u00142\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140#H\u0016J\b\u0010:\u001a\u00020\u0014H\u0002J\b\u0010;\u001a\u00020\u0014H\u0016J\b\u0010<\u001a\u00020\u0014H\u0016J-\u0010=\u001a\u00020\u00142#\u0010>\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0016J\u0018\u0010A\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u000eH\u0016J \u0010C\u001a\u00020\u00142\u0016\u0010D\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0016J\b\u0010E\u001a\u00020\u0014H\u0016J\u0010\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020HH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140#`$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTextureId", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView */
public class CameraPreviewGLTextureView extends ObservableTextureView implements SurfaceTextureListener, C1791c {
    public static final C9626a fcq = new C9626a();
    private Surface aOO;
    private HandlerThread eXa;
    private C7306ak eXb;
    private C37897a eXm;
    private C17126b<? super SurfaceTexture, C37091y> fcd;
    private C9627a fce;
    private boolean fcg;
    private C9609b fcl;
    private SurfaceTexture fcm;
    private int fcn;
    private int fco;
    private ArrayList<C31214a<C37091y>> fcp = new ArrayList();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView$c */
    static final class C9622c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ CameraPreviewGLTextureView fcr;

        C9622c(CameraPreviewGLTextureView cameraPreviewGLTextureView) {
            this.fcr = cameraPreviewGLTextureView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13284);
            C37897a renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.release();
            }
            C9609b c = this.fcr.fcl;
            if (c != null) {
                EGL14.eglDestroyContext(c.fae, c.fag);
                EGL14.eglDestroySurface(c.fae, c.faf);
                SurfaceTexture d = this.fcr.fcm;
                if (d != null) {
                    d.release();
                }
                CameraPreviewGLTextureView.m17139e(this.fcr);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13284);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView$d */
    static final class C9623d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ int eXr;
        final /* synthetic */ int eXs;
        final /* synthetic */ CameraPreviewGLTextureView fcr;

        C9623d(CameraPreviewGLTextureView cameraPreviewGLTextureView, int i, int i2) {
            this.fcr = cameraPreviewGLTextureView;
            this.eXr = i;
            this.eXs = i2;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13285);
            this.fcr.fcn = this.eXr;
            this.fcr.fco = this.eXs;
            C37897a renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.mo60642ci(this.fcr.fcn, this.fcr.fco);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13285);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView$e */
    static final class C9624e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ CameraPreviewGLTextureView fcr;

        C9624e(CameraPreviewGLTextureView cameraPreviewGLTextureView) {
            this.fcr = cameraPreviewGLTextureView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13286);
            C9627a i = this.fcr.fce;
            if (i != null) {
                SurfaceTexture surfaceTexture = i.getSurfaceTexture();
                if (surfaceTexture != null) {
                    surfaceTexture.updateTexImage();
                }
            }
            C37897a renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.onDrawFrame(null);
            }
            C9609b c = this.fcr.fcl;
            if (c != null) {
                EGLExt.eglPresentationTimeANDROID(c.fae, c.faf, System.nanoTime());
                EGL14.eglSwapBuffers(c.fae, c.faf);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13286);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView$onSurfaceTextureAvailable$1$1"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView$b */
    static final class C9625b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ int eVY;
        final /* synthetic */ int eVZ;
        final /* synthetic */ SurfaceTexture fbP;
        final /* synthetic */ CameraPreviewGLTextureView fcr;
        final /* synthetic */ SurfaceTexture fcs;

        C9625b(SurfaceTexture surfaceTexture, CameraPreviewGLTextureView cameraPreviewGLTextureView, int i, int i2, SurfaceTexture surfaceTexture2) {
            this.fbP = surfaceTexture;
            this.fcr = cameraPreviewGLTextureView;
            this.eVY = i;
            this.eVZ = i2;
            this.fcs = surfaceTexture2;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object obj = null;
            AppMethodBeat.m2504i(13283);
            this.fcr.fcm = this.fbP;
            this.fcr.fcn = this.eVY;
            this.fcr.fco = this.eVZ;
            this.fcr.aOO = new Surface(this.fcr.fcm);
            CameraPreviewGLTextureView cameraPreviewGLTextureView = this.fcr;
            C26386a c26386a = C42175b.fad;
            cameraPreviewGLTextureView.fcl = C26386a.m41987b(this.fcr.aOO, 0, 0);
            C37897a renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.onSurfaceCreated(null, null);
            }
            renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.mo60642ci(this.eVY, this.eVZ);
            }
            renderer = this.fcr.getRenderer();
            if (renderer != null) {
                renderer.mo60643cs(true);
            }
            CameraPreviewGLTextureView.m17132a(this.fcr, this.fcs, this.eVY, this.eVZ);
            this.fcr.fcg = true;
            C4990ab.m7416i("MicroMsg.CameraPreviewGLTextureView", "previewCallback?.invoke");
            C17126b h = this.fcr.fcd;
            if (h != null) {
                C9627a i = this.fcr.fce;
                if (i != null) {
                    obj = i.getSurfaceTexture();
                }
                h.mo50am(obj);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13283);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView$a */
    public static final class C9626a {
        private C9626a() {
        }

        public /* synthetic */ C9626a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(13304);
        AppMethodBeat.m2505o(13304);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m17132a(CameraPreviewGLTextureView cameraPreviewGLTextureView, SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(13306);
        super.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        AppMethodBeat.m2505o(13306);
    }

    public CameraPreviewGLTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(13301);
        setSurfaceTextureListener(this);
        m17128WC();
        AppMethodBeat.m2505o(13301);
    }

    public CameraPreviewGLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(13302);
        setSurfaceTextureListener(this);
        m17128WC();
        AppMethodBeat.m2505o(13302);
    }

    public CameraPreviewGLTextureView(Context context) {
        super(context);
        AppMethodBeat.m2504i(13303);
        setSurfaceTextureListener(this);
        m17128WC();
        AppMethodBeat.m2505o(13303);
    }

    /* Access modifiers changed, original: protected|final */
    public final C37897a getRenderer() {
        return this.eXm;
    }

    /* Access modifiers changed, original: protected|final */
    public final void setRenderer(C37897a c37897a) {
        this.eXm = c37897a;
    }

    /* renamed from: a */
    public final void mo5342a(C32765b c32765b) {
        AppMethodBeat.m2504i(13288);
        C25052j.m39376p(c32765b, "cameraConfig");
        C4990ab.m7416i("MicroMsg.CameraPreviewGLTextureView", "updateCameraConfig: ".concat(String.valueOf(c32765b)));
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            c9627a.mo20949a(c32765b);
            AppMethodBeat.m2505o(13288);
            return;
        }
        AppMethodBeat.m2505o(13288);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(13289);
        super.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        C4990ab.m7416i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:" + surfaceTexture + ", width:" + i + ", height:" + i2);
        mo5344c((C31214a) new C9623d(this, i, i2));
        AppMethodBeat.m2505o(13289);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(13290);
        super.onSurfaceTextureDestroyed(surfaceTexture);
        C4990ab.m7416i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
        this.fcg = false;
        mo5344c((C31214a) new C9622c(this));
        AppMethodBeat.m2505o(13290);
        return false;
    }

    public final void release() {
        AppMethodBeat.m2504i(13291);
        setSurfaceTextureListener(null);
        AppMethodBeat.m2505o(13291);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(13292);
        C4990ab.m7416i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:" + surfaceTexture + ", width:" + i + ", height:" + i2 + ", handler: " + this.eXb);
        if (this.eXb == null) {
            m17128WC();
        }
        if (surfaceTexture != null) {
            mo5344c((C31214a) new C9625b(surfaceTexture, this, i, i2, surfaceTexture));
            AppMethodBeat.m2505o(13292);
            return;
        }
        AppMethodBeat.m2505o(13292);
    }

    /* renamed from: b */
    public final void mo5343b(C17126b<? super SurfaceTexture, C37091y> c17126b) {
        AppMethodBeat.m2504i(13293);
        C4990ab.m7409c("MicroMsg.CameraPreviewGLTextureView", "tryCameraPreview canPreview:" + this.fcg, new Object[0]);
        if (this.fcg) {
            C9627a c9627a = this.fce;
            c17126b.mo50am(c9627a != null ? c9627a.getSurfaceTexture() : null);
            AppMethodBeat.m2505o(13293);
            return;
        }
        this.fcd = c17126b;
        AppMethodBeat.m2505o(13293);
    }

    /* renamed from: WA */
    public final void mo5339WA() {
        AppMethodBeat.m2504i(13294);
        C4990ab.m7409c("MicroMsg.CameraPreviewGLTextureView", "tryStopCameraPreview", new Object[0]);
        this.fcd = null;
        AppMethodBeat.m2505o(13294);
    }

    public EGLContext getEGLContext() {
        C9609b c9609b = this.fcl;
        if (c9609b != null) {
            return c9609b.fag;
        }
        return null;
    }

    public void setOnDrawListener(C17126b<? super Integer, C37091y> c17126b) {
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            c9627a.fct = c17126b;
        }
    }

    public int getPreviewTextureId() {
        C37897a c37897a = this.eXm;
        if (c37897a != null) {
            return c37897a.eYN;
        }
        return -1;
    }

    /* renamed from: a */
    public final void mo5341a(C37897a c37897a, boolean z) {
        AppMethodBeat.m2504i(13295);
        C25052j.m39376p(c37897a, "renderer");
        C4990ab.m7416i("MicroMsg.CameraPreviewGLTextureView", "setRenderer:" + c37897a.hashCode() + "  cpuCrop:" + z);
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
        }
        this.eXm = c37897a;
        AppMethodBeat.m2505o(13295);
    }

    public void requestRender() {
        AppMethodBeat.m2504i(13296);
        mo5344c((C31214a) new C9624e(this));
        AppMethodBeat.m2505o(13296);
    }

    /* renamed from: c */
    public final void mo5344c(C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(13297);
        C25052j.m39376p(c31214a, "r");
        if (this.eXb != null) {
            C7306ak c7306ak = this.eXb;
            if (c7306ak != null) {
                c7306ak.post(new C32770b(c31214a));
                AppMethodBeat.m2505o(13297);
                return;
            }
            AppMethodBeat.m2505o(13297);
            return;
        }
        this.fcp.add(c31214a);
        AppMethodBeat.m2505o(13297);
    }

    public C39387f getFrameDataCallback() {
        AppMethodBeat.m2504i(13298);
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            C39387f frameDataCallback = c9627a.getFrameDataCallback();
            AppMethodBeat.m2505o(13298);
            return frameDataCallback;
        }
        AppMethodBeat.m2505o(13298);
        return null;
    }

    /* renamed from: WB */
    public final void mo5340WB() {
        AppMethodBeat.m2504i(13299);
        C9627a c9627a = this.fce;
        if (c9627a != null) {
            c9627a.mo20947WB();
            AppMethodBeat.m2505o(13299);
            return;
        }
        AppMethodBeat.m2505o(13299);
    }

    /* renamed from: WC */
    private final void m17128WC() {
        AppMethodBeat.m2504i(13300);
        HandlerThread ek = C7305d.m12297ek("CameraPreviewTextureView_renderThread", -2);
        ek.start();
        this.eXb = new C7306ak(ek.getLooper());
        ArrayList<C31214a> arrayList = new ArrayList();
        arrayList.addAll(this.fcp);
        this.fcp.clear();
        for (C31214a c : arrayList) {
            mo5344c(c);
        }
        this.eXa = ek;
        AppMethodBeat.m2505o(13300);
    }

    /* renamed from: e */
    public static final /* synthetic */ void m17139e(CameraPreviewGLTextureView cameraPreviewGLTextureView) {
        AppMethodBeat.m2504i(13305);
        HandlerThread handlerThread = cameraPreviewGLTextureView.eXa;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        cameraPreviewGLTextureView.eXa = null;
        cameraPreviewGLTextureView.eXb = null;
        AppMethodBeat.m2505o(13305);
    }
}
