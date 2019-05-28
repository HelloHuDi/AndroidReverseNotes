package com.tencent.p177mm.plugin.facedetect.p403ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45571aj;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C33244g;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C42475m;
import com.tencent.p177mm.plugin.appbrand.jsapi.bio.face.C33253d;
import com.tencent.p177mm.plugin.appbrand.jsapi.bio.face.C38272c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bio.face.C45581b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1225h.C26996a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1225h.C26996a.C26998a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26982f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C10503e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C27057d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C27059f;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C19480k;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19483d;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19484j;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19486m;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C19517g;
import com.tencent.p177mm.plugin.facedetect.model.C11810f;
import com.tencent.p177mm.plugin.facedetect.model.C43032g;
import com.tencent.p177mm.plugin.facedetect.model.C43033h;
import com.tencent.p177mm.plugin.facedetect.model.C43033h.C39012a;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetect.p400c.C11795f;
import com.tencent.p177mm.plugin.facedetect.p400c.C34094b;
import com.tencent.p177mm.plugin.facedetect.p400c.C39010a;
import com.tencent.p177mm.plugin.facedetect.p401d.C11802b.C11803b;
import com.tencent.p177mm.plugin.facedetect.p401d.C11802b.C11805c;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a;
import com.tencent.p177mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.p177mm.plugin.facedetect.views.C11821a;
import com.tencent.p177mm.plugin.facedetect.views.C45920c;
import com.tencent.p177mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.p177mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.p177mm.plugin.facedetect.views.FaceDetectView.C341154;
import com.tencent.p177mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.p177mm.plugin.facedetect.views.FaceScanRect.C20663a;
import com.tencent.p177mm.plugin.facedetect.views.FaceScanRect.C20664b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI */
public class FaceDetectUI extends MMActivity implements C11795f, C11821a {
    private String edV = null;
    private int lSf = -1;
    private C39010a lWT = null;
    private C34109a lWU = null;
    private FaceTutorial lWV = null;
    private C20650b lXA = null;
    private boolean lXB = false;
    private boolean lXC = false;
    private View lXD = null;
    private RelativeLayout lXE;
    FaceDetectView lXF = null;
    FaceScanRect lXG = null;
    private TextView lXH = null;
    private Button lXI = null;
    private FaceDetectProcessService lXJ = null;
    private ServiceConnection lXK = null;
    private boolean lXL = false;
    private boolean lXM = false;
    private C45920c lXN = null;
    private String lXd;
    C43033h lXz = null;
    boolean lsZ = false;
    private WakeLock wakeLock = null;

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$1 */
    class C30451 implements OnClickListener {
        C30451() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED);
            C4990ab.m7416i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
            FaceDetectUI.m31885a(FaceDetectUI.this);
            AppMethodBeat.m2505o(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$2 */
    class C30462 implements Runnable {
        C30462() {
        }

        public final void run() {
            AppMethodBeat.m2504i(459);
            long yz = C5046bo.m7588yz();
            Runtime.getRuntime().gc();
            C4990ab.m7417i("MicroMsg.FaceDetectUI", "hy: gc uses: %d ms", Long.valueOf(C5046bo.m7525az(yz)));
            AppMethodBeat.m2505o(459);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$10 */
    class C2064710 implements AnimationListener {
        C2064710() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(470);
            FaceDetectUI.m31900l(FaceDetectUI.this);
            AppMethodBeat.m2505o(470);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$b */
    class C20650b {
        private boolean lXU;
        boolean lXV;
        private boolean lXW;
        private final boolean lXX;

        private C20650b() {
            this.lXU = true;
            this.lXV = false;
            this.lXW = true;
            this.lXX = true;
        }

        /* synthetic */ C20650b(FaceDetectUI faceDetectUI, byte b) {
            this();
        }

        public final synchronized void btu() {
            this.lXV = true;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void reset() {
            this.lXV = false;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void btv() {
            AppMethodBeat.m2504i(471);
            C4990ab.m7417i("MicroMsg.FaceDetectUI", "toString: %s", toString());
            if (this.lXU && this.lXV && this.lXW) {
                FaceDetectUI.this.lXE.setVisibility(0);
            }
            AppMethodBeat.m2505o(471);
        }

        public final String toString() {
            AppMethodBeat.m2504i(C10503e.CTRL_INDEX);
            String str = "InitHandler{isCgiInitDone=" + this.lXU + ", isCameraInitDone=" + this.lXV + ", isLightInitDone=true, isLibraryInitDone=" + this.lXW + '}';
            AppMethodBeat.m2505o(C10503e.CTRL_INDEX);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$4 */
    class C206514 implements ServiceConnection {
        C206514() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(461);
            C4990ab.m7417i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", componentName);
            FaceDetectUI.this.lXL = true;
            FaceDetectUI.this.lXJ = FaceDetectProcessService.this;
            C11810f c11810f = C11810f.lTL;
            FaceDetectProcessService d = FaceDetectUI.this.lXJ;
            C4990ab.m7417i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", C5046bo.m7524aw(C4996ah.getContext(), Process.myPid()), Integer.valueOf(c11810f.hashCode()));
            c11810f.lTM = d;
            C4990ab.m7417i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", Integer.valueOf(FaceDetectUI.this.lXJ.hashCode()));
            FaceDetectUI.m31891e(FaceDetectUI.this);
            AppMethodBeat.m2505o(461);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(462);
            C4990ab.m7417i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", componentName.toString());
            FaceDetectUI.this.lXL = false;
            AppMethodBeat.m2505o(462);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$5 */
    class C206525 implements C45920c {
        C206525() {
        }

        /* renamed from: vt */
        public final void mo35946vt(int i) {
            AppMethodBeat.m2504i(463);
            C4990ab.m7417i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", Integer.valueOf(i));
            if (i == 0) {
                FaceDetectUI.m31893f(FaceDetectUI.this);
                AppMethodBeat.m2505o(463);
            } else if (i == 1) {
                FaceDetectUI.m31895g(FaceDetectUI.this);
                AppMethodBeat.m2505o(463);
            } else {
                if (i == 2) {
                    FaceDetectUI.m31886a(FaceDetectUI.this, "camera permission not granted", FaceDetectUI.this.getString(C25738R.string.dbs));
                }
                AppMethodBeat.m2505o(463);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$6 */
    class C206536 implements Runnable {
        C206536() {
        }

        public final void run() {
            int i;
            int[] iArr = null;
            AppMethodBeat.m2504i(C19480k.CTRL_INDEX);
            C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo dismiss cover and start capture");
            FaceDetectUI.this.lXA.btu();
            FaceDetectUI.this.lXA.btv();
            FaceDetectUI faceDetectUI = FaceDetectUI.this;
            if (C43033h.lTS == null) {
                C43033h.lTS = new C43033h();
            }
            faceDetectUI.lXz = C43033h.lTS;
            C43033h c43033h = faceDetectUI.lXz;
            c43033h.lfO = 0;
            c43033h.lTQ = null;
            c43033h.lTR = -1;
            c43033h = faceDetectUI.lXz;
            C43032g c43032g = C11810f.lTL.lTM.lVR;
            if (c43032g.lTP == null) {
                C4990ab.m7412e("MicroMsg.FaceDetectNativeManager", "hy: get all motion not init");
            } else {
                iArr = c43032g.lTP.engineGetAllMotions();
            }
            c43033h.lTQ = iArr;
            if (c43033h.lTQ == null) {
                i = 0;
            } else {
                i = c43033h.lTQ.length;
            }
            c43033h.lTR = i;
            faceDetectUI.lsZ = true;
            FaceDetectView faceDetectView = faceDetectUI.lXF;
            RectF rectF = new RectF((float) faceDetectUI.lXG.getLeft(), (float) faceDetectUI.lXG.getTop(), (float) faceDetectUI.lXG.getRight(), (float) faceDetectUI.lXG.getBottom());
            FaceDetectDecorView faceDetectDecorView = faceDetectView.maB;
            String str = "MicroMsg.FaceDetectDecorView";
            String str2 = "hy: trigger showCover cover: %s, old: %s";
            Object[] objArr = new Object[2];
            objArr[0] = rectF.toString();
            objArr[1] = faceDetectDecorView.may == null ? BuildConfig.COMMAND : faceDetectDecorView.may.toString();
            C4990ab.m7417i(str, str2, objArr);
            faceDetectDecorView.mav = true;
            if (faceDetectDecorView.may == null || !faceDetectDecorView.may.equals(rectF)) {
                faceDetectDecorView.may = rectF;
                C4990ab.m7417i("MicroMsg.FaceDetectDecorView", "alvinluo invalidate %s", faceDetectDecorView.may.toString());
                faceDetectDecorView.invalidate();
            }
            faceDetectUI.btq();
            AppMethodBeat.m2505o(C19480k.CTRL_INDEX);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$9 */
    class C206549 implements C20656a {
        C206549() {
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(C33244g.CTRL_INDEX);
            C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
            FaceDetectUI.this.lXM = true;
            FaceDetectUI.this.mo23589a(0, 0, "collect data ok", null);
            AppMethodBeat.m2505o(C33244g.CTRL_INDEX);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$3 */
    class C206553 implements C20664b {
        C206553() {
        }

        public final void btt() {
            AppMethodBeat.m2504i(460);
            FaceDetectView c = FaceDetectUI.this.lXF;
            RectF rectF = new RectF((float) FaceDetectUI.this.lXG.getLeft(), (float) FaceDetectUI.this.lXG.getTop(), (float) FaceDetectUI.this.lXG.getRight(), (float) FaceDetectUI.this.lXG.getBottom());
            FaceDetectDecorView faceDetectDecorView = c.maB;
            faceDetectDecorView.mav = true;
            faceDetectDecorView.maw = true;
            faceDetectDecorView.may = rectF;
            faceDetectDecorView.invalidate();
            AppMethodBeat.m2505o(460);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$a */
    interface C20656a {
        void onFinish();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m31885a(FaceDetectUI faceDetectUI) {
        AppMethodBeat.m2504i(494);
        faceDetectUI.bth();
        AppMethodBeat.m2505o(494);
    }

    /* renamed from: l */
    static /* synthetic */ void m31900l(FaceDetectUI faceDetectUI) {
        AppMethodBeat.m2504i(C19484j.CTRL_INDEX);
        faceDetectUI.btq();
        AppMethodBeat.m2505o(C19484j.CTRL_INDEX);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(473);
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        this.edV = getIntent().getStringExtra("k_user_name");
        this.lSf = getIntent().getIntExtra("k_server_scene", -1);
        this.lXd = getIntent().getStringExtra("business_tips");
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.bsJ().mo54648a(faceDetectReporter);
        }
        C34094b c34094b = C34094b.lTj;
        this.lWT = C34094b.m55881a(this, this, this.lSf, 0, getIntent().getExtras());
        C43036p.m76429N(this);
        this.lXI = (Button) findViewById(2131823808);
        this.lXI.setOnClickListener(new C30451());
        this.lXD = findViewById(2131823805);
        this.lXD.setVisibility(8);
        this.lXE = (RelativeLayout) findViewById(2131823807);
        this.lXG = (FaceScanRect) findViewById(2131823809);
        this.lXF = (FaceDetectView) findViewById(2131823806);
        this.lXH = (TextView) findViewById(2131823810);
        this.lXF.setCallback(this);
        this.lXF.setBusinessTip(this.lXd);
        FaceDetectView faceDetectView = this.lXF;
        RelativeLayout relativeLayout = this.lXE;
        ViewGroup centerHintHolder = this.lXG.getCenterHintHolder();
        faceDetectView.maC = relativeLayout;
        faceDetectView.maD = centerHintHolder;
        this.lXF.setErrTextView(this.lXH);
        this.lXF.mo61942m(true, this.edV);
        this.lXG.setOnRefreshRectListener(new C206553());
        this.lXG.setVisibility(4);
        this.lXA = new C20650b(this, (byte) 0);
        AppMethodBeat.m2505o(473);
    }

    private void boF() {
        AppMethodBeat.m2504i(JsApiAddDownloadTask.CTRL_INDEX);
        C4990ab.m7417i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", Boolean.valueOf(this.lXL));
        if (this.lXL) {
            C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
            C25985d.m41456a(this.lXK, "tools");
            this.lXL = false;
        }
        AppMethodBeat.m2505o(JsApiAddDownloadTask.CTRL_INDEX);
    }

    public final void bsp() {
    }

    public void onStart() {
        AppMethodBeat.m2504i(JsApiCancelDownloadTask.CTRL_INDEX);
        super.onStart();
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo onStart");
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
        }
        if (!this.wakeLock.isHeld()) {
            C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
            this.wakeLock.acquire();
        }
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("key_face_service_connection_from", 2);
        this.lXK = new C206514();
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo bindService");
        C25985d.m41462a(intent, this.lXK, "tools");
        AppMethodBeat.m2505o(JsApiCancelDownloadTask.CTRL_INDEX);
    }

    public void onStop() {
        AppMethodBeat.m2504i(JsApiOpenAdCanvas.CTRL_INDEX);
        super.onStop();
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
        boF();
        if (this.lXM) {
            finish();
            AppMethodBeat.m2505o(JsApiOpenAdCanvas.CTRL_INDEX);
            return;
        }
        mo23589a(1, 90006, "cancel with on stop", null);
        AppMethodBeat.m2505o(JsApiOpenAdCanvas.CTRL_INDEX);
    }

    public final int getLayoutId() {
        return 2130969475;
    }

    public final void bsk() {
        AppMethodBeat.m2504i(C45581b.CTRL_INDEX);
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.9f) {
            attributes.screenBrightness = 0.9f;
            getWindow().setAttributes(attributes);
        }
        this.lXG.mbN = C20663a.INIT;
        FaceScanRect faceScanRect = this.lXG;
        if (faceScanRect.mbN == C20663a.OPENED) {
            C4990ab.m7420w("MicroMsg.FaceScanRect", "hy: already opened");
        } else {
            faceScanRect.mbM.setVisibility(0);
            faceScanRect.mbv.setBackgroundResource(C25738R.drawable.b3u);
            faceScanRect.mbM.startAnimation(faceScanRect.mbJ);
            for (View view : faceScanRect.mbE) {
                view.clearAnimation();
                view.setBackgroundColor(faceScanRect.getResources().getColor(C25738R.color.a69));
            }
            faceScanRect.mbN = C20663a.OPENED;
        }
        this.lXF.maB.mau = false;
        this.lXG.setVisibility(0);
        C4990ab.m7411d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", Integer.valueOf(this.lXG.getTop()), Integer.valueOf(this.lXG.getRight()), Integer.valueOf(this.lXG.getLeft()), Integer.valueOf(this.lXG.getBottom()));
        this.lXB = true;
        this.lsZ = false;
        this.lXA.reset();
        if (this.lXB) {
            this.lXN = new C206525();
            C4990ab.m7416i("MicroMsg.FaceDetectUI", "hy: start preview");
            C45920c c45920c = this.lXN;
            FaceDetectView faceDetectView = this.lXF;
            faceDetectView.maA.mo45839a(new C341154(c45920c));
        }
        AppMethodBeat.m2505o(C45581b.CTRL_INDEX);
    }

    public final void bsm() {
        AppMethodBeat.m2504i(C38272c.CTRL_INDEX);
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
        if (!this.lXC) {
            this.lXN = null;
            this.lXC = true;
            if (this.lXA.lXV) {
                bts();
                this.lXF.maA.mae.btG();
            }
            if (this.wakeLock != null && this.wakeLock.isHeld()) {
                this.wakeLock.release();
                this.wakeLock = null;
            }
            C7305d.post(new C30462(), "Face_active_gc");
        }
        boF();
        AppMethodBeat.m2505o(C38272c.CTRL_INDEX);
    }

    /* renamed from: a */
    public final void mo23589a(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.m2504i(479);
        C4990ab.m7417i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 0 && i2 != 0 && C27922a.btw().isStarted() && C27922a.btw().lZc) {
            C27922a.btw().bty();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("key_parcelable_reporter", FaceDetectReporter.bsJ());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m31892f(i, i2, str, bundle2);
        finish();
        AppMethodBeat.m2505o(479);
    }

    /* Access modifiers changed, original: final */
    public final void btq() {
        AppMethodBeat.m2504i(480);
        if (this.lsZ) {
            C4990ab.m7416i("MicroMsg.FaceDetectUI", "hy: start capture face");
            FaceDetectView faceDetectView = this.lXF;
            Rect rect = new Rect(this.lXG.getLeft(), this.lXG.getTop(), this.lXG.getRight(), this.lXG.getBottom());
            C39012a bsI = C43033h.bsI();
            if (bsI.type == 100) {
                AppMethodBeat.m2505o(480);
                return;
            }
            if (faceDetectView.maF != null) {
                faceDetectView.maF.bsX();
            }
            faceDetectView.eTf = false;
            faceDetectView.isPaused = false;
            faceDetectView.maL = C5046bo.m7588yz();
            faceDetectView.maJ = bsI.lTV;
            faceDetectView.maI = bsI.gJH;
            C4990ab.m7416i("MicroMsg.FaceDetectView", "carson logic");
            C4990ab.m7416i("MicroMsg.FaceDetectView", "item.hintStr" + bsI.gJH);
            faceDetectView.lTW = bsI.lTW;
            faceDetectView.maG = true;
            faceDetectView.maK = bsI.lTZ;
            faceDetectView.maF = C11805c.m19653a(bsI);
            if (faceDetectView.maF != null) {
                if (faceDetectView.maC != null) {
                    faceDetectView.maC.removeAllViews();
                }
                if (faceDetectView.maD != null) {
                    faceDetectView.maD.removeAllViews();
                }
                faceDetectView.maF.mo7238a(faceDetectView.getContext(), faceDetectView.maC, faceDetectView.maD);
                C4990ab.m7410d("MicroMsg.FaceDetectView", "mBusinessTip : " + faceDetectView.lXd);
                faceDetectView.maF.setBusinessTip(faceDetectView.lXd);
            }
            if (faceDetectView.maA != null) {
                faceDetectView.maA.mo45838a(rect, bsI.lTT);
            }
            faceDetectView.maH = false;
        }
        AppMethodBeat.m2505o(480);
    }

    private void stopPreview() {
        AppMethodBeat.m2504i(C42475m.CTRL_INDEX);
        this.lXB = false;
        this.lXF.maA.mae.stopPreview();
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "hy: stopped preview");
        AppMethodBeat.m2505o(C42475m.CTRL_INDEX);
    }

    private void btr() {
        AppMethodBeat.m2504i(482);
        this.lsZ = false;
        this.lXF.mo61941hc(false);
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "hy: stopped scan");
        AppMethodBeat.m2505o(482);
    }

    private void bts() {
        AppMethodBeat.m2504i(C19517g.CTRL_INDEX);
        btr();
        stopPreview();
        AppMethodBeat.m2505o(C19517g.CTRL_INDEX);
    }

    /* renamed from: a */
    public final void mo23590a(boolean z, boolean z2, C3048c c3048c) {
        AppMethodBeat.m2504i(484);
        if (z) {
            bts();
        }
        if (z2) {
            C4990ab.m7416i("MicroMsg.FaceDetectUI", "hy: need blur");
            final Bitmap previewBm = this.lXF.getPreviewBm();
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(C45571aj.CTRL_INDEX);
                    C4996ah.getContext();
                    final Bitmap n = C43036p.m76433n(FaceDetectUI.this.edV, previewBm);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(JsApiShowUpdatableMessageSubscribeButton.CTRL_INDEX);
                            FaceDetectUI.this.lWU.mo23623M(n);
                            AppMethodBeat.m2505o(JsApiShowUpdatableMessageSubscribeButton.CTRL_INDEX);
                        }
                    });
                    AppMethodBeat.m2505o(C45571aj.CTRL_INDEX);
                }
            }, "FaceDetectUI_BlurBgMap");
        }
        this.lWU.mo23624a(c3048c);
        AppMethodBeat.m2505o(484);
    }

    /* renamed from: t */
    private void m31902t(int i, String str, String str2) {
        AppMethodBeat.m2504i(485);
        C4990ab.m7417i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(4), Integer.valueOf(i), str);
        Bundle bundle = new Bundle();
        bundle.putString("show_err_msg", str2);
        bts();
        mo23589a(4, i, str, bundle);
        AppMethodBeat.m2505o(485);
    }

    /* renamed from: d */
    public final void mo23594d(int i, int i2, String str, Bundle bundle) {
    }

    /* renamed from: T */
    public final void mo23631T(int i, String str) {
        boolean z = true;
        AppMethodBeat.m2504i(486);
        C4990ab.m7417i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", Integer.valueOf(i));
        if (!FaceCharacteristicsResult.m19655vi(i)) {
            boolean z2;
            C43033h c43033h = this.lXz;
            if (c43033h.lfO >= c43033h.lTR - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                C4990ab.m7416i("MicroMsg.FaceDetectUI", "hy: collect data ok");
                this.lXF.mo61941hc(true);
                final Bitmap previewBm = this.lXF.getPreviewBm();
                String str2 = "MicroMsg.FaceDetectUI";
                String str3 = "alvinluo bitmap == null: %b";
                Object[] objArr = new Object[1];
                if (previewBm != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                C4990ab.m7417i(str2, str3, objArr);
                final C206549 c206549 = new C206549();
                C7305d.post(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectUI$8$1 */
                    class C30471 implements Runnable {
                        C30471() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(C26996a.CTRL_INDEX);
                            if (c206549 != null) {
                                c206549.onFinish();
                            }
                            AppMethodBeat.m2505o(C26996a.CTRL_INDEX);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(C26998a.CTRL_INDEX);
                        C4996ah.getContext();
                        C43036p.m76433n(FaceDetectUI.this.edV, previewBm);
                        C5004al.m7441d(new C30471());
                        AppMethodBeat.m2505o(C26998a.CTRL_INDEX);
                    }
                }, "save_face_bitmap");
                AppMethodBeat.m2505o(486);
                return;
            }
            c43033h = this.lXz;
            C43032g c43032g = C11810f.lTL.lTM.lVR;
            if (c43032g.lTP == null) {
                C4990ab.m7412e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
            } else {
                C4990ab.m7416i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
                c43032g.lTP.engineNextMotion();
            }
            c43033h.lfO++;
            int i2 = C43033h.bsI().type;
            C4990ab.m7417i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", Integer.valueOf(i2));
            if (C43033h.bsI().lTY) {
                this.lXG.mo35958b(new C2064710());
                AppMethodBeat.m2505o(486);
                return;
            }
            C4990ab.m7417i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", Integer.valueOf(i2));
            btq();
            AppMethodBeat.m2505o(486);
        } else if (i == 3) {
            m31902t(90017, "face detect time out", str);
            AppMethodBeat.m2505o(486);
        } else if (i == 6 || i == 5) {
            m31902t(90023, "face track failed or not stable", str);
            AppMethodBeat.m2505o(486);
        } else if (i == 7) {
            m31902t(90009, "audio permission not granted", C4996ah.getContext().getString(C25738R.string.dc0));
            AppMethodBeat.m2505o(486);
        } else {
            m31902t(90018, "system error", str);
            AppMethodBeat.m2505o(486);
        }
    }

    /* renamed from: vs */
    public final void mo23632vs(int i) {
        AppMethodBeat.m2504i(487);
        if (i == 1) {
            this.lXG.mo35958b(null);
        }
        AppMethodBeat.m2505o(487);
    }

    private void bth() {
        AppMethodBeat.m2504i(C27059f.CTRL_INDEX);
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
        C11803b currentMotionCancelInfo = this.lXF.getCurrentMotionCancelInfo();
        mo23589a(1, currentMotionCancelInfo.errCode, currentMotionCancelInfo.aIm, null);
        AppMethodBeat.m2505o(C27059f.CTRL_INDEX);
    }

    /* renamed from: f */
    private void m31892f(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.m2504i(489);
        setResult(-1, FaceDetectUI.m31894g(i, i2, str, bundle));
        AppMethodBeat.m2505o(489);
    }

    /* renamed from: g */
    private static Intent m31894g(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.m2504i(490);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_type", i);
        bundle2.putInt("err_code", i2);
        bundle2.putString("err_msg", str);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        AppMethodBeat.m2505o(490);
        return intent;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(C27057d.CTRL_INDEX);
        C4990ab.m7417i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", Integer.valueOf(hashCode()));
        super.onDestroy();
        AppMethodBeat.m2505o(C27057d.CTRL_INDEX);
    }

    public void finish() {
        AppMethodBeat.m2504i(C26982f.CTRL_INDEX);
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo finish");
        if (this.lWU != null && this.lWU.aFF()) {
            this.lWU.dismiss();
        }
        if (this.lWV != null) {
            this.lWV.dismiss();
        }
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
        bsm();
        super.finish();
        AppMethodBeat.m2505o(C26982f.CTRL_INDEX);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(FacebookRequestErrorClassification.ESC_APP_INACTIVE);
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
        bth();
        AppMethodBeat.m2505o(FacebookRequestErrorClassification.ESC_APP_INACTIVE);
    }

    /* renamed from: e */
    static /* synthetic */ void m31891e(FaceDetectUI faceDetectUI) {
        AppMethodBeat.m2504i(C33253d.CTRL_INDEX);
        C4990ab.m7416i("MicroMsg.FaceDetectUI", "alvinluo start");
        faceDetectUI.bsk();
        AppMethodBeat.m2505o(C33253d.CTRL_INDEX);
    }

    /* renamed from: f */
    static /* synthetic */ void m31893f(FaceDetectUI faceDetectUI) {
        AppMethodBeat.m2504i(C19486m.CTRL_INDEX);
        C4990ab.m7418v("MicroMsg.FaceDetectUI", "alvinluo onPreviewDone");
        if (C27922a.btw().lZc) {
            C27922a.btw().mo45818a(faceDetectUI.lXF.getCameraRotation(), faceDetectUI.lXF.getCameraPreivewWidth(), faceDetectUI.lXF.getCameraPreviewHeight(), faceDetectUI.lXF.getCameraBestWidth(), faceDetectUI.lXF.getCameraPreviewHeight(), true);
        }
        faceDetectUI.lXF.mo61942m(false, faceDetectUI.edV);
        C5004al.m7442n(new C206536(), 500);
        AppMethodBeat.m2505o(C19486m.CTRL_INDEX);
    }

    /* renamed from: g */
    static /* synthetic */ void m31895g(FaceDetectUI faceDetectUI) {
        AppMethodBeat.m2504i(C19483d.CTRL_INDEX);
        faceDetectUI.m31902t(90016, "preview error", faceDetectUI.getString(C25738R.string.er5));
        AppMethodBeat.m2505o(C19483d.CTRL_INDEX);
    }
}
