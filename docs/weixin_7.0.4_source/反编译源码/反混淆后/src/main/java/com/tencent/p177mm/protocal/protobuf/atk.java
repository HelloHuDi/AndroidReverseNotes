package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.atk */
public final class atk extends C1331a {
    public int iAd;
    public String kKZ;
    public int kbK;
    public String kdf;
    public String nSd;
    public String pMg;
    public int state;
    public String vAh;
    public int vNm;
    public String wpp;
    public long wxq;
    public String wxs;
    public int wxu;
    public int wxv;
    public String wxw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48872);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wpp != null) {
                c6093a.mo13475e(1, this.wpp);
            }
            if (this.vAh != null) {
                c6093a.mo13475e(2, this.vAh);
            }
            c6093a.mo13472ai(3, this.wxq);
            c6093a.mo13480iz(4, this.state);
            c6093a.mo13480iz(5, this.vNm);
            c6093a.mo13480iz(6, this.kbK);
            c6093a.mo13480iz(7, this.wxu);
            c6093a.mo13480iz(8, this.wxv);
            if (this.wxw != null) {
                c6093a.mo13475e(9, this.wxw);
            }
            if (this.kdf != null) {
                c6093a.mo13475e(10, this.kdf);
            }
            if (this.nSd != null) {
                c6093a.mo13475e(11, this.nSd);
            }
            if (this.kKZ != null) {
                c6093a.mo13475e(12, this.kKZ);
            }
            if (this.pMg != null) {
                c6093a.mo13475e(13, this.pMg);
            }
            if (this.wxs != null) {
                c6093a.mo13475e(14, this.wxs);
            }
            c6093a.mo13480iz(15, this.iAd);
            AppMethodBeat.m2505o(48872);
            return 0;
        } else if (i == 1) {
            if (this.wpp != null) {
                f = C6091a.m9575f(1, this.wpp) + 0;
            } else {
                f = 0;
            }
            if (this.vAh != null) {
                f += C6091a.m9575f(2, this.vAh);
            }
            f = (((((f + C6091a.m9578o(3, this.wxq)) + C6091a.m9572bs(4, this.state)) + C6091a.m9572bs(5, this.vNm)) + C6091a.m9572bs(6, this.kbK)) + C6091a.m9572bs(7, this.wxu)) + C6091a.m9572bs(8, this.wxv);
            if (this.wxw != null) {
                f += C6091a.m9575f(9, this.wxw);
            }
            if (this.kdf != null) {
                f += C6091a.m9575f(10, this.kdf);
            }
            if (this.nSd != null) {
                f += C6091a.m9575f(11, this.nSd);
            }
            if (this.kKZ != null) {
                f += C6091a.m9575f(12, this.kKZ);
            }
            if (this.pMg != null) {
                f += C6091a.m9575f(13, this.pMg);
            }
            if (this.wxs != null) {
                f += C6091a.m9575f(14, this.wxs);
            }
            int bs = f + C6091a.m9572bs(15, this.iAd);
            AppMethodBeat.m2505o(48872);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48872);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            atk atk = (atk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atk.wpp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 2:
                    atk.vAh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 3:
                    atk.wxq = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 4:
                    atk.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 5:
                    atk.vNm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 6:
                    atk.kbK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 7:
                    atk.wxu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 8:
                    atk.wxv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 9:
                    atk.wxw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 10:
                    atk.kdf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 11:
                    atk.nSd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 12:
                    atk.kKZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 13:
                    atk.pMg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 14:
                    atk.wxs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                case 15:
                    atk.iAd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48872);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48872);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48872);
            return -1;
        }
    }
}
