package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cbn */
public final class cbn extends C1331a {
    public int xaO;
    public ccp xaP;
    public boo xaQ;
    public C30238wh xaR;
    public blk xaS;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94592);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.xaO);
            if (this.xaP != null) {
                c6093a.mo13479iy(2, this.xaP.computeSize());
                this.xaP.writeFields(c6093a);
            }
            if (this.xaQ != null) {
                c6093a.mo13479iy(3, this.xaQ.computeSize());
                this.xaQ.writeFields(c6093a);
            }
            if (this.xaR != null) {
                c6093a.mo13479iy(4, this.xaR.computeSize());
                this.xaR.writeFields(c6093a);
            }
            if (this.xaS != null) {
                c6093a.mo13479iy(5, this.xaS.computeSize());
                this.xaS.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94592);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.xaO) + 0;
            if (this.xaP != null) {
                bs += C6087a.m9557ix(2, this.xaP.computeSize());
            }
            if (this.xaQ != null) {
                bs += C6087a.m9557ix(3, this.xaQ.computeSize());
            }
            if (this.xaR != null) {
                bs += C6087a.m9557ix(4, this.xaR.computeSize());
            }
            if (this.xaS != null) {
                bs += C6087a.m9557ix(5, this.xaS.computeSize());
            }
            AppMethodBeat.m2505o(94592);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94592);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cbn cbn = (cbn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cbn.xaO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94592);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccp ccp = new ccp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccp.populateBuilderWithField(c6086a3, ccp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbn.xaP = ccp;
                    }
                    AppMethodBeat.m2505o(94592);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        boo boo = new boo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = boo.populateBuilderWithField(c6086a3, boo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbn.xaQ = boo;
                    }
                    AppMethodBeat.m2505o(94592);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30238wh c30238wh = new C30238wh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30238wh.populateBuilderWithField(c6086a3, c30238wh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbn.xaR = c30238wh;
                    }
                    AppMethodBeat.m2505o(94592);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        blk blk = new blk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = blk.populateBuilderWithField(c6086a3, blk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbn.xaS = blk;
                    }
                    AppMethodBeat.m2505o(94592);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94592);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94592);
            return -1;
        }
    }
}
