package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aki */
public final class aki extends btd {
    public String guP;
    public int vQe;
    public String vQg;
    public SKBuiltinBuffer_t wpP;
    public int wpU;
    public LinkedList<bts> wpV = new LinkedList();
    public int wpW;
    public LinkedList<axw> wpX = new LinkedList();
    public String wpY;
    public int wpZ;
    public int wqa;
    public axx wqb;
    public String wqc;

    public aki() {
        AppMethodBeat.m2504i(28447);
        AppMethodBeat.m2505o(28447);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28448);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28448);
                throw c6092b;
            } else if (this.wpP == null) {
                c6092b = new C6092b("Not all required fields were included: Buff");
                AppMethodBeat.m2505o(28448);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.wpP != null) {
                    c6093a.mo13479iy(2, this.wpP.computeSize());
                    this.wpP.writeFields(c6093a);
                }
                c6093a.mo13480iz(3, this.wpU);
                c6093a.mo13474e(4, 8, this.wpV);
                c6093a.mo13480iz(5, this.wpW);
                c6093a.mo13474e(6, 8, this.wpX);
                c6093a.mo13480iz(7, this.vQe);
                if (this.wpY != null) {
                    c6093a.mo13475e(8, this.wpY);
                }
                if (this.vQg != null) {
                    c6093a.mo13475e(9, this.vQg);
                }
                c6093a.mo13480iz(10, this.wpZ);
                if (this.guP != null) {
                    c6093a.mo13475e(11, this.guP);
                }
                c6093a.mo13480iz(12, this.wqa);
                if (this.wqb != null) {
                    c6093a.mo13479iy(13, this.wqb.computeSize());
                    this.wqb.writeFields(c6093a);
                }
                if (this.wqc != null) {
                    c6093a.mo13475e(14, this.wqc);
                }
                AppMethodBeat.m2505o(28448);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wpP != null) {
                ix += C6087a.m9557ix(2, this.wpP.computeSize());
            }
            ix = ((((ix + C6091a.m9572bs(3, this.wpU)) + C6087a.m9552c(4, 8, this.wpV)) + C6091a.m9572bs(5, this.wpW)) + C6087a.m9552c(6, 8, this.wpX)) + C6091a.m9572bs(7, this.vQe);
            if (this.wpY != null) {
                ix += C6091a.m9575f(8, this.wpY);
            }
            if (this.vQg != null) {
                ix += C6091a.m9575f(9, this.vQg);
            }
            ix += C6091a.m9572bs(10, this.wpZ);
            if (this.guP != null) {
                ix += C6091a.m9575f(11, this.guP);
            }
            ix += C6091a.m9572bs(12, this.wqa);
            if (this.wqb != null) {
                ix += C6087a.m9557ix(13, this.wqb.computeSize());
            }
            if (this.wqc != null) {
                ix += C6091a.m9575f(14, this.wqc);
            }
            AppMethodBeat.m2505o(28448);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpV.clear();
            this.wpX.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28448);
                throw c6092b;
            } else if (this.wpP == null) {
                c6092b = new C6092b("Not all required fields were included: Buff");
                AppMethodBeat.m2505o(28448);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28448);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aki aki = (aki) objArr[1];
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
                        aki.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aki.wpP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 3:
                    aki.wpU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aki.wpV.add(bts);
                    }
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 5:
                    aki.wpW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axw axw = new axw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axw.populateBuilderWithField(c6086a3, axw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aki.wpX.add(axw);
                    }
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 7:
                    aki.vQe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 8:
                    aki.wpY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 9:
                    aki.vQg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 10:
                    aki.wpZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 11:
                    aki.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 12:
                    aki.wqa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axx axx = new axx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axx.populateBuilderWithField(c6086a3, axx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aki.wqb = axx;
                    }
                    AppMethodBeat.m2505o(28448);
                    return 0;
                case 14:
                    aki.wqc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28448);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28448);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28448);
            return -1;
        }
    }
}
