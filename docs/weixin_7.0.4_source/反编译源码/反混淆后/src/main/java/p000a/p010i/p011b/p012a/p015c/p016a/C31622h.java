package p000a.p010i.p011b.p012a.p015c.p016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.a.h */
public enum C31622h {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    public static final Set<C31622h> BbY = null;
    public final C37022f BbZ;
    public final C37022f Bca;
    public C8174b Bcb;
    private C8174b Bcc;

    static {
        BbY = Collections.unmodifiableSet(EnumSet.of(CHAR, new C31622h[]{BYTE, SHORT, INT, FLOAT, LONG, DOUBLE}));
        AppMethodBeat.m2505o(119106);
    }

    private C31622h(String str) {
        AppMethodBeat.m2504i(119105);
        this.Bcb = null;
        this.Bcc = null;
        this.BbZ = C37022f.avX(str);
        this.Bca = C37022f.avX(str + "Array");
        AppMethodBeat.m2505o(119105);
    }
}
