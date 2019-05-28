package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.agl */
public final class agl extends bsr {
    public String cMC;
    public String cMD;
    public int cME;
    public String kde;
    public String vBu;
    public String vBv;
    public int vBw;
    public cdc vBy;
    public String wni;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89077);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cMC == null) {
                c6092b = new C6092b("Not all required fields were included: card_id");
                AppMethodBeat.m2505o(89077);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.cMC != null) {
                c6093a.mo13475e(2, this.cMC);
            }
            c6093a.mo13480iz(3, this.cME);
            if (this.kde != null) {
                c6093a.mo13475e(4, this.kde);
            }
            if (this.cMD != null) {
                c6093a.mo13475e(5, this.cMD);
            }
            if (this.vBu != null) {
                c6093a.mo13475e(6, this.vBu);
            }
            if (this.vBv != null) {
                c6093a.mo13475e(7, this.vBv);
            }
            c6093a.mo13480iz(8, this.vBw);
            if (this.wni != null) {
                c6093a.mo13475e(9, this.wni);
            }
            if (this.vBy != null) {
                c6093a.mo13479iy(10, this.vBy.computeSize());
                this.vBy.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(89077);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.cMC != null) {
                ix += C6091a.m9575f(2, this.cMC);
            }
            ix += C6091a.m9572bs(3, this.cME);
            if (this.kde != null) {
                ix += C6091a.m9575f(4, this.kde);
            }
            if (this.cMD != null) {
                ix += C6091a.m9575f(5, this.cMD);
            }
            if (this.vBu != null) {
                ix += C6091a.m9575f(6, this.vBu);
            }
            if (this.vBv != null) {
                ix += C6091a.m9575f(7, this.vBv);
            }
            ix += C6091a.m9572bs(8, this.vBw);
            if (this.wni != null) {
                ix += C6091a.m9575f(9, this.wni);
            }
            if (this.vBy != null) {
                ix += C6087a.m9557ix(10, this.vBy.computeSize());
            }
            AppMethodBeat.m2505o(89077);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.cMC == null) {
                c6092b = new C6092b("Not all required fields were included: card_id");
                AppMethodBeat.m2505o(89077);
                throw c6092b;
            }
            AppMethodBeat.m2505o(89077);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            agl agl = (agl) objArr[1];
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
                        agl.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(89077);
                    return 0;
                case 2:
                    agl.cMC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89077);
                    return 0;
                case 3:
                    agl.cME = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89077);
                    return 0;
                case 4:
                    agl.kde = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89077);
                    return 0;
                case 5:
                    agl.cMD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89077);
                    return 0;
                case 6:
                    agl.vBu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89077);
                    return 0;
                case 7:
                    agl.vBv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89077);
                    return 0;
                case 8:
                    agl.vBw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89077);
                    return 0;
                case 9:
                    agl.wni = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89077);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdc cdc = new cdc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdc.populateBuilderWithField(c6086a3, cdc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agl.vBy = cdc;
                    }
                    AppMethodBeat.m2505o(89077);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89077);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89077);
            return -1;
        }
    }
}
