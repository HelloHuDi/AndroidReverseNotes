package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import p000a.C31824m;
import p000a.p001a.C17115v;
import p000a.p001a.C44629x;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C0039c;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C0057h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a.C41406b.C36973a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C0060t;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41409aa;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44635g;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8143n;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0136d;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0136d.C0137a;
import p000a.p010i.p011b.p012a.p015c.p044k.C41439d;
import p000a.p010i.p011b.p012a.p015c.p044k.C41442g;
import p000a.p010i.p011b.p012a.p015c.p048n.C8256d;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C37023h;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.c.a.j */
public final class C31653j extends C0054m {
    private final C0060t Bot;
    private final C41442g<Set<String>> Bov;
    private final C41439d<C31654a, C46865e> Bow;
    final C36974h Box;

    /* renamed from: a.i.b.a.c.d.a.c.a.j$d */
    static final class C31544d extends C25053k implements C31214a<Set<? extends String>> {
        final /* synthetic */ C0057h BlU;
        final /* synthetic */ C31653j BoB;

        C31544d(C31653j c31653j, C0057h c0057h) {
            this.BoB = c31653j;
            this.BlU = c0057h;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119974);
            Set b = this.BlU.Bnv.BmR.mo17929b(this.BoB.Box.BfP);
            AppMethodBeat.m2505o(119974);
            return b;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.c.a.j$a */
    static final class C31654a {
        final C37022f BgZ;
        final C44635g Boy;

