package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.uq */
public final class C23450uq extends btd {
    public int ehB;
    public SKBuiltinBuffer_t vEF;
    public LinkedList<baz> vEh = new LinkedList();
    public bts vEi;
    public String vXm;
    public String vXn;
    public bts wcc;
    public bts wce;
    public bts wcf;

    public C23450uq() {
        AppMethodBeat.m2504i(5570);
        AppMethodBeat.m2505o(5570);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5571);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else if (this.wcc == null) {
                c6092b = new C6092b("Not all required fields were included: Topic");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else if (this.wce == null) {
                c6092b = new C6092b("Not all required fields were included: PYInitial");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else if (this.wcf == null) {
                c6092b = new C6092b("Not all required fields were included: QuanPin");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else if (this.vEi == null) {
                c6092b = new C6092b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.wcc != null) {
                    c6093a.mo13479iy(2, this.wcc.computeSize());
                    this.wcc.writeFields(c6093a);
                }
                if (this.wce != null) {
                    c6093a.mo13479iy(3, this.wce.computeSize());
                    this.wce.writeFields(c6093a);
                }
                if (this.wcf != null) {
                    c6093a.mo13479iy(4, this.wcf.computeSize());
                    this.wcf.writeFields(c6093a);
                }
                c6093a.mo13480iz(5, this.ehB);
                c6093a.mo13474e(6, 8, this.vEh);
                if (this.vEi != null) {
                    c6093a.mo13479iy(7, this.vEi.computeSize());
                    this.vEi.writeFields(c6093a);
                }
                if (this.vEF != null) {
                    c6093a.mo13479iy(8, this.vEF.computeSize());
                    this.vEF.writeFields(c6093a);
                }
                if (this.vXm != null) {
                    c6093a.mo13475e(9, this.vXm);
                }
                if (this.vXn != null) {
                    c6093a.mo13475e(10, this.vXn);
                }
                AppMethodBeat.m2505o(5571);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcc != null) {
                ix += C6087a.m9557ix(2, this.wcc.computeSize());
            }
            if (this.wce != null) {
                ix += C6087a.m9557ix(3, this.wce.computeSize());
            }
            if (this.wcf != null) {
                ix += C6087a.m9557ix(4, this.wcf.computeSize());
            }
            ix = (ix + C6091a.m9572bs(5, this.ehB)) + C6087a.m9552c(6, 8, this.vEh);
            if (this.vEi != null) {
                ix += C6087a.m9557ix(7, this.vEi.computeSize());
            }
            if (this.vEF != null) {
                ix += C6087a.m9557ix(8, this.vEF.computeSize());
            }
            if (this.vXm != null) {
                ix += C6091a.m9575f(9, this.vXm);
            }
            if (this.vXn != null) {
                ix += C6091a.m9575f(10, this.vXn);
            }
            AppMethodBeat.m2505o(5571);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else if (this.wcc == null) {
                c6092b = new C6092b("Not all required fields were included: Topic");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else if (this.wce == null) {
                c6092b = new C6092b("Not all required fields were included: PYInitial");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else if (this.wcf == null) {
                c6092b = new C6092b("Not all required fields were included: QuanPin");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else if (this.vEi == null) {
                c6092b = new C6092b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(5571);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(5571);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23450uq c23450uq = (C23450uq) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23450uq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(5571);
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
                        c23450uq.wcc = bts;
                    }
                    AppMethodBeat.m2505o(5571);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23450uq.wce = bts;
                    }
                    AppMethodBeat.m2505o(5571);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23450uq.wcf = bts;
                    }
                    AppMethodBeat.m2505o(5571);
                    return 0;
                case 5:
                    c23450uq.ehB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5571);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        baz baz = new baz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baz.populateBuilderWithField(c6086a3, baz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23450uq.vEh.add(baz);
                    }
                    AppMethodBeat.m2505o(5571);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23450uq.vEi = bts;
                    }
                    AppMethodBeat.m2505o(5571);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23450uq.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5571);
                    return 0;
                case 9:
                    c23450uq.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5571);
                    return 0;
                case 10:
                    c23450uq.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5571);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5571);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5571);
            return -1;
        }
    }
}
