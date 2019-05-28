package android.support.v7.d;

import android.graphics.Color;
import android.support.v4.widget.j;
import android.support.v7.d.b.b;
import android.support.v7.d.b.c;
import android.util.TimingLogger;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public final class a {
    private static final Comparator<a> Xt = new Comparator<a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((a) obj2).getVolume() - ((a) obj).getVolume();
        }
    };
    final int[] Pn;
    public final List<c> Xp;
    final TimingLogger Xq = null;
    final b[] Xr;
    private final float[] Xs = new float[3];
    final int[] mHistogram;

    class a {
        private int XA;
        private int XB;
        private int XC;
        private int Xu;
        int Xv;
        private int Xw;
        private int Xx;
        private int Xy;
        private int Xz;

        a(int i, int i2) {
            this.Xu = i;
            this.Xv = i2;
            fN();
        }

        /* Access modifiers changed, original: final */
        public final int getVolume() {
            return (((this.Xy - this.Xx) + 1) * ((this.XA - this.Xz) + 1)) * ((this.XC - this.XB) + 1);
        }

        /* Access modifiers changed, original: final */
        public final boolean fL() {
            return fM() > 1;
        }

        private int fM() {
            return (this.Xv + 1) - this.Xu;
        }

        /* Access modifiers changed, original: final */
        public final void fN() {
            int[] iArr = a.this.Pn;
            int[] iArr2 = a.this.mHistogram;
            int i = 0;
            int i2 = this.Xu;
            int i3 = j.INVALID_ID;
            int i4 = j.INVALID_ID;
            int i5 = j.INVALID_ID;
            int i6 = BaseClientBuilder.API_PRIORITY_OTHER;
            int i7 = BaseClientBuilder.API_PRIORITY_OTHER;
            int i8 = BaseClientBuilder.API_PRIORITY_OTHER;
            while (i2 <= this.Xv) {
                int i9 = iArr[i2];
                i += iArr2[i9];
                int bn = a.bn(i9);
                int bo = a.bo(i9);
                i9 = a.bp(i9);
                if (bn > i3) {
                    i3 = bn;
                }
                if (bn < i6) {
                    i6 = bn;
                }
                if (bo > i4) {
                    bn = bo;
                } else {
                    bn = i4;
                }
                if (bo >= i7) {
                    bo = i7;
                }
                if (i9 > i5) {
                    i5 = i9;
                }
                if (i9 < i8) {
                    i8 = i9;
                }
                i2++;
                i4 = bn;
                i7 = bo;
            }
            this.Xx = i6;
            this.Xy = i3;
            this.Xz = i7;
            this.XA = i4;
            this.XB = i8;
            this.XC = i5;
            this.Xw = i;
        }

        /* Access modifiers changed, original: final */
        public final c fP() {
            int[] iArr = a.this.Pn;
            int[] iArr2 = a.this.mHistogram;
            int i = this.Xu;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i <= this.Xv) {
                int i6 = iArr[i];
                int i7 = iArr2[i6];
                i2 += i7;
                i5 += a.bn(i6) * i7;
                i4 += a.bo(i6) * i7;
                i++;
                i3 = (a.bp(i6) * i7) + i3;
            }
            return new c(a.j(Math.round(((float) i5) / ((float) i2)), Math.round(((float) i4) / ((float) i2)), Math.round(((float) i3) / ((float) i2))), i2);
        }

        /* Access modifiers changed, original: final */
        public final int fO() {
            int i = this.Xy - this.Xx;
            int i2 = this.XA - this.Xz;
            int i3 = this.XC - this.XB;
            if (i >= i2 && i >= i3) {
                i = -3;
            } else if (i2 < i || i2 < i3) {
                i = -1;
            } else {
                i = -2;
            }
            int[] iArr = a.this.Pn;
            int[] iArr2 = a.this.mHistogram;
            a.a(iArr, i, this.Xu, this.Xv);
            Arrays.sort(iArr, this.Xu, this.Xv + 1);
            a.a(iArr, i, this.Xu, this.Xv);
            int i4 = this.Xw / 2;
            i = 0;
            for (i2 = this.Xu; i2 <= this.Xv; i2++) {
                i += iArr2[iArr[i2]];
                if (i >= i4) {
                    return Math.min(this.Xv - 1, i2);
                }
            }
            return this.Xu;
        }
    }

    public a(int[] iArr, int i, b[] bVarArr) {
        int i2;
        int i3;
        int i4 = 0;
        this.Xr = bVarArr;
        int[] iArr2 = new int[32768];
        this.mHistogram = iArr2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            i3 = iArr[i2];
            i3 = k(Color.blue(i3), 8, 5) | ((k(Color.red(i3), 8, 5) << 10) | (k(Color.green(i3), 8, 5) << 5));
            iArr[i2] = i3;
            iArr2[i3] = iArr2[i3] + 1;
        }
        i2 = 0;
        for (i3 = 0; i3 < 32768; i3++) {
            if (iArr2[i3] > 0) {
                android.support.v4.a.b.d(bm(i3), this.Xs);
                if (c(this.Xs)) {
                    iArr2[i3] = 0;
                }
            }
            if (iArr2[i3] > 0) {
                i2++;
            }
        }
        int[] iArr3 = new int[i2];
        this.Pn = iArr3;
        int i5 = 0;
        int i6 = 0;
        while (i5 < 32768) {
            if (iArr2[i5] > 0) {
                i3 = i6 + 1;
                iArr3[i6] = i5;
            } else {
                i3 = i6;
            }
            i5++;
            i6 = i3;
        }
        if (i2 <= i) {
            this.Xp = new ArrayList();
            i2 = iArr3.length;
            while (i4 < i2) {
                i3 = iArr3[i4];
                this.Xp.add(new c(bm(i3), iArr2[i3]));
                i4++;
            }
            return;
        }
        PriorityQueue priorityQueue = new PriorityQueue(i, Xt);
        priorityQueue.offer(new a(0, this.Pn.length - 1));
        a(priorityQueue, i);
        this.Xp = b(priorityQueue);
    }

    private static void a(PriorityQueue<a> priorityQueue, int i) {
        while (priorityQueue.size() < i) {
            a aVar = (a) priorityQueue.poll();
            if (aVar != null && aVar.fL()) {
                if (aVar.fL()) {
                    int fO = aVar.fO();
                    a aVar2 = new a(fO + 1, aVar.Xv);
                    aVar.Xv = fO;
                    aVar.fN();
                    priorityQueue.offer(aVar2);
                    priorityQueue.offer(aVar);
                } else {
                    throw new IllegalStateException("Can not split a box with only 1 color");
                }
            }
            return;
        }
    }

    private List<c> b(Collection<a> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (a fP : collection) {
            c fP2 = fP.fP();
            if (!c(fP2.fR())) {
                arrayList.add(fP2);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Missing block: B:1:0x0004, code skipped:
            if (r5 > r6) goto L_0x0003;
     */
    /* JADX WARNING: Missing block: B:2:0x0006, code skipped:
            r0 = r3[r5];
            r3[r5] = (r0 & 31) | ((((r0 >> 5) & 31) << 10) | (((r0 >> 10) & 31) << 5));
            r5 = r5 + 1;
     */
    /* JADX WARNING: Missing block: B:3:0x001d, code skipped:
            if (r5 > r6) goto L_0x0003;
     */
    /* JADX WARNING: Missing block: B:4:0x001f, code skipped:
            r0 = r3[r5];
            r3[r5] = ((r0 >> 10) & 31) | (((r0 & 31) << 10) | (((r0 >> 5) & 31) << 5));
            r5 = r5 + 1;
     */
    /* JADX WARNING: Missing block: B:8:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:9:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(int[] iArr, int i, int i2, int i3) {
        switch (i) {
            case -2:
                break;
            case -1:
                break;
            default:
                return;
        }
    }

    private boolean c(float[] fArr) {
        if (this.Xr == null || this.Xr.length <= 0) {
            return false;
        }
        for (b d : this.Xr) {
            if (!d.d(fArr)) {
                return true;
            }
        }
        return false;
    }

    static int j(int i, int i2, int i3) {
        return Color.rgb(k(i, 5, 8), k(i2, 5, 8), k(i3, 5, 8));
    }

    static int bn(int i) {
        return (i >> 10) & 31;
    }

    static int bo(int i) {
        return (i >> 5) & 31;
    }

    static int bp(int i) {
        return i & 31;
    }

    private static int k(int i, int i2, int i3) {
        int i4;
        if (i3 > i2) {
            i4 = i << (i3 - i2);
        } else {
            i4 = i >> (i2 - i3);
        }
        return i4 & ((1 << i3) - 1);
    }

    private static int bm(int i) {
        return j((i >> 10) & 31, (i >> 5) & 31, i & 31);
    }
}
