package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ma extends bsr {
    public String token;
    public chl vPH;
    public String vPI;
    public int vPV;
    public cz vPn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56731);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vPH == null) {
                bVar = new b("Not all required fields were included: tock_mess");
                AppMethodBeat.o(56731);
                throw bVar;
            } else if (this.vPn == null) {
                bVar = new b("Not all required fields were included: after_placeorder_comm_req");
                AppMethodBeat.o(56731);
                throw bVar;
            } else if (this.token == null) {
                bVar = new b("Not all required fields were included: token");
                AppMethodBeat.o(56731);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.vPH != null) {
                    aVar.iy(2, this.vPH.computeSize());
                    this.vPH.writeFields(aVar);
                }
                if (this.vPn != null) {
                    aVar.iy(3, this.vPn.computeSize());
                    this.vPn.writeFields(aVar);
                }
                if (this.vPI != null) {
                    aVar.e(4, this.vPI);
                }
                aVar.iz(5, this.vPV);
                if (this.token != null) {
                    aVar.e(6, this.token);
                }
                AppMethodBeat.o(56731);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vPH != null) {
                ix += e.a.a.a.ix(2, this.vPH.computeSize());
            }
            if (this.vPn != null) {
                ix += e.a.a.a.ix(3, this.vPn.computeSize());
            }
            if (this.vPI != null) {
                ix += e.a.a.b.b.a.f(4, this.vPI);
            }
            ix += e.a.a.b.b.a.bs(5, this.vPV);
            if (this.token != null) {
                ix += e.a.a.b.b.a.f(6, this.token);
            }
            AppMethodBeat.o(56731);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vPH == null) {
                bVar = new b("Not all required fields were included: tock_mess");
                AppMethodBeat.o(56731);
                throw bVar;
            } else if (this.vPn == null) {
                bVar = new b("Not all required fields were included: after_placeorder_comm_req");
                AppMethodBeat.o(56731);
                throw bVar;
            } else if (this.token == null) {
                bVar = new b("Not all required fields were included: token");
                AppMethodBeat.o(56731);
                throw bVar;
            } else {
                AppMethodBeat.o(56731);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ma maVar = (ma) objArr[1];
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
                        maVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56731);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chl chl = new chl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chl.populateBuilderWithField(aVar4, chl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        maVar.vPH = chl;
                    }
                    AppMethodBeat.o(56731);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cz czVar = new cz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = czVar.populateBuilderWithField(aVar4, czVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        maVar.vPn = czVar;
                    }
                    AppMethodBeat.o(56731);
                    return 0;
                case 4:
                    maVar.vPI = aVar3.BTU.readString();
                    AppMethodBeat.o(56731);
                    return 0;
                case 5:
                    maVar.vPV = aVar3.BTU.vd();
                    AppMethodBeat.o(56731);
                    return 0;
                case 6:
                    maVar.token = aVar3.BTU.readString();
                    AppMethodBeat.o(56731);
                    return 0;
                default:
                    AppMethodBeat.o(56731);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56731);
            return -1;
        }
    }
}
