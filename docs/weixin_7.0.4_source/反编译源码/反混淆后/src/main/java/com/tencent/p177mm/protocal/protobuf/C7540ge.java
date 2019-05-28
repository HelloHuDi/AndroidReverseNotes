package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ge */
public final class C7540ge extends bsr {
    public String guQ;
    public String jBF;
    public String luP;
    public String luQ;
    public String nqc;
    public int vAM;
    public SKBuiltinBuffer_t vHH;
    public C7266hh vIg;
    public String vIh;
    public int vIi;
    public String vIj;
    public String vIk;
    public SKBuiltinBuffer_t vIl;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58887);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vHH == null) {
                c6092b = new C6092b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.m2505o(58887);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vIg != null) {
                c6093a.mo13479iy(2, this.vIg.computeSize());
                this.vIg.writeFields(c6093a);
            }
            if (this.vHH != null) {
                c6093a.mo13479iy(3, this.vHH.computeSize());
                this.vHH.writeFields(c6093a);
            }
            if (this.nqc != null) {
                c6093a.mo13475e(4, this.nqc);
            }
            if (this.vIh != null) {
                c6093a.mo13475e(5, this.vIh);
            }
            c6093a.mo13480iz(6, this.vIi);
            if (this.vIj != null) {
                c6093a.mo13475e(7, this.vIj);
            }
            if (this.guQ != null) {
                c6093a.mo13475e(8, this.guQ);
            }
            if (this.jBF != null) {
                c6093a.mo13475e(9, this.jBF);
            }
            if (this.vIk != null) {
                c6093a.mo13475e(10, this.vIk);
            }
            if (this.luQ != null) {
                c6093a.mo13475e(11, this.luQ);
            }
            if (this.luP != null) {
                c6093a.mo13475e(12, this.luP);
            }
            c6093a.mo13480iz(13, this.vAM);
            if (this.vIl != null) {
                c6093a.mo13479iy(14, this.vIl.computeSize());
                this.vIl.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(58887);
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
            if (this.vHH != null) {
                ix += C6087a.m9557ix(3, this.vHH.computeSize());
            }
            if (this.nqc != null) {
                ix += C6091a.m9575f(4, this.nqc);
            }
            if (this.vIh != null) {
                ix += C6091a.m9575f(5, this.vIh);
            }
            ix += C6091a.m9572bs(6, this.vIi);
            if (this.vIj != null) {
                ix += C6091a.m9575f(7, this.vIj);
            }
            if (this.guQ != null) {
                ix += C6091a.m9575f(8, this.guQ);
            }
            if (this.jBF != null) {
                ix += C6091a.m9575f(9, this.jBF);
            }
            if (this.vIk != null) {
                ix += C6091a.m9575f(10, this.vIk);
            }
            if (this.luQ != null) {
                ix += C6091a.m9575f(11, this.luQ);
            }
            if (this.luP != null) {
                ix += C6091a.m9575f(12, this.luP);
            }
            ix += C6091a.m9572bs(13, this.vAM);
            if (this.vIl != null) {
                ix += C6087a.m9557ix(14, this.vIl.computeSize());
            }
            AppMethodBeat.m2505o(58887);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vHH == null) {
                c6092b = new C6092b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.m2505o(58887);
                throw c6092b;
            }
            AppMethodBeat.m2505o(58887);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7540ge c7540ge = (C7540ge) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        c7540ge.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(58887);
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
                        c7540ge.vIg = c7266hh;
                    }
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7540ge.vHH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 4:
                    c7540ge.nqc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 5:
                    c7540ge.vIh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 6:
                    c7540ge.vIi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 7:
                    c7540ge.vIj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 8:
                    c7540ge.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 9:
                    c7540ge.jBF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 10:
                    c7540ge.vIk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 11:
                    c7540ge.luQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 12:
                    c7540ge.luP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 13:
                    c7540ge.vAM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58887);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7540ge.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58887);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58887);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58887);
            return -1;
        }
    }
}
