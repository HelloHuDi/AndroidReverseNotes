package com.google.android.exoplayer2.p101c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.c.m */
public interface C32041m {

    /* renamed from: com.google.android.exoplayer2.c.m$a */
    public static final class C8663a {
        public final int aRX;
        public final int aRY;
        public final int aTb;
        public final byte[] aTc;

        public C8663a(int i, byte[] bArr, int i2, int i3) {
            this.aTb = i;
            this.aTc = bArr;
            this.aRX = i2;
            this.aRY = i3;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(95066);
            if (this == obj) {
                AppMethodBeat.m2505o(95066);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.m2505o(95066);
                return false;
            } else {
                C8663a c8663a = (C8663a) obj;
                if (this.aTb == c8663a.aTb && this.aRX == c8663a.aRX && this.aRY == c8663a.aRY && Arrays.equals(this.aTc, c8663a.aTc)) {
                    AppMethodBeat.m2505o(95066);
                    return true;
                }
                AppMethodBeat.m2505o(95066);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(95067);
            int hashCode = (((((this.aTb * 31) + Arrays.hashCode(this.aTc)) * 31) + this.aRX) * 31) + this.aRY;
            AppMethodBeat.m2505o(95067);
            return hashCode;
        }
    }

    /* renamed from: a */
    int mo42832a(C45026f c45026f, int i, boolean z);

    /* renamed from: a */
    void mo42834a(long j, int i, int i2, int i3, C8663a c8663a);

    /* renamed from: a */
    void mo42835a(C32065l c32065l, int i);

    /* renamed from: f */
    void mo42836f(Format format);
}
