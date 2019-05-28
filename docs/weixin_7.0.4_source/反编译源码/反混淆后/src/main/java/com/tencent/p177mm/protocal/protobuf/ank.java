package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ank */
public final class ank extends bsr {
    public long bHi;
    public int bNT = 5;
    public int wsg;
    public C40552oo wsh;
    public C23440sq wsi;
    public int wsj;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(134430);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wsg);
            c6093a.mo13480iz(3, this.bNT);
            if (this.wsh != null) {
                c6093a.mo13479iy(4, this.wsh.computeSize());
                this.wsh.writeFields(c6093a);
            }
            c6093a.mo13472ai(5, this.bHi);
            if (this.wsi != null) {
                c6093a.mo13479iy(6, this.wsi.computeSize());
                this.wsi.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.wsj);
            AppMethodBeat.m2505o(134430);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.wsg)) + C6091a.m9572bs(3, this.bNT);
            if (this.wsh != null) {
                ix += C6087a.m9557ix(4, this.wsh.computeSize());
            }
            ix += C6091a.m9578o(5, this.bHi);
            if (this.wsi != null) {
                ix += C6087a.m9557ix(6, this.wsi.computeSize());
            }
            int bs = ix + C6091a.m9572bs(7, this.wsj);
            AppMethodBeat.m2505o(134430);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(134430);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ank ank = (ank) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ank.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(134430);
                    return 0;
                case 2:
                    ank.wsg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134430);
                    return 0;
                case 3:
                    ank.bNT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134430);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40552oo c40552oo = new C40552oo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40552oo.populateBuilderWithField(c6086a3, c40552oo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ank.wsh = c40552oo;
                    }
                    AppMethodBeat.m2505o(134430);
                    return 0;
                case 5:
                    ank.bHi = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(134430);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23440sq c23440sq = new C23440sq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23440sq.populateBuilderWithField(c6086a3, c23440sq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ank.wsi = c23440sq;
                    }
                    AppMethodBeat.m2505o(134430);
                    return 0;
                case 7:
                    ank.wsj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134430);
                    return 0;
                default:
                    AppMethodBeat.m2505o(134430);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(134430);
            return -1;
        }
    }
}
