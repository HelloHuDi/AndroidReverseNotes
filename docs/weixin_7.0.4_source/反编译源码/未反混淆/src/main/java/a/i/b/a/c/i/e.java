package a.i.b.a.c.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface e {

    public enum a {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH;

        static {
            AppMethodBeat.o(121978);
        }
    }

    public enum b {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN;

        static {
            AppMethodBeat.o(121981);
        }
    }

    b a(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2, a.i.b.a.c.b.e eVar);

    a eaX();
}
