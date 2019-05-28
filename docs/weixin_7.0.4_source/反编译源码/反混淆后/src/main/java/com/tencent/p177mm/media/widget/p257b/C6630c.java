package com.tencent.p177mm.media.widget.p257b;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.media.p251b.C24670c;
import com.tencent.p177mm.media.p254g.C9587a;
import com.tencent.p177mm.media.p254g.C9587a.C9591i;
import com.tencent.p177mm.media.p254g.C9587a.C9593d;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.p866d.C45426b;
import com.tencent.p177mm.media.p866d.C9582e;
import com.tencent.p177mm.media.p867i.C18594c;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p209c.C25998g;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.model.C34547b;
import com.tencent.p177mm.plugin.mmsight.model.C34549k;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C34546s;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c.C12542a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c.C28499b;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C12543a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C34543c;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43309m;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.nio.ByteBuffer;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

/* renamed from: com.tencent.mm.media.widget.b.c */
public final class C6630c implements C1788b {
    private static final Object fdj = new Object();
    private int bMU;
    private SurfaceTexture bsb;
    protected String cvZ;
    protected boolean eNa;
    protected int eTa;
    private EGLContext fag;
    private final Object fcD;
    protected String fcE;
    protected int fcF;
    protected float fcG;
    private int fcH;
    private float fcI;
    protected C43303c fcJ;
    protected C45426b fcK;
    protected int fcL;
    protected int fcM;
    protected int fcN;
    protected int fcO;
    protected int fcP;
    protected C34546s fcQ;
    protected int fcR;
    protected String fcS;
    protected boolean fcT;
    protected String fcU;
    protected boolean fcV;
    protected C34547b fcW;
    protected C34547b fcX;
    protected VideoTransPara fcY;
    protected C43309m fcZ;
    protected boolean fda;
    protected boolean fdb;
    protected int fdc;
    protected C12543a fdd;
    protected Runnable fde;
    protected boolean fdf;
    protected boolean fdg;
    protected boolean fdh;
    private C9587a fdi;
    protected C39387f fdk;
    private boolean isRecording;
    protected String mFileName;
    protected String thumbPath;

    /* renamed from: com.tencent.mm.media.widget.b.c$2 */
    class C66312 implements C17126b<C45426b, C37091y> {

        /* renamed from: com.tencent.mm.media.widget.b.c$2$2 */
        class C66322 implements C31214a<C37091y> {
            C66322() {
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(12740);
                C6630c.m10943a(C6630c.this);
                AppMethodBeat.m2505o(12740);
                return null;
            }
        }

        /* renamed from: com.tencent.mm.media.widget.b.c$2$1 */
        class C66331 implements C31591m<ByteBuffer, BufferInfo, C37091y> {
            C66331() {
            }

