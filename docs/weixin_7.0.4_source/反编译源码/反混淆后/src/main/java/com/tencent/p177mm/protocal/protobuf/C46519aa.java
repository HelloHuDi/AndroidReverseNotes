package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aa */
public final class C46519aa extends bsr {
    public int OpCode;
    public String SSID;
    public String URL;
    public String vAI;
    public String vAJ;
    public String vAK;
    public LinkedList<C7257dh> vAL = new LinkedList();
    public int vAM;
    public String vAN;
    public int vAO;
    public String vAP;

    public C46519aa() {
        AppMethodBeat.m2504i(28291);
        AppMethodBeat.m2505o(28291);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28292);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.URL != null) {
                c6093a.mo13475e(2, this.URL);
            }
            if (this.SSID != null) {
                c6093a.mo13475e(3, this.SSID);
            }
            if (this.vAI != null) {
                c6093a.mo13475e(4, this.vAI);
            }
            if (this.vAJ != null) {
                c6093a.mo13475e(5, this.vAJ);
            }
            if (this.vAK != null) {
                c6093a.mo13475e(6, this.vAK);
            }
            c6093a.mo13480iz(7, this.OpCode);
            c6093a.mo13474e(8, 8, this.vAL);
            c6093a.mo13480iz(9, this.vAM);
            if (this.vAN != null) {
                c6093a.mo13475e(10, this.vAN);
            }
            c6093a.mo13480iz(11, this.vAO);
            if (this.vAP != null) {
                c6093a.mo13475e(12, this.vAP);
            }
            AppMethodBeat.m2505o(28292);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.URL != null) {
                ix += C6091a.m9575f(2, this.URL);
            }
            if (this.SSID != null) {
                ix += C6091a.m9575f(3, this.SSID);
            }
            if (this.vAI != null) {
                ix += C6091a.m9575f(4, this.vAI);
            }
            if (this.vAJ != null) {
                ix += C6091a.m9575f(5, this.vAJ);
            }
            if (this.vAK != null) {
                ix += C6091a.m9575f(6, this.vAK);
            }
            ix = ((ix + C6091a.m9572bs(7, this.OpCode)) + C6087a.m9552c(8, 8, this.vAL)) + C6091a.m9572bs(9, this.vAM);
            if (this.vAN != null) {
                ix += C6091a.m9575f(10, this.vAN);
            }
            ix += C6091a.m9572bs(11, this.vAO);
            if (this.vAP != null) {
                ix += C6091a.m9575f(12, this.vAP);
            }
            AppMethodBeat.m2505o(28292);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vAL.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28292);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46519aa c46519aa = (C46519aa) objArr[1];
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
                        c46519aa.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 2:
                    c46519aa.URL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 3:
                    c46519aa.SSID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 4:
                    c46519aa.vAI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 5:
                    c46519aa.vAJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 6:
                    c46519aa.vAK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 7:
                    c46519aa.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7257dh c7257dh = new C7257dh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7257dh.populateBuilderWithField(c6086a3, c7257dh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46519aa.vAL.add(c7257dh);
                    }
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 9:
                    c46519aa.vAM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 10:
                    c46519aa.vAN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 11:
                    c46519aa.vAO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28292);
                    return 0;
                case 12:
                    c46519aa.vAP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28292);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28292);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28292);
            return -1;
        }
    }
}
