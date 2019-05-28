package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.rb */
public final class C40565rb extends btd {
    public int kdT;
    public String kdU;
    public ask vYe;
    public LinkedList<asj> vYf = new LinkedList();
    public String vYg;

    public C40565rb() {
        AppMethodBeat.m2504i(48817);
        AppMethodBeat.m2505o(48817);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48818);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48818);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kdT);
            if (this.kdU != null) {
                c6093a.mo13475e(3, this.kdU);
            }
            if (this.vYe != null) {
                c6093a.mo13479iy(4, this.vYe.computeSize());
                this.vYe.writeFields(c6093a);
            }
            c6093a.mo13474e(5, 8, this.vYf);
            if (this.vYg != null) {
                c6093a.mo13475e(6, this.vYg);
            }
            AppMethodBeat.m2505o(48818);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kdT);
            if (this.kdU != null) {
                ix += C6091a.m9575f(3, this.kdU);
            }
            if (this.vYe != null) {
                ix += C6087a.m9557ix(4, this.vYe.computeSize());
            }
            ix += C6087a.m9552c(5, 8, this.vYf);
            if (this.vYg != null) {
                ix += C6091a.m9575f(6, this.vYg);
            }
            AppMethodBeat.m2505o(48818);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vYf.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48818);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48818);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40565rb c40565rb = (C40565rb) objArr[1];
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
                        c40565rb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(48818);
                    return 0;
                case 2:
                    c40565rb.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48818);
                    return 0;
                case 3:
                    c40565rb.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48818);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ask ask = new ask();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ask.populateBuilderWithField(c6086a3, ask, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40565rb.vYe = ask;
                    }
                    AppMethodBeat.m2505o(48818);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asj asj = new asj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = asj.populateBuilderWithField(c6086a3, asj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40565rb.vYf.add(asj);
                    }
                    AppMethodBeat.m2505o(48818);
                    return 0;
                case 6:
                    c40565rb.vYg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48818);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48818);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48818);
            return -1;
        }
    }
}
