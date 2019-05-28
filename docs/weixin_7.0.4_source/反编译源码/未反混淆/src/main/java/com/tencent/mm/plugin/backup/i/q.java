package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class q extends a {
    public String jBG;
    public String jCa;
    public String jCb;
    public String jCc;
    public String jCd;
    public long jCe;
    public long jCf;
    public String jCg;
    public String jCh;
    public b jCi;
    public b jCj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18064);
        e.a.a.b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jCa == null) {
                bVar = new e.a.a.b("Not all required fields were included: WeChatVersion");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jCb == null) {
                bVar = new e.a.a.b("Not all required fields were included: WeChatUserID");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jCc == null) {
                bVar = new e.a.a.b("Not all required fields were included: WeChatNickName");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jCd == null) {
                bVar = new e.a.a.b("Not all required fields were included: WeChatInstallDir");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jCg == null) {
                bVar = new e.a.a.b("Not all required fields were included: Manufacturer");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jBG == null) {
                bVar = new e.a.a.b("Not all required fields were included: Model");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jCh == null) {
                bVar = new e.a.a.b("Not all required fields were included: Version");
                AppMethodBeat.o(18064);
                throw bVar;
            } else {
                if (this.jCa != null) {
                    aVar.e(1, this.jCa);
                }
                if (this.jCb != null) {
                    aVar.e(2, this.jCb);
                }
                if (this.jCc != null) {
                    aVar.e(3, this.jCc);
                }
                if (this.jCd != null) {
                    aVar.e(4, this.jCd);
                }
                aVar.ai(5, this.jCe);
                aVar.ai(6, this.jCf);
                if (this.jCg != null) {
                    aVar.e(7, this.jCg);
                }
                if (this.jBG != null) {
                    aVar.e(8, this.jBG);
                }
                if (this.jCh != null) {
                    aVar.e(9, this.jCh);
                }
                if (this.jCi != null) {
                    aVar.c(10, this.jCi);
                }
                if (this.jCj != null) {
                    aVar.c(11, this.jCj);
                }
                AppMethodBeat.o(18064);
                return 0;
            }
        } else if (i == 1) {
            if (this.jCa != null) {
                f = e.a.a.b.b.a.f(1, this.jCa) + 0;
            } else {
                f = 0;
            }
            if (this.jCb != null) {
                f += e.a.a.b.b.a.f(2, this.jCb);
            }
            if (this.jCc != null) {
                f += e.a.a.b.b.a.f(3, this.jCc);
            }
            if (this.jCd != null) {
                f += e.a.a.b.b.a.f(4, this.jCd);
            }
            f = (f + e.a.a.b.b.a.o(5, this.jCe)) + e.a.a.b.b.a.o(6, this.jCf);
            if (this.jCg != null) {
                f += e.a.a.b.b.a.f(7, this.jCg);
            }
            if (this.jBG != null) {
                f += e.a.a.b.b.a.f(8, this.jBG);
            }
            if (this.jCh != null) {
                f += e.a.a.b.b.a.f(9, this.jCh);
            }
            if (this.jCi != null) {
                f += e.a.a.b.b.a.b(10, this.jCi);
            }
            if (this.jCj != null) {
                f += e.a.a.b.b.a.b(11, this.jCj);
            }
            AppMethodBeat.o(18064);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.jCa == null) {
                bVar = new e.a.a.b("Not all required fields were included: WeChatVersion");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jCb == null) {
                bVar = new e.a.a.b("Not all required fields were included: WeChatUserID");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jCc == null) {
                bVar = new e.a.a.b("Not all required fields were included: WeChatNickName");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jCd == null) {
                bVar = new e.a.a.b("Not all required fields were included: WeChatInstallDir");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jCg == null) {
                bVar = new e.a.a.b("Not all required fields were included: Manufacturer");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jBG == null) {
                bVar = new e.a.a.b("Not all required fields were included: Model");
                AppMethodBeat.o(18064);
                throw bVar;
            } else if (this.jCh == null) {
                bVar = new e.a.a.b("Not all required fields were included: Version");
                AppMethodBeat.o(18064);
                throw bVar;
            } else {
                AppMethodBeat.o(18064);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.jCa = aVar3.BTU.readString();
                    AppMethodBeat.o(18064);
                    return 0;
                case 2:
                    qVar.jCb = aVar3.BTU.readString();
                    AppMethodBeat.o(18064);
                    return 0;
                case 3:
                    qVar.jCc = aVar3.BTU.readString();
                    AppMethodBeat.o(18064);
                    return 0;
                case 4:
                    qVar.jCd = aVar3.BTU.readString();
                    AppMethodBeat.o(18064);
                    return 0;
                case 5:
                    qVar.jCe = aVar3.BTU.ve();
                    AppMethodBeat.o(18064);
                    return 0;
                case 6:
                    qVar.jCf = aVar3.BTU.ve();
                    AppMethodBeat.o(18064);
                    return 0;
                case 7:
                    qVar.jCg = aVar3.BTU.readString();
                    AppMethodBeat.o(18064);
                    return 0;
                case 8:
                    qVar.jBG = aVar3.BTU.readString();
                    AppMethodBeat.o(18064);
                    return 0;
                case 9:
                    qVar.jCh = aVar3.BTU.readString();
                    AppMethodBeat.o(18064);
                    return 0;
                case 10:
                    qVar.jCi = aVar3.BTU.emu();
                    AppMethodBeat.o(18064);
                    return 0;
                case 11:
                    qVar.jCj = aVar3.BTU.emu();
                    AppMethodBeat.o(18064);
                    return 0;
                default:
                    AppMethodBeat.o(18064);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18064);
            return -1;
        }
    }
}
