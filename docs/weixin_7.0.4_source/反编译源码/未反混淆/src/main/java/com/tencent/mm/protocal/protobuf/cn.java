package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cn extends a {
    public int nao;
    public int pcX;
    public long ptF;
    public int vEI;
    public bts vEJ;
    public int vEK;
    public bts vEL;
    public int vEM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58885);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEJ == null) {
                bVar = new b("Not all required fields were included: ChatRoomId");
                AppMethodBeat.o(58885);
                throw bVar;
            } else if (this.vEL == null) {
                bVar = new b("Not all required fields were included: DigestContent");
                AppMethodBeat.o(58885);
                throw bVar;
            } else {
                if (this.vEJ != null) {
                    aVar.iy(1, this.vEJ.computeSize());
                    this.vEJ.writeFields(aVar);
                }
                aVar.ai(2, this.ptF);
                aVar.iz(3, this.vEI);
                aVar.iz(4, this.pcX);
                aVar.iz(5, this.vEK);
                if (this.vEL != null) {
                    aVar.iy(6, this.vEL.computeSize());
                    this.vEL.writeFields(aVar);
                }
                aVar.iz(7, this.vEM);
                aVar.iz(8, this.nao);
                AppMethodBeat.o(58885);
                return 0;
            }
        } else if (i == 1) {
            if (this.vEJ != null) {
                ix = e.a.a.a.ix(1, this.vEJ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((ix + e.a.a.b.b.a.o(2, this.ptF)) + e.a.a.b.b.a.bs(3, this.vEI)) + e.a.a.b.b.a.bs(4, this.pcX)) + e.a.a.b.b.a.bs(5, this.vEK);
            if (this.vEL != null) {
                ix += e.a.a.a.ix(6, this.vEL.computeSize());
            }
            int bs = (ix + e.a.a.b.b.a.bs(7, this.vEM)) + e.a.a.b.b.a.bs(8, this.nao);
            AppMethodBeat.o(58885);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vEJ == null) {
                bVar = new b("Not all required fields were included: ChatRoomId");
                AppMethodBeat.o(58885);
                throw bVar;
            } else if (this.vEL == null) {
                bVar = new b("Not all required fields were included: DigestContent");
                AppMethodBeat.o(58885);
                throw bVar;
            } else {
                AppMethodBeat.o(58885);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cn cnVar = (cn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cnVar.vEJ = bts;
                    }
                    AppMethodBeat.o(58885);
                    return 0;
                case 2:
                    cnVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(58885);
                    return 0;
                case 3:
                    cnVar.vEI = aVar3.BTU.vd();
                    AppMethodBeat.o(58885);
                    return 0;
                case 4:
                    cnVar.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(58885);
                    return 0;
                case 5:
                    cnVar.vEK = aVar3.BTU.vd();
                    AppMethodBeat.o(58885);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cnVar.vEL = bts;
                    }
                    AppMethodBeat.o(58885);
                    return 0;
                case 7:
                    cnVar.vEM = aVar3.BTU.vd();
                    AppMethodBeat.o(58885);
                    return 0;
                case 8:
                    cnVar.nao = aVar3.BTU.vd();
                    AppMethodBeat.o(58885);
                    return 0;
                default:
                    AppMethodBeat.o(58885);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58885);
            return -1;
        }
    }
}
