package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.video.e.a.AnonymousClass1;
import com.google.android.exoplayer2.video.e.a.AnonymousClass2;
import com.google.android.exoplayer2.video.e.a.AnonymousClass3;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class c extends com.google.android.exoplayer2.e.b {
    private static final int[] bsf = new int[]{1920, 1600, 1440, ActUtil.HEIGHT, VideoFilterUtil.IMAGE_HEIGHT, DeviceUtils.LAZY_HEIGHT, 640, 540, 480};
    private int aOF;
    private Surface aOO;
    private boolean aQR;
    private int bsA;
    private float bsB;
    private int bsC;
    private int bsD;
    private int bsE;
    private float bsF;
    b bsG;
    private long bsH;
    private int bsI;
    private final d bsg;
    private final com.google.android.exoplayer2.video.e.a bsh;
    private final long bsi;
    private final int bsj = 50;
    private final boolean bsk;
    private final long[] bsl;
    private Format[] bsm;
    private a bsn;
    private boolean bso;
    private Surface bsp;
    private int bsq;
    private boolean bsr;
    private long bss;
    private long bst;
    private int bsu;
    private int bsv;
    private int bsw;
    private float bsx;
    private int bsy;
    private int bsz;
    private final Context context;

    @TargetApi(23)
    final class b implements OnFrameRenderedListener {
        /* synthetic */ b(c cVar, MediaCodec mediaCodec, byte b) {
            this(mediaCodec);
        }

        private b(MediaCodec mediaCodec) {
            AppMethodBeat.i(95996);
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
            AppMethodBeat.o(95996);
        }

        public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            AppMethodBeat.i(95997);
            if (this != c.this.bsG) {
                AppMethodBeat.o(95997);
                return;
            }
            c.this.tU();
            AppMethodBeat.o(95997);
        }
    }

    protected static final class a {
        public final int bsJ;
        public final int height;
        public final int width;

        public a(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.bsJ = i3;
        }
    }

    public c(Context context, com.google.android.exoplayer2.e.c cVar, long j, com.google.android.exoplayer2.drm.b<d> bVar, Handler handler, e eVar) {
        boolean z = false;
        super(2, cVar, bVar, false);
        AppMethodBeat.i(95998);
        this.bsi = j;
        this.context = context.getApplicationContext();
        this.bsg = new d(context);
        this.bsh = new com.google.android.exoplayer2.video.e.a(handler, eVar);
        if (v.SDK_INT <= 22 && "foster".equals(v.DEVICE) && "NVIDIA".equals(v.MANUFACTURER)) {
            z = true;
        }
        this.bsk = z;
        this.bsl = new long[10];
        this.bsH = -9223372036854775807L;
        this.bss = -9223372036854775807L;
        this.bsy = -1;
        this.bsz = -1;
        this.bsB = -1.0f;
        this.bsx = -1.0f;
        this.bsq = 1;
        tV();
        AppMethodBeat.o(95998);
    }

    public final int a(com.google.android.exoplayer2.e.c cVar, Format format) {
        int i = 0;
        AppMethodBeat.i(95999);
        String str = format.aOd;
        if (i.aI(str)) {
            boolean z;
            DrmInitData drmInitData = format.aOg;
            if (drmInitData != null) {
                z = false;
                for (int i2 = 0; i2 < drmInitData.aSx; i2++) {
                    z |= drmInitData.aSw[i2].aSy;
                }
            } else {
                z = false;
            }
            com.google.android.exoplayer2.e.a e = cVar.e(str, z);
            if (e == null) {
                AppMethodBeat.o(95999);
                return 1;
            }
            boolean z2;
            String str2 = format.aOa;
            if (str2 == null || e.mimeType == null) {
                z2 = true;
            } else {
                String aK = i.aK(str2);
                if (aK == null) {
                    z2 = true;
                } else if (e.mimeType.equals(aK)) {
                    Pair ay = com.google.android.exoplayer2.e.d.ay(str2);
                    if (ay == null) {
                        z2 = true;
                    } else {
                        for (CodecProfileLevel codecProfileLevel : e.rD()) {
                            if (codecProfileLevel.profile == ((Integer) ay.first).intValue() && codecProfileLevel.level >= ((Integer) ay.second).intValue()) {
                                z2 = true;
                                break;
                            }
                        }
                        e.ax("codec.profileLevel, " + str2 + ", " + aK);
                        z2 = false;
                    }
                } else {
                    e.ax("codec.mime " + str2 + ", " + aK);
                    z2 = false;
                }
            }
            if (z2 && format.width > 0 && format.height > 0) {
                if (v.SDK_INT >= 21) {
                    z2 = e.a(format.width, format.height, (double) format.aOh);
                } else {
                    if (format.width * format.height <= com.google.android.exoplayer2.e.d.rK()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        new StringBuilder("FalseCheck [legacyFrameSize, ").append(format.width).append(VideoMaterialUtil.CRAZYFACE_X).append(format.height).append("] [").append(v.brM).append("]");
                    }
                }
            }
            int i3 = e.bdX ? 16 : 8;
            if (e.aQR) {
                i = 32;
            }
            i = (i | i3) | (z2 ? 4 : 3);
            AppMethodBeat.o(95999);
            return i;
        }
        AppMethodBeat.o(95999);
        return 0;
    }

    public final void aD(boolean z) {
        boolean z2;
        AppMethodBeat.i(96000);
        super.aD(z);
        this.aOF = this.aMs.aOF;
        if (this.aOF != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.aQR = z2;
        com.google.android.exoplayer2.video.e.a aVar = this.bsh;
        com.google.android.exoplayer2.b.d dVar = this.beI;
        if (aVar.btb != null) {
            aVar.handler.post(new AnonymousClass1(dVar));
        }
        d dVar2 = this.bsg;
        dVar2.bsS = false;
        if (dVar2.bsM) {
            dVar2.bsL.handler.sendEmptyMessage(1);
        }
        AppMethodBeat.o(96000);
    }

    public final void a(Format[] formatArr, long j) {
        AppMethodBeat.i(96001);
        this.bsm = formatArr;
        if (this.bsH == -9223372036854775807L) {
            this.bsH = j;
        } else {
            if (this.bsI == this.bsl.length) {
                new StringBuilder("Too many stream changes, so dropping offset: ").append(this.bsl[this.bsI - 1]);
            } else {
                this.bsI++;
            }
            this.bsl[this.bsI - 1] = j;
        }
        super.a(formatArr, j);
        AppMethodBeat.o(96001);
    }

    public final void b(long j, boolean z) {
        AppMethodBeat.i(96002);
        super.b(j, z);
        tT();
        this.bsv = 0;
        if (this.bsI != 0) {
            this.bsH = this.bsl[this.bsI - 1];
            this.bsI = 0;
        }
        if (z) {
            tS();
            AppMethodBeat.o(96002);
            return;
        }
        this.bss = -9223372036854775807L;
        AppMethodBeat.o(96002);
    }

    public final boolean isReady() {
        AppMethodBeat.i(96003);
        if (super.isReady() && (this.bsr || ((this.bsp != null && this.aOO == this.bsp) || this.bek == null || this.aQR))) {
            this.bss = -9223372036854775807L;
            AppMethodBeat.o(96003);
            return true;
        } else if (this.bss == -9223372036854775807L) {
            AppMethodBeat.o(96003);
            return false;
        } else if (SystemClock.elapsedRealtime() < this.bss) {
            AppMethodBeat.o(96003);
            return true;
        } else {
            this.bss = -9223372036854775807L;
            AppMethodBeat.o(96003);
            return false;
        }
    }

    public final void onStarted() {
        AppMethodBeat.i(96004);
        super.onStarted();
        this.bsu = 0;
        this.bst = SystemClock.elapsedRealtime();
        AppMethodBeat.o(96004);
    }

    public final void onStopped() {
        AppMethodBeat.i(96005);
        this.bss = -9223372036854775807L;
        tY();
        super.onStopped();
        AppMethodBeat.o(96005);
    }

    public final void pK() {
        AppMethodBeat.i(96006);
        this.bsy = -1;
        this.bsz = -1;
        this.bsB = -1.0f;
        this.bsx = -1.0f;
        this.bsH = -9223372036854775807L;
        this.bsI = 0;
        tV();
        tT();
        d dVar = this.bsg;
        if (dVar.bsM) {
            dVar.bsL.handler.sendEmptyMessage(2);
        }
        this.bsG = null;
        this.aQR = false;
        try {
            super.pK();
        } finally {
            this.bsh.e(this.beI);
            AppMethodBeat.o(96006);
        }
    }

    public final void c(int i, Object obj) {
        AppMethodBeat.i(96007);
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                if (this.bsp != null) {
                    surface = this.bsp;
                } else {
                    com.google.android.exoplayer2.e.a aVar = this.bel;
                    if (aVar != null && aN(aVar.bdY)) {
                        this.bsp = DummySurface.h(this.context, aVar.bdY);
                        surface = this.bsp;
                    }
                }
            }
            if (this.aOO != surface) {
                this.aOO = surface;
                int i2 = this.state;
                if (i2 == 1 || i2 == 2) {
                    MediaCodec mediaCodec = this.bek;
                    if (v.SDK_INT < 23 || mediaCodec == null || surface == null || this.bso) {
                        rF();
                        rE();
                    } else {
                        mediaCodec.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.bsp) {
                    tV();
                    tT();
                } else {
                    tX();
                    tT();
                    if (i2 == 2) {
                        tS();
                        AppMethodBeat.o(96007);
                        return;
                    }
                }
                AppMethodBeat.o(96007);
                return;
            }
            if (!(surface == null || surface == this.bsp)) {
                tX();
                if (this.bsr) {
                    this.bsh.d(this.aOO);
                }
            }
            AppMethodBeat.o(96007);
        } else if (i == 4) {
            this.bsq = ((Integer) obj).intValue();
            MediaCodec mediaCodec2 = this.bek;
            if (mediaCodec2 != null) {
                mediaCodec2.setVideoScalingMode(this.bsq);
            }
            AppMethodBeat.o(96007);
        } else {
            super.c(i, obj);
            AppMethodBeat.o(96007);
        }
    }

    public final boolean a(com.google.android.exoplayer2.e.a aVar) {
        AppMethodBeat.i(96008);
        if (this.aOO != null || aN(aVar.bdY)) {
            AppMethodBeat.o(96008);
            return true;
        }
        AppMethodBeat.o(96008);
        return false;
    }

    public final void a(com.google.android.exoplayer2.e.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        a aVar2;
        AppMethodBeat.i(96009);
        Format[] formatArr = this.bsm;
        int i = format.width;
        int i2 = format.height;
        int l = l(format);
        if (formatArr.length == 1) {
            aVar2 = new a(i, i2, l);
        } else {
            int i3 = 0;
            int length = formatArr.length;
            int i4 = 0;
            while (i4 < length) {
                int i5;
                Format format2 = formatArr[i4];
                if (b(aVar.bdX, format, format2)) {
                    i5 = (format2.width == -1 || format2.height == -1) ? 1 : 0;
                    i5 |= i3;
                    i = Math.max(i, format2.width);
                    i2 = Math.max(i2, format2.height);
                    l = Math.max(l, l(format2));
                } else {
                    i5 = i3;
                }
                i4++;
                i3 = i5;
            }
            if (i3 != 0) {
                new StringBuilder("Resolutions unknown. Codec max resolution: ").append(i).append(VideoMaterialUtil.CRAZYFACE_X).append(i2);
                Point a = a(aVar, format);
                if (a != null) {
                    i = Math.max(i, a.x);
                    i2 = Math.max(i2, a.y);
                    l = Math.max(l, b(format.aOd, i, i2));
                    new StringBuilder("Codec max resolution adjusted to: ").append(i).append(VideoMaterialUtil.CRAZYFACE_X).append(i2);
                }
            }
            aVar2 = new a(i, i2, l);
        }
        this.bsn = aVar2;
        aVar2 = this.bsn;
        boolean z = this.bsk;
        l = this.aOF;
        MediaFormat qc = format.qc();
        qc.setInteger("max-width", aVar2.width);
        qc.setInteger("max-height", aVar2.height);
        if (aVar2.bsJ != -1) {
            qc.setInteger("max-input-size", aVar2.bsJ);
        }
        if (z) {
            qc.setInteger("auto-frc", 0);
        }
        if (l != 0) {
            qc.setFeatureEnabled("tunneled-playback", true);
            qc.setInteger("audio-session-id", l);
        }
        if (this.aOO == null) {
            com.google.android.exoplayer2.i.a.checkState(aN(aVar.bdY));
            if (this.bsp == null) {
                this.bsp = DummySurface.h(this.context, aVar.bdY);
            }
            this.aOO = this.bsp;
        }
        mediaCodec.configure(qc, this.aOO, mediaCrypto, 0);
        if (v.SDK_INT >= 23 && this.aQR) {
            this.bsG = new b(this, mediaCodec, (byte) 0);
        }
        AppMethodBeat.o(96009);
    }

    public final void rF() {
        AppMethodBeat.i(96010);
        try {
            super.rF();
            if (this.bsp != null) {
                if (this.aOO == this.bsp) {
                    this.aOO = null;
                }
                this.bsp.release();
                this.bsp = null;
                AppMethodBeat.o(96010);
                return;
            }
            AppMethodBeat.o(96010);
        } catch (Throwable th) {
            if (this.bsp != null) {
                if (this.aOO == this.bsp) {
                    this.aOO = null;
                }
                this.bsp.release();
                this.bsp = null;
            }
            AppMethodBeat.o(96010);
        }
    }

    public final void c(String str, long j, long j2) {
        boolean z;
        AppMethodBeat.i(96011);
        com.google.android.exoplayer2.video.e.a aVar = this.bsh;
        if (aVar.btb != null) {
            aVar.handler.post(new AnonymousClass2(str, j, j2));
        }
        if ((("deb".equals(v.DEVICE) || "flo".equals(v.DEVICE)) && "OMX.qcom.video.decoder.avc".equals(str)) || ("tcl_eu".equals(v.DEVICE) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
            z = true;
        } else {
            z = false;
        }
        this.bso = z;
        AppMethodBeat.o(96011);
    }

    public final void e(Format format) {
        float f;
        AppMethodBeat.i(96012);
        super.e(format);
        com.google.android.exoplayer2.video.e.a aVar = this.bsh;
        if (aVar.btb != null) {
            aVar.handler.post(new AnonymousClass3(format));
        }
        if (format.aOj == -1.0f) {
            f = 1.0f;
        } else {
            f = format.aOj;
        }
        this.bsx = f;
        this.bsw = m(format);
        AppMethodBeat.o(96012);
    }

    public final void rH() {
        AppMethodBeat.i(96013);
        if (v.SDK_INT < 23 && this.aQR) {
            tU();
        }
        AppMethodBeat.o(96013);
    }

    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        AppMethodBeat.i(96014);
        Object obj = (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) ? 1 : null;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.bsy = integer;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer = mediaFormat.getInteger("height");
        }
        this.bsz = integer;
        this.bsB = this.bsx;
        if (v.SDK_INT < 21) {
            this.bsA = this.bsw;
        } else if (this.bsw == 90 || this.bsw == 270) {
            integer = this.bsy;
            this.bsy = this.bsz;
            this.bsz = integer;
            this.bsB = 1.0f / this.bsB;
        }
        mediaCodec.setVideoScalingMode(this.bsq);
        AppMethodBeat.o(96014);
    }

    public final boolean a(boolean z, Format format, Format format2) {
        AppMethodBeat.i(96015);
        if (!b(z, format, format2) || format2.width > this.bsn.width || format2.height > this.bsn.height || l(format2) > this.bsn.bsJ) {
            AppMethodBeat.o(96015);
            return false;
        }
        AppMethodBeat.o(96015);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        AppMethodBeat.i(96016);
        while (this.bsI != 0 && j3 >= this.bsl[0]) {
            this.bsH = this.bsl[0];
            this.bsI--;
            System.arraycopy(this.bsl, 1, this.bsl, 0, this.bsI);
        }
        if (z) {
            a(mediaCodec, i);
            AppMethodBeat.o(96016);
            return true;
        }
        long j4 = j3 - j;
        if (this.aOO == this.bsp) {
            if (as(j4)) {
                a(mediaCodec, i);
                AppMethodBeat.o(96016);
                return true;
            }
            AppMethodBeat.o(96016);
            return false;
        } else if (!this.bsr) {
            if (v.SDK_INT >= 21) {
                a(mediaCodec, i, System.nanoTime());
            } else {
                b(mediaCodec, i);
            }
            AppMethodBeat.o(96016);
            return true;
        } else if (this.state != 2) {
            AppMethodBeat.o(96016);
            return false;
        } else {
            long j5;
            j4 -= (SystemClock.elapsedRealtime() * 1000) - j2;
            long nanoTime = System.nanoTime();
            long j6 = nanoTime + (j4 * 1000);
            d dVar = this.bsg;
            long j7 = j3 * 1000;
            if (dVar.bsS) {
                if (j3 != dVar.bsP) {
                    dVar.bsV++;
                    dVar.bsQ = dVar.bsR;
                }
                if (dVar.bsV >= 6) {
                    j5 = dVar.bsQ + ((j7 - dVar.bsU) / dVar.bsV);
                    if (dVar.m(j5, j6)) {
                        dVar.bsS = false;
                        j4 = j6;
                        j5 = j7;
                    } else {
                        j4 = (dVar.bsT + j5) - dVar.bsU;
                    }
                    if (!dVar.bsS) {
                        dVar.bsU = j7;
                        dVar.bsT = j6;
                        dVar.bsV = 0;
                        dVar.bsS = true;
                    }
                    dVar.bsP = j3;
                    dVar.bsR = j5;
                    if (!(dVar.bsL == null || dVar.bsL.bsW == 0)) {
                        j6 = dVar.bsL.bsW;
                        j5 = dVar.bsN;
                        j7 = (((j4 - j6) / j5) * j5) + j6;
                        if (j4 > j7) {
                            j5 = j7 - j5;
                            j6 = j7;
                        } else {
                            j6 = j7 + j5;
                            j5 = j7;
                        }
                        if (j6 - j4 >= j4 - j5) {
                            j4 = j6;
                        } else {
                            j4 = j5;
                        }
                        j4 -= dVar.bsO;
                    }
                    j6 = (j4 - nanoTime) / 1000;
                    if (as(j6)) {
                        if (v.SDK_INT >= 21) {
                            if (j6 < 50000) {
                                a(mediaCodec, i, j4);
                                AppMethodBeat.o(96016);
                                return true;
                            }
                        } else if (j6 < 30000) {
                            if (j6 > 11000) {
                                try {
                                    Thread.sleep((j6 - 10000) / 1000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                            b(mediaCodec, i);
                            AppMethodBeat.o(96016);
                            return true;
                        }
                        AppMethodBeat.o(96016);
                        return false;
                    }
                    t.beginSection("dropVideoBuffer");
                    mediaCodec.releaseOutputBuffer(i, false);
                    t.endSection();
                    com.google.android.exoplayer2.b.d dVar2 = this.beI;
                    dVar2.aSh++;
                    this.bsu++;
                    this.bsv++;
                    this.beI.aSi = Math.max(this.bsv, this.beI.aSi);
                    if (this.bsu == this.bsj) {
                        tY();
                    }
                    AppMethodBeat.o(96016);
                    return true;
                } else if (dVar.m(j7, j6)) {
                    dVar.bsS = false;
                }
            }
            j4 = j6;
            j5 = j7;
            if (dVar.bsS) {
            }
            dVar.bsP = j3;
            dVar.bsR = j5;
            j6 = dVar.bsL.bsW;
            j5 = dVar.bsN;
            j7 = (((j4 - j6) / j5) * j5) + j6;
            if (j4 > j7) {
            }
            if (j6 - j4 >= j4 - j5) {
            }
            j4 -= dVar.bsO;
            j6 = (j4 - nanoTime) / 1000;
            if (as(j6)) {
            }
        }
    }

    private void a(MediaCodec mediaCodec, int i) {
        AppMethodBeat.i(96017);
        t.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.endSection();
        com.google.android.exoplayer2.b.d dVar = this.beI;
        dVar.aSg++;
        AppMethodBeat.o(96017);
    }

    private void b(MediaCodec mediaCodec, int i) {
        AppMethodBeat.i(96018);
        tW();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        t.endSection();
        com.google.android.exoplayer2.b.d dVar = this.beI;
        dVar.aSf++;
        this.bsv = 0;
        tU();
        AppMethodBeat.o(96018);
    }

    @TargetApi(21)
    private void a(MediaCodec mediaCodec, int i, long j) {
        AppMethodBeat.i(96019);
        tW();
        t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        t.endSection();
        com.google.android.exoplayer2.b.d dVar = this.beI;
        dVar.aSf++;
        this.bsv = 0;
        tU();
        AppMethodBeat.o(96019);
    }

    private boolean aN(boolean z) {
        AppMethodBeat.i(96020);
        if (v.SDK_INT < 23 || this.aQR || (z && !DummySurface.aj(this.context))) {
            AppMethodBeat.o(96020);
            return false;
        }
        AppMethodBeat.o(96020);
        return true;
    }

    private void tS() {
        AppMethodBeat.i(96021);
        this.bss = this.bsi > 0 ? SystemClock.elapsedRealtime() + this.bsi : -9223372036854775807L;
        AppMethodBeat.o(96021);
    }

    private void tT() {
        AppMethodBeat.i(96022);
        this.bsr = false;
        if (v.SDK_INT >= 23 && this.aQR) {
            MediaCodec mediaCodec = this.bek;
            if (mediaCodec != null) {
                this.bsG = new b(this, mediaCodec, (byte) 0);
            }
        }
        AppMethodBeat.o(96022);
    }

    /* Access modifiers changed, original: final */
    public final void tU() {
        AppMethodBeat.i(96023);
        if (!this.bsr) {
            this.bsr = true;
            this.bsh.d(this.aOO);
        }
        AppMethodBeat.o(96023);
    }

    private void tV() {
        this.bsC = -1;
        this.bsD = -1;
        this.bsF = -1.0f;
        this.bsE = -1;
    }

    private void tW() {
        AppMethodBeat.i(96024);
        if (!((this.bsy == -1 && this.bsz == -1) || (this.bsC == this.bsy && this.bsD == this.bsz && this.bsE == this.bsA && this.bsF == this.bsB))) {
            this.bsh.c(this.bsy, this.bsz, this.bsA, this.bsB);
            this.bsC = this.bsy;
            this.bsD = this.bsz;
            this.bsE = this.bsA;
            this.bsF = this.bsB;
        }
        AppMethodBeat.o(96024);
    }

    private void tX() {
        AppMethodBeat.i(96025);
        if (!(this.bsC == -1 && this.bsD == -1)) {
            this.bsh.c(this.bsC, this.bsD, this.bsE, this.bsF);
        }
        AppMethodBeat.o(96025);
    }

    private void tY() {
        AppMethodBeat.i(96026);
        if (this.bsu > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.bsh.k(this.bsu, elapsedRealtime - this.bst);
            this.bsu = 0;
            this.bst = elapsedRealtime;
        }
        AppMethodBeat.o(96026);
    }

    private static boolean as(long j) {
        return j < -30000;
    }

    private static Point a(com.google.android.exoplayer2.e.a aVar, Format format) {
        AppMethodBeat.i(96027);
        Object obj = format.height > format.width ? 1 : null;
        int i = obj != null ? format.height : format.width;
        int i2 = obj != null ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : bsf) {
            int i32;
            int i4 = (int) (((float) i32) * f);
            if (i32 <= i || i4 <= i2) {
                AppMethodBeat.o(96027);
                return null;
            }
            if (v.SDK_INT >= 21) {
                int i5;
                Point point;
                if (obj != null) {
                    i5 = i4;
                } else {
                    i5 = i32;
                }
                if (obj == null) {
                    i32 = i4;
                }
                if (aVar.bdZ == null) {
                    aVar.ax("align.caps");
                    point = null;
                } else {
                    VideoCapabilities videoCapabilities = aVar.bdZ.getVideoCapabilities();
                    if (videoCapabilities == null) {
                        aVar.ax("align.vCaps");
                        point = null;
                    } else {
                        int widthAlignment = videoCapabilities.getWidthAlignment();
                        int heightAlignment = videoCapabilities.getHeightAlignment();
                        point = new Point(v.bi(i5, widthAlignment) * widthAlignment, v.bi(i32, heightAlignment) * heightAlignment);
                    }
                }
                if (aVar.a(point.x, point.y, (double) format.aOh)) {
                    AppMethodBeat.o(96027);
                    return point;
                }
            } else {
                i32 = v.bi(i32, 16) * 16;
                i4 = v.bi(i4, 16) * 16;
                if (i32 * i4 <= com.google.android.exoplayer2.e.d.rK()) {
                    Point point2 = new Point(obj != null ? i4 : i32, obj != null ? i32 : i4);
                    AppMethodBeat.o(96027);
                    return point2;
                }
            }
        }
        AppMethodBeat.o(96027);
        return null;
    }

    private static int l(Format format) {
        AppMethodBeat.i(96028);
        int i;
        if (format.aOe != -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < format.aOf.size(); i3++) {
                i2 += ((byte[]) format.aOf.get(i3)).length;
            }
            i = format.aOe + i2;
            AppMethodBeat.o(96028);
            return i;
        }
        i = b(format.aOd, format.width, format.height);
        AppMethodBeat.o(96028);
        return i;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(String str, int i, int i2) {
        int i3 = 2;
        AppMethodBeat.i(96029);
        if (i == -1 || i2 == -1) {
            AppMethodBeat.o(96029);
            return -1;
        }
        int i4;
        int i5;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    i4 = 0;
                    break;
                }
            case -1662541442:
                if (str.equals("video/hevc")) {
                    i4 = 4;
                    break;
                }
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    i4 = 1;
                    break;
                }
            case 1331836730:
                if (str.equals("video/avc")) {
                    i4 = 2;
                    break;
                }
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    i4 = 3;
                    break;
                }
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    i4 = 5;
                    break;
                }
            default:
                i4 = -1;
                break;
        }
        switch (i4) {
            case 0:
            case 1:
                i5 = i * i2;
                break;
            case 2:
                if (!"BRAVIA 4K 2015".equals(v.MODEL)) {
                    i5 = ((v.bi(i, 16) * v.bi(i2, 16)) * 16) * 16;
                    break;
                }
                AppMethodBeat.o(96029);
                return -1;
            case 3:
                i5 = i * i2;
                break;
            case 4:
            case 5:
                i5 = i * i2;
                i3 = 4;
                break;
            default:
                AppMethodBeat.o(96029);
                return -1;
        }
        i3 = (i5 * 3) / (i3 * 2);
        AppMethodBeat.o(96029);
        return i3;
    }

    private static boolean b(boolean z, Format format, Format format2) {
        AppMethodBeat.i(96030);
        if (format.aOd.equals(format2.aOd) && m(format) == m(format2) && (z || (format.width == format2.width && format.height == format2.height))) {
            AppMethodBeat.o(96030);
            return true;
        }
        AppMethodBeat.o(96030);
        return false;
    }

    private static int m(Format format) {
        return format.aOi == -1 ? 0 : format.aOi;
    }
}
