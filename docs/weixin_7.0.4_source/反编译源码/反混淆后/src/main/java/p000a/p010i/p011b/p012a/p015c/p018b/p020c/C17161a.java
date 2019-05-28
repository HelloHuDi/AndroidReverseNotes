package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p006a.C31214a;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C44877n;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C25178l;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C41182f;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C44922as;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.a */
public abstract class C17161a implements C46865e {
    static final /* synthetic */ boolean $assertionsDisabled = (!C17161a.class.desiredAssertionStatus());
    public final C37022f BgZ;
    protected final C41441f<C8235ad> Bha;
    private final C41441f<C31746h> Bhb;
    private final C41441f<C41396ak> Bhc;

    /* renamed from: a.i.b.a.c.b.c.a$1 */
    class C171621 implements C31214a<C8235ad> {
        C171621() {
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119380);
            C8235ad a = C17316av.m26810a(C17161a.this, C17161a.this.dXZ());
            AppMethodBeat.m2505o(119380);
            return a;
        }
    }

    /* renamed from: a.i.b.a.c.b.c.a$2 */
    class C171632 implements C31214a<C31746h> {
        C171632() {
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119381);
            C41182f c41182f = new C41182f(C17161a.this.dXZ());
            AppMethodBeat.m2505o(119381);
            return c41182f;
        }
    }

    /* renamed from: a.i.b.a.c.b.c.a$3 */
    class C171643 implements C31214a<C41396ak> {
        C171643() {
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119382);
            C44875q c44875q = new C44875q(C17161a.this);
            AppMethodBeat.m2505o(119382);
            return c44875q;
        }
    }

    public final /* bridge */ /* synthetic */ C31642l dZd() {
        return this;
    }

    public final /* bridge */ /* synthetic */ C0036h dZe() {
        return this;
    }

    public C17161a(C25212i c25212i, C37022f c37022f) {
        this.BgZ = c37022f;
        this.Bha = c25212i.mo31373i(new C171621());
        this.Bhb = c25212i.mo31373i(new C171632());
        this.Bhc = c25212i.mo31373i(new C171643());
    }

    public final C37022f dZg() {
        return this.BgZ;
    }

    public final C46865e dZm() {
        return this;
    }

    public C31746h dZk() {
        return (C31746h) this.Bhb.invoke();
    }

    public final C41396ak dZl() {
        return (C41396ak) this.Bhc.invoke();
    }

    /* renamed from: a */
    public C31746h mo31262a(C44922as c44922as) {
        if (c44922as.isEmpty()) {
            return dXZ();
        }
        return new C25178l(dXZ(), C25227au.m39772d(c44922as));
    }

    public final C8235ad dZf() {
        return (C8235ad) this.Bha.invoke();
    }

    /* renamed from: a */
    public final <R, D> R mo245a(C44877n<R, D> c44877n, D d) {
        return c44877n.mo13677a((C46865e) this, (Object) d);
    }

    /* renamed from: g */
    public C46865e mo17870f(C25227au c25227au) {
        return c25227au.Bik.isEmpty() ? this : new C25089s(this, c25227au);
    }
}
