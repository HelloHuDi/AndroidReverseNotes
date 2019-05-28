package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.C44847aa;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;

/* renamed from: a.i.b.a.c.l.u */
public final class C46866u extends C44922as {
    public final C36955ar[] BJE;
    public final C41446ap[] BJF;
    private final boolean BJG;

    public C46866u(C36955ar[] c36955arArr, C41446ap[] c41446apArr, boolean z) {
        C25052j.m39376p(c36955arArr, "parameters");
        C25052j.m39376p(c41446apArr, "arguments");
        AppMethodBeat.m2504i(122596);
        this.BJE = c36955arArr;
        this.BJF = c41446apArr;
        this.BJG = z;
        Object obj = this.BJE.length <= this.BJF.length ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.BJE.length + ", args=" + this.BJF.length);
            AppMethodBeat.m2505o(122596);
            throw assertionError;
        }
        AppMethodBeat.m2505o(122596);
    }

    public C46866u(List<? extends C36955ar> list, List<? extends C41446ap> list2) {
        C25052j.m39376p(list, "parameters");
        C25052j.m39376p(list2, "argumentsList");
        Object[] toArray = list.toArray(new C36955ar[0]);
        C44941v c44941v;
        if (toArray == null) {
            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.m2505o(122597);
            throw c44941v;
        }
        C36955ar[] c36955arArr = (C36955ar[]) toArray;
        Object[] toArray2 = list2.toArray(new C41446ap[0]);
        if (toArray2 == null) {
            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.m2505o(122597);
            throw c44941v;
        }
        this(c36955arArr, (C41446ap[]) toArray2);
        AppMethodBeat.m2505o(122597);
    }

    public final boolean isEmpty() {
        return this.BJF.length == 0;
    }

    public final boolean ejx() {
        return this.BJG;
    }

    /* renamed from: O */
    public final C41446ap mo31386O(C46867w c46867w) {
        AppMethodBeat.m2504i(122595);
        C25052j.m39376p(c46867w, "key");
        C0036h dYs = c46867w.ejw().dYs();
        if (!(dYs instanceof C36955ar)) {
            dYs = null;
        }
        C36955ar c36955ar = (C36955ar) dYs;
        if (c36955ar == null) {
            AppMethodBeat.m2505o(122595);
            return null;
        }
        int index = c36955ar.getIndex();
        if (index >= this.BJE.length || !C25052j.m39373j(this.BJE[index].dXY(), c36955ar.dXY())) {
            AppMethodBeat.m2505o(122595);
            return null;
        }
        C41446ap c41446ap = this.BJF[index];
        AppMethodBeat.m2505o(122595);
        return c41446ap;
    }
}
