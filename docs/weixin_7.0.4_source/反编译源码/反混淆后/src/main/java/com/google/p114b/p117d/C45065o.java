package com.google.p114b.p117d;

import com.google.p114b.C25577g;
import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p801b.C45061b;
import java.util.Map;

/* renamed from: com.google.b.d.o */
public abstract class C45065o implements C25577g {
    /* renamed from: bj */
    public abstract boolean[] mo3687bj(String str);

    /* renamed from: a */
    public C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int vI = mo67035vI();
            if (map != null && map.containsKey(C41638c.MARGIN)) {
                vI = Integer.parseInt(map.get(C41638c.MARGIN).toString());
            }
            return C45065o.m82689a(mo3687bj(str), i, i2, vI);
        }
    }

    /* renamed from: a */
    private static C45061b m82689a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = length + i3;
        int max = Math.max(i, i4);
        int max2 = Math.max(1, i2);
        int i5 = max / i4;
        int i6 = (max - (length * i5)) / 2;
        C45061b c45061b = new C45061b(max, max2);
        i4 = 0;
        while (i4 < length) {
            if (zArr[i4]) {
                c45061b.mo72822p(i6, 0, i5, max2);
            }
            i4++;
            i6 += i5;
        }
        return c45061b;
    }

    /* renamed from: a */
    protected static int m82688a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (i2 < length) {
            int i5 = iArr[i2];
            int i6 = 0;
            while (i6 < i5) {
                int i7 = i4 + 1;
                zArr[i4] = z;
                i6++;
                i4 = i7;
            }
            i3 += i5;
            i2++;
            z = !z;
        }
        return i3;
    }

    /* renamed from: vI */
    public int mo67035vI() {
        return 10;
    }
}
