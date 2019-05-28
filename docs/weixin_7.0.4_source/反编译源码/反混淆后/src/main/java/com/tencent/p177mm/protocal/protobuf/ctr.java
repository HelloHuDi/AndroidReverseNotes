package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ctr */
public final class ctr extends C1331a {
    public int vOq;
    public LinkedList<ctk> woe = new LinkedList();
    public boolean xqq;

    public ctr() {
        AppMethodBeat.m2504i(28726);
        AppMethodBeat.m2505o(28726);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28727);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.woe);
            c6093a.mo13480iz(2, this.vOq);
            c6093a.mo13471aO(3, this.xqq);
            AppMethodBeat.m2505o(28727);
            return 0;
        } else if (i == 1) {
            c = ((C6087a.m9552c(1, 8, this.woe) + 0) + C6091a.m9572bs(2, this.vOq)) + (C6091a.m9576fv(3) + 1);
            AppMethodBeat.m2505o(28727);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woe.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28727);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ctr ctr = (ctr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ctk ctk = new ctk();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ctk.populateBuilderWithField(c6086a3, ctk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ctr.woe.add(ctk);
                    }
                    AppMethodBeat.m2505o(28727);
                    return 0;
                case 2:
                    ctr.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28727);
                    return 0;
                case 3:
                    ctr.xqq = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28727);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28727);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28727);
            return -1;
        }
    }
}
