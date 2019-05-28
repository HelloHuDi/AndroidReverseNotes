package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cwu */
public final class cwu extends C1331a {
    public String wYs;
    public boolean xsf;
    public String xsu;
    public bzj xsv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(115004);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xsu != null) {
                c6093a.mo13475e(1, this.xsu);
            }
            if (this.wYs != null) {
                c6093a.mo13475e(2, this.wYs);
            }
            if (this.xsv != null) {
                c6093a.mo13479iy(3, this.xsv.computeSize());
                this.xsv.writeFields(c6093a);
            }
            c6093a.mo13471aO(4, this.xsf);
            AppMethodBeat.m2505o(115004);
            return 0;
        } else if (i == 1) {
            if (this.xsu != null) {
                f = C6091a.m9575f(1, this.xsu) + 0;
            } else {
                f = 0;
            }
            if (this.wYs != null) {
                f += C6091a.m9575f(2, this.wYs);
            }
            if (this.xsv != null) {
                f += C6087a.m9557ix(3, this.xsv.computeSize());
            }
            int fv = f + (C6091a.m9576fv(4) + 1);
            AppMethodBeat.m2505o(115004);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(115004);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cwu cwu = (cwu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cwu.xsu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(115004);
                    return 0;
                case 2:
                    cwu.wYs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(115004);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bzj bzj = new bzj();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bzj.populateBuilderWithField(c6086a3, bzj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwu.xsv = bzj;
                    }
                    AppMethodBeat.m2505o(115004);
                    return 0;
                case 4:
                    cwu.xsf = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(115004);
                    return 0;
                default:
                    AppMethodBeat.m2505o(115004);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(115004);
            return -1;
        }
    }
}
