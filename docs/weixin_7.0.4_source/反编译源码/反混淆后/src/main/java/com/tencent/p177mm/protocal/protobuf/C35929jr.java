package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.jr */
public final class C35929jr extends btd {
    public int jBT;
    public int vCl;
    public int vCo;
    public SKBuiltinBuffer_t vEF;
    public SKBuiltinBuffer_t vHJ;
    public SKBuiltinBuffer_t vHP;
    public btv vLP;
    public String vLX;
    public bts vMa;
    public SKBuiltinBuffer_t vMb;
    public int vMd;
    public String vMe;
    public String vMf;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73696);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(73696);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(73696);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.vLX != null) {
                    c6093a.mo13475e(2, this.vLX);
                }
                if (this.vEF != null) {
                    c6093a.mo13479iy(3, this.vEF.computeSize());
                    this.vEF.writeFields(c6093a);
                }
                c6093a.mo13480iz(4, this.vCo);
                c6093a.mo13480iz(5, this.vMd);
                if (this.vMe != null) {
                    c6093a.mo13475e(6, this.vMe);
                }
                c6093a.mo13480iz(7, this.jBT);
                if (this.vMf != null) {
                    c6093a.mo13475e(8, this.vMf);
                }
                if (this.vMa != null) {
                    c6093a.mo13479iy(9, this.vMa.computeSize());
                    this.vMa.writeFields(c6093a);
                }
                if (this.vHP != null) {
                    c6093a.mo13479iy(10, this.vHP.computeSize());
                    this.vHP.writeFields(c6093a);
                }
                if (this.vMb != null) {
                    c6093a.mo13479iy(11, this.vMb.computeSize());
                    this.vMb.writeFields(c6093a);
                }
                if (this.vLP != null) {
                    c6093a.mo13479iy(12, this.vLP.computeSize());
                    this.vLP.writeFields(c6093a);
                }
                c6093a.mo13480iz(13, this.vCl);
                if (this.vHJ != null) {
                    c6093a.mo13479iy(14, this.vHJ.computeSize());
                    this.vHJ.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(73696);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vLX != null) {
                ix += C6091a.m9575f(2, this.vLX);
            }
            if (this.vEF != null) {
                ix += C6087a.m9557ix(3, this.vEF.computeSize());
            }
            ix = (ix + C6091a.m9572bs(4, this.vCo)) + C6091a.m9572bs(5, this.vMd);
            if (this.vMe != null) {
                ix += C6091a.m9575f(6, this.vMe);
            }
            ix += C6091a.m9572bs(7, this.jBT);
            if (this.vMf != null) {
                ix += C6091a.m9575f(8, this.vMf);
            }
            if (this.vMa != null) {
                ix += C6087a.m9557ix(9, this.vMa.computeSize());
            }
            if (this.vHP != null) {
                ix += C6087a.m9557ix(10, this.vHP.computeSize());
            }
            if (this.vMb != null) {
                ix += C6087a.m9557ix(11, this.vMb.computeSize());
            }
            if (this.vLP != null) {
                ix += C6087a.m9557ix(12, this.vLP.computeSize());
            }
            ix += C6091a.m9572bs(13, this.vCl);
            if (this.vHJ != null) {
                ix += C6087a.m9557ix(14, this.vHJ.computeSize());
            }
            AppMethodBeat.m2505o(73696);
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
                AppMethodBeat.m2505o(73696);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(73696);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(73696);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35929jr c35929jr = (C35929jr) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35929jr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 2:
                    c35929jr.vLX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73696);
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
                        c35929jr.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 4:
                    c35929jr.vCo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 5:
                    c35929jr.vMd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 6:
                    c35929jr.vMe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 7:
                    c35929jr.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 8:
                    c35929jr.vMf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35929jr.vMa = bts;
                    }
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35929jr.vHP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35929jr.vMb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btv btv = new btv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btv.populateBuilderWithField(c6086a3, btv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35929jr.vLP = btv;
                    }
                    AppMethodBeat.m2505o(73696);
                    return 0;
                case 13:
                    c35929jr.vCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73696);
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
                        c35929jr.vHJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(73696);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73696);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73696);
            return -1;
        }
    }
}
