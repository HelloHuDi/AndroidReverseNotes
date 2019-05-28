package com.tencent.mm.media.widget.a;

import a.l;
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
import android.view.SurfaceHolder;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.media.i.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0016J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u001fH\u0002J\u001c\u0010J\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0002J\n\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u00020\bH\u0002J\b\u0010R\u001a\u00020\bH\u0002J\b\u0010S\u001a\u00020\bH\u0002J\u0018\u0010T\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010U\u001a\u00020C2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\b2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020CH\u0016J\b\u0010^\u001a\u00020CH\u0016J\u0012\u0010_\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010#H\u0016J\b\u0010`\u001a\u00020CH\u0004J\u0012\u0010a\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0004J\u0012\u0010b\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0005J\u0012\u0010c\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0004J\u001a\u0010d\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010e\u001a\u00020\u0005H\u0002J\u0010\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\bH\u0002J\u0012\u0010h\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0004J\u0010\u0010i\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\bH\u0002J\b\u0010j\u001a\u00020CH\u0002J\b\u0010k\u001a\u00020CH\u0002J\"\u0010l\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010m\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\bH\u0016J\"\u0010l\u001a\u00020C2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010m\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\bH\u0016J$\u0010n\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010g\u001a\u00020\bH\u0002J$\u0010o\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010g\u001a\u00020\bH\u0002J \u0010p\u001a\u00020C2\u0006\u0010q\u001a\u00020\u00052\u0006\u0010r\u001a\u00020\u00052\u0006\u0010s\u001a\u00020\bH\u0016J\u0014\u0010t\u001a\u00020C2\n\u0010u\u001a\u00060vR\u00020wH\u0002J\u0016\u0010x\u001a\u00020C2\f\u0010u\u001a\b\u0018\u00010vR\u00020wH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000b\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020;X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000b\"\u0004\b@\u00109R\u000e\u0010A\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, dWq = {"Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "useBack", "", "(Landroid/content/Context;Z)V", "DEFAULT_UPPER_BOUND", "", "SMALL_ZOOM_STEP_NUM", "getSMALL_ZOOM_STEP_NUM", "()I", "SMALL_ZOOM_STEP_UPPER_BOUND", "getSMALL_ZOOM_STEP_UPPER_BOUND", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "cameraCallback", "Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "cameraCropCallback", "cameraPreviewCallback", "cropSize", "Landroid/graphics/Point;", "getCropSize", "()Landroid/graphics/Point;", "setCropSize", "(Landroid/graphics/Point;)V", "currentFrameData", "", "finishCallbackTimeCallback", "frameDataCallbackList", "", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getFrameDataCallbackList", "()Ljava/util/List;", "setFrameDataCallbackList", "(Ljava/util/List;)V", "isCameraOpen", "isZooming", "()Z", "setZooming", "(Z)V", "lock", "Ljava/lang/Object;", "openCameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "getOpenCameraRes", "()Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "setOpenCameraRes", "(Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;)V", "prevcameraCallback", "scrollSmallZoomStep", "getScrollSmallZoomStep", "setScrollSmallZoomStep", "(I)V", "sightHandler", "Lcom/tencent/mm/media/widget/camera/CameraHandler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera/CameraHandler;", "smallZoomStep", "getSmallZoomStep", "setSmallZoomStep", "takePictureLock", "addFrameDataCallback", "", "callback", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "dispatchCameraFrame", "frame", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getOrientation", "getPreviewHeight", "getPreviewWidth", "initCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "safeResetZoom", "safeSetFocusMode", "safeSetMetering", "safeSetPreviewFormat", "safeSetPreviewFrameRate", "useFixMode", "safeSetPreviewSize", "resolutionLimit", "safeSetStabilization", "selectNoCropPreviewSize", "setPreviewCallbackImpl", "setSafeConfig", "startPreview", "useCpuCrop", "startPreviewWithCPU", "startPreviewWithGPU", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "p", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "trySetPreviewFrameRateParameters", "plugin-mediaeditor_release"})
public final class d extends a {
    private boolean aJI;
    t erH;
    private final int faX = 20;
    private final int faY = 5;
    List<f> faZ = new ArrayList();
    private final c fba;
    private com.tencent.mm.compatible.e.d.a.a fbb;
    Point fbc;
    private int fbd;
    private int fbe;
    private final b fbf;
    private final b fbg;
    private final b fbh;
    private final b fbi;
    private final b fbj;
    private volatile boolean fbk;
    private volatile byte[] fbl;
    private boolean fbm;
    private final int fbn;
    private final Object lock;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/CommonCamera1$setPreviewCallbackImpl$1$1"})
    static final class a implements PreviewCallback {
        final /* synthetic */ d fbo;

