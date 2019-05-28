package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.q */
public final class C42778q extends C1331a {
    public String jBG;
    public String jCa;
    public String jCb;
    public String jCc;
    public String jCd;
    public long jCe;
    public long jCf;
    public String jCg;
    public String jCh;
    public C1332b jCi;
    public C1332b jCj;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18064);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jCa == null) {
                c6092b = new C6092b("Not all required fields were included: WeChatVersion");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jCb == null) {
                c6092b = new C6092b("Not all required fields were included: WeChatUserID");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jCc == null) {
                c6092b = new C6092b("Not all required fields were included: WeChatNickName");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jCd == null) {
                c6092b = new C6092b("Not all required fields were included: WeChatInstallDir");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jCg == null) {
                c6092b = new C6092b("Not all required fields were included: Manufacturer");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jBG == null) {
                c6092b = new C6092b("Not all required fields were included: Model");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jCh == null) {
                c6092b = new C6092b("Not all required fields were included: Version");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else {
                if (this.jCa != null) {
                    c6093a.mo13475e(1, this.jCa);
                }
                if (this.jCb != null) {
                    c6093a.mo13475e(2, this.jCb);
                }
                if (this.jCc != null) {
                    c6093a.mo13475e(3, this.jCc);
                }
                if (this.jCd != null) {
                    c6093a.mo13475e(4, this.jCd);
                }
                c6093a.mo13472ai(5, this.jCe);
                c6093a.mo13472ai(6, this.jCf);
                if (this.jCg != null) {
                    c6093a.mo13475e(7, this.jCg);
                }
                if (this.jBG != null) {
                    c6093a.mo13475e(8, this.jBG);
                }
                if (this.jCh != null) {
                    c6093a.mo13475e(9, this.jCh);
                }
                if (this.jCi != null) {
                    c6093a.mo13473c(10, this.jCi);
                }
                if (this.jCj != null) {
                    c6093a.mo13473c(11, this.jCj);
                }
                AppMethodBeat.m2505o(18064);
                return 0;
            }
        } else if (i == 1) {
            if (this.jCa != null) {
                f = C6091a.m9575f(1, this.jCa) + 0;
            } else {
                f = 0;
            }
            if (this.jCb != null) {
                f += C6091a.m9575f(2, this.jCb);
            }
            if (this.jCc != null) {
                f += C6091a.m9575f(3, this.jCc);
            }
            if (this.jCd != null) {
                f += C6091a.m9575f(4, this.jCd);
            }
            f = (f + C6091a.m9578o(5, this.jCe)) + C6091a.m9578o(6, this.jCf);
            if (this.jCg != null) {
                f += C6091a.m9575f(7, this.jCg);
            }
            if (this.jBG != null) {
                f += C6091a.m9575f(8, this.jBG);
            }
            if (this.jCh != null) {
                f += C6091a.m9575f(9, this.jCh);
            }
            if (this.jCi != null) {
                f += C6091a.m9571b(10, this.jCi);
            }
            if (this.jCj != null) {
                f += C6091a.m9571b(11, this.jCj);
            }
            AppMethodBeat.m2505o(18064);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.jCa == null) {
                c6092b = new C6092b("Not all required fields were included: WeChatVersion");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jCb == null) {
                c6092b = new C6092b("Not all required fields were included: WeChatUserID");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jCc == null) {
                c6092b = new C6092b("Not all required fields were included: WeChatNickName");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jCd == null) {
                c6092b = new C6092b("Not all required fields were included: WeChatInstallDir");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jCg == null) {
                c6092b = new C6092b("Not all required fields were included: Manufacturer");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jBG == null) {
                c6092b = new C6092b("Not all required fields were included: Model");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else if (this.jCh == null) {
                c6092b = new C6092b("Not all required fields were included: Version");
                AppMethodBeat.m2505o(18064);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(18064);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C42778q c42778q = (C42778q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c42778q.jCa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                case 2:
                    c42778q.jCb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                case 3:
                    c42778q.jCc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                case 4:
                    c42778q.jCd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                case 5:
                    c42778q.jCe = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                case 6:
                    c42778q.jCf = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                case 7:
                    c42778q.jCg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                case 8:
                    c42778q.jBG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                case 9:
                    c42778q.jCh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                case 10:
                    c42778q.jCi = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                case 11:
                    c42778q.jCj = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(18064);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18064);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18064);
            return -1;
        }
    }
}
