package p000a.p010i.p011b.p012a.p015c.p037i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.ServiceLoader;
import java.util.Set;
import p000a.C31826o;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36652p;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C31541z;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C31641y;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C36961p;
import p000a.p010i.p011b.p012a.p015c.p037i.C25180e.C25181a;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C25239y;
import p000a.p010i.p011b.p012a.p015c.p045l.C44924t;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C31765d;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C8229c;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C8229c.C0159a;
import p000a.p010i.p011b.p012a.p015c.p048n.C44929i;

/* renamed from: a.i.b.a.c.i.j */
public class C31747j {
    static final /* synthetic */ boolean $assertionsDisabled = (!C31747j.class.desiredAssertionStatus());
    private static final List<C25180e> BEl = C25035t.m39352m(ServiceLoader.load(C25180e.class, C25180e.class.getClassLoader()));
    public static final C31747j BEm = new C31747j(new C251851());
    private final C0159a BEn;

    /* renamed from: a.i.b.a.c.i.j$2 */
    static class C172912 implements C31591m<D, D, C31826o<C8045a, C8045a>> {
        C172912() {
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(121995);
            C31826o c31826o = new C31826o((C8045a) obj, (C8045a) obj2);
            AppMethodBeat.m2505o(121995);
            return c31826o;
        }
    }

    /* renamed from: a.i.b.a.c.i.j$1 */
    static class C251851 implements C0159a {
        C251851() {
        }

        /* renamed from: a */
        public final boolean mo243a(C17313an c17313an, C17313an c17313an2) {
            AppMethodBeat.m2504i(121994);
            boolean equals = c17313an.equals(c17313an2);
            AppMethodBeat.m2505o(121994);
            return equals;
        }
    }

    /* renamed from: a.i.b.a.c.i.j$5 */
    static class C317485 implements C17126b<C25085b, C8045a> {
        C317485() {
        }

        /* renamed from: am */
        public final /* bridge */ /* synthetic */ Object mo50am(Object obj) {
            return (C25085b) obj;
        }
    }

    /* renamed from: a.i.b.a.c.i.j$7 */
    static class C317497 implements C17126b<C25085b, C8045a> {
        C317497() {
        }

        /* renamed from: am */
        public final /* bridge */ /* synthetic */ Object mo50am(Object obj) {
            return (C25085b) obj;
        }
    }

    /* renamed from: a.i.b.a.c.i.j$a */
    public static class C31750a {
        private static final C31750a BEx = new C31750a(C8213a.OVERRIDABLE, "SUCCESS");
        public final C8213a BEy;
        private final String BEz;

        /* renamed from: a.i.b.a.c.i.j$a$a */
        public enum C8213a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT;

            static {
                AppMethodBeat.m2505o(122003);
            }
        }

        static {
            AppMethodBeat.m2504i(122006);
            AppMethodBeat.m2505o(122006);
        }

        public static C31750a ejs() {
            return BEx;
        }

        public static C31750a awg(String str) {
            AppMethodBeat.m2504i(122004);
            C31750a c31750a = new C31750a(C8213a.INCOMPATIBLE, str);
            AppMethodBeat.m2505o(122004);
            return c31750a;
        }

        public static C31750a awh(String str) {
            AppMethodBeat.m2504i(122005);
            C31750a c31750a = new C31750a(C8213a.CONFLICT, str);
            AppMethodBeat.m2505o(122005);
            return c31750a;
        }

