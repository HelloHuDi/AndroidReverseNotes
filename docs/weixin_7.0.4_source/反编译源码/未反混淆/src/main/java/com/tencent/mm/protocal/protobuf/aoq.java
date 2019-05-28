package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aoq extends bsr {
    public String jCH;
    public String luQ;
    public String vIj;
    public SKBuiltinBuffer_t vLz;
    public String wsI;
    public String wsJ;
    public String wsK;
    public String wsL;
    public String wsM;
    public int wsN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73716);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vLz == null) {
                bVar = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(73716);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vLz != null) {
                aVar.iy(2, this.vLz.computeSize());
                this.vLz.writeFields(aVar);
            }
            if (this.wsI != null) {
                aVar.e(3, this.wsI);
            }
            if (this.wsJ != null) {
                aVar.e(4, this.wsJ);
            }
            if (this.jCH != null) {
                aVar.e(5, this.jCH);
            }
            if (this.wsK != null) {
                aVar.e(6, this.wsK);
            }
            if (this.wsL != null) {
                aVar.e(7, this.wsL);
            }
            if (this.wsM != null) {
                aVar.e(8, this.wsM);
            }
            aVar.iz(9, this.wsN);
            if (this.luQ != null) {
                aVar.e(10, this.luQ);
            }
            if (this.vIj != null) {
                aVar.e(11, this.vIj);
            }
            AppMethodBeat.o(73716);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vLz != null) {
                ix += e.a.a.a.ix(2, this.vLz.computeSize());
            }
            if (this.wsI != null) {
                ix += e.a.a.b.b.a.f(3, this.wsI);
            }
            if (this.wsJ != null) {
                ix += e.a.a.b.b.a.f(4, this.wsJ);
            }
            if (this.jCH != null) {
                ix += e.a.a.b.b.a.f(5, this.jCH);
            }
            if (this.wsK != null) {
                ix += e.a.a.b.b.a.f(6, this.wsK);
            }
            if (this.wsL != null) {
                ix += e.a.a.b.b.a.f(7, this.wsL);
            }
            if (this.wsM != null) {
                ix += e.a.a.b.b.a.f(8, this.wsM);
            }
            ix += e.a.a.b.b.a.bs(9, this.wsN);
            if (this.luQ != null) {
                ix += e.a.a.b.b.a.f(10, this.luQ);
            }
            if (this.vIj != null) {
                ix += e.a.a.b.b.a.f(11, this.vIj);
            }
            AppMethodBeat.o(73716);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vLz == null) {
                bVar = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(73716);
                throw bVar;
            }
            AppMethodBeat.o(73716);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aoq aoq = (aoq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        aoq.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(73716);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aoq.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(73716);
                    return 0;
                case 3:
                    aoq.wsI = aVar3.BTU.readString();
                    AppMethodBeat.o(73716);
                    return 0;
                case 4:
                    aoq.wsJ = aVar3.BTU.readString();
                    AppMethodBeat.o(73716);
                    return 0;
                case 5:
                    aoq.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(73716);
                    return 0;
                case 6:
                    aoq.wsK = aVar3.BTU.readString();
                    AppMethodBeat.o(73716);
                    return 0;
                case 7:
                    aoq.wsL = aVar3.BTU.readString();
                    AppMethodBeat.o(73716);
                    return 0;
                case 8:
                    aoq.wsM = aVar3.BTU.readString();
                    AppMethodBeat.o(73716);
                    return 0;
                case 9:
                    aoq.wsN = aVar3.BTU.vd();
                    AppMethodBeat.o(73716);
                    return 0;
                case 10:
                    aoq.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(73716);
                    return 0;
                case 11:
                    aoq.vIj = aVar3.BTU.readString();
                    AppMethodBeat.o(73716);
                    return 0;
                default:
                    AppMethodBeat.o(73716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73716);
            return -1;
        }
    }
}
