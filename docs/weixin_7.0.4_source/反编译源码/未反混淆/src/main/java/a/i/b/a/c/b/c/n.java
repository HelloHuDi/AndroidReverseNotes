package a.i.b.a.c.b.c;

import a.f.a.b;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.i.e.d;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.i.e.i;
import a.i.b.a.c.i.j;
import a.i.b.a.c.k.c;
import a.i.b.a.c.k.f;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class n extends g {
    static final /* synthetic */ boolean $assertionsDisabled = (!n.class.desiredAssertionStatus());
    private final g Bfn;
    private final h BhC;
    private final f<Set<a.i.b.a.c.f.f>> BhD;
    final an Bhx;

    class a extends i {
        static final /* synthetic */ boolean $assertionsDisabled = (!n.class.desiredAssertionStatus());
        private final c<a.i.b.a.c.f.f, Collection<al>> BhE;
        private final c<a.i.b.a.c.f.f, Collection<ah>> BhF;
        private final f<Collection<l>> BhG;

        static {
            AppMethodBeat.i(119450);
            AppMethodBeat.o(119450);
        }

        public a(a.i.b.a.c.k.i iVar) {
            AppMethodBeat.i(119439);
            this.BhE = iVar.f(new b<a.i.b.a.c.f.f, Collection<al>>(n.this) {
                public final /* synthetic */ Object am(Object obj) {
                    AppMethodBeat.i(119435);
                    Collection a = a.a(a.this, (a.i.b.a.c.f.f) obj);
                    AppMethodBeat.o(119435);
                    return a;
                }
            });
            this.BhF = iVar.f(new b<a.i.b.a.c.f.f, Collection<ah>>(n.this) {
                public final /* synthetic */ Object am(Object obj) {
                    AppMethodBeat.i(119436);
                    Collection b = a.b(a.this, (a.i.b.a.c.f.f) obj);
                    AppMethodBeat.o(119436);
                    return b;
                }
            });
            this.BhG = iVar.i(new a.f.a.a<Collection<l>>(n.this) {
                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(119437);
                    Collection a = a.a(a.this);
                    AppMethodBeat.o(119437);
                    return a;
                }
            });
            AppMethodBeat.o(119439);
        }

        public final Collection a(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
            AppMethodBeat.i(119440);
            Collection collection = (Collection) this.BhF.am(fVar);
            AppMethodBeat.o(119440);
            return collection;
        }

        public final Collection b(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
            AppMethodBeat.i(119441);
            Collection collection = (Collection) this.BhE.am(fVar);
            AppMethodBeat.o(119441);
            return collection;
        }

        private h eat() {
            AppMethodBeat.i(119442);
            Collection eap = n.this.Bhx.eap();
            if ($assertionsDisabled || eap.size() == 1) {
                h dXR = ((w) eap.iterator().next()).dXR();
                AppMethodBeat.o(119442);
                return dXR;
            }
            AssertionError assertionError = new AssertionError("Enum entry and its companion object both should have exactly one supertype: ".concat(String.valueOf(eap)));
            AppMethodBeat.o(119442);
            throw assertionError;
        }

        private <D extends a.i.b.a.c.b.b> Collection<D> l(Collection<D> collection) {
            AppMethodBeat.i(119443);
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            j.a((Collection) collection, Collections.emptySet(), n.this, new a.i.b.a.c.i.h() {
                public final void g(a.i.b.a.c.b.b bVar) {
                    AppMethodBeat.i(119438);
                    j.a(bVar, null);
                    linkedHashSet.add(bVar);
                    AppMethodBeat.o(119438);
                }

                public final void a(a.i.b.a.c.b.b bVar, a.i.b.a.c.b.b bVar2) {
                }
            });
            AppMethodBeat.o(119443);
            return linkedHashSet;
        }

        public final Collection<l> a(d dVar, b<? super a.i.b.a.c.f.f, Boolean> bVar) {
            AppMethodBeat.i(119444);
            Collection collection = (Collection) this.BhG.invoke();
            AppMethodBeat.o(119444);
            return collection;
        }

        public final Set<a.i.b.a.c.f.f> eau() {
            AppMethodBeat.i(119445);
            Set set = (Set) n.this.BhD.invoke();
            AppMethodBeat.o(119445);
            return set;
        }

        public final Set<a.i.b.a.c.f.f> eav() {
            AppMethodBeat.i(119446);
            Set set = (Set) n.this.BhD.invoke();
            AppMethodBeat.o(119446);
            return set;
        }

        static /* synthetic */ Collection a(a aVar) {
            AppMethodBeat.i(119449);
            HashSet hashSet = new HashSet();
            for (a.i.b.a.c.f.f fVar : (Set) n.this.BhD.invoke()) {
                hashSet.addAll(aVar.b(fVar, a.i.b.a.c.c.a.c.FOR_NON_TRACKED_SCOPE));
                hashSet.addAll(aVar.a(fVar, a.i.b.a.c.c.a.c.FOR_NON_TRACKED_SCOPE));
            }
            AppMethodBeat.o(119449);
            return hashSet;
        }
    }

    static {
        AppMethodBeat.i(119457);
        AppMethodBeat.o(119457);
    }

    public static n a(a.i.b.a.c.k.i iVar, e eVar, a.i.b.a.c.f.f fVar, f<Set<a.i.b.a.c.f.f>> fVar2, g gVar, am amVar) {
        AppMethodBeat.i(119451);
        n nVar = new n(iVar, eVar, eVar.dZf(), fVar, fVar2, gVar, amVar);
        AppMethodBeat.o(119451);
        return nVar;
    }

    private n(a.i.b.a.c.k.i iVar, e eVar, w wVar, a.i.b.a.c.f.f fVar, f<Set<a.i.b.a.c.f.f>> fVar2, g gVar, am amVar) {
        super(iVar, eVar, fVar, amVar);
        AppMethodBeat.i(119452);
        if ($assertionsDisabled || eVar.dYc() == a.i.b.a.c.b.f.ENUM_CLASS) {
            this.Bfn = gVar;
            this.Bhx = new a.i.b.a.c.l.e(this, Collections.emptyList(), Collections.singleton(wVar), iVar);
            this.BhC = new a(iVar);
            this.BhD = fVar2;
            AppMethodBeat.o(119452);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(119452);
        throw assertionError;
    }

    public final h dXZ() {
        return this.BhC;
    }

    public final h dXX() {
        return h.b.BGh;
    }

    public final Collection<a.i.b.a.c.b.d> dYb() {
        AppMethodBeat.i(119453);
        List emptyList = Collections.emptyList();
        AppMethodBeat.o(119453);
        return emptyList;
    }

    public final an dXY() {
        return this.Bhx;
    }

    public final e dYa() {
        return null;
    }

    public final a.i.b.a.c.b.f dYc() {
        return a.i.b.a.c.b.f.ENUM_ENTRY;
    }

    public final a.i.b.a.c.b.w dYd() {
        return a.i.b.a.c.b.w.FINAL;
    }

    public final az dYf() {
        return ay.Bfa;
    }

    public final boolean dYh() {
        return false;
    }

    public final boolean dYi() {
        return false;
    }

    public final boolean dYj() {
        return false;
    }

    public final boolean dYg() {
        return false;
    }

    public final boolean dYk() {
        return false;
    }

    public final boolean dYl() {
        return false;
    }

    public final a.i.b.a.c.b.d dYe() {
        return null;
    }

    public final g dYn() {
        return this.Bfn;
    }

    public String toString() {
        AppMethodBeat.i(119454);
        String str = "enum entry " + this.BgZ;
        AppMethodBeat.o(119454);
        return str;
    }

    public final List<ar> dYq() {
        AppMethodBeat.i(119455);
        List emptyList = Collections.emptyList();
        AppMethodBeat.o(119455);
        return emptyList;
    }

    public final Collection<e> dYp() {
        AppMethodBeat.i(119456);
        List emptyList = Collections.emptyList();
        AppMethodBeat.o(119456);
        return emptyList;
    }
}
