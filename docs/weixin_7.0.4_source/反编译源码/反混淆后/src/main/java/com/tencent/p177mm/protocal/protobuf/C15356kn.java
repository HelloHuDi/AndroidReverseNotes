package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.kn */
public final class C15356kn extends bsr {
    public String ProductID;
    public int Scene;
    public LinkedList<String> vNF = new LinkedList();
    public String vNG;
    public double vNH;
    public double vNI;

    public C15356kn() {
        AppMethodBeat.m2504i(11711);
        AppMethodBeat.m2505o(11711);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11712);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.ProductID != null) {
                c6093a.mo13475e(2, this.ProductID);
            }
            c6093a.mo13474e(3, 1, this.vNF);
            c6093a.mo13480iz(4, this.Scene);
            if (this.vNG != null) {
                c6093a.mo13475e(5, this.vNG);
            }
            c6093a.mo13476f(6, this.vNH);
            c6093a.mo13476f(7, this.vNI);
            AppMethodBeat.m2505o(11712);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ProductID != null) {
                ix += C6091a.m9575f(2, this.ProductID);
            }
            ix = (ix + C6087a.m9552c(3, 1, this.vNF)) + C6091a.m9572bs(4, this.Scene);
            if (this.vNG != null) {
                ix += C6091a.m9575f(5, this.vNG);
            }
            int fv = (ix + (C6091a.m9576fv(6) + 8)) + (C6091a.m9576fv(7) + 8);
            AppMethodBeat.m2505o(11712);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vNF.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11712);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15356kn c15356kn = (C15356kn) objArr[1];
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
                        c15356kn.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(11712);
                    return 0;
                case 2:
                    c15356kn.ProductID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11712);
                    return 0;
                case 3:
                    c15356kn.vNF.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(11712);
                    return 0;
                case 4:
                    c15356kn.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11712);
                    return 0;
                case 5:
                    c15356kn.vNG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11712);
                    return 0;
                case 6:
                    c15356kn.vNH = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(11712);
                    return 0;
                case 7:
                    c15356kn.vNI = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(11712);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11712);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11712);
            return -1;
        }
    }
}
