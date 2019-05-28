package com.google.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class a {
    private final b[] bAJ;
    int bAK;
    private final int height;
    private final int width;

    a(int i, int i2) {
        AppMethodBeat.i(57229);
        this.bAJ = new b[i];
        int length = this.bAJ.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.bAJ[i3] = new b(((i2 + 4) * 17) + 1);
        }
        this.width = i2 * 17;
        this.height = i;
        this.bAK = -1;
        AppMethodBeat.o(57229);
    }

    /* Access modifiers changed, original: final */
    public final b vJ() {
        return this.bAJ[this.bAK];
    }

    public final byte[][] bG(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.height * i2, this.width * i});
        int i3 = this.height * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i3 - i4) - 1;
            b bVar = this.bAJ[i4 / i2];
            byte[] bArr2 = new byte[(bVar.bAL.length * i)];
            for (int i6 = 0; i6 < bArr2.length; i6++) {
                bArr2[i6] = bVar.bAL[i6 / i];
            }
            bArr[i5] = bArr2;
        }
        return bArr;
    }
}
