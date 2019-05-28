package a.i.b.a.c.d.a.c.a;

import a.a.ag;
import a.a.m;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.c.x;
import a.i.b.a.c.b.e;
import a.i.b.a.c.d.b.n;
import a.i.b.a.c.d.b.o;
import a.i.b.a.c.d.b.s;
import a.i.b.a.c.k.f;
import a.i.k;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class h extends x {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), v.a(new t(v.aN(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    private final g Bfn;
    private final a.i.b.a.c.d.a.c.h Bnn;
    private final f Bop = this.Bnn.Bnv.Baf.i(new a(this));
    private final d Boq = new d(this.Bnn, this.Bot, this);
    public final f<List<a.i.b.a.c.f.b>> Bor = this.Bnn.Bnv.Baf.a(new c(this), a.a.v.AUP);
    private final f Bos;
    private final a.i.b.a.c.d.a.e.t Bot;

    static final class b extends a.f.b.k implements a.f.a.a<HashMap<a.i.b.a.c.i.d.b, a.i.b.a.c.i.d.b>> {
        final /* synthetic */ h Bou;

        b(h hVar) {
            this.Bou = hVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119959);
            HashMap hashMap = new HashMap();
            for (Entry entry : this.Bou.ebv().entrySet()) {
                String str = (String) entry.getKey();
                n nVar = (n) entry.getValue();
                a.i.b.a.c.i.d.b awj = a.i.b.a.c.i.d.b.awj(str);
                j.o(awj, "JvmClassName.byInternalName(partInternalName)");
                a.i.b.a.c.d.b.a.a dXA = nVar.dXA();
                switch (i.eQZ[dXA.Bsc.ordinal()]) {
                    case 1:
                        Map map = hashMap;
                        String ecv = dXA.ecv();
                        if (ecv == null) {
                            break;
                        }
                        a.i.b.a.c.i.d.b awj2 = a.i.b.a.c.i.d.b.awj(ecv);
                        j.o(awj2, "JvmClassName.byInternalN…: continue@kotlinClasses)");
                        map.put(awj, awj2);
                        break;
                    case 2:
                        hashMap.put(awj, awj);
                        break;
                    default:
                        break;
                }
            }
            AppMethodBeat.o(119959);
            return hashMap;
        }
    }

    static final class a extends a.f.b.k implements a.f.a.a<Map<String, ? extends n>> {
        final /* synthetic */ h Bou;

        a(h hVar) {
            this.Bou = hVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119958);
            s sVar = this.Bou.Bnn.Bnv.Bnb;
            String str = this.Bou.BfP.ByQ.ByV;
            j.o(str, "fqName.asString()");
            Iterable<String> avA = sVar.avA(str);
            Collection arrayList = new ArrayList();
            for (String str2 : avA) {
                Object I;
                a.i.b.a.c.i.d.b awj = a.i.b.a.c.i.d.b.awj(str2);
                j.o(awj, "JvmClassName.byInternalName(partName)");
                a.i.b.a.c.f.a n = a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b(awj.BrD.replace(IOUtils.DIR_SEPARATOR_UNIX, '.')));
                j.o(n, "ClassId.topLevel(JvmClas…velClassMaybeWithDollars)");
                n b = this.Bou.Bnn.Bnv.BmS.b(n);
                if (b != null) {
                    I = u.I(str2, b);
                } else {
                    I = null;
                }
                if (I != null) {
                    arrayList.add(I);
                }
            }
            Map v = ag.v((List) arrayList);
            AppMethodBeat.o(119958);
            return v;
        }
    }

    static final class c extends a.f.b.k implements a.f.a.a<List<? extends a.i.b.a.c.f.b>> {
        final /* synthetic */ h Bou;

        c(h hVar) {
            this.Bou = hVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119960);
            Iterable<a.i.b.a.c.d.a.e.t> ebZ = this.Bou.Bot.ebZ();
            Collection arrayList = new ArrayList(m.d(ebZ));
            for (a.i.b.a.c.d.a.e.t dZF : ebZ) {
                arrayList.add(dZF.dZF());
            }
            List list = (List) arrayList;
            AppMethodBeat.o(119960);
            return list;
        }
    }

    static {
        AppMethodBeat.i(119961);
        AppMethodBeat.o(119961);
    }

    public final Map<String, n> ebv() {
        AppMethodBeat.i(119962);
        Map map = (Map) a.i.b.a.c.k.h.a(this.Bop, eQB[0]);
        AppMethodBeat.o(119962);
        return map;
    }

    public final g dYn() {
        return this.Bfn;
    }

    public final e c(a.i.b.a.c.d.a.e.g gVar) {
        AppMethodBeat.i(119963);
        j.p(gVar, "jClass");
        j jVar = this.Boq.BnN;
        j.p(gVar, "javaClass");
        e a = jVar.a(gVar.dZg(), gVar);
        AppMethodBeat.o(119963);
        return a;
    }

    public final String toString() {
        AppMethodBeat.i(119964);
        String str = "Lazy Java package fragment: " + this.BfP;
        AppMethodBeat.o(119964);
        return str;
    }

    public final am dYo() {
        AppMethodBeat.i(119965);
        am oVar = new o(this);
        AppMethodBeat.o(119965);
        return oVar;
    }

    public final /* bridge */ /* synthetic */ a.i.b.a.c.i.e.h dXR() {
        return this.Boq;
    }

    public h(a.i.b.a.c.d.a.c.h hVar, a.i.b.a.c.d.a.e.t tVar) {
        g eai;
        j.p(hVar, "outerContext");
        j.p(tVar, "jPackage");
        super(hVar.Bnv.BcH, tVar.dZF());
        AppMethodBeat.i(119966);
        this.Bot = tVar;
        this.Bnn = a.i.b.a.c.d.a.c.a.a(hVar, (a.i.b.a.c.b.g) this, null, 6);
        if (this.Bnn.Bnv.Bne.Bke) {
            a.i.b.a.c.b.a.g.a aVar = g.BfJ;
            eai = a.i.b.a.c.b.a.g.a.eai();
        } else {
            eai = a.i.b.a.c.d.a.c.f.a(this.Bnn, this.Bot);
        }
        this.Bfn = eai;
        this.Bos = this.Bnn.Bnv.Baf.i(new b(this));
        AppMethodBeat.o(119966);
    }
}
