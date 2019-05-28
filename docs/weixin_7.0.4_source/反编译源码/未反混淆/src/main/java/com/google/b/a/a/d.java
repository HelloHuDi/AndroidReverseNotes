package com.google.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    static final String[] byr = new String[]{"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] bys = new int[][]{new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    private static final int[][] byt;
    static final int[][] byu;
    final byte[] byv;

    static {
        int i;
        AppMethodBeat.i(57263);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{5, 256});
        byt = iArr;
        iArr[0][32] = 1;
        for (i = 65; i <= 90; i++) {
            byt[0][i] = (i - 65) + 2;
        }
        byt[1][32] = 1;
        for (i = 97; i <= 122; i++) {
            byt[1][i] = (i - 97) + 2;
        }
        byt[2][32] = 1;
        for (i = 48; i <= 57; i++) {
            byt[2][i] = (i - 48) + 2;
        }
        byt[2][44] = 12;
        byt[2][46] = 13;
        int[] iArr2 = new int[]{0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, com.tencent.view.d.MIC_SketchMark};
        for (i = 0; i < 28; i++) {
            byt[3][iArr2[i]] = i;
        }
        iArr2 = new int[]{0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (i = 0; i < 31; i++) {
            if (iArr2[i] > 0) {
                byt[4][iArr2[i]] = i;
            }
        }
        iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 6});
        byu = iArr;
        for (int[] fill : iArr) {
            Arrays.fill(fill, -1);
        }
        byu[0][4] = 0;
        byu[1][4] = 0;
        byu[1][0] = 28;
        byu[3][4] = 0;
        byu[2][4] = 0;
        byu[2][0] = 15;
        AppMethodBeat.o(57263);
    }

    public d(byte[] bArr) {
        this.byv = bArr;
    }

    /* Access modifiers changed, original: final */
    public final void a(f fVar, int i, Collection<f> collection) {
        Object obj;
        AppMethodBeat.i(57260);
        char c = (char) (this.byv[i] & 255);
        if (byt[fVar.mode][c] > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        f fVar2 = null;
        int i2 = 0;
        while (i2 <= 4) {
            f fB;
            int i3 = byt[i2][c];
            if (i3 > 0) {
                if (fVar2 == null) {
                    fB = fVar.fB(i);
                } else {
                    fB = fVar2;
                }
                if (obj == null || i2 == fVar.mode || i2 == 2) {
                    collection.add(fB.bw(i2, i3));
                }
                if (obj == null && byu[fVar.mode][i2] >= 0) {
                    collection.add(fB.bx(i2, i3));
                }
            } else {
                fB = fVar2;
            }
            i2++;
            fVar2 = fB;
        }
        if (fVar.byA > 0 || byt[fVar.mode][c] == 0) {
            collection.add(fVar.fA(i));
        }
        AppMethodBeat.o(57260);
    }

    static Collection<f> a(Iterable<f> iterable, int i, int i2) {
        AppMethodBeat.i(57261);
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            f fB = fVar.fB(i);
            linkedList.add(fB.bw(4, i2));
            if (fVar.mode != 4) {
                linkedList.add(fB.bx(4, i2));
            }
            if (i2 == 3 || i2 == 4) {
                linkedList.add(fB.bw(2, 16 - i2).bw(2, 1));
            }
            if (fVar.byA > 0) {
                linkedList.add(fVar.fA(i).fA(i + 1));
            }
        }
        Collection c = c(linkedList);
        AppMethodBeat.o(57261);
        return c;
    }

    static Collection<f> c(Iterable<f> iterable) {
        AppMethodBeat.i(57262);
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            Object obj;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                f fVar2 = (f) it.next();
                if (fVar2.a(fVar)) {
                    obj = null;
                    break;
                } else if (fVar.a(fVar2)) {
                    it.remove();
                }
            }
            int obj2 = 1;
            if (obj2 != null) {
                linkedList.add(fVar);
            }
        }
        AppMethodBeat.o(57262);
        return linkedList;
    }
}
