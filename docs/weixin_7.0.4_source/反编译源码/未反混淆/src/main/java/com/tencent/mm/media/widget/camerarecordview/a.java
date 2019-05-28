package com.tencent.mm.media.widget.camerarecordview;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

@l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0001EB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\u0006\u0010 \u001a\u00020\nJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020\"J.\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0012J\u000e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\"J\u0006\u00101\u001a\u00020\"J\u000e\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u0012J\b\u00104\u001a\u00020\"H\u0002J7\u00105\u001a\u00020\"2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2%\b\u0002\u00106\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\"\u0018\u000107J\u0006\u0010;\u001a\u00020\u000fJ\u0006\u0010<\u001a\u00020\"J-\u0010=\u001a\u00020\u000f2%\b\u0002\u00106\u001a\u001f\u0012\u0013\u0012\u00110>¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\"\u0018\u000107J\u0006\u0010@\u001a\u00020\u000fJ\u001e\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0004R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "audioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "cameraCountNumber", "", "context", "Landroid/content/Context;", "currentState", "initRecorderRet", "", "isRecording", "lastFlipCameraStamp", "", "mediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordMiniTime", "startRecordTimeStamp", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "createRecorder", "getCameraCount", "initRecorder", "", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "onPause", "onResume", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "setRecordMiniTime", "time", "setRender", "startPreview", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "startRecord", "stopPreview", "stopRecord", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "capture", "switchCamera", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public final class a {
    public static final a fbL = new a();
    private Context context;
    private int currentState = 1;
    private final com.tencent.mm.media.widget.a.e fbA;
    public com.tencent.mm.media.widget.b.b fbB;
    private com.tencent.mm.plugin.mmsight.model.a.c fbC;
    private final ak fbD = new ak(Looper.getMainLooper());
    private boolean fbE = true;
    private long fbF;
    private long fbG;
    private boolean fbH;
    public long fbI = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    public com.tencent.mm.media.widget.camerarecordview.b.a fbJ;
    public com.tencent.mm.media.widget.camerarecordview.c.a fbK;
    public final int fbz = com.tencent.mm.compatible.e.d.getNumberOfCameras();
    public boolean isRecording;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class b extends k implements a.f.a.b<Integer, y> {
        final /* synthetic */ a fbM;

        b(a aVar) {
            this.fbM = aVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13228);
            ((Number) obj).intValue();
            com.tencent.mm.media.widget.b.b b = this.fbM.fbB;
            if (b != null) {
                b.WG();
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13228);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
    static final class d extends k implements a.f.a.b<SurfaceTexture, y> {
        final /* synthetic */ a.f.a.b exI;
        final /* synthetic */ a fbM;
        final /* synthetic */ boolean fbN;

        d(a aVar, boolean z, a.f.a.b bVar) {
            this.fbM = aVar;
            this.fbN = z;
            this.exI = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13231);
            final SurfaceTexture surfaceTexture = (SurfaceTexture) obj;
            this.fbM.fbD.post(new Runnable(this) {
                final /* synthetic */ d fbO;

                public final void run() {
                    AppMethodBeat.i(13230);
                    this.fbO.fbM.fbA.a(surfaceTexture, this.fbO.fbM.fbK.WD(), this.fbO.fbM.fbK.getResolutionLimit());
                    com.tencent.mm.media.widget.a.b Wq = this.fbO.fbM.fbA.Wq();
                    if (Wq != null) {
                        this.fbO.fbM.fbK.getCameraPreviewView().a(Wq);
                        a.e(this.fbO.fbM);
                        a.f(this.fbO.fbM);
                        com.tencent.mm.media.widget.camerarecordview.b.a g = this.fbO.fbM.fbJ;
                        boolean z = !this.fbO.fbN && this.fbO.fbM.fbK.WE();
                        g.a(z, Wq);
                    }
                    a.f.a.b bVar = this.fbO.exI;
                    if (bVar != null) {
                        bVar.am(Boolean.valueOf(this.fbO.fbM.fbA.Wh()));
                        AppMethodBeat.o(13230);
                        return;
                    }
                    AppMethodBeat.o(13230);
                }
            });
            y yVar = y.AUy;
            AppMethodBeat.o(13231);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$setRender$renderer$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    public static final class c extends com.tencent.mm.media.h.d {
        final /* synthetic */ a fbM;

        c(int i) {
            this.fbM = i;
        }

        public final com.tencent.mm.media.h.b.a Vc() {
            AppMethodBeat.i(13229);
            com.tencent.mm.media.h.b.a eVar;
            if (this.fbM.fbK.WD()) {
                eVar = new com.tencent.mm.media.h.b.e(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
                AppMethodBeat.o(13229);
                return eVar;
            }
            eVar = new com.tencent.mm.media.h.b.c(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.o(13229);
            return eVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ a.f.a.b exI;
        final /* synthetic */ a fbM;
        final /* synthetic */ com.tencent.mm.media.i.a fbQ;

        e(a aVar, com.tencent.mm.media.i.a aVar2, a.f.a.b bVar) {
            this.fbM = aVar;
            this.fbQ = aVar2;
            this.exI = bVar;
        }

        public final void run() {
            String filePath;
            String str = null;
            AppMethodBeat.i(13232);
            String str2 = "MicroMsg.CameraPreviewContainer";
            StringBuilder stringBuilder = new StringBuilder("stopRecord ");
            com.tencent.mm.media.widget.b.b b = this.fbM.fbB;
            stringBuilder = stringBuilder.append(b != null ? b.getFilePath() : null).append(' ');
            b = this.fbM.fbB;
            com.tencent.luggage.g.d.c(str2, stringBuilder.append(b != null ? b.Wy() : null).toString(), new Object[0]);
            this.fbQ.SW();
            b = this.fbM.fbB;
            if (b != null) {
                filePath = b.getFilePath();
            } else {
                filePath = null;
            }
            com.tencent.mm.media.widget.b.b b2 = this.fbM.fbB;
            if (b2 != null) {
                str = b2.Wy();
            }
            if (!(filePath == null || str == null)) {
                com.tencent.mm.media.widget.camerarecordview.a.a aVar = new com.tencent.mm.media.widget.camerarecordview.a.a(filePath, str);
                a.f.a.b bVar = this.exI;
                if (bVar != null) {
                    bVar.am(aVar);
                    AppMethodBeat.o(13232);
                    return;
                }
            }
            AppMethodBeat.o(13232);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$Companion;", "", "()V", "STATE_IN_PAUSE", "", "STATE_IN_PREVIEW", "SWITCH_BLOCK_TIME", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(13246);
        AppMethodBeat.o(13246);
    }

    public a(com.tencent.mm.media.widget.camerarecordview.c.a aVar) {
        j.p(aVar, "process");
        AppMethodBeat.i(13245);
        this.fbK = aVar;
        com.tencent.luggage.g.d.c("MicroMsg.CameraPreviewContainer", this.fbK.toString(), new Object[0]);
        com.tencent.mm.media.widget.camerarecordview.preview.c cameraPreviewView = this.fbK.getCameraPreviewView();
        if (this.fbK.getPreviewRenderer() != null) {
            com.tencent.mm.media.h.a previewRenderer = this.fbK.getPreviewRenderer();
            if (previewRenderer == null) {
                j.dWJ();
            }
            cameraPreviewView.a(previewRenderer, this.fbK.WD());
        } else {
            cameraPreviewView.a(new c(this), this.fbK.WD());
        }
        this.fbA = new com.tencent.mm.media.widget.a.d(this.fbK.getContext());
        this.fbG = bo.yz();
        this.context = this.fbK.getContext();
        this.fbJ = new com.tencent.mm.media.widget.camerarecordview.b.a(this.context, this.fbK);
        AppMethodBeat.o(13245);
    }

    public static final /* synthetic */ boolean e(a aVar) {
        AppMethodBeat.i(13247);
        boolean Wt = aVar.Wt();
        AppMethodBeat.o(13247);
        return Wt;
    }

    public static final /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(13248);
        aVar.Wu();
        AppMethodBeat.o(13248);
    }

    public final boolean EL() {
        AppMethodBeat.i(13233);
        com.tencent.luggage.g.d.c("MicroMsg.CameraPreviewContainer", JsApiStartRecordVoice.NAME, new Object[0]);
        if (this.fbA.Wq() == null || this.fbB == null) {
            com.tencent.luggage.g.d.c("MicroMsg.CameraPreviewContainer", "cameraConfig is null", new Object[0]);
            AppMethodBeat.o(13233);
            return false;
        } else if (this.fbH) {
            com.tencent.mm.media.widget.b.b bVar = this.fbB;
            Object valueOf = bVar != null ? Integer.valueOf(bVar.b(com.tencent.mm.media.widget.a.b.Wi(), false, 0)) : null;
            com.tencent.luggage.g.d.i("MicroMsg.CameraPreviewContainer", "start record ret:".concat(String.valueOf(valueOf)));
            if (valueOf != null && valueOf.intValue() == 0) {
                this.fbF = bo.yz();
                this.isRecording = true;
                AppMethodBeat.o(13233);
                return true;
            }
            AppMethodBeat.o(13233);
            return false;
        } else {
            com.tencent.luggage.g.d.i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
            AppMethodBeat.o(13233);
            return false;
        }
    }

    public final void b(float f, float f2, int i, int i2) {
        AppMethodBeat.i(13235);
        if (this.currentState == 0) {
            this.fbA.b(f, f2, i, i2);
        }
        AppMethodBeat.o(13235);
    }

    public final void Wp() {
        AppMethodBeat.i(13236);
        if (this.currentState == 0) {
            this.fbA.Wp();
        }
        AppMethodBeat.o(13236);
    }

    public final void km(int i) {
        AppMethodBeat.i(13237);
        if (this.currentState == 0) {
            this.fbA.kj(i);
        }
        AppMethodBeat.o(13237);
    }

    public final void a(boolean z, boolean z2, int i) {
        AppMethodBeat.i(13238);
        if (this.currentState == 0) {
            this.fbA.a(z, z2, i);
        }
        AppMethodBeat.o(13238);
    }

    public final boolean Wg() {
        AppMethodBeat.i(13239);
        com.tencent.luggage.g.d.i("MicroMsg.CameraPreviewContainer", "flipCamera time space:" + bo.az(this.fbG));
        boolean z;
        if (bo.az(this.fbG) < 1000) {
            z = this.fbE;
            AppMethodBeat.o(13239);
            return z;
        }
        this.fbG = bo.yz();
        this.fbK.getCameraPreviewView().WB();
        this.fbE = this.fbA.Wg();
        com.tencent.mm.media.widget.a.b Wq = this.fbA.Wq();
        com.tencent.mm.media.widget.camerarecordview.b.a aVar = this.fbJ;
        z = !this.fbE && this.fbK.WE();
        aVar.a(z, Wq);
        if (Wq != null) {
            this.fbK.getCameraPreviewView().a(Wq);
            b bVar = b.fbR;
            com.tencent.mm.media.h.a renderer = b.getRenderer();
            if (renderer != null) {
                renderer.ch(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
            }
            bVar = b.fbR;
            renderer = b.getRenderer();
            if (renderer != null) {
                renderer.ka(com.tencent.mm.media.widget.a.b.Wi());
            }
            bVar = b.fbR;
            renderer = b.getRenderer();
            if (renderer != null) {
                renderer.ct(com.tencent.mm.media.widget.a.b.Wl());
            }
        }
        z = this.fbE;
        AppMethodBeat.o(13239);
        return z;
    }

    private final boolean Wt() {
        AppMethodBeat.i(13240);
        com.tencent.mm.media.widget.b.b bVar = this.fbB;
        if (bVar != null) {
            bVar.cancel();
            bVar.clear();
        }
        com.tencent.mm.media.widget.camerarecordview.a.b encodeConfig = this.fbK.getEncodeConfig();
        if (this.fbK.getCameraPreviewView().getEGLContext() == null) {
            AppMethodBeat.o(13240);
            return false;
        }
        a aVar;
        b bVar2;
        if (this.fbK.getRecorder() != null) {
            bVar = this.fbK.getRecorder();
            aVar = this;
        } else if (this.fbK.WD()) {
            bVar2 = b.fbR;
            bVar = b.a(encodeConfig.Ww(), this.fbK.getVideoTransPara(), this.fbA, this.fbK.getRecordRenderer());
            aVar = this;
        } else {
            bVar2 = b.fbR;
            int Ww = encodeConfig.Ww();
            VideoTransPara videoTransPara = this.fbK.getVideoTransPara();
            com.tencent.mm.media.widget.a.e eVar = this.fbA;
            EGLContext eGLContext = this.fbK.getCameraPreviewView().getEGLContext();
            if (eGLContext == null) {
                j.dWJ();
            }
            bVar = b.a(Ww, videoTransPara, eVar, eGLContext, this.fbK.getCameraPreviewView(), this.fbK.WD(), this.fbK.getRecordRenderer());
            aVar = this;
        }
        aVar.fbB = bVar;
        bVar = this.fbB;
        if (bVar != null) {
            bVar.setMute(this.fbK.DX());
        }
        if (encodeConfig.getSampleRate() > 0 && encodeConfig.Wx() > 0) {
            bVar2 = b.fbR;
            this.fbC = b.cl(encodeConfig.getSampleRate(), encodeConfig.Wx());
        }
        this.fbK.getCameraPreviewView().setOnDrawListener(new b(this));
        AppMethodBeat.o(13240);
        return true;
    }

    private final void Wu() {
        boolean ko;
        String str = null;
        AppMethodBeat.i(13241);
        com.tencent.mm.media.widget.b.b bVar = this.fbB;
        if (bVar != null) {
            bVar.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.Wj(), com.tencent.mm.media.widget.a.b.Wk());
        }
        if (bVar != null) {
            bVar.setFilePath(this.fbK.getEncodeConfig().getFilePath());
        }
        if (bVar != null) {
            bVar.mb(this.fbK.getEncodeConfig().Wy());
        }
        String str2 = "MicroMsg.CameraPreviewContainer";
        StringBuilder append = new StringBuilder("filePath : ").append(bVar != null ? bVar.getFilePath() : null).append("   thumbPath : ");
        if (bVar != null) {
            str = bVar.Wy();
        }
        com.tencent.luggage.g.d.c(str2, append.append(str).toString(), new Object[0]);
        com.tencent.mm.media.widget.b.b bVar2 = this.fbB;
        if (bVar2 != null) {
            ko = bVar2.ko(com.tencent.mm.media.widget.a.b.Wi());
        } else {
            ko = false;
        }
        if (!ko) {
            com.tencent.luggage.g.d.c("MicroMsg.CameraPreviewContainer", "init recorder ret:".concat(String.valueOf(ko)), new Object[0]);
        }
        this.fbH = ko;
        AppMethodBeat.o(13241);
    }

    public final void a(boolean z, a.f.a.b<? super Boolean, y> bVar) {
        AppMethodBeat.i(13242);
        if (this.currentState == 0) {
            AppMethodBeat.o(13242);
            return;
        }
        this.currentState = 0;
        com.tencent.luggage.g.d.c("MicroMsg.CameraPreviewContainer", "startPreview process.useCpuCrop():" + this.fbK.WD(), new Object[0]);
        this.fbE = z;
        this.fbA.o(this.fbK.getContext(), z);
        if (this.fbK.WD()) {
            this.fbA.a(this.fbK.getCameraPreviewView().getFrameDataCallback());
        }
        this.fbK.getCameraPreviewView().b(new d(this, z, bVar));
        AppMethodBeat.o(13242);
    }

    public final void stopPreview() {
        AppMethodBeat.i(13244);
        if (this.currentState == 1) {
            AppMethodBeat.o(13244);
            return;
        }
        this.currentState = 1;
        com.tencent.luggage.g.d.c("MicroMsg.CameraPreviewContainer", "stopPreview", new Object[0]);
        try {
            this.fbA.release();
        } catch (Exception e) {
            com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.CameraPreviewContainer", e, "camera relase error:" + e.getMessage(), new Object[0]);
        }
        this.fbA.b(this.fbK.getCameraPreviewView().getFrameDataCallback());
        this.fbK.getCameraPreviewView().WA();
        this.fbJ.a(false, null);
        AppMethodBeat.o(13244);
    }

    public final boolean a(a.f.a.b<? super com.tencent.mm.media.widget.camerarecordview.a.a, y> bVar) {
        AppMethodBeat.i(13234);
        if (this.isRecording) {
            this.isRecording = false;
            if (bo.az(this.fbF) < this.fbI) {
                com.tencent.luggage.g.d.c("MicroMsg.CameraPreviewContainer", "stopRecord " + bo.az(this.fbF), new Object[0]);
                com.tencent.mm.media.widget.b.b bVar2 = this.fbB;
                if (bVar2 != null) {
                    bVar2.cancel();
                }
                bVar2 = this.fbB;
                if (bVar2 != null) {
                    bVar2.clear();
                }
                Wt();
                if (this.fbA.Wq() == null) {
                    AppMethodBeat.o(13234);
                    return false;
                }
                Wu();
                AppMethodBeat.o(13234);
                return false;
            }
            com.tencent.luggage.g.d.c("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
            com.tencent.mm.media.i.a aVar = new com.tencent.mm.media.i.a(JsApiStopRecordVoice.NAME);
            com.tencent.mm.media.widget.b.b bVar3 = this.fbB;
            if (bVar3 != null) {
                bVar3.v(new e(this, aVar, bVar));
            }
            AppMethodBeat.o(13234);
            return true;
        }
        AppMethodBeat.o(13234);
        return true;
    }
}
