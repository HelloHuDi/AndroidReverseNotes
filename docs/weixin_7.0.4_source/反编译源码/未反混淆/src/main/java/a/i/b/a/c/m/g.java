package a.i.b.a.c.m;

import a.f.b.j;
import a.i.b.a.c.b.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface g {

    public static final class a implements g {
        public static final a BLF = new a();

        static {
            AppMethodBeat.i(122872);
            AppMethodBeat.o(122872);
        }

        private a() {
        }

        public final boolean h(l lVar, l lVar2) {
            AppMethodBeat.i(122871);
            j.p(lVar, "what");
            j.p(lVar2, "from");
            AppMethodBeat.o(122871);
            return true;
        }
    }

    boolean h(l lVar, l lVar2);
}
