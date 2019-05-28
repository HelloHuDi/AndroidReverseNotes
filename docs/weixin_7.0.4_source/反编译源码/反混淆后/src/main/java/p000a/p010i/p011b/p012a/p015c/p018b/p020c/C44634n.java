package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C36963d;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C0039c;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p037i.C31747j;
import p000a.p010i.p011b.p012a.p015c.p037i.C37038h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0136d;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h.C17288b;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C37037i;
import p000a.p010i.p011b.p012a.p015c.p044k.C24619c;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C41453e;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.n */
public class C44634n extends C41405g {
    static final /* synthetic */ boolean $assertionsDisabled = (!C44634n.class.desiredAssertionStatus());
    private final C0026g Bfn;
    private final C31746h BhC;
    private final C41441f<Set<C37022f>> BhD;
    final C17313an Bhx;

    /* renamed from: a.i.b.a.c.b.c.n$a */
    class C8071a extends C37037i {
        static final /* synthetic */ boolean $assertionsDisabled = (!C44634n.class.desiredAssertionStatus());
        private final C24619c<C37022f, Collection<C41397al>> BhE;
        private final C24619c<C37022f, Collection<C31220ah>> BhF;
        private final C41441f<Collection<C31642l>> BhG;

        static {
            AppMethodBeat.m2504i(119450);
            AppMethodBeat.m2505o(119450);
        }

        public C8071a(C25212i c25212i) {
            AppMethodBeat.m2504i(119439);
            this.BhE = c25212i.mo31371f(new C17126b<C37022f, Collection<C41397al>>(C44634n.this) {
                /* renamed from: am */
                public final /* synthetic */ Object mo50am(Object obj) {
                    AppMethodBeat.m2504i(119435);
                    Collection a = C8071a.m14249a(C8071a.this, (C37022f) obj);
                    AppMethodBeat.m2505o(119435);
                    return a;
                }
            });
            this.BhF = c25212i.mo31371f(new C17126b<C37022f, Collection<C31220ah>>(C44634n.this) {
                /* renamed from: am */
                public final /* synthetic */ Object mo50am(Object obj) {
                    AppMethodBeat.m2504i(119436);
                    Collection b = C8071a.m14250b(C8071a.this, (C37022f) obj);
                    AppMethodBeat.m2505o(119436);
                    return b;
                }
            });
            this.BhG = c25212i.mo31373i(new C31214a<Collection<C31642l>>(C44634n.this) {
                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(119437);
                    Collection a = C8071a.m14248a(C8071a.this);
                    AppMethodBeat.m2505o(119437);
                    return a;
                }
            });
            AppMethodBeat.m2505o(119439);
        }

        /* renamed from: a */
        public final Collection mo219a(C37022f c37022f, C8085a c8085a) {
            AppMethodBeat.m2504i(119440);
            Collection collection = (Collection) this.BhF.mo50am(c37022f);
            AppMethodBeat.m2505o(119440);
            return collection;
        }

        /* renamed from: b */
        public final Collection mo221b(C37022f c37022f, C8085a c8085a) {
            AppMethodBeat.m2504i(119441);
            Collection collection = (Collection) this.BhE.mo50am(c37022f);
            AppMethodBeat.m2505o(119441);
            return collection;
        }

        private C31746h eat() {
            AppMethodBeat.m2504i(119442);
            Collection eap = C44634n.this.Bhx.eap();
            if ($assertionsDisabled || eap.size() == 1) {
                C31746h dXR = ((C46867w) eap.iterator().next()).dXR();
                AppMethodBeat.m2505o(119442);
                return dXR;
            }
            AssertionError assertionError = new AssertionError("Enum entry and its companion object both should have exactly one supertype: ".concat(String.valueOf(eap)));
            AppMethodBeat.m2505o(119442);
            throw assertionError;
        }

        /* renamed from: l */
        private <D extends C25085b> Collection<D> m14251l(Collection<D> collection) {
            AppMethodBeat.m2504i(119443);
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            C31747j.m51406a((Collection) collection, Collections.emptySet(), C44634n.this, new C37038h() {
                /* renamed from: g */
                public final void mo232g(C25085b c25085b) {
                    AppMethodBeat.m2504i(119438);
                    C31747j.m51402a(c25085b, null);
                    linkedHashSet.add(c25085b);
                    AppMethodBeat.m2505o(119438);
                }

                /* renamed from: a */
                public final void mo231a(C25085b c25085b, C25085b c25085b2) {
                }
            });
            AppMethodBeat.m2505o(119443);
            return linkedHashSet;
        }

