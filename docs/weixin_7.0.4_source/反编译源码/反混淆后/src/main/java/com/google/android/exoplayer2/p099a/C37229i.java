package com.google.android.exoplayer2.p099a;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C17628b;
import com.google.android.exoplayer2.C25533e;
import com.google.android.exoplayer2.C45045p;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.C41600b;
import com.google.android.exoplayer2.drm.C44648d;
import com.google.android.exoplayer2.p099a.C0826e.C0827a;
import com.google.android.exoplayer2.p099a.C0826e.C0827a.C08296;
import com.google.android.exoplayer2.p099a.C0826e.C0827a.C08304;
import com.google.android.exoplayer2.p099a.C0826e.C0827a.C08311;
import com.google.android.exoplayer2.p099a.C0826e.C0827a.C08322;
import com.google.android.exoplayer2.p099a.C0826e.C0827a.C08333;
import com.google.android.exoplayer2.p099a.C45018f.C17627c;
import com.google.android.exoplayer2.p099a.C45018f.C32020f;
import com.google.android.exoplayer2.p099a.C45018f.C37226g;
import com.google.android.exoplayer2.p099a.C45018f.C37227h;
import com.google.android.exoplayer2.p099a.C45018f.C45017d;
import com.google.android.exoplayer2.p099a.C8640d.C8641a;
import com.google.android.exoplayer2.p100b.C32021d;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32063h;
import com.google.android.exoplayer2.p111i.C37265i;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.p797e.C17652c;
import com.google.android.exoplayer2.p797e.C44649b;
import com.google.android.exoplayer2.p797e.C45029a;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.a.i */
public final class C37229i extends C44649b implements C32063h {
    private int aOn;
    private int aOo;
    private final C0827a aRq;
    private final C45018f aRr;
    private boolean aRs;
    private boolean aRt;
    private MediaFormat aRu;
    private long aRv;
    private boolean aRw;

    /* renamed from: com.google.android.exoplayer2.a.i$a */
    final class C37230a implements C32020f {
        private C37230a() {
        }

        /* synthetic */ C37230a(C37229i c37229i, byte b) {
            this();
        }

        /* renamed from: dx */
        public final void mo52312dx(int i) {
            AppMethodBeat.m2504i(94696);
            C0827a a = C37229i.this.aRq;
            if (a.aPH != null) {
                a.handler.post(new C08296(i));
            }
            AppMethodBeat.m2505o(94696);
        }

        /* renamed from: qe */
        public final void mo52314qe() {
            AppMethodBeat.m2504i(94697);
            C37229i.this.aRw = true;
            AppMethodBeat.m2505o(94697);
        }

        /* renamed from: e */
        public final void mo52313e(int i, long j, long j2) {
            AppMethodBeat.m2504i(94698);
            C0827a a = C37229i.this.aRq;
            if (a.aPH != null) {
                a.handler.post(new C08304(i, j, j2));
            }
            AppMethodBeat.m2505o(94698);
        }
    }

    public C37229i(C17652c c17652c, C41600b<C44648d> c41600b, Handler handler, C0826e c0826e, C8639c c8639c, C8640d... c8640dArr) {
        super(1, c17652c, c41600b, true);
        AppMethodBeat.m2504i(94699);
        this.aRr = new C45018f(c8639c, c8640dArr, new C37230a(this, (byte) 0));
        this.aRq = new C0827a(handler, c0826e);
        AppMethodBeat.m2505o(94699);
    }

