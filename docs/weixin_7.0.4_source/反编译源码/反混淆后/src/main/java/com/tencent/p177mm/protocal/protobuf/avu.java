package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.avu */
public final class avu extends bsr {
    public String fKh;
    public LinkedList<String> wzD = new LinkedList();
    public int wzE;
    public int wzF;
    public cxh wzG;

    public avu() {
        AppMethodBeat.m2504i(96252);
        AppMethodBeat.m2505o(96252);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96253);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(2, this.fKh);
            }
            c6093a.mo13474e(3, 1, this.wzD);
            c6093a.mo13480iz(4, this.wzE);
            c6093a.mo13480iz(5, this.wzF);
            if (this.wzG != null) {
                c6093a.mo13479iy(6, this.wzG.computeSize());
                this.wzG.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(96253);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += C6091a.m9575f(2, this.fKh);
            }
            ix = ((ix + C6087a.m9552c(3, 1, this.wzD)) + C6091a.m9572bs(4, this.wzE)) + C6091a.m9572bs(5, this.wzF);
            if (this.wzG != null) {
                ix += C6087a.m9557ix(6, this.wzG.computeSize());
            }
            AppMethodBeat.m2505o(96253);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzD.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96253);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            avu avu = (avu) objArr[1];
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
                        avu.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(96253);
                    return 0;
                case 2:
                    avu.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96253);
                    return 0;
                case 3:
                    avu.wzD.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(96253);
                    return 0;
                case 4:
                    avu.wzE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96253);
                    return 0;
                case 5:
                    avu.wzF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96253);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxh cxh = new cxh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxh.populateBuilderWithField(c6086a3, cxh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        avu.wzG = cxh;
                    }
                    AppMethodBeat.m2505o(96253);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96253);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96253);
            return -1;
        }
    }
}