        /* renamed from: a */
        public final Collection<C31642l> mo220a(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
            AppMethodBeat.m2504i(119444);
            Collection collection = (Collection) this.BhG.invoke();
            AppMethodBeat.m2505o(119444);
            return collection;
        }

        public final Set<C37022f> eau() {
            AppMethodBeat.m2504i(119445);
            Set set = (Set) C44634n.this.BhD.invoke();
            AppMethodBeat.m2505o(119445);
            return set;
        }

        public final Set<C37022f> eav() {
            AppMethodBeat.m2504i(119446);
            Set set = (Set) C44634n.this.BhD.invoke();
            AppMethodBeat.m2505o(119446);
            return set;
        }

        /* renamed from: a */
        static /* synthetic */ Collection m14248a(C8071a c8071a) {
            AppMethodBeat.m2504i(119449);
            HashSet hashSet = new HashSet();
            for (C37022f c37022f : (Set) C44634n.this.BhD.invoke()) {
                hashSet.addAll(c8071a.mo221b(c37022f, C0039c.FOR_NON_TRACKED_SCOPE));
                hashSet.addAll(c8071a.mo219a(c37022f, C0039c.FOR_NON_TRACKED_SCOPE));
            }
            AppMethodBeat.m2505o(119449);
            return hashSet;
        }
    }

    static {
        AppMethodBeat.m2504i(119457);
        AppMethodBeat.m2505o(119457);
    }

    /* renamed from: a */
    public static C44634n m81056a(C25212i c25212i, C46865e c46865e, C37022f c37022f, C41441f<Set<C37022f>> c41441f, C0026g c0026g, C41398am c41398am) {
        AppMethodBeat.m2504i(119451);
        C44634n c44634n = new C44634n(c25212i, c46865e, c46865e.dZf(), c37022f, c41441f, c0026g, c41398am);
        AppMethodBeat.m2505o(119451);
        return c44634n;
    }

    private C44634n(C25212i c25212i, C46865e c46865e, C46867w c46867w, C37022f c37022f, C41441f<Set<C37022f>> c41441f, C0026g c0026g, C41398am c41398am) {
        super(c25212i, c46865e, c37022f, c41398am);
        AppMethodBeat.m2504i(119452);
        if ($assertionsDisabled || c46865e.dYc() == C36964f.ENUM_CLASS) {
            this.Bfn = c0026g;
            this.Bhx = new C41453e(this, Collections.emptyList(), Collections.singleton(c46867w), c25212i);
            this.BhC = new C8071a(c25212i);
            this.BhD = c41441f;
            AppMethodBeat.m2505o(119452);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(119452);
        throw assertionError;
    }

    public final C31746h dXZ() {
        return this.BhC;
    }

    public final C31746h dXX() {
        return C17288b.BGh;
    }

    public final Collection<C36963d> dYb() {
        AppMethodBeat.m2504i(119453);
        List emptyList = Collections.emptyList();
        AppMethodBeat.m2505o(119453);
        return emptyList;
    }

    public final C17313an dXY() {
        return this.Bhx;
    }

    public final C46865e dYa() {
        return null;
    }

    public final C36964f dYc() {
        return C36964f.ENUM_ENTRY;
    }

    public final C44879w dYd() {
        return C44879w.FINAL;
    }

    public final C25082az dYf() {
        return C8051ay.Bfa;
    }

    public final boolean dYh() {
        return false;
    }

    public final boolean dYi() {
        return false;
    }

    public final boolean dYj() {
        return false;
    }

    public final boolean dYg() {
        return false;
    }

    public final boolean dYk() {
        return false;
    }

    public final boolean dYl() {
        return false;
    }

    public final C36963d dYe() {
        return null;
    }

    public final C0026g dYn() {
        return this.Bfn;
    }

    public String toString() {
        AppMethodBeat.m2504i(119454);
        String str = "enum entry " + this.BgZ;
        AppMethodBeat.m2505o(119454);
        return str;
    }

    public final List<C36955ar> dYq() {
        AppMethodBeat.m2504i(119455);
        List emptyList = Collections.emptyList();
        AppMethodBeat.m2505o(119455);
        return emptyList;
    }

    public final Collection<C46865e> dYp() {
        AppMethodBeat.m2504i(119456);
        List emptyList = Collections.emptyList();
        AppMethodBeat.m2505o(119456);
        return emptyList;
    }
}
