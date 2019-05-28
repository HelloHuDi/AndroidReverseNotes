package com.google.p114b.p117d;

import com.google.p114b.C25576d;

/* renamed from: com.google.b.d.q */
public abstract class C41640q extends C8732n {
    static final int[] bAA = new int[]{1, 1, 1, 1, 1, 1};
    static final int[] bAC = new int[]{1, 1, 1};
    static final int[] bAD = new int[]{1, 1, 1, 1, 1};
    static final int[][] bAE = new int[][]{new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] bAF = new int[20][];

    static {
        int i = 10;
        System.arraycopy(bAE, 0, bAF, 0, 10);
        while (true) {
            int i2 = i;
            if (i2 < 20) {
                int[] iArr = bAE[i2 - 10];
                int[] iArr2 = new int[iArr.length];
                for (i = 0; i < iArr.length; i++) {
                    iArr2[i] = iArr[(iArr.length - i) - 1];
                }
                bAF[i2] = iArr2;
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: r */
    static boolean m73000r(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i;
        int i2 = 0;
        for (i = length - 2; i >= 0; i -= 2) {
            int charAt = charSequence.charAt(i) - 48;
            if (charAt < 0 || charAt > 9) {
                throw C25576d.m40557vs();
            }
            i2 += charAt;
        }
        i2 *= 3;
        for (i = length - 1; i >= 0; i -= 2) {
            length = charSequence.charAt(i) - 48;
            if (length < 0 || length > 9) {
                throw C25576d.m40557vs();
            }
            i2 += length;
        }
        if (i2 % 10 == 0) {
            return true;
        }
        return false;
    }
}
