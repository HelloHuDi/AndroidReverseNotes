package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cgo */
public final class cgo extends bsr {
    public int Scene;
    public int xfv;
    public LinkedList<cgn> xfw = new LinkedList();

    public cgo() {
        AppMethodBeat.m2504i(28669);
        AppMethodBeat.m2505o(28669);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28670);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.xfv);
            c6093a.mo13474e(3, 8, this.xfw);
            c6093a.mo13480iz(4, this.Scene);
            AppMethodBeat.m2505o(28670);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((ix + C6091a.m9572bs(2, this.xfv)) + C6087a.m9552c(3, 8, this.xfw)) + C6091a.m9572bs(4, this.Scene);
            AppMethodBeat.m2505o(28670);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xfw.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28670);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cgo cgo = (cgo) objArr[1];
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
                        cgo.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28670);
                    return 0;
                case 2:
                    cgo.xfv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28670);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgn cgn = new cgn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgn.populateBuilderWithField(c6086a3, cgn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cgo.xfw.add(cgn);
                    }
                    AppMethodBeat.m2505o(28670);
                    return 0;
                case 4:
                    cgo.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28670);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28670);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28670);
            return -1;
        }
    }
}
