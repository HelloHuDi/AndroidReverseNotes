package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.blj */
public final class blj extends btd {
    public int vKp;
    public String vKq;
    public String vRN;
    public LinkedList<C35968ze> wOp = new LinkedList();
    public LinkedList<C35905au> wOq = new LinkedList();
    public int wOr;
    public int wpD;

    public blj() {
        AppMethodBeat.m2504i(56929);
        AppMethodBeat.m2505o(56929);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56930);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wpD);
            c6093a.mo13474e(3, 8, this.wOp);
            if (this.vRN != null) {
                c6093a.mo13475e(4, this.vRN);
            }
            c6093a.mo13480iz(5, this.vKp);
            if (this.vKq != null) {
                c6093a.mo13475e(6, this.vKq);
            }
            c6093a.mo13474e(7, 8, this.wOq);
            c6093a.mo13480iz(8, this.wOr);
            AppMethodBeat.m2505o(56930);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.wpD)) + C6087a.m9552c(3, 8, this.wOp);
            if (this.vRN != null) {
                ix += C6091a.m9575f(4, this.vRN);
            }
            ix += C6091a.m9572bs(5, this.vKp);
            if (this.vKq != null) {
                ix += C6091a.m9575f(6, this.vKq);
            }
            int c = (ix + C6087a.m9552c(7, 8, this.wOq)) + C6091a.m9572bs(8, this.wOr);
            AppMethodBeat.m2505o(56930);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wOp.clear();
            this.wOq.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56930);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            blj blj = (blj) objArr[1];
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
                        blj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56930);
                    return 0;
                case 2:
                    blj.wpD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56930);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35968ze c35968ze = new C35968ze();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35968ze.populateBuilderWithField(c6086a3, c35968ze, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        blj.wOp.add(c35968ze);
                    }
                    AppMethodBeat.m2505o(56930);
                    return 0;
                case 4:
                    blj.vRN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56930);
                    return 0;
                case 5:
                    blj.vKp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56930);
                    return 0;
                case 6:
                    blj.vKq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56930);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35905au c35905au = new C35905au();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35905au.populateBuilderWithField(c6086a3, c35905au, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        blj.wOq.add(c35905au);
                    }
                    AppMethodBeat.m2505o(56930);
                    return 0;
                case 8:
                    blj.wOr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56930);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56930);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56930);
            return -1;
        }
    }
}
