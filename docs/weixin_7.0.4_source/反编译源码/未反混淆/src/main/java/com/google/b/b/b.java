package com.google.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

public final class b implements Cloneable {
    private final int[] byE;
    private final int byF;
    public final int height;
    public final int width;

    public b(int i) {
        this(i, i);
        AppMethodBeat.i(57264);
        AppMethodBeat.o(57264);
    }

    public b(int i, int i2) {
        AppMethodBeat.i(57265);
        if (i <= 0 || i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both dimensions must be greater than 0");
            AppMethodBeat.o(57265);
            throw illegalArgumentException;
        }
        this.width = i;
        this.height = i2;
        this.byF = (i + 31) / 32;
        this.byE = new int[(this.byF * i2)];
        AppMethodBeat.o(57265);
    }

    private b(int i, int i2, int i3, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.byF = i3;
        this.byE = iArr;
    }

    public final boolean bB(int i, int i2) {
        return ((this.byE[(this.byF * i2) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public final void set(int i, int i2) {
        int i3 = (this.byF * i2) + (i / 32);
        int[] iArr = this.byE;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public final void clear() {
        int length = this.byE.length;
        for (int i = 0; i < length; i++) {
            this.byE[i] = 0;
        }
    }

    public final void p(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(57266);
        IllegalArgumentException illegalArgumentException;
        if (i2 < 0 || i < 0) {
            illegalArgumentException = new IllegalArgumentException("Left and top must be nonnegative");
            AppMethodBeat.o(57266);
            throw illegalArgumentException;
        } else if (i4 <= 0 || i3 <= 0) {
            illegalArgumentException = new IllegalArgumentException("Height and width must be at least 1");
            AppMethodBeat.o(57266);
            throw illegalArgumentException;
        } else {
            int i5 = i + i3;
            int i6 = i2 + i4;
            if (i6 > this.height || i5 > this.width) {
                illegalArgumentException = new IllegalArgumentException("The region must fit inside the matrix");
                AppMethodBeat.o(57266);
                throw illegalArgumentException;
            }
            while (i2 < i6) {
                int i7 = i2 * this.byF;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.byE;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
            AppMethodBeat.o(57266);
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(57267);
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.width == bVar.width && this.height == bVar.height && this.byF == bVar.byF && Arrays.equals(this.byE, bVar.byE)) {
                AppMethodBeat.o(57267);
                return true;
            }
            AppMethodBeat.o(57267);
            return false;
        }
        AppMethodBeat.o(57267);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(57268);
        int hashCode = (((((((this.width * 31) + this.width) * 31) + this.height) * 31) + this.byF) * 31) + Arrays.hashCode(this.byE);
        AppMethodBeat.o(57268);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(57269);
        String str = "X ";
        String str2 = "  ";
        String str3 = IOUtils.LINE_SEPARATOR_UNIX;
        StringBuilder stringBuilder = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                String str4;
                if (bB(i2, i)) {
                    str4 = str;
                } else {
                    str4 = str2;
                }
                stringBuilder.append(str4);
            }
            stringBuilder.append(str3);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(57269);
        return stringBuilder2;
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(57270);
        b bVar = new b(this.width, this.height, this.byF, (int[]) this.byE.clone());
        AppMethodBeat.o(57270);
        return bVar;
    }
}
