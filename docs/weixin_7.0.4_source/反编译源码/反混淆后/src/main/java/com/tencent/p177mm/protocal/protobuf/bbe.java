package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bbe */
public final class bbe extends C1331a {
    public int jCt;
    public String ncM;
    public int pcX;
    public bts vEC;
    public String vEG;
    public int wFW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60044);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(60044);
                throw c6092b;
            }
            if (this.vEC != null) {
                c6093a.mo13479iy(1, this.vEC.computeSize());
                this.vEC.writeFields(c6093a);
            }
            if (this.ncM != null) {
                c6093a.mo13475e(2, this.ncM);
            }
            c6093a.mo13480iz(3, this.jCt);
            c6093a.mo13480iz(4, this.pcX);
            c6093a.mo13480iz(5, this.wFW);
            if (this.vEG != null) {
                c6093a.mo13475e(6, this.vEG);
            }
            AppMethodBeat.m2505o(60044);
            return 0;
        } else if (i == 1) {
            if (this.vEC != null) {
                ix = C6087a.m9557ix(1, this.vEC.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ncM != null) {
                ix += C6091a.m9575f(2, this.ncM);
            }
            ix = ((ix + C6091a.m9572bs(3, this.jCt)) + C6091a.m9572bs(4, this.pcX)) + C6091a.m9572bs(5, this.wFW);
            if (this.vEG != null) {
                ix += C6091a.m9575f(6, this.vEG);
            }
            AppMethodBeat.m2505o(60044);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(60044);
                throw c6092b;
            }
            AppMethodBeat.m2505o(60044);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bbe bbe = (bbe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbe.vEC = bts;
                    }
                    AppMethodBeat.m2505o(60044);
                    return 0;
                case 2:
                    bbe.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60044);
                    return 0;
                case 3:
                    bbe.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60044);
                    return 0;
                case 4:
                    bbe.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60044);
                    return 0;
                case 5:
                    bbe.wFW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60044);
                    return 0;
                case 6:
                    bbe.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60044);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60044);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60044);
            return -1;
        }
    }
}
