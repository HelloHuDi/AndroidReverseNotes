package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bq */
public final class C15322bq extends C1331a {
    public axb vDV;
    public LinkedList<axc> vDW = new LinkedList();

    public C15322bq() {
        AppMethodBeat.m2504i(70471);
        AppMethodBeat.m2505o(70471);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(70472);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vDV == null) {
                c6092b = new C6092b("Not all required fields were included: LogHead");
                AppMethodBeat.m2505o(70472);
                throw c6092b;
            }
            if (this.vDV != null) {
                c6093a.mo13479iy(1, this.vDV.computeSize());
                this.vDV.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vDW);
            AppMethodBeat.m2505o(70472);
            return 0;
        } else if (i == 1) {
            if (this.vDV != null) {
                ix = C6087a.m9557ix(1, this.vDV.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = ix + C6087a.m9552c(2, 8, this.vDW);
            AppMethodBeat.m2505o(70472);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vDW.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vDV == null) {
                c6092b = new C6092b("Not all required fields were included: LogHead");
                AppMethodBeat.m2505o(70472);
                throw c6092b;
            }
            AppMethodBeat.m2505o(70472);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15322bq c15322bq = (C15322bq) objArr[1];
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
                        axb axb = new axb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axb.populateBuilderWithField(c6086a3, axb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15322bq.vDV = axb;
                    }
                    AppMethodBeat.m2505o(70472);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axc axc = new axc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axc.populateBuilderWithField(c6086a3, axc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15322bq.vDW.add(axc);
                    }
                    AppMethodBeat.m2505o(70472);
                    return 0;
                default:
                    AppMethodBeat.m2505o(70472);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(70472);
            return -1;
        }
    }
}
