package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.biu */
public final class biu extends C1331a {
    public int jBT;
    public int vKo;
    public String wMe;
    public C1332b wMf;
    public C1332b wMg;
    public C1332b wMh;
    public String wMi;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56882);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wMe != null) {
                c6093a.mo13475e(1, this.wMe);
            }
            c6093a.mo13480iz(2, this.jBT);
            if (this.wMf != null) {
                c6093a.mo13473c(3, this.wMf);
            }
            if (this.wMg != null) {
                c6093a.mo13473c(4, this.wMg);
            }
            if (this.wMh != null) {
                c6093a.mo13473c(5, this.wMh);
            }
            c6093a.mo13480iz(6, this.vKo);
            if (this.wMi != null) {
                c6093a.mo13475e(7, this.wMi);
            }
            AppMethodBeat.m2505o(56882);
            return 0;
        } else if (i == 1) {
            if (this.wMe != null) {
                f = C6091a.m9575f(1, this.wMe) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.jBT);
            if (this.wMf != null) {
                f += C6091a.m9571b(3, this.wMf);
            }
            if (this.wMg != null) {
                f += C6091a.m9571b(4, this.wMg);
            }
            if (this.wMh != null) {
                f += C6091a.m9571b(5, this.wMh);
            }
            f += C6091a.m9572bs(6, this.vKo);
            if (this.wMi != null) {
                f += C6091a.m9575f(7, this.wMi);
            }
            AppMethodBeat.m2505o(56882);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56882);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            biu biu = (biu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    biu.wMe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56882);
                    return 0;
                case 2:
                    biu.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56882);
                    return 0;
                case 3:
                    biu.wMf = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(56882);
                    return 0;
                case 4:
                    biu.wMg = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(56882);
                    return 0;
                case 5:
                    biu.wMh = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(56882);
                    return 0;
                case 6:
                    biu.vKo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56882);
                    return 0;
                case 7:
                    biu.wMi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56882);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56882);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56882);
            return -1;
        }
    }
}
