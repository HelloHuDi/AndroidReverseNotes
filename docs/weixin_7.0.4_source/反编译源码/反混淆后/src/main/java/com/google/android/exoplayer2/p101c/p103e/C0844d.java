package com.google.android.exoplayer2.p101c.p103e;

import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.c.e.d */
final class C0844d {
    final C32030e aZP = new C32030e();
    final C32065l bah = new C32065l(new byte[65025], 0);
    int bai = -1;
    boolean baj;
    private int segmentCount;

    C0844d() {
        AppMethodBeat.m2504i(95039);
        AppMethodBeat.m2505o(95039);
    }

    /* renamed from: k */
    public final boolean mo2554k(C45026f c45026f) {
        AppMethodBeat.m2504i(95040);
        C45039a.checkState(c45026f != null);
        if (this.baj) {
            this.baj = false;
            this.bah.reset();
        }
        while (!this.baj) {
            int i;
            int i2;
            if (this.bai < 0) {
                if (this.aZP.mo52324c(c45026f, true)) {
                    i = this.aZP.aVG;
                    if ((this.aZP.type & 1) == 1 && this.bah.limit == 0) {
                        i += m1934ec(0);
                        i2 = this.segmentCount + 0;
                    } else {
                        i2 = 0;
                    }
                    c45026f.mo59482dG(i);
                    this.bai = i2;
                } else {
                    AppMethodBeat.m2505o(95040);
                    return false;
                }
            }
            i = m1934ec(this.bai);
            i2 = this.bai + this.segmentCount;
            if (i > 0) {
                boolean z;
                if (this.bah.capacity() < this.bah.limit + i) {
                    this.bah.data = Arrays.copyOf(this.bah.data, this.bah.limit + i);
                }
                c45026f.readFully(this.bah.data, this.bah.limit, i);
                this.bah.mo52368eL(i + this.bah.limit);
                if (this.aZP.bas[i2 - 1] != 255) {
                    z = true;
                } else {
                    z = false;
                }
                this.baj = z;
            }
            if (i2 == this.aZP.baq) {
                i = -1;
            } else {
                i = i2;
            }
            this.bai = i;
        }
        AppMethodBeat.m2505o(95040);
        return true;
    }

    /* renamed from: ec */
    private int m1934ec(int i) {
        int i2 = 0;
        this.segmentCount = 0;
        while (this.segmentCount + i < this.aZP.baq) {
            int[] iArr = this.aZP.bas;
            int i3 = this.segmentCount;
            this.segmentCount = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
