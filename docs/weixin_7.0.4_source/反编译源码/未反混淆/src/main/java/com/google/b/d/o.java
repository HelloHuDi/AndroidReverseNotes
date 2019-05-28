package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.g;
import java.util.Map;

public abstract class o implements g {
    public abstract boolean[] bj(String str);

    public b a(String str, a aVar, int i, int i2, Map<c, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int vI = vI();
            if (map != null && map.containsKey(c.MARGIN)) {
                vI = Integer.parseInt(map.get(c.MARGIN).toString());
            }
            return a(bj(str), i, i2, vI);
        }
    }

    private static b a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = length + i3;
        int max = Math.max(i, i4);
        int max2 = Math.max(1, i2);
        int i5 = max / i4;
        int i6 = (max - (length * i5)) / 2;
        b bVar = new b(max, max2);
        i4 = 0;
        while (i4 < length) {
            if (zArr[i4]) {
                bVar.p(i6, 0, i5, max2);
            }
            i4++;
            i6 += i5;
        }
        return bVar;
    }

    protected static int a(boolean[] zArr, int i, int[] iArr, boolean z) {
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

    public int vI() {
        return 10;
    }
}
