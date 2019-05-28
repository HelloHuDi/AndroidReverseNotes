package com.tencent.mm.plugin.facedetect.views;

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
import com.tencent.mm.plugin.appbrand.jsapi.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.k.ae;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.share.e;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;

public class FaceDetectCameraView extends MMTextureView implements SurfaceTextureListener {
    private static a mad = null;
    private ActivityManager aDn;
    private boolean hGM;
    private int height;
    private boolean jER;
    private long lTJ;
    b lZO;
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
    private c maa;
    private boolean mab;
    public b mae;
    private byte[] maf;
    private boolean mag;
    private long mah;
    private int width;

    class c implements b {
        n mam;
        PreviewCallback man;
        private com.tencent.mm.plugin.facedetect.model.d.b mao;

        /* synthetic */ c(FaceDetectCameraView faceDetectCameraView, byte b) {
            this();
        }

        private c() {
            AppMethodBeat.i(ae.CTRL_INDEX);
            this.mam = null;
            this.man = new PreviewCallback() {
                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    AppMethodBeat.i(581);
                    ab.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
                    d.bsq().aS(bArr);
                    AppMethodBeat.o(581);
                }
            };
            this.mao = new com.tencent.mm.plugin.facedetect.model.d.b() {
                public final void aT(byte[] bArr) {
                    AppMethodBeat.i(583);
                    if (!FaceDetectCameraView.this.mag) {
                        if (FaceDetectCameraView.this.maf == null) {
                            FaceDetectCameraView.this.maf = com.tencent.mm.plugin.facedetect.model.c.lTA.g(Integer.valueOf(bArr.length));
                        }
                        System.arraycopy(bArr, 0, FaceDetectCameraView.this.maf, 0, bArr.length);
                        FaceDetectCameraView.this.maf = bArr;
                    }
                    com.tencent.mm.plugin.facedetect.model.c.lTA.g(bArr);
                    f.bsA().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(r.CTRL_INDEX);
                            ab.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
                            long yz = bo.yz();
                            long p = yz - FaceDetectCameraView.this.lZQ;
                            if (FaceDetectCameraView.this.lZQ >= 0) {
                                ab.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", Long.valueOf(p));
                            }
                            if (FaceDetectCameraView.this.lZQ < 0 || p > FaceDetectCameraView.this.lZP) {
                                FaceDetectCameraView.this.lZQ = yz;
                                FaceDetectCameraView.b(FaceDetectCameraView.this, FaceDetectCameraView.this.maf);
                            }
                            AppMethodBeat.o(r.CTRL_INDEX);
                        }
                    });
                    AppMethodBeat.o(583);
                }

                public final com.tencent.mm.memory.a<byte[]> bsr() {
                    return com.tencent.mm.plugin.facedetect.model.c.lTA;
                }
            };
            this.mam = new n(FaceDetectCameraView.this.getContext());
            FaceDetectCameraView.this.lZQ = -1;
            FaceDetectCameraView.this.mag = false;
            AppMethodBeat.o(ae.CTRL_INDEX);
        }

        /* JADX WARNING: Missing block: B:15:0x003d, code skipped:
            com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.g(r5.mai);
     */
        /* JADX WARNING: Missing block: B:16:0x0048, code skipped:
            if (com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.h(r5.mai) != false) goto L_0x0089;
     */
        /* JADX WARNING: Missing block: B:18:0x0050, code skipped:
            if (r5.mai.isAvailable() == false) goto L_0x007c;
     */
        /* JADX WARNING: Missing block: B:19:0x0052, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FaceDetectCameraView", "hy: already available. manually call available");
            r5.mai.onSurfaceTextureAvailable(r5.mai.getSurfaceTexture(), r5.mai.getWidth(), r5.mai.getHeight());
            com.tencent.matrix.trace.core.AppMethodBeat.o(com.tencent.mm.plugin.appbrand.game.e.a.CTRL_INDEX);
     */
        /* JADX WARNING: Missing block: B:24:0x007c, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FaceDetectCameraView", "hy: not initialized yet. do after init");
            com.tencent.matrix.trace.core.AppMethodBeat.o(com.tencent.mm.plugin.appbrand.game.e.a.CTRL_INDEX);
     */
        /* JADX WARNING: Missing block: B:25:0x0089, code skipped:
            r0 = com.tencent.mm.sdk.platformtools.bo.yz();
            com.tencent.mm.sdk.g.d.post(new com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.AnonymousClass1(r5), "FaceDetectCameraView_Camera");
            com.tencent.matrix.trace.core.AppMethodBeat.o(com.tencent.mm.plugin.appbrand.game.e.a.CTRL_INDEX);
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
        public final void a(c cVar) {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.game.e.a.CTRL_INDEX);
            FaceDetectCameraView.this.maa = cVar;
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    if (this.mam == null) {
                        ab.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
                    } else if (this.mam.lUE) {
                        ab.w("MicroMsg.FaceDetectCameraView", "hy: already previewed. return");
                        FaceDetectCameraView.f(FaceDetectCameraView.this);
                        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.game.e.a.CTRL_INDEX);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(com.tencent.mm.plugin.appbrand.game.e.a.CTRL_INDEX);
                }
            }
        }

        public final void stopPreview() {
            AppMethodBeat.i(586);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    if (this.mam != null && this.mam.lUE) {
                        n nVar = this.mam;
                        if (nVar.erH != null) {
                            nVar.erH.stopPreview();
                            nVar.lUE = false;
                            com.tencent.mm.plugin.facedetect.model.c.lTA.WY();
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(586);
                }
            }
        }

        public final void btG() {
            AppMethodBeat.i(587);
            if (!FaceDetectCameraView.this.lZT) {
                FaceDetectCameraView.this.lZT = true;
                com.tencent.mm.sdk.g.d.post(new Runnable() {
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
                        AppMethodBeat.i(580);
                        synchronized (FaceDetectCameraView.this.lZY) {
                            try {
                                if (c.this.mam == null) {
                                } else {
                                    ab.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
                                    c.this.mam.setPreviewCallback(null);
                                    d bsq = d.bsq();
                                    i = d.mLock;
                                    synchronized (i) {
                                        if (bsq.lTC != null) {
                                            bsq.lTC.clear();
                                        }
                                    }
                                    if (FaceDetectCameraView.this.mSurfaceTexture != null) {
                                        FaceDetectCameraView.this.mSurfaceTexture.release();
                                    }
                                    c.this.mam.release();
                                    c.this.mam = null;
                                    ab.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
                                    i = 0;
                                    FaceDetectCameraView.this.lZT = false;
                                }
                            } catch (Throwable th) {
                                while (true) {
                                }
                                i = 580;
                            } finally {
                                AppMethodBeat.o(
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
	at jadx.core.codegen.InsnGen.inlineAnonymousConstr(InsnGen.java:610)
	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:561)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:336)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:120)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
	... 53 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 58 more

*/
                }, "FaceDetectCameraView_Camera");
            }
            AppMethodBeat.o(587);
        }

        public final int getPreviewWidth() {
            int previewWidth;
            AppMethodBeat.i(588);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    previewWidth = this.mam.getPreviewWidth();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(588);
                }
            }
            return previewWidth;
        }

        public final int getPreviewHeight() {
            int previewHeight;
            AppMethodBeat.i(e.CTRL_INDEX);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    previewHeight = this.mam.getPreviewHeight();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(e.CTRL_INDEX);
                }
            }
            return previewHeight;
        }

        public final int getRotation() {
            int i;
            AppMethodBeat.i(v.CTRL_INDEX);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    i = this.mam.lUJ;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(v.CTRL_INDEX);
                }
            }
            return i;
        }

        /* JADX WARNING: Missing block: B:16:0x0066, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(591);
     */
        /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void im(long j) {
            AppMethodBeat.i(591);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    if (this.mam == null) {
                        ab.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
                    } else {
                        ab.i("MicroMsg.FaceDetectCameraView", "hy: start capturing. tween: %d", Long.valueOf(j));
                        FaceDetectCameraView.this.lZP = j;
                        if (FaceDetectCameraView.this.jER) {
                            ab.w("MicroMsg.FaceDetectCameraView", "hy: already scanning");
                        } else if (this.mam == null || !this.mam.lUE) {
                            ab.i("MicroMsg.FaceDetectCameraView", "hy: not previewed yet. wait");
                            FaceDetectCameraView.this.lZV = true;
                        } else {
                            ab.i("MicroMsg.FaceDetectCameraView", "hy: is previewing. directly start capture");
                            FaceDetectCameraView.this.lZV = false;
                            d.bsq().a(this.mao);
                            FaceDetectCameraView.this.jER = true;
                        }
                    }
                } finally {
                    AppMethodBeat.o(591);
                }
            }
        }

        public final void btr() {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.fakenative.c.CTRL_INDEX);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    if (this.mam != null && this.mam.lUE) {
                        d.bsq().b(this.mao);
                        if (!FaceDetectCameraView.this.mag) {
                            FaceDetectCameraView.this.maf = null;
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.fakenative.c.CTRL_INDEX);
                }
            }
        }

        public final Point btH() {
            Point point;
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.fakenative.a.CTRL_INDEX);
            synchronized (FaceDetectCameraView.this.lZY) {
                try {
                    point = this.mam.lUM;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.fakenative.a.CTRL_INDEX);
                }
            }
            return point;
        }
    }

    public interface b {
        void a(c cVar);

        void btG();

        Point btH();

        void btr();

        int getPreviewHeight();

        int getPreviewWidth();

        int getRotation();

        void im(long j);

        void stopPreview();
    }

    static class a extends ak {
        private WeakReference<FaceDetectCameraView> Nw;

        /* synthetic */ a(FaceDetectCameraView faceDetectCameraView, byte b) {
            this(faceDetectCameraView);
        }

        private a(FaceDetectCameraView faceDetectCameraView) {
            super(Looper.getMainLooper());
            AppMethodBeat.i(574);
            this.Nw = new WeakReference(faceDetectCameraView);
            AppMethodBeat.o(574);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(575);
            super.handleMessage(message);
            if (this.Nw == null || this.Nw.get() == null) {
                ab.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
                AppMethodBeat.o(575);
                return;
            }
            if (message.what == 1) {
                FaceCharacteristicsResult faceCharacteristicsResult = (FaceCharacteristicsResult) message.obj;
                if (FaceCharacteristicsResult.vj(faceCharacteristicsResult.errCode)) {
                    if (((FaceDetectCameraView) this.Nw.get()).lZO != null) {
                        ((FaceDetectCameraView) this.Nw.get()).lZO.d(faceCharacteristicsResult);
                        AppMethodBeat.o(575);
                        return;
                    }
                } else if (FaceCharacteristicsResult.vi(faceCharacteristicsResult.errCode)) {
                    if (((FaceDetectCameraView) this.Nw.get()).lZO != null) {
                        ((FaceDetectCameraView) this.Nw.get()).lZO.a(faceCharacteristicsResult.errCode, faceCharacteristicsResult.aIm);
                        AppMethodBeat.o(575);
                        return;
                    }
                } else if (((FaceDetectCameraView) this.Nw.get()).lZO != null) {
                    ((FaceDetectCameraView) this.Nw.get()).lZO.c(faceCharacteristicsResult);
                }
            }
            AppMethodBeat.o(575);
        }
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(g.CTRL_INDEX);
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
        this.width = com.tencent.mm.plugin.appbrand.jsapi.ab.CTRL_INDEX;
        this.height = 576;
        this.maa = null;
        this.mab = false;
        this.mae = null;
        this.maf = null;
        this.mag = false;
        this.mah = -1;
        this.aDn = (ActivityManager) getContext().getSystemService("activity");
        ab.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", Boolean.valueOf(this.mab));
        this.mae = new c(this, (byte) 0);
        mad = new a(this, (byte) 0);
        setOpaque(false);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(g.CTRL_INDEX);
    }

    public final Point getEncodeVideoBestSize() {
        AppMethodBeat.i(l.CTRL_INDEX);
        Point btH = this.mae.btH();
        AppMethodBeat.o(l.CTRL_INDEX);
        return btH;
    }

    /* Access modifiers changed, original: final */
    public final void setCallback(b bVar) {
        this.lZO = bVar;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(j.CTRL_INDEX);
        this.mae.a(cVar);
        this.lTJ = -1;
        AppMethodBeat.o(j.CTRL_INDEX);
    }

    public final synchronized void a(Rect rect, long j) {
        AppMethodBeat.i(597);
        btB();
        this.lZZ = rect;
        btE();
        this.mae.im(j);
        AppMethodBeat.o(597);
    }

    private static void btB() {
        AppMethodBeat.i(598);
        ab.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
        f.bsz();
        AppMethodBeat.o(598);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(599);
        ab.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
        dAh();
        this.hGM = true;
        this.mSurfaceTexture = surfaceTexture;
        if (this.lZW) {
            a(this.maa);
        }
        AppMethodBeat.o(599);
    }

    public final void btC() {
        AppMethodBeat.i(600);
        btD();
        f.lTL.lTM.lVR.bsH();
        AppMethodBeat.o(600);
    }

    public final void btD() {
        AppMethodBeat.i(601);
        this.jER = false;
        this.mae.btr();
        btB();
        int bsD = f.lTL.bsD();
        ab.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", Long.valueOf(System.currentTimeMillis()));
        FaceDetectReporter.bsJ().I(bsD, r2);
        AppMethodBeat.o(601);
    }

    private synchronized void btE() {
        AppMethodBeat.i(602);
        ab.i("MicroMsg.FaceDetectCameraView", "alvinluo capture face");
        f.lTL.bsC();
        com.tencent.mm.plugin.facedetect.model.g gVar = f.lTL.lTM.lVR;
        if (gVar.lTP == null) {
            ab.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        } else {
            ab.i("MicroMsg.FaceDetectNativeManager", "hy: start init motion");
            gVar.lTP.engineGetCurrMotion();
        }
        int bsD = f.lTL.bsD();
        ab.i("MicroMsg.FaceDetectCameraView", "alvinluo start motion time: %d", Long.valueOf(System.currentTimeMillis()));
        FaceDetectReporter.bsJ().H(bsD, r2);
        AppMethodBeat.o(602);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(603);
        ab.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
        this.mSurfaceTexture = surfaceTexture;
        AppMethodBeat.o(603);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(604);
        ab.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
        this.hGM = false;
        AppMethodBeat.o(604);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(605);
        super.onAttachedToWindow();
        ab.i("MicroMsg.FaceDetectCameraView", "hy: attached");
        AppMethodBeat.o(605);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized FaceResult btF() {
        FaceResult bsG;
        AppMethodBeat.i(606);
        f.bsz();
        int bsC = f.lTL.bsC();
        bsG = f.lTL.lTM.lVR.bsG();
        String str = "MicroMsg.FaceDetectCameraView";
        String str2 = "hy: motionResult: %d, finalResult: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bsC);
        objArr[1] = Integer.valueOf(bsG != null ? bsG.result : -10000);
        ab.i(str, str2, objArr);
        AppMethodBeat.o(606);
        return bsG;
    }

    public final Bitmap getPreviewBm() {
        AppMethodBeat.i(Downloads.DOWNLOAD_ERR_SSL_HANDSHAKE_EXCEPTION);
        Bitmap bitmap = getBitmap();
        AppMethodBeat.o(Downloads.DOWNLOAD_ERR_SSL_HANDSHAKE_EXCEPTION);
        return bitmap;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(608);
        super.onMeasure(i, i2);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        ab.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", Integer.valueOf(this.width), Integer.valueOf(this.height));
        AppMethodBeat.o(608);
    }

    public final int getCameraRotation() {
        AppMethodBeat.i(609);
        int rotation = this.mae.getRotation();
        AppMethodBeat.o(609);
        return rotation;
    }

    public final int getPreviewWidth() {
        AppMethodBeat.i(610);
        int previewWidth = this.mae.getPreviewWidth();
        AppMethodBeat.o(610);
        return previewWidth;
    }

    public final int getPreviewHeight() {
        AppMethodBeat.i(611);
        int previewHeight = this.mae.getPreviewHeight();
        AppMethodBeat.o(611);
        return previewHeight;
    }

    static /* synthetic */ void f(FaceDetectCameraView faceDetectCameraView) {
        AppMethodBeat.i(612);
        if (faceDetectCameraView.lZV && faceDetectCameraView.lZP > 0) {
            ab.i("MicroMsg.FaceDetectCameraView", "hy: already request scanning face and now automatically capture");
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(572);
                    FaceDetectCameraView.this.a(FaceDetectCameraView.this.lZZ, FaceDetectCameraView.this.lZP);
                    FaceDetectCameraView.this.lZV = false;
                    AppMethodBeat.o(572);
                }
            });
        }
        AppMethodBeat.o(612);
    }
}
