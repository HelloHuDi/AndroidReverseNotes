package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class akx extends bsr {
    public int ptD;
    public long ptF;
    public int ptw;
    public int ptx;
    public int pty;
    public bts vEB;
    public bts vEC;
    public int wqw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80075);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vEB == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(80075);
                throw bVar;
            } else if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(80075);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                aVar.iz(2, this.ptD);
                if (this.vEB != null) {
                    aVar.iy(3, this.vEB.computeSize());
                    this.vEB.writeFields(aVar);
                }
                if (this.vEC != null) {
                    aVar.iy(4, this.vEC.computeSize());
                    this.vEC.writeFields(aVar);
                }
                aVar.iz(5, this.ptw);
                aVar.iz(6, this.ptx);
                aVar.iz(7, this.pty);
                aVar.iz(8, this.wqw);
                aVar.ai(9, this.ptF);
                AppMethodBeat.o(80075);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.ptD);
            if (this.vEB != null) {
                ix += e.a.a.a.ix(3, this.vEB.computeSize());
            }
            if (this.vEC != null) {
                ix += e.a.a.a.ix(4, this.vEC.computeSize());
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(5, this.ptw)) + e.a.a.b.b.a.bs(6, this.ptx)) + e.a.a.b.b.a.bs(7, this.pty)) + e.a.a.b.b.a.bs(8, this.wqw)) + e.a.a.b.b.a.o(9, this.ptF);
            AppMethodBeat.o(80075);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vEB == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(80075);
                throw bVar;
            } else if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(80075);
                throw bVar;
            } else {
                AppMethodBeat.o(80075);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            akx akx = (akx) objArr[1];
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
                        akx.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80075);
                    return 0;
                case 2:
                    akx.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(80075);
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
                        akx.vEB = bts;
                    }
                    AppMethodBeat.o(80075);
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
                        akx.vEC = bts;
                    }
                    AppMethodBeat.o(80075);
                    return 0;
                case 5:
                    akx.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(80075);
                    return 0;
                case 6:
                    akx.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(80075);
                    return 0;
                case 7:
                    akx.pty = aVar3.BTU.vd();
                    AppMethodBeat.o(80075);
                    return 0;
                case 8:
                    akx.wqw = aVar3.BTU.vd();
                    AppMethodBeat.o(80075);
                    return 0;
                case 9:
                    akx.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(80075);
                    return 0;
                default:
                    AppMethodBeat.o(80075);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80075);
            return -1;
        }
    }
}
