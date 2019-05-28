package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p000a.C44847aa;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C24623g;
import p000a.p010i.p011b.p012a.p015c.p045l.C24623g.C17322a;
import p000a.p010i.p011b.p012a.p015c.p045l.C37059v;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C44924t;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.l.a.s */
public final class C25215s {
    public static final C25215s BLd = new C25215s();

    /* renamed from: a.i.b.a.c.l.a.s$a */
    enum C25216a {
        ;

        /* renamed from: a.i.b.a.c.l.a.s$a$a */
        static final class C25217a extends C25216a {
            C25217a(String str) {
                super(str, 1);
            }

            /* renamed from: f */
            public final C25216a mo42073f(C41447az c41447az) {
                AppMethodBeat.m2504i(122802);
                C25052j.m39376p(c41447az, "nextType");
                C25216a g = C25216a.m39743g(c41447az);
                AppMethodBeat.m2505o(122802);
                return g;
            }
        }

        /* renamed from: a.i.b.a.c.l.a.s$a$d */
        static final class C25218d extends C25216a {
            C25218d(String str) {
                super(str, 2);
            }

            /* renamed from: f */
            public final C25216a mo42073f(C41447az c41447az) {
                AppMethodBeat.m2504i(122805);
                C25052j.m39376p(c41447az, "nextType");
                C25216a g = C25216a.m39743g(c41447az);
                if (g == C25216a.BLf) {
                    C25216a c25216a = this;
                    AppMethodBeat.m2505o(122805);
                    return c25216a;
                }
                AppMethodBeat.m2505o(122805);
                return g;
            }
        }

        /* renamed from: a.i.b.a.c.l.a.s$a$b */
        static final class C25219b extends C25216a {
            C25219b(String str) {
                super(str, 3);
            }

            /* renamed from: f */
            public final /* synthetic */ C25216a mo42073f(C41447az c41447az) {
                AppMethodBeat.m2504i(122803);
                C25052j.m39376p(c41447az, "nextType");
                C25216a c25216a = this;
                AppMethodBeat.m2505o(122803);
                return c25216a;
            }
        }

        /* renamed from: a.i.b.a.c.l.a.s$a$c */
        static final class C25220c extends C25216a {
            C25220c(String str) {
                super(str, 0);
            }

            /* renamed from: f */
            public final C25216a mo42073f(C41447az c41447az) {
                AppMethodBeat.m2504i(122804);
                C25052j.m39376p(c41447az, "nextType");
                C25216a g = C25216a.m39743g(c41447az);
                AppMethodBeat.m2505o(122804);
                return g;
            }
        }

        /* renamed from: f */
        public abstract C25216a mo42073f(C41447az c41447az);

        /* renamed from: g */
        protected static C25216a m39743g(C41447az c41447az) {
            C25052j.m39376p(c41447az, "receiver$0");
            if (c41447az.eci()) {
                return BLf;
            }
            C8232l c8232l = C8232l.BKB;
            if (C8232l.m14541d(c41447az)) {
                return BLh;
            }
            return BLg;
        }
    }

    static {
        AppMethodBeat.m2504i(122808);
        AppMethodBeat.m2505o(122808);
    }

    private C25215s() {
    }

