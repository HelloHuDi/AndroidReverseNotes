package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.biw */
public final class biw extends C1331a {
    public String cEh;
    public String cIY;
    public int tBA;
    public int tBB;
    public long tBC;
    public String tBl;
    public long tBx;
    public long tBy;
    public long tBz;
    public String tID;
    public String title;
    public String type;
    public String tzT;
    public String url;
    public String wMj;
    public String wMk;
    public String wMl;
    public int wMm;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56883);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.url != null) {
                c6093a.mo13475e(1, this.url);
            }
            if (this.cEh != null) {
                c6093a.mo13475e(2, this.cEh);
            }
            if (this.cIY != null) {
                c6093a.mo13475e(3, this.cIY);
            }
            if (this.tID != null) {
                c6093a.mo13475e(4, this.tID);
            }
            if (this.tBl != null) {
                c6093a.mo13475e(5, this.tBl);
            }
            if (this.wMj != null) {
                c6093a.mo13475e(6, this.wMj);
            }
            if (this.type != null) {
                c6093a.mo13475e(7, this.type);
            }
            if (this.title != null) {
                c6093a.mo13475e(8, this.title);
            }
            c6093a.mo13472ai(9, this.tBx);
            c6093a.mo13472ai(10, this.tBy);
            if (this.tzT != null) {
                c6093a.mo13475e(11, this.tzT);
            }
            c6093a.mo13472ai(12, this.tBz);
            c6093a.mo13480iz(13, this.tBA);
            c6093a.mo13480iz(14, this.tBB);
            if (this.wMk != null) {
                c6093a.mo13475e(15, this.wMk);
            }
            if (this.wMl != null) {
                c6093a.mo13475e(16, this.wMl);
            }
            c6093a.mo13472ai(17, this.tBC);
            c6093a.mo13480iz(18, this.wMm);
            AppMethodBeat.m2505o(56883);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = C6091a.m9575f(1, this.url) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += C6091a.m9575f(2, this.cEh);
            }
            if (this.cIY != null) {
                f += C6091a.m9575f(3, this.cIY);
            }
            if (this.tID != null) {
                f += C6091a.m9575f(4, this.tID);
            }
            if (this.tBl != null) {
                f += C6091a.m9575f(5, this.tBl);
            }
            if (this.wMj != null) {
                f += C6091a.m9575f(6, this.wMj);
            }
            if (this.type != null) {
                f += C6091a.m9575f(7, this.type);
            }
            if (this.title != null) {
                f += C6091a.m9575f(8, this.title);
            }
            f = (f + C6091a.m9578o(9, this.tBx)) + C6091a.m9578o(10, this.tBy);
            if (this.tzT != null) {
                f += C6091a.m9575f(11, this.tzT);
            }
            f = ((f + C6091a.m9578o(12, this.tBz)) + C6091a.m9572bs(13, this.tBA)) + C6091a.m9572bs(14, this.tBB);
            if (this.wMk != null) {
                f += C6091a.m9575f(15, this.wMk);
            }
            if (this.wMl != null) {
                f += C6091a.m9575f(16, this.wMl);
            }
            int o = (f + C6091a.m9578o(17, this.tBC)) + C6091a.m9572bs(18, this.wMm);
            AppMethodBeat.m2505o(56883);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56883);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            biw biw = (biw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    biw.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 2:
                    biw.cEh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 3:
                    biw.cIY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 4:
                    biw.tID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 5:
                    biw.tBl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 6:
                    biw.wMj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 7:
                    biw.type = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 8:
                    biw.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 9:
                    biw.tBx = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 10:
                    biw.tBy = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 11:
                    biw.tzT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 12:
                    biw.tBz = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 13:
                    biw.tBA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 14:
                    biw.tBB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 15:
                    biw.wMk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 16:
                    biw.wMl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 17:
                    biw.tBC = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                case 18:
                    biw.wMm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56883);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56883);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56883);
            return -1;
        }
    }
}
