package a.i.b.a.c.b.c;

import a.aa;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.aq;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.d;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.m;
import a.i.b.a.c.b.o;
import a.i.b.a.c.b.w;
import a.i.b.a.c.f.f;
import a.i.b.a.c.k.g;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.au;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag extends p implements af {
    public static final a Bjq = new a();
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(ag.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    final i Baf;
    private final g Bjn;
    private d Bjo;
    final aq Bjp;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        static au a(aq aqVar) {
            AppMethodBeat.i(119590);
            if (aqVar.dZR() == null) {
                AppMethodBeat.o(119590);
                return null;
            }
            au aw = au.aw(aqVar.dZQ());
            AppMethodBeat.o(119590);
            return aw;
        }
    }

    static final class b extends a.f.b.k implements a.f.a.a<ag> {
        final /* synthetic */ ag Bjr;
        final /* synthetic */ d Bjs;

        b(ag agVar, d dVar) {
            this.Bjr = agVar;
            this.Bjs = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119591);
            i iVar = this.Bjr.Baf;
            aq aqVar = this.Bjr.Bjp;
            d dVar = this.Bjs;
            af afVar = this.Bjr;
            a.i.b.a.c.b.a.g dYn = this.Bjs.dYn();
            a.i.b.a.c.b.b.a dYZ = this.Bjs.dYZ();
            j.o(dYZ, "underlyingConstructorDescriptor.kind");
            am dYo = this.Bjr.Bjp.dYo();
            j.o(dYo, "typeAliasDescriptor.source");
            ag agVar = new ag(iVar, aqVar, dVar, afVar, dYn, dYZ, dYo, (byte) 0);
            a aVar = ag.Bjq;
            au a = a.a(this.Bjr.Bjp);
            if (a == null) {
                AppMethodBeat.o(119591);
                return null;
            }
            ak dYR = this.Bjs.dYR();
            agVar.a(null, dYR != null ? dYR.e(a) : null, this.Bjr.Bjp.dYq(), this.Bjr.BhM, this.Bjr.dYT(), w.FINAL, this.Bjr.Bjp.dYf());
            AppMethodBeat.o(119591);
            return agVar;
        }
    }

    static {
        AppMethodBeat.i(119592);
        AppMethodBeat.o(119592);
    }

    private ag(i iVar, aq aqVar, d dVar, af afVar, a.i.b.a.c.b.a.g gVar, a.i.b.a.c.b.b.a aVar, am amVar) {
        super(aqVar, afVar, gVar, f.avZ("<init>"), aVar, amVar);
        AppMethodBeat.i(119608);
        this.Baf = iVar;
        this.Bjp = aqVar;
        this.BhW = this.Bjp.dYl();
        this.Bjn = this.Baf.j(new b(this, dVar));
        this.Bjo = dVar;
        AppMethodBeat.o(119608);
    }

    public /* synthetic */ ag(i iVar, aq aqVar, d dVar, af afVar, a.i.b.a.c.b.a.g gVar, a.i.b.a.c.b.b.a aVar, am amVar, byte b) {
        this(iVar, aqVar, dVar, afVar, gVar, aVar, amVar);
    }

    public final /* synthetic */ a.i.b.a.c.b.b a(l lVar, w wVar, az azVar, a.i.b.a.c.b.b.a aVar) {
        AppMethodBeat.i(119605);
        a.i.b.a.c.b.b d = d(lVar, wVar, azVar, aVar, false);
        AppMethodBeat.o(119605);
        return d;
    }

    public final /* synthetic */ p a(l lVar, a.i.b.a.c.b.t tVar, a.i.b.a.c.b.b.a aVar, f fVar, a.i.b.a.c.b.a.g gVar, am amVar) {
        Object obj = 1;
        AppMethodBeat.i(119607);
        j.p(lVar, "newOwner");
        j.p(aVar, "kind");
        j.p(gVar, "annotations");
        j.p(amVar, "source");
        Object obj2 = (aVar == a.i.b.a.c.b.b.a.DECLARATION || aVar == a.i.b.a.c.b.b.a.SYNTHESIZED) ? 1 : null;
        Throwable assertionError;
        if (aa.AUz && obj2 == null) {
            assertionError = new AssertionError("Creating a type alias constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + lVar + "\nkind: " + aVar);
            AppMethodBeat.o(119607);
            throw assertionError;
        }
        if (fVar != null) {
            obj = null;
        }
        if (aa.AUz && obj == null) {
            assertionError = new AssertionError("Renaming type alias constructor: ".concat(String.valueOf(this)));
            AppMethodBeat.o(119607);
            throw assertionError;
        }
        p agVar = new ag(this.Baf, this.Bjp, this.Bjo, this, gVar, a.i.b.a.c.b.b.a.DECLARATION, amVar);
        AppMethodBeat.o(119607);
        return agVar;
    }

    public final /* synthetic */ a.i.b.a.c.b.k b(au auVar) {
        AppMethodBeat.i(119603);
        a.i.b.a.c.b.k i = i(auVar);
        AppMethodBeat.o(119603);
        return i;
    }

    public final /* synthetic */ a.i.b.a.c.b.t b(l lVar, w wVar, az azVar, a.i.b.a.c.b.b.a aVar, boolean z) {
        AppMethodBeat.i(119606);
        a.i.b.a.c.b.t d = d(lVar, wVar, azVar, aVar, z);
        AppMethodBeat.o(119606);
        return d;
    }

    public final /* synthetic */ a.i.b.a.c.b.t c(au auVar) {
        AppMethodBeat.i(119602);
        a.i.b.a.c.b.t i = i(auVar);
        AppMethodBeat.o(119602);
        return i;
    }

    public final /* synthetic */ a.i.b.a.c.b.a dYU() {
        AppMethodBeat.i(119597);
        a.i.b.a.c.b.a eaM = eaM();
        AppMethodBeat.o(119597);
        return eaM;
    }

    public final /* synthetic */ a.i.b.a.c.b.b dYY() {
        AppMethodBeat.i(119598);
        a.i.b.a.c.b.b eaM = eaM();
        AppMethodBeat.o(119598);
        return eaM;
    }

    public final /* synthetic */ l dZd() {
        AppMethodBeat.i(119595);
        l eaM = eaM();
        AppMethodBeat.o(119595);
        return eaM;
    }

    public final /* synthetic */ a.i.b.a.c.b.t dZp() {
        AppMethodBeat.i(119599);
        a.i.b.a.c.b.t eaM = eaM();
        AppMethodBeat.o(119599);
        return eaM;
    }

    public final /* synthetic */ o ean() {
        AppMethodBeat.i(119596);
        o eaM = eaM();
        AppMethodBeat.o(119596);
        return eaM;
    }

    public final /* synthetic */ m f(au auVar) {
        AppMethodBeat.i(119601);
        m i = i(auVar);
        AppMethodBeat.o(119601);
        return i;
    }

    public final d eaL() {
        return this.Bjo;
    }

    public final a.i.b.a.c.l.w dYT() {
        AppMethodBeat.i(119593);
        a.i.b.a.c.l.w dYT = super.dYT();
        if (dYT == null) {
            j.dWJ();
        }
        AppMethodBeat.o(119593);
        return dYT;
    }

    private af eaM() {
        AppMethodBeat.i(119594);
        a.i.b.a.c.b.t dZp = super.ean();
        if (dZp == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
            AppMethodBeat.o(119594);
            throw vVar;
        }
        af afVar = (af) dZp;
        AppMethodBeat.o(119594);
        return afVar;
    }

    private af i(au auVar) {
        AppMethodBeat.i(119600);
        j.p(auVar, "substitutor");
        a.i.b.a.c.b.t c = super.f(auVar);
        if (c == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
            AppMethodBeat.o(119600);
            throw vVar;
        }
        ag agVar = (ag) c;
        au aw = au.aw(agVar.dYT());
        j.o(aw, "TypeSubstitutor.create(s…asConstructor.returnType)");
        d a = this.Bjo.dZj().a(aw);
        if (a == null) {
            AppMethodBeat.o(119600);
            return null;
        }
        agVar.Bjo = a;
        af afVar = agVar;
        AppMethodBeat.o(119600);
        return afVar;
    }

    private af d(l lVar, w wVar, az azVar, a.i.b.a.c.b.b.a aVar, boolean z) {
        AppMethodBeat.i(119604);
        j.p(lVar, "newOwner");
        j.p(wVar, "modality");
        j.p(azVar, "visibility");
        j.p(aVar, "kind");
        a.i.b.a.c.b.t dZC = dZw().g(lVar).a(wVar).a(azVar).a(aVar).rG(z).dZC();
        if (dZC == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
            AppMethodBeat.o(119604);
            throw vVar;
        }
        af afVar = (af) dZC;
        AppMethodBeat.o(119604);
        return afVar;
    }

    public final /* bridge */ /* synthetic */ l dXW() {
        return this.Bjp;
    }

    public final /* bridge */ /* synthetic */ a.i.b.a.c.b.i dZo() {
        return this.Bjp;
    }
}
