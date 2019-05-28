package com.google.p114b.p118e.p119a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

/* renamed from: com.google.b.e.a.a */
public final class C32085a {
    private final C32086b[] bAJ;
    int bAK;
    private final int height;
    private final int width;

    C32085a(int i, int i2) {
        AppMethodBeat.m2504i(57229);
        this.bAJ = new C32086b[i];
        int length = this.bAJ.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.bAJ[i3] = new C32086b(((i2 + 4) * 17) + 1);
        }
        this.width = i2 * 17;
        this.height = i;
        this.bAK = -1;
        AppMethodBeat.m2505o(57229);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vJ */
    public final C32086b mo52655vJ() {
        return this.bAJ[this.bAK];
    }

    /* renamed from: bG */
    public final byte[][] mo52654bG(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.height * i2, this.width * i});
        int i3 = this.height * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i3 - i4) - 1;
            C32086b c32086b = this.bAJ[i4 / i2];
            byte[] bArr2 = new byte[(c32086b.bAL.length * i)];
            for (int i6 = 0; i6 < bArr2.length; i6++) {
                bArr2[i6] = c32086b.bAL[i6 / i];
            }
            bArr[i5] = bArr2;
        }
        return bArr;
    }
}
