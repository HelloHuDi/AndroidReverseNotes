package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e {
    private final CharSequence bzD;
    private final int bzE;
    public final int bzF;
    public final byte[] bzG;

    public e(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.i(57167);
        this.bzD = charSequence;
        this.bzF = i;
        this.bzE = i2;
        this.bzG = new byte[(i * i2)];
        Arrays.fill(this.bzG, (byte) -1);
        AppMethodBeat.o(57167);
    }

    private void f(int i, int i2, boolean z) {
        this.bzG[(this.bzF * i2) + i] = (byte) (z ? 1 : 0);
    }

    private boolean bF(int i, int i2) {
        return this.bzG[(this.bzF * i2) + i] >= (byte) 0;
    }

    public final void vw() {
        AppMethodBeat.i(57168);
        int i = 0;
        int i2 = 4;
        int i3 = 0;
        while (true) {
            int i4;
            if (i2 == this.bzE && r0 == 0) {
                i4 = i3 + 1;
                q(this.bzE - 1, 0, i3, 1);
                q(this.bzE - 1, 1, i3, 2);
                q(this.bzE - 1, 2, i3, 3);
                q(0, this.bzF - 2, i3, 4);
                q(0, this.bzF - 1, i3, 5);
                q(1, this.bzF - 1, i3, 6);
                q(2, this.bzF - 1, i3, 7);
                q(3, this.bzF - 1, i3, 8);
                i3 = i4;
            }
            if (i2 == this.bzE - 2 && r0 == 0 && this.bzF % 4 != 0) {
                i4 = i3 + 1;
                q(this.bzE - 3, 0, i3, 1);
                q(this.bzE - 2, 0, i3, 2);
                q(this.bzE - 1, 0, i3, 3);
                q(0, this.bzF - 4, i3, 4);
                q(0, this.bzF - 3, i3, 5);
                q(0, this.bzF - 2, i3, 6);
                q(0, this.bzF - 1, i3, 7);
                q(1, this.bzF - 1, i3, 8);
                i3 = i4;
            }
            if (i2 == this.bzE - 2 && r0 == 0 && this.bzF % 8 == 4) {
                i4 = i3 + 1;
                q(this.bzE - 3, 0, i3, 1);
                q(this.bzE - 2, 0, i3, 2);
                q(this.bzE - 1, 0, i3, 3);
                q(0, this.bzF - 2, i3, 4);
                q(0, this.bzF - 1, i3, 5);
                q(1, this.bzF - 1, i3, 6);
                q(2, this.bzF - 1, i3, 7);
                q(3, this.bzF - 1, i3, 8);
                i3 = i4;
            }
            if (i2 == this.bzE + 4 && r0 == 2 && this.bzF % 8 == 0) {
                i4 = i3 + 1;
                q(this.bzE - 1, 0, i3, 1);
                q(this.bzE - 1, this.bzF - 1, i3, 2);
                q(0, this.bzF - 3, i3, 3);
                q(0, this.bzF - 2, i3, 4);
                q(0, this.bzF - 1, i3, 5);
                q(1, this.bzF - 3, i3, 6);
                q(1, this.bzF - 2, i3, 7);
                q(1, this.bzF - 1, i3, 8);
                i3 = i4;
            }
            do {
                if (i2 < this.bzE && i >= 0 && !bF(i, i2)) {
                    i4 = i3 + 1;
                    A(i2, i, i3);
                    i3 = i4;
                }
                i2 -= 2;
                i += 2;
                if (i2 < 0) {
                    break;
                }
            } while (i < this.bzF);
            i4 = i2 + 1;
            i2 = i + 3;
            int i5 = i4;
            i = i3;
            while (true) {
                if (i5 < 0 || i2 >= this.bzF || bF(i2, i5)) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                    A(i5, i2, i);
                }
                i5 += 2;
                i4 = i2 - 2;
                if (i5 >= this.bzE || i4 < 0) {
                    i2 = i5 + 3;
                    i = i4 + 1;
                } else {
                    i2 = i4;
                    i = i3;
                }
            }
            i2 = i5 + 3;
            i = i4 + 1;
            if (i2 >= this.bzE && i >= this.bzF) {
                break;
            }
        }
        if (!bF(this.bzF - 1, this.bzE - 1)) {
            f(this.bzF - 1, this.bzE - 1, true);
            f(this.bzF - 2, this.bzE - 2, true);
        }
        AppMethodBeat.o(57168);
    }

    private void q(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        boolean z = true;
        AppMethodBeat.i(57169);
        if (i < 0) {
            i5 = i + this.bzE;
            i6 = (4 - ((this.bzE + 4) % 8)) + i2;
        } else {
            i6 = i2;
            i5 = i;
        }
        if (i6 < 0) {
            i6 += this.bzF;
            i5 += 4 - ((this.bzF + 4) % 8);
        }
        if ((this.bzD.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        f(i6, i5, z);
        AppMethodBeat.o(57169);
    }

    private void A(int i, int i2, int i3) {
        AppMethodBeat.i(57170);
        q(i - 2, i2 - 2, i3, 1);
        q(i - 2, i2 - 1, i3, 2);
        q(i - 1, i2 - 2, i3, 3);
        q(i - 1, i2 - 1, i3, 4);
        q(i - 1, i2, i3, 5);
        q(i, i2 - 2, i3, 6);
        q(i, i2 - 1, i3, 7);
        q(i, i2, i3, 8);
        AppMethodBeat.o(57170);
    }
}
