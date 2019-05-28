package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cwo */
public final class cwo extends bsr {
    public LinkedList<cwt> xsk = new LinkedList();
    public brr xsl;

    public cwo() {
        AppMethodBeat.m2504i(96326);
        AppMethodBeat.m2505o(96326);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96327);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.xsk);
            if (this.xsl != null) {
                c6093a.mo13479iy(3, this.xsl.computeSize());
                this.xsl.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(96327);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.xsk);
            if (this.xsl != null) {
                ix += C6087a.m9557ix(3, this.xsl.computeSize());
            }
            AppMethodBeat.m2505o(96327);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xsk.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96327);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cwo cwo = (cwo) objArr[1];
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
                        cwo.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(96327);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwt cwt = new cwt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwt.populateBuilderWithField(c6086a3, cwt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwo.xsk.add(cwt);
                    }
                    AppMethodBeat.m2505o(96327);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brr brr = new brr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = brr.populateBuilderWithField(c6086a3, brr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwo.xsl = brr;
                    }
                    AppMethodBeat.m2505o(96327);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96327);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96327);
            return -1;
        }
    }
}
