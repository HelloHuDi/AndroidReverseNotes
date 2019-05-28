package com.google.p114b.p1162a.p1163a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.b.a.a.d */
public final class C41635d {
    static final String[] byr = new String[]{"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] bys = new int[][]{new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    private static final int[][] byt;
    static final int[][] byu;
    final byte[] byv;

    /* renamed from: com.google.b.a.a.d$1 */
    class C372901 implements Comparator<C37291f> {
        C372901() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C37291f) obj).byB - ((C37291f) obj2).byB;
        }
    }

    static {
        int i;
        AppMethodBeat.m2504i(57263);
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
        int[] iArr2 = new int[]{0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, C31128d.MIC_SketchMark};
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
        AppMethodBeat.m2505o(57263);
    }

    public C41635d(byte[] bArr) {
        this.byv = bArr;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo67031a(C37291f c37291f, int i, Collection<C37291f> collection) {
        Object obj;
        AppMethodBeat.m2504i(57260);
        char c = (char) (this.byv[i] & 255);
        if (byt[c37291f.mode][c] > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        C37291f c37291f2 = null;
        int i2 = 0;
        while (i2 <= 4) {
            C37291f fB;
            int i3 = byt[i2][c];
            if (i3 > 0) {
                if (c37291f2 == null) {
                    fB = c37291f.mo59985fB(i);
                } else {
                    fB = c37291f2;
                }
                if (obj == null || i2 == c37291f.mode || i2 == 2) {
                    collection.add(fB.mo59982bw(i2, i3));
                }
                if (obj == null && byu[c37291f.mode][i2] >= 0) {
                    collection.add(fB.mo59983bx(i2, i3));
                }
            } else {
                fB = c37291f2;
            }
            i2++;
            c37291f2 = fB;
        }
        if (c37291f.byA > 0 || byt[c37291f.mode][c] == 0) {
            collection.add(c37291f.mo59984fA(i));
        }
        AppMethodBeat.m2505o(57260);
    }

    /* renamed from: a */
    static Collection<C37291f> m72992a(Iterable<C37291f> iterable, int i, int i2) {
        AppMethodBeat.m2504i(57261);
        LinkedList linkedList = new LinkedList();
        for (C37291f c37291f : iterable) {
            C37291f fB = c37291f.mo59985fB(i);
            linkedList.add(fB.mo59982bw(4, i2));
            if (c37291f.mode != 4) {
                linkedList.add(fB.mo59983bx(4, i2));
            }
            if (i2 == 3 || i2 == 4) {
                linkedList.add(fB.mo59982bw(2, 16 - i2).mo59982bw(2, 1));
            }
            if (c37291f.byA > 0) {
                linkedList.add(c37291f.mo59984fA(i).mo59984fA(i + 1));
            }
        }
        Collection c = C41635d.m72993c(linkedList);
        AppMethodBeat.m2505o(57261);
        return c;
    }

    /* renamed from: c */
    static Collection<C37291f> m72993c(Iterable<C37291f> iterable) {
        AppMethodBeat.m2504i(57262);
        LinkedList linkedList = new LinkedList();
        for (C37291f c37291f : iterable) {
            Object obj;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C37291f c37291f2 = (C37291f) it.next();
                if (c37291f2.mo59981a(c37291f)) {
                    obj = null;
                    break;
                } else if (c37291f.mo59981a(c37291f2)) {
                    it.remove();
                }
            }
            int obj2 = 1;
            if (obj2 != null) {
                linkedList.add(c37291f);
            }
        }
        AppMethodBeat.m2505o(57262);
        return linkedList;
    }
}
