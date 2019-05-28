package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class d {
    final e aZP = new e();
    final l bah = new l(new byte[65025], 0);
    int bai = -1;
    boolean baj;
    private int segmentCount;

    d() {
        AppMethodBeat.i(95039);
        AppMethodBeat.o(95039);
    }

    public final boolean k(f fVar) {
        AppMethodBeat.i(95040);
        a.checkState(fVar != null);
        if (this.baj) {
            this.baj = false;
            this.bah.reset();
        }
        while (!this.baj) {
            int i;
            int i2;
            if (this.bai < 0) {
                if (this.aZP.c(fVar, true)) {
                    i = this.aZP.aVG;
                    if ((this.aZP.type & 1) == 1 && this.bah.limit == 0) {
                        i += ec(0);
                        i2 = this.segmentCount + 0;
                    } else {
                        i2 = 0;
                    }
                    fVar.dG(i);
                    this.bai = i2;
                } else {
                    AppMethodBeat.o(95040);
                    return false;
                }
            }
            i = ec(this.bai);
            i2 = this.bai + this.segmentCount;
            if (i > 0) {
                boolean z;
                if (this.bah.capacity() < this.bah.limit + i) {
                    this.bah.data = Arrays.copyOf(this.bah.data, this.bah.limit + i);
                }
                fVar.readFully(this.bah.data, this.bah.limit, i);
                this.bah.eL(i + this.bah.limit);
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
        AppMethodBeat.o(95040);
        return true;
    }

    private int ec(int i) {
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
