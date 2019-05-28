package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.jsapi.contact.e;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ugc.TXRecordCommon;

public class a {
    private static volatile a lYT = null;
    private static final String lZi = (p.bsO() + IOUtils.DIR_SEPARATOR_UNIX + "fdv_");
    public static final String lZj = (p.bsO() + IOUtils.DIR_SEPARATOR_UNIX + "video_temp_test.mp4");
    private static final String lZk = (p.bsO() + IOUtils.DIR_SEPARATOR_UNIX + "fdv_t_");
    public d ext;
    private com.tencent.mm.plugin.mmsight.model.a.d gLs;
    public al lYU;
    private final int lYV;
    private final int lYW;
    private final int lYX;
    private a lYY;
    private int lYZ;
    private boolean lZa;
    private int lZb;
    public boolean lZc;
    private b lZd;
    private int lZe;
    private int lZf;
    private String lZg;
    public com.tencent.mm.plugin.mmsight.api.b lZh;
    private com.tencent.mm.plugin.facedetect.model.d.b lZl;
    private com.tencent.mm.plugin.mmsight.model.a.d.a lZm;
    private String mFilePath;
    private final Object mLock;

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ Runnable lZA;
        final /* synthetic */ int lZn;
        final /* synthetic */ int lZo;
        final /* synthetic */ int lZp;
        final /* synthetic */ boolean lZq = false;
        final /* synthetic */ int lZr = 0;
        final /* synthetic */ int lZt;
        final /* synthetic */ int lZu;

        public AnonymousClass3(int i, int i2, int i3, int i4, int i5, Runnable runnable) {
            this.lZn = i;
            this.lZo = i2;
            this.lZp = i3;
            this.lZt = i4;
            this.lZu = i5;
            this.lZA = runnable;
        }

