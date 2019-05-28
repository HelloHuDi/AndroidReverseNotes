package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p037i.C31747j;
import p000a.p010i.p011b.p012a.p015c.p037i.C37038h;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.i.e.e */
public abstract class C0139e extends C37037i {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C0139e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    private final C41441f BFY;
    protected final C46865e BFZ;

    /* renamed from: a.i.b.a.c.i.e.e$a */
    static final class C0140a extends C25053k implements C31214a<List<? extends C31642l>> {
        final /* synthetic */ C0139e BGa;

        C0140a(C0139e c0139e) {
            this.BGa = c0139e;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(122184);
            List dYw = this.BGa.dYw();
            List b = C25035t.m39331b((Collection) dYw, (Iterable) C0139e.m259a(this.BGa, dYw));
            AppMethodBeat.m2505o(122184);
            return b;
        }
    }

    /* renamed from: a.i.b.a.c.i.e.e$b */
    public static final class C0141b extends C37038h {
        final /* synthetic */ C0139e BGa;
        final /* synthetic */ ArrayList BcP;

        C0141b(C0139e c0139e, ArrayList arrayList) {
            this.BGa = c0139e;
            this.BcP = arrayList;
        }

        /* renamed from: g */
        public final void mo232g(C25085b c25085b) {
            AppMethodBeat.m2504i(122185);
            C25052j.m39376p(c25085b, "fakeOverride");
            C31747j.m51402a(c25085b, null);
            this.BcP.add(c25085b);
            AppMethodBeat.m2505o(122185);
        }

        /* renamed from: a */
        public final void mo231a(C25085b c25085b, C25085b c25085b2) {
            AppMethodBeat.m2504i(122186);
            C25052j.m39376p(c25085b, "fromSuper");
            C25052j.m39376p(c25085b2, "fromCurrent");
            Throwable illegalStateException = new IllegalStateException(("Conflict in scope of " + this.BGa.BFZ + ": " + c25085b + " vs " + c25085b2).toString());
            AppMethodBeat.m2505o(122186);
            throw illegalStateException;
        }
    }

    private final List<C31642l> ejM() {
        return (List) C17310h.m26799a(this.BFY, eQB[0]);
    }

    public abstract List<C8083t> dYw();

    public C0139e(C25212i c25212i, C46865e c46865e) {
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c46865e, "containingClass");
        this.BFZ = c46865e;
        this.BFY = c25212i.mo31373i(new C0140a(this));
    }

    /* renamed from: a */
    public final Collection<C31642l> mo220a(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        if (c0136d.mo228UI(C0136d.BFM.BFy)) {
            return ejM();
        }
        return C17115v.AUP;
    }

    /* renamed from: b */
    public final Collection<C41397al> mo221b(C37022f c37022f, C8085a c8085a) {
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        Collection arrayList = new ArrayList();
        for (Object next : ejM()) {
            if (next instanceof C41397al) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Object next2 : (List) arrayList) {
            if (C25052j.m39373j(((C41397al) next2).dZg(), c37022f)) {
                arrayList2.add(next2);
            }
        }
        return (List) arrayList2;
    }

    /* renamed from: a */
    public final Collection<C31220ah> mo219a(C37022f c37022f, C8085a c8085a) {
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        Collection arrayList = new ArrayList();
        for (Object next : ejM()) {
            if (next instanceof C31220ah) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Object next2 : (List) arrayList) {
            if (C25052j.m39373j(((C31220ah) next2).dZg(), c37022f)) {
                arrayList2.add(next2);
            }
        }
        return (List) arrayList2;
    }
}
