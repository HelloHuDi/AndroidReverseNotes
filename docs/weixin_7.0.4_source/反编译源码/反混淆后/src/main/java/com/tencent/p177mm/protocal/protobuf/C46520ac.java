package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ac */
public final class C46520ac extends bsr {
    public LinkedList<C7257dh> vAL = new LinkedList();
    public int vBd;
    public C23460xa vBe;
    public int vBf;

    public C46520ac() {
        AppMethodBeat.m2504i(28294);
        AppMethodBeat.m2505o(28294);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28295);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vBd);
            c6093a.mo13474e(3, 8, this.vAL);
            if (this.vBe != null) {
                c6093a.mo13479iy(4, this.vBe.computeSize());
                this.vBe.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.vBf);
            AppMethodBeat.m2505o(28295);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.vBd)) + C6087a.m9552c(3, 8, this.vAL);
            if (this.vBe != null) {
                ix += C6087a.m9557ix(4, this.vBe.computeSize());
            }
            int bs = ix + C6091a.m9572bs(5, this.vBf);
            AppMethodBeat.m2505o(28295);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vAL.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28295);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46520ac c46520ac = (C46520ac) objArr[1];
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
                        c46520ac.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28295);
                    return 0;
                case 2:
                    c46520ac.vBd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28295);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7257dh c7257dh = new C7257dh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7257dh.populateBuilderWithField(c6086a3, c7257dh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46520ac.vAL.add(c7257dh);
                    }
                    AppMethodBeat.m2505o(28295);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23460xa c23460xa = new C23460xa();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23460xa.populateBuilderWithField(c6086a3, c23460xa, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46520ac.vBe = c23460xa;
                    }
                    AppMethodBeat.m2505o(28295);
                    return 0;
                case 5:
                    c46520ac.vBf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28295);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28295);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28295);
            return -1;
        }
    }
}
