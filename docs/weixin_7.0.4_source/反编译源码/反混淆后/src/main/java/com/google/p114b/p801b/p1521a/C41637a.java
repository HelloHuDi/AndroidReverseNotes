package com.google.p114b.p801b.p1521a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;

/* renamed from: com.google.b.b.a.a */
public final class C41637a {
    public static final C41637a bzm = new C41637a(4201, 4096, 1);
    public static final C41637a bzn = new C41637a(1033, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 1);
    public static final C41637a bzo = new C41637a(67, 64, 1);
    public static final C41637a bzp = new C41637a(19, 16, 1);
    public static final C41637a bzq = new C41637a(285, 256, 0);
    public static final C41637a bzr;
    public static final C41637a bzs;
    public static final C41637a bzt = bzo;
    final int[] bzu;
    final int[] bzv;
    final C45060b bzw;
    private final C45060b bzx;
    private final int bzy;
    final int bzz;
    final int size;

    static {
        AppMethodBeat.m2504i(57273);
        C41637a c41637a = new C41637a(301, 256, 1);
        bzr = c41637a;
        bzs = c41637a;
        AppMethodBeat.m2505o(57273);
    }

    private C41637a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(57271);
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
        this.bzw = new C45060b(this, new int[]{0});
        this.bzx = new C45060b(this, new int[]{1});
        AppMethodBeat.m2505o(57271);
    }

    /* renamed from: bC */
    static int m72996bC(int i, int i2) {
        return i ^ i2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bD */
    public final int mo67033bD(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.bzu[(this.bzv[i] + this.bzv[i2]) % (this.size - 1)];
    }

    public final String toString() {
        AppMethodBeat.m2504i(57272);
        String str = "GF(0x" + Integer.toHexString(this.bzy) + ',' + this.size + ')';
        AppMethodBeat.m2505o(57272);
        return str;
    }
}
