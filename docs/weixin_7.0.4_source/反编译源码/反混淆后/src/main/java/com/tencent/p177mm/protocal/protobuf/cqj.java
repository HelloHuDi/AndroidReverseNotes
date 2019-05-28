package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cqj */
public final class cqj extends bsr {
    public int vTN;
    public SKBuiltinBuffer_t vTO;
    public String wPm;
    public int wem;
    public long wen;
    public long xlQ;
    public cpg xoq;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5279);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vTO == null) {
                c6092b = new C6092b("Not all required fields were included: KeyBuf");
                AppMethodBeat.m2505o(5279);
                throw c6092b;
            } else if (this.xoq == null) {
                c6092b = new C6092b("Not all required fields were included: OpLog");
                AppMethodBeat.m2505o(5279);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.wPm != null) {
                    c6093a.mo13475e(2, this.wPm);
                }
                c6093a.mo13480iz(3, this.wem);
                if (this.vTO != null) {
                    c6093a.mo13479iy(4, this.vTO.computeSize());
                    this.vTO.writeFields(c6093a);
                }
                if (this.xoq != null) {
                    c6093a.mo13479iy(5, this.xoq.computeSize());
                    this.xoq.writeFields(c6093a);
                }
                c6093a.mo13472ai(6, this.wen);
                c6093a.mo13480iz(7, this.vTN);
                c6093a.mo13472ai(8, this.xlQ);
                AppMethodBeat.m2505o(5279);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPm != null) {
                ix += C6091a.m9575f(2, this.wPm);
            }
            ix += C6091a.m9572bs(3, this.wem);
            if (this.vTO != null) {
                ix += C6087a.m9557ix(4, this.vTO.computeSize());
            }
            if (this.xoq != null) {
                ix += C6087a.m9557ix(5, this.xoq.computeSize());
            }
            int o = ((ix + C6091a.m9578o(6, this.wen)) + C6091a.m9572bs(7, this.vTN)) + C6091a.m9578o(8, this.xlQ);
            AppMethodBeat.m2505o(5279);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vTO == null) {
                c6092b = new C6092b("Not all required fields were included: KeyBuf");
                AppMethodBeat.m2505o(5279);
                throw c6092b;
            } else if (this.xoq == null) {
                c6092b = new C6092b("Not all required fields were included: OpLog");
                AppMethodBeat.m2505o(5279);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(5279);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cqj cqj = (cqj) objArr[1];
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
                        cqj.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(5279);
                    return 0;
                case 2:
                    cqj.wPm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5279);
                    return 0;
                case 3:
                    cqj.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5279);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqj.vTO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5279);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpg cpg = new cpg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpg.populateBuilderWithField(c6086a3, cpg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqj.xoq = cpg;
                    }
                    AppMethodBeat.m2505o(5279);
                    return 0;
                case 6:
                    cqj.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5279);
                    return 0;
                case 7:
                    cqj.vTN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5279);
                    return 0;
                case 8:
                    cqj.xlQ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5279);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5279);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5279);
            return -1;
        }
    }
}