    /* JADX WARNING: Missing block: B:22:0x0053, code skipped:
            if (r2 != 0) goto L_0x0055;
     */
    /* JADX WARNING: Missing block: B:28:0x0066, code skipped:
            if (r2 != 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo59458a(C17652c c17652c, Format format) {
        int i = 0;
        AppMethodBeat.m2504i(94700);
        String str = format.aOd;
        if (C37265i.m62522aH(str)) {
            int i2;
            if (C17675v.SDK_INT >= 21) {
                i2 = 32;
            } else {
                i2 = 0;
            }
            if (!m62396av(str) || c17652c.mo19162rJ() == null) {
                C45029a e = c17652c.mo19161e(str, false);
                if (e == null) {
                    AppMethodBeat.m2505o(94700);
                    return 1;
                }
                if (C17675v.SDK_INT >= 21) {
                    int i3;
                    if (format.sampleRate != -1) {
                        i3 = format.sampleRate;
                        if (e.bdZ == null) {
                            e.mo72545ax("sampleRate.caps");
                            i3 = 0;
                        } else {
                            AudioCapabilities audioCapabilities = e.bdZ.getAudioCapabilities();
                            if (audioCapabilities == null) {
                                e.mo72545ax("sampleRate.aCaps");
                                i3 = 0;
                            } else if (audioCapabilities.isSampleRateSupported(i3)) {
                                i3 = 1;
                            } else {
                                e.mo72545ax("sampleRate.support, ".concat(String.valueOf(i3)));
                                i3 = 0;
                            }
                        }
                    }
                    if (format.aOn != -1) {
                        int i4 = format.aOn;
                        if (e.bdZ == null) {
                            e.mo72545ax("channelCount.caps");
                            i3 = 0;
                        } else {
                            AudioCapabilities audioCapabilities2 = e.bdZ.getAudioCapabilities();
                            if (audioCapabilities2 == null) {
                                e.mo72545ax("channelCount.aCaps");
                                i3 = 0;
                            } else {
                                String str2 = e.name;
                                String str3 = e.mimeType;
                                int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                                if (maxInputChannelCount > 1 || (C17675v.SDK_INT >= 26 && maxInputChannelCount > 0)) {
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
                                    e.mo72545ax("channelCount.support, ".concat(String.valueOf(i4)));
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
                AppMethodBeat.m2505o(94700);
                return i;
            }
            i = (i2 | 8) | 4;
            AppMethodBeat.m2505o(94700);
            return i;
        }
        AppMethodBeat.m2505o(94700);
        return 0;
    }

    /* renamed from: a */
    public final C45029a mo59459a(C17652c c17652c, Format format, boolean z) {
        C45029a rJ;
        AppMethodBeat.m2504i(94701);
        if (m62396av(format.aOd)) {
            rJ = c17652c.mo19162rJ();
            if (rJ != null) {
                this.aRs = true;
                AppMethodBeat.m2505o(94701);
                return rJ;
            }
        }
        this.aRs = false;
        rJ = super.mo59459a(c17652c, format, z);
        AppMethodBeat.m2505o(94701);
        return rJ;
    }

    /* renamed from: av */
    private boolean m62396av(String str) {
        AppMethodBeat.m2504i(94702);
        boolean at = this.aRr.mo72528at(str);
        AppMethodBeat.m2505o(94702);
        return at;
    }

    /* renamed from: a */
    public final void mo59460a(C45029a c45029a, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        boolean z;
        AppMethodBeat.m2504i(94703);
        String str = c45029a.name;
        if (C17675v.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(C17675v.MANUFACTURER) && (C17675v.DEVICE.startsWith("zeroflte") || C17675v.DEVICE.startsWith("herolte") || C17675v.DEVICE.startsWith("heroqlte"))) {
            z = true;
        } else {
            z = false;
        }
        this.aRt = z;
        if (this.aRs) {
            this.aRu = format.mo19121qc();
            this.aRu.setString("mime", "audio/raw");
            mediaCodec.configure(this.aRu, null, mediaCrypto, 0);
            this.aRu.setString("mime", format.aOd);
            AppMethodBeat.m2505o(94703);
            return;
        }
        mediaCodec.configure(format.mo19121qc(), null, mediaCrypto, 0);
        this.aRu = null;
        AppMethodBeat.m2505o(94703);
    }

    /* renamed from: pD */
    public final C32063h mo52405pD() {
        return this;
    }

    /* renamed from: c */
    public final void mo59464c(String str, long j, long j2) {
        AppMethodBeat.m2504i(94704);
        C0827a c0827a = this.aRq;
        if (c0827a.aPH != null) {
            c0827a.handler.post(new C08322(str, j, j2));
        }
        AppMethodBeat.m2505o(94704);
    }

