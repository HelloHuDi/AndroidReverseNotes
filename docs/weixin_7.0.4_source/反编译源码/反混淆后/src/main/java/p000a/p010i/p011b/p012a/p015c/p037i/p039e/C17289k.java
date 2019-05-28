package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44847aa;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p037i.C8202c;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.i.e.k */
public final class C17289k extends C37037i {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C17289k.class), "functions", "getFunctions()Ljava/util/List;"))};
    private final C46865e BFZ;
    private final C41441f BGi;

    /* renamed from: a.i.b.a.c.i.e.k$a */
    static final class C17290a extends C25053k implements C31214a<List<? extends C41397al>> {
        final /* synthetic */ C17289k BGj;

        C17290a(C17289k c17289k) {
            this.BGj = c17289k;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(122200);
            List listOf = C7987l.listOf(C8202c.m14465w(this.BGj.BFZ), C8202c.m14464v(this.BGj.BFZ));
            AppMethodBeat.m2505o(122200);
            return listOf;
        }
    }

    static {
        AppMethodBeat.m2504i(122201);
        AppMethodBeat.m2505o(122201);
    }

    private final List<C41397al> ejO() {
        AppMethodBeat.m2504i(122203);
        List list = (List) C17310h.m26799a(this.BGi, eQB[0]);
        AppMethodBeat.m2505o(122203);
        return list;
    }

    /* renamed from: a */
    public final /* synthetic */ Collection mo220a(C0136d c0136d, C17126b c17126b) {
        AppMethodBeat.m2504i(122204);
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        Collection ejO = ejO();
        AppMethodBeat.m2505o(122204);
        return ejO;
    }

    /* renamed from: b */
    public final /* synthetic */ Collection mo221b(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122205);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        Collection arrayList = new ArrayList(1);
        for (Object next : ejO()) {
            if (C25052j.m39373j(((C41397al) next).dZg(), c37022f)) {
                arrayList.add(next);
            }
        }
        arrayList = (ArrayList) arrayList;
        AppMethodBeat.m2505o(122205);
        return arrayList;
    }

    /* renamed from: c */
    public final /* synthetic */ C0036h mo222c(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(122202);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        AppMethodBeat.m2505o(122202);
        return null;
    }

    public C17289k(C25212i c25212i, C46865e c46865e) {
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c46865e, "containingClass");
        AppMethodBeat.m2504i(122206);
        this.BFZ = c46865e;
        Object obj = this.BFZ.dYc() == C36964f.ENUM_CLASS ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Class should be an enum: " + this.BFZ);
            AppMethodBeat.m2505o(122206);
            throw assertionError;
        }
        this.BGi = c25212i.mo31373i(new C17290a(this));
        AppMethodBeat.m2505o(122206);
    }
}
