package com.tencent.p177mm.media.widget.camerarecordview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Looper;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.p255h.C45432d;
import com.tencent.p177mm.media.p255h.p256b.C1786a;
import com.tencent.p177mm.media.p255h.p256b.C37898e;
import com.tencent.p177mm.media.p255h.p256b.C6629c;
import com.tencent.p177mm.media.p867i.C42174a;
import com.tencent.p177mm.media.widget.camerarecordview.p1465c.C32768a;
import com.tencent.p177mm.media.widget.camerarecordview.p258a.C42176b;
import com.tencent.p177mm.media.widget.camerarecordview.p258a.C9614a;
import com.tencent.p177mm.media.widget.camerarecordview.p869b.C32766a;
import com.tencent.p177mm.media.widget.camerarecordview.preview.C1791c;
import com.tencent.p177mm.media.widget.p257b.C1788b;
import com.tencent.p177mm.media.widget.p868a.C18597d;
import com.tencent.p177mm.media.widget.p868a.C26390e;
import com.tencent.p177mm.media.widget.p868a.C32765b;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0001EB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\u0006\u0010 \u001a\u00020\nJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020\"J.\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0012J\u000e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\"J\u0006\u00101\u001a\u00020\"J\u000e\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u0012J\b\u00104\u001a\u00020\"H\u0002J7\u00105\u001a\u00020\"2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2%\b\u0002\u00106\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\"\u0018\u000107J\u0006\u0010;\u001a\u00020\u000fJ\u0006\u0010<\u001a\u00020\"J-\u0010=\u001a\u00020\u000f2%\b\u0002\u00106\u001a\u001f\u0012\u0013\u0012\u00110>¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\"\u0018\u000107J\u0006\u0010@\u001a\u00020\u000fJ\u001e\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0004R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "audioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "cameraCountNumber", "", "context", "Landroid/content/Context;", "currentState", "initRecorderRet", "", "isRecording", "lastFlipCameraStamp", "", "mediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordMiniTime", "startRecordTimeStamp", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "createRecorder", "getCameraCount", "initRecorder", "", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "onPause", "onResume", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "setRecordMiniTime", "time", "setRender", "startPreview", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "startRecord", "stopPreview", "stopRecord", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "capture", "switchCamera", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.camerarecordview.a */
public final class C9615a {
    public static final C9620a fbL = new C9620a();
    private Context context;
    private int currentState = 1;
    private final C26390e fbA;
    public C1788b fbB;
    private C43303c fbC;
    private final C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private boolean fbE = true;
    private long fbF;
    private long fbG;
    private boolean fbH;
    public long fbI = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    public C32766a fbJ;
    public C32768a fbK;
    public final int fbz = C32468d.getNumberOfCameras();
    public boolean isRecording;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.a$b */
    static final class C9613b extends C25053k implements C17126b<Integer, C37091y> {
        final /* synthetic */ C9615a fbM;

        C9613b(C9615a c9615a) {
            this.fbM = c9615a;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13228);
            ((Number) obj).intValue();
            C1788b b = this.fbM.fbB;
            if (b != null) {
                b.mo5338WG();
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13228);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.a$d */
    static final class C9616d extends C25053k implements C17126b<SurfaceTexture, C37091y> {
        final /* synthetic */ C17126b exI;
        final /* synthetic */ C9615a fbM;
        final /* synthetic */ boolean fbN;

