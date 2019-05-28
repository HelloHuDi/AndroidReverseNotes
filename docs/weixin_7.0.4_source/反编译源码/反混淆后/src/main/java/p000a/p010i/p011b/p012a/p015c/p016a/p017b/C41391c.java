package p000a.p010i.p011b.p012a.p015c.p016a.p017b;

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
import p000a.C44847aa;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C0024d;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p016a.p774a.C24607b.C8027b;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C25176c;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C37023h;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p010i.p011b.p012a.p015c.p778f.C8175c;
import p000a.p010i.p011b.p012a.p015c.p778f.C8177d;
import p000a.p051k.C0218t;
import p000a.p051k.C31820v;

/* renamed from: a.i.b.a.c.a.b.c */
public final class C41391c {
    private static final String Bde = (C8027b.Function.BcW.toString() + "." + C8027b.Function.BcX);
    private static final String Bdf = (C8027b.KFunction.BcW.toString() + "." + C8027b.KFunction.BcX);
    private static final String Bdg = (C8027b.SuspendFunction.BcW.toString() + "." + C8027b.SuspendFunction.BcX);
    private static final String Bdh = (C8027b.KSuspendFunction.BcW.toString() + "." + C8027b.KSuspendFunction.BcX);
    private static final C8173a Bdi;
    private static final C8174b Bdj;
    private static final C8173a Bdk;
    private static final HashMap<C8175c, C8173a> Bdl = new HashMap();
    private static final HashMap<C8175c, C8173a> Bdm = new HashMap();
    private static final HashMap<C8175c, C8174b> Bdn = new HashMap();
    static final HashMap<C8175c, C8174b> Bdo = new HashMap();
    private static final List<C41392a> Bdp;
    public static final C41391c Bdq;

    /* renamed from: a.i.b.a.c.a.b.c$a */
    public static final class C41392a {
        public final C8173a Bdr;
        final C8173a Bds;
        final C8173a Bdt;

