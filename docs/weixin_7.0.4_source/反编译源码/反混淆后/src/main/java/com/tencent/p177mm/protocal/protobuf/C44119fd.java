package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.fd */
public final class C44119fd extends btd {
    public C1332b vGZ;
    public int vHe;
    public int vHf;
    public C40519fi vHg;
    public C30182fe vHh;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28315);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28315);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vHe);
            c6093a.mo13480iz(3, this.vHf);
            if (this.vGZ != null) {
                c6093a.mo13473c(4, this.vGZ);
            }
            if (this.vHg != null) {
                c6093a.mo13479iy(5, this.vHg.computeSize());
                this.vHg.writeFields(c6093a);
            }
            if (this.vHh != null) {
                c6093a.mo13479iy(6, this.vHh.computeSize());
                this.vHh.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(28315);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.vHe)) + C6091a.m9572bs(3, this.vHf);
            if (this.vGZ != null) {
                ix += C6091a.m9571b(4, this.vGZ);
            }
            if (this.vHg != null) {
                ix += C6087a.m9557ix(5, this.vHg.computeSize());
            }
            if (this.vHh != null) {
                ix += C6087a.m9557ix(6, this.vHh.computeSize());
            }
            AppMethodBeat.m2505o(28315);
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
                AppMethodBeat.m2505o(28315);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28315);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44119fd c44119fd = (C44119fd) objArr[1];
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
                        c44119fd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28315);
                    return 0;
                case 2:
                    c44119fd.vHe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28315);
                    return 0;
                case 3:
                    c44119fd.vHf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28315);
                    return 0;
                case 4:
                    c44119fd.vGZ = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28315);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40519fi c40519fi = new C40519fi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40519fi.populateBuilderWithField(c6086a3, c40519fi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44119fd.vHg = c40519fi;
                    }
                    AppMethodBeat.m2505o(28315);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30182fe c30182fe = new C30182fe();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30182fe.populateBuilderWithField(c6086a3, c30182fe, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44119fd.vHh = c30182fe;
                    }
                    AppMethodBeat.m2505o(28315);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28315);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28315);
            return -1;
        }
    }
}
