package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aln */
public final class aln extends btd {
    public C30178dr wqN;
    public C46523as wqO;
    public LinkedList<cvz> wqP = new LinkedList();

    public aln() {
        AppMethodBeat.m2504i(80087);
        AppMethodBeat.m2505o(80087);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80088);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wqN != null) {
                c6093a.mo13479iy(2, this.wqN.computeSize());
                this.wqN.writeFields(c6093a);
            }
            if (this.wqO != null) {
                c6093a.mo13479iy(3, this.wqO.computeSize());
                this.wqO.writeFields(c6093a);
            }
            c6093a.mo13474e(4, 8, this.wqP);
            AppMethodBeat.m2505o(80088);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wqN != null) {
                ix += C6087a.m9557ix(2, this.wqN.computeSize());
            }
            if (this.wqO != null) {
                ix += C6087a.m9557ix(3, this.wqO.computeSize());
            }
            int c = ix + C6087a.m9552c(4, 8, this.wqP);
            AppMethodBeat.m2505o(80088);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wqP.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80088);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aln aln = (aln) objArr[1];
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
                        aln.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(80088);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30178dr c30178dr = new C30178dr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30178dr.populateBuilderWithField(c6086a3, c30178dr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aln.wqN = c30178dr;
                    }
                    AppMethodBeat.m2505o(80088);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46523as c46523as = new C46523as();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46523as.populateBuilderWithField(c6086a3, c46523as, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aln.wqO = c46523as;
                    }
                    AppMethodBeat.m2505o(80088);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvz cvz = new cvz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvz.populateBuilderWithField(c6086a3, cvz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aln.wqP.add(cvz);
                    }
                    AppMethodBeat.m2505o(80088);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80088);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80088);
            return -1;
        }
    }
}
