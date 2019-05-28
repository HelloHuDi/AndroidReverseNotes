package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cdj */
public final class cdj extends bsr {
    public String ndF;
    public String ndG;
    public String vFF;
    public int xcZ;
    public int xda;
    public LinkedList<cdl> xdb = new LinkedList();
    public cdi xdc;
    public int xdd;
    public LinkedList<cdi> xde = new LinkedList();

    public cdj() {
        AppMethodBeat.m2504i(80191);
        AppMethodBeat.m2505o(80191);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80192);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.xcZ);
            if (this.ndG != null) {
                c6093a.mo13475e(3, this.ndG);
            }
            if (this.ndF != null) {
                c6093a.mo13475e(4, this.ndF);
            }
            if (this.vFF != null) {
                c6093a.mo13475e(5, this.vFF);
            }
            c6093a.mo13480iz(6, this.xda);
            c6093a.mo13474e(7, 8, this.xdb);
            if (this.xdc != null) {
                c6093a.mo13479iy(8, this.xdc.computeSize());
                this.xdc.writeFields(c6093a);
            }
            c6093a.mo13480iz(9, this.xdd);
            c6093a.mo13474e(10, 8, this.xde);
            AppMethodBeat.m2505o(80192);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.xcZ);
            if (this.ndG != null) {
                ix += C6091a.m9575f(3, this.ndG);
            }
            if (this.ndF != null) {
                ix += C6091a.m9575f(4, this.ndF);
            }
            if (this.vFF != null) {
                ix += C6091a.m9575f(5, this.vFF);
            }
            ix = (ix + C6091a.m9572bs(6, this.xda)) + C6087a.m9552c(7, 8, this.xdb);
            if (this.xdc != null) {
                ix += C6087a.m9557ix(8, this.xdc.computeSize());
            }
            int bs = (ix + C6091a.m9572bs(9, this.xdd)) + C6087a.m9552c(10, 8, this.xde);
            AppMethodBeat.m2505o(80192);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xdb.clear();
            this.xde.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80192);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cdj cdj = (cdj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            cdi cdi;
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
                        cdj.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(80192);
                    return 0;
                case 2:
                    cdj.xcZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80192);
                    return 0;
                case 3:
                    cdj.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80192);
                    return 0;
                case 4:
                    cdj.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80192);
                    return 0;
                case 5:
                    cdj.vFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80192);
                    return 0;
                case 6:
                    cdj.xda = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80192);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdl cdl = new cdl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdl.populateBuilderWithField(c6086a3, cdl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdj.xdb.add(cdl);
                    }
                    AppMethodBeat.m2505o(80192);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdi = new cdi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdi.populateBuilderWithField(c6086a3, cdi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdj.xdc = cdi;
                    }
                    AppMethodBeat.m2505o(80192);
                    return 0;
                case 9:
                    cdj.xdd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80192);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdi = new cdi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdi.populateBuilderWithField(c6086a3, cdi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdj.xde.add(cdi);
                    }
                    AppMethodBeat.m2505o(80192);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80192);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80192);
            return -1;
        }
    }
}
