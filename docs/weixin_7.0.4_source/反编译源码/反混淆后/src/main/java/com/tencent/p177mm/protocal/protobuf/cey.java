package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cey */
public final class cey extends C1331a {
    public String ThumbUrl;
    public int jCt;
    public String ncM;
    public String ndF;
    public String ndG;
    public int pcX;
    public long vQE;
    public int wZF;
    public int wZG;
    public int wZH;
    public int xdB;
    public cer xdJ;
    public String xdy;
    public String xdz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56544);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.vQE);
            if (this.ndG != null) {
                c6093a.mo13475e(2, this.ndG);
            }
            if (this.ndF != null) {
                c6093a.mo13475e(3, this.ndF);
            }
            if (this.xdy != null) {
                c6093a.mo13475e(4, this.xdy);
            }
            if (this.xdz != null) {
                c6093a.mo13475e(5, this.xdz);
            }
            if (this.ncM != null) {
                c6093a.mo13475e(6, this.ncM);
            }
            c6093a.mo13480iz(7, this.jCt);
            c6093a.mo13480iz(8, this.pcX);
            c6093a.mo13480iz(9, this.wZG);
            c6093a.mo13480iz(10, this.wZF);
            c6093a.mo13480iz(11, this.wZH);
            if (this.ThumbUrl != null) {
                c6093a.mo13475e(12, this.ThumbUrl);
            }
            if (this.xdJ != null) {
                c6093a.mo13479iy(13, this.xdJ.computeSize());
                this.xdJ.writeFields(c6093a);
            }
            c6093a.mo13480iz(14, this.xdB);
            AppMethodBeat.m2505o(56544);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.vQE) + 0;
            if (this.ndG != null) {
                o += C6091a.m9575f(2, this.ndG);
            }
            if (this.ndF != null) {
                o += C6091a.m9575f(3, this.ndF);
            }
            if (this.xdy != null) {
                o += C6091a.m9575f(4, this.xdy);
            }
            if (this.xdz != null) {
                o += C6091a.m9575f(5, this.xdz);
            }
            if (this.ncM != null) {
                o += C6091a.m9575f(6, this.ncM);
            }
            o = ((((o + C6091a.m9572bs(7, this.jCt)) + C6091a.m9572bs(8, this.pcX)) + C6091a.m9572bs(9, this.wZG)) + C6091a.m9572bs(10, this.wZF)) + C6091a.m9572bs(11, this.wZH);
            if (this.ThumbUrl != null) {
                o += C6091a.m9575f(12, this.ThumbUrl);
            }
            if (this.xdJ != null) {
                o += C6087a.m9557ix(13, this.xdJ.computeSize());
            }
            o += C6091a.m9572bs(14, this.xdB);
            AppMethodBeat.m2505o(56544);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56544);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cey cey = (cey) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cey.vQE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 2:
                    cey.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 3:
                    cey.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 4:
                    cey.xdy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 5:
                    cey.xdz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 6:
                    cey.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 7:
                    cey.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 8:
                    cey.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 9:
                    cey.wZG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 10:
                    cey.wZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 11:
                    cey.wZH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 12:
                    cey.ThumbUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 13:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cer cer = new cer();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cer.populateBuilderWithField(c6086a3, cer, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cey.xdJ = cer;
                    }
                    AppMethodBeat.m2505o(56544);
                    return 0;
                case 14:
                    cey.xdB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56544);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56544);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56544);
            return -1;
        }
    }
}
