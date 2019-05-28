package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44847aa;
import p000a.C44941v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C25225ao;
import p000a.p010i.p011b.p012a.p015c.p045l.C25225ao.C8238a;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p048n.C8256d;

/* renamed from: a.i.b.a.c.l.a.g */
public final class C41443g {
    /* renamed from: a */
    public static /* synthetic */ C8235ad m72302a(C8235ad c8235ad, C0158a c0158a) {
        AppMethodBeat.m2504i(122732);
        C31591m ekv = C8256d.ekv();
        C25052j.m39376p(c8235ad, "type");
        C25052j.m39376p(c0158a, "status");
        C25052j.m39376p(ekv, "acceptNewCapturedType");
        if (c8235ad.ejt().size() != c8235ad.ejw().getParameters().size()) {
            AppMethodBeat.m2505o(122732);
            return null;
        }
        Object obj;
        List ejt = c8235ad.ejt();
        Iterable<C41446ap> iterable = ejt;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (C41446ap ekq : iterable) {
                if (ekq.ekq() == C0163ba.INVARIANT) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj == null) {
                    obj = null;
                    break;
                }
            }
        }
        obj = 1;
        if (obj != null) {
            AppMethodBeat.m2505o(122732);
            return null;
        }
        iterable = ejt;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C41446ap ekq2 : iterable) {
            if (ekq2.ekq() != C0163ba.INVARIANT) {
                C41447az c41447az;
                if (ekq2.ekp() || ekq2.ekq() != C0163ba.IN_VARIANCE) {
                    c41447az = null;
                } else {
                    c41447az = ekq2.dZS().ekn();
                }
                obj = C41448a.m72315aM(new C31767e(c0158a, c41447az, ekq2));
            }
            arrayList.add(obj);
        }
        List list = (List) arrayList;
        C8238a c8238a = C25225ao.BJQ;
        C25227au ekr = C8238a.m14558a(c8235ad.ejw(), list).ekr();
        int size = ejt.size();
        for (int i = 0; i < size; i++) {
            C41446ap c41446ap = (C41446ap) ejt.get(i);
            C41446ap c41446ap2 = (C41446ap) list.get(i);
            if (c41446ap.ekq() != C0163ba.INVARIANT) {
                Object a;
                obj = c8235ad.ejw().getParameters().get(i);
                C25052j.m39375o(obj, "type.constructor.parameters[index]");
                List dWP = ((C36955ar) obj).dWP();
                C25052j.m39375o(dWP, "type.constructor.parameters[index].upperBounds");
                Iterable<C46867w> iterable2 = dWP;
                Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable2));
                for (C46867w c46867w : iterable2) {
                    C31769h c31769h = C31769h.BKA;
                    arrayList2.add(C31769h.m51465c(ekr.mo42079b(c46867w, C0163ba.INVARIANT).ekn()));
                }
                dWP = (List) arrayList2;
                if (c41446ap.ekp() || c41446ap.ekq() != C0163ba.OUT_VARIANCE) {
                    List a2 = dWP;
                } else {
                    arrayList2 = dWP;
                    C31769h c31769h2 = C31769h.BKA;
                    a2 = C25035t.m39326a(arrayList2, (Object) C31769h.m51465c(c41446ap.dZS().ekn()));
                }
                C46867w dZS = c41446ap2.dZS();
                if (dZS == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                    AppMethodBeat.m2505o(122732);
                    throw c44941v;
                }
                C31767e c31767e = (C31767e) dZS;
                C31768f c31768f = c31767e.BKw;
                C25052j.m39376p(a2, "supertypes");
                Object obj2 = c31768f.BKz == null ? 1 : null;
                if (C44847aa.AUz && obj2 == null) {
                    Throwable assertionError = new AssertionError("Already initialized! oldValue = " + c31768f.BKz + ", newValue = " + a2);
                    AppMethodBeat.m2505o(122732);
                    throw assertionError;
                }
                c31768f.BKz = a2;
                ekv.mo212m(Integer.valueOf(i), c31767e);
            }
        }
        C8235ad c = C17326x.m26840c(c8235ad.dYn(), c8235ad.ejw(), list, c8235ad.eci());
        AppMethodBeat.m2505o(122732);
        return c;
    }
}
