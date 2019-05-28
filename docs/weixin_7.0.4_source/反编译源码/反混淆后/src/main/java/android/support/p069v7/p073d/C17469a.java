package android.support.p069v7.p073d;

import android.graphics.Color;
import android.support.p057v4.p058a.C0284b;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p073d.C17471b.C17472b;
import android.support.p069v7.p073d.C17471b.C17473c;
import android.util.TimingLogger;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* renamed from: android.support.v7.d.a */
public final class C17469a {
    /* renamed from: Xt */
    private static final Comparator<C17470a> f3999Xt = new C84201();
    /* renamed from: Pn */
    final int[] f4000Pn;
    /* renamed from: Xp */
    public final List<C17473c> f4001Xp;
    /* renamed from: Xq */
    final TimingLogger f4002Xq = null;
    /* renamed from: Xr */
    final C17472b[] f4003Xr;
    /* renamed from: Xs */
    private final float[] f4004Xs = new float[3];
    final int[] mHistogram;

    /* renamed from: android.support.v7.d.a$1 */
    static class C84201 implements Comparator<C17470a> {
        C84201() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C17470a) obj2).getVolume() - ((C17470a) obj).getVolume();
        }
    }

    /* renamed from: android.support.v7.d.a$a */
    class C17470a {
        /* renamed from: XA */
        private int f4005XA;
        /* renamed from: XB */
        private int f4006XB;
        /* renamed from: XC */
        private int f4007XC;
        /* renamed from: Xu */
        private int f4009Xu;
        /* renamed from: Xv */
        int f4010Xv;
        /* renamed from: Xw */
        private int f4011Xw;
        /* renamed from: Xx */
        private int f4012Xx;
        /* renamed from: Xy */
        private int f4013Xy;
        /* renamed from: Xz */
        private int f4014Xz;

        C17470a(int i, int i2) {
            this.f4009Xu = i;
            this.f4010Xv = i2;
            mo31813fN();
        }

        /* Access modifiers changed, original: final */
        public final int getVolume() {
            return (((this.f4013Xy - this.f4012Xx) + 1) * ((this.f4005XA - this.f4014Xz) + 1)) * ((this.f4007XC - this.f4006XB) + 1);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: fL */
        public final boolean mo31812fL() {
            return m27123fM() > 1;
        }

        /* renamed from: fM */
        private int m27123fM() {
            return (this.f4010Xv + 1) - this.f4009Xu;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: fN */
        public final void mo31813fN() {
            int[] iArr = C17469a.this.f4000Pn;
            int[] iArr2 = C17469a.this.mHistogram;
            int i = 0;
            int i2 = this.f4009Xu;
            int i3 = C8415j.INVALID_ID;
            int i4 = C8415j.INVALID_ID;
            int i5 = C8415j.INVALID_ID;
            int i6 = BaseClientBuilder.API_PRIORITY_OTHER;
            int i7 = BaseClientBuilder.API_PRIORITY_OTHER;
            int i8 = BaseClientBuilder.API_PRIORITY_OTHER;
            while (i2 <= this.f4010Xv) {
                int i9 = iArr[i2];
                i += iArr2[i9];
                int bn = C17469a.m27117bn(i9);
                int bo = C17469a.m27118bo(i9);
                i9 = C17469a.m27119bp(i9);
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
            this.f4012Xx = i6;
            this.f4013Xy = i3;
            this.f4014Xz = i7;
            this.f4005XA = i4;
            this.f4006XB = i8;
            this.f4007XC = i5;
            this.f4011Xw = i;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: fP */
        public final C17473c mo31815fP() {
            int[] iArr = C17469a.this.f4000Pn;
            int[] iArr2 = C17469a.this.mHistogram;
            int i = this.f4009Xu;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i <= this.f4010Xv) {
                int i6 = iArr[i];
                int i7 = iArr2[i6];
                i2 += i7;
                i5 += C17469a.m27117bn(i6) * i7;
                i4 += C17469a.m27118bo(i6) * i7;
                i++;
                i3 = (C17469a.m27119bp(i6) * i7) + i3;
            }
            return new C17473c(C17469a.m27121j(Math.round(((float) i5) / ((float) i2)), Math.round(((float) i4) / ((float) i2)), Math.round(((float) i3) / ((float) i2))), i2);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: fO */
        public final int mo31814fO() {
            int i = this.f4013Xy - this.f4012Xx;
            int i2 = this.f4005XA - this.f4014Xz;
            int i3 = this.f4007XC - this.f4006XB;
            if (i >= i2 && i >= i3) {
                i = -3;
            } else if (i2 < i || i2 < i3) {
                i = -1;
            } else {
                i = -2;
            }
            int[] iArr = C17469a.this.f4000Pn;
            int[] iArr2 = C17469a.this.mHistogram;
            C17469a.m27114a(iArr, i, this.f4009Xu, this.f4010Xv);
            Arrays.sort(iArr, this.f4009Xu, this.f4010Xv + 1);
            C17469a.m27114a(iArr, i, this.f4009Xu, this.f4010Xv);
            int i4 = this.f4011Xw / 2;
            i = 0;
            for (i2 = this.f4009Xu; i2 <= this.f4010Xv; i2++) {
                i += iArr2[iArr[i2]];
                if (i >= i4) {
                    return Math.min(this.f4010Xv - 1, i2);
                }
            }
            return this.f4009Xu;
        }
    }

    public C17469a(int[] iArr, int i, C17472b[] c17472bArr) {
        int i2;
        int i3;
        int i4 = 0;
        this.f4003Xr = c17472bArr;
        int[] iArr2 = new int[32768];
        this.mHistogram = iArr2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            i3 = iArr[i2];
            i3 = C17469a.m27122k(Color.blue(i3), 8, 5) | ((C17469a.m27122k(Color.red(i3), 8, 5) << 10) | (C17469a.m27122k(Color.green(i3), 8, 5) << 5));
            iArr[i2] = i3;
            iArr2[i3] = iArr2[i3] + 1;
        }
        i2 = 0;
        for (i3 = 0; i3 < 32768; i3++) {
            if (iArr2[i3] > 0) {
                C0284b.m475d(C17469a.m27116bm(i3), this.f4004Xs);
                if (m27120c(this.f4004Xs)) {
                    iArr2[i3] = 0;
                }
            }
            if (iArr2[i3] > 0) {
                i2++;
            }
        }
        int[] iArr3 = new int[i2];
        this.f4000Pn = iArr3;
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
            this.f4001Xp = new ArrayList();
            i2 = iArr3.length;
            while (i4 < i2) {
                i3 = iArr3[i4];
                this.f4001Xp.add(new C17473c(C17469a.m27116bm(i3), iArr2[i3]));
                i4++;
            }
            return;
        }
        PriorityQueue priorityQueue = new PriorityQueue(i, f3999Xt);
        priorityQueue.offer(new C17470a(0, this.f4000Pn.length - 1));
        C17469a.m27113a(priorityQueue, i);
        this.f4001Xp = m27115b(priorityQueue);
    }

    /* renamed from: a */
    private static void m27113a(PriorityQueue<C17470a> priorityQueue, int i) {
        while (priorityQueue.size() < i) {
            C17470a c17470a = (C17470a) priorityQueue.poll();
            if (c17470a != null && c17470a.mo31812fL()) {
                if (c17470a.mo31812fL()) {
                    int fO = c17470a.mo31814fO();
                    C17470a c17470a2 = new C17470a(fO + 1, c17470a.f4010Xv);
                    c17470a.f4010Xv = fO;
                    c17470a.mo31813fN();
                    priorityQueue.offer(c17470a2);
                    priorityQueue.offer(c17470a);
                } else {
                    throw new IllegalStateException("Can not split a box with only 1 color");
                }
            }
            return;
        }
    }

    /* renamed from: b */
    private List<C17473c> m27115b(Collection<C17470a> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (C17470a fP : collection) {
            C17473c fP2 = fP.mo31815fP();
            if (!m27120c(fP2.mo31818fR())) {
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
    /* renamed from: a */
    static void m27114a(int[] iArr, int i, int i2, int i3) {
        switch (i) {
            case -2:
                break;
            case -1:
                break;
            default:
                return;
        }
    }

    /* renamed from: c */
    private boolean m27120c(float[] fArr) {
        if (this.f4003Xr == null || this.f4003Xr.length <= 0) {
            return false;
        }
        for (C17472b d : this.f4003Xr) {
            if (!d.mo1468d(fArr)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    static int m27121j(int i, int i2, int i3) {
        return Color.rgb(C17469a.m27122k(i, 5, 8), C17469a.m27122k(i2, 5, 8), C17469a.m27122k(i3, 5, 8));
    }

    /* renamed from: bn */
    static int m27117bn(int i) {
        return (i >> 10) & 31;
    }

    /* renamed from: bo */
    static int m27118bo(int i) {
        return (i >> 5) & 31;
    }

    /* renamed from: bp */
    static int m27119bp(int i) {
        return i & 31;
    }

    /* renamed from: k */
    private static int m27122k(int i, int i2, int i3) {
        int i4;
        if (i3 > i2) {
            i4 = i << (i3 - i2);
        } else {
            i4 = i >> (i2 - i3);
        }
        return i4 & ((1 << i3) - 1);
    }

    /* renamed from: bm */
    private static int m27116bm(int i) {
        return C17469a.m27121j((i >> 10) & 31, (i >> 5) & 31, i & 31);
    }
}
