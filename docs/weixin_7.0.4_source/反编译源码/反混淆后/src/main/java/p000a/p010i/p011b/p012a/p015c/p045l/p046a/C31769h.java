package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p000a.C31824m;
import p000a.C44847aa;
import p000a.p001a.C17115v;
import p000a.p001a.C25033k;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C44628q;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C36967x;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C41433n;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p1435a.p1436a.C41430b;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C17325q;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C25225ao;
import p000a.p010i.p011b.p012a.p015c.p045l.C25225ao.C8238a;
import p000a.p010i.p011b.p012a.p015c.p045l.C25231ax;
import p000a.p010i.p011b.p012a.p015c.p045l.C25239y;
import p000a.p010i.p011b.p012a.p015c.p045l.C37059v;
import p000a.p010i.p011b.p012a.p015c.p045l.C41444ag;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C41457n;
import p000a.p010i.p011b.p012a.p015c.p045l.C44921aj;
import p000a.p010i.p011b.p012a.p015c.p045l.C44924t;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C37046c;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C37046c.C37047a;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C37046c.C37048b;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C37046c.C37049c;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C44918b;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p048n.C37067h;

/* renamed from: a.i.b.a.c.l.a.h */
public final class C31769h implements C8229c {
    public static final C31769h BKA = new C31769h();

    static {
        AppMethodBeat.m2504i(122750);
        AppMethodBeat.m2505o(122750);
    }

    private C31769h() {
    }

    /* renamed from: c */
    public final boolean mo18024c(C46867w c46867w, C46867w c46867w2) {
        AppMethodBeat.m2504i(122734);
        C25052j.m39376p(c46867w, "subtype");
        C25052j.m39376p(c46867w2, "supertype");
        boolean b = m51464b(new C44919o(true, (byte) 0), c46867w.ekn(), c46867w2.ekn());
        AppMethodBeat.m2505o(122734);
        return b;
    }

    /* renamed from: d */
    public final boolean mo18025d(C46867w c46867w, C46867w c46867w2) {
        AppMethodBeat.m2504i(122735);
        C25052j.m39376p(c46867w, "a");
        C25052j.m39376p(c46867w2, "b");
        boolean a = m51457a(new C44919o(false, (byte) 0), c46867w.ekn(), c46867w2.ekn());
        AppMethodBeat.m2505o(122735);
        return a;
    }

    /* renamed from: a */
    private boolean m51457a(C44919o c44919o, C41447az c41447az, C41447az c41447az2) {
        AppMethodBeat.m2504i(122736);
        C25052j.m39376p(c44919o, "receiver$0");
        C25052j.m39376p(c41447az, "a");
        C25052j.m39376p(c41447az2, "b");
        if (c41447az == c41447az2) {
            AppMethodBeat.m2505o(122736);
            return true;
        }
        if (C31769h.m51460aI(c41447az) && C31769h.m51460aI(c41447az2)) {
            if (!C44919o.m82148c(c41447az.ejw(), c41447az2.ejw())) {
                AppMethodBeat.m2505o(122736);
                return false;
            } else if (c41447az.ejt().isEmpty()) {
                if (C31769h.m51459aH(c41447az) || C31769h.m51459aH(c41447az2)) {
                    AppMethodBeat.m2505o(122736);
                    return true;
                } else if (c41447az.eci() == c41447az2.eci()) {
                    AppMethodBeat.m2505o(122736);
                    return true;
                } else {
                    AppMethodBeat.m2505o(122736);
                    return false;
                }
            }
        }
        if (m51464b(c44919o, c41447az, c41447az2) && m51464b(c44919o, c41447az2, c41447az)) {
            AppMethodBeat.m2505o(122736);
            return true;
        }
        AppMethodBeat.m2505o(122736);
        return false;
    }

    /* renamed from: aH */
    private static boolean m51459aH(C46867w c46867w) {
        AppMethodBeat.m2504i(122737);
        if (C44924t.m82162ak(c46867w).eci() != C44924t.m82163al(c46867w).eci()) {
            AppMethodBeat.m2505o(122737);
            return true;
        }
        AppMethodBeat.m2505o(122737);
        return false;
    }