        C9616d(C9615a c9615a, boolean z, C17126b c17126b) {
            this.fbM = c9615a;
            this.fbN = z;
            this.exI = c17126b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13231);
            final SurfaceTexture surfaceTexture = (SurfaceTexture) obj;
            this.fbM.fbD.post(new Runnable(this) {
                final /* synthetic */ C9616d fbO;

                public final void run() {
                    AppMethodBeat.m2504i(13230);
                    this.fbO.fbM.fbA.mo33841a(surfaceTexture, this.fbO.fbM.fbK.mo45657WD(), this.fbO.fbM.fbK.getResolutionLimit());
                    C32765b Wq = this.fbO.fbM.fbA.mo33840Wq();
                    if (Wq != null) {
                        this.fbO.fbM.fbK.getCameraPreviewView().mo5342a(Wq);
                        C9615a.m17115e(this.fbO.fbM);
                        C9615a.m17116f(this.fbO.fbM);
                        C32766a g = this.fbO.fbM.fbJ;
                        boolean z = !this.fbO.fbN && this.fbO.fbM.fbK.mo45658WE();
                        g.mo53311a(z, Wq);
                    }
                    C17126b c17126b = this.fbO.exI;
                    if (c17126b != null) {
                        c17126b.mo50am(Boolean.valueOf(this.fbO.fbM.fbA.mo44176Wh()));
                        AppMethodBeat.m2505o(13230);
                        return;
                    }
                    AppMethodBeat.m2505o(13230);
                }
            });
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13231);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$setRender$renderer$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.a$c */
    public static final class C9618c extends C45432d {
        final /* synthetic */ C9615a fbM;

        C9618c(int i) {
            this.fbM = i;
        }

