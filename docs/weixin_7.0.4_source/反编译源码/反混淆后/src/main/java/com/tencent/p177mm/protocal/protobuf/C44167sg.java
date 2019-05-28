package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.sg */
public final class C44167sg extends btd {
    public int jBT;
    public clu vZA;
    public bod vZB;
    public int vZC;
    public cof vZz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28363);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28363);
                throw c6092b;
            } else if (this.vZz == null) {
                c6092b = new C6092b("Not all required fields were included: TransRes");
                AppMethodBeat.m2505o(28363);
                throw c6092b;
            } else if (this.vZA == null) {
                c6092b = new C6092b("Not all required fields were included: UploadCtx");
                AppMethodBeat.m2505o(28363);
                throw c6092b;
            } else if (this.vZB == null) {
                c6092b = new C6092b("Not all required fields were included: QueryCtx");
                AppMethodBeat.m2505o(28363);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.jBT);
                if (this.vZz != null) {
                    c6093a.mo13479iy(3, this.vZz.computeSize());
                    this.vZz.writeFields(c6093a);
                }
                if (this.vZA != null) {
                    c6093a.mo13479iy(4, this.vZA.computeSize());
                    this.vZA.writeFields(c6093a);
                }
                if (this.vZB != null) {
                    c6093a.mo13479iy(5, this.vZB.computeSize());
                    this.vZB.writeFields(c6093a);
                }
                c6093a.mo13480iz(6, this.vZC);
                AppMethodBeat.m2505o(28363);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.jBT);
            if (this.vZz != null) {
                ix += C6087a.m9557ix(3, this.vZz.computeSize());
            }
            if (this.vZA != null) {
                ix += C6087a.m9557ix(4, this.vZA.computeSize());
            }
            if (this.vZB != null) {
                ix += C6087a.m9557ix(5, this.vZB.computeSize());
            }
            int bs = ix + C6091a.m9572bs(6, this.vZC);
            AppMethodBeat.m2505o(28363);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28363);
                throw c6092b;
            } else if (this.vZz == null) {
                c6092b = new C6092b("Not all required fields were included: TransRes");
                AppMethodBeat.m2505o(28363);
                throw c6092b;
            } else if (this.vZA == null) {
                c6092b = new C6092b("Not all required fields were included: UploadCtx");
                AppMethodBeat.m2505o(28363);
                throw c6092b;
            } else if (this.vZB == null) {
                c6092b = new C6092b("Not all required fields were included: QueryCtx");
                AppMethodBeat.m2505o(28363);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28363);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44167sg c44167sg = (C44167sg) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44167sg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28363);
                    return 0;
                case 2:
                    c44167sg.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28363);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cof cof = new cof();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cof.populateBuilderWithField(c6086a3, cof, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44167sg.vZz = cof;
                    }
                    AppMethodBeat.m2505o(28363);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        clu clu = new clu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = clu.populateBuilderWithField(c6086a3, clu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44167sg.vZA = clu;
                    }
                    AppMethodBeat.m2505o(28363);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bod bod = new bod();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bod.populateBuilderWithField(c6086a3, bod, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44167sg.vZB = bod;
                    }
                    AppMethodBeat.m2505o(28363);
                    return 0;
                case 6:
                    c44167sg.vZC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28363);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28363);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28363);
            return -1;
        }
    }
}
