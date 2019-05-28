package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"})
/* renamed from: kotlinx.coroutines.e */
public final class C41161e {
    /* renamed from: a */
    public static final C41157bc m71593a(C36622ac c36622ac, C41366e c41366e, C6098ad c6098ad, C31591m<? super C36622ac, ? super C36927c<? super C37091y>, ? extends Object> c31591m) {
        boolean z;
        C16461bp c36626bi;
        AppMethodBeat.m2504i(118288);
        C25052j.m39376p(c36622ac, "receiver$0");
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(c6098ad, "start");
        C25052j.m39376p(c31591m, "block");
        C41366e a = C46852v.m89092a(c36622ac, c41366e);
        if (c6098ad == C6098ad.LAZY) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            c36626bi = new C36626bi(a, c31591m);
        } else {
            c36626bi = new C16461bp(a, true);
        }
        c36626bi.mo71481a(c6098ad, c36626bi, c31591m);
        C41157bc c41157bc = c36626bi;
        AppMethodBeat.m2505o(118288);
        return c41157bc;
    }
}
