package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ye */
public final class C15399ye extends C1331a {
    public int Scene;
    public int vIK = 0;
    public LinkedList<ckw> wdV = new LinkedList();
    public int wdW;
    public boolean wdX = false;

    public C15399ye() {
        AppMethodBeat.m2504i(62527);
        AppMethodBeat.m2505o(62527);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62528);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.wdV);
            c6093a.mo13480iz(2, this.wdW);
            c6093a.mo13471aO(3, this.wdX);
            c6093a.mo13480iz(4, this.vIK);
            c6093a.mo13480iz(5, this.Scene);
            AppMethodBeat.m2505o(62528);
            return 0;
        } else if (i == 1) {
            c = ((((C6087a.m9552c(1, 8, this.wdV) + 0) + C6091a.m9572bs(2, this.wdW)) + (C6091a.m9576fv(3) + 1)) + C6091a.m9572bs(4, this.vIK)) + C6091a.m9572bs(5, this.Scene);
            AppMethodBeat.m2505o(62528);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wdV.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62528);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15399ye c15399ye = (C15399ye) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ckw ckw = new ckw();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ckw.populateBuilderWithField(c6086a3, ckw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15399ye.wdV.add(ckw);
                    }
                    AppMethodBeat.m2505o(62528);
                    return 0;
                case 2:
                    c15399ye.wdW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62528);
                    return 0;
                case 3:
                    c15399ye.wdX = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(62528);
                    return 0;
                case 4:
                    c15399ye.vIK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62528);
                    return 0;
                case 5:
                    c15399ye.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62528);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62528);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62528);
            return -1;
        }
    }
}
