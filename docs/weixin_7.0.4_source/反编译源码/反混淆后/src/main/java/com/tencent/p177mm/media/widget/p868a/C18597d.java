package com.tencent.p177mm.media.widget.p868a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Looper;
import android.support.p057v4.widget.C8415j;
import android.view.SurfaceHolder;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.compatible.p221e.C41938t;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.media.p867i.C18594c;
import com.tencent.p177mm.media.widget.p868a.C26389c.C18595a;
import com.tencent.p177mm.media.widget.p868a.C32763a.C32764a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.model.C34547b;
import com.tencent.p177mm.plugin.mmsight.model.C34549k;
import com.tencent.p177mm.plugin.mmsight.model.C34552p;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import com.tencent.p177mm.plugin.mmsight.model.C39388g;
import com.tencent.p177mm.plugin.mmsight.model.C39388g.C39389b;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43306k;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0016J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u001fH\u0002J\u001c\u0010J\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0002J\n\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u00020\bH\u0002J\b\u0010R\u001a\u00020\bH\u0002J\b\u0010S\u001a\u00020\bH\u0002J\u0018\u0010T\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010U\u001a\u00020C2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\b2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020CH\u0016J\b\u0010^\u001a\u00020CH\u0016J\u0012\u0010_\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010#H\u0016J\b\u0010`\u001a\u00020CH\u0004J\u0012\u0010a\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0004J\u0012\u0010b\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0005J\u0012\u0010c\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0004J\u001a\u0010d\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010e\u001a\u00020\u0005H\u0002J\u0010\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\bH\u0002J\u0012\u0010h\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0004J\u0010\u0010i\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\bH\u0002J\b\u0010j\u001a\u00020CH\u0002J\b\u0010k\u001a\u00020CH\u0002J\"\u0010l\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010m\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\bH\u0016J\"\u0010l\u001a\u00020C2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010m\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\bH\u0016J$\u0010n\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010g\u001a\u00020\bH\u0002J$\u0010o\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010g\u001a\u00020\bH\u0002J \u0010p\u001a\u00020C2\u0006\u0010q\u001a\u00020\u00052\u0006\u0010r\u001a\u00020\u00052\u0006\u0010s\u001a\u00020\bH\u0016J\u0014\u0010t\u001a\u00020C2\n\u0010u\u001a\u00060vR\u00020wH\u0002J\u0016\u0010x\u001a\u00020C2\f\u0010u\u001a\b\u0018\u00010vR\u00020wH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000b\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020;X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000b\"\u0004\b@\u00109R\u000e\u0010A\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, dWq = {"Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "useBack", "", "(Landroid/content/Context;Z)V", "DEFAULT_UPPER_BOUND", "", "SMALL_ZOOM_STEP_NUM", "getSMALL_ZOOM_STEP_NUM", "()I", "SMALL_ZOOM_STEP_UPPER_BOUND", "getSMALL_ZOOM_STEP_UPPER_BOUND", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "cameraCallback", "Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "cameraCropCallback", "cameraPreviewCallback", "cropSize", "Landroid/graphics/Point;", "getCropSize", "()Landroid/graphics/Point;", "setCropSize", "(Landroid/graphics/Point;)V", "currentFrameData", "", "finishCallbackTimeCallback", "frameDataCallbackList", "", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getFrameDataCallbackList", "()Ljava/util/List;", "setFrameDataCallbackList", "(Ljava/util/List;)V", "isCameraOpen", "isZooming", "()Z", "setZooming", "(Z)V", "lock", "Ljava/lang/Object;", "openCameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "getOpenCameraRes", "()Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "setOpenCameraRes", "(Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;)V", "prevcameraCallback", "scrollSmallZoomStep", "getScrollSmallZoomStep", "setScrollSmallZoomStep", "(I)V", "sightHandler", "Lcom/tencent/mm/media/widget/camera/CameraHandler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera/CameraHandler;", "smallZoomStep", "getSmallZoomStep", "setSmallZoomStep", "takePictureLock", "addFrameDataCallback", "", "callback", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "dispatchCameraFrame", "frame", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getOrientation", "getPreviewHeight", "getPreviewWidth", "initCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "safeResetZoom", "safeSetFocusMode", "safeSetMetering", "safeSetPreviewFormat", "safeSetPreviewFrameRate", "useFixMode", "safeSetPreviewSize", "resolutionLimit", "safeSetStabilization", "selectNoCropPreviewSize", "setPreviewCallbackImpl", "setSafeConfig", "startPreview", "useCpuCrop", "startPreviewWithCPU", "startPreviewWithGPU", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "p", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "trySetPreviewFrameRateParameters", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.a.d */
public final class C18597d extends C32763a {
    private boolean aJI;
    C41938t erH;
    private final int faX = 20;
    private final int faY = 5;
    List<C39387f> faZ = new ArrayList();
    private final C26389c fba;
    private C32470a fbb;
    Point fbc;
    private int fbd;
    private int fbe;
    private final C34547b fbf;
    private final C34547b fbg;
    private final C34547b fbh;
    private final C34547b fbi;
    private final C34547b fbj;
    private volatile boolean fbk;
    private volatile byte[] fbl;
    private boolean fbm;
    private final int fbn;
    private final Object lock;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/CommonCamera1$setPreviewCallbackImpl$1$1"})
    /* renamed from: com.tencent.mm.media.widget.a.d$a */
    static final class C18598a implements PreviewCallback {
        final /* synthetic */ C18597d fbo;

