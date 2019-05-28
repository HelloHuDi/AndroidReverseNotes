package a.i.b.a.c.b.c;

import a.a.ag;
import a.a.m;
import a.a.x;
import a.aa;
import a.f;
import a.f.b.j;
import a.f.b.t;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ac;
import a.i.b.a.c.b.ad;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.n;
import a.i.b.a.c.b.u;
import a.i.b.a.c.b.y;
import a.i.b.a.c.k.c;
import a.i.b.a.c.k.i;
import a.i.k;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class v extends j implements y {
    static final /* synthetic */ k[] eQB = new k[]{a.f.b.v.a(new t(a.f.b.v.aN(v.class), "packageFragmentProviderForWholeModuleWithDependencies", "getPackageFragmentProviderForWholeModuleWithDependencies()Lorg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider;"))};
    private final i Baf;
    private final g BfO;
    private final Map<Object<? extends Object>, Object> BiO;
    private t BiP;
    private ac BiQ;
    private final c<a.i.b.a.c.f.b, ad> BiR;
    private final f BiS;
    private final a.i.b.a.c.f.f BiT;
    private boolean bYN;

    static final class a extends a.f.b.k implements a.f.a.a<i> {
        final /* synthetic */ v BiU;

        a(v vVar) {
            this.BiU = vVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119507);
            t b = this.BiU.BiP;
            Throwable assertionError;
            if (b == null) {
                assertionError = new AssertionError("Dependencies of module " + v.c(this.BiU) + " were not set before querying module content");
                AppMethodBeat.o(119507);
                throw assertionError;
            }
            List<v> eaz = b.eaz();
            boolean contains = eaz.contains(this.BiU);
            if (!aa.AUz || contains) {
                for (v vVar : eaz) {
                    boolean d = v.d(vVar);
                    if (aa.AUz && !d) {
                        assertionError = new AssertionError("Dependency module " + v.c(vVar) + " was not initialized by the time contents of dependent module " + v.c(this.BiU) + " were queried");
                        AppMethodBeat.o(119507);
                        throw assertionError;
                    }
                }
                Iterable<v> iterable = eaz;
                Collection arrayList = new ArrayList(m.d(iterable));
                for (v e : iterable) {
                    ac e2 = e.BiQ;
                    if (e2 == null) {
                        j.dWJ();
                    }
                    arrayList.add(e2);
                }
                i iVar = new i((List) arrayList);
                AppMethodBeat.o(119507);
                return iVar;
            }
            assertionError = new AssertionError("Module " + v.c(this.BiU) + " is not contained in his own dependencies, this is probably a misconfiguration");
            AppMethodBeat.o(119507);
            throw assertionError;
        }
    }

    static final class b extends a.f.b.k implements a.f.a.b<a.i.b.a.c.f.b, r> {
        final /* synthetic */ v BiU;

        b(v vVar) {
            this.BiU = vVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119508);
            a.i.b.a.c.f.b bVar = (a.i.b.a.c.f.b) obj;
            j.p(bVar, "fqName");
            r rVar = new r(this.BiU, bVar, this.BiU.Baf);
            AppMethodBeat.o(119508);
            return rVar;
        }
    }

    static {
        AppMethodBeat.i(119509);
        AppMethodBeat.o(119509);
    }

    public v(a.i.b.a.c.f.f fVar, i iVar, g gVar) {
        this(fVar, iVar, gVar, null, 48);
    }

    private final i eaD() {
        AppMethodBeat.i(119513);
        i iVar = (i) this.BiS.getValue();
        AppMethodBeat.o(119513);
        return iVar;
    }

    public static final /* synthetic */ String c(v vVar) {
        AppMethodBeat.i(119525);
        String id = vVar.getId();
        AppMethodBeat.o(119525);
        return id;
    }

    public static final /* synthetic */ boolean d(v vVar) {
        AppMethodBeat.i(119526);
        boolean isInitialized = vVar.isInitialized();
        AppMethodBeat.o(119526);
        return isInitialized;
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        AppMethodBeat.i(119524);
        j.p(nVar, "visitor");
        j.p(nVar, "visitor");
        Object a = nVar.a((y) this, (Object) d);
        AppMethodBeat.o(119524);
        return a;
    }

    public final l dXW() {
        return null;
    }

    public final g dZD() {
        return this.BfO;
    }

    public /* synthetic */ v(a.i.b.a.c.f.f fVar, i iVar, g gVar, Map map, int i) {
        if ((i & 16) != 0) {
            map = ag.emptyMap();
        }
        this(fVar, iVar, gVar, map);
        AppMethodBeat.i(119523);
        AppMethodBeat.o(119523);
    }

    private v(a.i.b.a.c.f.f fVar, i iVar, g gVar, Map<Object<?>, ? extends Object> map) {
        j.p(fVar, "moduleName");
        j.p(iVar, "storageManager");
        j.p(gVar, "builtIns");
        j.p(map, "capabilities");
        a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
        super(a.i.b.a.c.b.a.g.a.eai(), fVar);
        AppMethodBeat.i(119522);
        this.Baf = iVar;
        this.BfO = gVar;
        this.BiT = null;
        if (fVar.ByZ) {
            Map emptyMap = ag.emptyMap();
            j.p(map, "receiver$0");
            j.p(emptyMap, "map");
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            linkedHashMap.putAll(emptyMap);
            this.BiO = linkedHashMap;
            this.bYN = true;
            this.BiR = this.Baf.f(new b(this));
            this.BiS = a.i.g(new a(this));
            AppMethodBeat.o(119522);
            return;
        }
        Throwable illegalArgumentException = new IllegalArgumentException("Module name must be special: ".concat(String.valueOf(fVar)));
        AppMethodBeat.o(119522);
        throw illegalArgumentException;
    }

    public final ad g(a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(119511);
        j.p(bVar, "fqName");
        eaC();
        ad adVar = (ad) this.BiR.am(bVar);
        AppMethodBeat.o(119511);
        return adVar;
    }

    public final Collection<a.i.b.a.c.f.b> a(a.i.b.a.c.f.b bVar, a.f.a.b<? super a.i.b.a.c.f.f, Boolean> bVar2) {
        AppMethodBeat.i(119512);
        j.p(bVar, "fqName");
        j.p(bVar2, "nameFilter");
        eaC();
        Collection a = eaE().a(bVar, bVar2);
        AppMethodBeat.o(119512);
        return a;
    }

    private final boolean isInitialized() {
        return this.BiQ != null;
    }

    private void a(t tVar) {
        AppMethodBeat.i(119514);
        j.p(tVar, "dependencies");
        Object obj = this.BiP == null ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Dependencies of " + getId() + " were already set");
            AppMethodBeat.o(119514);
            throw assertionError;
        }
        this.BiP = tVar;
        AppMethodBeat.o(119514);
    }

    public final void a(v... vVarArr) {
        AppMethodBeat.i(119515);
        j.p(vVarArr, "descriptors");
        fU(a.a.i.Q(vVarArr));
        AppMethodBeat.o(119515);
    }

    private void a(List<v> list, Set<v> set) {
        AppMethodBeat.i(119517);
        j.p(list, "descriptors");
        j.p(set, NativeProtocol.AUDIENCE_FRIENDS);
        a((t) new u(list, set, a.a.v.AUP));
        AppMethodBeat.o(119517);
    }

    public final boolean a(y yVar) {
        AppMethodBeat.i(119518);
        j.p(yVar, "targetModule");
        if (!j.j(this, yVar)) {
            t tVar = this.BiP;
            if (tVar == null) {
                j.dWJ();
            }
            if (!a.a.t.a((Iterable) tVar.eaA(), (Object) yVar)) {
                tVar = this.BiP;
                if (tVar == null) {
                    Throwable assertionError = new AssertionError("Dependencies of module " + getId() + " were not set");
                    AppMethodBeat.o(119518);
                    throw assertionError;
                } else if (!tVar.eaB().contains(yVar)) {
                    AppMethodBeat.o(119518);
                    return false;
                }
            }
        }
        AppMethodBeat.o(119518);
        return true;
    }

    public final void a(ac acVar) {
        AppMethodBeat.i(119520);
        j.p(acVar, "providerForModuleContent");
        Object obj = !isInitialized() ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Attempt to initialize module " + getId() + " twice");
            AppMethodBeat.o(119520);
            throw assertionError;
        }
        this.BiQ = acVar;
        AppMethodBeat.o(119520);
    }

    public final ac eaE() {
        AppMethodBeat.i(119521);
        eaC();
        ac eaD = eaD();
        AppMethodBeat.o(119521);
        return eaD;
    }

    private void eaC() {
        AppMethodBeat.i(119510);
        if (this.bYN) {
            AppMethodBeat.o(119510);
            return;
        }
        Throwable uVar = new u("Accessing invalid module descriptor ".concat(String.valueOf(this)));
        AppMethodBeat.o(119510);
        throw uVar;
    }

    private void fU(List<v> list) {
        AppMethodBeat.i(119516);
        j.p(list, "descriptors");
        a((List) list, (Set) x.AUR);
        AppMethodBeat.o(119516);
    }

    private final String getId() {
        AppMethodBeat.i(119519);
        String fVar = this.BgZ.toString();
        j.o(fVar, "name.toString()");
        AppMethodBeat.o(119519);
        return fVar;
    }
}
