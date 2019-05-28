package com.tencent.p177mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.segment.C46082e.C12578a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.h */
public final class C39401h implements C12578a {
    private static int fYO = -1;
    long bqO = -1;
    long eTA = -1;
    int eTJ = -1;
    Thread eVR;
    MediaExtractor eWb;
    int eWc;
    private int fYA;
    private int fYB;
    private int fYC;
    private int fYD;
    private int fYE;
    VideoTransPara fYK;
    private int fYL = 0;
    String fYM;
    private MediaFormat fYP;
    private int fYx;
    private int fYy;
    private int fYz;
    private Object lock = new byte[0];
    C39402a oyg;
    C46082e oyh;
    private boolean oyi = false;
    int rotate;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.h$1 */
    class C285151 implements Runnable {
        C285151() {
        }

        public final void run() {
            AppMethodBeat.m2504i(3653);
            C39401h c39401h = C39401h.this;
            C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "waitEncoderFinish: %s %s", c39401h.oyg, c39401h.eVR);
            if (!(c39401h.oyg == null || c39401h.eVR == null)) {
                c39401h.oyg.fYU = true;
                try {
                    c39401h.eVR.join();
                    C7305d.xDG.remove(c39401h.oyg);
                    AppMethodBeat.m2505o(3653);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e, "waitEncoderFinish, join error: %s", e.getMessage());
                }
            }
            AppMethodBeat.m2505o(3653);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.h$a */
    class C39402a implements Runnable {
        volatile int eVU;
        int fYT;
        boolean fYU;
        Object fYV;

        private C39402a() {
            AppMethodBeat.m2504i(3654);
            this.fYV = new Object();
            AppMethodBeat.m2505o(3654);
        }

