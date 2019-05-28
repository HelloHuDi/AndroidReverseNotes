package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ok */
public final class C15370ok extends C1331a {
    public int jBT;
    public int vEr;
    public String vUK;
    public long vUL;
    public int vUM;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(114434);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vUK != null) {
                c6093a.mo13475e(1, this.vUK);
            }
            c6093a.mo13472ai(2, this.vUL);
            c6093a.mo13480iz(3, this.vUM);
            c6093a.mo13480iz(4, this.vEr);
            c6093a.mo13480iz(5, this.jBT);
            AppMethodBeat.m2505o(114434);
            return 0;
        } else if (i == 1) {
            if (this.vUK != null) {
                f = C6091a.m9575f(1, this.vUK) + 0;
            } else {
                f = 0;
            }
            int o = (((f + C6091a.m9578o(2, this.vUL)) + C6091a.m9572bs(3, this.vUM)) + C6091a.m9572bs(4, this.vEr)) + C6091a.m9572bs(5, this.jBT);
            AppMethodBeat.m2505o(114434);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(114434);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15370ok c15370ok = (C15370ok) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c15370ok.vUK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114434);
                    return 0;
                case 2:
                    c15370ok.vUL = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(114434);
                    return 0;
                case 3:
                    c15370ok.vUM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(114434);
                    return 0;
                case 4:
                    c15370ok.vEr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(114434);
                    return 0;
                case 5:
                    c15370ok.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(114434);
                    return 0;
                default:
                    AppMethodBeat.m2505o(114434);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(114434);
            return -1;
        }
    }
}
