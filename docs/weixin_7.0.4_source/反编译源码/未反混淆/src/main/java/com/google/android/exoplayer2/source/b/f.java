package com.google.android.exoplayer2.source.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.b;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f.c;
import com.google.android.exoplayer2.c.f.u;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.google.android.exoplayer2.source.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class f extends d {
    private static final AtomicInteger biJ = new AtomicInteger();
    private final s aYf;
    private final boolean aZs;
    private volatile boolean bhf;
    private e bhj;
    public final int biK;
    public final a biL;
    private final com.google.android.exoplayer2.h.f biM;
    private final i biN;
    private final boolean biO;
    private final String biP;
    private final e biQ;
    private final boolean biR;
    private final boolean biS;
    private final boolean biT;
    private final com.google.android.exoplayer2.metadata.id3.a biU;
    private final l biV;
    private int biW;
    private int biX;
    private boolean biY;
    private j biZ;
    private final List<Format> bit;
    volatile boolean bja;
    public final int uid;

    static {
        AppMethodBeat.i(125909);
        AppMethodBeat.o(125909);
    }

    public final void a(j jVar) {
        int i = 0;
        this.biZ = jVar;
        int i2 = this.uid;
        boolean z = this.biR;
        jVar.bjt = i2;
        for (k kVar : jVar.bgO) {
            kVar.bhG.bhE = i2;
        }
        if (z) {
            k[] kVarArr = jVar.bgO;
            i2 = kVarArr.length;
            while (i < i2) {
                kVarArr[i].bhP = true;
                i++;
            }
        }
    }

    public final long ss() {
        return (long) this.biX;
    }

    public final void se() {
        this.bhf = true;
    }

    public final boolean sf() {
        return this.bhf;
    }

    public final void sg() {
        int i;
        i am;
        b bVar;
        Object obj = null;
        int i2 = 0;
        AppMethodBeat.i(125908);
        if (this.bhj == null && !this.biT) {
            e lVar;
            boolean i3;
            if ("text/vtt".equals(this.biL.aOv.aOd) || this.biP.endsWith(".webvtt") || this.biP.endsWith(".vtt")) {
                lVar = new l(this.bic.aOt, this.aYf);
                i3 = true;
            } else if (!this.biS) {
                lVar = this.biQ;
                i3 = 0;
            } else if (this.biP.endsWith(VideoMaterialUtil.MP4_SUFFIX) || this.biP.startsWith(".m4", this.biP.length() - 4)) {
                lVar = new com.google.android.exoplayer2.c.d.e(0, this.aYf);
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
                            aK = com.google.android.exoplayer2.i.i.aK(aK22);
                            if (aK != null && com.google.android.exoplayer2.i.i.aH(aK)) {
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
                            aK222 = com.google.android.exoplayer2.i.i.aK(aK222);
                            if (aK222 != null && com.google.android.exoplayer2.i.i.aI(aK222)) {
                                obj = aK222;
                                break;
                            }
                        }
                    }
                    if (!str2.equals(obj)) {
                        i3 |= 4;
                    }
                }
                Object lVar2 = new u(2, this.aYf, new com.google.android.exoplayer2.c.f.e(i3, list));
                i3 = true;
            }
            if (i3 != 0) {
                lVar2.a(this.biZ);
            }
            this.bhj = lVar2;
        }
        if (!(this.biQ == this.bhj || this.biY || this.biN == null)) {
            am = this.biN.am((long) this.biW);
            try {
                bVar = new b(this.biM, am.bpQ, this.biM.a(am));
                i3 = 0;
                while (i3 == 0) {
                    if (!this.bhf) {
                        i3 = this.bhj.a(bVar, null);
                    }
                }
                this.biW = (int) (bVar.getPosition() - this.biN.bpQ);
                v.a(this.aSF);
                this.biY = true;
            } catch (Throwable th) {
                v.a(this.aSF);
                AppMethodBeat.o(125908);
            }
        }
        if (!this.bhf) {
            boolean z;
            if (this.aZs) {
                am = this.bib;
                z = this.biX != 0;
            } else {
                am = this.bib.am((long) this.biX);
                z = false;
            }
            if (!this.biO) {
                this.aYf.tR();
            } else if (this.aYf.bbh == Long.MAX_VALUE) {
                this.aYf.an(this.bif);
            }
            try {
                bVar = new b(this.aSF, am.bpQ, this.aSF.a(am));
                if (this.bhj == null) {
                    long readLong;
                    e cVar;
                    bVar.qY();
                    if (bVar.b(this.biV.data, 0, 10, true)) {
                        this.biV.reset(10);
                        if (this.biV.tD() == com.google.android.exoplayer2.metadata.id3.a.bbg) {
                            this.biV.eM(3);
                            i3 = this.biV.tH();
                            int i4 = i3 + 10;
                            if (i4 > this.biV.capacity()) {
                                byte[] bArr = this.biV.data;
                                this.biV.reset(i4);
                                System.arraycopy(bArr, 0, this.biV.data, 0, 10);
                            }
                            if (bVar.b(this.biV.data, 10, i3, true)) {
                                Metadata d = this.biU.d(this.biV.data, i3);
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
                    readLong = readLong != -9223372036854775807L ? this.aYf.ao(readLong) : this.bif;
                    if (this.biP.endsWith(".aac")) {
                        cVar = new c(readLong);
                    } else if (this.biP.endsWith(".ac3") || this.biP.endsWith(".ec3")) {
                        cVar = new com.google.android.exoplayer2.c.f.a(readLong);
                    } else if (this.biP.endsWith(".mp3")) {
                        cVar = new com.google.android.exoplayer2.c.c.b(0, readLong);
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown extension for audio file: " + this.biP);
                        AppMethodBeat.o(125908);
                        throw illegalArgumentException;
                    }
                    cVar.a(this.biZ);
                    this.bhj = cVar;
                }
                if (z) {
                    bVar.dG(this.biX);
                }
                while (i2 == 0) {
                    if (this.bhf) {
                        break;
                    }
                    i2 = this.bhj.a(bVar, null);
                }
                this.biX = (int) (bVar.getPosition() - this.bib.bpQ);
                v.a(this.aSF);
                this.bja = true;
            } catch (Throwable th2) {
                v.a(this.aSF);
                AppMethodBeat.o(125908);
            }
        }
        AppMethodBeat.o(125908);
    }

    public f(com.google.android.exoplayer2.h.f fVar, i iVar, i iVar2, a aVar, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, s sVar, f fVar2, byte[] bArr, byte[] bArr2) {
        com.google.android.exoplayer2.h.f fVar3;
        if (bArr == null || bArr2 == null) {
            fVar3 = fVar;
        } else {
            fVar3 = new a(fVar, bArr, bArr2);
        }
        super(fVar3, iVar, aVar.aOv, i, obj, j, j2, i2);
        AppMethodBeat.i(125907);
        this.biK = i3;
        this.biN = iVar2;
        this.biL = aVar;
        this.bit = list;
        this.biO = z;
        this.aYf = sVar;
        this.aZs = this.aSF instanceof a;
        this.biP = iVar.uri.getLastPathSegment();
        boolean z2 = this.biP.endsWith(".aac") || this.biP.endsWith(".ac3") || this.biP.endsWith(".ec3") || this.biP.endsWith(".mp3");
        this.biT = z2;
        if (fVar2 != null) {
            this.biU = fVar2.biU;
            this.biV = fVar2.biV;
            this.biQ = fVar2.bhj;
            this.biR = fVar2.biL != aVar;
            z2 = fVar2.biK != i3 || this.biR;
            this.biS = z2;
        } else {
            this.biU = this.biT ? new com.google.android.exoplayer2.metadata.id3.a() : null;
            this.biV = this.biT ? new l(10) : null;
            this.biQ = null;
            this.biR = false;
            this.biS = true;
        }
        this.biM = fVar;
        this.uid = biJ.getAndIncrement();
        AppMethodBeat.o(125907);
    }
}
