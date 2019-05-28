package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvi */
public final class cvi extends C1331a {
    public String lvA;
    public String lvz;
    public String phw;
    public String qVw;
    public String source;
    public String thumbUrl;
    public String uaa;
    public String uab;
    public String uac;
    public String uad;
    public long uae;
    public String uaf;
    public String uag;
    public String uah;
    public String uai;
    public String uaj;
    public String uak;
    public String ual;
    public long uam;
    public String uan;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55714);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.uaa != null) {
                c6093a.mo13475e(1, this.uaa);
            }
            if (this.uab != null) {
                c6093a.mo13475e(2, this.uab);
            }
            if (this.uac != null) {
                c6093a.mo13475e(3, this.uac);
            }
            if (this.uad != null) {
                c6093a.mo13475e(4, this.uad);
            }
            c6093a.mo13472ai(5, this.uae);
            if (this.uai != null) {
                c6093a.mo13475e(6, this.uai);
            }
            if (this.lvz != null) {
                c6093a.mo13475e(7, this.lvz);
            }
            if (this.lvA != null) {
                c6093a.mo13475e(8, this.lvA);
            }
            if (this.qVw != null) {
                c6093a.mo13475e(9, this.qVw);
            }
            if (this.uaf != null) {
                c6093a.mo13475e(10, this.uaf);
            }
            if (this.uag != null) {
                c6093a.mo13475e(11, this.uag);
            }
            if (this.uah != null) {
                c6093a.mo13475e(12, this.uah);
            }
            if (this.source != null) {
                c6093a.mo13475e(13, this.source);
            }
            if (this.phw != null) {
                c6093a.mo13475e(14, this.phw);
            }
            if (this.uaj != null) {
                c6093a.mo13475e(15, this.uaj);
            }
            if (this.uak != null) {
                c6093a.mo13475e(16, this.uak);
            }
            if (this.ual != null) {
                c6093a.mo13475e(17, this.ual);
            }
            c6093a.mo13472ai(18, this.uam);
            if (this.thumbUrl != null) {
                c6093a.mo13475e(19, this.thumbUrl);
            }
            if (this.uan != null) {
                c6093a.mo13475e(20, this.uan);
            }
            AppMethodBeat.m2505o(55714);
            return 0;
        } else if (i == 1) {
            if (this.uaa != null) {
                f = C6091a.m9575f(1, this.uaa) + 0;
            } else {
                f = 0;
            }
            if (this.uab != null) {
                f += C6091a.m9575f(2, this.uab);
            }
            if (this.uac != null) {
                f += C6091a.m9575f(3, this.uac);
            }
            if (this.uad != null) {
                f += C6091a.m9575f(4, this.uad);
            }
            f += C6091a.m9578o(5, this.uae);
            if (this.uai != null) {
                f += C6091a.m9575f(6, this.uai);
            }
            if (this.lvz != null) {
                f += C6091a.m9575f(7, this.lvz);
            }
            if (this.lvA != null) {
                f += C6091a.m9575f(8, this.lvA);
            }
            if (this.qVw != null) {
                f += C6091a.m9575f(9, this.qVw);
            }
            if (this.uaf != null) {
                f += C6091a.m9575f(10, this.uaf);
            }
            if (this.uag != null) {
                f += C6091a.m9575f(11, this.uag);
            }
            if (this.uah != null) {
                f += C6091a.m9575f(12, this.uah);
            }
            if (this.source != null) {
                f += C6091a.m9575f(13, this.source);
            }
            if (this.phw != null) {
                f += C6091a.m9575f(14, this.phw);
            }
            if (this.uaj != null) {
                f += C6091a.m9575f(15, this.uaj);
            }
            if (this.uak != null) {
                f += C6091a.m9575f(16, this.uak);
            }
            if (this.ual != null) {
                f += C6091a.m9575f(17, this.ual);
            }
            f += C6091a.m9578o(18, this.uam);
            if (this.thumbUrl != null) {
                f += C6091a.m9575f(19, this.thumbUrl);
            }
            if (this.uan != null) {
                f += C6091a.m9575f(20, this.uan);
            }
            AppMethodBeat.m2505o(55714);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55714);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvi cvi = (cvi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvi.uaa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 2:
                    cvi.uab = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 3:
                    cvi.uac = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 4:
                    cvi.uad = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 5:
                    cvi.uae = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 6:
                    cvi.uai = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 7:
                    cvi.lvz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 8:
                    cvi.lvA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 9:
                    cvi.qVw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 10:
                    cvi.uaf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 11:
                    cvi.uag = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 12:
                    cvi.uah = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 13:
                    cvi.source = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 14:
                    cvi.phw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 15:
                    cvi.uaj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 16:
                    cvi.uak = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 17:
                    cvi.ual = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 18:
                    cvi.uam = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 19:
                    cvi.thumbUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                case 20:
                    cvi.uan = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55714);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55714);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55714);
            return -1;
        }
    }
}
