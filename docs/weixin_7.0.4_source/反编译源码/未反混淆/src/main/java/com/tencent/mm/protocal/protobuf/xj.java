package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xj extends bsr {
    public String fKh;
    public String fKk;
    public String jBB;
    public int jCt;
    public long ptF;
    public int ptw;
    public int ptx;
    public int pty;
    public int vFE;
    public String wdi;
    public int wdj;
    public int wdk;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135756);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            aVar.iz(3, this.vFE);
            if (this.fKk != null) {
                aVar.e(4, this.fKk);
            }
            if (this.jBB != null) {
                aVar.e(5, this.jBB);
            }
            aVar.iz(6, this.ptw);
            aVar.iz(7, this.ptx);
            aVar.iz(8, this.pty);
            if (this.wdi != null) {
                aVar.e(9, this.wdi);
            }
            aVar.iz(10, this.wdj);
            aVar.iz(11, this.jCt);
            aVar.iz(12, this.wdk);
            aVar.ai(13, this.ptF);
            AppMethodBeat.o(135756);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(2, this.fKh);
            }
            ix += e.a.a.b.b.a.bs(3, this.vFE);
            if (this.fKk != null) {
                ix += e.a.a.b.b.a.f(4, this.fKk);
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(5, this.jBB);
            }
            ix = ((ix + e.a.a.b.b.a.bs(6, this.ptw)) + e.a.a.b.b.a.bs(7, this.ptx)) + e.a.a.b.b.a.bs(8, this.pty);
            if (this.wdi != null) {
                ix += e.a.a.b.b.a.f(9, this.wdi);
            }
            int bs = (((ix + e.a.a.b.b.a.bs(10, this.wdj)) + e.a.a.b.b.a.bs(11, this.jCt)) + e.a.a.b.b.a.bs(12, this.wdk)) + e.a.a.b.b.a.o(13, this.ptF);
            AppMethodBeat.o(135756);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(135756);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xj xjVar = (xj) objArr[1];
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
                        xjVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(135756);
                    return 0;
                case 2:
                    xjVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(135756);
                    return 0;
                case 3:
                    xjVar.vFE = aVar3.BTU.vd();
                    AppMethodBeat.o(135756);
                    return 0;
                case 4:
                    xjVar.fKk = aVar3.BTU.readString();
                    AppMethodBeat.o(135756);
                    return 0;
                case 5:
                    xjVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(135756);
                    return 0;
                case 6:
                    xjVar.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(135756);
                    return 0;
                case 7:
                    xjVar.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(135756);
                    return 0;
                case 8:
                    xjVar.pty = aVar3.BTU.vd();
                    AppMethodBeat.o(135756);
                    return 0;
                case 9:
                    xjVar.wdi = aVar3.BTU.readString();
                    AppMethodBeat.o(135756);
                    return 0;
                case 10:
                    xjVar.wdj = aVar3.BTU.vd();
                    AppMethodBeat.o(135756);
                    return 0;
                case 11:
                    xjVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(135756);
                    return 0;
                case 12:
                    xjVar.wdk = aVar3.BTU.vd();
                    AppMethodBeat.o(135756);
                    return 0;
                case 13:
                    xjVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(135756);
                    return 0;
                default:
                    AppMethodBeat.o(135756);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135756);
            return -1;
        }
    }
}
