package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bee extends bsr {
    public int Scene;
    public int vOs;
    public int wHN;
    public b wHO;
    public int wHP;
    public b wHQ;
    public String wHR;
    public String wHS;
    public String wHT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(81502);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vOs);
            aVar.iz(3, this.wHN);
            if (this.wHO != null) {
                aVar.c(4, this.wHO);
            }
            aVar.iz(5, this.wHP);
            if (this.wHQ != null) {
                aVar.c(6, this.wHQ);
            }
            if (this.wHR != null) {
                aVar.e(7, this.wHR);
            }
            if (this.wHS != null) {
                aVar.e(8, this.wHS);
            }
            if (this.wHT != null) {
                aVar.e(9, this.wHT);
            }
            aVar.iz(10, this.Scene);
            AppMethodBeat.o(81502);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.vOs)) + e.a.a.b.b.a.bs(3, this.wHN);
            if (this.wHO != null) {
                ix += e.a.a.b.b.a.b(4, this.wHO);
            }
            ix += e.a.a.b.b.a.bs(5, this.wHP);
            if (this.wHQ != null) {
                ix += e.a.a.b.b.a.b(6, this.wHQ);
            }
            if (this.wHR != null) {
                ix += e.a.a.b.b.a.f(7, this.wHR);
            }
            if (this.wHS != null) {
                ix += e.a.a.b.b.a.f(8, this.wHS);
            }
            if (this.wHT != null) {
                ix += e.a.a.b.b.a.f(9, this.wHT);
            }
            int bs = ix + e.a.a.b.b.a.bs(10, this.Scene);
            AppMethodBeat.o(81502);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(81502);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bee bee = (bee) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bee.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(81502);
                    return 0;
                case 2:
                    bee.vOs = aVar3.BTU.vd();
                    AppMethodBeat.o(81502);
                    return 0;
                case 3:
                    bee.wHN = aVar3.BTU.vd();
                    AppMethodBeat.o(81502);
                    return 0;
                case 4:
                    bee.wHO = aVar3.BTU.emu();
                    AppMethodBeat.o(81502);
                    return 0;
                case 5:
                    bee.wHP = aVar3.BTU.vd();
                    AppMethodBeat.o(81502);
                    return 0;
                case 6:
                    bee.wHQ = aVar3.BTU.emu();
                    AppMethodBeat.o(81502);
                    return 0;
                case 7:
                    bee.wHR = aVar3.BTU.readString();
                    AppMethodBeat.o(81502);
                    return 0;
                case 8:
                    bee.wHS = aVar3.BTU.readString();
                    AppMethodBeat.o(81502);
                    return 0;
                case 9:
                    bee.wHT = aVar3.BTU.readString();
                    AppMethodBeat.o(81502);
                    return 0;
                case 10:
                    bee.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(81502);
                    return 0;
                default:
                    AppMethodBeat.o(81502);
                    return -1;
            }
        } else {
            AppMethodBeat.o(81502);
            return -1;
        }
    }
}
