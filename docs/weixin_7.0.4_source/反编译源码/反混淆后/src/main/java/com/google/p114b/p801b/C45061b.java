package com.google.p114b.p801b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

/* renamed from: com.google.b.b.b */
public final class C45061b implements Cloneable {
    private final int[] byE;
    private final int byF;
    public final int height;
    public final int width;

    public C45061b(int i) {
        this(i, i);
        AppMethodBeat.m2504i(57264);
        AppMethodBeat.m2505o(57264);
    }

    public C45061b(int i, int i2) {
        AppMethodBeat.m2504i(57265);
        if (i <= 0 || i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both dimensions must be greater than 0");
            AppMethodBeat.m2505o(57265);
            throw illegalArgumentException;
        }
        this.width = i;
        this.height = i2;
        this.byF = (i + 31) / 32;
        this.byE = new int[(this.byF * i2)];
        AppMethodBeat.m2505o(57265);
    }

    private C45061b(int i, int i2, int i3, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.byF = i3;
        this.byE = iArr;
    }

    /* renamed from: bB */
    public final boolean mo72817bB(int i, int i2) {
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

    /* renamed from: p */
    public final void mo72822p(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(57266);
        IllegalArgumentException illegalArgumentException;
        if (i2 < 0 || i < 0) {
            illegalArgumentException = new IllegalArgumentException("Left and top must be nonnegative");
            AppMethodBeat.m2505o(57266);
            throw illegalArgumentException;
        } else if (i4 <= 0 || i3 <= 0) {
            illegalArgumentException = new IllegalArgumentException("Height and width must be at least 1");
            AppMethodBeat.m2505o(57266);
            throw illegalArgumentException;
        } else {
            int i5 = i + i3;
            int i6 = i2 + i4;
            if (i6 > this.height || i5 > this.width) {
                illegalArgumentException = new IllegalArgumentException("The region must fit inside the matrix");
                AppMethodBeat.m2505o(57266);
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
            AppMethodBeat.m2505o(57266);
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(57267);
        if (obj instanceof C45061b) {
            C45061b c45061b = (C45061b) obj;
            if (this.width == c45061b.width && this.height == c45061b.height && this.byF == c45061b.byF && Arrays.equals(this.byE, c45061b.byE)) {
                AppMethodBeat.m2505o(57267);
                return true;
            }
            AppMethodBeat.m2505o(57267);
            return false;
        }
        AppMethodBeat.m2505o(57267);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(57268);
        int hashCode = (((((((this.width * 31) + this.width) * 31) + this.height) * 31) + this.byF) * 31) + Arrays.hashCode(this.byE);
        AppMethodBeat.m2505o(57268);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(57269);
        String str = "X ";
        String str2 = "  ";
        String str3 = IOUtils.LINE_SEPARATOR_UNIX;
        StringBuilder stringBuilder = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                String str4;
                if (mo72817bB(i2, i)) {
                    str4 = str;
                } else {
                    str4 = str2;
                }
                stringBuilder.append(str4);
            }
            stringBuilder.append(str3);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(57269);
        return stringBuilder2;
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(57270);
        C45061b c45061b = new C45061b(this.width, this.height, this.byF, (int[]) this.byE.clone());
        AppMethodBeat.m2505o(57270);
        return c45061b;
    }
}
