package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bqd */
public class bqd extends C1331a {
    public String iAa;
    public String iAb;
    public String iAc;
    public int iAd;
    public String iAe;
    public String izZ;
    public String kLg;
    public double score;
    public int wSp;
    public String wSq;
    public String wSr;
    public String wSs;
    public String wSt;
    public String wSu;
    public ars wSv;
    public String wSw;
    public String wSx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(134439);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.iAd);
            c6093a.mo13480iz(2, this.wSp);
            if (this.wSq != null) {
                c6093a.mo13475e(3, this.wSq);
            }
            if (this.iAb != null) {
                c6093a.mo13475e(4, this.iAb);
            }
            if (this.iAc != null) {
                c6093a.mo13475e(5, this.iAc);
            }
            if (this.wSr != null) {
                c6093a.mo13475e(6, this.wSr);
            }
            if (this.kLg != null) {
                c6093a.mo13475e(7, this.kLg);
            }
            if (this.wSs != null) {
                c6093a.mo13475e(8, this.wSs);
            }
            if (this.wSt != null) {
                c6093a.mo13475e(9, this.wSt);
            }
            c6093a.mo13476f(10, this.score);
            if (this.wSu != null) {
                c6093a.mo13475e(11, this.wSu);
            }
            if (this.izZ != null) {
                c6093a.mo13475e(12, this.izZ);
            }
            if (this.wSv != null) {
                c6093a.mo13479iy(14, this.wSv.computeSize());
                this.wSv.writeFields(c6093a);
            }
            if (this.iAa != null) {
                c6093a.mo13475e(15, this.iAa);
            }
            if (this.wSw != null) {
                c6093a.mo13475e(16, this.wSw);
            }
            if (this.wSx != null) {
                c6093a.mo13475e(17, this.wSx);
            }
            if (this.iAe != null) {
                c6093a.mo13475e(18, this.iAe);
            }
            AppMethodBeat.m2505o(134439);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.iAd) + 0) + C6091a.m9572bs(2, this.wSp);
            if (this.wSq != null) {
                bs += C6091a.m9575f(3, this.wSq);
            }
            if (this.iAb != null) {
                bs += C6091a.m9575f(4, this.iAb);
            }
            if (this.iAc != null) {
                bs += C6091a.m9575f(5, this.iAc);
            }
            if (this.wSr != null) {
                bs += C6091a.m9575f(6, this.wSr);
            }
            if (this.kLg != null) {
                bs += C6091a.m9575f(7, this.kLg);
            }
            if (this.wSs != null) {
                bs += C6091a.m9575f(8, this.wSs);
            }
            if (this.wSt != null) {
                bs += C6091a.m9575f(9, this.wSt);
            }
            bs += C6091a.m9576fv(10) + 8;
            if (this.wSu != null) {
                bs += C6091a.m9575f(11, this.wSu);
            }
            if (this.izZ != null) {
                bs += C6091a.m9575f(12, this.izZ);
            }
            if (this.wSv != null) {
                bs += C6087a.m9557ix(14, this.wSv.computeSize());
            }
            if (this.iAa != null) {
                bs += C6091a.m9575f(15, this.iAa);
            }
            if (this.wSw != null) {
                bs += C6091a.m9575f(16, this.wSw);
            }
            if (this.wSx != null) {
                bs += C6091a.m9575f(17, this.wSx);
            }
            if (this.iAe != null) {
                bs += C6091a.m9575f(18, this.iAe);
            }
            AppMethodBeat.m2505o(134439);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(134439);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bqd bqd = (bqd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bqd.iAd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 2:
                    bqd.wSp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 3:
                    bqd.wSq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 4:
                    bqd.iAb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 5:
                    bqd.iAc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 6:
                    bqd.wSr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 7:
                    bqd.kLg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 8:
                    bqd.wSs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 9:
                    bqd.wSt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 10:
                    bqd.score = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 11:
                    bqd.wSu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 12:
                    bqd.izZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 14:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ars ars = new ars();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ars.populateBuilderWithField(c6086a3, ars, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bqd.wSv = ars;
                    }
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 15:
                    bqd.iAa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 16:
                    bqd.wSw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 17:
                    bqd.wSx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                case 18:
                    bqd.iAe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134439);
                    return 0;
                default:
                    AppMethodBeat.m2505o(134439);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(134439);
            return -1;
        }
    }
}
