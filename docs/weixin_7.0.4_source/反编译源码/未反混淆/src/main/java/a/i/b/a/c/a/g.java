package a.i.b.a.c.a;

import a.a.al;
import a.a.t;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ac;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.c.m;
import a.i.b.a.c.b.c.v;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.q;
import a.i.b.a.c.b.s;
import a.i.b.a.c.b.y;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.d;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.ar;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class g {
    static final /* synthetic */ boolean $assertionsDisabled = (!g.class.desiredAssertionStatus());
    public static final f AZU;
    public static final a.i.b.a.c.f.b AZV;
    private static final a.i.b.a.c.f.b AZW;
    public static final a.i.b.a.c.f.b AZX = AZV.q(f.avX("collections"));
    public static final a.i.b.a.c.f.b AZY = AZV.q(f.avX("ranges"));
    public static final a.i.b.a.c.f.b AZZ = AZV.q(f.avX("text"));
    public static final Set<a.i.b.a.c.f.b> Baa = al.setOf(AZV, AZX, AZY, AZW, j.dXT(), AZV.q(f.avX("internal")), d.BDS);
    public static final a Bag = new a();
    public static final f Bah = f.avZ("<built-ins module>");
    public v Bab;
    private final a.i.b.a.c.k.f<c> Bac;
    public final a.i.b.a.c.k.f<b> Bad;
    private final a.i.b.a.c.k.c<f, e> Bae;
    protected final i Baf;

    public static class a {
        public final a.i.b.a.c.f.c BaA = avC("Float").ByQ;
        public final a.i.b.a.c.f.c BaB = avC("Double").ByQ;
        public final a.i.b.a.c.f.c BaC = avC("Number").ByQ;
        public final a.i.b.a.c.f.c BaD = avC("Enum").ByQ;
        public final a.i.b.a.c.f.c BaE = avC("Function").ByQ;
        public final a.i.b.a.c.f.b BaF = avC("Throwable");
        public final a.i.b.a.c.f.b BaG = avC("Comparable");
        public final a.i.b.a.c.f.c BaH = avE("CharRange");
        public final a.i.b.a.c.f.c BaI = avE("IntRange");
        public final a.i.b.a.c.f.c BaJ = avE("LongRange");
        public final a.i.b.a.c.f.b BaK = avC("Deprecated");
        public final a.i.b.a.c.f.b BaL = avC("DeprecationLevel");
        public final a.i.b.a.c.f.b BaM = avC("ReplaceWith");
        public final a.i.b.a.c.f.b BaN = avC("ExtensionFunctionType");
        public final a.i.b.a.c.f.b BaO = avC("ParameterName");
        public final a.i.b.a.c.f.b BaP = avC("Annotation");
        public final a.i.b.a.c.f.b BaQ = avG("Target");
        public final a.i.b.a.c.f.b BaR = avG("AnnotationTarget");
        public final a.i.b.a.c.f.b BaS = avG("AnnotationRetention");
        public final a.i.b.a.c.f.b BaT = avG("Retention");
        public final a.i.b.a.c.f.b BaU = avG("Repeatable");
        public final a.i.b.a.c.f.b BaV = avG("MustBeDocumented");
        public final a.i.b.a.c.f.b BaW = avC("UnsafeVariance");
        public final a.i.b.a.c.f.b BaX = avC("PublishedApi");
        public final a.i.b.a.c.f.b BaY = avD("Iterator");
        public final a.i.b.a.c.f.b BaZ = avD("Iterable");
        public final a.i.b.a.c.f.c Bam = avC("Any").ByQ;
        public final a.i.b.a.c.f.c Ban = avC("Nothing").ByQ;
        public final a.i.b.a.c.f.c Bao = avC("Cloneable").ByQ;
        public final a.i.b.a.c.f.b Bap = avC("Suppress");
        public final a.i.b.a.c.f.c Baq = avC("Unit").ByQ;
        public final a.i.b.a.c.f.c Bar = avC("CharSequence").ByQ;
        public final a.i.b.a.c.f.c Bas = avC("String").ByQ;
        public final a.i.b.a.c.f.c Bat = avC("Array").ByQ;
        public final a.i.b.a.c.f.c Bau = avC("Boolean").ByQ;
        public final a.i.b.a.c.f.c Bav = avC("Char").ByQ;
        public final a.i.b.a.c.f.c Baw = avC("Byte").ByQ;
        public final a.i.b.a.c.f.c Bax = avC("Short").ByQ;
        public final a.i.b.a.c.f.c Bay = avC("Int").ByQ;
        public final a.i.b.a.c.f.c Baz = avC("Long").ByQ;
        public final a.i.b.a.c.f.b BbA = avC("ULong");
        public final a.i.b.a.c.f.a BbB = a.i.b.a.c.f.a.n(this.Bbx);
        public final a.i.b.a.c.f.a BbC = a.i.b.a.c.f.a.n(this.Bby);
        public final a.i.b.a.c.f.a BbD = a.i.b.a.c.f.a.n(this.Bbz);
        public final a.i.b.a.c.f.a BbE = a.i.b.a.c.f.a.n(this.BbA);
        public final Set<f> BbF = a.i.b.a.c.n.a.UQ(h.values().length);
        public final Set<f> BbG = a.i.b.a.c.n.a.UQ(h.values().length);
        public final Map<a.i.b.a.c.f.c, h> BbH = a.i.b.a.c.n.a.UP(h.values().length);
        public final Map<a.i.b.a.c.f.c, h> BbI = a.i.b.a.c.n.a.UP(h.values().length);
        public final a.i.b.a.c.f.b Bba = avD("Collection");
        public final a.i.b.a.c.f.b Bbb = avD("List");
        public final a.i.b.a.c.f.b Bbc = avD("ListIterator");
        public final a.i.b.a.c.f.b Bbd = avD("Set");
        public final a.i.b.a.c.f.b Bbe = avD("Map");
        public final a.i.b.a.c.f.b Bbf = this.Bbe.q(f.avX("Entry"));
        public final a.i.b.a.c.f.b Bbg = avD("MutableIterator");
        public final a.i.b.a.c.f.b Bbh = avD("MutableIterable");
        public final a.i.b.a.c.f.b Bbi = avD("MutableCollection");
        public final a.i.b.a.c.f.b Bbj = avD("MutableList");
        public final a.i.b.a.c.f.b Bbk = avD("MutableListIterator");
        public final a.i.b.a.c.f.b Bbl = avD("MutableSet");
        public final a.i.b.a.c.f.b Bbm = avD("MutableMap");
        public final a.i.b.a.c.f.b Bbn = this.Bbm.q(f.avX("MutableEntry"));
        public final a.i.b.a.c.f.c Bbo = avF("KClass");
        public final a.i.b.a.c.f.c Bbp = avF("KCallable");
        public final a.i.b.a.c.f.c Bbq = avF("KProperty0");
        public final a.i.b.a.c.f.c Bbr = avF("KProperty1");
        public final a.i.b.a.c.f.c Bbs = avF("KProperty2");
        public final a.i.b.a.c.f.c Bbt = avF("KMutableProperty0");
        public final a.i.b.a.c.f.c Bbu = avF("KMutableProperty1");
        public final a.i.b.a.c.f.c Bbv = avF("KMutableProperty2");
        public final a.i.b.a.c.f.a Bbw = a.i.b.a.c.f.a.n(avF("KProperty").ehI());
        public final a.i.b.a.c.f.b Bbx = avC("UByte");
        public final a.i.b.a.c.f.b Bby = avC("UShort");
        public final a.i.b.a.c.f.b Bbz = avC("UInt");

        public a() {
            AppMethodBeat.i(119097);
            for (h hVar : h.values()) {
                this.BbF.add(hVar.BbZ);
                this.BbG.add(hVar.Bca);
                this.BbH.put(avC(hVar.BbZ.name).ByQ, hVar);
                this.BbI.put(avC(hVar.Bca.name).ByQ, hVar);
            }
            AppMethodBeat.o(119097);
        }

        private static a.i.b.a.c.f.b avC(String str) {
            AppMethodBeat.i(119098);
            a.i.b.a.c.f.b q = g.AZV.q(f.avX(str));
            AppMethodBeat.o(119098);
            return q;
        }

        private static a.i.b.a.c.f.b avD(String str) {
            AppMethodBeat.i(119099);
            a.i.b.a.c.f.b q = g.AZX.q(f.avX(str));
            AppMethodBeat.o(119099);
            return q;
        }

        private static a.i.b.a.c.f.c avE(String str) {
            AppMethodBeat.i(119100);
            a.i.b.a.c.f.c cVar = g.AZY.q(f.avX(str)).ByQ;
            AppMethodBeat.o(119100);
            return cVar;
        }

        private static a.i.b.a.c.f.c avF(String str) {
            AppMethodBeat.i(119101);
            a.i.b.a.c.f.c cVar = j.dXT().q(f.avX(str)).ByQ;
            AppMethodBeat.o(119101);
            return cVar;
        }

        private static a.i.b.a.c.f.b avG(String str) {
            AppMethodBeat.i(119102);
            a.i.b.a.c.f.b q = g.AZW.q(f.avX(str));
            AppMethodBeat.o(119102);
            return q;
        }
    }

    static class c {
        public final Map<h, ad> BbN;
        public final Map<w, ad> BbO;
        public final Map<ad, ad> BbP;

        /* synthetic */ c(Map map, Map map2, Map map3, byte b) {
            this(map, map2, map3);
        }

        private c(Map<h, ad> map, Map<w, ad> map2, Map<ad, ad> map3) {
            this.BbN = map;
            this.BbO = map2;
            this.BbP = map3;
        }
    }

    public static class b {
        public final ab BbJ;
        public final ab BbK;
        public final ab BbL;
        public final Set<ab> BbM;

        /* synthetic */ b(ab abVar, ab abVar2, ab abVar3, Set set, byte b) {
            this(abVar, abVar2, abVar3, set);
        }

        private b(ab abVar, ab abVar2, ab abVar3, Set<ab> set) {
            this.BbJ = abVar;
            this.BbK = abVar2;
            this.BbL = abVar3;
            this.BbM = set;
        }
    }

    static {
        f avX = f.avX("kotlin");
        AZU = avX;
        a.i.b.a.c.f.b s = a.i.b.a.c.f.b.s(avX);
        AZV = s;
        AZW = s.q(f.avX("annotation"));
    }

    protected g(i iVar) {
        this.Baf = iVar;
        this.Bad = iVar.i(new a.f.a.a<b>() {
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119092);
                ac eaE = g.this.Bab.eaE();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                ab a = g.a(g.this, eaE, linkedHashMap, g.AZV);
                g.a(g.this, eaE, null, d.BDS);
                ab a2 = g.a(g.this, eaE, linkedHashMap, g.AZX);
                g.a(g.this, eaE, linkedHashMap, g.AZY);
                b bVar = new b(a, a2, g.a(g.this, eaE, linkedHashMap, g.AZW), new LinkedHashSet(linkedHashMap.values()), (byte) 0);
                AppMethodBeat.o(119092);
                return bVar;
            }
        });
        this.Bac = iVar.i(new a.f.a.a<c>() {
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119093);
                EnumMap enumMap = new EnumMap(h.class);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                for (h hVar : h.values()) {
                    ad a = g.this.avB(hVar.BbZ.name).dZf();
                    ad a2 = g.this.avB(hVar.Bca.name).dZf();
                    enumMap.put(hVar, a2);
                    hashMap.put(a, a2);
                    hashMap2.put(a2, a);
                }
                c cVar = new c(enumMap, hashMap, hashMap2, (byte) 0);
                AppMethodBeat.o(119093);
                return cVar;
            }
        });
        this.Bae = iVar.f(new a.f.a.b<f, e>() {
            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(119094);
                e b = g.a((f) obj, ((b) g.this.Bad.invoke()).BbJ);
                AppMethodBeat.o(119094);
                return b;
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final void dXH() {
        this.Bab = new v(Bah, this.Baf, this);
        v vVar = this.Bab;
        a.i.b.a.c.a.b.a aVar = b.AZL;
        b bVar = (b) a.i.b.a.c.a.b.a.AZM.getValue();
        dXK();
        dXJ();
        dXI();
        vVar.a(bVar.dXE());
        this.Bab.a(this.Bab);
    }

    /* Access modifiers changed, original: protected */
    public a.i.b.a.c.b.b.a dXI() {
        return a.i.b.a.c.b.b.a.a.BgV;
    }

    /* Access modifiers changed, original: protected */
    public a.i.b.a.c.b.b.c dXJ() {
        return a.i.b.a.c.b.b.c.b.BgX;
    }

    /* Access modifiers changed, original: protected */
    public Iterable<a.i.b.a.c.b.b.b> dXK() {
        return Collections.singletonList(new a.i.b.a.c.a.a.a(this.Baf, this.Bab));
    }

    public static boolean b(l lVar) {
        return d.a(lVar, c.class, false) != null;
    }

    public static boolean c(l lVar) {
        for (l lVar2 = lVar; lVar2 != null; lVar2 = lVar2.dXW()) {
            if (lVar2 instanceof ab) {
                return ((ab) lVar2).dZF().r(AZU);
            }
        }
        return false;
    }

    private e c(f fVar) {
        return (e) this.Bae.am(fVar);
    }

    public final e avB(String str) {
        return c(f.avX(str));
    }

    public static String SK(int i) {
        return "Function".concat(String.valueOf(i));
    }

    public static a.i.b.a.c.f.a SL(int i) {
        return new a.i.b.a.c.f.a(AZV, f.avX(SK(i)));
    }

    public final e SM(int i) {
        return c(d.BDS.q(f.avX(a.i.b.a.c.a.a.b.b.SuspendFunction.BcX + i)));
    }

    public final ad dXN() {
        return dXM().rL(true);
    }

    public final w l(w wVar) {
        if (!n(wVar)) {
            w aA = av.aA(wVar);
            w wVar2 = (w) ((c) this.Bac.invoke()).BbP.get(aA);
            if (wVar2 != null) {
                return wVar2;
            }
            y Y = d.Y(aA);
            if (Y != null) {
                h dYs = aA.ejw().dYs();
                if (dYs == null) {
                    wVar2 = null;
                } else {
                    m mVar = m.BcG;
                    if (m.d(dYs.dZg())) {
                        a.i.b.a.c.f.a c = a.i.b.a.c.i.c.a.c(dYs);
                        if (c == null) {
                            wVar2 = null;
                        } else {
                            mVar = m.BcG;
                            c = m.c(c);
                            if (c == null) {
                                wVar2 = null;
                            } else {
                                e a = s.a(Y, c);
                                if (a == null) {
                                    wVar2 = null;
                                } else {
                                    wVar2 = a.dZf();
                                }
                            }
                        }
                    } else {
                        wVar2 = null;
                    }
                }
                if (wVar2 != null) {
                    return wVar2;
                }
            }
            throw new IllegalStateException("not array: ".concat(String.valueOf(wVar)));
        } else if (wVar.ejt().size() == 1) {
            return ((ap) wVar.ejt().get(0)).dZS();
        } else {
            throw new IllegalStateException();
        }
    }

    public final ad b(h hVar) {
        return (ad) ((c) this.Bac.invoke()).BbN.get(hVar);
    }

    public final ad m(w wVar) {
        ad adVar = (ad) ((c) this.Bac.invoke()).BbO.get(wVar);
        if (adVar != null) {
            return adVar;
        }
        m mVar = m.BcG;
        if (!m.G(wVar)) {
            return null;
        }
        if (av.aB(wVar)) {
            return null;
        }
        y Y = d.Y(wVar);
        if (Y == null) {
            return null;
        }
        a.i.b.a.c.f.a c = a.i.b.a.c.i.c.a.c(wVar.ejw().dYs());
        if ($assertionsDisabled || c != null) {
            m mVar2 = m.BcG;
            a.i.b.a.c.f.a d = m.d(c);
            if ($assertionsDisabled || d != null) {
                e a = s.a(Y, d);
                if (a == null) {
                    return null;
                }
                return a.dZf();
            }
            throw new AssertionError("arrayClassId should not be null for unsigned type ".concat(String.valueOf(c)));
        }
        throw new AssertionError("unsignedClassId should not be null for unsigned type ".concat(String.valueOf(wVar)));
    }

    public static boolean b(a.i.b.a.c.f.c cVar) {
        return Bag.BbI.get(cVar) != null;
    }

    public static h d(l lVar) {
        return Bag.BbF.contains(lVar.dZg()) ? (h) Bag.BbH.get(d.n(lVar)) : null;
    }

    public static h e(l lVar) {
        return Bag.BbG.contains(lVar.dZg()) ? (h) Bag.BbI.get(d.n(lVar)) : null;
    }

    public final ad a(ba baVar, w wVar) {
        List singletonList = Collections.singletonList(new ar(baVar, wVar));
        a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
        return x.a(a.i.b.a.c.b.a.g.a.eai(), avB("Array"), singletonList);
    }

    public static boolean n(w wVar) {
        return a(wVar, Bag.Bat);
    }

    public static boolean c(e eVar) {
        return a((h) eVar, Bag.Bat) || e((l) eVar) != null;
    }

    public static boolean o(w wVar) {
        l dYs = wVar.ejw().dYs();
        return (dYs == null || e(dYs) == null) ? false : true;
    }

    public static boolean p(w wVar) {
        if (!wVar.eci()) {
            Object obj;
            h dYs = wVar.ejw().dYs();
            if ((dYs instanceof e) && d((e) dYs)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(e eVar) {
        return d((l) eVar) != null;
    }

    private static boolean a(w wVar, a.i.b.a.c.f.c cVar) {
        h dYs = wVar.ejw().dYs();
        return (dYs instanceof e) && a(dYs, cVar);
    }

    private static boolean a(h hVar, a.i.b.a.c.f.c cVar) {
        return hVar.dZg().equals(cVar.ehK()) && cVar.equals(d.n(hVar));
    }

    private static boolean b(w wVar, a.i.b.a.c.f.c cVar) {
        return !wVar.eci() && a(wVar, cVar);
    }

    public static boolean e(e eVar) {
        return a((h) eVar, Bag.Bam) || a((h) eVar, Bag.Ban);
    }

    public static boolean f(e eVar) {
        return a((h) eVar, Bag.Bam);
    }

    public static boolean q(w wVar) {
        return c(wVar, Bag.Bau);
    }

    public static boolean r(w wVar) {
        return c(wVar, Bag.Bav);
    }

    public static boolean s(w wVar) {
        return c(wVar, Bag.Bay);
    }

    public static boolean t(w wVar) {
        return c(wVar, Bag.Baw);
    }

    public static boolean u(w wVar) {
        return c(wVar, Bag.Baz);
    }

    public static boolean v(w wVar) {
        return c(wVar, Bag.Bax);
    }

    private static boolean c(w wVar, a.i.b.a.c.f.c cVar) {
        return a(wVar, cVar) && !wVar.eci();
    }

    public static boolean y(w wVar) {
        return z(wVar) && !av.aB(wVar);
    }

    public static boolean z(w wVar) {
        return a(wVar, Bag.Ban);
    }

    public static boolean A(w wVar) {
        return a(wVar, Bag.Bam);
    }

    public static boolean B(w wVar) {
        return A(wVar) && wVar.eci();
    }

    public static boolean C(w wVar) {
        return B(wVar);
    }

    public static boolean D(w wVar) {
        return b(wVar, Bag.Baq);
    }

    public static boolean E(w wVar) {
        return wVar != null && b(wVar, Bag.Bas);
    }

    public static boolean g(e eVar) {
        return a((h) eVar, Bag.Bbo);
    }

    public static boolean f(l lVar) {
        if (lVar.dZd().dYn().j(Bag.BaK)) {
            return true;
        }
        if (!(lVar instanceof ah)) {
            return false;
        }
        boolean dZZ = ((ah) lVar).dZZ();
        l dZI = ((ah) lVar).dZI();
        l dZJ = ((ah) lVar).dZJ();
        return dZI != null && f(dZI) && (!dZZ || (dZJ != null && f(dZJ)));
    }

    public static a.i.b.a.c.f.b c(h hVar) {
        return AZV.q(hVar.BbZ);
    }

    public static e a(f fVar, ab abVar) {
        h c = abVar.dXR().c(fVar, a.i.b.a.c.c.a.c.FROM_BUILTINS);
        if ($assertionsDisabled || c == null || (c instanceof e)) {
            e eVar = (e) c;
            if (eVar != null) {
                return eVar;
            }
            throw new AssertionError("Built-in class " + abVar.dZF().q(fVar).ByQ.ByV + " is not found");
        }
        throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + c);
    }

    public final e c(a.i.b.a.c.f.b bVar) {
        e a = q.a(this.Bab, bVar, a.i.b.a.c.c.a.c.FROM_BUILTINS);
        if ($assertionsDisabled || a != null) {
            return a;
        }
        throw new AssertionError("Can't find built-in class ".concat(String.valueOf(bVar)));
    }

    public final ad dXL() {
        return avB("Nothing").dZf();
    }

    public final ad dXM() {
        return avB("Any").dZf();
    }

    public final ad a(h hVar) {
        return avB(hVar.BbZ.name).dZf();
    }

    public final ad dXO() {
        return avB("Unit").dZf();
    }

    public final ad dXP() {
        return avB("String").dZf();
    }

    public static boolean w(w wVar) {
        return a(wVar, Bag.BaA) && !wVar.eci();
    }

    public static boolean x(w wVar) {
        return a(wVar, Bag.BaB) && !wVar.eci();
    }

    static /* synthetic */ ab a(g gVar, ac acVar, Map map, a.i.b.a.c.f.b bVar) {
        Object mVar;
        final List h = acVar.h(bVar);
        if (h.isEmpty()) {
            mVar = new m(gVar.Bab, bVar);
        } else if (h.size() == 1) {
            ab mVar2 = (ab) h.iterator().next();
        } else {
            final a.i.b.a.c.f.b bVar2 = bVar;
            mVar2 = new a.i.b.a.c.b.c.x(gVar.Bab, bVar) {
                public final a.i.b.a.c.i.e.h dXR() {
                    AppMethodBeat.i(119096);
                    a.i.b.a.c.i.e.b bVar = new a.i.b.a.c.i.e.b("built-in package " + bVar2, t.c((Iterable) h, (a.f.a.b) new a.f.a.b<ab, a.i.b.a.c.i.e.h>() {
                        public final /* synthetic */ Object am(Object obj) {
                            AppMethodBeat.i(119095);
                            a.i.b.a.c.i.e.h dXR = ((ab) obj).dXR();
                            AppMethodBeat.o(119095);
                            return dXR;
                        }
                    }));
                    AppMethodBeat.o(119096);
                    return bVar;
                }
            };
        }
        if (map != null) {
            map.put(bVar, mVar2);
        }
        return mVar2;
    }
}
