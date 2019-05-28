package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C31634ah;

/* renamed from: a.i.b.a.c.l.k */
public final class C41454k {
    /* renamed from: a */
    public static C25227au m72328a(List<C36955ar> list, C44922as c44922as, C31642l c31642l, List<C36955ar> list2) {
        AppMethodBeat.m2504i(122517);
        C25227au a = C41454k.m72329a(list, c44922as, c31642l, list2, null);
        if (a == null) {
            AssertionError assertionError = new AssertionError("Substitution failed");
            AppMethodBeat.m2505o(122517);
            throw assertionError;
        }
        AppMethodBeat.m2505o(122517);
        return a;
    }

    /* renamed from: a */
    public static C25227au m72329a(List<C36955ar> list, C44922as c44922as, C31642l c31642l, List<C36955ar> list2, boolean[] zArr) {
        AppMethodBeat.m2504i(122518);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i = 0;
        for (C36955ar c36955ar : list) {
            int i2 = i + 1;
            C31634ah a = C31634ah.m51155a(c31642l, c36955ar.dYn(), c36955ar.dZi(), c36955ar.dZh(), c36955ar.dZg(), i, C41398am.BeR);
            hashMap.put(c36955ar.dXY(), new C44836ar(a.dZf()));
            hashMap2.put(c36955ar, a);
            list2.add(a);
            i = i2;
        }
        C25227au b = C25227au.m39769b(c44922as, C25225ao.m39758be(hashMap));
        for (C36955ar c36955ar2 : list) {
            C31634ah c31634ah = (C31634ah) hashMap2.get(c36955ar2);
            for (C46867w c46867w : c36955ar2.dWP()) {
                C46867w c = b.mo42080c(c46867w, C0163ba.IN_VARIANCE);
                if (c == null) {
                    AppMethodBeat.m2505o(122518);
                    return null;
                }
                if (!(c == c46867w || zArr == null)) {
                    zArr[0] = true;
                }
                c31634ah.mo51626L(c);
            }
            c31634ah.setInitialized();
        }
        AppMethodBeat.m2505o(122518);
        return b;
    }
}
