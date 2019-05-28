package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bxd */
public final class bxd extends bsr {
    public int Scene;
    public String ncM;
    public int wXm;
    public axx wcn;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80186);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcn == null) {
                c6092b = new C6092b("Not all required fields were included: Loc");
                AppMethodBeat.m2505o(80186);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wcn != null) {
                c6093a.mo13479iy(2, this.wcn.computeSize());
                this.wcn.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.wXm);
            c6093a.mo13480iz(4, this.Scene);
            if (this.ncM != null) {
                c6093a.mo13475e(5, this.ncM);
            }
            AppMethodBeat.m2505o(80186);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcn != null) {
                ix += C6087a.m9557ix(2, this.wcn.computeSize());
            }
            ix = (ix + C6091a.m9572bs(3, this.wXm)) + C6091a.m9572bs(4, this.Scene);
            if (this.ncM != null) {
                ix += C6091a.m9575f(5, this.ncM);
            }
            AppMethodBeat.m2505o(80186);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wcn == null) {
                c6092b = new C6092b("Not all required fields were included: Loc");
                AppMethodBeat.m2505o(80186);
                throw c6092b;
            }
            AppMethodBeat.m2505o(80186);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bxd bxd = (bxd) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bxd.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(80186);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axx axx = new axx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axx.populateBuilderWithField(c6086a3, axx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bxd.wcn = axx;
                    }
                    AppMethodBeat.m2505o(80186);
                    return 0;
                case 3:
                    bxd.wXm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80186);
                    return 0;
                case 4:
                    bxd.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80186);
                    return 0;
                case 5:
                    bxd.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80186);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80186);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80186);
            return -1;
        }
    }
}
