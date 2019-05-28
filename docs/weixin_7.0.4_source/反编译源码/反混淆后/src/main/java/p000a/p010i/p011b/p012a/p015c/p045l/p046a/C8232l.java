package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Set;
import p000a.C44847aa;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C41444ag;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C44924t;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C37046c;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C37046c.C17311d;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C37046c.C37047a;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C37046c.C37049c;

/* renamed from: a.i.b.a.c.l.a.l */
public final class C8232l {
    public static final C8232l BKB = new C8232l();

    static {
        AppMethodBeat.m2504i(122758);
        AppMethodBeat.m2505o(122758);
    }

    private C8232l() {
    }

    /* renamed from: d */
    public static boolean m14541d(C41447az c41447az) {
        AppMethodBeat.m2504i(122755);
        C25052j.m39376p(c41447az, "type");
        boolean a = C8232l.m14538a(new C44919o(false, (byte) 0), C44924t.m82162ak(c41447az), C37047a.BKT);
        AppMethodBeat.m2505o(122755);
        return a;
    }

    /* renamed from: a */
    private static boolean m14538a(C44919o c44919o, C8235ad c8235ad, C37046c c37046c) {
        boolean z;
        AppMethodBeat.m2504i(122756);
        if ((!C8230j.m14535c(c8235ad) || c8235ad.eci()) && !C41444ag.m72304ap(c8235ad)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            AppMethodBeat.m2505o(122756);
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
            if (arrayDeque.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                c44919o.clear();
                AppMethodBeat.m2505o(122756);
                return false;
            } else if (set.size() > 1000) {
                Throwable illegalStateException = new IllegalStateException(("Too many supertypes for type: " + c8235ad + ". Supertypes = " + C25035t.m39322a((Iterable) set, null, null, null, 0, null, null, 63)).toString());
                AppMethodBeat.m2505o(122756);
                throw illegalStateException;
            } else {
                C8235ad c8235ad2 = (C8235ad) arrayDeque.pop();
                C25052j.m39375o(c8235ad2, "current");
                if (set.add(c8235ad2)) {
                    C37046c c37046c2;
                    if (c8235ad2.eci()) {
                        c37046c2 = C37049c.BKU;
                    } else {
                        c37046c2 = c37046c;
                    }
                    C37046c c37046c3 = (C25052j.m39373j(c37046c2, C37049c.BKU) ^ 1) != 0 ? c37046c2 : null;
                    if (c37046c3 != null) {
                        for (C46867w c46867w : c8235ad2.ejw().eap()) {
                            C25052j.m39375o(c46867w, "supertype");
                            C8235ad aJ = c37046c3.mo31381aJ(c46867w);
                            if ((!C8230j.m14535c(aJ) || aJ.eci()) && !C41444ag.m72304ap(aJ)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                c44919o.clear();
                                AppMethodBeat.m2505o(122756);
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

    /* renamed from: d */
    private static boolean m14540d(C44919o c44919o, C8235ad c8235ad, C17313an c17313an) {
        boolean z;
        AppMethodBeat.m2504i(122757);
        if (c8235ad.eci() || !C25052j.m39373j(c8235ad.ejw(), c17313an)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            AppMethodBeat.m2505o(122757);
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
            if (arrayDeque.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                c44919o.clear();
                AppMethodBeat.m2505o(122757);
                return false;
            } else if (set.size() > 1000) {
                Throwable illegalStateException = new IllegalStateException(("Too many supertypes for type: " + c8235ad + ". Supertypes = " + C25035t.m39322a((Iterable) set, null, null, null, 0, null, null, 63)).toString());
                AppMethodBeat.m2505o(122757);
                throw illegalStateException;
            } else {
                C8235ad c8235ad2 = (C8235ad) arrayDeque.pop();
                C25052j.m39375o(c8235ad2, "current");
                if (set.add(c8235ad2)) {
                    C37046c c37046c = c8235ad2.eci() ? C37049c.BKU : C37047a.BKT;
                    if ((C25052j.m39373j(c37046c, C37049c.BKU) ^ 1) == 0) {
                        c37046c = null;
                    }
                    if (c37046c != null) {
                        for (C46867w c46867w : c8235ad2.ejw().eap()) {
                            C25052j.m39375o(c46867w, "supertype");
                            C8235ad aJ = c37046c.mo31381aJ(c46867w);
                            if (aJ.eci() || !C25052j.m39373j(aJ.ejw(), c17313an)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                c44919o.clear();
                                AppMethodBeat.m2505o(122757);
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

    /* renamed from: c */
    public static boolean m14539c(C44919o c44919o, C8235ad c8235ad, C8235ad c8235ad2) {
        AppMethodBeat.m2504i(122754);
        C25052j.m39376p(c44919o, "context");
        C25052j.m39376p(c8235ad, "subType");
        C25052j.m39376p(c8235ad2, "superType");
        boolean z = C8230j.m14537e(c8235ad) || C8230j.m14536d(c8235ad) || c44919o.mo72115e(c8235ad);
        Throwable assertionError;
        if (!C44847aa.AUz || z) {
            z = C8230j.m14536d(c8235ad2) || c44919o.mo72115e(c8235ad2);
            if (C44847aa.AUz && !z) {
                assertionError = new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(c8235ad2)));
                AppMethodBeat.m2505o(122754);
                throw assertionError;
            } else if (c8235ad2.eci()) {
                AppMethodBeat.m2505o(122754);
                return true;
            } else if (C41444ag.m72304ap(c8235ad)) {
                AppMethodBeat.m2505o(122754);
                return true;
            } else if (C8232l.m14538a(c44919o, c8235ad, C37047a.BKT)) {
                AppMethodBeat.m2505o(122754);
                return true;
            } else if (C41444ag.m72304ap(c8235ad2)) {
                AppMethodBeat.m2505o(122754);
                return false;
            } else if (C8232l.m14538a(c44919o, c8235ad2, C17311d.BKV)) {
                AppMethodBeat.m2505o(122754);
                return false;
            } else if (C8230j.m14535c(c8235ad)) {
                AppMethodBeat.m2505o(122754);
                return false;
            } else {
                boolean d = C8232l.m14540d(c44919o, c8235ad, c8235ad2.ejw());
                AppMethodBeat.m2505o(122754);
                return d;
            }
        }
        assertionError = new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(c8235ad2)));
        AppMethodBeat.m2505o(122754);
        throw assertionError;
    }
}
