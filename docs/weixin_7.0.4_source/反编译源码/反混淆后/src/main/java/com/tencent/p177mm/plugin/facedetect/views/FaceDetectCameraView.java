package com.tencent.p177mm.plugin.facedetect.views;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C18601a;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.appbrand.game.p295e.C42444a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19281ab;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45628v;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.C19365c;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.C33304a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19314g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19320l;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C42478j;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C24697ae;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42526r;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C42570e;
import com.tencent.p177mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.p177mm.plugin.facedetect.model.C11810f;
import com.tencent.p177mm.plugin.facedetect.model.C20636d;
import com.tencent.p177mm.plugin.facedetect.model.C20636d.C20637b;
import com.tencent.p177mm.plugin.facedetect.model.C20639n;
import com.tencent.p177mm.plugin.facedetect.model.C27931c;
import com.tencent.p177mm.plugin.facedetect.model.C43032g;
import com.tencent.p177mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView */
public class FaceDetectCameraView extends MMTextureView implements SurfaceTextureListener {
    private static C27940a mad = null;
    private ActivityManager aDn;
    private boolean hGM;
    private int height;
    private boolean jER;
    private long lTJ;
    C11822b lZO;
    private long lZP;
    private long lZQ;
    private int lZR;
    private boolean lZS;
    private boolean lZT;
    private final Object lZU;
    private boolean lZV;
    private boolean lZW;
    private final Object lZX;
    private final Object lZY;
    private Rect lZZ;
    private SurfaceTexture mSurfaceTexture;
    private C45920c maa;
    private boolean mab;
    public C20661b mae;
    private byte[] maf;
    private boolean mag;
    private long mah;
    private int width;

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c */
    class C3051c implements C20661b {
        C20639n mam;
        PreviewCallback man;
        private C20637b mao;

        /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$2 */
        class C30492 implements Runnable {
            C30492() {
            }

            /* JADX WARNING: Missing block: B:31:?, code skipped:
            return;
     */
            /* JADX WARNING: Missing block: B:32:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                int i;
                int i2 = 580;
                AppMethodBeat.m2504i(580);
                synchronized (FaceDetectCameraView.this.lZY) {
                    try {
                        if (C3051c.this.mam == null) {
                        } else {
                            C4990ab.m7410d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
                            C3051c.this.mam.setPreviewCallback(null);
                            C20636d bsq = C20636d.bsq();
                            i = C20636d.mLock;
                            synchronized (i) {
                                if (bsq.lTC != null) {
                                    bsq.lTC.clear();
                                }
                            }
                            if (FaceDetectCameraView.this.mSurfaceTexture != null) {
                                FaceDetectCameraView.this.mSurfaceTexture.release();
                            }
                            C3051c.this.mam.release();
                            C3051c.this.mam = null;
                            C4990ab.m7410d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
                            i = 0;
                            FaceDetectCameraView.this.lZT = false;
                        }
                    } catch (Throwable th) {
                        while (true) {
                        }
                        i = 580;
                    } finally {
                        AppMethodBeat.m2505o(
/*
Method generation error in method: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.2.run():void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007c: INVOKE  (wrap: int
  ?: MERGE  (r4_1 int) = (r4_0 'i2' int), (r2_8 'i' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.2.run():void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:234)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:234)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r4_1 int) = (r4_0 'i2' int), (r2_8 'i' int) in method: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.2.run():void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 33 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 38 more

*/
        }

        /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$3 */
        class C30503 implements PreviewCallback {
            C30503() {
            }

            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                AppMethodBeat.m2504i(581);
                C4990ab.m7418v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
                C20636d.bsq().mo35922aS(bArr);
                AppMethodBeat.m2505o(581);
            }
        }

        /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$4 */
        class C30564 implements C20637b {

            /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$4$1 */
            class C30571 implements Runnable {
                C30571() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(C42526r.CTRL_INDEX);
                    C4990ab.m7418v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
                    long yz = C5046bo.m7588yz();
                    long p = yz - FaceDetectCameraView.this.lZQ;
                    if (FaceDetectCameraView.this.lZQ >= 0) {
                        C4990ab.m7419v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", Long.valueOf(p));
                    }
                    if (FaceDetectCameraView.this.lZQ < 0 || p > FaceDetectCameraView.this.lZP) {
                        FaceDetectCameraView.this.lZQ = yz;
                        FaceDetectCameraView.m44476b(FaceDetectCameraView.this, FaceDetectCameraView.this.maf);
                    }
                    AppMethodBeat.m2505o(C42526r.CTRL_INDEX);
                }
            }