        /* JADX WARNING: Missing block: B:9:0x002a, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.Bdt, r4.Bdt) != false) goto L_0x002c;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(119175);
            if (this != obj) {
                if (obj instanceof C41392a) {
                    C41392a c41392a = (C41392a) obj;
                    if (C25052j.m39373j(this.Bdr, c41392a.Bdr)) {
                        if (C25052j.m39373j(this.Bds, c41392a.Bds)) {
                        }
                    }
                }
                AppMethodBeat.m2505o(119175);
                return false;
            }
            AppMethodBeat.m2505o(119175);
            return true;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.m2504i(119174);
            C8173a c8173a = this.Bdr;
            int hashCode = (c8173a != null ? c8173a.hashCode() : 0) * 31;
            c8173a = this.Bds;
            int hashCode2 = ((c8173a != null ? c8173a.hashCode() : 0) + hashCode) * 31;
            C8173a c8173a2 = this.Bdt;
            if (c8173a2 != null) {
                i = c8173a2.hashCode();
            }
            hashCode2 += i;
            AppMethodBeat.m2505o(119174);
            return hashCode2;
        }

        public final String toString() {
            AppMethodBeat.m2504i(119173);
            String str = "PlatformMutabilityMapping(javaClass=" + this.Bdr + ", kotlinReadOnly=" + this.Bds + ", kotlinMutable=" + this.Bdt + ")";
            AppMethodBeat.m2505o(119173);
            return str;
        }

        public C41392a(C8173a c8173a, C8173a c8173a2, C8173a c8173a3) {
            C25052j.m39376p(c8173a, "javaClass");
            C25052j.m39376p(c8173a2, "kotlinReadOnly");
            C25052j.m39376p(c8173a3, "kotlinMutable");
            AppMethodBeat.m2504i(119172);
            this.Bdr = c8173a;
            this.Bds = c8173a2;
            this.Bdt = c8173a3;
            AppMethodBeat.m2505o(119172);
        }
    }

    static {
        C8173a c8173a;
        C8173a c8173a2;
        int i;
        AppMethodBeat.m2504i(119190);
        C41391c c41391c = new C41391c();
        Bdq = c41391c;
        C8173a n = C8173a.m14427n(new C8174b("kotlin.jvm.functions.FunctionN"));
        C25052j.m39375o(n, "ClassId.topLevel(FqName(…vm.functions.FunctionN\"))");
        Bdi = n;
        C8174b ehE = n.ehE();
        C25052j.m39375o(ehE, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        Bdj = ehE;
        n = C8173a.m14427n(new C8174b("kotlin.reflect.KFunction"));
        C25052j.m39375o(n, "ClassId.topLevel(FqName(…tlin.reflect.KFunction\"))");
        Bdk = n;
        C41392a[] c41392aArr = new C41392a[8];
        C8173a n2 = C8173a.m14427n(C31619g.Bag.BaZ);
        C25052j.m39375o(n2, "ClassId.topLevel(FQ_NAMES.iterable)");
        C8174b c8174b = C31619g.Bag.Bbh;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableIterable");
        C8174b c8174b2 = n2.BcW;
        C8174b c8174b3 = n2.BcW;
        C25052j.m39375o(c8174b3, "kotlinReadOnly.packageFqName");
        c41392aArr[0] = new C41392a(c41391c.m72178aW(Iterable.class), n2, new C8173a(c8174b2, C8177d.m14438b(c8174b, c8174b3), false));
        n2 = C8173a.m14427n(C31619g.Bag.BaY);
        C25052j.m39375o(n2, "ClassId.topLevel(FQ_NAMES.iterator)");
        c8174b = C31619g.Bag.Bbg;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableIterator");
        c8174b2 = n2.BcW;
        c8174b3 = n2.BcW;
        C25052j.m39375o(c8174b3, "kotlinReadOnly.packageFqName");
        c41392aArr[1] = new C41392a(c41391c.m72178aW(Iterator.class), n2, new C8173a(c8174b2, C8177d.m14438b(c8174b, c8174b3), false));
        n2 = C8173a.m14427n(C31619g.Bag.Bba);
        C25052j.m39375o(n2, "ClassId.topLevel(FQ_NAMES.collection)");
        c8174b = C31619g.Bag.Bbi;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableCollection");
        c8174b2 = n2.BcW;
        c8174b3 = n2.BcW;
        C25052j.m39375o(c8174b3, "kotlinReadOnly.packageFqName");
        c41392aArr[2] = new C41392a(c41391c.m72178aW(Collection.class), n2, new C8173a(c8174b2, C8177d.m14438b(c8174b, c8174b3), false));
        n2 = C8173a.m14427n(C31619g.Bag.Bbb);
        C25052j.m39375o(n2, "ClassId.topLevel(FQ_NAMES.list)");
        c8174b = C31619g.Bag.Bbj;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableList");
        c8174b2 = n2.BcW;
        c8174b3 = n2.BcW;
        C25052j.m39375o(c8174b3, "kotlinReadOnly.packageFqName");
        c41392aArr[3] = new C41392a(c41391c.m72178aW(List.class), n2, new C8173a(c8174b2, C8177d.m14438b(c8174b, c8174b3), false));
        n2 = C8173a.m14427n(C31619g.Bag.Bbd);
        C25052j.m39375o(n2, "ClassId.topLevel(FQ_NAMES.set)");
        c8174b = C31619g.Bag.Bbl;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableSet");
        c8174b2 = n2.BcW;
        c8174b3 = n2.BcW;
        C25052j.m39375o(c8174b3, "kotlinReadOnly.packageFqName");
        c41392aArr[4] = new C41392a(c41391c.m72178aW(Set.class), n2, new C8173a(c8174b2, C8177d.m14438b(c8174b, c8174b3), false));
        n2 = C8173a.m14427n(C31619g.Bag.Bbc);
        C25052j.m39375o(n2, "ClassId.topLevel(FQ_NAMES.listIterator)");
        c8174b = C31619g.Bag.Bbk;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableListIterator");
        c8174b2 = n2.BcW;
        c8174b3 = n2.BcW;
        C25052j.m39375o(c8174b3, "kotlinReadOnly.packageFqName");
        c41392aArr[5] = new C41392a(c41391c.m72178aW(ListIterator.class), n2, new C8173a(c8174b2, C8177d.m14438b(c8174b, c8174b3), false));
        n2 = C8173a.m14427n(C31619g.Bag.Bbe);
        C25052j.m39375o(n2, "ClassId.topLevel(FQ_NAMES.map)");
        c8174b = C31619g.Bag.Bbm;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableMap");
        c8174b2 = n2.BcW;
        c8174b3 = n2.BcW;
        C25052j.m39375o(c8174b3, "kotlinReadOnly.packageFqName");
        c41392aArr[6] = new C41392a(c41391c.m72178aW(Map.class), n2, new C8173a(c8174b2, C8177d.m14438b(c8174b, c8174b3), false));
        n2 = C8173a.m14427n(C31619g.Bag.Bbe).mo17969p(C31619g.Bag.Bbf.ByQ.ehK());
        C25052j.m39375o(n2, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
        c8174b = C31619g.Bag.Bbn;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableMapEntry");
        c8174b2 = n2.BcW;
        c8174b3 = n2.BcW;
        C25052j.m39375o(c8174b3, "kotlinReadOnly.packageFqName");
        c41392aArr[7] = new C41392a(c41391c.m72178aW(Entry.class), n2, new C8173a(c8174b2, C8177d.m14438b(c8174b, c8174b3), false));
        Bdp = C7987l.listOf(c41392aArr);
        C8175c c8175c = C31619g.Bag.Bam;
        C25052j.m39375o(c8175c, "FQ_NAMES.any");
        c41391c.m72176a(Object.class, c8175c);
        c8175c = C31619g.Bag.Bas;
        C25052j.m39375o(c8175c, "FQ_NAMES.string");
        c41391c.m72176a(String.class, c8175c);
        c8175c = C31619g.Bag.Bar;
        C25052j.m39375o(c8175c, "FQ_NAMES.charSequence");
        c41391c.m72176a(CharSequence.class, c8175c);
        C8174b c8174b4 = C31619g.Bag.BaF;
        C25052j.m39375o(c8174b4, "FQ_NAMES.throwable");
        c41391c.m72175a(Throwable.class, c8174b4);
        c8175c = C31619g.Bag.Bao;
        C25052j.m39375o(c8175c, "FQ_NAMES.cloneable");
        c41391c.m72176a(Cloneable.class, c8175c);
        c8175c = C31619g.Bag.BaC;
        C25052j.m39375o(c8175c, "FQ_NAMES.number");
        c41391c.m72176a(Number.class, c8175c);
        c8174b4 = C31619g.Bag.BaG;
        C25052j.m39375o(c8174b4, "FQ_NAMES.comparable");
        c41391c.m72175a(Comparable.class, c8174b4);
        c8175c = C31619g.Bag.BaD;
        C25052j.m39375o(c8175c, "FQ_NAMES._enum");
        c41391c.m72176a(Enum.class, c8175c);
        c8174b4 = C31619g.Bag.BaP;
        C25052j.m39375o(c8174b4, "FQ_NAMES.annotation");
        c41391c.m72175a(Annotation.class, c8174b4);
        for (C41392a c41392a : Bdp) {
            c8173a = c41392a.Bdr;
            c8173a2 = c41392a.Bds;
            n = c41392a.Bdt;
            C41391c.m72173a(c8173a, c8173a2);
            c8174b2 = n.ehE();
            C25052j.m39375o(c8174b2, "mutableClassId.asSingleFqName()");
            C41391c.m72174a(c8174b2, c8173a);
            c8174b = c8173a2.ehE();
            C25052j.m39375o(c8174b, "readOnlyClassId.asSingleFqName()");
            C8174b ehE2 = n.ehE();
            C25052j.m39375o(ehE2, "mutableClassId.asSingleFqName()");
            Bdn.put(n.ehE().ByQ, c8174b);
            Bdo.put(c8174b.ByQ, ehE2);
        }
        for (C25176c c25176c : C25176c.values()) {
            C8173a n3 = C8173a.m14427n(c25176c.BFr);
            C25052j.m39375o(n3, "ClassId.topLevel(jvmType.wrapperFqName)");
            c8173a2 = C8173a.m14427n(C31619g.m51112c(c25176c.BFq));
            C25052j.m39375o(c8173a2, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
            C41391c.m72173a(n3, c8173a2);
        }
        C0024d c0024d = C0024d.AZQ;
        for (C8173a n4 : C0024d.dXF()) {
            c8173a = C8173a.m14427n(new C8174b("kotlin.jvm.internal." + n4.ByN.ByQ.ehK().name + "CompanionObject"));
            C25052j.m39375o(c8173a, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
            n4 = n4.mo17969p(C37023h.Bze);
            C25052j.m39375o(n4, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            C41391c.m72173a(c8173a, n4);
        }
        for (i = 0; i < 23; i++) {
            n2 = C8173a.m14427n(new C8174b("kotlin.jvm.functions.Function".concat(String.valueOf(i))));
            C25052j.m39375o(n2, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
            c8173a = C31619g.m51100SL(i);
            C25052j.m39375o(c8173a, "KotlinBuiltIns.getFunctionClassId(i)");
            C41391c.m72173a(n2, c8173a);
            C41391c.m72174a(new C8174b(Bdf + i), Bdk);
        }
        for (i = 0; i < 22; i++) {
            C8027b c8027b = C8027b.KSuspendFunction;
            C41391c.m72174a(new C8174b((c8027b.BcW.toString() + "." + c8027b.BcX) + i), Bdk);
        }
        ehE = C31619g.Bag.Ban.ehI();
        C25052j.m39375o(ehE, "FQ_NAMES.nothing.toSafe()");
        C41391c.m72174a(ehE, c41391c.m72178aW(Void.class));
        AppMethodBeat.m2505o(119190);
    }

    private C41391c() {
    }

    public static C8174b dYA() {
        return Bdj;
    }

    public static List<C41392a> dYB() {
        return Bdp;
    }

    /* renamed from: f */
    public static C8173a m72180f(C8174b c8174b) {
        AppMethodBeat.m2504i(119176);
        C25052j.m39376p(c8174b, "fqName");
        C8173a c8173a = (C8173a) Bdl.get(c8174b.ByQ);
        AppMethodBeat.m2505o(119176);
        return c8173a;
    }

