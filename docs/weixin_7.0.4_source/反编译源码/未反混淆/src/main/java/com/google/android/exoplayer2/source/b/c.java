package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

final class c {
    private byte[] aTc;
    private String biA;
    f biB;
    private byte[] bil;
    private final com.google.android.exoplayer2.h.f bin;
    private final com.google.android.exoplayer2.h.f bio;
    private final k bip;
    private final com.google.android.exoplayer2.source.b.a.a.a[] biq;
    private final e bir;
    final o bis;
    private final List<Format> bit;
    boolean biu;
    byte[] biv;
    IOException biw;
    private com.google.android.exoplayer2.source.b.a.a.a bix;
    private boolean biy;
    private Uri biz;

    static final class a extends com.google.android.exoplayer2.source.a.c {
        public final String biC;
        byte[] result;

        public a(com.google.android.exoplayer2.h.f fVar, i iVar, Format format, int i, Object obj, byte[] bArr, String str) {
            super(fVar, iVar, format, i, obj, bArr);
            this.biC = str;
        }

        public final void f(byte[] bArr, int i) {
            AppMethodBeat.i(125899);
            this.result = Arrays.copyOf(bArr, i);
            AppMethodBeat.o(125899);
        }
    }

    public static final class b {
        public com.google.android.exoplayer2.source.a.a biD;
        public boolean biE;
        public com.google.android.exoplayer2.source.b.a.a.a biF;

        public b() {
            AppMethodBeat.i(125900);
            clear();
            AppMethodBeat.o(125900);
        }

        public final void clear() {
            this.biD = null;
            this.biE = false;
            this.biF = null;
        }
    }

    static final class c extends com.google.android.exoplayer2.g.b {
        private int biG;

        public c(o oVar, int[] iArr) {
            super(oVar, iArr);
            AppMethodBeat.i(125901);
            this.biG = j(oVar.bhv[0]);
            AppMethodBeat.o(125901);
        }

        public final void ag(long j) {
            AppMethodBeat.i(125902);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (j(this.biG, elapsedRealtime)) {
                int i = this.length - 1;
                while (i >= 0) {
                    if (j(i, elapsedRealtime)) {
                        i--;
                    } else {
                        this.biG = i;
                        AppMethodBeat.o(125902);
                        return;
                    }
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(125902);
                throw illegalStateException;
            }
            AppMethodBeat.o(125902);
        }

        public final int su() {
            return this.biG;
        }

        public final int sv() {
            return 0;
        }

        public final Object sw() {
            return null;
        }
    }

    public c(e eVar, com.google.android.exoplayer2.source.b.a.a.a[] aVarArr, d dVar, k kVar, List<Format> list) {
        AppMethodBeat.i(125903);
        this.bir = eVar;
        this.biq = aVarArr;
        this.bip = kVar;
        this.bit = list;
        Format[] formatArr = new Format[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            formatArr[i] = aVarArr[i].aOv;
            iArr[i] = i;
        }
        this.bin = dVar.st();
        this.bio = dVar.st();
        this.bis = new o(formatArr);
        this.biB = new c(this.bis, iArr);
        AppMethodBeat.o(125903);
    }