        /* synthetic */ C39402a(C39401h c39401h, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(3655);
            if (this.fYT == -1) {
                this.fYT = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", Integer.valueOf(this.fYT));
            }
            this.eVU = 0;
            synchronized (this.fYV) {
                long yz;
                while (!this.fYU) {
                    int triggerEncodeForSegment;
                    try {
                        yz = C5046bo.m7588yz();
                        C4990ab.m7416i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
                        triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.eVU), false);
                        C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(this.eVU), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId()));
                        if (triggerEncodeForSegment == this.eVU) {
                            Thread.sleep(20);
                        }
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(3655);
                    }
                    this.eVU = triggerEncodeForSegment;
                }
                yz = C5046bo.m7588yz();
                this.eVU = MP4MuxerJNI.triggerEncodeForSegment(this.eVU, true);
                C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(this.eVU), Long.valueOf(Thread.currentThread().getId()));
            }
            AppMethodBeat.m2505o(3655);
        }
    }

    public C39401h() {
        AppMethodBeat.m2504i(3656);
        AppMethodBeat.m2505o(3656);
    }

    /* JADX WARNING: Missing block: B:24:0x005c, code skipped:
            if (r0 == 3) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int bQk() {
        AppMethodBeat.m2504i(3657);
        int i = CaptureMMProxy.getInstance().getInt(C5127a.USERINFO_LOCAL_SIGHT_FFMMPEGCUT_INT_SYNC, -1);
        if (i != -1) {
            if (i == 1) {
                if (C1443d.m3068iW(21)) {
                    fYO = 2;
                } else {
                    fYO = 1;
                }
            } else if (i == 2) {
                fYO = 1;
            } else {
                fYO = 3;
            }
            i = fYO;
            AppMethodBeat.m2505o(3657);
            return i;
        } else if (fYO != -1) {
            i = fYO;
            AppMethodBeat.m2505o(3657);
            return i;
        } else {
            i = C1427q.etj.etD;
            if (i == -1) {
                if (C1443d.m3068iW(C5046bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21))) {
                    fYO = 1;
                }
                fYO = 3;
            } else if (i == 1) {
                fYO = 1;
            } else if (i == 2) {
                if (C1443d.m3068iW(21)) {
                    fYO = 2;
                } else {
                    fYO = 1;
                }
            }
            i = fYO;
            AppMethodBeat.m2505o(3657);
            return i;
        }
    }

    /* renamed from: f */
    public final int mo62332f(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(3658);
        C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", mediaFormat, this.fYM);
        this.fYP = mediaFormat;
        int bQk = C39401h.bQk();
        if (bQk == 1) {
            this.oyh = new C28517i(this.eWb, mediaFormat, this.eWc);
            this.oyi = false;
        } else if (bQk == 2) {
            this.oyh = new C12580j(this.eWb, mediaFormat, this.eWc);
            this.oyi = false;
        } else {
            this.oyh = new C12574b();
            this.oyi = true;
        }
        if (this.oyh == null) {
            C4990ab.m7416i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
            this.oyh = new C28517i(this.eWb, mediaFormat, this.eWc);
            this.oyi = false;
        }
        bQk = this.oyh.mo24498i(this.fYM, this.bqO, this.eTA);
        C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", Integer.valueOf(bQk));
        if (bQk < 0 && (fYO == 1 || fYO == 2)) {
            C4990ab.m7416i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.oyh.stop();
                this.oyh = null;
            } catch (Exception e) {
            }
            this.oyh = new C12574b();
            this.oyi = true;
            fYO = 3;
            bQk = this.oyh.mo24498i(this.fYM, this.bqO, this.eTA);
        }
        this.oyh.mo24495a(this);
        C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", Integer.valueOf(bQk), Integer.valueOf(fYO));
        AppMethodBeat.m2505o(3658);
        return bQk;
    }

    /* renamed from: cE */
    public final void mo62331cE(int i, int i2) {
        AppMethodBeat.m2504i(3659);
        C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.fYz = i;
        this.fYA = i2;
        AppMethodBeat.m2505o(3659);
    }

    /* renamed from: v */
    private static Point m67245v(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(3660);
        C4990ab.m7410d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            int i5;
            Point point;
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                C4990ab.m7416i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
                AppMethodBeat.m2505o(3660);
                return null;
            } else if (max / 2 == max2 && min / 2 == min2) {
                C4990ab.m7416i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.m2505o(3660);
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
                    C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", Integer.valueOf(max), Integer.valueOf(i5));
                    point.x = max;
                    point.y = i5;
                    AppMethodBeat.m2505o(3660);
                    return point;
                }
                C4990ab.m7416i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.m2505o(3660);
                return point;
            }
        }
        C4990ab.m7416i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
        AppMethodBeat.m2505o(3660);
        return null;
    }

    public final void release() {
        AppMethodBeat.m2504i(3661);
        C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", Integer.valueOf(fYO));
        try {
            if (this.oyh != null) {
                this.oyh.stop();
            }
            MP4MuxerJNI.releaseDataBuf(0);
            fYO = -1;
            AppMethodBeat.m2505o(3661);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", e.getMessage());
            MP4MuxerJNI.releaseDataBuf(0);
            fYO = -1;
            AppMethodBeat.m2505o(3661);
        } catch (Throwable th) {
            MP4MuxerJNI.releaseDataBuf(0);
            fYO = -1;
            AppMethodBeat.m2505o(3661);
            throw th;
        }
    }

    /* renamed from: ba */
    public final void mo24511ba(byte[] bArr) {
        AppMethodBeat.m2504i(3662);
        if (bArr == null || bArr.length == 0) {
            C4990ab.m7416i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
            AppMethodBeat.m2505o(3662);
            return;
        }
        Point v;
        Point alJ = this.oyh.alJ();
        this.fYx = alJ.x;
        this.fYy = alJ.y;
        if (this.fYE <= 0 || this.fYD <= 0) {
            v = C39401h.m67245v(this.fYx, this.fYy, this.fYz, this.fYA);
            if (v != null) {
                this.fYD = v.x;
                this.fYE = v.y;
            } else {
                this.fYD = this.fYx;
                this.fYE = this.fYy;
            }
            C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", Integer.valueOf(this.fYD), Integer.valueOf(this.fYE), Integer.valueOf(this.fYx), Integer.valueOf(this.fYy));
        }
        long yz = C5046bo.m7588yz();
        int i = 0;
        int i2 = 0;
        if (this.fYP != null) {
            i = this.fYP.getInteger("width");
            i2 = this.fYP.getInteger("height");
            if (this.fYB <= 0 || this.fYC <= 0) {
                boolean z;
                v = C39401h.m67245v(i, i2, this.fYz, this.fYA);
                if (v != null) {
                    this.fYB = v.x;
                    this.fYC = v.y;
                    z = true;
                } else {
                    if (Math.abs(i2 - alJ.y) <= 0 || i != alJ.x) {
                        this.fYB = alJ.x;
                        this.fYC = alJ.y;
                    } else {
                        this.fYB = i;
                        this.fYC = i2;
                    }
                    z = false;
                }
                if (z) {
                    this.fYD = this.fYB;
                    this.fYE = this.fYC;
                }
                C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", Integer.valueOf(this.fYB), Integer.valueOf(this.fYC), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
            }
        }
        this.fYL = this.oyh.alK();
        int writeYuvDataForSegment = MP4MuxerJNI.writeYuvDataForSegment(bArr, alJ.x, alJ.y, this.fYD, this.fYE, this.fYL, i, i2);
        C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        if (writeYuvDataForSegment < 0) {
            C4990ab.m7413e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", Integer.valueOf(writeYuvDataForSegment));
        }
        if (this.oyg == null) {
            MP4MuxerJNI.initH264Encoder(this.fYB, this.fYC, (float) this.fYK.fps, this.fYK.videoBitrate, this.fYK.fzV, 8, this.fYK.fzU, 23.0f);
            this.oyg = new C39402a(this, (byte) 0);
            this.eVR = C7305d.m12301h(this.oyg, "MediaCodecFFMpegTranscoder_Encoder");
            this.eVR.start();
            C4990ab.m7416i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
        }
        AppMethodBeat.m2505o(3662);
    }
}