    /* renamed from: c */
    public static C8173a m72179c(C8175c c8175c) {
        AppMethodBeat.m2504i(119178);
        C25052j.m39376p(c8175c, "kotlinFqName");
        C8173a c8173a;
        if (C41391c.m72177a(c8175c, Bde)) {
            c8173a = Bdi;
            AppMethodBeat.m2505o(119178);
            return c8173a;
        } else if (C41391c.m72177a(c8175c, Bdg)) {
            c8173a = Bdi;
            AppMethodBeat.m2505o(119178);
            return c8173a;
        } else if (C41391c.m72177a(c8175c, Bdf)) {
            c8173a = Bdk;
            AppMethodBeat.m2505o(119178);
            return c8173a;
        } else if (C41391c.m72177a(c8175c, Bdh)) {
            c8173a = Bdk;
            AppMethodBeat.m2505o(119178);
            return c8173a;
        } else {
            c8173a = (C8173a) Bdm.get(c8175c);
            AppMethodBeat.m2505o(119178);
            return c8173a;
        }
    }

    /* renamed from: a */
    private final void m72176a(Class<?> cls, C8175c c8175c) {
        AppMethodBeat.m2504i(119181);
        C8174b ehI = c8175c.ehI();
        C25052j.m39375o(ehI, "kotlinFqName.toSafe()");
        m72175a((Class) cls, ehI);
        AppMethodBeat.m2505o(119181);
    }

