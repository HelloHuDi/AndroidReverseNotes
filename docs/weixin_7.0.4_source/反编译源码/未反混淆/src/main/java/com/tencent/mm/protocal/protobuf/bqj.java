package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bqj extends a {
    public long bHi;
    public String csB;
    public String nickname;
    public String pia;
    public String username;
    public String wSE;
    public double wSF;
    public LinkedList<on> wSG = new LinkedList();
    public String wSH;
    public LinkedList<btm> wSI = new LinkedList();

    public bqj() {
        AppMethodBeat.i(134441);
        AppMethodBeat.o(134441);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134442);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB != null) {
                aVar.e(1, this.csB);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            if (this.pia != null) {
                aVar.e(4, this.pia);
            }
            aVar.ai(5, this.bHi);
            if (this.wSE != null) {
                aVar.e(6, this.wSE);
            }
            aVar.f(7, this.wSF);
            aVar.e(16, 8, this.wSG);
            if (this.wSH != null) {
                aVar.e(17, this.wSH);
            }
            aVar.e(19, 8, this.wSI);
            AppMethodBeat.o(134442);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.username != null) {
                f += e.a.a.b.b.a.f(2, this.username);
            }
            if (this.nickname != null) {
                f += e.a.a.b.b.a.f(3, this.nickname);
            }
            if (this.pia != null) {
                f += e.a.a.b.b.a.f(4, this.pia);
            }
            f += e.a.a.b.b.a.o(5, this.bHi);
            if (this.wSE != null) {
                f += e.a.a.b.b.a.f(6, this.wSE);
            }
            f = (f + (e.a.a.b.b.a.fv(7) + 8)) + e.a.a.a.c(16, 8, this.wSG);
            if (this.wSH != null) {
                f += e.a.a.b.b.a.f(17, this.wSH);
            }
            int c = f + e.a.a.a.c(19, 8, this.wSI);
            AppMethodBeat.o(134442);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wSG.clear();
            this.wSI.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134442);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqj bqj = (bqj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bqj.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(134442);
                    return 0;
                case 2:
                    bqj.username = aVar3.BTU.readString();
                    AppMethodBeat.o(134442);
                    return 0;
                case 3:
                    bqj.nickname = aVar3.BTU.readString();
                    AppMethodBeat.o(134442);
                    return 0;
                case 4:
                    bqj.pia = aVar3.BTU.readString();
                    AppMethodBeat.o(134442);
                    return 0;
                case 5:
                    bqj.bHi = aVar3.BTU.ve();
                    AppMethodBeat.o(134442);
                    return 0;
                case 6:
                    bqj.wSE = aVar3.BTU.readString();
                    AppMethodBeat.o(134442);
                    return 0;
                case 7:
                    bqj.wSF = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(134442);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        on onVar = new on();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = onVar.populateBuilderWithField(aVar4, onVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bqj.wSG.add(onVar);
                    }
                    AppMethodBeat.o(134442);
                    return 0;
                case 17:
                    bqj.wSH = aVar3.BTU.readString();
                    AppMethodBeat.o(134442);
                    return 0;
                case 19:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btm btm = new btm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btm.populateBuilderWithField(aVar4, btm, a.getNextFieldNumber(aVar4))) {
                        }
                        bqj.wSI.add(btm);
                    }
                    AppMethodBeat.o(134442);
                    return 0;
                default:
                    AppMethodBeat.o(134442);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134442);
            return -1;
        }
    }
}
