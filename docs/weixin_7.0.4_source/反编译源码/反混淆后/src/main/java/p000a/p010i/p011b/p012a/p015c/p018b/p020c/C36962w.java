package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
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
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h.C17288b;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C41453e;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.w */
public class C36962w extends C41405g {
    static final /* synthetic */ boolean $assertionsDisabled = (!C36962w.class.desiredAssertionStatus());
    private final C25212i Baf;
    private List<C36955ar> BeK;
    private final boolean BeM;
    public C25082az BhQ;
    private C44879w Bhv;
    private final C36964f Bhw;
    private C17313an Bhx;
    private final Collection<C46867w> BiV = new ArrayList();

    static {
        AppMethodBeat.m2504i(119535);
        AppMethodBeat.m2505o(119535);
    }

    public C36962w(C31642l c31642l, C36964f c36964f, C37022f c37022f, C41398am c41398am, C25212i c25212i) {
        super(c25212i, c31642l, c37022f, c41398am);
        AppMethodBeat.m2504i(119527);
        this.Baf = c25212i;
        if ($assertionsDisabled || c36964f != C36964f.OBJECT) {
            this.Bhw = c36964f;
            this.BeM = false;
            AppMethodBeat.m2505o(119527);
            return;
        }
        AssertionError assertionError = new AssertionError("Fix isCompanionObject()");
        AppMethodBeat.m2505o(119527);
        throw assertionError;
    }

    public final C46865e dYa() {
        return null;
    }

    public final C0026g dYn() {
        AppMethodBeat.m2504i(119528);
        C0027a c0027a = C0026g.BfJ;
        C0026g eai = C0027a.eai();
        AppMethodBeat.m2505o(119528);
        return eai;
    }

    /* renamed from: b */
    public final void mo58967b(C44879w c44879w) {
        AppMethodBeat.m2504i(119529);
        if ($assertionsDisabled || c44879w != C44879w.SEALED) {
            this.Bhv = c44879w;
            AppMethodBeat.m2505o(119529);
            return;
        }
        AssertionError assertionError = new AssertionError("Implement getSealedSubclasses() for this class: " + getClass());
        AppMethodBeat.m2505o(119529);
        throw assertionError;
    }

    public final C44879w dYd() {
        return this.Bhv;
    }

    public final C36964f dYc() {
        return this.Bhw;
    }

    public final C25082az dYf() {
        return this.BhQ;
    }

    public final boolean dYh() {
        return this.BeM;
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

    public final C17313an dXY() {
        return this.Bhx;
    }

    public final C36963d dYe() {
        return null;
    }

    /* renamed from: fV */
    public final void mo58969fV(List<C36955ar> list) {
        AppMethodBeat.m2504i(119530);
        if (this.BeK != null) {
            IllegalStateException illegalStateException = new IllegalStateException("Type parameters are already set for " + this.BgZ);
            AppMethodBeat.m2505o(119530);
            throw illegalStateException;
        }
        this.BeK = new ArrayList(list);
        AppMethodBeat.m2505o(119530);
    }

    public final List<C36955ar> dYq() {
        return this.BeK;
    }

    public final void eaF() {
        AppMethodBeat.m2504i(119531);
        if ($assertionsDisabled || this.Bhx == null) {
            this.Bhx = new C41453e(this, this.BeK, this.BiV, this.Baf);
            for (C36963d c36963d : Collections.emptySet()) {
                ((C41404f) c36963d).BhN = dZf();
            }
            AppMethodBeat.m2505o(119531);
            return;
        }
        AssertionError assertionError = new AssertionError(this.Bhx);
        AppMethodBeat.m2505o(119531);
        throw assertionError;
    }

    public final C31746h dXZ() {
        return C17288b.BGh;
    }

    public final C31746h dXX() {
        return C17288b.BGh;
    }

    public final Collection<C46865e> dYp() {
        AppMethodBeat.m2504i(119532);
        List emptyList = Collections.emptyList();
        AppMethodBeat.m2505o(119532);
        return emptyList;
    }

    public String toString() {
        AppMethodBeat.m2504i(119533);
        String h = C25087j.m39416h(this);
        AppMethodBeat.m2505o(119533);
        return h;
    }

    public final /* synthetic */ Collection dYb() {
        AppMethodBeat.m2504i(119534);
        Set emptySet = Collections.emptySet();
        AppMethodBeat.m2505o(119534);
        return emptySet;
    }
}