    /* renamed from: e */
    public final void mo59465e(Format format) {
        AppMethodBeat.m2504i(94705);
        super.mo59465e(format);
        C0827a c0827a = this.aRq;
        if (c0827a.aPH != null) {
            c0827a.handler.post(new C08333(format));
        }
        this.aOo = "audio/raw".equals(format.aOd) ? format.aOo : 2;
        this.aOn = format.aOn;
        AppMethodBeat.m2505o(94705);
    }

    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        Object string;
        int i;
        int[] iArr;
        AppMethodBeat.m2504i(94706);
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
        C17627c c17627c;
        try {
            int au;
            int i2;
            C45018f c45018f = this.aRr;
            i = this.aOo;
            boolean z = !"audio/raw".equals(string2);
            if (z) {
                au = C45018f.m82456au(string2);
            } else {
                au = i;
            }
            int i3 = 0;
            if (z) {
                i2 = 0;
            } else {
                c45018f.aQw = C17675v.m27566bj(i, integer);
                c45018f.aPW.aRk = iArr;
                i = integer;
                for (C8640d c8640d : c45018f.aPY) {
                    i3 |= c8640d.mo19136r(integer2, i, au);
                    if (c8640d.isActive()) {
                        i = c8640d.mo19133qk();
                        au = 2;
                    }
                }
                if (i3 != 0) {
                    c45018f.mo72532qn();
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
                    i = C17628b.CHANNEL_OUT_7POINT1_SURROUND;
                    break;
                default:
                    c17627c = new C17627c("Unsupported channel count: ".concat(String.valueOf(integer)));
                    AppMethodBeat.m2505o(94706);
                    throw c17627c;
            }
            if (C17675v.SDK_INT <= 23 && "foster".equals(C17675v.DEVICE) && "NVIDIA".equals(C17675v.MANUFACTURER)) {
                switch (integer) {
                    case 3:
                    case 5:
                        i = 252;
                        break;
                    case 7:
                        i = C17628b.CHANNEL_OUT_7POINT1_SURROUND;
                        break;
                }
            }
            if (C17675v.SDK_INT <= 25 && "fugu".equals(C17675v.DEVICE) && z && integer == 1) {
                i3 = 12;
            } else {
                i3 = i;
            }
            if (!(i2 == 0 && c45018f.isInitialized() && c45018f.encoding == au && c45018f.sampleRate == integer2 && c45018f.aQg == i3)) {
                C45018f c45018f2;
                long j;
                c45018f.reset();
                c45018f.encoding = au;
                c45018f.aQi = z;
                c45018f.sampleRate = integer2;
                c45018f.aQg = i3;
                c45018f.aQh = z ? au : 2;
                c45018f.aQz = C17675v.m27566bj(2, integer);
                if (!z) {
                    au = AudioTrack.getMinBufferSize(integer2, i3, c45018f.aQh);
                    C45039a.checkState(au != -2);
                    i3 = au * 4;
                    i = ((int) c45018f.mo72525K(250000)) * c45018f.aQz;
                    au = (int) Math.max((long) au, c45018f.mo72525K(750000) * ((long) c45018f.aQz));
                    if (i3 < i) {
                        c45018f2 = c45018f;
                    } else if (i3 > au) {
                        i = au;
                        c45018f2 = c45018f;
                    } else {
                        i = i3;
                        c45018f2 = c45018f;
                    }
                } else if (c45018f.aQh == 5 || c45018f.aQh == 6) {
                    i = 20480;
                    c45018f2 = c45018f;
                } else {
                    i = 49152;
                    c45018f2 = c45018f;
                }
                c45018f2.bufferSize = i;
                if (z) {
                    j = -9223372036854775807L;
                } else {
                    j = c45018f.mo72524J((long) (c45018f.bufferSize / c45018f.aQz));
                }
                c45018f.aQj = j;
                c45018f.mo72529b(c45018f.aNg);
            }
            AppMethodBeat.m2505o(94706);
        } catch (C8641a e) {
            C17627c c17627c2 = new C17627c(e);
            AppMethodBeat.m2505o(94706);
            throw c17627c2;
        } catch (C17627c c17627c3) {
            C25533e b = C25533e.m40358b(c17627c3, this.index);
            AppMethodBeat.m2505o(94706);
            throw b;
        }
    }

