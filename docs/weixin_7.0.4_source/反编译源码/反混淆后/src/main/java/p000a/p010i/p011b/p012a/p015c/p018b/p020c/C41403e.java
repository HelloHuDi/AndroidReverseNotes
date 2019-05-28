package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p000a.p005f.p006a.C31214a;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C36965o;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44877n;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31745g;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C8207m;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C37055c;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.e */
public abstract class C41403e extends C17168k implements C36955ar {
    private final C41441f<C8235ad> Bha;
    final C0163ba Bhj;
    final boolean Bhk;
    private final C41441f<C17313an> Bhl;
    private final int index;

    /* renamed from: a.i.b.a.c.b.c.e$a */
    class C0033a extends C37055c {
        private final C17157ap Bhr;

        public C0033a(C25212i c25212i, C17157ap c17157ap) {
            super(c25212i);
            this.Bhr = c17157ap;
        }

        public final Collection<C46867w> dYr() {
            AppMethodBeat.m2504i(119391);
            List eaq = C41403e.this.eaq();
            AppMethodBeat.m2505o(119391);
            return eaq;
        }

        public final List<C36955ar> getParameters() {
            AppMethodBeat.m2504i(119392);
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(119392);
            return emptyList;
        }

        public final boolean dYu() {
            return true;
        }

        public final C0036h dYs() {
            return C41403e.this;
        }

        public final C31619g dZD() {
            AppMethodBeat.m2504i(119393);
            C31619g G = C41434a.m72275G(C41403e.this);
            AppMethodBeat.m2505o(119393);
            return G;
        }

        public final String toString() {
            AppMethodBeat.m2504i(119394);
            String c37022f = C41403e.this.BgZ.toString();
            AppMethodBeat.m2505o(119394);
            return c37022f;
        }

        public final C17157ap dYv() {
            return this.Bhr;
        }

        /* renamed from: J */
        public final void mo60J(C46867w c46867w) {
            AppMethodBeat.m2504i(119395);
            C41403e.this.mo101J(c46867w);
            AppMethodBeat.m2505o(119395);
        }

        public final C46867w ear() {
            AppMethodBeat.m2504i(119396);
            C8235ad awn = C25235p.awn("Cyclic upper bounds");
            AppMethodBeat.m2505o(119396);
            return awn;
        }
    }

    /* renamed from: J */
    public abstract void mo101J(C46867w c46867w);

    public abstract List<C46867w> eaq();

    protected C41403e(final C25212i c25212i, C31642l c31642l, C0026g c0026g, final C37022f c37022f, C0163ba c0163ba, boolean z, int i, C41398am c41398am, final C17157ap c17157ap) {
        super(c31642l, c0026g, c37022f, c41398am);
        this.Bhj = c0163ba;
        this.Bhk = z;
        this.index = i;
        this.Bhl = c25212i.mo31373i(new C31214a<C17313an>() {
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(119388);
                C0033a c0033a = new C0033a(c25212i, c17157ap);
                AppMethodBeat.m2505o(119388);
                return c0033a;
            }
        });
        this.Bha = c25212i.mo31373i(new C31214a<C8235ad>() {

            /* renamed from: a.i.b.a.c.b.c.e$2$1 */
            class C316361 implements C31214a<C31746h> {
                C316361() {
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(119389);
                    C31746h a = C8207m.m14504a("Scope for type parameter " + c37022f.name, C41403e.this.dWP());
                    AppMethodBeat.m2505o(119389);
                    return a;
                }
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(119390);
                C0027a c0027a = C0026g.BfJ;
                C8235ad a = C17326x.m26838a(C0027a.eai(), C41403e.this.dXY(), Collections.emptyList(), false, new C31745g(c25212i.mo31373i(new C316361())));
                AppMethodBeat.m2505o(119390);
                return a;
            }
        });
    }

    public final C0163ba dZh() {
        return this.Bhj;
    }

    public final boolean dZi() {
        return this.Bhk;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean dZb() {
        return false;
    }

    public final List<C46867w> dWP() {
        return ((C0033a) dXY()).eap();
    }

    public final C17313an dXY() {
        return (C17313an) this.Bhl.invoke();
    }

    public final C8235ad dZf() {
        return (C8235ad) this.Bha.invoke();
    }

    public final C36955ar dZc() {
        return (C36955ar) super.dZd();
    }

    /* renamed from: a */
    public final <R, D> R mo245a(C44877n<R, D> c44877n, D d) {
        return c44877n.mo13675a((C36955ar) this, (Object) d);
    }

    public final /* bridge */ /* synthetic */ C36965o ean() {
        return (C36955ar) super.dZd();
    }

    public final /* synthetic */ C31642l dZd() {
        return (C36955ar) super.dZd();
    }

    public final /* synthetic */ C0036h dZe() {
        return (C36955ar) super.dZd();
    }
}
