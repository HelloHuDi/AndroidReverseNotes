package com.tencent.p177mm.media.widget.p257b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.media.p251b.C24670c;
import com.tencent.p177mm.media.p254g.C9587a;
import com.tencent.p177mm.media.p254g.C9587a.C9589c;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.p255h.p256b.C1786a;
import com.tencent.p177mm.media.p866d.C18586g;
import com.tencent.p177mm.media.p866d.C18586g.C18587c;
import com.tencent.p177mm.media.p866d.C18586g.C18588b;
import com.tencent.p177mm.media.p867i.C18594c;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.model.C34547b;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
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
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.nio.IntBuffer;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

/* renamed from: com.tencent.mm.media.widget.b.d */
public final class C6643d implements C1788b {
    protected String cvZ;
    protected boolean eNa;
    protected int eTa;
    private EGLContext fag;
    final Object fcD;
    protected String fcE;
    protected int fcF;
    protected float fcG;
    private int fcH;
    private float fcI;
    protected C43303c fcJ;
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
    C9587a fdi;
    protected C39387f fdk;
    protected C18586g fdp;
    C37897a fdq;
    public C17126b fdr;
    private boolean isRecording;
    protected String mFileName;
    protected String thumbPath;

    /* renamed from: com.tencent.mm.media.widget.b.d$4 */
    class C66444 implements C17126b<Boolean, C37091y> {

        /* renamed from: com.tencent.mm.media.widget.b.d$4$1 */
        class C66451 implements C28499b {
            C66451() {
            }

            /* renamed from: WT */
            public final void mo14866WT() {
                AppMethodBeat.m2504i(12781);
                C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
                AppMethodBeat.m2505o(12781);
            }
        }

        C66444() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(12783);
            C37091y WV = m11012WV();
            AppMethodBeat.m2505o(12783);
            return WV;
        }

