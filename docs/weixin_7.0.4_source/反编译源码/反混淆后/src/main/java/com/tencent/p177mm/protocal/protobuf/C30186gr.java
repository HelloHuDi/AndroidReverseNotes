package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gr */
public final class C30186gr extends bsr {
    public int Scene;
    public long jBP;
    public int vIN;
    public LinkedList<C7284ua> vIO = new LinkedList();
    public String vIP;
    public String vIQ;
    public String vIR;

    public C30186gr() {
        AppMethodBeat.m2504i(28329);
        AppMethodBeat.m2505o(28329);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28330);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vIN);
            c6093a.mo13474e(3, 8, this.vIO);
            if (this.vIP != null) {
                c6093a.mo13475e(4, this.vIP);
            }
            if (this.vIQ != null) {
                c6093a.mo13475e(5, this.vIQ);
            }
            c6093a.mo13480iz(6, this.Scene);
            c6093a.mo13472ai(7, this.jBP);
            if (this.vIR != null) {
                c6093a.mo13475e(8, this.vIR);
            }
            AppMethodBeat.m2505o(28330);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.vIN)) + C6087a.m9552c(3, 8, this.vIO);
            if (this.vIP != null) {
                ix += C6091a.m9575f(4, this.vIP);
            }
            if (this.vIQ != null) {
                ix += C6091a.m9575f(5, this.vIQ);
            }
            ix = (ix + C6091a.m9572bs(6, this.Scene)) + C6091a.m9578o(7, this.jBP);
            if (this.vIR != null) {
                ix += C6091a.m9575f(8, this.vIR);
            }
            AppMethodBeat.m2505o(28330);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIO.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28330);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30186gr c30186gr = (C30186gr) objArr[1];
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
                        c30186gr.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28330);
                    return 0;
                case 2:
                    c30186gr.vIN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28330);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7284ua c7284ua = new C7284ua();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7284ua.populateBuilderWithField(c6086a3, c7284ua, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30186gr.vIO.add(c7284ua);
                    }
                    AppMethodBeat.m2505o(28330);
                    return 0;
                case 4:
                    c30186gr.vIP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28330);
                    return 0;
                case 5:
                    c30186gr.vIQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28330);
                    return 0;
                case 6:
                    c30186gr.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28330);
                    return 0;
                case 7:
                    c30186gr.jBP = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28330);
                    return 0;
                case 8:
                    c30186gr.vIR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28330);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28330);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28330);
            return -1;
        }
    }
}
