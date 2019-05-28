package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bwb */
public final class bwb extends bsr {
    public String Md5;
    public String guQ;
    public int vHo;
    public int vRy;
    public C46534dv wWQ;
    public String wWR;
    public String wWS;
    public int wWT;
    public int wdW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28629);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wWQ == null) {
                c6092b = new C6092b("Not all required fields were included: Msg");
                AppMethodBeat.m2505o(28629);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wWQ != null) {
                c6093a.mo13479iy(2, this.wWQ.computeSize());
                this.wWQ.writeFields(c6093a);
            }
            if (this.wWR != null) {
                c6093a.mo13475e(3, this.wWR);
            }
            c6093a.mo13480iz(4, this.wdW);
            if (this.Md5 != null) {
                c6093a.mo13475e(5, this.Md5);
            }
            c6093a.mo13480iz(6, this.vHo);
            if (this.guQ != null) {
                c6093a.mo13475e(7, this.guQ);
            }
            if (this.wWS != null) {
                c6093a.mo13475e(8, this.wWS);
            }
            c6093a.mo13480iz(9, this.wWT);
            c6093a.mo13480iz(10, this.vRy);
            AppMethodBeat.m2505o(28629);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wWQ != null) {
                ix += C6087a.m9557ix(2, this.wWQ.computeSize());
            }
            if (this.wWR != null) {
                ix += C6091a.m9575f(3, this.wWR);
            }
            ix += C6091a.m9572bs(4, this.wdW);
            if (this.Md5 != null) {
                ix += C6091a.m9575f(5, this.Md5);
            }
            ix += C6091a.m9572bs(6, this.vHo);
            if (this.guQ != null) {
                ix += C6091a.m9575f(7, this.guQ);
            }
            if (this.wWS != null) {
                ix += C6091a.m9575f(8, this.wWS);
            }
            int bs = (ix + C6091a.m9572bs(9, this.wWT)) + C6091a.m9572bs(10, this.vRy);
            AppMethodBeat.m2505o(28629);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wWQ == null) {
                c6092b = new C6092b("Not all required fields were included: Msg");
                AppMethodBeat.m2505o(28629);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28629);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bwb bwb = (bwb) objArr[1];
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
                        bwb.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28629);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46534dv c46534dv = new C46534dv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46534dv.populateBuilderWithField(c6086a3, c46534dv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bwb.wWQ = c46534dv;
                    }
                    AppMethodBeat.m2505o(28629);
                    return 0;
                case 3:
                    bwb.wWR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28629);
                    return 0;
                case 4:
                    bwb.wdW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28629);
                    return 0;
                case 5:
                    bwb.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28629);
                    return 0;
                case 6:
                    bwb.vHo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28629);
                    return 0;
                case 7:
                    bwb.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28629);
                    return 0;
                case 8:
                    bwb.wWS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28629);
                    return 0;
                case 9:
                    bwb.wWT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28629);
                    return 0;
                case 10:
                    bwb.vRy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28629);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28629);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28629);
            return -1;
        }
    }
}
