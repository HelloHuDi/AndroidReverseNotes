package com.google.android.exoplayer2.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Map;

public abstract class e extends h {
    private int aOF = 0;
    private final SparseArray<Map<p, b>> bpu = new SparseArray();
    private final SparseBooleanArray bpv = new SparseBooleanArray();
    private a bpw;

    public static final class a {
        private final int[][][] bpA;
        private final p bpB;
        private final int[] bpx;
        private final p[] bpy;
        private final int[] bpz;
        public final int length;

        a(int[] iArr, p[] pVarArr, int[] iArr2, int[][][] iArr3, p pVar) {
            AppMethodBeat.i(95780);
            this.bpx = iArr;
            this.bpy = pVarArr;
            this.bpA = iArr3;
            this.bpz = iArr2;
            this.bpB = pVar;
            this.length = pVarArr.length;
            AppMethodBeat.o(95780);
        }
    }

    public static final class b {
        public final com.google.android.exoplayer2.g.f.a bpC;
        public final int bpD;
        public final int[] bpe;
    }

    public abstract f[] a(s[] sVarArr, p[] pVarArr, int[][][] iArr);

    public final i a(s[] sVarArr, p pVar) {
        int i;
        int i2;
        int length;
        int i3;
        int i4;
        int b;
        int[] iArr;
        int[] iArr2 = new int[(sVarArr.length + 1)];
        o[][] oVarArr = new o[(sVarArr.length + 1)][];
        int[][][] iArr3 = new int[(sVarArr.length + 1)][][];
        for (i = 0; i < oVarArr.length; i++) {
            oVarArr[i] = new o[pVar.length];
            iArr3[i] = new int[pVar.length][];
        }
        int[] iArr4 = new int[sVarArr.length];
        for (i = 0; i < iArr4.length; i++) {
            iArr4[i] = sVarArr[i].pJ();
        }
        i = 0;
        while (true) {
            i2 = i;
            if (i2 >= pVar.length) {
                break;
            }
            int[] iArr5;
            o oVar = pVar.bia[i2];
            length = sVarArr.length;
            i = 0;
            i3 = 0;
            while (i3 < sVarArr.length) {
                s sVar = sVarArr[i3];
                for (i4 = 0; i4 < oVar.length; i4++) {
                    b = sVar.b(oVar.bhv[i4]) & 7;
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
            if (i3 == sVarArr.length) {
                iArr5 = new int[oVar.length];
            } else {
                s sVar2 = sVarArr[i3];
                iArr = new int[oVar.length];
                for (i = 0; i < oVar.length; i++) {
                    iArr[i] = sVar2.b(oVar.bhv[i]);
                }
                iArr5 = iArr;
            }
            length = iArr2[i3];
            oVarArr[i3][length] = oVar;
            iArr3[i3][length] = iArr5;
            iArr2[i3] = iArr2[i3] + 1;
            i = i2 + 1;
        }
        p[] pVarArr = new p[sVarArr.length];
        iArr = new int[sVarArr.length];
        i = 0;
        while (true) {
            i4 = i;
            if (i4 >= sVarArr.length) {
                break;
            }
            b = iArr2[i4];
            pVarArr[i4] = new p((o[]) Arrays.copyOf(oVarArr[i4], b));
            iArr3[i4] = (int[][]) Arrays.copyOf(iArr3[i4], b);
            iArr[i4] = sVarArr[i4].getTrackType();
            i = i4 + 1;
        }
        p pVar2 = new p((o[]) Arrays.copyOf(oVarArr[sVarArr.length], iArr2[sVarArr.length]));
        f[] a = a(sVarArr, pVarArr, iArr3);
        for (i2 = 0; i2 < sVarArr.length; i2++) {
            f fVar;
            f[] fVarArr;
            if (this.bpv.get(i2)) {
                fVar = null;
                b = i2;
                fVarArr = a;
            } else {
                Object obj;
                Object obj2 = pVarArr[i2];
                Map map = (Map) this.bpu.get(i2);
                if (map == null || !map.containsKey(obj2)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    b bVar = (b) ((Map) this.bpu.get(i2)).get(obj2);
                    if (bVar == null) {
                        fVar = null;
                        b = i2;
                        fVarArr = a;
                    } else {
                        fVar = bVar.bpC.a(obj2.bia[bVar.bpD], bVar.bpe);
                        b = i2;
                        fVarArr = a;
                    }
                } else {
                }
            }
            fVarArr[b] = fVar;
        }
        a aVar = new a(iArr, pVarArr, iArr4, iArr3, pVar2);
        t[] tVarArr = new t[sVarArr.length];
        for (length = 0; length < sVarArr.length; length++) {
            tVarArr[length] = a[length] != null ? t.aOE : null;
        }
        int i5 = this.aOF;
        if (i5 != 0) {
            b = -1;
            int i6 = -1;
            i4 = 0;
            while (i4 < sVarArr.length) {
                int trackType = sVarArr[i4].getTrackType();
                f fVar2 = a[i4];
                if ((trackType == 1 || trackType == 2) && fVar2 != null) {
                    Object obj3;
                    int[][] iArr6 = iArr3[i4];
                    p pVar3 = pVarArr[i4];
                    if (fVar2 == null) {
                        obj3 = null;
                    } else {
                        int a2 = pVar3.a(fVar2.tf());
                        for (length = 0; length < fVar2.length(); length++) {
                            if ((iArr6[a2][fVar2.eH(length)] & 32) != 32) {
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
                t tVar = new t(i5);
                tVarArr[b] = tVar;
                tVarArr[i6] = tVar;
            }
        }
        return new i(pVar, new g(a), aVar, tVarArr);
    }

    public final void ae(Object obj) {
        this.bpw = (a) obj;
    }
}
