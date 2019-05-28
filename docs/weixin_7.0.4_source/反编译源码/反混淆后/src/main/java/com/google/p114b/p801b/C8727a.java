package com.google.p114b.p801b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.google.b.b.a */
public final class C8727a implements Cloneable {
    public int[] byE;
    public int size;

    public C8727a() {
        AppMethodBeat.m2504i(57279);
        this.size = 0;
        this.byE = new int[1];
        AppMethodBeat.m2505o(57279);
    }

    private C8727a(int[] iArr, int i) {
        this.byE = iArr;
        this.size = i;
    }

    /* renamed from: vt */
    public final int mo19748vt() {
        return (this.size + 7) / 8;
    }

    private void ensureCapacity(int i) {
        AppMethodBeat.m2504i(57280);
        if (i > (this.byE.length << 5)) {
            int[] iArr = new int[((i + 31) / 32)];
            System.arraycopy(this.byE, 0, iArr, 0, this.byE.length);
            this.byE = iArr;
        }
        AppMethodBeat.m2505o(57280);
    }

    public final boolean get(int i) {
        return (this.byE[i / 32] & (1 << (i & 31))) != 0;
    }

    /* renamed from: aT */
    public final void mo19741aT(boolean z) {
        AppMethodBeat.m2504i(57281);
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.byE;
            int i = this.size / 32;
            iArr[i] = iArr[i] | (1 << (this.size & 31));
        }
        this.size++;
        AppMethodBeat.m2505o(57281);
    }

    /* renamed from: bA */
    public final void mo19742bA(int i, int i2) {
        AppMethodBeat.m2504i(57282);
        if (i2 < 0 || i2 > 32) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Num bits must be between 0 and 32");
            AppMethodBeat.m2505o(57282);
            throw illegalArgumentException;
        }
        ensureCapacity(this.size + i2);
        while (i2 > 0) {
            mo19741aT(((i >> (i2 + -1)) & 1) == 1);
            i2--;
        }
        AppMethodBeat.m2505o(57282);
    }

    /* renamed from: a */
    public final void mo19740a(C8727a c8727a) {
        AppMethodBeat.m2504i(57283);
        int i = c8727a.size;
        ensureCapacity(this.size + i);
        for (int i2 = 0; i2 < i; i2++) {
            mo19741aT(c8727a.get(i2));
        }
        AppMethodBeat.m2505o(57283);
    }

    /* renamed from: a */
    public final void mo19739a(int i, byte[] bArr, int i2) {
        AppMethodBeat.m2504i(57284);
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
        AppMethodBeat.m2505o(57284);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(57285);
        if (obj instanceof C8727a) {
            C8727a c8727a = (C8727a) obj;
            if (this.size == c8727a.size && Arrays.equals(this.byE, c8727a.byE)) {
                AppMethodBeat.m2505o(57285);
                return true;
            }
            AppMethodBeat.m2505o(57285);
            return false;
        }
        AppMethodBeat.m2505o(57285);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(57286);
        int hashCode = (this.size * 31) + Arrays.hashCode(this.byE);
        AppMethodBeat.m2505o(57286);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(57287);
        StringBuilder stringBuilder = new StringBuilder(this.size);
        for (int i = 0; i < this.size; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(get(i) ? 'X' : '.');
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(57287);
        return stringBuilder2;
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(57288);
        C8727a c8727a = new C8727a((int[]) this.byE.clone(), this.size);
        AppMethodBeat.m2505o(57288);
        return c8727a;
    }
}