        a(d dVar) {
            this.fbo = dVar;
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            AppMethodBeat.i(13195);
            if (bArr != null) {
                if ((bArr.length == 0 ? 1 : null) == null) {
                    t tVar;
                    if (this.fbo.faZ.size() <= 0) {
                        tVar = this.fbo.erH;
                        if (tVar != null) {
                            tVar.addCallbackBuffer(bArr);
                            AppMethodBeat.o(13195);
                            return;
                        }
                        AppMethodBeat.o(13195);
                        return;
                    }
                    if (!(this.fbo.fbk || this.fbo.faZ.size() <= 0 || this.fbo.fbc == null)) {
                        byte[] g;
                        Point point = this.fbo.fbc;
                        if (point != null && point.x == this.fbo.fav.lZe) {
                            point = this.fbo.fbc;
                            if (point != null && point.y == this.fbo.fav.lZf) {
                                long yz = bo.yz();
                                boolean a = d.a(this.fbo, bArr);
                                yz = bo.az(yz);
                                if (a) {
                                    this.fbo.fbj.jl(yz);
                                }
                                if (a) {
                                    bArr = j.owk.g(Integer.valueOf(bArr.length));
                                }
                            }
                        }
                        j jVar = j.owk;
                        int i = this.fbo.fav.lZe;
                        Point point2 = this.fbo.fbc;
                        if (point2 == null) {
                            a.f.b.j.dWJ();
                        }
                        byte[] g2 = jVar.g(Integer.valueOf(((i * point2.y) * 3) / 2));
                        this.fbo.fbh.jl(1);
                        long yz2 = bo.yz();
                        int i2 = this.fbo.fav.lZe;
                        int i3 = this.fbo.fav.lZf;
                        Point point3 = this.fbo.fbc;
                        if (point3 == null) {
                            a.f.b.j.dWJ();
                        }
                        SightVideoJNI.cropCameraData(bArr, g2, i2, i3, point3.y);
                        point = this.fbo.fbc;
                        if (point == null) {
                            a.f.b.j.dWJ();
                        }
                        if (point.x < this.fbo.fav.lZe) {
                            jVar = j.owk;
                            Point point4 = this.fbo.fbc;
                            if (point4 == null) {
                                a.f.b.j.dWJ();
                            }
                            i3 = point4.x;
                            point3 = this.fbo.fbc;
                            if (point3 == null) {
                                a.f.b.j.dWJ();
                            }
                            g = jVar.g(Integer.valueOf(((i3 * point3.y) * 3) / 2));
                            i3 = this.fbo.fav.lZe;
                            point3 = this.fbo.fbc;
                            if (point3 == null) {
                                a.f.b.j.dWJ();
                            }
                            int i4 = point3.x;
                            Point point5 = this.fbo.fbc;
                            if (point5 == null) {
                                a.f.b.j.dWJ();
                            }
                            SightVideoJNI.cropCameraDataLongEdge(g2, g, i3, i4, point5.y);
                            j.owk.g(g2);
                        } else {
                            g = g2;
                        }
                        this.fbo.fbi.jl(bo.az(yz2));
                        d dVar = this.fbo;
                        a.f.b.j.o(g, "curFrameData");
                        boolean a2 = d.a(dVar, g);
                        yz2 = bo.az(yz2);
                        if (a2) {
                            this.fbo.fbj.jl(yz2);
                        }
                    }
                    tVar = this.fbo.erH;
                    if (tVar != null) {
                        tVar.addCallbackBuffer(bArr);
                        AppMethodBeat.o(13195);
                        return;
                    }
                    AppMethodBeat.o(13195);
                    return;
                }
            }
            ab.e(this.fbo.TAG, "onPreviewFrame, frame data is null!!");
            AppMethodBeat.o(13195);
        }
    }

    public d(Context context) {
        a.f.b.j.p(context, "context");
        super(context);
        AppMethodBeat.i(13222);
        Looper mainLooper = Looper.getMainLooper();
        a.f.b.j.o(mainLooper, "Looper.getMainLooper()");
        this.fba = new c(mainLooper);
        this.fbd = -1;
        this.fbe = -1;
        this.fbf = new b("prevcameraCallback");
        this.fbg = new b("cameraCallback");
        this.fbh = new b("cameraPreviewCallback");
        this.fbi = new b("cameraCropCallback");
        this.fbj = new b("finishCallbackTimeCallback");
        this.fbn = 2100;
        this.lock = new Object();
        AppMethodBeat.o(13222);
    }

