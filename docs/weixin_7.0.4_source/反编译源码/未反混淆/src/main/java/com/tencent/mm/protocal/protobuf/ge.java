package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ge extends bsr {
    public String guQ;
    public String jBF;
    public String luP;
    public String luQ;
    public String nqc;
    public int vAM;
    public SKBuiltinBuffer_t vHH;
    public hh vIg;
    public String vIh;
    public int vIi;
    public String vIj;
    public String vIk;
    public SKBuiltinBuffer_t vIl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58887);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vHH == null) {
                bVar = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(58887);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vIg != null) {
                aVar.iy(2, this.vIg.computeSize());
                this.vIg.writeFields(aVar);
            }
            if (this.vHH != null) {
                aVar.iy(3, this.vHH.computeSize());
                this.vHH.writeFields(aVar);
            }
            if (this.nqc != null) {
                aVar.e(4, this.nqc);
            }
            if (this.vIh != null) {
                aVar.e(5, this.vIh);
            }
            aVar.iz(6, this.vIi);
            if (this.vIj != null) {
                aVar.e(7, this.vIj);
            }
            if (this.guQ != null) {
                aVar.e(8, this.guQ);
            }
            if (this.jBF != null) {
                aVar.e(9, this.jBF);
            }
            if (this.vIk != null) {
                aVar.e(10, this.vIk);
            }
            if (this.luQ != null) {
                aVar.e(11, this.luQ);
            }
            if (this.luP != null) {
                aVar.e(12, this.luP);
            }
            aVar.iz(13, this.vAM);
            if (this.vIl != null) {
                aVar.iy(14, this.vIl.computeSize());
                this.vIl.writeFields(aVar);
            }
            AppMethodBeat.o(58887);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vIg != null) {
                ix += e.a.a.a.ix(2, this.vIg.computeSize());
            }
            if (this.vHH != null) {
                ix += e.a.a.a.ix(3, this.vHH.computeSize());
            }
            if (this.nqc != null) {
                ix += e.a.a.b.b.a.f(4, this.nqc);
            }
            if (this.vIh != null) {
                ix += e.a.a.b.b.a.f(5, this.vIh);
            }
            ix += e.a.a.b.b.a.bs(6, this.vIi);
            if (this.vIj != null) {
                ix += e.a.a.b.b.a.f(7, this.vIj);
            }
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(8, this.guQ);
            }
            if (this.jBF != null) {
                ix += e.a.a.b.b.a.f(9, this.jBF);
            }
            if (this.vIk != null) {
                ix += e.a.a.b.b.a.f(10, this.vIk);
            }
            if (this.luQ != null) {
                ix += e.a.a.b.b.a.f(11, this.luQ);
            }
            if (this.luP != null) {
                ix += e.a.a.b.b.a.f(12, this.luP);
            }
            ix += e.a.a.b.b.a.bs(13, this.vAM);
            if (this.vIl != null) {
                ix += e.a.a.a.ix(14, this.vIl.computeSize());
            }
            AppMethodBeat.o(58887);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vHH == null) {
                bVar = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(58887);
                throw bVar;
            }
            AppMethodBeat.o(58887);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ge geVar = (ge) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        geVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(58887);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hh hhVar = new hh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hhVar.populateBuilderWithField(aVar4, hhVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        geVar.vIg = hhVar;
                    }
                    AppMethodBeat.o(58887);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        geVar.vHH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58887);
                    return 0;
                case 4:
                    geVar.nqc = aVar3.BTU.readString();
                    AppMethodBeat.o(58887);
                    return 0;
                case 5:
                    geVar.vIh = aVar3.BTU.readString();
                    AppMethodBeat.o(58887);
                    return 0;
                case 6:
                    geVar.vIi = aVar3.BTU.vd();
                    AppMethodBeat.o(58887);
                    return 0;
                case 7:
                    geVar.vIj = aVar3.BTU.readString();
                    AppMethodBeat.o(58887);
                    return 0;
                case 8:
                    geVar.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(58887);
                    return 0;
                case 9:
                    geVar.jBF = aVar3.BTU.readString();
                    AppMethodBeat.o(58887);
                    return 0;
                case 10:
                    geVar.vIk = aVar3.BTU.readString();
                    AppMethodBeat.o(58887);
                    return 0;
                case 11:
                    geVar.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(58887);
                    return 0;
                case 12:
                    geVar.luP = aVar3.BTU.readString();
                    AppMethodBeat.o(58887);
                    return 0;
                case 13:
                    geVar.vAM = aVar3.BTU.vd();
                    AppMethodBeat.o(58887);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        geVar.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58887);
                    return 0;
                default:
                    AppMethodBeat.o(58887);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58887);
            return -1;
        }
    }
}
