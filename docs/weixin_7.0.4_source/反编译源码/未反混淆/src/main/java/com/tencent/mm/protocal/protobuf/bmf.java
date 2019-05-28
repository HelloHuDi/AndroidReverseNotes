package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bmf extends bsr {
    public long wOS;
    public bts wPi;
    public bts wPj;
    public bts wPk;
    public int wPl;
    public int wem;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28589);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wPi == null) {
                bVar = new b("Not all required fields were included: ClientReport");
                AppMethodBeat.o(28589);
                throw bVar;
            } else if (this.wPj == null) {
                bVar = new b("Not all required fields were included: ChannelReport");
                AppMethodBeat.o(28589);
                throw bVar;
            } else if (this.wPk == null) {
                bVar = new b("Not all required fields were included: EngineReport");
                AppMethodBeat.o(28589);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.wPi != null) {
                    aVar.iy(2, this.wPi.computeSize());
                    this.wPi.writeFields(aVar);
                }
                if (this.wPj != null) {
                    aVar.iy(3, this.wPj.computeSize());
                    this.wPj.writeFields(aVar);
                }
                if (this.wPk != null) {
                    aVar.iy(4, this.wPk.computeSize());
                    this.wPk.writeFields(aVar);
                }
                aVar.iz(5, this.wem);
                aVar.ai(6, this.wOS);
                aVar.iz(7, this.wPl);
                AppMethodBeat.o(28589);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPi != null) {
                ix += e.a.a.a.ix(2, this.wPi.computeSize());
            }
            if (this.wPj != null) {
                ix += e.a.a.a.ix(3, this.wPj.computeSize());
            }
            if (this.wPk != null) {
                ix += e.a.a.a.ix(4, this.wPk.computeSize());
            }
            int bs = ((ix + e.a.a.b.b.a.bs(5, this.wem)) + e.a.a.b.b.a.o(6, this.wOS)) + e.a.a.b.b.a.bs(7, this.wPl);
            AppMethodBeat.o(28589);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wPi == null) {
                bVar = new b("Not all required fields were included: ClientReport");
                AppMethodBeat.o(28589);
                throw bVar;
            } else if (this.wPj == null) {
                bVar = new b("Not all required fields were included: ChannelReport");
                AppMethodBeat.o(28589);
                throw bVar;
            } else if (this.wPk == null) {
                bVar = new b("Not all required fields were included: EngineReport");
                AppMethodBeat.o(28589);
                throw bVar;
            } else {
                AppMethodBeat.o(28589);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmf bmf = (bmf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        bmf.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28589);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bmf.wPi = bts;
                    }
                    AppMethodBeat.o(28589);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bmf.wPj = bts;
                    }
                    AppMethodBeat.o(28589);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bmf.wPk = bts;
                    }
                    AppMethodBeat.o(28589);
                    return 0;
                case 5:
                    bmf.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(28589);
                    return 0;
                case 6:
                    bmf.wOS = aVar3.BTU.ve();
                    AppMethodBeat.o(28589);
                    return 0;
                case 7:
                    bmf.wPl = aVar3.BTU.vd();
                    AppMethodBeat.o(28589);
                    return 0;
                default:
                    AppMethodBeat.o(28589);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28589);
            return -1;
        }
    }
}
