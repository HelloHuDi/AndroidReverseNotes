package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cna */
public final class cna extends btd {
    public SKBuiltinBuffer_t vEF;
    public SKBuiltinBuffer_t vHJ;
    public String vHO;
    public SKBuiltinBuffer_t vHP;
    public bts vMa;
    public SKBuiltinBuffer_t vMb;
    public String wdB;
    public bts wtZ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60073);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(60073);
                throw c6092b;
            } else if (this.wtZ == null) {
                c6092b = new C6092b("Not all required fields were included: ImgSid");
                AppMethodBeat.m2505o(60073);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(60073);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.wtZ != null) {
                    c6093a.mo13479iy(2, this.wtZ.computeSize());
                    this.wtZ.writeFields(c6093a);
                }
                if (this.vEF != null) {
                    c6093a.mo13479iy(3, this.vEF.computeSize());
                    this.vEF.writeFields(c6093a);
                }
                if (this.wdB != null) {
                    c6093a.mo13475e(4, this.wdB);
                }
                if (this.vMa != null) {
                    c6093a.mo13479iy(5, this.vMa.computeSize());
                    this.vMa.writeFields(c6093a);
                }
                if (this.vHP != null) {
                    c6093a.mo13479iy(6, this.vHP.computeSize());
                    this.vHP.writeFields(c6093a);
                }
                if (this.vMb != null) {
                    c6093a.mo13479iy(7, this.vMb.computeSize());
                    this.vMb.writeFields(c6093a);
                }
                if (this.vHO != null) {
                    c6093a.mo13475e(8, this.vHO);
                }
                if (this.vHJ != null) {
                    c6093a.mo13479iy(9, this.vHJ.computeSize());
                    this.vHJ.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(60073);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wtZ != null) {
                ix += C6087a.m9557ix(2, this.wtZ.computeSize());
            }
            if (this.vEF != null) {
                ix += C6087a.m9557ix(3, this.vEF.computeSize());
            }
            if (this.wdB != null) {
                ix += C6091a.m9575f(4, this.wdB);
            }
            if (this.vMa != null) {
                ix += C6087a.m9557ix(5, this.vMa.computeSize());
            }
            if (this.vHP != null) {
                ix += C6087a.m9557ix(6, this.vHP.computeSize());
            }
            if (this.vMb != null) {
                ix += C6087a.m9557ix(7, this.vMb.computeSize());
            }
            if (this.vHO != null) {
                ix += C6091a.m9575f(8, this.vHO);
            }
            if (this.vHJ != null) {
                ix += C6087a.m9557ix(9, this.vHJ.computeSize());
            }
            AppMethodBeat.m2505o(60073);
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
                AppMethodBeat.m2505o(60073);
                throw c6092b;
            } else if (this.wtZ == null) {
                c6092b = new C6092b("Not all required fields were included: ImgSid");
                AppMethodBeat.m2505o(60073);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(60073);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(60073);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cna cna = (cna) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            bts bts;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        cna.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(60073);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cna.wtZ = bts;
                    }
                    AppMethodBeat.m2505o(60073);
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
                        cna.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(60073);
                    return 0;
                case 4:
                    cna.wdB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60073);
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
                        cna.vMa = bts;
                    }
                    AppMethodBeat.m2505o(60073);
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
                        cna.vHP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(60073);
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
                        cna.vMb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(60073);
                    return 0;
                case 8:
                    cna.vHO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60073);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cna.vHJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(60073);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60073);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60073);
            return -1;
        }
    }
}
