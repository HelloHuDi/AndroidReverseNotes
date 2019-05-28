package p000a.p010i.p011b.p012a.p015c.p048n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import p000a.p005f.p006a.C17126b;

/* renamed from: a.i.b.a.c.n.b */
public final class C31781b {

    /* renamed from: a.i.b.a.c.n.b$e */
    public static class C17330e<N> implements C31784d<N> {
        private final Set<N> BML;

        public C17330e() {
            this(new HashSet());
            AppMethodBeat.m2504i(122921);
            AppMethodBeat.m2505o(122921);
        }

        private C17330e(Set<N> set) {
            this.BML = set;
        }

        /* renamed from: dV */
        public final boolean mo31399dV(N n) {
            AppMethodBeat.m2504i(122922);
            boolean add = this.BML.add(n);
            AppMethodBeat.m2505o(122922);
            return add;
        }
    }

    /* renamed from: a.i.b.a.c.n.b$b */
    public interface C31782b<N> {
        /* renamed from: dA */
        Iterable<? extends N> mo13654dA(N n);
    }

    /* renamed from: a.i.b.a.c.n.b$c */
    public interface C31783c<N, R> {
        /* renamed from: dB */
        boolean mo13655dB(N n);

        /* renamed from: dR */
        void mo31364dR(N n);

        R dYP();
    }

    /* renamed from: a.i.b.a.c.n.b$d */
    public interface C31784d<N> {
        /* renamed from: dV */
        boolean mo31399dV(N n);
    }

    /* renamed from: a.i.b.a.c.n.b$a */
    public static abstract class C31785a<N, R> implements C31783c<N, R> {
        /* renamed from: dB */
        public boolean mo13655dB(N n) {
            return true;
        }

        /* renamed from: dR */
        public void mo31364dR(N n) {
        }
    }

    /* renamed from: a */
    private static <N, R> R m51482a(Collection<N> collection, C31782b<N> c31782b, C31784d<N> c31784d, C31783c<N, R> c31783c) {
        AppMethodBeat.m2504i(122923);
        for (N a : collection) {
            C31781b.m51483a((Object) a, (C31782b) c31782b, (C31784d) c31784d, (C31783c) c31783c);
        }
        Object dYP = c31783c.dYP();
        AppMethodBeat.m2505o(122923);
        return dYP;
    }

    /* renamed from: a */
    public static <N, R> R m51481a(Collection<N> collection, C31782b<N> c31782b, C31783c<N, R> c31783c) {
        AppMethodBeat.m2504i(122924);
        Object a = C31781b.m51482a((Collection) collection, (C31782b) c31782b, new C17330e(), (C31783c) c31783c);
        AppMethodBeat.m2505o(122924);
        return a;
    }

    /* renamed from: a */
    public static <N> Boolean m51480a(Collection<N> collection, C31782b<N> c31782b, final C17126b<N, Boolean> c17126b) {
        AppMethodBeat.m2504i(122925);
        final boolean[] zArr = new boolean[1];
        Boolean bool = (Boolean) C31781b.m51481a((Collection) collection, (C31782b) c31782b, new C31785a<N, Boolean>() {
            /* renamed from: dB */
            public final boolean mo13655dB(N n) {
                AppMethodBeat.m2504i(122919);
                if (((Boolean) c17126b.mo50am(n)).booleanValue()) {
                    zArr[0] = true;
                }
                if (zArr[0]) {
                    AppMethodBeat.m2505o(122919);
                    return false;
                }
                AppMethodBeat.m2505o(122919);
                return true;
            }

            public final /* synthetic */ Object dYP() {
                AppMethodBeat.m2504i(122920);
                Boolean valueOf = Boolean.valueOf(zArr[0]);
                AppMethodBeat.m2505o(122920);
                return valueOf;
            }
        });
        AppMethodBeat.m2505o(122925);
        return bool;
    }

    /* renamed from: a */
    private static <N> void m51483a(N n, C31782b<N> c31782b, C31784d<N> c31784d, C31783c<N, ?> c31783c) {
        AppMethodBeat.m2504i(122926);
        if (!c31784d.mo31399dV(n)) {
            AppMethodBeat.m2505o(122926);
        } else if (c31783c.mo13655dB(n)) {
            for (Object a : c31782b.mo13654dA(n)) {
                C31781b.m51483a(a, (C31782b) c31782b, (C31784d) c31784d, (C31783c) c31783c);
            }
            c31783c.mo31364dR(n);
            AppMethodBeat.m2505o(122926);
        } else {
            AppMethodBeat.m2505o(122926);
        }
    }
}
