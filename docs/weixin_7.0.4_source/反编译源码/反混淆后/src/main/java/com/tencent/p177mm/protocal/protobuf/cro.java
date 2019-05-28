package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cro */
public final class cro extends C1331a {
    public cqm xoW;
    public crf xpg;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102426);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xoW == null) {
                c6092b = new C6092b("Not all required fields were included: base_response");
                AppMethodBeat.m2505o(102426);
                throw c6092b;
            }
            if (this.xoW != null) {
                c6093a.mo13479iy(1, this.xoW.computeSize());
                this.xoW.writeFields(c6093a);
            }
            if (this.xpg != null) {
                c6093a.mo13479iy(2, this.xpg.computeSize());
                this.xpg.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(102426);
            return 0;
        } else if (i == 1) {
            if (this.xoW != null) {
                ix = C6087a.m9557ix(1, this.xoW.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xpg != null) {
                ix += C6087a.m9557ix(2, this.xpg.computeSize());
            }
            AppMethodBeat.m2505o(102426);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xoW == null) {
                c6092b = new C6092b("Not all required fields were included: base_response");
                AppMethodBeat.m2505o(102426);
                throw c6092b;
            }
            AppMethodBeat.m2505o(102426);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cro cro = (cro) objArr[1];
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
                        cqm cqm = new cqm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqm.populateBuilderWithField(c6086a3, cqm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cro.xoW = cqm;
                    }
                    AppMethodBeat.m2505o(102426);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        crf crf = new crf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = crf.populateBuilderWithField(c6086a3, crf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cro.xpg = crf;
                    }
                    AppMethodBeat.m2505o(102426);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102426);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102426);
            return -1;
        }
    }
}
