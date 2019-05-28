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
import com.google.android.exoplayer2.drm.C41600b;
import com.google.android.exoplayer2.drm.C44648d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p100b.C32021d;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C37265i;
import com.google.android.exoplayer2.p111i.C41619t;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.p797e.C17652c;
import com.google.android.exoplayer2.p797e.C17653d;
import com.google.android.exoplayer2.p797e.C44649b;
import com.google.android.exoplayer2.p797e.C45029a;
import com.google.android.exoplayer2.video.C17693e.C0886a;
import com.google.android.exoplayer2.video.C17693e.C0886a.C08893;
import com.google.android.exoplayer2.video.C17693e.C0886a.C08912;
import com.google.android.exoplayer2.video.C17693e.C0886a.C08931;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.video.c */
public final class C37285c extends C44649b {
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
    C8720b bsG;
    private long bsH;
    private int bsI;
    private final C17691d bsg;
    private final C0886a bsh;
    private final long bsi;
    private final int bsj = 50;
    private final boolean bsk;
    private final long[] bsl;
    private Format[] bsm;
    private C25562a bsn;
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
    /* renamed from: com.google.android.exoplayer2.video.c$b */
    final class C8720b implements OnFrameRenderedListener {
        /* synthetic */ C8720b(C37285c c37285c, MediaCodec mediaCodec, byte b) {
            this(mediaCodec);
        }

        private C8720b(MediaCodec mediaCodec) {
            AppMethodBeat.m2504i(95996);
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
            AppMethodBeat.m2505o(95996);
        }

