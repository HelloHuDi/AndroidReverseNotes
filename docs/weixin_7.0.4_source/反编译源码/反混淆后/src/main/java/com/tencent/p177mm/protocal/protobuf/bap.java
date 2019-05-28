package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bap */
public final class bap extends bsr {
    public String ThumbUrl;
    public int nao;
    public String nbr;
    public int vRm;
    public int vRn;
    public String wEA;
    public String wEB;
    public String wEl;
    public String wEm;
    public String wEn;
    public int wEo;
    public SKBuiltinBuffer_t wEp;
    public int wEq;
    public int wEr;
    public int wEs;
    public int wEt;
    public SKBuiltinBuffer_t wEu;
    public int wEv;
    public int wEw;
    public int wEx;
    public int wEy;
    public int wEz;
    public int wqw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28548);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wEp == null) {
                c6092b = new C6092b("Not all required fields were included: DataBuffer");
                AppMethodBeat.m2505o(28548);
                throw c6092b;
            } else if (this.wEu == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbData");
                AppMethodBeat.m2505o(28548);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.wEl != null) {
                    c6093a.mo13475e(2, this.wEl);
                }
                if (this.wEm != null) {
                    c6093a.mo13475e(3, this.wEm);
                }
                if (this.wEn != null) {
                    c6093a.mo13475e(4, this.wEn);
                }
                c6093a.mo13480iz(5, this.nao);
                c6093a.mo13480iz(6, this.wEo);
                if (this.wEp != null) {
                    c6093a.mo13479iy(7, this.wEp.computeSize());
                    this.wEp.writeFields(c6093a);
                }
                c6093a.mo13480iz(8, this.wEq);
                c6093a.mo13480iz(9, this.wEr);
                c6093a.mo13480iz(10, this.wEs);
                c6093a.mo13480iz(11, this.wEt);
                if (this.wEu != null) {
                    c6093a.mo13479iy(12, this.wEu.computeSize());
                    this.wEu.writeFields(c6093a);
                }
                c6093a.mo13480iz(13, this.wEv);
                c6093a.mo13480iz(14, this.wEw);
                c6093a.mo13480iz(15, this.wEx);
                c6093a.mo13480iz(16, this.wEy);
                c6093a.mo13480iz(17, this.wqw);
                c6093a.mo13480iz(18, this.wEz);
                if (this.nbr != null) {
                    c6093a.mo13475e(19, this.nbr);
                }
                if (this.ThumbUrl != null) {
                    c6093a.mo13475e(20, this.ThumbUrl);
                }
                c6093a.mo13480iz(21, this.vRn);
                c6093a.mo13480iz(22, this.vRm);
                if (this.wEA != null) {
                    c6093a.mo13475e(23, this.wEA);
                }
                if (this.wEB != null) {
                    c6093a.mo13475e(24, this.wEB);
                }
                AppMethodBeat.m2505o(28548);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wEl != null) {
                ix += C6091a.m9575f(2, this.wEl);
            }
            if (this.wEm != null) {
                ix += C6091a.m9575f(3, this.wEm);
            }
            if (this.wEn != null) {
                ix += C6091a.m9575f(4, this.wEn);
            }
            ix = (ix + C6091a.m9572bs(5, this.nao)) + C6091a.m9572bs(6, this.wEo);
            if (this.wEp != null) {
                ix += C6087a.m9557ix(7, this.wEp.computeSize());
            }
            ix = (((ix + C6091a.m9572bs(8, this.wEq)) + C6091a.m9572bs(9, this.wEr)) + C6091a.m9572bs(10, this.wEs)) + C6091a.m9572bs(11, this.wEt);
            if (this.wEu != null) {
                ix += C6087a.m9557ix(12, this.wEu.computeSize());
            }
            ix = (((((ix + C6091a.m9572bs(13, this.wEv)) + C6091a.m9572bs(14, this.wEw)) + C6091a.m9572bs(15, this.wEx)) + C6091a.m9572bs(16, this.wEy)) + C6091a.m9572bs(17, this.wqw)) + C6091a.m9572bs(18, this.wEz);
            if (this.nbr != null) {
                ix += C6091a.m9575f(19, this.nbr);
            }
            if (this.ThumbUrl != null) {
                ix += C6091a.m9575f(20, this.ThumbUrl);
            }
            ix = (ix + C6091a.m9572bs(21, this.vRn)) + C6091a.m9572bs(22, this.vRm);
            if (this.wEA != null) {
                ix += C6091a.m9575f(23, this.wEA);
            }
            if (this.wEB != null) {
                ix += C6091a.m9575f(24, this.wEB);
            }
            AppMethodBeat.m2505o(28548);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wEp == null) {
                c6092b = new C6092b("Not all required fields were included: DataBuffer");
                AppMethodBeat.m2505o(28548);
                throw c6092b;
            } else if (this.wEu == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbData");
                AppMethodBeat.m2505o(28548);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28548);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bap bap = (bap) objArr[1];
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
                        bap.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 2:
                    bap.wEl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 3:
                    bap.wEm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 4:
                    bap.wEn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 5:
                    bap.nao = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 6:
                    bap.wEo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bap.wEp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 8:
                    bap.wEq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 9:
                    bap.wEr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 10:
                    bap.wEs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 11:
                    bap.wEt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bap.wEu = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 13:
                    bap.wEv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 14:
                    bap.wEw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 15:
                    bap.wEx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 16:
                    bap.wEy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 17:
                    bap.wqw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 18:
                    bap.wEz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 19:
                    bap.nbr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 20:
                    bap.ThumbUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 21:
                    bap.vRn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 22:
                    bap.vRm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 23:
                    bap.wEA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                case 24:
                    bap.wEB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28548);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28548);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28548);
            return -1;
        }
    }
}
