package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.btd;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.bc */
public final class C43160bc extends btd {
    public String mZM;
    public LinkedList<C12110ad> nbU = new LinkedList();
    public C1332b nbV;
    public boolean nbW;

    public C43160bc() {
        AppMethodBeat.m2504i(111598);
        AppMethodBeat.m2505o(111598);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111599);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(111599);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.nbU);
            if (this.nbV != null) {
                c6093a.mo13473c(3, this.nbV);
            }
            c6093a.mo13471aO(4, this.nbW);
            if (this.mZM != null) {
                c6093a.mo13475e(5, this.mZM);
            }
            AppMethodBeat.m2505o(111599);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.nbU);
            if (this.nbV != null) {
                ix += C6091a.m9571b(3, this.nbV);
            }
            ix += C6091a.m9576fv(4) + 1;
            if (this.mZM != null) {
                ix += C6091a.m9575f(5, this.mZM);
            }
            AppMethodBeat.m2505o(111599);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbU.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(111599);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111599);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43160bc c43160bc = (C43160bc) objArr[1];
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
                        c43160bc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(111599);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C12110ad c12110ad = new C12110ad();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12110ad.populateBuilderWithField(c6086a3, c12110ad, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43160bc.nbU.add(c12110ad);
                    }
                    AppMethodBeat.m2505o(111599);
                    return 0;
                case 3:
                    c43160bc.nbV = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(111599);
                    return 0;
                case 4:
                    c43160bc.nbW = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111599);
                    return 0;
                case 5:
                    c43160bc.mZM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111599);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111599);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111599);
            return -1;
        }
    }
}
