package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ks */
public class C44138ks extends C1331a {
    public int cancel;
    public long cuQ;
    public int pos;
    public String vNN;
    public LinkedList<Integer> vNO = new LinkedList();
    public int vNP;
    public int vNQ;
    public int vNR;
    public int vNS;
    public int vNT;
    public int vNU;
    public int vNV;
    public int vNW;
    public int vNX;
    public int vNY;
    public int vNZ;
    public int vNr;
    public int vOa;
    public int vOb;
    public String vOc;
    public long vOd;
    public int vOe;
    public int vOf;
    public int vOg;
    public int vOh;
    public int vOi;
    public int vOj;
    public int vOk;

    public C44138ks() {
        AppMethodBeat.m2504i(14714);
        AppMethodBeat.m2505o(14714);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14715);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vNN != null) {
                c6093a.mo13475e(1, this.vNN);
            }
            c6093a.mo13472ai(2, this.cuQ);
            c6093a.mo13480iz(3, this.pos);
            c6093a.mo13474e(4, 2, this.vNO);
            c6093a.mo13480iz(5, this.vNP);
            c6093a.mo13480iz(6, this.vNQ);
            c6093a.mo13480iz(7, this.vNR);
            c6093a.mo13480iz(8, this.vNS);
            c6093a.mo13480iz(9, this.vNT);
            c6093a.mo13480iz(10, this.vNU);
            c6093a.mo13480iz(11, this.vNr);
            c6093a.mo13480iz(12, this.vNV);
            c6093a.mo13480iz(13, this.vNW);
            c6093a.mo13480iz(14, this.cancel);
            c6093a.mo13480iz(15, this.vNX);
            c6093a.mo13480iz(16, this.vNY);
            c6093a.mo13480iz(17, this.vNZ);
            c6093a.mo13480iz(18, this.vOa);
            c6093a.mo13480iz(19, this.vOb);
            if (this.vOc != null) {
                c6093a.mo13475e(20, this.vOc);
            }
            c6093a.mo13472ai(21, this.vOd);
            c6093a.mo13480iz(22, this.vOe);
            c6093a.mo13480iz(23, this.vOf);
            c6093a.mo13480iz(24, this.vOg);
            c6093a.mo13480iz(25, this.vOh);
            c6093a.mo13480iz(26, this.vOi);
            c6093a.mo13480iz(27, this.vOj);
            c6093a.mo13480iz(28, this.vOk);
            AppMethodBeat.m2505o(14715);
            return 0;
        } else if (i == 1) {
            if (this.vNN != null) {
                f = C6091a.m9575f(1, this.vNN) + 0;
            } else {
                f = 0;
            }
            f = (((((((((((((((((f + C6091a.m9578o(2, this.cuQ)) + C6091a.m9572bs(3, this.pos)) + C6087a.m9552c(4, 2, this.vNO)) + C6091a.m9572bs(5, this.vNP)) + C6091a.m9572bs(6, this.vNQ)) + C6091a.m9572bs(7, this.vNR)) + C6091a.m9572bs(8, this.vNS)) + C6091a.m9572bs(9, this.vNT)) + C6091a.m9572bs(10, this.vNU)) + C6091a.m9572bs(11, this.vNr)) + C6091a.m9572bs(12, this.vNV)) + C6091a.m9572bs(13, this.vNW)) + C6091a.m9572bs(14, this.cancel)) + C6091a.m9572bs(15, this.vNX)) + C6091a.m9572bs(16, this.vNY)) + C6091a.m9572bs(17, this.vNZ)) + C6091a.m9572bs(18, this.vOa)) + C6091a.m9572bs(19, this.vOb);
            if (this.vOc != null) {
                f += C6091a.m9575f(20, this.vOc);
            }
            int o = (((((((f + C6091a.m9578o(21, this.vOd)) + C6091a.m9572bs(22, this.vOe)) + C6091a.m9572bs(23, this.vOf)) + C6091a.m9572bs(24, this.vOg)) + C6091a.m9572bs(25, this.vOh)) + C6091a.m9572bs(26, this.vOi)) + C6091a.m9572bs(27, this.vOj)) + C6091a.m9572bs(28, this.vOk);
            AppMethodBeat.m2505o(14715);
            return o;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vNO.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14715);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44138ks c44138ks = (C44138ks) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44138ks.vNN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 2:
                    c44138ks.cuQ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 3:
                    c44138ks.pos = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 4:
                    c44138ks.vNO.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 5:
                    c44138ks.vNP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 6:
                    c44138ks.vNQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 7:
                    c44138ks.vNR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 8:
                    c44138ks.vNS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 9:
                    c44138ks.vNT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 10:
                    c44138ks.vNU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 11:
                    c44138ks.vNr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 12:
                    c44138ks.vNV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 13:
                    c44138ks.vNW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 14:
                    c44138ks.cancel = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 15:
                    c44138ks.vNX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 16:
                    c44138ks.vNY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 17:
                    c44138ks.vNZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 18:
                    c44138ks.vOa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 19:
                    c44138ks.vOb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 20:
                    c44138ks.vOc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 21:
                    c44138ks.vOd = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 22:
                    c44138ks.vOe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 23:
                    c44138ks.vOf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 24:
                    c44138ks.vOg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 25:
                    c44138ks.vOh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 26:
                    c44138ks.vOi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case 27:
                    c44138ks.vOj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    c44138ks.vOk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14715);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14715);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14715);
            return -1;
        }
    }
}