        public C31654a(C37022f c37022f, C44635g c44635g) {
            C25052j.m39376p(c37022f, "name");
            AppMethodBeat.m2504i(119969);
            this.BgZ = c37022f;
            this.Boy = c44635g;
            AppMethodBeat.m2505o(119969);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(119967);
            if ((obj instanceof C31654a) && C25052j.m39373j(this.BgZ, ((C31654a) obj).BgZ)) {
                AppMethodBeat.m2505o(119967);
                return true;
            }
            AppMethodBeat.m2505o(119967);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(119968);
            int hashCode = this.BgZ.hashCode();
            AppMethodBeat.m2505o(119968);
            return hashCode;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.c.a.j$c */
    static final class C31655c extends C25053k implements C17126b<C31654a, C46865e> {
        final /* synthetic */ C0057h BlU;
        final /* synthetic */ C31653j BoB;

        C31655c(C31653j c31653j, C0057h c0057h) {
            this.BoB = c31653j;
            this.BlU = c0057h;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            C8143n a;
            C8173a dWY;
            AppMethodBeat.m2504i(119973);
            C31654a c31654a = (C31654a) obj;
            C25052j.m39376p(c31654a, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            C8173a c8173a = new C8173a(this.BoB.Box.BfP, c31654a.BgZ);
            if (c31654a.Boy != null) {
                a = this.BlU.Bnv.BmS.mo17819a(c31654a.Boy);
            } else {
                a = this.BlU.Bnv.BmS.mo17820b(c8173a);
            }
            if (a != null) {
                dWY = a.dWY();
            } else {
                dWY = null;
            }
            if (dWY == null || !(dWY.ehD() || dWY.ByO)) {
                C31656b a2 = C31653j.m51199a(this.BoB, a);
                if (a2 instanceof C8109a) {
                    Object obj2 = ((C8109a) a2).Biz;
                    AppMethodBeat.m2505o(119973);
                    return obj2;
                } else if (a2 instanceof C31657c) {
                    AppMethodBeat.m2505o(119973);
                    return null;
                } else if (a2 instanceof C25105b) {
                    Object a3;
                    C44635g c44635g = c31654a.Boy;
                    if (c44635g == null) {
                        a3 = this.BlU.Bnv.BmR.mo17927a(c8173a);
                    } else {
                        C44635g a32 = c44635g;
                    }
                    if (C41409aa.BINARY == null) {
                        Throwable illegalStateException = new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + a32 + 10 + "ClassId: " + c8173a + 10 + "findKotlinClass(JavaClass) = " + this.BlU.Bnv.BmS.mo17819a(a32) + 10 + "findKotlinClass(ClassId) = " + this.BlU.Bnv.BmS.mo17820b(c8173a) + 10);
                        AppMethodBeat.m2505o(119973);
                        throw illegalStateException;
                    }
                    C8174b dZF;
                    Object obj3;
                    if (a32 != null) {
                        dZF = a32.dZF();
                    } else {
                        dZF = null;
                    }
                    if (dZF == null || dZF.ByQ.ByV.isEmpty() || (C25052j.m39373j(dZF.ehG(), this.BoB.Box.BfP) ^ 1) != 0) {
                        obj3 = null;
                    } else {
                        C8101f c8101f = new C8101f(this.BlU, this.BoB.Box, a32);
                        this.BlU.Bnv.Bng.mo58989a(c8101f);
                        C8101f obj32 = c8101f;
                    }
                    C46865e c46865e = (C46865e) obj32;
                    AppMethodBeat.m2505o(119973);
                    return c46865e;
                } else {
                    C31824m c31824m = new C31824m();
                    AppMethodBeat.m2505o(119973);
                    throw c31824m;
                }
            }
            AppMethodBeat.m2505o(119973);
            return null;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.c.a.j$b */
    static abstract class C31656b {

        /* renamed from: a.i.b.a.c.d.a.c.a.j$b$a */
        public static final class C8109a extends C31656b {
            final C46865e Biz;

            public C8109a(C46865e c46865e) {
                C25052j.m39376p(c46865e, "descriptor");
                super();
                AppMethodBeat.m2504i(119970);
                this.Biz = c46865e;
                AppMethodBeat.m2505o(119970);
            }
        }

        /* renamed from: a.i.b.a.c.d.a.c.a.j$b$b */
        public static final class C25105b extends C31656b {
            public static final C25105b Boz = new C25105b();

            static {
                AppMethodBeat.m2504i(119971);
                AppMethodBeat.m2505o(119971);
            }

            private C25105b() {
                super();
            }
        }

        /* renamed from: a.i.b.a.c.d.a.c.a.j$b$c */
        public static final class C31657c extends C31656b {
            public static final C31657c BoA = new C31657c();

            static {
                AppMethodBeat.m2504i(119972);
                AppMethodBeat.m2505o(119972);
            }

            private C31657c() {
                super();
            }
        }

        private C31656b() {
        }

        public /* synthetic */ C31656b(byte b) {
            this();
        }
    }

    public C31653j(C0057h c0057h, C0060t c0060t, C36974h c36974h) {
        C25052j.m39376p(c0057h, "c");
        C25052j.m39376p(c0060t, "jPackage");
        C25052j.m39376p(c36974h, "ownerDescriptor");
        super(c0057h);
        AppMethodBeat.m2504i(119984);
        this.Bot = c0060t;
        this.Box = c36974h;
        this.Bov = c0057h.Bnv.Baf.mo31374j(new C31544d(this, c0057h));
        this.Bow = c0057h.Bnv.Baf.mo31372g(new C31655c(this, c0057h));
        AppMethodBeat.m2505o(119984);
    }

    /* renamed from: e */
    public final C46865e mo51639e(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(119975);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        C46865e a = mo51638a(c37022f, null);
        AppMethodBeat.m2505o(119975);
        return a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C46865e mo51638a(C37022f c37022f, C44635g c44635g) {
        AppMethodBeat.m2504i(119977);
        if (C37023h.m61940x(c37022f)) {
            Set set = (Set) this.Bov.invoke();
            if (c44635g != null || set == null || set.contains(c37022f.name)) {
                C46865e c46865e = (C46865e) this.Bow.mo50am(new C31654a(c37022f, c44635g));
                AppMethodBeat.m2505o(119977);
                return c46865e;
            }
            AppMethodBeat.m2505o(119977);
            return null;
        }
        AppMethodBeat.m2505o(119977);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final C41406b ebt() {
        return C36973a.BnM;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final Set<C37022f> mo13651c(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
        AppMethodBeat.m2504i(119979);
        C25052j.m39376p(c0136d, "kindFilter");
        C0137a c0137a = C0136d.BFX;
        if (c0136d.mo228UI(C0136d.BFB)) {
            Set<String> set = (Set) this.Bov.invoke();
            Collection hashSet;
            Set<C37022f> set2;
            if (set != null) {
                hashSet = new HashSet();
                for (String avX : set) {
                    hashSet.add(C37022f.avX(avX));
                }
                set2 = (Set) hashSet;
                AppMethodBeat.m2505o(119979);
                return set2;
            }
            C0060t c0060t = this.Bot;
            if (c17126b == null) {
                C17126b c17126b2 = C8256d.eku();
            }
            hashSet = new LinkedHashSet();
            for (C44635g c44635g : c0060t.mo105d(c17126b2)) {
                Object obj;
                if (C41409aa.SOURCE == null) {
                    obj = null;
                } else {
                    obj = c44635g.dZg();
                }
                if (obj != null) {
                    hashSet.add(obj);
                }
            }
            set2 = (Set) hashSet;
            AppMethodBeat.m2505o(119979);
            return set2;
        }
        Set<C37022f> set3 = C44629x.AUR;
        AppMethodBeat.m2505o(119979);
        return set3;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo13649a(Collection<C41397al> collection, C37022f c37022f) {
        AppMethodBeat.m2504i(119981);
        C25052j.m39376p(collection, "result");
        C25052j.m39376p(c37022f, "name");
        AppMethodBeat.m2505o(119981);
    }

    /* renamed from: a */
    public final Collection<C31642l> mo220a(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
        AppMethodBeat.m2504i(119983);
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        Collection a = mo51643a(c0136d, (C17126b) c17126b, (C8085a) C0039c.WHEN_GET_ALL_DESCRIPTORS);
        AppMethodBeat.m2505o(119983);
        return a;
    }

    /* renamed from: a */
    public final Collection<C31220ah> mo219a(C37022f c37022f, C8085a c8085a) {
        AppMethodBeat.m2504i(119978);
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(c8085a, C8741b.LOCATION);
        Collection collection = C17115v.AUP;
        AppMethodBeat.m2505o(119978);
        return collection;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final Set<C37022f> mo13650b(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
        AppMethodBeat.m2504i(119980);
        C25052j.m39376p(c0136d, "kindFilter");
        Set set = C44629x.AUR;
        AppMethodBeat.m2505o(119980);
        return set;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final Set<C37022f> mo13648a(C0136d c0136d) {
        AppMethodBeat.m2504i(119982);
        C25052j.m39376p(c0136d, "kindFilter");
        Set set = C44629x.AUR;
        AppMethodBeat.m2505o(119982);
        return set;
    }

    public final /* bridge */ /* synthetic */ C31642l ebu() {
        return this.Box;
    }
}
