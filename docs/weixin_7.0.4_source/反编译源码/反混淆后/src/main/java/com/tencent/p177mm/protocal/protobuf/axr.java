package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.axr */
public final class axr extends btd {
    public axn wBI;
    public C15381rg wBJ;
    public cwn wBK;
    public bmm wBL;
    public C15321ay wBM;
    public bhm wBN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96274);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(96274);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wBI != null) {
                c6093a.mo13479iy(2, this.wBI.computeSize());
                this.wBI.writeFields(c6093a);
            }
            if (this.wBJ != null) {
                c6093a.mo13479iy(3, this.wBJ.computeSize());
                this.wBJ.writeFields(c6093a);
            }
            if (this.wBK != null) {
                c6093a.mo13479iy(4, this.wBK.computeSize());
                this.wBK.writeFields(c6093a);
            }
            if (this.wBL != null) {
                c6093a.mo13479iy(5, this.wBL.computeSize());
                this.wBL.writeFields(c6093a);
            }
            if (this.wBM != null) {
                c6093a.mo13479iy(6, this.wBM.computeSize());
                this.wBM.writeFields(c6093a);
            }
            if (this.wBN != null) {
                c6093a.mo13479iy(7, this.wBN.computeSize());
                this.wBN.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(96274);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wBI != null) {
                ix += C6087a.m9557ix(2, this.wBI.computeSize());
            }
            if (this.wBJ != null) {
                ix += C6087a.m9557ix(3, this.wBJ.computeSize());
            }
            if (this.wBK != null) {
                ix += C6087a.m9557ix(4, this.wBK.computeSize());
            }
            if (this.wBL != null) {
                ix += C6087a.m9557ix(5, this.wBL.computeSize());
            }
            if (this.wBM != null) {
                ix += C6087a.m9557ix(6, this.wBM.computeSize());
            }
            if (this.wBN != null) {
                ix += C6087a.m9557ix(7, this.wBN.computeSize());
            }
            AppMethodBeat.m2505o(96274);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(96274);
                throw c6092b;
            }
            AppMethodBeat.m2505o(96274);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            axr axr = (axr) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(96274);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axn axn = new axn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axn.populateBuilderWithField(c6086a3, axn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axr.wBI = axn;
                    }
                    AppMethodBeat.m2505o(96274);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15381rg c15381rg = new C15381rg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15381rg.populateBuilderWithField(c6086a3, c15381rg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axr.wBJ = c15381rg;
                    }
                    AppMethodBeat.m2505o(96274);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwn cwn = new cwn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwn.populateBuilderWithField(c6086a3, cwn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axr.wBK = cwn;
                    }
                    AppMethodBeat.m2505o(96274);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bmm bmm = new bmm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmm.populateBuilderWithField(c6086a3, bmm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axr.wBL = bmm;
                    }
                    AppMethodBeat.m2505o(96274);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15321ay c15321ay = new C15321ay();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15321ay.populateBuilderWithField(c6086a3, c15321ay, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axr.wBM = c15321ay;
                    }
                    AppMethodBeat.m2505o(96274);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhm bhm = new bhm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhm.populateBuilderWithField(c6086a3, bhm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axr.wBN = bhm;
                    }
                    AppMethodBeat.m2505o(96274);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96274);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96274);
            return -1;
        }
    }
}
