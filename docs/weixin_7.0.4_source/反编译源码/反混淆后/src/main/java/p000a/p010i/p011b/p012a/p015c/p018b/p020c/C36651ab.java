package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p000a.p010i.p011b.p012a.p015c.p018b.C17153ag;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36965o;
import p000a.p010i.p011b.p012a.p015c.p018b.C41395aj;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C44877n;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.ab */
public class C36651ab extends C31641y implements C41395aj {
    static final /* synthetic */ boolean $assertionsDisabled = (!C36651ab.class.desiredAssertionStatus());
    private C41399au Bjk;
    private final C41395aj Bjl;

    static {
        AppMethodBeat.m2504i(119572);
        AppMethodBeat.m2505o(119572);
    }

    public C36651ab(C31220ah c31220ah, C0026g c0026g, C44879w c44879w, C25082az c25082az, boolean z, boolean z2, boolean z3, C8063a c8063a, C41395aj c41395aj, C41398am c41398am) {
        C37022f avZ = C37022f.avZ("<set-" + c31220ah.dZg() + ">");
        super(c44879w, c25082az, c31220ah, c0026g, avZ, z, z2, z3, c8063a, c41398am);
        AppMethodBeat.m2504i(119565);
        if (c41395aj == null) {
            Object c41395aj2 = this;
        }
        this.Bjl = c41395aj2;
        AppMethodBeat.m2505o(119565);
    }

    /* renamed from: a */
    public final void mo58508a(C41399au c41399au) {
        AppMethodBeat.m2504i(119566);
        if ($assertionsDisabled || this.Bjk == null) {
            this.Bjk = c41399au;
            AppMethodBeat.m2505o(119566);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(119566);
        throw assertionError;
    }

    /* renamed from: a */
    public static C8069ai m60748a(C41395aj c41395aj, C46867w c46867w, C0026g c0026g) {
        AppMethodBeat.m2504i(119567);
        C8069ai c8069ai = new C8069ai(c41395aj, null, 0, c0026g, C37022f.avZ("<set-?>"), c46867w, false, false, false, null, C41398am.BeR);
        AppMethodBeat.m2505o(119567);
        return c8069ai;
    }

    public final Collection<? extends C41395aj> dYX() {
        AppMethodBeat.m2504i(119568);
        Collection rJ = super.mo51634rJ(false);
        AppMethodBeat.m2505o(119568);
        return rJ;
    }

    public final List<C41399au> dYV() {
        AppMethodBeat.m2504i(119569);
        if (this.Bjk == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.m2505o(119569);
            throw illegalStateException;
        }
        List singletonList = Collections.singletonList(this.Bjk);
        AppMethodBeat.m2505o(119569);
        return singletonList;
    }

    public final C46867w dYT() {
        AppMethodBeat.m2504i(119570);
        C8235ad dXO = C41434a.m72275G(this).dXO();
        AppMethodBeat.m2505o(119570);
        return dXO;
    }

    /* renamed from: a */
    public final <R, D> R mo245a(C44877n<R, D> c44877n, D d) {
        AppMethodBeat.m2504i(119571);
        Object a = c44877n.mo13672a((C41395aj) this, (Object) d);
        AppMethodBeat.m2505o(119571);
        return a;
    }

    public final /* bridge */ /* synthetic */ C17153ag eaG() {
        return this.Bjl;
    }

    public final /* bridge */ /* synthetic */ C8083t dZp() {
        return this.Bjl;
    }

    public final /* bridge */ /* synthetic */ C25085b dYY() {
        return this.Bjl;
    }

    public final /* bridge */ /* synthetic */ C8045a dYU() {
        return this.Bjl;
    }

    public final /* bridge */ /* synthetic */ C31642l dZd() {
        return this.Bjl;
    }

    public final /* bridge */ /* synthetic */ C36965o ean() {
        return this.Bjl;
    }
}