    /* renamed from: a */
    private final void m72175a(Class<?> cls, C8174b c8174b) {
        AppMethodBeat.m2504i(119182);
        C8173a aW = m72178aW(cls);
        C8173a n = C8173a.m14427n(c8174b);
        C25052j.m39375o(n, "ClassId.topLevel(kotlinFqName)");
        C41391c.m72173a(aW, n);
        AppMethodBeat.m2505o(119182);
    }

    /* renamed from: a */
    private static void m72174a(C8174b c8174b, C8173a c8173a) {
        AppMethodBeat.m2504i(119183);
        Bdm.put(c8174b.ByQ, c8173a);
        AppMethodBeat.m2505o(119183);
    }

    /* renamed from: h */
    public static boolean m72181h(C46865e c46865e) {
        AppMethodBeat.m2504i(119184);
        C25052j.m39376p(c46865e, "mutable");
        boolean containsKey = Bdn.containsKey(C8203d.m14486n(c46865e));
        AppMethodBeat.m2505o(119184);
        return containsKey;
    }

    /* renamed from: i */
    public static boolean m72182i(C46865e c46865e) {
        AppMethodBeat.m2504i(119185);
        C25052j.m39376p(c46865e, "readOnly");
        boolean containsKey = Bdo.containsKey(C8203d.m14486n(c46865e));
        AppMethodBeat.m2505o(119185);
        return containsKey;
    }

