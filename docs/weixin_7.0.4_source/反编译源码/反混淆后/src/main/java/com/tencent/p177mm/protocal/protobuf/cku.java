package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cku */
public final class cku extends bsr {
    public int bIb;
    public String ceI;
    public String cws;
    public String fhH;
    public String wWc;
    public int xiA;
    public int xiB;
    public int xiu;
    public int xiv;
    public String xiw;
    public int xix;
    public String xiy;
    public LinkedList<ccz> xiz = new LinkedList();

    public cku() {
        AppMethodBeat.m2504i(55725);
        AppMethodBeat.m2505o(55725);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55726);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.ceI != null) {
                c6093a.mo13475e(2, this.ceI);
            }
            if (this.cws != null) {
                c6093a.mo13475e(3, this.cws);
            }
            c6093a.mo13480iz(4, this.xiu);
            c6093a.mo13480iz(5, this.xiv);
            c6093a.mo13480iz(6, this.bIb);
            if (this.xiw != null) {
                c6093a.mo13475e(7, this.xiw);
            }
            if (this.wWc != null) {
                c6093a.mo13475e(8, this.wWc);
            }
            if (this.fhH != null) {
                c6093a.mo13475e(9, this.fhH);
            }
            c6093a.mo13480iz(10, this.xix);
            if (this.xiy != null) {
                c6093a.mo13475e(11, this.xiy);
            }
            c6093a.mo13474e(12, 8, this.xiz);
            c6093a.mo13480iz(13, this.xiA);
            c6093a.mo13480iz(14, this.xiB);
            AppMethodBeat.m2505o(55726);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ceI != null) {
                ix += C6091a.m9575f(2, this.ceI);
            }
            if (this.cws != null) {
                ix += C6091a.m9575f(3, this.cws);
            }
            ix = ((ix + C6091a.m9572bs(4, this.xiu)) + C6091a.m9572bs(5, this.xiv)) + C6091a.m9572bs(6, this.bIb);
            if (this.xiw != null) {
                ix += C6091a.m9575f(7, this.xiw);
            }
            if (this.wWc != null) {
                ix += C6091a.m9575f(8, this.wWc);
            }
            if (this.fhH != null) {
                ix += C6091a.m9575f(9, this.fhH);
            }
            ix += C6091a.m9572bs(10, this.xix);
            if (this.xiy != null) {
                ix += C6091a.m9575f(11, this.xiy);
            }
            int c = ((ix + C6087a.m9552c(12, 8, this.xiz)) + C6091a.m9572bs(13, this.xiA)) + C6091a.m9572bs(14, this.xiB);
            AppMethodBeat.m2505o(55726);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xiz.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55726);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cku cku = (cku) objArr[1];
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
                        cku.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 2:
                    cku.ceI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 3:
                    cku.cws = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 4:
                    cku.xiu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 5:
                    cku.xiv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 6:
                    cku.bIb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 7:
                    cku.xiw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 8:
                    cku.wWc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 9:
                    cku.fhH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 10:
                    cku.xix = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 11:
                    cku.xiy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccz ccz = new ccz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccz.populateBuilderWithField(c6086a3, ccz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cku.xiz.add(ccz);
                    }
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 13:
                    cku.xiA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                case 14:
                    cku.xiB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55726);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55726);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55726);
            return -1;
        }
    }
}
