package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.l.ba */
public enum C0163ba {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);
    
    private final boolean BKl;
    public final boolean BKm;
    private final int BKn;
    public final String label;

    private C0163ba(String str, boolean z, boolean z2, int i) {
        C25052j.m39376p(str, "label");
        AppMethodBeat.m2504i(122708);
        this.label = str;
        this.BKl = z;
        this.BKm = z2;
        this.BKn = i;
        AppMethodBeat.m2505o(122708);
    }

    static {
        AppMethodBeat.m2505o(122707);
    }

    public final String toString() {
        return this.label;
    }
}
