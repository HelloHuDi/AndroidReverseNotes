package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p209c.C25998g;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.model.C12563j;
import com.tencent.p177mm.plugin.mmsight.model.C34547b;
import com.tencent.p177mm.plugin.mmsight.model.C34549k;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C21292f.C21293a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43302b.C125411;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43302b.C28498a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c.C12542a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c.C28499b;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C12543a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C34543c;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.n */
public final class C12544n implements C43304d {
    protected String cvZ = "";
    protected boolean eNa = false;
    protected int eTa;
    protected Point fbc = null;
    private final Object fcD = new Object();
    protected String fcE = "";
    protected int fcF = 0;
    protected float fcG = 0.0f;
    private int fcH = -1;
    private float fcI = -1.0f;
    protected C43303c fcJ;
    protected int fcL = 480;
    protected int fcM = 640;
    protected int fcN = 1600000;
    protected int fcO = 480;
    protected int fcP = 640;
    protected C34546s fcQ;
    protected int fcR;
    protected String fcS = null;
    protected boolean fcT = false;
    protected String fcU = null;
    protected boolean fcV = false;
    protected C34547b fcW = new C34547b("yuvRecorderWriteData");
    protected C34547b fcX = new C34547b("frameCountCallback");
    protected VideoTransPara fcY;
    protected C43309m fcZ;
    protected boolean fda = false;
    protected boolean fdb = false;
    protected int fdc = 0;
    protected C12543a fdd;
    protected Runnable fde = null;
    protected boolean fdf = false;
    protected boolean fdg = true;
    protected boolean fdh = false;
    protected C39387f fdk = new C125451();
    protected String mFileName;
    protected boolean ouL = false;
    protected volatile C28500q owH;
    protected HandlerThread owI;
    protected C7306ak owJ;
    protected int owK = 0;
    protected String thumbPath = null;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.n$1 */
    class C125451 implements C39387f {
        C125451() {
        }

