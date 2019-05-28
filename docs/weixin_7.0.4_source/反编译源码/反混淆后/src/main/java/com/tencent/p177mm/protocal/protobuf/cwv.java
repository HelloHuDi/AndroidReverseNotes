package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cwv */
public final class cwv extends C1331a {
    public int vMG;
    public LinkedList<C23424om> wco = new LinkedList();
    public C44116ex xsA;
    public int xsw;
    public String xsx;
    public String xsy;
    public int xsz;

    public cwv() {
        AppMethodBeat.m2504i(96331);
        AppMethodBeat.m2505o(96331);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96332);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vMG);
            c6093a.mo13480iz(2, this.xsw);
            if (this.xsx != null) {
                c6093a.mo13475e(3, this.xsx);
            }
            if (this.xsy != null) {
                c6093a.mo13475e(4, this.xsy);
            }
            c6093a.mo13480iz(5, this.xsz);
            c6093a.mo13474e(6, 8, this.wco);
            if (this.xsA != null) {
                c6093a.mo13479iy(7, this.xsA.computeSize());
                this.xsA.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(96332);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.vMG) + 0) + C6091a.m9572bs(2, this.xsw);
            if (this.xsx != null) {
                bs += C6091a.m9575f(3, this.xsx);
            }
            if (this.xsy != null) {
                bs += C6091a.m9575f(4, this.xsy);
            }
            bs = (bs + C6091a.m9572bs(5, this.xsz)) + C6087a.m9552c(6, 8, this.wco);
            if (this.xsA != null) {
                bs += C6087a.m9557ix(7, this.xsA.computeSize());
            }
            AppMethodBeat.m2505o(96332);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wco.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96332);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cwv cwv = (cwv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cwv.vMG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96332);
                    return 0;
                case 2:
                    cwv.xsw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96332);
                    return 0;
                case 3:
                    cwv.xsx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96332);
                    return 0;
                case 4:
                    cwv.xsy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96332);
                    return 0;
                case 5:
                    cwv.xsz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96332);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23424om c23424om = new C23424om();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23424om.populateBuilderWithField(c6086a3, c23424om, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwv.wco.add(c23424om);
                    }
                    AppMethodBeat.m2505o(96332);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44116ex c44116ex = new C44116ex();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44116ex.populateBuilderWithField(c6086a3, c44116ex, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwv.xsA = c44116ex;
                    }
                    AppMethodBeat.m2505o(96332);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96332);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96332);
            return -1;
        }
    }
}
