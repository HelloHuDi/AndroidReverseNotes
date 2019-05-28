package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C44847aa;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.C0037k;
import p000a.p010i.p011b.p012a.p015c.p018b.C17159aq;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C31643m;
import p000a.p010i.p011b.p012a.p015c.p018b.C36963d;
import p000a.p010i.p011b.p012a.p015c.p018b.C36965o;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C6134i;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41442g;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.ag */
public final class C8066ag extends C36961p implements C25086af {
    public static final C8067a Bjq = new C8067a();
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C8066ag.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    final C25212i Baf;
    private final C41442g Bjn;
    private C36963d Bjo;
    final C17159aq Bjp;

    /* renamed from: a.i.b.a.c.b.c.ag$a */
    public static final class C8067a {
        private C8067a() {
        }

        public /* synthetic */ C8067a(byte b) {
            this();
        }

        /* renamed from: a */
        static C25227au m14244a(C17159aq c17159aq) {
            AppMethodBeat.m2504i(119590);
            if (c17159aq.dZR() == null) {
                AppMethodBeat.m2505o(119590);
                return null;
            }
            C25227au aw = C25227au.m39766aw(c17159aq.dZQ());
            AppMethodBeat.m2505o(119590);
            return aw;
        }
    }

    /* renamed from: a.i.b.a.c.b.c.ag$b */
    static final class C8068b extends C25053k implements C31214a<C8066ag> {
        final /* synthetic */ C8066ag Bjr;
        final /* synthetic */ C36963d Bjs;

