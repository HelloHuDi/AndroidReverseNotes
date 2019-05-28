package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class che extends a {
    public String bzH;
    public String cdy;
    public int iCm;
    public String nna;
    public String nuk;
    public String num;
    public String nun;
    public String nuo;
    public String title;
    public int versionCode;
    public String xga;
    public String xgb;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(105579);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.num == null) {
                bVar = new b("Not all required fields were included: patchId");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.nun == null) {
                bVar = new b("Not all required fields were included: newApkMd5");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.nuo == null) {
                bVar = new b("Not all required fields were included: oldApkMd5");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.title == null) {
                bVar = new b("Not all required fields were included: title");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.xgb == null) {
                bVar = new b("Not all required fields were included: okBtn");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.nna == null) {
                bVar = new b("Not all required fields were included: cancelBtn");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.cdy == null) {
                bVar = new b("Not all required fields were included: patchMd5");
                AppMethodBeat.o(105579);
                throw bVar;
            } else {
                if (this.num != null) {
                    aVar.e(1, this.num);
                }
                if (this.xga != null) {
                    aVar.e(2, this.xga);
                }
                aVar.iz(3, this.iCm);
                if (this.nun != null) {
                    aVar.e(4, this.nun);
                }
                if (this.nuo != null) {
                    aVar.e(5, this.nuo);
                }
                if (this.title != null) {
                    aVar.e(6, this.title);
                }
                if (this.bzH != null) {
                    aVar.e(7, this.bzH);
                }
                if (this.xgb != null) {
                    aVar.e(8, this.xgb);
                }
                if (this.nna != null) {
                    aVar.e(9, this.nna);
                }
                if (this.nuk != null) {
                    aVar.e(10, this.nuk);
                }
                if (this.cdy != null) {
                    aVar.e(11, this.cdy);
                }
                aVar.iz(12, this.versionCode);
                AppMethodBeat.o(105579);
                return 0;
            }
        } else if (i == 1) {
            if (this.num != null) {
                f = e.a.a.b.b.a.f(1, this.num) + 0;
            } else {
                f = 0;
            }
            if (this.xga != null) {
                f += e.a.a.b.b.a.f(2, this.xga);
            }
            f += e.a.a.b.b.a.bs(3, this.iCm);
            if (this.nun != null) {
                f += e.a.a.b.b.a.f(4, this.nun);
            }
            if (this.nuo != null) {
                f += e.a.a.b.b.a.f(5, this.nuo);
            }
            if (this.title != null) {
                f += e.a.a.b.b.a.f(6, this.title);
            }
            if (this.bzH != null) {
                f += e.a.a.b.b.a.f(7, this.bzH);
            }
            if (this.xgb != null) {
                f += e.a.a.b.b.a.f(8, this.xgb);
            }
            if (this.nna != null) {
                f += e.a.a.b.b.a.f(9, this.nna);
            }
            if (this.nuk != null) {
                f += e.a.a.b.b.a.f(10, this.nuk);
            }
            if (this.cdy != null) {
                f += e.a.a.b.b.a.f(11, this.cdy);
            }
            int bs = f + e.a.a.b.b.a.bs(12, this.versionCode);
            AppMethodBeat.o(105579);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.num == null) {
                bVar = new b("Not all required fields were included: patchId");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.nun == null) {
                bVar = new b("Not all required fields were included: newApkMd5");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.nuo == null) {
                bVar = new b("Not all required fields were included: oldApkMd5");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.title == null) {
                bVar = new b("Not all required fields were included: title");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.xgb == null) {
                bVar = new b("Not all required fields were included: okBtn");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.nna == null) {
                bVar = new b("Not all required fields were included: cancelBtn");
                AppMethodBeat.o(105579);
                throw bVar;
            } else if (this.cdy == null) {
                bVar = new b("Not all required fields were included: patchMd5");
                AppMethodBeat.o(105579);
                throw bVar;
            } else {
                AppMethodBeat.o(105579);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            che che = (che) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    che.num = aVar3.BTU.readString();
                    AppMethodBeat.o(105579);
                    return 0;
                case 2:
                    che.xga = aVar3.BTU.readString();
                    AppMethodBeat.o(105579);
                    return 0;
                case 3:
                    che.iCm = aVar3.BTU.vd();
                    AppMethodBeat.o(105579);
                    return 0;
                case 4:
                    che.nun = aVar3.BTU.readString();
                    AppMethodBeat.o(105579);
                    return 0;
                case 5:
                    che.nuo = aVar3.BTU.readString();
                    AppMethodBeat.o(105579);
                    return 0;
                case 6:
                    che.title = aVar3.BTU.readString();
                    AppMethodBeat.o(105579);
                    return 0;
                case 7:
                    che.bzH = aVar3.BTU.readString();
                    AppMethodBeat.o(105579);
                    return 0;
                case 8:
                    che.xgb = aVar3.BTU.readString();
                    AppMethodBeat.o(105579);
                    return 0;
                case 9:
                    che.nna = aVar3.BTU.readString();
                    AppMethodBeat.o(105579);
                    return 0;
                case 10:
                    che.nuk = aVar3.BTU.readString();
                    AppMethodBeat.o(105579);
                    return 0;
                case 11:
                    che.cdy = aVar3.BTU.readString();
                    AppMethodBeat.o(105579);
                    return 0;
                case 12:
                    che.versionCode = aVar3.BTU.vd();
                    AppMethodBeat.o(105579);
                    return 0;
                default:
                    AppMethodBeat.o(105579);
                    return -1;
            }
        } else {
            AppMethodBeat.o(105579);
            return -1;
        }
    }
}
