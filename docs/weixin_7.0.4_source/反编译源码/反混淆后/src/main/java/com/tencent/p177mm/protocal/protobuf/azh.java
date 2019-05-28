package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.azh */
public final class azh extends C1331a {
    public String type;
    public int vXd;
    public String wDs;
    public String wDt;
    public String woO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(70486);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wDs != null) {
                c6093a.mo13475e(1, this.wDs);
            }
            if (this.woO != null) {
                c6093a.mo13475e(2, this.woO);
            }
            if (this.type != null) {
                c6093a.mo13475e(3, this.type);
            }
            c6093a.mo13480iz(4, this.vXd);
            if (this.wDt != null) {
                c6093a.mo13475e(5, this.wDt);
            }
            AppMethodBeat.m2505o(70486);
            return 0;
        } else if (i == 1) {
            if (this.wDs != null) {
                f = C6091a.m9575f(1, this.wDs) + 0;
            } else {
                f = 0;
            }
            if (this.woO != null) {
                f += C6091a.m9575f(2, this.woO);
            }
            if (this.type != null) {
                f += C6091a.m9575f(3, this.type);
            }
            f += C6091a.m9572bs(4, this.vXd);
            if (this.wDt != null) {
                f += C6091a.m9575f(5, this.wDt);
            }
            AppMethodBeat.m2505o(70486);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(70486);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            azh azh = (azh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azh.wDs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70486);
                    return 0;
                case 2:
                    azh.woO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70486);
                    return 0;
                case 3:
                    azh.type = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70486);
                    return 0;
                case 4:
                    azh.vXd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(70486);
                    return 0;
                case 5:
                    azh.wDt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70486);
                    return 0;
                default:
                    AppMethodBeat.m2505o(70486);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(70486);
            return -1;
        }
    }
}
