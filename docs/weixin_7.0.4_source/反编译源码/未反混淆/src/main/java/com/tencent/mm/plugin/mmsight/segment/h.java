package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h implements com.tencent.mm.plugin.mmsight.segment.e.a {
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
    a oyg;
    e oyh;
    private boolean oyi = false;
    int rotate;

    class a implements Runnable {
        volatile int eVU;
        int fYT;
        boolean fYU;
        Object fYV;

        private a() {
            AppMethodBeat.i(3654);
            this.fYV = new Object();
            AppMethodBeat.o(3654);
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(3655);
            if (this.fYT == -1) {
                this.fYT = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", Integer.valueOf(this.fYT));
            }
            this.eVU = 0;
            synchronized (this.fYV) {
                long yz;
                while (!this.fYU) {
                    int triggerEncodeForSegment;
                    try {
                        yz = bo.yz();
                        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
                        triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.eVU), false);
                        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(bo.az(yz)), Integer.valueOf(this.eVU), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId()));
                        if (triggerEncodeForSegment == this.eVU) {
                            Thread.sleep(20);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
                    } catch (Throwable th) {
                        AppMethodBeat.o(3655);
                    }
                    this.eVU = triggerEncodeForSegment;
                }
                yz = bo.yz();
                this.eVU = MP4MuxerJNI.triggerEncodeForSegment(this.eVU, true);
                ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(bo.az(yz)), Integer.valueOf(this.eVU), Long.valueOf(Thread.currentThread().getId()));
            }
            AppMethodBeat.o(3655);
        }
    }

    public h() {
        AppMethodBeat.i(3656);
        AppMethodBeat.o(3656);
    }

    /* JADX WARNING: Missing block: B:24:0x005c, code skipped:
            if (r0 == 3) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int bQk() {
        AppMethodBeat.i(3657);
        int i = CaptureMMProxy.getInstance().getInt(com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_FFMMPEGCUT_INT_SYNC, -1);
        if (i != -1) {
            if (i == 1) {
                if (d.iW(21)) {
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
            AppMethodBeat.o(3657);
            return i;
        } else if (fYO != -1) {
            i = fYO;
            AppMethodBeat.o(3657);
            return i;
        } else {
            i = q.etj.etD;
            if (i == -1) {
                if (d.iW(bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21))) {
                    fYO = 1;
                }
                fYO = 3;
            } else if (i == 1) {
                fYO = 1;
            } else if (i == 2) {
                if (d.iW(21)) {
                    fYO = 2;
                } else {
                    fYO = 1;
                }
            }
            i = fYO;
            AppMethodBeat.o(3657);
            return i;
        }
    }

    public final int f(MediaFormat mediaFormat) {
        AppMethodBeat.i(3658);
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", mediaFormat, this.fYM);
        this.fYP = mediaFormat;
        int bQk = bQk();
        if (bQk == 1) {
            this.oyh = new i(this.eWb, mediaFormat, this.eWc);
            this.oyi = false;
        } else if (bQk == 2) {
            this.oyh = new j(this.eWb, mediaFormat, this.eWc);
            this.oyi = false;
        } else {
            this.oyh = new b();
            this.oyi = true;
        }
        if (this.oyh == null) {
            ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
            this.oyh = new i(this.eWb, mediaFormat, this.eWc);
            this.oyi = false;
        }
        bQk = this.oyh.i(this.fYM, this.bqO, this.eTA);
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", Integer.valueOf(bQk));
        if (bQk < 0 && (fYO == 1 || fYO == 2)) {
            ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.oyh.stop();
                this.oyh = null;
            } catch (Exception e) {
            }
            this.oyh = new b();
            this.oyi = true;
            fYO = 3;
            bQk = this.oyh.i(this.fYM, this.bqO, this.eTA);
        }
        this.oyh.a(this);
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", Integer.valueOf(bQk), Integer.valueOf(fYO));
        AppMethodBeat.o(3658);
        return bQk;
    }

    public final void cE(int i, int i2) {
        AppMethodBeat.i(3659);
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.fYz = i;
        this.fYA = i2;
        AppMethodBeat.o(3659);
    }

    private static Point v(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(3660);
        ab.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            int i5;
            Point point;
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
                AppMethodBeat.o(3660);
                return null;
            } else if (max / 2 == max2 && min / 2 == min2) {
                ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.o(3660);
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
                    ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", Integer.valueOf(max), Integer.valueOf(i5));
                    point.x = max;
                    point.y = i5;
                    AppMethodBeat.o(3660);
                    return point;
                }
                ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.o(3660);
                return point;
            }
        }
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
        AppMethodBeat.o(3660);
        return null;
    }

    public final void release() {
        AppMethodBeat.i(3661);
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", Integer.valueOf(fYO));
        try {
            if (this.oyh != null) {
                this.oyh.stop();
            }
            MP4MuxerJNI.releaseDataBuf(0);
            fYO = -1;
            AppMethodBeat.o(3661);
        } catch (Exception e) {
            ab.e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", e.getMessage());
            MP4MuxerJNI.releaseDataBuf(0);
            fYO = -1;
            AppMethodBeat.o(3661);
        } catch (Throwable th) {
            MP4MuxerJNI.releaseDataBuf(0);
            fYO = -1;
            AppMethodBeat.o(3661);
            throw th;
        }
    }

    public final void ba(byte[] bArr) {
        AppMethodBeat.i(3662);
        if (bArr == null || bArr.length == 0) {
            ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
            AppMethodBeat.o(3662);
            return;
        }
        Point v;
        Point alJ = this.oyh.alJ();
        this.fYx = alJ.x;
        this.fYy = alJ.y;
        if (this.fYE <= 0 || this.fYD <= 0) {
            v = v(this.fYx, this.fYy, this.fYz, this.fYA);
            if (v != null) {
                this.fYD = v.x;
                this.fYE = v.y;
            } else {
                this.fYD = this.fYx;
                this.fYE = this.fYy;
            }
            ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", Integer.valueOf(this.fYD), Integer.valueOf(this.fYE), Integer.valueOf(this.fYx), Integer.valueOf(this.fYy));
        }
        long yz = bo.yz();
        int i = 0;
        int i2 = 0;
        if (this.fYP != null) {
            i = this.fYP.getInteger("width");
            i2 = this.fYP.getInteger("height");
            if (this.fYB <= 0 || this.fYC <= 0) {
                boolean z;
                v = v(i, i2, this.fYz, this.fYA);
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
                ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", Integer.valueOf(this.fYB), Integer.valueOf(this.fYC), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
            }
        }
        this.fYL = this.oyh.alK();
        int writeYuvDataForSegment = MP4MuxerJNI.writeYuvDataForSegment(bArr, alJ.x, alJ.y, this.fYD, this.fYE, this.fYL, i, i2);
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", Long.valueOf(bo.az(yz)));
        if (writeYuvDataForSegment < 0) {
            ab.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", Integer.valueOf(writeYuvDataForSegment));
        }
        if (this.oyg == null) {
            MP4MuxerJNI.initH264Encoder(this.fYB, this.fYC, (float) this.fYK.fps, this.fYK.videoBitrate, this.fYK.fzV, 8, this.fYK.fzU, 23.0f);
            this.oyg = new a(this, (byte) 0);
            this.eVR = com.tencent.mm.sdk.g.d.h(this.oyg, "MediaCodecFFMpegTranscoder_Encoder");
            this.eVR.start();
            ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
        }
        AppMethodBeat.o(3662);
    }
}
