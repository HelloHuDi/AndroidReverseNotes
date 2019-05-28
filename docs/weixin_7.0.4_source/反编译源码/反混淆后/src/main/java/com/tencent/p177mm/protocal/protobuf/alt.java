package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.alt */
public final class alt extends btd {
    public int OpCode;
    public String Url;
    public String vBa;
    public String vQg;
    public String wdK;
    public SKBuiltinBuffer_t wpP;
    public String wpY;
    public int wpZ;
    public int wqU;
    public LinkedList<bhu> wqV = new LinkedList();
    public int wqW;

    public alt() {
        AppMethodBeat.m2504i(113783);
        AppMethodBeat.m2505o(113783);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(113784);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(113784);
                throw c6092b;
            } else if (this.wpP == null) {
                c6092b = new C6092b("Not all required fields were included: Buff");
                AppMethodBeat.m2505o(113784);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.wqU);
                c6093a.mo13474e(3, 8, this.wqV);
                c6093a.mo13480iz(4, this.OpCode);
                c6093a.mo13480iz(5, this.wqW);
                if (this.wpP != null) {
                    c6093a.mo13479iy(6, this.wpP.computeSize());
                    this.wpP.writeFields(c6093a);
                }
                if (this.Url != null) {
                    c6093a.mo13475e(7, this.Url);
                }
                if (this.wpY != null) {
                    c6093a.mo13475e(8, this.wpY);
                }
                if (this.wdK != null) {
                    c6093a.mo13475e(9, this.wdK);
                }
                if (this.vBa != null) {
                    c6093a.mo13475e(10, this.vBa);
                }
                c6093a.mo13480iz(11, this.wpZ);
                if (this.vQg != null) {
                    c6093a.mo13475e(12, this.vQg);
                }
                AppMethodBeat.m2505o(113784);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((ix + C6091a.m9572bs(2, this.wqU)) + C6087a.m9552c(3, 8, this.wqV)) + C6091a.m9572bs(4, this.OpCode)) + C6091a.m9572bs(5, this.wqW);
            if (this.wpP != null) {
                ix += C6087a.m9557ix(6, this.wpP.computeSize());
            }
            if (this.Url != null) {
                ix += C6091a.m9575f(7, this.Url);
            }
            if (this.wpY != null) {
                ix += C6091a.m9575f(8, this.wpY);
            }
            if (this.wdK != null) {
                ix += C6091a.m9575f(9, this.wdK);
            }
            if (this.vBa != null) {
                ix += C6091a.m9575f(10, this.vBa);
            }
            ix += C6091a.m9572bs(11, this.wpZ);
            if (this.vQg != null) {
                ix += C6091a.m9575f(12, this.vQg);
            }
            AppMethodBeat.m2505o(113784);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wqV.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(113784);
                throw c6092b;
            } else if (this.wpP == null) {
                c6092b = new C6092b("Not all required fields were included: Buff");
                AppMethodBeat.m2505o(113784);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(113784);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            alt alt = (alt) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        alt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 2:
                    alt.wqU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhu bhu = new bhu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhu.populateBuilderWithField(c6086a3, bhu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        alt.wqV.add(bhu);
                    }
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 4:
                    alt.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 5:
                    alt.wqW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        alt.wpP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 7:
                    alt.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 8:
                    alt.wpY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 9:
                    alt.wdK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 10:
                    alt.vBa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 11:
                    alt.wpZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(113784);
                    return 0;
                case 12:
                    alt.vQg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113784);
                    return 0;
                default:
                    AppMethodBeat.m2505o(113784);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(113784);
            return -1;
        }
    }
}