    /* renamed from: j */
    public static C46865e m72183j(C46865e c46865e) {
        AppMethodBeat.m2504i(119186);
        C25052j.m39376p(c46865e, "mutable");
        C46865e a = C41391c.m72171a(c46865e, Bdn, "mutable");
        AppMethodBeat.m2505o(119186);
        return a;
    }

    /* renamed from: k */
    public static C46865e m72184k(C46865e c46865e) {
        AppMethodBeat.m2504i(119187);
        C25052j.m39376p(c46865e, "readOnly");
        C46865e a = C41391c.m72171a(c46865e, Bdo, "read-only");
        AppMethodBeat.m2505o(119187);
        return a;
    }

    /* renamed from: aW */
    private final C8173a m72178aW(Class<?> cls) {
        AppMethodBeat.m2504i(119188);
        Object obj = (cls.isPrimitive() || cls.isArray()) ? null : 1;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Invalid class: ".concat(String.valueOf(cls)));
            AppMethodBeat.m2505o(119188);
            throw assertionError;
        }
        Class declaringClass = cls.getDeclaringClass();
        C8173a n;
        if (declaringClass == null) {
            n = C8173a.m14427n(new C8174b(cls.getCanonicalName()));
            C25052j.m39375o(n, "ClassId.topLevel(FqName(clazz.canonicalName))");
            AppMethodBeat.m2505o(119188);
            return n;
        }
        n = m72178aW(declaringClass).mo17969p(C37022f.avX(cls.getSimpleName()));
        C25052j.m39375o(n, "classId(outer).createNes…tifier(clazz.simpleName))");
        AppMethodBeat.m2505o(119188);
        return n;
    }

    /* renamed from: a */
    private static C46865e m72171a(C46865e c46865e, Map<C8175c, C8174b> map, String str) {
        AppMethodBeat.m2504i(119189);
        C8174b c8174b = (C8174b) map.get(C8203d.m14486n(c46865e));
        if (c8174b == null) {
            Throwable illegalArgumentException = new IllegalArgumentException("Given class " + c46865e + " is not a " + str + " collection");
            AppMethodBeat.m2505o(119189);
            throw illegalArgumentException;
        }
        C46865e c = C41434a.m72275G(c46865e).mo51611c(c8174b);
        C25052j.m39375o(c, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
        AppMethodBeat.m2505o(119189);
        return c;
    }

    /* renamed from: a */
    private static boolean m72177a(C8175c c8175c, String str) {
        Object obj;
        AppMethodBeat.m2504i(119179);
        String str2 = c8175c.ByV;
        C25052j.m39375o(str2, "kotlinFqName.asString()");
        String aK = C31820v.m51528aK(str2, str, "");
        if (aK.length() > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || C31820v.m51531au(aK)) {
            AppMethodBeat.m2505o(119179);
            return false;
        }
        Integer awy = C0218t.awy(aK);
        if (awy == null || awy.intValue() < 23) {
            AppMethodBeat.m2505o(119179);
            return false;
        }
        AppMethodBeat.m2505o(119179);
        return true;
    }

    /* renamed from: a */
    private static void m72173a(C8173a c8173a, C8173a c8173a2) {
        AppMethodBeat.m2504i(119180);
        Bdl.put(c8173a.ehE().ByQ, c8173a2);
        C8174b ehE = c8173a2.ehE();
        C25052j.m39375o(ehE, "kotlinClassId.asSingleFqName()");
        C41391c.m72174a(ehE, c8173a);
        AppMethodBeat.m2505o(119180);
    }
}
