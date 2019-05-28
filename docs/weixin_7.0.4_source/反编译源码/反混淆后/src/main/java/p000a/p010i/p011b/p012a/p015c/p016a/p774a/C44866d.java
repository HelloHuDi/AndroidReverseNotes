package p000a.p010i.p011b.p012a.p015c.p016a.p774a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p001a.C25033k;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.p774a.C44867f.C17144a;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0139e;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;

/* renamed from: a.i.b.a.c.a.a.d */
public final class C44866d extends C0139e {
    public C44866d(C25212i c25212i, C24607b c24607b) {
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c24607b, "containingClass");
        super(c25212i, c24607b);
        AppMethodBeat.m2504i(119157);
        AppMethodBeat.m2505o(119157);
    }

    public final List<C8083t> dYw() {
        AppMethodBeat.m2504i(119156);
        C46865e c46865e = this.BFZ;
        if (c46865e == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
            AppMethodBeat.m2505o(119156);
            throw c44941v;
        }
        C17144a c17144a;
        List<C8083t> listOf;
        switch (C36948e.eQZ[((C24607b) c46865e).BcN.ordinal()]) {
            case 1:
                c17144a = C44867f.BcZ;
                listOf = C25033k.listOf(C17144a.m26517a((C24607b) this.BFZ, false));
                AppMethodBeat.m2505o(119156);
                return listOf;
            case 2:
                c17144a = C44867f.BcZ;
                listOf = C25033k.listOf(C17144a.m26517a((C24607b) this.BFZ, true));
                AppMethodBeat.m2505o(119156);
                return listOf;
            default:
                List list = C17115v.AUP;
                AppMethodBeat.m2505o(119156);
                return list;
        }
    }
}
