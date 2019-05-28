package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cxs */
public final class cxs extends C1331a {
    public String Md5;
    public int vMG;
    public int wUZ;
    public int wVb;
    public cxp xsZ;
    public int xtk;
    public boolean xtl;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(115019);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xsZ != null) {
                c6093a.mo13479iy(1, this.xsZ.computeSize());
                this.xsZ.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.xtk);
            c6093a.mo13480iz(3, this.wUZ);
            c6093a.mo13480iz(4, this.wVb);
            c6093a.mo13471aO(5, this.xtl);
            c6093a.mo13480iz(6, this.vMG);
            if (this.Md5 != null) {
                c6093a.mo13475e(7, this.Md5);
            }
            AppMethodBeat.m2505o(115019);
            return 0;
        } else if (i == 1) {
            if (this.xsZ != null) {
                ix = C6087a.m9557ix(1, this.xsZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((ix + C6091a.m9572bs(2, this.xtk)) + C6091a.m9572bs(3, this.wUZ)) + C6091a.m9572bs(4, this.wVb)) + (C6091a.m9576fv(5) + 1)) + C6091a.m9572bs(6, this.vMG);
            if (this.Md5 != null) {
                ix += C6091a.m9575f(7, this.Md5);
            }
            AppMethodBeat.m2505o(115019);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(115019);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cxs cxs = (cxs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cxp cxp = new cxp();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cxp.populateBuilderWithField(c6086a3, cxp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cxs.xsZ = cxp;
                    }
                    AppMethodBeat.m2505o(115019);
                    return 0;
                case 2:
                    cxs.xtk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(115019);
                    return 0;
                case 3:
                    cxs.wUZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(115019);
                    return 0;
                case 4:
                    cxs.wVb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(115019);
                    return 0;
                case 5:
                    cxs.xtl = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(115019);
                    return 0;
                case 6:
                    cxs.vMG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(115019);
                    return 0;
                case 7:
                    cxs.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(115019);
                    return 0;
                default:
                    AppMethodBeat.m2505o(115019);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(115019);
            return -1;
        }
    }
}
