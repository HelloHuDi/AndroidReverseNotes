package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.e.a.AnonymousClass1;
import com.google.android.exoplayer2.a.e.a.AnonymousClass2;
import com.google.android.exoplayer2.a.e.a.AnonymousClass3;
import com.google.android.exoplayer2.a.e.a.AnonymousClass4;
import com.google.android.exoplayer2.a.e.a.AnonymousClass6;
import com.google.android.exoplayer2.a.f.f;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.p;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class i extends b implements h {
    private int aOn;
    private int aOo;
    private final com.google.android.exoplayer2.a.e.a aRq;
    private final f aRr;
    private boolean aRs;
    private boolean aRt;
    private MediaFormat aRu;
    private long aRv;
    private boolean aRw;

    final class a implements f {
        private a() {
        }

        /* synthetic */ a(i iVar, byte b) {
            this();
        }

        public final void dx(int i) {
            AppMethodBeat.i(94696);
            com.google.android.exoplayer2.a.e.a a = i.this.aRq;
            if (a.aPH != null) {
                a.handler.post(new AnonymousClass6(i));
            }
            AppMethodBeat.o(94696);
        }

        public final void qe() {
            AppMethodBeat.i(94697);
            i.this.aRw = true;
            AppMethodBeat.o(94697);
        }

        public final void e(int i, long j, long j2) {
            AppMethodBeat.i(94698);
            com.google.android.exoplayer2.a.e.a a = i.this.aRq;
            if (a.aPH != null) {
                a.handler.post(new AnonymousClass4(i, j, j2));
            }
            AppMethodBeat.o(94698);
        }
    }

    public i(c cVar, com.google.android.exoplayer2.drm.b<d> bVar, Handler handler, e eVar, c cVar2, d... dVarArr) {
        super(1, cVar, bVar, true);
        AppMethodBeat.i(94699);
        this.aRr = new f(cVar2, dVarArr, new a(this, (byte) 0));
        this.aRq = new com.google.android.exoplayer2.a.e.a(handler, eVar);
        AppMethodBeat.o(94699);
    }

    /* JADX WARNING: Missing block: B:22:0x0053, code skipped:
            if (r2 != 0) goto L_0x0055;
     */
    /* JADX WARNING: Missing block: B:28:0x0066, code skipped:
            if (r2 != 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(c cVar, Format format) {
        int i = 0;
        AppMethodBeat.i(94700);
        String str = format.aOd;
        if (com.google.android.exoplayer2.i.i.aH(str)) {
            int i2;
            if (v.SDK_INT >= 21) {
                i2 = 32;
            } else {
                i2 = 0;
            }
            if (!av(str) || cVar.rJ() == null) {
                com.google.android.exoplayer2.e.a e = cVar.e(str, false);
                if (e == null) {
                    AppMethodBeat.o(94700);
                    return 1;
                }
                if (v.SDK_INT >= 21) {
                    int i3;
                    if (format.sampleRate != -1) {
                        i3 = format.sampleRate;
                        if (e.bdZ == null) {
                            e.ax("sampleRate.caps");
                            i3 = 0;
                        } else {
                            AudioCapabilities audioCapabilities = e.bdZ.getAudioCapabilities();
                            if (audioCapabilities == null) {
                                e.ax("sampleRate.aCaps");
                                i3 = 0;
                            } else if (audioCapabilities.isSampleRateSupported(i3)) {
                                i3 = 1;
                            } else {
                                e.ax("sampleRate.support, ".concat(String.valueOf(i3)));
                                i3 = 0;
                            }
                        }
                    }
                    if (format.aOn != -1) {
                        int i4 = format.aOn;
                        if (e.bdZ == null) {
                            e.ax("channelCount.caps");
                            i3 = 0;
                        } else {
                            AudioCapabilities audioCapabilities2 = e.bdZ.getAudioCapabilities();
                            if (audioCapabilities2 == null) {
                                e.ax("channelCount.aCaps");
                                i3 = 0;
                            } else {
                                String str2 = e.name;
                                String str3 = e.mimeType;
                                int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                                if (maxInputChannelCount > 1 || (v.SDK_INT >= 26 && maxInputChannelCount > 0)) {
                                    i3 = maxInputChannelCount;
                                } else if ("audio/mpeg".equals(str3) || "audio/3gpp".equals(str3) || "audio/amr-wb".equals(str3) || "audio/mp4a-latm".equals(str3) || "audio/vorbis".equals(str3) || "audio/opus".equals(str3) || "audio/raw".equals(str3) || "audio/flac".equals(str3) || "audio/g711-alaw".equals(str3) || "audio/g711-mlaw".equals(str3) || "audio/gsm".equals(str3)) {
                                    i3 = maxInputChannelCount;
                                } else {
                                    if ("audio/ac3".equals(str3)) {
                                        i3 = 6;
                                    } else if ("audio/eac3".equals(str3)) {
                                        i3 = 16;
                                    } else {
                                        i3 = 30;
                                    }
                                    new StringBuilder("AssumedMaxChannelAdjustment: ").append(str2).append(", [").append(maxInputChannelCount).append(" to ").append(i3).append("]");
                                }
                                if (i3 < i4) {
                                    e.ax("channelCount.support, ".concat(String.valueOf(i4)));
                                    i3 = 0;
                                } else {
                                    i3 = 1;
                                }
                            }
                        }
                    }
                }
                i = 1;
                i = (i != 0 ? 4 : 3) | (i2 | 8);
                AppMethodBeat.o(94700);
                return i;
            }
            i = (i2 | 8) | 4;
            AppMethodBeat.o(94700);
            return i;
        }
        AppMethodBeat.o(94700);
        return 0;
    }

    public final com.google.android.exoplayer2.e.a a(c cVar, Format format, boolean z) {
        com.google.android.exoplayer2.e.a rJ;
        AppMethodBeat.i(94701);
        if (av(format.aOd)) {
            rJ = cVar.rJ();
            if (rJ != null) {
                this.aRs = true;
                AppMethodBeat.o(94701);
                return rJ;
            }
        }
        this.aRs = false;
        rJ = super.a(cVar, format, z);
        AppMethodBeat.o(94701);
        return rJ;
    }

    private boolean av(String str) {
        AppMethodBeat.i(94702);
        boolean at = this.aRr.at(str);
        AppMethodBeat.o(94702);
        return at;
    }

    public final void a(com.google.android.exoplayer2.e.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        boolean z;
        AppMethodBeat.i(94703);
        String str = aVar.name;
        if (v.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(v.MANUFACTURER) && (v.DEVICE.startsWith("zeroflte") || v.DEVICE.startsWith("herolte") || v.DEVICE.startsWith("heroqlte"))) {
            z = true;
        } else {
            z = false;
        }
        this.aRt = z;
        if (this.aRs) {
            this.aRu = format.qc();
            this.aRu.setString("mime", "audio/raw");
            mediaCodec.configure(this.aRu, null, mediaCrypto, 0);
            this.aRu.setString("mime", format.aOd);
            AppMethodBeat.o(94703);
            return;
        }
        mediaCodec.configure(format.qc(), null, mediaCrypto, 0);
        this.aRu = null;
        AppMethodBeat.o(94703);
    }

    public final h pD() {
        return this;
    }

    public final void c(String str, long j, long j2) {
        AppMethodBeat.i(94704);
        com.google.android.exoplayer2.a.e.a aVar = this.aRq;
        if (aVar.aPH != null) {
            aVar.handler.post(new AnonymousClass2(str, j, j2));
        }
        AppMethodBeat.o(94704);
    }

    public final void e(Format format) {
        AppMethodBeat.i(94705);
        super.e(format);
        com.google.android.exoplayer2.a.e.a aVar = this.aRq;
        if (aVar.aPH != null) {
            aVar.handler.post(new AnonymousClass3(format));
        }
        this.aOo = "audio/raw".equals(format.aOd) ? format.aOo : 2;
        this.aOn = format.aOn;
        AppMethodBeat.o(94705);
    }

    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        Object string;
        int i;
        int[] iArr;
        AppMethodBeat.i(94706);
        Object obj = this.aRu != null ? 1 : null;
        if (obj != null) {
            string = this.aRu.getString("mime");
        } else {
            String string2 = "audio/raw";
        }
        if (obj != null) {
            mediaFormat = this.aRu;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.aRt && integer == 6 && this.aOn < 6) {
            int[] iArr2 = new int[this.aOn];
            for (i = 0; i < this.aOn; i++) {
                iArr2[i] = i;
            }
            iArr = iArr2;
        } else {
            iArr = null;
        }
        f.c cVar;
        try {
            int au;
            int i2;
            f fVar = this.aRr;
            i = this.aOo;
            boolean z = !"audio/raw".equals(string2);
            if (z) {
                au = f.au(string2);
            } else {
                au = i;
            }
            int i3 = 0;
            if (z) {
                i2 = 0;
            } else {
                fVar.aQw = v.bj(i, integer);
                fVar.aPW.aRk = iArr;
                i = integer;
                for (d dVar : fVar.aPY) {
                    i3 |= dVar.r(integer2, i, au);
                    if (dVar.isActive()) {
                        i = dVar.qk();
                        au = 2;
                    }
                }
                if (i3 != 0) {
                    fVar.qn();
                }
                i2 = i3;
                integer = i;
            }
            switch (integer) {
                case 1:
                    i = 4;
                    break;
                case 2:
                    i = 12;
                    break;
                case 3:
                    i = 28;
                    break;
                case 4:
                    i = 204;
                    break;
                case 5:
                    i = 220;
                    break;
                case 6:
                    i = 252;
                    break;
                case 7:
                    i = 1276;
                    break;
                case 8:
                    i = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
                    break;
                default:
                    cVar = new f.c("Unsupported channel count: ".concat(String.valueOf(integer)));
                    AppMethodBeat.o(94706);
                    throw cVar;
            }
            if (v.SDK_INT <= 23 && "foster".equals(v.DEVICE) && "NVIDIA".equals(v.MANUFACTURER)) {
                switch (integer) {
                    case 3:
                    case 5:
                        i = 252;
                        break;
                    case 7:
                        i = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
                        break;
                }
            }
            if (v.SDK_INT <= 25 && "fugu".equals(v.DEVICE) && z && integer == 1) {
                i3 = 12;
            } else {
                i3 = i;
            }
            if (!(i2 == 0 && fVar.isInitialized() && fVar.encoding == au && fVar.sampleRate == integer2 && fVar.aQg == i3)) {
                f fVar2;
                long j;
                fVar.reset();
                fVar.encoding = au;
                fVar.aQi = z;
                fVar.sampleRate = integer2;
                fVar.aQg = i3;
                fVar.aQh = z ? au : 2;
                fVar.aQz = v.bj(2, integer);
                if (!z) {
                    au = AudioTrack.getMinBufferSize(integer2, i3, fVar.aQh);
                    com.google.android.exoplayer2.i.a.checkState(au != -2);
                    i3 = au * 4;
                    i = ((int) fVar.K(250000)) * fVar.aQz;
                    au = (int) Math.max((long) au, fVar.K(750000) * ((long) fVar.aQz));
                    if (i3 < i) {
                        fVar2 = fVar;
                    } else if (i3 > au) {
                        i = au;
                        fVar2 = fVar;
                    } else {
                        i = i3;
                        fVar2 = fVar;
                    }
                } else if (fVar.aQh == 5 || fVar.aQh == 6) {
                    i = 20480;
                    fVar2 = fVar;
                } else {
                    i = 49152;
                    fVar2 = fVar;
                }
                fVar2.bufferSize = i;
                if (z) {
                    j = -9223372036854775807L;
                } else {
                    j = fVar.J((long) (fVar.bufferSize / fVar.aQz));
                }
                fVar.aQj = j;
                fVar.b(fVar.aNg);
            }
            AppMethodBeat.o(94706);
        } catch (com.google.android.exoplayer2.a.d.a e) {
            f.c cVar2 = new f.c(e);
            AppMethodBeat.o(94706);
            throw cVar2;
        } catch (f.c cVar3) {
            e b = e.b(cVar3, this.index);
            AppMethodBeat.o(94706);
            throw b;
        }
    }

    public final void aD(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(94707);
        super.aD(z);
        com.google.android.exoplayer2.a.e.a aVar = this.aRq;
        com.google.android.exoplayer2.b.d dVar = this.beI;
        if (aVar.aPH != null) {
            aVar.handler.post(new AnonymousClass1(dVar));
        }
        int i = this.aMs.aOF;
        if (i != 0) {
            f fVar = this.aRr;
            if (v.SDK_INT >= 21) {
                z2 = true;
            }
            com.google.android.exoplayer2.i.a.checkState(z2);
            if (!(fVar.aQR && fVar.aOX == i)) {
                fVar.aQR = true;
                fVar.aOX = i;
                fVar.reset();
            }
            AppMethodBeat.o(94707);
            return;
        }
        f fVar2 = this.aRr;
        if (fVar2.aQR) {
            fVar2.aQR = false;
            fVar2.aOX = 0;
            fVar2.reset();
        }
        AppMethodBeat.o(94707);
    }

    public final void b(long j, boolean z) {
        AppMethodBeat.i(94708);
        super.b(j, z);
        this.aRr.reset();
        this.aRv = j;
        this.aRw = true;
        AppMethodBeat.o(94708);
    }

    public final void onStarted() {
        AppMethodBeat.i(94709);
        super.onStarted();
        this.aRr.play();
        AppMethodBeat.o(94709);
    }

    public final void onStopped() {
        AppMethodBeat.i(94710);
        f fVar = this.aRr;
        fVar.aQQ = false;
        if (fVar.isInitialized()) {
            fVar.qu();
            fVar.aQc.pause();
        }
        super.onStopped();
        AppMethodBeat.o(94710);
    }

    public final void pK() {
        AppMethodBeat.i(94711);
        try {
            f fVar = this.aRr;
            fVar.reset();
            fVar.qr();
            for (d reset : fVar.aPY) {
                reset.reset();
            }
            fVar.aOX = 0;
            fVar.aQQ = false;
            try {
                super.pK();
            } finally {
                this.aRq.e(this.beI);
                AppMethodBeat.o(94711);
            }
        } catch (Throwable th) {
            super.pK();
        } finally {
            this.aRq.e(this.beI);
            AppMethodBeat.o(94711);
        }
    }

    public final boolean qf() {
        AppMethodBeat.i(94712);
        if (super.qf()) {
            boolean z;
            f fVar = this.aRr;
            if (!fVar.isInitialized() || (fVar.aQP && !fVar.qp())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(94712);
                return true;
            }
        }
        AppMethodBeat.o(94712);
        return false;
    }

    public final boolean isReady() {
        AppMethodBeat.i(94713);
        if (this.aRr.qp() || super.isReady()) {
            AppMethodBeat.o(94713);
            return true;
        }
        AppMethodBeat.o(94713);
        return false;
    }

    public final long qy() {
        AppMethodBeat.i(94714);
        long aI = this.aRr.aI(qf());
        if (aI != Long.MIN_VALUE) {
            if (!this.aRw) {
                aI = Math.max(this.aRv, aI);
            }
            this.aRv = aI;
            this.aRw = false;
        }
        aI = this.aRv;
        AppMethodBeat.o(94714);
        return aI;
    }

    public final p b(p pVar) {
        AppMethodBeat.i(94715);
        p b = this.aRr.b(pVar);
        AppMethodBeat.o(94715);
        return b;
    }

    public final p qC() {
        return this.aRr.aNg;
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cc A:{Catch:{ d -> 0x01da, h -> 0x023d }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cc A:{Catch:{ d -> 0x01da, h -> 0x023d }} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cc A:{Catch:{ d -> 0x01da, h -> 0x023d }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cc A:{Catch:{ d -> 0x01da, h -> 0x023d }} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0252  */
    /* JADX WARNING: Missing block: B:50:0x00fb, code skipped:
            if (r10.aQc.qx() != 0) goto L_0x00c9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        Exception e;
        e b;
        AppMethodBeat.i(94716);
        com.google.android.exoplayer2.b.d dVar;
        if (this.aRs && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            AppMethodBeat.o(94716);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            dVar = this.beI;
            dVar.aSg++;
            f fVar = this.aRr;
            if (fVar.aQD == 1) {
                fVar.aQD = 2;
            }
            AppMethodBeat.o(94716);
            return true;
        } else {
            try {
                Object obj;
                f fVar2 = this.aRr;
                boolean z2 = fVar2.aQK == null || byteBuffer == fVar2.aQK;
                com.google.android.exoplayer2.i.a.checkArgument(z2);
                if (!fVar2.isInitialized()) {
                    fVar2.aQa.block();
                    fVar2.aQf = fVar2.qw();
                    int audioSessionId = fVar2.aQf.getAudioSessionId();
                    if (f.aPT && v.SDK_INT < 21) {
                        if (!(fVar2.aQe == null || audioSessionId == fVar2.aQe.getAudioSessionId())) {
                            fVar2.qr();
                        }
                        if (fVar2.aQe == null) {
                            fVar2.aQe = new AudioTrack(3, WearableStatusCodes.TARGET_NODE_NOT_CONNECTED, 4, 2, 2, 0, audioSessionId);
                        }
                    }
                    if (fVar2.aOX != audioSessionId) {
                        fVar2.aOX = audioSessionId;
                        fVar2.aPZ.dx(audioSessionId);
                    }
                    fVar2.aQc.a(fVar2.aQf, fVar2.qv());
                    fVar2.qq();
                    fVar2.aQS = false;
                    if (fVar2.aQQ) {
                        fVar2.play();
                    }
                }
                if (fVar2.qv()) {
                    if (fVar2.aQf.getPlayState() == 2) {
                        fVar2.aQS = false;
                    } else if (fVar2.aQf.getPlayState() == 1) {
                    }
                    obj = null;
                    if (obj != null) {
                        mediaCodec.releaseOutputBuffer(i, false);
                        dVar = this.beI;
                        dVar.aSf++;
                        AppMethodBeat.o(94716);
                        return true;
                    }
                    AppMethodBeat.o(94716);
                    return false;
                }
                z2 = fVar2.aQS;
                fVar2.aQS = fVar2.qp();
                if (!(!z2 || fVar2.aQS || fVar2.aQf.getPlayState() == 1)) {
                    fVar2.aPZ.e(fVar2.bufferSize, com.google.android.exoplayer2.b.w(fVar2.aQj), SystemClock.elapsedRealtime() - fVar2.aQT);
                }
                if (fVar2.aQK == null) {
                    if (byteBuffer.hasRemaining()) {
                        if (fVar2.aQi && fVar2.aQC == 0) {
                            int i3 = fVar2.aQh;
                            if (i3 == 7 || i3 == 8) {
                                i3 = h.h(byteBuffer);
                            } else if (i3 == 5) {
                                i3 = a.qj();
                            } else if (i3 == 6) {
                                i3 = a.f(byteBuffer);
                            } else {
                                IllegalStateException illegalStateException = new IllegalStateException("Unexpected audio encoding: ".concat(String.valueOf(i3)));
                                AppMethodBeat.o(94716);
                                throw illegalStateException;
                            }
                            fVar2.aQC = i3;
                        }
                        if (fVar2.aQk != null) {
                            if (fVar2.qo()) {
                                fVar2.aQd.add(new g(fVar2.aQk, Math.max(0, j3), fVar2.J(fVar2.qt()), (byte) 0));
                                fVar2.aQk = null;
                                fVar2.qn();
                            }
                            obj = null;
                            if (obj != null) {
                            }
                        }
                        if (fVar2.aQD == 0) {
                            fVar2.aQE = Math.max(0, j3);
                            fVar2.aQD = 1;
                        } else {
                            long J = fVar2.aQE + fVar2.J(fVar2.qs());
                            if (fVar2.aQD == 1 && Math.abs(J - j3) > 200000) {
                                new StringBuilder("Discontinuity detected [expected ").append(J).append(", got ").append(j3).append("]");
                                fVar2.aQD = 2;
                            }
                            if (fVar2.aQD == 2) {
                                fVar2.aQE = (j3 - J) + fVar2.aQE;
                                fVar2.aQD = 1;
                                fVar2.aPZ.qe();
                            }
                        }
                        if (fVar2.aQi) {
                            fVar2.aQy += (long) fVar2.aQC;
                        } else {
                            fVar2.aQx += (long) byteBuffer.remaining();
                        }
                        fVar2.aQK = byteBuffer;
                    } else {
                        obj = 1;
                        if (obj != null) {
                        }
                    }
                }
                if (fVar2.aQi) {
                    fVar2.a(fVar2.aQK, j3);
                } else {
                    fVar2.H(j3);
                }
                if (!fVar2.aQK.hasRemaining()) {
                    fVar2.aQK = null;
                    obj = 1;
                    if (obj != null) {
                    }
                }
                obj = null;
                if (obj != null) {
                }
            } catch (f.d e2) {
                e = e2;
                b = e.b(e, this.index);
                AppMethodBeat.o(94716);
                throw b;
            } catch (f.h e3) {
                e = e3;
                b = e.b(e, this.index);
                AppMethodBeat.o(94716);
                throw b;
            }
        }
    }

    public final void qD() {
        AppMethodBeat.i(94717);
        try {
            f fVar = this.aRr;
            if (fVar.aQP || !fVar.isInitialized()) {
                AppMethodBeat.o(94717);
                return;
            }
            if (fVar.qo()) {
                fVar.aQc.L(fVar.qt());
                fVar.aQo = 0;
                fVar.aQP = true;
            }
            AppMethodBeat.o(94717);
        } catch (f.h e) {
            e b = e.b(e, this.index);
            AppMethodBeat.o(94717);
            throw b;
        }
    }

    public final void c(int i, Object obj) {
        AppMethodBeat.i(94718);
        f fVar;
        switch (i) {
            case 2:
                fVar = this.aRr;
                float floatValue = ((Float) obj).floatValue();
                if (fVar.aQH != floatValue) {
                    fVar.aQH = floatValue;
                    fVar.qq();
                }
                AppMethodBeat.o(94718);
                return;
            case 3:
                b bVar = (b) obj;
                fVar = this.aRr;
                if (!fVar.aOY.equals(bVar)) {
                    fVar.aOY = bVar;
                    if (!fVar.aQR) {
                        fVar.reset();
                        fVar.aOX = 0;
                    }
                }
                AppMethodBeat.o(94718);
                return;
            default:
                super.c(i, obj);
                AppMethodBeat.o(94718);
                return;
        }
    }
}
