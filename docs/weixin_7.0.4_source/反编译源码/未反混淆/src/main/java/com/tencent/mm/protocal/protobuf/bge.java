package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bge extends a {
    public String appId;
    public String bCu;
    public String eoz;
    public String userName;
    public int wKg;
    public String wKh;
    public String wKi;
    public String wcj;
    public String wck;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80131);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.userName != null) {
                aVar.e(1, this.userName);
            }
            if (this.bCu != null) {
                aVar.e(2, this.bCu);
            }
            if (this.eoz != null) {
                aVar.e(3, this.eoz);
            }
            if (this.wcj != null) {
                aVar.e(4, this.wcj);
            }
            if (this.wck != null) {
                aVar.e(5, this.wck);
            }
            aVar.iz(6, this.wKg);
            if (this.appId != null) {
                aVar.e(7, this.appId);
            }
            if (this.wKh != null) {
                aVar.e(8, this.wKh);
            }
            if (this.wKi != null) {
                aVar.e(9, this.wKi);
            }
            AppMethodBeat.o(80131);
            return 0;
        } else if (i == 1) {
            if (this.userName != null) {
                f = e.a.a.b.b.a.f(1, this.userName) + 0;
            } else {
                f = 0;
            }
            if (this.bCu != null) {
                f += e.a.a.b.b.a.f(2, this.bCu);
            }
            if (this.eoz != null) {
                f += e.a.a.b.b.a.f(3, this.eoz);
            }
            if (this.wcj != null) {
                f += e.a.a.b.b.a.f(4, this.wcj);
            }
            if (this.wck != null) {
                f += e.a.a.b.b.a.f(5, this.wck);
            }
            f += e.a.a.b.b.a.bs(6, this.wKg);
            if (this.appId != null) {
                f += e.a.a.b.b.a.f(7, this.appId);
            }
            if (this.wKh != null) {
                f += e.a.a.b.b.a.f(8, this.wKh);
            }
            if (this.wKi != null) {
                f += e.a.a.b.b.a.f(9, this.wKi);
            }
            AppMethodBeat.o(80131);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80131);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bge bge = (bge) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bge.userName = aVar3.BTU.readString();
                    AppMethodBeat.o(80131);
                    return 0;
                case 2:
                    bge.bCu = aVar3.BTU.readString();
                    AppMethodBeat.o(80131);
                    return 0;
                case 3:
                    bge.eoz = aVar3.BTU.readString();
                    AppMethodBeat.o(80131);
                    return 0;
                case 4:
                    bge.wcj = aVar3.BTU.readString();
                    AppMethodBeat.o(80131);
                    return 0;
                case 5:
                    bge.wck = aVar3.BTU.readString();
                    AppMethodBeat.o(80131);
                    return 0;
                case 6:
                    bge.wKg = aVar3.BTU.vd();
                    AppMethodBeat.o(80131);
                    return 0;
                case 7:
                    bge.appId = aVar3.BTU.readString();
                    AppMethodBeat.o(80131);
                    return 0;
                case 8:
                    bge.wKh = aVar3.BTU.readString();
                    AppMethodBeat.o(80131);
                    return 0;
                case 9:
                    bge.wKi = aVar3.BTU.readString();
                    AppMethodBeat.o(80131);
                    return 0;
                default:
                    AppMethodBeat.o(80131);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80131);
            return -1;
        }
    }
}
