package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.btd;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.bm */
public final class C39190bm extends btd {
    public C43166ch ncr;
    public LinkedList<C45992c> ncs = new LinkedList();
    public boolean nct;
    public int ncu;

    public C39190bm() {
        AppMethodBeat.m2504i(111614);
        AppMethodBeat.m2505o(111614);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111615);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(111615);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.ncr != null) {
                c6093a.mo13479iy(2, this.ncr.computeSize());
                this.ncr.writeFields(c6093a);
            }
            c6093a.mo13474e(3, 8, this.ncs);
            c6093a.mo13471aO(4, this.nct);
            c6093a.mo13480iz(5, this.ncu);
            AppMethodBeat.m2505o(111615);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ncr != null) {
                ix += C6087a.m9557ix(2, this.ncr.computeSize());
            }
            int c = ((ix + C6087a.m9552c(3, 8, this.ncs)) + (C6091a.m9576fv(4) + 1)) + C6091a.m9572bs(5, this.ncu);
            AppMethodBeat.m2505o(111615);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ncs.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(111615);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111615);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39190bm c39190bm = (C39190bm) objArr[1];
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
                        c39190bm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(111615);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43166ch c43166ch = new C43166ch();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43166ch.populateBuilderWithField(c6086a3, c43166ch, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c39190bm.ncr = c43166ch;
                    }
                    AppMethodBeat.m2505o(111615);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45992c c45992c = new C45992c();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45992c.populateBuilderWithField(c6086a3, c45992c, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c39190bm.ncs.add(c45992c);
                    }
                    AppMethodBeat.m2505o(111615);
                    return 0;
                case 4:
                    c39190bm.nct = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111615);
                    return 0;
                case 5:
                    c39190bm.ncu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111615);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111615);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111615);
            return -1;
        }
    }
}
