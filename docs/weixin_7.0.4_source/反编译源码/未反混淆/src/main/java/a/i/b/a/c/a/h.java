package a.i.b.a.c.a;

import a.i.b.a.c.f.b;
import a.i.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum h {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    public static final Set<h> BbY = null;
    public final f BbZ;
    public final f Bca;
    public b Bcb;
    private b Bcc;

    static {
        BbY = Collections.unmodifiableSet(EnumSet.of(CHAR, new h[]{BYTE, SHORT, INT, FLOAT, LONG, DOUBLE}));
        AppMethodBeat.o(119106);
    }

    private h(String str) {
        AppMethodBeat.i(119105);
        this.Bcb = null;
        this.Bcc = null;
        this.BbZ = f.avX(str);
        this.Bca = f.avX(str + "Array");
        AppMethodBeat.o(119105);
    }
}
