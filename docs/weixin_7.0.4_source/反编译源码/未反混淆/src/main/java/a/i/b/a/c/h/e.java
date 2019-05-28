package a.i.b.a.c.h;

import a.a.m;
import a.aa;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.af;
import a.i.b.a.c.b.ag;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.aq;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.as;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.aw;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.n;
import a.i.b.a.c.i.b.o;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ay;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.bb;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.q;
import a.i.b.a.c.l.w;
import a.i.k;
import a.k.u;
import a.k.x;
import a.y;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e extends c implements i {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(e.class), "functionTypeAnnotationsRenderer", "getFunctionTypeAnnotationsRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRendererImpl;")), v.a(new t(v.aN(e.class), "functionTypeParameterTypesRenderer", "getFunctionTypeParameterTypesRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer;"))};
    private final a.f BCa;
    private final a.f BCb;
    final j BCc;

    final class a implements n<y, StringBuilder> {
        private final void a(ag agVar, StringBuilder stringBuilder, String str) {
            AppMethodBeat.i(121737);
            switch (f.eQZ[e.this.BCc.eji().ordinal()]) {
                case 1:
                    e.a(e.this, agVar, stringBuilder);
                    stringBuilder.append(str + " for ");
                    e eVar = e.this;
                    ah dZH = agVar.dZH();
                    j.o(dZH, "descriptor.correspondingProperty");
                    e.a(eVar, dZH, stringBuilder);
                    AppMethodBeat.o(121737);
                    return;
                case 2:
                    b(agVar, stringBuilder);
                    break;
            }
            AppMethodBeat.o(121737);
        }

        private void b(a.i.b.a.c.b.t tVar, StringBuilder stringBuilder) {
            AppMethodBeat.i(121738);
            j.p(tVar, "descriptor");
            j.p(stringBuilder, "builder");
            e.a(e.this, tVar, stringBuilder);
            AppMethodBeat.o(121738);
        }
    }

    static final class b extends a.f.b.k implements a.f.a.b<ap, CharSequence> {
        final /* synthetic */ e BCd;

        b(e eVar) {
            this.BCd = eVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            String str;
            AppMethodBeat.i(121749);
            ap apVar = (ap) obj;
            j.p(apVar, "it");
            if (apVar.ekp()) {
                str = "*";
            } else {
                e eVar = this.BCd;
                w dZS = apVar.dZS();
                j.o(dZS, "it.type");
                str = eVar.b(dZS);
                if (apVar.ekq() != ba.INVARIANT) {
                    str = apVar.ekq() + ' ' + str;
                }
            }
            CharSequence charSequence = str;
            AppMethodBeat.o(121749);
            return charSequence;
        }
    }

    static final class c extends a.f.b.k implements a.f.a.a<e> {
        final /* synthetic */ e BCd;

        c(e eVar) {
            this.BCd = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(121752);
            e eVar = (e) this.BCd.e(AnonymousClass1.BCg);
            AppMethodBeat.o(121752);
            return eVar;
        }
    }

    static final class d extends a.f.b.k implements a.f.a.a<c> {
        final /* synthetic */ e BCd;

        d(e eVar) {
            this.BCd = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(121755);
            c e = this.BCd.e(AnonymousClass1.BCh);
            AppMethodBeat.o(121755);
            return e;
        }
    }

    static final class e extends a.f.b.k implements a.f.a.b<a.i.b.a.c.i.b.f<?>, String> {
        final /* synthetic */ e BCd;

        e(e eVar) {
            this.BCd = eVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(121756);
            a.i.b.a.c.i.b.f fVar = (a.i.b.a.c.i.b.f) obj;
            j.p(fVar, "it");
            String a = e.a(this.BCd, fVar);
            AppMethodBeat.o(121756);
            return a;
        }
    }

    static final class f extends a.f.b.k implements a.f.a.b<w, String> {
        final /* synthetic */ e BCd;

        f(e eVar) {
            this.BCd = eVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(121757);
            w wVar = (w) obj;
            e eVar = this.BCd;
            j.o(wVar, "it");
            String b = eVar.b(wVar);
            AppMethodBeat.o(121757);
            return b;
        }
    }

    static {
        AppMethodBeat.i(121758);
        AppMethodBeat.o(121758);
    }

    private final e eiO() {
        AppMethodBeat.i(121759);
        e eVar = (e) this.BCa.getValue();
        AppMethodBeat.o(121759);
        return eVar;
    }

    private final c eiP() {
        AppMethodBeat.i(121760);
        c cVar = (c) this.BCb.getValue();
        AppMethodBeat.o(121760);
        return cVar;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(121819);
        j.p(aVar, "<set-?>");
        this.BCc.a(aVar);
        AppMethodBeat.o(121819);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(121820);
        j.p(bVar, "<set-?>");
        this.BCc.a(bVar);
        AppMethodBeat.o(121820);
    }

    public final void a(n nVar) {
        AppMethodBeat.i(121827);
        j.p(nVar, "<set-?>");
        this.BCc.a(nVar);
        AppMethodBeat.o(121827);
    }

    public final void a(p pVar) {
        AppMethodBeat.i(121831);
        j.p(pVar, "<set-?>");
        this.BCc.a(pVar);
        AppMethodBeat.o(121831);
    }

    public final a eiR() {
        AppMethodBeat.i(121818);
        a eiR = this.BCc.eiR();
        AppMethodBeat.o(121818);
        return eiR;
    }

    public final boolean eiS() {
        AppMethodBeat.i(139063);
        boolean eiS = this.BCc.eiS();
        AppMethodBeat.o(139063);
        return eiS;
    }

    public final boolean eiT() {
        AppMethodBeat.i(121823);
        boolean eiT = this.BCc.eiT();
        AppMethodBeat.o(121823);
        return eiT;
    }

    public final Set<a.i.b.a.c.f.b> eiU() {
        AppMethodBeat.i(139064);
        Set eiU = this.BCc.eiU();
        AppMethodBeat.o(139064);
        return eiU;
    }

    public final void fN(boolean z) {
        AppMethodBeat.i(121822);
        this.BCc.fN(z);
        AppMethodBeat.o(121822);
    }

    public final void m(Set<a.i.b.a.c.f.b> set) {
        AppMethodBeat.i(121825);
        j.p(set, "<set-?>");
        this.BCc.m(set);
        AppMethodBeat.o(121825);
    }

    public final void n(Set<? extends h> set) {
        AppMethodBeat.i(121826);
        j.p(set, "<set-?>");
        this.BCc.n(set);
        AppMethodBeat.o(121826);
    }

    public final void rR(boolean z) {
        AppMethodBeat.i(121828);
        this.BCc.rR(z);
        AppMethodBeat.o(121828);
    }

    public final void rS(boolean z) {
        AppMethodBeat.i(121829);
        this.BCc.rS(z);
        AppMethodBeat.o(121829);
    }

    public final void rT(boolean z) {
        AppMethodBeat.i(121830);
        this.BCc.rT(z);
        AppMethodBeat.o(121830);
    }

    public final void rU(boolean z) {
        AppMethodBeat.i(121832);
        this.BCc.rU(z);
        AppMethodBeat.o(121832);
    }

    public final void rV(boolean z) {
        AppMethodBeat.i(121833);
        this.BCc.rV(z);
        AppMethodBeat.o(121833);
    }

    public final void rW(boolean z) {
        AppMethodBeat.i(121834);
        this.BCc.rW(z);
        AppMethodBeat.o(121834);
    }

    public final void rX(boolean z) {
        AppMethodBeat.i(121835);
        this.BCc.rX(z);
        AppMethodBeat.o(121835);
    }

    public e(j jVar) {
        j.p(jVar, "options");
        AppMethodBeat.i(121817);
        this.BCc = jVar;
        boolean z = this.BCc.aCf;
        if (!aa.AUz || z) {
            this.BCa = i.g(new c(this));
            this.BCb = i.g(new d(this));
            AppMethodBeat.o(121817);
            return;
        }
        Throwable assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.o(121817);
        throw assertionError;
    }

    public final String b(a.i.b.a.c.f.f fVar, boolean z) {
        AppMethodBeat.i(121765);
        j.p(fVar, "name");
        String escape = escape(q.y(fVar));
        if (this.BCc.ejp() && this.BCc.ejh() == p.BDH && z) {
            escape = "<b>" + escape + "</b>";
            AppMethodBeat.o(121765);
            return escape;
        }
        AppMethodBeat.o(121765);
        return escape;
    }

    private final void a(l lVar, StringBuilder stringBuilder, boolean z) {
        AppMethodBeat.i(121766);
        a.i.b.a.c.f.f dZg = lVar.dZg();
        j.o(dZg, "descriptor.name");
        stringBuilder.append(b(dZg, z));
        AppMethodBeat.o(121766);
    }

    public final String f(a.i.b.a.c.f.c cVar) {
        AppMethodBeat.i(121767);
        j.p(cVar, "fqName");
        List ehM = cVar.ehM();
        j.o(ehM, "fqName.pathSegments()");
        String escape = escape(q.fZ(ehM));
        AppMethodBeat.o(121767);
        return escape;
    }

    private String b(h hVar) {
        AppMethodBeat.i(121768);
        j.p(hVar, "klass");
        String obj;
        if (p.L(hVar)) {
            obj = hVar.dXY().toString();
            AppMethodBeat.o(121768);
            return obj;
        }
        obj = this.BCc.eiV().a(hVar, this);
        AppMethodBeat.o(121768);
        return obj;
    }

    public final String b(w wVar) {
        AppMethodBeat.i(121769);
        j.p(wVar, "type");
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder, (w) ((a.f.a.b) this.BCc.BCP.b(j.eQB[18])).am(wVar));
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(121769);
        return stringBuilder2;
    }

    private final void b(StringBuilder stringBuilder, w wVar) {
        AppMethodBeat.i(121770);
        az ekn = wVar.ekn();
        if (!(ekn instanceof a.i.b.a.c.l.a)) {
            ekn = null;
        }
        a.i.b.a.c.l.a aVar = (a.i.b.a.c.l.a) ekn;
        if (aVar != null) {
            c(stringBuilder, (w) aVar.BJa);
            if (this.BCc.ejl()) {
                a(stringBuilder, aVar);
            }
            AppMethodBeat.o(121770);
            return;
        }
        c(stringBuilder, wVar);
        AppMethodBeat.o(121770);
    }

    private final void c(StringBuilder stringBuilder, w wVar) {
        AppMethodBeat.i(121772);
        if ((wVar instanceof bb) && this.BCc.eiS() && !((bb) wVar).ekf()) {
            stringBuilder.append("<Not computed yet>");
            AppMethodBeat.o(121772);
            return;
        }
        az ekn = wVar.ekn();
        if (ekn instanceof q) {
            stringBuilder.append(((q) ekn).a(this, this));
            AppMethodBeat.o(121772);
            return;
        }
        if (ekn instanceof ad) {
            a(stringBuilder, (ad) ekn);
        }
        AppMethodBeat.o(121772);
    }

    private final void a(StringBuilder stringBuilder, ad adVar) {
        AppMethodBeat.i(121773);
        if (j.j(adVar, av.BKd) || av.ay(adVar)) {
            stringBuilder.append("???");
            AppMethodBeat.o(121773);
        } else if (p.ah(adVar)) {
            if (this.BCc.eja()) {
                an ejw = adVar.ejw();
                if (ejw == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor");
                    AppMethodBeat.o(121773);
                    throw vVar;
                }
                ar arVar = ((a.i.b.a.c.l.p.d) ejw).BJv;
                j.o(arVar, "(type.constructor as Uni…).typeParameterDescriptor");
                String fVar = arVar.dZg().toString();
                j.o(fVar, "(type.constructor as Uni…escriptor.name.toString()");
                stringBuilder.append(awf(fVar));
                AppMethodBeat.o(121773);
                return;
            }
            stringBuilder.append("???");
            AppMethodBeat.o(121773);
        } else if (a.i.b.a.c.l.y.an(adVar)) {
            d(stringBuilder, adVar);
            AppMethodBeat.o(121773);
        } else if (W(adVar)) {
            e(stringBuilder, adVar);
            AppMethodBeat.o(121773);
        } else {
            d(stringBuilder, adVar);
            AppMethodBeat.o(121773);
        }
    }

    private static boolean W(w wVar) {
        AppMethodBeat.i(121774);
        if (a.i.b.a.c.a.f.f(wVar)) {
            Object obj;
            Iterable<ap> ejt = wVar.ejt();
            if (!((ejt instanceof Collection) && ((Collection) ejt).isEmpty())) {
                for (ap ekp : ejt) {
                    if (ekp.ekp()) {
                        obj = null;
                        break;
                    }
                }
            }
            int obj2 = 1;
            if (obj2 != null) {
                AppMethodBeat.o(121774);
                return true;
            }
        }
        AppMethodBeat.o(121774);
        return false;
    }

    public final String a(String str, String str2, g gVar) {
        AppMethodBeat.i(121775);
        j.p(str, "lowerRendered");
        j.p(str2, "upperRendered");
        j.p(gVar, "builtIns");
        String str3;
        if (!iZ(str, str2)) {
            b eiV = this.BCc.eiV();
            a.i.b.a.c.b.e a = g.a(a.i.b.a.c.f.f.avX("Collection"), ((a.i.b.a.c.a.g.b) gVar.Bad.invoke()).BbK);
            j.o(a, "builtIns.collection");
            String je = a.k.v.je(eiV.a(a, this), "Collection");
            str3 = "Mutable";
            str3 = h(str, je + str3, str2, je, je + '(' + str3 + ')');
            if (str3 != null) {
                AppMethodBeat.o(121775);
                return str3;
            }
            str3 = h(str, je + "MutableMap.MutableEntry", str2, je + "Map.Entry", je + "(Mutable)Map.(Mutable)Entry");
            if (str3 != null) {
                AppMethodBeat.o(121775);
                return str3;
            }
            eiV = this.BCc.eiV();
            a = gVar.avB("Array");
            j.o(a, "builtIns.array");
            str3 = a.k.v.je(eiV.a(a, this), "Array");
            str3 = h(str, str3 + escape("Array<"), str2, str3 + escape("Array<out "), str3 + escape("Array<(out) "));
            if (str3 != null) {
                AppMethodBeat.o(121775);
                return str3;
            }
            str3 = "(" + str + ".." + str2 + ')';
            AppMethodBeat.o(121775);
            return str3;
        } else if (u.jb(str2, "(")) {
            str3 = "(" + str + ")!";
            AppMethodBeat.o(121775);
            return str3;
        } else {
            str3 = str + "!";
            AppMethodBeat.o(121775);
            return str3;
        }
    }

    private String fY(List<? extends ap> list) {
        AppMethodBeat.i(121776);
        j.p(list, "typeArguments");
        String str;
        if (list.isEmpty()) {
            str = "";
            AppMethodBeat.o(121776);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(escape("<"));
        a(stringBuilder, (List) list);
        stringBuilder.append(escape(">"));
        str = stringBuilder.toString();
        j.o(str, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(121776);
        return str;
    }

    private final void d(StringBuilder stringBuilder, w wVar) {
        AppMethodBeat.i(121777);
        a(stringBuilder, (a.i.b.a.c.b.a.a) wVar, null);
        if (a.i.b.a.c.l.y.an(wVar)) {
            if ((wVar instanceof ay) && this.BCc.ejo()) {
                stringBuilder.append(((ay) wVar).BKg);
            } else {
                stringBuilder.append(wVar.ejw().toString());
            }
            stringBuilder.append(fY(wVar.ejt()));
        } else {
            a(this, stringBuilder, wVar);
        }
        if (wVar.eci()) {
            stringBuilder.append("?");
        }
        if (a.i.b.a.c.l.ag.ap(wVar)) {
            stringBuilder.append("!!");
        }
        AppMethodBeat.o(121777);
    }

    private final void a(StringBuilder stringBuilder, w wVar, an anVar) {
        AppMethodBeat.i(121778);
        j.p(wVar, "receiver$0");
        h dYs = wVar.ejw().dYs();
        if (!(dYs instanceof a.i.b.a.c.b.i)) {
            dYs = null;
        }
        af a = as.a(wVar, (a.i.b.a.c.b.i) dYs, 0);
        if (a == null) {
            stringBuilder.append(a(anVar));
            stringBuilder.append(fY(wVar.ejt()));
            AppMethodBeat.o(121778);
            return;
        }
        a(stringBuilder, a);
        AppMethodBeat.o(121778);
    }

    private String a(an anVar) {
        AppMethodBeat.i(121781);
        j.p(anVar, "typeConstructor");
        h dYs = anVar.dYs();
        String b;
        if ((dYs instanceof ar) || (dYs instanceof a.i.b.a.c.b.e) || (dYs instanceof aq)) {
            b = b(dYs);
            AppMethodBeat.o(121781);
            return b;
        } else if (dYs == null) {
            b = anVar.toString();
            AppMethodBeat.o(121781);
            return b;
        } else {
            Throwable illegalStateException = new IllegalStateException(("Unexpected classifier: " + dYs.getClass()).toString());
            AppMethodBeat.o(121781);
            throw illegalStateException;
        }
    }

    public final String a(ap apVar) {
        AppMethodBeat.i(121782);
        j.p(apVar, "typeProjection");
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder, a.a.k.listOf(apVar));
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(121782);
        return stringBuilder2;
    }

    private final void a(StringBuilder stringBuilder, List<? extends ap> list) {
        AppMethodBeat.i(121783);
        a.a.t.a(list, stringBuilder, ", ", null, null, 0, null, new b(this), 60);
        AppMethodBeat.o(121783);
    }

    private final void e(StringBuilder stringBuilder, w wVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(121784);
        int length = stringBuilder.length();
        eiO().a(stringBuilder, (a.i.b.a.c.b.a.a) wVar, null);
        boolean z3 = stringBuilder.length() != length;
        boolean e = a.i.b.a.c.a.f.e(wVar);
        boolean eci = wVar.eci();
        w h = a.i.b.a.c.a.f.h(wVar);
        if (eci || (z3 && h != null)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (e) {
                stringBuilder.insert(length, '(');
            } else {
                if (z3) {
                    z3 = x.av((CharSequence) stringBuilder) == ' ';
                    if (aa.AUz && !z3) {
                        Throwable assertionError = new AssertionError("Assertion failed");
                        AppMethodBeat.o(121784);
                        throw assertionError;
                    } else if (stringBuilder.charAt(a.k.v.at(stringBuilder) - 1) != ')') {
                        stringBuilder.insert(a.k.v.at(stringBuilder), "()");
                    }
                }
                stringBuilder.append("(");
            }
        }
        a(stringBuilder, e, "suspend");
        if (h != null) {
            if ((!W(h) || h.eci()) && !X(h)) {
                z2 = false;
            }
            if (z2) {
                stringBuilder.append("(");
            }
            b(stringBuilder, h);
            if (z2) {
                stringBuilder.append(")");
            }
            stringBuilder.append(".");
        }
        stringBuilder.append("(");
        int i = 0;
        for (ap apVar : a.i.b.a.c.a.f.j(wVar)) {
            a.i.b.a.c.f.f k;
            if (i > 0) {
                stringBuilder.append(", ");
            }
            if (this.BCc.ejn()) {
                w dZS = apVar.dZS();
                j.o(dZS, "typeProjection.type");
                k = a.i.b.a.c.a.f.k(dZS);
            } else {
                k = null;
            }
            if (k != null) {
                stringBuilder.append(b(k, false));
                stringBuilder.append(": ");
            }
            stringBuilder.append(eiP().a(apVar));
            i++;
        }
        stringBuilder.append(") ").append(eiQ()).append(" ");
        b(stringBuilder, a.i.b.a.c.a.f.i(wVar));
        if (z) {
            stringBuilder.append(")");
        }
        if (eci) {
            stringBuilder.append("?");
        }
        AppMethodBeat.o(121784);
    }

    private static boolean X(w wVar) {
        AppMethodBeat.i(121785);
        if (a.i.b.a.c.a.f.e(wVar) || !wVar.dYn().isEmpty()) {
            AppMethodBeat.o(121785);
            return true;
        }
        AppMethodBeat.o(121785);
        return false;
    }

    /* JADX WARNING: Missing block: B:10:0x005c, code skipped:
            if (r0 != 0) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String a(a.i.b.a.c.b.a.c cVar, a.i.b.a.c.b.a.e eVar) {
        AppMethodBeat.i(121788);
        j.p(cVar, "annotation");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('@');
        if (eVar != null) {
            stringBuilder.append(eVar.BfB + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        }
        w dZS = cVar.dZS();
        stringBuilder.append(b(dZS));
        if (a.i.b.a.c.h.i.a.a(this.BCc)) {
            List k = k(cVar);
            if (!a.i.b.a.c.h.i.a.b(this.BCc)) {
                int i;
                if (k.isEmpty()) {
                    i = 0;
                } else {
                    i = 1;
                }
            }
            a.a.t.a(k, stringBuilder, ", ", "(", ")", 0, null, null, 112);
        }
        if (this.BCc.eiZ() && (a.i.b.a.c.l.y.an(dZS) || (dZS.ejw().dYs() instanceof a.i.b.a.c.b.aa.b))) {
            stringBuilder.append(" /* annotation class not found */");
        }
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(121788);
        return stringBuilder2;
    }

    private final List<String> k(a.i.b.a.c.b.a.c cVar) {
        a.i.b.a.c.b.e l;
        List dYV;
        Collection arrayList;
        List list = null;
        AppMethodBeat.i(121789);
        Map eah = cVar.eah();
        if (((Boolean) this.BCc.BCZ.b(j.eQB[28])).booleanValue()) {
            l = a.i.b.a.c.i.c.a.l(cVar);
        } else {
            l = null;
        }
        if (l != null) {
            a.i.b.a.c.b.d dYe = l.dYe();
            if (dYe != null) {
                dYV = dYe.dYV();
                if (dYV != null) {
                    Collection arrayList2 = new ArrayList();
                    for (Object next : dYV) {
                        if (((au) next).dZU()) {
                            arrayList2.add(next);
                        }
                    }
                    Iterable<au> iterable = (List) arrayList2;
                    arrayList = new ArrayList(m.d(iterable));
                    for (au auVar : iterable) {
                        j.o(auVar, "it");
                        arrayList.add(auVar.dZg());
                    }
                    list = (List) arrayList;
                }
            }
        }
        if (list == null) {
            list = a.a.v.AUP;
        }
        Collection arrayList3 = new ArrayList();
        for (Object next2 : list) {
            if ((!eah.containsKey((a.i.b.a.c.f.f) next2) ? 1 : 0) != 0) {
                arrayList3.add(next2);
            }
        }
        Iterable<a.i.b.a.c.f.f> iterable2 = (List) arrayList3;
        arrayList = new ArrayList(m.d(iterable2));
        for (a.i.b.a.c.f.f fVar : iterable2) {
            arrayList.add(fVar.name + " = ...");
        }
        dYV = (List) arrayList;
        Iterable<Entry> entrySet = eah.entrySet();
        Collection arrayList4 = new ArrayList(m.d(entrySet));
        for (Entry entry : entrySet) {
            a.i.b.a.c.f.f fVar2 = (a.i.b.a.c.f.f) entry.getKey();
            arrayList4.add(fVar2.name + " = " + (!list.contains(fVar2) ? b((a.i.b.a.c.i.b.f) entry.getValue()) : "..."));
        }
        Iterable b = a.a.t.b((Collection) dYV, (Iterable) (List) arrayList4);
        j.p(b, "receiver$0");
        if (((Collection) b).size() <= 1) {
            dYV = a.a.t.m(b);
            AppMethodBeat.o(121789);
            return dYV;
        }
        Object[] toArray = ((Collection) b).toArray(new Comparable[0]);
        a.v vVar;
        if (toArray == null) {
            vVar = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(121789);
            throw vVar;
        } else if (toArray == null) {
            vVar = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(121789);
            throw vVar;
        } else {
            Comparable[] comparableArr = (Comparable[]) toArray;
            if (comparableArr == null) {
                vVar = new a.v("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                AppMethodBeat.o(121789);
                throw vVar;
            }
            Object[] objArr = (Object[]) comparableArr;
            j.p(objArr, "receiver$0");
            if (objArr.length > 1) {
                Arrays.sort(objArr);
            }
            List<String> asList = a.a.h.asList((Object[]) comparableArr);
            AppMethodBeat.o(121789);
            return asList;
        }
    }

    private final String b(a.i.b.a.c.i.b.f<?> fVar) {
        AppMethodBeat.i(121790);
        String a;
        if (fVar instanceof a.i.b.a.c.i.b.b) {
            a = a.a.t.a((Iterable) ((a.i.b.a.c.i.b.b) fVar).getValue(), (CharSequence) ", ", (CharSequence) "{", (CharSequence) "}", 0, null, (a.f.a.b) new e(this), 24);
            AppMethodBeat.o(121790);
            return a;
        } else if (fVar instanceof a.i.b.a.c.i.b.a) {
            a = a.k.v.b(a((a.i.b.a.c.b.a.c) ((a.i.b.a.c.i.b.a) fVar).getValue(), null), (CharSequence) "@");
            AppMethodBeat.o(121790);
            return a;
        } else if (fVar instanceof o) {
            a = b(((o) fVar).ejy()) + "::class";
            AppMethodBeat.o(121790);
            return a;
        } else {
            a = fVar.toString();
            AppMethodBeat.o(121790);
            return a;
        }
    }

    private final void a(a.i.b.a.c.b.b bVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121793);
        if (!(a.i.b.a.c.i.d.r(bVar) && bVar.dYd() == a.i.b.a.c.b.w.FINAL)) {
            if (this.BCc.ejf() == m.RENDER_OVERRIDE && bVar.dYd() == a.i.b.a.c.b.w.OPEN && t(bVar)) {
                AppMethodBeat.o(121793);
                return;
            }
            a.i.b.a.c.b.w dYd = bVar.dYd();
            j.o(dYd, "callable.modality");
            a(dYd, stringBuilder);
        }
        AppMethodBeat.o(121793);
    }

    private final void a(StringBuilder stringBuilder, boolean z, String str) {
        AppMethodBeat.i(121796);
        if (z) {
            stringBuilder.append(awe(str));
            stringBuilder.append(" ");
        }
        AppMethodBeat.o(121796);
    }

    private final void a(a.i.b.a.c.b.v vVar, StringBuilder stringBuilder) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(121797);
        a(stringBuilder, vVar.dYm(), "external");
        if (this.BCc.eiW().contains(h.EXPECT) && vVar.dYk()) {
            z = true;
        } else {
            z = false;
        }
        a(stringBuilder, z, "expect");
        if (!(this.BCc.eiW().contains(h.ACTUAL) && vVar.dYl())) {
            z2 = false;
        }
        a(stringBuilder, z2, "actual");
        AppMethodBeat.o(121797);
    }

    private final void a(a.i.b.a.c.b.t tVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121798);
        a(stringBuilder, tVar.dZv(), "suspend");
        AppMethodBeat.o(121798);
    }

    public final String k(l lVar) {
        String str;
        AppMethodBeat.i(121799);
        j.p(lVar, "declarationDescriptor");
        StringBuilder stringBuilder = new StringBuilder();
        lVar.a(new a(), stringBuilder);
        if (!(!((Boolean) this.BCc.BCy.b(j.eQB[1])).booleanValue() || (lVar instanceof ab) || (lVar instanceof a.i.b.a.c.b.ad))) {
            if (lVar instanceof a.i.b.a.c.b.y) {
                stringBuilder.append(" is a module");
            } else {
                l dXW = lVar.dXW();
                if (!(dXW == null || (dXW instanceof a.i.b.a.c.b.y))) {
                    StringBuilder append = stringBuilder.append(" ");
                    str = "defined in";
                    j.p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    switch (g.BCe[this.BCc.ejh().ordinal()]) {
                        case 1:
                            break;
                        case 2:
                            str = "<i>" + str + "</i>";
                            break;
                        default:
                            a.m mVar = new a.m();
                            AppMethodBeat.o(121799);
                            throw mVar;
                    }
                    append.append(str).append(" ");
                    a.i.b.a.c.f.c n = a.i.b.a.c.i.d.n(dXW);
                    j.o(n, "DescriptorUtils.getFqName(containingDeclaration)");
                    if (n.ByV.isEmpty()) {
                        str = "root package";
                    } else {
                        str = f(n);
                    }
                    stringBuilder.append(str);
                    if (((Boolean) this.BCc.BCz.b(j.eQB[2])).booleanValue() && (dXW instanceof ab) && (lVar instanceof a.i.b.a.c.b.o)) {
                        am dYo = ((a.i.b.a.c.b.o) lVar).dYo();
                        j.o(dYo, "descriptor.source");
                        j.o(dYo.dXz(), "descriptor.source.containingFile");
                    }
                }
            }
        }
        str = stringBuilder.toString();
        j.o(str, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(121799);
        return str;
    }

    private final void a(ar arVar, StringBuilder stringBuilder, boolean z) {
        AppMethodBeat.i(121800);
        if (z) {
            stringBuilder.append(escape("<"));
        }
        if (this.BCc.eiZ()) {
            stringBuilder.append("/*").append(arVar.getIndex()).append("*/ ");
        }
        a(stringBuilder, arVar.dZi(), "reified");
        String str = arVar.dZh().label;
        a(stringBuilder, ((CharSequence) str).length() > 0, str);
        a(stringBuilder, (a.i.b.a.c.b.a.a) arVar, null);
        a((l) arVar, stringBuilder, z);
        int size = arVar.dWP().size();
        w wVar;
        if ((size > 1 && !z) || size == 1) {
            wVar = (w) arVar.dWP().iterator().next();
            if (!g.C(wVar)) {
                StringBuilder append = stringBuilder.append(" : ");
                j.o(wVar, "upperBound");
                append.append(b(wVar));
            }
        } else if (z) {
            Object obj = 1;
            for (w wVar2 : arVar.dWP()) {
                Object obj2;
                if (g.C(wVar2)) {
                    obj2 = obj;
                } else {
                    if (obj != null) {
                        stringBuilder.append(" : ");
                    } else {
                        stringBuilder.append(" & ");
                    }
                    j.o(wVar2, "upperBound");
                    stringBuilder.append(b(wVar2));
                    obj2 = null;
                }
                obj = obj2;
            }
        }
        if (z) {
            stringBuilder.append(escape(">"));
        }
        AppMethodBeat.o(121800);
    }

    private final void b(StringBuilder stringBuilder, List<? extends ar> list) {
        AppMethodBeat.i(121802);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a((ar) it.next(), stringBuilder, false);
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        AppMethodBeat.o(121802);
    }

    private final void b(a.i.b.a.c.b.a aVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121804);
        ak dYQ = aVar.dYQ();
        if (dYQ != null) {
            a(stringBuilder, (a.i.b.a.c.b.a.a) dYQ, a.i.b.a.c.b.a.e.RECEIVER);
            w dZS = dYQ.dZS();
            j.o(dZS, "receiver.type");
            String b = b(dZS);
            if (W(dZS) && !av.aB(dZS)) {
                b = "(" + b + ')';
            }
            stringBuilder.append(b).append(".");
        }
        AppMethodBeat.o(121804);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(au auVar, boolean z, StringBuilder stringBuilder, boolean z2) {
        Object obj;
        AppMethodBeat.i(121807);
        if (z2) {
            stringBuilder.append(awe("value-parameter")).append(" ");
        }
        if (this.BCc.eiZ()) {
            stringBuilder.append("/*").append(auVar.getIndex()).append("*/ ");
        }
        a(stringBuilder, (a.i.b.a.c.b.a.a) auVar, null);
        a(stringBuilder, auVar.dZX(), "crossinline");
        a(stringBuilder, auVar.dZY(), "noinline");
        a((aw) auVar, z, stringBuilder, z2);
        if (this.BCc.ejd() != null) {
            if (this.BCc.eiS() ? auVar.dZU() : a.i.b.a.c.i.c.a.b(auVar)) {
                obj = 1;
                if (obj != null) {
                    StringBuilder stringBuilder2 = new StringBuilder(" = ");
                    a.f.a.b ejd = this.BCc.ejd();
                    if (ejd == null) {
                        j.dWJ();
                    }
                    stringBuilder.append(stringBuilder2.append((String) ejd.am(auVar)).toString());
                }
                AppMethodBeat.o(121807);
            }
        }
        obj = null;
        if (obj != null) {
        }
        AppMethodBeat.o(121807);
    }

    private final void a(aw awVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121808);
        if (!(awVar instanceof au)) {
            stringBuilder.append(awe(awVar.dZZ() ? "var" : "val")).append(" ");
        }
        AppMethodBeat.o(121808);
    }

    private final void a(aw awVar, boolean z, StringBuilder stringBuilder, boolean z2) {
        aw awVar2;
        w wVar;
        AppMethodBeat.i(121809);
        w dZS = awVar.dZS();
        j.o(dZS, "variable.type");
        if (awVar instanceof au) {
            awVar2 = awVar;
        } else {
            awVar2 = null;
        }
        au auVar = (au) awVar2;
        w dZV = auVar != null ? auVar.dZV() : null;
        if (dZV == null) {
            wVar = dZS;
        } else {
            wVar = dZV;
        }
        a(stringBuilder, dZV != null, "vararg");
        if (z2 && !this.BCc.eiX()) {
            a(awVar, stringBuilder);
        }
        if (z) {
            a((l) awVar, stringBuilder, z2);
            stringBuilder.append(": ");
        }
        stringBuilder.append(b(wVar));
        b(awVar, stringBuilder);
        if (this.BCc.eiZ() && dZV != null) {
            stringBuilder.append(" /*").append(b(dZS)).append("*/");
        }
        AppMethodBeat.o(121809);
    }

    private final void a(a.i.b.a.c.b.i iVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121811);
        List dYq = iVar.dYq();
        j.o(dYq, "classifier.declaredTypeParameters");
        an dXY = iVar.dXY();
        j.o(dXY, "classifier.typeConstructor");
        List parameters = dXY.getParameters();
        j.o(parameters, "classifier.typeConstructor.parameters");
        if (this.BCc.eiZ() && iVar.dYh() && parameters.size() > dYq.size()) {
            stringBuilder.append(" /*captured type parameters: ");
            b(stringBuilder, parameters.subList(dYq.size(), parameters.size()));
            stringBuilder.append("*/");
        }
        AppMethodBeat.o(121811);
    }

    private final void a(a.i.b.a.c.f.b bVar, String str, StringBuilder stringBuilder) {
        AppMethodBeat.i(121812);
        stringBuilder.append(awe(str));
        a.i.b.a.c.f.c cVar = bVar.ByQ;
        j.o(cVar, "fqName.toUnsafe()");
        String f = f(cVar);
        if ((((CharSequence) f).length() > 0 ? 1 : null) != null) {
            stringBuilder.append(" ");
            stringBuilder.append(f);
        }
        AppMethodBeat.o(121812);
    }

    private static void g(StringBuilder stringBuilder) {
        AppMethodBeat.i(121813);
        int length = stringBuilder.length();
        if (length == 0 || stringBuilder.charAt(length - 1) != ' ') {
            stringBuilder.append(' ');
        }
        AppMethodBeat.o(121813);
    }

    private static boolean iZ(String str, String str2) {
        AppMethodBeat.i(121815);
        if (j.j(str, u.i(str2, "?", "", false)) || ((u.jc(str2, "?") && j.j(str + '?', str2)) || j.j("(" + str + ")?", str2))) {
            AppMethodBeat.o(121815);
            return true;
        }
        AppMethodBeat.o(121815);
        return false;
    }

    private static boolean t(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(121816);
        if (bVar.dYX().isEmpty()) {
            AppMethodBeat.o(121816);
            return false;
        }
        AppMethodBeat.o(121816);
        return true;
    }

    private final String awe(String str) {
        AppMethodBeat.i(121761);
        switch (g.eQZ[this.BCc.ejh().ordinal()]) {
            case 1:
                AppMethodBeat.o(121761);
                return str;
            case 2:
                if (this.BCc.ejp()) {
                    AppMethodBeat.o(121761);
                    return str;
                }
                str = "<b>" + str + "</b>";
                AppMethodBeat.o(121761);
                return str;
            default:
                a.m mVar = new a.m();
                AppMethodBeat.o(121761);
                throw mVar;
        }
    }

    private final String awf(String str) {
        AppMethodBeat.i(121762);
        switch (g.pCY[this.BCc.ejh().ordinal()]) {
            case 1:
                AppMethodBeat.o(121762);
                return str;
            case 2:
                str = "<font color=red><b>" + str + "</b></font>";
                AppMethodBeat.o(121762);
                return str;
            default:
                a.m mVar = new a.m();
                AppMethodBeat.o(121762);
                throw mVar;
        }
    }

    private final String escape(String str) {
        AppMethodBeat.i(121763);
        String escape = this.BCc.ejh().escape(str);
        AppMethodBeat.o(121763);
        return escape;
    }

    private final String eiQ() {
        AppMethodBeat.i(121764);
        String escape;
        switch (g.pEv[this.BCc.ejh().ordinal()]) {
            case 1:
                escape = escape("->");
                AppMethodBeat.o(121764);
                return escape;
            case 2:
                escape = "&rarr;";
                AppMethodBeat.o(121764);
                return escape;
            default:
                a.m mVar = new a.m();
                AppMethodBeat.o(121764);
                throw mVar;
        }
    }

    private final void a(StringBuilder stringBuilder, a.i.b.a.c.l.a aVar) {
        AppMethodBeat.i(121771);
        if (this.BCc.ejh() == p.BDH) {
            stringBuilder.append("<font color=\"808080\"><i>");
        }
        stringBuilder.append(" /* = ");
        c(stringBuilder, (w) aVar.BpK);
        stringBuilder.append(" */");
        if (this.BCc.ejh() == p.BDH) {
            stringBuilder.append("</i></font>");
        }
        AppMethodBeat.o(121771);
    }

    /* JADX WARNING: Missing block: B:3:0x0027, code skipped:
            if (r4.append(b(r0, false)) == null) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(StringBuilder stringBuilder, af afVar) {
        AppMethodBeat.i(121780);
        af afVar2 = afVar.BeQ;
        if (afVar2 != null) {
            a(stringBuilder, afVar2);
            stringBuilder.append('.');
            a.i.b.a.c.f.f dZg = afVar.BeO.dZg();
            j.o(dZg, "possiblyInnerType.classifierDescriptor.name");
        }
        an dXY = afVar.BeO.dXY();
        j.o(dXY, "possiblyInnerType.classi…escriptor.typeConstructor");
        stringBuilder.append(a(dXY));
        stringBuilder.append(fY(afVar.BeP));
        AppMethodBeat.o(121780);
    }

    private final void a(StringBuilder stringBuilder, a.i.b.a.c.b.a.a aVar, a.i.b.a.c.b.a.e eVar) {
        AppMethodBeat.i(121786);
        if (this.BCc.eiW().contains(h.ANNOTATIONS)) {
            Set eiU;
            if (aVar instanceof w) {
                eiU = this.BCc.eiU();
            } else {
                eiU = (Set) this.BCc.BDb.b(j.eQB[30]);
            }
            a.f.a.b bVar = (a.f.a.b) this.BCc.BDd.b(j.eQB[32]);
            for (a.i.b.a.c.b.a.c cVar : aVar.dYn()) {
                if (!a.a.t.a((Iterable) eiU, (Object) cVar.dZF()) && (bVar == null || ((Boolean) bVar.am(cVar)).booleanValue())) {
                    stringBuilder.append(a(cVar, eVar));
                    if (((Boolean) this.BCc.BDa.b(j.eQB[29])).booleanValue()) {
                        a.k.q.i(stringBuilder);
                    } else {
                        stringBuilder.append(" ");
                    }
                }
            }
            AppMethodBeat.o(121786);
            return;
        }
        AppMethodBeat.o(121786);
    }

    private final void a(a.i.b.a.c.b.az azVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121791);
        if (this.BCc.eiW().contains(h.VISIBILITY)) {
            Object azVar2;
            if (((Boolean) this.BCc.BCJ.b(j.eQB[12])).booleanValue()) {
                azVar2 = azVar2.eag();
            }
            if (((Boolean) this.BCc.BCK.b(j.eQB[13])).booleanValue() || !j.j(azVar2, a.i.b.a.c.b.ay.Bfh)) {
                stringBuilder.append(awe(azVar2.getDisplayName())).append(" ");
                AppMethodBeat.o(121791);
                return;
            }
            AppMethodBeat.o(121791);
            return;
        }
        AppMethodBeat.o(121791);
    }

    private final void a(a.i.b.a.c.b.w wVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121792);
        boolean contains = this.BCc.eiW().contains(h.MODALITY);
        String name = wVar.name();
        if (name == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(121792);
            throw vVar;
        }
        name = name.toLowerCase();
        j.o(name, "(this as java.lang.String).toLowerCase()");
        a(stringBuilder, contains, name);
        AppMethodBeat.o(121792);
    }

    private final void b(a.i.b.a.c.b.b bVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121794);
        if (this.BCc.eiW().contains(h.OVERRIDE)) {
            if (t(bVar) && this.BCc.ejf() != m.RENDER_OPEN) {
                a(stringBuilder, true, "override");
                if (this.BCc.eiZ()) {
                    stringBuilder.append("/*").append(bVar.dYX().size()).append("*/ ");
                }
            }
            AppMethodBeat.o(121794);
            return;
        }
        AppMethodBeat.o(121794);
    }

    private final void c(a.i.b.a.c.b.b bVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121795);
        if (this.BCc.eiW().contains(h.MEMBER_KIND)) {
            if (this.BCc.eiZ() && bVar.dYZ() != a.i.b.a.c.b.b.a.DECLARATION) {
                StringBuilder append = stringBuilder.append("/*");
                String name = bVar.dYZ().name();
                if (name == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(121795);
                    throw vVar;
                }
                name = name.toLowerCase();
                j.o(name, "(this as java.lang.String).toLowerCase()");
                append.append(name).append("*/ ");
            }
            AppMethodBeat.o(121795);
            return;
        }
        AppMethodBeat.o(121795);
    }

    private final void a(List<? extends ar> list, StringBuilder stringBuilder, boolean z) {
        AppMethodBeat.i(121801);
        if (this.BCc.ejc()) {
            AppMethodBeat.o(121801);
            return;
        }
        if (!list.isEmpty()) {
            stringBuilder.append(escape("<"));
            b(stringBuilder, (List) list);
            stringBuilder.append(escape(">"));
            if (z) {
                stringBuilder.append(" ");
            }
        }
        AppMethodBeat.o(121801);
    }

    private final void a(a.i.b.a.c.b.a aVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121803);
        if (((Boolean) this.BCc.BCW.b(j.eQB[25])).booleanValue()) {
            ak dYQ = aVar.dYQ();
            if (dYQ != null) {
                StringBuilder append = stringBuilder.append(" on ");
                w dZS = dYQ.dZS();
                j.o(dZS, "receiver.type");
                append.append(b(dZS));
            }
            AppMethodBeat.o(121803);
            return;
        }
        AppMethodBeat.o(121803);
    }

    private final void a(List<? extends ar> list, StringBuilder stringBuilder) {
        AppMethodBeat.i(121805);
        if (this.BCc.ejc()) {
            AppMethodBeat.o(121805);
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (ar arVar : list) {
            List dWP = arVar.dWP();
            j.o(dWP, "typeParameter.upperBounds");
            for (w wVar : a.a.t.j(dWP)) {
                Collection collection = arrayList;
                StringBuilder stringBuilder2 = new StringBuilder();
                a.i.b.a.c.f.f dZg = arVar.dZg();
                j.o(dZg, "typeParameter.name");
                stringBuilder2 = stringBuilder2.append(b(dZg, false)).append(" : ");
                j.o(wVar, "it");
                collection.add(stringBuilder2.append(b(wVar)).toString());
            }
        }
        if (!arrayList.isEmpty()) {
            stringBuilder.append(" ").append(awe("where")).append(" ");
            a.a.t.a(arrayList, stringBuilder, ", ", null, null, 0, null, null, 124);
        }
        AppMethodBeat.o(121805);
    }

    private final void a(Collection<? extends au> collection, boolean z, StringBuilder stringBuilder) {
        boolean z2 = true;
        AppMethodBeat.i(121806);
        switch (g.BCf[((n) this.BCc.BCV.b(j.eQB[24])).ordinal()]) {
            case 1:
                break;
            case 2:
                if (z) {
                    z2 = false;
                    break;
                }
                break;
            case 3:
                z2 = false;
                break;
            default:
                a.m mVar = new a.m();
                AppMethodBeat.o(121806);
                throw mVar;
        }
        int size = collection.size();
        this.BCc.ejg().e(stringBuilder);
        int i = 0;
        for (au auVar : collection) {
            this.BCc.ejg().a(auVar, stringBuilder);
            a(auVar, z2, stringBuilder, false);
            this.BCc.ejg().a(auVar, i, size, stringBuilder);
            i++;
        }
        this.BCc.ejg().f(stringBuilder);
        AppMethodBeat.o(121806);
    }

    private final void b(aw awVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(121810);
        if (this.BCc.ejb()) {
            a.i.b.a.c.i.b.f eaa = awVar.eaa();
            if (eaa != null) {
                StringBuilder append = stringBuilder.append(" = ");
                j.o(eaa, "constant");
                append.append(escape(b(eaa)));
                AppMethodBeat.o(121810);
                return;
            }
        }
        AppMethodBeat.o(121810);
    }

    private static String h(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(121814);
        if (u.jb(str, str2) && u.jb(str3, str4)) {
            int length = str2.length();
            a.v vVar;
            if (str == null) {
                vVar = new a.v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(121814);
                throw vVar;
            }
            String substring = str.substring(length);
            j.o(substring, "(this as java.lang.String).substring(startIndex)");
            length = str4.length();
            if (str3 == null) {
                vVar = new a.v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(121814);
                throw vVar;
            }
            String substring2 = str3.substring(length);
            j.o(substring2, "(this as java.lang.String).substring(startIndex)");
            String str6 = str5 + substring;
            if (j.j(substring, substring2)) {
                AppMethodBeat.o(121814);
                return str6;
            } else if (iZ(substring, substring2)) {
                str6 = str6 + "!";
                AppMethodBeat.o(121814);
                return str6;
            }
        }
        AppMethodBeat.o(121814);
        return null;
    }
}
