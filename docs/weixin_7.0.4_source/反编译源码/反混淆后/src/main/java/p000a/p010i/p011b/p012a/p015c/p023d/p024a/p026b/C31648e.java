package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p026b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a.C8037a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C36961p;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C41177ad;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p047m.C37061c;
import p000a.p010i.p011b.p012a.p015c.p047m.C37061c.C37062c;
import p000a.p010i.p011b.p012a.p015c.p047m.C37061c.C37063a;
import p000a.p010i.p011b.p012a.p015c.p047m.C37061c.C37064b;
import p000a.p010i.p011b.p012a.p015c.p047m.C37065d;
import p000a.p010i.p011b.p012a.p015c.p047m.C44925b;
import p000a.p010i.p011b.p012a.p015c.p047m.C44926i;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.a.b.e */
public class C31648e extends C41177ad implements C17174b {
    static final /* synthetic */ boolean $assertionsDisabled = (!C31648e.class.desiredAssertionStatus());
    public static final C8037a<C41399au> BmA = new C171751();
    private C31649a BmB = null;

    /* renamed from: a.i.b.a.c.d.a.b.e$1 */
    static class C171751 implements C8037a<C41399au> {
        C171751() {
        }
    }

    /* renamed from: a.i.b.a.c.d.a.b.e$a */
    enum C31649a {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        
        public final boolean BmG;
        public final boolean BmH;

        static {
            AppMethodBeat.m2505o(119797);
        }

        private C31649a(boolean z, boolean z2) {
            this.BmG = z;
            this.BmH = z2;
        }

        /* renamed from: ap */
        public static C31649a m51193ap(boolean z, boolean z2) {
            return z ? z2 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z2 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
        }
    }

    static {
        AppMethodBeat.m2504i(119805);
        AppMethodBeat.m2505o(119805);
    }

    private C31648e(C31642l c31642l, C41397al c41397al, C0026g c0026g, C37022f c37022f, C8063a c8063a, C41398am c41398am) {
        super(c31642l, c41397al, c0026g, c37022f, c8063a, c41398am);
    }

    /* renamed from: a */
    public static C31648e m51188a(C31642l c31642l, C0026g c0026g, C37022f c37022f, C41398am c41398am) {
        AppMethodBeat.m2504i(119798);
        C31648e c31648e = new C31648e(c31642l, null, c0026g, c37022f, C8063a.DECLARATION, c41398am);
        AppMethodBeat.m2505o(119798);
        return c31648e;
    }

    /* renamed from: a */
    public final C41177ad mo51636a(C41396ak c41396ak, C41396ak c41396ak2, List<? extends C36955ar> list, List<C41399au> list2, C46867w c46867w, C44879w c44879w, C25082az c25082az, Map<? extends C8037a<?>, ?> map) {
        C37061c c37064b;
        AppMethodBeat.m2504i(119799);
        C41177ad a = super.mo51636a(c41396ak, c41396ak2, list, list2, c46867w, c44879w, c25082az, map);
        C44926i c44926i = C44926i.BLI;
        C25052j.m39376p(a, "functionDescriptor");
        for (C37065d c37065d : c44926i.ekt()) {
            Object obj;
            C25052j.m39376p(a, "functionDescriptor");
            if (c37065d.BgZ == null || (C25052j.m39373j(a.dZg(), c37065d.BgZ) ^ 1) == 0) {
                if (c37065d.BLv != null) {
                    String str = a.dZg().name;
                    C25052j.m39375o(str, "functionDescriptor.name.asString()");
                    if (!c37065d.BLv.mo42119aq(str)) {
                        obj = null;
                        continue;
                    }
                }
                if (c37065d.BLw == null || c37065d.BLw.contains(a.dZg())) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                C25052j.m39376p(a, "functionDescriptor");
                for (C44925b i : c37065d.BLy) {
                    String i2 = i.mo18042i(a);
                    if (i2 != null) {
                        c37064b = new C37064b(i2);
                        break;
                    }
                }
                String str2 = (String) c37065d.BLx.mo50am(a);
                c37064b = str2 != null ? new C37064b(str2) : C37062c.BLu;
                this.BhR = c37064b.cxT;
                AppMethodBeat.m2505o(119799);
                return a;
            }
        }
        c37064b = C37063a.BLt;
        this.BhR = c37064b.cxT;
        AppMethodBeat.m2505o(119799);
        return a;
    }

    public final boolean eaw() {
        AppMethodBeat.m2504i(119800);
        if ($assertionsDisabled || this.BmB != null) {
            boolean z = this.BmB.BmG;
            AppMethodBeat.m2505o(119800);
            return z;
        }
        AssertionError assertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.m2505o(119800);
        throw assertionError;
    }

    public final boolean dYW() {
        AppMethodBeat.m2504i(119801);
        if ($assertionsDisabled || this.BmB != null) {
            boolean z = this.BmB.BmH;
            AppMethodBeat.m2505o(119801);
            return z;
        }
        AssertionError assertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.m2505o(119801);
        throw assertionError;
    }

    /* renamed from: ao */
    public final void mo51637ao(boolean z, boolean z2) {
        AppMethodBeat.m2504i(119802);
        this.BmB = C31649a.m51193ap(z, z2);
        AppMethodBeat.m2505o(119802);
    }

    /* renamed from: a */
    public final /* synthetic */ C36961p mo91a(C31642l c31642l, C8083t c8083t, C8063a c8063a, C37022f c37022f, C0026g c0026g, C41398am c41398am) {
        C37022f c37022f2;
        AppMethodBeat.m2504i(119803);
        C41397al c41397al = (C41397al) c8083t;
        if (c37022f != null) {
            c37022f2 = c37022f;
        } else {
            c37022f2 = this.BgZ;
        }
        C31648e c31648e = new C31648e(c31642l, c41397al, c0026g, c37022f2, c8063a, c41398am);
        c31648e.mo51637ao(eaw(), dYW());
        AppMethodBeat.m2505o(119803);
        return c31648e;
    }
}
