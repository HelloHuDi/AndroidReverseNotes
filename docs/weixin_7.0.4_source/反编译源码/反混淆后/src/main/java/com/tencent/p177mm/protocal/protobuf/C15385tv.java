package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.tv */
public final class C15385tv extends C1331a {
    public LinkedList<C30228tu> vEN = new LinkedList();
    public long waM;
    public long wbj;

    public C15385tv() {
        AppMethodBeat.m2504i(135601);
        AppMethodBeat.m2505o(135601);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(135602);
        int o;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.wbj);
            c6093a.mo13472ai(2, this.waM);
            c6093a.mo13474e(3, 8, this.vEN);
            AppMethodBeat.m2505o(135602);
            return 0;
        } else if (i == 1) {
            o = ((C6091a.m9578o(1, this.wbj) + 0) + C6091a.m9578o(2, this.waM)) + C6087a.m9552c(3, 8, this.vEN);
            AppMethodBeat.m2505o(135602);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEN.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(135602);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15385tv c15385tv = (C15385tv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c15385tv.wbj = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(135602);
                    return 0;
                case 2:
                    c15385tv.waM = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(135602);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30228tu c30228tu = new C30228tu();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c30228tu.populateBuilderWithField(c6086a3, c30228tu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15385tv.vEN.add(c30228tu);
                    }
                    AppMethodBeat.m2505o(135602);
                    return 0;
                default:
                    AppMethodBeat.m2505o(135602);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(135602);
            return -1;
        }
    }
}
