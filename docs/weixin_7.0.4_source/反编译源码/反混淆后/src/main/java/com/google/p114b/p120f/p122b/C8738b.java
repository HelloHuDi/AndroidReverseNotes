package com.google.p114b.p120f.p122b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

/* renamed from: com.google.b.f.b.b */
public final class C8738b {
    final byte[][] bBJ;
    public final int height;
    public final int width;

    public C8738b(int i, int i2) {
        AppMethodBeat.m2504i(57177);
        this.bBJ = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{i2, i});
        this.width = i;
        this.height = i2;
        AppMethodBeat.m2505o(57177);
    }

    /* renamed from: bH */
    public final byte mo19752bH(int i, int i2) {
        return this.bBJ[i2][i];
    }

    public final void set(int i, int i2, int i3) {
        this.bBJ[i2][i] = (byte) i3;
    }

    public final void set(int i, int i2, boolean z) {
        this.bBJ[i2][i] = (byte) (z ? 1 : 0);
    }

    public final String toString() {
        AppMethodBeat.m2504i(57178);
        StringBuilder stringBuilder = new StringBuilder(((this.width * 2) * this.height) + 2);
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                switch (this.bBJ[i][i2]) {
                    case (byte) 0:
                        stringBuilder.append(" 0");
                        break;
                    case (byte) 1:
                        stringBuilder.append(" 1");
                        break;
                    default:
                        stringBuilder.append("  ");
                        break;
                }
            }
            stringBuilder.append(10);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(57178);
        return stringBuilder2;
    }
}
