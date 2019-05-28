package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bdq */
public final class bdq extends C1331a {
    public cgv vCN;
    public bds wHr;
    public bdr wHs;
    public bdr wHt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48898);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vCN != null) {
                c6093a.mo13479iy(1, this.vCN.computeSize());
                this.vCN.writeFields(c6093a);
            }
            if (this.wHr != null) {
                c6093a.mo13479iy(2, this.wHr.computeSize());
                this.wHr.writeFields(c6093a);
            }
            if (this.wHs != null) {
                c6093a.mo13479iy(3, this.wHs.computeSize());
                this.wHs.writeFields(c6093a);
            }
            if (this.wHt != null) {
                c6093a.mo13479iy(4, this.wHt.computeSize());
                this.wHt.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48898);
            return 0;
        } else if (i == 1) {
            if (this.vCN != null) {
                ix = C6087a.m9557ix(1, this.vCN.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wHr != null) {
                ix += C6087a.m9557ix(2, this.wHr.computeSize());
            }
            if (this.wHs != null) {
                ix += C6087a.m9557ix(3, this.wHs.computeSize());
            }
            if (this.wHt != null) {
                ix += C6087a.m9557ix(4, this.wHt.computeSize());
            }
            AppMethodBeat.m2505o(48898);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48898);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bdq bdq = (bdq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            bdr bdr;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bdq.vCN = cgv;
                    }
                    AppMethodBeat.m2505o(48898);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bds bds = new bds();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bds.populateBuilderWithField(c6086a3, bds, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bdq.wHr = bds;
                    }
                    AppMethodBeat.m2505o(48898);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdr = new bdr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdr.populateBuilderWithField(c6086a3, bdr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bdq.wHs = bdr;
                    }
                    AppMethodBeat.m2505o(48898);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdr = new bdr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdr.populateBuilderWithField(c6086a3, bdr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bdq.wHt = bdr;
                    }
                    AppMethodBeat.m2505o(48898);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48898);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48898);
            return -1;
        }
    }
}
