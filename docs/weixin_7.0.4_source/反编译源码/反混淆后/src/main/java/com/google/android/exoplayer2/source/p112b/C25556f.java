package com.google.android.exoplayer2.source.p112b;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.C41620a;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C37232b;
import com.google.android.exoplayer2.p101c.p102d.C8647e;
import com.google.android.exoplayer2.p101c.p104f.C37238c;
import com.google.android.exoplayer2.p101c.p104f.C37239e;
import com.google.android.exoplayer2.p101c.p104f.C37243u;
import com.google.android.exoplayer2.p101c.p104f.C8656a;
import com.google.android.exoplayer2.p101c.p1160c.C45021b;
import com.google.android.exoplayer2.p110h.C0867f;
import com.google.android.exoplayer2.p110h.C17665i;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C37265i;
import com.google.android.exoplayer2.p111i.C45042s;
import com.google.android.exoplayer2.source.C25560k;
import com.google.android.exoplayer2.source.p112b.p113a.C25553a.C25552a;
import com.google.android.exoplayer2.source.p1520a.C45046d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.exoplayer2.source.b.f */
final class C25556f extends C45046d {
    private static final AtomicInteger biJ = new AtomicInteger();
    private final C45042s aYf;
    private final boolean aZs;
    private volatile boolean bhf;
    private C32034e bhj;
    public final int biK;
    public final C25552a biL;
    private final C0867f biM;
    private final C17665i biN;
    private final boolean biO;
    private final String biP;
    private final C32034e biQ;
    private final boolean biR;
    private final boolean biS;
    private final boolean biT;
    private final C41620a biU;
    private final C32065l biV;
    private int biW;
    private int biX;
    private boolean biY;
    private C41626j biZ;
    private final List<Format> bit;
    volatile boolean bja;
    public final int uid;

    static {
        AppMethodBeat.m2504i(125909);
        AppMethodBeat.m2505o(125909);
    }

    /* renamed from: a */
    public final void mo42817a(C41626j c41626j) {
        int i = 0;
        this.biZ = c41626j;
        int i2 = this.uid;
        boolean z = this.biR;
        c41626j.bjt = i2;
        for (C25560k c25560k : c41626j.bgO) {
            c25560k.bhG.bhE = i2;
        }
        if (z) {
            C25560k[] c25560kArr = c41626j.bgO;
            i2 = c25560kArr.length;
            while (i < i2) {
                c25560kArr[i].bhP = true;
                i++;
            }
        }
    }

    /* renamed from: ss */
    public final long mo42818ss() {
        return (long) this.biX;
    }

    /* renamed from: se */
    public final void mo19287se() {
        this.bhf = true;
    }

    /* renamed from: sf */
    public final boolean mo19288sf() {
        return this.bhf;
    }

