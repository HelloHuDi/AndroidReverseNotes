package a.i.b.a.c.g;

import a.i.b.a.c.g.i.f;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private static final g BzB = new g((byte) 0);
    private static volatile boolean Bzz = false;
    final Map<a, f<?, ?>> BzA;

    static final class a {
        private final int number;
        private final Object object;

        a(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            AppMethodBeat.i(121491);
            int identityHashCode = (System.identityHashCode(this.object) * CdnLogic.kBizGeneric) + this.number;
            AppMethodBeat.o(121491);
            return identityHashCode;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.object == aVar.object && this.number == aVar.number) {
                return true;
            }
            return false;
        }
    }

    static {
        AppMethodBeat.i(121496);
        AppMethodBeat.o(121496);
    }

    public static g eie() {
        AppMethodBeat.i(121492);
        g gVar = new g();
        AppMethodBeat.o(121492);
        return gVar;
    }

    public static g eif() {
        return BzB;
    }

    public final void a(f<?, ?> fVar) {
        AppMethodBeat.i(121493);
        this.BzA.put(new a(fVar.BzS, fVar.BzU.number), fVar);
        AppMethodBeat.o(121493);
    }

    g() {
        AppMethodBeat.i(121494);
        this.BzA = new HashMap();
        AppMethodBeat.o(121494);
    }

    private g(byte b) {
        AppMethodBeat.i(121495);
        this.BzA = Collections.emptyMap();
        AppMethodBeat.o(121495);
    }
}