        C8068b(C8066ag c8066ag, C36963d c36963d) {
            this.Bjr = c8066ag;
            this.Bjs = c36963d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119591);
            C25212i c25212i = this.Bjr.Baf;
            C17159aq c17159aq = this.Bjr.Bjp;
            C36963d c36963d = this.Bjs;
            C25086af c25086af = this.Bjr;
            C0026g dYn = this.Bjs.dYn();
            C8063a dYZ = this.Bjs.dYZ();
            C25052j.m39375o(dYZ, "underlyingConstructorDescriptor.kind");
            C41398am dYo = this.Bjr.Bjp.dYo();
            C25052j.m39375o(dYo, "typeAliasDescriptor.source");
            C8066ag c8066ag = new C8066ag(c25212i, c17159aq, c36963d, c25086af, dYn, dYZ, dYo, (byte) 0);
            C8067a c8067a = C8066ag.Bjq;
            C25227au a = C8067a.m14244a(this.Bjr.Bjp);
            if (a == null) {
                AppMethodBeat.m2505o(119591);
                return null;
            }
            C41396ak dYR = this.Bjs.dYR();
            c8066ag.mo58963a(null, dYR != null ? dYR.mo31269e(a) : null, this.Bjr.Bjp.dYq(), this.Bjr.BhM, this.Bjr.dYT(), C44879w.FINAL, this.Bjr.Bjp.dYf());
            AppMethodBeat.m2505o(119591);
            return c8066ag;
        }
    }

    static {
        AppMethodBeat.m2504i(119592);
        AppMethodBeat.m2505o(119592);
    }

    private C8066ag(C25212i c25212i, C17159aq c17159aq, C36963d c36963d, C25086af c25086af, C0026g c0026g, C8063a c8063a, C41398am c41398am) {
        super(c17159aq, c25086af, c0026g, C37022f.avZ("<init>"), c8063a, c41398am);
        AppMethodBeat.m2504i(119608);
        this.Baf = c25212i;
        this.Bjp = c17159aq;
        this.BhW = this.Bjp.dYl();
        this.Bjn = this.Baf.mo31374j(new C8068b(this, c36963d));
        this.Bjo = c36963d;
        AppMethodBeat.m2505o(119608);
    }

    public /* synthetic */ C8066ag(C25212i c25212i, C17159aq c17159aq, C36963d c36963d, C25086af c25086af, C0026g c0026g, C8063a c8063a, C41398am c41398am, byte b) {
        this(c25212i, c17159aq, c36963d, c25086af, c0026g, c8063a, c41398am);
    }

    /* renamed from: a */
    public final /* synthetic */ C25085b mo17863a(C31642l c31642l, C44879w c44879w, C25082az c25082az, C8063a c8063a) {
        AppMethodBeat.m2504i(119605);
        C25085b d = m14236d(c31642l, c44879w, c25082az, c8063a, false);
        AppMethodBeat.m2505o(119605);
        return d;
    }

    /* renamed from: a */
    public final /* synthetic */ C36961p mo91a(C31642l c31642l, C8083t c8083t, C8063a c8063a, C37022f c37022f, C0026g c0026g, C41398am c41398am) {
        Object obj = 1;
        AppMethodBeat.m2504i(119607);
        C25052j.m39376p(c31642l, "newOwner");
        C25052j.m39376p(c8063a, "kind");
        C25052j.m39376p(c0026g, "annotations");
        C25052j.m39376p(c41398am, "source");
        Object obj2 = (c8063a == C8063a.DECLARATION || c8063a == C8063a.SYNTHESIZED) ? 1 : null;
        Throwable assertionError;
        if (C44847aa.AUz && obj2 == null) {
            assertionError = new AssertionError("Creating a type alias constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + c31642l + "\nkind: " + c8063a);
            AppMethodBeat.m2505o(119607);
            throw assertionError;
        }
        if (c37022f != null) {
            obj = null;
        }
        if (C44847aa.AUz && obj == null) {
            assertionError = new AssertionError("Renaming type alias constructor: ".concat(String.valueOf(this)));
            AppMethodBeat.m2505o(119607);
            throw assertionError;
        }
        C36961p c8066ag = new C8066ag(this.Baf, this.Bjp, this.Bjo, this, c0026g, C8063a.DECLARATION, c41398am);
        AppMethodBeat.m2505o(119607);
        return c8066ag;
    }

    /* renamed from: b */
    public final /* synthetic */ C0037k mo75b(C25227au c25227au) {
        AppMethodBeat.m2504i(119603);
        C0037k i = m14237i(c25227au);
        AppMethodBeat.m2505o(119603);
        return i;
    }

    /* renamed from: b */
    public final /* synthetic */ C8083t mo17864b(C31642l c31642l, C44879w c44879w, C25082az c25082az, C8063a c8063a, boolean z) {
        AppMethodBeat.m2504i(119606);
        C8083t d = m14236d(c31642l, c44879w, c25082az, c8063a, z);
        AppMethodBeat.m2505o(119606);
        return d;
    }

    /* renamed from: c */
    public final /* synthetic */ C8083t mo17865c(C25227au c25227au) {
        AppMethodBeat.m2504i(119602);
        C8083t i = m14237i(c25227au);
        AppMethodBeat.m2505o(119602);
        return i;
    }

    public final /* synthetic */ C8045a dYU() {
        AppMethodBeat.m2504i(119597);
        C8045a eaM = eaM();
        AppMethodBeat.m2505o(119597);
        return eaM;
    }

    public final /* synthetic */ C25085b dYY() {
        AppMethodBeat.m2504i(119598);
        C25085b eaM = eaM();
        AppMethodBeat.m2505o(119598);
        return eaM;
    }

    public final /* synthetic */ C31642l dZd() {
        AppMethodBeat.m2504i(119595);
        C31642l eaM = eaM();
        AppMethodBeat.m2505o(119595);
        return eaM;
    }

    public final /* synthetic */ C8083t dZp() {
        AppMethodBeat.m2504i(119599);
        C8083t eaM = eaM();
        AppMethodBeat.m2505o(119599);
        return eaM;
    }

    public final /* synthetic */ C36965o ean() {
        AppMethodBeat.m2504i(119596);
        C36965o eaM = eaM();
        AppMethodBeat.m2505o(119596);
        return eaM;
    }

    /* renamed from: f */
    public final /* synthetic */ C31643m mo17870f(C25227au c25227au) {
        AppMethodBeat.m2504i(119601);
        C31643m i = m14237i(c25227au);
        AppMethodBeat.m2505o(119601);
        return i;
    }

    public final C36963d eaL() {
        return this.Bjo;
    }

    public final C46867w dYT() {
        AppMethodBeat.m2504i(119593);
        C46867w dYT = super.dYT();
        if (dYT == null) {
            C25052j.dWJ();
        }
        AppMethodBeat.m2505o(119593);
        return dYT;
    }

    private C25086af eaM() {
        AppMethodBeat.m2504i(119594);
        C8083t dZp = super.ean();
        if (dZp == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
            AppMethodBeat.m2505o(119594);
            throw c44941v;
        }
        C25086af c25086af = (C25086af) dZp;
        AppMethodBeat.m2505o(119594);
        return c25086af;
    }

    /* renamed from: i */
    private C25086af m14237i(C25227au c25227au) {
        AppMethodBeat.m2504i(119600);
        C25052j.m39376p(c25227au, "substitutor");
        C8083t c = super.mo17870f(c25227au);
        if (c == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
            AppMethodBeat.m2505o(119600);
            throw c44941v;
        }
        C8066ag c8066ag = (C8066ag) c;
        C25227au aw = C25227au.m39766aw(c8066ag.dYT());
        C25052j.m39375o(aw, "TypeSubstitutor.create(s…asConstructor.returnType)");
        C36963d a = this.Bjo.dZj().mo58972a(aw);
        if (a == null) {
            AppMethodBeat.m2505o(119600);
            return null;
        }
        c8066ag.Bjo = a;
        C25086af c25086af = c8066ag;
        AppMethodBeat.m2505o(119600);
        return c25086af;
    }

    /* renamed from: d */
    private C25086af m14236d(C31642l c31642l, C44879w c44879w, C25082az c25082az, C8063a c8063a, boolean z) {
        AppMethodBeat.m2504i(119604);
        C25052j.m39376p(c31642l, "newOwner");
        C25052j.m39376p(c44879w, "modality");
        C25052j.m39376p(c25082az, "visibility");
        C25052j.m39376p(c8063a, "kind");
        C8083t dZC = dZw().mo17915g(c31642l).mo17904a(c44879w).mo17902a(c25082az).mo17903a(c8063a).mo17916rG(z).dZC();
        if (dZC == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
            AppMethodBeat.m2505o(119604);
            throw c44941v;
        }
        C25086af c25086af = (C25086af) dZC;
        AppMethodBeat.m2505o(119604);
        return c25086af;
    }

    public final /* bridge */ /* synthetic */ C31642l dXW() {
        return this.Bjp;
    }

    public final /* bridge */ /* synthetic */ C6134i dZo() {
        return this.Bjp;
    }
}
