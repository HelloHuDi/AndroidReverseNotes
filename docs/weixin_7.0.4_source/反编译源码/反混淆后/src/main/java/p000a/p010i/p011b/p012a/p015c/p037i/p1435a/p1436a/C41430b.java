package p000a.p010i.p011b.p012a.p015c.p037i.p1435a.p1436a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import p000a.C44847aa;
import p000a.p001a.C17115v;
import p000a.p001a.C25033k;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C31768f;

/* renamed from: a.i.b.a.c.i.a.a.b */
public final class C41430b implements C17313an {
    public final C41446ap BEG;
    public C31768f BEJ;

    public C41430b(C41446ap c41446ap) {
        C25052j.m39376p(c41446ap, "typeProjection");
        AppMethodBeat.m2504i(122059);
        this.BEG = c41446ap;
        Object obj = this.BEG.ekq() != C0163ba.INVARIANT ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Only nontrivial projections can be captured, not: " + this.BEG);
            AppMethodBeat.m2505o(122059);
            throw assertionError;
        }
        AppMethodBeat.m2505o(122059);
    }

    public final /* bridge */ /* synthetic */ C0036h dYs() {
        return null;
    }

    public final Collection<C46867w> eap() {
        Object dZS;
        AppMethodBeat.m2504i(122056);
        if (this.BEG.ekq() == C0163ba.OUT_VARIANCE) {
            dZS = this.BEG.dZS();
        } else {
            C46867w dZS2 = dZD().dXN();
        }
        C25052j.m39375o(dZS2, "if (typeProjection.proje… builtIns.nullableAnyType");
        Collection listOf = C25033k.listOf(dZS2);
        AppMethodBeat.m2505o(122056);
        return listOf;
    }

    public final boolean dYu() {
        return false;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122057);
        String str = "CapturedTypeConstructor(" + this.BEG + ')';
        AppMethodBeat.m2505o(122057);
        return str;
    }

    public final C31619g dZD() {
        AppMethodBeat.m2504i(122058);
        C31619g dZD = this.BEG.dZS().ejw().dZD();
        C25052j.m39375o(dZD, "typeProjection.type.constructor.builtIns");
        AppMethodBeat.m2505o(122058);
        return dZD;
    }

    public final List<C36955ar> getParameters() {
        return C17115v.AUP;
    }
}
