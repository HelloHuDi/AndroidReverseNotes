package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bau;
import java.util.LinkedList;
import java.util.List;

public final class e {
    public List<bau> list = new LinkedList();
    public String nQB;
    public int qFQ;

    public e() {
        AppMethodBeat.i(35796);
        AppMethodBeat.o(35796);
    }

    public e(bau bau) {
        AppMethodBeat.i(35797);
        this.list.add(bau);
        AppMethodBeat.o(35797);
    }

    public e(List<bau> list) {
        AppMethodBeat.i(35798);
        this.list = list;
        AppMethodBeat.o(35798);
    }
}
