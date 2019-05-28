package a.i.b.a.c.l;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ba {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);
    
    private final boolean BKl;
    public final boolean BKm;
    private final int BKn;
    public final String label;

    private ba(String str, boolean z, boolean z2, int i) {
        j.p(str, "label");
        AppMethodBeat.i(122708);
        this.label = str;
        this.BKl = z;
        this.BKm = z2;
        this.BKn = i;
        AppMethodBeat.o(122708);
    }

    static {
        AppMethodBeat.o(122707);
    }

    public final String toString() {
        return this.label;
    }
}
