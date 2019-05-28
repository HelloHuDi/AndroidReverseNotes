package com.tencent.mm.bj;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

public final class h implements com.tencent.mm.bj.a.a {
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
    b fYF;
    Thread fYG;
    private c fYH;
    HandlerThread fYI;
    a fYJ;
    VideoTransPara fYK;
    private int fYL = 0;
    String fYM;
    a fYN;
    private MediaFormat fYP;
    private boolean fYu = false;
    boolean fYv = false;
    private int fYx;
    private int fYy;
    private int fYz;
    private Object lock = new byte[0];
    int rotate;

    class a extends ak {
        private Point fYS = null;

        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.i(50946);
            if (message.what == h.fYQ) {
                byte[] bArr = (byte[]) message.obj;
                if (message.arg1 != 1) {
                    z = false;
                }
                long j = (long) message.arg2;
                if (h.this.fYH != null) {
                    int integer;
                    int integer2;
                    this.fYS = h.this.fYN.alJ();
                    if (h.this.fYP != null) {
                        integer = h.this.fYP.getInteger("width");
                        integer2 = h.this.fYP.getInteger("height");
                    } else {
                        integer2 = 0;
                        integer = 0;
                    }
                    h.this.fYH.a(bArr, integer, integer2, this.fYS.x, this.fYS.y, z, j, h.this.fYN.alK());
                    b.fXS.g(bArr);
                }
            }
            AppMethodBeat.o(50946);
        }
    }

    class b implements Runnable {
        volatile int eVU;
        int fYT;
        boolean fYU;
        Object fYV;

        private b() {
            AppMethodBeat.i(50947);
            this.fYV = new Object();
            AppMethodBeat.o(50947);
        }

        /* synthetic */ b(h hVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(50948);
            if (this.fYT == -1) {
                this.fYT = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                ab.i("MicroMsg.VideoTranscoder", "encodeTid: %s", Integer.valueOf(this.fYT));
            }
            this.eVU = 0;
            synchronized (this.fYV) {
                long yz;
                while (!this.fYU) {
                    int triggerEncodeForSegmentLock;
                    try {
                        yz = bo.yz();
                        ab.i("MicroMsg.VideoTranscoder", "try trigger encode");
                        triggerEncodeForSegmentLock = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.eVU), false);
                        ab.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(bo.az(yz)), Integer.valueOf(this.eVU), Integer.valueOf(triggerEncodeForSegmentLock), Long.valueOf(Thread.currentThread().getId()));
                        if (triggerEncodeForSegmentLock == this.eVU) {
                            Thread.sleep(5);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.VideoTranscoder", "thread sleep error");
                    } catch (Throwable th) {
                        AppMethodBeat.o(50948);
                    }
                    this.eVU = triggerEncodeForSegmentLock;
                }
                yz = bo.yz();
                this.eVU = MP4MuxerJNI.triggerEncodeForSegmentLock(this.eVU, true);
                ab.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(bo.az(yz)), Integer.valueOf(this.eVU), Long.valueOf(Thread.currentThread().getId()));
            }
            AppMethodBeat.o(50948);
        }
    }

    public h(int i) {
        AppMethodBeat.i(50949);
        ab.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", Integer.valueOf(i));
        this.eTa = i;
        AppMethodBeat.o(50949);
    }

    public final int a(MediaFormat mediaFormat, boolean z) {
        AppMethodBeat.i(50950);
        ab.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", mediaFormat, this.fYM, Boolean.valueOf(z));
        this.fYP = mediaFormat;
        this.fYu = z;
        this.fYN = new d(this.eWb, mediaFormat, this.eWc);
        int i = this.fYN.i(this.fYM, this.bqO, this.eTA);
        bo.az(bo.yz());
        ab.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", Integer.valueOf(i));
        if (i < 0) {
            ab.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.fYN.stop();
                this.fYN = null;
            } catch (Exception e) {
            }
            this.fYN = new d(this.eWb, mediaFormat, this.eWc);
            i = this.fYN.i(this.fYM, this.bqO, this.eTA);
        }
        this.fYN.a(this);
        ab.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", Integer.valueOf(i), Integer.valueOf(fYO));
        AppMethodBeat.o(50950);
        return i;
    }

    public final void cE(int i, int i2) {
        AppMethodBeat.i(50951);
        ab.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.fYz = i;
        this.fYA = i2;
        AppMethodBeat.o(50951);
    }

    private static Point v(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(50952);
        ab.d("MicroMsg.VideoTranscoder", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            int i5;
            Point point;
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                ab.i("MicroMsg.VideoTranscoder", "calc scale, same len divide by 16, no need scale");
                AppMethodBeat.o(50952);
                return null;
            } else if (max / 2 == max2 && min / 2 == min2) {
                ab.i("MicroMsg.VideoTranscoder", "calc scale, double ratio");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.o(50952);
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
                    ab.i("MicroMsg.VideoTranscoder", "calc scale, outputsize: %s %s", Integer.valueOf(max), Integer.valueOf(i5));
                    point.x = max;
                    point.y = i5;
                    point.x = ms(point.x);
                    point.y = ms(point.y);
                    AppMethodBeat.o(50952);
                    return point;
                }
                ab.i("MicroMsg.VideoTranscoder", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.o(50952);
                return point;
            }
        }
        ab.i("MicroMsg.VideoTranscoder", "calc scale, small or equal to spec size");
        AppMethodBeat.o(50952);
        return null;
    }

    private static int ms(int i) {
        AppMethodBeat.i(50953);
        int i2 = i % 16;
        if (i2 == 0) {
            AppMethodBeat.o(50953);
            return i;
        }
        int min = i - Math.min(16, i2);
        if (min < BaseClientBuilder.API_PRIORITY_OTHER) {
            AppMethodBeat.o(50953);
            return min;
        }
        i -= i2;
        AppMethodBeat.o(50953);
        return i;
    }

    public final void release() {
        AppMethodBeat.i(50954);
        ab.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", Integer.valueOf(fYO));
        try {
            if (this.fYN != null) {
                this.fYN.stop();
            }
            MP4MuxerJNI.releaseDataBufLock(0);
            fYO = -1;
            AppMethodBeat.o(50954);
        } catch (Exception e) {
            ab.e("MicroMsg.VideoTranscoder", "release error: %s", e.getMessage());
            MP4MuxerJNI.releaseDataBufLock(0);
            fYO = -1;
            AppMethodBeat.o(50954);
        } catch (Throwable th) {
            MP4MuxerJNI.releaseDataBufLock(0);
            fYO = -1;
            AppMethodBeat.o(50954);
            throw th;
        }
    }

    public final void a(byte[] bArr, boolean z, long j) {
        AppMethodBeat.i(50955);
        if (bArr == null || bArr.length == 0) {
            ab.i("MicroMsg.VideoTranscoder", "onYuvDataImp error data is null!!");
            AppMethodBeat.o(50955);
            return;
        }
        Point alJ = this.fYN.alJ();
        this.fYx = alJ.x;
        this.fYy = alJ.y;
        long yz = bo.yz();
        int i = 0;
        int i2 = 0;
        if (this.fYu) {
            if (this.fYE <= 0 || this.fYD <= 0) {
                Point v = v(this.fYx, this.fYy, this.fYz, this.fYA);
                if (v != null) {
                    this.fYD = v.x;
                    this.fYE = v.y;
                } else {
                    this.fYD = this.fYx;
                    this.fYE = this.fYy;
                }
                ab.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", Integer.valueOf(this.fYD), Integer.valueOf(this.fYE), Integer.valueOf(this.fYx), Integer.valueOf(this.fYy));
            }
            if (this.fYP != null) {
                i = this.fYP.getInteger("width");
                i2 = this.fYP.getInteger("height");
                if (this.fYB <= 0 || this.fYC <= 0) {
                    boolean z2 = false;
                    Point v2 = v(i, i2, this.fYz, this.fYA);
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
                    ab.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", Integer.valueOf(this.fYB), Integer.valueOf(this.fYC), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2));
                }
            }
        } else {
            if (this.fYE <= 0 || this.fYD <= 0) {
                this.fYD = this.fYx;
                this.fYE = this.fYy;
                ab.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", Integer.valueOf(this.fYD), Integer.valueOf(this.fYE), Integer.valueOf(this.fYx), Integer.valueOf(this.fYy));
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
                    ab.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", Integer.valueOf(this.fYB), Integer.valueOf(this.fYC), Integer.valueOf(i), Integer.valueOf(i2), Boolean.FALSE);
                }
            }
        }
        this.fYL = this.fYN.alK();
        int i3 = 0;
        if (this.fYv) {
            i3 = MP4MuxerJNI.writeYuvDataForSegmentLock(bArr, alJ.x, alJ.y, this.fYD, this.fYE, this.fYL, i, i2);
            ab.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", Long.valueOf(bo.az(yz)));
        }
        if (i3 < 0) {
            ab.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", Integer.valueOf(i3));
        }
        if (this.fYv) {
            if (this.fYF == null) {
                MP4MuxerJNI.initH264EncoderLock(this.fYB, this.fYC, (float) this.fYK.fps, this.fYK.videoBitrate, this.fYK.fzV, 8, this.fYK.fzU, 23.0f);
                this.fYF = new b(this, (byte) 0);
                this.fYG = d.h(this.fYF, "MediaCodecFFMpegTranscoder_Encoder");
                this.fYG.start();
                ab.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", Boolean.valueOf(this.fYv));
            }
        } else if (this.fYH == null) {
            this.fYH = new c(this.fYB, this.fYC, this.fYK.videoBitrate, this.fYK.fps);
            this.fYH.fXU = new com.tencent.mm.bj.c.a() {
                public final void a(int i, ByteBuffer byteBuffer, int i2) {
                    AppMethodBeat.i(50944);
                    MP4MuxerJNI.writeH264DataLock(i, byteBuffer, i2);
                    AppMethodBeat.o(50944);
                }
            };
            try {
                i3 = this.fYH.mq(this.eTa);
                ab.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", Integer.valueOf(i3));
                c cVar = this.fYH;
                ab.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
                cVar.cFy = true;
                if (this.fYI == null) {
                    this.fYI = d.ek("remuxer_encode", -2);
                    this.fYI.start();
                    this.fYJ = new a(this.fYI.getLooper());
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VideoTranscoder", e, "init mediaCodecEncoder error: %s", e.getMessage());
            }
            ab.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", Boolean.valueOf(this.fYv));
        }
        if (!(this.fYv || this.fYJ == null)) {
            Message obtain = Message.obtain();
            obtain.what = fYQ;
            byte[] g = b.fXS.g(Integer.valueOf(bArr.length));
            if (g != null) {
                System.arraycopy(bArr, 0, g, 0, bArr.length);
            }
            obtain.obj = g;
            obtain.arg1 = z ? 1 : 0;
            obtain.arg2 = (int) j;
            this.fYJ.sendMessage(obtain);
        }
        AppMethodBeat.o(50955);
    }
}
