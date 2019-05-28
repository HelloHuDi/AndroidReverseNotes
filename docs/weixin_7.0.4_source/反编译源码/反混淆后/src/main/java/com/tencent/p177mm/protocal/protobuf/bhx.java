package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bhx */
public final class bhx extends btd {
    public String pdA;
    public String type;
    public String wLb;
    public bia wLf;
    public LinkedList<bhx> wLg = new LinkedList();
    public int wLh;

    public bhx() {
        AppMethodBeat.m2504i(90699);
        AppMethodBeat.m2505o(90699);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(90700);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wLf != null) {
                c6093a.mo13479iy(2, this.wLf.computeSize());
                this.wLf.writeFields(c6093a);
            }
            if (this.wLb != null) {
                c6093a.mo13475e(3, this.wLb);
            }
            if (this.pdA != null) {
                c6093a.mo13475e(4, this.pdA);
            }
            if (this.type != null) {
                c6093a.mo13475e(5, this.type);
            }
            c6093a.mo13474e(6, 8, this.wLg);
            c6093a.mo13480iz(7, this.wLh);
            AppMethodBeat.m2505o(90700);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wLf != null) {
                ix += C6087a.m9557ix(2, this.wLf.computeSize());
            }
            if (this.wLb != null) {
                ix += C6091a.m9575f(3, this.wLb);
            }
            if (this.pdA != null) {
                ix += C6091a.m9575f(4, this.pdA);
            }
            if (this.type != null) {
                ix += C6091a.m9575f(5, this.type);
            }
            int c = (ix + C6087a.m9552c(6, 8, this.wLg)) + C6091a.m9572bs(7, this.wLh);
            AppMethodBeat.m2505o(90700);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wLg.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(90700);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bhx bhx = (bhx) objArr[1];
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
                        bhx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(90700);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bia bia = new bia();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bia.populateBuilderWithField(c6086a3, bia, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bhx.wLf = bia;
                    }
                    AppMethodBeat.m2505o(90700);
                    return 0;
                case 3:
                    bhx.wLb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(90700);
                    return 0;
                case 4:
                    bhx.pdA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(90700);
                    return 0;
                case 5:
                    bhx.type = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(90700);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhx bhx2 = new bhx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhx2.populateBuilderWithField(c6086a3, bhx2, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bhx.wLg.add(bhx2);
                    }
                    AppMethodBeat.m2505o(90700);
                    return 0;
                case 7:
                    bhx.wLh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(90700);
                    return 0;
                default:
                    AppMethodBeat.m2505o(90700);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(90700);
            return -1;
        }
    }
}
