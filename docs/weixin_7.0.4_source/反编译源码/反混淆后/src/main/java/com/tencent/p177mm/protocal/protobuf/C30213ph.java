package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ph */
public final class C30213ph extends C1331a {
    public C15372pg vWA;
    public C15372pg vWB;
    public C15372pg vWC;
    public C15372pg vWD;
    public C15372pg vWE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89051);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vWA != null) {
                c6093a.mo13479iy(1, this.vWA.computeSize());
                this.vWA.writeFields(c6093a);
            }
            if (this.vWB != null) {
                c6093a.mo13479iy(2, this.vWB.computeSize());
                this.vWB.writeFields(c6093a);
            }
            if (this.vWC != null) {
                c6093a.mo13479iy(3, this.vWC.computeSize());
                this.vWC.writeFields(c6093a);
            }
            if (this.vWD != null) {
                c6093a.mo13479iy(4, this.vWD.computeSize());
                this.vWD.writeFields(c6093a);
            }
            if (this.vWE != null) {
                c6093a.mo13479iy(5, this.vWE.computeSize());
                this.vWE.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(89051);
            return 0;
        } else if (i == 1) {
            if (this.vWA != null) {
                ix = C6087a.m9557ix(1, this.vWA.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vWB != null) {
                ix += C6087a.m9557ix(2, this.vWB.computeSize());
            }
            if (this.vWC != null) {
                ix += C6087a.m9557ix(3, this.vWC.computeSize());
            }
            if (this.vWD != null) {
                ix += C6087a.m9557ix(4, this.vWD.computeSize());
            }
            if (this.vWE != null) {
                ix += C6087a.m9557ix(5, this.vWE.computeSize());
            }
            AppMethodBeat.m2505o(89051);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89051);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30213ph c30213ph = (C30213ph) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C15372pg c15372pg;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c15372pg = new C15372pg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15372pg.populateBuilderWithField(c6086a3, c15372pg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30213ph.vWA = c15372pg;
                    }
                    AppMethodBeat.m2505o(89051);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c15372pg = new C15372pg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15372pg.populateBuilderWithField(c6086a3, c15372pg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30213ph.vWB = c15372pg;
                    }
                    AppMethodBeat.m2505o(89051);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c15372pg = new C15372pg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15372pg.populateBuilderWithField(c6086a3, c15372pg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30213ph.vWC = c15372pg;
                    }
                    AppMethodBeat.m2505o(89051);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c15372pg = new C15372pg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15372pg.populateBuilderWithField(c6086a3, c15372pg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30213ph.vWD = c15372pg;
                    }
                    AppMethodBeat.m2505o(89051);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c15372pg = new C15372pg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15372pg.populateBuilderWithField(c6086a3, c15372pg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30213ph.vWE = c15372pg;
                    }
                    AppMethodBeat.m2505o(89051);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89051);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89051);
            return -1;
        }
    }
}
