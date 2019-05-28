package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class as {
    public static final as BJU = new b();
    public static final a BJV = new a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static final class b extends as {
        b() {
        }

        public final /* synthetic */ ap O(w wVar) {
            AppMethodBeat.i(122655);
            j.p(wVar, "key");
            AppMethodBeat.o(122655);
            return null;
        }

        public final boolean isEmpty() {
            return true;
        }

        public final String toString() {
            return "Empty TypeSubstitution";
        }
    }

    public abstract ap O(w wVar);

    public w a(w wVar, ba baVar) {
        j.p(wVar, "topLevelType");
        j.p(baVar, "position");
        return wVar;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean eki() {
        return false;
    }

    public boolean ejx() {
        return false;
    }

    public g h(g gVar) {
        j.p(gVar, "annotations");
        return gVar;
    }

    public final au ekr() {
        au d = au.d(this);
        j.o(d, "TypeSubstitutor.create(this)");
        return d;
    }
}
