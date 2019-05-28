package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bsw */
public final class bsw extends C1331a {
    public int vQW;
    public int vek;
    public int wOI;
    public bsz wUV;
    public bsy wUW;
    public int wUX;
    public String wUY;
    public int wUZ;
    public int wVa;
    public int wVb;
    public int wpk;
    public int wxG;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80162);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wUY == null) {
                c6092b = new C6092b("Not all required fields were included: SampleId");
                AppMethodBeat.m2505o(80162);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.wOI);
            if (this.wUV != null) {
                c6093a.mo13479iy(2, this.wUV.computeSize());
                this.wUV.writeFields(c6093a);
            }
            if (this.wUW != null) {
                c6093a.mo13479iy(3, this.wUW.computeSize());
                this.wUW.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.wpk);
            c6093a.mo13480iz(5, this.wUX);
            if (this.wUY != null) {
                c6093a.mo13475e(6, this.wUY);
            }
            c6093a.mo13480iz(7, this.vQW);
            c6093a.mo13480iz(8, this.wUZ);
            c6093a.mo13480iz(9, this.vek);
            c6093a.mo13480iz(10, this.wVa);
            c6093a.mo13480iz(11, this.wVb);
            c6093a.mo13480iz(12, this.wxG);
            AppMethodBeat.m2505o(80162);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wOI) + 0;
            if (this.wUV != null) {
                bs += C6087a.m9557ix(2, this.wUV.computeSize());
            }
            if (this.wUW != null) {
                bs += C6087a.m9557ix(3, this.wUW.computeSize());
            }
            bs = (bs + C6091a.m9572bs(4, this.wpk)) + C6091a.m9572bs(5, this.wUX);
            if (this.wUY != null) {
                bs += C6091a.m9575f(6, this.wUY);
            }
            bs = (((((bs + C6091a.m9572bs(7, this.vQW)) + C6091a.m9572bs(8, this.wUZ)) + C6091a.m9572bs(9, this.vek)) + C6091a.m9572bs(10, this.wVa)) + C6091a.m9572bs(11, this.wVb)) + C6091a.m9572bs(12, this.wxG);
            AppMethodBeat.m2505o(80162);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wUY == null) {
                c6092b = new C6092b("Not all required fields were included: SampleId");
                AppMethodBeat.m2505o(80162);
                throw c6092b;
            }
            AppMethodBeat.m2505o(80162);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bsw bsw = (bsw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bsw.wOI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsz bsz = new bsz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsz.populateBuilderWithField(c6086a3, bsz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bsw.wUV = bsz;
                    }
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsy bsy = new bsy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsy.populateBuilderWithField(c6086a3, bsy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bsw.wUW = bsy;
                    }
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 4:
                    bsw.wpk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 5:
                    bsw.wUX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 6:
                    bsw.wUY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 7:
                    bsw.vQW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 8:
                    bsw.wUZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 9:
                    bsw.vek = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 10:
                    bsw.wVa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 11:
                    bsw.wVb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80162);
                    return 0;
                case 12:
                    bsw.wxG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80162);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80162);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80162);
            return -1;
        }
    }
}
