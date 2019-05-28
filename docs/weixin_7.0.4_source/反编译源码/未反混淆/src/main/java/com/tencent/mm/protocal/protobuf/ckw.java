package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class ckw extends a {
    public int ptw;
    public int ptx;
    public String wdD;
    public String wdE;
    public String wdF;
    public String wdO;
    public b xiD;
    public boolean xiE;
    public LinkedList<String> xiF = new LinkedList();
    public String xiG;

    public ckw() {
        AppMethodBeat.i(62584);
        AppMethodBeat.o(62584);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62585);
        e.a.a.b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xiD == null) {
                bVar = new e.a.a.b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.o(62585);
                throw bVar;
            }
            if (this.wdO != null) {
                aVar.e(1, this.wdO);
            }
            aVar.iz(2, this.ptx);
            aVar.iz(3, this.ptw);
            if (this.xiD != null) {
                aVar.c(4, this.xiD);
            }
            aVar.aO(5, this.xiE);
            aVar.e(6, 1, this.xiF);
            if (this.wdD != null) {
                aVar.e(7, this.wdD);
            }
            if (this.xiG != null) {
                aVar.e(8, this.xiG);
            }
            if (this.wdF != null) {
                aVar.e(9, this.wdF);
            }
            if (this.wdE != null) {
                aVar.e(10, this.wdE);
            }
            AppMethodBeat.o(62585);
            return 0;
        } else if (i == 1) {
            if (this.wdO != null) {
                f = e.a.a.b.b.a.f(1, this.wdO) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.ptx)) + e.a.a.b.b.a.bs(3, this.ptw);
            if (this.xiD != null) {
                f += e.a.a.b.b.a.b(4, this.xiD);
            }
            f = (f + (e.a.a.b.b.a.fv(5) + 1)) + e.a.a.a.c(6, 1, this.xiF);
            if (this.wdD != null) {
                f += e.a.a.b.b.a.f(7, this.wdD);
            }
            if (this.xiG != null) {
                f += e.a.a.b.b.a.f(8, this.xiG);
            }
            if (this.wdF != null) {
                f += e.a.a.b.b.a.f(9, this.wdF);
            }
            if (this.wdE != null) {
                f += e.a.a.b.b.a.f(10, this.wdE);
            }
            AppMethodBeat.o(62585);
            return f;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xiF.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.xiD == null) {
                bVar = new e.a.a.b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.o(62585);
                throw bVar;
            }
            AppMethodBeat.o(62585);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ckw ckw = (ckw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ckw.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(62585);
                    return 0;
                case 2:
                    ckw.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(62585);
                    return 0;
                case 3:
                    ckw.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(62585);
                    return 0;
                case 4:
                    ckw.xiD = aVar3.BTU.emu();
                    AppMethodBeat.o(62585);
                    return 0;
                case 5:
                    ckw.xiE = aVar3.BTU.ehX();
                    AppMethodBeat.o(62585);
                    return 0;
                case 6:
                    ckw.xiF.add(aVar3.BTU.readString());
                    AppMethodBeat.o(62585);
                    return 0;
                case 7:
                    ckw.wdD = aVar3.BTU.readString();
                    AppMethodBeat.o(62585);
                    return 0;
                case 8:
                    ckw.xiG = aVar3.BTU.readString();
                    AppMethodBeat.o(62585);
                    return 0;
                case 9:
                    ckw.wdF = aVar3.BTU.readString();
                    AppMethodBeat.o(62585);
                    return 0;
                case 10:
                    ckw.wdE = aVar3.BTU.readString();
                    AppMethodBeat.o(62585);
                    return 0;
                default:
                    AppMethodBeat.o(62585);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62585);
            return -1;
        }
    }
}
