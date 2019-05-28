package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aa extends bsr {
    public int OpCode;
    public String SSID;
    public String URL;
    public String vAI;
    public String vAJ;
    public String vAK;
    public LinkedList<dh> vAL = new LinkedList();
    public int vAM;
    public String vAN;
    public int vAO;
    public String vAP;

    public aa() {
        AppMethodBeat.i(28291);
        AppMethodBeat.o(28291);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28292);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.URL != null) {
                aVar.e(2, this.URL);
            }
            if (this.SSID != null) {
                aVar.e(3, this.SSID);
            }
            if (this.vAI != null) {
                aVar.e(4, this.vAI);
            }
            if (this.vAJ != null) {
                aVar.e(5, this.vAJ);
            }
            if (this.vAK != null) {
                aVar.e(6, this.vAK);
            }
            aVar.iz(7, this.OpCode);
            aVar.e(8, 8, this.vAL);
            aVar.iz(9, this.vAM);
            if (this.vAN != null) {
                aVar.e(10, this.vAN);
            }
            aVar.iz(11, this.vAO);
            if (this.vAP != null) {
                aVar.e(12, this.vAP);
            }
            AppMethodBeat.o(28292);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.URL != null) {
                ix += e.a.a.b.b.a.f(2, this.URL);
            }
            if (this.SSID != null) {
                ix += e.a.a.b.b.a.f(3, this.SSID);
            }
            if (this.vAI != null) {
                ix += e.a.a.b.b.a.f(4, this.vAI);
            }
            if (this.vAJ != null) {
                ix += e.a.a.b.b.a.f(5, this.vAJ);
            }
            if (this.vAK != null) {
                ix += e.a.a.b.b.a.f(6, this.vAK);
            }
            ix = ((ix + e.a.a.b.b.a.bs(7, this.OpCode)) + e.a.a.a.c(8, 8, this.vAL)) + e.a.a.b.b.a.bs(9, this.vAM);
            if (this.vAN != null) {
                ix += e.a.a.b.b.a.f(10, this.vAN);
            }
            ix += e.a.a.b.b.a.bs(11, this.vAO);
            if (this.vAP != null) {
                ix += e.a.a.b.b.a.f(12, this.vAP);
            }
            AppMethodBeat.o(28292);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vAL.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28292);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
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
                        aaVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28292);
                    return 0;
                case 2:
                    aaVar.URL = aVar3.BTU.readString();
                    AppMethodBeat.o(28292);
                    return 0;
                case 3:
                    aaVar.SSID = aVar3.BTU.readString();
                    AppMethodBeat.o(28292);
                    return 0;
                case 4:
                    aaVar.vAI = aVar3.BTU.readString();
                    AppMethodBeat.o(28292);
                    return 0;
                case 5:
                    aaVar.vAJ = aVar3.BTU.readString();
                    AppMethodBeat.o(28292);
                    return 0;
                case 6:
                    aaVar.vAK = aVar3.BTU.readString();
                    AppMethodBeat.o(28292);
                    return 0;
                case 7:
                    aaVar.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(28292);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dh dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.populateBuilderWithField(aVar4, dhVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aaVar.vAL.add(dhVar);
                    }
                    AppMethodBeat.o(28292);
                    return 0;
                case 9:
                    aaVar.vAM = aVar3.BTU.vd();
                    AppMethodBeat.o(28292);
                    return 0;
                case 10:
                    aaVar.vAN = aVar3.BTU.readString();
                    AppMethodBeat.o(28292);
                    return 0;
                case 11:
                    aaVar.vAO = aVar3.BTU.vd();
                    AppMethodBeat.o(28292);
                    return 0;
                case 12:
                    aaVar.vAP = aVar3.BTU.readString();
                    AppMethodBeat.o(28292);
                    return 0;
                default:
                    AppMethodBeat.o(28292);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28292);
            return -1;
        }
    }
}
