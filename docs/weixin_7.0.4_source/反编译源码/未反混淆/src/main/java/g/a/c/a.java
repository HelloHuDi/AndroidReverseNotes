package g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public short[] BZY;
    public int BZZ;

    public a(int i) {
        AppMethodBeat.i(86245);
        this.BZZ = i;
        this.BZY = new short[(1 << i)];
        AppMethodBeat.o(86245);
    }

    public final int a(b bVar) {
        int i;
        AppMethodBeat.i(86246);
        int i2 = 1;
        for (i = this.BZZ; i != 0; i--) {
            i2 = bVar.g(this.BZY, i2) + (i2 << 1);
        }
        i = i2 - (1 << this.BZZ);
        AppMethodBeat.o(86246);
        return i;
    }
}
