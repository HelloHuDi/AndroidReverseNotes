package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.arb */
public final class arb extends bsr {
    public String csB;
    public int type;
    public int vOP;
    public String wsY;
    public int wtb;
    public String wuL;
    public int wuM;
    public bie wuN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96234);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.type);
            if (this.csB != null) {
                c6093a.mo13475e(3, this.csB);
            }
            c6093a.mo13480iz(4, this.vOP);
            if (this.wuL != null) {
                c6093a.mo13475e(5, this.wuL);
            }
            c6093a.mo13480iz(6, this.wtb);
            c6093a.mo13480iz(7, this.wuM);
            if (this.wsY != null) {
                c6093a.mo13475e(8, this.wsY);
            }
            if (this.wuN != null) {
                c6093a.mo13479iy(10, this.wuN.computeSize());
                this.wuN.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(96234);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.type);
            if (this.csB != null) {
                ix += C6091a.m9575f(3, this.csB);
            }
            ix += C6091a.m9572bs(4, this.vOP);
            if (this.wuL != null) {
                ix += C6091a.m9575f(5, this.wuL);
            }
            ix = (ix + C6091a.m9572bs(6, this.wtb)) + C6091a.m9572bs(7, this.wuM);
            if (this.wsY != null) {
                ix += C6091a.m9575f(8, this.wsY);
            }
            if (this.wuN != null) {
                ix += C6087a.m9557ix(10, this.wuN.computeSize());
            }
            AppMethodBeat.m2505o(96234);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96234);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            arb arb = (arb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        arb.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(96234);
                    return 0;
                case 2:
                    arb.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96234);
                    return 0;
                case 3:
                    arb.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96234);
                    return 0;
                case 4:
                    arb.vOP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96234);
                    return 0;
                case 5:
                    arb.wuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96234);
                    return 0;
                case 6:
                    arb.wtb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96234);
                    return 0;
                case 7:
                    arb.wuM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96234);
                    return 0;
                case 8:
                    arb.wsY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96234);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bie bie = new bie();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bie.populateBuilderWithField(c6086a3, bie, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        arb.wuN = bie;
                    }
                    AppMethodBeat.m2505o(96234);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96234);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96234);
            return -1;
        }
    }
}
