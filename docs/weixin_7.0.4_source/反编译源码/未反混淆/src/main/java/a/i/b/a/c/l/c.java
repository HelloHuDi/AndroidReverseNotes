package a.i.b.a.c.l;

import a.a.t;
import a.a.v;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ap;
import a.i.b.a.c.k.f;
import a.i.b.a.c.k.i;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public abstract class c implements an {
    private final f<a> BJb;

    static final class c extends k implements a.f.a.b<Boolean, a> {
        public static final c BJf = new c();

        static {
            AppMethodBeat.i(122490);
            AppMethodBeat.o(122490);
        }

        c() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122489);
            ((Boolean) obj).booleanValue();
            a aVar = new a(a.a.k.listOf(p.BJp));
            AppMethodBeat.o(122489);
            return aVar;
        }
    }

    static final class a {
        List<? extends w> BJc = a.a.k.listOf(p.BJp);
        final Collection<w> BJd;

        public a(Collection<? extends w> collection) {
            j.p(collection, "allSupertypes");
            AppMethodBeat.i(122487);
            this.BJd = collection;
            AppMethodBeat.o(122487);
        }
    }

    static final class b extends k implements a.f.a.a<a> {
        final /* synthetic */ c BJe;

        b(c cVar) {
            this.BJe = cVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(122488);
            a aVar = new a(this.BJe.dYr());
            AppMethodBeat.o(122488);
            return aVar;
        }
    }

    static final class d extends k implements a.f.a.b<a, y> {
        final /* synthetic */ c BJe;

        static final class a extends k implements a.f.a.b<an, Collection<? extends w>> {
            final /* synthetic */ d BJg;

            a(d dVar) {
                this.BJg = dVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(122493);
                an anVar = (an) obj;
                j.p(anVar, "it");
                Collection a = c.a(anVar, false);
                AppMethodBeat.o(122493);
                return a;
            }
        }

        static final class b extends k implements a.f.a.b<w, y> {
            final /* synthetic */ d BJg;

            b(d dVar) {
                this.BJg = dVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(122494);
                w wVar = (w) obj;
                j.p(wVar, "it");
                this.BJg.BJe.J(wVar);
                y yVar = y.AUy;
                AppMethodBeat.o(122494);
                return yVar;
            }
        }

        /* renamed from: a.i.b.a.c.l.c$d$1 */
        static final class AnonymousClass1 extends k implements a.f.a.b<an, Collection<? extends w>> {
            final /* synthetic */ d BJg;

            AnonymousClass1(d dVar) {
                this.BJg = dVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(122491);
                an anVar = (an) obj;
                j.p(anVar, "it");
                Collection a = c.a(anVar, true);
                AppMethodBeat.o(122491);
                return a;
            }
        }

        /* renamed from: a.i.b.a.c.l.c$d$2 */
        static final class AnonymousClass2 extends k implements a.f.a.b<w, y> {
            final /* synthetic */ d BJg;

            AnonymousClass2(d dVar) {
                this.BJg = dVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(122492);
                w wVar = (w) obj;
                j.p(wVar, "it");
                j.p(wVar, "type");
                y yVar = y.AUy;
                AppMethodBeat.o(122492);
                return yVar;
            }
        }

        d(c cVar) {
            this.BJe = cVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            Collection collection;
            AppMethodBeat.i(122495);
            a aVar = (a) obj;
            j.p(aVar, "supertypes");
            Collection a = this.BJe.dYv().a(this.BJe, aVar.BJd, new a(this), new b(this));
            if (a.isEmpty()) {
                List listOf;
                w ear = this.BJe.ear();
                if (ear != null) {
                    listOf = a.a.k.listOf(ear);
                } else {
                    listOf = null;
                }
                if (listOf == null) {
                    listOf = v.AUP;
                }
                a = listOf;
            }
            this.BJe.dYv().a(this.BJe, a, new AnonymousClass1(this), new AnonymousClass2(this));
            if (a instanceof List) {
                collection = a;
            } else {
                collection = null;
            }
            Object obj2 = (List) collection;
            if (obj2 == null) {
                obj2 = t.m(a);
            }
            j.p(obj2, "<set-?>");
            aVar.BJc = obj2;
            y yVar = y.AUy;
            AppMethodBeat.o(122495);
            return yVar;
        }
    }

    public abstract Collection<w> dYr();

    public abstract ap dYv();

    public c(i iVar) {
        j.p(iVar, "storageManager");
        this.BJb = iVar.a(new b(this), c.BJf, new d(this));
    }

    /* renamed from: ekh */
    public final List<w> eap() {
        return ((a) this.BJb.invoke()).BJc;
    }

    /* Access modifiers changed, original: protected */
    public void J(w wVar) {
        j.p(wVar, "type");
    }

    /* Access modifiers changed, original: protected */
    public w ear() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public Collection<w> sb(boolean z) {
        return v.AUP;
    }

    public static final /* synthetic */ Collection a(an anVar, boolean z) {
        an anVar2;
        if (anVar instanceof c) {
            anVar2 = anVar;
        } else {
            anVar2 = null;
        }
        c cVar = (c) anVar2;
        if (cVar != null) {
            return t.b(((a) cVar.BJb.invoke()).BJd, (Iterable) cVar.sb(z));
        }
        Collection eap = anVar.eap();
        j.o(eap, "supertypes");
        return eap;
    }
}
