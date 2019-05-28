package com.tencent.mm.media.widget.b;

import a.y;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.nio.IntBuffer;

public final class d implements b {
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
    protected c fcJ;
    protected int fcL;
    protected int fcM;
    protected int fcN;
    protected int fcO;
    protected int fcP;
    protected s fcQ;
    protected int fcR;
    protected String fcS;
    protected boolean fcT;
    protected String fcU;
    protected boolean fcV;
    protected b fcW;
    protected b fcX;
    protected VideoTransPara fcY;
    protected m fcZ;
    protected boolean fda;
    protected boolean fdb;
    protected int fdc;
    protected a fdd;
    protected Runnable fde;
    protected boolean fdf;
    protected boolean fdg;
    protected boolean fdh;
    com.tencent.mm.media.g.a fdi;
    protected f fdk;
    protected g fdp;
    com.tencent.mm.media.h.a fdq;
    public a.f.a.b fdr;
    private boolean isRecording;
    protected String mFileName;
    protected String thumbPath;

    private d(VideoTransPara videoTransPara) {
        AppMethodBeat.i(12788);
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
        this.fcW = new b("yuvRecorderWriteData");
        this.fcX = new b("frameCountCallback");
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
        this.fdk = new f() {
            public final boolean O(byte[] bArr) {
                AppMethodBeat.i(12778);
                if (bArr == null || bArr.length <= 0) {
                    ab.e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
                    AppMethodBeat.o(12778);
                    return false;
                } else if (d.this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.Start || d.this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.PrepareStop) {
                    if (d.this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.PrepareStop) {
                        d.this.fcQ.oxa = com.tencent.mm.plugin.mmsight.model.a.d.c.WaitStop;
                        ab.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
                    }
                    d.this.fcX.jl(1);
                    if (d.this.fcJ != null) {
                        d.this.fcJ.bPM();
                    }
                    d.this.fdi.a(bArr, System.nanoTime(), new a.f.a.b<byte[], y>() {
                        public final /* synthetic */ Object am(Object obj) {
                            AppMethodBeat.i(12777);
                            j.owk.g((byte[]) obj);
                            AppMethodBeat.o(12777);
                            return null;
                        }
                    });
                    d.this.fcW.jl(1);
                    AppMethodBeat.o(12778);
                    return true;
                } else {
                    AppMethodBeat.o(12778);
                    return false;
                }
            }
        };
        this.fdr = new a.f.a.b<Integer, y>() {
            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(12779);
                Integer num = (Integer) obj;
                if (d.this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.Start || d.this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.PrepareStop) {
                    if (d.this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.PrepareStop) {
                        d.this.fcQ.oxa = com.tencent.mm.plugin.mmsight.model.a.d.c.WaitStop;
                        ab.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
                    }
                    d.this.fcX.jl(1);
                    if (d.this.fcJ != null) {
                        d.this.fcJ.bPM();
                    }
                    d.this.fdi.s(num.intValue(), System.nanoTime());
                    d.this.fcW.jl(1);
                }
                AppMethodBeat.o(12779);
                return null;
            }
        };
        this.fcY = videoTransPara;
        this.fcL = videoTransPara.width;
        this.fcM = videoTransPara.height;
        this.fcQ = new s();
        ab.d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", Integer.valueOf(this.fcL), Integer.valueOf(this.fcM));
        AppMethodBeat.o(12788);
    }

    public d(VideoTransPara videoTransPara, com.tencent.mm.media.h.a aVar) {
        this(videoTransPara);
        AppMethodBeat.i(12789);
        this.fag = null;
        this.fdq = aVar;
        this.fdi = new com.tencent.mm.media.g.a(aVar);
        com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
        com.tencent.mm.media.i.c.Vn();
        AppMethodBeat.o(12789);
    }

    private boolean kn(int i) {
        AppMethodBeat.i(12790);
        long yz = bo.yz();
        this.fcN = this.fcY.videoBitrate;
        this.eTa = SightVideoJNI.initDataBufferForMMSightLock(this.fcO, this.fcP, i, this.fcL, this.fcM, (float) this.fcY.fps, this.fcN, this.fcY.fzV, 8, this.fcY.fzU, 23.0f, false, true, this.fcY.duration, false);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", Integer.valueOf(this.eTa));
        if (this.eTa < 0) {
            ab.e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
            AppMethodBeat.o(12790);
            return false;
        }
        this.fcR = i;
        com.tencent.mm.media.b.c cVar = new com.tencent.mm.media.b.c();
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.fcN + "  videoParams.fps: " + this.fcY.fps + " mTargetHeight:" + this.fcM + " mTargetWidth:" + this.fcL);
        cVar.bitrate = this.fcN;
        cVar.eTk = this.fcY.fps;
        cVar.eTj = this.fcM;
        cVar.eTi = this.fcL;
        this.fdp = new g(this.eTa, this.fcL, this.fcM);
        com.tencent.mm.media.g.a aVar = this.fdi;
        EGLContext eGLContext = this.fag;
        int i2 = this.fcL;
        int i3 = this.fcM;
        AnonymousClass3 anonymousClass3 = new a.f.a.b<Boolean, y>() {
            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(12780);
                com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.Vp();
                AppMethodBeat.o(12780);
                return null;
            }
        };
        ab.i(aVar.TAG, aVar.hashCode() + " initWithSize, eglContext: " + eGLContext + ", callback: false, width:" + i2 + ", height:" + i3);
        aVar.b((a.f.a.a) new com.tencent.mm.media.g.a.c(aVar, eGLContext, i2, i3, anonymousClass3));
        this.fdi.eXd = new a.f.a.b<Boolean, y>() {
            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(12783);
                y WV = WV();
                AppMethodBeat.o(12783);
                return WV;
            }

            private y WV() {
                AppMethodBeat.i(12782);
                synchronized (d.this.fcD) {
                    try {
                        if (d.this.fdp != null) {
                            IntBuffer intBuffer;
                            com.tencent.mm.media.h.b.a aVar = d.this.fdq.eYL;
                            if (aVar != null) {
                                intBuffer = aVar.eZl;
                            } else {
                                intBuffer = null;
                            }
                            if (intBuffer != null) {
                                intBuffer.position(0);
                                int[] iArr = new int[intBuffer.remaining()];
                                intBuffer.get(iArr);
                                g gVar = d.this.fdp;
                                int i = d.this.fcL;
                                int i2 = d.this.fcM;
                                a.f.b.j.p(iArr, "data");
                                if (gVar.eTa < 0) {
                                    ab.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
                                } else {
                                    synchronized (gVar.eTu) {
                                        gVar.eVS.aa(new g.c(gVar, i, i2, iArr));
                                    }
                                }
                            }
                        }
                        if (d.this.fdp != null && d.this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.WaitStop) {
                            d.this.fdp.stop(false);
                            if (d.this.fcJ != null) {
                                d.this.fcJ.a(new c.b() {
                                    public final void WT() {
                                        AppMethodBeat.i(12781);
                                        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
                                        AppMethodBeat.o(12781);
                                    }
                                });
                            }
                            d.this.fdi.release();
                            d dVar = d.this;
                            ab.c("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl", new Object[0]);
                            com.tencent.mm.sdk.g.d.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(12786);
                                    synchronized (d.this.fcD) {
                                        try {
                                            com.tencent.mm.media.i.c cVar;
                                            ab.i("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl result: %s", Boolean.valueOf(d.a(d.this)));
                                            if (d.a(d.this)) {
                                                cVar = com.tencent.mm.media.i.c.faj;
                                                com.tencent.mm.media.i.c.Vu();
                                                d.a(d.this, com.tencent.mm.plugin.mmsight.d.tv(d.this.fcE));
                                                try {
                                                    com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(d.this.fcE);
                                                    if (WR != null) {
                                                        com.tencent.mm.media.i.c cVar2 = com.tencent.mm.media.i.c.faj;
                                                        com.tencent.mm.media.i.c.cj(WR.videoBitrate, WR.eTk);
                                                    }
                                                } catch (Exception e) {
                                                }
                                                if (d.this.fde != null) {
                                                    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "call stopCallback");
                                                    al.d(d.this.fde);
                                                }
                                            } else {
                                                cVar = com.tencent.mm.media.i.c.faj;
                                                com.tencent.mm.media.i.c.Vt();
                                                SightVideoJNI.releaseBigSightDataBufferLock(d.this.eTa);
                                                if (d.this.fdd != null) {
                                                    al.d(new Runnable() {
                                                        public final void run() {
                                                            AppMethodBeat.i(12785);
                                                            d.this.fdd.asv();
                                                            AppMethodBeat.o(12785);
                                                        }
                                                    });
                                                }
                                            }
                                            cVar = com.tencent.mm.media.i.c.faj;
                                            com.tencent.mm.media.i.c.Vs();
                                        } finally {
                                            AppMethodBeat.o(12786);
                                        }
                                    }
                                }
                            }, "X264MP4MuxRecorder_stop");
                            if (d.this.fcQ != null) {
                                d.this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Stop);
                            }
                        }
                    } catch (Throwable th) {
                    } finally {
                        AppMethodBeat.o(12782);
                    }
                }
                return null;
            }
        };
        WH();
        this.fcJ = new a(this.fcY.audioSampleRate, this.fcY.fzS);
        this.fcJ.iW(this.fdf);
        int q = this.fcJ.q(this.eTa, com.tencent.mm.plugin.sight.base.d.WP(this.fcE));
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", Long.valueOf(bo.az(yz)));
        if (q != 0) {
            com.tencent.mm.media.i.c cVar2 = com.tencent.mm.media.i.c.faj;
            com.tencent.mm.media.i.c.Vq();
            AppMethodBeat.o(12790);
            return false;
        }
        AppMethodBeat.o(12790);
        return true;
    }

    private void WH() {
        AppMethodBeat.i(12791);
        this.fdi.cg(this.fcL, this.fcM);
        this.fdi.ka(this.fcR);
        this.fdi.ch(this.fcO, this.fcP);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", Integer.valueOf(r0), Integer.valueOf(r1), Integer.valueOf(this.fcO), Integer.valueOf(this.fcP), Integer.valueOf(this.fcR));
        AppMethodBeat.o(12791);
    }

    public final boolean ko(int i) {
        AppMethodBeat.i(12792);
        if (this.eNa) {
            com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
            com.tencent.mm.media.i.c.Vo();
            AppMethodBeat.o(12792);
            return true;
        }
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
        boolean kn = kn(i);
        this.eNa = true;
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", Boolean.valueOf(kn));
        AppMethodBeat.o(12792);
        return kn;
    }

    public final int b(int i, boolean z, int i2) {
        AppMethodBeat.i(12793);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
        this.fcW.reset();
        this.fcF = 0;
        this.fcX.reset();
        this.fcT = false;
        this.fdb = z;
        this.fdc = i2;
        this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.WaitStart);
        if (bo.isNullOrNil(this.fcE)) {
            ab.e("MicroMsg.Media.X264MP4MuxRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.o(12793);
            return -1;
        }
        int i3;
        try {
            this.mFileName = e.atd(this.fcE);
            String atb = e.atb(this.fcE);
            if (!atb.endsWith("/")) {
                atb = atb + "/";
            }
            this.fcS = atb + "tempRotate.mp4";
        } catch (Exception e) {
            ab.e("MicroMsg.Media.X264MP4MuxRecorder", "retrieve file name error: %s", e.getMessage());
        }
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", this.fcE, this.fcS);
        this.fcR = i;
        if (!this.eNa) {
            kn(i);
            this.eNa = true;
        }
        synchronized (this.fcD) {
            try {
                g gVar = this.fdp;
                gVar.isStop = false;
                gVar.eVT = false;
                gVar.frameCount = 0;
                gVar.startTime = bo.yz();
                SightVideoJNI.setRotateForBufId(gVar.eTa, 0);
                gVar.eVR = com.tencent.mm.sdk.g.d.h((Runnable) new g.b(gVar), "X264TransEncoder_encodeThread");
                gVar.eVV = false;
                ab.i("MicroMsg.X264TransEncoder", "start");
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(12793);
                }
            }
        }
        if (this.fdh || this.fdf) {
            ab.i("MicroMsg.Media.X264MP4MuxRecorder", "start yuvRecorder with mute");
            this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Start);
            this.fda = false;
            i3 = 0;
        } else {
            i3 = this.fcJ.a(new c.a() {
                public final void WU() {
                    AppMethodBeat.i(12784);
                    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "onPcmReady");
                    if (d.this.WL() != com.tencent.mm.plugin.mmsight.model.a.d.c.Initialized) {
                        ab.w("MicroMsg.Media.X264MP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                        AppMethodBeat.o(12784);
                        return;
                    }
                    d.this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Start);
                    AppMethodBeat.o(12784);
                }
            });
            ab.i("MicroMsg.Media.X264MP4MuxRecorder", "start aacRecorder ret: %s", Integer.valueOf(i3));
            this.fda = false;
            if (i3 != 0) {
                this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Error);
            } else {
                this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Initialized);
            }
        }
        AppMethodBeat.o(12793);
        return i3;
    }

    /* JADX WARNING: Missing block: B:24:0x005c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(12794);
     */
    /* JADX WARNING: Missing block: B:31:0x007f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(12794);
     */
    /* JADX WARNING: Missing block: B:40:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v(Runnable runnable) {
        AppMethodBeat.i(12794);
        synchronized (this.fcD) {
            try {
                this.fde = runnable;
                ab.i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", runnable);
                if (this.fdp == null || (this.fcJ == null && !this.fdh)) {
                    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
                    if (runnable != null) {
                        al.d(runnable);
                    }
                } else if (this.fcQ == null || this.fcQ.oxa != com.tencent.mm.plugin.mmsight.model.a.d.c.Stop) {
                    this.fdk = null;
                    this.fcF = (int) bo.az(this.fdp.startTime);
                    if (this.fcQ != null) {
                        com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                        com.tencent.mm.media.i.c.Vr();
                        this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.PrepareStop);
                    }
                } else {
                    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
                    if (this.fcJ != null) {
                        this.fcJ.clear();
                    }
                    if (runnable != null) {
                        al.d(runnable);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12794);
            }
        }
    }

    public final String Aq() {
        AppMethodBeat.i(12795);
        String bc = bo.bc(this.cvZ, "");
        AppMethodBeat.o(12795);
        return bc;
    }

    public final void cancel() {
        AppMethodBeat.i(12796);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
        synchronized (this.fcD) {
            try {
                if (this.fdp == null || (this.fcJ == null && !this.fdh)) {
                    ab.e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
                } else {
                    this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.WaitStop);
                    this.fdp.stop(true);
                    if (this.fcJ != null) {
                        this.fcJ.a(new c.b() {
                            public final void WT() {
                                AppMethodBeat.i(12787);
                                ab.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
                                AppMethodBeat.o(12787);
                            }
                        });
                    }
                    if (this.eTa >= 0) {
                        SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
                    } else {
                        ab.e("MicroMsg.Media.X264MP4MuxRecorder", "why buf id < 0 ? %d", Integer.valueOf(this.eTa));
                    }
                    this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Stop);
                    reset();
                    AppMethodBeat.o(12796);
                }
            } finally {
                AppMethodBeat.o(12796);
            }
        }
    }

    public final void clear() {
        AppMethodBeat.i(12797);
        try {
            ab.i("MicroMsg.Media.X264MP4MuxRecorder", "clear");
            if (this.fcJ != null) {
                this.fcJ.clear();
            }
            if (this.fdi != null) {
                this.fdi.release();
            }
            if (this.eTa >= 0) {
                SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
            }
            AppMethodBeat.o(12797);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", e, "clear error: %s", e.getMessage());
            AppMethodBeat.o(12797);
        }
    }

    public final void setFilePath(String str) {
        this.fcE = str;
    }

    public final void mb(String str) {
        this.thumbPath = str;
    }

    public final void mc(String str) {
        this.fcU = str;
    }

    public final String WI() {
        return this.fcU;
    }

    public final String getFilePath() {
        return this.fcE;
    }

    public final String getFileName() {
        return this.mFileName;
    }

    public final float WJ() {
        return this.fcG;
    }

    public final void reset() {
        AppMethodBeat.i(12798);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", this.fdp, this.fcJ, this.fcZ);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", this.fdp, this.fcJ);
        synchronized (this.fcD) {
            try {
                this.fdp = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12798);
            }
        }
        this.fcJ = null;
        this.fcZ = null;
        this.eNa = false;
        this.fda = false;
    }

    public final long WK() {
        long az;
        AppMethodBeat.i(12799);
        synchronized (this.fcD) {
            try {
                if (this.fdp != null) {
                    az = bo.az(this.fdp.startTime);
                } else {
                    AppMethodBeat.o(12799);
                    return 0;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12799);
            }
        }
        return az;
    }

    public final f getFrameDataCallback() {
        return this.fdk;
    }

    public final void s(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(12800);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 % 16 != 0) {
            i3 = com.tencent.mm.plugin.mmsight.d.yN(i3);
        }
        if (i4 % 16 != 0) {
            i4 = com.tencent.mm.plugin.mmsight.d.yN(i4);
        }
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.fcO = i;
        this.fcP = i2;
        if (j.owk.g(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            ab.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3));
            long yz = bo.yz();
            for (int i5 = 0; i5 < 3; i5++) {
                j.owk.g(new byte[(((i * i2) * 3) / 2)]);
            }
            ab.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData used %sms", Long.valueOf(bo.az(yz)));
        }
        AppMethodBeat.o(12800);
    }

    public final String Wy() {
        return this.thumbPath;
    }

    public final com.tencent.mm.plugin.mmsight.model.a.d.c WL() {
        return this.fcQ.oxa;
    }

    public final int WM() {
        AppMethodBeat.i(12801);
        int round = Math.round(((float) this.fcF) / 1000.0f);
        AppMethodBeat.o(12801);
        return round;
    }

    public final Point WN() {
        AppMethodBeat.i(12802);
        Point point = new Point(this.fcO, this.fcP);
        AppMethodBeat.o(12802);
        return point;
    }

    public final int WO() {
        return this.fcR;
    }

    public final void pause() {
        AppMethodBeat.i(12803);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
        if (this.fcQ != null && this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.Start) {
            this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Pause);
        }
        AppMethodBeat.o(12803);
    }

    public final void G(int i, int i2, int i3) {
        AppMethodBeat.i(12804);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", Integer.valueOf(i));
        this.fcR = i;
        this.fcO = i2;
        this.fcP = i3;
        this.fdi.ka(this.fcR);
        WH();
        if (this.fcQ != null && this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.Pause) {
            this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Start);
        }
        AppMethodBeat.o(12804);
    }

    public final boolean WP() {
        return this.fda;
    }

    public final void a(a aVar) {
        this.fdd = aVar;
    }

    public final boolean isLandscape() {
        return this.fdb;
    }

    public final void cv(boolean z) {
        this.fdf = z;
    }

    public final com.tencent.mm.audio.b.c.a WQ() {
        AppMethodBeat.i(12805);
        if (this.fcJ != null) {
            com.tencent.mm.audio.b.c.a bPN = this.fcJ.bPN();
            AppMethodBeat.o(12805);
            return bPN;
        }
        AppMethodBeat.o(12805);
        return null;
    }

    public final void WR() {
        this.fdg = false;
    }

    public final void setMute(boolean z) {
        this.fdh = z;
    }

    public final void kp(int i) {
        AppMethodBeat.i(12806);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", Integer.valueOf(i));
        this.fcH = i;
        AppMethodBeat.o(12806);
    }

    public final void af(float f) {
        AppMethodBeat.i(12807);
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", Float.valueOf(f));
        this.fcI = f;
        AppMethodBeat.o(12807);
    }

    public final void WG() {
    }

    static /* synthetic */ void a(d dVar, Bitmap bitmap) {
        AppMethodBeat.i(12809);
        if (bitmap == null) {
            ab.e("MicroMsg.Media.X264MP4MuxRecorder", "saveVideoThumbImpl with null bitmap");
            AppMethodBeat.o(12809);
            return;
        }
        try {
            com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.JPEG, dVar.thumbPath, true);
            ab.i("MicroMsg.Media.X264MP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", dVar.thumbPath, Integer.valueOf(dVar.fcR), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Long.valueOf(e.asZ(dVar.thumbPath)));
            AppMethodBeat.o(12809);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", e, "", new Object[0]);
            AppMethodBeat.o(12809);
        }
    }
}
