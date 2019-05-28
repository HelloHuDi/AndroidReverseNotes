package com.tencent.p177mm.plugin.facedetect.p402e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.memory.C18601a;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C16657e;
import com.tencent.p177mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.p177mm.plugin.facedetect.model.C20636d;
import com.tencent.p177mm.plugin.facedetect.model.C20636d.C20637b;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.model.FaceContextData;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.mmsight.api.C39375b;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C12543a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.plugin.facedetect.e.a */
public class C27922a {
    private static volatile C27922a lYT = null;
    private static final String lZi = (C43036p.bsO() + IOUtils.DIR_SEPARATOR_UNIX + "fdv_");
    public static final String lZj = (C43036p.bsO() + IOUtils.DIR_SEPARATOR_UNIX + "video_temp_test.mp4");
    private static final String lZk = (C43036p.bsO() + IOUtils.DIR_SEPARATOR_UNIX + "fdv_t_");
    public C46607d ext;
    private C43304d gLs;
    public C5004al lYU;
    private final int lYV;
    private final int lYW;
    private final int lYX;
    private C27930a lYY;
    private int lYZ;
    private boolean lZa;
    private int lZb;
    public boolean lZc;
    private C27929b lZd;
    private int lZe;
    private int lZf;
    private String lZg;
    public C39375b lZh;
    private C20637b lZl;
    private C12543a lZm;
    private String mFilePath;
    private final Object mLock;

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$3 */
    public class C30353 implements Runnable {
        final /* synthetic */ Runnable lZA;
        final /* synthetic */ int lZn;
        final /* synthetic */ int lZo;
        final /* synthetic */ int lZp;
        final /* synthetic */ boolean lZq = false;
        final /* synthetic */ int lZr = 0;
        final /* synthetic */ int lZt;
        final /* synthetic */ int lZu;

        /* renamed from: com.tencent.mm.plugin.facedetect.e.a$3$1 */
        class C30361 implements Runnable {
            C30361() {
            }