            /* renamed from: m */
            public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
                AppMethodBeat.m2504i(12739);
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                BufferInfo bufferInfo = (BufferInfo) obj2;
                C4990ab.m7410d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "writeH264Data  ,bufferInfo.size : " + bufferInfo.size);
                SightVideoJNI.writeH264DataLock(C6630c.this.eTa, byteBuffer, bufferInfo.size);
                AppMethodBeat.m2505o(12739);
                return null;
            }
        }

        C66312() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(12741);
            C45426b c45426b = (C45426b) obj;
            c45426b.eVy = new C66331();
            c45426b.eVz = new C66322();
            AppMethodBeat.m2505o(12741);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.c$3 */
    class C66343 implements C17126b<Boolean, C37091y> {
        C66343() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(12743);
            C37091y c = C66343.m10976c((Boolean) obj);
            AppMethodBeat.m2505o(12743);
            return c;
        }

        /* renamed from: c */
        private static C37091y m10976c(Boolean bool) {
            AppMethodBeat.m2504i(12742);
            if (!bool.booleanValue()) {
                C18594c c18594c = C18594c.faj;
                C18594c.m28982Vx();
            }
            synchronized (C6630c.fdj) {
                try {
                    C6630c.fdj.notifyAll();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e, "initSurfaceLock notify error", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(12742);
                }
            }
            AppMethodBeat.m2505o(12742);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.c$4 */
    class C66354 implements C17126b<Boolean, C37091y> {

        /* renamed from: com.tencent.mm.media.widget.b.c$4$1 */
        class C66361 implements C28499b {
            C66361() {
            }

            /* renamed from: WT */
            public final void mo14866WT() {
                AppMethodBeat.m2504i(12744);
                C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "aac stop finish");
                AppMethodBeat.m2505o(12744);
            }
        }

        C66354() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(12745);
            if (C6630c.this.fcK != null) {
                C6630c.this.fcK.mo20900UP();
            }
            if (C6630c.this.fcK != null && C6630c.this.fcQ.oxa == C34543c.WaitStop) {
                C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "final frame draw");
                C6630c.this.fcK.mo20899UO();
                if (C6630c.this.fcJ != null) {
                    C6630c.this.fcJ.mo36709a(new C66361());
                }
                C6630c.this.fdi.release();
            }
            AppMethodBeat.m2505o(12745);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.c$5 */
    class C66375 implements C12542a {
        C66375() {
        }

        /* renamed from: WU */
        public final void mo14867WU() {
            AppMethodBeat.m2504i(12746);
            C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "onPcmReady");
            if (C6630c.this.mo14838WL() != C34543c.Initialized) {
                C4990ab.m7420w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                AppMethodBeat.m2505o(12746);
                return;
            }
            C6630c.this.fcQ.mo55075a(C34543c.Start);
            AppMethodBeat.m2505o(12746);
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.c$6 */
    class C66386 implements Runnable {

        /* renamed from: com.tencent.mm.media.widget.b.c$6$1 */
        class C66391 implements Runnable {
            C66391() {
            }

            public final void run() {
                AppMethodBeat.m2504i(12747);
                C6630c.this.fdd.asv();
                AppMethodBeat.m2505o(12747);
            }
        }

        C66386() {
        }

        public final void run() {
            C18594c c18594c;
            AppMethodBeat.m2504i(12748);
            C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stopImpl result: %s", Boolean.valueOf(C6630c.m10948c(C6630c.this)));
            if (C6630c.m10948c(C6630c.this)) {
                c18594c = C18594c.faj;
                C18594c.m28945VC();
                C6630c.m10944a(C6630c.this, C3475d.m5784tv(C6630c.this.fcE));
                try {
                    C43528a WR = C21846d.m33388WR(C6630c.this.fcE);
                    if (WR != null) {
                        C18594c c18594c2 = C18594c.faj;
                        C18594c.m28991ck(WR.videoBitrate, WR.eTk);
                    }
                } catch (Exception e) {
                }
                if (C6630c.this.fde != null) {
                    C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "call stopCallback");
                    C5004al.m7441d(C6630c.this.fde);
                }
            } else {
                c18594c = C18594c.faj;
                C18594c.m28944VB();
                SightVideoJNI.releaseBigSightDataBufferLock(C6630c.this.eTa);
                if (C6630c.this.fdd != null) {
                    C5004al.m7441d(new C66391());
                }
            }
            c18594c = C18594c.faj;
            C18594c.m28943VA();
            AppMethodBeat.m2505o(12748);
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.c$1 */
    class C66401 implements C39387f {
        C66401() {
        }

        /* renamed from: O */
        public final boolean mo14870O(byte[] bArr) {
            AppMethodBeat.m2504i(12738);
            C6630c.m10945a(C6630c.this, bArr);
            AppMethodBeat.m2505o(12738);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.c$7 */
    class C66417 implements C28499b {
        C66417() {
        }

        /* renamed from: WT */
        public final void mo14866WT() {
            AppMethodBeat.m2504i(12749);
            C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "aac stop finish");
            AppMethodBeat.m2505o(12749);
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.c$8 */
    class C66428 implements C17126b<byte[], C37091y> {
        C66428() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(12750);
            C43305j.owk.mo68845g((byte[]) obj);
            AppMethodBeat.m2505o(12750);
            return null;
        }
    }

    static {
        AppMethodBeat.m2504i(12776);
        AppMethodBeat.m2505o(12776);
    }

    public C6630c(VideoTransPara videoTransPara, C37897a c37897a) {
        this(videoTransPara, c37897a, null, -1);
    }

    public C6630c(VideoTransPara videoTransPara, C37897a c37897a, EGLContext eGLContext, int i) {
        AppMethodBeat.m2504i(12751);
        this.fcD = new Object();
        this.fcE = "";
        this.fcF = 0;
        this.fcG = 0.0f;
        this.fcH = -1;
        this.fcI = -1.0f;
        this.fcL = 480;
        this.fcM = 640;
        this.fcN = 1600000;
        this.fcO = 480;
        this.fcP = 640;
        this.eTa = -1;
        this.fcS = null;
        this.fcT = false;
        this.thumbPath = null;
        this.fcU = null;
        this.fcV = false;
        this.fcW = new C34547b("yuvRecorderWriteData");
        this.fcX = new C34547b("frameCountCallback");
        this.eNa = false;
        this.fda = false;
        this.cvZ = "";
        this.fdb = false;
        this.fdc = 0;
        this.fde = null;
        this.fdf = false;
        this.fdg = true;
        this.fdh = false;
        this.isRecording = false;
        this.fdi = null;
        this.fag = null;
        this.bMU = -1;
        this.fdk = new C66401();
        this.fcY = videoTransPara;
        this.fcL = videoTransPara.width;
        this.fcM = videoTransPara.height;
        this.fcQ = new C34546s();
        C18594c c18594c = C18594c.faj;
        C18594c.m28980Vv();
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", Integer.valueOf(this.fcL), Integer.valueOf(this.fcM));
        this.fag = eGLContext;
        this.fdi = new C9587a(c37897a);
        this.bMU = i;
        C4990ab.m7409c("MicroMsg.Media.MediaCodecMP4MuxRecorder", "textureId : ".concat(String.valueOf(i)), new Object[0]);
        AppMethodBeat.m2505o(12751);
    }

    /* renamed from: kn */
    private boolean m10949kn(int i) {
        AppMethodBeat.m2504i(12752);
        long yz = C5046bo.m7588yz();
        this.fcN = this.fcY.videoBitrate;
        this.eTa = SightVideoJNI.initDataBufferForMMSightLock(this.fcO, this.fcP, i, this.fcL, this.fcM, (float) this.fcY.fps, this.fcN, this.fcY.fzV, 8, this.fcY.fzU, 23.0f, false, false, this.fcY.duration, false);
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "init, bufId: %s", Integer.valueOf(this.eTa));
        if (this.eTa < 0) {
            C4990ab.m7412e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "init failed!");
            AppMethodBeat.m2505o(12752);
            return false;
        }
        this.fcR = i;
        C24670c c24670c = new C24670c();
        if (c24670c.eTn) {
            C4990ab.m7412e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "encodeConfig  InitError");
            AppMethodBeat.m2505o(12752);
            return false;
        }
        C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mTargetRate " + this.fcN + "  videoParams.fps: " + this.fcY.fps + " mTargetHeight:" + this.fcM + " mTargetWidth:" + this.fcL);
        c24670c.bitrate = this.fcN;
        c24670c.eTk = this.fcY.fps;
        c24670c.eTj = this.fcM;
        c24670c.eTi = this.fcL;
        C18594c c18594c;
        try {
            this.fcK = new C9582e(c24670c, true, new C66312());
            C9587a c9587a = this.fdi;
            Surface inputSurface = this.fcK.getInputSurface();
            EGLContext eGLContext = this.fag;
            C66343 c66343 = new C66343();
            C25052j.m39376p(inputSurface, "surface");
            c9587a.aOO = inputSurface;
            C4990ab.m7416i(c9587a.TAG, c9587a.hashCode() + " initWithSurface, eglContext:" + eGLContext + ", surface:" + inputSurface + ", waitNewFrame:false, callback:false");
            c9587a.mo20913b((C31214a) new C9593d(c9587a, eGLContext, inputSurface, c66343));
            synchronized (fdj) {
                try {
                    fdj.wait(500);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e, "initSurfaceLock wait error", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(12752);
                    throw th;
                }
            }
            this.fdi.eXd = new C66354();
            m10941WH();
            this.fcJ = new C9612a(this.fcY.audioSampleRate, this.fcY.fzS);
            this.fcJ.mo36714iW(this.fdf);
            int q = this.fcJ.mo20926q(this.eTa, C21846d.m33386WP(this.fcE));
            C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "initImpl used %sms", Long.valueOf(C5046bo.m7525az(yz)));
            if (q != 0) {
                c18594c = C18594c.faj;
                C18594c.m28983Vy();
                AppMethodBeat.m2505o(12752);
                return false;
            }
            AppMethodBeat.m2505o(12752);
            return true;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e2, "init encoder error", new Object[0]);
            c18594c = C18594c.faj;
            C18594c.m28981Vw();
            AppMethodBeat.m2505o(12752);
            return false;
        }
    }

    /* renamed from: WH */
    private void m10941WH() {
        AppMethodBeat.m2504i(12753);
        this.fdi.mo20914cg(this.fcL, this.fcM);
        this.fdi.mo20916ka(this.fcR);
        this.fdi.mo20915ch(this.fcO, this.fcP);
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", Integer.valueOf(r0), Integer.valueOf(r1), Integer.valueOf(this.fcO), Integer.valueOf(this.fcP), Integer.valueOf(this.fcR));
        AppMethodBeat.m2505o(12753);
    }

    /* renamed from: ko */
    public final boolean mo14856ko(int i) {
        AppMethodBeat.m2504i(12754);
        if (this.eNa) {
            AppMethodBeat.m2505o(12754);
            return true;
        }
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "preInit, cameraOrientation %d", Integer.valueOf(i));
        boolean kn = m10949kn(i);
        this.eNa = true;
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "initImpl result: %s", Boolean.valueOf(kn));
        AppMethodBeat.m2505o(12754);
        return kn;
    }

    /* renamed from: b */
    public final int mo14848b(int i, boolean z, int i2) {
        AppMethodBeat.m2504i(12755);
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
        this.fcW.reset();
        this.fcF = 0;
        this.fcX.reset();
        this.fcT = false;
        this.fdb = z;
        this.fdc = i2;
        this.fcQ.mo55075a(C34543c.WaitStart);
        if (C5046bo.isNullOrNil(this.fcE)) {
            C4990ab.m7412e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.m2505o(12755);
            return -1;
        }
        int i3;
        try {
            this.mFileName = C5730e.atd(this.fcE);
            String atb = C5730e.atb(this.fcE);
            if (!atb.endsWith("/")) {
                atb = atb + "/";
            }
            this.fcS = atb + "tempRotate.mp4";
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "retrieve file name error: %s", e.getMessage());
        }
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", this.fcE, this.fcS);
        this.fcR = i;
        if (!this.eNa) {
            m10949kn(i);
            this.eNa = true;
        }
        if (this.fdh || this.fdf || this.fcJ == null) {
            C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
            this.fcQ.mo55075a(C34543c.Start);
            this.fda = false;
            i3 = 0;
        } else {
            i3 = this.fcJ.mo36708a(new C66375());
            C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", Integer.valueOf(i3));
            this.fda = false;
            if (i3 != 0) {
                this.fcQ.mo55075a(C34543c.Error);
            } else {
                this.fcQ.mo55075a(C34543c.Initialized);
            }
        }
        AppMethodBeat.m2505o(12755);
        return i3;
    }

    /* renamed from: v */
    public final void mo14865v(Runnable runnable) {
        AppMethodBeat.m2504i(12756);
        this.fde = runnable;
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s !!!", runnable);
        if (this.fcK == null || (this.fcJ == null && !this.fdh)) {
            C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                C5004al.m7441d(runnable);
            }
            AppMethodBeat.m2505o(12756);
        } else if (this.fcQ == null || this.fcQ.oxa != C34543c.Stop) {
            this.fcF = (int) this.fcK.mo20901UQ();
            C18594c c18594c = C18594c.faj;
            C18594c.m28984Vz();
            if (this.fcQ != null) {
                this.fcQ.mo55075a(C34543c.PrepareStop);
            }
            AppMethodBeat.m2505o(12756);
        } else {
            C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stop, already in stop videoRecordStatus");
            if (this.fcJ != null) {
                this.fcJ.clear();
            }
            if (runnable != null) {
                C5004al.m7441d(runnable);
            }
            AppMethodBeat.m2505o(12756);
        }
    }

    /* renamed from: Aq */
    public final String mo14833Aq() {
        AppMethodBeat.m2504i(12757);
        String bc = C5046bo.m7532bc(this.cvZ, "");
        AppMethodBeat.m2505o(12757);
        return bc;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(12758);
        C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "cancel record");
        if (this.fcK == null || (this.fcJ == null && !this.fdh)) {
            C4990ab.m7412e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            AppMethodBeat.m2505o(12758);
            return;
        }
        this.fcQ.mo55075a(C34543c.WaitStop);
        this.fcK.mo20899UO();
        if (this.fcJ != null) {
            this.fcJ.mo36709a(new C66417());
        }
        if (this.eTa >= 0) {
            SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
        } else {
            C4990ab.m7413e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "why buf id < 0 ? %d", Integer.valueOf(this.eTa));
        }
        this.fcQ.mo55075a(C34543c.Stop);
        reset();
        AppMethodBeat.m2505o(12758);
    }

    public final void clear() {
        AppMethodBeat.m2504i(12759);
        try {
            C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "clear");
            if (this.fcJ != null) {
                this.fcJ.clear();
            }
            if (this.fdi != null) {
                this.fdi.release();
            }
            if (this.fcK != null) {
                this.fcK.release();
            }
            AppMethodBeat.m2505o(12759);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e, "clear error: %s", e.getMessage());
            AppMethodBeat.m2505o(12759);
        }
    }

    public final void setFilePath(String str) {
        this.fcE = str;
    }

    /* renamed from: mb */
    public final void mo14858mb(String str) {
        this.thumbPath = str;
    }

    /* renamed from: mc */
    public final void mo14859mc(String str) {
        this.fcU = str;
    }

    /* renamed from: WI */
    public final String mo14835WI() {
        return this.fcU;
    }

    public final String getFilePath() {
        return this.fcE;
    }

    public final String getFileName() {
        return this.mFileName;
    }

    /* renamed from: WJ */
    public final float mo14836WJ() {
        return this.fcG;
    }

    public final void reset() {
        AppMethodBeat.m2504i(12760);
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", this.fcK, this.fcJ, this.fcZ);
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", this.fcK, this.fcJ);
        synchronized (this.fcD) {
            try {
                this.fcK = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12760);
            }
        }
        this.fcJ = null;
        this.fcZ = null;
        this.eNa = false;
        this.fda = false;
    }

    /* renamed from: WK */
    public final long mo14837WK() {
        AppMethodBeat.m2504i(12761);
        if (this.fcK != null) {
            long UQ = this.fcK.mo20901UQ();
            AppMethodBeat.m2505o(12761);
            return UQ;
        }
        AppMethodBeat.m2505o(12761);
        return 0;
    }

    public final C39387f getFrameDataCallback() {
        return this.fdk;
    }

    /* renamed from: s */
    public final void mo14862s(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(12762);
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 % 16 != 0) {
            i3 = C3475d.m5785yN(i3);
        }
        if (i4 % 16 != 0) {
            i4 = C3475d.m5785yN(i4);
        }
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.fcO = i;
        this.fcP = i2;
        if (C43305j.owk.mo68846g(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3));
            long yz = C5046bo.m7588yz();
            for (int i5 = 0; i5 < 3; i5++) {
                C43305j.owk.mo68845g(new byte[(((i * i2) * 3) / 2)]);
            }
            C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "preloadCameraData used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        }
        AppMethodBeat.m2505o(12762);
    }

    /* renamed from: Wy */
    public final String mo14845Wy() {
        return this.thumbPath;
    }

    /* renamed from: WL */
    public final C34543c mo14838WL() {
        return this.fcQ.oxa;
    }

    /* renamed from: WM */
    public final int mo14839WM() {
        AppMethodBeat.m2504i(12763);
        int round = Math.round(((float) this.fcF) / 1000.0f);
        AppMethodBeat.m2505o(12763);
        return round;
    }

    /* renamed from: WN */
    public final Point mo14840WN() {
        AppMethodBeat.m2504i(12764);
        Point point = new Point(this.fcO, this.fcP);
        AppMethodBeat.m2505o(12764);
        return point;
    }

    /* renamed from: WO */
    public final int mo14841WO() {
        return this.fcR;
    }

    public final void pause() {
        AppMethodBeat.m2504i(12765);
        C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "pause");
        if (this.fcQ != null && this.fcQ.oxa == C34543c.Start) {
            this.fcQ.mo55075a(C34543c.Pause);
        }
        AppMethodBeat.m2505o(12765);
    }

    /* renamed from: G */
    public final void mo14834G(int i, int i2, int i3) {
        AppMethodBeat.m2504i(12766);
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.fcR = i;
        this.fcO = i2;
        this.fcP = i3;
        this.fdi.mo20916ka(this.fcR);
        m10941WH();
        if (this.fcQ != null && this.fcQ.oxa == C34543c.Pause) {
            this.fcQ.mo55075a(C34543c.Start);
        }
        AppMethodBeat.m2505o(12766);
    }

    /* renamed from: WP */
    public final boolean mo14842WP() {
        return this.fda;
    }

    /* renamed from: a */
    public final void mo14846a(C12543a c12543a) {
        this.fdd = c12543a;
    }

    public final boolean isLandscape() {
        return this.fdb;
    }

    /* renamed from: cv */
    public final void mo14851cv(boolean z) {
        this.fdf = z;
    }

    /* renamed from: WQ */
    public final C1293a mo14843WQ() {
        AppMethodBeat.m2504i(12767);
        if (this.fcJ != null) {
            C1293a bPN = this.fcJ.bPN();
            AppMethodBeat.m2505o(12767);
            return bPN;
        }
        AppMethodBeat.m2505o(12767);
        return null;
    }

    /* renamed from: WR */
    public final void mo14844WR() {
        this.fdg = false;
    }

    public final void setMute(boolean z) {
        this.fdh = z;
    }

    /* renamed from: kp */
    public final void mo14857kp(int i) {
        AppMethodBeat.m2504i(12768);
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "overrideDurationMs: %s", Integer.valueOf(i));
        this.fcH = i;
        AppMethodBeat.m2505o(12768);
    }

    /* renamed from: af */
    public final void mo14847af(float f) {
        AppMethodBeat.m2504i(12769);
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "overrideFps: %s", Float.valueOf(f));
        this.fcI = f;
        AppMethodBeat.m2505o(12769);
    }

    /* renamed from: WS */
    private boolean m10942WS() {
        AppMethodBeat.m2504i(12771);
        if (this.fcQ.oxa == C34543c.Start || this.fcQ.oxa == C34543c.PrepareStop) {
            if (this.fcQ.oxa == C34543c.PrepareStop) {
                this.fcQ.oxa = C34543c.WaitStop;
                C4990ab.m7409c("MicroMsg.Media.MediaCodecMP4MuxRecorder", "forward one more frame", new Object[0]);
            }
            if (this.fcJ != null) {
                this.fcJ.bPM();
            }
            this.fcX.mo55078jl(1);
            this.fcW.mo55078jl(1);
            AppMethodBeat.m2505o(12771);
            return true;
        }
        AppMethodBeat.m2505o(12771);
        return false;
    }

    /* renamed from: WG */
    public final void mo5338WG() {
        AppMethodBeat.m2504i(12770);
        if (this.bMU >= 0 && m10942WS()) {
            this.fdi.mo20918s(this.bMU, System.nanoTime());
        }
        if (this.bsb == null || !m10942WS()) {
            AppMethodBeat.m2505o(12770);
            return;
        }
        C9587a c9587a = this.fdi;
        SurfaceTexture surfaceTexture = this.bsb;
        C25052j.m39376p(surfaceTexture, "surfaceTexture");
        c9587a.mo20913b((C31214a) new C9591i(c9587a, surfaceTexture));
        AppMethodBeat.m2505o(12770);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m10948c(C6630c c6630c) {
        AppMethodBeat.m2504i(12774);
        long yz = C5046bo.m7588yz();
        if (c6630c.fcK == null) {
            AppMethodBeat.m2505o(12774);
            return false;
        }
        c6630c.fcG = (((float) c6630c.fcK.frameNum) * 1000.0f) / ((float) c6630c.fcF);
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", Integer.valueOf(r2), Float.valueOf(c6630c.fcG), Integer.valueOf(c6630c.fcF), c6630c.fcE, Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(c6630c.fcH), Float.valueOf(c6630c.fcI));
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frameCountCallback %s", c6630c.fcX.getValue());
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", c6630c.fcW.getValue());
        String str = null;
        if (CaptureMMProxy.getInstance() != null) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
        } else if (!C5046bo.isNullOrNil(c6630c.fcE)) {
            str = new File(c6630c.fcE).getParentFile().getAbsolutePath();
        }
        Object RJ = !C5046bo.isNullOrNil(str) ? C3475d.m5762RJ(str) : c6630c.fcE;
        int i = c6630c.fcF;
        if (c6630c.fcH > 0) {
            i = c6630c.fcH;
        }
        float f = c6630c.fcG;
        if (c6630c.fcI > 0.0f) {
            f = c6630c.fcI;
        }
        C4990ab.m7416i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "muxResultPath : ".concat(String.valueOf(RJ)));
        C43309m c43309m = new C43309m(c6630c.eTa, RJ, f, c6630c.fcN, i, c6630c.fcY.audioSampleRate, c6630c.fdh);
        long yz2 = C5046bo.m7588yz();
        C4990ab.m7417i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mux used %sms, success: %s", Long.valueOf(C5046bo.m7525az(yz2)), Boolean.valueOf(c43309m.bPO()));
        if (c43309m.bPO()) {
            SightVideoJNI.releaseBigSightDataBufferLock(c6630c.eTa);
            c6630c.fcQ.mo55075a(C34543c.Stop);
            c6630c.cvZ = C25998g.m41489cz(RJ);
            if (!(C5046bo.isNullOrNil(RJ) || RJ.equals(c6630c.fcE))) {
                C5730e.m8623aQ(RJ, c6630c.fcE);
                C5730e.deleteFile(RJ);
            }
            AppMethodBeat.m2505o(12774);
            return true;
        }
        C4990ab.m7412e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mux failed!");
        C34549k.bPC();
        AppMethodBeat.m2505o(12774);
        return false;
    }
}
