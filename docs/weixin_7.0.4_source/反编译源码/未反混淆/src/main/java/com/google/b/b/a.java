package com.google.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a implements Cloneable {
    public int[] byE;
    public int size;

    public a() {
        AppMethodBeat.i(57279);
        this.size = 0;
        this.byE = new int[1];
        AppMethodBeat.o(57279);
    }

    private a(int[] iArr, int i) {
        this.byE = iArr;
        this.size = i;
    }

    public final int vt() {
        return (this.size + 7) / 8;
    }

    private void ensureCapacity(int i) {
        AppMethodBeat.i(57280);
        if (i > (this.byE.length << 5)) {
            int[] iArr = new int[((i + 31) / 32)];
            System.arraycopy(this.byE, 0, iArr, 0, this.byE.length);
            this.byE = iArr;
        }
        AppMethodBeat.o(57280);
    }

    public final boolean get(int i) {
        return (this.byE[i / 32] & (1 << (i & 31))) != 0;
    }

    public final void aT(boolean z) {
        AppMethodBeat.i(57281);
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.byE;
            int i = this.size / 32;
            iArr[i] = iArr[i] | (1 << (this.size & 31));
        }
        this.size++;
        AppMethodBeat.o(57281);
    }

    public final void bA(int i, int i2) {
        AppMethodBeat.i(57282);
        if (i2 < 0 || i2 > 32) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Num bits must be between 0 and 32");
            AppMethodBeat.o(57282);
            throw illegalArgumentException;
        }
        ensureCapacity(this.size + i2);
        while (i2 > 0) {
            aT(((i >> (i2 + -1)) & 1) == 1);
            i2--;
        }
        AppMethodBeat.o(57282);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(57283);
        int i = aVar.size;
        ensureCapacity(this.size + i);
        for (int i2 = 0; i2 < i; i2++) {
            aT(aVar.get(i2));
        }
        AppMethodBeat.o(57283);
    }

    public final void a(int i, byte[] bArr, int i2) {
        AppMethodBeat.i(57284);
        int i3 = i;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (get(i3)) {
                    i5 |= 1 << (7 - i6);
                }
                i3++;
            }
            bArr[i4 + 0] = (byte) i5;
        }
        AppMethodBeat.o(57284);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(57285);
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.size == aVar.size && Arrays.equals(this.byE, aVar.byE)) {
                AppMethodBeat.o(57285);
                return true;
            }
            AppMethodBeat.o(57285);
            return false;
        }
        AppMethodBeat.o(57285);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(57286);
        int hashCode = (this.size * 31) + Arrays.hashCode(this.byE);
        AppMethodBeat.o(57286);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(57287);
        StringBuilder stringBuilder = new StringBuilder(this.size);
        for (int i = 0; i < this.size; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(get(i) ? 'X' : '.');
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(57287);
        return stringBuilder2;
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(57288);
        a aVar = new a((int[]) this.byE.clone(), this.size);
        AppMethodBeat.o(57288);
        return aVar;
    }
}
