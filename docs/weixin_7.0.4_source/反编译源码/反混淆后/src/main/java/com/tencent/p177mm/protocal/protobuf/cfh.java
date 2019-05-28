package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cfh */
public final class cfh extends C1331a {
    public String fiG;
    public String fiI;
    public String fiJ;
    public String fiK;
    public String fiL;
    public String fiM;
    public String fiN;
    public int wid;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51006);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.fiG != null) {
                c6093a.mo13475e(1, this.fiG);
            }
            c6093a.mo13480iz(2, this.wid);
            if (this.fiJ != null) {
                c6093a.mo13475e(3, this.fiJ);
            }
            if (this.fiK != null) {
                c6093a.mo13475e(4, this.fiK);
            }
            if (this.fiI != null) {
                c6093a.mo13475e(5, this.fiI);
            }
            if (this.fiL != null) {
                c6093a.mo13475e(6, this.fiL);
            }
            if (this.fiM != null) {
                c6093a.mo13475e(7, this.fiM);
            }
            if (this.fiN != null) {
                c6093a.mo13475e(8, this.fiN);
            }
            AppMethodBeat.m2505o(51006);
            return 0;
        } else if (i == 1) {
            if (this.fiG != null) {
                f = C6091a.m9575f(1, this.fiG) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wid);
            if (this.fiJ != null) {
                f += C6091a.m9575f(3, this.fiJ);
            }
            if (this.fiK != null) {
                f += C6091a.m9575f(4, this.fiK);
            }
            if (this.fiI != null) {
                f += C6091a.m9575f(5, this.fiI);
            }
            if (this.fiL != null) {
                f += C6091a.m9575f(6, this.fiL);
            }
            if (this.fiM != null) {
                f += C6091a.m9575f(7, this.fiM);
            }
            if (this.fiN != null) {
                f += C6091a.m9575f(8, this.fiN);
            }
            AppMethodBeat.m2505o(51006);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51006);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cfh cfh = (cfh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfh.fiG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51006);
                    return 0;
                case 2:
                    cfh.wid = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51006);
                    return 0;
                case 3:
                    cfh.fiJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51006);
                    return 0;
                case 4:
                    cfh.fiK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51006);
                    return 0;
                case 5:
                    cfh.fiI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51006);
                    return 0;
                case 6:
                    cfh.fiL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51006);
                    return 0;
                case 7:
                    cfh.fiM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51006);
                    return 0;
                case 8:
                    cfh.fiN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51006);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51006);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51006);
            return -1;
        }
    }
}
