package com.tencent.p177mm.plugin.product.p737c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.product.c.j */
public final class C7017j extends C1331a {
    public int bJt;
    public String iqz;
    public C39489g phT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56633);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.bJt);
            if (this.phT != null) {
                c6093a.mo13479iy(2, this.phT.computeSize());
                this.phT.writeFields(c6093a);
            }
            if (this.iqz != null) {
                c6093a.mo13475e(3, this.iqz);
            }
            AppMethodBeat.m2505o(56633);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.bJt) + 0;
            if (this.phT != null) {
                bs += C6087a.m9557ix(2, this.phT.computeSize());
            }
            if (this.iqz != null) {
                bs += C6091a.m9575f(3, this.iqz);
            }
            AppMethodBeat.m2505o(56633);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56633);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7017j c7017j = (C7017j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c7017j.bJt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56633);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C39489g c39489g = new C39489g();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c39489g.populateBuilderWithField(c6086a3, c39489g, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7017j.phT = c39489g;
                    }
                    AppMethodBeat.m2505o(56633);
                    return 0;
                case 3:
                    c7017j.iqz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56633);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56633);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56633);
            return -1;
        }
    }
}
