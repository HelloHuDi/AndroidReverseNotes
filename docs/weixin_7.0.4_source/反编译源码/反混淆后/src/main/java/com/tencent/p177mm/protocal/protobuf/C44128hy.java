package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.hy */
public final class C44128hy extends bsr {
    public LinkedList<String> vKr = new LinkedList();
    public LinkedList<bsq> vKs = new LinkedList();
    public String vKt;
    public long vKu;
    public int vKv;
    public int vKw;

    public C44128hy() {
        AppMethodBeat.m2504i(14707);
        AppMethodBeat.m2505o(14707);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14708);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 1, this.vKr);
            c6093a.mo13474e(3, 8, this.vKs);
            if (this.vKt != null) {
                c6093a.mo13475e(4, this.vKt);
            }
            c6093a.mo13472ai(5, this.vKu);
            c6093a.mo13480iz(6, this.vKv);
            c6093a.mo13480iz(7, this.vKw);
            AppMethodBeat.m2505o(14708);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6087a.m9552c(2, 1, this.vKr)) + C6087a.m9552c(3, 8, this.vKs);
            if (this.vKt != null) {
                ix += C6091a.m9575f(4, this.vKt);
            }
            int o = ((ix + C6091a.m9578o(5, this.vKu)) + C6091a.m9572bs(6, this.vKv)) + C6091a.m9572bs(7, this.vKw);
            AppMethodBeat.m2505o(14708);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKr.clear();
            this.vKs.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14708);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44128hy c44128hy = (C44128hy) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44128hy.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(14708);
                    return 0;
                case 2:
                    c44128hy.vKr.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(14708);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsq bsq = new bsq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsq.populateBuilderWithField(c6086a3, bsq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44128hy.vKs.add(bsq);
                    }
                    AppMethodBeat.m2505o(14708);
                    return 0;
                case 4:
                    c44128hy.vKt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14708);
                    return 0;
                case 5:
                    c44128hy.vKu = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(14708);
                    return 0;
                case 6:
                    c44128hy.vKv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14708);
                    return 0;
                case 7:
                    c44128hy.vKw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14708);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14708);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14708);
            return -1;
        }
    }
}
