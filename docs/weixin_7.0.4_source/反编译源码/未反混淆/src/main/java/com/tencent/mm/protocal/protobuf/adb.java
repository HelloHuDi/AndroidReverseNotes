package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class adb extends a {
    public String Title;
    public int type;
    public LinkedList<acv> wkO = new LinkedList();
    public LinkedList<add> wkP = new LinkedList();
    public String wkQ;
    public String wkR;
    public LinkedList<adc> wkS = new LinkedList();
    public int wkT;
    public boolean wkU;

    public adb() {
        AppMethodBeat.i(112430);
        AppMethodBeat.o(112430);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(112431);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.iz(2, this.type);
            aVar.e(3, 8, this.wkO);
            aVar.e(4, 8, this.wkP);
            if (this.wkQ != null) {
                aVar.e(5, this.wkQ);
            }
            if (this.wkR != null) {
                aVar.e(6, this.wkR);
            }
            aVar.e(7, 8, this.wkS);
            aVar.iz(8, this.wkT);
            aVar.aO(9, this.wkU);
            AppMethodBeat.o(112431);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            f = ((f + e.a.a.b.b.a.bs(2, this.type)) + e.a.a.a.c(3, 8, this.wkO)) + e.a.a.a.c(4, 8, this.wkP);
            if (this.wkQ != null) {
                f += e.a.a.b.b.a.f(5, this.wkQ);
            }
            if (this.wkR != null) {
                f += e.a.a.b.b.a.f(6, this.wkR);
            }
            int c = ((f + e.a.a.a.c(7, 8, this.wkS)) + e.a.a.b.b.a.bs(8, this.wkT)) + (e.a.a.b.b.a.fv(9) + 1);
            AppMethodBeat.o(112431);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wkO.clear();
            this.wkP.clear();
            this.wkS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(112431);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adb adb = (adb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    adb.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(112431);
                    return 0;
                case 2:
                    adb.type = aVar3.BTU.vd();
                    AppMethodBeat.o(112431);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acv acv = new acv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = acv.populateBuilderWithField(aVar4, acv, a.getNextFieldNumber(aVar4))) {
                        }
                        adb.wkO.add(acv);
                    }
                    AppMethodBeat.o(112431);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        add add = new add();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = add.populateBuilderWithField(aVar4, add, a.getNextFieldNumber(aVar4))) {
                        }
                        adb.wkP.add(add);
                    }
                    AppMethodBeat.o(112431);
                    return 0;
                case 5:
                    adb.wkQ = aVar3.BTU.readString();
                    AppMethodBeat.o(112431);
                    return 0;
                case 6:
                    adb.wkR = aVar3.BTU.readString();
                    AppMethodBeat.o(112431);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        adc adc = new adc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = adc.populateBuilderWithField(aVar4, adc, a.getNextFieldNumber(aVar4))) {
                        }
                        adb.wkS.add(adc);
                    }
                    AppMethodBeat.o(112431);
                    return 0;
                case 8:
                    adb.wkT = aVar3.BTU.vd();
                    AppMethodBeat.o(112431);
                    return 0;
                case 9:
                    adb.wkU = aVar3.BTU.ehX();
                    AppMethodBeat.o(112431);
                    return 0;
                default:
                    AppMethodBeat.o(112431);
                    return -1;
            }
        } else {
            AppMethodBeat.o(112431);
            return -1;
        }
    }
}
