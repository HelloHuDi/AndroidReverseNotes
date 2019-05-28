package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ry */
public final class C23436ry extends btd {
    public String Md5;
    public int Version;
    public String vZm;
    public int vZn;
    public LinkedList<chi> vZo = new LinkedList();
    public int vZp;

    public C23436ry() {
        AppMethodBeat.m2504i(14721);
        AppMethodBeat.m2505o(14721);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14722);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(14722);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.Version);
            if (this.vZm != null) {
                c6093a.mo13475e(3, this.vZm);
            }
            if (this.Md5 != null) {
                c6093a.mo13475e(4, this.Md5);
            }
            c6093a.mo13480iz(5, this.vZn);
            c6093a.mo13474e(6, 8, this.vZo);
            c6093a.mo13480iz(7, this.vZp);
            AppMethodBeat.m2505o(14722);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.Version);
            if (this.vZm != null) {
                ix += C6091a.m9575f(3, this.vZm);
            }
            if (this.Md5 != null) {
                ix += C6091a.m9575f(4, this.Md5);
            }
            int bs = ((ix + C6091a.m9572bs(5, this.vZn)) + C6087a.m9552c(6, 8, this.vZo)) + C6091a.m9572bs(7, this.vZp);
            AppMethodBeat.m2505o(14722);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vZo.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(14722);
                throw c6092b;
            }
            AppMethodBeat.m2505o(14722);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23436ry c23436ry = (C23436ry) objArr[1];
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
                        c23436ry.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(14722);
                    return 0;
                case 2:
                    c23436ry.Version = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14722);
                    return 0;
                case 3:
                    c23436ry.vZm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14722);
                    return 0;
                case 4:
                    c23436ry.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14722);
                    return 0;
                case 5:
                    c23436ry.vZn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14722);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chi chi = new chi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chi.populateBuilderWithField(c6086a3, chi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23436ry.vZo.add(chi);
                    }
                    AppMethodBeat.m2505o(14722);
                    return 0;
                case 7:
                    c23436ry.vZp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14722);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14722);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14722);
            return -1;
        }
    }
}