        /* renamed from: O */
        public final boolean mo14870O(byte[] bArr) {
            AppMethodBeat.m2504i(76629);
            if (bArr == null || bArr.length <= 0) {
                C4990ab.m7412e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
                AppMethodBeat.m2505o(76629);
                return false;
            } else if (C12544n.this.fcQ.oxa == C34543c.Start || C12544n.this.fcQ.oxa == C34543c.PrepareStop) {
                if (C12544n.this.fcQ.oxa == C34543c.PrepareStop) {
                    C12544n.this.fcQ.oxa = C34543c.WaitStop;
                    C4990ab.m7418v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
                }
                C12544n.this.fcX.mo55078jl(1);
                if (C12544n.this.fcJ != null) {
                    C12544n.this.fcJ.bPM();
                }
                C12544n.this.mo24468aZ(bArr);
                AppMethodBeat.m2505o(76629);
                return true;
            } else {
                AppMethodBeat.m2505o(76629);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.n$4 */
    class C125464 implements C21293a {
        C125464() {
        }

        public final void bPP() {
            AppMethodBeat.m2504i(76632);
            C7305d.post(new C125516(), "MMSightMediaCodecMP4MuxRecorder_stop");
            AppMethodBeat.m2505o(76632);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.n$3 */
    class C125483 implements C12542a {
        C125483() {
        }

        /* renamed from: WU */
        public final void mo14867WU() {
            AppMethodBeat.m2504i(76631);
            C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
            if (C12544n.this.mo14838WL() != C34543c.Initialized) {
                C4990ab.m7420w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                AppMethodBeat.m2505o(76631);
                return;
            }
            C12544n.this.owH.start();
            C12544n.this.fcQ.mo55075a(C34543c.Start);
            AppMethodBeat.m2505o(76631);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.n$5 */
    class C125505 implements C28499b {
        C125505() {
        }

        /* renamed from: WT */
        public final void mo14866WT() {
            AppMethodBeat.m2504i(76633);
            C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
            AppMethodBeat.m2505o(76633);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.n$6 */
    class C125516 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.mmsight.model.a.n$6$1 */
        class C125521 implements Runnable {
            C125521() {
            }

            public final void run() {
                AppMethodBeat.m2504i(76634);
                C12544n.this.fdd.asv();
                AppMethodBeat.m2505o(76634);
            }
        }

        C125516() {
        }

        public final void run() {
            AppMethodBeat.m2504i(76635);
            C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stopImpl result: %s", Boolean.valueOf(C12544n.this.bPW()));
            if (!C12544n.this.bPW()) {
                SightVideoJNI.releaseBigSightDataBufferLock(C12544n.this.eTa);
                if (C12544n.this.fdd != null) {
                    C5004al.m7441d(new C125521());
                }
            } else if (C12544n.this.fde != null) {
                C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "call stopCallback");
                C5004al.m7441d(C12544n.this.fde);
                AppMethodBeat.m2505o(76635);
                return;
            }
            AppMethodBeat.m2505o(76635);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.n$8 */
    class C125538 implements C28499b {
        C125538() {
        }

        /* renamed from: WT */
        public final void mo14866WT() {
            AppMethodBeat.m2504i(76637);
            C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
            AppMethodBeat.m2505o(76637);
        }
    }

    public C12544n(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76639);
        this.fcY = videoTransPara;
        this.fcL = videoTransPara.width;
        this.fcM = videoTransPara.height;
        this.fcN = videoTransPara.videoBitrate;
        C43306k.bPR();
        int bPT = C43306k.bPT();
        if (bPT == -1) {
            this.fcN = videoTransPara.videoBitrate;
        } else {
            this.fcN = bPT;
        }
        this.fcQ = new C34546s();
        C4990ab.m7411d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", Integer.valueOf(this.fcL), Integer.valueOf(this.fcM), Integer.valueOf(this.fcN));
        AppMethodBeat.m2505o(76639);
    }

    /* renamed from: kn */
    private boolean m20461kn(int i) {
        AppMethodBeat.m2504i(76640);
        long yz = C5046bo.m7588yz();
        this.ouL = C12563j.ouz.ouL;
        int i2 = this.fcN;
        this.eTa = SightVideoJNI.initDataBufferForMMSightLock(this.fcO, this.fcP, i, this.fcL, this.fcM, (float) this.fcY.fps, i2, this.fcY.fzV, 8, this.fcY.fzU, 23.0f, false, false, this.fcY.duration, false);
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", Integer.valueOf(this.eTa));
        if (this.eTa < 0) {
            C4990ab.m7412e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
            C34549k.bPz();
            AppMethodBeat.m2505o(76640);
            return false;
        }
        this.fcR = i;
        this.owH = new C28500q(this.fcO, this.fcP, this.fcL, this.fcM, this.fcN, this.fcY.fzT, this.fcY.fps, this.ouL);
        int ew = this.owH.mo46466ew(this.eTa, i);
        int i3 = 0;
        if (!this.fdh) {
            int i4 = -1;
            if (CaptureMMProxy.getInstance() != null) {
                i4 = CaptureMMProxy.getInstance().getInt(C5127a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, -1);
            }
            if (i4 < 0) {
                this.fcJ = new C24797g(this.fcY.audioSampleRate, this.fcY.fzS);
                this.fcJ.mo36714iW(this.fdf);
                i3 = this.fcJ.mo20926q(this.eTa, C21846d.m33386WP(this.fcE));
                if (ew < 0 || i3 < 0) {
                    C4990ab.m7413e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(ew), Integer.valueOf(i3));
                    if (i3 < 0 && ew >= 0) {
                        C4990ab.m7420w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
                        this.fcJ.clear();
                        this.fcJ = new C21299i(this.fcY.audioSampleRate, this.fcY.fzS);
                        this.fcJ.mo36714iW(this.fdf);
                        C4990ab.m7421w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", Integer.valueOf(this.fcJ.mo20926q(this.eTa, C21846d.m33386WP(this.fcE))));
                        if (this.fcJ.mo20926q(this.eTa, C21846d.m33386WP(this.fcE)) >= 0) {
                            AppMethodBeat.m2505o(76640);
                            return true;
                        }
                    }
                    SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
                    C34549k.bPz();
                    AppMethodBeat.m2505o(76640);
                    return false;
                }
            }
            if (i4 == 1) {
                this.fcJ = new C24797g(this.fcY.audioSampleRate, this.fcY.fzS);
                this.fcJ.mo36714iW(this.fdf);
                i3 = this.fcJ.mo20926q(this.eTa, C21846d.m33386WP(this.fcE));
            } else if (i4 == 2) {
                this.fcJ = new C21299i(this.fcY.audioSampleRate, this.fcY.fzS);
                this.fcJ.mo36714iW(this.fdf);
                i3 = this.fcJ.mo20926q(this.eTa, C21846d.m33386WP(this.fcE));
            }
            if (ew < 0 || i3 < 0) {
                C4990ab.m7413e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(ew), Integer.valueOf(i3));
                SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
                C34549k.bPz();
                AppMethodBeat.m2505o(76640);
                return false;
            }
        } else if (ew < 0) {
            C4990ab.m7413e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", Integer.valueOf(ew), Integer.valueOf(0));
            SightVideoJNI.releaseBigSightDataBuffer(this.eTa);
            C34549k.bPz();
            AppMethodBeat.m2505o(76640);
            return false;
        }
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(76640);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aZ */
    public final void mo24468aZ(byte[] bArr) {
        AppMethodBeat.m2504i(76641);
        if (this.owH != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bArr;
            if (this.owJ != null) {
                this.owJ.sendMessage(obtain);
            }
        }
        AppMethodBeat.m2505o(76641);
    }

    /* renamed from: ko */
    public final boolean mo14856ko(int i) {
        AppMethodBeat.m2504i(76642);
        if (this.eNa) {
            AppMethodBeat.m2505o(76642);
            return true;
        }
        C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
        boolean kn = m20461kn(i);
        this.eNa = true;
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", Boolean.valueOf(kn));
        AppMethodBeat.m2505o(76642);
        return kn;
    }

    /* renamed from: b */
    public final int mo14848b(int i, boolean z, int i2) {
        int i3 = -1;
        AppMethodBeat.m2504i(76643);
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
        this.fcW.reset();
        this.fcF = 0;
        this.fcX.reset();
        this.fcT = false;
        this.fdb = z;
        this.fdc = i2;
        this.fcQ.mo55075a(C34543c.WaitStart);
        if (C5046bo.isNullOrNil(this.fcE)) {
            C4990ab.m7412e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.m2505o(76643);
        } else {
            try {
                this.mFileName = C5730e.atd(this.fcE);
                String atb = C5730e.atb(this.fcE);
                if (!atb.endsWith("/")) {
                    atb = atb + "/";
                }
                this.fcS = atb + "tempRotate.mp4";
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", e.getMessage());
            }
            C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", this.fcE, this.fcS);
            this.fcR = i;
            this.owI = C7305d.m12297ek("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
            this.owI.start();
            this.owJ = new C7306ak(this.owI.getLooper()) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.m2504i(76630);
                    C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
                    if (message.what == 1) {
                        byte[] bArr = (byte[]) message.obj;
                        if (!(bArr == null || C12544n.this.owH == null)) {
                            C12544n.m20459a(C12544n.this, bArr);
                        }
                    }
                    AppMethodBeat.m2505o(76630);
                }
            };
            if (!this.eNa) {
                m20461kn(i);
                this.eNa = true;
            }
            if (this.fdh || this.fdf) {
                C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
                this.owH.start();
                this.fcQ.mo55075a(C34543c.Start);
                this.fda = false;
                C34549k.bPx();
                C34549k.m56642Vv();
                i3 = 0;
            } else {
                i3 = this.fcJ.mo36708a(new C125483());
                C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", Integer.valueOf(i3));
                this.fda = false;
                if (i3 != 0) {
                    this.fcQ.mo55075a(C34543c.Error);
                } else {
                    this.fcQ.mo55075a(C34543c.Initialized);
                }
                C34549k.bPx();
                C34549k.m56642Vv();
            }
            AppMethodBeat.m2505o(76643);
        }
        return i3;
    }

    /* renamed from: v */
    public final void mo14865v(Runnable runnable) {
        AppMethodBeat.m2504i(76644);
        this.fde = runnable;
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", runnable);
        if (this.owH == null || (this.fcJ == null && !this.fdh)) {
            C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                C5004al.m7441d(runnable);
            }
            AppMethodBeat.m2505o(76644);
        } else if (this.fcQ == null || this.fcQ.oxa != C34543c.Stop) {
            this.fdk = null;
            this.fcF = (int) this.owH.mo62270UQ();
            if (this.fcQ != null) {
                this.fcQ.mo55075a(C34543c.PrepareStop);
            }
            if (this.owH != null) {
                this.owH.mo62271a((C21293a) new C125464());
            }
            if (this.fcJ != null) {
                this.fcJ.mo36709a(new C125505());
            }
            AppMethodBeat.m2505o(76644);
        } else {
            C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
            if (this.fcJ != null) {
                this.fcJ.clear();
            }
            if (this.owH != null) {
                this.owH.clear();
            }
            if (runnable != null) {
                C5004al.m7441d(runnable);
            }
            AppMethodBeat.m2505o(76644);
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean bPW() {
        AppMethodBeat.m2504i(76645);
        long yz = C5046bo.m7588yz();
        if (!(this.owI == null || this.owJ == null)) {
            if (C1443d.m3068iW(18)) {
                this.owI.quitSafely();
            } else {
                this.owI.quit();
            }
            this.owJ = null;
        }
        this.fcG = (((float) this.owH.frameCount) * 1000.0f) / ((float) this.fcF);
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", Integer.valueOf(r2), Float.valueOf(this.fcG), Integer.valueOf(this.fcF), this.fcE, Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(this.fcH), Float.valueOf(this.fcI));
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", this.fcX.getValue());
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", this.fcW.getValue());
        String str = null;
        if (CaptureMMProxy.getInstance() != null) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
        } else if (!C5046bo.isNullOrNil(this.fcE)) {
            str = new File(this.fcE).getParentFile().getAbsolutePath();
        }
        String RJ = !C5046bo.isNullOrNil(str) ? C3475d.m5762RJ(str) : this.fcE;
        int i = this.fcF;
        if (this.fcH > 0) {
            i = this.fcH;
        }
        float f = this.fcG;
        if (this.fcI > 0.0f) {
            f = this.fcI;
        }
        this.fcZ = new C43309m(this.eTa, RJ, f, this.fcN, i, this.fcY.audioSampleRate, this.fdh);
        yz = C5046bo.m7588yz();
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", Long.valueOf(C5046bo.m7525az(yz)), Boolean.valueOf(this.fcZ.bPO()));
        if (this.fcZ.bPO()) {
            if ((this.fdb && this.ouL) || (!(this.ouL || this.fdb) || ((this.fdb && Math.abs(this.fcR - this.fdc) == 0) || this.fdc == 180))) {
                long yz2 = C5046bo.m7588yz();
                int i2 = (this.ouL || this.fdb) ? this.ouL ? this.fdc : 180 : this.fcR;
                if (this.fdc == 180 && !this.ouL) {
                    i2 += 180;
                    if (i2 > v2helper.VOIP_ENC_HEIGHT_LV1) {
                        i2 -= 360;
                    }
                }
                if (i2 > 0) {
                    SightVideoJNI.tagRotateVideo(RJ, this.fcS, i2);
                    this.fcV = true;
                    C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", Long.valueOf(C5046bo.m7525az(yz2)), Integer.valueOf(this.fcR), Boolean.valueOf(this.fdb), Integer.valueOf(this.fdc), Integer.valueOf(i2));
                    yz = C5046bo.m7588yz();
                    try {
                        C5730e.deleteFile(RJ);
                        C5730e.m8623aQ(this.fcS, RJ);
                        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", Long.valueOf(C5046bo.m7525az(yz)));
                        str = this.fcS;
                        C7305d.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(76636);
                                try {
                                    C5730e.deleteFile(str);
                                    AppMethodBeat.m2505o(76636);
                                } catch (Exception e) {
                                    C4990ab.m7413e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", e.getMessage());
                                    AppMethodBeat.m2505o(76636);
                                }
                            }
                        }, "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
                        AppMethodBeat.m2505o(76645);
                        return false;
                    }
                }
            }
            SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
            this.fcQ.mo55075a(C34543c.Stop);
            this.cvZ = C25998g.m41489cz(RJ);
            if (!(C5046bo.isNullOrNil(RJ) || RJ.equals(this.fcE))) {
                C5730e.m8623aQ(RJ, this.fcE);
                C5730e.deleteFile(RJ);
            }
            AppMethodBeat.m2505o(76645);
            return true;
        }
        C4990ab.m7412e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
        C34549k.bPC();
        AppMethodBeat.m2505o(76645);
        return false;
    }

    /* renamed from: Aq */
    public final String mo14833Aq() {
        AppMethodBeat.m2504i(76646);
        String bc = C5046bo.m7532bc(this.cvZ, "");
        AppMethodBeat.m2505o(76646);
        return bc;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(76647);
        C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
        if (this.owH == null || (this.fcJ == null && !this.fdh)) {
            C4990ab.m7412e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            AppMethodBeat.m2505o(76647);
            return;
        }
        this.fcQ.mo55075a(C34543c.WaitStop);
        this.owH.mo62271a(null);
        if (this.fcJ != null) {
            this.fcJ.mo36709a(new C125538());
        }
        if (!(this.owI == null || this.owJ == null)) {
            this.owJ.removeMessages(0);
            this.owI.quit();
            this.owJ = null;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
        this.fcQ.mo55075a(C34543c.Stop);
        reset();
        AppMethodBeat.m2505o(76647);
    }

    public final void clear() {
        AppMethodBeat.m2504i(76648);
        try {
            C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
            if (this.fcJ != null) {
                this.fcJ.clear();
            }
            if (this.owH != null) {
                this.owH.clear();
            }
            AppMethodBeat.m2505o(76648);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", e, "clear error: %s", e.getMessage());
            AppMethodBeat.m2505o(76648);
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
        AppMethodBeat.m2504i(76649);
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", this.owH, this.fcJ, this.fcZ);
        synchronized (this.fcD) {
            try {
                this.owH = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(76649);
            }
        }
        this.fcJ = null;
        this.fcZ = null;
        this.eNa = false;
        this.fda = false;
    }

    /* renamed from: WK */
    public final long mo14837WK() {
        AppMethodBeat.m2504i(76650);
        if (this.owH != null) {
            long UQ = this.owH.mo62270UQ();
            AppMethodBeat.m2505o(76650);
            return UQ;
        }
        AppMethodBeat.m2505o(76650);
        return 0;
    }

    public final C39387f getFrameDataCallback() {
        return this.fdk;
    }

    /* renamed from: s */
    public final void mo14862s(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(76651);
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.fcL = i3;
        this.fcM = i4;
        this.fcO = i;
        this.fcP = i2;
        if (C43305j.owk.mo68846g(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3));
            long yz = C5046bo.m7588yz();
            for (int i5 = 0; i5 < 3; i5++) {
                C43305j.owk.mo68845g(new byte[(((i * i2) * 3) / 2)]);
            }
            C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        }
        AppMethodBeat.m2505o(76651);
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
        AppMethodBeat.m2504i(76652);
        int round = Math.round(((float) this.fcF) / 1000.0f);
        AppMethodBeat.m2505o(76652);
        return round;
    }

    /* renamed from: WN */
    public final Point mo14840WN() {
        AppMethodBeat.m2504i(76653);
        Point point = new Point(this.fcO, this.fcP);
        AppMethodBeat.m2505o(76653);
        return point;
    }

    /* renamed from: WO */
    public final int mo14841WO() {
        return this.fcR;
    }

    public final void pause() {
        AppMethodBeat.m2504i(76654);
        C4990ab.m7416i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
        if (this.fcQ != null && this.fcQ.oxa == C34543c.Start) {
            this.fcQ.mo55075a(C34543c.Pause);
        }
        AppMethodBeat.m2505o(76654);
    }

    /* renamed from: G */
    public final void mo14834G(int i, int i2, int i3) {
        AppMethodBeat.m2504i(76655);
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", Integer.valueOf(i));
        if (this.fcQ != null && this.fcQ.oxa == C34543c.Pause) {
            if (this.owH != null) {
                C28500q c28500q = this.owH;
                c28500q.owT = i;
                c28500q.owU = i2;
                c28500q.owV = i3;
                C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
            this.fcQ.mo55075a(C34543c.Start);
        }
        AppMethodBeat.m2505o(76655);
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
        AppMethodBeat.m2504i(76656);
        if (this.fcJ != null) {
            C1293a bPN = this.fcJ.bPN();
            AppMethodBeat.m2505o(76656);
            return bPN;
        }
        AppMethodBeat.m2505o(76656);
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
        AppMethodBeat.m2504i(76657);
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", Integer.valueOf(i));
        this.fcH = i;
        AppMethodBeat.m2505o(76657);
    }

    /* renamed from: af */
    public final void mo14847af(float f) {
        AppMethodBeat.m2504i(76658);
        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", Float.valueOf(f));
        this.fcI = f;
        AppMethodBeat.m2505o(76658);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0123 A:{Catch:{ all -> 0x01f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A:{Catch:{ all -> 0x01f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0091 A:{Catch:{ all -> 0x01f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a A:{Catch:{ all -> 0x01f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0123 A:{Catch:{ all -> 0x01f7 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m20459a(C12544n c12544n, byte[] bArr) {
        AppMethodBeat.m2504i(76659);
        C4990ab.m7410d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvDataImpl");
        C4990ab.m7410d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorder" + c12544n.owH);
        synchronized (c12544n.fcD) {
            try {
                if (c12544n.owH != null) {
                    int i;
                    boolean z;
                    int i2;
                    int i3;
                    boolean z2;
                    C43302b c43302b;
                    C46075a c46075a;
                    final byte[] bArr2;
                    c12544n.fcW.mo55078jl(1);
                    long yz = C5046bo.m7588yz();
                    C28500q c28500q = c12544n.owH;
                    int i4 = c12544n.fcO;
                    int i5 = c12544n.fcP;
                    C5046bo.m7588yz();
                    int i6 = c28500q.owS;
                    boolean z3 = c28500q.ouL;
                    if (z3) {
                        i = c28500q.owT == -1 ? c28500q.owS : c28500q.owT;
                    } else if (c28500q.owT == -1 || c28500q.owT == c28500q.owS) {
                        z = false;
                        i = c28500q.owS;
                        if (!(c28500q.owT == -1 || c28500q.owT == c28500q.owS)) {
                            i = c28500q.owT;
                        }
                        if (i != 0 || i == 180) {
                            i2 = i4;
                        } else {
                            i2 = i5;
                        }
                        if (i != 0 || i == 180) {
                            i3 = i5;
                        } else {
                            i3 = i4;
                        }
                        if (i2 == c28500q.eTi || i3 != c28500q.eTj) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!(c28500q.owU == -1 || c28500q.owV == -1 || (c28500q.owU == c28500q.eTi && c28500q.owV == c28500q.eTj))) {
                            z2 = true;
                        }
                        C4990ab.m7411d("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", Boolean.valueOf(c28500q.ouL), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
                        c43302b = new C43302b(i2, i3, c28500q.eTl, c28500q.eTi, c28500q.eTj, z2, z, i6, bArr);
                        c46075a = c28500q.owW;
                        if (!c46075a.ovl) {
                            if (c46075a.handler == null) {
                                c46075a.handler = new C7306ak(Looper.myLooper());
                            }
                            i3 = c46075a.ovh % C46075a.ovf;
                            if (c46075a.ovg[i3] != null) {
                                i4 = c46075a.ovh;
                                Looper looper = c46075a.ovg[i3].getLooper();
                                C28498a c28498a = c46075a.ovm;
                                c43302b.ovt = i4;
                                c43302b.ovv = i3;
                                c43302b.ovu = C5046bo.m7588yz();
                                C4990ab.m7417i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", Integer.valueOf(c43302b.ovq.length), Integer.valueOf(c43302b.ovt));
                                new C7306ak(looper).post(new C125411(c28498a));
                                c46075a.ovh++;
                            }
                        }
                        C4990ab.m7411d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", Long.valueOf(C5046bo.m7525az(yz)));
                        if (!c12544n.fcT && c12544n.fdg) {
                            c12544n.fcT = true;
                            bArr2 = new byte[bArr.length];
                            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                            C7305d.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(76638);
                                    C12544n.m20460b(C12544n.this, bArr2);
                                    AppMethodBeat.m2505o(76638);
                                }
                            }, "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                        }
                        c12544n.fda = true;
                    } else {
                        z3 = true;
                        i = c28500q.owT;
                        if (c28500q.owS <= 180) {
                            i -= c28500q.owS;
                        } else {
                            i += 360 - c28500q.owS;
                        }
                        i6 = Math.max(0, i);
                        if (i6 >= v2helper.VOIP_ENC_HEIGHT_LV1) {
                            i = 0;
                        } else {
                            z = true;
                            i = c28500q.owS;
                            i = c28500q.owT;
                            if (i != 0) {
                            }
                            i2 = i4;
                            if (i != 0) {
                            }
                            i3 = i5;
                            if (i2 == c28500q.eTi) {
                            }
                            z2 = true;
                            z2 = true;
                            C4990ab.m7411d("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", Boolean.valueOf(c28500q.ouL), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
                            c43302b = new C43302b(i2, i3, c28500q.eTl, c28500q.eTi, c28500q.eTj, z2, z, i6, bArr);
                            c46075a = c28500q.owW;
                            if (c46075a.ovl) {
                            }
                            C4990ab.m7411d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", Long.valueOf(C5046bo.m7525az(yz)));
                            c12544n.fcT = true;
                            bArr2 = new byte[bArr.length];
                            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                            C7305d.post(/* anonymous class already generated */, "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                            c12544n.fda = true;
                        }
                    }
                    z = z3;
                    i6 = i;
                    i = c28500q.owS;
                    i = c28500q.owT;
                    if (i != 0) {
                    }
                    i2 = i4;
                    if (i != 0) {
                    }
                    i3 = i5;
                    if (i2 == c28500q.eTi) {
                    }
                    z2 = true;
                    z2 = true;
                    C4990ab.m7411d("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", Boolean.valueOf(c28500q.ouL), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
                    c43302b = new C43302b(i2, i3, c28500q.eTl, c28500q.eTi, c28500q.eTj, z2, z, i6, bArr);
                    c46075a = c28500q.owW;
                    if (c46075a.ovl) {
                    }
                    C4990ab.m7411d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", Long.valueOf(C5046bo.m7525az(yz)));
                    c12544n.fcT = true;
                    bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    C7305d.post(/* anonymous class already generated */, "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                    c12544n.fda = true;
                }
            } finally {
                AppMethodBeat.m2505o(76659);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m20460b(C12544n c12544n, byte[] bArr) {
        AppMethodBeat.m2504i(76660);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (C5046bo.isNullOrNil(c12544n.thumbPath)) {
                        C4990ab.m7412e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, thumbpath is null");
                        c12544n.fcT = false;
                        AppMethodBeat.m2505o(76660);
                        return;
                    }
                    int width;
                    Bitmap b;
                    int i = (c12544n.fcR == 0 || c12544n.fcR == 180) ? c12544n.fcO : c12544n.fcP;
                    int i2 = (c12544n.fcR == 0 || c12544n.fcR == 180) ? c12544n.fcP : c12544n.fcO;
                    YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                    Rect rect = new Rect(0, 0, i, i2);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                    if (c12544n.fcY != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > c12544n.fcY.fAf) {
                        width = decodeByteArray.getWidth();
                        i = decodeByteArray.getHeight();
                        int i3 = c12544n.fcY.fAf > 0 ? c12544n.fcY.fAf : c12544n.fcY.width;
                        if (width < i) {
                            width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                            i = i3;
                        } else {
                            i = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                            width = i3;
                        }
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i, width, true);
                    }
                    if (!c12544n.fdb || c12544n.fdc == 180) {
                        width = c12544n.fcR;
                        if (c12544n.fdc == 180) {
                            width += 180;
                            if (width > v2helper.VOIP_ENC_HEIGHT_LV1) {
                                width -= 360;
                            }
                        }
                        b = C5056d.m7648b(decodeByteArray, (float) width);
                    } else if (Math.abs(c12544n.fcR - c12544n.fdc) == 0) {
                        b = C5056d.m7648b(decodeByteArray, 180.0f);
                        C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "bitmap recycle %s", decodeByteArray.toString());
                        decodeByteArray.recycle();
                    } else {
                        b = decodeByteArray;
                    }
                    C5056d.m7625a(b, 60, CompressFormat.JPEG, c12544n.thumbPath, true);
                    C4990ab.m7417i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", c12544n.thumbPath, Integer.valueOf(c12544n.fcR), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Long.valueOf(C5730e.asZ(c12544n.thumbPath)));
                    AppMethodBeat.m2505o(76660);
                    return;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb error: %s", e.getMessage());
                c12544n.fcT = false;
                AppMethodBeat.m2505o(76660);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, data is null");
        c12544n.fcT = false;
        AppMethodBeat.m2505o(76660);
    }
}
