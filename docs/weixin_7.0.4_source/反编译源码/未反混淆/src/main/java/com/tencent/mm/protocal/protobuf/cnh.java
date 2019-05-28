package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cnh extends bsr {
    public int vIJ;
    public SKBuiltinBuffer_t vIl;
    public String wsM;
    public int xkM;
    public LinkedList<cnf> xkN = new LinkedList();
    public int xkO;
    public LinkedList<Integer> xkP = new LinkedList();
    public int xkQ;
    public LinkedList<cng> xkR = new LinkedList();

    public cnh() {
        AppMethodBeat.i(80209);
        AppMethodBeat.o(80209);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80210);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vIJ);
            aVar.iz(3, this.xkM);
            aVar.e(4, 8, this.xkN);
            if (this.wsM != null) {
                aVar.e(5, this.wsM);
            }
            aVar.iz(6, this.xkO);
            aVar.f(7, 2, this.xkP);
            aVar.iz(8, this.xkQ);
            aVar.e(9, 8, this.xkR);
            if (this.vIl != null) {
                aVar.iy(10, this.vIl.computeSize());
                this.vIl.writeFields(aVar);
            }
            AppMethodBeat.o(80210);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.vIJ)) + e.a.a.b.b.a.bs(3, this.xkM)) + e.a.a.a.c(4, 8, this.xkN);
            if (this.wsM != null) {
                ix += e.a.a.b.b.a.f(5, this.wsM);
            }
            ix = (((ix + e.a.a.b.b.a.bs(6, this.xkO)) + e.a.a.a.d(7, 2, this.xkP)) + e.a.a.b.b.a.bs(8, this.xkQ)) + e.a.a.a.c(9, 8, this.xkR);
            if (this.vIl != null) {
                ix += e.a.a.a.ix(10, this.vIl.computeSize());
            }
            AppMethodBeat.o(80210);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xkN.clear();
            this.xkP.clear();
            this.xkR.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80210);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cnh cnh = (cnh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cnh.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80210);
                    return 0;
                case 2:
                    cnh.vIJ = aVar3.BTU.vd();
                    AppMethodBeat.o(80210);
                    return 0;
                case 3:
                    cnh.xkM = aVar3.BTU.vd();
                    AppMethodBeat.o(80210);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnf cnf = new cnf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnf.populateBuilderWithField(aVar4, cnf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cnh.xkN.add(cnf);
                    }
                    AppMethodBeat.o(80210);
                    return 0;
                case 5:
                    cnh.wsM = aVar3.BTU.readString();
                    AppMethodBeat.o(80210);
                    return 0;
                case 6:
                    cnh.xkO = aVar3.BTU.vd();
                    AppMethodBeat.o(80210);
                    return 0;
                case 7:
                    cnh.xkP = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(80210);
                    return 0;
                case 8:
                    cnh.xkQ = aVar3.BTU.vd();
                    AppMethodBeat.o(80210);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cng cng = new cng();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cng.populateBuilderWithField(aVar4, cng, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cnh.xkR.add(cng);
                    }
                    AppMethodBeat.o(80210);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cnh.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80210);
                    return 0;
                default:
                    AppMethodBeat.o(80210);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80210);
            return -1;
        }
    }
}
