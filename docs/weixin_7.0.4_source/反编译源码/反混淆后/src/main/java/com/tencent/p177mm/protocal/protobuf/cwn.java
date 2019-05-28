package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cwn */
public final class cwn extends C1331a {
    public LinkedList<bkn> xsi = new LinkedList();
    public LinkedList<aws> xsj = new LinkedList();

    public cwn() {
        AppMethodBeat.m2504i(96324);
        AppMethodBeat.m2505o(96324);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96325);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.xsi);
            c6093a.mo13474e(2, 8, this.xsj);
            AppMethodBeat.m2505o(96325);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 8, this.xsi) + 0) + C6087a.m9552c(2, 8, this.xsj);
            AppMethodBeat.m2505o(96325);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xsi.clear();
            this.xsj.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96325);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cwn cwn = (cwn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkn bkn = new bkn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkn.populateBuilderWithField(c6086a3, bkn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwn.xsi.add(bkn);
                    }
                    AppMethodBeat.m2505o(96325);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aws aws = new aws();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aws.populateBuilderWithField(c6086a3, aws, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwn.xsj.add(aws);
                    }
                    AppMethodBeat.m2505o(96325);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96325);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96325);
            return -1;
        }
    }
}
