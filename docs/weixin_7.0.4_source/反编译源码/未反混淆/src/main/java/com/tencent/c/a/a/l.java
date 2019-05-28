package com.tencent.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class l {
    static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(125781);
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length <= 0 || length > 256) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("key must be between 1 and 256 bytes");
            AppMethodBeat.o(125781);
            throw illegalArgumentException;
        }
        int i;
        for (i = 0; i < 256; i++) {
            iArr[i] = i;
            iArr2[i] = bArr2[i % length];
        }
        i = 0;
        for (length = 0; length < 256; length++) {
            i = ((i + iArr[length]) + iArr2[length]) & 255;
            int i2 = iArr[length];
            iArr[length] = iArr[i];
            iArr[i] = i2;
        }
        byte[] bArr3 = new byte[bArr.length];
        i = 0;
        length = 0;
        int i3 = 0;
        while (i < bArr.length) {
            int i4 = (length + 1) & 255;
            i3 = (iArr[i4] + i3) & 255;
            length = iArr[i4];
            iArr[i4] = iArr[i3];
            iArr[i3] = length;
            bArr3[i] = (byte) (iArr[(iArr[i4] + iArr[i3]) & 255] ^ bArr[i]);
            i++;
            length = i4;
        }
        AppMethodBeat.o(125781);
        return bArr3;
    }
}