        public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            AppMethodBeat.m2504i(95997);
            if (this != C37285c.this.bsG) {
                AppMethodBeat.m2505o(95997);
                return;
            }
            C37285c.this.mo59554tU();
            AppMethodBeat.m2505o(95997);
        }
    }

    /* renamed from: com.google.android.exoplayer2.video.c$a */
    protected static final class C25562a {
        public final int bsJ;
        public final int height;
        public final int width;

        public C25562a(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.bsJ = i3;
        }
    }

    public C37285c(Context context, C17652c c17652c, long j, C41600b<C44648d> c41600b, Handler handler, C17693e c17693e) {
        boolean z = false;
        super(2, c17652c, c41600b, false);
        AppMethodBeat.m2504i(95998);
        this.bsi = j;
        this.context = context.getApplicationContext();
        this.bsg = new C17691d(context);
        this.bsh = new C0886a(handler, c17693e);
        if (C17675v.SDK_INT <= 22 && "foster".equals(C17675v.DEVICE) && "NVIDIA".equals(C17675v.MANUFACTURER)) {
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
        m62602tV();
        AppMethodBeat.m2505o(95998);
    }

    /* renamed from: a */
    public final int mo59458a(C17652c c17652c, Format format) {
        int i = 0;
        AppMethodBeat.m2504i(95999);
        String str = format.aOd;
        if (C37265i.m62523aI(str)) {
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
            C45029a e = c17652c.mo19161e(str, z);
            if (e == null) {
                AppMethodBeat.m2505o(95999);
                return 1;
            }
            boolean z2;
            String str2 = format.aOa;
            if (str2 == null || e.mimeType == null) {
                z2 = true;
            } else {
                String aK = C37265i.m62525aK(str2);
                if (aK == null) {
                    z2 = true;
                } else if (e.mimeType.equals(aK)) {
                    Pair ay = C17653d.m27503ay(str2);
                    if (ay == null) {
                        z2 = true;
                    } else {
                        for (CodecProfileLevel codecProfileLevel : e.mo72546rD()) {
                            if (codecProfileLevel.profile == ((Integer) ay.first).intValue() && codecProfileLevel.level >= ((Integer) ay.second).intValue()) {
                                z2 = true;
                                break;
                            }
                        }
                        e.mo72545ax("codec.profileLevel, " + str2 + ", " + aK);
                        z2 = false;
                    }
                } else {
                    e.mo72545ax("codec.mime " + str2 + ", " + aK);
                    z2 = false;
                }
            }
            if (z2 && format.width > 0 && format.height > 0) {
                if (C17675v.SDK_INT >= 21) {
                    z2 = e.mo72544a(format.width, format.height, (double) format.aOh);
                } else {
                    if (format.width * format.height <= C17653d.m27508rK()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        new StringBuilder("FalseCheck [legacyFrameSize, ").append(format.width).append(VideoMaterialUtil.CRAZYFACE_X).append(format.height).append("] [").append(C17675v.brM).append("]");
                    }
                }
            }
            int i3 = e.bdX ? 16 : 8;
            if (e.aQR) {
                i = 32;
            }
            i = (i | i3) | (z2 ? 4 : 3);
            AppMethodBeat.m2505o(95999);
            return i;
        }
        AppMethodBeat.m2505o(95999);
        return 0;
    }

    /* renamed from: aD */
    public final void mo59462aD(boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(96000);
        super.mo59462aD(z);
        this.aOF = this.aMs.aOF;
        if (this.aOF != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.aQR = z2;
        C0886a c0886a = this.bsh;
        C32021d c32021d = this.beI;
        if (c0886a.btb != null) {
            c0886a.handler.post(new C08931(c32021d));
        }
        C17691d c17691d = this.bsg;
        c17691d.bsS = false;
        if (c17691d.bsM) {
            c17691d.bsL.handler.sendEmptyMessage(1);
        }
        AppMethodBeat.m2505o(96000);
    }

    /* renamed from: a */
    public final void mo32348a(Format[] formatArr, long j) {
        AppMethodBeat.m2504i(96001);
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
        super.mo32348a(formatArr, j);
        AppMethodBeat.m2505o(96001);
    }

    /* renamed from: b */
    public final void mo32349b(long j, boolean z) {
        AppMethodBeat.m2504i(96002);
        super.mo32349b(j, z);
        m62601tT();
        this.bsv = 0;
        if (this.bsI != 0) {
            this.bsH = this.bsl[this.bsI - 1];
            this.bsI = 0;
        }
        if (z) {
            m62600tS();
            AppMethodBeat.m2505o(96002);
            return;
        }
        this.bss = -9223372036854775807L;
        AppMethodBeat.m2505o(96002);
    }

    public final boolean isReady() {
        AppMethodBeat.m2504i(96003);
        if (super.isReady() && (this.bsr || ((this.bsp != null && this.aOO == this.bsp) || this.bek == null || this.aQR))) {
            this.bss = -9223372036854775807L;
            AppMethodBeat.m2505o(96003);
            return true;
        } else if (this.bss == -9223372036854775807L) {
            AppMethodBeat.m2505o(96003);
            return false;
        } else if (SystemClock.elapsedRealtime() < this.bss) {
            AppMethodBeat.m2505o(96003);
            return true;
        } else {
            this.bss = -9223372036854775807L;
            AppMethodBeat.m2505o(96003);
            return false;
        }
    }

    public final void onStarted() {
        AppMethodBeat.m2504i(96004);
        super.onStarted();
        this.bsu = 0;
        this.bst = SystemClock.elapsedRealtime();
        AppMethodBeat.m2505o(96004);
    }

    public final void onStopped() {
        AppMethodBeat.m2504i(96005);
        this.bss = -9223372036854775807L;
        m62605tY();
        super.onStopped();
        AppMethodBeat.m2505o(96005);
    }

    /* renamed from: pK */
    public final void mo32353pK() {
        AppMethodBeat.m2504i(96006);
        this.bsy = -1;
        this.bsz = -1;
        this.bsB = -1.0f;
        this.bsx = -1.0f;
        this.bsH = -9223372036854775807L;
        this.bsI = 0;
        m62602tV();
        m62601tT();
        C17691d c17691d = this.bsg;
        if (c17691d.bsM) {
            c17691d.bsL.handler.sendEmptyMessage(2);
        }
        this.bsG = null;
        this.aQR = false;
        try {
            super.mo32353pK();
        } finally {
            this.bsh.mo2648e(this.beI);
            AppMethodBeat.m2505o(96006);
        }
    }

    /* renamed from: c */
    public final void mo59463c(int i, Object obj) {
        AppMethodBeat.m2504i(96007);
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                if (this.bsp != null) {
                    surface = this.bsp;
                } else {
                    C45029a c45029a = this.bel;
                    if (c45029a != null && m62593aN(c45029a.bdY)) {
                        this.bsp = DummySurface.m15486h(this.context, c45029a.bdY);
                        surface = this.bsp;
                    }
                }
            }
            if (this.aOO != surface) {
                this.aOO = surface;
                int i2 = this.state;
                if (i2 == 1 || i2 == 2) {
                    MediaCodec mediaCodec = this.bek;
                    if (C17675v.SDK_INT < 23 || mediaCodec == null || surface == null || this.bso) {
                        mo59552rF();
                        mo71688rE();
                    } else {
                        mediaCodec.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.bsp) {
                    m62602tV();
                    m62601tT();
                } else {
                    m62604tX();
                    m62601tT();
                    if (i2 == 2) {
                        m62600tS();
                        AppMethodBeat.m2505o(96007);
                        return;
                    }
                }
                AppMethodBeat.m2505o(96007);
                return;
            }
            if (!(surface == null || surface == this.bsp)) {
                m62604tX();
                if (this.bsr) {
                    this.bsh.mo2647d(this.aOO);
                }
            }
            AppMethodBeat.m2505o(96007);
        } else if (i == 4) {
            this.bsq = ((Integer) obj).intValue();
            MediaCodec mediaCodec2 = this.bek;
            if (mediaCodec2 != null) {
                mediaCodec2.setVideoScalingMode(this.bsq);
            }
            AppMethodBeat.m2505o(96007);
        } else {
            super.mo59463c(i, obj);
            AppMethodBeat.m2505o(96007);
        }
    }

    /* renamed from: a */
    public final boolean mo59550a(C45029a c45029a) {
        AppMethodBeat.m2504i(96008);
        if (this.aOO != null || m62593aN(c45029a.bdY)) {
            AppMethodBeat.m2505o(96008);
            return true;
        }
        AppMethodBeat.m2505o(96008);
        return false;
    }

    /* renamed from: a */
    public final void mo59460a(C45029a c45029a, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        C25562a c25562a;
        AppMethodBeat.m2504i(96009);
        Format[] formatArr = this.bsm;
        int i = format.width;
        int i2 = format.height;
        int l = C37285c.m62598l(format);
        if (formatArr.length == 1) {
            c25562a = new C25562a(i, i2, l);
        } else {
            int i3 = 0;
            int length = formatArr.length;
            int i4 = 0;
            while (i4 < length) {
                int i5;
                Format format2 = formatArr[i4];
                if (C37285c.m62597b(c45029a.bdX, format, format2)) {
                    i5 = (format2.width == -1 || format2.height == -1) ? 1 : 0;
                    i5 |= i3;
                    i = Math.max(i, format2.width);
                    i2 = Math.max(i2, format2.height);
                    l = Math.max(l, C37285c.m62598l(format2));
                } else {
                    i5 = i3;
                }
                i4++;
                i3 = i5;
            }
            if (i3 != 0) {
                new StringBuilder("Resolutions unknown. Codec max resolution: ").append(i).append(VideoMaterialUtil.CRAZYFACE_X).append(i2);
                Point a = C37285c.m62590a(c45029a, format);
                if (a != null) {
                    i = Math.max(i, a.x);
                    i2 = Math.max(i2, a.y);
                    l = Math.max(l, C37285c.m62595b(format.aOd, i, i2));
                    new StringBuilder("Codec max resolution adjusted to: ").append(i).append(VideoMaterialUtil.CRAZYFACE_X).append(i2);
                }
            }
            c25562a = new C25562a(i, i2, l);
        }
        this.bsn = c25562a;
        c25562a = this.bsn;
        boolean z = this.bsk;
        l = this.aOF;
        MediaFormat qc = format.mo19121qc();
        qc.setInteger("max-width", c25562a.width);
        qc.setInteger("max-height", c25562a.height);
        if (c25562a.bsJ != -1) {
            qc.setInteger("max-input-size", c25562a.bsJ);
        }
        if (z) {
            qc.setInteger("auto-frc", 0);
        }
        if (l != 0) {
            qc.setFeatureEnabled("tunneled-playback", true);
            qc.setInteger("audio-session-id", l);
        }
        if (this.aOO == null) {
            C45039a.checkState(m62593aN(c45029a.bdY));
            if (this.bsp == null) {
                this.bsp = DummySurface.m15486h(this.context, c45029a.bdY);
            }
            this.aOO = this.bsp;
        }
        mediaCodec.configure(qc, this.aOO, mediaCrypto, 0);
        if (C17675v.SDK_INT >= 23 && this.aQR) {
            this.bsG = new C8720b(this, mediaCodec, (byte) 0);
        }
        AppMethodBeat.m2505o(96009);
    }

    /* renamed from: rF */
    public final void mo59552rF() {
        AppMethodBeat.m2504i(96010);
        try {
            super.mo59552rF();
            if (this.bsp != null) {
                if (this.aOO == this.bsp) {
                    this.aOO = null;
                }
                this.bsp.release();
                this.bsp = null;
                AppMethodBeat.m2505o(96010);
                return;
            }
            AppMethodBeat.m2505o(96010);
        } catch (Throwable th) {
            if (this.bsp != null) {
                if (this.aOO == this.bsp) {
                    this.aOO = null;
                }
                this.bsp.release();
                this.bsp = null;
            }
            AppMethodBeat.m2505o(96010);
        }
    }

    /* renamed from: c */
    public final void mo59464c(String str, long j, long j2) {
        boolean z;
        AppMethodBeat.m2504i(96011);
        C0886a c0886a = this.bsh;
        if (c0886a.btb != null) {
            c0886a.handler.post(new C08912(str, j, j2));
        }
        if ((("deb".equals(C17675v.DEVICE) || "flo".equals(C17675v.DEVICE)) && "OMX.qcom.video.decoder.avc".equals(str)) || ("tcl_eu".equals(C17675v.DEVICE) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
            z = true;
        } else {
            z = false;
        }
        this.bso = z;
        AppMethodBeat.m2505o(96011);
    }

    /* renamed from: e */
    public final void mo59465e(Format format) {
        float f;
        AppMethodBeat.m2504i(96012);
        super.mo59465e(format);
        C0886a c0886a = this.bsh;
        if (c0886a.btb != null) {
            c0886a.handler.post(new C08893(format));
        }
        if (format.aOj == -1.0f) {
            f = 1.0f;
        } else {
            f = format.aOj;
        }
        this.bsx = f;
        this.bsw = C37285c.m62599m(format);
        AppMethodBeat.m2505o(96012);
    }

    /* renamed from: rH */
    public final void mo59553rH() {
        AppMethodBeat.m2504i(96013);
        if (C17675v.SDK_INT < 23 && this.aQR) {
            mo59554tU();
        }
        AppMethodBeat.m2505o(96013);
    }

    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        AppMethodBeat.m2504i(96014);
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
        if (C17675v.SDK_INT < 21) {
            this.bsA = this.bsw;
        } else if (this.bsw == 90 || this.bsw == 270) {
            integer = this.bsy;
            this.bsy = this.bsz;
            this.bsz = integer;
            this.bsB = 1.0f / this.bsB;
        }
        mediaCodec.setVideoScalingMode(this.bsq);
        AppMethodBeat.m2505o(96014);
    }

    /* renamed from: a */
    public final boolean mo59551a(boolean z, Format format, Format format2) {
        AppMethodBeat.m2504i(96015);
        if (!C37285c.m62597b(z, format, format2) || format2.width > this.bsn.width || format2.height > this.bsn.height || C37285c.m62598l(format2) > this.bsn.bsJ) {
            AppMethodBeat.m2505o(96015);
            return false;
        }
        AppMethodBeat.m2505o(96015);
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
    /* renamed from: a */
    public final boolean mo59461a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        AppMethodBeat.m2504i(96016);
        while (this.bsI != 0 && j3 >= this.bsl[0]) {
            this.bsH = this.bsl[0];
            this.bsI--;
            System.arraycopy(this.bsl, 1, this.bsl, 0, this.bsI);
        }
        if (z) {
            m62591a(mediaCodec, i);
            AppMethodBeat.m2505o(96016);
            return true;
        }
        long j4 = j3 - j;
        if (this.aOO == this.bsp) {
            if (C37285c.m62594as(j4)) {
                m62591a(mediaCodec, i);
                AppMethodBeat.m2505o(96016);
                return true;
            }
            AppMethodBeat.m2505o(96016);
            return false;
        } else if (!this.bsr) {
            if (C17675v.SDK_INT >= 21) {
                m62592a(mediaCodec, i, System.nanoTime());
            } else {
                m62596b(mediaCodec, i);
            }
            AppMethodBeat.m2505o(96016);
            return true;
        } else if (this.state != 2) {
            AppMethodBeat.m2505o(96016);
            return false;
        } else {
            long j5;
            j4 -= (SystemClock.elapsedRealtime() * 1000) - j2;
            long nanoTime = System.nanoTime();
            long j6 = nanoTime + (j4 * 1000);
            C17691d c17691d = this.bsg;
            long j7 = j3 * 1000;
            if (c17691d.bsS) {
                if (j3 != c17691d.bsP) {
                    c17691d.bsV++;
                    c17691d.bsQ = c17691d.bsR;
                }
                if (c17691d.bsV >= 6) {
                    j5 = c17691d.bsQ + ((j7 - c17691d.bsU) / c17691d.bsV);
                    if (c17691d.mo32391m(j5, j6)) {
                        c17691d.bsS = false;
                        j4 = j6;
                        j5 = j7;
                    } else {
                        j4 = (c17691d.bsT + j5) - c17691d.bsU;
                    }
                    if (!c17691d.bsS) {
                        c17691d.bsU = j7;
                        c17691d.bsT = j6;
                        c17691d.bsV = 0;
                        c17691d.bsS = true;
                    }
                    c17691d.bsP = j3;
                    c17691d.bsR = j5;
                    if (!(c17691d.bsL == null || c17691d.bsL.bsW == 0)) {
                        j6 = c17691d.bsL.bsW;
                        j5 = c17691d.bsN;
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
                        j4 -= c17691d.bsO;
                    }
                    j6 = (j4 - nanoTime) / 1000;
                    if (C37285c.m62594as(j6)) {
                        if (C17675v.SDK_INT >= 21) {
                            if (j6 < 50000) {
                                m62592a(mediaCodec, i, j4);
                                AppMethodBeat.m2505o(96016);
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
                            m62596b(mediaCodec, i);
                            AppMethodBeat.m2505o(96016);
                            return true;
                        }
                        AppMethodBeat.m2505o(96016);
                        return false;
                    }
                    C41619t.beginSection("dropVideoBuffer");
                    mediaCodec.releaseOutputBuffer(i, false);
                    C41619t.endSection();
                    C32021d c32021d = this.beI;
                    c32021d.aSh++;
                    this.bsu++;
                    this.bsv++;
                    this.beI.aSi = Math.max(this.bsv, this.beI.aSi);
                    if (this.bsu == this.bsj) {
                        m62605tY();
                    }
                    AppMethodBeat.m2505o(96016);
                    return true;
                } else if (c17691d.mo32391m(j7, j6)) {
                    c17691d.bsS = false;
                }
            }
            j4 = j6;
            j5 = j7;
            if (c17691d.bsS) {
            }
            c17691d.bsP = j3;
            c17691d.bsR = j5;
            j6 = c17691d.bsL.bsW;
            j5 = c17691d.bsN;
            j7 = (((j4 - j6) / j5) * j5) + j6;
            if (j4 > j7) {
            }
            if (j6 - j4 >= j4 - j5) {
            }
            j4 -= c17691d.bsO;
            j6 = (j4 - nanoTime) / 1000;
            if (C37285c.m62594as(j6)) {
            }
        }
    }

    /* renamed from: a */
    private void m62591a(MediaCodec mediaCodec, int i) {
        AppMethodBeat.m2504i(96017);
        C41619t.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        C41619t.endSection();
        C32021d c32021d = this.beI;
        c32021d.aSg++;
        AppMethodBeat.m2505o(96017);
    }

    /* renamed from: b */
    private void m62596b(MediaCodec mediaCodec, int i) {
        AppMethodBeat.m2504i(96018);
        m62603tW();
        C41619t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        C41619t.endSection();
        C32021d c32021d = this.beI;
        c32021d.aSf++;
        this.bsv = 0;
        mo59554tU();
        AppMethodBeat.m2505o(96018);
    }

    @TargetApi(21)
    /* renamed from: a */
    private void m62592a(MediaCodec mediaCodec, int i, long j) {
        AppMethodBeat.m2504i(96019);
        m62603tW();
        C41619t.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        C41619t.endSection();
        C32021d c32021d = this.beI;
        c32021d.aSf++;
        this.bsv = 0;
        mo59554tU();
        AppMethodBeat.m2505o(96019);
    }

    /* renamed from: aN */
    private boolean m62593aN(boolean z) {
        AppMethodBeat.m2504i(96020);
        if (C17675v.SDK_INT < 23 || this.aQR || (z && !DummySurface.m15485aj(this.context))) {
            AppMethodBeat.m2505o(96020);
            return false;
        }
        AppMethodBeat.m2505o(96020);
        return true;
    }

    /* renamed from: tS */
    private void m62600tS() {
        AppMethodBeat.m2504i(96021);
        this.bss = this.bsi > 0 ? SystemClock.elapsedRealtime() + this.bsi : -9223372036854775807L;
        AppMethodBeat.m2505o(96021);
    }

    /* renamed from: tT */
    private void m62601tT() {
        AppMethodBeat.m2504i(96022);
        this.bsr = false;
        if (C17675v.SDK_INT >= 23 && this.aQR) {
            MediaCodec mediaCodec = this.bek;
            if (mediaCodec != null) {
                this.bsG = new C8720b(this, mediaCodec, (byte) 0);
            }
        }
        AppMethodBeat.m2505o(96022);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: tU */
    public final void mo59554tU() {
        AppMethodBeat.m2504i(96023);
        if (!this.bsr) {
            this.bsr = true;
            this.bsh.mo2647d(this.aOO);
        }
        AppMethodBeat.m2505o(96023);
    }

    /* renamed from: tV */
    private void m62602tV() {
        this.bsC = -1;
        this.bsD = -1;
        this.bsF = -1.0f;
        this.bsE = -1;
    }

    /* renamed from: tW */
    private void m62603tW() {
        AppMethodBeat.m2504i(96024);
        if (!((this.bsy == -1 && this.bsz == -1) || (this.bsC == this.bsy && this.bsD == this.bsz && this.bsE == this.bsA && this.bsF == this.bsB))) {
            this.bsh.mo2646c(this.bsy, this.bsz, this.bsA, this.bsB);
            this.bsC = this.bsy;
            this.bsD = this.bsz;
            this.bsE = this.bsA;
            this.bsF = this.bsB;
        }
        AppMethodBeat.m2505o(96024);
    }

    /* renamed from: tX */
    private void m62604tX() {
        AppMethodBeat.m2504i(96025);
        if (!(this.bsC == -1 && this.bsD == -1)) {
            this.bsh.mo2646c(this.bsC, this.bsD, this.bsE, this.bsF);
        }
        AppMethodBeat.m2505o(96025);
    }

    /* renamed from: tY */
    private void m62605tY() {
        AppMethodBeat.m2504i(96026);
        if (this.bsu > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.bsh.mo2649k(this.bsu, elapsedRealtime - this.bst);
            this.bsu = 0;
            this.bst = elapsedRealtime;
        }
        AppMethodBeat.m2505o(96026);
    }

    /* renamed from: as */
    private static boolean m62594as(long j) {
        return j < -30000;
    }

    /* renamed from: a */
    private static Point m62590a(C45029a c45029a, Format format) {
        AppMethodBeat.m2504i(96027);
        Object obj = format.height > format.width ? 1 : null;
        int i = obj != null ? format.height : format.width;
        int i2 = obj != null ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : bsf) {
            int i32;
            int i4 = (int) (((float) i32) * f);
            if (i32 <= i || i4 <= i2) {
                AppMethodBeat.m2505o(96027);
                return null;
            }
            if (C17675v.SDK_INT >= 21) {
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
                if (c45029a.bdZ == null) {
                    c45029a.mo72545ax("align.caps");
                    point = null;
                } else {
                    VideoCapabilities videoCapabilities = c45029a.bdZ.getVideoCapabilities();
                    if (videoCapabilities == null) {
                        c45029a.mo72545ax("align.vCaps");
                        point = null;
                    } else {
                        int widthAlignment = videoCapabilities.getWidthAlignment();
                        int heightAlignment = videoCapabilities.getHeightAlignment();
                        point = new Point(C17675v.m27565bi(i5, widthAlignment) * widthAlignment, C17675v.m27565bi(i32, heightAlignment) * heightAlignment);
                    }
                }
                if (c45029a.mo72544a(point.x, point.y, (double) format.aOh)) {
                    AppMethodBeat.m2505o(96027);
                    return point;
                }
            } else {
                i32 = C17675v.m27565bi(i32, 16) * 16;
                i4 = C17675v.m27565bi(i4, 16) * 16;
                if (i32 * i4 <= C17653d.m27508rK()) {
                    Point point2 = new Point(obj != null ? i4 : i32, obj != null ? i32 : i4);
                    AppMethodBeat.m2505o(96027);
                    return point2;
                }
            }
        }
        AppMethodBeat.m2505o(96027);
        return null;
    }

    /* renamed from: l */
    private static int m62598l(Format format) {
        AppMethodBeat.m2504i(96028);
        int i;
        if (format.aOe != -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < format.aOf.size(); i3++) {
                i2 += ((byte[]) format.aOf.get(i3)).length;
            }
            i = format.aOe + i2;
            AppMethodBeat.m2505o(96028);
            return i;
        }
        i = C37285c.m62595b(format.aOd, format.width, format.height);
        AppMethodBeat.m2505o(96028);
        return i;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static int m62595b(String str, int i, int i2) {
        int i3 = 2;
        AppMethodBeat.m2504i(96029);
        if (i == -1 || i2 == -1) {
            AppMethodBeat.m2505o(96029);
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
                if (!"BRAVIA 4K 2015".equals(C17675v.MODEL)) {
                    i5 = ((C17675v.m27565bi(i, 16) * C17675v.m27565bi(i2, 16)) * 16) * 16;
                    break;
                }
                AppMethodBeat.m2505o(96029);
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
                AppMethodBeat.m2505o(96029);
                return -1;
        }
        i3 = (i5 * 3) / (i3 * 2);
        AppMethodBeat.m2505o(96029);
        return i3;
    }

    /* renamed from: b */
    private static boolean m62597b(boolean z, Format format, Format format2) {
        AppMethodBeat.m2504i(96030);
        if (format.aOd.equals(format2.aOd) && C37285c.m62599m(format) == C37285c.m62599m(format2) && (z || (format.width == format2.width && format.height == format2.height))) {
            AppMethodBeat.m2505o(96030);
            return true;
        }
        AppMethodBeat.m2505o(96030);
        return false;
    }

    /* renamed from: m */
    private static int m62599m(Format format) {
        return format.aOi == -1 ? 0 : format.aOi;
    }
}
