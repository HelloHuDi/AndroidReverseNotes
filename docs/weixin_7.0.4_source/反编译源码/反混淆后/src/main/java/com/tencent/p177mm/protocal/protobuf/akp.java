package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.akp */
public final class akp extends bsr {
    public int Scene;
    public int nbk;
    public String wdO;
    public int wqg;
    public LinkedList<bbl> wqh = new LinkedList();
    public int wqi;
    public LinkedList<azc> wqj = new LinkedList();

    public akp() {
        AppMethodBeat.m2504i(73707);
        AppMethodBeat.m2505o(73707);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73708);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.nbk);
            if (this.wdO != null) {
                c6093a.mo13475e(3, this.wdO);
            }
            c6093a.mo13480iz(4, this.wqg);
            c6093a.mo13474e(5, 8, this.wqh);
            c6093a.mo13480iz(6, this.wqi);
            c6093a.mo13474e(7, 8, this.wqj);
            c6093a.mo13480iz(8, this.Scene);
            AppMethodBeat.m2505o(73708);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.nbk);
            if (this.wdO != null) {
                ix += C6091a.m9575f(3, this.wdO);
            }
            int bs = ((((ix + C6091a.m9572bs(4, this.wqg)) + C6087a.m9552c(5, 8, this.wqh)) + C6091a.m9572bs(6, this.wqi)) + C6087a.m9552c(7, 8, this.wqj)) + C6091a.m9572bs(8, this.Scene);
            AppMethodBeat.m2505o(73708);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wqh.clear();
            this.wqj.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73708);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            akp akp = (akp) objArr[1];
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
                        akp.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(73708);
                    return 0;
                case 2:
                    akp.nbk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73708);
                    return 0;
                case 3:
                    akp.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73708);
                    return 0;
                case 4:
                    akp.wqg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73708);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbl bbl = new bbl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbl.populateBuilderWithField(c6086a3, bbl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        akp.wqh.add(bbl);
                    }
                    AppMethodBeat.m2505o(73708);
                    return 0;
                case 6:
                    akp.wqi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73708);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        azc azc = new azc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = azc.populateBuilderWithField(c6086a3, azc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        akp.wqj.add(azc);
                    }
                    AppMethodBeat.m2505o(73708);
                    return 0;
                case 8:
                    akp.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73708);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73708);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73708);
            return -1;
        }
    }
}
