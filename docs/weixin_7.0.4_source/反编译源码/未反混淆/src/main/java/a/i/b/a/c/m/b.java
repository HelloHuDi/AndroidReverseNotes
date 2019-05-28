package a.i.b.a.c.m;

import a.f.b.j;
import a.i.b.a.c.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b {

    public static final class a {
        public static String a(b bVar, t tVar) {
            AppMethodBeat.i(122848);
            j.p(tVar, "functionDescriptor");
            if (bVar.h(tVar)) {
                AppMethodBeat.o(122848);
                return null;
            }
            String description = bVar.getDescription();
            AppMethodBeat.o(122848);
            return description;
        }
    }

    String getDescription();

    boolean h(t tVar);

    String i(t tVar);
}
