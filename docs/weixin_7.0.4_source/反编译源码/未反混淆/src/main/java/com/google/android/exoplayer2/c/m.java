package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public interface m {

    public static final class a {
        public final int aRX;
        public final int aRY;
        public final int aTb;
        public final byte[] aTc;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.aTb = i;
            this.aTc = bArr;
            this.aRX = i2;
            this.aRY = i3;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(95066);
            if (this == obj) {
                AppMethodBeat.o(95066);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(95066);
                return false;
            } else {
                a aVar = (a) obj;
                if (this.aTb == aVar.aTb && this.aRX == aVar.aRX && this.aRY == aVar.aRY && Arrays.equals(this.aTc, aVar.aTc)) {
                    AppMethodBeat.o(95066);
                    return true;
                }
                AppMethodBeat.o(95066);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(95067);
            int hashCode = (((((this.aTb * 31) + Arrays.hashCode(this.aTc)) * 31) + this.aRX) * 31) + this.aRY;
            AppMethodBeat.o(95067);
            return hashCode;
        }
    }

    int a(f fVar, int i, boolean z);

    void a(long j, int i, int i2, int i3, a aVar);

    void a(l lVar, int i);

    void f(Format format);
}
