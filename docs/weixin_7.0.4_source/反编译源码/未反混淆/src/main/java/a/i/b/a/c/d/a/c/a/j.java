package a.i.b.a.c.d.a.c.a;

import a.a.v;
import a.a.x;
import a.f.b.k;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.d.a.c.h;
import a.i.b.a.c.d.a.e.aa;
import a.i.b.a.c.d.a.e.t;
import a.i.b.a.c.d.b.n;
import a.i.b.a.c.f.f;
import a.i.b.a.c.k.g;
import a.m;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public final class j extends m {
    private final t Bot;
    private final g<Set<String>> Bov;
    private final a.i.b.a.c.k.d<a, e> Bow;
    final h Box;

    static final class d extends k implements a.f.a.a<Set<? extends String>> {
        final /* synthetic */ h BlU;
        final /* synthetic */ j BoB;

        d(j jVar, h hVar) {
            this.BoB = jVar;
            this.BlU = hVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119974);
            Set b = this.BlU.Bnv.BmR.b(this.BoB.Box.BfP);
            AppMethodBeat.o(119974);
            return b;
        }
    }

    static final class a {
        final f BgZ;
        final a.i.b.a.c.d.a.e.g Boy;

        public a(f fVar, a.i.b.a.c.d.a.e.g gVar) {
            a.f.b.j.p(fVar, "name");
            AppMethodBeat.i(119969);
            this.BgZ = fVar;
            this.Boy = gVar;
            AppMethodBeat.o(119969);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(119967);
            if ((obj instanceof a) && a.f.b.j.j(this.BgZ, ((a) obj).BgZ)) {
                AppMethodBeat.o(119967);
                return true;
            }
            AppMethodBeat.o(119967);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(119968);
            int hashCode = this.BgZ.hashCode();
            AppMethodBeat.o(119968);
            return hashCode;
        }
    }

    static final class c extends k implements a.f.a.b<a, e> {
        final /* synthetic */ h BlU;
        final /* synthetic */ j BoB;

        c(j jVar, h hVar) {
            this.BoB = jVar;
            this.BlU = hVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            n a;
            a.i.b.a.c.f.a dWY;
            AppMethodBeat.i(119973);
            a aVar = (a) obj;
            a.f.b.j.p(aVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            a.i.b.a.c.f.a aVar2 = new a.i.b.a.c.f.a(this.BoB.Box.BfP, aVar.BgZ);
            if (aVar.Boy != null) {
                a = this.BlU.Bnv.BmS.a(aVar.Boy);
            } else {
                a = this.BlU.Bnv.BmS.b(aVar2);
            }
            if (a != null) {
                dWY = a.dWY();
            } else {
                dWY = null;
            }
            if (dWY == null || !(dWY.ehD() || dWY.ByO)) {
                b a2 = j.a(this.BoB, a);
                if (a2 instanceof a) {
                    Object obj2 = ((a) a2).Biz;
                    AppMethodBeat.o(119973);
                    return obj2;
                } else if (a2 instanceof c) {
                    AppMethodBeat.o(119973);
                    return null;
                } else if (a2 instanceof b) {
                    Object a3;
                    a.i.b.a.c.d.a.e.g gVar = aVar.Boy;
                    if (gVar == null) {
                        a3 = this.BlU.Bnv.BmR.a(aVar2);
                    } else {
                        a.i.b.a.c.d.a.e.g a32 = gVar;
                    }
                    if (aa.BINARY == null) {
                        Throwable illegalStateException = new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + a32 + 10 + "ClassId: " + aVar2 + 10 + "findKotlinClass(JavaClass) = " + this.BlU.Bnv.BmS.a(a32) + 10 + "findKotlinClass(ClassId) = " + this.BlU.Bnv.BmS.b(aVar2) + 10);
                        AppMethodBeat.o(119973);
                        throw illegalStateException;
                    }
                    a.i.b.a.c.f.b dZF;
                    Object obj3;
                    if (a32 != null) {
                        dZF = a32.dZF();
                    } else {
                        dZF = null;
                    }
                    if (dZF == null || dZF.ByQ.ByV.isEmpty() || (a.f.b.j.j(dZF.ehG(), this.BoB.Box.BfP) ^ 1) != 0) {
                        obj3 = null;
                    } else {
                        f fVar = new f(this.BlU, this.BoB.Box, a32);
                        this.BlU.Bnv.Bng.a(fVar);
                        f obj32 = fVar;
                    }
                    e eVar = (e) obj32;
                    AppMethodBeat.o(119973);
                    return eVar;
                } else {
                    m mVar = new m();
                    AppMethodBeat.o(119973);
                    throw mVar;
                }
            }
            AppMethodBeat.o(119973);
            return null;
        }
    }

    static abstract class b {

        public static final class a extends b {
            final e Biz;

            public a(e eVar) {
                a.f.b.j.p(eVar, "descriptor");
                super();
                AppMethodBeat.i(119970);
                this.Biz = eVar;
                AppMethodBeat.o(119970);
            }
        }

        public static final class b extends b {
            public static final b Boz = new b();

            static {
                AppMethodBeat.i(119971);
                AppMethodBeat.o(119971);
            }

            private b() {
                super();
            }
        }

        public static final class c extends b {
            public static final c BoA = new c();

            static {
                AppMethodBeat.i(119972);
                AppMethodBeat.o(119972);
            }

            private c() {
                super();
            }
        }

        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public j(h hVar, t tVar, h hVar2) {
        a.f.b.j.p(hVar, "c");
        a.f.b.j.p(tVar, "jPackage");
        a.f.b.j.p(hVar2, "ownerDescriptor");
        super(hVar);
        AppMethodBeat.i(119984);
        this.Bot = tVar;
        this.Box = hVar2;
        this.Bov = hVar.Bnv.Baf.j(new d(this, hVar));
        this.Bow = hVar.Bnv.Baf.g(new c(this, hVar));
        AppMethodBeat.o(119984);
    }

    public final e e(f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(119975);
        a.f.b.j.p(fVar, "name");
        a.f.b.j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        e a = a(fVar, null);
        AppMethodBeat.o(119975);
        return a;
    }

    /* Access modifiers changed, original: final */
    public final e a(f fVar, a.i.b.a.c.d.a.e.g gVar) {
        AppMethodBeat.i(119977);
        if (a.i.b.a.c.f.h.x(fVar)) {
            Set set = (Set) this.Bov.invoke();
            if (gVar != null || set == null || set.contains(fVar.name)) {
                e eVar = (e) this.Bow.am(new a(fVar, gVar));
                AppMethodBeat.o(119977);
                return eVar;
            }
            AppMethodBeat.o(119977);
            return null;
        }
        AppMethodBeat.o(119977);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final b ebt() {
        return a.i.b.a.c.d.a.c.a.b.a.BnM;
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<f> c(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(119979);
        a.f.b.j.p(dVar, "kindFilter");
        a.i.b.a.c.i.e.d.a aVar = a.i.b.a.c.i.e.d.BFX;
        if (dVar.UI(a.i.b.a.c.i.e.d.BFB)) {
            Set<String> set = (Set) this.Bov.invoke();
            Collection hashSet;
            Set<f> set2;
            if (set != null) {
                hashSet = new HashSet();
                for (String avX : set) {
                    hashSet.add(f.avX(avX));
                }
                set2 = (Set) hashSet;
                AppMethodBeat.o(119979);
                return set2;
            }
            t tVar = this.Bot;
            if (bVar == null) {
                a.f.a.b bVar2 = a.i.b.a.c.n.d.eku();
            }
            hashSet = new LinkedHashSet();
            for (a.i.b.a.c.d.a.e.g gVar : tVar.d(bVar2)) {
                Object obj;
                if (aa.SOURCE == null) {
                    obj = null;
                } else {
                    obj = gVar.dZg();
                }
                if (obj != null) {
                    hashSet.add(obj);
                }
            }
            set2 = (Set) hashSet;
            AppMethodBeat.o(119979);
            return set2;
        }
        Set<f> set3 = x.AUR;
        AppMethodBeat.o(119979);
        return set3;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Collection<al> collection, f fVar) {
        AppMethodBeat.i(119981);
        a.f.b.j.p(collection, "result");
        a.f.b.j.p(fVar, "name");
        AppMethodBeat.o(119981);
    }

    public final Collection<l> a(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(119983);
        a.f.b.j.p(dVar, "kindFilter");
        a.f.b.j.p(bVar, "nameFilter");
        Collection a = a(dVar, (a.f.a.b) bVar, (a.i.b.a.c.c.a.a) a.i.b.a.c.c.a.c.WHEN_GET_ALL_DESCRIPTORS);
        AppMethodBeat.o(119983);
        return a;
    }

    public final Collection<ah> a(f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(119978);
        a.f.b.j.p(fVar, "name");
        a.f.b.j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        Collection collection = v.AUP;
        AppMethodBeat.o(119978);
        return collection;
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<f> b(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(119980);
        a.f.b.j.p(dVar, "kindFilter");
        Set set = x.AUR;
        AppMethodBeat.o(119980);
        return set;
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<f> a(a.i.b.a.c.i.e.d dVar) {
        AppMethodBeat.i(119982);
        a.f.b.j.p(dVar, "kindFilter");
        Set set = x.AUR;
        AppMethodBeat.o(119982);
        return set;
    }

    public final /* bridge */ /* synthetic */ l ebu() {
        return this.Box;
    }
}
