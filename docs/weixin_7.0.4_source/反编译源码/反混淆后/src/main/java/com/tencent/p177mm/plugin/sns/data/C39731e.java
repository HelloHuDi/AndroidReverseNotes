package com.tencent.p177mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.bau;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.data.e */
public final class C39731e {
    public List<bau> list = new LinkedList();
    public String nQB;
    public int qFQ;

    public C39731e() {
        AppMethodBeat.m2504i(35796);
        AppMethodBeat.m2505o(35796);
    }

    public C39731e(bau bau) {
        AppMethodBeat.m2504i(35797);
        this.list.add(bau);
        AppMethodBeat.m2505o(35797);
    }

    public C39731e(List<bau> list) {
        AppMethodBeat.m2504i(35798);
        this.list = list;
        AppMethodBeat.m2505o(35798);
    }
}