    public final boolean o(Context context, boolean z) {
        AppMethodBeat.i(13196);
        a.f.b.j.p(context, "context");
        try {
            if (this.fbm) {
                ab.i(this.TAG, "initCamera, already open");
                AppMethodBeat.o(13196);
                return true;
            }
            int Lr;
            c cVar = c.faj;
            c.Vk();
            super.o(context, z);
            release();
            if (z) {
                Lr = com.tencent.mm.compatible.e.d.Lr();
            } else {
                Lr = com.tencent.mm.compatible.e.d.Ls();
            }
            ab.c(this.TAG, "use camera id %d, DeviceInfo id %d", Integer.valueOf(Lr), Integer.valueOf(q.etc.ert));
            this.fbb = new f().a(context, Lr, Looper.getMainLooper());
            ab.i(this.TAG, "open camera end, %s", Looper.myLooper());
            if (this.fbb == null) {
                ab.i(this.TAG, "open camera FAILED, %s", Looper.myLooper());
                Wf();
                AppMethodBeat.o(13196);
                return false;
            }
            com.tencent.mm.compatible.e.d.a.a aVar = this.fbb;
            this.erH = aVar != null ? aVar.erH : null;
            this.fba.faJ = false;
            p pVar = this.fav;
            aVar = this.fbb;
            if (aVar != null) {
                Lr = aVar.rotate;
            } else {
                Lr = 0;
            }
            pVar.rotate = Lr;
            if (this.erH == null) {
                ab.e(this.TAG, "start camera FAILED!");
                Wf();
                AppMethodBeat.o(13196);
                return false;
            }
            this.fbm = true;
            AppMethodBeat.o(13196);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "init camera failed!", new Object[0]);
            c cVar2 = c.faj;
            c.Vm();
            AppMethodBeat.o(13196);
            return false;
        }
    }

    public final void a(SurfaceTexture surfaceTexture, boolean z, int i) {
        AppMethodBeat.i(13199);
        super.a(surfaceTexture, z, i);
        if (z) {
            a(surfaceTexture, null, i);
            AppMethodBeat.o(13199);
            return;
        }
        b(surfaceTexture, null, i);
        AppMethodBeat.o(13199);
    }

    public final void a(SurfaceHolder surfaceHolder, boolean z, int i) {
        AppMethodBeat.i(13200);
        super.a(surfaceHolder, z, i);
        if (z) {
            a(null, surfaceHolder, i);
            AppMethodBeat.o(13200);
            return;
        }
        b(null, surfaceHolder, i);
        AppMethodBeat.o(13200);
    }

    private final void a(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int i) {
        AppMethodBeat.i(13201);
        long yz = bo.yz();
        ab.i(this.TAG, "start startPreviewWithCPU,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + surfaceTexture + ", surface:" + surfaceHolder);
        if (Wh()) {
            ab.i(this.TAG, "startPreviewWithCPU, camera previewing");
            AppMethodBeat.o(13201);
            return;
        }
        try {
            kk(i);
            Wo();
            Ws();
            if (a(surfaceTexture, surfaceHolder)) {
                a(com.tencent.mm.media.widget.a.a.a.CAMERA_IS_PREVIEWING);
            }
        } catch (Exception e) {
            ab.e(this.TAG, "start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
            c cVar = c.faj;
            c.Vm();
        }
        ab.i(this.TAG, "start preview end, use %dms %s", Long.valueOf(bo.az(yz)), Looper.myLooper());
        AppMethodBeat.o(13201);
    }

    private final void b(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, int i) {
        AppMethodBeat.i(13202);
        long yz = bo.yz();
        ab.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + surfaceTexture + ", surface:" + surfaceHolder);
        if (Wh()) {
            ab.i(this.TAG, "startPreviewWithGPU, camera previewing");
            AppMethodBeat.o(13202);
            return;
        }
        try {
            kl(i);
            Wo();
            if (a(surfaceTexture, surfaceHolder)) {
                a(com.tencent.mm.media.widget.a.a.a.CAMERA_IS_PREVIEWING);
            }
        } catch (Exception e) {
            ab.e(this.TAG, "start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
            c cVar = c.faj;
            c.Vm();
        }
        ab.i(this.TAG, "start preview end, use %dms %s", Long.valueOf(bo.az(yz)), Looper.myLooper());
        AppMethodBeat.o(13202);
    }

    private final boolean a(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(13203);
        t tVar = this.erH;
        if (tVar == null) {
            AppMethodBeat.o(13203);
            return false;
        } else if (surfaceTexture == null && surfaceHolder == null) {
            ab.i(this.TAG, "doStartPreview error, surfaceTexture and surface is null");
            c cVar = c.faj;
            c.Vm();
            AppMethodBeat.o(13203);
            return false;
        } else {
            if (surfaceTexture != null) {
                tVar.setPreviewTexture(surfaceTexture);
            } else {
                tVar.setPreviewDisplay(surfaceHolder);
            }
            tVar.startPreview();
            ab.i(this.TAG, "doStartPreview finish");
            c cVar2 = c.faj;
            c.Vl();
            AppMethodBeat.o(13203);
            return true;
        }
    }

    private final void Wo() {
        boolean z;
        AppMethodBeat.i(13204);
        Integer valueOf = Integer.valueOf(0);
        k bPR = k.bPR();
        a.f.b.j.o(bPR, "MMSightController.getInstance()");
        if (bPR.bPS() != null) {
            k bPR2 = k.bPR();
            a.f.b.j.o(bPR2, "MMSightController.getInstance()");
            valueOf = Integer.valueOf(bPR2.bPS().osS);
        }
        String str = this.TAG;
        String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
        Object[] objArr = new Object[6];
        objArr[0] = valueOf;
        String str3 = q.etc.ern == 1 ? "Range" : q.etc.erm == 1 ? "Fix" : "Error";
        objArr[1] = str3;
        if (q.etc.ero == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        if (q.etc.erp == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        if (q.etc.erq == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[4] = Boolean.valueOf(z);
        if (q.etc.err == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[5] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (q.etc.ern == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
            a(this.erH, false);
        } else if (q.etc.erm == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
            a(this.erH, true);
        }
        if (q.etc.ero == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
            b(this.erH);
        }
        if (q.etj.etH != -1 && q.etj.etH == 1 && com.tencent.mm.compatible.util.d.iX(14)) {
            c(this.erH);
        }
        if (q.etc.erq == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
            a(this.erH);
        }
        if (q.etc.err == 1 && valueOf.intValue() != 0) {
            valueOf.intValue();
        }
        Wr();
        AppMethodBeat.o(13204);
    }

    public final void b(float f, float f2, int i, int i2) {
        AppMethodBeat.i(13205);
        if (!Wh()) {
            AppMethodBeat.o(13205);
        } else if (com.tencent.mm.compatible.util.d.fP(14)) {
            AppMethodBeat.o(13205);
        } else {
            c cVar = this.fba;
            com.tencent.mm.media.widget.a.c.a aVar = c.faV;
            cVar.removeMessages(c.faR);
            this.fba.faK = f;
            this.fba.faL = f2;
            this.fba.faM = i;
            this.fba.faN = i2;
            cVar = this.fba;
            c cVar2 = this.fba;
            com.tencent.mm.media.widget.a.c.a aVar2 = c.faV;
            cVar.sendMessageDelayed(cVar2.obtainMessage(c.faR, this.erH), 400);
            AppMethodBeat.o(13205);
        }
    }

    public final void Wp() {
        AppMethodBeat.i(13206);
        if (Wh()) {
            c cVar = this.fba;
            com.tencent.mm.media.widget.a.c.a aVar = c.faV;
            cVar.removeMessages(c.faR);
            AppMethodBeat.o(13206);
            return;
        }
        AppMethodBeat.o(13206);
    }

    public final void kj(int i) {
        AppMethodBeat.i(13207);
        if (this.fbd > 0) {
            AppMethodBeat.o(13207);
            return;
        }
        int i2 = ae.hy(ah.getContext()).y;
        ab.i(this.TAG, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", Integer.valueOf(i), r0);
        if (i2 / 2 >= i) {
            AppMethodBeat.o(13207);
            return;
        }
        try {
            if (this.erH != null) {
                int maxZoom;
                t tVar = this.erH;
                Parameters parameters = tVar != null ? tVar.getParameters() : null;
                if (parameters != null) {
                    maxZoom = parameters.getMaxZoom();
                } else {
                    maxZoom = 0;
                }
                double d = ((double) maxZoom) / ((((double) i) / 3.0d) / 10.0d);
                if (d > 0.0d) {
                    this.fbd = ((int) d) + 1;
                }
                ab.i(this.TAG, "scrollSmallZoomStep: %s, maxZoom: %s", Integer.valueOf(this.fbd), Integer.valueOf(maxZoom));
                AppMethodBeat.o(13207);
                return;
            }
        } catch (Exception e) {
            ab.e(this.TAG, "calcScrollZoomStep error: %s", e.getMessage());
        }
        AppMethodBeat.o(13207);
    }

    public final void a(boolean z, boolean z2, int i) {
        AppMethodBeat.i(13208);
        if (this.erH == null || !Wh()) {
            AppMethodBeat.o(13208);
            return;
        }
        try {
            ab.d(this.TAG, "triggerSmallZoom, zoom: %s", Boolean.valueOf(z));
            if (this.aJI) {
                ab.d(this.TAG, "triggerSmallZoom, zooming, ignore");
                return;
            }
            Parameters parameters;
            t tVar = this.erH;
            if (tVar != null) {
                parameters = tVar.getParameters();
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
                    ab.e(this.TAG, "scroll zoom error, scrollSmallZoomStep: %s", Integer.valueOf(this.fbd));
                    this.aJI = false;
                    AppMethodBeat.o(13208);
                    return;
                } else {
                    i2 = this.fbd;
                }
                ab.d(this.TAG, "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.fbe), Integer.valueOf(this.fbd), Integer.valueOf(i));
                if (i > 0) {
                    i2 *= i;
                }
                if (z) {
                    if (zoom >= maxZoom) {
                        this.aJI = false;
                        AppMethodBeat.o(13208);
                        return;
                    }
                    i2 += zoom;
                    if (i2 < maxZoom) {
                        maxZoom = i2;
                    }
                } else if (zoom == 0) {
                    this.aJI = false;
                    AppMethodBeat.o(13208);
                    return;
                } else {
                    maxZoom = zoom - i2;
                    if (maxZoom <= 0) {
                        maxZoom = 0;
                    }
                }
                ab.d(this.TAG, "triggerSmallZoom, nextZoom: %s, smoothZoomSupported: %s", Integer.valueOf(maxZoom), Boolean.valueOf(parameters.isSmoothZoomSupported()));
                parameters.setZoom(maxZoom);
                tVar = this.erH;
                if (tVar != null) {
                    tVar.setParameters(parameters);
                }
            }
            this.aJI = false;
            AppMethodBeat.o(13208);
        } catch (Exception e) {
            ab.e(this.TAG, "triggerSmallZoom error: %s", e.getMessage());
        } finally {
            this.aJI = false;
            AppMethodBeat.o(13208);
        }
    }

    private final int getPreviewHeight() {
        AppMethodBeat.i(13210);
        if (this.erH == null) {
            AppMethodBeat.o(13210);
            return 0;
        }
        if (this.fbb != null) {
            try {
                int i;
                if (!this.fau || this.fbc == null) {
                    i = this.fav.lZf;
                    AppMethodBeat.o(13210);
                    return i;
                }
                Point point = this.fbc;
                if (point == null) {
                    a.f.b.j.dWJ();
                }
                i = point.y;
                AppMethodBeat.o(13210);
                return i;
            } catch (Exception e) {
                ab.e(this.TAG, "getPreviewHeight: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(13210);
        return 0;
    }

    private final int getPreviewWidth() {
        AppMethodBeat.i(13211);
        if (this.erH == null) {
            AppMethodBeat.o(13211);
            return 0;
        }
        if (this.fbb != null) {
            try {
                int i;
                if (!this.fau || this.fbc == null) {
                    i = this.fav.lZe;
                    AppMethodBeat.o(13211);
                    return i;
                }
                Point point = this.fbc;
                if (point == null) {
                    a.f.b.j.dWJ();
                }
                i = point.x;
                AppMethodBeat.o(13211);
                return i;
            } catch (Exception e) {
                ab.e(this.TAG, "getPreviewWidth: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(13211);
        return 0;
    }

    private final boolean a(t tVar, boolean z) {
        AppMethodBeat.i(13212);
        if (tVar == null) {
            AppMethodBeat.o(13212);
            return false;
        }
        try {
            List supportedPreviewFrameRates;
            Parameters parameters = tVar.getParameters();
            Object obj;
            int i;
            if (!z) {
                a.f.b.j.o(parameters, "p");
                if (q.etc.eri > 0) {
                    ab.i(this.fao, "set frame rate > 0, do not try set preview fps range");
                } else {
                    List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                    if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0)) {
                        int i2 = android.support.v4.widget.j.INVALID_ID;
                        int i3 = android.support.v4.widget.j.INVALID_ID;
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
                                ab.i(this.TAG, "dkfps %d:[%d %d]", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i));
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
                        ab.i(this.fao, "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(30));
                        if (!(i2 == BaseClientBuilder.API_PRIORITY_OTHER || i3 == BaseClientBuilder.API_PRIORITY_OTHER)) {
                            try {
                                parameters.setPreviewFpsRange(i2, i3);
                                ab.i(this.fao, "set fps range %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                            } catch (Exception e) {
                                ab.i(this.fao, "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e.getMessage());
                            }
                        }
                    }
                }
            } else if (q.etc.eri > 0) {
                ab.i(this.fao, "set frame rate > 0, do not try set preview frame rate");
            } else if (parameters == null) {
                ab.e(this.TAG, "trySetPreviewFrameRateParameters error, p is null!");
            } else {
                try {
                    supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                    if (supportedPreviewFrameRates != null && supportedPreviewFrameRates.size() > 0) {
                        obj = Collections.max(supportedPreviewFrameRates);
                        a.f.b.j.o(obj, "Collections.max(fr)");
                        parameters.setPreviewFrameRate(Math.min(30, ((Number) obj).intValue()));
                        ab.i(this.fao, "set preview frame rate %d", Integer.valueOf(i));
                    }
                } catch (Exception e2) {
                    ab.i(this.fao, "trySetPreviewFrameRateParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                }
            }
            a.f.b.j.o(parameters, "p");
            supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            ab.i(this.fao, "use fix mode %B, supported preview frame rates %s", Boolean.valueOf(z), supportedPreviewFrameRates);
            tVar.setParameters(parameters);
            AppMethodBeat.o(13212);
            return true;
        } catch (Exception e22) {
            ab.i(this.fao, "setPreviewFrameRate Exception, %s, %s", Looper.myLooper(), e22.getMessage());
            AppMethodBeat.o(13212);
            return false;
        }
    }

    private boolean a(t tVar) {
        AppMethodBeat.i(13213);
        if (tVar == null) {
            AppMethodBeat.o(13213);
            return false;
        }
        try {
            Parameters parameters = tVar.getParameters();
            a.f.b.j.o(parameters, "p");
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-picture")) {
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("continuous-video")) {
                        ab.i(this.TAG, "support continuous video");
                        parameters.setFocusMode("continuous-video");
                    }
                }
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("auto")) {
                        ab.i(this.TAG, "support auto focus");
                        parameters.setFocusMode("auto");
                    }
                }
                ab.i(this.TAG, "not support continuous video or auto focus");
            } else {
                ab.i(this.TAG, "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            }
            tVar.setParameters(parameters);
            AppMethodBeat.o(13213);
            return true;
        } catch (Exception e) {
            ab.i(this.TAG, "setFocusMode Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.o(13213);
            return false;
        }
    }

    private void Wr() {
        AppMethodBeat.i(13214);
        try {
            t tVar = this.erH;
            Parameters parameters = tVar != null ? tVar.getParameters() : null;
            if (parameters != null && parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            t tVar2 = this.erH;
            if (tVar2 != null) {
                tVar2.setParameters(parameters);
                AppMethodBeat.o(13214);
                return;
            }
            AppMethodBeat.o(13214);
        } catch (Exception e) {
            ab.e(this.TAG, "safeResetZoom error: %s", e.getMessage());
            AppMethodBeat.o(13214);
        }
    }

    private boolean b(t tVar) {
        AppMethodBeat.i(13215);
        if (tVar == null) {
            AppMethodBeat.o(13215);
            return false;
        }
        try {
            ab.i(this.TAG, "safeSetPreviewFormat");
            Parameters parameters = tVar.getParameters();
            a.f.b.j.o(parameters, "p");
            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(17))) {
                ab.e(this.TAG, "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            tVar.setParameters(parameters);
            AppMethodBeat.o(13215);
            return true;
        } catch (Exception e) {
            ab.i(this.TAG, "setPreviewFormat Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.o(13215);
            return false;
        }
    }

    @TargetApi(14)
    private boolean c(t tVar) {
        AppMethodBeat.i(13216);
        if (tVar == null) {
            AppMethodBeat.o(13216);
            return false;
        }
        try {
            ab.i(this.TAG, "safeSetMetering");
            Parameters parameters = tVar.getParameters();
            a.f.b.j.o(parameters, "params");
            if (parameters.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Area(new Rect(-1000, -1000, 1000, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            tVar.setParameters(parameters);
            AppMethodBeat.o(13216);
            return true;
        } catch (Exception e) {
            ab.i(this.TAG, "safeSetMetering Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.o(13216);
            return false;
        }
    }

    private final void Ws() {
        AppMethodBeat.i(13217);
        if (this.erH == null) {
            AppMethodBeat.o(13217);
            return;
        }
        try {
            if (this.erH != null) {
                t tVar = this.erH;
                if (tVar != null) {
                    Parameters parameters = tVar.getParameters();
                    if (parameters != null) {
                        int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.fav.lZe * this.fav.lZf)) / 8;
                        ab.i(this.TAG, "setPreviewCallbackImpl  size: ".concat(String.valueOf(bitsPerPixel)));
                        for (int i = 0; i < 5; i++) {
                            byte[] g = j.owk.g(Integer.valueOf(bitsPerPixel));
                            t tVar2 = this.erH;
                            if (tVar2 != null) {
                                tVar2.addCallbackBuffer(g);
                            }
                        }
                        this.fbf.reset();
                        this.fbg.reset();
                        this.fbh.reset();
                        this.fbi.reset();
                        this.fbj.reset();
                        t tVar3 = this.erH;
                        if (tVar3 != null) {
                            tVar3.setPreviewCallbackWithBuffer(new a(this));
                            AppMethodBeat.o(13217);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(13217);
                return;
            }
            AppMethodBeat.o(13217);
        } catch (Exception e) {
            ab.e(this.TAG, "setPreviewCallbackImpl error: %s", e.getMessage());
            AppMethodBeat.o(13217);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034 A:{Catch:{ Exception -> 0x0040 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean kk(int i) {
        AppMethodBeat.i(13218);
        if (this.erH == null || this.fbb == null) {
            ab.d(this.TAG, "maybe sth. is wrong ,camera is null");
            AppMethodBeat.o(13218);
            return false;
        }
        boolean z;
        t tVar;
        com.tencent.mm.compatible.e.d.a.a aVar = this.fbb;
        if (aVar == null || aVar.rotate != 90) {
            aVar = this.fbb;
            if (aVar == null || aVar.rotate != 270) {
                z = false;
                tVar = this.erH;
                if (tVar != null) {
                    Parameters parameters = tVar.getParameters();
                    if (parameters != null) {
                        g.b c;
                        Point eu = com.tencent.mm.plugin.mmsight.d.eu(this.context);
                        g.b b = g.b(parameters, eu, i, z);
                        if (b.oum == null) {
                            ab.e(this.TAG, "fuck, preview size still null!!");
                            c = g.c(parameters, new Point(Math.min(eu.x, eu.y), Math.max(eu.x, eu.y)), this.fbn, z);
                        } else {
                            c = b;
                        }
                        if (c.oum == null) {
                            ab.i(this.TAG, "checkMore start %s", c.toString());
                            c.oum = c.oup;
                            c.oun = c.ouq;
                            c.ouo = c.our;
                        }
                        Point point = c.oum;
                        if (point == null) {
                            com.tencent.mm.plugin.mmsight.model.k.bPD();
                            AppMethodBeat.o(13218);
                            return false;
                        }
                        this.fav.lZe = point.x;
                        this.fav.lZf = point.y;
                        this.fbc = point;
                        if (c.oun != null) {
                            this.fbc = c.oun;
                        }
                        ab.i(this.TAG, "final set camera preview size: " + point + ", cropSize: " + this.fbc);
                        parameters.setPreviewSize(point.x, point.y);
                        t tVar2 = this.erH;
                        if (tVar2 != null) {
                            tVar2.setParameters(parameters);
                        }
                        AppMethodBeat.o(13218);
                        return true;
                    }
                }
                AppMethodBeat.o(13218);
                return false;
            }
        }
        z = true;
        try {
            tVar = this.erH;
            if (tVar != null) {
            }
            AppMethodBeat.o(13218);
            return false;
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "setPreviewSize Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.o(13218);
            return false;
        }
    }

    private final boolean kl(int i) {
        AppMethodBeat.i(13219);
        if (this.erH == null || this.fbb == null) {
            ab.d(this.TAG, "maybe sth. is wrong ,camera is null");
            AppMethodBeat.o(13219);
            return false;
        }
        com.tencent.mm.compatible.e.d.a.a aVar = this.fbb;
        if (aVar != null) {
            boolean z = aVar.rotate == 90 || aVar.rotate == 270;
            try {
                Parameters parameters;
                g.b c;
                t tVar = this.erH;
                if (tVar != null) {
                    parameters = tVar.getParameters();
                } else {
                    parameters = null;
                }
                Point eu = com.tencent.mm.plugin.mmsight.d.eu(this.context);
                g.b d = g.d(parameters, eu, i, z);
                if (d.oum == null) {
                    ab.e(this.TAG, "fuck, preview size still null!!");
                    c = g.c(parameters, new Point(Math.min(eu.x, eu.y), Math.max(eu.x, eu.y)), this.fbn, z);
                } else {
                    c = d;
                }
                if (c.oum == null) {
                    ab.i(this.TAG, "checkMore start %s", c.toString());
                    c.oum = c.oup;
                    c.oun = c.ouq;
                    c.ouo = c.our;
                }
                Point point = c.oum;
                if (point == null) {
                    com.tencent.mm.plugin.mmsight.model.k.bPD();
                    AppMethodBeat.o(13219);
                    return false;
                }
                this.fav.lZe = point.x;
                this.fav.lZf = point.y;
                this.fbc = null;
                ab.i(this.TAG, "final set camera preview size: " + point + ", cropSize: " + this.fbc);
                if (parameters != null) {
                    parameters.setPreviewSize(this.fav.lZe, this.fav.lZf);
                }
                t tVar2 = this.erH;
                if (tVar2 != null) {
                    tVar2.setParameters(parameters);
                }
            } catch (Exception e) {
                ab.i(this.TAG, "setPreviewSize Exception, %s, %s", Looper.myLooper(), e.getMessage());
                AppMethodBeat.o(13219);
                return false;
            }
        }
        AppMethodBeat.o(13219);
        return true;
    }

    private final boolean N(byte[] bArr) {
        AppMethodBeat.i(13220);
        bo.yz();
        synchronized (this.lock) {
            try {
                if (this.faZ == null || this.faZ.size() == 0) {
                } else {
                    boolean z = false;
                    for (f O : this.faZ) {
                        z |= O.O(bArr);
                    }
                    AppMethodBeat.o(13220);
                    return z;
                }
            } finally {
                AppMethodBeat.o(13220);
            }
        }
        return false;
    }

    public final void release() {
        AppMethodBeat.i(13221);
        super.release();
        try {
            ab.i(this.TAG, this.fbf.getValue());
            ab.i(this.TAG, this.fbg.getValue());
            ab.i(this.TAG, this.fbh.getValue());
            ab.i(this.TAG, this.fbi.getValue());
            ab.i(this.TAG, this.fbj.getValue());
            if (this.erH != null) {
                long yz = bo.yz();
                ab.i(this.TAG, "release camera beg, %s", Looper.myLooper());
                this.fba.removeCallbacksAndMessages(null);
                this.fba.faJ = true;
                t tVar = this.erH;
                if (tVar != null) {
                    tVar.setPreviewCallback(null);
                }
                tVar = this.erH;
                if (tVar != null) {
                    tVar.stopPreview();
                }
                tVar = this.erH;
                if (tVar != null) {
                    tVar.release();
                }
                this.erH = null;
                ab.i(this.TAG, "release camera end, use %dms, %s", Long.valueOf(bo.az(yz)), Looper.myLooper());
            }
            this.fba.faH = false;
            this.fba.faO = true;
            this.fbc = null;
            this.fbl = null;
            this.fbm = false;
            AppMethodBeat.o(13221);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "cameraRelease error", new Object[0]);
            AppMethodBeat.o(13221);
        }
    }

    public final void a(f fVar) {
        AppMethodBeat.i(13197);
        ab.c(this.TAG, "addFrameDataCallback ".concat(String.valueOf(fVar)), new Object[0]);
        if (fVar == null) {
            AppMethodBeat.o(13197);
            return;
        }
        synchronized (this.lock) {
            try {
                this.faZ.add(fVar);
            } finally {
                AppMethodBeat.o(13197);
            }
        }
    }

    public final void b(f fVar) {
        AppMethodBeat.i(13198);
        ab.c(this.TAG, "removeFrameDataCallback ".concat(String.valueOf(fVar)), new Object[0]);
        if (fVar == null) {
            AppMethodBeat.o(13198);
            return;
        }
        synchronized (this.lock) {
            try {
                this.faZ.remove(fVar);
            } finally {
                AppMethodBeat.o(13198);
            }
        }
    }

    public final b Wq() {
        boolean z = true;
        AppMethodBeat.i(13209);
        ab.c(this.TAG, "generateCameraConfig", new Object[0]);
        if (this.erH == null) {
            ab.i(this.TAG, "generateCameraConfig, camera is null!!");
            AppMethodBeat.o(13209);
            return null;
        } else if (Wh()) {
            b.ke(getPreviewWidth());
            b.kd(getPreviewHeight());
            com.tencent.mm.compatible.e.d.a.a aVar = this.fbb;
            int i = aVar != null ? (aVar.rotate == 90 || aVar.rotate == 270) ? true : 0 : 0;
            b.kg(this.fav.lZe);
            b.kh(this.fav.lZf);
            if (i != 0) {
                i = b.Wj();
                b.kg(b.Wk());
                b.kh(i);
            }
            if (this.fbb == null || !Wh()) {
                i = -1;
            } else {
                aVar = this.fbb;
                if (aVar != null) {
                    i = aVar.rotate;
                } else {
                    i = 0;
                }
            }
            b.kf(i);
            if (this.fas) {
                z = false;
            }
            b.setFrontCamera(z);
            b.cu(this.fau);
            b bVar = this.faw;
            AppMethodBeat.o(13209);
            return bVar;
        } else {
            ab.i(this.TAG, "generateCameraConfig, camera not previewing");
            AppMethodBeat.o(13209);
            return null;
        }
    }
}