    /* renamed from: gc */
    public static C8235ad m39741gc(List<? extends C8235ad> list) {
        AppMethodBeat.m2504i(122806);
        C25052j.m39376p(list, "types");
        boolean z = list.size() > 1;
        if (!C44847aa.AUz || z) {
            Collection eap;
            ArrayList<C8235ad> arrayList = new ArrayList();
            for (C8235ad c8235ad : list) {
                if (c8235ad.ejw() instanceof C37059v) {
                    eap = c8235ad.ejw().eap();
                    C25052j.m39375o(eap, "type.constructor.supertypes");
                    Iterable<C46867w> iterable = eap;
                    Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable));
                    for (C46867w c46867w : iterable) {
                        C25052j.m39375o(c46867w, "it");
                        Object al = C44924t.m82163al(c46867w);
                        if (c8235ad.eci()) {
                            al = al.mo18033rL(true);
                        }
                        arrayList2.add(al);
                    }
                    arrayList.addAll((List) arrayList2);
                } else {
                    arrayList.add(c8235ad);
                }
            }
            Iterable<C41447az> iterable2 = arrayList;
            C25216a c25216a = C25216a.BLe;
            C25216a c25216a2 = c25216a;
            for (C41447az f : iterable2) {
                c25216a2 = c25216a2.mo42073f(f);
            }
            eap = new LinkedHashSet();
            for (C8235ad c8235ad2 : arrayList) {
                Object obj;
                if (c25216a2 == C25216a.BLh) {
                    C25052j.m39376p(c8235ad2, "receiver$0");
                    C17322a c17322a = C24623g.BJi;
                    C24623g a = C17322a.m26830a(c8235ad2);
                    obj = a != null ? a : c8235ad2.mo18033rL(false);
                } else {
                    C8235ad obj2 = c8235ad2;
                }
                eap.add(obj2);
            }
            C8235ad p = C25215s.m39742p((LinkedHashSet) eap);
            AppMethodBeat.m2505o(122806);
            return p;
        }
        Throwable assertionError = new AssertionError("Size should be at least 2, but it is " + list.size());
        AppMethodBeat.m2505o(122806);
        throw assertionError;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: p */
    private static C8235ad m39742p(Set<? extends C8235ad> set) {
        AppMethodBeat.m2504i(122807);
        C8235ad c8235ad;
        if (set.size() == 1) {
            c8235ad = (C8235ad) C25035t.m39345h((Iterable) set);
            AppMethodBeat.m2505o(122807);
            return c8235ad;
        }
        int i;
        ArrayList arrayList = new ArrayList(set);
        Iterator it = arrayList.iterator();
        C25052j.m39375o(it, "filteredSuperAndEqualTypes.iterator()");
        while (it.hasNext()) {
            c8235ad = (C8235ad) it.next();
            Iterable<C8235ad> iterable = arrayList;
            if (!((Collection) iterable).isEmpty()) {
                for (C8235ad c8235ad2 : iterable) {
                    int i2;
                    if (c8235ad2 != c8235ad) {
                        int i3;
                        C25052j.m39375o(c8235ad2, "lower");
                        C46867w c46867w = c8235ad2;
                        C25052j.m39375o(c8235ad, "upper");
                        C46867w c46867w2 = c8235ad;
                        C31769h c31769h = C31769h.BKA;
                        if (!c31769h.mo18024c(c46867w, c46867w2) || c31769h.mo18024c(c46867w2, c46867w)) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        if (i3 != 0 || C31769h.BKA.mo18025d(c8235ad2, c8235ad)) {
                            i2 = 1;
                            continue;
                            if (i2 != 0) {
                                i = 1;
                                break;
                            }
                        }
                    }
                    i2 = 0;
                    continue;
                    if (i2 != 0) {
                    }
                }
            }
            i = 0;
            if (i != 0) {
                it.remove();
            }
        }
        i = !((Collection) arrayList).isEmpty() ? 1 : 0;
        if (C44847aa.AUz && i == 0) {
            Throwable assertionError = new AssertionError("This collections cannot be empty! input types: " + C25035t.m39322a((Iterable) set, null, null, null, 0, null, null, 63));
            AppMethodBeat.m2505o(122807);
            throw assertionError;
        } else if (arrayList.size() < 2) {
            Object fN = C25035t.m39341fN(arrayList);
            C25052j.m39375o(fN, "filteredSuperAndEqualTypes.single()");
            c8235ad = (C8235ad) fN;
            AppMethodBeat.m2505o(122807);
            return c8235ad;
        } else {
            C37059v c37059v = new C37059v(set);
            C0027a c0027a = C0026g.BfJ;
            C0026g eai = C0027a.eai();
            C17313an c17313an = c37059v;
            List list = C17115v.AUP;
            C31746h ekm = c37059v.ekm();
            C25052j.m39375o(ekm, "constructor.createScopeForKotlinType()");
            c8235ad = C17326x.m26838a(eai, c17313an, list, false, ekm);
            AppMethodBeat.m2505o(122807);
            return c8235ad;
        }
    }
}