    /* renamed from: aI */
    private static boolean m51460aI(C46867w c46867w) {
        AppMethodBeat.m2504i(122738);
        if (!c46867w.ejw().dYu() || C41457n.m72337ag(c46867w) || C41444ag.m72304ap(c46867w) || !C25052j.m39373j(C44924t.m82162ak(c46867w).ejw(), C44924t.m82163al(c46867w).ejw())) {
            AppMethodBeat.m2505o(122738);
            return false;
        }
        AppMethodBeat.m2505o(122738);
        return true;
    }

    /* renamed from: b */
    private boolean m51464b(C44919o c44919o, C41447az c41447az, C41447az c41447az2) {
        AppMethodBeat.m2504i(122739);
        C25052j.m39376p(c44919o, "receiver$0");
        C25052j.m39376p(c41447az, "subType");
        C25052j.m39376p(c41447az2, "superType");
        if (c41447az == c41447az2) {
            AppMethodBeat.m2505o(122739);
            return true;
        }
        C41447az c = C31769h.m51465c(c41447az);
        C41447az c2 = C31769h.m51465c(c41447az2);
        Boolean a = m51454a(c44919o, C44924t.m82162ak(c), C44924t.m82163al(c2));
        boolean booleanValue;
        if (a != null) {
            booleanValue = a.booleanValue();
            C44919o.m82147b(c, c2);
            AppMethodBeat.m2505o(122739);
            return booleanValue;
        }
        C44919o.m82147b(c, c2);
        booleanValue = C31769h.m51463b(c44919o, C44924t.m82162ak(c), C44924t.m82163al(c2));
        AppMethodBeat.m2505o(122739);
        return booleanValue;
    }

