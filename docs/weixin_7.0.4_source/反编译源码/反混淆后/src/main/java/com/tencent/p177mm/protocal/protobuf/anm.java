package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.anm */
public final class anm extends bsr {
    public float cEB;
    public float cGm;
    public long rUb;
    public int wsn;
    public LinkedList<C1332b> wso = new LinkedList();

    public anm() {
        AppMethodBeat.m2504i(108894);
        AppMethodBeat.m2505o(108894);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(108895);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wsn);
            c6093a.mo13481r(3, this.cEB);
            c6093a.mo13481r(4, this.cGm);
            c6093a.mo13474e(5, 6, this.wso);
            c6093a.mo13472ai(6, this.rUb);
            AppMethodBeat.m2505o(108895);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((ix + C6091a.m9572bs(2, this.wsn)) + (C6091a.m9576fv(3) + 4)) + (C6091a.m9576fv(4) + 4)) + C6087a.m9552c(5, 6, this.wso)) + C6091a.m9578o(6, this.rUb);
            AppMethodBeat.m2505o(108895);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wso.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(108895);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            anm anm = (anm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        anm.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(108895);
                    return 0;
                case 2:
                    anm.wsn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108895);
                    return 0;
                case 3:
                    anm.cEB = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(108895);
                    return 0;
                case 4:
                    anm.cGm = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(108895);
                    return 0;
                case 5:
                    anm.wso.add(c6086a2.BTU.emu());
                    AppMethodBeat.m2505o(108895);
                    return 0;
                case 6:
                    anm.rUb = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(108895);
                    return 0;
                default:
                    AppMethodBeat.m2505o(108895);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(108895);
            return -1;
        }
    }
}
