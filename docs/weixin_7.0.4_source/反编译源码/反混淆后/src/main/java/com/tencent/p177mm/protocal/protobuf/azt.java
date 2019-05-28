package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.azt */
public final class azt extends C1331a {
    public int Scene;
    public String csB;
    public String username;
    public int vMG;
    public int wDA;
    public String wDB;
    public int wDC;
    public int wDz;
    public int wzF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102382);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.csB != null) {
                c6093a.mo13475e(1, this.csB);
            }
            if (this.username != null) {
                c6093a.mo13475e(2, this.username);
            }
            c6093a.mo13480iz(3, this.wzF);
            c6093a.mo13480iz(4, this.vMG);
            c6093a.mo13480iz(5, this.Scene);
            c6093a.mo13480iz(6, this.wDz);
            c6093a.mo13480iz(7, this.wDA);
            if (this.wDB != null) {
                c6093a.mo13475e(8, this.wDB);
            }
            c6093a.mo13480iz(9, this.wDC);
            AppMethodBeat.m2505o(102382);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = C6091a.m9575f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.username != null) {
                f += C6091a.m9575f(2, this.username);
            }
            f = ((((f + C6091a.m9572bs(3, this.wzF)) + C6091a.m9572bs(4, this.vMG)) + C6091a.m9572bs(5, this.Scene)) + C6091a.m9572bs(6, this.wDz)) + C6091a.m9572bs(7, this.wDA);
            if (this.wDB != null) {
                f += C6091a.m9575f(8, this.wDB);
            }
            int bs = f + C6091a.m9572bs(9, this.wDC);
            AppMethodBeat.m2505o(102382);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102382);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            azt azt = (azt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azt.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102382);
                    return 0;
                case 2:
                    azt.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102382);
                    return 0;
                case 3:
                    azt.wzF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102382);
                    return 0;
                case 4:
                    azt.vMG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102382);
                    return 0;
                case 5:
                    azt.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102382);
                    return 0;
                case 6:
                    azt.wDz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102382);
                    return 0;
                case 7:
                    azt.wDA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102382);
                    return 0;
                case 8:
                    azt.wDB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102382);
                    return 0;
                case 9:
                    azt.wDC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102382);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102382);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102382);
            return -1;
        }
    }
}
