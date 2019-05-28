package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cy */
public final class C46531cy extends C1331a {
    public cai vEX;
    public bts vEY;
    public int vEZ;
    public brf vFa;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94503);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEX == null) {
                c6092b = new C6092b("Not all required fields were included: SnsADObject");
                AppMethodBeat.m2505o(94503);
                throw c6092b;
            }
            if (this.vEX != null) {
                c6093a.mo13479iy(1, this.vEX.computeSize());
                this.vEX.writeFields(c6093a);
            }
            if (this.vEY != null) {
                c6093a.mo13479iy(2, this.vEY.computeSize());
                this.vEY.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.vEZ);
            if (this.vFa != null) {
                c6093a.mo13479iy(4, this.vFa.computeSize());
                this.vFa.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94503);
            return 0;
        } else if (i == 1) {
            if (this.vEX != null) {
                ix = C6087a.m9557ix(1, this.vEX.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vEY != null) {
                ix += C6087a.m9557ix(2, this.vEY.computeSize());
            }
            ix += C6091a.m9572bs(3, this.vEZ);
            if (this.vFa != null) {
                ix += C6087a.m9557ix(4, this.vFa.computeSize());
            }
            AppMethodBeat.m2505o(94503);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vEX == null) {
                c6092b = new C6092b("Not all required fields were included: SnsADObject");
                AppMethodBeat.m2505o(94503);
                throw c6092b;
            }
            AppMethodBeat.m2505o(94503);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46531cy c46531cy = (C46531cy) objArr[1];
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
                        cai cai = new cai();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cai.populateBuilderWithField(c6086a3, cai, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46531cy.vEX = cai;
                    }
                    AppMethodBeat.m2505o(94503);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46531cy.vEY = bts;
                    }
                    AppMethodBeat.m2505o(94503);
                    return 0;
                case 3:
                    c46531cy.vEZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94503);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brf brf = new brf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = brf.populateBuilderWithField(c6086a3, brf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46531cy.vFa = brf;
                    }
                    AppMethodBeat.m2505o(94503);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94503);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94503);
            return -1;
        }
    }
}
