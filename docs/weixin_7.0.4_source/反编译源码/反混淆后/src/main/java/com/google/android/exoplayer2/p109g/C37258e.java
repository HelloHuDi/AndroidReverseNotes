package com.google.android.exoplayer2.p109g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.C0882t;
import com.google.android.exoplayer2.C8703s;
import com.google.android.exoplayer2.p109g.C45035f.C8678a;
import com.google.android.exoplayer2.source.C41630o;
import com.google.android.exoplayer2.source.C41631p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.g.e */
public abstract class C37258e extends C25538h {
    private int aOF = 0;
    private final SparseArray<Map<C41631p, C8677b>> bpu = new SparseArray();
    private final SparseBooleanArray bpv = new SparseBooleanArray();
    private C0864a bpw;

    /* renamed from: com.google.android.exoplayer2.g.e$a */
    public static final class C0864a {
        private final int[][][] bpA;
        private final C41631p bpB;
        private final int[] bpx;
        private final C41631p[] bpy;
        private final int[] bpz;
        public final int length;

        C0864a(int[] iArr, C41631p[] c41631pArr, int[] iArr2, int[][][] iArr3, C41631p c41631p) {
            AppMethodBeat.m2504i(95780);
            this.bpx = iArr;
            this.bpy = c41631pArr;
            this.bpA = iArr3;
            this.bpz = iArr2;
            this.bpB = c41631p;
            this.length = c41631pArr.length;
            AppMethodBeat.m2505o(95780);
        }
    }

    /* renamed from: com.google.android.exoplayer2.g.e$b */
    public static final class C8677b {
        public final C8678a bpC;
        public final int bpD;
        public final int[] bpe;
    }

    /* renamed from: a */
    public abstract C45035f[] mo59497a(C8703s[] c8703sArr, C41631p[] c41631pArr, int[][][] iArr);

