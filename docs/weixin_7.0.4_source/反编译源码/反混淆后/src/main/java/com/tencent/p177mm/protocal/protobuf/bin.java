package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bin */
public final class bin extends bsr {
    public String fKh;
    public String mZu;
    public String ncH;
    public C15319aw vRP;
    public String vYO;
    public String vYP;
    public String vYQ;
    public String vYR;
    public String wLU;
    public String wLV;
    public String wLW;
    public String wLX;
    public String wLY;
    public String wlb;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56876);
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
            if (this.wLU != null) {
                c6093a.mo13475e(3, this.wLU);
            }
            if (this.wlb != null) {
                c6093a.mo13475e(4, this.wlb);
            }
            if (this.vYO != null) {
                c6093a.mo13475e(5, this.vYO);
            }
            if (this.wLV != null) {
                c6093a.mo13475e(6, this.wLV);
            }
            if (this.vYP != null) {
                c6093a.mo13475e(7, this.vYP);
            }
            if (this.vYQ != null) {
                c6093a.mo13475e(8, this.vYQ);
            }
            if (this.vYR != null) {
                c6093a.mo13475e(9, this.vYR);
            }
            if (this.wLW != null) {
                c6093a.mo13475e(10, this.wLW);
            }
            if (this.vRP != null) {
                c6093a.mo13479iy(11, this.vRP.computeSize());
                this.vRP.writeFields(c6093a);
            }
            if (this.wLX != null) {
                c6093a.mo13475e(12, this.wLX);
            }
            if (this.mZu != null) {
                c6093a.mo13475e(13, this.mZu);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(14, this.ncH);
            }
            if (this.wLY != null) {
                c6093a.mo13475e(15, this.wLY);
            }
            AppMethodBeat.m2505o(56876);
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
            if (this.wLU != null) {
                ix += C6091a.m9575f(3, this.wLU);
            }
            if (this.wlb != null) {
                ix += C6091a.m9575f(4, this.wlb);
            }
            if (this.vYO != null) {
                ix += C6091a.m9575f(5, this.vYO);
            }
            if (this.wLV != null) {
                ix += C6091a.m9575f(6, this.wLV);
            }
            if (this.vYP != null) {
                ix += C6091a.m9575f(7, this.vYP);
            }
            if (this.vYQ != null) {
                ix += C6091a.m9575f(8, this.vYQ);
            }
            if (this.vYR != null) {
                ix += C6091a.m9575f(9, this.vYR);
            }
            if (this.wLW != null) {
                ix += C6091a.m9575f(10, this.wLW);
            }
            if (this.vRP != null) {
                ix += C6087a.m9557ix(11, this.vRP.computeSize());
            }
            if (this.wLX != null) {
                ix += C6091a.m9575f(12, this.wLX);
            }
            if (this.mZu != null) {
                ix += C6091a.m9575f(13, this.mZu);
            }
            if (this.ncH != null) {
                ix += C6091a.m9575f(14, this.ncH);
            }
            if (this.wLY != null) {
                ix += C6091a.m9575f(15, this.wLY);
            }
            AppMethodBeat.m2505o(56876);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56876);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bin bin = (bin) objArr[1];
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
                        bin.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 2:
                    bin.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 3:
                    bin.wLU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 4:
                    bin.wlb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 5:
                    bin.vYO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 6:
                    bin.wLV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 7:
                    bin.vYP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 8:
                    bin.vYQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 9:
                    bin.vYR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 10:
                    bin.wLW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15319aw c15319aw = new C15319aw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15319aw.populateBuilderWithField(c6086a3, c15319aw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bin.vRP = c15319aw;
                    }
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 12:
                    bin.wLX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 13:
                    bin.mZu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 14:
                    bin.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                case 15:
                    bin.wLY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56876);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56876);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56876);
            return -1;
        }
    }
}