        C18598a(C18597d c18597d) {
            this.fbo = c18597d;
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            AppMethodBeat.m2504i(13195);
            if (bArr != null) {
                if ((bArr.length == 0 ? 1 : null) == null) {
                    C41938t c41938t;
                    if (this.fbo.faZ.size() <= 0) {
                        c41938t = this.fbo.erH;
                        if (c41938t != null) {
                            c41938t.addCallbackBuffer(bArr);
                            AppMethodBeat.m2505o(13195);
                            return;
                        }
                        AppMethodBeat.m2505o(13195);
                        return;
                    }
                    if (!(this.fbo.fbk || this.fbo.faZ.size() <= 0 || this.fbo.fbc == null)) {
                        byte[] g;
                        Point point = this.fbo.fbc;
                        if (point != null && point.x == this.fbo.fav.lZe) {
                            point = this.fbo.fbc;
                            if (point != null && point.y == this.fbo.fav.lZf) {
                                long yz = C5046bo.m7588yz();
                                boolean a = C18597d.m29007a(this.fbo, bArr);
                                yz = C5046bo.m7525az(yz);
                                if (a) {
                                    this.fbo.fbj.mo55078jl(yz);
                                }
                                if (a) {
                                    bArr = C43305j.owk.mo68846g(Integer.valueOf(bArr.length));
                                }
                            }
                        }
                        C43305j c43305j = C43305j.owk;
                        int i = this.fbo.fav.lZe;
                        Point point2 = this.fbo.fbc;
                        if (point2 == null) {
                            C25052j.dWJ();
                        }
                        byte[] g2 = c43305j.mo68846g(Integer.valueOf(((i * point2.y) * 3) / 2));
                        this.fbo.fbh.mo55078jl(1);
                        long yz2 = C5046bo.m7588yz();
                        int i2 = this.fbo.fav.lZe;
                        int i3 = this.fbo.fav.lZf;
                        Point point3 = this.fbo.fbc;
                        if (point3 == null) {
                            C25052j.dWJ();
                        }
                        SightVideoJNI.cropCameraData(bArr, g2, i2, i3, point3.y);
                        point = this.fbo.fbc;
                        if (point == null) {
                            C25052j.dWJ();
                        }
                        if (point.x < this.fbo.fav.lZe) {
                            c43305j = C43305j.owk;
                            Point point4 = this.fbo.fbc;
                            if (point4 == null) {
                                C25052j.dWJ();
                            }
                            i3 = point4.x;
                            point3 = this.fbo.fbc;
                            if (point3 == null) {
                                C25052j.dWJ();
                            }
                            g = c43305j.mo68846g(Integer.valueOf(((i3 * point3.y) * 3) / 2));
                            i3 = this.fbo.fav.lZe;
                            point3 = this.fbo.fbc;
                            if (point3 == null) {
                                C25052j.dWJ();
                            }
                            int i4 = point3.x;
                            Point point5 = this.fbo.fbc;
                            if (point5 == null) {
                                C25052j.dWJ();
                            }
                            SightVideoJNI.cropCameraDataLongEdge(g2, g, i3, i4, point5.y);
                            C43305j.owk.mo68845g(g2);
                        } else {
                            g = g2;
                        }
                        this.fbo.fbi.mo55078jl(C5046bo.m7525az(yz2));
                        C18597d c18597d = this.fbo;
                        C25052j.m39375o(g, "curFrameData");
                        boolean a2 = C18597d.m29007a(c18597d, g);
                        yz2 = C5046bo.m7525az(yz2);
                        if (a2) {
                            this.fbo.fbj.mo55078jl(yz2);
                        }
                    }
                    c41938t = this.fbo.erH;
                    if (c41938t != null) {
                        c41938t.addCallbackBuffer(bArr);
                        AppMethodBeat.m2505o(13195);
                        return;
                    }
                    AppMethodBeat.m2505o(13195);
                    return;
                }
            }
            C4990ab.m7412e(this.fbo.TAG, "onPreviewFrame, frame data is null!!");
            AppMethodBeat.m2505o(13195);
        }
    }

    public C18597d(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(13222);
        Looper mainLooper = Looper.getMainLooper();
        C25052j.m39375o(mainLooper, "Looper.getMainLooper()");
        this.fba = new C26389c(mainLooper);
        this.fbd = -1;
        this.fbe = -1;
        this.fbf = new C34547b("prevcameraCallback");
        this.fbg = new C34547b("cameraCallback");
        this.fbh = new C34547b("cameraPreviewCallback");
        this.fbi = new C34547b("cameraCropCallback");
        this.fbj = new C34547b("finishCallbackTimeCallback");
        this.fbn = 2100;
        this.lock = new Object();
        AppMethodBeat.m2505o(13222);
    }

