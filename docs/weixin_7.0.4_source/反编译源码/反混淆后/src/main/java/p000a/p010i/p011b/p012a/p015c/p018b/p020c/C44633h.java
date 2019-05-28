package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C36963d;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h.C17288b;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C41453e;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.h */
public class C44633h extends C41405g {
    static final /* synthetic */ boolean $assertionsDisabled = (!C44633h.class.desiredAssertionStatus());
    private C36963d BhA;
    private final C44879w Bhv;
    private final C36964f Bhw;
    private final C17313an Bhx;
    private C31746h Bhy;
    private Set<C36963d> Bhz;

    static {
        AppMethodBeat.m2504i(119427);
        AppMethodBeat.m2505o(119427);
    }

    public C44633h(C31642l c31642l, C37022f c37022f, C44879w c44879w, C36964f c36964f, Collection<C46867w> collection, C41398am c41398am, C25212i c25212i) {
        super(c25212i, c31642l, c37022f, c41398am);
        AppMethodBeat.m2504i(119422);
        if ($assertionsDisabled || c44879w != C44879w.SEALED) {
            this.Bhv = c44879w;
            this.Bhw = c36964f;
            this.Bhx = new C41453e(this, Collections.emptyList(), collection, c25212i);
            AppMethodBeat.m2505o(119422);
            return;
        }
        AssertionError assertionError = new AssertionError("Implement getSealedSubclasses() for this class: " + getClass());
        AppMethodBeat.m2505o(119422);
        throw assertionError;
    }

    /* renamed from: a */
    public final void mo71682a(C31746h c31746h, Set<C36963d> set, C36963d c36963d) {
        this.Bhy = c31746h;
        this.Bhz = set;
        this.BhA = c36963d;
    }

    public final C0026g dYn() {
        AppMethodBeat.m2504i(119423);
        C0027a c0027a = C0026g.BfJ;
        C0026g eai = C0027a.eai();
        AppMethodBeat.m2505o(119423);
        return eai;
    }

    public final C17313an dXY() {
        return this.Bhx;
    }

    public final Collection<C36963d> dYb() {
        return this.Bhz;
    }

    public final C31746h dXZ() {
        return this.Bhy;
    }

    public final C31746h dXX() {
        return C17288b.BGh;
    }

    public final C46865e dYa() {
        return null;
    }

    public final C36964f dYc() {
        return this.Bhw;
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
        return this.BhA;
    }

    public final C44879w dYd() {
        return this.Bhv;
    }

    public final C25082az dYf() {
        return C8051ay.Bfa;
    }

    public final boolean dYi() {
        return false;
    }

    public final boolean dYj() {
        return false;
    }

    public final boolean dYh() {
        return false;
    }

    public String toString() {
        AppMethodBeat.m2504i(119424);
        String str = "class " + this.BgZ;
        AppMethodBeat.m2505o(119424);
        return str;
    }

    public final List<C36955ar> dYq() {
        AppMethodBeat.m2504i(119425);
        List emptyList = Collections.emptyList();
        AppMethodBeat.m2505o(119425);
        return emptyList;
    }

    public final Collection<C46865e> dYp() {
        AppMethodBeat.m2504i(119426);
        List emptyList = Collections.emptyList();
        AppMethodBeat.m2505o(119426);
        return emptyList;
    }
}
