package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p209c.C25998g;
import com.tencent.p177mm.plugin.mmsight.model.C12563j;
import com.tencent.p177mm.plugin.mmsight.model.C34549k;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c.C12542a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c.C28499b;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C12543a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C34543c;
import com.tencent.p177mm.plugin.report.service.C7060h;
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

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.l */
public final class C44750l implements C43304d {
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
    C34546s fcQ;
    int fcR = 0;
    String fcS = null;
    boolean fcT = false;
    private String fcU = null;
    private boolean fcV = false;
    VideoTransPara fcY;
    boolean fda = false;
    boolean fdb = false;
    int fdc = 0;
    C12543a fdd;
    boolean fdg = true;
    private C39387f fdk = new C433071();
    private String mFileName;
    boolean ouL = false;
    C43303c own;
    C12555p owo;
    private C3478a owp = null;
    C21291e owq;
    private HandlerThread owr = null;
    C7306ak ows = null;
    int owt = -1;
    private int owu = -1;
    private boolean owv = false;
    public boolean oww = false;
    String thumbPath = null;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.l$a */
    class C3478a implements Runnable {
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

        /* renamed from: com.tencent.mm.plugin.mmsight.model.a.l$a$1 */
        class C34791 implements Runnable {
            C34791() {
            }

            public final void run() {
                AppMethodBeat.m2504i(76601);
                if (C44750l.this.fdd != null) {
                    C44750l.this.fdd.asv();
                }
                AppMethodBeat.m2505o(76601);
            }
        }

        /* renamed from: com.tencent.mm.plugin.mmsight.model.a.l$a$2 */
        class C34802 implements Runnable {
            C34802() {
            }

            public final void run() {
                AppMethodBeat.m2504i(76602);
                if (C44750l.this.fdd != null) {
                    C44750l.this.fdd.asv();
                }
                AppMethodBeat.m2505o(76602);
            }
        }

        public C3478a() {
            AppMethodBeat.m2504i(76604);
            synchronized (this.fYV) {
                try {
                    String atb = C5730e.atb(C44750l.this.fcE);
                    if (!atb.endsWith("/")) {
                        atb = atb + "/";
                    }
                    C44750l.this.fcS = atb + "tempRotate.mp4";
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", e.getMessage());
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(76604);
                }
            }
            AppMethodBeat.m2505o(76604);
        }

