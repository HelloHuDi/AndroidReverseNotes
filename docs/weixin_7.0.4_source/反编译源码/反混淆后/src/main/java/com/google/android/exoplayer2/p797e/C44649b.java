package com.google.android.exoplayer2.p797e;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.C25533e;
import com.google.android.exoplayer2.C41591a;
import com.google.android.exoplayer2.C8692k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.C17650a;
import com.google.android.exoplayer2.drm.C17650a.C17651a;
import com.google.android.exoplayer2.drm.C41600b;
import com.google.android.exoplayer2.drm.C44648d;
import com.google.android.exoplayer2.p100b.C32021d;
import com.google.android.exoplayer2.p100b.C32022e;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C41619t;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.p111i.C45041j;
import com.google.android.exoplayer2.p797e.C17653d.C17654b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.e.b */
public abstract class C44649b extends C41591a {
    private static final byte[] bea = C17675v.m27563aU("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private final C41600b<C44648d> aMJ;
    private Format aOv;
    private ByteBuffer[] aQJ;
    private int beA;
    private int beB;
    private boolean beC;
    private boolean beD;
    private boolean beE;
    private boolean beF;
    private boolean beG;
    private boolean beH;
    protected C32021d beI;
    private final C17652c beb;
    private final boolean bec;
    private final C32022e bed;
    private final C32022e bee;
    private final C8692k bef;
    private final List<Long> beg;
    private final BufferInfo beh;
    private C17650a<C44648d> bei;
    private C17650a<C44648d> bej;
    protected MediaCodec bek;
    protected C45029a bel;
    private int bem;
    private boolean ben;
    private boolean beo;
    private boolean bep;
    private boolean beq;
    private boolean ber;
    private boolean bes;
    private boolean bet;
    private boolean beu;
    private long bev;
    private int bew;
    private int bex;
    private boolean bey;
    private boolean bez;
    private ByteBuffer[] inputBuffers;

    /* renamed from: com.google.android.exoplayer2.e.b$a */
    public static class C32042a extends Exception {
        public final boolean beJ;
        public final String beK;
        public final String beL;
        public final String mimeType;

        public C32042a(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            AppMethodBeat.m2504i(95235);
            this.mimeType = format.aOd;
            this.beJ = z;
            this.beK = null;
            this.beL = "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
            AppMethodBeat.m2505o(95235);
        }

        public C32042a(Format format, Throwable th, boolean z, String str) {
            String str2 = null;
            super("Decoder init failed: " + str + ", " + format, th);
            AppMethodBeat.m2504i(95236);
            this.mimeType = format.aOd;
            this.beJ = z;
            this.beK = str;
            if (C17675v.SDK_INT >= 21 && (th instanceof CodecException)) {
                str2 = ((CodecException) th).getDiagnosticInfo();
            }
            this.beL = str2;
            AppMethodBeat.m2505o(95236);
        }
    }

    /* renamed from: a */
    public abstract int mo59458a(C17652c c17652c, Format format);

    /* renamed from: a */
    public abstract void mo59460a(C45029a c45029a, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    /* renamed from: a */
    public abstract boolean mo59461a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    public C44649b(int i, C17652c c17652c, C41600b<C44648d> c41600b, boolean z) {
        super(i);
        C45039a.checkState(C17675v.SDK_INT >= 16);
        this.beb = (C17652c) C45039a.checkNotNull(c17652c);
        this.aMJ = c41600b;
        this.bec = z;
        this.bed = new C32022e(0);
        this.bee = new C32022e(0);
        this.bef = new C8692k();
        this.beg = new ArrayList();
        this.beh = new BufferInfo();
        this.beA = 0;
        this.beB = 0;
    }

    /* renamed from: pJ */
    public final int mo19258pJ() {
        return 8;
    }

    /* renamed from: b */
    public final int mo19256b(Format format) {
        try {
            int a = mo59458a(this.beb, format);
            if ((a & 7) <= 2) {
                return a;
            }
            boolean z;
            C41600b c41600b = this.aMJ;
            if (format.aOg == null) {
                z = true;
            } else if (c41600b == null) {
                z = false;
            } else {
                z = c41600b.mo66734qV();
            }
            if (z) {
                return a;
            }
            return (a & -8) | 2;
        } catch (C17654b e) {
            throw C25533e.m40358b(e, this.index);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public C45029a mo59459a(C17652c c17652c, Format format, boolean z) {
        return c17652c.mo19161e(format.aOd, z);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: rE */
    public final void mo71688rE() {
        boolean z = false;
        if (this.bek == null && this.aOv != null) {
            boolean z2;
            boolean z3;
            MediaCrypto mediaCrypto;
            this.bei = this.bej;
            String str = this.aOv.aOd;
            if (this.bei != null) {
                C44648d c44648d = (C44648d) this.bei.mo32346qU();
                if (c44648d == null) {
                    C17651a qT = this.bei.mo32345qT();
                    if (qT != null) {
                        throw C25533e.m40358b(qT, this.index);
                    }
                    return;
                }
                MediaCrypto mediaCrypto2 = c44648d.aSz;
                if (c44648d.aSA || !c44648d.aSz.requiresSecureDecoderComponent(str)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                z3 = z2;
                mediaCrypto = mediaCrypto2;
            } else {
                z3 = false;
                mediaCrypto = null;
            }
            if (this.bel == null) {
                try {
                    this.bel = mo59459a(this.beb, this.aOv, z3);
                    if (this.bel == null && z3) {
                        this.bel = mo59459a(this.beb, this.aOv, false);
                        if (this.bel != null) {
                            new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.bel.name).append(".");
                        }
                    }
                } catch (C17654b e) {
                    m81181a(new C32042a(this.aOv, e, z3, -49998));
                }
                if (this.bel == null) {
                    m81181a(new C32042a(this.aOv, null, z3, -49999));
                }
            }
            if (mo59550a(this.bel)) {
                int i;
                String str2 = this.bel.name;
                if (C17675v.SDK_INT <= 24 && "OMX.Exynos.avc.dec.secure".equals(str2) && (C17675v.MODEL.startsWith("SM-T585") || C17675v.MODEL.startsWith("SM-A520"))) {
                    i = 2;
                } else if (C17675v.SDK_INT >= 24 || !(("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(C17675v.DEVICE) || "flounder_lte".equals(C17675v.DEVICE) || "grouper".equals(C17675v.DEVICE) || "tilapia".equals(C17675v.DEVICE)))) {
                    i = 0;
                } else {
                    i = 1;
                }
                this.bem = i;
                Format format = this.aOv;
                if (C17675v.SDK_INT < 21 && format.aOf.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.ben = z2;
                if (C17675v.SDK_INT < 18 || ((C17675v.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (C17675v.SDK_INT == 19 && C17675v.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2))))) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.beo = z2;
                if (C17675v.SDK_INT > 17 || !("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.bep = z2;
                if ((C17675v.SDK_INT > 23 || !"OMX.google.vorbis.decoder".equals(str2)) && !(C17675v.SDK_INT <= 19 && "hb2000".equals(C17675v.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.beq = z2;
                if (C17675v.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.ber = z2;
                format = this.aOv;
                if (C17675v.SDK_INT <= 18 && format.aOn == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                    z = true;
                }
                this.bes = z;
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    C41619t.beginSection("createCodec:".concat(String.valueOf(str2)));
                    this.bek = MediaCodec.createByCodecName(str2);
                    C41619t.endSection();
                    C41619t.beginSection("configureCodec");
                    mo59460a(this.bel, this.bek, this.aOv, mediaCrypto);
                    C41619t.endSection();
                    C41619t.beginSection("startCodec");
                    this.bek.start();
                    C41619t.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    mo59464c(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.inputBuffers = this.bek.getInputBuffers();
                    this.aQJ = this.bek.getOutputBuffers();
                } catch (Exception e2) {
                    m81181a(new C32042a(this.aOv, e2, z3, str2));
                }
                this.bev = this.state == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.bew = -1;
                this.bex = -1;
                this.beH = true;
                C32021d c32021d = this.beI;
                c32021d.aSc++;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo59550a(C45029a c45029a) {
        return true;
    }

    /* renamed from: aD */
    public void mo59462aD(boolean z) {
        this.beI = new C32021d();
    }

    /* renamed from: b */
    public void mo32349b(long j, boolean z) {
        this.beE = false;
        this.beF = false;
        if (this.bek != null) {
            this.bev = -9223372036854775807L;
            this.bew = -1;
            this.bex = -1;
            this.beH = true;
            this.beG = false;
            this.bey = false;
            this.beg.clear();
            this.bet = false;
            this.beu = false;
            if (this.beo || (this.beq && this.beD)) {
                mo59552rF();
                mo71688rE();
            } else if (this.beB != 0) {
                mo59552rF();
                mo71688rE();
            } else {
                this.bek.flush();
                this.beC = false;
            }
            if (this.bez && this.aOv != null) {
                this.beA = 1;
            }
        }
    }

    /* renamed from: pK */
    public void mo32353pK() {
        this.aOv = null;
        try {
            mo59552rF();
        } finally {
            this.bei = null;
            this.bej = null;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: rF */
    public void mo59552rF() {
        this.bev = -9223372036854775807L;
        this.bew = -1;
        this.bex = -1;
        this.beG = false;
        this.bey = false;
        this.beg.clear();
        this.inputBuffers = null;
        this.aQJ = null;
        this.bel = null;
        this.bez = false;
        this.beC = false;
        this.ben = false;
        this.beo = false;
        this.bem = 0;
        this.bep = false;
        this.beq = false;
        this.bes = false;
        this.bet = false;
        this.beu = false;
        this.beD = false;
        this.beA = 0;
        this.beB = 0;
        this.bed.aEY = null;
        if (this.bek != null) {
            C32021d c32021d = this.beI;
            c32021d.aSd++;
            try {
                this.bek.stop();
                try {
                    this.bek.release();
                } finally {
                    this.bek = null;
                    if (!(this.bei == null || this.bej == this.bei)) {
                        this.bei = null;
                    }
                }
            } catch (Throwable th) {
                this.bek.release();
            } finally {
                this.bek = null;
                if (!(this.bei == null || this.bej == this.bei)) {
                    this.bei = null;
                }
            }
        }
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    /* renamed from: f */
    public final void mo32350f(long j, long j2) {
        if (this.beF) {
            mo59469qD();
            return;
        }
        int a;
        if (this.aOv == null) {
            this.bee.clear();
            a = mo66727a(this.bef, this.bee, true);
            if (a == -5) {
                mo59465e(this.bef.aOv);
            } else if (a == -4) {
                C45039a.checkState(this.bee.mo42774qG());
                this.beE = true;
                m81184rI();
                return;
            } else {
                return;
            }
        }
        mo71688rE();
        if (this.bek != null) {
            C41619t.beginSection("drainAndFeed");
            do {
            } while (m81182h(j, j2));
            do {
            } while (m81183rG());
            C41619t.endSection();
            return;
        }
        this.aMt.mo19292Z(j - this.aMu);
        this.bee.clear();
        a = mo66727a(this.bef, this.bee, false);
        if (a == -5) {
            mo59465e(this.bef.aOv);
        } else if (a == -4) {
            C45039a.checkState(this.bee.mo42774qG());
            this.beE = true;
            m81184rI();
        }
    }

    /* renamed from: rG */
    private boolean m81183rG() {
        if (this.bek == null || this.beB == 2 || this.beE) {
            return false;
        }
        if (this.bew < 0) {
            this.bew = this.bek.dequeueInputBuffer(0);
            if (this.bew < 0) {
                return false;
            }
            this.bed.aEY = this.inputBuffers[this.bew];
            this.bed.clear();
        }
        if (this.beB == 1) {
            if (!this.bep) {
                this.beD = true;
                this.bek.queueInputBuffer(this.bew, 0, 0, 0, 4);
                this.bew = -1;
            }
            this.beB = 2;
            return false;
        } else if (this.bet) {
            this.bet = false;
            this.bed.aEY.put(bea);
            this.bek.queueInputBuffer(this.bew, 0, bea.length, 0, 0);
            this.bew = -1;
            this.beC = true;
            return true;
        } else {
            int i;
            int i2;
            int position;
            if (this.beG) {
                i = 0;
                i2 = -4;
            } else {
                if (this.beA == 1) {
                    for (i = 0; i < this.aOv.aOf.size(); i++) {
                        this.bed.aEY.put((byte[]) this.aOv.aOf.get(i));
                    }
                    this.beA = 2;
                }
                position = this.bed.aEY.position();
                i2 = mo66727a(this.bef, this.bed, false);
                i = position;
            }
            if (i2 == -3) {
                return false;
            }
            if (i2 == -5) {
                if (this.beA == 2) {
                    this.bed.clear();
                    this.beA = 1;
                }
                mo59465e(this.bef.aOv);
                return true;
            } else if (this.bed.mo42774qG()) {
                if (this.beA == 2) {
                    this.bed.clear();
                    this.beA = 1;
                }
                this.beE = true;
                if (this.beC) {
                    try {
                        if (this.bep) {
                            return false;
                        }
                        this.beD = true;
                        this.bek.queueInputBuffer(this.bew, 0, 0, 0, 4);
                        this.bew = -1;
                        return false;
                    } catch (CryptoException e) {
                        throw C25533e.m40358b(e, this.index);
                    }
                }
                m81184rI();
                return false;
            } else if (!this.beH || this.bed.mo42775qH()) {
                boolean z;
                this.beH = false;
                boolean qK = this.bed.mo52316qK();
                if (this.bei == null || (!qK && this.bec)) {
                    z = false;
                } else {
                    position = this.bei.getState();
                    if (position == 1) {
                        throw C25533e.m40358b(this.bei.mo32345qT(), this.index);
                    }
                    z = position != 4;
                }
                this.beG = z;
                if (this.beG) {
                    return false;
                }
                if (this.ben && !qK) {
                    C45041j.m82577i(this.bed.aEY);
                    if (this.bed.aEY.position() == 0) {
                        return true;
                    }
                    this.ben = false;
                }
                try {
                    long j = this.bed.aSk;
                    if (this.bed.mo42773qF()) {
                        this.beg.add(Long.valueOf(j));
                    }
                    this.bed.mo52317qL();
                    mo59553rH();
                    if (qK) {
                        CryptoInfo cryptoInfo = this.bed.aSj.aRZ;
                        if (i != 0) {
                            if (cryptoInfo.numBytesOfClearData == null) {
                                cryptoInfo.numBytesOfClearData = new int[1];
                            }
                            int[] iArr = cryptoInfo.numBytesOfClearData;
                            iArr[0] = i + iArr[0];
                        }
                        this.bek.queueSecureInputBuffer(this.bew, 0, cryptoInfo, j, 0);
                    } else {
                        this.bek.queueInputBuffer(this.bew, 0, this.bed.aEY.limit(), j, 0);
                    }
                    this.bew = -1;
                    this.beC = true;
                    this.beA = 0;
                    C32021d c32021d = this.beI;
                    c32021d.aSe++;
                    return true;
                } catch (CryptoException e2) {
                    throw C25533e.m40358b(e2, this.index);
                }
            } else {
                this.bed.clear();
                if (this.beA == 2) {
                    this.beA = 1;
                }
                return true;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public void mo59464c(String str, long j, long j2) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: e */
    public void mo59465e(Format format) {
        Format format2 = this.aOv;
        this.aOv = format;
        if (!C17675v.m27574j(this.aOv.aOg, format2 == null ? null : format2.aOg)) {
            if (this.aOv.aOg == null) {
                this.bej = null;
            } else if (this.aMJ == null) {
                throw C25533e.m40358b(new IllegalStateException("Media requires a DrmSessionManager"), this.index);
            } else {
                C41600b c41600b = this.aMJ;
                Looper.myLooper();
                this.bej = c41600b.mo66735qW();
                if (this.bej == this.bei) {
                }
            }
        }
        if (this.bej == this.bei && this.bek != null && mo59551a(this.bel.bdX, format2, this.aOv)) {
            boolean z;
            this.bez = true;
            this.beA = 1;
            if (this.bem == 2 || (this.bem == 1 && this.aOv.width == format2.width && this.aOv.height == format2.height)) {
                z = true;
            } else {
                z = false;
            }
            this.bet = z;
        } else if (this.beC) {
            this.beB = 1;
        } else {
            mo59552rF();
            mo71688rE();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: rH */
    public void mo59553rH() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo59551a(boolean z, Format format, Format format2) {
        return false;
    }

    /* renamed from: qf */
    public boolean mo32354qf() {
        return this.beF;
    }

    public boolean isReady() {
        if (!(this.aOv == null || this.beG)) {
            boolean z;
            if (this.aMv) {
                z = this.aMw;
            } else {
                z = this.aMt.isReady();
            }
            if (z || this.bex >= 0 || (this.bev != -9223372036854775807L && SystemClock.elapsedRealtime() < this.bev)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private boolean m81182h(long j, long j2) {
        boolean z;
        if (this.bex < 0) {
            if (this.ber && this.beD) {
                try {
                    this.bex = this.bek.dequeueOutputBuffer(this.beh, 0);
                } catch (IllegalStateException e) {
                    m81184rI();
                    if (this.beF) {
                        mo59552rF();
                    }
                    return false;
                }
            }
            this.bex = this.bek.dequeueOutputBuffer(this.beh, 0);
            if (this.bex >= 0) {
                if (this.beu) {
                    this.beu = false;
                    this.bek.releaseOutputBuffer(this.bex, false);
                    this.bex = -1;
                    return true;
                } else if ((this.beh.flags & 4) != 0) {
                    m81184rI();
                    this.bex = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.aQJ[this.bex];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.beh.offset);
                        byteBuffer.limit(this.beh.offset + this.beh.size);
                    }
                    long j3 = this.beh.presentationTimeUs;
                    int size = this.beg.size();
                    for (int i = 0; i < size; i++) {
                        if (((Long) this.beg.get(i)).longValue() == j3) {
                            this.beg.remove(i);
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    this.bey = z;
                }
            } else if (this.bex == -2) {
                MediaFormat outputFormat = this.bek.getOutputFormat();
                if (this.bem != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.beu = true;
                } else {
                    if (this.bes) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.bek, outputFormat);
                }
                return true;
            } else if (this.bex == -3) {
                this.aQJ = this.bek.getOutputBuffers();
                return true;
            } else {
                if (this.bep && (this.beE || this.beB == 2)) {
                    m81184rI();
                }
                return false;
            }
        }
        if (this.ber && this.beD) {
            try {
                z = mo59461a(j, j2, this.bek, this.aQJ[this.bex], this.bex, this.beh.flags, this.beh.presentationTimeUs, this.bey);
            } catch (IllegalStateException e2) {
                m81184rI();
                if (this.beF) {
                    mo59552rF();
                }
                return false;
            }
        }
        z = mo59461a(j, j2, this.bek, this.aQJ[this.bex], this.bex, this.beh.flags, this.beh.presentationTimeUs, this.bey);
        if (!z) {
            return false;
        }
        long j4 = this.beh.presentationTimeUs;
        this.bex = -1;
        return true;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: qD */
    public void mo59469qD() {
    }

    /* renamed from: rI */
    private void m81184rI() {
        if (this.beB == 2) {
            mo59552rF();
            mo71688rE();
            return;
        }
        this.beF = true;
        mo59469qD();
    }

    /* renamed from: a */
    private void m81181a(C32042a c32042a) {
        throw C25533e.m40358b(c32042a, this.index);
    }
}