        public final void run() {
            AppMethodBeat.i(547);
            if (this.lZn == 90 || this.lZn == 270) {
                ab.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
                a.this.lZe = this.lZo;
                a.this.lZf = this.lZp;
            } else {
                a.this.lZe = this.lZp;
                a.this.lZf = this.lZo;
            }
            synchronized (a.this.mLock) {
                try {
                    a.this.lYZ = this.lZn;
                    a.this.lZa = this.lZq;
                    a.this.lZb = this.lZr;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(547);
                }
            }
            a.b(a.this);
            a.c(a.this);
            a.d(a.this);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(546);
                    final long yz = bo.yz();
                    a.this.ext.connect(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(545);
                            synchronized (a.this.mLock) {
                                try {
                                    ab.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", Long.valueOf(bo.az(yz)));
                                    long yz = bo.yz();
                                    a.this.gLs = a.this.lZh.asl();
                                    a.this.gLs.setFilePath(a.this.mFilePath);
                                    a.this.gLs.mb(a.this.lZg);
                                    a.this.gLs.cv(true);
                                    a.this.gLs.s(a.this.lZe, a.this.lZf, AnonymousClass3.this.lZt, AnonymousClass3.this.lZu);
                                    a.this.gLs.ko(a.this.lYZ);
                                    a.this.gLs.a(a.this.lZm);
                                    a.this.lYY = a.INITIALIZED;
                                    ab.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", Long.valueOf(bo.az(yz)));
                                    if (AnonymousClass3.this.lZA != null) {
                                        AnonymousClass3.this.lZA.run();
                                    }
                                } finally {
                                    while (true) {
                                    }
                                    AppMethodBeat.o(545);
                                }
                            }
                        }
                    });
                    AppMethodBeat.o(546);
                }
            });
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ int lZD;

        public AnonymousClass4(int i) {
            this.lZD = i;
        }

        public final void run() {
            AppMethodBeat.i(548);
            if (a.this.gLs != null) {
                a.this.gLs.kp(this.lZD);
            }
            AppMethodBeat.o(548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ float lZE;

        public AnonymousClass5(float f) {
            this.lZE = f;
        }

        public final void run() {
            AppMethodBeat.i(JsApiChooseMultiMedia.CTRL_INDEX);
            if (a.this.gLs != null) {
                a.this.gLs.af(this.lZE);
            }
            AppMethodBeat.o(JsApiChooseMultiMedia.CTRL_INDEX);
        }
    }

    public interface b {
        void Lu(String str);
    }

    public enum a {
        UNINITIALIZED,
        INITIALIZED,
        STARTED,
        STOPPING,
        STOPPED,
        CANCELLED;

        static {
            AppMethodBeat.o(JsApiSetLabInfo.CTRL_INDEX);
        }
    }

    static {
        AppMethodBeat.i(571);
        AppMethodBeat.o(571);
    }

    private a() {
        AppMethodBeat.i(559);
        this.mLock = new Object();
        this.lYU = null;
        this.lYV = VideoFilterUtil.IMAGE_HEIGHT;
        this.lYW = 540;
        this.lYX = 15;
        this.lYY = a.UNINITIALIZED;
        this.lYZ = 0;
        this.lZa = false;
        this.lZb = 0;
        this.lZc = false;
        this.lZd = null;
        this.lZe = -1;
        this.lZf = -1;
        this.mFilePath = "";
        this.lZg = "";
        this.ext = new d(ah.getContext());
        this.lZh = com.tencent.mm.plugin.mmsight.api.b.ota.asm();
        this.lZl = new com.tencent.mm.plugin.facedetect.model.d.b() {
            public final void aT(byte[] bArr) {
                AppMethodBeat.i(554);
                a.this.aU(bArr);
                AppMethodBeat.o(554);
            }

            public final com.tencent.mm.memory.a<byte[]> bsr() {
                return j.owk;
            }
        };
        this.lZm = new com.tencent.mm.plugin.mmsight.model.a.d.a() {
            public final void asv() {
                AppMethodBeat.i(544);
                ab.e("MicroMsg.FaceVideoRecorder", "hy: video capture error: %d", Integer.valueOf(1));
                a.this.lYU.aa(new Runnable() {
                    final /* synthetic */ int gIb = 1;

                    public final void run() {
                        AppMethodBeat.i(543);
                        try {
                            if (a.this.gLs != null) {
                                a.this.gLs.reset();
                            }
                            a.d(a.this);
                        } catch (Exception e) {
                            ab.e("MicroMsg.FaceVideoRecorder", "hy: onError, reset mediaRecorder error: %s", e.getMessage());
                            a.d(a.this);
                        } catch (Throwable th) {
                            a.d(a.this);
                            AppMethodBeat.o(543);
                        }
                        synchronized (a.this.mLock) {
                            try {
                                a.this.lYY = a.INITIALIZED;
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(543);
                            }
                        }
                        FaceDetectReporter.i(FaceContextData.bss().lTH, 2, this.gIb);
                    }
                });
                AppMethodBeat.o(544);
            }
        };
        this.lYU = new al("face_video_handler");
        AppMethodBeat.o(559);
    }

    public static a btw() {
        AppMethodBeat.i(560);
        a aVar;
        if (lYT == null) {
            synchronized (a.class) {
                try {
                    if (lYT == null) {
                        lYT = new a();
                    }
                    aVar = lYT;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(560);
                }
            }
            return aVar;
        }
        aVar = lYT;
        AppMethodBeat.o(560);
        return aVar;
    }

    public final boolean a(int i, int i2, int i3, int i4, int i5, boolean z) {
        AppMethodBeat.i(561);
        ab.i("MicroMsg.FaceVideoRecorder", "hy: init record");
        ab.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d, acceptVoiceFromOutside: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.FALSE, Integer.valueOf(0), Boolean.valueOf(z));
        this.lZh.a(this.ext, btA());
        final int i6 = i;
        final int i7 = i3;
        final int i8 = i2;
        final boolean z2 = z;
        final int i9 = i4;
        final int i10 = i5;
        this.lYU.aa(new Runnable() {
            final /* synthetic */ boolean lZq = false;
            final /* synthetic */ int lZr = 0;

            public final void run() {
                AppMethodBeat.i(542);
                if (i6 == 90 || i6 == 270) {
                    ab.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
                    a.this.lZe = i7;
                    a.this.lZf = i8;
                } else {
                    a.this.lZe = i8;
                    a.this.lZf = i7;
                }
                synchronized (a.this.mLock) {
                    try {
                        a.this.lYZ = i6;
                        a.this.lZa = this.lZq;
                        a.this.lZb = this.lZr;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(542);
                    }
                }
                a.b(a.this);
                a.c(a.this);
                a.d(a.this);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(541);
                        final long yz = bo.yz();
                        a.this.ext.connect(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(540);
                                synchronized (a.this.mLock) {
                                    try {
                                        ab.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", Long.valueOf(bo.az(yz)));
                                        long yz = bo.yz();
                                        a.this.gLs = a.this.lZh.asl();
                                        a.this.gLs.setFilePath(a.this.mFilePath);
                                        a.this.gLs.mb(a.this.lZg);
                                        a.this.gLs.cv(z2);
                                        a.this.gLs.s(a.this.lZe, a.this.lZf, i9, i10);
                                        a.this.gLs.ko(a.this.lYZ);
                                        a.this.gLs.a(a.this.lZm);
                                        a.this.lYY = a.INITIALIZED;
                                        ab.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", Long.valueOf(bo.az(yz)));
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.o(540);
                                    }
                                }
                            }
                        });
                        AppMethodBeat.o(541);
                    }
                });
            }
        });
        AppMethodBeat.o(561);
        return true;
    }

    public final boolean isStarted() {
        boolean z;
        synchronized (this.mLock) {
            z = this.lYY == a.STARTED;
        }
        return z;
    }

    public final com.tencent.mm.audio.b.c.a btx() {
        AppMethodBeat.i(562);
        if (this.gLs != null) {
            com.tencent.mm.audio.b.c.a WQ = this.gLs.WQ();
            AppMethodBeat.o(562);
            return WQ;
        }
        ab.w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
        AppMethodBeat.o(562);
        return null;
    }

    public final boolean EL() {
        AppMethodBeat.i(563);
        ab.e("MicroMsg.FaceVideoRecorder", "carson: start Record Video");
        this.lYU.aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(e.CTRL_INDEX);
                synchronized (a.this.mLock) {
                    try {
                        if (a.this.lYY == a.UNINITIALIZED) {
                            ab.e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
                            a.d(a.this);
                        } else if (a.this.lYY == a.STARTED) {
                            ab.w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
                            AppMethodBeat.o(e.CTRL_INDEX);
                        } else {
                            ab.i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
                            com.tencent.mm.plugin.facedetect.model.d.bsq().a(a.this.lZl);
                            a.this.gLs.b(a.this.lYZ, a.this.lZa, a.this.lZb);
                            a.this.lYY = a.STARTED;
                            AppMethodBeat.o(e.CTRL_INDEX);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(e.CTRL_INDEX);
                    }
                }
            }
        });
        AppMethodBeat.o(563);
        return true;
    }

    public final void bty() {
        AppMethodBeat.i(564);
        ab.e("MicroMsg.FaceVideoRecorder", "carson: cancel Record Video");
        this.lYU.aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(551);
                synchronized (a.this.mLock) {
                    try {
                        if (a.this.lYY == a.UNINITIALIZED) {
                            ab.e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
                            a.d(a.this);
                        } else {
                            ab.i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
                            a.this.gLs.cancel();
                            a.d(a.this);
                            com.tencent.mm.plugin.facedetect.model.d.bsq().b(a.this.lZl);
                            a.this.lYY = a.CANCELLED;
                            a.this.ext.release();
                            AppMethodBeat.o(551);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(551);
                    }
                }
            }
        });
        AppMethodBeat.o(564);
    }

    public final void a(final b bVar) {
        AppMethodBeat.i(565);
        ab.e("MicroMsg.FaceVideoRecorder", "carson: stop Record Video");
        this.lYU.aa(new Runnable() {
            /* JADX WARNING: Missing block: B:18:0x0077, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(553);
     */
            /* JADX WARNING: Missing block: B:26:0x00aa, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(553);
     */
            /* JADX WARNING: Missing block: B:45:?, code skipped:
            return;
     */
            /* JADX WARNING: Missing block: B:46:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(553);
                synchronized (a.this.mLock) {
                    try {
                        a.this.lZd = bVar;
                        if (a.this.lYY == a.UNINITIALIZED) {
                            ab.e("MicroMsg.FaceVideoRecorder", "hy: not initialized. should not happen");
                            a.d(a.this);
                            if (a.this.lZd != null) {
                                a.this.lZd.Lu(null);
                            }
                        } else if (a.this.lYY == a.CANCELLED || a.this.lYY == a.INITIALIZED) {
                            ab.w("MicroMsg.FaceVideoRecorder", "hy: cancelled or not started capturing.");
                            a.d(a.this);
                            if (a.this.lZd != null) {
                                a.this.lZd.Lu(null);
                            }
                        } else if (a.this.lYY == a.STOPPED) {
                            ab.i("MicroMsg.FaceVideoRecorder", "hy: already stopped");
                            if (a.this.lZd != null) {
                                a.this.lZd.Lu(a.this.gLs.getFilePath());
                            }
                        } else if (a.this.lYY == a.STOPPING) {
                            ab.i("MicroMsg.FaceVideoRecorder", "hy: stopping. wait");
                            AppMethodBeat.o(553);
                        } else {
                            ab.i("MicroMsg.FaceVideoRecorder", "hy: stop record and release" + Thread.currentThread().getName());
                            com.tencent.mm.plugin.facedetect.model.d.bsq().b(a.this.lZl);
                            a.this.lYY = a.STOPPING;
                            a.this.gLs.v(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(552);
                                    synchronized (a.this.mLock) {
                                        try {
                                            ab.i("MicroMsg.FaceVideoRecorder", "carson: begin to stop" + a.this.gLs.getFilePath());
                                            a.this.lYY = a.STOPPED;
                                            com.tencent.mm.vfs.e.deleteFile(a.this.lZg);
                                            if (a.this.lZd != null) {
                                                a.this.lZd.Lu(a.this.gLs.getFilePath());
                                            }
                                        } finally {
                                            while (true) {
                                            }
                                            AppMethodBeat.o(552);
                                        }
                                    }
                                }
                            });
                            AppMethodBeat.o(553);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(553);
                    }
                }
            }
        });
        AppMethodBeat.o(565);
    }

    public final void aU(final byte[] bArr) {
        AppMethodBeat.i(566);
        this.lYU.aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(555);
                SightVideoJNI.mirrorCameraData(bArr, a.this.lZe, a.this.lZf, false);
                if (a.this.gLs.getFrameDataCallback() != null) {
                    a.this.gLs.getFrameDataCallback().O(bArr);
                }
                AppMethodBeat.o(555);
            }
        });
        AppMethodBeat.o(566);
    }

    public final a btz() {
        a aVar;
        synchronized (this.mLock) {
            aVar = this.lYY;
        }
        return aVar;
    }

    private VideoTransPara btA() {
        AppMethodBeat.i(567);
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
        AppMethodBeat.o(567);
        return videoTransPara;
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(568);
        aVar.mFilePath = lZi + bo.yz() + VideoMaterialUtil.MP4_SUFFIX;
        AppMethodBeat.o(568);
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(569);
        aVar.lZg = lZk + bo.yz() + ".thumb";
        AppMethodBeat.o(569);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(570);
        com.tencent.mm.vfs.e.deleteFile(aVar.mFilePath);
        com.tencent.mm.vfs.e.deleteFile(aVar.lZg);
        AppMethodBeat.o(570);
    }
}
