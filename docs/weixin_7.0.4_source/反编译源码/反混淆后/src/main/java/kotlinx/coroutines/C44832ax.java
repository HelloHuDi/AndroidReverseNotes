package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, dWq = {"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.ax */
public final class C44832ax implements C44612ay {
    final C36628bk BQt;

    public C44832ax(C36628bk c36628bk) {
        C25052j.m39376p(c36628bk, "list");
        AppMethodBeat.m2504i(118453);
        this.BQt = c36628bk;
        AppMethodBeat.m2505o(118453);
    }

    public final C36628bk ell() {
        return this.BQt;
    }

    public final boolean isActive() {
        return false;
    }

    public final String toString() {
        AppMethodBeat.m2504i(118452);
        String string = this.BQt.getString("New");
        AppMethodBeat.m2505o(118452);
        return string;
    }
}
