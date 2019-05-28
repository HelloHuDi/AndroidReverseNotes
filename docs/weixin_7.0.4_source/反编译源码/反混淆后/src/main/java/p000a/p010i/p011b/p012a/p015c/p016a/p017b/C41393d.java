package p000a.p010i.p011b.p012a.p015c.p016a.p017b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C25031ak;
import p000a.p001a.C25033k;
import p000a.p001a.C25035t;
import p000a.p001a.C44629x;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p016a.C8033c;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C44633h;
import p000a.p010i.p011b.p012a.p015c.p018b.p775b.C17160b;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.a.b.d */
public final class C41393d implements C17160b {
    public static final C0022a BdA = new C0022a();
    private static final C8174b Bdx = C31619g.AZV;
    private static final C37022f Bdy;
    private static final C8173a Bdz;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C41393d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    private final C41441f Bdu;
    private final C25093y Bdv;
    private final C17126b<C25093y, C31642l> Bdw;

    /* renamed from: a.i.b.a.c.a.b.d$a */
    public static final class C0022a {
        private C0022a() {
        }

        public /* synthetic */ C0022a(byte b) {
            this();
        }
    }

    /* renamed from: a.i.b.a.c.a.b.d$b */
    static final class C17145b extends C25053k implements C31214a<C44633h> {
        final /* synthetic */ C41393d BdC;
        final /* synthetic */ C25212i BdD;

        C17145b(C41393d c41393d, C25212i c25212i) {
            this.BdC = c41393d;
            this.BdD = c25212i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119193);
            C44633h c44633h = new C44633h((C31642l) this.BdC.Bdw.mo50am(this.BdC.Bdv), C41393d.Bdy, C44879w.ABSTRACT, C36964f.INTERFACE, C25033k.listOf(this.BdC.Bdv.dZD().dXM()), C41398am.BeR, this.BdD);
            c44633h.mo71682a(new C41388a(this.BdD, c44633h), C44629x.AUR, null);
            AppMethodBeat.m2505o(119193);
            return c44633h;
        }
    }

    /* renamed from: a.i.b.a.c.a.b.d$1 */
    static final class C312181 extends C25053k implements C17126b<C25093y, C8033c> {
        public static final C312181 BdB = new C312181();

        static {
            AppMethodBeat.m2504i(119192);
            AppMethodBeat.m2505o(119192);
        }

        C312181() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119191);
            C25093y c25093y = (C25093y) obj;
            C25052j.m39376p(c25093y, "module");
            C8174b dYE = C41393d.Bdx;
            C25052j.m39375o(dYE, "KOTLIN_FQ_NAME");
            Collection arrayList = new ArrayList();
            for (Object next : c25093y.mo252g(dYE).getFragments()) {
                if (next instanceof C8033c) {
                    arrayList.add(next);
                }
            }
            C8033c c8033c = (C8033c) C25035t.m39337fJ((List) arrayList);
            AppMethodBeat.m2505o(119191);
            return c8033c;
        }
    }

    private final C44633h dYC() {
        AppMethodBeat.m2504i(119195);
        C44633h c44633h = (C44633h) C17310h.m26799a(this.Bdu, eQB[0]);
        AppMethodBeat.m2505o(119195);
        return c44633h;
    }

    private C41393d(C25212i c25212i, C25093y c25093y, C17126b<? super C25093y, ? extends C31642l> c17126b) {
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c25093y, "moduleDescriptor");
        C25052j.m39376p(c17126b, "computeContainingDeclaration");
        AppMethodBeat.m2504i(119199);
        this.Bdv = c25093y;
        this.Bdw = c17126b;
        this.Bdu = c25212i.mo31373i(new C17145b(this, c25212i));
        AppMethodBeat.m2505o(119199);
    }

    public /* synthetic */ C41393d(C25212i c25212i, C25093y c25093y) {
        this(c25212i, c25093y, C312181.BdB);
        AppMethodBeat.m2504i(119200);
        AppMethodBeat.m2505o(119200);
    }

    /* renamed from: a */
    public final boolean mo31259a(C8174b c8174b, C37022f c37022f) {
        AppMethodBeat.m2504i(119196);
        C25052j.m39376p(c8174b, "packageFqName");
        C25052j.m39376p(c37022f, "name");
        if (C25052j.m39373j(c37022f, Bdy) && C25052j.m39373j(c8174b, Bdx)) {
            AppMethodBeat.m2505o(119196);
            return true;
        }
        AppMethodBeat.m2505o(119196);
        return false;
    }

    /* renamed from: e */
    public final C46865e mo31261e(C8173a c8173a) {
        AppMethodBeat.m2504i(119197);
        C25052j.m39376p(c8173a, "classId");
        if (C25052j.m39373j(c8173a, Bdz)) {
            C46865e dYC = dYC();
            AppMethodBeat.m2505o(119197);
            return dYC;
        }
        AppMethodBeat.m2505o(119197);
        return null;
    }

    /* renamed from: d */
    public final Collection<C46865e> mo31260d(C8174b c8174b) {
        AppMethodBeat.m2504i(119198);
        C25052j.m39376p(c8174b, "packageFqName");
        if (C25052j.m39373j(c8174b, Bdx)) {
            Collection of = C25031ak.setOf(dYC());
            AppMethodBeat.m2505o(119198);
            return of;
        }
        Collection<C46865e> collection = C44629x.AUR;
        AppMethodBeat.m2505o(119198);
        return collection;
    }

    static {
        AppMethodBeat.m2504i(119194);
        C37022f ehK = C31619g.Bag.Bao.ehK();
        C25052j.m39375o(ehK, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
        Bdy = ehK;
        C8173a n = C8173a.m14427n(C31619g.Bag.Bao.ehI());
        C25052j.m39375o(n, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
        Bdz = n;
        AppMethodBeat.m2505o(119194);
    }
}
