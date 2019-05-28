package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.az */
public final class C46524az extends C1331a {
    public cgv vCN;
    public cgv vCO;
    public btr vCP;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48769);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vCN != null) {
                c6093a.mo13479iy(1, this.vCN.computeSize());
                this.vCN.writeFields(c6093a);
            }
            if (this.vCO != null) {
                c6093a.mo13479iy(2, this.vCO.computeSize());
                this.vCO.writeFields(c6093a);
            }
            if (this.vCP != null) {
                c6093a.mo13479iy(3, this.vCP.computeSize());
                this.vCP.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48769);
            return 0;
        } else if (i == 1) {
            if (this.vCN != null) {
                ix = C6087a.m9557ix(1, this.vCN.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vCO != null) {
                ix += C6087a.m9557ix(2, this.vCO.computeSize());
            }
            if (this.vCP != null) {
                ix += C6087a.m9557ix(3, this.vCP.computeSize());
            }
            AppMethodBeat.m2505o(48769);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48769);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46524az c46524az = (C46524az) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            cgv cgv;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46524az.vCN = cgv;
                    }
                    AppMethodBeat.m2505o(48769);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46524az.vCO = cgv;
                    }
                    AppMethodBeat.m2505o(48769);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(c6086a3, btr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46524az.vCP = btr;
                    }
                    AppMethodBeat.m2505o(48769);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48769);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48769);
            return -1;
        }
    }
}