    /* renamed from: aD */
    public final void mo59462aD(boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(94707);
        super.mo59462aD(z);
        C0827a c0827a = this.aRq;
        C32021d c32021d = this.beI;
        if (c0827a.aPH != null) {
            c0827a.handler.post(new C08311(c32021d));
        }
        int i = this.aMs.aOF;
        if (i != 0) {
            C45018f c45018f = this.aRr;
            if (C17675v.SDK_INT >= 21) {
                z2 = true;
            }
            C45039a.checkState(z2);
            if (!(c45018f.aQR && c45018f.aOX == i)) {
                c45018f.aQR = true;
                c45018f.aOX = i;
                c45018f.reset();
            }
            AppMethodBeat.m2505o(94707);
            return;
        }
        C45018f c45018f2 = this.aRr;
        if (c45018f2.aQR) {
            c45018f2.aQR = false;
            c45018f2.aOX = 0;
            c45018f2.reset();
        }
        AppMethodBeat.m2505o(94707);
    }

    /* renamed from: b */
    public final void mo32349b(long j, boolean z) {
        AppMethodBeat.m2504i(94708);
        super.mo32349b(j, z);
        this.aRr.reset();
        this.aRv = j;
        this.aRw = true;
        AppMethodBeat.m2505o(94708);
    }

    public final void onStarted() {
        AppMethodBeat.m2504i(94709);
        super.onStarted();
        this.aRr.play();
        AppMethodBeat.m2505o(94709);
    }

    public final void onStopped() {
        AppMethodBeat.m2504i(94710);
        C45018f c45018f = this.aRr;
        c45018f.aQQ = false;
        if (c45018f.isInitialized()) {
            c45018f.mo72539qu();
            c45018f.aQc.pause();
        }
        super.onStopped();
        AppMethodBeat.m2505o(94710);
    }

    /* renamed from: pK */
    public final void mo32353pK() {
        AppMethodBeat.m2504i(94711);
        try {
            C45018f c45018f = this.aRr;
            c45018f.reset();
            c45018f.mo72536qr();
            for (C8640d reset : c45018f.aPY) {
                reset.reset();
            }
            c45018f.aOX = 0;
            c45018f.aQQ = false;
            try {
                super.mo32353pK();
            } finally {
                this.aRq.mo2528e(this.beI);
                AppMethodBeat.m2505o(94711);
            }
        } catch (Throwable th) {
            super.mo32353pK();
        } finally {
            this.aRq.mo2528e(this.beI);
            AppMethodBeat.m2505o(94711);
        }
    }

    /* renamed from: qf */
    public final boolean mo32354qf() {
        AppMethodBeat.m2504i(94712);
        if (super.mo32354qf()) {
            boolean z;
            C45018f c45018f = this.aRr;
            if (!c45018f.isInitialized() || (c45018f.aQP && !c45018f.mo72534qp())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.m2505o(94712);
                return true;
            }
        }
        AppMethodBeat.m2505o(94712);
        return false;
    }

    public final boolean isReady() {
        AppMethodBeat.m2504i(94713);
        if (this.aRr.mo72534qp() || super.isReady()) {
            AppMethodBeat.m2505o(94713);
            return true;
        }
        AppMethodBeat.m2505o(94713);
        return false;
    }

    /* renamed from: qy */
    public final long mo52353qy() {
        AppMethodBeat.m2504i(94714);
        long aI = this.aRr.mo72527aI(mo32354qf());
        if (aI != Long.MIN_VALUE) {
            if (!this.aRw) {
                aI = Math.max(this.aRv, aI);
            }
            this.aRv = aI;
            this.aRw = false;
        }
        aI = this.aRv;
        AppMethodBeat.m2505o(94714);
        return aI;
    }

