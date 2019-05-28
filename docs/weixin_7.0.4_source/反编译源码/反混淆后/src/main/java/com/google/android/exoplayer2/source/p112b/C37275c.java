package com.google.android.exoplayer2.source.p112b;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.C17628b;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p109g.C45035f;
import com.google.android.exoplayer2.p109g.C8675b;
import com.google.android.exoplayer2.p110h.C0867f;
import com.google.android.exoplayer2.p110h.C17665i;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C25544u;
import com.google.android.exoplayer2.p111i.C45042s;
import com.google.android.exoplayer2.source.C32074b;
import com.google.android.exoplayer2.source.C41630o;
import com.google.android.exoplayer2.source.p112b.p113a.C25553a.C25552a;
import com.google.android.exoplayer2.source.p112b.p113a.C37272b;
import com.google.android.exoplayer2.source.p112b.p113a.C37272b.C37273a;
import com.google.android.exoplayer2.source.p112b.p113a.C45049e;
import com.google.android.exoplayer2.source.p112b.p113a.C45049e.C0878a;
import com.google.android.exoplayer2.source.p1520a.C37270c;
import com.google.android.exoplayer2.source.p1520a.C41622a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.source.b.c */
final class C37275c {
    private byte[] aTc;
    private String biA;
    C45035f biB;
    private byte[] bil;
    private final C0867f bin;
    private final C0867f bio;
    private final C41628k bip;
    private final C25552a[] biq;
    private final C45049e bir;
    final C41630o bis;
    private final List<Format> bit;
    boolean biu;
    byte[] biv;
    IOException biw;
    private C25552a bix;
    private boolean biy;
    private Uri biz;

    /* renamed from: com.google.android.exoplayer2.source.b.c$a */
    static final class C0880a extends C37270c {
        public final String biC;
        byte[] result;

        public C0880a(C0867f c0867f, C17665i c17665i, Format format, int i, Object obj, byte[] bArr, String str) {
            super(c0867f, c17665i, format, i, obj, bArr);
            this.biC = str;
        }

