package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cah */
public final class cah extends C1331a {
    public int vFH;
    public bts wZq;
    public bts wZs;
    public int wZt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94557);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wZq != null) {
                c6093a.mo13479iy(1, this.wZq.computeSize());
                this.wZq.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vFH);
            if (this.wZs != null) {
                c6093a.mo13479iy(3, this.wZs.computeSize());
                this.wZs.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.wZt);
            AppMethodBeat.m2505o(94557);
            return 0;
        } else if (i == 1) {
            if (this.wZq != null) {
                ix = C6087a.m9557ix(1, this.wZq.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.vFH);
            if (this.wZs != null) {
                ix += C6087a.m9557ix(3, this.wZs.computeSize());
            }
            int bs = ix + C6091a.m9572bs(4, this.wZt);
            AppMethodBeat.m2505o(94557);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94557);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cah cah = (cah) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cah.wZq = bts;
                    }
                    AppMethodBeat.m2505o(94557);
                    return 0;
                case 2:
                    cah.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94557);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cah.wZs = bts;
                    }
                    AppMethodBeat.m2505o(94557);
                    return 0;
                case 4:
                    cah.wZt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94557);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94557);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94557);
            return -1;
        }
    }
}