    /* renamed from: a */
    public final C17663i mo42792a(C8703s[] c8703sArr, C41631p c41631p) {
        int i;
        int i2;
        int length;
        int i3;
        int i4;
        int b;
        int[] iArr;
        int[] iArr2 = new int[(c8703sArr.length + 1)];
        C41630o[][] c41630oArr = new C41630o[(c8703sArr.length + 1)][];
        int[][][] iArr3 = new int[(c8703sArr.length + 1)][][];
        for (i = 0; i < c41630oArr.length; i++) {
            c41630oArr[i] = new C41630o[c41631p.length];
            iArr3[i] = new int[c41631p.length][];
        }
        int[] iArr4 = new int[c8703sArr.length];
        for (i = 0; i < iArr4.length; i++) {
            iArr4[i] = c8703sArr[i].mo19258pJ();
        }
        i = 0;
        while (true) {
            i2 = i;
            if (i2 >= c41631p.length) {
                break;
            }
            int[] iArr5;
            C41630o c41630o = c41631p.bia[i2];
            length = c8703sArr.length;
            i = 0;
            i3 = 0;
            while (i3 < c8703sArr.length) {
                C8703s c8703s = c8703sArr[i3];
                for (i4 = 0; i4 < c41630o.length; i4++) {
                    b = c8703s.mo19256b(c41630o.bhv[i4]) & 7;
                    if (b > i) {
                        if (b == 4) {
                            break;
                        }
                        i = b;
                        length = i3;
                    }
                }
                i3++;
            }
            i3 = length;
            if (i3 == c8703sArr.length) {
                iArr5 = new int[c41630o.length];
            } else {
                C8703s c8703s2 = c8703sArr[i3];
                iArr = new int[c41630o.length];
                for (i = 0; i < c41630o.length; i++) {
                    iArr[i] = c8703s2.mo19256b(c41630o.bhv[i]);
                }
                iArr5 = iArr;
            }
            length = iArr2[i3];
            c41630oArr[i3][length] = c41630o;
            iArr3[i3][length] = iArr5;
            iArr2[i3] = iArr2[i3] + 1;
            i = i2 + 1;
        }
        C41631p[] c41631pArr = new C41631p[c8703sArr.length];
        iArr = new int[c8703sArr.length];
        i = 0;
        while (true) {
            i4 = i;
            if (i4 >= c8703sArr.length) {
                break;
            }
            b = iArr2[i4];
            c41631pArr[i4] = new C41631p((C41630o[]) Arrays.copyOf(c41630oArr[i4], b));
            iArr3[i4] = (int[][]) Arrays.copyOf(iArr3[i4], b);
            iArr[i4] = c8703sArr[i4].getTrackType();
            i = i4 + 1;
        }
        C41631p c41631p2 = new C41631p((C41630o[]) Arrays.copyOf(c41630oArr[c8703sArr.length], iArr2[c8703sArr.length]));
        C45035f[] a = mo59497a(c8703sArr, c41631pArr, iArr3);
        for (i2 = 0; i2 < c8703sArr.length; i2++) {
            C45035f c45035f;
            C45035f[] c45035fArr;
            if (this.bpv.get(i2)) {
                c45035f = null;
                b = i2;
                c45035fArr = a;
            } else {
                Object obj;
                Object obj2 = c41631pArr[i2];
                Map map = (Map) this.bpu.get(i2);
                if (map == null || !map.containsKey(obj2)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    C8677b c8677b = (C8677b) ((Map) this.bpu.get(i2)).get(obj2);
                    if (c8677b == null) {
                        c45035f = null;
                        b = i2;
                        c45035fArr = a;
                    } else {
                        c45035f = c8677b.bpC.mo19210a(obj2.bia[c8677b.bpD], c8677b.bpe);
                        b = i2;
                        c45035fArr = a;
                    }
                } else {
                }
            }
            c45035fArr[b] = c45035f;
        }
        C0864a c0864a = new C0864a(iArr, c41631pArr, iArr4, iArr3, c41631p2);
        C0882t[] c0882tArr = new C0882t[c8703sArr.length];
        for (length = 0; length < c8703sArr.length; length++) {
            c0882tArr[length] = a[length] != null ? C0882t.aOE : null;
        }
        int i5 = this.aOF;
        if (i5 != 0) {
            b = -1;
            int i6 = -1;
            i4 = 0;
            while (i4 < c8703sArr.length) {
                int trackType = c8703sArr[i4].getTrackType();
                C45035f c45035f2 = a[i4];
                if ((trackType == 1 || trackType == 2) && c45035f2 != null) {
                    Object obj3;
                    int[][] iArr6 = iArr3[i4];
                    C41631p c41631p3 = c41631pArr[i4];
                    if (c45035f2 == null) {
                        obj3 = null;
                    } else {
                        int a2 = c41631p3.mo66766a(c45035f2.mo19206tf());
                        for (length = 0; length < c45035f2.length(); length++) {
                            if ((iArr6[a2][c45035f2.mo19198eH(length)] & 32) != 32) {
                                obj3 = null;
                                break;
                            }
                        }
                        obj3 = 1;
                    }
                    if (obj3 != null) {
                        if (trackType == 1) {
                            if (b != -1) {
                                i3 = 0;
                                break;
                            }
                            length = i6;
                            b = i4;
                            i4++;
                            i6 = length;
                        } else if (i6 != -1) {
                            i3 = 0;
                            break;
                        } else {
                            length = i4;
                            i4++;
                            i6 = length;
                        }
                    }
                }
                length = i6;
                i4++;
                i6 = length;
            }
            i3 = 1;
            length = (b == -1 || i6 == -1) ? 0 : 1;
            if ((length & i3) != 0) {
                C0882t c0882t = new C0882t(i5);
                c0882tArr[b] = c0882t;
                c0882tArr[i6] = c0882t;
            }
        }
        return new C17663i(c41631p, new C37259g(a), c0864a, c0882tArr);
    }

    /* renamed from: ae */
    public final void mo42793ae(Object obj) {
        this.bpw = (C0864a) obj;
    }
}
