package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ua */
public final class C7284ua extends C1331a {
    public String vYA;
    public LinkedList<Integer> wbp = new LinkedList();

    public C7284ua() {
        AppMethodBeat.m2504i(28366);
        AppMethodBeat.m2505o(28366);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28367);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vYA != null) {
                c6093a.mo13475e(1, this.vYA);
            }
            c6093a.mo13474e(2, 2, this.wbp);
            AppMethodBeat.m2505o(28367);
            return 0;
        } else if (i == 1) {
            if (this.vYA != null) {
                f = C6091a.m9575f(1, this.vYA) + 0;
            } else {
                f = 0;
            }
            int c = f + C6087a.m9552c(2, 2, this.wbp);
            AppMethodBeat.m2505o(28367);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wbp.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28367);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7284ua c7284ua = (C7284ua) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7284ua.vYA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28367);
                    return 0;
                case 2:
                    c7284ua.wbp.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(28367);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28367);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28367);
            return -1;
        }
    }
}
