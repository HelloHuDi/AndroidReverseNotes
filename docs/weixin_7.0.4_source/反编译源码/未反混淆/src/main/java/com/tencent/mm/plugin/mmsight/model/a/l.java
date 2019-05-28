package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.g;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;

public final class l implements d {
    private String cvZ = "";
    private boolean eNa = false;
    int fYT = -1;
    String fcE = "";
    private int fcF = 0;
    private float fcG = 0.0f;
    int fcH = -1;
    float fcI = -1.0f;
    private int fcL = 480;
    private int fcM = 640;
    int fcN = 1600000;
    int fcO = 480;
    int fcP = 640;
    s fcQ;
    int fcR = 0;
    String fcS = null;
    boolean fcT = false;
    private String fcU = null;
    private boolean fcV = false;
    VideoTransPara fcY;
    boolean fda = false;
    boolean fdb = false;
    int fdc = 0;
    com.tencent.mm.plugin.mmsight.model.a.d.a fdd;
    boolean fdg = true;
    private f fdk = new f() {
        public final boolean O(byte[] bArr) {
            AppMethodBeat.i(76594);
            if (bArr == null || bArr.length <= 0) {
                AppMethodBeat.o(76594);
                return false;
            } else if (l.this.fcQ.oxa == c.Start) {
                l lVar = l.this;
                if (!lVar.fcT && lVar.fdg) {
                    lVar.fcT = true;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    d.post(new AnonymousClass7(bArr2), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                }
                if (l.this.ows != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = bArr;
                    l.this.ows.sendMessage(obtain);
                }
                AppMethodBeat.o(76594);
                return true;
            } else {
                AppMethodBeat.o(76594);
                return false;
            }
        }
    };
    private String mFileName;
    boolean ouL = false;
    c own;
    p owo;
    private a owp = null;
    e owq;
    private HandlerThread owr = null;
    ak ows = null;
    int owt = -1;
    private int owu = -1;
    private boolean owv = false;
    public boolean oww = false;
    String thumbPath = null;

    class a implements Runnable {
        float bSi;
        Runnable callback = null;
        int duration;
        volatile int eVU = 0;
        final Object fYV = new Object();
        boolean owA = false;
        boolean owB = false;
        boolean owC = false;
        boolean owD = false;
        int owy;
        volatile boolean owz = true;

        public a() {
            AppMethodBeat.i(76604);
            synchronized (this.fYV) {
                try {
                    String atb = e.atb(l.this.fcE);
                    if (!atb.endsWith("/")) {
                        atb = atb + "/";
                    }
                    l.this.fcS = atb + "tempRotate.mp4";
                } catch (Exception e) {
                    ab.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", e.getMessage());
                } catch (Throwable th) {
                    AppMethodBeat.o(76604);
                }
            }
            AppMethodBeat.o(76604);
        }

        public final void run() {
            AppMethodBeat.i(76605);
            if (l.this.fYT == -1) {
                l.this.fYT = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                ab.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", Integer.valueOf(l.this.fYT));
            }
            synchronized (this.fYV) {
                long yz;
                while (!this.owB) {
                    yz = bo.yz();
                    int triggerEncode = SightVideoJNI.triggerEncode(this.owy, Math.max(0, this.eVU), false);
                    ab.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(bo.az(yz)), Integer.valueOf(this.eVU), Integer.valueOf(triggerEncode), Long.valueOf(Thread.currentThread().getId()));
                    if (Math.abs(triggerEncode - this.eVU) <= 5) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            ab.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
                        } catch (Throwable th) {
                            AppMethodBeat.o(76605);
                        }
                    }
                    this.eVU = triggerEncode;
                }
                yz = bo.yz();
                if (!this.owC) {
                    this.eVU = SightVideoJNI.triggerEncode(this.owy, this.eVU, true);
                }
                ab.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", Long.valueOf(bo.az(yz)), Integer.valueOf(this.eVU), Boolean.valueOf(this.owC), Long.valueOf(Thread.currentThread().getId()));
                if (!this.owC) {
                    int max = Math.max(1000, this.duration);
                    if (l.this.fcH > 0) {
                        max = l.this.fcH;
                    }
                    float f = this.bSi;
                    if (l.this.fcI > 0.0f) {
                        f = l.this.fcI;
                    }
                    l.this.owq = new m(this.owy, l.this.fcE, f, l.this.fcN, max, l.this.fcY.audioSampleRate, false);
                    yz = bo.yz();
                    ab.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", Long.valueOf(bo.az(yz)), Boolean.valueOf(l.this.owq.bPO()));
                    if (!l.this.owq.bPO()) {
                        ab.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
                        SightVideoJNI.releaseBigSightDataBuffer(this.owy);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(76601);
                                if (l.this.fdd != null) {
                                    l.this.fdd.asv();
                                }
                                AppMethodBeat.o(76601);
                            }
                        });
                        ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
                        h.pYm.a(440, 30, 1, false);
                        AppMethodBeat.o(76605);
                        return;
                    } else if ((l.this.fdb && l.this.ouL) || (!(l.this.ouL || l.this.fdb) || ((l.this.fdb && Math.abs(l.this.fcR - l.this.fdc) == 0) || l.this.fdc == 180))) {
                        int i;
                        long yz2 = bo.yz();
                        if (!l.this.ouL && !l.this.fdb) {
                            i = l.this.fcR;
                        } else if (l.this.ouL) {
                            i = l.this.fdc;
                        } else {
                            i = 180;
                        }
                        if (l.this.fdc == 180 && !l.this.ouL) {
                            i += 180;
                            if (i > v2helper.VOIP_ENC_HEIGHT_LV1) {
                                i -= 360;
                            }
                        }
                        if (i > 0) {
                            SightVideoJNI.tagRotateVideo(l.this.fcE, l.this.fcS, i);
                            ab.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", Long.valueOf(bo.az(yz2)), Integer.valueOf(l.this.fcR), Boolean.valueOf(l.this.fdb), Integer.valueOf(l.this.fdc), Integer.valueOf(i));
                            final String str = l.this.fcS;
                            try {
                                e.y(l.this.fcS, l.this.fcE);
                                d.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(76603);
                                        try {
                                            e.deleteFile(str);
                                            AppMethodBeat.o(76603);
                                        } catch (Exception e) {
                                            ab.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", e.getMessage());
                                            AppMethodBeat.o(76603);
                                        }
                                    }
                                }, "BigSightFFMpegRecorder_tagRotate_after_process");
                                ab.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", Long.valueOf(bo.az(yz2)));
                            } catch (Exception e2) {
                                ab.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
                                SightVideoJNI.releaseBigSightDataBuffer(this.owy);
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(76602);
                                        if (l.this.fdd != null) {
                                            l.this.fdd.asv();
                                        }
                                        AppMethodBeat.o(76602);
                                    }
                                });
                                AppMethodBeat.o(76605);
                                return;
                            }
                        }
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(this.owy);
                ab.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", this.callback);
                l.this.reset();
                al.d(this.callback);
                this.owD = true;
                l.this.fYT = -1;
                l.this.owt = -1;
                AppMethodBeat.o(76605);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.l$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ byte[] hWX;

        AnonymousClass7(byte[] bArr) {
            this.hWX = bArr;
        }

        public final void run() {
            AppMethodBeat.i(76600);
            l lVar = l.this;
            byte[] bArr = this.hWX;
            if (bArr != null) {
                try {
                    if (bArr.length != 0) {
                        if (bo.isNullOrNil(lVar.thumbPath)) {
                            ab.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, thumbpath is null");
                            lVar.fcT = false;
                            AppMethodBeat.o(76600);
                            return;
                        }
                        int width;
                        Bitmap b;
                        int i = (lVar.fcR == 0 || lVar.fcR == 180) ? lVar.fcO : lVar.fcP;
                        int i2 = (lVar.fcR == 0 || lVar.fcR == 180) ? lVar.fcP : lVar.fcO;
                        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                        Rect rect = new Rect(0, 0, i, i2);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                        byte[] toByteArray = byteArrayOutputStream.toByteArray();
                        Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                        if (lVar.fcY != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > lVar.fcY.fAf) {
                            width = decodeByteArray.getWidth();
                            i = decodeByteArray.getHeight();
                            int i3 = lVar.fcY.fAf > 0 ? lVar.fcY.fAf : lVar.fcY.width;
                            if (width < i) {
                                width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                                i = i3;
                            } else {
                                i = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                                width = i3;
                            }
                            decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i, width, true);
                        }
                        if (!lVar.fdb || lVar.fdc == 180) {
                            width = lVar.fcR;
                            if (lVar.fdc == 180) {
                                width += 180;
                                if (width > v2helper.VOIP_ENC_HEIGHT_LV1) {
                                    width -= 360;
                                }
                            }
                            b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) width);
                        } else if (Math.abs(lVar.fcR - lVar.fdc) == 0) {
                            b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, 180.0f);
                            ab.i("MicroMsg.MMSightFFMpegRecorder", "bitmap recycle %s", decodeByteArray.toString());
                            decodeByteArray.recycle();
                        } else {
                            b = decodeByteArray;
                        }
                        com.tencent.mm.sdk.platformtools.d.a(b, 60, CompressFormat.JPEG, lVar.thumbPath, true);
                        ab.i("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", lVar.thumbPath, Integer.valueOf(lVar.fcR), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()));
                        AppMethodBeat.o(76600);
                        return;
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb error: %s", e.getMessage());
                    lVar.fcT = false;
                    AppMethodBeat.o(76600);
                    return;
                }
            }
            ab.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, data is null");
            lVar.fcT = false;
            AppMethodBeat.o(76600);
        }
    }

    public l(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76606);
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
        this.eNa = false;
        ab.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", Integer.valueOf(this.fcL), Integer.valueOf(this.fcM), Integer.valueOf(this.fcN), Integer.valueOf(bPT));
        AppMethodBeat.o(76606);
    }

    public final void s(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(76607);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.fcL = i3;
        this.fcM = i4;
        this.fcO = i;
        this.fcP = i2;
        if (j.owk.g(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            ab.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3));
            long yz = bo.yz();
            for (int i5 = 0; i5 < 3; i5++) {
                j.owk.g(new byte[(((i * i2) * 3) / 2)]);
            }
            ab.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", Long.valueOf(bo.az(yz)));
        }
        AppMethodBeat.o(76607);
    }

    public final String Wy() {
        return this.thumbPath;
    }

    private boolean yT(int i) {
        AppMethodBeat.i(76608);
        if (this.owp == null || this.owp.owD) {
            AppMethodBeat.o(76608);
            return false;
        }
        if (!this.owp.owA) {
            this.owp.callback = null;
            this.owp.owC = true;
            this.owp.owB = true;
            d.xDG.remove(this.owp);
        }
        synchronized (this.owp.fYV) {
            try {
                SightVideoJNI.releaseBigSightDataBuffer(i);
                if (this.owp.owy != i) {
                    SightVideoJNI.releaseBigSightDataBuffer(this.owp.owy);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(76608);
            }
        }
        return true;
    }

    public final void clear() {
        boolean z = true;
        AppMethodBeat.i(76609);
        int i = -1;
        if (this.owo != null) {
            i = this.owo.owR;
            if (i < 0) {
                ab.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
                AppMethodBeat.o(76609);
                return;
            }
            this.owo.stop();
        }
        if (this.own != null) {
            this.own.a(null);
        }
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.owp == null);
        if (this.owp == null || !this.owp.owC) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.v(str, str2, objArr);
        if (i >= 0 && !yT(i)) {
            SightVideoJNI.releaseRecorderBufferRef("clear");
            SightVideoJNI.releaseBigSightDataBuffer(i);
        }
        if (this.owr != null) {
            this.owr.quit();
        }
        AppMethodBeat.o(76609);
    }

    public final void cancel() {
        AppMethodBeat.i(76610);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
        this.fcQ.a(c.WaitStop);
        clear();
        this.fcQ.a(c.Stop);
        AppMethodBeat.o(76610);
    }

    public final void v(final Runnable runnable) {
        boolean z;
        AppMethodBeat.i(76611);
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.owp == null);
        if (this.owp == null || !this.owp.owA) {
            z = false;
        } else {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.owp == null || !this.owp.owB) {
            z = false;
        } else {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (this.owp == null || !this.owp.owA) {
            ab.i("MicroMsg.MMSightFFMpegRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", Boolean.valueOf(this.oww), this.ows);
            if (!this.oww || this.ows == null) {
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(76596);
                        l.a(l.this, runnable);
                        AppMethodBeat.o(76596);
                    }
                }, "MMSightFFMpegRecorder_stop");
                AppMethodBeat.o(76611);
                return;
            }
            this.ows.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(76595);
                    l.a(l.this, runnable);
                    AppMethodBeat.o(76595);
                }
            });
            AppMethodBeat.o(76611);
            return;
        }
        synchronized (this.owp.fYV) {
            try {
                reset();
                al.d(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(76611);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void WT() {
        if (this.owp != null) {
            this.owp.owB = true;
        }
    }

    public final String Aq() {
        AppMethodBeat.i(76612);
        String bc = bo.bc(this.cvZ, "");
        AppMethodBeat.o(76612);
        return bc;
    }

    public final c WL() {
        return this.fcQ.oxa;
    }

    public final long WK() {
        AppMethodBeat.i(76613);
        long UQ = this.owo.UQ();
        AppMethodBeat.o(76613);
        return UQ;
    }

    public final f getFrameDataCallback() {
        return this.fdk;
    }

    public final String getFilePath() {
        return this.fcE;
    }

    public final String getFileName() {
        return this.mFileName;
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

    public final void reset() {
        AppMethodBeat.i(76614);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "reset");
        this.fcQ.oxa = c.Stop;
        this.fda = false;
        if (this.own != null) {
            this.own.clear();
        }
        if (this.owo != null) {
            this.owo.clear();
        }
        clear();
        AppMethodBeat.o(76614);
    }

    private boolean kn(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(76615);
        long yz = bo.yz();
        this.ouL = j.ouz.ouL;
        this.fcR = i;
        if (this.ouL) {
            i2 = (i == 0 || i == 180) ? this.fcO : this.fcP;
            i3 = (i == 0 || i == 180) ? this.fcP : this.fcO;
            i4 = (i == 0 || i == 180) ? this.fcL : this.fcM;
            if (i == 0 || i == 180) {
                i5 = this.fcM;
            } else {
                i5 = this.fcL;
            }
        } else {
            i6 = (i == 0 || i == 180) ? this.fcO : this.fcP;
            i3 = (i == 0 || i == 180) ? this.fcP : this.fcO;
            i4 = this.fcL;
            i5 = this.fcM;
            i2 = i6;
        }
        i6 = SightVideoJNI.initDataBufferForMMSight(i2, i3, i, i4, i5, (float) this.fcY.fps, this.fcN, this.fcY.fzV, 8, this.fcY.fzU, 23.0f, this.ouL, true, this.fcY.duration, false);
        if (i6 < 0) {
            ab.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
            k.bPy();
            AppMethodBeat.o(76615);
            return false;
        }
        this.owu = i6;
        this.owo = new p(this.ouL, i, i4, i5);
        i4 = this.owo.yU(i6);
        i2 = 0;
        i3 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i3 = CaptureMMProxy.getInstance().getInt(com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, -1);
        }
        if (i3 < 0) {
            this.own = new g(this.fcY.audioSampleRate, this.fcY.fzS);
            this.own.iW(this.owv);
            i2 = this.own.q(i6, com.tencent.mm.plugin.sight.base.d.WP(this.fcE));
            if (i4 < 0 || i2 < 0) {
                ab.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(i4), Integer.valueOf(i2));
                if (i2 < 0 && i4 >= 0) {
                    ab.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
                    this.own.clear();
                    this.own = new i(this.fcY.audioSampleRate, this.fcY.fzS);
                    this.own.iW(this.owv);
                    ab.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", Integer.valueOf(this.own.q(i6, com.tencent.mm.plugin.sight.base.d.WP(this.fcE))));
                    if (this.own.q(i6, com.tencent.mm.plugin.sight.base.d.WP(this.fcE)) >= 0) {
                        AppMethodBeat.o(76615);
                        return true;
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(i6);
                k.bPy();
                AppMethodBeat.o(76615);
                return false;
            }
        }
        if (i3 == 1) {
            this.own = new g(this.fcY.audioSampleRate, this.fcY.fzS);
            this.own.iW(this.owv);
            i2 = this.own.q(i6, com.tencent.mm.plugin.sight.base.d.WP(this.fcE));
        } else if (i3 == 2) {
            this.own = new i(this.fcY.audioSampleRate, this.fcY.fzS);
            this.own.iW(this.owv);
            i2 = this.own.q(i6, com.tencent.mm.plugin.sight.base.d.WP(this.fcE));
        }
        if (i4 < 0 || i2 < 0) {
            ab.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(i4), Integer.valueOf(i2));
            SightVideoJNI.releaseBigSightDataBuffer(i6);
            k.bPy();
            AppMethodBeat.o(76615);
            return false;
        }
        ab.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(76615);
        return true;
    }

    public final boolean ko(int i) {
        AppMethodBeat.i(76616);
        if (this.eNa) {
            AppMethodBeat.o(76616);
            return true;
        }
        ab.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", Integer.valueOf(i));
        boolean kn = kn(i);
        this.eNa = true;
        ab.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", Boolean.valueOf(kn));
        AppMethodBeat.o(76616);
        return kn;
    }

    public final int b(int i, boolean z, int i2) {
        boolean z2;
        AppMethodBeat.i(76617);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", this.fcQ.oxa, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
        this.fdb = z;
        this.fcF = 0;
        this.fdc = i2;
        this.fcQ.a(c.WaitStart);
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]";
        Object[] objArr = new Object[3];
        objArr[0] = this.fcE;
        objArr[1] = Boolean.valueOf(this.owp == null);
        if (this.owp == null || this.owp.owD) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        ab.i(str, str2, objArr);
        if (this.owp != null && !this.owp.owD) {
            ab.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
            AppMethodBeat.o(76617);
            return -1;
        } else if (bo.isNullOrNil(this.fcE)) {
            ab.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.o(76617);
            return -1;
        } else {
            int i3;
            this.mFileName = e.atd(this.fcE);
            ab.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", this.fcE);
            this.fcR = i;
            ab.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", Integer.valueOf(this.fcR));
            if (!this.eNa) {
                kn(i);
                this.eNa = true;
            }
            p pVar = this.owo;
            if (0 == pVar.miD) {
                pVar.miD = System.currentTimeMillis();
            }
            if (this.owv) {
                i3 = 0;
            } else {
                i3 = this.own.a(new com.tencent.mm.plugin.mmsight.model.a.c.a() {
                    public final void WU() {
                        AppMethodBeat.i(76598);
                        l.this.WU();
                        AppMethodBeat.o(76598);
                    }
                });
            }
            ab.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", Integer.valueOf(i3));
            this.owr = d.ek("BigSightWriteCameraData", 0);
            this.owr.start();
            this.ows = new ak(this.owr.getLooper()) {
                /* JADX WARNING: Removed duplicated region for block: B:81:0x013e  */
                /* JADX WARNING: Removed duplicated region for block: B:46:0x00d5  */
                /* JADX WARNING: Removed duplicated region for block: B:87:0x014d  */
                /* JADX WARNING: Removed duplicated region for block: B:51:0x00df  */
                /* JADX WARNING: Removed duplicated region for block: B:93:0x015b  */
                /* JADX WARNING: Removed duplicated region for block: B:56:0x00e9  */
                /* JADX WARNING: Removed duplicated region for block: B:98:0x0165 A:{SKIP} */
                /* JADX WARNING: Removed duplicated region for block: B:61:0x00f2 A:{SKIP} */
                /* JADX WARNING: Removed duplicated region for block: B:46:0x00d5  */
                /* JADX WARNING: Removed duplicated region for block: B:81:0x013e  */
                /* JADX WARNING: Removed duplicated region for block: B:51:0x00df  */
                /* JADX WARNING: Removed duplicated region for block: B:87:0x014d  */
                /* JADX WARNING: Removed duplicated region for block: B:56:0x00e9  */
                /* JADX WARNING: Removed duplicated region for block: B:93:0x015b  */
                /* JADX WARNING: Removed duplicated region for block: B:61:0x00f2 A:{SKIP} */
                /* JADX WARNING: Removed duplicated region for block: B:98:0x0165 A:{SKIP} */
                /* JADX WARNING: Removed duplicated region for block: B:66:0x00fb A:{SKIP} */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(76599);
                    if (l.this.owt == -1) {
                        l.this.owt = Process.myTid();
                        ab.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", Integer.valueOf(l.this.owt));
                    }
                    if (message.what == 1) {
                        int length;
                        int i;
                        int i2;
                        int i3;
                        byte[] bArr;
                        p pVar;
                        int i4;
                        l.this.own.bPM();
                        l lVar = l.this;
                        byte[] bArr2 = (byte[]) message.obj;
                        p pVar2;
                        if (lVar.ouL) {
                            pVar2 = lVar.owo;
                            length = bArr2.length;
                            i = lVar.fcO;
                            i2 = lVar.fcP;
                            i3 = i;
                            bArr = bArr2;
                            pVar = pVar2;
                        } else {
                            pVar2 = lVar.owo;
                            length = bArr2.length;
                            i4 = (lVar.fcR == 0 || lVar.fcR == 180) ? lVar.fcO : lVar.fcP;
                            if (lVar.fcR == 0 || lVar.fcR == 180) {
                                i2 = lVar.fcP;
                                i3 = i4;
                                bArr = bArr2;
                                pVar = pVar2;
                            } else {
                                i2 = lVar.fcO;
                                i3 = i4;
                                bArr = bArr2;
                                pVar = pVar2;
                            }
                        }
                        pVar.ovu = bo.yz();
                        if (pVar.owR < 0) {
                            ab.e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
                        } else {
                            boolean z;
                            int i5;
                            int i6;
                            boolean z2;
                            synchronized (p.class) {
                                try {
                                    pVar.frameCount++;
                                } catch (Throwable th) {
                                    while (true) {
                                        AppMethodBeat.o(76599);
                                    }
                                }
                            }
                            i4 = pVar.owS;
                            boolean z3 = pVar.ouL;
                            if (z3) {
                                i4 = pVar.owT == -1 ? pVar.owS : pVar.owT;
                            } else if (pVar.owT == -1 || pVar.owT == pVar.owS) {
                                z = false;
                                SightVideoJNI.setRotateForBufId(pVar.owR, i4);
                                i = z ? (i4 == 0 || i4 == 180) ? pVar.eTi : pVar.eTj : (i4 == 0 || i4 == 180) ? pVar.eTj : pVar.eTi;
                                i5 = z ? (i4 == 0 || i4 == 180) ? pVar.eTj : pVar.eTi : (i4 == 0 || i4 == 180) ? pVar.eTi : pVar.eTj;
                                i6 = z ? (i4 == 0 || i4 == 180) ? i3 : i2 : (i4 == 0 || i4 == 180) ? i2 : i3;
                                if (z) {
                                    if (i4 == 0 || i4 == 180) {
                                        i3 = i2;
                                    }
                                } else if (!(i4 == 0 || i4 == 180)) {
                                    i3 = i2;
                                }
                                if (i6 == i || i3 != i5) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                SightVideoJNI.writeYuvDataForMMSight(pVar.owR, bArr, length, i, i5, z, z2, i6, i3);
                                ab.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", Long.valueOf(bo.az(pVar.ovu)));
                            } else {
                                z3 = true;
                                i4 = pVar.owT;
                                if (pVar.owS <= 180) {
                                    i4 -= pVar.owS;
                                } else {
                                    i4 += 360 - pVar.owS;
                                }
                                i4 = Math.max(0, i4);
                                if (i4 >= v2helper.VOIP_ENC_HEIGHT_LV1) {
                                    i4 = 0;
                                } else {
                                    z = true;
                                    SightVideoJNI.setRotateForBufId(pVar.owR, i4);
                                    if (z) {
                                    }
                                    if (z) {
                                    }
                                    if (z) {
                                    }
                                    if (z) {
                                    }
                                    if (i6 == i) {
                                    }
                                    z2 = true;
                                    SightVideoJNI.writeYuvDataForMMSight(pVar.owR, bArr, length, i, i5, z, z2, i6, i3);
                                    ab.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", Long.valueOf(bo.az(pVar.ovu)));
                                }
                            }
                            z = z3;
                            SightVideoJNI.setRotateForBufId(pVar.owR, i4);
                            if (z) {
                            }
                            if (z) {
                            }
                            if (z) {
                            }
                            if (z) {
                            }
                            if (i6 == i) {
                            }
                            z2 = true;
                            SightVideoJNI.writeYuvDataForMMSight(pVar.owR, bArr, length, i, i5, z, z2, i6, i3);
                            ab.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", Long.valueOf(bo.az(pVar.ovu)));
                        }
                        j.owk.g(bArr2);
                        lVar.fda = true;
                    }
                    AppMethodBeat.o(76599);
                }
            };
            this.fda = false;
            if (i3 != 0) {
                this.fcQ.a(c.Error);
            } else {
                this.fcQ.a(c.Initialized);
            }
            k.bPx();
            ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
            h.pYm.a(440, 1, 1, false);
            if (this.owv) {
                WU();
            }
            AppMethodBeat.o(76617);
            return i3;
        }
    }

    /* Access modifiers changed, original: final */
    public final void WU() {
        AppMethodBeat.i(76618);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
        if (!(this.owp == null || this.owp.owD)) {
            ab.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", this.owp);
            synchronized (this.owp.fYV) {
                try {
                    yT(this.owp.owy);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(76618);
                    }
                }
            }
        }
        if (this.fcQ.oxa != c.Initialized) {
            ab.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(76618);
            return;
        }
        this.fcQ.a(c.Start);
        this.owp = new a();
        this.owp.owy = this.owu;
        d.f(this.owp, "SightCustomAsyncMediaRecorder_encode_" + bo.yz());
        AppMethodBeat.o(76618);
    }

    public final int WM() {
        AppMethodBeat.i(76619);
        int round = Math.round(((float) this.fcF) / 1000.0f);
        AppMethodBeat.o(76619);
        return round;
    }

    public final Point WN() {
        AppMethodBeat.i(76620);
        Point point = new Point(this.fcO, this.fcP);
        AppMethodBeat.o(76620);
        return point;
    }

    public final int WO() {
        return this.fcR;
    }

    public final void pause() {
        AppMethodBeat.i(76621);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "pause");
        if (this.fcQ != null && this.fcQ.oxa == c.Start) {
            this.fcQ.a(c.Pause);
        }
        AppMethodBeat.o(76621);
    }

    public final void G(int i, int i2, int i3) {
        AppMethodBeat.i(76622);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", Integer.valueOf(i));
        if (this.fcQ != null && this.fcQ.oxa == c.Pause) {
            if (this.owo != null) {
                p pVar = this.owo;
                ab.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                pVar.owT = i;
                pVar.owU = i2;
                pVar.owV = i3;
            }
            this.fcQ.a(c.Start);
        }
        AppMethodBeat.o(76622);
    }

    public final boolean WP() {
        return this.fda;
    }

    public final void a(com.tencent.mm.plugin.mmsight.model.a.d.a aVar) {
        this.fdd = aVar;
    }

    public final boolean isLandscape() {
        return this.fdb;
    }

    public final void cv(boolean z) {
        this.owv = z;
    }

    public final com.tencent.mm.audio.b.c.a WQ() {
        AppMethodBeat.i(76623);
        if (this.own != null) {
            com.tencent.mm.audio.b.c.a bPN = this.own.bPN();
            AppMethodBeat.o(76623);
            return bPN;
        }
        AppMethodBeat.o(76623);
        return null;
    }

    public final void WR() {
        this.fdg = false;
    }

    public final void setMute(boolean z) {
    }

    public final void kp(int i) {
        AppMethodBeat.i(76624);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", Integer.valueOf(i));
        this.fcH = i;
        AppMethodBeat.o(76624);
    }

    public final void af(float f) {
        AppMethodBeat.i(76625);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", Float.valueOf(f));
        this.fcI = f;
        AppMethodBeat.o(76625);
    }

    public final float WJ() {
        return this.fcG;
    }

    static /* synthetic */ void a(l lVar, Runnable runnable) {
        AppMethodBeat.i(76626);
        lVar.fcQ.a(c.WaitStop);
        if (lVar.owo != null) {
            int i = lVar.owo.owR;
            float UQ = (((float) lVar.owo.frameCount) * 1000.0f) / ((float) lVar.owo.UQ());
            ab.i("MicroMsg.MMSightFFMpegRecorder", "stop, bufID %d, frameCount %d, duration %dms, %.6ffps", Integer.valueOf(i), Integer.valueOf(lVar.owo.frameCount), Long.valueOf(lVar.owo.UQ()), Float.valueOf(UQ));
            lVar.fcF = (int) lVar.owo.UQ();
            lVar.fcG = UQ;
            lVar.owo.stop();
            if (lVar.owp != null) {
                lVar.owp.bSi = UQ;
                lVar.owp.duration = lVar.fcF;
                lVar.owp.callback = runnable;
                lVar.owp.owA = true;
                d.xDG.remove(lVar.owp);
            }
        }
        if (!(lVar.own == null || lVar.owv)) {
            lVar.own.a(new b() {
                public final void WT() {
                    AppMethodBeat.i(76597);
                    l.this.WT();
                    AppMethodBeat.o(76597);
                }
            });
        }
        lVar.fcQ.a(c.Stop);
        lVar.cvZ = g.cz(lVar.fcE);
        if (lVar.owp == null) {
            ab.e("MicroMsg.MMSightFFMpegRecorder", "encodeRunnable is null!, directly call stopcallback");
            lVar.reset();
            al.d(runnable);
        }
        if (lVar.owv) {
            lVar.WT();
        }
        AppMethodBeat.o(76626);
    }
}
