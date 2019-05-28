package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cqb extends bsr {
    public double vNH;
    public double vNI;
    public int vZF;
    public int wem;
    public long wen;
    public LinkedList<ccw> wpo = new LinkedList();
    public long xod;
    public bts xoe;
    public bts xof;
    public int xog;

    public cqb() {
        AppMethodBeat.i(5267);
        AppMethodBeat.o(5267);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5268);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xoe == null) {
                bVar = new b("Not all required fields were included: NetName");
                AppMethodBeat.o(5268);
                throw bVar;
            } else if (this.xof == null) {
                bVar = new b("Not all required fields were included: WifiName");
                AppMethodBeat.o(5268);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                aVar.ai(2, this.xod);
                aVar.ai(3, this.wen);
                aVar.iz(4, this.vZF);
                if (this.xoe != null) {
                    aVar.iy(5, this.xoe.computeSize());
                    this.xoe.writeFields(aVar);
                }
                if (this.xof != null) {
                    aVar.iy(6, this.xof.computeSize());
                    this.xof.writeFields(aVar);
                }
                aVar.f(7, this.vNH);
                aVar.f(8, this.vNI);
                aVar.iz(9, this.wem);
                aVar.iz(10, this.xog);
                aVar.e(11, 8, this.wpo);
                AppMethodBeat.o(5268);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.o(2, this.xod)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.b.b.a.bs(4, this.vZF);
            if (this.xoe != null) {
                ix += e.a.a.a.ix(5, this.xoe.computeSize());
            }
            if (this.xof != null) {
                ix += e.a.a.a.ix(6, this.xof.computeSize());
            }
            int fv = ((((ix + (e.a.a.b.b.a.fv(7) + 8)) + (e.a.a.b.b.a.fv(8) + 8)) + e.a.a.b.b.a.bs(9, this.wem)) + e.a.a.b.b.a.bs(10, this.xog)) + e.a.a.a.c(11, 8, this.wpo);
            AppMethodBeat.o(5268);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xoe == null) {
                bVar = new b("Not all required fields were included: NetName");
                AppMethodBeat.o(5268);
                throw bVar;
            } else if (this.xof == null) {
                bVar = new b("Not all required fields were included: WifiName");
                AppMethodBeat.o(5268);
                throw bVar;
            } else {
                AppMethodBeat.o(5268);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cqb cqb = (cqb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
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
                        cqb.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5268);
                    return 0;
                case 2:
                    cqb.xod = aVar3.BTU.ve();
                    AppMethodBeat.o(5268);
                    return 0;
                case 3:
                    cqb.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5268);
                    return 0;
                case 4:
                    cqb.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(5268);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqb.xoe = bts;
                    }
                    AppMethodBeat.o(5268);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqb.xof = bts;
                    }
                    AppMethodBeat.o(5268);
                    return 0;
                case 7:
                    cqb.vNH = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(5268);
                    return 0;
                case 8:
                    cqb.vNI = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(5268);
                    return 0;
                case 9:
                    cqb.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5268);
                    return 0;
                case 10:
                    cqb.xog = aVar3.BTU.vd();
                    AppMethodBeat.o(5268);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccw ccw = new ccw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccw.populateBuilderWithField(aVar4, ccw, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqb.wpo.add(ccw);
                    }
                    AppMethodBeat.o(5268);
                    return 0;
                default:
                    AppMethodBeat.o(5268);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5268);
            return -1;
        }
    }
}