        public final void run() {
            AppMethodBeat.m2504i(76605);
            if (C44750l.this.fYT == -1) {
                C44750l.this.fYT = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", Integer.valueOf(C44750l.this.fYT));
            }
            synchronized (this.fYV) {
                long yz;
                while (!this.owB) {
                    yz = C5046bo.m7588yz();
                    int triggerEncode = SightVideoJNI.triggerEncode(this.owy, Math.max(0, this.eVU), false);
                    C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(this.eVU), Integer.valueOf(triggerEncode), Long.valueOf(Thread.currentThread().getId()));
                    if (Math.abs(triggerEncode - this.eVU) <= 5) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(76605);
                        }
                    }
                    this.eVU = triggerEncode;
                }
                yz = C5046bo.m7588yz();
                if (!this.owC) {
                    this.eVU = SightVideoJNI.triggerEncode(this.owy, this.eVU, true);
                }
                C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(this.eVU), Boolean.valueOf(this.owC), Long.valueOf(Thread.currentThread().getId()));
                if (!this.owC) {
                    int max = Math.max(1000, this.duration);
                    if (C44750l.this.fcH > 0) {
                        max = C44750l.this.fcH;
                    }
                    float f = this.bSi;
                    if (C44750l.this.fcI > 0.0f) {
                        f = C44750l.this.fcI;
                    }
                    C44750l.this.owq = new C43309m(this.owy, C44750l.this.fcE, f, C44750l.this.fcN, max, C44750l.this.fcY.audioSampleRate, false);
                    yz = C5046bo.m7588yz();
                    C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", Long.valueOf(C5046bo.m7525az(yz)), Boolean.valueOf(C44750l.this.owq.bPO()));
                    if (!C44750l.this.owq.bPO()) {
                        C4990ab.m7412e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
                        SightVideoJNI.releaseBigSightDataBuffer(this.owy);
                        C5004al.m7441d(new C34791());
                        C4990ab.m7416i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
                        C7060h.pYm.mo8378a(440, 30, 1, false);
                        AppMethodBeat.m2505o(76605);
                        return;
                    } else if ((C44750l.this.fdb && C44750l.this.ouL) || (!(C44750l.this.ouL || C44750l.this.fdb) || ((C44750l.this.fdb && Math.abs(C44750l.this.fcR - C44750l.this.fdc) == 0) || C44750l.this.fdc == 180))) {
                        int i;
                        long yz2 = C5046bo.m7588yz();
                        if (!C44750l.this.ouL && !C44750l.this.fdb) {
                            i = C44750l.this.fcR;
                        } else if (C44750l.this.ouL) {
                            i = C44750l.this.fdc;
                        } else {
                            i = 180;
                        }
                        if (C44750l.this.fdc == 180 && !C44750l.this.ouL) {
                            i += 180;
                            if (i > v2helper.VOIP_ENC_HEIGHT_LV1) {
                                i -= 360;
                            }
                        }
                        if (i > 0) {
                            SightVideoJNI.tagRotateVideo(C44750l.this.fcE, C44750l.this.fcS, i);
                            C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", Long.valueOf(C5046bo.m7525az(yz2)), Integer.valueOf(C44750l.this.fcR), Boolean.valueOf(C44750l.this.fdb), Integer.valueOf(C44750l.this.fdc), Integer.valueOf(i));
                            final String str = C44750l.this.fcS;
                            try {
                                C5730e.m8644y(C44750l.this.fcS, C44750l.this.fcE);
                                C7305d.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(76603);
                                        try {
                                            C5730e.deleteFile(str);
                                            AppMethodBeat.m2505o(76603);
                                        } catch (Exception e) {
                                            C4990ab.m7413e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", e.getMessage());
                                            AppMethodBeat.m2505o(76603);
                                        }
                                    }
                                }, "BigSightFFMpegRecorder_tagRotate_after_process");
                                C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", Long.valueOf(C5046bo.m7525az(yz2)));
                            } catch (Exception e2) {
                                C4990ab.m7412e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
                                SightVideoJNI.releaseBigSightDataBuffer(this.owy);
                                C5004al.m7441d(new C34802());
                                AppMethodBeat.m2505o(76605);
                                return;
                            }
                        }
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(this.owy);
                C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", this.callback);
                C44750l.this.reset();
                C5004al.m7441d(this.callback);
                this.owD = true;
                C44750l.this.fYT = -1;
                C44750l.this.owt = -1;
                AppMethodBeat.m2505o(76605);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.l$5 */
    class C168075 implements C12542a {
        C168075() {
        }

        /* renamed from: WU */
        public final void mo14867WU() {
            AppMethodBeat.m2504i(76598);
            C44750l.this.mo71825WU();
            AppMethodBeat.m2505o(76598);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.l$7 */
    class C213017 implements Runnable {
        final /* synthetic */ byte[] hWX;

        C213017(byte[] bArr) {
            this.hWX = bArr;
        }

        public final void run() {
            AppMethodBeat.m2504i(76600);
            C44750l c44750l = C44750l.this;
            byte[] bArr = this.hWX;
            if (bArr != null) {
                try {
                    if (bArr.length != 0) {
                        if (C5046bo.isNullOrNil(c44750l.thumbPath)) {
                            C4990ab.m7412e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, thumbpath is null");
                            c44750l.fcT = false;
                            AppMethodBeat.m2505o(76600);
                            return;
                        }
                        int width;
                        Bitmap b;
                        int i = (c44750l.fcR == 0 || c44750l.fcR == 180) ? c44750l.fcO : c44750l.fcP;
                        int i2 = (c44750l.fcR == 0 || c44750l.fcR == 180) ? c44750l.fcP : c44750l.fcO;
                        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                        Rect rect = new Rect(0, 0, i, i2);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                        byte[] toByteArray = byteArrayOutputStream.toByteArray();
                        Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                        if (c44750l.fcY != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > c44750l.fcY.fAf) {
                            width = decodeByteArray.getWidth();
                            i = decodeByteArray.getHeight();
                            int i3 = c44750l.fcY.fAf > 0 ? c44750l.fcY.fAf : c44750l.fcY.width;
                            if (width < i) {
                                width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                                i = i3;
                            } else {
                                i = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                                width = i3;
                            }
                            decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i, width, true);
                        }
                        if (!c44750l.fdb || c44750l.fdc == 180) {
                            width = c44750l.fcR;
                            if (c44750l.fdc == 180) {
                                width += 180;
                                if (width > v2helper.VOIP_ENC_HEIGHT_LV1) {
                                    width -= 360;
                                }
                            }
                            b = C5056d.m7648b(decodeByteArray, (float) width);
                        } else if (Math.abs(c44750l.fcR - c44750l.fdc) == 0) {
                            b = C5056d.m7648b(decodeByteArray, 180.0f);
                            C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "bitmap recycle %s", decodeByteArray.toString());
                            decodeByteArray.recycle();
                        } else {
                            b = decodeByteArray;
                        }
                        C5056d.m7625a(b, 60, CompressFormat.JPEG, c44750l.thumbPath, true);
                        C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", c44750l.thumbPath, Integer.valueOf(c44750l.fcR), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()));
                        AppMethodBeat.m2505o(76600);
                        return;
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb error: %s", e.getMessage());
                    c44750l.fcT = false;
                    AppMethodBeat.m2505o(76600);
                    return;
                }
            }
            C4990ab.m7412e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, data is null");
            c44750l.fcT = false;
            AppMethodBeat.m2505o(76600);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.l$1 */
    class C433071 implements C39387f {
        C433071() {
        }

        /* renamed from: O */
        public final boolean mo14870O(byte[] bArr) {
            AppMethodBeat.m2504i(76594);
            if (bArr == null || bArr.length <= 0) {
                AppMethodBeat.m2505o(76594);
                return false;
            } else if (C44750l.this.fcQ.oxa == C34543c.Start) {
                C44750l c44750l = C44750l.this;
                if (!c44750l.fcT && c44750l.fdg) {
                    c44750l.fcT = true;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    C7305d.post(new C213017(bArr2), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                }
                if (C44750l.this.ows != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = bArr;
                    C44750l.this.ows.sendMessage(obtain);
                }
                AppMethodBeat.m2505o(76594);
                return true;
            } else {
                AppMethodBeat.m2505o(76594);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.l$4 */
    class C447514 implements C28499b {
        C447514() {
        }

        /* renamed from: WT */
        public final void mo14866WT() {
            AppMethodBeat.m2504i(76597);
            C44750l.this.mo71824WT();
            AppMethodBeat.m2505o(76597);
        }
    }

    public C44750l(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76606);
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
        this.eNa = false;
        C4990ab.m7411d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", Integer.valueOf(this.fcL), Integer.valueOf(this.fcM), Integer.valueOf(this.fcN), Integer.valueOf(bPT));
        AppMethodBeat.m2505o(76606);
    }

    /* renamed from: s */
    public final void mo14862s(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(76607);
        C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.fcL = i3;
        this.fcM = i4;
        this.fcO = i;
        this.fcP = i2;
        if (C43305j.owk.mo68846g(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3));
            long yz = C5046bo.m7588yz();
            for (int i5 = 0; i5 < 3; i5++) {
                C43305j.owk.mo68845g(new byte[(((i * i2) * 3) / 2)]);
            }
            C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        }
        AppMethodBeat.m2505o(76607);
    }

    /* renamed from: Wy */
    public final String mo14845Wy() {
        return this.thumbPath;
    }

    /* renamed from: yT */
    private boolean m81574yT(int i) {
        AppMethodBeat.m2504i(76608);
        if (this.owp == null || this.owp.owD) {
            AppMethodBeat.m2505o(76608);
            return false;
        }
        if (!this.owp.owA) {
            this.owp.callback = null;
            this.owp.owC = true;
            this.owp.owB = true;
            C7305d.xDG.remove(this.owp);
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
                AppMethodBeat.m2505o(76608);
            }
        }
        return true;
    }

    public final void clear() {
        boolean z = true;
        AppMethodBeat.m2504i(76609);
        int i = -1;
        if (this.owo != null) {
            i = this.owo.owR;
            if (i < 0) {
                C4990ab.m7418v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
                AppMethodBeat.m2505o(76609);
                return;
            }
            this.owo.stop();
        }
        if (this.own != null) {
            this.own.mo36709a(null);
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
        C4990ab.m7419v(str, str2, objArr);
        if (i >= 0 && !m81574yT(i)) {
            SightVideoJNI.releaseRecorderBufferRef("clear");
            SightVideoJNI.releaseBigSightDataBuffer(i);
        }
        if (this.owr != null) {
            this.owr.quit();
        }
        AppMethodBeat.m2505o(76609);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(76610);
        C4990ab.m7416i("MicroMsg.MMSightFFMpegRecorder", "cancel");
        this.fcQ.mo55075a(C34543c.WaitStop);
        clear();
        this.fcQ.mo55075a(C34543c.Stop);
        AppMethodBeat.m2505o(76610);
    }

    /* renamed from: v */
    public final void mo14865v(final Runnable runnable) {
        boolean z;
        AppMethodBeat.m2504i(76611);
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
        C4990ab.m7417i(str, str2, objArr);
        if (this.owp == null || !this.owp.owA) {
            C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", Boolean.valueOf(this.oww), this.ows);
            if (!this.oww || this.ows == null) {
                C7305d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(76596);
                        C44750l.m81572a(C44750l.this, runnable);
                        AppMethodBeat.m2505o(76596);
                    }
                }, "MMSightFFMpegRecorder_stop");
                AppMethodBeat.m2505o(76611);
                return;
            }
            this.ows.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(76595);
                    C44750l.m81572a(C44750l.this, runnable);
                    AppMethodBeat.m2505o(76595);
                }
            });
            AppMethodBeat.m2505o(76611);
            return;
        }
        synchronized (this.owp.fYV) {
            try {
                reset();
                C5004al.m7441d(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(76611);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: WT */
    public final void mo71824WT() {
        if (this.owp != null) {
            this.owp.owB = true;
        }
    }

    /* renamed from: Aq */
    public final String mo14833Aq() {
        AppMethodBeat.m2504i(76612);
        String bc = C5046bo.m7532bc(this.cvZ, "");
        AppMethodBeat.m2505o(76612);
        return bc;
    }

    /* renamed from: WL */
    public final C34543c mo14838WL() {
        return this.fcQ.oxa;
    }

    /* renamed from: WK */
    public final long mo14837WK() {
        AppMethodBeat.m2504i(76613);
        long UQ = this.owo.mo24475UQ();
        AppMethodBeat.m2505o(76613);
        return UQ;
    }

    public final C39387f getFrameDataCallback() {
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

    public final void reset() {
        AppMethodBeat.m2504i(76614);
        C4990ab.m7416i("MicroMsg.MMSightFFMpegRecorder", "reset");
        this.fcQ.oxa = C34543c.Stop;
        this.fda = false;
        if (this.own != null) {
            this.own.clear();
        }
        if (this.owo != null) {
            this.owo.clear();
        }
        clear();
        AppMethodBeat.m2505o(76614);
    }

    /* renamed from: kn */
    private boolean m81573kn(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.m2504i(76615);
        long yz = C5046bo.m7588yz();
        this.ouL = C12563j.ouz.ouL;
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
            C4990ab.m7412e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
            C34549k.bPy();
            AppMethodBeat.m2505o(76615);
            return false;
        }
        this.owu = i6;
        this.owo = new C12555p(this.ouL, i, i4, i5);
        i4 = this.owo.mo24478yU(i6);
        i2 = 0;
        i3 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i3 = CaptureMMProxy.getInstance().getInt(C5127a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, -1);
        }
        if (i3 < 0) {
            this.own = new C24797g(this.fcY.audioSampleRate, this.fcY.fzS);
            this.own.mo36714iW(this.owv);
            i2 = this.own.mo20926q(i6, C21846d.m33386WP(this.fcE));
            if (i4 < 0 || i2 < 0) {
                C4990ab.m7413e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(i4), Integer.valueOf(i2));
                if (i2 < 0 && i4 >= 0) {
                    C4990ab.m7420w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
                    this.own.clear();
                    this.own = new C21299i(this.fcY.audioSampleRate, this.fcY.fzS);
                    this.own.mo36714iW(this.owv);
                    C4990ab.m7421w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", Integer.valueOf(this.own.mo20926q(i6, C21846d.m33386WP(this.fcE))));
                    if (this.own.mo20926q(i6, C21846d.m33386WP(this.fcE)) >= 0) {
                        AppMethodBeat.m2505o(76615);
                        return true;
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(i6);
                C34549k.bPy();
                AppMethodBeat.m2505o(76615);
                return false;
            }
        }
        if (i3 == 1) {
            this.own = new C24797g(this.fcY.audioSampleRate, this.fcY.fzS);
            this.own.mo36714iW(this.owv);
            i2 = this.own.mo20926q(i6, C21846d.m33386WP(this.fcE));
        } else if (i3 == 2) {
            this.own = new C21299i(this.fcY.audioSampleRate, this.fcY.fzS);
            this.own.mo36714iW(this.owv);
            i2 = this.own.mo20926q(i6, C21846d.m33386WP(this.fcE));
        }
        if (i4 < 0 || i2 < 0) {
            C4990ab.m7413e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(i4), Integer.valueOf(i2));
            SightVideoJNI.releaseBigSightDataBuffer(i6);
            C34549k.bPy();
            AppMethodBeat.m2505o(76615);
            return false;
        }
        C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(76615);
        return true;
    }

    /* renamed from: ko */
    public final boolean mo14856ko(int i) {
        AppMethodBeat.m2504i(76616);
        if (this.eNa) {
            AppMethodBeat.m2505o(76616);
            return true;
        }
        C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", Integer.valueOf(i));
        boolean kn = m81573kn(i);
        this.eNa = true;
        C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", Boolean.valueOf(kn));
        AppMethodBeat.m2505o(76616);
        return kn;
    }

    /* renamed from: b */
    public final int mo14848b(int i, boolean z, int i2) {
        boolean z2;
        AppMethodBeat.m2504i(76617);
        C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", this.fcQ.oxa, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
        this.fdb = z;
        this.fcF = 0;
        this.fdc = i2;
        this.fcQ.mo55075a(C34543c.WaitStart);
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
        C4990ab.m7417i(str, str2, objArr);
        if (this.owp != null && !this.owp.owD) {
            C4990ab.m7420w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
            AppMethodBeat.m2505o(76617);
            return -1;
        } else if (C5046bo.isNullOrNil(this.fcE)) {
            C4990ab.m7412e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.m2505o(76617);
            return -1;
        } else {
            int i3;
            this.mFileName = C5730e.atd(this.fcE);
            C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", this.fcE);
            this.fcR = i;
            C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", Integer.valueOf(this.fcR));
            if (!this.eNa) {
                m81573kn(i);
                this.eNa = true;
            }
            C12555p c12555p = this.owo;
            if (0 == c12555p.miD) {
                c12555p.miD = System.currentTimeMillis();
            }
            if (this.owv) {
                i3 = 0;
            } else {
                i3 = this.own.mo36708a(new C168075());
            }
            C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", Integer.valueOf(i3));
            this.owr = C7305d.m12297ek("BigSightWriteCameraData", 0);
            this.owr.start();
            this.ows = new C7306ak(this.owr.getLooper()) {
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
                    AppMethodBeat.m2504i(76599);
                    if (C44750l.this.owt == -1) {
                        C44750l.this.owt = Process.myTid();
                        C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", Integer.valueOf(C44750l.this.owt));
                    }
                    if (message.what == 1) {
                        int length;
                        int i;
                        int i2;
                        int i3;
                        byte[] bArr;
                        C12555p c12555p;
                        int i4;
                        C44750l.this.own.bPM();
                        C44750l c44750l = C44750l.this;
                        byte[] bArr2 = (byte[]) message.obj;
                        C12555p c12555p2;
                        if (c44750l.ouL) {
                            c12555p2 = c44750l.owo;
                            length = bArr2.length;
                            i = c44750l.fcO;
                            i2 = c44750l.fcP;
                            i3 = i;
                            bArr = bArr2;
                            c12555p = c12555p2;
                        } else {
                            c12555p2 = c44750l.owo;
                            length = bArr2.length;
                            i4 = (c44750l.fcR == 0 || c44750l.fcR == 180) ? c44750l.fcO : c44750l.fcP;
                            if (c44750l.fcR == 0 || c44750l.fcR == 180) {
                                i2 = c44750l.fcP;
                                i3 = i4;
                                bArr = bArr2;
                                c12555p = c12555p2;
                            } else {
                                i2 = c44750l.fcO;
                                i3 = i4;
                                bArr = bArr2;
                                c12555p = c12555p2;
                            }
                        }
                        c12555p.ovu = C5046bo.m7588yz();
                        if (c12555p.owR < 0) {
                            C4990ab.m7412e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
                        } else {
                            boolean z;
                            int i5;
                            int i6;
                            boolean z2;
                            synchronized (C12555p.class) {
                                try {
                                    c12555p.frameCount++;
                                } catch (Throwable th) {
                                    while (true) {
                                        AppMethodBeat.m2505o(76599);
                                    }
                                }
                            }
                            i4 = c12555p.owS;
                            boolean z3 = c12555p.ouL;
                            if (z3) {
                                i4 = c12555p.owT == -1 ? c12555p.owS : c12555p.owT;
                            } else if (c12555p.owT == -1 || c12555p.owT == c12555p.owS) {
                                z = false;
                                SightVideoJNI.setRotateForBufId(c12555p.owR, i4);
                                i = z ? (i4 == 0 || i4 == 180) ? c12555p.eTi : c12555p.eTj : (i4 == 0 || i4 == 180) ? c12555p.eTj : c12555p.eTi;
                                i5 = z ? (i4 == 0 || i4 == 180) ? c12555p.eTj : c12555p.eTi : (i4 == 0 || i4 == 180) ? c12555p.eTi : c12555p.eTj;
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
                                SightVideoJNI.writeYuvDataForMMSight(c12555p.owR, bArr, length, i, i5, z, z2, i6, i3);
                                C4990ab.m7411d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", Long.valueOf(C5046bo.m7525az(c12555p.ovu)));
                            } else {
                                z3 = true;
                                i4 = c12555p.owT;
                                if (c12555p.owS <= 180) {
                                    i4 -= c12555p.owS;
                                } else {
                                    i4 += 360 - c12555p.owS;
                                }
                                i4 = Math.max(0, i4);
                                if (i4 >= v2helper.VOIP_ENC_HEIGHT_LV1) {
                                    i4 = 0;
                                } else {
                                    z = true;
                                    SightVideoJNI.setRotateForBufId(c12555p.owR, i4);
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
                                    SightVideoJNI.writeYuvDataForMMSight(c12555p.owR, bArr, length, i, i5, z, z2, i6, i3);
                                    C4990ab.m7411d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", Long.valueOf(C5046bo.m7525az(c12555p.ovu)));
                                }
                            }
                            z = z3;
                            SightVideoJNI.setRotateForBufId(c12555p.owR, i4);
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
                            SightVideoJNI.writeYuvDataForMMSight(c12555p.owR, bArr, length, i, i5, z, z2, i6, i3);
                            C4990ab.m7411d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", Long.valueOf(C5046bo.m7525az(c12555p.ovu)));
                        }
                        C43305j.owk.mo68845g(bArr2);
                        c44750l.fda = true;
                    }
                    AppMethodBeat.m2505o(76599);
                }
            };
            this.fda = false;
            if (i3 != 0) {
                this.fcQ.mo55075a(C34543c.Error);
            } else {
                this.fcQ.mo55075a(C34543c.Initialized);
            }
            C34549k.bPx();
            C4990ab.m7416i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
            C7060h.pYm.mo8378a(440, 1, 1, false);
            if (this.owv) {
                mo71825WU();
            }
            AppMethodBeat.m2505o(76617);
            return i3;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: WU */
    public final void mo71825WU() {
        AppMethodBeat.m2504i(76618);
        C4990ab.m7416i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
        if (!(this.owp == null || this.owp.owD)) {
            C4990ab.m7413e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", this.owp);
            synchronized (this.owp.fYV) {
                try {
                    m81574yT(this.owp.owy);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(76618);
                    }
                }
            }
        }
        if (this.fcQ.oxa != C34543c.Initialized) {
            C4990ab.m7420w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.m2505o(76618);
            return;
        }
        this.fcQ.mo55075a(C34543c.Start);
        this.owp = new C3478a();
        this.owp.owy = this.owu;
        C7305d.m12298f(this.owp, "SightCustomAsyncMediaRecorder_encode_" + C5046bo.m7588yz());
        AppMethodBeat.m2505o(76618);
    }

    /* renamed from: WM */
    public final int mo14839WM() {
        AppMethodBeat.m2504i(76619);
        int round = Math.round(((float) this.fcF) / 1000.0f);
        AppMethodBeat.m2505o(76619);
        return round;
    }

    /* renamed from: WN */
    public final Point mo14840WN() {
        AppMethodBeat.m2504i(76620);
        Point point = new Point(this.fcO, this.fcP);
        AppMethodBeat.m2505o(76620);
        return point;
    }

    /* renamed from: WO */
    public final int mo14841WO() {
        return this.fcR;
    }

    public final void pause() {
        AppMethodBeat.m2504i(76621);
        C4990ab.m7416i("MicroMsg.MMSightFFMpegRecorder", "pause");
        if (this.fcQ != null && this.fcQ.oxa == C34543c.Start) {
            this.fcQ.mo55075a(C34543c.Pause);
        }
        AppMethodBeat.m2505o(76621);
    }

    /* renamed from: G */
    public final void mo14834G(int i, int i2, int i3) {
        AppMethodBeat.m2504i(76622);
        C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", Integer.valueOf(i));
        if (this.fcQ != null && this.fcQ.oxa == C34543c.Pause) {
            if (this.owo != null) {
                C12555p c12555p = this.owo;
                C4990ab.m7417i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                c12555p.owT = i;
                c12555p.owU = i2;
                c12555p.owV = i3;
            }
            this.fcQ.mo55075a(C34543c.Start);
        }
        AppMethodBeat.m2505o(76622);
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
        this.owv = z;
    }

    /* renamed from: WQ */
    public final C1293a mo14843WQ() {
        AppMethodBeat.m2504i(76623);
        if (this.own != null) {
            C1293a bPN = this.own.bPN();
            AppMethodBeat.m2505o(76623);
            return bPN;
        }
        AppMethodBeat.m2505o(76623);
        return null;
    }

    /* renamed from: WR */
    public final void mo14844WR() {
        this.fdg = false;
    }

    public final void setMute(boolean z) {
    }

    /* renamed from: kp */
    public final void mo14857kp(int i) {
        AppMethodBeat.m2504i(76624);
        C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", Integer.valueOf(i));
        this.fcH = i;
        AppMethodBeat.m2505o(76624);
    }

    /* renamed from: af */
    public final void mo14847af(float f) {
        AppMethodBeat.m2504i(76625);
        C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", Float.valueOf(f));
        this.fcI = f;
        AppMethodBeat.m2505o(76625);
    }

    /* renamed from: WJ */
    public final float mo14836WJ() {
        return this.fcG;
    }

    /* renamed from: a */
    static /* synthetic */ void m81572a(C44750l c44750l, Runnable runnable) {
        AppMethodBeat.m2504i(76626);
        c44750l.fcQ.mo55075a(C34543c.WaitStop);
        if (c44750l.owo != null) {
            int i = c44750l.owo.owR;
            float UQ = (((float) c44750l.owo.frameCount) * 1000.0f) / ((float) c44750l.owo.mo24475UQ());
            C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "stop, bufID %d, frameCount %d, duration %dms, %.6ffps", Integer.valueOf(i), Integer.valueOf(c44750l.owo.frameCount), Long.valueOf(c44750l.owo.mo24475UQ()), Float.valueOf(UQ));
            c44750l.fcF = (int) c44750l.owo.mo24475UQ();
            c44750l.fcG = UQ;
            c44750l.owo.stop();
            if (c44750l.owp != null) {
                c44750l.owp.bSi = UQ;
                c44750l.owp.duration = c44750l.fcF;
                c44750l.owp.callback = runnable;
                c44750l.owp.owA = true;
                C7305d.xDG.remove(c44750l.owp);
            }
        }
        if (!(c44750l.own == null || c44750l.owv)) {
            c44750l.own.mo36709a(new C447514());
        }
        c44750l.fcQ.mo55075a(C34543c.Stop);
        c44750l.cvZ = C25998g.m41489cz(c44750l.fcE);
        if (c44750l.owp == null) {
            C4990ab.m7412e("MicroMsg.MMSightFFMpegRecorder", "encodeRunnable is null!, directly call stopcallback");
            c44750l.reset();
            C5004al.m7441d(runnable);
        }
        if (c44750l.owv) {
            c44750l.mo71824WT();
        }
        AppMethodBeat.m2505o(76626);
    }
}
