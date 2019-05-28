package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.fw */
public final class C7538fw extends bsr {
    public String csB;
    public LinkedList<String> vIa = new LinkedList();
    public boolean vIb;
    public int vIc;

    public C7538fw() {
        AppMethodBeat.m2504i(102370);
        AppMethodBeat.m2505o(102370);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102371);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.csB != null) {
                c6093a.mo13475e(2, this.csB);
            }
            c6093a.mo13474e(3, 1, this.vIa);
            c6093a.mo13471aO(4, this.vIb);
            c6093a.mo13480iz(5, this.vIc);
            AppMethodBeat.m2505o(102371);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.csB != null) {
                ix += C6091a.m9575f(2, this.csB);
            }
            int c = ((ix + C6087a.m9552c(3, 1, this.vIa)) + (C6091a.m9576fv(4) + 1)) + C6091a.m9572bs(5, this.vIc);
            AppMethodBeat.m2505o(102371);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIa.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102371);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7538fw c7538fw = (C7538fw) objArr[1];
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
                        c7538fw.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(102371);
                    return 0;
                case 2:
                    c7538fw.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102371);
                    return 0;
                case 3:
                    c7538fw.vIa.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(102371);
                    return 0;
                case 4:
                    c7538fw.vIb = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(102371);
                    return 0;
                case 5:
                    c7538fw.vIc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102371);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102371);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102371);
            return -1;
        }
    }
}
