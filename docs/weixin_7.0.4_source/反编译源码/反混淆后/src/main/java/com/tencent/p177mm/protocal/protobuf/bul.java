package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bul */
public final class bul extends bsr {
    public String csB;
    public String state;
    public int wII;
    public LinkedList<String> wIJ = new LinkedList();
    public String wWc;
    public int wcA;

    public bul() {
        AppMethodBeat.m2504i(10234);
        AppMethodBeat.m2505o(10234);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10235);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.wII);
            c6093a.mo13474e(4, 1, this.wIJ);
            if (this.csB != null) {
                c6093a.mo13475e(5, this.csB);
            }
            if (this.state != null) {
                c6093a.mo13475e(6, this.state);
            }
            if (this.wWc != null) {
                c6093a.mo13475e(7, this.wWc);
            }
            c6093a.mo13480iz(8, this.wcA);
            AppMethodBeat.m2505o(10235);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(3, this.wII)) + C6087a.m9552c(4, 1, this.wIJ);
            if (this.csB != null) {
                ix += C6091a.m9575f(5, this.csB);
            }
            if (this.state != null) {
                ix += C6091a.m9575f(6, this.state);
            }
            if (this.wWc != null) {
                ix += C6091a.m9575f(7, this.wWc);
            }
            int bs = ix + C6091a.m9572bs(8, this.wcA);
            AppMethodBeat.m2505o(10235);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wIJ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10235);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bul bul = (bul) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bul.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(10235);
                    return 0;
                case 3:
                    bul.wII = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10235);
                    return 0;
                case 4:
                    bul.wIJ.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(10235);
                    return 0;
                case 5:
                    bul.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10235);
                    return 0;
                case 6:
                    bul.state = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10235);
                    return 0;
                case 7:
                    bul.wWc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10235);
                    return 0;
                case 8:
                    bul.wcA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10235);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10235);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10235);
            return -1;
        }
    }
}
