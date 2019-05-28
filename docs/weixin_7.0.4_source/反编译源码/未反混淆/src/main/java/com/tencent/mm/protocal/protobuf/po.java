package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class po extends bsr {
    public int cIb;
    public int nUf;
    public String pPT;
    public String vWG;
    public String vWJ;
    public String vWK;
    public int vWL;
    public String vWM;
    public String vWN;
    public String vWO;
    public String vWP;
    public int vWQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48799);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vWJ == null) {
                bVar = new b("Not all required fields were included: receiver_name");
                AppMethodBeat.o(48799);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vWJ != null) {
                aVar.e(2, this.vWJ);
            }
            aVar.iz(3, this.nUf);
            if (this.vWK != null) {
                aVar.e(4, this.vWK);
            }
            if (this.pPT != null) {
                aVar.e(5, this.pPT);
            }
            aVar.iz(6, this.vWL);
            aVar.iz(7, this.cIb);
            if (this.vWM != null) {
                aVar.e(8, this.vWM);
            }
            if (this.vWG != null) {
                aVar.e(9, this.vWG);
            }
            if (this.vWN != null) {
                aVar.e(10, this.vWN);
            }
            if (this.vWO != null) {
                aVar.e(11, this.vWO);
            }
            if (this.vWP != null) {
                aVar.e(12, this.vWP);
            }
            aVar.iz(13, this.vWQ);
            AppMethodBeat.o(48799);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vWJ != null) {
                ix += e.a.a.b.b.a.f(2, this.vWJ);
            }
            ix += e.a.a.b.b.a.bs(3, this.nUf);
            if (this.vWK != null) {
                ix += e.a.a.b.b.a.f(4, this.vWK);
            }
            if (this.pPT != null) {
                ix += e.a.a.b.b.a.f(5, this.pPT);
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.vWL)) + e.a.a.b.b.a.bs(7, this.cIb);
            if (this.vWM != null) {
                ix += e.a.a.b.b.a.f(8, this.vWM);
            }
            if (this.vWG != null) {
                ix += e.a.a.b.b.a.f(9, this.vWG);
            }
            if (this.vWN != null) {
                ix += e.a.a.b.b.a.f(10, this.vWN);
            }
            if (this.vWO != null) {
                ix += e.a.a.b.b.a.f(11, this.vWO);
            }
            if (this.vWP != null) {
                ix += e.a.a.b.b.a.f(12, this.vWP);
            }
            int bs = ix + e.a.a.b.b.a.bs(13, this.vWQ);
            AppMethodBeat.o(48799);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vWJ == null) {
                bVar = new b("Not all required fields were included: receiver_name");
                AppMethodBeat.o(48799);
                throw bVar;
            }
            AppMethodBeat.o(48799);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            po poVar = (po) objArr[1];
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
                        poVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48799);
                    return 0;
                case 2:
                    poVar.vWJ = aVar3.BTU.readString();
                    AppMethodBeat.o(48799);
                    return 0;
                case 3:
                    poVar.nUf = aVar3.BTU.vd();
                    AppMethodBeat.o(48799);
                    return 0;
                case 4:
                    poVar.vWK = aVar3.BTU.readString();
                    AppMethodBeat.o(48799);
                    return 0;
                case 5:
                    poVar.pPT = aVar3.BTU.readString();
                    AppMethodBeat.o(48799);
                    return 0;
                case 6:
                    poVar.vWL = aVar3.BTU.vd();
                    AppMethodBeat.o(48799);
                    return 0;
                case 7:
                    poVar.cIb = aVar3.BTU.vd();
                    AppMethodBeat.o(48799);
                    return 0;
                case 8:
                    poVar.vWM = aVar3.BTU.readString();
                    AppMethodBeat.o(48799);
                    return 0;
                case 9:
                    poVar.vWG = aVar3.BTU.readString();
                    AppMethodBeat.o(48799);
                    return 0;
                case 10:
                    poVar.vWN = aVar3.BTU.readString();
                    AppMethodBeat.o(48799);
                    return 0;
                case 11:
                    poVar.vWO = aVar3.BTU.readString();
                    AppMethodBeat.o(48799);
                    return 0;
                case 12:
                    poVar.vWP = aVar3.BTU.readString();
                    AppMethodBeat.o(48799);
                    return 0;
                case 13:
                    poVar.vWQ = aVar3.BTU.vd();
                    AppMethodBeat.o(48799);
                    return 0;
                default:
                    AppMethodBeat.o(48799);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48799);
            return -1;
        }
    }
}
