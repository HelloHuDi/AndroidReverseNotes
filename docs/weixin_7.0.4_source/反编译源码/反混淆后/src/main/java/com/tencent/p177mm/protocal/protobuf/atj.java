package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.atj */
public final class atj extends C1331a {
    public int kbK;
    public String kdf;
    public int state;
    public int tob;
    public int vNm;
    public String vYh;
    public long wch;
    public String wpp;
    public String wxs;
    public bkc wxt;
    public int wxu;
    public int wxv;
    public String wxw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48871);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wpp != null) {
                c6093a.mo13475e(1, this.wpp);
            }
            if (this.vYh != null) {
                c6093a.mo13475e(2, this.vYh);
            }
            c6093a.mo13472ai(3, this.wch);
            c6093a.mo13480iz(4, this.state);
            if (this.wxs != null) {
                c6093a.mo13475e(5, this.wxs);
            }
            c6093a.mo13480iz(6, this.tob);
            if (this.wxt != null) {
                c6093a.mo13479iy(7, this.wxt.computeSize());
                this.wxt.writeFields(c6093a);
            }
            c6093a.mo13480iz(8, this.vNm);
            c6093a.mo13480iz(9, this.kbK);
            c6093a.mo13480iz(10, this.wxu);
            c6093a.mo13480iz(11, this.wxv);
            if (this.wxw != null) {
                c6093a.mo13475e(12, this.wxw);
            }
            if (this.kdf != null) {
                c6093a.mo13475e(13, this.kdf);
            }
            AppMethodBeat.m2505o(48871);
            return 0;
        } else if (i == 1) {
            if (this.wpp != null) {
                f = C6091a.m9575f(1, this.wpp) + 0;
            } else {
                f = 0;
            }
            if (this.vYh != null) {
                f += C6091a.m9575f(2, this.vYh);
            }
            f = (f + C6091a.m9578o(3, this.wch)) + C6091a.m9572bs(4, this.state);
            if (this.wxs != null) {
                f += C6091a.m9575f(5, this.wxs);
            }
            f += C6091a.m9572bs(6, this.tob);
            if (this.wxt != null) {
                f += C6087a.m9557ix(7, this.wxt.computeSize());
            }
            f = (((f + C6091a.m9572bs(8, this.vNm)) + C6091a.m9572bs(9, this.kbK)) + C6091a.m9572bs(10, this.wxu)) + C6091a.m9572bs(11, this.wxv);
            if (this.wxw != null) {
                f += C6091a.m9575f(12, this.wxw);
            }
            if (this.kdf != null) {
                f += C6091a.m9575f(13, this.kdf);
            }
            AppMethodBeat.m2505o(48871);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48871);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            atj atj = (atj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    atj.wpp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 2:
                    atj.vYh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 3:
                    atj.wch = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 4:
                    atj.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 5:
                    atj.wxs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 6:
                    atj.tob = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bkc bkc = new bkc();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bkc.populateBuilderWithField(c6086a3, bkc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        atj.wxt = bkc;
                    }
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 8:
                    atj.vNm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 9:
                    atj.kbK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 10:
                    atj.wxu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 11:
                    atj.wxv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 12:
                    atj.wxw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                case 13:
                    atj.kdf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48871);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48871);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48871);
            return -1;
        }
    }
}
