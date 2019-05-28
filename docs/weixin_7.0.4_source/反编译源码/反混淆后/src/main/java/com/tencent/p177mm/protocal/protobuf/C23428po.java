package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.po */
public final class C23428po extends bsr {
    public int cIb;
    public int nUf;
    public String pPT;
    public String vWG;
    public String vWJ;
    public String vWK;
    public int vWL;
    public String vWM;
    public String vWN;
    public String vWO;
    public String vWP;
    public int vWQ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48799);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vWJ == null) {
                c6092b = new C6092b("Not all required fields were included: receiver_name");
                AppMethodBeat.m2505o(48799);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vWJ != null) {
                c6093a.mo13475e(2, this.vWJ);
            }
            c6093a.mo13480iz(3, this.nUf);
            if (this.vWK != null) {
                c6093a.mo13475e(4, this.vWK);
            }
            if (this.pPT != null) {
                c6093a.mo13475e(5, this.pPT);
            }
            c6093a.mo13480iz(6, this.vWL);
            c6093a.mo13480iz(7, this.cIb);
            if (this.vWM != null) {
                c6093a.mo13475e(8, this.vWM);
            }
            if (this.vWG != null) {
                c6093a.mo13475e(9, this.vWG);
            }
            if (this.vWN != null) {
                c6093a.mo13475e(10, this.vWN);
            }
            if (this.vWO != null) {
                c6093a.mo13475e(11, this.vWO);
            }
            if (this.vWP != null) {
                c6093a.mo13475e(12, this.vWP);
            }
            c6093a.mo13480iz(13, this.vWQ);
            AppMethodBeat.m2505o(48799);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vWJ != null) {
                ix += C6091a.m9575f(2, this.vWJ);
            }
            ix += C6091a.m9572bs(3, this.nUf);
            if (this.vWK != null) {
                ix += C6091a.m9575f(4, this.vWK);
            }
            if (this.pPT != null) {
                ix += C6091a.m9575f(5, this.pPT);
            }
            ix = (ix + C6091a.m9572bs(6, this.vWL)) + C6091a.m9572bs(7, this.cIb);
            if (this.vWM != null) {
                ix += C6091a.m9575f(8, this.vWM);
            }
            if (this.vWG != null) {
                ix += C6091a.m9575f(9, this.vWG);
            }
            if (this.vWN != null) {
                ix += C6091a.m9575f(10, this.vWN);
            }
            if (this.vWO != null) {
                ix += C6091a.m9575f(11, this.vWO);
            }
            if (this.vWP != null) {
                ix += C6091a.m9575f(12, this.vWP);
            }
            int bs = ix + C6091a.m9572bs(13, this.vWQ);
            AppMethodBeat.m2505o(48799);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vWJ == null) {
                c6092b = new C6092b("Not all required fields were included: receiver_name");
                AppMethodBeat.m2505o(48799);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48799);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23428po c23428po = (C23428po) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23428po.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 2:
                    c23428po.vWJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 3:
                    c23428po.nUf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 4:
                    c23428po.vWK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 5:
                    c23428po.pPT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 6:
                    c23428po.vWL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 7:
                    c23428po.cIb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 8:
                    c23428po.vWM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 9:
                    c23428po.vWG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 10:
                    c23428po.vWN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 11:
                    c23428po.vWO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 12:
                    c23428po.vWP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                case 13:
                    c23428po.vWQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48799);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48799);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48799);
            return -1;
        }
    }
}