            public final void run() {
                AppMethodBeat.m2504i(546);
                final long yz = C5046bo.m7588yz();
                C27922a.this.ext.connect(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(545);
                        synchronized (C27922a.this.mLock) {
                            try {
                                C4990ab.m7417i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", Long.valueOf(C5046bo.m7525az(yz)));
                                long yz = C5046bo.m7588yz();
                                C27922a.this.gLs = C27922a.this.lZh.asl();
                                C27922a.this.gLs.setFilePath(C27922a.this.mFilePath);
                                C27922a.this.gLs.mo14858mb(C27922a.this.lZg);
                                C27922a.this.gLs.mo14851cv(true);
                                C27922a.this.gLs.mo14862s(C27922a.this.lZe, C27922a.this.lZf, C30353.this.lZt, C30353.this.lZu);
                                C27922a.this.gLs.mo14856ko(C27922a.this.lYZ);
                                C27922a.this.gLs.mo14846a(C27922a.this.lZm);
                                C27922a.this.lYY = C27930a.INITIALIZED;
                                C4990ab.m7417i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", Long.valueOf(C5046bo.m7525az(yz)));
                                if (C30353.this.lZA != null) {
                                    C30353.this.lZA.run();
                                }
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.m2505o(545);
                            }
                        }
                    }
                });
                AppMethodBeat.m2505o(546);
            }
        }

        public C30353(int i, int i2, int i3, int i4, int i5, Runnable runnable) {
            this.lZn = i;
            this.lZo = i2;
            this.lZp = i3;
            this.lZt = i4;
            this.lZu = i5;
            this.lZA = runnable;
        }

        public final void run() {
            AppMethodBeat.m2504i(547);
            if (this.lZn == 90 || this.lZn == 270) {
                C4990ab.m7416i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
                C27922a.this.lZe = this.lZo;
                C27922a.this.lZf = this.lZp;
            } else {
                C27922a.this.lZe = this.lZp;
                C27922a.this.lZf = this.lZo;
            }
            synchronized (C27922a.this.mLock) {
                try {
                    C27922a.this.lYZ = this.lZn;
                    C27922a.this.lZa = this.lZq;
                    C27922a.this.lZb = this.lZr;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(547);
                }
            }
            C27922a.m44423b(C27922a.this);
            C27922a.m44425c(C27922a.this);
            C27922a.m44427d(C27922a.this);
            C5004al.m7441d(new C30361());
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$2 */
    class C167632 implements C12543a {

        /* renamed from: com.tencent.mm.plugin.facedetect.e.a$2$1 */
        class C167641 implements Runnable {
            final /* synthetic */ int gIb = 1;

            C167641() {
            }

            public final void run() {
                AppMethodBeat.m2504i(543);
                try {
                    if (C27922a.this.gLs != null) {
                        C27922a.this.gLs.reset();
                    }
                    C27922a.m44427d(C27922a.this);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.FaceVideoRecorder", "hy: onError, reset mediaRecorder error: %s", e.getMessage());
                    C27922a.m44427d(C27922a.this);
                } catch (Throwable th) {
                    C27922a.m44427d(C27922a.this);
                    AppMethodBeat.m2505o(543);
                }
                synchronized (C27922a.this.mLock) {
                    try {
                        C27922a.this.lYY = C27930a.INITIALIZED;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(543);
                    }
                }
                FaceDetectReporter.m55882i(FaceContextData.bss().lTH, 2, this.gIb);
            }
        }

        C167632() {
        }

        public final void asv() {
            AppMethodBeat.m2504i(544);
            C4990ab.m7413e("MicroMsg.FaceVideoRecorder", "hy: video capture error: %d", Integer.valueOf(1));
            C27922a.this.lYU.mo10302aa(new C167641());
            AppMethodBeat.m2505o(544);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$9 */
    class C206349 implements C20637b {
        C206349() {
        }

        /* renamed from: aT */
        public final void mo7298aT(byte[] bArr) {
            AppMethodBeat.m2504i(554);
            C27922a.this.mo45819aU(bArr);
            AppMethodBeat.m2505o(554);
        }

        public final C18601a<byte[]> bsr() {
            return C43305j.owk;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$4 */
    public class C279254 implements Runnable {
        final /* synthetic */ int lZD;

        public C279254(int i) {
            this.lZD = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(548);
            if (C27922a.this.gLs != null) {
                C27922a.this.gLs.mo14857kp(this.lZD);
            }
            AppMethodBeat.m2505o(548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$6 */
    class C279266 implements Runnable {
        C279266() {
        }

        public final void run() {
            AppMethodBeat.m2504i(C16657e.CTRL_INDEX);
            synchronized (C27922a.this.mLock) {
                try {
                    if (C27922a.this.lYY == C27930a.UNINITIALIZED) {
                        C4990ab.m7412e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
                        C27922a.m44427d(C27922a.this);
                    } else if (C27922a.this.lYY == C27930a.STARTED) {
                        C4990ab.m7420w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
                        AppMethodBeat.m2505o(C16657e.CTRL_INDEX);
                    } else {
                        C4990ab.m7416i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
                        C20636d.bsq().mo35921a(C27922a.this.lZl);
                        C27922a.this.gLs.mo14848b(C27922a.this.lYZ, C27922a.this.lZa, C27922a.this.lZb);
                        C27922a.this.lYY = C27930a.STARTED;
                        AppMethodBeat.m2505o(C16657e.CTRL_INDEX);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(C16657e.CTRL_INDEX);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$7 */
    class C279277 implements Runnable {
        C279277() {
        }

        public final void run() {
            AppMethodBeat.m2504i(551);
            synchronized (C27922a.this.mLock) {
                try {
                    if (C27922a.this.lYY == C27930a.UNINITIALIZED) {
                        C4990ab.m7412e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
                        C27922a.m44427d(C27922a.this);
                    } else {
                        C4990ab.m7416i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
                        C27922a.this.gLs.cancel();
                        C27922a.m44427d(C27922a.this);
                        C20636d.bsq().mo35923b(C27922a.this.lZl);
                        C27922a.this.lYY = C27930a.CANCELLED;
                        C27922a.this.ext.release();
                        AppMethodBeat.m2505o(551);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(551);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$5 */
    public class C279285 implements Runnable {
        final /* synthetic */ float lZE;

        public C279285(float f) {
            this.lZE = f;
        }

        public final void run() {
            AppMethodBeat.m2504i(JsApiChooseMultiMedia.CTRL_INDEX);
            if (C27922a.this.gLs != null) {
                C27922a.this.gLs.mo14847af(this.lZE);
            }
            AppMethodBeat.m2505o(JsApiChooseMultiMedia.CTRL_INDEX);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$b */
    public interface C27929b {
        /* renamed from: Lu */
        void mo23665Lu(String str);
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$a */
    public enum C27930a {
        UNINITIALIZED,
        INITIALIZED,
        STARTED,
        STOPPING,
        STOPPED,
        CANCELLED;

        static {
            AppMethodBeat.m2505o(JsApiSetLabInfo.CTRL_INDEX);
        }
    }

    static {
        AppMethodBeat.m2504i(571);
        AppMethodBeat.m2505o(571);
    }

    private C27922a() {
        AppMethodBeat.m2504i(559);
        this.mLock = new Object();
        this.lYU = null;
        this.lYV = VideoFilterUtil.IMAGE_HEIGHT;
        this.lYW = 540;
        this.lYX = 15;
        this.lYY = C27930a.UNINITIALIZED;
        this.lYZ = 0;
        this.lZa = false;
        this.lZb = 0;
        this.lZc = false;
        this.lZd = null;
        this.lZe = -1;
        this.lZf = -1;
        this.mFilePath = "";
        this.lZg = "";
        this.ext = new C46607d(C4996ah.getContext());
        this.lZh = C39375b.ota.asm();
        this.lZl = new C206349();
        this.lZm = new C167632();
        this.lYU = new C5004al("face_video_handler");
        AppMethodBeat.m2505o(559);
    }

    public static C27922a btw() {
        AppMethodBeat.m2504i(560);
        C27922a c27922a;
        if (lYT == null) {
            synchronized (C27922a.class) {
                try {
                    if (lYT == null) {
                        lYT = new C27922a();
                    }
                    c27922a = lYT;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(560);
                }
            }
            return c27922a;
        }
        c27922a = lYT;
        AppMethodBeat.m2505o(560);
        return c27922a;
    }

    /* renamed from: a */
    public final boolean mo45818a(int i, int i2, int i3, int i4, int i5, boolean z) {
        AppMethodBeat.m2504i(561);
        C4990ab.m7416i("MicroMsg.FaceVideoRecorder", "hy: init record");
        C4990ab.m7417i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d, acceptVoiceFromOutside: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.FALSE, Integer.valueOf(0), Boolean.valueOf(z));
        this.lZh.mo62266a(this.ext, btA());
        final int i6 = i;
        final int i7 = i3;
        final int i8 = i2;
        final boolean z2 = z;
        final int i9 = i4;
        final int i10 = i5;
        this.lYU.mo10302aa(new Runnable() {
            final /* synthetic */ boolean lZq = false;
            final /* synthetic */ int lZr = 0;

            /* renamed from: com.tencent.mm.plugin.facedetect.e.a$1$1 */
            class C118061 implements Runnable {
                C118061() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(541);
                    final long yz = C5046bo.m7588yz();
                    C27922a.this.ext.connect(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(540);
                            synchronized (C27922a.this.mLock) {
                                try {
                                    C4990ab.m7417i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", Long.valueOf(C5046bo.m7525az(yz)));
                                    long yz = C5046bo.m7588yz();
                                    C27922a.this.gLs = C27922a.this.lZh.asl();
                                    C27922a.this.gLs.setFilePath(C27922a.this.mFilePath);
                                    C27922a.this.gLs.mo14858mb(C27922a.this.lZg);
                                    C27922a.this.gLs.mo14851cv(z2);
                                    C27922a.this.gLs.mo14862s(C27922a.this.lZe, C27922a.this.lZf, i9, i10);
                                    C27922a.this.gLs.mo14856ko(C27922a.this.lYZ);
                                    C27922a.this.gLs.mo14846a(C27922a.this.lZm);
                                    C27922a.this.lYY = C27930a.INITIALIZED;
                                    C4990ab.m7417i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", Long.valueOf(C5046bo.m7525az(yz)));
                                } finally {
                                    while (true) {
                                    }
                                    AppMethodBeat.m2505o(540);
                                }
                            }
                        }
                    });
                    AppMethodBeat.m2505o(541);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(542);
                if (i6 == 90 || i6 == 270) {
                    C4990ab.m7416i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
                    C27922a.this.lZe = i7;
                    C27922a.this.lZf = i8;
                } else {
                    C27922a.this.lZe = i8;
                    C27922a.this.lZf = i7;
                }
                synchronized (C27922a.this.mLock) {
                    try {
                        C27922a.this.lYZ = i6;
                        C27922a.this.lZa = this.lZq;
                        C27922a.this.lZb = this.lZr;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(542);
                    }
                }
                C27922a.m44423b(C27922a.this);
                C27922a.m44425c(C27922a.this);
                C27922a.m44427d(C27922a.this);
                C5004al.m7441d(new C118061());
            }
        });
        AppMethodBeat.m2505o(561);
        return true;
    }

    public final boolean isStarted() {
        boolean z;
        synchronized (this.mLock) {
            z = this.lYY == C27930a.STARTED;
        }
        return z;
    }

    public final C1293a btx() {
        AppMethodBeat.m2504i(562);
        if (this.gLs != null) {
            C1293a WQ = this.gLs.mo14843WQ();
            AppMethodBeat.m2505o(562);
            return WQ;
        }
        C4990ab.m7420w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
        AppMethodBeat.m2505o(562);
        return null;
    }

    /* renamed from: EL */
    public final boolean mo45816EL() {
        AppMethodBeat.m2504i(563);
        C4990ab.m7412e("MicroMsg.FaceVideoRecorder", "carson: start Record Video");
        this.lYU.mo10302aa(new C279266());
        AppMethodBeat.m2505o(563);
        return true;
    }

    public final void bty() {
        AppMethodBeat.m2504i(564);
        C4990ab.m7412e("MicroMsg.FaceVideoRecorder", "carson: cancel Record Video");
        this.lYU.mo10302aa(new C279277());
        AppMethodBeat.m2505o(564);
    }

    /* renamed from: a */
    public final void mo45817a(final C27929b c27929b) {
        AppMethodBeat.m2504i(565);
        C4990ab.m7412e("MicroMsg.FaceVideoRecorder", "carson: stop Record Video");
        this.lYU.mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.facedetect.e.a$8$1 */
            class C30391 implements Runnable {
                C30391() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(552);
                    synchronized (C27922a.this.mLock) {
                        try {
                            C4990ab.m7416i("MicroMsg.FaceVideoRecorder", "carson: begin to stop" + C27922a.this.gLs.getFilePath());
                            C27922a.this.lYY = C27930a.STOPPED;
                            C5730e.deleteFile(C27922a.this.lZg);
                            if (C27922a.this.lZd != null) {
                                C27922a.this.lZd.mo23665Lu(C27922a.this.gLs.getFilePath());
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(552);
                        }
                    }
                }
            }

            /* JADX WARNING: Missing block: B:18:0x0077, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(553);
     */
            /* JADX WARNING: Missing block: B:26:0x00aa, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(553);
     */
            /* JADX WARNING: Missing block: B:45:?, code skipped:
            return;
     */
            /* JADX WARNING: Missing block: B:46:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.m2504i(553);
                synchronized (C27922a.this.mLock) {
                    try {
                        C27922a.this.lZd = c27929b;
                        if (C27922a.this.lYY == C27930a.UNINITIALIZED) {
                            C4990ab.m7412e("MicroMsg.FaceVideoRecorder", "hy: not initialized. should not happen");
                            C27922a.m44427d(C27922a.this);
                            if (C27922a.this.lZd != null) {
                                C27922a.this.lZd.mo23665Lu(null);
                            }
                        } else if (C27922a.this.lYY == C27930a.CANCELLED || C27922a.this.lYY == C27930a.INITIALIZED) {
                            C4990ab.m7420w("MicroMsg.FaceVideoRecorder", "hy: cancelled or not started capturing.");
                            C27922a.m44427d(C27922a.this);
                            if (C27922a.this.lZd != null) {
                                C27922a.this.lZd.mo23665Lu(null);
                            }
                        } else if (C27922a.this.lYY == C27930a.STOPPED) {
                            C4990ab.m7416i("MicroMsg.FaceVideoRecorder", "hy: already stopped");
                            if (C27922a.this.lZd != null) {
                                C27922a.this.lZd.mo23665Lu(C27922a.this.gLs.getFilePath());
                            }
                        } else if (C27922a.this.lYY == C27930a.STOPPING) {
                            C4990ab.m7416i("MicroMsg.FaceVideoRecorder", "hy: stopping. wait");
                            AppMethodBeat.m2505o(553);
                        } else {
                            C4990ab.m7416i("MicroMsg.FaceVideoRecorder", "hy: stop record and release" + Thread.currentThread().getName());
                            C20636d.bsq().mo35923b(C27922a.this.lZl);
                            C27922a.this.lYY = C27930a.STOPPING;
                            C27922a.this.gLs.mo14865v(new C30391());
                            AppMethodBeat.m2505o(553);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(553);
                    }
                }
            }
        });
        AppMethodBeat.m2505o(565);
    }

    /* renamed from: aU */
    public final void mo45819aU(final byte[] bArr) {
        AppMethodBeat.m2504i(566);
        this.lYU.mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(555);
                SightVideoJNI.mirrorCameraData(bArr, C27922a.this.lZe, C27922a.this.lZf, false);
                if (C27922a.this.gLs.getFrameDataCallback() != null) {
                    C27922a.this.gLs.getFrameDataCallback().mo14870O(bArr);
                }
                AppMethodBeat.m2505o(555);
            }
        });
        AppMethodBeat.m2505o(566);
    }

    public final C27930a btz() {
        C27930a c27930a;
        synchronized (this.mLock) {
            c27930a = this.lYY;
        }
        return c27930a;
    }

    private VideoTransPara btA() {
        AppMethodBeat.m2504i(567);
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.width = this.lZe;
        videoTransPara.height = this.lZf;
        videoTransPara.fps = 30;
        videoTransPara.videoBitrate = 1200000;
        videoTransPara.fzT = 10;
        videoTransPara.fzS = 64000;
        videoTransPara.fzU = 2;
        videoTransPara.fzV = 1;
        videoTransPara.audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_16000;
        videoTransPara.duration = 15;
        AppMethodBeat.m2505o(567);
        return videoTransPara;
    }

    /* renamed from: b */
    static /* synthetic */ void m44423b(C27922a c27922a) {
        AppMethodBeat.m2504i(568);
        c27922a.mFilePath = lZi + C5046bo.m7588yz() + VideoMaterialUtil.MP4_SUFFIX;
        AppMethodBeat.m2505o(568);
    }

    /* renamed from: c */
    static /* synthetic */ void m44425c(C27922a c27922a) {
        AppMethodBeat.m2504i(569);
        c27922a.lZg = lZk + C5046bo.m7588yz() + ".thumb";
        AppMethodBeat.m2505o(569);
    }

    /* renamed from: d */
    static /* synthetic */ void m44427d(C27922a c27922a) {
        AppMethodBeat.m2504i(570);
        C5730e.deleteFile(c27922a.mFilePath);
        C5730e.deleteFile(c27922a.lZg);
        AppMethodBeat.m2505o(570);
    }
}
