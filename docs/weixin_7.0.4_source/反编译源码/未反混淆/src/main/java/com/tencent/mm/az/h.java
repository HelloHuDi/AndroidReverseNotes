package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.axe;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class h extends b {
    private axe fLC;

    public static class a {
        axd fLD;
        private int key;
        private String value;

        public a() {
            AppMethodBeat.i(59995);
            this.key = 0;
            this.value = "";
            this.fLD = new axd();
            this.fLD.pXC = 0;
            this.fLD.pXM = "";
            AppMethodBeat.o(59995);
        }

        public a(int i, String str) {
            AppMethodBeat.i(59996);
            this.key = i;
            this.value = str;
            this.fLD = new axd();
            this.fLD.pXC = i;
            this.fLD.pXM = str;
            AppMethodBeat.o(59996);
        }
    }

    public h(List<a> list) {
        super(36);
        AppMethodBeat.i(59997);
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.fLD);
        }
        this.fLC = new axe();
        this.fLC.jBv = list.size();
        this.fLC.jBw = linkedList;
        this.oqT = this.fLC;
        AppMethodBeat.o(59997);
    }
}
