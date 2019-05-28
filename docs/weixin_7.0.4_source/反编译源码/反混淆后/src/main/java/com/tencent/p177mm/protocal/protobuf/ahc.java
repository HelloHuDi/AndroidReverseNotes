package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ahc */
public final class ahc extends C1331a {
    public int vEI;
    public bts wnA;
    public int wnB;
    public int wnC;
    public int wnD = 1;
    public int wnE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5580);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wnA == null) {
                c6092b = new C6092b("Not all required fields were included: ChatroomId");
                AppMethodBeat.m2505o(5580);
                throw c6092b;
            }
            if (this.wnA != null) {
                c6093a.mo13479iy(1, this.wnA.computeSize());
                this.wnA.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vEI);
            c6093a.mo13480iz(3, this.wnB);
            c6093a.mo13480iz(4, this.wnC);
            c6093a.mo13480iz(5, this.wnD);
            c6093a.mo13480iz(6, this.wnE);
            AppMethodBeat.m2505o(5580);
            return 0;
        } else if (i == 1) {
            if (this.wnA != null) {
                ix = C6087a.m9557ix(1, this.wnA.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((ix + C6091a.m9572bs(2, this.vEI)) + C6091a.m9572bs(3, this.wnB)) + C6091a.m9572bs(4, this.wnC)) + C6091a.m9572bs(5, this.wnD)) + C6091a.m9572bs(6, this.wnE);
            AppMethodBeat.m2505o(5580);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wnA == null) {
                c6092b = new C6092b("Not all required fields were included: ChatroomId");
                AppMethodBeat.m2505o(5580);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5580);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ahc ahc = (ahc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ahc.wnA = bts;
                    }
                    AppMethodBeat.m2505o(5580);
                    return 0;
                case 2:
                    ahc.vEI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5580);
                    return 0;
                case 3:
                    ahc.wnB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5580);
                    return 0;
                case 4:
                    ahc.wnC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5580);
                    return 0;
                case 5:
                    ahc.wnD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5580);
                    return 0;
                case 6:
                    ahc.wnE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5580);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5580);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5580);
            return -1;
        }
    }
}
