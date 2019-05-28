package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cjj */
public final class cjj extends btd {
    public int xic;
    public C7259fv xid;
    public C7251ar xie;
    public bdv xif;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58938);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(58938);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.xic);
            if (this.xid != null) {
                c6093a.mo13479iy(3, this.xid.computeSize());
                this.xid.writeFields(c6093a);
            }
            if (this.xie != null) {
                c6093a.mo13479iy(4, this.xie.computeSize());
                this.xie.writeFields(c6093a);
            }
            if (this.xif != null) {
                c6093a.mo13479iy(5, this.xif.computeSize());
                this.xif.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(58938);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.xic);
            if (this.xid != null) {
                ix += C6087a.m9557ix(3, this.xid.computeSize());
            }
            if (this.xie != null) {
                ix += C6087a.m9557ix(4, this.xie.computeSize());
            }
            if (this.xif != null) {
                ix += C6087a.m9557ix(5, this.xif.computeSize());
            }
            AppMethodBeat.m2505o(58938);
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
                AppMethodBeat.m2505o(58938);
                throw c6092b;
            }
            AppMethodBeat.m2505o(58938);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cjj cjj = (cjj) objArr[1];
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
                        cjj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(58938);
                    return 0;
                case 2:
                    cjj.xic = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58938);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7259fv c7259fv = new C7259fv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7259fv.populateBuilderWithField(c6086a3, c7259fv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cjj.xid = c7259fv;
                    }
                    AppMethodBeat.m2505o(58938);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7251ar c7251ar = new C7251ar();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7251ar.populateBuilderWithField(c6086a3, c7251ar, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cjj.xie = c7251ar;
                    }
                    AppMethodBeat.m2505o(58938);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdv bdv = new bdv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdv.populateBuilderWithField(c6086a3, bdv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cjj.xif = bdv;
                    }
                    AppMethodBeat.m2505o(58938);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58938);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58938);
            return -1;
        }
    }
}
