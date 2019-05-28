package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.agc */
public final class agc extends btd {
    public C7273mw vMl;
    public C7273mw vMm;
    public C7273mw vMn;
    public SKBuiltinBuffer_t vMo;
    public SKBuiltinBuffer_t vMp;
    public C7273mw vMq;
    public int vMr;
    public C23417mv vMs;
    public C23417mv vMt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80070);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(80070);
                throw c6092b;
            } else if (this.vMl == null) {
                c6092b = new C6092b("Not all required fields were included: DnsInfo");
                AppMethodBeat.m2505o(80070);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.vMl != null) {
                    c6093a.mo13479iy(2, this.vMl.computeSize());
                    this.vMl.writeFields(c6093a);
                }
                if (this.vMm != null) {
                    c6093a.mo13479iy(3, this.vMm.computeSize());
                    this.vMm.writeFields(c6093a);
                }
                if (this.vMn != null) {
                    c6093a.mo13479iy(4, this.vMn.computeSize());
                    this.vMn.writeFields(c6093a);
                }
                if (this.vMo != null) {
                    c6093a.mo13479iy(5, this.vMo.computeSize());
                    this.vMo.writeFields(c6093a);
                }
                if (this.vMp != null) {
                    c6093a.mo13479iy(6, this.vMp.computeSize());
                    this.vMp.writeFields(c6093a);
                }
                if (this.vMq != null) {
                    c6093a.mo13479iy(7, this.vMq.computeSize());
                    this.vMq.writeFields(c6093a);
                }
                c6093a.mo13480iz(8, this.vMr);
                if (this.vMs != null) {
                    c6093a.mo13479iy(9, this.vMs.computeSize());
                    this.vMs.writeFields(c6093a);
                }
                if (this.vMt != null) {
                    c6093a.mo13479iy(10, this.vMt.computeSize());
                    this.vMt.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(80070);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vMl != null) {
                ix += C6087a.m9557ix(2, this.vMl.computeSize());
            }
            if (this.vMm != null) {
                ix += C6087a.m9557ix(3, this.vMm.computeSize());
            }
            if (this.vMn != null) {
                ix += C6087a.m9557ix(4, this.vMn.computeSize());
            }
            if (this.vMo != null) {
                ix += C6087a.m9557ix(5, this.vMo.computeSize());
            }
            if (this.vMp != null) {
                ix += C6087a.m9557ix(6, this.vMp.computeSize());
            }
            if (this.vMq != null) {
                ix += C6087a.m9557ix(7, this.vMq.computeSize());
            }
            ix += C6091a.m9572bs(8, this.vMr);
            if (this.vMs != null) {
                ix += C6087a.m9557ix(9, this.vMs.computeSize());
            }
            if (this.vMt != null) {
                ix += C6087a.m9557ix(10, this.vMt.computeSize());
            }
            AppMethodBeat.m2505o(80070);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(80070);
                throw c6092b;
            } else if (this.vMl == null) {
                c6092b = new C6092b("Not all required fields were included: DnsInfo");
                AppMethodBeat.m2505o(80070);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(80070);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            agc agc = (agc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            C7273mw c7273mw;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C23417mv c23417mv;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(80070);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7273mw = new C7273mw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7273mw.populateBuilderWithField(c6086a3, c7273mw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agc.vMl = c7273mw;
                    }
                    AppMethodBeat.m2505o(80070);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7273mw = new C7273mw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7273mw.populateBuilderWithField(c6086a3, c7273mw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agc.vMm = c7273mw;
                    }
                    AppMethodBeat.m2505o(80070);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7273mw = new C7273mw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7273mw.populateBuilderWithField(c6086a3, c7273mw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agc.vMn = c7273mw;
                    }
                    AppMethodBeat.m2505o(80070);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agc.vMo = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80070);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agc.vMp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80070);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7273mw = new C7273mw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7273mw.populateBuilderWithField(c6086a3, c7273mw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agc.vMq = c7273mw;
                    }
                    AppMethodBeat.m2505o(80070);
                    return 0;
                case 8:
                    agc.vMr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80070);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23417mv = new C23417mv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23417mv.populateBuilderWithField(c6086a3, c23417mv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agc.vMs = c23417mv;
                    }
                    AppMethodBeat.m2505o(80070);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23417mv = new C23417mv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23417mv.populateBuilderWithField(c6086a3, c23417mv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agc.vMt = c23417mv;
                    }
                    AppMethodBeat.m2505o(80070);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80070);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80070);
            return -1;
        }
    }
}
