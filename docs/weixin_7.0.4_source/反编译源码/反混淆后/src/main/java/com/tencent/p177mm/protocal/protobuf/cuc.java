package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cuc */
public final class cuc extends C1331a {
    public int nao;
    public String ncM;
    public long vIs;
    public long vIv;
    public String wCW;
    public String wyw;
    public boolean xqD;
    public C1332b xqE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28740);
        C6092b c6092b;
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wCW == null) {
                c6092b = new C6092b("Not all required fields were included: Nickname");
                AppMethodBeat.m2505o(28740);
                throw c6092b;
            } else if (this.ncM == null) {
                c6092b = new C6092b("Not all required fields were included: Content");
                AppMethodBeat.m2505o(28740);
                throw c6092b;
            } else if (this.wyw == null) {
                c6092b = new C6092b("Not all required fields were included: Talker");
                AppMethodBeat.m2505o(28740);
                throw c6092b;
            } else {
                c6093a.mo13472ai(1, this.vIs);
                if (this.wCW != null) {
                    c6093a.mo13475e(2, this.wCW);
                }
                if (this.ncM != null) {
                    c6093a.mo13475e(3, this.ncM);
                }
                c6093a.mo13480iz(4, this.nao);
                if (this.wyw != null) {
                    c6093a.mo13475e(5, this.wyw);
                }
                c6093a.mo13472ai(6, this.vIv);
                c6093a.mo13471aO(7, this.xqD);
                if (this.xqE != null) {
                    c6093a.mo13473c(8, this.xqE);
                }
                AppMethodBeat.m2505o(28740);
                return 0;
            }
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.vIs) + 0;
            if (this.wCW != null) {
                o += C6091a.m9575f(2, this.wCW);
            }
            if (this.ncM != null) {
                o += C6091a.m9575f(3, this.ncM);
            }
            o += C6091a.m9572bs(4, this.nao);
            if (this.wyw != null) {
                o += C6091a.m9575f(5, this.wyw);
            }
            o = (o + C6091a.m9578o(6, this.vIv)) + (C6091a.m9576fv(7) + 1);
            if (this.xqE != null) {
                o += C6091a.m9571b(8, this.xqE);
            }
            AppMethodBeat.m2505o(28740);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.wCW == null) {
                c6092b = new C6092b("Not all required fields were included: Nickname");
                AppMethodBeat.m2505o(28740);
                throw c6092b;
            } else if (this.ncM == null) {
                c6092b = new C6092b("Not all required fields were included: Content");
                AppMethodBeat.m2505o(28740);
                throw c6092b;
            } else if (this.wyw == null) {
                c6092b = new C6092b("Not all required fields were included: Talker");
                AppMethodBeat.m2505o(28740);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28740);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cuc cuc = (cuc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuc.vIs = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28740);
                    return 0;
                case 2:
                    cuc.wCW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28740);
                    return 0;
                case 3:
                    cuc.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28740);
                    return 0;
                case 4:
                    cuc.nao = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28740);
                    return 0;
                case 5:
                    cuc.wyw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28740);
                    return 0;
                case 6:
                    cuc.vIv = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28740);
                    return 0;
                case 7:
                    cuc.xqD = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28740);
                    return 0;
                case 8:
                    cuc.xqE = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28740);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28740);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28740);
            return -1;
        }
    }
}
