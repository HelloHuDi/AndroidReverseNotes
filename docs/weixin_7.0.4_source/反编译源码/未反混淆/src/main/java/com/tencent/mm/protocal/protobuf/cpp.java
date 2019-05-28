package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cpp extends bsr {
    public int vZF;
    public int wOQ;
    public String wPm;
    public int wem;
    public long wen;
    public int xcr;
    public cpx xlM;
    public cpx xlN;
    public long xlQ;
    public int xlR;
    public int xmL;
    public int xmW;
    public LinkedList<bts> xmX = new LinkedList();
    public int xmY;

    public cpp() {
        AppMethodBeat.i(5249);
        AppMethodBeat.o(5249);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5250);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xlM == null) {
                bVar = new b("Not all required fields were included: PeerId");
                AppMethodBeat.o(5250);
                throw bVar;
            } else if (this.xlN == null) {
                bVar = new b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(5250);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.wPm != null) {
                    aVar.e(2, this.wPm);
                }
                aVar.iz(3, this.xmW);
                aVar.e(4, 8, this.xmX);
                if (this.xlM != null) {
                    aVar.iy(6, this.xlM.computeSize());
                    this.xlM.writeFields(aVar);
                }
                if (this.xlN != null) {
                    aVar.iy(7, this.xlN.computeSize());
                    this.xlN.writeFields(aVar);
                }
                aVar.iz(8, this.vZF);
                aVar.iz(9, this.xcr);
                aVar.iz(10, this.wem);
                aVar.ai(11, this.wen);
                aVar.iz(12, this.xmL);
                aVar.ai(13, this.xlQ);
                aVar.iz(14, this.xmY);
                aVar.iz(15, this.wOQ);
                aVar.iz(16, this.xlR);
                AppMethodBeat.o(5250);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPm != null) {
                ix += e.a.a.b.b.a.f(2, this.wPm);
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.xmW)) + e.a.a.a.c(4, 8, this.xmX);
            if (this.xlM != null) {
                ix += e.a.a.a.ix(6, this.xlM.computeSize());
            }
            if (this.xlN != null) {
                ix += e.a.a.a.ix(7, this.xlN.computeSize());
            }
            int bs = ((((((((ix + e.a.a.b.b.a.bs(8, this.vZF)) + e.a.a.b.b.a.bs(9, this.xcr)) + e.a.a.b.b.a.bs(10, this.wem)) + e.a.a.b.b.a.o(11, this.wen)) + e.a.a.b.b.a.bs(12, this.xmL)) + e.a.a.b.b.a.o(13, this.xlQ)) + e.a.a.b.b.a.bs(14, this.xmY)) + e.a.a.b.b.a.bs(15, this.wOQ)) + e.a.a.b.b.a.bs(16, this.xlR);
            AppMethodBeat.o(5250);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xmX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xlM == null) {
                bVar = new b("Not all required fields were included: PeerId");
                AppMethodBeat.o(5250);
                throw bVar;
            } else if (this.xlN == null) {
                bVar = new b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(5250);
                throw bVar;
            } else {
                AppMethodBeat.o(5250);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpp cpp = (cpp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            cpx cpx;
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
                        cpp.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5250);
                    return 0;
                case 2:
                    cpp.wPm = aVar3.BTU.readString();
                    AppMethodBeat.o(5250);
                    return 0;
                case 3:
                    cpp.xmW = aVar3.BTU.vd();
                    AppMethodBeat.o(5250);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpp.xmX.add(bts);
                    }
                    AppMethodBeat.o(5250);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(aVar4, cpx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpp.xlM = cpx;
                    }
                    AppMethodBeat.o(5250);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(aVar4, cpx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpp.xlN = cpx;
                    }
                    AppMethodBeat.o(5250);
                    return 0;
                case 8:
                    cpp.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(5250);
                    return 0;
                case 9:
                    cpp.xcr = aVar3.BTU.vd();
                    AppMethodBeat.o(5250);
                    return 0;
                case 10:
                    cpp.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5250);
                    return 0;
                case 11:
                    cpp.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5250);
                    return 0;
                case 12:
                    cpp.xmL = aVar3.BTU.vd();
                    AppMethodBeat.o(5250);
                    return 0;
                case 13:
                    cpp.xlQ = aVar3.BTU.ve();
                    AppMethodBeat.o(5250);
                    return 0;
                case 14:
                    cpp.xmY = aVar3.BTU.vd();
                    AppMethodBeat.o(5250);
                    return 0;
                case 15:
                    cpp.wOQ = aVar3.BTU.vd();
                    AppMethodBeat.o(5250);
                    return 0;
                case 16:
                    cpp.xlR = aVar3.BTU.vd();
                    AppMethodBeat.o(5250);
                    return 0;
                default:
                    AppMethodBeat.o(5250);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5250);
            return -1;
        }
    }
}
