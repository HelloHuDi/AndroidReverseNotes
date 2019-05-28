package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bow */
public final class bow extends bsr {
    public bqe wRt;
    public bqc wRu;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(134436);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wRt != null) {
                c6093a.mo13479iy(2, this.wRt.computeSize());
                this.wRt.writeFields(c6093a);
            }
            if (this.wRu != null) {
                c6093a.mo13479iy(3, this.wRu.computeSize());
                this.wRu.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(134436);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wRt != null) {
                ix += C6087a.m9557ix(2, this.wRt.computeSize());
            }
            if (this.wRu != null) {
                ix += C6087a.m9557ix(3, this.wRu.computeSize());
            }
            AppMethodBeat.m2505o(134436);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(134436);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bow bow = (bow) objArr[1];
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
                        bow.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(134436);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqe bqe = new bqe();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqe.populateBuilderWithField(c6086a3, bqe, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bow.wRt = bqe;
                    }
                    AppMethodBeat.m2505o(134436);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqc bqc = new bqc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqc.populateBuilderWithField(c6086a3, bqc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bow.wRu = bqc;
                    }
                    AppMethodBeat.m2505o(134436);
                    return 0;
                default:
                    AppMethodBeat.m2505o(134436);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(134436);
            return -1;
        }
    }
}
