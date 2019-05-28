package com.tencent.p177mm.plugin.scanner.util;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p699f.C6094a;

/* renamed from: com.tencent.mm.plugin.scanner.util.f */
public final class C39638f extends C6094a {
    private static int qhH = 10;
    private final byte[] qhG;

    public C39638f(Bitmap bitmap) {
        super(bitmap.getWidth() + 0, bitmap.getHeight() + 0);
        AppMethodBeat.m2504i(81414);
        int width = bitmap.getWidth() + 0;
        int height = bitmap.getHeight() + 0;
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        this.qhG = new byte[(width * height)];
        for (int i = 0; i < height; i++) {
            int i2 = i * width;
            for (int i3 = 0; i3 < width; i3++) {
                int i4 = iArr[i2 + i3];
                int i5 = (i4 >> 16) & 255;
                int i6 = (i4 >> 8) & 255;
                i4 &= 255;
                if (i5 == i6 && i6 == i4) {
                    this.qhG[i2 + i3] = (byte) i5;
                } else {
                    this.qhG[i2 + i3] = (byte) ((i4 + ((i5 + i6) + i6)) >> 2);
                }
            }
        }
        AppMethodBeat.m2505o(81414);
    }

    /* renamed from: n */
    public final byte[] mo13483n(int i, byte[] bArr) {
        AppMethodBeat.m2504i(81415);
        if (i < 0 || i >= this.height) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(81415);
            throw illegalArgumentException;
        }
        Object bArr2;
        int i2 = this.width;
        if (bArr2 == null || bArr2.length < i2) {
            bArr2 = new byte[i2];
        }
        System.arraycopy(this.qhG, i * i2, bArr2, 0, i2);
        AppMethodBeat.m2505o(81415);
        return bArr2;
    }

    public final byte[] chS() {
        return this.qhG;
    }
}