            C30564() {
            }

            /* renamed from: aT */
            public final void mo7298aT(byte[] bArr) {
                AppMethodBeat.m2504i(583);
                if (!FaceDetectCameraView.this.mag) {
                    if (FaceDetectCameraView.this.maf == null) {
                        FaceDetectCameraView.this.maf = C27931c.lTA.mo45832g(Integer.valueOf(bArr.length));
                    }
                    System.arraycopy(bArr, 0, FaceDetectCameraView.this.maf, 0, bArr.length);
                    FaceDetectCameraView.this.maf = bArr;
                }
                C27931c.lTA.mo45831g(bArr);
                C11810f.bsA().post(new C30571());
                AppMethodBeat.m2505o(583);
            }

            public final C18601a<byte[]> bsr() {
                return C27931c.lTA;
            }
        }

        /* synthetic */ C3051c(FaceDetectCameraView faceDetectCameraView, byte b) {
            this();
        }

        private C3051c() {
            AppMethodBeat.m2504i(C24697ae.CTRL_INDEX);
            this.mam = null;
            this.man = new C30503();
            this.mao = new C30564();
            this.mam = new C20639n(FaceDetectCameraView.this.getContext());
            FaceDetectCameraView.this.lZQ = -1;
            FaceDetectCameraView.this.mag = false;
            AppMethodBeat.m2505o(C24697ae.CTRL_INDEX);
        }

        /* JADX WARNING: Missing block: B:15:0x003d, code skipped:
            com.tencent.p177mm.plugin.facedetect.views.FaceDetectCameraView.m44482g(r5.mai);
     */
        /* JADX WARNING: Missing block: B:16:0x0048, code skipped:
            if (com.tencent.p177mm.plugin.facedetect.views.FaceDetectCameraView.m44483h(r5.mai) != false) goto L_0x0089;
     */
        /* JADX WARNING: Missing block: B:18:0x0050, code skipped:
            if (r5.mai.isAvailable() == false) goto L_0x007c;
     */
        /* JADX WARNING: Missing block: B:19:0x0052, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.FaceDetectCameraView", "hy: already available. manually call available");
            r5.mai.onSurfaceTextureAvailable(r5.mai.getSurfaceTexture(), r5.mai.getWidth(), r5.mai.getHeight());
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(com.tencent.p177mm.plugin.appbrand.game.p295e.C42444a.CTRL_INDEX);
     */
        /* JADX WARNING: Missing block: B:24:0x007c, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("MicroMsg.FaceDetectCameraView", "hy: not initialized yet. do after init");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(com.tencent.p177mm.plugin.appbrand.game.p295e.C42444a.CTRL_INDEX);
     */
        /* JADX WARNING: Missing block: B:25:0x0089, code skipped:
            r0 = com.tencent.p177mm.sdk.platformtools.C5046bo.m7588yz();
            com.tencent.p177mm.sdk.p604g.C7305d.post(new com.tencent.p177mm.plugin.facedetect.views.FaceDetectCameraView.C3051c.C30521(r5), "FaceDetectCameraView_Camera");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(com.tencent.p177mm.plugin.appbrand.game.p295e.C42444a.CTRL_INDEX);
     */
        /* JADX WARNING: Missing block: B:31:?, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:32:?, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:33:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo7285a(C45920c c45920c) {
            AppMethodBeat.m2504i(C42444a.CTRL_INDEX);
            FaceDetectCameraView.this.maa = c45920c;
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    if (this.mam == null) {
                        C4990ab.m7420w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
                    } else if (this.mam.lUE) {
                        C4990ab.m7420w("MicroMsg.FaceDetectCameraView", "hy: already previewed. return");
                        FaceDetectCameraView.m44481f(FaceDetectCameraView.this);
                        AppMethodBeat.m2505o(C42444a.CTRL_INDEX);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(C42444a.CTRL_INDEX);
                }
            }
        }

        public final void stopPreview() {
            AppMethodBeat.m2504i(586);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    if (this.mam != null && this.mam.lUE) {
                        C20639n c20639n = this.mam;
                        if (c20639n.erH != null) {
                            c20639n.erH.stopPreview();
                            c20639n.lUE = false;
                            C27931c.lTA.mo45830WY();
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(586);
                }
            }
        }

        public final void btG() {
            AppMethodBeat.m2504i(587);
            if (!FaceDetectCameraView.this.lZT) {
                FaceDetectCameraView.this.lZT = true;
                C7305d.post(new C30492(), "FaceDetectCameraView_Camera");
            }
            AppMethodBeat.m2505o(587);
        }

        public final int getPreviewWidth() {
            int previewWidth;
            AppMethodBeat.m2504i(588);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    previewWidth = this.mam.getPreviewWidth();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(588);
                }
            }
            return previewWidth;
        }

        public final int getPreviewHeight() {
            int previewHeight;
            AppMethodBeat.m2504i(C42570e.CTRL_INDEX);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    previewHeight = this.mam.getPreviewHeight();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(C42570e.CTRL_INDEX);
                }
            }
            return previewHeight;
        }

        public final int getRotation() {
            int i;
            AppMethodBeat.m2504i(C45628v.CTRL_INDEX);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    i = this.mam.lUJ;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(C45628v.CTRL_INDEX);
                }
            }
            return i;
        }

        /* JADX WARNING: Missing block: B:16:0x0066, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(591);
     */
        /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: im */
        public final void mo7292im(long j) {
            AppMethodBeat.m2504i(591);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    if (this.mam == null) {
                        C4990ab.m7420w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
                    } else {
                        C4990ab.m7417i("MicroMsg.FaceDetectCameraView", "hy: start capturing. tween: %d", Long.valueOf(j));
                        FaceDetectCameraView.this.lZP = j;
                        if (FaceDetectCameraView.this.jER) {
                            C4990ab.m7420w("MicroMsg.FaceDetectCameraView", "hy: already scanning");
                        } else if (this.mam == null || !this.mam.lUE) {
                            C4990ab.m7416i("MicroMsg.FaceDetectCameraView", "hy: not previewed yet. wait");
                            FaceDetectCameraView.this.lZV = true;
                        } else {
                            C4990ab.m7416i("MicroMsg.FaceDetectCameraView", "hy: is previewing. directly start capture");
                            FaceDetectCameraView.this.lZV = false;
                            C20636d.bsq().mo35921a(this.mao);
                            FaceDetectCameraView.this.jER = true;
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(591);
                }
            }
        }

        public final void btr() {
            AppMethodBeat.m2504i(C19365c.CTRL_INDEX);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    if (this.mam != null && this.mam.lUE) {
                        C20636d.bsq().mo35923b(this.mao);
                        if (!FaceDetectCameraView.this.mag) {
                            FaceDetectCameraView.this.maf = null;
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(C19365c.CTRL_INDEX);
                }
            }
        }

        public final Point btH() {
            Point point;
            AppMethodBeat.m2504i(C33304a.CTRL_INDEX);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    point = this.mam.lUM;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(C33304a.CTRL_INDEX);
                }
            }
            return point;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$b */
    public interface C20661b {
        /* renamed from: a */
        void mo7285a(C45920c c45920c);

        void btG();

        Point btH();

        void btr();

        int getPreviewHeight();

        int getPreviewWidth();

        int getRotation();

        /* renamed from: im */
        void mo7292im(long j);

        void stopPreview();
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$a */
    static class C27940a extends C7306ak {
        /* renamed from: Nw */
        private WeakReference<FaceDetectCameraView> f13690Nw;

        /* synthetic */ C27940a(FaceDetectCameraView faceDetectCameraView, byte b) {
            this(faceDetectCameraView);
        }

        private C27940a(FaceDetectCameraView faceDetectCameraView) {
            super(Looper.getMainLooper());
            AppMethodBeat.m2504i(574);
            this.f13690Nw = new WeakReference(faceDetectCameraView);
            AppMethodBeat.m2505o(574);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(575);
            super.handleMessage(message);
            if (this.f13690Nw == null || this.f13690Nw.get() == null) {
                C4990ab.m7412e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
                AppMethodBeat.m2505o(575);
                return;
            }
            if (message.what == 1) {
                FaceCharacteristicsResult faceCharacteristicsResult = (FaceCharacteristicsResult) message.obj;
                if (FaceCharacteristicsResult.m19656vj(faceCharacteristicsResult.errCode)) {
                    if (((FaceDetectCameraView) this.f13690Nw.get()).lZO != null) {
                        ((FaceDetectCameraView) this.f13690Nw.get()).lZO.mo7303d(faceCharacteristicsResult);
                        AppMethodBeat.m2505o(575);
                        return;
                    }
                } else if (FaceCharacteristicsResult.m19655vi(faceCharacteristicsResult.errCode)) {
                    if (((FaceDetectCameraView) this.f13690Nw.get()).lZO != null) {
                        ((FaceDetectCameraView) this.f13690Nw.get()).lZO.mo7301a(faceCharacteristicsResult.errCode, faceCharacteristicsResult.aIm);
                        AppMethodBeat.m2505o(575);
                        return;
                    }
                } else if (((FaceDetectCameraView) this.f13690Nw.get()).lZO != null) {
                    ((FaceDetectCameraView) this.f13690Nw.get()).lZO.mo7302c(faceCharacteristicsResult);
                }
            }
            AppMethodBeat.m2505o(575);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$1 */
    class C279421 implements Runnable {
        C279421() {
        }

        public final void run() {
            AppMethodBeat.m2504i(572);
            FaceDetectCameraView.this.mo45838a(FaceDetectCameraView.this.lZZ, FaceDetectCameraView.this.lZP);
            FaceDetectCameraView.this.lZV = false;
            AppMethodBeat.m2505o(572);
        }
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(C19314g.CTRL_INDEX);
        this.lZO = null;
        this.mSurfaceTexture = null;
        this.lZP = FaceDetectView.maQ;
        this.lZQ = -1;
        this.lTJ = -1;
        this.lZR = 1;
        this.hGM = false;
        this.lZS = false;
        this.lZT = false;
        this.lZU = new Object();
        this.lZV = false;
        this.lZW = false;
        this.jER = false;
        this.lZX = new Object();
        this.lZY = new Object();
        this.lZZ = null;
        this.width = C19281ab.CTRL_INDEX;
        this.height = 576;
        this.maa = null;
        this.mab = false;
        this.mae = null;
        this.maf = null;
        this.mag = false;
        this.mah = -1;
        this.aDn = (ActivityManager) getContext().getSystemService("activity");
        C4990ab.m7417i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", Boolean.valueOf(this.mab));
        this.mae = new C3051c(this, (byte) 0);
        mad = new C27940a(this, (byte) 0);
        setOpaque(false);
        setSurfaceTextureListener(this);
        AppMethodBeat.m2505o(C19314g.CTRL_INDEX);
    }

    public final Point getEncodeVideoBestSize() {
        AppMethodBeat.m2504i(C19320l.CTRL_INDEX);
        Point btH = this.mae.btH();
        AppMethodBeat.m2505o(C19320l.CTRL_INDEX);
        return btH;
    }

    /* Access modifiers changed, original: final */
    public final void setCallback(C11822b c11822b) {
        this.lZO = c11822b;
    }

    /* renamed from: a */
    public final void mo45839a(C45920c c45920c) {
        AppMethodBeat.m2504i(C42478j.CTRL_INDEX);
        this.mae.mo7285a(c45920c);
        this.lTJ = -1;
        AppMethodBeat.m2505o(C42478j.CTRL_INDEX);
    }

    /* renamed from: a */
    public final synchronized void mo45838a(Rect rect, long j) {
        AppMethodBeat.m2504i(597);
        FaceDetectCameraView.btB();
        this.lZZ = rect;
        btE();
        this.mae.mo7292im(j);
        AppMethodBeat.m2505o(597);
    }

    private static void btB() {
        AppMethodBeat.m2504i(598);
        C4990ab.m7416i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
        C11810f.bsz();
        AppMethodBeat.m2505o(598);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(599);
        C4990ab.m7416i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
        dAh();
        this.hGM = true;
        this.mSurfaceTexture = surfaceTexture;
        if (this.lZW) {
            mo45839a(this.maa);
        }
        AppMethodBeat.m2505o(599);
    }

    public final void btC() {
        AppMethodBeat.m2504i(600);
        btD();
        C11810f.lTL.lTM.lVR.bsH();
        AppMethodBeat.m2505o(600);
    }

    public final void btD() {
        AppMethodBeat.m2504i(601);
        this.jER = false;
        this.mae.btr();
        FaceDetectCameraView.btB();
        int bsD = C11810f.lTL.bsD();
        C4990ab.m7417i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", Long.valueOf(System.currentTimeMillis()));
        FaceDetectReporter.bsJ().mo54645I(bsD, r2);
        AppMethodBeat.m2505o(601);
    }

    private synchronized void btE() {
        AppMethodBeat.m2504i(602);
        C4990ab.m7416i("MicroMsg.FaceDetectCameraView", "alvinluo capture face");
        C11810f.lTL.bsC();
        C43032g c43032g = C11810f.lTL.lTM.lVR;
        if (c43032g.lTP == null) {
            C4990ab.m7412e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        } else {
            C4990ab.m7416i("MicroMsg.FaceDetectNativeManager", "hy: start init motion");
            c43032g.lTP.engineGetCurrMotion();
        }
        int bsD = C11810f.lTL.bsD();
        C4990ab.m7417i("MicroMsg.FaceDetectCameraView", "alvinluo start motion time: %d", Long.valueOf(System.currentTimeMillis()));
        FaceDetectReporter.bsJ().mo54644H(bsD, r2);
        AppMethodBeat.m2505o(602);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(603);
        C4990ab.m7416i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
        this.mSurfaceTexture = surfaceTexture;
        AppMethodBeat.m2505o(603);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(604);
        C4990ab.m7416i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
        this.hGM = false;
        AppMethodBeat.m2505o(604);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(605);
        super.onAttachedToWindow();
        C4990ab.m7416i("MicroMsg.FaceDetectCameraView", "hy: attached");
        AppMethodBeat.m2505o(605);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized FaceResult btF() {
        FaceResult bsG;
        AppMethodBeat.m2504i(606);
        C11810f.bsz();
        int bsC = C11810f.lTL.bsC();
        bsG = C11810f.lTL.lTM.lVR.bsG();
        String str = "MicroMsg.FaceDetectCameraView";
        String str2 = "hy: motionResult: %d, finalResult: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bsC);
        objArr[1] = Integer.valueOf(bsG != null ? bsG.result : -10000);
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(606);
        return bsG;
    }

    public final Bitmap getPreviewBm() {
        AppMethodBeat.m2504i(Downloads.DOWNLOAD_ERR_SSL_HANDSHAKE_EXCEPTION);
        Bitmap bitmap = getBitmap();
        AppMethodBeat.m2505o(Downloads.DOWNLOAD_ERR_SSL_HANDSHAKE_EXCEPTION);
        return bitmap;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(608);
        super.onMeasure(i, i2);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        C4990ab.m7417i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", Integer.valueOf(this.width), Integer.valueOf(this.height));
        AppMethodBeat.m2505o(608);
    }

    public final int getCameraRotation() {
        AppMethodBeat.m2504i(609);
        int rotation = this.mae.getRotation();
        AppMethodBeat.m2505o(609);
        return rotation;
    }

    public final int getPreviewWidth() {
        AppMethodBeat.m2504i(610);
        int previewWidth = this.mae.getPreviewWidth();
        AppMethodBeat.m2505o(610);
        return previewWidth;
    }

    public final int getPreviewHeight() {
        AppMethodBeat.m2504i(611);
        int previewHeight = this.mae.getPreviewHeight();
        AppMethodBeat.m2505o(611);
        return previewHeight;
    }

    /* renamed from: f */
    static /* synthetic */ void m44481f(FaceDetectCameraView faceDetectCameraView) {
        AppMethodBeat.m2504i(612);
        if (faceDetectCameraView.lZV && faceDetectCameraView.lZP > 0) {
            C4990ab.m7416i("MicroMsg.FaceDetectCameraView", "hy: already request scanning face and now automatically capture");
            C5004al.m7441d(new C279421());
        }
        AppMethodBeat.m2505o(612);
    }
}
