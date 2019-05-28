package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bbf */
public final class bbf extends btd {
    public int Ret;
    public int jCt;
    public int pcX;
    public int ptD;
    public long ptF;
    public bts vEC;
    public int vHX;
    public int wFW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60045);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(60045);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.Ret);
            if (this.vEC != null) {
                c6093a.mo13479iy(2, this.vEC.computeSize());
                this.vEC.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.ptD);
            c6093a.mo13480iz(4, this.wFW);
            c6093a.mo13480iz(5, this.pcX);
            c6093a.mo13480iz(6, this.vHX);
            c6093a.mo13480iz(7, this.jCt);
            c6093a.mo13472ai(8, this.ptF);
            AppMethodBeat.m2505o(60045);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.Ret) + 0;
            if (this.vEC != null) {
                bs += C6087a.m9557ix(2, this.vEC.computeSize());
            }
            bs = (((((bs + C6091a.m9572bs(3, this.ptD)) + C6091a.m9572bs(4, this.wFW)) + C6091a.m9572bs(5, this.pcX)) + C6091a.m9572bs(6, this.vHX)) + C6091a.m9572bs(7, this.jCt)) + C6091a.m9578o(8, this.ptF);
            AppMethodBeat.m2505o(60045);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(60045);
                throw c6092b;
            }
            AppMethodBeat.m2505o(60045);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bbf bbf = (bbf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bbf.Ret = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60045);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbf.vEC = bts;
                    }
                    AppMethodBeat.m2505o(60045);
                    return 0;
                case 3:
                    bbf.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60045);
                    return 0;
                case 4:
                    bbf.wFW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60045);
                    return 0;
                case 5:
                    bbf.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60045);
                    return 0;
                case 6:
                    bbf.vHX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60045);
                    return 0;
                case 7:
                    bbf.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60045);
                    return 0;
                case 8:
                    bbf.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(60045);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60045);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60045);
            return -1;
        }
    }
}
