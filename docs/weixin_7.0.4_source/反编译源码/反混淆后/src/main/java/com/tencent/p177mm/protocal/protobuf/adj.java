package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.adj */
public final class adj extends bsr {
    public int Scene;
    public String fKh;
    public String ndT;
    public int vAM;
    public String vLo;
    public C15319aw vRP;
    public String vXP;
    public String vYO;
    public String vYP;
    public String vYQ;
    public String vYR;
    public String wla;
    public String wld;
    public String wle;
    public int wlf;
    public String wlg;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56800);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(2, this.fKh);
            }
            if (this.vYO != null) {
                c6093a.mo13475e(3, this.vYO);
            }
            if (this.vLo != null) {
                c6093a.mo13475e(4, this.vLo);
            }
            if (this.vYP != null) {
                c6093a.mo13475e(5, this.vYP);
            }
            if (this.vYQ != null) {
                c6093a.mo13475e(6, this.vYQ);
            }
            if (this.vYR != null) {
                c6093a.mo13475e(7, this.vYR);
            }
            if (this.vXP != null) {
                c6093a.mo13475e(8, this.vXP);
            }
            if (this.wla != null) {
                c6093a.mo13475e(9, this.wla);
            }
            c6093a.mo13480iz(10, this.vAM);
            if (this.ndT != null) {
                c6093a.mo13475e(11, this.ndT);
            }
            if (this.wld != null) {
                c6093a.mo13475e(12, this.wld);
            }
            if (this.wle != null) {
                c6093a.mo13475e(13, this.wle);
            }
            if (this.vRP != null) {
                c6093a.mo13479iy(14, this.vRP.computeSize());
                this.vRP.writeFields(c6093a);
            }
            c6093a.mo13480iz(15, this.Scene);
            c6093a.mo13480iz(16, this.wlf);
            if (this.wlg != null) {
                c6093a.mo13475e(17, this.wlg);
            }
            AppMethodBeat.m2505o(56800);
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
            if (this.vYO != null) {
                ix += C6091a.m9575f(3, this.vYO);
            }
            if (this.vLo != null) {
                ix += C6091a.m9575f(4, this.vLo);
            }
            if (this.vYP != null) {
                ix += C6091a.m9575f(5, this.vYP);
            }
            if (this.vYQ != null) {
                ix += C6091a.m9575f(6, this.vYQ);
            }
            if (this.vYR != null) {
                ix += C6091a.m9575f(7, this.vYR);
            }
            if (this.vXP != null) {
                ix += C6091a.m9575f(8, this.vXP);
            }
            if (this.wla != null) {
                ix += C6091a.m9575f(9, this.wla);
            }
            ix += C6091a.m9572bs(10, this.vAM);
            if (this.ndT != null) {
                ix += C6091a.m9575f(11, this.ndT);
            }
            if (this.wld != null) {
                ix += C6091a.m9575f(12, this.wld);
            }
            if (this.wle != null) {
                ix += C6091a.m9575f(13, this.wle);
            }
            if (this.vRP != null) {
                ix += C6087a.m9557ix(14, this.vRP.computeSize());
            }
            ix = (ix + C6091a.m9572bs(15, this.Scene)) + C6091a.m9572bs(16, this.wlf);
            if (this.wlg != null) {
                ix += C6091a.m9575f(17, this.wlg);
            }
            AppMethodBeat.m2505o(56800);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56800);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            adj adj = (adj) objArr[1];
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
                        adj.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 2:
                    adj.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 3:
                    adj.vYO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 4:
                    adj.vLo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 5:
                    adj.vYP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 6:
                    adj.vYQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 7:
                    adj.vYR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 8:
                    adj.vXP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 9:
                    adj.wla = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 10:
                    adj.vAM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 11:
                    adj.ndT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 12:
                    adj.wld = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 13:
                    adj.wle = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15319aw c15319aw = new C15319aw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15319aw.populateBuilderWithField(c6086a3, c15319aw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adj.vRP = c15319aw;
                    }
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 15:
                    adj.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 16:
                    adj.wlf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                case 17:
                    adj.wlg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56800);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56800);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56800);
            return -1;
        }
    }
}
