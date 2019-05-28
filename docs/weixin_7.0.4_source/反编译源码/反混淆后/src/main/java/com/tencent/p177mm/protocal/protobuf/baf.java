package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.baf */
public final class baf extends bsr {
    public String guQ;
    public String jBF;
    public String luP;
    public String luQ;
    public int nbj;
    public String nqc;
    public int vAM;
    public C7266hh vIg;
    public String vIh;
    public int vIi;
    public String vIj;
    public String vIk;
    public SKBuiltinBuffer_t vIl;
    public String vOA;
    public String vOz;
    public String wDX;
    public String wDY;
    public String wDZ;
    public int wEa;
    public String wdz;
    public String wlq;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58912);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vIg != null) {
                c6093a.mo13479iy(2, this.vIg.computeSize());
                this.vIg.writeFields(c6093a);
            }
            if (this.nqc != null) {
                c6093a.mo13475e(3, this.nqc);
            }
            if (this.vIh != null) {
                c6093a.mo13475e(4, this.vIh);
            }
            c6093a.mo13480iz(5, this.vIi);
            if (this.vIj != null) {
                c6093a.mo13475e(6, this.vIj);
            }
            if (this.guQ != null) {
                c6093a.mo13475e(7, this.guQ);
            }
            if (this.jBF != null) {
                c6093a.mo13475e(8, this.jBF);
            }
            if (this.vIk != null) {
                c6093a.mo13475e(9, this.vIk);
            }
            if (this.luQ != null) {
                c6093a.mo13475e(10, this.luQ);
            }
            if (this.luP != null) {
                c6093a.mo13475e(11, this.luP);
            }
            c6093a.mo13480iz(13, this.vAM);
            c6093a.mo13480iz(14, this.nbj);
            if (this.vOA != null) {
                c6093a.mo13475e(15, this.vOA);
            }
            if (this.vOz != null) {
                c6093a.mo13475e(16, this.vOz);
            }
            if (this.wDX != null) {
                c6093a.mo13475e(17, this.wDX);
            }
            if (this.wdz != null) {
                c6093a.mo13475e(18, this.wdz);
            }
            if (this.wlq != null) {
                c6093a.mo13475e(19, this.wlq);
            }
            if (this.wDY != null) {
                c6093a.mo13475e(20, this.wDY);
            }
            if (this.wDZ != null) {
                c6093a.mo13475e(21, this.wDZ);
            }
            c6093a.mo13480iz(22, this.wEa);
            if (this.vIl != null) {
                c6093a.mo13479iy(23, this.vIl.computeSize());
                this.vIl.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(58912);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vIg != null) {
                ix += C6087a.m9557ix(2, this.vIg.computeSize());
            }
            if (this.nqc != null) {
                ix += C6091a.m9575f(3, this.nqc);
            }
            if (this.vIh != null) {
                ix += C6091a.m9575f(4, this.vIh);
            }
            ix += C6091a.m9572bs(5, this.vIi);
            if (this.vIj != null) {
                ix += C6091a.m9575f(6, this.vIj);
            }
            if (this.guQ != null) {
                ix += C6091a.m9575f(7, this.guQ);
            }
            if (this.jBF != null) {
                ix += C6091a.m9575f(8, this.jBF);
            }
            if (this.vIk != null) {
                ix += C6091a.m9575f(9, this.vIk);
            }
            if (this.luQ != null) {
                ix += C6091a.m9575f(10, this.luQ);
            }
            if (this.luP != null) {
                ix += C6091a.m9575f(11, this.luP);
            }
            ix = (ix + C6091a.m9572bs(13, this.vAM)) + C6091a.m9572bs(14, this.nbj);
            if (this.vOA != null) {
                ix += C6091a.m9575f(15, this.vOA);
            }
            if (this.vOz != null) {
                ix += C6091a.m9575f(16, this.vOz);
            }
            if (this.wDX != null) {
                ix += C6091a.m9575f(17, this.wDX);
            }
            if (this.wdz != null) {
                ix += C6091a.m9575f(18, this.wdz);
            }
            if (this.wlq != null) {
                ix += C6091a.m9575f(19, this.wlq);
            }
            if (this.wDY != null) {
                ix += C6091a.m9575f(20, this.wDY);
            }
            if (this.wDZ != null) {
                ix += C6091a.m9575f(21, this.wDZ);
            }
            ix += C6091a.m9572bs(22, this.wEa);
            if (this.vIl != null) {
                ix += C6087a.m9557ix(23, this.vIl.computeSize());
            }
            AppMethodBeat.m2505o(58912);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(58912);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            baf baf = (baf) objArr[1];
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
                        baf.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7266hh c7266hh = new C7266hh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7266hh.populateBuilderWithField(c6086a3, c7266hh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        baf.vIg = c7266hh;
                    }
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 3:
                    baf.nqc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 4:
                    baf.vIh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 5:
                    baf.vIi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 6:
                    baf.vIj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 7:
                    baf.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 8:
                    baf.jBF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 9:
                    baf.vIk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 10:
                    baf.luQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 11:
                    baf.luP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 13:
                    baf.vAM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 14:
                    baf.nbj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 15:
                    baf.vOA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 16:
                    baf.vOz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 17:
                    baf.wDX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 18:
                    baf.wdz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 19:
                    baf.wlq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 20:
                    baf.wDY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 21:
                    baf.wDZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 22:
                    baf.wEa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58912);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        baf.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58912);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58912);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58912);
            return -1;
        }
    }
}
