package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import p000a.C37091y;
import p000a.p001a.C17115v;
import p000a.p001a.C25033k;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;

/* renamed from: a.i.b.a.c.l.c */
public abstract class C37055c implements C17313an {
    private final C41441f<C17318a> BJb;

    /* renamed from: a.i.b.a.c.l.c$c */
    static final class C8242c extends C25053k implements C17126b<Boolean, C17318a> {
        public static final C8242c BJf = new C8242c();

        static {
            AppMethodBeat.m2504i(122490);
            AppMethodBeat.m2505o(122490);
        }

        C8242c() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122489);
            ((Boolean) obj).booleanValue();
            C17318a c17318a = new C17318a(C25033k.listOf(C25235p.BJp));
            AppMethodBeat.m2505o(122489);
            return c17318a;
        }
    }

    /* renamed from: a.i.b.a.c.l.c$a */
    static final class C17318a {
        List<? extends C46867w> BJc = C25033k.listOf(C25235p.BJp);
        final Collection<C46867w> BJd;

        public C17318a(Collection<? extends C46867w> collection) {
            C25052j.m39376p(collection, "allSupertypes");
            AppMethodBeat.m2504i(122487);
            this.BJd = collection;
            AppMethodBeat.m2505o(122487);
        }
    }

    /* renamed from: a.i.b.a.c.l.c$b */
    static final class C31547b extends C25053k implements C31214a<C17318a> {
        final /* synthetic */ C37055c BJe;

        C31547b(C37055c c37055c) {
            this.BJe = c37055c;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(122488);
            C17318a c17318a = new C17318a(this.BJe.dYr());
            AppMethodBeat.m2505o(122488);
            return c17318a;
        }
    }

    /* renamed from: a.i.b.a.c.l.c$d */
    static final class C37056d extends C25053k implements C17126b<C17318a, C37091y> {
        final /* synthetic */ C37055c BJe;

        /* renamed from: a.i.b.a.c.l.c$d$a */
        static final class C8243a extends C25053k implements C17126b<C17313an, Collection<? extends C46867w>> {
            final /* synthetic */ C37056d BJg;

            C8243a(C37056d c37056d) {
                this.BJg = c37056d;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(122493);
                C17313an c17313an = (C17313an) obj;
                C25052j.m39376p(c17313an, "it");
                Collection a = C37055c.m62009a(c17313an, false);
                AppMethodBeat.m2505o(122493);
                return a;
            }
        }

        /* renamed from: a.i.b.a.c.l.c$d$b */
        static final class C31235b extends C25053k implements C17126b<C46867w, C37091y> {
            final /* synthetic */ C37056d BJg;

            C31235b(C37056d c37056d) {
                this.BJg = c37056d;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(122494);
                C46867w c46867w = (C46867w) obj;
                C25052j.m39376p(c46867w, "it");
                this.BJg.BJe.mo60J(c46867w);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(122494);
                return c37091y;
            }
        }

        /* renamed from: a.i.b.a.c.l.c$d$1 */
        static final class C370541 extends C25053k implements C17126b<C17313an, Collection<? extends C46867w>> {
            final /* synthetic */ C37056d BJg;

            C370541(C37056d c37056d) {
                this.BJg = c37056d;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(122491);
                C17313an c17313an = (C17313an) obj;
                C25052j.m39376p(c17313an, "it");
                Collection a = C37055c.m62009a(c17313an, true);
                AppMethodBeat.m2505o(122491);
                return a;
            }
        }

        /* renamed from: a.i.b.a.c.l.c$d$2 */
        static final class C370572 extends C25053k implements C17126b<C46867w, C37091y> {
            final /* synthetic */ C37056d BJg;

            C370572(C37056d c37056d) {
                this.BJg = c37056d;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(122492);
                C46867w c46867w = (C46867w) obj;
                C25052j.m39376p(c46867w, "it");
                C25052j.m39376p(c46867w, "type");
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(122492);
                return c37091y;
            }
        }

        C37056d(C37055c c37055c) {
            this.BJe = c37055c;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            Collection collection;
            AppMethodBeat.m2504i(122495);
            C17318a c17318a = (C17318a) obj;
            C25052j.m39376p(c17318a, "supertypes");
            Collection a = this.BJe.dYv().mo31255a(this.BJe, c17318a.BJd, new C8243a(this), new C31235b(this));
            if (a.isEmpty()) {
                List listOf;
                C46867w ear = this.BJe.ear();
                if (ear != null) {
                    listOf = C25033k.listOf(ear);
                } else {
                    listOf = null;
                }
                if (listOf == null) {
                    listOf = C17115v.AUP;
                }
                a = listOf;
            }
            this.BJe.dYv().mo31255a(this.BJe, a, new C370541(this), new C370572(this));
            if (a instanceof List) {
                collection = a;
            } else {
                collection = null;
            }
            Object obj2 = (List) collection;
            if (obj2 == null) {
                obj2 = C25035t.m39352m(a);
            }
            C25052j.m39376p(obj2, "<set-?>");
            c17318a.BJc = obj2;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(122495);
            return c37091y;
        }
    }

    public abstract Collection<C46867w> dYr();

    public abstract C17157ap dYv();

    public C37055c(C25212i c25212i) {
        C25052j.m39376p(c25212i, "storageManager");
        this.BJb = c25212i.mo31368a(new C31547b(this), C8242c.BJf, new C37056d(this));
    }

    /* renamed from: ekh */
    public final List<C46867w> eap() {
        return ((C17318a) this.BJb.invoke()).BJc;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: J */
    public void mo60J(C46867w c46867w) {
        C25052j.m39376p(c46867w, "type");
    }

    /* Access modifiers changed, original: protected */
    public C46867w ear() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: sb */
    public Collection<C46867w> mo59083sb(boolean z) {
        return C17115v.AUP;
    }

    /* renamed from: a */
    public static final /* synthetic */ Collection m62009a(C17313an c17313an, boolean z) {
        C17313an c17313an2;
        if (c17313an instanceof C37055c) {
            c17313an2 = c17313an;
        } else {
            c17313an2 = null;
        }
        C37055c c37055c = (C37055c) c17313an2;
        if (c37055c != null) {
            return C25035t.m39331b(((C17318a) c37055c.BJb.invoke()).BJd, (Iterable) c37055c.mo59083sb(z));
        }
        Collection eap = c17313an.eap();
        C25052j.m39375o(eap, "supertypes");
        return eap;
    }
}