        /* renamed from: WV */
        private C37091y m11012WV() {
            AppMethodBeat.m2504i(12782);
            synchronized (C6643d.this.fcD) {
                try {
                    if (C6643d.this.fdp != null) {
                        IntBuffer intBuffer;
                        C1786a c1786a = C6643d.this.fdq.eYL;
                        if (c1786a != null) {
                            intBuffer = c1786a.eZl;
                        } else {
                            intBuffer = null;
                        }
                        if (intBuffer != null) {
                            intBuffer.position(0);
                            int[] iArr = new int[intBuffer.remaining()];
                            intBuffer.get(iArr);
                            C18586g c18586g = C6643d.this.fdp;
                            int i = C6643d.this.fcL;
                            int i2 = C6643d.this.fcM;
                            C25052j.m39376p(iArr, "data");
                            if (c18586g.eTa < 0) {
                                C4990ab.m7412e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
                            } else {
                                synchronized (c18586g.eTu) {
                                    c18586g.eVS.mo10302aa(new C18587c(c18586g, i, i2, iArr));
                                }
                            }
                        }
                    }
                    if (C6643d.this.fdp != null && C6643d.this.fcQ.oxa == C34543c.WaitStop) {
                        C6643d.this.fdp.stop(false);
                        if (C6643d.this.fcJ != null) {
                            C6643d.this.fcJ.mo36709a(new C66451());
                        }
                        C6643d.this.fdi.release();
                        C6643d c6643d = C6643d.this;
                        C4990ab.m7409c("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl", new Object[0]);
                        C7305d.post(new C66506(), "X264MP4MuxRecorder_stop");
                        if (C6643d.this.fcQ != null) {
                            C6643d.this.fcQ.mo55075a(C34543c.Stop);
                        }
                    }
                } catch (Throwable th) {
                } finally {
                    AppMethodBeat.m2505o(12782);
                }
            }
            return null;
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.d$1 */
    class C66461 implements C39387f {

        /* renamed from: com.tencent.mm.media.widget.b.d$1$1 */
        class C66471 implements C17126b<byte[], C37091y> {
            C66471() {
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(12777);
                C43305j.owk.mo68845g((byte[]) obj);
                AppMethodBeat.m2505o(12777);
                return null;
            }
        }

        C66461() {
        }

        /* renamed from: O */
        public final boolean mo14870O(byte[] bArr) {
            AppMethodBeat.m2504i(12778);
            if (bArr == null || bArr.length <= 0) {
                C4990ab.m7412e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
                AppMethodBeat.m2505o(12778);
                return false;
            } else if (C6643d.this.fcQ.oxa == C34543c.Start || C6643d.this.fcQ.oxa == C34543c.PrepareStop) {
                if (C6643d.this.fcQ.oxa == C34543c.PrepareStop) {
                    C6643d.this.fcQ.oxa = C34543c.WaitStop;
                    C4990ab.m7418v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
                }
                C6643d.this.fcX.mo55078jl(1);
                if (C6643d.this.fcJ != null) {
                    C6643d.this.fcJ.bPM();
                }
                C6643d.this.fdi.mo20912a(bArr, System.nanoTime(), new C66471());
                C6643d.this.fcW.mo55078jl(1);
                AppMethodBeat.m2505o(12778);
                return true;
            } else {
                AppMethodBeat.m2505o(12778);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.d$2 */
    class C66482 implements C17126b<Integer, C37091y> {
        C66482() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(12779);
            Integer num = (Integer) obj;
            if (C6643d.this.fcQ.oxa == C34543c.Start || C6643d.this.fcQ.oxa == C34543c.PrepareStop) {
                if (C6643d.this.fcQ.oxa == C34543c.PrepareStop) {
                    C6643d.this.fcQ.oxa = C34543c.WaitStop;
                    C4990ab.m7418v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
                }
                C6643d.this.fcX.mo55078jl(1);
                if (C6643d.this.fcJ != null) {
                    C6643d.this.fcJ.bPM();
                }
                C6643d.this.fdi.mo20918s(num.intValue(), System.nanoTime());
                C6643d.this.fcW.mo55078jl(1);
            }
            AppMethodBeat.m2505o(12779);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.d$3 */
    class C66493 implements C17126b<Boolean, C37091y> {
        C66493() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(12780);
            C18594c c18594c = C18594c.faj;
            C18594c.m28974Vp();
            AppMethodBeat.m2505o(12780);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.d$6 */
    class C66506 implements Runnable {

        /* renamed from: com.tencent.mm.media.widget.b.d$6$1 */
        class C66511 implements Runnable {
            C66511() {
            }

            public final void run() {
                AppMethodBeat.m2504i(12785);
                C6643d.this.fdd.asv();
                AppMethodBeat.m2505o(12785);
            }
        }

        C66506() {
        }

        public final void run() {
            AppMethodBeat.m2504i(12786);
            synchronized (C6643d.this.fcD) {
                try {
                    C18594c c18594c;
                    C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl result: %s", Boolean.valueOf(C6643d.m10986a(C6643d.this)));
                    if (C6643d.m10986a(C6643d.this)) {
                        c18594c = C18594c.faj;
                        C18594c.m28979Vu();
                        C6643d.m10985a(C6643d.this, C3475d.m5784tv(C6643d.this.fcE));
                        try {
                            C43528a WR = C21846d.m33388WR(C6643d.this.fcE);
                            if (WR != null) {
                                C18594c c18594c2 = C18594c.faj;
                                C18594c.m28990cj(WR.videoBitrate, WR.eTk);
                            }
                        } catch (Exception e) {
                        }
                        if (C6643d.this.fde != null) {
                            C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "call stopCallback");
                            C5004al.m7441d(C6643d.this.fde);
                        }
                    } else {
                        c18594c = C18594c.faj;
                        C18594c.m28978Vt();
                        SightVideoJNI.releaseBigSightDataBufferLock(C6643d.this.eTa);
                        if (C6643d.this.fdd != null) {
                            C5004al.m7441d(new C66511());
                        }
                    }
                    c18594c = C18594c.faj;
                    C18594c.m28977Vs();
                } finally {
                    AppMethodBeat.m2505o(12786);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.d$7 */
    class C66527 implements C28499b {
        C66527() {
        }

        /* renamed from: WT */
        public final void mo14866WT() {
            AppMethodBeat.m2504i(12787);
            C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
            AppMethodBeat.m2505o(12787);
        }
    }

    /* renamed from: com.tencent.mm.media.widget.b.d$5 */
    class C66535 implements C12542a {
        C66535() {
        }

        /* renamed from: WU */
        public final void mo14867WU() {
            AppMethodBeat.m2504i(12784);
            C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "onPcmReady");
            if (C6643d.this.mo14838WL() != C34543c.Initialized) {
                C4990ab.m7420w("MicroMsg.Media.X264MP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                AppMethodBeat.m2505o(12784);
                return;
            }
            C6643d.this.fcQ.mo55075a(C34543c.Start);
            AppMethodBeat.m2505o(12784);
        }
    }

    private C6643d(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(12788);
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
        this.fdq = null;
        this.fdk = new C66461();
        this.fdr = new C66482();
        this.fcY = videoTransPara;
        this.fcL = videoTransPara.width;
        this.fcM = videoTransPara.height;
        this.fcQ = new C34546s();
        C4990ab.m7411d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", Integer.valueOf(this.fcL), Integer.valueOf(this.fcM));
        AppMethodBeat.m2505o(12788);
    }

    public C6643d(VideoTransPara videoTransPara, C37897a c37897a) {
        this(videoTransPara);
        AppMethodBeat.m2504i(12789);
        this.fag = null;
        this.fdq = c37897a;
        this.fdi = new C9587a(c37897a);
        C18594c c18594c = C18594c.faj;
        C18594c.m28972Vn();
        AppMethodBeat.m2505o(12789);
    }

    /* renamed from: kn */
    private boolean m10987kn(int i) {
        AppMethodBeat.m2504i(12790);
        long yz = C5046bo.m7588yz();
        this.fcN = this.fcY.videoBitrate;
        this.eTa = SightVideoJNI.initDataBufferForMMSightLock(this.fcO, this.fcP, i, this.fcL, this.fcM, (float) this.fcY.fps, this.fcN, this.fcY.fzV, 8, this.fcY.fzU, 23.0f, false, true, this.fcY.duration, false);
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", Integer.valueOf(this.eTa));
        if (this.eTa < 0) {
            C4990ab.m7412e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
            AppMethodBeat.m2505o(12790);
            return false;
        }
        this.fcR = i;
        C24670c c24670c = new C24670c();
        C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.fcN + "  videoParams.fps: " + this.fcY.fps + " mTargetHeight:" + this.fcM + " mTargetWidth:" + this.fcL);
        c24670c.bitrate = this.fcN;
        c24670c.eTk = this.fcY.fps;
        c24670c.eTj = this.fcM;
        c24670c.eTi = this.fcL;
        this.fdp = new C18586g(this.eTa, this.fcL, this.fcM);
        C9587a c9587a = this.fdi;
        EGLContext eGLContext = this.fag;
        int i2 = this.fcL;
        int i3 = this.fcM;
        C66493 c66493 = new C66493();
        C4990ab.m7416i(c9587a.TAG, c9587a.hashCode() + " initWithSize, eglContext: " + eGLContext + ", callback: false, width:" + i2 + ", height:" + i3);
        c9587a.mo20913b((C31214a) new C9589c(c9587a, eGLContext, i2, i3, c66493));
        this.fdi.eXd = new C66444();
        m10984WH();
        this.fcJ = new C9612a(this.fcY.audioSampleRate, this.fcY.fzS);
        this.fcJ.mo36714iW(this.fdf);
        int q = this.fcJ.mo20926q(this.eTa, C21846d.m33386WP(this.fcE));
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        if (q != 0) {
            C18594c c18594c = C18594c.faj;
            C18594c.m28975Vq();
            AppMethodBeat.m2505o(12790);
            return false;
        }
        AppMethodBeat.m2505o(12790);
        return true;
    }

    /* renamed from: WH */
    private void m10984WH() {
        AppMethodBeat.m2504i(12791);
        this.fdi.mo20914cg(this.fcL, this.fcM);
        this.fdi.mo20916ka(this.fcR);
        this.fdi.mo20915ch(this.fcO, this.fcP);
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", Integer.valueOf(r0), Integer.valueOf(r1), Integer.valueOf(this.fcO), Integer.valueOf(this.fcP), Integer.valueOf(this.fcR));
        AppMethodBeat.m2505o(12791);
    }

    /* renamed from: ko */
    public final boolean mo14856ko(int i) {
        AppMethodBeat.m2504i(12792);
        if (this.eNa) {
            C18594c c18594c = C18594c.faj;
            C18594c.m28973Vo();
            AppMethodBeat.m2505o(12792);
            return true;
        }
        C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
        boolean kn = m10987kn(i);
        this.eNa = true;
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", Boolean.valueOf(kn));
        AppMethodBeat.m2505o(12792);
        return kn;
    }

    /* renamed from: b */
    public final int mo14848b(int i, boolean z, int i2) {
        AppMethodBeat.m2504i(12793);
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
        this.fcW.reset();
        this.fcF = 0;
        this.fcX.reset();
        this.fcT = false;
        this.fdb = z;
        this.fdc = i2;
        this.fcQ.mo55075a(C34543c.WaitStart);
        if (C5046bo.isNullOrNil(this.fcE)) {
            C4990ab.m7412e("MicroMsg.Media.X264MP4MuxRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.m2505o(12793);
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
            C4990ab.m7413e("MicroMsg.Media.X264MP4MuxRecorder", "retrieve file name error: %s", e.getMessage());
        }
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", this.fcE, this.fcS);
        this.fcR = i;
        if (!this.eNa) {
            m10987kn(i);
            this.eNa = true;
        }
        synchronized (this.fcD) {
            try {
                C18586g c18586g = this.fdp;
                c18586g.isStop = false;
                c18586g.eVT = false;
                c18586g.frameCount = 0;
                c18586g.startTime = C5046bo.m7588yz();
                SightVideoJNI.setRotateForBufId(c18586g.eTa, 0);
                c18586g.eVR = C7305d.m12301h((Runnable) new C18588b(c18586g), "X264TransEncoder_encodeThread");
                c18586g.eVV = false;
                C4990ab.m7416i("MicroMsg.X264TransEncoder", "start");
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(12793);
                }
            }
        }
        if (this.fdh || this.fdf) {
            C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "start yuvRecorder with mute");
            this.fcQ.mo55075a(C34543c.Start);
            this.fda = false;
            i3 = 0;
        } else {
            i3 = this.fcJ.mo36708a(new C66535());
            C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "start aacRecorder ret: %s", Integer.valueOf(i3));
            this.fda = false;
            if (i3 != 0) {
                this.fcQ.mo55075a(C34543c.Error);
            } else {
                this.fcQ.mo55075a(C34543c.Initialized);
            }
        }
        AppMethodBeat.m2505o(12793);
        return i3;
    }

    /* JADX WARNING: Missing block: B:24:0x005c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(12794);
     */
    /* JADX WARNING: Missing block: B:31:0x007f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(12794);
     */
    /* JADX WARNING: Missing block: B:40:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: v */
    public final void mo14865v(Runnable runnable) {
        AppMethodBeat.m2504i(12794);
        synchronized (this.fcD) {
            try {
                this.fde = runnable;
                C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", runnable);
                if (this.fdp == null || (this.fcJ == null && !this.fdh)) {
                    C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
                    if (runnable != null) {
                        C5004al.m7441d(runnable);
                    }
                } else if (this.fcQ == null || this.fcQ.oxa != C34543c.Stop) {
                    this.fdk = null;
                    this.fcF = (int) C5046bo.m7525az(this.fdp.startTime);
                    if (this.fcQ != null) {
                        C18594c c18594c = C18594c.faj;
                        C18594c.m28976Vr();
                        this.fcQ.mo55075a(C34543c.PrepareStop);
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
                    if (this.fcJ != null) {
                        this.fcJ.clear();
                    }
                    if (runnable != null) {
                        C5004al.m7441d(runnable);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12794);
            }
        }
    }

    /* renamed from: Aq */
    public final String mo14833Aq() {
        AppMethodBeat.m2504i(12795);
        String bc = C5046bo.m7532bc(this.cvZ, "");
        AppMethodBeat.m2505o(12795);
        return bc;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(12796);
        C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
        synchronized (this.fcD) {
            try {
                if (this.fdp == null || (this.fcJ == null && !this.fdh)) {
                    C4990ab.m7412e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
                } else {
                    this.fcQ.mo55075a(C34543c.WaitStop);
                    this.fdp.stop(true);
                    if (this.fcJ != null) {
                        this.fcJ.mo36709a(new C66527());
                    }
                    if (this.eTa >= 0) {
                        SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
                    } else {
                        C4990ab.m7413e("MicroMsg.Media.X264MP4MuxRecorder", "why buf id < 0 ? %d", Integer.valueOf(this.eTa));
                    }
                    this.fcQ.mo55075a(C34543c.Stop);
                    reset();
                    AppMethodBeat.m2505o(12796);
                }
            } finally {
                AppMethodBeat.m2505o(12796);
            }
        }
    }

    public final void clear() {
        AppMethodBeat.m2504i(12797);
        try {
            C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "clear");
            if (this.fcJ != null) {
                this.fcJ.clear();
            }
            if (this.fdi != null) {
                this.fdi.release();
            }
            if (this.eTa >= 0) {
                SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
            }
            AppMethodBeat.m2505o(12797);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", e, "clear error: %s", e.getMessage());
            AppMethodBeat.m2505o(12797);
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
        AppMethodBeat.m2504i(12798);
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", this.fdp, this.fcJ, this.fcZ);
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", this.fdp, this.fcJ);
        synchronized (this.fcD) {
            try {
                this.fdp = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12798);
            }
        }
        this.fcJ = null;
        this.fcZ = null;
        this.eNa = false;
        this.fda = false;
    }

    /* renamed from: WK */
    public final long mo14837WK() {
        long az;
        AppMethodBeat.m2504i(12799);
        synchronized (this.fcD) {
            try {
                if (this.fdp != null) {
                    az = C5046bo.m7525az(this.fdp.startTime);
                } else {
                    AppMethodBeat.m2505o(12799);
                    return 0;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12799);
            }
        }
        return az;
    }

    public final C39387f getFrameDataCallback() {
        return this.fdk;
    }

    /* renamed from: s */
    public final void mo14862s(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(12800);
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 % 16 != 0) {
            i3 = C3475d.m5785yN(i3);
        }
        if (i4 % 16 != 0) {
            i4 = C3475d.m5785yN(i4);
        }
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.fcO = i;
        this.fcP = i2;
        if (C43305j.owk.mo68846g(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3));
            long yz = C5046bo.m7588yz();
            for (int i5 = 0; i5 < 3; i5++) {
                C43305j.owk.mo68845g(new byte[(((i * i2) * 3) / 2)]);
            }
            C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        }
        AppMethodBeat.m2505o(12800);
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
        AppMethodBeat.m2504i(12801);
        int round = Math.round(((float) this.fcF) / 1000.0f);
        AppMethodBeat.m2505o(12801);
        return round;
    }

    /* renamed from: WN */
    public final Point mo14840WN() {
        AppMethodBeat.m2504i(12802);
        Point point = new Point(this.fcO, this.fcP);
        AppMethodBeat.m2505o(12802);
        return point;
    }

    /* renamed from: WO */
    public final int mo14841WO() {
        return this.fcR;
    }

    public final void pause() {
        AppMethodBeat.m2504i(12803);
        C4990ab.m7416i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
        if (this.fcQ != null && this.fcQ.oxa == C34543c.Start) {
            this.fcQ.mo55075a(C34543c.Pause);
        }
        AppMethodBeat.m2505o(12803);
    }

    /* renamed from: G */
    public final void mo14834G(int i, int i2, int i3) {
        AppMethodBeat.m2504i(12804);
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", Integer.valueOf(i));
        this.fcR = i;
        this.fcO = i2;
        this.fcP = i3;
        this.fdi.mo20916ka(this.fcR);
        m10984WH();
        if (this.fcQ != null && this.fcQ.oxa == C34543c.Pause) {
            this.fcQ.mo55075a(C34543c.Start);
        }
        AppMethodBeat.m2505o(12804);
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
        AppMethodBeat.m2504i(12805);
        if (this.fcJ != null) {
            C1293a bPN = this.fcJ.bPN();
            AppMethodBeat.m2505o(12805);
            return bPN;
        }
        AppMethodBeat.m2505o(12805);
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
        AppMethodBeat.m2504i(12806);
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", Integer.valueOf(i));
        this.fcH = i;
        AppMethodBeat.m2505o(12806);
    }

    /* renamed from: af */
    public final void mo14847af(float f) {
        AppMethodBeat.m2504i(12807);
        C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", Float.valueOf(f));
        this.fcI = f;
        AppMethodBeat.m2505o(12807);
    }

    /* renamed from: WG */
    public final void mo5338WG() {
    }

    /* renamed from: a */
    static /* synthetic */ void m10985a(C6643d c6643d, Bitmap bitmap) {
        AppMethodBeat.m2504i(12809);
        if (bitmap == null) {
            C4990ab.m7412e("MicroMsg.Media.X264MP4MuxRecorder", "saveVideoThumbImpl with null bitmap");
            AppMethodBeat.m2505o(12809);
            return;
        }
        try {
            C5056d.m7625a(bitmap, 100, CompressFormat.JPEG, c6643d.thumbPath, true);
            C4990ab.m7417i("MicroMsg.Media.X264MP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", c6643d.thumbPath, Integer.valueOf(c6643d.fcR), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Long.valueOf(C5730e.asZ(c6643d.thumbPath)));
            AppMethodBeat.m2505o(12809);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", e, "", new Object[0]);
            AppMethodBeat.m2505o(12809);
        }
    }
}