        /* renamed from: Vc */
        public final C1786a mo20940Vc() {
            AppMethodBeat.m2504i(13229);
            C1786a c37898e;
            if (this.fbM.fbK.mo45657WD()) {
                c37898e = new C37898e(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
                AppMethodBeat.m2505o(13229);
                return c37898e;
            }
            c37898e = new C6629c(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.m2505o(13229);
            return c37898e;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.a$e */
    static final class C9619e implements Runnable {
        final /* synthetic */ C17126b exI;
        final /* synthetic */ C9615a fbM;
        final /* synthetic */ C42174a fbQ;

        C9619e(C9615a c9615a, C42174a c42174a, C17126b c17126b) {
            this.fbM = c9615a;
            this.fbQ = c42174a;
            this.exI = c17126b;
        }

        public final void run() {
            String filePath;
            String str = null;
            AppMethodBeat.m2504i(13232);
            String str2 = "MicroMsg.CameraPreviewContainer";
            StringBuilder stringBuilder = new StringBuilder("stopRecord ");
            C1788b b = this.fbM.fbB;
            stringBuilder = stringBuilder.append(b != null ? b.getFilePath() : null).append(' ');
            b = this.fbM.fbB;
            C45124d.m82924c(str2, stringBuilder.append(b != null ? b.mo14845Wy() : null).toString(), new Object[0]);
            this.fbQ.mo67718SW();
            b = this.fbM.fbB;
            if (b != null) {
                filePath = b.getFilePath();
            } else {
                filePath = null;
            }
            C1788b b2 = this.fbM.fbB;
            if (b2 != null) {
                str = b2.mo14845Wy();
            }
            if (!(filePath == null || str == null)) {
                C9614a c9614a = new C9614a(filePath, str);
                C17126b c17126b = this.exI;
                if (c17126b != null) {
                    c17126b.mo50am(c9614a);
                    AppMethodBeat.m2505o(13232);
                    return;
                }
            }
            AppMethodBeat.m2505o(13232);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$Companion;", "", "()V", "STATE_IN_PAUSE", "", "STATE_IN_PREVIEW", "SWITCH_BLOCK_TIME", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.a$a */
    public static final class C9620a {
        private C9620a() {
        }

        public /* synthetic */ C9620a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(13246);
        AppMethodBeat.m2505o(13246);
    }

    public C9615a(C32768a c32768a) {
        C25052j.m39376p(c32768a, "process");
        AppMethodBeat.m2504i(13245);
        this.fbK = c32768a;
        C45124d.m82924c("MicroMsg.CameraPreviewContainer", this.fbK.toString(), new Object[0]);
        C1791c cameraPreviewView = this.fbK.getCameraPreviewView();
        if (this.fbK.getPreviewRenderer() != null) {
            C37897a previewRenderer = this.fbK.getPreviewRenderer();
            if (previewRenderer == null) {
                C25052j.dWJ();
            }
            cameraPreviewView.mo5341a(previewRenderer, this.fbK.mo45657WD());
        } else {
            cameraPreviewView.mo5341a(new C9618c(this), this.fbK.mo45657WD());
        }
        this.fbA = new C18597d(this.fbK.getContext());
        this.fbG = C5046bo.m7588yz();
        this.context = this.fbK.getContext();
        this.fbJ = new C32766a(this.context, this.fbK);
        AppMethodBeat.m2505o(13245);
    }

    /* renamed from: e */
    public static final /* synthetic */ boolean m17115e(C9615a c9615a) {
        AppMethodBeat.m2504i(13247);
        boolean Wt = c9615a.m17109Wt();
        AppMethodBeat.m2505o(13247);
        return Wt;
    }

    /* renamed from: f */
    public static final /* synthetic */ void m17116f(C9615a c9615a) {
        AppMethodBeat.m2504i(13248);
        c9615a.m17110Wu();
        AppMethodBeat.m2505o(13248);
    }

    /* renamed from: EL */
    public final boolean mo20930EL() {
        AppMethodBeat.m2504i(13233);
        C45124d.m82924c("MicroMsg.CameraPreviewContainer", JsApiStartRecordVoice.NAME, new Object[0]);
        if (this.fbA.mo33840Wq() == null || this.fbB == null) {
            C45124d.m82924c("MicroMsg.CameraPreviewContainer", "cameraConfig is null", new Object[0]);
            AppMethodBeat.m2505o(13233);
            return false;
        } else if (this.fbH) {
            C1788b c1788b = this.fbB;
            Object valueOf = c1788b != null ? Integer.valueOf(c1788b.mo14848b(C32765b.m53502Wi(), false, 0)) : null;
            C45124d.m82929i("MicroMsg.CameraPreviewContainer", "start record ret:".concat(String.valueOf(valueOf)));
            if (valueOf != null && valueOf.intValue() == 0) {
                this.fbF = C5046bo.m7588yz();
                this.isRecording = true;
                AppMethodBeat.m2505o(13233);
                return true;
            }
            AppMethodBeat.m2505o(13233);
            return false;
        } else {
            C45124d.m82929i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
            AppMethodBeat.m2505o(13233);
            return false;
        }
    }

    /* renamed from: b */
    public final void mo20936b(float f, float f2, int i, int i2) {
        AppMethodBeat.m2504i(13235);
        if (this.currentState == 0) {
            this.fbA.mo33845b(f, f2, i, i2);
        }
        AppMethodBeat.m2505o(13235);
    }

    /* renamed from: Wp */
    public final void mo20932Wp() {
        AppMethodBeat.m2504i(13236);
        if (this.currentState == 0) {
            this.fbA.mo33839Wp();
        }
        AppMethodBeat.m2505o(13236);
    }

    /* renamed from: km */
    public final void mo20937km(int i) {
        AppMethodBeat.m2504i(13237);
        if (this.currentState == 0) {
            this.fbA.mo33847kj(i);
        }
        AppMethodBeat.m2505o(13237);
    }

    /* renamed from: a */
    public final void mo20934a(boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(13238);
        if (this.currentState == 0) {
            this.fbA.mo33844a(z, z2, i);
        }
        AppMethodBeat.m2505o(13238);
    }

    /* renamed from: Wg */
    public final boolean mo20931Wg() {
        AppMethodBeat.m2504i(13239);
        C45124d.m82929i("MicroMsg.CameraPreviewContainer", "flipCamera time space:" + C5046bo.m7525az(this.fbG));
        boolean z;
        if (C5046bo.m7525az(this.fbG) < 1000) {
            z = this.fbE;
            AppMethodBeat.m2505o(13239);
            return z;
        }
        this.fbG = C5046bo.m7588yz();
        this.fbK.getCameraPreviewView().mo5340WB();
        this.fbE = this.fbA.mo44175Wg();
        C32765b Wq = this.fbA.mo33840Wq();
        C32766a c32766a = this.fbJ;
        z = !this.fbE && this.fbK.mo45658WE();
        c32766a.mo53311a(z, Wq);
        if (Wq != null) {
            this.fbK.getCameraPreviewView().mo5342a(Wq);
            C26393b c26393b = C26393b.fbR;
            C37897a renderer = C26393b.getRenderer();
            if (renderer != null) {
                renderer.mo60641ch(C32765b.getPreviewWidth(), C32765b.getPreviewHeight());
            }
            c26393b = C26393b.fbR;
            renderer = C26393b.getRenderer();
            if (renderer != null) {
                renderer.mo60646ka(C32765b.m53502Wi());
            }
            c26393b = C26393b.fbR;
            renderer = C26393b.getRenderer();
            if (renderer != null) {
                renderer.mo60644ct(C32765b.m53505Wl());
            }
        }
        z = this.fbE;
        AppMethodBeat.m2505o(13239);
        return z;
    }

    /* renamed from: Wt */
    private final boolean m17109Wt() {
        AppMethodBeat.m2504i(13240);
        C1788b c1788b = this.fbB;
        if (c1788b != null) {
            c1788b.cancel();
            c1788b.clear();
        }
        C42176b encodeConfig = this.fbK.getEncodeConfig();
        if (this.fbK.getCameraPreviewView().getEGLContext() == null) {
            AppMethodBeat.m2505o(13240);
            return false;
        }
        C9615a c9615a;
        C26393b c26393b;
        if (this.fbK.getRecorder() != null) {
            c1788b = this.fbK.getRecorder();
            c9615a = this;
        } else if (this.fbK.mo45657WD()) {
            c26393b = C26393b.fbR;
            c1788b = C26393b.m42009a(encodeConfig.mo26019Ww(), this.fbK.getVideoTransPara(), this.fbA, this.fbK.getRecordRenderer());
            c9615a = this;
        } else {
            c26393b = C26393b.fbR;
            int Ww = encodeConfig.mo26019Ww();
            VideoTransPara videoTransPara = this.fbK.getVideoTransPara();
            C26390e c26390e = this.fbA;
            EGLContext eGLContext = this.fbK.getCameraPreviewView().getEGLContext();
            if (eGLContext == null) {
                C25052j.dWJ();
            }
            c1788b = C26393b.m42008a(Ww, videoTransPara, c26390e, eGLContext, this.fbK.getCameraPreviewView(), this.fbK.mo45657WD(), this.fbK.getRecordRenderer());
            c9615a = this;
        }
        c9615a.fbB = c1788b;
        c1788b = this.fbB;
        if (c1788b != null) {
            c1788b.setMute(this.fbK.mo45656DX());
        }
        if (encodeConfig.getSampleRate() > 0 && encodeConfig.mo26020Wx() > 0) {
            c26393b = C26393b.fbR;
            this.fbC = C26393b.m42010cl(encodeConfig.getSampleRate(), encodeConfig.mo26020Wx());
        }
        this.fbK.getCameraPreviewView().setOnDrawListener(new C9613b(this));
        AppMethodBeat.m2505o(13240);
        return true;
    }

    /* renamed from: Wu */
    private final void m17110Wu() {
        boolean ko;
        String str = null;
        AppMethodBeat.m2504i(13241);
        C1788b c1788b = this.fbB;
        if (c1788b != null) {
            c1788b.mo14862s(C32765b.getPreviewWidth(), C32765b.getPreviewHeight(), C32765b.m53503Wj(), C32765b.m53504Wk());
        }
        if (c1788b != null) {
            c1788b.setFilePath(this.fbK.getEncodeConfig().getFilePath());
        }
        if (c1788b != null) {
            c1788b.mo14858mb(this.fbK.getEncodeConfig().mo26021Wy());
        }
        String str2 = "MicroMsg.CameraPreviewContainer";
        StringBuilder append = new StringBuilder("filePath : ").append(c1788b != null ? c1788b.getFilePath() : null).append("   thumbPath : ");
        if (c1788b != null) {
            str = c1788b.mo14845Wy();
        }
        C45124d.m82924c(str2, append.append(str).toString(), new Object[0]);
        C1788b c1788b2 = this.fbB;
        if (c1788b2 != null) {
            ko = c1788b2.mo14856ko(C32765b.m53502Wi());
        } else {
            ko = false;
        }
        if (!ko) {
            C45124d.m82924c("MicroMsg.CameraPreviewContainer", "init recorder ret:".concat(String.valueOf(ko)), new Object[0]);
        }
        this.fbH = ko;
        AppMethodBeat.m2505o(13241);
    }

    /* renamed from: a */
    public final void mo20933a(boolean z, C17126b<? super Boolean, C37091y> c17126b) {
        AppMethodBeat.m2504i(13242);
        if (this.currentState == 0) {
            AppMethodBeat.m2505o(13242);
            return;
        }
        this.currentState = 0;
        C45124d.m82924c("MicroMsg.CameraPreviewContainer", "startPreview process.useCpuCrop():" + this.fbK.mo45657WD(), new Object[0]);
        this.fbE = z;
        this.fbA.mo33848o(this.fbK.getContext(), z);
        if (this.fbK.mo45657WD()) {
            this.fbA.mo33843a(this.fbK.getCameraPreviewView().getFrameDataCallback());
        }
        this.fbK.getCameraPreviewView().mo5343b(new C9616d(this, z, c17126b));
        AppMethodBeat.m2505o(13242);
    }

    public final void stopPreview() {
        AppMethodBeat.m2504i(13244);
        if (this.currentState == 1) {
            AppMethodBeat.m2505o(13244);
            return;
        }
        this.currentState = 1;
        C45124d.m82924c("MicroMsg.CameraPreviewContainer", "stopPreview", new Object[0]);
        try {
            this.fbA.release();
        } catch (Exception e) {
            C45124d.printErrStackTrace("MicroMsg.CameraPreviewContainer", e, "camera relase error:" + e.getMessage(), new Object[0]);
        }
        this.fbA.mo33846b(this.fbK.getCameraPreviewView().getFrameDataCallback());
        this.fbK.getCameraPreviewView().mo5339WA();
        this.fbJ.mo53311a(false, null);
        AppMethodBeat.m2505o(13244);
    }

    /* renamed from: a */
    public final boolean mo20935a(C17126b<? super C9614a, C37091y> c17126b) {
        AppMethodBeat.m2504i(13234);
        if (this.isRecording) {
            this.isRecording = false;
            if (C5046bo.m7525az(this.fbF) < this.fbI) {
                C45124d.m82924c("MicroMsg.CameraPreviewContainer", "stopRecord " + C5046bo.m7525az(this.fbF), new Object[0]);
                C1788b c1788b = this.fbB;
                if (c1788b != null) {
                    c1788b.cancel();
                }
                c1788b = this.fbB;
                if (c1788b != null) {
                    c1788b.clear();
                }
                m17109Wt();
                if (this.fbA.mo33840Wq() == null) {
                    AppMethodBeat.m2505o(13234);
                    return false;
                }
                m17110Wu();
                AppMethodBeat.m2505o(13234);
                return false;
            }
            C45124d.m82924c("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
            C42174a c42174a = new C42174a(JsApiStopRecordVoice.NAME);
            C1788b c1788b2 = this.fbB;
            if (c1788b2 != null) {
                c1788b2.mo14865v(new C9619e(this, c42174a, c17126b));
            }
            AppMethodBeat.m2505o(13234);
            return true;
        }
        AppMethodBeat.m2505o(13234);
        return true;
    }
}
