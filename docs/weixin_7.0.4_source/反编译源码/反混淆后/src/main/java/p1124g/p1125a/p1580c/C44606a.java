package p1124g.p1125a.p1580c;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: g.a.c.a */
public final class C44606a {
    public short[] BZY;
    public int BZZ;

    public C44606a(int i) {
        AppMethodBeat.m2504i(86245);
        this.BZZ = i;
        this.BZY = new short[(1 << i)];
        AppMethodBeat.m2505o(86245);
    }

    /* renamed from: a */
    public final int mo71474a(C41149b c41149b) {
        int i;
        AppMethodBeat.m2504i(86246);
        int i2 = 1;
        for (i = this.BZZ; i != 0; i--) {
            i2 = c41149b.mo65730g(this.BZY, i2) + (i2 << 1);
        }
        i = i2 - (1 << this.BZZ);
        AppMethodBeat.m2505o(86246);
        return i;
    }
}
