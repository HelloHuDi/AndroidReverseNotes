package com.tencent.mm.ui.tools;

import com.tencent.mm.pointers.PIntArray;

public final class ImgFilter {
    public static native boolean FilterInt(int i, int[] iArr, int[][] iArr2, int i2, int i3, int i4, PIntArray pIntArray);

    private ImgFilter() {
    }
}
