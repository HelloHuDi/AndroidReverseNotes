package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C17115v;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;

/* renamed from: a.i.b.a.c.l.a.f */
public final class C31768f implements C17313an {
    private final C41446ap BKy;
    List<? extends C41447az> BKz;

    public /* synthetic */ C31768f(C41446ap c41446ap) {
        this(c41446ap, null);
    }

    public C31768f(C41446ap c41446ap, List<? extends C41447az> list) {
        C25052j.m39376p(c41446ap, "projection");
        AppMethodBeat.m2504i(122731);
        this.BKy = c41446ap;
        this.BKz = list;
        AppMethodBeat.m2505o(122731);
    }

    public final boolean dYu() {
        return false;
    }

    public final C0036h dYs() {
        return null;
    }

    public final C31619g dZD() {
        AppMethodBeat.m2504i(122729);
        C46867w dZS = this.BKy.dZS();
        C25052j.m39375o(dZS, "projection.type");
        C31619g aL = C41448a.m72314aL(dZS);
        AppMethodBeat.m2505o(122729);
        return aL;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122730);
        String str = "CapturedType(" + this.BKy + ')';
        AppMethodBeat.m2505o(122730);
        return str;
    }

    public final /* bridge */ /* synthetic */ Collection eap() {
        List list = this.BKz;
        if (list == null) {
            list = C17115v.AUP;
        }
        return list;
    }

    public final List<C36955ar> getParameters() {
        return C17115v.AUP;
    }
}
