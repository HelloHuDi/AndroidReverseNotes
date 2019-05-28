package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.g;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.e;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class n implements d {
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
    protected c fcJ;
    protected int fcL = 480;
    protected int fcM = 640;
    protected int fcN = 1600000;
    protected int fcO = 480;
    protected int fcP = 640;
    protected s fcQ;
    protected int fcR;
    protected String fcS = null;
    protected boolean fcT = false;
    protected String fcU = null;
    protected boolean fcV = false;
    protected b fcW = new b("yuvRecorderWriteData");
    protected b fcX = new b("frameCountCallback");
    protected VideoTransPara fcY;
    protected m fcZ;
    protected boolean fda = false;
    protected boolean fdb = false;
    protected int fdc = 0;
    protected a fdd;
    protected Runnable fde = null;
    protected boolean fdf = false;
    protected boolean fdg = true;
    protected boolean fdh = false;
    protected f fdk = new f() {
        public final boolean O(byte[] bArr) {
            AppMethodBeat.i(76629);
            if (bArr == null || bArr.length <= 0) {
                ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
                AppMethodBeat.o(76629);
                return false;
            } else if (n.this.fcQ.oxa == c.Start || n.this.fcQ.oxa == c.PrepareStop) {
                if (n.this.fcQ.oxa == c.PrepareStop) {
                    n.this.fcQ.oxa = c.WaitStop;
                    ab.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
                }
                n.this.fcX.jl(1);
                if (n.this.fcJ != null) {
                    n.this.fcJ.bPM();
                }
                n.this.aZ(bArr);
                AppMethodBeat.o(76629);
                return true;
            } else {
                AppMethodBeat.o(76629);
                return false;
            }
        }
    };
    protected String mFileName;
    protected boolean ouL = false;
    protected volatile q owH;
    protected HandlerThread owI;
    protected ak owJ;
    protected int owK = 0;
    protected String thumbPath = null;

    public n(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76639);
        this.fcY = videoTransPara;
        this.fcL = videoTransPara.width;
        this.fcM = videoTransPara.height;
        this.fcN = videoTransPara.videoBitrate;
        k.bPR();
        int bPT = k.bPT();
        if (bPT == -1) {
            this.fcN = videoTransPara.videoBitrate;
        } else {
            this.fcN = bPT;
        }
        this.fcQ = new s();
        ab.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", Integer.valueOf(this.fcL), Integer.valueOf(this.fcM), Integer.valueOf(this.fcN));
        AppMethodBeat.o(76639);
    }

    private boolean kn(int i) {
        AppMethodBeat.i(76640);
        long yz = bo.yz();
        this.ouL = j.ouz.ouL;
        int i2 = this.fcN;
        this.eTa = SightVideoJNI.initDataBufferForMMSightLock(this.fcO, this.fcP, i, this.fcL, this.fcM, (float) this.fcY.fps, i2, this.fcY.fzV, 8, this.fcY.fzU, 23.0f, false, false, this.fcY.duration, false);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", Integer.valueOf(this.eTa));
        if (this.eTa < 0) {
            ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
            k.bPz();
            AppMethodBeat.o(76640);
            return false;
        }
        this.fcR = i;
        this.owH = new q(this.fcO, this.fcP, this.fcL, this.fcM, this.fcN, this.fcY.fzT, this.fcY.fps, this.ouL);
        int ew = this.owH.ew(this.eTa, i);
        int i3 = 0;
        if (!this.fdh) {
            int i4 = -1;
            if (CaptureMMProxy.getInstance() != null) {
                i4 = CaptureMMProxy.getInstance().getInt(ac.a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, -1);
            }
            if (i4 < 0) {
                this.fcJ = new g(this.fcY.audioSampleRate, this.fcY.fzS);
                this.fcJ.iW(this.fdf);
                i3 = this.fcJ.q(this.eTa, d.WP(this.fcE));
                if (ew < 0 || i3 < 0) {
                    ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(ew), Integer.valueOf(i3));
                    if (i3 < 0 && ew >= 0) {
                        ab.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
                        this.fcJ.clear();
                        this.fcJ = new i(this.fcY.audioSampleRate, this.fcY.fzS);
                        this.fcJ.iW(this.fdf);
                        ab.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", Integer.valueOf(this.fcJ.q(this.eTa, d.WP(this.fcE))));
                        if (this.fcJ.q(this.eTa, d.WP(this.fcE)) >= 0) {
                            AppMethodBeat.o(76640);
                            return true;
                        }
                    }
                    SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
                    k.bPz();
                    AppMethodBeat.o(76640);
                    return false;
                }
            }
            if (i4 == 1) {
                this.fcJ = new g(this.fcY.audioSampleRate, this.fcY.fzS);
                this.fcJ.iW(this.fdf);
                i3 = this.fcJ.q(this.eTa, d.WP(this.fcE));
            } else if (i4 == 2) {
                this.fcJ = new i(this.fcY.audioSampleRate, this.fcY.fzS);
                this.fcJ.iW(this.fdf);
                i3 = this.fcJ.q(this.eTa, d.WP(this.fcE));
            }
            if (ew < 0 || i3 < 0) {
                ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(ew), Integer.valueOf(i3));
                SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
                k.bPz();
                AppMethodBeat.o(76640);
                return false;
            }
        } else if (ew < 0) {
            ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", Integer.valueOf(ew), Integer.valueOf(0));
            SightVideoJNI.releaseBigSightDataBuffer(this.eTa);
            k.bPz();
            AppMethodBeat.o(76640);
            return false;
        }
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(76640);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aZ(byte[] bArr) {
        AppMethodBeat.i(76641);
        if (this.owH != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bArr;
            if (this.owJ != null) {
                this.owJ.sendMessage(obtain);
            }
        }
        AppMethodBeat.o(76641);
    }

    public final boolean ko(int i) {
        AppMethodBeat.i(76642);
        if (this.eNa) {
            AppMethodBeat.o(76642);
            return true;
        }
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
        boolean kn = kn(i);
        this.eNa = true;
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", Boolean.valueOf(kn));
        AppMethodBeat.o(76642);
        return kn;
    }

    public final int b(int i, boolean z, int i2) {
        int i3 = -1;
        AppMethodBeat.i(76643);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
        this.fcW.reset();
        this.fcF = 0;
        this.fcX.reset();
        this.fcT = false;
        this.fdb = z;
        this.fdc = i2;
        this.fcQ.a(c.WaitStart);
        if (bo.isNullOrNil(this.fcE)) {
            ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.o(76643);
        } else {
            try {
                this.mFileName = e.atd(this.fcE);
                String atb = e.atb(this.fcE);
                if (!atb.endsWith("/")) {
                    atb = atb + "/";
                }
                this.fcS = atb + "tempRotate.mp4";
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", e.getMessage());
            }
            ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", this.fcE, this.fcS);
            this.fcR = i;
            this.owI = com.tencent.mm.sdk.g.d.ek("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
            this.owI.start();
            this.owJ = new ak(this.owI.getLooper()) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(76630);
                    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
                    if (message.what == 1) {
                        byte[] bArr = (byte[]) message.obj;
                        if (!(bArr == null || n.this.owH == null)) {
                            n.a(n.this, bArr);
                        }
                    }
                    AppMethodBeat.o(76630);
                }
            };
            if (!this.eNa) {
                kn(i);
                this.eNa = true;
            }
            if (this.fdh || this.fdf) {
                ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
                this.owH.start();
                this.fcQ.a(c.Start);
                this.fda = false;
                k.bPx();
                k.Vv();
                i3 = 0;
            } else {
                i3 = this.fcJ.a(new c.a() {
                    public final void WU() {
                        AppMethodBeat.i(76631);
                        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
                        if (n.this.WL() != c.Initialized) {
                            ab.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                            AppMethodBeat.o(76631);
                            return;
                        }
                        n.this.owH.start();
                        n.this.fcQ.a(c.Start);
                        AppMethodBeat.o(76631);
                    }
                });
                ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", Integer.valueOf(i3));
                this.fda = false;
                if (i3 != 0) {
                    this.fcQ.a(c.Error);
                } else {
                    this.fcQ.a(c.Initialized);
                }
                k.bPx();
                k.Vv();
            }
            AppMethodBeat.o(76643);
        }
        return i3;
    }

    public final void v(Runnable runnable) {
        AppMethodBeat.i(76644);
        this.fde = runnable;
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", runnable);
        if (this.owH == null || (this.fcJ == null && !this.fdh)) {
            ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                al.d(runnable);
            }
            AppMethodBeat.o(76644);
        } else if (this.fcQ == null || this.fcQ.oxa != c.Stop) {
            this.fdk = null;
            this.fcF = (int) this.owH.UQ();
            if (this.fcQ != null) {
                this.fcQ.a(c.PrepareStop);
            }
            if (this.owH != null) {
                this.owH.a((f.a) new f.a() {
                    public final void bPP() {
                        AppMethodBeat.i(76632);
                        com.tencent.mm.sdk.g.d.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(76635);
                                ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stopImpl result: %s", Boolean.valueOf(n.this.bPW()));
                                if (!n.this.bPW()) {
                                    SightVideoJNI.releaseBigSightDataBufferLock(n.this.eTa);
                                    if (n.this.fdd != null) {
                                        al.d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(76634);
                                                n.this.fdd.asv();
                                                AppMethodBeat.o(76634);
                                            }
                                        });
                                    }
                                } else if (n.this.fde != null) {
                                    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "call stopCallback");
                                    al.d(n.this.fde);
                                    AppMethodBeat.o(76635);
                                    return;
                                }
                                AppMethodBeat.o(76635);
                            }
                        }, "MMSightMediaCodecMP4MuxRecorder_stop");
                        AppMethodBeat.o(76632);
                    }
                });
            }
            if (this.fcJ != null) {
                this.fcJ.a(new c.b() {
                    public final void WT() {
                        AppMethodBeat.i(76633);
                        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
                        AppMethodBeat.o(76633);
                    }
                });
            }
            AppMethodBeat.o(76644);
        } else {
            ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
            if (this.fcJ != null) {
                this.fcJ.clear();
            }
            if (this.owH != null) {
                this.owH.clear();
            }
            if (runnable != null) {
                al.d(runnable);
            }
            AppMethodBeat.o(76644);
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean bPW() {
        AppMethodBeat.i(76645);
        long yz = bo.yz();
        if (!(this.owI == null || this.owJ == null)) {
            if (com.tencent.mm.compatible.util.d.iW(18)) {
                this.owI.quitSafely();
            } else {
                this.owI.quit();
            }
            this.owJ = null;
        }
        this.fcG = (((float) this.owH.frameCount) * 1000.0f) / ((float) this.fcF);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", Integer.valueOf(r2), Float.valueOf(this.fcG), Integer.valueOf(this.fcF), this.fcE, Long.valueOf(bo.az(yz)), Integer.valueOf(this.fcH), Float.valueOf(this.fcI));
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", this.fcX.getValue());
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", this.fcW.getValue());
        String str = null;
        if (CaptureMMProxy.getInstance() != null) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
        } else if (!bo.isNullOrNil(this.fcE)) {
            str = new File(this.fcE).getParentFile().getAbsolutePath();
        }
        String RJ = !bo.isNullOrNil(str) ? com.tencent.mm.plugin.mmsight.d.RJ(str) : this.fcE;
        int i = this.fcF;
        if (this.fcH > 0) {
            i = this.fcH;
        }
        float f = this.fcG;
        if (this.fcI > 0.0f) {
            f = this.fcI;
        }
        this.fcZ = new m(this.eTa, RJ, f, this.fcN, i, this.fcY.audioSampleRate, this.fdh);
        yz = bo.yz();
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", Long.valueOf(bo.az(yz)), Boolean.valueOf(this.fcZ.bPO()));
        if (this.fcZ.bPO()) {
            if ((this.fdb && this.ouL) || (!(this.ouL || this.fdb) || ((this.fdb && Math.abs(this.fcR - this.fdc) == 0) || this.fdc == 180))) {
                long yz2 = bo.yz();
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
                    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", Long.valueOf(bo.az(yz2)), Integer.valueOf(this.fcR), Boolean.valueOf(this.fdb), Integer.valueOf(this.fdc), Integer.valueOf(i2));
                    yz = bo.yz();
                    try {
                        e.deleteFile(RJ);
                        e.aQ(this.fcS, RJ);
                        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", Long.valueOf(bo.az(yz)));
                        str = this.fcS;
                        com.tencent.mm.sdk.g.d.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(76636);
                                try {
                                    e.deleteFile(str);
                                    AppMethodBeat.o(76636);
                                } catch (Exception e) {
                                    ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", e.getMessage());
                                    AppMethodBeat.o(76636);
                                }
                            }
                        }, "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
                    } catch (Exception e) {
                        ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
                        AppMethodBeat.o(76645);
                        return false;
                    }
                }
            }
            SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
            this.fcQ.a(c.Stop);
            this.cvZ = g.cz(RJ);
            if (!(bo.isNullOrNil(RJ) || RJ.equals(this.fcE))) {
                e.aQ(RJ, this.fcE);
                e.deleteFile(RJ);
            }
            AppMethodBeat.o(76645);
            return true;
        }
        ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
        k.bPC();
        AppMethodBeat.o(76645);
        return false;
    }

    public final String Aq() {
        AppMethodBeat.i(76646);
        String bc = bo.bc(this.cvZ, "");
        AppMethodBeat.o(76646);
        return bc;
    }

    public final void cancel() {
        AppMethodBeat.i(76647);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
        if (this.owH == null || (this.fcJ == null && !this.fdh)) {
            ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            AppMethodBeat.o(76647);
            return;
        }
        this.fcQ.a(c.WaitStop);
        this.owH.a(null);
        if (this.fcJ != null) {
            this.fcJ.a(new c.b() {
                public final void WT() {
                    AppMethodBeat.i(76637);
                    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
                    AppMethodBeat.o(76637);
                }
            });
        }
        if (!(this.owI == null || this.owJ == null)) {
            this.owJ.removeMessages(0);
            this.owI.quit();
            this.owJ = null;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
        this.fcQ.a(c.Stop);
        reset();
        AppMethodBeat.o(76647);
    }

    public final void clear() {
        AppMethodBeat.i(76648);
        try {
            ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
            if (this.fcJ != null) {
                this.fcJ.clear();
            }
            if (this.owH != null) {
                this.owH.clear();
            }
            AppMethodBeat.o(76648);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", e, "clear error: %s", e.getMessage());
            AppMethodBeat.o(76648);
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
        AppMethodBeat.i(76649);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", this.owH, this.fcJ, this.fcZ);
        synchronized (this.fcD) {
            try {
                this.owH = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(76649);
            }
        }
        this.fcJ = null;
        this.fcZ = null;
        this.eNa = false;
        this.fda = false;
    }

    public final long WK() {
        AppMethodBeat.i(76650);
        if (this.owH != null) {
            long UQ = this.owH.UQ();
            AppMethodBeat.o(76650);
            return UQ;
        }
        AppMethodBeat.o(76650);
        return 0;
    }

    public final f getFrameDataCallback() {
        return this.fdk;
    }

    public final void s(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(76651);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.fcL = i3;
        this.fcM = i4;
        this.fcO = i;
        this.fcP = i2;
        if (j.owk.g(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3));
            long yz = bo.yz();
            for (int i5 = 0; i5 < 3; i5++) {
                j.owk.g(new byte[(((i * i2) * 3) / 2)]);
            }
            ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", Long.valueOf(bo.az(yz)));
        }
        AppMethodBeat.o(76651);
    }

    public final String Wy() {
        return this.thumbPath;
    }

    public final c WL() {
        return this.fcQ.oxa;
    }

    public final int WM() {
        AppMethodBeat.i(76652);
        int round = Math.round(((float) this.fcF) / 1000.0f);
        AppMethodBeat.o(76652);
        return round;
    }

    public final Point WN() {
        AppMethodBeat.i(76653);
        Point point = new Point(this.fcO, this.fcP);
        AppMethodBeat.o(76653);
        return point;
    }

    public final int WO() {
        return this.fcR;
    }

    public final void pause() {
        AppMethodBeat.i(76654);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
        if (this.fcQ != null && this.fcQ.oxa == c.Start) {
            this.fcQ.a(c.Pause);
        }
        AppMethodBeat.o(76654);
    }

    public final void G(int i, int i2, int i3) {
        AppMethodBeat.i(76655);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", Integer.valueOf(i));
        if (this.fcQ != null && this.fcQ.oxa == c.Pause) {
            if (this.owH != null) {
                q qVar = this.owH;
                qVar.owT = i;
                qVar.owU = i2;
                qVar.owV = i3;
                ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
            this.fcQ.a(c.Start);
        }
        AppMethodBeat.o(76655);
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
        AppMethodBeat.i(76656);
        if (this.fcJ != null) {
            com.tencent.mm.audio.b.c.a bPN = this.fcJ.bPN();
            AppMethodBeat.o(76656);
            return bPN;
        }
        AppMethodBeat.o(76656);
        return null;
    }

    public final void WR() {
        this.fdg = false;
    }

    public final void setMute(boolean z) {
        this.fdh = z;
    }

    public final void kp(int i) {
        AppMethodBeat.i(76657);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", Integer.valueOf(i));
        this.fcH = i;
        AppMethodBeat.o(76657);
    }

    public final void af(float f) {
        AppMethodBeat.i(76658);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", Float.valueOf(f));
        this.fcI = f;
        AppMethodBeat.o(76658);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0123 A:{Catch:{ all -> 0x01f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A:{Catch:{ all -> 0x01f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0091 A:{Catch:{ all -> 0x01f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a A:{Catch:{ all -> 0x01f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0123 A:{Catch:{ all -> 0x01f7 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(n nVar, byte[] bArr) {
        AppMethodBeat.i(76659);
        ab.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvDataImpl");
        ab.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorder" + nVar.owH);
        synchronized (nVar.fcD) {
            try {
                if (nVar.owH != null) {
                    int i;
                    boolean z;
                    int i2;
                    int i3;
                    boolean z2;
                    b bVar;
                    a aVar;
                    final byte[] bArr2;
                    nVar.fcW.jl(1);
                    long yz = bo.yz();
                    q qVar = nVar.owH;
                    int i4 = nVar.fcO;
                    int i5 = nVar.fcP;
                    bo.yz();
                    int i6 = qVar.owS;
                    boolean z3 = qVar.ouL;
                    if (z3) {
                        i = qVar.owT == -1 ? qVar.owS : qVar.owT;
                    } else if (qVar.owT == -1 || qVar.owT == qVar.owS) {
                        z = false;
                        i = qVar.owS;
                        if (!(qVar.owT == -1 || qVar.owT == qVar.owS)) {
                            i = qVar.owT;
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
                        if (i2 == qVar.eTi || i3 != qVar.eTj) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!(qVar.owU == -1 || qVar.owV == -1 || (qVar.owU == qVar.eTi && qVar.owV == qVar.eTj))) {
                            z2 = true;
                        }
                        ab.d("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", Boolean.valueOf(qVar.ouL), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
                        bVar = new b(i2, i3, qVar.eTl, qVar.eTi, qVar.eTj, z2, z, i6, bArr);
                        aVar = qVar.owW;
                        if (!aVar.ovl) {
                            if (aVar.handler == null) {
                                aVar.handler = new ak(Looper.myLooper());
                            }
                            i3 = aVar.ovh % a.ovf;
                            if (aVar.ovg[i3] != null) {
                                i4 = aVar.ovh;
                                Looper looper = aVar.ovg[i3].getLooper();
                                b.a aVar2 = aVar.ovm;
                                bVar.ovt = i4;
                                bVar.ovv = i3;
                                bVar.ovu = bo.yz();
                                ab.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", Integer.valueOf(bVar.ovq.length), Integer.valueOf(bVar.ovt));
                                new ak(looper).post(new com.tencent.mm.plugin.mmsight.model.a.b.AnonymousClass1(aVar2));
                                aVar.ovh++;
                            }
                        }
                        ab.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", Long.valueOf(bo.az(yz)));
                        if (!nVar.fcT && nVar.fdg) {
                            nVar.fcT = true;
                            bArr2 = new byte[bArr.length];
                            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                            com.tencent.mm.sdk.g.d.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(76638);
                                    n.b(n.this, bArr2);
                                    AppMethodBeat.o(76638);
                                }
                            }, "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                        }
                        nVar.fda = true;
                    } else {
                        z3 = true;
                        i = qVar.owT;
                        if (qVar.owS <= 180) {
                            i -= qVar.owS;
                        } else {
                            i += 360 - qVar.owS;
                        }
                        i6 = Math.max(0, i);
                        if (i6 >= v2helper.VOIP_ENC_HEIGHT_LV1) {
                            i = 0;
                        } else {
                            z = true;
                            i = qVar.owS;
                            i = qVar.owT;
                            if (i != 0) {
                            }
                            i2 = i4;
                            if (i != 0) {
                            }
                            i3 = i5;
                            if (i2 == qVar.eTi) {
                            }
                            z2 = true;
                            z2 = true;
                            ab.d("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", Boolean.valueOf(qVar.ouL), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
                            bVar = new b(i2, i3, qVar.eTl, qVar.eTi, qVar.eTj, z2, z, i6, bArr);
                            aVar = qVar.owW;
                            if (aVar.ovl) {
                            }
                            ab.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", Long.valueOf(bo.az(yz)));
                            nVar.fcT = true;
                            bArr2 = new byte[bArr.length];
                            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                            com.tencent.mm.sdk.g.d.post(/* anonymous class already generated */, "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                            nVar.fda = true;
                        }
                    }
                    z = z3;
                    i6 = i;
                    i = qVar.owS;
                    i = qVar.owT;
                    if (i != 0) {
                    }
                    i2 = i4;
                    if (i != 0) {
                    }
                    i3 = i5;
                    if (i2 == qVar.eTi) {
                    }
                    z2 = true;
                    z2 = true;
                    ab.d("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", Boolean.valueOf(qVar.ouL), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
                    bVar = new b(i2, i3, qVar.eTl, qVar.eTi, qVar.eTj, z2, z, i6, bArr);
                    aVar = qVar.owW;
                    if (aVar.ovl) {
                    }
                    ab.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", Long.valueOf(bo.az(yz)));
                    nVar.fcT = true;
                    bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    com.tencent.mm.sdk.g.d.post(/* anonymous class already generated */, "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                    nVar.fda = true;
                }
            } finally {
                AppMethodBeat.o(76659);
            }
        }
    }

    static /* synthetic */ void b(n nVar, byte[] bArr) {
        AppMethodBeat.i(76660);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (bo.isNullOrNil(nVar.thumbPath)) {
                        ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, thumbpath is null");
                        nVar.fcT = false;
                        AppMethodBeat.o(76660);
                        return;
                    }
                    int width;
                    Bitmap b;
                    int i = (nVar.fcR == 0 || nVar.fcR == 180) ? nVar.fcO : nVar.fcP;
                    int i2 = (nVar.fcR == 0 || nVar.fcR == 180) ? nVar.fcP : nVar.fcO;
                    YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                    Rect rect = new Rect(0, 0, i, i2);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                    if (nVar.fcY != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > nVar.fcY.fAf) {
                        width = decodeByteArray.getWidth();
                        i = decodeByteArray.getHeight();
                        int i3 = nVar.fcY.fAf > 0 ? nVar.fcY.fAf : nVar.fcY.width;
                        if (width < i) {
                            width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                            i = i3;
                        } else {
                            i = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                            width = i3;
                        }
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i, width, true);
                    }
                    if (!nVar.fdb || nVar.fdc == 180) {
                        width = nVar.fcR;
                        if (nVar.fdc == 180) {
                            width += 180;
                            if (width > v2helper.VOIP_ENC_HEIGHT_LV1) {
                                width -= 360;
                            }
                        }
                        b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) width);
                    } else if (Math.abs(nVar.fcR - nVar.fdc) == 0) {
                        b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, 180.0f);
                        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "bitmap recycle %s", decodeByteArray.toString());
                        decodeByteArray.recycle();
                    } else {
                        b = decodeByteArray;
                    }
                    com.tencent.mm.sdk.platformtools.d.a(b, 60, CompressFormat.JPEG, nVar.thumbPath, true);
                    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", nVar.thumbPath, Integer.valueOf(nVar.fcR), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Long.valueOf(e.asZ(nVar.thumbPath)));
                    AppMethodBeat.o(76660);
                    return;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb error: %s", e.getMessage());
                nVar.fcT = false;
                AppMethodBeat.o(76660);
                return;
            }
        }
        ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, data is null");
        nVar.fcT = false;
        AppMethodBeat.o(76660);
    }
}
