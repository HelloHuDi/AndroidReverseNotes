package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bdu */
public final class bdu extends C1331a {
    public int wHA;
    public int wHB;
    public String wHw;
    public String wHx;
    public int wHy;
    public int wHz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58915);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wHw != null) {
                c6093a.mo13475e(1, this.wHw);
            }
            if (this.wHx != null) {
                c6093a.mo13475e(2, this.wHx);
            }
            c6093a.mo13480iz(3, this.wHy);
            c6093a.mo13480iz(4, this.wHz);
            c6093a.mo13480iz(5, this.wHA);
            c6093a.mo13480iz(7, this.wHB);
            AppMethodBeat.m2505o(58915);
            return 0;
        } else if (i == 1) {
            if (this.wHw != null) {
                f = C6091a.m9575f(1, this.wHw) + 0;
            } else {
                f = 0;
            }
            if (this.wHx != null) {
                f += C6091a.m9575f(2, this.wHx);
            }
            int bs = (((f + C6091a.m9572bs(3, this.wHy)) + C6091a.m9572bs(4, this.wHz)) + C6091a.m9572bs(5, this.wHA)) + C6091a.m9572bs(7, this.wHB);
            AppMethodBeat.m2505o(58915);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(58915);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bdu bdu = (bdu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdu.wHw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58915);
                    return 0;
                case 2:
                    bdu.wHx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58915);
                    return 0;
                case 3:
                    bdu.wHy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58915);
                    return 0;
                case 4:
                    bdu.wHz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58915);
                    return 0;
                case 5:
                    bdu.wHA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58915);
                    return 0;
                case 7:
                    bdu.wHB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58915);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58915);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58915);
            return -1;
        }
    }
}
