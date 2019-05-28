package com.tencent.p177mm.p838bj;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p838bj.C41790a.C37515a;
import com.tencent.p177mm.p838bj.C41792c.C17984a;
import com.tencent.p177mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.bj.h */
public final class C25863h implements C37515a {
    private static int fYO = -1;
    private static int fYQ = 1;
    long bqO = -1;
    long eTA = -1;
    int eTJ = -1;
    private int eTa;
    MediaExtractor eWb;
    int eWc;
    private int fYA;
    private int fYB;
    private int fYC;
    private int fYD;
    private int fYE;
    C25866b fYF;
    Thread fYG;
    private C41792c fYH;
    HandlerThread fYI;
    C17989a fYJ;
    VideoTransPara fYK;
    private int fYL = 0;
    String fYM;
    C41790a fYN;
    private MediaFormat fYP;
    private boolean fYu = false;
    boolean fYv = false;
    private int fYx;
    private int fYy;
    private int fYz;
    private Object lock = new byte[0];
    int rotate;

    /* renamed from: com.tencent.mm.bj.h$a */
    class C17989a extends C7306ak {
        private Point fYS = null;

        public C17989a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.m2504i(50946);
            if (message.what == C25863h.fYQ) {
                byte[] bArr = (byte[]) message.obj;
                if (message.arg1 != 1) {
                    z = false;
                }
                long j = (long) message.arg2;
                if (C25863h.this.fYH != null) {
                    int integer;
                    int integer2;
                    this.fYS = C25863h.this.fYN.alJ();
                    if (C25863h.this.fYP != null) {
                        integer = C25863h.this.fYP.getInteger("width");
                        integer2 = C25863h.this.fYP.getInteger("height");
                    } else {
                        integer2 = 0;
                        integer = 0;
                    }
                    C25863h.this.fYH.mo67544a(bArr, integer, integer2, this.fYS.x, this.fYS.y, z, j, C25863h.this.fYN.alK());
                    C41791b.fXS.mo67542g(bArr);
                }
            }
            AppMethodBeat.m2505o(50946);
        }
    }

    /* renamed from: com.tencent.mm.bj.h$2 */
    class C258642 implements Runnable {
        C258642() {
        }

        public final void run() {
            AppMethodBeat.m2504i(50945);
            C25863h c25863h = C25863h.this;
            C4990ab.m7417i("MicroMsg.VideoTranscoder", "waitEncoderFinish: %s %s %s %s %s", c25863h.fYF, c25863h.fYG, Boolean.valueOf(c25863h.fYv), c25863h.fYI, c25863h.fYJ);
            if (c25863h.fYv) {
                if (!(c25863h.fYF == null || c25863h.fYG == null)) {
                    c25863h.fYF.fYU = true;
                    try {
                        c25863h.fYG.join();
                        C7305d.xDG.remove(c25863h.fYF);
                        AppMethodBeat.m2505o(50945);
                        return;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.VideoTranscoder", e, "waitEncoderFinish, join error: %s", e.getMessage());
                        AppMethodBeat.m2505o(50945);
                        return;
                    }
                }
            } else if (!(c25863h.fYI == null || c25863h.fYJ == null)) {
                try {
                    c25863h.fYI.quitSafely();
                    c25863h.fYI.join();
                    c25863h.fYJ = null;
                    AppMethodBeat.m2505o(50945);
                    return;
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.VideoTranscoder", e2, "waitEncoderFinish, join error: %s", e2.getMessage());
                }
            }
            AppMethodBeat.m2505o(50945);
        }
    }

    /* renamed from: com.tencent.mm.bj.h$1 */
    class C258651 implements C17984a {
        C258651() {
        }

        /* renamed from: a */
        public final void mo33528a(int i, ByteBuffer byteBuffer, int i2) {
            AppMethodBeat.m2504i(50944);
            MP4MuxerJNI.writeH264DataLock(i, byteBuffer, i2);
            AppMethodBeat.m2505o(50944);
        }
    }

    /* renamed from: com.tencent.mm.bj.h$b */
    class C25866b implements Runnable {
        volatile int eVU;
        int fYT;
        boolean fYU;
        Object fYV;

        private C25866b() {
            AppMethodBeat.m2504i(50947);
            this.fYV = new Object();
            AppMethodBeat.m2505o(50947);
        }

        /* synthetic */ C25866b(C25863h c25863h, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(50948);
            if (this.fYT == -1) {
                this.fYT = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                C4990ab.m7417i("MicroMsg.VideoTranscoder", "encodeTid: %s", Integer.valueOf(this.fYT));
            }
            this.eVU = 0;
            synchronized (this.fYV) {
                long yz;
                while (!this.fYU) {
                    int triggerEncodeForSegmentLock;
                    try {
                        yz = C5046bo.m7588yz();
                        C4990ab.m7416i("MicroMsg.VideoTranscoder", "try trigger encode");
                        triggerEncodeForSegmentLock = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.eVU), false);
                        C4990ab.m7417i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(this.eVU), Integer.valueOf(triggerEncodeForSegmentLock), Long.valueOf(Thread.currentThread().getId()));
                        if (triggerEncodeForSegmentLock == this.eVU) {
                            Thread.sleep(5);
                        }
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.VideoTranscoder", "thread sleep error");
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(50948);
                    }
                    this.eVU = triggerEncodeForSegmentLock;
                }
                yz = C5046bo.m7588yz();
                this.eVU = MP4MuxerJNI.triggerEncodeForSegmentLock(this.eVU, true);
                C4990ab.m7417i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(this.eVU), Long.valueOf(Thread.currentThread().getId()));
            }
            AppMethodBeat.m2505o(50948);
        }
    }

    public C25863h(int i) {
        AppMethodBeat.m2504i(50949);
        C4990ab.m7417i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", Integer.valueOf(i));
        this.eTa = i;
        AppMethodBeat.m2505o(50949);
    }

    /* renamed from: a */
    public final int mo43845a(MediaFormat mediaFormat, boolean z) {
        AppMethodBeat.m2504i(50950);
        C4990ab.m7417i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", mediaFormat, this.fYM, Boolean.valueOf(z));
        this.fYP = mediaFormat;
        this.fYu = z;
        this.fYN = new C45185d(this.eWb, mediaFormat, this.eWc);
        int i = this.fYN.mo67538i(this.fYM, this.bqO, this.eTA);
        C5046bo.m7525az(C5046bo.m7588yz());
        C4990ab.m7417i("MicroMsg.VideoTranscoder", "init decoder ret: %s", Integer.valueOf(i));
        if (i < 0) {
            C4990ab.m7416i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.fYN.stop();
                this.fYN = null;
            } catch (Exception e) {
            }
            this.fYN = new C45185d(this.eWb, mediaFormat, this.eWc);
            i = this.fYN.mo67538i(this.fYM, this.bqO, this.eTA);
        }
        this.fYN.mo67535a(this);
        C4990ab.m7417i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", Integer.valueOf(i), Integer.valueOf(fYO));
        AppMethodBeat.m2505o(50950);
        return i;
    }

    /* renamed from: cE */
    public final void mo43847cE(int i, int i2) {
        AppMethodBeat.m2504i(50951);
        C4990ab.m7417i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.fYz = i;
        this.fYA = i2;
        AppMethodBeat.m2505o(50951);
    }

    /* renamed from: v */
    private static Point m41176v(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(50952);
        C4990ab.m7410d("MicroMsg.VideoTranscoder", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            int i5;
            Point point;
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                C4990ab.m7416i("MicroMsg.VideoTranscoder", "calc scale, same len divide by 16, no need scale");
                AppMethodBeat.m2505o(50952);
                return null;
            } else if (max / 2 == max2 && min / 2 == min2) {
                C4990ab.m7416i("MicroMsg.VideoTranscoder", "calc scale, double ratio");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.m2505o(50952);
                return point;
            } else {
                i5 = max / 2;
                max = min / 2;
                if (i5 % 16 != 0 || Math.abs(i5 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    point = new Point();
                    if (i < i2) {
                        max = Math.min(i3, i4);
                        i5 = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) max)));
                    } else {
                        i5 = Math.min(i3, i4);
                        max = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) i5)));
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    C4990ab.m7417i("MicroMsg.VideoTranscoder", "calc scale, outputsize: %s %s", Integer.valueOf(max), Integer.valueOf(i5));
                    point.x = max;
                    point.y = i5;
                    point.x = C25863h.m41175ms(point.x);
                    point.y = C25863h.m41175ms(point.y);
                    AppMethodBeat.m2505o(50952);
                    return point;
                }
                C4990ab.m7416i("MicroMsg.VideoTranscoder", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.m2505o(50952);
                return point;
            }
        }
        C4990ab.m7416i("MicroMsg.VideoTranscoder", "calc scale, small or equal to spec size");
        AppMethodBeat.m2505o(50952);
        return null;
    }

    /* renamed from: ms */
    private static int m41175ms(int i) {
        AppMethodBeat.m2504i(50953);
        int i2 = i % 16;
        if (i2 == 0) {
            AppMethodBeat.m2505o(50953);
            return i;
        }
        int min = i - Math.min(16, i2);
        if (min < BaseClientBuilder.API_PRIORITY_OTHER) {
            AppMethodBeat.m2505o(50953);
            return min;
        }
        i -= i2;
        AppMethodBeat.m2505o(50953);
        return i;
    }

    public final void release() {
        AppMethodBeat.m2504i(50954);
        C4990ab.m7417i("MicroMsg.VideoTranscoder", "release, decoderType: %d", Integer.valueOf(fYO));
        try {
            if (this.fYN != null) {
                this.fYN.stop();
            }
            MP4MuxerJNI.releaseDataBufLock(0);
            fYO = -1;
            AppMethodBeat.m2505o(50954);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.VideoTranscoder", "release error: %s", e.getMessage());
            MP4MuxerJNI.releaseDataBufLock(0);
            fYO = -1;
            AppMethodBeat.m2505o(50954);
        } catch (Throwable th) {
            MP4MuxerJNI.releaseDataBufLock(0);
            fYO = -1;
            AppMethodBeat.m2505o(50954);
            throw th;
        }
    }

    /* renamed from: a */
    public final void mo43846a(byte[] bArr, boolean z, long j) {
        AppMethodBeat.m2504i(50955);
        if (bArr == null || bArr.length == 0) {
            C4990ab.m7416i("MicroMsg.VideoTranscoder", "onYuvDataImp error data is null!!");
            AppMethodBeat.m2505o(50955);
            return;
        }
        Point alJ = this.fYN.alJ();
        this.fYx = alJ.x;
        this.fYy = alJ.y;
        long yz = C5046bo.m7588yz();
        int i = 0;
        int i2 = 0;
        if (this.fYu) {
            if (this.fYE <= 0 || this.fYD <= 0) {
                Point v = C25863h.m41176v(this.fYx, this.fYy, this.fYz, this.fYA);
                if (v != null) {
                    this.fYD = v.x;
                    this.fYE = v.y;
                } else {
                    this.fYD = this.fYx;
                    this.fYE = this.fYy;
                }
                C4990ab.m7417i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", Integer.valueOf(this.fYD), Integer.valueOf(this.fYE), Integer.valueOf(this.fYx), Integer.valueOf(this.fYy));
            }
            if (this.fYP != null) {
                i = this.fYP.getInteger("width");
                i2 = this.fYP.getInteger("height");
                if (this.fYB <= 0 || this.fYC <= 0) {
                    boolean z2 = false;
                    Point v2 = C25863h.m41176v(i, i2, this.fYz, this.fYA);
                    if (v2 != null) {
                        this.fYB = v2.x;
                        this.fYC = v2.y;
                        z2 = true;
                    } else if (Math.abs(i2 - alJ.y) <= 0 || i != alJ.x) {
                        this.fYB = alJ.x;
                        this.fYC = alJ.y;
                    } else {
                        this.fYB = i;
                        this.fYC = i2;
                    }
                    if (z2) {
                        this.fYD = this.fYB;
                        this.fYE = this.fYC;
                    }
                    C4990ab.m7417i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", Integer.valueOf(this.fYB), Integer.valueOf(this.fYC), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2));
                }
            }
        } else {
            if (this.fYE <= 0 || this.fYD <= 0) {
                this.fYD = this.fYx;
                this.fYE = this.fYy;
                C4990ab.m7417i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", Integer.valueOf(this.fYD), Integer.valueOf(this.fYE), Integer.valueOf(this.fYx), Integer.valueOf(this.fYy));
            }
            if (this.fYP != null) {
                i = this.fYP.getInteger("width");
                i2 = this.fYP.getInteger("height");
                if (this.fYB <= 0 || this.fYC <= 0) {
                    if (Math.abs(i2 - alJ.y) <= 0 || i != alJ.x) {
                        this.fYB = alJ.x;
                        this.fYC = alJ.y;
                    } else {
                        this.fYB = i;
                        this.fYC = i2;
                    }
                    C4990ab.m7417i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", Integer.valueOf(this.fYB), Integer.valueOf(this.fYC), Integer.valueOf(i), Integer.valueOf(i2), Boolean.FALSE);
                }
            }
        }
        this.fYL = this.fYN.alK();
        int i3 = 0;
        if (this.fYv) {
            i3 = MP4MuxerJNI.writeYuvDataForSegmentLock(bArr, alJ.x, alJ.y, this.fYD, this.fYE, this.fYL, i, i2);
            C4990ab.m7417i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        }
        if (i3 < 0) {
            C4990ab.m7413e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", Integer.valueOf(i3));
        }
        if (this.fYv) {
            if (this.fYF == null) {
                MP4MuxerJNI.initH264EncoderLock(this.fYB, this.fYC, (float) this.fYK.fps, this.fYK.videoBitrate, this.fYK.fzV, 8, this.fYK.fzU, 23.0f);
                this.fYF = new C25866b(this, (byte) 0);
                this.fYG = C7305d.m12301h(this.fYF, "MediaCodecFFMpegTranscoder_Encoder");
                this.fYG.start();
                C4990ab.m7417i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", Boolean.valueOf(this.fYv));
            }
        } else if (this.fYH == null) {
            this.fYH = new C41792c(this.fYB, this.fYC, this.fYK.videoBitrate, this.fYK.fps);
            this.fYH.fXU = new C258651();
            try {
                i3 = this.fYH.mo67545mq(this.eTa);
                C4990ab.m7417i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", Integer.valueOf(i3));
                C41792c c41792c = this.fYH;
                C4990ab.m7416i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
                c41792c.cFy = true;
                if (this.fYI == null) {
                    this.fYI = C7305d.m12297ek("remuxer_encode", -2);
                    this.fYI.start();
                    this.fYJ = new C17989a(this.fYI.getLooper());
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VideoTranscoder", e, "init mediaCodecEncoder error: %s", e.getMessage());
            }
            C4990ab.m7417i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", Boolean.valueOf(this.fYv));
        }
        if (!(this.fYv || this.fYJ == null)) {
            Message obtain = Message.obtain();
            obtain.what = fYQ;
            byte[] g = C41791b.fXS.mo67543g(Integer.valueOf(bArr.length));
            if (g != null) {
                System.arraycopy(bArr, 0, g, 0, bArr.length);
            }
            obtain.obj = g;
            obtain.arg1 = z ? 1 : 0;
            obtain.arg2 = (int) j;
            this.fYJ.sendMessage(obtain);
        }
        AppMethodBeat.m2505o(50955);
    }
}
