package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cnh */
public final class cnh extends bsr {
    public int vIJ;
    public SKBuiltinBuffer_t vIl;
    public String wsM;
    public int xkM;
    public LinkedList<cnf> xkN = new LinkedList();
    public int xkO;
    public LinkedList<Integer> xkP = new LinkedList();
    public int xkQ;
    public LinkedList<cng> xkR = new LinkedList();

    public cnh() {
        AppMethodBeat.m2504i(80209);
        AppMethodBeat.m2505o(80209);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80210);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vIJ);
            c6093a.mo13480iz(3, this.xkM);
            c6093a.mo13474e(4, 8, this.xkN);
            if (this.wsM != null) {
                c6093a.mo13475e(5, this.wsM);
            }
            c6093a.mo13480iz(6, this.xkO);
            c6093a.mo13477f(7, 2, this.xkP);
            c6093a.mo13480iz(8, this.xkQ);
            c6093a.mo13474e(9, 8, this.xkR);
            if (this.vIl != null) {
                c6093a.mo13479iy(10, this.vIl.computeSize());
                this.vIl.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(80210);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + C6091a.m9572bs(2, this.vIJ)) + C6091a.m9572bs(3, this.xkM)) + C6087a.m9552c(4, 8, this.xkN);
            if (this.wsM != null) {
                ix += C6091a.m9575f(5, this.wsM);
            }
            ix = (((ix + C6091a.m9572bs(6, this.xkO)) + C6087a.m9553d(7, 2, this.xkP)) + C6091a.m9572bs(8, this.xkQ)) + C6087a.m9552c(9, 8, this.xkR);
            if (this.vIl != null) {
                ix += C6087a.m9557ix(10, this.vIl.computeSize());
            }
            AppMethodBeat.m2505o(80210);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xkN.clear();
            this.xkP.clear();
            this.xkR.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80210);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cnh cnh = (cnh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        cnh.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(80210);
                    return 0;
                case 2:
                    cnh.vIJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80210);
                    return 0;
                case 3:
                    cnh.xkM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80210);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnf cnf = new cnf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnf.populateBuilderWithField(c6086a3, cnf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnh.xkN.add(cnf);
                    }
                    AppMethodBeat.m2505o(80210);
                    return 0;
                case 5:
                    cnh.wsM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80210);
                    return 0;
                case 6:
                    cnh.xkO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80210);
                    return 0;
                case 7:
                    cnh.xkP = new C6086a(c6086a2.BTU.emu().f1226wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.m2505o(80210);
                    return 0;
                case 8:
                    cnh.xkQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80210);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cng cng = new cng();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cng.populateBuilderWithField(c6086a3, cng, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnh.xkR.add(cng);
                    }
                    AppMethodBeat.m2505o(80210);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnh.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80210);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80210);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80210);
            return -1;
        }
    }
}
