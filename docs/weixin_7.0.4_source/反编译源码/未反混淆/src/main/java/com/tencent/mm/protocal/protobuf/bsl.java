package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class bsl extends a {
    public String AesKey;
    public String wTY;
    public String wUA;
    public String wUB;
    public String wUC;
    public String wUD;
    public float wUE;
    public String wUv;
    public float wUw;
    public String wUx;
    public String wUy;
    public String wUz;
    public String wdO;
    public String wip;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(65420);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wip == null) {
                bVar = new b("Not all required fields were included: FileID");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.AesKey == null) {
                bVar = new b("Not all required fields were included: AesKey");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUx == null) {
                bVar = new b("Not all required fields were included: ThumbFileID");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUy == null) {
                bVar = new b("Not all required fields were included: ThumbAesKey");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUz == null) {
                bVar = new b("Not all required fields were included: ThumbMD5");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUB == null) {
                bVar = new b("Not all required fields were included: OriginThumbFileID");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUC == null) {
                bVar = new b("Not all required fields were included: OriginThumbAesKey");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUD == null) {
                bVar = new b("Not all required fields were included: OriginThumbMD5");
                AppMethodBeat.o(65420);
                throw bVar;
            } else {
                if (this.wip != null) {
                    aVar.e(1, this.wip);
                }
                if (this.AesKey != null) {
                    aVar.e(2, this.AesKey);
                }
                if (this.wdO != null) {
                    aVar.e(3, this.wdO);
                }
                if (this.wUv != null) {
                    aVar.e(4, this.wUv);
                }
                aVar.r(5, this.wUw);
                if (this.wUx != null) {
                    aVar.e(6, this.wUx);
                }
                if (this.wUy != null) {
                    aVar.e(7, this.wUy);
                }
                if (this.wUz != null) {
                    aVar.e(8, this.wUz);
                }
                if (this.wTY != null) {
                    aVar.e(9, this.wTY);
                }
                if (this.wUA != null) {
                    aVar.e(10, this.wUA);
                }
                if (this.wUB != null) {
                    aVar.e(11, this.wUB);
                }
                if (this.wUC != null) {
                    aVar.e(12, this.wUC);
                }
                if (this.wUD != null) {
                    aVar.e(13, this.wUD);
                }
                aVar.r(14, this.wUE);
                AppMethodBeat.o(65420);
                return 0;
            }
        } else if (i == 1) {
            if (this.wip != null) {
                f = e.a.a.b.b.a.f(1, this.wip) + 0;
            } else {
                f = 0;
            }
            if (this.AesKey != null) {
                f += e.a.a.b.b.a.f(2, this.AesKey);
            }
            if (this.wdO != null) {
                f += e.a.a.b.b.a.f(3, this.wdO);
            }
            if (this.wUv != null) {
                f += e.a.a.b.b.a.f(4, this.wUv);
            }
            f += e.a.a.b.b.a.fv(5) + 4;
            if (this.wUx != null) {
                f += e.a.a.b.b.a.f(6, this.wUx);
            }
            if (this.wUy != null) {
                f += e.a.a.b.b.a.f(7, this.wUy);
            }
            if (this.wUz != null) {
                f += e.a.a.b.b.a.f(8, this.wUz);
            }
            if (this.wTY != null) {
                f += e.a.a.b.b.a.f(9, this.wTY);
            }
            if (this.wUA != null) {
                f += e.a.a.b.b.a.f(10, this.wUA);
            }
            if (this.wUB != null) {
                f += e.a.a.b.b.a.f(11, this.wUB);
            }
            if (this.wUC != null) {
                f += e.a.a.b.b.a.f(12, this.wUC);
            }
            if (this.wUD != null) {
                f += e.a.a.b.b.a.f(13, this.wUD);
            }
            int fv = f + (e.a.a.b.b.a.fv(14) + 4);
            AppMethodBeat.o(65420);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wip == null) {
                bVar = new b("Not all required fields were included: FileID");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.AesKey == null) {
                bVar = new b("Not all required fields were included: AesKey");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUx == null) {
                bVar = new b("Not all required fields were included: ThumbFileID");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUy == null) {
                bVar = new b("Not all required fields were included: ThumbAesKey");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUz == null) {
                bVar = new b("Not all required fields were included: ThumbMD5");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUB == null) {
                bVar = new b("Not all required fields were included: OriginThumbFileID");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUC == null) {
                bVar = new b("Not all required fields were included: OriginThumbAesKey");
                AppMethodBeat.o(65420);
                throw bVar;
            } else if (this.wUD == null) {
                bVar = new b("Not all required fields were included: OriginThumbMD5");
                AppMethodBeat.o(65420);
                throw bVar;
            } else {
                AppMethodBeat.o(65420);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsl bsl = (bsl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bsl.wip = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 2:
                    bsl.AesKey = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 3:
                    bsl.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 4:
                    bsl.wUv = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 5:
                    bsl.wUw = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(65420);
                    return 0;
                case 6:
                    bsl.wUx = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 7:
                    bsl.wUy = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 8:
                    bsl.wUz = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 9:
                    bsl.wTY = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 10:
                    bsl.wUA = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 11:
                    bsl.wUB = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 12:
                    bsl.wUC = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 13:
                    bsl.wUD = aVar3.BTU.readString();
                    AppMethodBeat.o(65420);
                    return 0;
                case 14:
                    bsl.wUE = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(65420);
                    return 0;
                default:
                    AppMethodBeat.o(65420);
                    return -1;
            }
        } else {
            AppMethodBeat.o(65420);
            return -1;
        }
    }
}
