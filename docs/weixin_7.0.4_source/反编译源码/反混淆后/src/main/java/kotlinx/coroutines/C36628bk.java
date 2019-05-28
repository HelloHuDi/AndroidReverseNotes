package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.p700a.C31179h;
import kotlinx.coroutines.p700a.C46844f;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, dWq = {"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bk */
public final class C36628bk extends C46844f implements C44612ay {
    public final boolean isActive() {
        return true;
    }

    public final C36628bk ell() {
        return this;
    }

    public final String getString(String str) {
        AppMethodBeat.m2504i(118559);
        C25052j.m39376p(str, "state");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List{");
        stringBuilder.append(str);
        stringBuilder.append("}[");
        Object obj = 1;
        Object elJ = elJ();
        if (elJ == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            AppMethodBeat.m2505o(118559);
            throw c44941v;
        }
        Object obj2 = (C31179h) elJ;
        while ((C25052j.m39373j(obj2, this) ^ 1) != 0) {
            if (obj2 instanceof C31189bf) {
                C31189bf c31189bf = (C31189bf) obj2;
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(c31189bf);
            }
            elJ = obj;
            obj2 = obj2.elK();
            obj = elJ;
        }
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        C25052j.m39375o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.m2505o(118559);
        return stringBuilder2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(118560);
        String string = getString("Active");
        AppMethodBeat.m2505o(118560);
        return string;
    }
}
