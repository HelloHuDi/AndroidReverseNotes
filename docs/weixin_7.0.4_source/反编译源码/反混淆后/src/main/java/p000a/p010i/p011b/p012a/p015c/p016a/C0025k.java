package p000a.p010i.p011b.p012a.p015c.p016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44847aa;
import p000a.p001a.C25033k;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C31634ah;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C36959m;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C36962w;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p044k.C17299b;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.a.k */
public final class C0025k {
    private static final C36962w Bct;
    private static final C36962w Bcu;

    public static final C36962w dXU() {
        return Bct;
    }

    static {
        AppMethodBeat.m2504i(119114);
        C25093y ekj = C25235p.ekj();
        C25052j.m39375o(ekj, "ErrorUtils.getErrorModule()");
        C8174b c8174b = C8203d.BDT;
        C25052j.m39375o(c8174b, "DescriptorUtils.COROUTIN…KAGE_FQ_NAME_EXPERIMENTAL");
        C36962w c36962w = new C36962w(new C36959m(ekj, c8174b), C36964f.INTERFACE, C8203d.BDV.ByQ.ehK(), C41398am.BeR, C17299b.BIH);
        c36962w.mo58967b(C44879w.ABSTRACT);
        c36962w.BhQ = C8051ay.Bfa;
        C31642l c31642l = c36962w;
        C0027a c0027a = C0026g.BfJ;
        c36962w.mo58969fV(C25033k.listOf(C31634ah.m51154a(c31642l, C0027a.eai(), C0163ba.IN_VARIANCE, C37022f.avX("T"), 0)));
        c36962w.eaF();
        Bct = c36962w;
        ekj = C25235p.ekj();
        C25052j.m39375o(ekj, "ErrorUtils.getErrorModule()");
        c8174b = C8203d.BDS;
        C25052j.m39375o(c8174b, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE");
        c36962w = new C36962w(new C36959m(ekj, c8174b), C36964f.INTERFACE, C8203d.BDW.ByQ.ehK(), C41398am.BeR, C17299b.BIH);
        c36962w.mo58967b(C44879w.ABSTRACT);
        c36962w.BhQ = C8051ay.Bfa;
        c31642l = c36962w;
        c0027a = C0026g.BfJ;
        c36962w.mo58969fV(C25033k.listOf(C31634ah.m51154a(c31642l, C0027a.eai(), C0163ba.IN_VARIANCE, C37022f.avX("T"), 0)));
        c36962w.eaF();
        Bcu = c36962w;
        AppMethodBeat.m2505o(119114);
    }

    public static final C36962w dXV() {
        return Bcu;
    }

    /* renamed from: F */
    public static final C8235ad m25F(C46867w c46867w) {
        AppMethodBeat.m2504i(119112);
        C25052j.m39376p(c46867w, "suspendFunType");
        boolean e = C31615f.m51085e(c46867w);
        if (!C44847aa.AUz || e) {
            C31619g aL = C41448a.m72314aL(c46867w);
            C0026g dYn = c46867w.dYn();
            C46867w h = C31615f.m51088h(c46867w);
            Iterable<C41446ap> j = C31615f.m51090j(c46867w);
            Collection arrayList = new ArrayList(C25034m.m39318d(j));
            for (C41446ap dZS : j) {
                arrayList.add(dZS.dZS());
            }
            arrayList = (List) arrayList;
            C0027a c0027a = C0026g.BfJ;
            C0026g eai = C0027a.eai();
            C17313an dXY = Bct.dXY();
            C25052j.m39375o(dXY, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
            List a = C25035t.m39326a(arrayList, (Object) C17326x.m26840c(eai, dXY, C25033k.listOf(C41448a.m72315aM(C31615f.m51089i(c46867w))), false));
            C8235ad dXN = C41448a.m72314aL(c46867w).dXN();
            C25052j.m39375o(dXN, "suspendFunType.builtIns.nullableAnyType");
            dXN = C31615f.m51082a(aL, dYn, h, a, dXN).mo18033rL(c46867w.eci());
            AppMethodBeat.m2505o(119112);
            return dXN;
        }
        Throwable assertionError = new AssertionError("This type should be suspend function type: ".concat(String.valueOf(c46867w)));
        AppMethodBeat.m2505o(119112);
        throw assertionError;
    }

    /* renamed from: a */
    public static final boolean m26a(C8174b c8174b, boolean z) {
        AppMethodBeat.m2504i(119113);
        boolean j;
        if (z) {
            j = C25052j.m39373j(c8174b, C8203d.BDW);
            AppMethodBeat.m2505o(119113);
            return j;
        }
        j = C25052j.m39373j(c8174b, C8203d.BDV);
        AppMethodBeat.m2505o(119113);
        return j;
    }
}
