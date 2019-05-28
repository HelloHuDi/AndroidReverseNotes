package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.buw */
public final class buw extends C1331a {
    public int Scene;
    public int vOq;
    public long vQd;
    public String vQg;
    public axy wDI;
    public int wWo;
    public LinkedList<cmg> wWp = new LinkedList();
    public String wol;

    public buw() {
        AppMethodBeat.m2504i(124347);
        AppMethodBeat.m2505o(124347);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124348);
        C6092b c6092b;
        int o;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wol == null) {
                c6092b = new C6092b("Not all required fields were included: KeyWord");
                AppMethodBeat.m2505o(124348);
                throw c6092b;
            }
            c6093a.mo13472ai(1, this.vQd);
            if (this.wol != null) {
                c6093a.mo13475e(2, this.wol);
            }
            c6093a.mo13480iz(3, this.vOq);
            if (this.wDI != null) {
                c6093a.mo13479iy(4, this.wDI.computeSize());
                this.wDI.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.wWo);
            c6093a.mo13474e(6, 8, this.wWp);
            c6093a.mo13480iz(7, this.Scene);
            if (this.vQg != null) {
                c6093a.mo13475e(8, this.vQg);
            }
            AppMethodBeat.m2505o(124348);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.vQd) + 0;
            if (this.wol != null) {
                o += C6091a.m9575f(2, this.wol);
            }
            o += C6091a.m9572bs(3, this.vOq);
            if (this.wDI != null) {
                o += C6087a.m9557ix(4, this.wDI.computeSize());
            }
            o = ((o + C6091a.m9572bs(5, this.wWo)) + C6087a.m9552c(6, 8, this.wWp)) + C6091a.m9572bs(7, this.Scene);
            if (this.vQg != null) {
                o += C6091a.m9575f(8, this.vQg);
            }
            AppMethodBeat.m2505o(124348);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wWp.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.wol == null) {
                c6092b = new C6092b("Not all required fields were included: KeyWord");
                AppMethodBeat.m2505o(124348);
                throw c6092b;
            }
            AppMethodBeat.m2505o(124348);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            buw buw = (buw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    buw.vQd = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(124348);
                    return 0;
                case 2:
                    buw.wol = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124348);
                    return 0;
                case 3:
                    buw.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124348);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axy axy = new axy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axy.populateBuilderWithField(c6086a3, axy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        buw.wDI = axy;
                    }
                    AppMethodBeat.m2505o(124348);
                    return 0;
                case 5:
                    buw.wWo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124348);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmg cmg = new cmg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmg.populateBuilderWithField(c6086a3, cmg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        buw.wWp.add(cmg);
                    }
                    AppMethodBeat.m2505o(124348);
                    return 0;
                case 7:
                    buw.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124348);
                    return 0;
                case 8:
                    buw.vQg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124348);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124348);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124348);
            return -1;
        }
    }
}