        private C31750a(C8213a c8213a, String str) {
            this.BEy = c8213a;
            this.BEz = str;
        }
    }

    static {
        AppMethodBeat.m2504i(122036);
        AppMethodBeat.m2505o(122036);
    }

    /* renamed from: a */
    public static C31747j m51396a(C0159a c0159a) {
        AppMethodBeat.m2504i(122007);
        C31747j c31747j = new C31747j(c0159a);
        AppMethodBeat.m2505o(122007);
        return c31747j;
    }

    private C31747j(C0159a c0159a) {
        this.BEn = c0159a;
    }

    /* renamed from: o */
    private static <D extends C8045a> Set<D> m51419o(Set<D> set) {
        AppMethodBeat.m2504i(122008);
        C172912 c172912 = new C172912();
        if (set.size() <= 1) {
            AppMethodBeat.m2505o(122008);
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object next : set) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                C31826o c31826o = (C31826o) c172912.mo212m(next, it.next());
                C8045a c8045a = (C8045a) c31826o.first;
                C8045a c8045a2 = (C8045a) c31826o.second;
                if (!C31747j.m51413c(c8045a, c8045a2)) {
                    if (C31747j.m51413c(c8045a2, c8045a)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
            linkedHashSet.add(next);
        }
        if ($assertionsDisabled || !linkedHashSet.isEmpty()) {
            AppMethodBeat.m2505o(122008);
            return linkedHashSet;
        }
        AssertionError assertionError = new AssertionError("All candidates filtered out from ".concat(String.valueOf(set)));
        AppMethodBeat.m2505o(122008);
        throw assertionError;
    }

    /* renamed from: c */
    private static <D extends C8045a> boolean m51413c(D d, D d2) {
        AppMethodBeat.m2504i(122009);
        if (d.equals(d2) || !C44906b.BDK.mo72105d(d.dYU(), d2.dYU())) {
            C8045a dYU = d2.dYU();
            for (C8045a d3 : C8203d.m14482d(d)) {
                if (C44906b.BDK.mo72105d(dYU, d3)) {
                    AppMethodBeat.m2505o(122009);
                    return true;
                }
            }
            AppMethodBeat.m2505o(122009);
            return false;
        }
        AppMethodBeat.m2505o(122009);
        return true;
    }

    /* renamed from: w */
    private static Set<C25085b> m51421w(C25085b c25085b) {
        AppMethodBeat.m2504i(122010);
        Set linkedHashSet = new LinkedHashSet();
        C31747j.m51403a(c25085b, linkedHashSet);
        AppMethodBeat.m2505o(122010);
        return linkedHashSet;
    }

    /* renamed from: a */
    private static void m51403a(C25085b c25085b, Set<C25085b> set) {
        AppMethodBeat.m2504i(122011);
        if (c25085b.dYZ().dZa()) {
            set.add(c25085b);
            AppMethodBeat.m2505o(122011);
        } else if (c25085b.dYX().isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("No overridden descriptors found for (fake override) ".concat(String.valueOf(c25085b)));
            AppMethodBeat.m2505o(122011);
            throw illegalStateException;
        } else {
            for (C25085b a : c25085b.dYX()) {
                C31747j.m51403a(a, (Set) set);
            }
            AppMethodBeat.m2505o(122011);
        }
    }

    /* renamed from: b */
    private C31750a m51412b(C8045a c8045a, C8045a c8045a2, C46865e c46865e) {
        AppMethodBeat.m2504i(122012);
        C31750a a = mo51743a(c8045a, c8045a2, c46865e, false);
        AppMethodBeat.m2505o(122012);
        return a;
    }

    /* renamed from: a */
    public final C31750a mo51743a(C8045a c8045a, C8045a c8045a2, C46865e c46865e, boolean z) {
        C31750a awh;
        AppMethodBeat.m2504i(122013);
        C31750a a = mo51744a(c8045a, c8045a2, z);
        Object obj = a.BEy == C8213a.OVERRIDABLE ? 1 : null;
        Object obj2 = obj;
        for (C25180e c25180e : BEl) {
            if (c25180e.eaX() != C25181a.CONFLICTS_ONLY && (obj2 == null || c25180e.eaX() != C25181a.SUCCESS_ONLY)) {
                switch (c25180e.mo42047a(c8045a, c8045a2, c46865e)) {
                    case OVERRIDABLE:
                        obj2 = 1;
                        break;
                    case CONFLICT:
                        awh = C31750a.awh("External condition failed");
                        AppMethodBeat.m2505o(122013);
                        return awh;
                    case INCOMPATIBLE:
                        awh = C31750a.awg("External condition");
                        AppMethodBeat.m2505o(122013);
                        return awh;
                    default:
                        break;
                }
            }
        }
        if (obj2 == null) {
            AppMethodBeat.m2505o(122013);
            return a;
        }
        for (C25180e c25180e2 : BEl) {
            if (c25180e2.eaX() == C25181a.CONFLICTS_ONLY) {
                switch (c25180e2.mo42047a(c8045a, c8045a2, c46865e)) {
                    case OVERRIDABLE:
                        IllegalStateException illegalStateException = new IllegalStateException("Contract violation in " + c25180e2.getClass().getName() + " condition. It's not supposed to end with success");
                        AppMethodBeat.m2505o(122013);
                        throw illegalStateException;
                    case CONFLICT:
                        awh = C31750a.awh("External condition failed");
                        AppMethodBeat.m2505o(122013);
                        return awh;
                    case INCOMPATIBLE:
                        awh = C31750a.awg("External condition");
                        AppMethodBeat.m2505o(122013);
                        return awh;
                    default:
                        break;
                }
            }
        }
        awh = C31750a.ejs();
        AppMethodBeat.m2505o(122013);
        return awh;
    }

    /* renamed from: a */
    public final C31750a mo51744a(C8045a c8045a, C8045a c8045a2, boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(122014);
        C31750a d = C31747j.m51414d(c8045a, c8045a2);
        if (d != null) {
            AppMethodBeat.m2505o(122014);
            return d;
        }
        List e = C31747j.m51416e(c8045a);
        List e2 = C31747j.m51416e(c8045a2);
        List dYS = c8045a.dYS();
        List dYS2 = c8045a2.dYS();
        if (dYS.size() != dYS2.size()) {
            while (i < e.size()) {
                if (C8229c.BKs.mo18025d((C46867w) e.get(i), (C46867w) e2.get(i))) {
                    i++;
                } else {
                    d = C31750a.awg("Type parameter number mismatch");
                    AppMethodBeat.m2505o(122014);
                    return d;
                }
            }
            d = C31750a.awh("Type parameter number mismatch");
            AppMethodBeat.m2505o(122014);
            return d;
        }
        C8229c u = m51420u(dYS, dYS2);
        int i2 = 0;
        while (i2 < dYS.size()) {
            if (C31747j.m51409a((C36955ar) dYS.get(i2), (C36955ar) dYS2.get(i2), u)) {
                i2++;
            } else {
                d = C31750a.awg("Type parameter bounds mismatch");
                AppMethodBeat.m2505o(122014);
                return d;
            }
        }
        i2 = 0;
        while (i2 < e.size()) {
            if (C31747j.m51411a((C46867w) e.get(i2), (C46867w) e2.get(i2), u)) {
                i2++;
            } else {
                d = C31750a.awg("Value parameter type mismatch");
                AppMethodBeat.m2505o(122014);
                return d;
            }
        }
        if ((c8045a instanceof C8083t) && (c8045a2 instanceof C8083t) && ((C8083t) c8045a).dZv() != ((C8083t) c8045a2).dZv()) {
            d = C31750a.awh("Incompatible suspendability");
            AppMethodBeat.m2505o(122014);
            return d;
        }
        if (z) {
            C46867w dYT = c8045a.dYT();
            C46867w dYT2 = c8045a2.dYT();
            if (!(dYT == null || dYT2 == null)) {
                if (C25239y.m39807an(dYT2) && C25239y.m39807an(dYT)) {
                    i = 1;
                }
                if (i == 0 && !u.mo18024c(dYT2, dYT)) {
                    d = C31750a.awh("Return type mismatch");
                    AppMethodBeat.m2505o(122014);
                    return d;
                }
            }
        }
        d = C31750a.ejs();
        AppMethodBeat.m2505o(122014);
        return d;
    }

    /* renamed from: d */
    private static C31750a m51414d(C8045a c8045a, C8045a c8045a2) {
        AppMethodBeat.m2504i(122015);
        C31750a awg;
        if (((c8045a instanceof C8083t) && !(c8045a2 instanceof C8083t)) || ((c8045a instanceof C31220ah) && !(c8045a2 instanceof C31220ah))) {
            awg = C31750a.awg("Member kind mismatch");
            AppMethodBeat.m2505o(122015);
            return awg;
        } else if (!(c8045a instanceof C8083t) && !(c8045a instanceof C31220ah)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: ".concat(String.valueOf(c8045a)));
            AppMethodBeat.m2505o(122015);
            throw illegalArgumentException;
        } else if (c8045a.dZg().equals(c8045a2.dZg())) {
            awg = C31747j.m51415e(c8045a, c8045a2);
            if (awg != null) {
                AppMethodBeat.m2505o(122015);
                return awg;
            }
            AppMethodBeat.m2505o(122015);
            return null;
        } else {
            awg = C31750a.awg("Name mismatch");
            AppMethodBeat.m2505o(122015);
            return awg;
        }
    }

    /* renamed from: u */
    private C8229c m51420u(List<C36955ar> list, List<C36955ar> list2) {
        AppMethodBeat.m2504i(122016);
        C8229c b;
        if (!$assertionsDisabled && list.size() != list2.size()) {
            AssertionError assertionError = new AssertionError("Should be the same number of type parameters: " + list + " vs " + list2);
            AppMethodBeat.m2505o(122016);
            throw assertionError;
        } else if (list.isEmpty()) {
            b = C31765d.m51443b(this.BEn);
            AppMethodBeat.m2505o(122016);
            return b;
        } else {
            final HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    hashMap.put(((C36955ar) list.get(i2)).dXY(), ((C36955ar) list2.get(i2)).dXY());
                    i = i2 + 1;
                } else {
                    b = C31765d.m51443b(new C0159a() {
                        /* renamed from: a */
                        public final boolean mo243a(C17313an c17313an, C17313an c17313an2) {
                            AppMethodBeat.m2504i(121996);
                            if (C31747j.this.BEn.mo243a(c17313an, c17313an2)) {
                                AppMethodBeat.m2505o(121996);
                                return true;
                            }
                            C17313an c17313an3 = (C17313an) hashMap.get(c17313an);
                            C17313an c17313an4 = (C17313an) hashMap.get(c17313an2);
                            if ((c17313an3 == null || !c17313an3.equals(c17313an2)) && (c17313an4 == null || !c17313an4.equals(c17313an))) {
                                AppMethodBeat.m2505o(121996);
                                return false;
                            }
                            AppMethodBeat.m2505o(121996);
                            return true;
                        }
                    });
                    AppMethodBeat.m2505o(122016);
                    return b;
                }
            }
        }
    }

    /* renamed from: e */
    private static C31750a m51415e(C8045a c8045a, C8045a c8045a2) {
        Object obj = 1;
        AppMethodBeat.m2504i(122017);
        Object obj2 = c8045a.dYQ() == null ? 1 : null;
        if (c8045a2.dYQ() != null) {
            obj = null;
        }
        C31750a awg;
        if (obj2 != obj) {
            awg = C31750a.awg("Receiver presence mismatch");
            AppMethodBeat.m2505o(122017);
            return awg;
        } else if (c8045a.dYV().size() != c8045a2.dYV().size()) {
            awg = C31750a.awg("Value parameter number mismatch");
            AppMethodBeat.m2505o(122017);
            return awg;
        } else {
            AppMethodBeat.m2505o(122017);
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m51411a(C46867w c46867w, C46867w c46867w2, C8229c c8229c) {
        boolean z;
        AppMethodBeat.m2504i(122018);
        if (C25239y.m39807an(c46867w) && C25239y.m39807an(c46867w2)) {
            z = true;
        } else {
            z = false;
        }
        if (z || c8229c.mo18025d(c46867w, c46867w2)) {
            AppMethodBeat.m2505o(122018);
            return true;
        }
        AppMethodBeat.m2505o(122018);
        return false;
    }

    /* renamed from: a */
    private static boolean m51409a(C36955ar c36955ar, C36955ar c36955ar2, C8229c c8229c) {
        AppMethodBeat.m2504i(122019);
        List<C46867w> dWP = c36955ar.dWP();
        ArrayList arrayList = new ArrayList(c36955ar2.dWP());
        if (dWP.size() != arrayList.size()) {
            AppMethodBeat.m2505o(122019);
            return false;
        }
        for (C46867w c46867w : dWP) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (C31747j.m51411a(c46867w, (C46867w) listIterator.next(), c8229c)) {
                    listIterator.remove();
                }
            }
            AppMethodBeat.m2505o(122019);
            return false;
        }
        AppMethodBeat.m2505o(122019);
        return true;
    }

    /* renamed from: e */
    private static List<C46867w> m51416e(C8045a c8045a) {
        AppMethodBeat.m2504i(122020);
        C41396ak dYQ = c8045a.dYQ();
        ArrayList arrayList = new ArrayList();
        if (dYQ != null) {
            arrayList.add(dYQ.dZS());
        }
        for (C41399au dZS : c8045a.dYV()) {
            arrayList.add(dZS.dZS());
        }
        AppMethodBeat.m2505o(122020);
        return arrayList;
    }

    /* renamed from: a */
    public static void m51406a(Collection<? extends C25085b> collection, Collection<? extends C25085b> collection2, C46865e c46865e, C44909i c44909i) {
        AppMethodBeat.m2504i(122021);
        Collection linkedHashSet = new LinkedHashSet(collection);
        for (C25085b a : collection2) {
            linkedHashSet.removeAll(C31747j.m51399a(a, (Collection) collection, c46865e, c44909i));
        }
        C31747j.m51404a(c46865e, linkedHashSet, c44909i);
        AppMethodBeat.m2505o(122021);
    }

    /* renamed from: a */
    private static Collection<C25085b> m51399a(C25085b c25085b, Collection<? extends C25085b> collection, C46865e c46865e, C44909i c44909i) {
        AppMethodBeat.m2504i(122022);
        ArrayList arrayList = new ArrayList(collection.size());
        C44929i ekD = C44929i.ekD();
        for (C36652p c36652p : collection) {
            Object obj;
            C8213a c8213a = BEm.m51412b(c36652p, c25085b, c46865e).BEy;
            if (C8051ay.m14226b(c36652p.dYf()) || !C8051ay.m14224a(c36652p, (C31642l) c25085b)) {
                obj = null;
            } else {
                obj = 1;
            }
            switch (c8213a) {
                case OVERRIDABLE:
                    if (obj != null) {
                        ekD.add(c36652p);
                    }
                    arrayList.add(c36652p);
                    break;
                case CONFLICT:
                    if (obj != null) {
                        c44909i.mo59080b(c36652p, c25085b);
                    }
                    arrayList.add(c36652p);
                    break;
                default:
                    break;
            }
        }
        c44909i.mo31270a(c25085b, ekD);
        AppMethodBeat.m2505o(122022);
        return arrayList;
    }

    /* renamed from: f */
    public static boolean m51417f(C8045a c8045a, C8045a c8045a2) {
        AppMethodBeat.m2504i(122024);
        C46867w dYT = c8045a.dYT();
        C46867w dYT2 = c8045a2.dYT();
        AssertionError assertionError;
        boolean a;
        if (!$assertionsDisabled && dYT == null) {
            assertionError = new AssertionError("Return type of " + c8045a + " is null");
            AppMethodBeat.m2505o(122024);
            throw assertionError;
        } else if (!$assertionsDisabled && dYT2 == null) {
            assertionError = new AssertionError("Return type of " + c8045a2 + " is null");
            AppMethodBeat.m2505o(122024);
            throw assertionError;
        } else if (!C31747j.m51410a((C36652p) c8045a, (C36652p) c8045a2)) {
            AppMethodBeat.m2505o(122024);
            return false;
        } else if (c8045a instanceof C8083t) {
            if ($assertionsDisabled || (c8045a2 instanceof C8083t)) {
                a = C31747j.m51407a(c8045a, dYT, c8045a2, dYT2);
                AppMethodBeat.m2505o(122024);
                return a;
            }
            assertionError = new AssertionError("b is " + c8045a2.getClass());
            AppMethodBeat.m2505o(122024);
            throw assertionError;
        } else if (!(c8045a instanceof C31220ah)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected callable: " + c8045a.getClass());
            AppMethodBeat.m2505o(122024);
            throw illegalArgumentException;
        } else if ($assertionsDisabled || (c8045a2 instanceof C31220ah)) {
            boolean z;
            C31220ah c31220ah = (C31220ah) c8045a;
            C31220ah c31220ah2 = (C31220ah) c8045a2;
            C36652p dZJ = c31220ah.dZJ();
            C36652p dZJ2 = c31220ah2.dZJ();
            if (dZJ == null || dZJ2 == null) {
                z = true;
            } else {
                z = C31747j.m51410a(dZJ, dZJ2);
            }
            if (!z) {
                AppMethodBeat.m2505o(122024);
                return false;
            } else if (c31220ah.dZZ() && c31220ah2.dZZ()) {
                a = BEm.m51420u(c8045a.dYS(), c8045a2.dYS()).mo18025d(dYT, dYT2);
                AppMethodBeat.m2505o(122024);
                return a;
            } else if ((c31220ah.dZZ() || !c31220ah2.dZZ()) && C31747j.m51407a(c8045a, dYT, c8045a2, dYT2)) {
                AppMethodBeat.m2505o(122024);
                return true;
            } else {
                AppMethodBeat.m2505o(122024);
                return false;
            }
        } else {
            assertionError = new AssertionError("b is " + c8045a2.getClass());
            AppMethodBeat.m2505o(122024);
            throw assertionError;
        }
    }

    /* renamed from: a */
    private static boolean m51410a(C36652p c36652p, C36652p c36652p2) {
        AppMethodBeat.m2504i(122025);
        Integer b = C8051ay.m14225b(c36652p.dYf(), c36652p2.dYf());
        if (b == null || b.intValue() >= 0) {
            AppMethodBeat.m2505o(122025);
            return true;
        }
        AppMethodBeat.m2505o(122025);
        return false;
    }

    /* renamed from: a */
    private static boolean m51408a(C8045a c8045a, Collection<C8045a> collection) {
        AppMethodBeat.m2504i(122026);
        for (C8045a f : collection) {
            if (!C31747j.m51417f(c8045a, f)) {
                AppMethodBeat.m2505o(122026);
                return false;
            }
        }
        AppMethodBeat.m2505o(122026);
        return true;
    }

    /* renamed from: a */
    private static boolean m51407a(C8045a c8045a, C46867w c46867w, C8045a c8045a2, C46867w c46867w2) {
        AppMethodBeat.m2504i(122027);
        boolean c = BEm.m51420u(c8045a.dYS(), c8045a2.dYS()).mo18024c(c46867w, c46867w2);
        AppMethodBeat.m2505o(122027);
        return c;
    }

    /* renamed from: a */
    public static <H> H m51398a(Collection<H> collection, C17126b<H, C8045a> c17126b) {
        AppMethodBeat.m2504i(122028);
        if (!$assertionsDisabled && collection.isEmpty()) {
            AssertionError assertionError = new AssertionError("Should have at least one overridable descriptor");
            AppMethodBeat.m2505o(122028);
            throw assertionError;
        } else if (collection.size() == 1) {
            Object e = C25035t.m39335e(collection);
            AppMethodBeat.m2505o(122028);
            return e;
        } else {
            H h;
            ArrayList arrayList = new ArrayList(2);
            Collection c = C25035t.m39332c((Iterable) collection, (C17126b) c17126b);
            H e2 = C25035t.m39335e(collection);
            C8045a c8045a = (C8045a) c17126b.mo50am(e2);
            Iterator it = collection.iterator();
            while (true) {
                h = e2;
                if (!it.hasNext()) {
                    break;
                }
                H next = it.next();
                C8045a c8045a2 = (C8045a) c17126b.mo50am(next);
                if (C31747j.m51408a(c8045a2, c)) {
                    arrayList.add(next);
                }
                if (!C31747j.m51417f(c8045a2, c8045a) || C31747j.m51417f(c8045a, c8045a2)) {
                    e2 = h;
                } else {
                    e2 = next;
                }
            }
            if (arrayList.isEmpty()) {
                AppMethodBeat.m2505o(122028);
                return h;
            } else if (arrayList.size() == 1) {
                h = C25035t.m39335e(arrayList);
                AppMethodBeat.m2505o(122028);
                return h;
            } else {
                for (H h2 : arrayList) {
                    if (!C44924t.m82160ai(((C8045a) c17126b.mo50am(h2)).dYT())) {
                        break;
                    }
                }
                h2 = null;
                if (h2 != null) {
                    AppMethodBeat.m2505o(122028);
                    return h2;
                }
                h2 = C25035t.m39335e(arrayList);
                AppMethodBeat.m2505o(122028);
                return h2;
            }
        }
    }

    /* renamed from: a */
    private static void m51405a(Collection<C25085b> collection, C46865e c46865e, C44909i c44909i) {
        Collection collection2;
        AppMethodBeat.m2504i(122029);
        Collection a = C31747j.m51400a(c46865e, (Collection) collection2);
        boolean isEmpty = a.isEmpty();
        if (!isEmpty) {
            collection2 = a;
        }
        C25085b a2 = ((C25085b) C31747j.m51398a(collection2, new C317485())).mo17863a(c46865e, C31747j.m51394a(collection2, c46865e), isEmpty ? C8051ay.Bfd : C8051ay.Bfc, C8063a.FAKE_OVERRIDE);
        c44909i.mo31270a(a2, collection2);
        if ($assertionsDisabled || !a2.dYX().isEmpty()) {
            c44909i.mo232g(a2);
            AppMethodBeat.m2505o(122029);
            return;
        }
        AssertionError assertionError = new AssertionError("Overridden descriptors should be set for " + C8063a.FAKE_OVERRIDE);
        AppMethodBeat.m2505o(122029);
        throw assertionError;
    }

    /* renamed from: a */
    private static C44879w m51394a(Collection<C25085b> collection, C46865e c46865e) {
        C44879w c44879w;
        boolean z = true;
        AppMethodBeat.m2504i(122030);
        boolean z2 = false;
        boolean z3 = false;
        for (C25085b c25085b : collection) {
            boolean z4;
            switch (c25085b.dYd()) {
                case FINAL:
                    c44879w = C44879w.FINAL;
                    AppMethodBeat.m2505o(122030);
                    return c44879w;
                case SEALED:
                    IllegalStateException illegalStateException = new IllegalStateException("Member cannot have SEALED modality: ".concat(String.valueOf(c25085b)));
                    AppMethodBeat.m2505o(122030);
                    throw illegalStateException;
                case OPEN:
                    z3 = true;
                    continue;
                case ABSTRACT:
                    z4 = true;
                    break;
                default:
                    z4 = z2;
                    break;
            }
            z2 = z4;
        }
        if (!c46865e.dYk() || c46865e.dYd() == C44879w.ABSTRACT || c46865e.dYd() == C44879w.SEALED) {
            z = false;
        }
        if (z3 && !z2) {
            c44879w = C44879w.OPEN;
            AppMethodBeat.m2505o(122030);
            return c44879w;
        } else if (z3 || !z2) {
            HashSet hashSet = new HashSet();
            for (C25085b c25085b2 : collection) {
                hashSet.addAll(C31747j.m51421w(c25085b2));
            }
            c44879w = C31747j.m51395a(C31747j.m51419o(hashSet), z, c46865e.dYd());
            AppMethodBeat.m2505o(122030);
            return c44879w;
        } else if (z) {
            c44879w = c46865e.dYd();
            AppMethodBeat.m2505o(122030);
            return c44879w;
        } else {
            c44879w = C44879w.ABSTRACT;
            AppMethodBeat.m2505o(122030);
            return c44879w;
        }
    }

    /* renamed from: a */
    private static C44879w m51395a(Collection<C25085b> collection, boolean z, C44879w c44879w) {
        AppMethodBeat.m2504i(122031);
        Enum enumR = C44879w.ABSTRACT;
        Iterator it = collection.iterator();
        while (true) {
            Enum enumR2 = enumR;
            if (it.hasNext()) {
                C25085b c25085b = (C25085b) it.next();
                enumR = (z && c25085b.dYd() == C44879w.ABSTRACT) ? c44879w : c25085b.dYd();
                if (enumR.compareTo(enumR2) >= 0) {
                    enumR = enumR2;
                }
            } else {
                AppMethodBeat.m2505o(122031);
                return enumR2;
            }
        }
    }

    /* renamed from: a */
    private static Collection<C25085b> m51400a(final C46865e c46865e, Collection<C25085b> collection) {
        AppMethodBeat.m2504i(122032);
        List b = C25035t.m39330b((Iterable) collection, (C17126b) new C17126b<C25085b, Boolean>() {
            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                boolean z;
                AppMethodBeat.m2504i(121998);
                C36652p c36652p = (C25085b) obj;
                if (C8051ay.m14226b(c36652p.dYf()) || !C8051ay.m14224a(c36652p, c46865e)) {
                    z = false;
                } else {
                    z = true;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.m2505o(121998);
                return valueOf;
            }
        });
        AppMethodBeat.m2505o(122032);
        return b;
    }

    /* renamed from: a */
    public static <H> Collection<H> m51401a(H h, Collection<H> collection, C17126b<H, C8045a> c17126b, C17126b<H, C37091y> c17126b2) {
        AppMethodBeat.m2504i(122033);
        ArrayList arrayList = new ArrayList();
        arrayList.add(h);
        C8045a c8045a = (C8045a) c17126b.mo50am(h);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            C8045a c8045a2 = (C8045a) c17126b.mo50am(next);
            if (h == next) {
                it.remove();
            } else {
                C8213a g = C31747j.m51418g(c8045a, c8045a2);
                if (g == C8213a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (g == C8213a.CONFLICT) {
                    c17126b2.mo50am(next);
                    it.remove();
                }
            }
        }
        AppMethodBeat.m2505o(122033);
        return arrayList;
    }

    /* renamed from: g */
    public static C8213a m51418g(C8045a c8045a, C8045a c8045a2) {
        AppMethodBeat.m2504i(122034);
        C8213a c8213a = BEm.m51412b(c8045a2, c8045a, null).BEy;
        C8213a c8213a2 = BEm.m51412b(c8045a, c8045a2, null).BEy;
        if (c8213a == C8213a.OVERRIDABLE && c8213a2 == C8213a.OVERRIDABLE) {
            c8213a = C8213a.OVERRIDABLE;
            AppMethodBeat.m2505o(122034);
            return c8213a;
        } else if (c8213a == C8213a.CONFLICT || c8213a2 == C8213a.CONFLICT) {
            c8213a = C8213a.CONFLICT;
            AppMethodBeat.m2505o(122034);
            return c8213a;
        } else {
            c8213a = C8213a.INCOMPATIBLE;
            AppMethodBeat.m2505o(122034);
            return c8213a;
        }
    }

    /* renamed from: a */
    public static void m51402a(C25085b c25085b, C17126b<C25085b, C37091y> c17126b) {
        AppMethodBeat.m2504i(122035);
        for (C25085b c25085b2 : c25085b.dYX()) {
            if (c25085b2.dYf() == C8051ay.Bfc) {
                C31747j.m51402a(c25085b2, (C17126b) c17126b);
            }
        }
        if (c25085b.dYf() != C8051ay.Bfc) {
            AppMethodBeat.m2505o(122035);
            return;
        }
        C25082az c25082az;
        C25082az c25082az2;
        Collection<C25085b> dYX = c25085b.dYX();
        if (dYX.isEmpty()) {
            c25082az = C8051ay.Bfh;
        } else {
            Integer b;
            c25082az2 = null;
            for (C25085b c25085b22 : dYX) {
                c25082az = c25085b22.dYf();
                if (!$assertionsDisabled && c25082az == C8051ay.Bfc) {
                    AssertionError assertionError = new AssertionError("Visibility should have been computed for ".concat(String.valueOf(c25085b22)));
                    AppMethodBeat.m2505o(122035);
                    throw assertionError;
                } else if (c25082az2 == null) {
                    c25082az2 = c25082az;
                } else {
                    b = C8051ay.m14225b(c25082az, c25082az2);
                    if (b == null) {
                        c25082az2 = null;
                    } else {
                        C25082az c25082az3;
                        if (b.intValue() > 0) {
                            c25082az3 = c25082az;
                        } else {
                            c25082az3 = c25082az2;
                        }
                        c25082az2 = c25082az3;
                    }
                }
            }
            if (c25082az2 == null) {
                c25082az = null;
            } else {
                for (C25085b c25085b222 : dYX) {
                    b = C8051ay.m14225b(c25082az2, c25085b222.dYf());
                    if (b != null) {
                        if (b.intValue() < 0) {
                        }
                    }
                    c25082az = null;
                }
                c25082az = c25082az2;
            }
        }
        if (c25082az == null) {
            c25082az = null;
        } else if (c25085b.dYZ() == C8063a.FAKE_OVERRIDE) {
            for (C25085b c25085b2222 : dYX) {
                if (c25085b2222.dYd() != C44879w.ABSTRACT && !c25085b2222.dYf().equals(c25082az)) {
                    c25082az = null;
                    break;
                }
            }
        } else {
            c25082az = c25082az.eag();
        }
        if (c25082az == null) {
            if (c17126b != null) {
                c17126b.mo50am(c25085b);
            }
            c25082az2 = C8051ay.Bfa;
        } else {
            c25082az2 = c25082az;
        }
        if (c25085b instanceof C31541z) {
            ((C31541z) c25085b).BhQ = c25082az2;
            for (C25085b c25085b22222 : ((C31220ah) c25085b).dZK()) {
                C17126b c17126b2;
                if (c25082az == null) {
                    c17126b2 = null;
                } else {
                    C17126b<C25085b, C37091y> c17126b22 = c17126b;
                }
                C31747j.m51402a(c25085b22222, c17126b22);
            }
            AppMethodBeat.m2505o(122035);
        } else if (c25085b instanceof C36961p) {
            ((C36961p) c25085b).BhQ = c25082az2;
            AppMethodBeat.m2505o(122035);
        } else if ($assertionsDisabled || (c25085b instanceof C31641y)) {
            C31641y c31641y = (C31641y) c25085b;
            c31641y.BhQ = c25082az2;
            if (c25082az2 != c31641y.BhL.dYf()) {
                c31641y.isDefault = false;
            }
            AppMethodBeat.m2505o(122035);
        } else {
            AssertionError assertionError2 = new AssertionError();
            AppMethodBeat.m2505o(122035);
            throw assertionError2;
        }
    }

    /* renamed from: a */
    private static void m51404a(C46865e c46865e, Collection<C25085b> collection, final C44909i c44909i) {
        Object obj;
        AppMethodBeat.m2504i(122023);
        if (collection.size() >= 2) {
            final C31642l dXW = ((C25085b) collection.iterator().next()).dXW();
            C251864 c251864 = new C17126b<C25085b, Boolean>() {
                /* renamed from: am */
                public final /* synthetic */ Object mo50am(Object obj) {
                    boolean z;
                    AppMethodBeat.m2504i(121997);
                    if (((C25085b) obj).dXW() == dXW) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.m2505o(121997);
                    return valueOf;
                }
            };
            C25052j.m39376p(collection, "receiver$0");
            C25052j.m39376p(c251864, "predicate");
            if (!collection.isEmpty()) {
                for (Object obj2 : collection) {
                    if (!((Boolean) c251864.mo50am(obj2)).booleanValue()) {
                        obj2 = null;
                        break;
                    }
                }
            }
        }
        obj2 = 1;
        if (obj2 != null) {
            for (C25085b singleton : collection) {
                C31747j.m51405a(Collections.singleton(singleton), c46865e, c44909i);
            }
            AppMethodBeat.m2505o(122023);
            return;
        }
        Collection linkedList = new LinkedList(collection);
        while (!linkedList.isEmpty()) {
            final Object n = C8214l.m14516n(linkedList);
            C31747j.m51405a(C31747j.m51401a(n, linkedList, new C317497(), new C17126b<C25085b, C37091y>() {
                /* renamed from: am */
                public final /* synthetic */ Object mo50am(Object obj) {
                    AppMethodBeat.m2504i(121999);
                    c44909i.mo59081c(n, (C25085b) obj);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(121999);
                    return c37091y;
                }
            }), c46865e, c44909i);
        }
        AppMethodBeat.m2505o(122023);
    }
}