    /* renamed from: b */
    public final C45045p mo52351b(C45045p c45045p) {
        AppMethodBeat.m2504i(94715);
        C45045p b = this.aRr.mo72529b(c45045p);
        AppMethodBeat.m2505o(94715);
        return b;
    }

    /* renamed from: qC */
    public final C45045p mo52352qC() {
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
            if (r10.aQc.mo2540qx() != 0) goto L_0x00c9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo59461a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        Exception e;
        C25533e b;
        AppMethodBeat.m2504i(94716);
        C32021d c32021d;
        if (this.aRs && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            AppMethodBeat.m2505o(94716);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            c32021d = this.beI;
            c32021d.aSg++;
            C45018f c45018f = this.aRr;
            if (c45018f.aQD == 1) {
                c45018f.aQD = 2;
            }
            AppMethodBeat.m2505o(94716);
            return true;
        } else {
            try {
                Object obj;
                C45018f c45018f2 = this.aRr;
                boolean z2 = c45018f2.aQK == null || byteBuffer == c45018f2.aQK;
                C45039a.checkArgument(z2);
                if (!c45018f2.isInitialized()) {
                    c45018f2.aQa.block();
                    c45018f2.aQf = c45018f2.mo72541qw();
                    int audioSessionId = c45018f2.aQf.getAudioSessionId();
                    if (C45018f.aPT && C17675v.SDK_INT < 21) {
                        if (!(c45018f2.aQe == null || audioSessionId == c45018f2.aQe.getAudioSessionId())) {
                            c45018f2.mo72536qr();
                        }
                        if (c45018f2.aQe == null) {
                            c45018f2.aQe = new AudioTrack(3, WearableStatusCodes.TARGET_NODE_NOT_CONNECTED, 4, 2, 2, 0, audioSessionId);
                        }
                    }
                    if (c45018f2.aOX != audioSessionId) {
                        c45018f2.aOX = audioSessionId;
                        c45018f2.aPZ.mo52312dx(audioSessionId);
                    }
                    c45018f2.aQc.mo2536a(c45018f2.aQf, c45018f2.mo72540qv());
                    c45018f2.mo72535qq();
                    c45018f2.aQS = false;
                    if (c45018f2.aQQ) {
                        c45018f2.play();
                    }
                }
                if (c45018f2.mo72540qv()) {
                    if (c45018f2.aQf.getPlayState() == 2) {
                        c45018f2.aQS = false;
                    } else if (c45018f2.aQf.getPlayState() == 1) {
                    }
                    obj = null;
                    if (obj != null) {
                        mediaCodec.releaseOutputBuffer(i, false);
                        c32021d = this.beI;
                        c32021d.aSf++;
                        AppMethodBeat.m2505o(94716);
                        return true;
                    }
                    AppMethodBeat.m2505o(94716);
                    return false;
                }
                z2 = c45018f2.aQS;
                c45018f2.aQS = c45018f2.mo72534qp();
                if (!(!z2 || c45018f2.aQS || c45018f2.aQf.getPlayState() == 1)) {
                    c45018f2.aPZ.mo52313e(c45018f2.bufferSize, C17628b.m27433w(c45018f2.aQj), SystemClock.elapsedRealtime() - c45018f2.aQT);
                }
                if (c45018f2.aQK == null) {
                    if (byteBuffer.hasRemaining()) {
                        if (c45018f2.aQi && c45018f2.aQC == 0) {
                            int i3 = c45018f2.aQh;
                            if (i3 == 7 || i3 == 8) {
                                i3 = C45019h.m82475h(byteBuffer);
                            } else if (i3 == 5) {
                                i3 = C32018a.m51995qj();
                            } else if (i3 == 6) {
                                i3 = C32018a.m51993f(byteBuffer);
                            } else {
                                IllegalStateException illegalStateException = new IllegalStateException("Unexpected audio encoding: ".concat(String.valueOf(i3)));
                                AppMethodBeat.m2505o(94716);
                                throw illegalStateException;
                            }
                            c45018f2.aQC = i3;
                        }
                        if (c45018f2.aQk != null) {
                            if (c45018f2.mo72533qo()) {
                                c45018f2.aQd.add(new C37226g(c45018f2.aQk, Math.max(0, j3), c45018f2.mo72524J(c45018f2.mo72538qt()), (byte) 0));
                                c45018f2.aQk = null;
                                c45018f2.mo72532qn();
                            }
                            obj = null;
                            if (obj != null) {
                            }
                        }
                        if (c45018f2.aQD == 0) {
                            c45018f2.aQE = Math.max(0, j3);
                            c45018f2.aQD = 1;
                        } else {
                            long J = c45018f2.aQE + c45018f2.mo72524J(c45018f2.mo72537qs());
                            if (c45018f2.aQD == 1 && Math.abs(J - j3) > 200000) {
                                new StringBuilder("Discontinuity detected [expected ").append(J).append(", got ").append(j3).append("]");
                                c45018f2.aQD = 2;
                            }
                            if (c45018f2.aQD == 2) {
                                c45018f2.aQE = (j3 - J) + c45018f2.aQE;
                                c45018f2.aQD = 1;
                                c45018f2.aPZ.mo52314qe();
                            }
                        }
                        if (c45018f2.aQi) {
                            c45018f2.aQy += (long) c45018f2.aQC;
                        } else {
                            c45018f2.aQx += (long) byteBuffer.remaining();
                        }
                        c45018f2.aQK = byteBuffer;
                    } else {
                        obj = 1;
                        if (obj != null) {
                        }
                    }
                }
                if (c45018f2.aQi) {
                    c45018f2.mo72526a(c45018f2.aQK, j3);
                } else {
                    c45018f2.mo72523H(j3);
                }
                if (!c45018f2.aQK.hasRemaining()) {
                    c45018f2.aQK = null;
                    obj = 1;
                    if (obj != null) {
                    }
                }
                obj = null;
                if (obj != null) {
                }
            } catch (C45017d e2) {
                e = e2;
                b = C25533e.m40358b(e, this.index);
                AppMethodBeat.m2505o(94716);
                throw b;
            } catch (C37227h e3) {
                e = e3;
                b = C25533e.m40358b(e, this.index);
                AppMethodBeat.m2505o(94716);
                throw b;
            }
        }
    }

