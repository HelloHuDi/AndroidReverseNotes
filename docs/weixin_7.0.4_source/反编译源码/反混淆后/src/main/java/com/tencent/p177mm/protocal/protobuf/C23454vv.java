package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.vv */
public final class C23454vv extends C1331a {
    public int jBv;
    public bts wcB;
    public LinkedList<Integer> wcH = new LinkedList();

    public C23454vv() {
        AppMethodBeat.m2504i(60032);
        AppMethodBeat.m2505o(60032);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60033);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(60033);
                throw c6092b;
            }
            if (this.wcB != null) {
                c6093a.mo13479iy(1, this.wcB.computeSize());
                this.wcB.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.jBv);
            c6093a.mo13477f(3, 2, this.wcH);
            AppMethodBeat.m2505o(60033);
            return 0;
        } else if (i == 1) {
            if (this.wcB != null) {
                ix = C6087a.m9557ix(1, this.wcB.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (ix + C6091a.m9572bs(2, this.jBv)) + C6087a.m9553d(3, 2, this.wcH);
            AppMethodBeat.m2505o(60033);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wcH.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(60033);
                throw c6092b;
            }
            AppMethodBeat.m2505o(60033);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23454vv c23454vv = (C23454vv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23454vv.wcB = bts;
                    }
                    AppMethodBeat.m2505o(60033);
                    return 0;
                case 2:
                    c23454vv.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60033);
                    return 0;
                case 3:
                    c23454vv.wcH = new C6086a(c6086a2.BTU.emu().f1226wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.m2505o(60033);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60033);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60033);
            return -1;
        }
    }
}