        /* renamed from: f */
        public final void mo2610f(byte[] bArr, int i) {
            AppMethodBeat.m2504i(125899);
            this.result = Arrays.copyOf(bArr, i);
            AppMethodBeat.m2505o(125899);
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.b.c$b */
    public static final class C32072b {
        public C41622a biD;
        public boolean biE;
        public C25552a biF;

        public C32072b() {
            AppMethodBeat.m2504i(125900);
            clear();
            AppMethodBeat.m2505o(125900);
        }

        public final void clear() {
            this.biD = null;
            this.biE = false;
            this.biF = null;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.b.c$c */
    static final class C32073c extends C8675b {
        private int biG;

        public C32073c(C41630o c41630o, int[] iArr) {
            super(c41630o, iArr);
            AppMethodBeat.m2504i(125901);
            this.biG = mo19203j(c41630o.bhv[0]);
            AppMethodBeat.m2505o(125901);
        }

        /* renamed from: ag */
        public final void mo52334ag(long j) {
            AppMethodBeat.m2504i(125902);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (mo19204j(this.biG, elapsedRealtime)) {
                int i = this.length - 1;
                while (i >= 0) {
                    if (mo19204j(i, elapsedRealtime)) {
                        i--;
                    } else {
                        this.biG = i;
                        AppMethodBeat.m2505o(125902);
                        return;
                    }
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.m2505o(125902);
                throw illegalStateException;
            }
            AppMethodBeat.m2505o(125902);
        }

        /* renamed from: su */
        public final int mo52335su() {
            return this.biG;
        }

        /* renamed from: sv */
        public final int mo52336sv() {
            return 0;
        }

        /* renamed from: sw */
        public final Object mo52337sw() {
            return null;
        }
    }

    public C37275c(C45049e c45049e, C25552a[] c25552aArr, C25555d c25555d, C41628k c41628k, List<Format> list) {
        AppMethodBeat.m2504i(125903);
        this.bir = c45049e;
        this.biq = c25552aArr;
        this.bip = c41628k;
        this.bit = list;
        Format[] formatArr = new Format[c25552aArr.length];
        int[] iArr = new int[c25552aArr.length];
        for (int i = 0; i < c25552aArr.length; i++) {
            formatArr[i] = c25552aArr[i].aOv;
            iArr[i] = i;
        }
        this.bin = c25555d.mo42816st();
        this.bio = c25555d.mo42816st();
        this.bis = new C41630o(formatArr);
        this.biB = new C32073c(this.bis, iArr);
        AppMethodBeat.m2505o(125903);
    }

    /* renamed from: rW */
    public final void mo59520rW() {
        AppMethodBeat.m2504i(125904);
        if (this.biw != null) {
            IOException iOException = this.biw;
            AppMethodBeat.m2505o(125904);
            throw iOException;
        }
        if (this.bix != null) {
            this.bir.mo72566d(this.bix);
        }
        AppMethodBeat.m2505o(125904);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo59519a(C25556f c25556f, long j, C32072b c32072b) {
        int i;
        long j2;
        Object obj;
        AppMethodBeat.m2504i(125905);
        if (c25556f == null) {
            i = -1;
        } else {
            i = this.bis.mo66765j(c25556f.bic);
        }
        this.bix = null;
        if (c25556f == null) {
            j2 = 0;
        } else {
            j2 = Math.max(0, (this.biy ? c25556f.big : c25556f.bif) - j);
        }
        this.biB.mo52334ag(j2);
        int th = this.biB.mo19208th();
        Object obj2;
        if (i != th) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        C25552a c25552a = this.biq[th];
        C0878a c0878a = (C0878a) this.bir.bkC.get(c25552a);
        if (c0878a.bkN != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000, C17628b.m27433w(c0878a.bkN.aOz));
            if (c0878a.bkN.bjP || c0878a.bkN.bjI == 2 || c0878a.bkN.bjI == 1 || max + c0878a.bkO > elapsedRealtime) {
                obj = 1;
                if (obj != null) {
                    c32072b.biF = c25552a;
                    this.bix = c25552a;
                    AppMethodBeat.m2505o(125905);
                    return;
                }
                C37272b c37272b;
                C25552a c25552a2;
                int i2;
                int i3;
                C37272b c = this.bir.mo72565c(c25552a);
                this.biy = c.bjO;
                if (c25556f == null || obj2 != null) {
                    if (c25556f != null) {
                        j = this.biy ? c25556f.big : c25556f.bif;
                    }
                    if (c.bjP || j < c.mo59516sC()) {
                        C37272b c37272b2;
                        C25552a c25552a3;
                        List list = c.bjS;
                        Object valueOf = Long.valueOf(j - c.bif);
                        boolean z = !this.bir.bkJ || c25556f == null;
                        int a = C17675v.m27552a(list, valueOf, z) + c.bjM;
                        if (a >= c.bjM || c25556f == null) {
                            c37272b2 = c;
                            c25552a3 = c25552a;
                            i = th;
                        } else {
                            c25552a3 = this.biq[i];
                            c37272b2 = this.bir.mo72565c(c25552a3);
                            a = c25556f.bih + 1;
                        }
                        c37272b = c37272b2;
                        c25552a2 = c25552a3;
                        i2 = i;
                        i3 = a;
                    } else {
                        i3 = c.bjM + c.bjS.size();
                        c37272b = c;
                        c25552a2 = c25552a;
                        i2 = th;
                    }
                } else {
                    i3 = c25556f.bih + 1;
                    c37272b = c;
                    c25552a2 = c25552a;
                    i2 = th;
                }
                if (i3 < c37272b.bjM) {
                    this.biw = new C32074b();
                    AppMethodBeat.m2505o(125905);
                    return;
                }
                int i4 = i3 - c37272b.bjM;
                if (i4 < c37272b.bjS.size()) {
                    C17665i c17665i;
                    C45042s c45042s;
                    C37273a c37273a = (C37273a) c37272b.bjS.get(i4);
                    if (c37273a.aZs) {
                        Uri m = C25544u.m40382m(c37272b.bjZ, c37273a.bjV);
                        if (!m.equals(this.biz)) {
                            c32072b.biD = new C0880a(this.bio, new C17665i(m, (byte) 0), this.biq[i2].aOv, this.biB.mo52336sv(), this.biB.mo52337sw(), this.biv, c37273a.bjW);
                            AppMethodBeat.m2505o(125905);
                            return;
                        } else if (!C17675v.m27574j(c37273a.bjW, this.biA)) {
                            mo59518a(m, c37273a.bjW, this.aTc);
                        }
                    } else {
                        this.biz = null;
                        this.aTc = null;
                        this.biA = null;
                        this.bil = null;
                    }
                    C37273a c37273a2 = c37272b.bjR;
                    if (c37273a2 != null) {
                        c17665i = new C17665i(C25544u.m40382m(c37272b.bjZ, c37273a2.url), c37273a2.bjX, c37273a2.bjY, null);
                    } else {
                        c17665i = null;
                    }
                    long j3 = c37272b.bif + c37273a.bjU;
                    int i5 = c37272b.bjL + c37273a.bjT;
                    C41628k c41628k = this.bip;
                    C45042s c45042s2 = (C45042s) c41628k.bjA.get(i5);
                    if (c45042s2 == null) {
                        C45042s c45042s3 = new C45042s(Long.MAX_VALUE);
                        c41628k.bjA.put(i5, c45042s3);
                    } else {
                        c45042s = c45042s2;
                    }
                    c32072b.biD = new C25556f(this.bin, new C17665i(C25544u.m40382m(c37272b.bjZ, c37273a.url), c37273a.bjX, c37273a.bjY, null), c17665i, c25552a2, this.bit, this.biB.mo52336sv(), this.biB.mo52337sw(), j3, j3 + c37273a.aOz, i3, i5, this.biu, c45042s, c25556f, this.aTc, this.bil);
                    AppMethodBeat.m2505o(125905);
                    return;
                } else if (c37272b.bjP) {
                    c32072b.biE = true;
                    AppMethodBeat.m2505o(125905);
                    return;
                } else {
                    c32072b.biF = c25552a2;
                    this.bix = c25552a2;
                    AppMethodBeat.m2505o(125905);
                    return;
                }
            }
        }
        obj = null;
        if (obj != null) {
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo59518a(Uri uri, String str, byte[] bArr) {
        String substring;
        AppMethodBeat.m2504i(125906);
        if (C17675v.m27560aR(str).startsWith("0x")) {
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
        AppMethodBeat.m2505o(125906);
    }
}
