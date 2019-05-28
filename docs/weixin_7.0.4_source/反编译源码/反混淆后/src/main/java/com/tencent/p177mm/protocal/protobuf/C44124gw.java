package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gw */
public final class C44124gw extends C1331a {
    public String cFl;
    public String twT;
    public String twV;
    public String twY;
    public String twZ;
    public String vJj;
    public String vJk;
    public String vJl;
    public String vJm;
    public String vJn;
    public String vJo;
    public String vJp;
    public String vJq;
    public String vJr;
    public long vJs;
    public int vJt;
    public String vJu;
    public String vJv;
    public String vJw;
    public String vJx;
    public C40523gx vJy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56704);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vJj != null) {
                c6093a.mo13475e(1, this.vJj);
            }
            if (this.vJk != null) {
                c6093a.mo13475e(2, this.vJk);
            }
            if (this.vJl != null) {
                c6093a.mo13475e(3, this.vJl);
            }
            if (this.vJm != null) {
                c6093a.mo13475e(4, this.vJm);
            }
            if (this.vJn != null) {
                c6093a.mo13475e(5, this.vJn);
            }
            if (this.vJo != null) {
                c6093a.mo13475e(6, this.vJo);
            }
            if (this.vJp != null) {
                c6093a.mo13475e(7, this.vJp);
            }
            if (this.vJq != null) {
                c6093a.mo13475e(8, this.vJq);
            }
            if (this.cFl != null) {
                c6093a.mo13475e(9, this.cFl);
            }
            if (this.vJr != null) {
                c6093a.mo13475e(10, this.vJr);
            }
            if (this.twV != null) {
                c6093a.mo13475e(11, this.twV);
            }
            if (this.twZ != null) {
                c6093a.mo13475e(12, this.twZ);
            }
            if (this.twY != null) {
                c6093a.mo13475e(13, this.twY);
            }
            c6093a.mo13472ai(14, this.vJs);
            c6093a.mo13480iz(15, this.vJt);
            if (this.vJu != null) {
                c6093a.mo13475e(16, this.vJu);
            }
            if (this.vJv != null) {
                c6093a.mo13475e(17, this.vJv);
            }
            if (this.vJw != null) {
                c6093a.mo13475e(18, this.vJw);
            }
            if (this.twT != null) {
                c6093a.mo13475e(19, this.twT);
            }
            if (this.vJx != null) {
                c6093a.mo13475e(20, this.vJx);
            }
            if (this.vJy != null) {
                c6093a.mo13479iy(21, this.vJy.computeSize());
                this.vJy.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56704);
            return 0;
        } else if (i == 1) {
            if (this.vJj != null) {
                f = C6091a.m9575f(1, this.vJj) + 0;
            } else {
                f = 0;
            }
            if (this.vJk != null) {
                f += C6091a.m9575f(2, this.vJk);
            }
            if (this.vJl != null) {
                f += C6091a.m9575f(3, this.vJl);
            }
            if (this.vJm != null) {
                f += C6091a.m9575f(4, this.vJm);
            }
            if (this.vJn != null) {
                f += C6091a.m9575f(5, this.vJn);
            }
            if (this.vJo != null) {
                f += C6091a.m9575f(6, this.vJo);
            }
            if (this.vJp != null) {
                f += C6091a.m9575f(7, this.vJp);
            }
            if (this.vJq != null) {
                f += C6091a.m9575f(8, this.vJq);
            }
            if (this.cFl != null) {
                f += C6091a.m9575f(9, this.cFl);
            }
            if (this.vJr != null) {
                f += C6091a.m9575f(10, this.vJr);
            }
            if (this.twV != null) {
                f += C6091a.m9575f(11, this.twV);
            }
            if (this.twZ != null) {
                f += C6091a.m9575f(12, this.twZ);
            }
            if (this.twY != null) {
                f += C6091a.m9575f(13, this.twY);
            }
            f = (f + C6091a.m9578o(14, this.vJs)) + C6091a.m9572bs(15, this.vJt);
            if (this.vJu != null) {
                f += C6091a.m9575f(16, this.vJu);
            }
            if (this.vJv != null) {
                f += C6091a.m9575f(17, this.vJv);
            }
            if (this.vJw != null) {
                f += C6091a.m9575f(18, this.vJw);
            }
            if (this.twT != null) {
                f += C6091a.m9575f(19, this.twT);
            }
            if (this.vJx != null) {
                f += C6091a.m9575f(20, this.vJx);
            }
            if (this.vJy != null) {
                f += C6087a.m9557ix(21, this.vJy.computeSize());
            }
            AppMethodBeat.m2505o(56704);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56704);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44124gw c44124gw = (C44124gw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c44124gw.vJj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 2:
                    c44124gw.vJk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 3:
                    c44124gw.vJl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 4:
                    c44124gw.vJm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 5:
                    c44124gw.vJn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 6:
                    c44124gw.vJo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 7:
                    c44124gw.vJp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 8:
                    c44124gw.vJq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 9:
                    c44124gw.cFl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 10:
                    c44124gw.vJr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 11:
                    c44124gw.twV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 12:
                    c44124gw.twZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 13:
                    c44124gw.twY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 14:
                    c44124gw.vJs = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 15:
                    c44124gw.vJt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 16:
                    c44124gw.vJu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 17:
                    c44124gw.vJv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 18:
                    c44124gw.vJw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 19:
                    c44124gw.twT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 20:
                    c44124gw.vJx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56704);
                    return 0;
                case 21:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C40523gx c40523gx = new C40523gx();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c40523gx.populateBuilderWithField(c6086a3, c40523gx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44124gw.vJy = c40523gx;
                    }
                    AppMethodBeat.m2505o(56704);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56704);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56704);
            return -1;
        }
    }
}
