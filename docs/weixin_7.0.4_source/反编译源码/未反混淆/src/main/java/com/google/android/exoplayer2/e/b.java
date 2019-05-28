package com.google.android.exoplayer2.e;

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
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b extends com.google.android.exoplayer2.a {
    private static final byte[] bea = v.aU("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private final com.google.android.exoplayer2.drm.b<d> aMJ;
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
    protected com.google.android.exoplayer2.b.d beI;
    private final c beb;
    private final boolean bec;
    private final e bed;
    private final e bee;
    private final k bef;
    private final List<Long> beg;
    private final BufferInfo beh;
    private com.google.android.exoplayer2.drm.a<d> bei;
    private com.google.android.exoplayer2.drm.a<d> bej;
    protected MediaCodec bek;
    protected a bel;
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

    public static class a extends Exception {
        public final boolean beJ;
        public final String beK;
        public final String beL;
        public final String mimeType;

        public a(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            AppMethodBeat.i(95235);
            this.mimeType = format.aOd;
            this.beJ = z;
            this.beK = null;
            this.beL = "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
            AppMethodBeat.o(95235);
        }

        public a(Format format, Throwable th, boolean z, String str) {
            String str2 = null;
            super("Decoder init failed: " + str + ", " + format, th);
            AppMethodBeat.i(95236);
            this.mimeType = format.aOd;
            this.beJ = z;
            this.beK = str;
            if (v.SDK_INT >= 21 && (th instanceof CodecException)) {
                str2 = ((CodecException) th).getDiagnosticInfo();
            }
            this.beL = str2;
            AppMethodBeat.o(95236);
        }
    }

    public abstract int a(c cVar, Format format);

    public abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    public abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    public b(int i, c cVar, com.google.android.exoplayer2.drm.b<d> bVar, boolean z) {
        super(i);
        com.google.android.exoplayer2.i.a.checkState(v.SDK_INT >= 16);
        this.beb = (c) com.google.android.exoplayer2.i.a.checkNotNull(cVar);
        this.aMJ = bVar;
        this.bec = z;
        this.bed = new e(0);
        this.bee = new e(0);
        this.bef = new k();
        this.beg = new ArrayList();
        this.beh = new BufferInfo();
        this.beA = 0;
        this.beB = 0;
    }

    public final int pJ() {
        return 8;
    }

    public final int b(Format format) {
        try {
            int a = a(this.beb, format);
            if ((a & 7) <= 2) {
                return a;
            }
            boolean z;
            com.google.android.exoplayer2.drm.b bVar = this.aMJ;
            if (format.aOg == null) {
                z = true;
            } else if (bVar == null) {
                z = false;
            } else {
                z = bVar.qV();
            }
            if (z) {
                return a;
            }
            return (a & -8) | 2;
        } catch (com.google.android.exoplayer2.e.d.b e) {
            throw com.google.android.exoplayer2.e.b(e, this.index);
        }
    }

    /* Access modifiers changed, original: protected */
    public a a(c cVar, Format format, boolean z) {
        return cVar.e(format.aOd, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void rE() {
        boolean z = false;
        if (this.bek == null && this.aOv != null) {
            boolean z2;
            boolean z3;
            MediaCrypto mediaCrypto;
            this.bei = this.bej;
            String str = this.aOv.aOd;
            if (this.bei != null) {
                d dVar = (d) this.bei.qU();
                if (dVar == null) {
                    com.google.android.exoplayer2.drm.a.a qT = this.bei.qT();
                    if (qT != null) {
                        throw com.google.android.exoplayer2.e.b(qT, this.index);
                    }
                    return;
                }
                MediaCrypto mediaCrypto2 = dVar.aSz;
                if (dVar.aSA || !dVar.aSz.requiresSecureDecoderComponent(str)) {
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
                    this.bel = a(this.beb, this.aOv, z3);
                    if (this.bel == null && z3) {
                        this.bel = a(this.beb, this.aOv, false);
                        if (this.bel != null) {
                            new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.bel.name).append(".");
                        }
                    }
                } catch (com.google.android.exoplayer2.e.d.b e) {
                    a(new a(this.aOv, e, z3, -49998));
                }
                if (this.bel == null) {
                    a(new a(this.aOv, null, z3, -49999));
                }
            }
            if (a(this.bel)) {
                int i;
                String str2 = this.bel.name;
                if (v.SDK_INT <= 24 && "OMX.Exynos.avc.dec.secure".equals(str2) && (v.MODEL.startsWith("SM-T585") || v.MODEL.startsWith("SM-A520"))) {
                    i = 2;
                } else if (v.SDK_INT >= 24 || !(("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(v.DEVICE) || "flounder_lte".equals(v.DEVICE) || "grouper".equals(v.DEVICE) || "tilapia".equals(v.DEVICE)))) {
                    i = 0;
                } else {
                    i = 1;
                }
                this.bem = i;
                Format format = this.aOv;
                if (v.SDK_INT < 21 && format.aOf.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.ben = z2;
                if (v.SDK_INT < 18 || ((v.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (v.SDK_INT == 19 && v.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2))))) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.beo = z2;
                if (v.SDK_INT > 17 || !("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.bep = z2;
                if ((v.SDK_INT > 23 || !"OMX.google.vorbis.decoder".equals(str2)) && !(v.SDK_INT <= 19 && "hb2000".equals(v.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.beq = z2;
                if (v.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.ber = z2;
                format = this.aOv;
                if (v.SDK_INT <= 18 && format.aOn == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                    z = true;
                }
                this.bes = z;
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    t.beginSection("createCodec:".concat(String.valueOf(str2)));
                    this.bek = MediaCodec.createByCodecName(str2);
                    t.endSection();
                    t.beginSection("configureCodec");
                    a(this.bel, this.bek, this.aOv, mediaCrypto);
                    t.endSection();
                    t.beginSection("startCodec");
                    this.bek.start();
                    t.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    c(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.inputBuffers = this.bek.getInputBuffers();
                    this.aQJ = this.bek.getOutputBuffers();
                } catch (Exception e2) {
                    a(new a(this.aOv, e2, z3, str2));
                }
                this.bev = this.state == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.bew = -1;
                this.bex = -1;
                this.beH = true;
                com.google.android.exoplayer2.b.d dVar2 = this.beI;
                dVar2.aSc++;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean a(a aVar) {
        return true;
    }

    public void aD(boolean z) {
        this.beI = new com.google.android.exoplayer2.b.d();
    }

    public void b(long j, boolean z) {
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
                rF();
                rE();
            } else if (this.beB != 0) {
                rF();
                rE();
            } else {
                this.bek.flush();
                this.beC = false;
            }
            if (this.bez && this.aOv != null) {
                this.beA = 1;
            }
        }
    }

    public void pK() {
        this.aOv = null;
        try {
            rF();
        } finally {
            this.bei = null;
            this.bej = null;
        }
    }

    /* Access modifiers changed, original: protected */
    public void rF() {
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
            com.google.android.exoplayer2.b.d dVar = this.beI;
            dVar.aSd++;
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

    public final void f(long j, long j2) {
        if (this.beF) {
            qD();
            return;
        }
        int a;
        if (this.aOv == null) {
            this.bee.clear();
            a = a(this.bef, this.bee, true);
            if (a == -5) {
                e(this.bef.aOv);
            } else if (a == -4) {
                com.google.android.exoplayer2.i.a.checkState(this.bee.qG());
                this.beE = true;
                rI();
                return;
            } else {
                return;
            }
        }
        rE();
        if (this.bek != null) {
            t.beginSection("drainAndFeed");
            do {
            } while (h(j, j2));
            do {
            } while (rG());
            t.endSection();
            return;
        }
        this.aMt.Z(j - this.aMu);
        this.bee.clear();
        a = a(this.bef, this.bee, false);
        if (a == -5) {
            e(this.bef.aOv);
        } else if (a == -4) {
            com.google.android.exoplayer2.i.a.checkState(this.bee.qG());
            this.beE = true;
            rI();
        }
    }

    private boolean rG() {
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
                i2 = a(this.bef, this.bed, false);
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
                e(this.bef.aOv);
                return true;
            } else if (this.bed.qG()) {
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
                        throw com.google.android.exoplayer2.e.b(e, this.index);
                    }
                }
                rI();
                return false;
            } else if (!this.beH || this.bed.qH()) {
                boolean z;
                this.beH = false;
                boolean qK = this.bed.qK();
                if (this.bei == null || (!qK && this.bec)) {
                    z = false;
                } else {
                    position = this.bei.getState();
                    if (position == 1) {
                        throw com.google.android.exoplayer2.e.b(this.bei.qT(), this.index);
                    }
                    z = position != 4;
                }
                this.beG = z;
                if (this.beG) {
                    return false;
                }
                if (this.ben && !qK) {
                    j.i(this.bed.aEY);
                    if (this.bed.aEY.position() == 0) {
                        return true;
                    }
                    this.ben = false;
                }
                try {
                    long j = this.bed.aSk;
                    if (this.bed.qF()) {
                        this.beg.add(Long.valueOf(j));
                    }
                    this.bed.qL();
                    rH();
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
                    com.google.android.exoplayer2.b.d dVar = this.beI;
                    dVar.aSe++;
                    return true;
                } catch (CryptoException e2) {
                    throw com.google.android.exoplayer2.e.b(e2, this.index);
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
    public void c(String str, long j, long j2) {
    }

    /* Access modifiers changed, original: protected */
    public void e(Format format) {
        Format format2 = this.aOv;
        this.aOv = format;
        if (!v.j(this.aOv.aOg, format2 == null ? null : format2.aOg)) {
            if (this.aOv.aOg == null) {
                this.bej = null;
            } else if (this.aMJ == null) {
                throw com.google.android.exoplayer2.e.b(new IllegalStateException("Media requires a DrmSessionManager"), this.index);
            } else {
                com.google.android.exoplayer2.drm.b bVar = this.aMJ;
                Looper.myLooper();
                this.bej = bVar.qW();
                if (this.bej == this.bei) {
                }
            }
        }
        if (this.bej == this.bei && this.bek != null && a(this.bel.bdX, format2, this.aOv)) {
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
            rF();
            rE();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    /* Access modifiers changed, original: protected */
    public void rH() {
    }

    /* Access modifiers changed, original: protected */
    public boolean a(boolean z, Format format, Format format2) {
        return false;
    }

    public boolean qf() {
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

    private boolean h(long j, long j2) {
        boolean z;
        if (this.bex < 0) {
            if (this.ber && this.beD) {
                try {
                    this.bex = this.bek.dequeueOutputBuffer(this.beh, 0);
                } catch (IllegalStateException e) {
                    rI();
                    if (this.beF) {
                        rF();
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
                    rI();
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
                    rI();
                }
                return false;
            }
        }
        if (this.ber && this.beD) {
            try {
                z = a(j, j2, this.bek, this.aQJ[this.bex], this.bex, this.beh.flags, this.beh.presentationTimeUs, this.bey);
            } catch (IllegalStateException e2) {
                rI();
                if (this.beF) {
                    rF();
                }
                return false;
            }
        }
        z = a(j, j2, this.bek, this.aQJ[this.bex], this.bex, this.beh.flags, this.beh.presentationTimeUs, this.bey);
        if (!z) {
            return false;
        }
        long j4 = this.beh.presentationTimeUs;
        this.bex = -1;
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void qD() {
    }

    private void rI() {
        if (this.beB == 2) {
            rF();
            rE();
            return;
        }
        this.beF = true;
        qD();
    }

    private void a(a aVar) {
        throw com.google.android.exoplayer2.e.b(aVar, this.index);
    }
}
