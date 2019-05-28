package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cip */
public final class cip extends bsr {
    public String link;
    public int scene;
    public avc xhv;
    public LinkedList<C35913df> xhw = new LinkedList();

    public cip() {
        AppMethodBeat.m2504i(80198);
        AppMethodBeat.m2505o(80198);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80199);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.link != null) {
                c6093a.mo13475e(2, this.link);
            }
            c6093a.mo13480iz(3, this.scene);
            if (this.xhv != null) {
                c6093a.mo13479iy(4, this.xhv.computeSize());
                this.xhv.writeFields(c6093a);
            }
            c6093a.mo13474e(5, 8, this.xhw);
            AppMethodBeat.m2505o(80199);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.link != null) {
                ix += C6091a.m9575f(2, this.link);
            }
            ix += C6091a.m9572bs(3, this.scene);
            if (this.xhv != null) {
                ix += C6087a.m9557ix(4, this.xhv.computeSize());
            }
            int c = ix + C6087a.m9552c(5, 8, this.xhw);
            AppMethodBeat.m2505o(80199);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xhw.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80199);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cip cip = (cip) objArr[1];
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
                        cip.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(80199);
                    return 0;
                case 2:
                    cip.link = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80199);
                    return 0;
                case 3:
                    cip.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80199);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avc avc = new avc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = avc.populateBuilderWithField(c6086a3, avc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cip.xhv = avc;
                    }
                    AppMethodBeat.m2505o(80199);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35913df c35913df = new C35913df();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35913df.populateBuilderWithField(c6086a3, c35913df, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cip.xhw.add(c35913df);
                    }
                    AppMethodBeat.m2505o(80199);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80199);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80199);
            return -1;
        }
    }
}
