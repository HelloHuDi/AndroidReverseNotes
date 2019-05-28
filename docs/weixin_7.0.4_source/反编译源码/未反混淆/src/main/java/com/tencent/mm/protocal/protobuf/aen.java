package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aen extends bsr {
    public String app_id;
    public String kbU;
    public b keu;
    public int kmq;
    public String kmr;
    public String kms;
    public String kmt;
    public String kmu;
    public int time_stamp;
    public int wmp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89067);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.app_id != null) {
                aVar.e(2, this.app_id);
            }
            aVar.iz(3, this.kmq);
            if (this.kmr != null) {
                aVar.e(4, this.kmr);
            }
            if (this.kms != null) {
                aVar.e(5, this.kms);
            }
            aVar.iz(6, this.time_stamp);
            if (this.kmt != null) {
                aVar.e(7, this.kmt);
            }
            if (this.kbU != null) {
                aVar.e(8, this.kbU);
            }
            if (this.kmu != null) {
                aVar.e(9, this.kmu);
            }
            if (this.keu != null) {
                aVar.c(10, this.keu);
            }
            aVar.iz(11, this.wmp);
            AppMethodBeat.o(89067);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.app_id != null) {
                ix += e.a.a.b.b.a.f(2, this.app_id);
            }
            ix += e.a.a.b.b.a.bs(3, this.kmq);
            if (this.kmr != null) {
                ix += e.a.a.b.b.a.f(4, this.kmr);
            }
            if (this.kms != null) {
                ix += e.a.a.b.b.a.f(5, this.kms);
            }
            ix += e.a.a.b.b.a.bs(6, this.time_stamp);
            if (this.kmt != null) {
                ix += e.a.a.b.b.a.f(7, this.kmt);
            }
            if (this.kbU != null) {
                ix += e.a.a.b.b.a.f(8, this.kbU);
            }
            if (this.kmu != null) {
                ix += e.a.a.b.b.a.f(9, this.kmu);
            }
            if (this.keu != null) {
                ix += e.a.a.b.b.a.b(10, this.keu);
            }
            int bs = ix + e.a.a.b.b.a.bs(11, this.wmp);
            AppMethodBeat.o(89067);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89067);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aen aen = (aen) objArr[1];
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
                        aen.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(89067);
                    return 0;
                case 2:
                    aen.app_id = aVar3.BTU.readString();
                    AppMethodBeat.o(89067);
                    return 0;
                case 3:
                    aen.kmq = aVar3.BTU.vd();
                    AppMethodBeat.o(89067);
                    return 0;
                case 4:
                    aen.kmr = aVar3.BTU.readString();
                    AppMethodBeat.o(89067);
                    return 0;
                case 5:
                    aen.kms = aVar3.BTU.readString();
                    AppMethodBeat.o(89067);
                    return 0;
                case 6:
                    aen.time_stamp = aVar3.BTU.vd();
                    AppMethodBeat.o(89067);
                    return 0;
                case 7:
                    aen.kmt = aVar3.BTU.readString();
                    AppMethodBeat.o(89067);
                    return 0;
                case 8:
                    aen.kbU = aVar3.BTU.readString();
                    AppMethodBeat.o(89067);
                    return 0;
                case 9:
                    aen.kmu = aVar3.BTU.readString();
                    AppMethodBeat.o(89067);
                    return 0;
                case 10:
                    aen.keu = aVar3.BTU.emu();
                    AppMethodBeat.o(89067);
                    return 0;
                case 11:
                    aen.wmp = aVar3.BTU.vd();
                    AppMethodBeat.o(89067);
                    return 0;
                default:
                    AppMethodBeat.o(89067);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89067);
            return -1;
        }
    }
}
