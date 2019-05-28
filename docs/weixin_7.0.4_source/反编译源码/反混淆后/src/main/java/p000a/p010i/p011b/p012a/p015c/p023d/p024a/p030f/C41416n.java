package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import p000a.p001a.C25032am;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.d.a.f.n */
public final class C41416n {
    /* renamed from: a */
    static final C8119d m72233a(C41414g c41414g, C41412e c41412e, boolean z, boolean z2) {
        AppMethodBeat.m2504i(120187);
        C8119d c8119d;
        if (z2 && c41414g == C41414g.NOT_NULL) {
            c8119d = new C8119d(c41414g, c41412e, true, z);
            AppMethodBeat.m2505o(120187);
            return c8119d;
        }
        c8119d = new C8119d(c41414g, c41412e, false, z);
        AppMethodBeat.m2505o(120187);
        return c8119d;
    }

    /* JADX WARNING: Missing block: B:18:0x003d, code skipped:
            if (r0 == null) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static final <T> T m72235a(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        AppMethodBeat.m2504i(120188);
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (C25052j.m39373j(t4, t) && C25052j.m39373j(t3, t2)) {
                AppMethodBeat.m2505o(120188);
                return null;
            }
            if (t3 != null) {
                t4 = t3;
            }
            AppMethodBeat.m2505o(120188);
            return t4;
        }
        Set o;
        if (t3 != null) {
            o = C25035t.m39354o(C25032am.m39317b(set, t3));
        }
        o = set;
        T i = C25035t.m39347i((Iterable) o);
        AppMethodBeat.m2505o(120188);
        return i;
    }

    /* renamed from: a */
    static final C41414g m72234a(Set<? extends C41414g> set, C41414g c41414g, boolean z) {
        AppMethodBeat.m2504i(120189);
        C41414g c41414g2;
        if (c41414g == C41414g.FORCE_FLEXIBILITY) {
            c41414g2 = C41414g.FORCE_FLEXIBILITY;
            AppMethodBeat.m2505o(120189);
            return c41414g2;
        }
        c41414g2 = (C41414g) C41416n.m72235a(set, C41414g.NOT_NULL, C41414g.NULLABLE, c41414g, z);
        AppMethodBeat.m2505o(120189);
        return c41414g2;
    }
}