    /* renamed from: qD */
    public final void mo59469qD() {
        AppMethodBeat.m2504i(94717);
        try {
            C45018f c45018f = this.aRr;
            if (c45018f.aQP || !c45018f.isInitialized()) {
                AppMethodBeat.m2505o(94717);
                return;
            }
            if (c45018f.mo72533qo()) {
                c45018f.aQc.mo2535L(c45018f.mo72538qt());
                c45018f.aQo = 0;
                c45018f.aQP = true;
            }
            AppMethodBeat.m2505o(94717);
        } catch (C37227h e) {
            C25533e b = C25533e.m40358b(e, this.index);
            AppMethodBeat.m2505o(94717);
            throw b;
        }
    }

    /* renamed from: c */
    public final void mo59463c(int i, Object obj) {
        AppMethodBeat.m2504i(94718);
        C45018f c45018f;
        switch (i) {
            case 2:
                c45018f = this.aRr;
                float floatValue = ((Float) obj).floatValue();
                if (c45018f.aQH != floatValue) {
                    c45018f.aQH = floatValue;
                    c45018f.mo72535qq();
                }
                AppMethodBeat.m2505o(94718);
                return;
            case 3:
                C0824b c0824b = (C0824b) obj;
                c45018f = this.aRr;
                if (!c45018f.aOY.equals(c0824b)) {
                    c45018f.aOY = c0824b;
                    if (!c45018f.aQR) {
                        c45018f.reset();
                        c45018f.aOX = 0;
                    }
                }
                AppMethodBeat.m2505o(94718);
                return;
            default:
                super.mo59463c(i, obj);
                AppMethodBeat.m2505o(94718);
                return;
        }
    }
}
