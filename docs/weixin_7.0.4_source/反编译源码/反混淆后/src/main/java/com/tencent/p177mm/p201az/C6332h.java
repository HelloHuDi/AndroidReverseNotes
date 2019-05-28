package com.tencent.p177mm.p201az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.protobuf.axd;
import com.tencent.p177mm.protocal.protobuf.axe;
import java.util.LinkedList;
import java.util.List;

@Deprecated
/* renamed from: com.tencent.mm.az.h */
public final class C6332h extends C3463b {
    private axe fLC;

    /* renamed from: com.tencent.mm.az.h$a */
    public static class C6333a {
        axd fLD;
        private int key;
        private String value;

        public C6333a() {
            AppMethodBeat.m2504i(59995);
            this.key = 0;
            this.value = "";
            this.fLD = new axd();
            this.fLD.pXC = 0;
            this.fLD.pXM = "";
            AppMethodBeat.m2505o(59995);
        }

        public C6333a(int i, String str) {
            AppMethodBeat.m2504i(59996);
            this.key = i;
            this.value = str;
            this.fLD = new axd();
            this.fLD.pXC = i;
            this.fLD.pXM = str;
            AppMethodBeat.m2505o(59996);
        }
    }

    public C6332h(List<C6333a> list) {
        super(36);
        AppMethodBeat.m2504i(59997);
        LinkedList linkedList = new LinkedList();
        for (C6333a c6333a : list) {
            linkedList.add(c6333a.fLD);
        }
        this.fLC = new axe();
        this.fLC.jBv = list.size();
        this.fLC.jBw = linkedList;
        this.oqT = this.fLC;
        AppMethodBeat.m2505o(59997);
    }
}
