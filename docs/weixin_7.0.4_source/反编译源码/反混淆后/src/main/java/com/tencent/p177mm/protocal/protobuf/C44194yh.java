package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.yh */
public final class C44194yh extends C1331a {
    public String Md5;
    public int jBv;
    public LinkedList<axm> jBw = new LinkedList();

    public C44194yh() {
        AppMethodBeat.m2504i(62537);
        AppMethodBeat.m2505o(62537);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62538);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Md5 != null) {
                c6093a.mo13475e(1, this.Md5);
            }
            c6093a.mo13480iz(2, this.jBv);
            c6093a.mo13474e(3, 8, this.jBw);
            AppMethodBeat.m2505o(62538);
            return 0;
        } else if (i == 1) {
            if (this.Md5 != null) {
                f = C6091a.m9575f(1, this.Md5) + 0;
            } else {
                f = 0;
            }
            int bs = (f + C6091a.m9572bs(2, this.jBv)) + C6087a.m9552c(3, 8, this.jBw);
            AppMethodBeat.m2505o(62538);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBw.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62538);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44194yh c44194yh = (C44194yh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c44194yh.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62538);
                    return 0;
                case 2:
                    c44194yh.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62538);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axm axm = new axm();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = axm.populateBuilderWithField(c6086a3, axm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44194yh.jBw.add(axm);
                    }
                    AppMethodBeat.m2505o(62538);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62538);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62538);
            return -1;
        }
    }
}
