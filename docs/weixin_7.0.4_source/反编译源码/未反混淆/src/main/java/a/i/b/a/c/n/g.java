package a.i.b.a.c.n;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");
    
    public static final a BNn = null;
    final String description;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private g(String str) {
        j.p(str, "description");
        AppMethodBeat.i(122945);
        this.description = str;
        AppMethodBeat.o(122945);
    }

    static {
        BNn = new a();
        AppMethodBeat.o(122944);
    }

    public final boolean eky() {
        return ((g) this) == WARN;
    }

    public final boolean ekz() {
        return ((g) this) == IGNORE;
    }
}
