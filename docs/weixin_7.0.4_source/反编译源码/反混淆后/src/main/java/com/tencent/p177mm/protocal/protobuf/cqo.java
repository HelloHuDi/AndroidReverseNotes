package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cqo */
public final class cqo extends C1331a {
    public String xot;
    public String xou;
    public LinkedList<String> xov = new LinkedList();
    public int xow;

    public cqo() {
        AppMethodBeat.m2504i(102395);
        AppMethodBeat.m2505o(102395);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102396);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xot != null) {
                c6093a.mo13475e(1, this.xot);
            }
            if (this.xou != null) {
                c6093a.mo13475e(2, this.xou);
            }
            c6093a.mo13474e(3, 1, this.xov);
            c6093a.mo13480iz(4, this.xow);
            AppMethodBeat.m2505o(102396);
            return 0;
        } else if (i == 1) {
            if (this.xot != null) {
                f = C6091a.m9575f(1, this.xot) + 0;
            } else {
                f = 0;
            }
            if (this.xou != null) {
                f += C6091a.m9575f(2, this.xou);
            }
            int c = (f + C6087a.m9552c(3, 1, this.xov)) + C6091a.m9572bs(4, this.xow);
            AppMethodBeat.m2505o(102396);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xov.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102396);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cqo cqo = (cqo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cqo.xot = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102396);
                    return 0;
                case 2:
                    cqo.xou = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102396);
                    return 0;
                case 3:
                    cqo.xov.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(102396);
                    return 0;
                case 4:
                    cqo.xow = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102396);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102396);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102396);
            return -1;
        }
    }
}
