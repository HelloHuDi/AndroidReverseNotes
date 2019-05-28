package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.to */
public final class C30227to extends C1331a {
    public int count;
    public int scene;
    public int vGr;
    public String vGs;
    public int waF;
    public int waG;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14723);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vGs != null) {
                c6093a.mo13475e(1, this.vGs);
            }
            c6093a.mo13480iz(2, this.vGr);
            c6093a.mo13480iz(3, this.waF);
            c6093a.mo13480iz(4, this.waG);
            c6093a.mo13480iz(5, this.scene);
            c6093a.mo13480iz(6, this.count);
            AppMethodBeat.m2505o(14723);
            return 0;
        } else if (i == 1) {
            if (this.vGs != null) {
                f = C6091a.m9575f(1, this.vGs) + 0;
            } else {
                f = 0;
            }
            int bs = ((((f + C6091a.m9572bs(2, this.vGr)) + C6091a.m9572bs(3, this.waF)) + C6091a.m9572bs(4, this.waG)) + C6091a.m9572bs(5, this.scene)) + C6091a.m9572bs(6, this.count);
            AppMethodBeat.m2505o(14723);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14723);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30227to c30227to = (C30227to) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c30227to.vGs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14723);
                    return 0;
                case 2:
                    c30227to.vGr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14723);
                    return 0;
                case 3:
                    c30227to.waF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14723);
                    return 0;
                case 4:
                    c30227to.waG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14723);
                    return 0;
                case 5:
                    c30227to.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14723);
                    return 0;
                case 6:
                    c30227to.count = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14723);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14723);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14723);
            return -1;
        }
    }
}
