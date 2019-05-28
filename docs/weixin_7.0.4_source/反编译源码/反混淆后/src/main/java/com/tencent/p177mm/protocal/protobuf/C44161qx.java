package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.qx */
public final class C44161qx extends C1331a {
    public int Scene;
    public LinkedList<aax> vYb = new LinkedList();
    public abi vYc;

    public C44161qx() {
        AppMethodBeat.m2504i(51382);
        AppMethodBeat.m2505o(51382);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51383);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.vYb);
            c6093a.mo13480iz(2, this.Scene);
            if (this.vYc != null) {
                c6093a.mo13479iy(3, this.vYc.computeSize());
                this.vYc.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(51383);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 8, this.vYb) + 0) + C6091a.m9572bs(2, this.Scene);
            if (this.vYc != null) {
                c += C6087a.m9557ix(3, this.vYc.computeSize());
            }
            AppMethodBeat.m2505o(51383);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vYb.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51383);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44161qx c44161qx = (C44161qx) objArr[1];
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
                        aax aax = new aax();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aax.populateBuilderWithField(c6086a3, aax, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44161qx.vYb.add(aax);
                    }
                    AppMethodBeat.m2505o(51383);
                    return 0;
                case 2:
                    c44161qx.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51383);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abi abi = new abi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abi.populateBuilderWithField(c6086a3, abi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44161qx.vYc = abi;
                    }
                    AppMethodBeat.m2505o(51383);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51383);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51383);
            return -1;
        }
    }
}
