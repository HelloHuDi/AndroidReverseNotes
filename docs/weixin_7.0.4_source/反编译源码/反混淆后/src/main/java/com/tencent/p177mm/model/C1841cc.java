package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.model.cc */
public final class C1841cc {
    public Set<C1840a> fnN = new HashSet();
    public boolean isRunning = false;

    /* renamed from: com.tencent.mm.model.cc$a */
    public interface C1840a {
        boolean aaG();
    }

    public C1841cc() {
        AppMethodBeat.m2504i(58142);
        AppMethodBeat.m2505o(58142);
    }

    /* renamed from: a */
    public final boolean mo5418a(C1840a c1840a) {
        AppMethodBeat.m2504i(58143);
        if (this.isRunning) {
            C4990ab.m7412e("MicroMsg.UninitForUEH", "add , is running , forbid add");
            AppMethodBeat.m2505o(58143);
            return false;
        }
        boolean add = this.fnN.add(c1840a);
        AppMethodBeat.m2505o(58143);
        return add;
    }

    /* renamed from: b */
    public final boolean mo5419b(C1840a c1840a) {
        AppMethodBeat.m2504i(58144);
        if (this.isRunning) {
            C4990ab.m7412e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
            AppMethodBeat.m2505o(58144);
            return false;
        }
        boolean remove = this.fnN.remove(c1840a);
        AppMethodBeat.m2505o(58144);
        return remove;
    }
}
