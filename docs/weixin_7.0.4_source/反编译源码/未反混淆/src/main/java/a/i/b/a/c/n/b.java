package a.i.b.a.c.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class b {

    public static class e<N> implements d<N> {
        private final Set<N> BML;

        public e() {
            this(new HashSet());
            AppMethodBeat.i(122921);
            AppMethodBeat.o(122921);
        }

        private e(Set<N> set) {
            this.BML = set;
        }

        public final boolean dV(N n) {
            AppMethodBeat.i(122922);
            boolean add = this.BML.add(n);
            AppMethodBeat.o(122922);
            return add;
        }
    }

    public interface b<N> {
        Iterable<? extends N> dA(N n);
    }

    public interface c<N, R> {
        boolean dB(N n);

        void dR(N n);

        R dYP();
    }

    public interface d<N> {
        boolean dV(N n);
    }

    public static abstract class a<N, R> implements c<N, R> {
        public boolean dB(N n) {
            return true;
        }

        public void dR(N n) {
        }
    }

    private static <N, R> R a(Collection<N> collection, b<N> bVar, d<N> dVar, c<N, R> cVar) {
        AppMethodBeat.i(122923);
        for (N a : collection) {
            a((Object) a, (b) bVar, (d) dVar, (c) cVar);
        }
        Object dYP = cVar.dYP();
        AppMethodBeat.o(122923);
        return dYP;
    }

    public static <N, R> R a(Collection<N> collection, b<N> bVar, c<N, R> cVar) {
        AppMethodBeat.i(122924);
        Object a = a((Collection) collection, (b) bVar, new e(), (c) cVar);
        AppMethodBeat.o(122924);
        return a;
    }

    public static <N> Boolean a(Collection<N> collection, b<N> bVar, final a.f.a.b<N, Boolean> bVar2) {
        AppMethodBeat.i(122925);
        final boolean[] zArr = new boolean[1];
        Boolean bool = (Boolean) a((Collection) collection, (b) bVar, new a<N, Boolean>() {
            public final boolean dB(N n) {
                AppMethodBeat.i(122919);
                if (((Boolean) bVar2.am(n)).booleanValue()) {
                    zArr[0] = true;
                }
                if (zArr[0]) {
                    AppMethodBeat.o(122919);
                    return false;
                }
                AppMethodBeat.o(122919);
                return true;
            }

            public final /* synthetic */ Object dYP() {
                AppMethodBeat.i(122920);
                Boolean valueOf = Boolean.valueOf(zArr[0]);
                AppMethodBeat.o(122920);
                return valueOf;
            }
        });
        AppMethodBeat.o(122925);
        return bool;
    }

    private static <N> void a(N n, b<N> bVar, d<N> dVar, c<N, ?> cVar) {
        AppMethodBeat.i(122926);
        if (!dVar.dV(n)) {
            AppMethodBeat.o(122926);
        } else if (cVar.dB(n)) {
            for (Object a : bVar.dA(n)) {
                a(a, (b) bVar, (d) dVar, (c) cVar);
            }
            cVar.dR(n);
            AppMethodBeat.o(122926);
        } else {
            AppMethodBeat.o(122926);
        }
    }
}
