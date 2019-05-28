package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.na */
public final class C23418na extends C1331a {
    public String vJY;
    public String vRB;
    public int vRC;
    public String vRD;
    public String vRE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(2537);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vRB != null) {
                c6093a.mo13475e(1, this.vRB);
            }
            c6093a.mo13480iz(2, this.vRC);
            if (this.vRD != null) {
                c6093a.mo13475e(3, this.vRD);
            }
            if (this.vJY != null) {
                c6093a.mo13475e(4, this.vJY);
            }
            if (this.vRE != null) {
                c6093a.mo13475e(5, this.vRE);
            }
            AppMethodBeat.m2505o(2537);
            return 0;
        } else if (i == 1) {
            if (this.vRB != null) {
                f = C6091a.m9575f(1, this.vRB) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.vRC);
            if (this.vRD != null) {
                f += C6091a.m9575f(3, this.vRD);
            }
            if (this.vJY != null) {
                f += C6091a.m9575f(4, this.vJY);
            }
            if (this.vRE != null) {
                f += C6091a.m9575f(5, this.vRE);
            }
            AppMethodBeat.m2505o(2537);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(2537);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23418na c23418na = (C23418na) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23418na.vRB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(2537);
                    return 0;
                case 2:
                    c23418na.vRC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(2537);
                    return 0;
                case 3:
                    c23418na.vRD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(2537);
                    return 0;
                case 4:
                    c23418na.vJY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(2537);
                    return 0;
                case 5:
                    c23418na.vRE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(2537);
                    return 0;
                default:
                    AppMethodBeat.m2505o(2537);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(2537);
            return -1;
        }
    }
}