    /* renamed from: o */
    public final boolean mo33848o(Context context, boolean z) {
        AppMethodBeat.m2504i(13196);
        C25052j.m39376p(context, "context");
        try {
            if (this.fbm) {
                C4990ab.m7416i(this.TAG, "initCamera, already open");
                AppMethodBeat.m2505o(13196);
                return true;
            }
            int Lr;
            C18594c c18594c = C18594c.faj;
            C18594c.m28969Vk();
            super.mo33848o(context, z);
            release();
            if (z) {
                Lr = C32468d.m53152Lr();
            } else {
                Lr = C32468d.m53153Ls();
            }
            C4990ab.m7409c(this.TAG, "use camera id %d, DeviceInfo id %d", Integer.valueOf(Lr), Integer.valueOf(C1427q.etc.ert));
            this.fbb = new C9610f().mo20922a(context, Lr, Looper.getMainLooper());
            C4990ab.m7417i(this.TAG, "open camera end, %s", Looper.myLooper());
            if (this.fbb == null) {
                C4990ab.m7417i(this.TAG, "open camera FAILED, %s", Looper.myLooper());
                mo53308Wf();
                AppMethodBeat.m2505o(13196);
                return false;
            }
            C32470a c32470a = this.fbb;
            this.erH = c32470a != null ? c32470a.erH : null;
            this.fba.faJ = false;
            C34552p c34552p = this.fav;
            c32470a = this.fbb;
            if (c32470a != null) {
                Lr = c32470a.rotate;
            } else {
                Lr = 0;
            }
            c34552p.rotate = Lr;
            if (this.erH == null) {
                C4990ab.m7412e(this.TAG, "start camera FAILED!");
                mo53308Wf();
                AppMethodBeat.m2505o(13196);
                return false;
            }
            this.fbm = true;
            AppMethodBeat.m2505o(13196);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "init camera failed!", new Object[0]);
            C18594c c18594c2 = C18594c.faj;
            C18594c.m28971Vm();
            AppMethodBeat.m2505o(13196);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo33841a(SurfaceTexture surfaceTexture, boolean z, int i) {
        AppMethodBeat.m2504i(13199);
        super.mo33841a(surfaceTexture, z, i);
        if (z) {
            m29002a(surfaceTexture, null, i);
            AppMethodBeat.m2505o(13199);
            return;
        }
        m29009b(surfaceTexture, null, i);
        AppMethodBeat.m2505o(13199);
    }

    /* renamed from: a */
    public final void mo33842a(SurfaceHolder surfaceHolder, boolean z, int i) {
        AppMethodBeat.m2504i(13200);
        super.mo33842a(surfaceHolder, z, i);
        if (z) {
            m29002a(null, surfaceHolder, i);
            AppMethodBeat.m2505o(13200);
            return;
        }
        m29009b(null, surfaceHolder, i);
        AppMethodBeat.m2505o(13200);
    }

    /* renamed from: a */
    private final void m29002a(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int i) {
        AppMethodBeat.m2504i(13201);
        long yz = C5046bo.m7588yz();
        C4990ab.m7416i(this.TAG, "start startPreviewWithCPU,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + surfaceTexture + ", surface:" + surfaceHolder);
        if (mo44176Wh()) {
            C4990ab.m7416i(this.TAG, "startPreviewWithCPU, camera previewing");
            AppMethodBeat.m2505o(13201);
            return;
        }
        try {
            m29014kk(i);
            m28999Wo();
            m29001Ws();
            if (m29003a(surfaceTexture, surfaceHolder)) {
                mo53309a(C32764a.CAMERA_IS_PREVIEWING);
            }
        } catch (Exception e) {
            C4990ab.m7413e(this.TAG, "start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
            C18594c c18594c = C18594c.faj;
            C18594c.m28971Vm();
        }
        C4990ab.m7417i(this.TAG, "start preview end, use %dms %s", Long.valueOf(C5046bo.m7525az(yz)), Looper.myLooper());
        AppMethodBeat.m2505o(13201);
    }

    /* renamed from: b */
    private final void m29009b(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int i) {
        AppMethodBeat.m2504i(13202);
        long yz = C5046bo.m7588yz();
        C4990ab.m7416i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + surfaceTexture + ", surface:" + surfaceHolder);
        if (mo44176Wh()) {
            C4990ab.m7416i(this.TAG, "startPreviewWithGPU, camera previewing");
            AppMethodBeat.m2505o(13202);
            return;
        }
        try {
            m29015kl(i);
            m28999Wo();
            if (m29003a(surfaceTexture, surfaceHolder)) {
                mo53309a(C32764a.CAMERA_IS_PREVIEWING);
            }
        } catch (Exception e) {
            C4990ab.m7413e(this.TAG, "start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
            C18594c c18594c = C18594c.faj;
            C18594c.m28971Vm();
        }
        C4990ab.m7417i(this.TAG, "start preview end, use %dms %s", Long.valueOf(C5046bo.m7525az(yz)), Looper.myLooper());
        AppMethodBeat.m2505o(13202);
    }

    /* renamed from: a */
    private final boolean m29003a(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(13203);
        C41938t c41938t = this.erH;
        if (c41938t == null) {
            AppMethodBeat.m2505o(13203);
            return false;
        } else if (surfaceTexture == null && surfaceHolder == null) {
            C4990ab.m7416i(this.TAG, "doStartPreview error, surfaceTexture and surface is null");
            C18594c c18594c = C18594c.faj;
            C18594c.m28971Vm();
            AppMethodBeat.m2505o(13203);
            return false;
        } else {
            if (surfaceTexture != null) {
                c41938t.setPreviewTexture(surfaceTexture);
            } else {
                c41938t.setPreviewDisplay(surfaceHolder);
            }
            c41938t.startPreview();
            C4990ab.m7416i(this.TAG, "doStartPreview finish");
            C18594c c18594c2 = C18594c.faj;
            C18594c.m28970Vl();
            AppMethodBeat.m2505o(13203);
            return true;
        }
    }

    /* renamed from: Wo */
    private final void m28999Wo() {
        boolean z;
        AppMethodBeat.m2504i(13204);
        Integer valueOf = Integer.valueOf(0);
        C43306k bPR = C43306k.bPR();
        C25052j.m39375o(bPR, "MMSightController.getInstance()");
        if (bPR.bPS() != null) {
            C43306k bPR2 = C43306k.bPR();
            C25052j.m39375o(bPR2, "MMSightController.getInstance()");
            valueOf = Integer.valueOf(bPR2.bPS().osS);
        }
        String str = this.TAG;
        String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
        Object[] objArr = new Object[6];
        objArr[0] = valueOf;
        String str3 = C1427q.etc.ern == 1 ? "Range" : C1427q.etc.erm == 1 ? "Fix" : "Error";
        objArr[1] = str3;
        if (C1427q.etc.ero == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        if (C1427q.etc.erp == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        if (C1427q.etc.erq == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[4] = Boolean.valueOf(z);
        if (C1427q.etc.err == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[5] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (C1427q.etc.ern == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
            m29005a(this.erH, false);
        } else if (C1427q.etc.erm == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
            m29005a(this.erH, true);
        }
        if (C1427q.etc.ero == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
            m29010b(this.erH);
        }
        if (C1427q.etj.etH != -1 && C1427q.etj.etH == 1 && C1443d.m3069iX(14)) {
            m29012c(this.erH);
        }
        if (C1427q.etc.erq == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
            m29004a(this.erH);
        }
        if (C1427q.etc.err == 1 && valueOf.intValue() != 0) {
            valueOf.intValue();
        }
        m29000Wr();
        AppMethodBeat.m2505o(13204);
    }

    /* renamed from: b */
    public final void mo33845b(float f, float f2, int i, int i2) {
        AppMethodBeat.m2504i(13205);
        if (!mo44176Wh()) {
            AppMethodBeat.m2505o(13205);
        } else if (C1443d.m3067fP(14)) {
            AppMethodBeat.m2505o(13205);
        } else {
            C26389c c26389c = this.fba;
            C18595a c18595a = C26389c.faV;
            c26389c.removeMessages(C26389c.faR);
            this.fba.faK = f;
            this.fba.faL = f2;
            this.fba.faM = i;
            this.fba.faN = i2;
            c26389c = this.fba;
            C26389c c26389c2 = this.fba;
            C18595a c18595a2 = C26389c.faV;
            c26389c.sendMessageDelayed(c26389c2.obtainMessage(C26389c.faR, this.erH), 400);
            AppMethodBeat.m2505o(13205);
        }
    }

    /* renamed from: Wp */
    public final void mo33839Wp() {
        AppMethodBeat.m2504i(13206);
        if (mo44176Wh()) {
            C26389c c26389c = this.fba;
            C18595a c18595a = C26389c.faV;
            c26389c.removeMessages(C26389c.faR);
            AppMethodBeat.m2505o(13206);
            return;
        }
        AppMethodBeat.m2505o(13206);
    }

    /* renamed from: kj */
    public final void mo33847kj(int i) {
        AppMethodBeat.m2504i(13207);
        if (this.fbd > 0) {
            AppMethodBeat.m2505o(13207);
            return;
        }
        int i2 = C5222ae.m7953hy(C4996ah.getContext()).y;
        C4990ab.m7417i(this.TAG, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", Integer.valueOf(i), r0);
        if (i2 / 2 >= i) {
            AppMethodBeat.m2505o(13207);
            return;
        }
        try {
            if (this.erH != null) {
                int maxZoom;
                C41938t c41938t = this.erH;
                Parameters parameters = c41938t != null ? c41938t.getParameters() : null;
                if (parameters != null) {
                    maxZoom = parameters.getMaxZoom();
                } else {
                    maxZoom = 0;
                }
                double d = ((double) maxZoom) / ((((double) i) / 3.0d) / 10.0d);
                if (d > 0.0d) {
                    this.fbd = ((int) d) + 1;
                }
                C4990ab.m7417i(this.TAG, "scrollSmallZoomStep: %s, maxZoom: %s", Integer.valueOf(this.fbd), Integer.valueOf(maxZoom));
                AppMethodBeat.m2505o(13207);
                return;
            }
        } catch (Exception e) {
            C4990ab.m7413e(this.TAG, "calcScrollZoomStep error: %s", e.getMessage());
        }
        AppMethodBeat.m2505o(13207);
    }

    /* renamed from: a */
    public final void mo33844a(boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(13208);
        if (this.erH == null || !mo44176Wh()) {
            AppMethodBeat.m2505o(13208);
            return;
        }
        try {
            C4990ab.m7411d(this.TAG, "triggerSmallZoom, zoom: %s", Boolean.valueOf(z));
            if (this.aJI) {
                C4990ab.m7410d(this.TAG, "triggerSmallZoom, zooming, ignore");
                return;
            }
            Parameters parameters;
            C41938t c41938t = this.erH;
            if (c41938t != null) {
                parameters = c41938t.getParameters();
            } else {
                parameters = null;
            }
            if (parameters != null && parameters.isZoomSupported()) {
                int i2;
                this.aJI = true;
                int zoom = parameters.getZoom();
                int maxZoom = parameters.getMaxZoom();
                if (!z2) {
                    if (this.fbe <= 0) {
                        this.fbe = Math.round(((float) maxZoom) / ((float) this.faX));
                        if (this.fbe > this.faY) {
                            this.fbe = this.faY;
                        }
                    }
                    i2 = this.fbe;
                } else if (this.fbd <= 0) {
                    C4990ab.m7413e(this.TAG, "scroll zoom error, scrollSmallZoomStep: %s", Integer.valueOf(this.fbd));
                    this.aJI = false;
                    AppMethodBeat.m2505o(13208);
                    return;
                } else {
                    i2 = this.fbd;
                }
                C4990ab.m7411d(this.TAG, "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.fbe), Integer.valueOf(this.fbd), Integer.valueOf(i));
                if (i > 0) {
                    i2 *= i;
                }
                if (z) {
                    if (zoom >= maxZoom) {
                        this.aJI = false;
                        AppMethodBeat.m2505o(13208);
                        return;
                    }
                    i2 += zoom;
                    if (i2 < maxZoom) {
                        maxZoom = i2;
                    }
                } else if (zoom == 0) {
                    this.aJI = false;
                    AppMethodBeat.m2505o(13208);
                    return;
                } else {
                    maxZoom = zoom - i2;
                    if (maxZoom <= 0) {
                        maxZoom = 0;
                    }
                }
                C4990ab.m7411d(this.TAG, "triggerSmallZoom, nextZoom: %s, smoothZoomSupported: %s", Integer.valueOf(maxZoom), Boolean.valueOf(parameters.isSmoothZoomSupported()));
                parameters.setZoom(maxZoom);
                c41938t = this.erH;
                if (c41938t != null) {
                    c41938t.setParameters(parameters);
                }
            }
            this.aJI = false;
            AppMethodBeat.m2505o(13208);
        } catch (Exception e) {
            C4990ab.m7413e(this.TAG, "triggerSmallZoom error: %s", e.getMessage());
        } finally {
            this.aJI = false;
            AppMethodBeat.m2505o(13208);
        }
    }

    private final int getPreviewHeight() {
        AppMethodBeat.m2504i(13210);
        if (this.erH == null) {
            AppMethodBeat.m2505o(13210);
            return 0;
        }
        if (this.fbb != null) {
            try {
                int i;
                if (!this.fau || this.fbc == null) {
                    i = this.fav.lZf;
                    AppMethodBeat.m2505o(13210);
                    return i;
                }
                Point point = this.fbc;
                if (point == null) {
                    C25052j.dWJ();
                }
                i = point.y;
                AppMethodBeat.m2505o(13210);
                return i;
            } catch (Exception e) {
                C4990ab.m7413e(this.TAG, "getPreviewHeight: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(13210);
        return 0;
    }

    private final int getPreviewWidth() {
        AppMethodBeat.m2504i(13211);
        if (this.erH == null) {
            AppMethodBeat.m2505o(13211);
            return 0;
        }
        if (this.fbb != null) {
            try {
                int i;
                if (!this.fau || this.fbc == null) {
                    i = this.fav.lZe;
                    AppMethodBeat.m2505o(13211);
                    return i;
                }
                Point point = this.fbc;
                if (point == null) {
                    C25052j.dWJ();
                }
                i = point.x;
                AppMethodBeat.m2505o(13211);
                return i;
            } catch (Exception e) {
                C4990ab.m7413e(this.TAG, "getPreviewWidth: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(13211);
        return 0;
    }

    /* renamed from: a */
    private final boolean m29005a(C41938t c41938t, boolean z) {
        AppMethodBeat.m2504i(13212);
        if (c41938t == null) {
            AppMethodBeat.m2505o(13212);
            return false;
        }
        try {
            List supportedPreviewFrameRates;
            Parameters parameters = c41938t.getParameters();
            Object obj;
            int i;
            if (!z) {
                C25052j.m39375o(parameters, "p");
                if (C1427q.etc.eri > 0) {
                    C4990ab.m7416i(this.fao, "set frame rate > 0, do not try set preview fps range");
                } else {
                    List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                    if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0)) {
                        int i2 = C8415j.INVALID_ID;
                        int i3 = C8415j.INVALID_ID;
                        Object obj2 = null;
                        int size = supportedPreviewFpsRange.size();
                        int i4 = 0;
                        while (i4 < size) {
                            int[] iArr = (int[]) supportedPreviewFpsRange.get(i4);
                            if (iArr == null || iArr.length <= 1) {
                                obj = obj2;
                            } else {
                                int i5 = iArr[0];
                                i = iArr[1];
                                C4990ab.m7417i(this.TAG, "dkfps %d:[%d %d]", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i));
                                if (i5 < 0 || i < i5) {
                                    obj = obj2;
                                } else {
                                    if (i >= i3 && obj2 == null) {
                                        i3 = i;
                                        i2 = i5;
                                    }
                                    if (i >= 30000) {
                                        obj = 1;
                                    } else {
                                        obj = obj2;
                                    }
                                }
                            }
                            i4++;
                            obj2 = obj;
                        }
                        C4990ab.m7417i(this.fao, "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(30));
                        if (!(i2 == BaseClientBuilder.API_PRIORITY_OTHER || i3 == BaseClientBuilder.API_PRIORITY_OTHER)) {
                            try {
                                parameters.setPreviewFpsRange(i2, i3);
                                C4990ab.m7417i(this.fao, "set fps range %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                            } catch (Exception e) {
                                C4990ab.m7417i(this.fao, "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e.getMessage());
                            }
                        }
                    }
                }
            } else if (C1427q.etc.eri > 0) {
                C4990ab.m7416i(this.fao, "set frame rate > 0, do not try set preview frame rate");
            } else if (parameters == null) {
                C4990ab.m7412e(this.TAG, "trySetPreviewFrameRateParameters error, p is null!");
            } else {
                try {
                    supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                    if (supportedPreviewFrameRates != null && supportedPreviewFrameRates.size() > 0) {
                        obj = Collections.max(supportedPreviewFrameRates);
                        C25052j.m39375o(obj, "Collections.max(fr)");
                        parameters.setPreviewFrameRate(Math.min(30, ((Number) obj).intValue()));
                        C4990ab.m7417i(this.fao, "set preview frame rate %d", Integer.valueOf(i));
                    }
                } catch (Exception e2) {
                    C4990ab.m7417i(this.fao, "trySetPreviewFrameRateParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                }
            }
            C25052j.m39375o(parameters, "p");
            supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            C4990ab.m7417i(this.fao, "use fix mode %B, supported preview frame rates %s", Boolean.valueOf(z), supportedPreviewFrameRates);
            c41938t.setParameters(parameters);
            AppMethodBeat.m2505o(13212);
            return true;
        } catch (Exception e22) {
            C4990ab.m7417i(this.fao, "setPreviewFrameRate Exception, %s, %s", Looper.myLooper(), e22.getMessage());
            AppMethodBeat.m2505o(13212);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m29004a(C41938t c41938t) {
        AppMethodBeat.m2504i(13213);
        if (c41938t == null) {
            AppMethodBeat.m2505o(13213);
            return false;
        }
        try {
            Parameters parameters = c41938t.getParameters();
            C25052j.m39375o(parameters, "p");
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-picture")) {
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("continuous-video")) {
                        C4990ab.m7416i(this.TAG, "support continuous video");
                        parameters.setFocusMode("continuous-video");
                    }
                }
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("auto")) {
                        C4990ab.m7416i(this.TAG, "support auto focus");
                        parameters.setFocusMode("auto");
                    }
                }
                C4990ab.m7416i(this.TAG, "not support continuous video or auto focus");
            } else {
                C4990ab.m7416i(this.TAG, "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            }
            c41938t.setParameters(parameters);
            AppMethodBeat.m2505o(13213);
            return true;
        } catch (Exception e) {
            C4990ab.m7417i(this.TAG, "setFocusMode Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.m2505o(13213);
            return false;
        }
    }

    /* renamed from: Wr */
    private void m29000Wr() {
        AppMethodBeat.m2504i(13214);
        try {
            C41938t c41938t = this.erH;
            Parameters parameters = c41938t != null ? c41938t.getParameters() : null;
            if (parameters != null && parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            C41938t c41938t2 = this.erH;
            if (c41938t2 != null) {
                c41938t2.setParameters(parameters);
                AppMethodBeat.m2505o(13214);
                return;
            }
            AppMethodBeat.m2505o(13214);
        } catch (Exception e) {
            C4990ab.m7413e(this.TAG, "safeResetZoom error: %s", e.getMessage());
            AppMethodBeat.m2505o(13214);
        }
    }

    /* renamed from: b */
    private boolean m29010b(C41938t c41938t) {
        AppMethodBeat.m2504i(13215);
        if (c41938t == null) {
            AppMethodBeat.m2505o(13215);
            return false;
        }
        try {
            C4990ab.m7416i(this.TAG, "safeSetPreviewFormat");
            Parameters parameters = c41938t.getParameters();
            C25052j.m39375o(parameters, "p");
            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(17))) {
                C4990ab.m7412e(this.TAG, "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            c41938t.setParameters(parameters);
            AppMethodBeat.m2505o(13215);
            return true;
        } catch (Exception e) {
            C4990ab.m7417i(this.TAG, "setPreviewFormat Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.m2505o(13215);
            return false;
        }
    }

    @TargetApi(14)
    /* renamed from: c */
    private boolean m29012c(C41938t c41938t) {
        AppMethodBeat.m2504i(13216);
        if (c41938t == null) {
            AppMethodBeat.m2505o(13216);
            return false;
        }
        try {
            C4990ab.m7416i(this.TAG, "safeSetMetering");
            Parameters parameters = c41938t.getParameters();
            C25052j.m39375o(parameters, "params");
            if (parameters.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Area(new Rect(-1000, -1000, 1000, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            c41938t.setParameters(parameters);
            AppMethodBeat.m2505o(13216);
            return true;
        } catch (Exception e) {
            C4990ab.m7417i(this.TAG, "safeSetMetering Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.m2505o(13216);
            return false;
        }
    }

    /* renamed from: Ws */
    private final void m29001Ws() {
        AppMethodBeat.m2504i(13217);
        if (this.erH == null) {
            AppMethodBeat.m2505o(13217);
            return;
        }
        try {
            if (this.erH != null) {
                C41938t c41938t = this.erH;
                if (c41938t != null) {
                    Parameters parameters = c41938t.getParameters();
                    if (parameters != null) {
                        int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.fav.lZe * this.fav.lZf)) / 8;
                        C4990ab.m7416i(this.TAG, "setPreviewCallbackImpl  size: ".concat(String.valueOf(bitsPerPixel)));
                        for (int i = 0; i < 5; i++) {
                            byte[] g = C43305j.owk.mo68846g(Integer.valueOf(bitsPerPixel));
                            C41938t c41938t2 = this.erH;
                            if (c41938t2 != null) {
                                c41938t2.addCallbackBuffer(g);
                            }
                        }
                        this.fbf.reset();
                        this.fbg.reset();
                        this.fbh.reset();
                        this.fbi.reset();
                        this.fbj.reset();
                        C41938t c41938t3 = this.erH;
                        if (c41938t3 != null) {
                            c41938t3.setPreviewCallbackWithBuffer(new C18598a(this));
                            AppMethodBeat.m2505o(13217);
                            return;
                        }
                    }
                }
                AppMethodBeat.m2505o(13217);
                return;
            }
            AppMethodBeat.m2505o(13217);
        } catch (Exception e) {
            C4990ab.m7413e(this.TAG, "setPreviewCallbackImpl error: %s", e.getMessage());
            AppMethodBeat.m2505o(13217);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034 A:{Catch:{ Exception -> 0x0040 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: kk */
    private final boolean m29014kk(int i) {
        AppMethodBeat.m2504i(13218);
        if (this.erH == null || this.fbb == null) {
            C4990ab.m7410d(this.TAG, "maybe sth. is wrong ,camera is null");
            AppMethodBeat.m2505o(13218);
            return false;
        }
        boolean z;
        C41938t c41938t;
        C32470a c32470a = this.fbb;
        if (c32470a == null || c32470a.rotate != 90) {
            c32470a = this.fbb;
            if (c32470a == null || c32470a.rotate != 270) {
                z = false;
                c41938t = this.erH;
                if (c41938t != null) {
                    Parameters parameters = c41938t.getParameters();
                    if (parameters != null) {
                        C39389b c;
                        Point eu = C3475d.m5780eu(this.context);
                        C39389b b = C39388g.m67219b(parameters, eu, i, z);
                        if (b.oum == null) {
                            C4990ab.m7412e(this.TAG, "fuck, preview size still null!!");
                            c = C39388g.m67220c(parameters, new Point(Math.min(eu.x, eu.y), Math.max(eu.x, eu.y)), this.fbn, z);
                        } else {
                            c = b;
                        }
                        if (c.oum == null) {
                            C4990ab.m7417i(this.TAG, "checkMore start %s", c.toString());
                            c.oum = c.oup;
                            c.oun = c.ouq;
                            c.ouo = c.our;
                        }
                        Point point = c.oum;
                        if (point == null) {
                            C34549k.bPD();
                            AppMethodBeat.m2505o(13218);
                            return false;
                        }
                        this.fav.lZe = point.x;
                        this.fav.lZf = point.y;
                        this.fbc = point;
                        if (c.oun != null) {
                            this.fbc = c.oun;
                        }
                        C4990ab.m7416i(this.TAG, "final set camera preview size: " + point + ", cropSize: " + this.fbc);
                        parameters.setPreviewSize(point.x, point.y);
                        C41938t c41938t2 = this.erH;
                        if (c41938t2 != null) {
                            c41938t2.setParameters(parameters);
                        }
                        AppMethodBeat.m2505o(13218);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(13218);
                return false;
            }
        }
        z = true;
        try {
            c41938t = this.erH;
            if (c41938t != null) {
            }
            AppMethodBeat.m2505o(13218);
            return false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "setPreviewSize Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.m2505o(13218);
            return false;
        }
    }

    /* renamed from: kl */
    private final boolean m29015kl(int i) {
        AppMethodBeat.m2504i(13219);
        if (this.erH == null || this.fbb == null) {
            C4990ab.m7410d(this.TAG, "maybe sth. is wrong ,camera is null");
            AppMethodBeat.m2505o(13219);
            return false;
        }
        C32470a c32470a = this.fbb;
        if (c32470a != null) {
            boolean z = c32470a.rotate == 90 || c32470a.rotate == 270;
            try {
                Parameters parameters;
                C39389b c;
                C41938t c41938t = this.erH;
                if (c41938t != null) {
                    parameters = c41938t.getParameters();
                } else {
                    parameters = null;
                }
                Point eu = C3475d.m5780eu(this.context);
                C39389b d = C39388g.m67221d(parameters, eu, i, z);
                if (d.oum == null) {
                    C4990ab.m7412e(this.TAG, "fuck, preview size still null!!");
                    c = C39388g.m67220c(parameters, new Point(Math.min(eu.x, eu.y), Math.max(eu.x, eu.y)), this.fbn, z);
                } else {
                    c = d;
                }
                if (c.oum == null) {
                    C4990ab.m7417i(this.TAG, "checkMore start %s", c.toString());
                    c.oum = c.oup;
                    c.oun = c.ouq;
                    c.ouo = c.our;
                }
                Point point = c.oum;
                if (point == null) {
                    C34549k.bPD();
                    AppMethodBeat.m2505o(13219);
                    return false;
                }
                this.fav.lZe = point.x;
                this.fav.lZf = point.y;
                this.fbc = null;
                C4990ab.m7416i(this.TAG, "final set camera preview size: " + point + ", cropSize: " + this.fbc);
                if (parameters != null) {
                    parameters.setPreviewSize(this.fav.lZe, this.fav.lZf);
                }
                C41938t c41938t2 = this.erH;
                if (c41938t2 != null) {
                    c41938t2.setParameters(parameters);
                }
            } catch (Exception e) {
                C4990ab.m7417i(this.TAG, "setPreviewSize Exception, %s, %s", Looper.myLooper(), e.getMessage());
                AppMethodBeat.m2505o(13219);
                return false;
            }
        }
        AppMethodBeat.m2505o(13219);
        return true;
    }

    /* renamed from: N */
    private final boolean m28998N(byte[] bArr) {
        AppMethodBeat.m2504i(13220);
        C5046bo.m7588yz();
        synchronized (this.lock) {
            try {
                if (this.faZ == null || this.faZ.size() == 0) {
                } else {
                    boolean z = false;
                    for (C39387f O : this.faZ) {
                        z |= O.mo14870O(bArr);
                    }
                    AppMethodBeat.m2505o(13220);
                    return z;
                }
            } finally {
                AppMethodBeat.m2505o(13220);
            }
        }
        return false;
    }

    public final void release() {
        AppMethodBeat.m2504i(13221);
        super.release();
        try {
            C4990ab.m7416i(this.TAG, this.fbf.getValue());
            C4990ab.m7416i(this.TAG, this.fbg.getValue());
            C4990ab.m7416i(this.TAG, this.fbh.getValue());
            C4990ab.m7416i(this.TAG, this.fbi.getValue());
            C4990ab.m7416i(this.TAG, this.fbj.getValue());
            if (this.erH != null) {
                long yz = C5046bo.m7588yz();
                C4990ab.m7417i(this.TAG, "release camera beg, %s", Looper.myLooper());
                this.fba.removeCallbacksAndMessages(null);
                this.fba.faJ = true;
                C41938t c41938t = this.erH;
                if (c41938t != null) {
                    c41938t.setPreviewCallback(null);
                }
                c41938t = this.erH;
                if (c41938t != null) {
                    c41938t.stopPreview();
                }
                c41938t = this.erH;
                if (c41938t != null) {
                    c41938t.release();
                }
                this.erH = null;
                C4990ab.m7417i(this.TAG, "release camera end, use %dms, %s", Long.valueOf(C5046bo.m7525az(yz)), Looper.myLooper());
            }
            this.fba.faH = false;
            this.fba.faO = true;
            this.fbc = null;
            this.fbl = null;
            this.fbm = false;
            AppMethodBeat.m2505o(13221);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "cameraRelease error", new Object[0]);
            AppMethodBeat.m2505o(13221);
        }
    }

    /* renamed from: a */
    public final void mo33843a(C39387f c39387f) {
        AppMethodBeat.m2504i(13197);
        C4990ab.m7409c(this.TAG, "addFrameDataCallback ".concat(String.valueOf(c39387f)), new Object[0]);
        if (c39387f == null) {
            AppMethodBeat.m2505o(13197);
            return;
        }
        synchronized (this.lock) {
            try {
                this.faZ.add(c39387f);
            } finally {
                AppMethodBeat.m2505o(13197);
            }
        }
    }

    /* renamed from: b */
    public final void mo33846b(C39387f c39387f) {
        AppMethodBeat.m2504i(13198);
        C4990ab.m7409c(this.TAG, "removeFrameDataCallback ".concat(String.valueOf(c39387f)), new Object[0]);
        if (c39387f == null) {
            AppMethodBeat.m2505o(13198);
            return;
        }
        synchronized (this.lock) {
            try {
                this.faZ.remove(c39387f);
            } finally {
                AppMethodBeat.m2505o(13198);
            }
        }
    }

    /* renamed from: Wq */
    public final C32765b mo33840Wq() {
        boolean z = true;
        AppMethodBeat.m2504i(13209);
        C4990ab.m7409c(this.TAG, "generateCameraConfig", new Object[0]);
        if (this.erH == null) {
            C4990ab.m7416i(this.TAG, "generateCameraConfig, camera is null!!");
            AppMethodBeat.m2505o(13209);
            return null;
        } else if (mo44176Wh()) {
            C32765b.m53509ke(getPreviewWidth());
            C32765b.m53508kd(getPreviewHeight());
            C32470a c32470a = this.fbb;
            int i = c32470a != null ? (c32470a.rotate == 90 || c32470a.rotate == 270) ? true : 0 : 0;
            C32765b.m53511kg(this.fav.lZe);
            C32765b.m53512kh(this.fav.lZf);
            if (i != 0) {
                i = C32765b.m53503Wj();
                C32765b.m53511kg(C32765b.m53504Wk());
                C32765b.m53512kh(i);
            }
            if (this.fbb == null || !mo44176Wh()) {
                i = -1;
            } else {
                c32470a = this.fbb;
                if (c32470a != null) {
                    i = c32470a.rotate;
                } else {
                    i = 0;
                }
            }
            C32765b.m53510kf(i);
            if (this.fas) {
                z = false;
            }
            C32765b.setFrontCamera(z);
            C32765b.m53507cu(this.fau);
            C32765b c32765b = this.faw;
            AppMethodBeat.m2505o(13209);
            return c32765b;
        } else {
            C4990ab.m7416i(this.TAG, "generateCameraConfig, camera not previewing");
            AppMethodBeat.m2505o(13209);
            return null;
        }
    }
}
