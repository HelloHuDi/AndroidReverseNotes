package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bh extends bsr {
    public String bssid;
    public int cvd;
    public String qEg;
    public int scene;
    public String ssid;
    public b vDA;
    public b vDB;
    public int vDs;
    public String vDt;
    public long vDu;
    public bt vDv;
    public int vDw;
    public int vDx;
    public String vDy;
    public int vDz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94491);
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
            aVar.iz(3, this.vDs);
            if (this.vDt != null) {
                aVar.e(4, this.vDt);
            }
            aVar.iz(5, this.scene);
            if (this.ssid != null) {
                aVar.e(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(7, this.bssid);
            }
            aVar.ai(8, this.vDu);
            if (this.vDv != null) {
                aVar.iy(9, this.vDv.computeSize());
                this.vDv.writeFields(aVar);
            }
            aVar.iz(10, this.vDw);
            aVar.iz(11, this.vDx);
            aVar.iz(12, this.cvd);
            if (this.vDy != null) {
                aVar.e(13, this.vDy);
            }
            aVar.iz(14, this.vDz);
            if (this.vDA != null) {
                aVar.c(15, this.vDA);
            }
            if (this.vDB != null) {
                aVar.c(16, this.vDB);
            }
            AppMethodBeat.o(94491);
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
            ix += e.a.a.b.b.a.bs(3, this.vDs);
            if (this.vDt != null) {
                ix += e.a.a.b.b.a.f(4, this.vDt);
            }
            ix += e.a.a.b.b.a.bs(5, this.scene);
            if (this.ssid != null) {
                ix += e.a.a.b.b.a.f(6, this.ssid);
            }
            if (this.bssid != null) {
                ix += e.a.a.b.b.a.f(7, this.bssid);
            }
            ix += e.a.a.b.b.a.o(8, this.vDu);
            if (this.vDv != null) {
                ix += e.a.a.a.ix(9, this.vDv.computeSize());
            }
            ix = ((ix + e.a.a.b.b.a.bs(10, this.vDw)) + e.a.a.b.b.a.bs(11, this.vDx)) + e.a.a.b.b.a.bs(12, this.cvd);
            if (this.vDy != null) {
                ix += e.a.a.b.b.a.f(13, this.vDy);
            }
            ix += e.a.a.b.b.a.bs(14, this.vDz);
            if (this.vDA != null) {
                ix += e.a.a.b.b.a.b(15, this.vDA);
            }
            if (this.vDB != null) {
                ix += e.a.a.b.b.a.b(16, this.vDB);
            }
            AppMethodBeat.o(94491);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94491);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bh bhVar = (bh) objArr[1];
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
                        bhVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94491);
                    return 0;
                case 2:
                    bhVar.qEg = aVar3.BTU.readString();
                    AppMethodBeat.o(94491);
                    return 0;
                case 3:
                    bhVar.vDs = aVar3.BTU.vd();
                    AppMethodBeat.o(94491);
                    return 0;
                case 4:
                    bhVar.vDt = aVar3.BTU.readString();
                    AppMethodBeat.o(94491);
                    return 0;
                case 5:
                    bhVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(94491);
                    return 0;
                case 6:
                    bhVar.ssid = aVar3.BTU.readString();
                    AppMethodBeat.o(94491);
                    return 0;
                case 7:
                    bhVar.bssid = aVar3.BTU.readString();
                    AppMethodBeat.o(94491);
                    return 0;
                case 8:
                    bhVar.vDu = aVar3.BTU.ve();
                    AppMethodBeat.o(94491);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bt btVar = new bt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btVar.populateBuilderWithField(aVar4, btVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bhVar.vDv = btVar;
                    }
                    AppMethodBeat.o(94491);
                    return 0;
                case 10:
                    bhVar.vDw = aVar3.BTU.vd();
                    AppMethodBeat.o(94491);
                    return 0;
                case 11:
                    bhVar.vDx = aVar3.BTU.vd();
                    AppMethodBeat.o(94491);
                    return 0;
                case 12:
                    bhVar.cvd = aVar3.BTU.vd();
                    AppMethodBeat.o(94491);
                    return 0;
                case 13:
                    bhVar.vDy = aVar3.BTU.readString();
                    AppMethodBeat.o(94491);
                    return 0;
                case 14:
                    bhVar.vDz = aVar3.BTU.vd();
                    AppMethodBeat.o(94491);
                    return 0;
                case 15:
                    bhVar.vDA = aVar3.BTU.emu();
                    AppMethodBeat.o(94491);
                    return 0;
                case 16:
                    bhVar.vDB = aVar3.BTU.emu();
                    AppMethodBeat.o(94491);
                    return 0;
                default:
                    AppMethodBeat.o(94491);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94491);
            return -1;
        }
    }
}
