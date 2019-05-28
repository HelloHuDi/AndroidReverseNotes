package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class brw extends a {
    public String AesKey;
    public String wTW;
    public String wTX;
    public String wTY;
    public String wdO;
    public String wip;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(65416);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wip == null) {
                bVar = new b("Not all required fields were included: FileID");
                AppMethodBeat.o(65416);
                throw bVar;
            } else if (this.AesKey == null) {
                bVar = new b("Not all required fields were included: AesKey");
                AppMethodBeat.o(65416);
                throw bVar;
            } else if (this.wdO == null) {
                bVar = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(65416);
                throw bVar;
            } else if (this.wTW == null) {
                bVar = new b("Not all required fields were included: OriginFileID");
                AppMethodBeat.o(65416);
                throw bVar;
            } else if (this.wTX == null) {
                bVar = new b("Not all required fields were included: OriginAesKey");
                AppMethodBeat.o(65416);
                throw bVar;
            } else if (this.wTY == null) {
                bVar = new b("Not all required fields were included: OriginMD5");
                AppMethodBeat.o(65416);
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
                if (this.wTW != null) {
                    aVar.e(4, this.wTW);
                }
                if (this.wTX != null) {
                    aVar.e(5, this.wTX);
                }
                if (this.wTY != null) {
                    aVar.e(6, this.wTY);
                }
                AppMethodBeat.o(65416);
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
            if (this.wTW != null) {
                f += e.a.a.b.b.a.f(4, this.wTW);
            }
            if (this.wTX != null) {
                f += e.a.a.b.b.a.f(5, this.wTX);
            }
            if (this.wTY != null) {
                f += e.a.a.b.b.a.f(6, this.wTY);
            }
            AppMethodBeat.o(65416);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wip == null) {
                bVar = new b("Not all required fields were included: FileID");
                AppMethodBeat.o(65416);
                throw bVar;
            } else if (this.AesKey == null) {
                bVar = new b("Not all required fields were included: AesKey");
                AppMethodBeat.o(65416);
                throw bVar;
            } else if (this.wdO == null) {
                bVar = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(65416);
                throw bVar;
            } else if (this.wTW == null) {
                bVar = new b("Not all required fields were included: OriginFileID");
                AppMethodBeat.o(65416);
                throw bVar;
            } else if (this.wTX == null) {
                bVar = new b("Not all required fields were included: OriginAesKey");
                AppMethodBeat.o(65416);
                throw bVar;
            } else if (this.wTY == null) {
                bVar = new b("Not all required fields were included: OriginMD5");
                AppMethodBeat.o(65416);
                throw bVar;
            } else {
                AppMethodBeat.o(65416);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brw brw = (brw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brw.wip = aVar3.BTU.readString();
                    AppMethodBeat.o(65416);
                    return 0;
                case 2:
                    brw.AesKey = aVar3.BTU.readString();
                    AppMethodBeat.o(65416);
                    return 0;
                case 3:
                    brw.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(65416);
                    return 0;
                case 4:
                    brw.wTW = aVar3.BTU.readString();
                    AppMethodBeat.o(65416);
                    return 0;
                case 5:
                    brw.wTX = aVar3.BTU.readString();
                    AppMethodBeat.o(65416);
                    return 0;
                case 6:
                    brw.wTY = aVar3.BTU.readString();
                    AppMethodBeat.o(65416);
                    return 0;
                default:
                    AppMethodBeat.o(65416);
                    return -1;
            }
        } else {
            AppMethodBeat.o(65416);
            return -1;
        }
    }
}