    /* renamed from: b */
    private static C8235ad m51461b(C8235ad c8235ad) {
        C41447az c41447az = null;
        AppMethodBeat.m2504i(122740);
        C25052j.m39376p(c8235ad, "type");
        C17313an ejw = c8235ad.ejw();
        C46867w dZS;
        C8235ad c31767e;
        Iterable<C46867w> iterable;
        Collection arrayList;
        if (ejw instanceof C41430b) {
            boolean z;
            C41446ap c41446ap = ((C41430b) ejw).BEG;
            if (c41446ap.ekq() == C0163ba.IN_VARIANCE) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                c41446ap = null;
            }
            if (c41446ap != null) {
                dZS = c41446ap.dZS();
                if (dZS != null) {
                    c41447az = dZS.ekn();
                }
            }
            if (((C41430b) ejw).BEJ == null) {
                C41430b c41430b = (C41430b) ejw;
                C41446ap c41446ap2 = ((C41430b) ejw).BEG;
                Iterable<C46867w> eap = ((C41430b) ejw).eap();
                Collection arrayList2 = new ArrayList(C25034m.m39318d(eap));
                for (C46867w ekn : eap) {
                    arrayList2.add(ekn.ekn());
                }
                c41430b.BEJ = new C31768f(c41446ap2, (List) arrayList2);
            }
            C0158a c0158a = C0158a.FOR_SUBTYPING;
            C31768f c31768f = ((C41430b) ejw).BEJ;
            if (c31768f == null) {
                C25052j.dWJ();
            }
            c31767e = new C31767e(c0158a, c31768f, c41447az, c8235ad.dYn(), c8235ad.eci());
            AppMethodBeat.m2505o(122740);
            return c31767e;
        } else if (ejw instanceof C41433n) {
            iterable = ((C41433n) ejw).BEU;
            arrayList = new ArrayList(C25034m.m39318d(iterable));
            for (C46867w dZS2 : iterable) {
                arrayList.add(C17316av.m26811a(dZS2, c8235ad.eci()));
            }
            c31767e = C17326x.m26838a(c8235ad.dYn(), new C37059v((List) arrayList), C17115v.AUP, false, c8235ad.dXR());
            AppMethodBeat.m2505o(122740);
            return c31767e;
        } else if ((ejw instanceof C37059v) && c8235ad.eci()) {
            Set set = ((C37059v) ejw).BJH;
            C25052j.m39375o(set, "constructor.supertypes");
            iterable = set;
            arrayList = new ArrayList(C25034m.m39318d(iterable));
            for (C46867w dZS22 : iterable) {
                C25052j.m39375o(dZS22, "it");
                arrayList.add(C41448a.m72317az(dZS22));
            }
            C37059v c37059v = new C37059v((List) arrayList);
            C0026g dYn = c8235ad.dYn();
            C17313an c17313an = c37059v;
            List list = C17115v.AUP;
            C31746h ekm = c37059v.ekm();
            C25052j.m39375o(ekm, "newConstructor.createScopeForKotlinType()");
            c31767e = C17326x.m26838a(dYn, c17313an, list, false, ekm);
            AppMethodBeat.m2505o(122740);
            return c31767e;
        } else {
            AppMethodBeat.m2505o(122740);
            return c8235ad;
        }
    }

    /* renamed from: c */
    public static C41447az m51465c(C41447az c41447az) {
        C41447az b;
        AppMethodBeat.m2504i(122741);
        C25052j.m39376p(c41447az, "type");
        if (c41447az instanceof C8235ad) {
            b = C31769h.m51461b((C8235ad) c41447az);
        } else if (c41447az instanceof C17325q) {
            C8235ad b2 = C31769h.m51461b(((C17325q) c41447az).BJx);
            C8235ad b3 = C31769h.m51461b(((C17325q) c41447az).BJy);
            b = (b2 == ((C17325q) c41447az).BJx && b3 == ((C17325q) c41447az).BJy) ? c41447az : C17326x.m26839a(b2, b3);
        } else {
            C31824m c31824m = new C31824m();
            AppMethodBeat.m2505o(122741);
            throw c31824m;
        }
        b = C25231ax.m39778a(b, c41447az);
        AppMethodBeat.m2505o(122741);
        return b;
    }

    /* renamed from: a */
    private final Boolean m51454a(C44919o c44919o, C8235ad c8235ad, C8235ad c8235ad2) {
        boolean z = false;
        AppMethodBeat.m2504i(122742);
        Boolean bool;
        if (C25239y.m39807an(c8235ad) || C25239y.m39807an(c8235ad2)) {
            if (c44919o.BKI) {
                bool = Boolean.TRUE;
                AppMethodBeat.m2505o(122742);
                return bool;
            } else if (!c8235ad.eci() || c8235ad2.eci()) {
                bool = Boolean.valueOf(C44917m.BKC.mo72113c(c8235ad.mo18033rL(false), c8235ad2.mo18033rL(false)));
                AppMethodBeat.m2505o(122742);
                return bool;
            } else {
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(122742);
                return bool;
            }
        } else if ((c8235ad instanceof C44921aj) || (c8235ad2 instanceof C44921aj)) {
            bool = Boolean.TRUE;
            AppMethodBeat.m2505o(122742);
            return bool;
        } else {
            if ((c8235ad2 instanceof C31767e) && ((C31767e) c8235ad2).BKx != null) {
                switch (C0160i.eQZ[C44919o.m82146a(c8235ad, (C31767e) c8235ad2).ordinal()]) {
                    case 1:
                        bool = Boolean.valueOf(m51464b(c44919o, (C41447az) c8235ad, ((C31767e) c8235ad2).BKx));
                        AppMethodBeat.m2505o(122742);
                        return bool;
                    case 2:
                        if (m51464b(c44919o, (C41447az) c8235ad, ((C31767e) c8235ad2).BKx)) {
                            bool = Boolean.TRUE;
                            AppMethodBeat.m2505o(122742);
                            return bool;
                        }
                        break;
                }
            }
            C17313an ejw = c8235ad2.ejw();
            if (!(ejw instanceof C37059v)) {
                ejw = null;
            }
            C37059v c37059v = (C37059v) ejw;
            if (c37059v != null) {
                boolean z2;
                if (c8235ad2.eci()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!C44847aa.AUz || z2) {
                    Set set = c37059v.BJH;
                    C25052j.m39375o(set, "it.supertypes");
                    Iterable<C46867w> iterable = set;
                    if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                        for (C46867w ekn : iterable) {
                            if (!BKA.m51464b(c44919o, (C41447az) c8235ad, ekn.ekn())) {
                                bool = Boolean.valueOf(z);
                                AppMethodBeat.m2505o(122742);
                                return bool;
                            }
                        }
                    }
                    z = true;
                    bool = Boolean.valueOf(z);
                    AppMethodBeat.m2505o(122742);
                    return bool;
                }
                Throwable assertionError = new AssertionError("Intersection type should not be marked nullable!: ".concat(String.valueOf(c8235ad2)));
                AppMethodBeat.m2505o(122742);
                throw assertionError;
            }
            AppMethodBeat.m2505o(122742);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x01df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static boolean m51463b(C44919o c44919o, C8235ad c8235ad, C8235ad c8235ad2) {
        AppMethodBeat.m2504i(122744);
        Object obj = (C8230j.m14536d(c8235ad) || C8230j.m14537e(c8235ad) || c44919o.mo72115e(c8235ad)) ? 1 : null;
        Throwable assertionError;
        if (C44847aa.AUz && obj == null) {
            assertionError = new AssertionError("Not singleClassifierType and not intersection subType: ".concat(String.valueOf(c8235ad)));
            AppMethodBeat.m2505o(122744);
            throw assertionError;
        }
        obj = (C8230j.m14536d(c8235ad2) || c44919o.mo72115e(c8235ad2)) ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            assertionError = new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(c8235ad2)));
            AppMethodBeat.m2505o(122744);
            throw assertionError;
        }
        C8232l c8232l = C8232l.BKB;
        if (C8232l.m14539c(c44919o, c8235ad, c8235ad2)) {
            C17313an ejw = c8235ad2.ejw();
            if (C25052j.m39373j(c8235ad.ejw(), ejw) && ejw.getParameters().isEmpty()) {
                AppMethodBeat.m2505o(122744);
                return true;
            } else if (C41448a.m72309A(c8235ad2)) {
                AppMethodBeat.m2505o(122744);
                return true;
            } else {
                List b = C31769h.m51462b(c44919o, c8235ad, ejw);
                boolean a;
                switch (b.size()) {
                    case 0:
                        a = C31769h.m51456a(c44919o, c8235ad);
                        AppMethodBeat.m2505o(122744);
                        return a;
                    case 1:
                        a = C31769h.m51458a(c44919o, ((C8235ad) C25035t.m39337fJ(b)).ejt(), c8235ad2);
                        AppMethodBeat.m2505o(122744);
                        return a;
                    default:
                        Iterable<C8235ad> iterable;
                        switch (C0160i.pCY[C44918b.INTERSECT_ARGUMENTS_AND_CHECK_AGAIN.ordinal()]) {
                            case 1:
                                AppMethodBeat.m2505o(122744);
                                return false;
                            case 2:
                                a = C31769h.m51458a(c44919o, ((C8235ad) C25035t.m39337fJ(b)).ejt(), c8235ad2);
                                AppMethodBeat.m2505o(122744);
                                return a;
                            case 3:
                            case 4:
                                iterable = b;
                                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                                    for (C8235ad ejt : iterable) {
                                        if (C31769h.m51458a(c44919o, ejt.ejt(), c8235ad2)) {
                                            obj = 1;
                                            if (obj != null) {
                                                AppMethodBeat.m2505o(122744);
                                                return true;
                                            }
                                        }
                                    }
                                }
                                obj = null;
                                if (obj != null) {
                                }
                                break;
                        }
                        C44918b c44918b = C44918b.INTERSECT_ARGUMENTS_AND_CHECK_AGAIN;
                        List parameters = ejw.getParameters();
                        C25052j.m39375o(parameters, "superConstructor.parameters");
                        Iterable iterable2 = parameters;
                        Collection arrayList = new ArrayList(C25034m.m39318d(iterable2));
                        Iterator it = iterable2.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            it.next();
                            int i2 = i + 1;
                            if (i < 0) {
                                C7987l.dWs();
                            }
                            iterable = b;
                            Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable));
                            for (C8235ad ejt2 : iterable) {
                                C41446ap c41446ap = (C41446ap) C25035t.m39361x(ejt2.ejt(), i);
                                if (c41446ap != null) {
                                    if ((c41446ap.ekq() == C0163ba.INVARIANT ? 1 : null) == null) {
                                        c41446ap = null;
                                    }
                                    if (c41446ap != null) {
                                        C46867w dZS = c41446ap.dZS();
                                        if (dZS != null) {
                                            C41447az ekn = dZS.ekn();
                                            if (ekn != null) {
                                                arrayList2.add(ekn);
                                            }
                                        }
                                    }
                                }
                                assertionError = new IllegalStateException(("Incorrect type: " + ejt2 + ", subType: " + c8235ad + ", superType: " + c8235ad2).toString());
                                AppMethodBeat.m2505o(122744);
                                throw assertionError;
                            }
                            arrayList.add(C41448a.m72315aM(C8228b.m14532gb((List) arrayList2)));
                            i = i2;
                        }
                        a = C31769h.m51458a(c44919o, (List) arrayList, c8235ad2);
                        AppMethodBeat.m2505o(122744);
                        return a;
                }
            }
        }
        AppMethodBeat.m2505o(122744);
        return false;
    }

    /* renamed from: a */
    private static List<C8235ad> m51455a(C44919o c44919o, C8235ad c8235ad, C17313an c17313an) {
        AppMethodBeat.m2504i(122745);
        List<C8235ad> c = C31769h.m51466c(c44919o, c8235ad, c17313an);
        if (c.size() >= 2) {
            Collection arrayList = new ArrayList();
            for (Object next : c) {
                Object obj;
                Iterable<C41446ap> ejt = ((C8235ad) next).ejt();
                if (!((ejt instanceof Collection) && ((Collection) ejt).isEmpty())) {
                    for (C41446ap dZS : ejt) {
                        C46867w dZS2 = dZS.dZS();
                        C25052j.m39375o(dZS2, "it.type");
                        if (C44924t.m82160ai(dZS2)) {
                            obj = null;
                            continue;
                        } else {
                            obj = 1;
                            continue;
                        }
                        if (obj == null) {
                            obj = null;
                            break;
                        }
                    }
                }
                int i = 1;
                if (obj != null) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if ((!((Collection) list).isEmpty() ? 1 : null) != null) {
                AppMethodBeat.m2505o(122745);
                return list;
            }
        }
        AppMethodBeat.m2505o(122745);
        return c;
    }

    /* renamed from: b */
    private static List<C8235ad> m51462b(C44919o c44919o, C8235ad c8235ad, C17313an c17313an) {
        AppMethodBeat.m2504i(122746);
        C25052j.m39376p(c44919o, "receiver$0");
        C25052j.m39376p(c8235ad, "baseType");
        C25052j.m39376p(c17313an, "constructor");
        List<C8235ad> list;
        if (C8230j.m14535c(c8235ad)) {
            List a = C31769h.m51455a(c44919o, c8235ad, c17313an);
            AppMethodBeat.m2505o(122746);
            return a;
        } else if (c17313an.dYs() instanceof C46865e) {
            C37067h<C8235ad> c37067h = new C37067h();
            c44919o.initialize();
            ArrayDeque arrayDeque = c44919o.BKG;
            if (arrayDeque == null) {
                C25052j.dWJ();
            }
            Set set = c44919o.BKH;
            if (set == null) {
                C25052j.dWJ();
            }
            arrayDeque.push(c8235ad);
            while (true) {
                int i;
                if (arrayDeque.isEmpty()) {
                    i = 0;
                } else {
                    i = 1;
                }
                C8235ad c8235ad2;
                if (i == 0) {
                    c44919o.clear();
                    Collection arrayList = new ArrayList();
                    for (C8235ad c8235ad22 : c37067h) {
                        C25052j.m39375o(c8235ad22, "it");
                        C44628q.m81054a(arrayList, (Iterable) C31769h.m51455a(c44919o, c8235ad22, c17313an));
                    }
                    list = (List) arrayList;
                    AppMethodBeat.m2505o(122746);
                    return list;
                } else if (set.size() > 1000) {
                    Throwable illegalStateException = new IllegalStateException(("Too many supertypes for type: " + c8235ad + ". Supertypes = " + C25035t.m39322a((Iterable) set, null, null, null, 0, null, null, 63)).toString());
                    AppMethodBeat.m2505o(122746);
                    throw illegalStateException;
                } else {
                    c8235ad22 = (C8235ad) arrayDeque.pop();
                    C25052j.m39375o(c8235ad22, "current");
                    if (set.add(c8235ad22)) {
                        C37046c c37046c;
                        if (C8230j.m14535c(c8235ad22)) {
                            c37067h.add(c8235ad22);
                            c37046c = C37049c.BKU;
                        } else {
                            c37046c = C37047a.BKT;
                        }
                        if ((C25052j.m39373j(c37046c, C37049c.BKU) ^ 1) == 0) {
                            c37046c = null;
                        }
                        if (c37046c != null) {
                            for (C46867w c46867w : c8235ad22.ejw().eap()) {
                                C25052j.m39375o(c46867w, "supertype");
                                arrayDeque.add(c37046c.mo31381aJ(c46867w));
                            }
                        }
                    }
                }
            }
        } else {
            list = C31769h.m51466c(c44919o, c8235ad, c17313an);
            AppMethodBeat.m2505o(122746);
            return list;
        }
    }

    /* renamed from: c */
    private static List<C8235ad> m51466c(C44919o c44919o, C8235ad c8235ad, C17313an c17313an) {
        AppMethodBeat.m2504i(122747);
        C0036h dYs = c17313an.dYs();
        if (!(dYs instanceof C46865e)) {
            dYs = null;
        }
        C46865e c46865e = (C46865e) dYs;
        List<C8235ad> c37067h;
        if (c46865e == null || !C31769h.m51453B(c46865e)) {
            c37067h = new C37067h();
            c44919o.initialize();
            ArrayDeque arrayDeque = c44919o.BKG;
            if (arrayDeque == null) {
                C25052j.dWJ();
            }
            Set set = c44919o.BKH;
            if (set == null) {
                C25052j.dWJ();
            }
            arrayDeque.push(c8235ad);
            while (true) {
                int i;
                if (arrayDeque.isEmpty()) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i == 0) {
                    c44919o.clear();
                    AppMethodBeat.m2505o(122747);
                    return c37067h;
                } else if (set.size() > 1000) {
                    Throwable illegalStateException = new IllegalStateException(("Too many supertypes for type: " + c8235ad + ". Supertypes = " + C25035t.m39322a((Iterable) set, null, null, null, 0, null, null, 63)).toString());
                    AppMethodBeat.m2505o(122747);
                    throw illegalStateException;
                } else {
                    C8235ad c8235ad2 = (C8235ad) arrayDeque.pop();
                    C25052j.m39375o(c8235ad2, "current");
                    if (set.add(c8235ad2)) {
                        C37046c c37046c;
                        C8235ad a = C41443g.m72302a(c8235ad2, C0158a.FOR_SUBTYPING);
                        if (a == null) {
                            a = c8235ad2;
                        }
                        if (C44919o.m82148c(a.ejw(), c17313an)) {
                            c37067h.add(a);
                            c37046c = C37049c.BKU;
                        } else if (a.ejt().isEmpty()) {
                            c37046c = C37047a.BKT;
                        } else {
                            C8238a c8238a = C25225ao.BJQ;
                            c37046c = new C37048b(C8238a.m14559au(a).ekr());
                        }
                        if ((C25052j.m39373j(c37046c, C37049c.BKU) ^ 1) == 0) {
                            c37046c = null;
                        }
                        if (c37046c != null) {
                            for (C46867w c46867w : c8235ad2.ejw().eap()) {
                                C25052j.m39375o(c46867w, "supertype");
                                arrayDeque.add(c37046c.mo31381aJ(c46867w));
                            }
                        }
                    }
                }
            }
        } else if (C44919o.m82148c(c8235ad.ejw(), c17313an)) {
            C8235ad a2 = C41443g.m72302a(c8235ad, C0158a.FOR_SUBTYPING);
            if (a2 != null) {
                c8235ad = a2;
            }
            List listOf = C25033k.listOf(c8235ad);
            AppMethodBeat.m2505o(122747);
            return listOf;
        } else {
            c37067h = C17115v.AUP;
            AppMethodBeat.m2505o(122747);
            return c37067h;
        }
    }

    /* renamed from: B */
    private static boolean m51453B(C46865e c46865e) {
        AppMethodBeat.m2504i(122748);
        if (!C36967x.m61754p(c46865e) || c46865e.dYc() == C36964f.ENUM_ENTRY || c46865e.dYc() == C36964f.ANNOTATION_CLASS) {
            AppMethodBeat.m2505o(122748);
            return false;
        }
        AppMethodBeat.m2505o(122748);
        return true;
    }

    /* renamed from: a */
    private static boolean m51458a(C44919o c44919o, List<? extends C41446ap> list, C8235ad c8235ad) {
        AppMethodBeat.m2504i(122749);
        if (list == c8235ad.ejt()) {
            AppMethodBeat.m2505o(122749);
            return true;
        }
        List parameters = c8235ad.ejw().getParameters();
        C25052j.m39375o(parameters, "superType.constructor.parameters");
        int size = parameters.size();
        for (int i = 0; i < size; i++) {
            C41446ap c41446ap = (C41446ap) c8235ad.ejt().get(i);
            if (!c41446ap.ekp()) {
                C41447az ekn = c41446ap.dZS().ekn();
                C41446ap c41446ap2 = (C41446ap) list.get(i);
                boolean z = c41446ap2.ekq() == C0163ba.INVARIANT;
                Throwable illegalStateException;
                if (!C44847aa.AUz || z) {
                    C41447az ekn2 = c41446ap2.dZS().ekn();
                    Object obj = parameters.get(i);
                    C25052j.m39375o(obj, "parameters[index]");
                    C0163ba dZh = ((C36955ar) obj).dZh();
                    C25052j.m39375o(dZh, "parameters[index].variance");
                    C0163ba ekq = c41446ap.ekq();
                    C25052j.m39375o(ekq, "superProjection.projectionKind");
                    C25052j.m39376p(dZh, "declared");
                    C25052j.m39376p(ekq, "useSite");
                    if (dZh != C0163ba.INVARIANT) {
                        if (ekq == C0163ba.INVARIANT) {
                            ekq = dZh;
                        } else if (dZh == ekq) {
                            ekq = dZh;
                        } else {
                            ekq = null;
                        }
                    }
                    if (ekq == null) {
                        boolean z2 = c44919o.BKI;
                        AppMethodBeat.m2505o(122749);
                        return z2;
                    } else if (c44919o.BKE > 100) {
                        illegalStateException = new IllegalStateException("Arguments depth is too high. Some related argument: ".concat(String.valueOf(ekn2)).toString());
                        AppMethodBeat.m2505o(122749);
                        throw illegalStateException;
                    } else {
                        boolean a;
                        c44919o.BKE++;
                        switch (C0160i.pEv[ekq.ordinal()]) {
                            case 1:
                                a = BKA.m51457a(c44919o, ekn2, ekn);
                                break;
                            case 2:
                                a = BKA.m51464b(c44919o, ekn2, ekn);
                                break;
                            case 3:
                                a = BKA.m51464b(c44919o, ekn, ekn2);
                                break;
                            default:
                                C31824m c31824m = new C31824m();
                                AppMethodBeat.m2505o(122749);
                                throw c31824m;
                        }
                        c44919o.BKE--;
                        if (!a) {
                            AppMethodBeat.m2505o(122749);
                            return false;
                        }
                    }
                } else {
                    illegalStateException = new AssertionError("Incorrect sub argument: ".concat(String.valueOf(c41446ap2)));
                    AppMethodBeat.m2505o(122749);
                    throw illegalStateException;
                }
            }
        }
        AppMethodBeat.m2505o(122749);
        return true;
    }

    /* renamed from: a */
    private static boolean m51456a(C44919o c44919o, C8235ad c8235ad) {
        AppMethodBeat.m2504i(122743);
        if (C31619g.m51135z(c8235ad)) {
            AppMethodBeat.m2505o(122743);
            return true;
        }
        c44919o.initialize();
        ArrayDeque arrayDeque = c44919o.BKG;
        if (arrayDeque == null) {
            C25052j.dWJ();
        }
        Set set = c44919o.BKH;
        if (set == null) {
            C25052j.dWJ();
        }
        arrayDeque.push(c8235ad);
        while (true) {
            boolean z;
            if (arrayDeque.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                c44919o.clear();
                AppMethodBeat.m2505o(122743);
                return false;
            } else if (set.size() > 1000) {
                Throwable illegalStateException = new IllegalStateException(("Too many supertypes for type: " + c8235ad + ". Supertypes = " + C25035t.m39322a((Iterable) set, null, null, null, 0, null, null, 63)).toString());
                AppMethodBeat.m2505o(122743);
                throw illegalStateException;
            } else {
                C8235ad c8235ad2 = (C8235ad) arrayDeque.pop();
                C25052j.m39375o(c8235ad2, "current");
                if (set.add(c8235ad2)) {
                    C37046c c37046c = C8230j.m14535c(c8235ad2) ? C37049c.BKU : C37047a.BKT;
                    C37046c c37046c2 = (C25052j.m39373j(c37046c, C37049c.BKU) ^ 1) != 0 ? c37046c : null;
                    if (c37046c2 != null) {
                        for (C46867w c46867w : c8235ad2.ejw().eap()) {
                            C25052j.m39375o(c46867w, "supertype");
                            C8235ad aJ = c37046c2.mo31381aJ(c46867w);
                            if (C31619g.m51135z(aJ)) {
                                c44919o.clear();
                                AppMethodBeat.m2505o(122743);
                                return true;
                            }
                            arrayDeque.add(aJ);
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}
