package a.i.b.a.c.a.b;

import a.a.l;
import a.aa;
import a.f.b.j;
import a.i.b.a.c.a.a.b.b;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.e;
import a.i.b.a.c.f.d;
import a.i.b.a.c.f.f;
import a.i.b.a.c.f.h;
import a.k.t;
import a.k.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c {
    private static final String Bde = (b.Function.BcW.toString() + "." + b.Function.BcX);
    private static final String Bdf = (b.KFunction.BcW.toString() + "." + b.KFunction.BcX);
    private static final String Bdg = (b.SuspendFunction.BcW.toString() + "." + b.SuspendFunction.BcX);
    private static final String Bdh = (b.KSuspendFunction.BcW.toString() + "." + b.KSuspendFunction.BcX);
    private static final a.i.b.a.c.f.a Bdi;
    private static final a.i.b.a.c.f.b Bdj;
    private static final a.i.b.a.c.f.a Bdk;
    private static final HashMap<a.i.b.a.c.f.c, a.i.b.a.c.f.a> Bdl = new HashMap();
    private static final HashMap<a.i.b.a.c.f.c, a.i.b.a.c.f.a> Bdm = new HashMap();
    private static final HashMap<a.i.b.a.c.f.c, a.i.b.a.c.f.b> Bdn = new HashMap();
    static final HashMap<a.i.b.a.c.f.c, a.i.b.a.c.f.b> Bdo = new HashMap();
    private static final List<a> Bdp;
    public static final c Bdq;

    public static final class a {
        public final a.i.b.a.c.f.a Bdr;
        final a.i.b.a.c.f.a Bds;
        final a.i.b.a.c.f.a Bdt;

        /* JADX WARNING: Missing block: B:9:0x002a, code skipped:
            if (a.f.b.j.j(r3.Bdt, r4.Bdt) != false) goto L_0x002c;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(119175);
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (j.j(this.Bdr, aVar.Bdr)) {
                        if (j.j(this.Bds, aVar.Bds)) {
                        }
                    }
                }
                AppMethodBeat.o(119175);
                return false;
            }
            AppMethodBeat.o(119175);
            return true;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.i(119174);
            a.i.b.a.c.f.a aVar = this.Bdr;
            int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
            aVar = this.Bds;
            int hashCode2 = ((aVar != null ? aVar.hashCode() : 0) + hashCode) * 31;
            a.i.b.a.c.f.a aVar2 = this.Bdt;
            if (aVar2 != null) {
                i = aVar2.hashCode();
            }
            hashCode2 += i;
            AppMethodBeat.o(119174);
            return hashCode2;
        }

        public final String toString() {
            AppMethodBeat.i(119173);
            String str = "PlatformMutabilityMapping(javaClass=" + this.Bdr + ", kotlinReadOnly=" + this.Bds + ", kotlinMutable=" + this.Bdt + ")";
            AppMethodBeat.o(119173);
            return str;
        }

        public a(a.i.b.a.c.f.a aVar, a.i.b.a.c.f.a aVar2, a.i.b.a.c.f.a aVar3) {
            j.p(aVar, "javaClass");
            j.p(aVar2, "kotlinReadOnly");
            j.p(aVar3, "kotlinMutable");
            AppMethodBeat.i(119172);
            this.Bdr = aVar;
            this.Bds = aVar2;
            this.Bdt = aVar3;
            AppMethodBeat.o(119172);
        }
    }

    static {
        a.i.b.a.c.f.a aVar;
        a.i.b.a.c.f.a aVar2;
        int i;
        AppMethodBeat.i(119190);
        c cVar = new c();
        Bdq = cVar;
        a.i.b.a.c.f.a n = a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b("kotlin.jvm.functions.FunctionN"));
        j.o(n, "ClassId.topLevel(FqName(…vm.functions.FunctionN\"))");
        Bdi = n;
        a.i.b.a.c.f.b ehE = n.ehE();
        j.o(ehE, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        Bdj = ehE;
        n = a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b("kotlin.reflect.KFunction"));
        j.o(n, "ClassId.topLevel(FqName(…tlin.reflect.KFunction\"))");
        Bdk = n;
        a[] aVarArr = new a[8];
        a.i.b.a.c.f.a n2 = a.i.b.a.c.f.a.n(g.Bag.BaZ);
        j.o(n2, "ClassId.topLevel(FQ_NAMES.iterable)");
        a.i.b.a.c.f.b bVar = g.Bag.Bbh;
        j.o(bVar, "FQ_NAMES.mutableIterable");
        a.i.b.a.c.f.b bVar2 = n2.BcW;
        a.i.b.a.c.f.b bVar3 = n2.BcW;
        j.o(bVar3, "kotlinReadOnly.packageFqName");
        aVarArr[0] = new a(cVar.aW(Iterable.class), n2, new a.i.b.a.c.f.a(bVar2, d.b(bVar, bVar3), false));
        n2 = a.i.b.a.c.f.a.n(g.Bag.BaY);
        j.o(n2, "ClassId.topLevel(FQ_NAMES.iterator)");
        bVar = g.Bag.Bbg;
        j.o(bVar, "FQ_NAMES.mutableIterator");
        bVar2 = n2.BcW;
        bVar3 = n2.BcW;
        j.o(bVar3, "kotlinReadOnly.packageFqName");
        aVarArr[1] = new a(cVar.aW(Iterator.class), n2, new a.i.b.a.c.f.a(bVar2, d.b(bVar, bVar3), false));
        n2 = a.i.b.a.c.f.a.n(g.Bag.Bba);
        j.o(n2, "ClassId.topLevel(FQ_NAMES.collection)");
        bVar = g.Bag.Bbi;
        j.o(bVar, "FQ_NAMES.mutableCollection");
        bVar2 = n2.BcW;
        bVar3 = n2.BcW;
        j.o(bVar3, "kotlinReadOnly.packageFqName");
        aVarArr[2] = new a(cVar.aW(Collection.class), n2, new a.i.b.a.c.f.a(bVar2, d.b(bVar, bVar3), false));
        n2 = a.i.b.a.c.f.a.n(g.Bag.Bbb);
        j.o(n2, "ClassId.topLevel(FQ_NAMES.list)");
        bVar = g.Bag.Bbj;
        j.o(bVar, "FQ_NAMES.mutableList");
        bVar2 = n2.BcW;
        bVar3 = n2.BcW;
        j.o(bVar3, "kotlinReadOnly.packageFqName");
        aVarArr[3] = new a(cVar.aW(List.class), n2, new a.i.b.a.c.f.a(bVar2, d.b(bVar, bVar3), false));
        n2 = a.i.b.a.c.f.a.n(g.Bag.Bbd);
        j.o(n2, "ClassId.topLevel(FQ_NAMES.set)");
        bVar = g.Bag.Bbl;
        j.o(bVar, "FQ_NAMES.mutableSet");
        bVar2 = n2.BcW;
        bVar3 = n2.BcW;
        j.o(bVar3, "kotlinReadOnly.packageFqName");
        aVarArr[4] = new a(cVar.aW(Set.class), n2, new a.i.b.a.c.f.a(bVar2, d.b(bVar, bVar3), false));
        n2 = a.i.b.a.c.f.a.n(g.Bag.Bbc);
        j.o(n2, "ClassId.topLevel(FQ_NAMES.listIterator)");
        bVar = g.Bag.Bbk;
        j.o(bVar, "FQ_NAMES.mutableListIterator");
        bVar2 = n2.BcW;
        bVar3 = n2.BcW;
        j.o(bVar3, "kotlinReadOnly.packageFqName");
        aVarArr[5] = new a(cVar.aW(ListIterator.class), n2, new a.i.b.a.c.f.a(bVar2, d.b(bVar, bVar3), false));
        n2 = a.i.b.a.c.f.a.n(g.Bag.Bbe);
        j.o(n2, "ClassId.topLevel(FQ_NAMES.map)");
        bVar = g.Bag.Bbm;
        j.o(bVar, "FQ_NAMES.mutableMap");
        bVar2 = n2.BcW;
        bVar3 = n2.BcW;
        j.o(bVar3, "kotlinReadOnly.packageFqName");
        aVarArr[6] = new a(cVar.aW(Map.class), n2, new a.i.b.a.c.f.a(bVar2, d.b(bVar, bVar3), false));
        n2 = a.i.b.a.c.f.a.n(g.Bag.Bbe).p(g.Bag.Bbf.ByQ.ehK());
        j.o(n2, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
        bVar = g.Bag.Bbn;
        j.o(bVar, "FQ_NAMES.mutableMapEntry");
        bVar2 = n2.BcW;
        bVar3 = n2.BcW;
        j.o(bVar3, "kotlinReadOnly.packageFqName");
        aVarArr[7] = new a(cVar.aW(Entry.class), n2, new a.i.b.a.c.f.a(bVar2, d.b(bVar, bVar3), false));
        Bdp = l.listOf(aVarArr);
        a.i.b.a.c.f.c cVar2 = g.Bag.Bam;
        j.o(cVar2, "FQ_NAMES.any");
        cVar.a(Object.class, cVar2);
        cVar2 = g.Bag.Bas;
        j.o(cVar2, "FQ_NAMES.string");
        cVar.a(String.class, cVar2);
        cVar2 = g.Bag.Bar;
        j.o(cVar2, "FQ_NAMES.charSequence");
        cVar.a(CharSequence.class, cVar2);
        a.i.b.a.c.f.b bVar4 = g.Bag.BaF;
        j.o(bVar4, "FQ_NAMES.throwable");
        cVar.a(Throwable.class, bVar4);
        cVar2 = g.Bag.Bao;
        j.o(cVar2, "FQ_NAMES.cloneable");
        cVar.a(Cloneable.class, cVar2);
        cVar2 = g.Bag.BaC;
        j.o(cVar2, "FQ_NAMES.number");
        cVar.a(Number.class, cVar2);
        bVar4 = g.Bag.BaG;
        j.o(bVar4, "FQ_NAMES.comparable");
        cVar.a(Comparable.class, bVar4);
        cVar2 = g.Bag.BaD;
        j.o(cVar2, "FQ_NAMES._enum");
        cVar.a(Enum.class, cVar2);
        bVar4 = g.Bag.BaP;
        j.o(bVar4, "FQ_NAMES.annotation");
        cVar.a(Annotation.class, bVar4);
        for (a aVar3 : Bdp) {
            aVar = aVar3.Bdr;
            aVar2 = aVar3.Bds;
            n = aVar3.Bdt;
            a(aVar, aVar2);
            bVar2 = n.ehE();
            j.o(bVar2, "mutableClassId.asSingleFqName()");
            a(bVar2, aVar);
            bVar = aVar2.ehE();
            j.o(bVar, "readOnlyClassId.asSingleFqName()");
            a.i.b.a.c.f.b ehE2 = n.ehE();
            j.o(ehE2, "mutableClassId.asSingleFqName()");
            Bdn.put(n.ehE().ByQ, bVar);
            Bdo.put(bVar.ByQ, ehE2);
        }
        for (a.i.b.a.c.i.d.c cVar3 : a.i.b.a.c.i.d.c.values()) {
            a.i.b.a.c.f.a n3 = a.i.b.a.c.f.a.n(cVar3.BFr);
            j.o(n3, "ClassId.topLevel(jvmType.wrapperFqName)");
            aVar2 = a.i.b.a.c.f.a.n(g.c(cVar3.BFq));
            j.o(aVar2, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
            a(n3, aVar2);
        }
        a.i.b.a.c.a.d dVar = a.i.b.a.c.a.d.AZQ;
        for (a.i.b.a.c.f.a n4 : a.i.b.a.c.a.d.dXF()) {
            aVar = a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b("kotlin.jvm.internal." + n4.ByN.ByQ.ehK().name + "CompanionObject"));
            j.o(aVar, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
            n4 = n4.p(h.Bze);
            j.o(n4, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            a(aVar, n4);
        }
        for (i = 0; i < 23; i++) {
            n2 = a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b("kotlin.jvm.functions.Function".concat(String.valueOf(i))));
            j.o(n2, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
            aVar = g.SL(i);
            j.o(aVar, "KotlinBuiltIns.getFunctionClassId(i)");
            a(n2, aVar);
            a(new a.i.b.a.c.f.b(Bdf + i), Bdk);
        }
        for (i = 0; i < 22; i++) {
            b bVar5 = b.KSuspendFunction;
            a(new a.i.b.a.c.f.b((bVar5.BcW.toString() + "." + bVar5.BcX) + i), Bdk);
        }
        ehE = g.Bag.Ban.ehI();
        j.o(ehE, "FQ_NAMES.nothing.toSafe()");
        a(ehE, cVar.aW(Void.class));
        AppMethodBeat.o(119190);
    }

    private c() {
    }

    public static a.i.b.a.c.f.b dYA() {
        return Bdj;
    }

    public static List<a> dYB() {
        return Bdp;
    }

    public static a.i.b.a.c.f.a f(a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(119176);
        j.p(bVar, "fqName");
        a.i.b.a.c.f.a aVar = (a.i.b.a.c.f.a) Bdl.get(bVar.ByQ);
        AppMethodBeat.o(119176);
        return aVar;
    }

    public static a.i.b.a.c.f.a c(a.i.b.a.c.f.c cVar) {
        AppMethodBeat.i(119178);
        j.p(cVar, "kotlinFqName");
        a.i.b.a.c.f.a aVar;
        if (a(cVar, Bde)) {
            aVar = Bdi;
            AppMethodBeat.o(119178);
            return aVar;
        } else if (a(cVar, Bdg)) {
            aVar = Bdi;
            AppMethodBeat.o(119178);
            return aVar;
        } else if (a(cVar, Bdf)) {
            aVar = Bdk;
            AppMethodBeat.o(119178);
            return aVar;
        } else if (a(cVar, Bdh)) {
            aVar = Bdk;
            AppMethodBeat.o(119178);
            return aVar;
        } else {
            aVar = (a.i.b.a.c.f.a) Bdm.get(cVar);
            AppMethodBeat.o(119178);
            return aVar;
        }
    }

    private final void a(Class<?> cls, a.i.b.a.c.f.c cVar) {
        AppMethodBeat.i(119181);
        a.i.b.a.c.f.b ehI = cVar.ehI();
        j.o(ehI, "kotlinFqName.toSafe()");
        a((Class) cls, ehI);
        AppMethodBeat.o(119181);
    }

    private final void a(Class<?> cls, a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(119182);
        a.i.b.a.c.f.a aW = aW(cls);
        a.i.b.a.c.f.a n = a.i.b.a.c.f.a.n(bVar);
        j.o(n, "ClassId.topLevel(kotlinFqName)");
        a(aW, n);
        AppMethodBeat.o(119182);
    }

    private static void a(a.i.b.a.c.f.b bVar, a.i.b.a.c.f.a aVar) {
        AppMethodBeat.i(119183);
        Bdm.put(bVar.ByQ, aVar);
        AppMethodBeat.o(119183);
    }

    public static boolean h(e eVar) {
        AppMethodBeat.i(119184);
        j.p(eVar, "mutable");
        boolean containsKey = Bdn.containsKey(a.i.b.a.c.i.d.n(eVar));
        AppMethodBeat.o(119184);
        return containsKey;
    }

    public static boolean i(e eVar) {
        AppMethodBeat.i(119185);
        j.p(eVar, "readOnly");
        boolean containsKey = Bdo.containsKey(a.i.b.a.c.i.d.n(eVar));
        AppMethodBeat.o(119185);
        return containsKey;
    }

    public static e j(e eVar) {
        AppMethodBeat.i(119186);
        j.p(eVar, "mutable");
        e a = a(eVar, Bdn, "mutable");
        AppMethodBeat.o(119186);
        return a;
    }

    public static e k(e eVar) {
        AppMethodBeat.i(119187);
        j.p(eVar, "readOnly");
        e a = a(eVar, Bdo, "read-only");
        AppMethodBeat.o(119187);
        return a;
    }

    private final a.i.b.a.c.f.a aW(Class<?> cls) {
        AppMethodBeat.i(119188);
        Object obj = (cls.isPrimitive() || cls.isArray()) ? null : 1;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Invalid class: ".concat(String.valueOf(cls)));
            AppMethodBeat.o(119188);
            throw assertionError;
        }
        Class declaringClass = cls.getDeclaringClass();
        a.i.b.a.c.f.a n;
        if (declaringClass == null) {
            n = a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b(cls.getCanonicalName()));
            j.o(n, "ClassId.topLevel(FqName(clazz.canonicalName))");
            AppMethodBeat.o(119188);
            return n;
        }
        n = aW(declaringClass).p(f.avX(cls.getSimpleName()));
        j.o(n, "classId(outer).createNes…tifier(clazz.simpleName))");
        AppMethodBeat.o(119188);
        return n;
    }

    private static e a(e eVar, Map<a.i.b.a.c.f.c, a.i.b.a.c.f.b> map, String str) {
        AppMethodBeat.i(119189);
        a.i.b.a.c.f.b bVar = (a.i.b.a.c.f.b) map.get(a.i.b.a.c.i.d.n(eVar));
        if (bVar == null) {
            Throwable illegalArgumentException = new IllegalArgumentException("Given class " + eVar + " is not a " + str + " collection");
            AppMethodBeat.o(119189);
            throw illegalArgumentException;
        }
        e c = a.i.b.a.c.i.c.a.G(eVar).c(bVar);
        j.o(c, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
        AppMethodBeat.o(119189);
        return c;
    }

    private static boolean a(a.i.b.a.c.f.c cVar, String str) {
        Object obj;
        AppMethodBeat.i(119179);
        String str2 = cVar.ByV;
        j.o(str2, "kotlinFqName.asString()");
        String aK = v.aK(str2, str, "");
        if (aK.length() > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || v.au(aK)) {
            AppMethodBeat.o(119179);
            return false;
        }
        Integer awy = t.awy(aK);
        if (awy == null || awy.intValue() < 23) {
            AppMethodBeat.o(119179);
            return false;
        }
        AppMethodBeat.o(119179);
        return true;
    }

    private static void a(a.i.b.a.c.f.a aVar, a.i.b.a.c.f.a aVar2) {
        AppMethodBeat.i(119180);
        Bdl.put(aVar.ehE().ByQ, aVar2);
        a.i.b.a.c.f.b ehE = aVar2.ehE();
        j.o(ehE, "kotlinClassId.asSingleFqName()");
        a(ehE, aVar);
        AppMethodBeat.o(119180);
    }
}
