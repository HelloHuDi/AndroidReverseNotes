package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.es */
public final class C7537es extends bsr {
    public LinkedList<C35916er> vGC = new LinkedList();
    public int vGD;

    public C7537es() {
        AppMethodBeat.m2504i(14703);
        AppMethodBeat.m2505o(14703);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14704);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vGC);
            c6093a.mo13480iz(3, this.vGD);
            AppMethodBeat.m2505o(14704);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (ix + C6087a.m9552c(2, 8, this.vGC)) + C6091a.m9572bs(3, this.vGD);
            AppMethodBeat.m2505o(14704);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vGC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14704);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7537es c7537es = (C7537es) objArr[1];
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
                        c7537es.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(14704);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35916er c35916er = new C35916er();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35916er.populateBuilderWithField(c6086a3, c35916er, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7537es.vGC.add(c35916er);
                    }
                    AppMethodBeat.m2505o(14704);
                    return 0;
                case 3:
                    c7537es.vGD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14704);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14704);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14704);
            return -1;
        }
    }
}
