package p000a.p010i.p011b.p012a.p015c.p016a.p017b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44847aa;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p045l.C25225ao;
import p000a.p010i.p011b.p012a.p015c.p045l.C25225ao.C8238a;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;

/* renamed from: a.i.b.a.c.a.b.h */
public final class C25077h {
    /* renamed from: a */
    public static final C25225ao m39409a(C46865e c46865e, C46865e c46865e2) {
        AppMethodBeat.m2504i(119243);
        C25052j.m39376p(c46865e, "from");
        C25052j.m39376p(c46865e2, "to");
        Object obj = c46865e.dYq().size() == c46865e2.dYq().size() ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError(c46865e + " and " + c46865e2 + " should have same number of type parameters, but " + c46865e.dYq().size() + " / " + c46865e2.dYq().size() + " found");
            AppMethodBeat.m2505o(119243);
            throw assertionError;
        }
        C8238a c8238a = C25225ao.BJQ;
        List dYq = c46865e.dYq();
        C25052j.m39375o(dYq, "from.declaredTypeParameters");
        Iterable<C36955ar> iterable = dYq;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C36955ar dXY : iterable) {
            arrayList.add(dXY.dXY());
        }
        Iterable iterable2 = (List) arrayList;
        dYq = c46865e2.dYq();
        C25052j.m39375o(dYq, "to.declaredTypeParameters");
        iterable = dYq;
        Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable));
        for (C36955ar dXY2 : iterable) {
            C25052j.m39375o(dXY2, "it");
            C8235ad dZf = dXY2.dZf();
            C25052j.m39375o(dZf, "it.defaultType");
            arrayList2.add(C41448a.m72315aM(dZf));
        }
        C25225ao bf = C8238a.m14560bf(C31586ag.m51052v(C25035t.m39325a(iterable2, (Iterable) (List) arrayList2)));
        AppMethodBeat.m2505o(119243);
        return bf;
    }
}
