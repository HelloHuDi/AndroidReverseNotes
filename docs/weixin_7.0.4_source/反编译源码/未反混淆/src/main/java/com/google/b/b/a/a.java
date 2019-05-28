package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class a {
    public static final a bzm = new a(4201, 4096, 1);
    public static final a bzn = new a(1033, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 1);
    public static final a bzo = new a(67, 64, 1);
    public static final a bzp = new a(19, 16, 1);
    public static final a bzq = new a(285, 256, 0);
    public static final a bzr;
    public static final a bzs;
    public static final a bzt = bzo;
    final int[] bzu;
    final int[] bzv;
    final b bzw;
    private final b bzx;
    private final int bzy;
    final int bzz;
    final int size;

    static {
        AppMethodBeat.i(57273);
        a aVar = new a(301, 256, 1);
        bzr = aVar;
        bzs = aVar;
        AppMethodBeat.o(57273);
    }

    private a(int i, int i2, int i3) {
        AppMethodBeat.i(57271);
        this.bzy = i;
        this.size = i2;
        this.bzz = i3;
        this.bzu = new int[i2];
        this.bzv = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.bzu[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (i4 = 0; i4 < i2 - 1; i4++) {
            this.bzv[this.bzu[i4]] = i4;
        }
        this.bzw = new b(this, new int[]{0});
        this.bzx = new b(this, new int[]{1});
        AppMethodBeat.o(57271);
    }

    static int bC(int i, int i2) {
        return i ^ i2;
    }

    /* Access modifiers changed, original: final */
    public final int bD(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.bzu[(this.bzv[i] + this.bzv[i2]) % (this.size - 1)];
    }

    public final String toString() {
        AppMethodBeat.i(57272);
        String str = "GF(0x" + Integer.toHexString(this.bzy) + ',' + this.size + ')';
        AppMethodBeat.o(57272);
        return str;
    }
}
