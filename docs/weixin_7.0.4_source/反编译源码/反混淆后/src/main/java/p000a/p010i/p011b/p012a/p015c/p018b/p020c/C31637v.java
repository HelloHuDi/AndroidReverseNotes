package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.C17344i;
import p000a.C44847aa;
import p000a.C44856f;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p001a.C36913i;
import p000a.p001a.C44629x;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36954ad;
import p000a.p010i.p011b.p012a.p015c.p018b.C44871ac;
import p000a.p010i.p011b.p012a.p015c.p018b.C44877n;
import p000a.p010i.p011b.p012a.p015c.p018b.C44878u;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p044k.C24619c;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.c.v */
public final class C31637v extends C25087j implements C25093y {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C31637v.class), "packageFragmentProviderForWholeModuleWithDependencies", "getPackageFragmentProviderForWholeModuleWithDependencies()Lorg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider;"))};
    private final C25212i Baf;
    private final C31619g BfO;
    private final Map<Object<? extends Object>, Object> BiO;
    private C17169t BiP;
    private C44871ac BiQ;
    private final C24619c<C8174b, C36954ad> BiR;
    private final C44856f BiS;
    private final C37022f BiT;
    private boolean bYN;

    /* renamed from: a.i.b.a.c.b.c.v$a */
    static final class C31638a extends C25053k implements C31214a<C17167i> {
        final /* synthetic */ C31637v BiU;

        C31638a(C31637v c31637v) {
            this.BiU = c31637v;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119507);
            C17169t b = this.BiU.BiP;
            Throwable assertionError;
            if (b == null) {
                assertionError = new AssertionError("Dependencies of module " + C31637v.m51163c(this.BiU) + " were not set before querying module content");
                AppMethodBeat.m2505o(119507);
                throw assertionError;
            }
            List<C31637v> eaz = b.eaz();
            boolean contains = eaz.contains(this.BiU);
            if (!C44847aa.AUz || contains) {
                for (C31637v c31637v : eaz) {
                    boolean d = C31637v.m51164d(c31637v);
                    if (C44847aa.AUz && !d) {
                        assertionError = new AssertionError("Dependency module " + C31637v.m51163c(c31637v) + " was not initialized by the time contents of dependent module " + C31637v.m51163c(this.BiU) + " were queried");
                        AppMethodBeat.m2505o(119507);
                        throw assertionError;
                    }
                }
                Iterable<C31637v> iterable = eaz;
                Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
                for (C31637v e : iterable) {
                    C44871ac e2 = e.BiQ;
                    if (e2 == null) {
                        C25052j.dWJ();
                    }
                    arrayList.add(e2);
                }
                C17167i c17167i = new C17167i((List) arrayList);
                AppMethodBeat.m2505o(119507);
                return c17167i;
            }
            assertionError = new AssertionError("Module " + C31637v.m51163c(this.BiU) + " is not contained in his own dependencies, this is probably a misconfiguration");
            AppMethodBeat.m2505o(119507);
            throw assertionError;
        }
    }

    /* renamed from: a.i.b.a.c.b.c.v$b */
    static final class C31639b extends C25053k implements C17126b<C8174b, C8075r> {
        final /* synthetic */ C31637v BiU;

        C31639b(C31637v c31637v) {
            this.BiU = c31637v;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119508);
            C8174b c8174b = (C8174b) obj;
            C25052j.m39376p(c8174b, "fqName");
            C8075r c8075r = new C8075r(this.BiU, c8174b, this.BiU.Baf);
            AppMethodBeat.m2505o(119508);
            return c8075r;
        }
    }

    static {
        AppMethodBeat.m2504i(119509);
        AppMethodBeat.m2505o(119509);
    }

    public C31637v(C37022f c37022f, C25212i c25212i, C31619g c31619g) {
        this(c37022f, c25212i, c31619g, null, 48);
    }

    private final C17167i eaD() {
        AppMethodBeat.m2504i(119513);
        C17167i c17167i = (C17167i) this.BiS.getValue();
        AppMethodBeat.m2505o(119513);
        return c17167i;
    }

    /* renamed from: c */
    public static final /* synthetic */ String m51163c(C31637v c31637v) {
        AppMethodBeat.m2504i(119525);
        String id = c31637v.getId();
        AppMethodBeat.m2505o(119525);
        return id;
    }

    /* renamed from: d */
    public static final /* synthetic */ boolean m51164d(C31637v c31637v) {
        AppMethodBeat.m2504i(119526);
        boolean isInitialized = c31637v.isInitialized();
        AppMethodBeat.m2505o(119526);
        return isInitialized;
    }

    /* renamed from: a */
    public final <R, D> R mo245a(C44877n<R, D> c44877n, D d) {
        AppMethodBeat.m2504i(119524);
        C25052j.m39376p(c44877n, "visitor");
        C25052j.m39376p(c44877n, "visitor");
        Object a = c44877n.mo13680a((C25093y) this, (Object) d);
        AppMethodBeat.m2505o(119524);
        return a;
    }

    public final C31642l dXW() {
        return null;
    }

    public final C31619g dZD() {
        return this.BfO;
    }

    public /* synthetic */ C31637v(C37022f c37022f, C25212i c25212i, C31619g c31619g, Map map, int i) {
        if ((i & 16) != 0) {
            map = C31586ag.emptyMap();
        }
        this(c37022f, c25212i, c31619g, map);
        AppMethodBeat.m2504i(119523);
        AppMethodBeat.m2505o(119523);
    }

    private C31637v(C37022f c37022f, C25212i c25212i, C31619g c31619g, Map<Object<?>, ? extends Object> map) {
        C25052j.m39376p(c37022f, "moduleName");
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c31619g, "builtIns");
        C25052j.m39376p(map, "capabilities");
        C0027a c0027a = C0026g.BfJ;
        super(C0027a.eai(), c37022f);
        AppMethodBeat.m2504i(119522);
        this.Baf = c25212i;
        this.BfO = c31619g;
        this.BiT = null;
        if (c37022f.ByZ) {
            Map emptyMap = C31586ag.emptyMap();
            C25052j.m39376p(map, "receiver$0");
            C25052j.m39376p(emptyMap, "map");
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            linkedHashMap.putAll(emptyMap);
            this.BiO = linkedHashMap;
            this.bYN = true;
            this.BiR = this.Baf.mo31371f(new C31639b(this));
            this.BiS = C17344i.m26854g(new C31638a(this));
            AppMethodBeat.m2505o(119522);
            return;
        }
        Throwable illegalArgumentException = new IllegalArgumentException("Module name must be special: ".concat(String.valueOf(c37022f)));
        AppMethodBeat.m2505o(119522);
        throw illegalArgumentException;
    }

    /* renamed from: g */
    public final C36954ad mo252g(C8174b c8174b) {
        AppMethodBeat.m2504i(119511);
        C25052j.m39376p(c8174b, "fqName");
        eaC();
        C36954ad c36954ad = (C36954ad) this.BiR.mo50am(c8174b);
        AppMethodBeat.m2505o(119511);
        return c36954ad;
    }

    /* renamed from: a */
    public final Collection<C8174b> mo246a(C8174b c8174b, C17126b<? super C37022f, Boolean> c17126b) {
        AppMethodBeat.m2504i(119512);
        C25052j.m39376p(c8174b, "fqName");
        C25052j.m39376p(c17126b, "nameFilter");
        eaC();
        Collection a = eaE().mo17924a(c8174b, c17126b);
        AppMethodBeat.m2505o(119512);
        return a;
    }

    private final boolean isInitialized() {
        return this.BiQ != null;
    }

    /* renamed from: a */
    private void m51160a(C17169t c17169t) {
        AppMethodBeat.m2504i(119514);
        C25052j.m39376p(c17169t, "dependencies");
        Object obj = this.BiP == null ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Dependencies of " + getId() + " were already set");
            AppMethodBeat.m2505o(119514);
            throw assertionError;
        }
        this.BiP = c17169t;
        AppMethodBeat.m2505o(119514);
    }

    /* renamed from: a */
    public final void mo51629a(C31637v... c31637vArr) {
        AppMethodBeat.m2504i(119515);
        C25052j.m39376p(c31637vArr, "descriptors");
        m51166fU(C36913i.m61684Q(c31637vArr));
        AppMethodBeat.m2505o(119515);
    }

    /* renamed from: a */
    private void m51161a(List<C31637v> list, Set<C31637v> set) {
        AppMethodBeat.m2504i(119517);
        C25052j.m39376p(list, "descriptors");
        C25052j.m39376p(set, NativeProtocol.AUDIENCE_FRIENDS);
        m51160a((C17169t) new C0035u(list, set, C17115v.AUP));
        AppMethodBeat.m2505o(119517);
    }

    /* renamed from: a */
    public final boolean mo247a(C25093y c25093y) {
        AppMethodBeat.m2504i(119518);
        C25052j.m39376p(c25093y, "targetModule");
        if (!C25052j.m39373j(this, c25093y)) {
            C17169t c17169t = this.BiP;
            if (c17169t == null) {
                C25052j.dWJ();
            }
            if (!C25035t.m39327a((Iterable) c17169t.eaA(), (Object) c25093y)) {
                c17169t = this.BiP;
                if (c17169t == null) {
                    Throwable assertionError = new AssertionError("Dependencies of module " + getId() + " were not set");
                    AppMethodBeat.m2505o(119518);
                    throw assertionError;
                } else if (!c17169t.eaB().contains(c25093y)) {
                    AppMethodBeat.m2505o(119518);
                    return false;
                }
            }
        }
        AppMethodBeat.m2505o(119518);
        return true;
    }

    /* renamed from: a */
    public final void mo51628a(C44871ac c44871ac) {
        AppMethodBeat.m2504i(119520);
        C25052j.m39376p(c44871ac, "providerForModuleContent");
        Object obj = !isInitialized() ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Attempt to initialize module " + getId() + " twice");
            AppMethodBeat.m2505o(119520);
            throw assertionError;
        }
        this.BiQ = c44871ac;
        AppMethodBeat.m2505o(119520);
    }

    public final C44871ac eaE() {
        AppMethodBeat.m2504i(119521);
        eaC();
        C44871ac eaD = eaD();
        AppMethodBeat.m2505o(119521);
        return eaD;
    }

    private void eaC() {
        AppMethodBeat.m2504i(119510);
        if (this.bYN) {
            AppMethodBeat.m2505o(119510);
            return;
        }
        Throwable c44878u = new C44878u("Accessing invalid module descriptor ".concat(String.valueOf(this)));
        AppMethodBeat.m2505o(119510);
        throw c44878u;
    }

    /* renamed from: fU */
    private void m51166fU(List<C31637v> list) {
        AppMethodBeat.m2504i(119516);
        C25052j.m39376p(list, "descriptors");
        m51161a((List) list, (Set) C44629x.AUR);
        AppMethodBeat.m2505o(119516);
    }

    private final String getId() {
        AppMethodBeat.m2504i(119519);
        String c37022f = this.BgZ.toString();
        C25052j.m39375o(c37022f, "name.toString()");
        AppMethodBeat.m2505o(119519);
        return c37022f;
    }
}
