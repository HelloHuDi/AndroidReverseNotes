package a.i.b.a.c.h;

import a.f.b.j;
import a.k.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum p {
    ;

    static final class a extends p {
        a(String str) {
            super(str, 1);
        }

        public final String escape(String str) {
            AppMethodBeat.i(121912);
            j.p(str, "string");
            String i = u.i(u.i(str, "<", "&lt;", false), ">", "&gt;", false);
            AppMethodBeat.o(121912);
            return i;
        }
    }

    static final class b extends p {
        b(String str) {
            super(str, 0);
        }

        public final String escape(String str) {
            AppMethodBeat.i(121913);
            j.p(str, "string");
            AppMethodBeat.o(121913);
            return str;
        }
    }

    public abstract String escape(String str);
}
