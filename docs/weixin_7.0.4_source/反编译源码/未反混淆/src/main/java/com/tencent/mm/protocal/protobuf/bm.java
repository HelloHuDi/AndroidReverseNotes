package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bm extends bsr {
    public String bssid;
    public int cvd;
    public String qEg;
    public int scene;
    public String ssid;
    public int type;
    public b vDA;
    public b vDB;
    public int vDK;
    public bl vDL;
    public bo vDM;
    public int vDN;
    public int vDO;
    public int vDP;
    public String vDt;
    public long vDu;
    public int vDw;
    public String vDy;
    public int vDz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94497);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.qEg != null) {
                aVar.e(2, this.qEg);
            }
            aVar.iz(3, this.scene);
            aVar.iz(4, this.type);
            aVar.iz(5, this.vDK);
            if (this.ssid != null) {
                aVar.e(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(7, this.bssid);
            }
            aVar.ai(8, this.vDu);
            if (this.vDL != null) {
                aVar.iy(9, this.vDL.computeSize());
                this.vDL.writeFields(aVar);
            }
            if (this.vDM != null) {
                aVar.iy(10, this.vDM.computeSize());
                this.vDM.writeFields(aVar);
            }
            aVar.iz(11, this.vDw);
            if (this.vDt != null) {
                aVar.e(12, this.vDt);
            }
            aVar.iz(13, this.cvd);
            if (this.vDy != null) {
                aVar.e(14, this.vDy);
            }
            aVar.iz(15, this.vDN);
            aVar.iz(16, this.vDO);
            aVar.iz(17, this.vDP);
            aVar.iz(18, this.vDz);
            if (this.vDA != null) {
                aVar.c(19, this.vDA);
            }
            if (this.vDB != null) {
                aVar.c(20, this.vDB);
            }
            AppMethodBeat.o(94497);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.qEg != null) {
                ix += e.a.a.b.b.a.f(2, this.qEg);
            }
            ix = ((ix + e.a.a.b.b.a.bs(3, this.scene)) + e.a.a.b.b.a.bs(4, this.type)) + e.a.a.b.b.a.bs(5, this.vDK);
            if (this.ssid != null) {
                ix += e.a.a.b.b.a.f(6, this.ssid);
            }
            if (this.bssid != null) {
                ix += e.a.a.b.b.a.f(7, this.bssid);
            }
            ix += e.a.a.b.b.a.o(8, this.vDu);
            if (this.vDL != null) {
                ix += e.a.a.a.ix(9, this.vDL.computeSize());
            }
            if (this.vDM != null) {
                ix += e.a.a.a.ix(10, this.vDM.computeSize());
            }
            ix += e.a.a.b.b.a.bs(11, this.vDw);
            if (this.vDt != null) {
                ix += e.a.a.b.b.a.f(12, this.vDt);
            }
            ix += e.a.a.b.b.a.bs(13, this.cvd);
            if (this.vDy != null) {
                ix += e.a.a.b.b.a.f(14, this.vDy);
            }
            ix = (((ix + e.a.a.b.b.a.bs(15, this.vDN)) + e.a.a.b.b.a.bs(16, this.vDO)) + e.a.a.b.b.a.bs(17, this.vDP)) + e.a.a.b.b.a.bs(18, this.vDz);
            if (this.vDA != null) {
                ix += e.a.a.b.b.a.b(19, this.vDA);
            }
            if (this.vDB != null) {
                ix += e.a.a.b.b.a.b(20, this.vDB);
            }
            AppMethodBeat.o(94497);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94497);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bm bmVar = (bm) objArr[1];
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
                        bmVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94497);
                    return 0;
                case 2:
                    bmVar.qEg = aVar3.BTU.readString();
                    AppMethodBeat.o(94497);
                    return 0;
                case 3:
                    bmVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(94497);
                    return 0;
                case 4:
                    bmVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(94497);
                    return 0;
                case 5:
                    bmVar.vDK = aVar3.BTU.vd();
                    AppMethodBeat.o(94497);
                    return 0;
                case 6:
                    bmVar.ssid = aVar3.BTU.readString();
                    AppMethodBeat.o(94497);
                    return 0;
                case 7:
                    bmVar.bssid = aVar3.BTU.readString();
                    AppMethodBeat.o(94497);
                    return 0;
                case 8:
                    bmVar.vDu = aVar3.BTU.ve();
                    AppMethodBeat.o(94497);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bl blVar = new bl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = blVar.populateBuilderWithField(aVar4, blVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bmVar.vDL = blVar;
                    }
                    AppMethodBeat.o(94497);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bo boVar = new bo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = boVar.populateBuilderWithField(aVar4, boVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bmVar.vDM = boVar;
                    }
                    AppMethodBeat.o(94497);
                    return 0;
                case 11:
                    bmVar.vDw = aVar3.BTU.vd();
                    AppMethodBeat.o(94497);
                    return 0;
                case 12:
                    bmVar.vDt = aVar3.BTU.readString();
                    AppMethodBeat.o(94497);
                    return 0;
                case 13:
                    bmVar.cvd = aVar3.BTU.vd();
                    AppMethodBeat.o(94497);
                    return 0;
                case 14:
                    bmVar.vDy = aVar3.BTU.readString();
                    AppMethodBeat.o(94497);
                    return 0;
                case 15:
                    bmVar.vDN = aVar3.BTU.vd();
                    AppMethodBeat.o(94497);
                    return 0;
                case 16:
                    bmVar.vDO = aVar3.BTU.vd();
                    AppMethodBeat.o(94497);
                    return 0;
                case 17:
                    bmVar.vDP = aVar3.BTU.vd();
                    AppMethodBeat.o(94497);
                    return 0;
                case 18:
                    bmVar.vDz = aVar3.BTU.vd();
                    AppMethodBeat.o(94497);
                    return 0;
                case 19:
                    bmVar.vDA = aVar3.BTU.emu();
                    AppMethodBeat.o(94497);
                    return 0;
                case 20:
                    bmVar.vDB = aVar3.BTU.emu();
                    AppMethodBeat.o(94497);
                    return 0;
                default:
                    AppMethodBeat.o(94497);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94497);
            return -1;
        }
    }
}
