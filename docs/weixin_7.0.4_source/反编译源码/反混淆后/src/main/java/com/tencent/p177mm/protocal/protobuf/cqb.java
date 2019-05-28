package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cqb */
public final class cqb extends bsr {
    public double vNH;
    public double vNI;
    public int vZF;
    public int wem;
    public long wen;
    public LinkedList<ccw> wpo = new LinkedList();
    public long xod;
    public bts xoe;
    public bts xof;
    public int xog;

    public cqb() {
        AppMethodBeat.m2504i(5267);
        AppMethodBeat.m2505o(5267);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5268);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xoe == null) {
                c6092b = new C6092b("Not all required fields were included: NetName");
                AppMethodBeat.m2505o(5268);
                throw c6092b;
            } else if (this.xof == null) {
                c6092b = new C6092b("Not all required fields were included: WifiName");
                AppMethodBeat.m2505o(5268);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                c6093a.mo13472ai(2, this.xod);
                c6093a.mo13472ai(3, this.wen);
                c6093a.mo13480iz(4, this.vZF);
                if (this.xoe != null) {
                    c6093a.mo13479iy(5, this.xoe.computeSize());
                    this.xoe.writeFields(c6093a);
                }
                if (this.xof != null) {
                    c6093a.mo13479iy(6, this.xof.computeSize());
                    this.xof.writeFields(c6093a);
                }
                c6093a.mo13476f(7, this.vNH);
                c6093a.mo13476f(8, this.vNI);
                c6093a.mo13480iz(9, this.wem);
                c6093a.mo13480iz(10, this.xog);
                c6093a.mo13474e(11, 8, this.wpo);
                AppMethodBeat.m2505o(5268);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + C6091a.m9578o(2, this.xod)) + C6091a.m9578o(3, this.wen)) + C6091a.m9572bs(4, this.vZF);
            if (this.xoe != null) {
                ix += C6087a.m9557ix(5, this.xoe.computeSize());
            }
            if (this.xof != null) {
                ix += C6087a.m9557ix(6, this.xof.computeSize());
            }
            int fv = ((((ix + (C6091a.m9576fv(7) + 8)) + (C6091a.m9576fv(8) + 8)) + C6091a.m9572bs(9, this.wem)) + C6091a.m9572bs(10, this.xog)) + C6087a.m9552c(11, 8, this.wpo);
            AppMethodBeat.m2505o(5268);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpo.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xoe == null) {
                c6092b = new C6092b("Not all required fields were included: NetName");
                AppMethodBeat.m2505o(5268);
                throw c6092b;
            } else if (this.xof == null) {
                c6092b = new C6092b("Not all required fields were included: WifiName");
                AppMethodBeat.m2505o(5268);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(5268);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cqb cqb = (cqb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            bts bts;
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
                        cqb.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(5268);
                    return 0;
                case 2:
                    cqb.xod = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5268);
                    return 0;
                case 3:
                    cqb.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5268);
                    return 0;
                case 4:
                    cqb.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5268);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqb.xoe = bts;
                    }
                    AppMethodBeat.m2505o(5268);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqb.xof = bts;
                    }
                    AppMethodBeat.m2505o(5268);
                    return 0;
                case 7:
                    cqb.vNH = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(5268);
                    return 0;
                case 8:
                    cqb.vNI = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(5268);
                    return 0;
                case 9:
                    cqb.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5268);
                    return 0;
                case 10:
                    cqb.xog = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5268);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccw ccw = new ccw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccw.populateBuilderWithField(c6086a3, ccw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqb.wpo.add(ccw);
                    }
                    AppMethodBeat.m2505o(5268);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5268);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5268);
            return -1;
        }
    }
}
