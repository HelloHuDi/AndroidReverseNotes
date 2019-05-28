package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p000a.C8312u;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C31586ag;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44876g;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C31640x;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C0056f;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C0057h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C25106a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C0060t;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44635g;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C36996s;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8143n;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8147o;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.p032a.C8134a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C41436b;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.c.a.h */
public final class C36974h extends C31640x {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C36974h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C36974h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    private final C0026g Bfn;
    private final C0057h Bnn;
    private final C41441f Bop = this.Bnn.Bnv.Baf.mo31373i(new C31543a(this));
    private final C8095d Boq = new C8095d(this.Bnn, this.Bot, this);
    public final C41441f<List<C8174b>> Bor = this.Bnn.Bnv.Baf.mo31369a(new C36975c(this), C17115v.AUP);
    private final C41441f Bos;
    private final C0060t Bot;

    /* renamed from: a.i.b.a.c.d.a.c.a.h$b */
    static final class C17178b extends C25053k implements C31214a<HashMap<C41436b, C41436b>> {
        final /* synthetic */ C36974h Bou;

        C17178b(C36974h c36974h) {
            this.Bou = c36974h;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119959);
            HashMap hashMap = new HashMap();
            for (Entry entry : this.Bou.ebv().entrySet()) {
                String str = (String) entry.getKey();
                C8143n c8143n = (C8143n) entry.getValue();
                C41436b awj = C41436b.awj(str);
                C25052j.m39375o(awj, "JvmClassName.byInternalName(partInternalName)");
                C8134a dXA = c8143n.dXA();
                switch (C44881i.eQZ[dXA.Bsc.ordinal()]) {
                    case 1:
                        Map map = hashMap;
                        String ecv = dXA.ecv();
                        if (ecv == null) {
                            break;
                        }
                        C41436b awj2 = C41436b.awj(ecv);
                        C25052j.m39375o(awj2, "JvmClassName.byInternalN…: continue@kotlinClasses)");
                        map.put(awj, awj2);
                        break;
                    case 2:
                        hashMap.put(awj, awj);
                        break;
                    default:
                        break;
                }
            }
            AppMethodBeat.m2505o(119959);
            return hashMap;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.c.a.h$a */
    static final class C31543a extends C25053k implements C31214a<Map<String, ? extends C8143n>> {
        final /* synthetic */ C36974h Bou;

        C31543a(C36974h c36974h) {
            this.Bou = c36974h;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119958);
            C36996s c36996s = this.Bou.Bnn.Bnv.Bnb;
            String str = this.Bou.BfP.ByQ.ByV;
            C25052j.m39375o(str, "fqName.asString()");
            Iterable<String> avA = c36996s.avA(str);
            Collection arrayList = new ArrayList();
            for (String str2 : avA) {
                Object I;
                C41436b awj = C41436b.awj(str2);
                C25052j.m39375o(awj, "JvmClassName.byInternalName(partName)");
                C8173a n = C8173a.m14427n(new C8174b(awj.BrD.replace(IOUtils.DIR_SEPARATOR_UNIX, '.')));
                C25052j.m39375o(n, "ClassId.topLevel(JvmClas…velClassMaybeWithDollars)");
                C8143n b = this.Bou.Bnn.Bnv.BmS.mo17820b(n);
                if (b != null) {
                    I = C8312u.m14628I(str2, b);
                } else {
                    I = null;
                }
                if (I != null) {
                    arrayList.add(I);
                }
            }
            Map v = C31586ag.m51052v((List) arrayList);
            AppMethodBeat.m2505o(119958);
            return v;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.c.a.h$c */
    static final class C36975c extends C25053k implements C31214a<List<? extends C8174b>> {
        final /* synthetic */ C36974h Bou;

        C36975c(C36974h c36974h) {
            this.Bou = c36974h;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119960);
            Iterable<C0060t> ebZ = this.Bou.Bot.ebZ();
            Collection arrayList = new ArrayList(C25034m.m39318d(ebZ));
            for (C0060t dZF : ebZ) {
                arrayList.add(dZF.dZF());
            }
            List list = (List) arrayList;
            AppMethodBeat.m2505o(119960);
            return list;
        }
    }

    static {
        AppMethodBeat.m2504i(119961);
        AppMethodBeat.m2505o(119961);
    }

    public final Map<String, C8143n> ebv() {
        AppMethodBeat.m2504i(119962);
        Map map = (Map) C17310h.m26799a(this.Bop, eQB[0]);
        AppMethodBeat.m2505o(119962);
        return map;
    }

    public final C0026g dYn() {
        return this.Bfn;
    }

    /* renamed from: c */
    public final C46865e mo58979c(C44635g c44635g) {
        AppMethodBeat.m2504i(119963);
        C25052j.m39376p(c44635g, "jClass");
        C31653j c31653j = this.Boq.BnN;
        C25052j.m39376p(c44635g, "javaClass");
        C46865e a = c31653j.mo51638a(c44635g.dZg(), c44635g);
        AppMethodBeat.m2505o(119963);
        return a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(119964);
        String str = "Lazy Java package fragment: " + this.BfP;
        AppMethodBeat.m2505o(119964);
        return str;
    }

    public final C41398am dYo() {
        AppMethodBeat.m2504i(119965);
        C41398am c8147o = new C8147o(this);
        AppMethodBeat.m2505o(119965);
        return c8147o;
    }

    public final /* bridge */ /* synthetic */ C31746h dXR() {
        return this.Boq;
    }

    public C36974h(C0057h c0057h, C0060t c0060t) {
        C0026g eai;
        C25052j.m39376p(c0057h, "outerContext");
        C25052j.m39376p(c0060t, "jPackage");
        super(c0057h.Bnv.BcH, c0060t.dZF());
        AppMethodBeat.m2504i(119966);
        this.Bot = c0060t;
        this.Bnn = C25106a.m39483a(c0057h, (C44876g) this, null, 6);
        if (this.Bnn.Bnv.Bne.Bke) {
            C0027a c0027a = C0026g.BfJ;
            eai = C0027a.eai();
        } else {
            eai = C0056f.m61a(this.Bnn, this.Bot);
        }
        this.Bfn = eai;
        this.Bos = this.Bnn.Bnv.Baf.mo31373i(new C17178b(this));
        AppMethodBeat.m2505o(119966);
    }
}