    /* renamed from: sg */
    public final void mo19289sg() {
        int i;
        C17665i am;
        C37232b c37232b;
        Object obj = null;
        int i2 = 0;
        AppMethodBeat.m2504i(125908);
        if (this.bhj == null && !this.biT) {
            C32034e c37276l;
            boolean i3;
            if ("text/vtt".equals(this.biL.aOv.aOd) || this.biP.endsWith(".webvtt") || this.biP.endsWith(".vtt")) {
                c37276l = new C37276l(this.bic.aOt, this.aYf);
                i3 = true;
            } else if (!this.biS) {
                c37276l = this.biQ;
                i3 = 0;
            } else if (this.biP.endsWith(VideoMaterialUtil.MP4_SUFFIX) || this.biP.startsWith(".m4", this.biP.length() - 4)) {
                c37276l = new C8647e(0, this.aYf);
                i3 = true;
            } else {
                i3 = 16;
                List list = this.bit;
                if (list != null) {
                    i3 = 48;
                } else {
                    list = Collections.emptyList();
                }
                String str = this.bic.aOa;
                if (!TextUtils.isEmpty(str)) {
                    Object aK;
                    String aK2;
                    String str2 = "audio/mp4a-latm";
                    if (str != null) {
                        for (String aK22 : str.split(",")) {
                            aK = C37265i.m62525aK(aK22);
                            if (aK != null && C37265i.m62522aH(aK)) {
                                break;
                            }
                        }
                    }
                    aK = null;
                    if (!str2.equals(aK)) {
                        i3 |= 2;
                    }
                    str2 = "video/avc";
                    if (str != null) {
                        for (String aK222 : str.split(",")) {
                            aK222 = C37265i.m62525aK(aK222);
                            if (aK222 != null && C37265i.m62523aI(aK222)) {
                                obj = aK222;
                                break;
                            }
                        }
                    }
                    if (!str2.equals(obj)) {
                        i3 |= 4;
                    }
                }
                Object c37276l2 = new C37243u(2, this.aYf, new C37239e(i3, list));
                i3 = true;
            }
            if (i3 != 0) {
                c37276l2.mo2569a(this.biZ);
            }
            this.bhj = c37276l2;
        }
        if (!(this.biQ == this.bhj || this.biY || this.biN == null)) {
            am = this.biN.mo32358am((long) this.biW);
            try {
                c37232b = new C37232b(this.biM, am.bpQ, this.biM.mo2583a(am));
                i3 = 0;
                while (i3 == 0) {
                    if (!this.bhf) {
                        i3 = this.bhj.mo2568a(c37232b, null);
                    }
                }
                this.biW = (int) (c37232b.getPosition() - this.biN.bpQ);
                C17675v.m27555a(this.aSF);
                this.biY = true;
            } catch (Throwable th) {
                C17675v.m27555a(this.aSF);
                AppMethodBeat.m2505o(125908);
            }
        }
        if (!this.bhf) {
            boolean z;
            if (this.aZs) {
                am = this.bib;
                z = this.biX != 0;
            } else {
                am = this.bib.mo32358am((long) this.biX);
                z = false;
            }
            if (!this.biO) {
                this.aYf.mo72554tR();
            } else if (this.aYf.bbh == Long.MAX_VALUE) {
                this.aYf.mo72550an(this.bif);
            }
            try {
                c37232b = new C37232b(this.aSF, am.bpQ, this.aSF.mo2583a(am));
                if (this.bhj == null) {
                    long readLong;
                    C32034e c37238c;
                    c37232b.mo59486qY();
                    if (c37232b.mo59480b(this.biV.data, 0, 10, true)) {
                        this.biV.reset(10);
                        if (this.biV.mo52384tD() == C41620a.bbg) {
                            this.biV.mo52369eM(3);
                            i3 = this.biV.mo52388tH();
                            int i4 = i3 + 10;
                            if (i4 > this.biV.capacity()) {
                                byte[] bArr = this.biV.data;
                                this.biV.reset(i4);
                                System.arraycopy(bArr, 0, this.biV.data, 0, 10);
                            }
                            if (c37232b.mo59480b(this.biV.data, 10, i3, true)) {
                                Metadata d = this.biU.mo66752d(this.biV.data, i3);
                                if (d != null) {
                                    for (Entry entry : d.beW) {
                                        if (entry instanceof PrivFrame) {
                                            PrivFrame privFrame = (PrivFrame) entry;
                                            if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.bfz)) {
                                                System.arraycopy(privFrame.bfA, 0, this.biV.data, 0, 8);
                                                this.biV.reset(8);
                                                readLong = this.biV.readLong();
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    readLong = -9223372036854775807L;
                    readLong = readLong != -9223372036854775807L ? this.aYf.mo72551ao(readLong) : this.bif;
                    if (this.biP.endsWith(".aac")) {
                        c37238c = new C37238c(readLong);
                    } else if (this.biP.endsWith(".ac3") || this.biP.endsWith(".ec3")) {
                        c37238c = new C8656a(readLong);
                    } else if (this.biP.endsWith(".mp3")) {
                        c37238c = new C45021b(0, readLong);
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown extension for audio file: " + this.biP);
                        AppMethodBeat.m2505o(125908);
                        throw illegalArgumentException;
                    }
                    c37238c.mo2569a(this.biZ);
                    this.bhj = c37238c;
                }
                if (z) {
                    c37232b.mo59482dG(this.biX);
                }
                while (i2 == 0) {
                    if (this.bhf) {
                        break;
                    }
                    i2 = this.bhj.mo2568a(c37232b, null);
                }
                this.biX = (int) (c37232b.getPosition() - this.bib.bpQ);
                C17675v.m27555a(this.aSF);
                this.bja = true;
            } catch (Throwable th2) {
                C17675v.m27555a(this.aSF);
                AppMethodBeat.m2505o(125908);
            }
        }
        AppMethodBeat.m2505o(125908);
    }

    public C25556f(C0867f c0867f, C17665i c17665i, C17665i c17665i2, C25552a c25552a, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, C45042s c45042s, C25556f c25556f, byte[] bArr, byte[] bArr2) {
        C0867f c0867f2;
        if (bArr == null || bArr2 == null) {
            c0867f2 = c0867f;
        } else {
            c0867f2 = new C37274a(c0867f, bArr, bArr2);
        }
        super(c0867f2, c17665i, c25552a.aOv, i, obj, j, j2, i2);
        AppMethodBeat.m2504i(125907);
        this.biK = i3;
        this.biN = c17665i2;
        this.biL = c25552a;
        this.bit = list;
        this.biO = z;
        this.aYf = c45042s;
        this.aZs = this.aSF instanceof C37274a;
        this.biP = c17665i.uri.getLastPathSegment();
        boolean z2 = this.biP.endsWith(".aac") || this.biP.endsWith(".ac3") || this.biP.endsWith(".ec3") || this.biP.endsWith(".mp3");
        this.biT = z2;
        if (c25556f != null) {
            this.biU = c25556f.biU;
            this.biV = c25556f.biV;
            this.biQ = c25556f.bhj;
            this.biR = c25556f.biL != c25552a;
            z2 = c25556f.biK != i3 || this.biR;
            this.biS = z2;
        } else {
            this.biU = this.biT ? new C41620a() : null;
            this.biV = this.biT ? new C32065l(10) : null;
            this.biQ = null;
            this.biR = false;
            this.biS = true;
        }
        this.biM = c0867f;
        this.uid = biJ.getAndIncrement();
        AppMethodBeat.m2505o(125907);
    }
}