    public final void rW() {
        AppMethodBeat.i(125904);
        if (this.biw != null) {
            IOException iOException = this.biw;
            AppMethodBeat.o(125904);
            throw iOException;
        }
        if (this.bix != null) {
            this.bir.d(this.bix);
        }
        AppMethodBeat.o(125904);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(f fVar, long j, b bVar) {
        int i;
        long j2;
        Object obj;
        AppMethodBeat.i(125905);
        if (fVar == null) {
            i = -1;
        } else {
            i = this.bis.j(fVar.bic);
        }
        this.bix = null;
        if (fVar == null) {
            j2 = 0;
        } else {
            j2 = Math.max(0, (this.biy ? fVar.big : fVar.bif) - j);
        }
        this.biB.ag(j2);
        int th = this.biB.th();
        Object obj2;
        if (i != th) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        com.google.android.exoplayer2.source.b.a.a.a aVar = this.biq[th];
        com.google.android.exoplayer2.source.b.a.e.a aVar2 = (com.google.android.exoplayer2.source.b.a.e.a) this.bir.bkC.get(aVar);
        if (aVar2.bkN != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000, com.google.android.exoplayer2.b.w(aVar2.bkN.aOz));
            if (aVar2.bkN.bjP || aVar2.bkN.bjI == 2 || aVar2.bkN.bjI == 1 || max + aVar2.bkO > elapsedRealtime) {
                obj = 1;
                if (obj != null) {
                    bVar.biF = aVar;
                    this.bix = aVar;
                    AppMethodBeat.o(125905);
                    return;
                }
                com.google.android.exoplayer2.source.b.a.b bVar2;
                com.google.android.exoplayer2.source.b.a.a.a aVar3;
                int i2;
                int i3;
                com.google.android.exoplayer2.source.b.a.b c = this.bir.c(aVar);
                this.biy = c.bjO;
                if (fVar == null || obj2 != null) {
                    if (fVar != null) {
                        j = this.biy ? fVar.big : fVar.bif;
                    }
                    if (c.bjP || j < c.sC()) {
                        com.google.android.exoplayer2.source.b.a.b bVar3;
                        com.google.android.exoplayer2.source.b.a.a.a aVar4;
                        List list = c.bjS;
                        Object valueOf = Long.valueOf(j - c.bif);
                        boolean z = !this.bir.bkJ || fVar == null;
                        int a = v.a(list, valueOf, z) + c.bjM;
                        if (a >= c.bjM || fVar == null) {
                            bVar3 = c;
                            aVar4 = aVar;
                            i = th;
                        } else {
                            aVar4 = this.biq[i];
                            bVar3 = this.bir.c(aVar4);
                            a = fVar.bih + 1;
                        }
                        bVar2 = bVar3;
                        aVar3 = aVar4;
                        i2 = i;
                        i3 = a;
                    } else {
                        i3 = c.bjM + c.bjS.size();
                        bVar2 = c;
                        aVar3 = aVar;
                        i2 = th;
                    }
                } else {
                    i3 = fVar.bih + 1;
                    bVar2 = c;
                    aVar3 = aVar;
                    i2 = th;
                }
                if (i3 < bVar2.bjM) {
                    this.biw = new com.google.android.exoplayer2.source.b();
                    AppMethodBeat.o(125905);
                    return;
                }
                int i4 = i3 - bVar2.bjM;
                if (i4 < bVar2.bjS.size()) {
                    i iVar;
                    s sVar;
                    com.google.android.exoplayer2.source.b.a.b.a aVar5 = (com.google.android.exoplayer2.source.b.a.b.a) bVar2.bjS.get(i4);
                    if (aVar5.aZs) {
                        Uri m = u.m(bVar2.bjZ, aVar5.bjV);
                        if (!m.equals(this.biz)) {
                            bVar.biD = new a(this.bio, new i(m, (byte) 0), this.biq[i2].aOv, this.biB.sv(), this.biB.sw(), this.biv, aVar5.bjW);
                            AppMethodBeat.o(125905);
                            return;
                        } else if (!v.j(aVar5.bjW, this.biA)) {
                            a(m, aVar5.bjW, this.aTc);
                        }
                    } else {
                        this.biz = null;
                        this.aTc = null;
                        this.biA = null;
                        this.bil = null;
                    }
                    com.google.android.exoplayer2.source.b.a.b.a aVar6 = bVar2.bjR;
                    if (aVar6 != null) {
                        iVar = new i(u.m(bVar2.bjZ, aVar6.url), aVar6.bjX, aVar6.bjY, null);
                    } else {
                        iVar = null;
                    }
                    long j3 = bVar2.bif + aVar5.bjU;
                    int i5 = bVar2.bjL + aVar5.bjT;
                    k kVar = this.bip;
                    s sVar2 = (s) kVar.bjA.get(i5);
                    if (sVar2 == null) {
                        s sVar3 = new s(Long.MAX_VALUE);
                        kVar.bjA.put(i5, sVar3);
                    } else {
                        sVar = sVar2;
                    }
                    bVar.biD = new f(this.bin, new i(u.m(bVar2.bjZ, aVar5.url), aVar5.bjX, aVar5.bjY, null), iVar, aVar3, this.bit, this.biB.sv(), this.biB.sw(), j3, j3 + aVar5.aOz, i3, i5, this.biu, sVar, fVar, this.aTc, this.bil);
                    AppMethodBeat.o(125905);
                    return;
                } else if (bVar2.bjP) {
                    bVar.biE = true;
                    AppMethodBeat.o(125905);
                    return;
                } else {
                    bVar.biF = aVar3;
                    this.bix = aVar3;
                    AppMethodBeat.o(125905);
                    return;
                }
            }
        }
        obj = null;
        if (obj != null) {
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(Uri uri, String str, byte[] bArr) {
        String substring;
        AppMethodBeat.i(125906);
        if (v.aR(str).startsWith("0x")) {
            substring = str.substring(2);
        } else {
            substring = str;
        }
        byte[] toByteArray = new BigInteger(substring, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = toByteArray.length > 16 ? toByteArray.length - 16 : 0;
        System.arraycopy(toByteArray, length, bArr2, (16 - toByteArray.length) + length, toByteArray.length - length);
        this.biz = uri;
        this.aTc = bArr;
        this.biA = str;
        this.bil = bArr2;
        AppMethodBeat.o(125906);
    }
}
