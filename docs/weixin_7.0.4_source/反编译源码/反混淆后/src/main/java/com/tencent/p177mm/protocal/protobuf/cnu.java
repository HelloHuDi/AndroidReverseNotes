package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cnu */
public final class cnu extends C1331a {
    public C40577ue xkY;
    public boolean xkZ = true;
    public cnq xla;
    public String xlb;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124376);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xkY != null) {
                c6093a.mo13479iy(1, this.xkY.computeSize());
                this.xkY.writeFields(c6093a);
            }
            c6093a.mo13471aO(2, this.xkZ);
            if (this.xla != null) {
                c6093a.mo13479iy(3, this.xla.computeSize());
                this.xla.writeFields(c6093a);
            }
            if (this.xlb != null) {
                c6093a.mo13475e(4, this.xlb);
            }
            AppMethodBeat.m2505o(124376);
            return 0;
        } else if (i == 1) {
            if (this.xkY != null) {
                ix = C6087a.m9557ix(1, this.xkY.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9576fv(2) + 1;
            if (this.xla != null) {
                ix += C6087a.m9557ix(3, this.xla.computeSize());
            }
            if (this.xlb != null) {
                ix += C6091a.m9575f(4, this.xlb);
            }
            AppMethodBeat.m2505o(124376);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124376);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cnu cnu = (cnu) objArr[1];
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
                        C40577ue c40577ue = new C40577ue();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40577ue.populateBuilderWithField(c6086a3, c40577ue, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnu.xkY = c40577ue;
                    }
                    AppMethodBeat.m2505o(124376);
                    return 0;
                case 2:
                    cnu.xkZ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(124376);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnq cnq = new cnq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnq.populateBuilderWithField(c6086a3, cnq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnu.xla = cnq;
                    }
                    AppMethodBeat.m2505o(124376);
                    return 0;
                case 4:
                    cnu.xlb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124376);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124376);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124376);
            return -1;
        }
    }
}
