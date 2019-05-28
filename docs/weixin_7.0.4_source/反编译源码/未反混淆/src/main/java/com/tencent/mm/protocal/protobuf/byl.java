package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class byl extends btd {
    public String cMD;
    public String color;
    public String kbU;
    public String kbV;
    public String kbW;
    public String kbX;
    public int kbZ;
    public int kdC;
    public String kdg;
    public int qsn;
    public int qsq;
    public String qsr;
    public String qss;
    public String qst;
    public String qsu;
    public String qsv;
    public boolean qsw;
    public String title;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28641);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28641);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdC);
            if (this.kbU != null) {
                aVar.e(3, this.kbU);
            }
            if (this.cMD != null) {
                aVar.e(4, this.cMD);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            if (this.kbW != null) {
                aVar.e(6, this.kbW);
            }
            if (this.kbX != null) {
                aVar.e(7, this.kbX);
            }
            if (this.kdg != null) {
                aVar.e(8, this.kdg);
            }
            if (this.kbV != null) {
                aVar.e(9, this.kbV);
            }
            if (this.color != null) {
                aVar.e(10, this.color);
            }
            aVar.iz(11, this.qsn);
            aVar.iz(12, this.qsq);
            if (this.qsr != null) {
                aVar.e(13, this.qsr);
            }
            if (this.qss != null) {
                aVar.e(14, this.qss);
            }
            if (this.qst != null) {
                aVar.e(19, this.qst);
            }
            if (this.qsu != null) {
                aVar.e(21, this.qsu);
            }
            aVar.iz(22, this.kbZ);
            if (this.qsv != null) {
                aVar.e(23, this.qsv);
            }
            aVar.aO(24, this.qsw);
            AppMethodBeat.o(28641);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdC);
            if (this.kbU != null) {
                ix += e.a.a.b.b.a.f(3, this.kbU);
            }
            if (this.cMD != null) {
                ix += e.a.a.b.b.a.f(4, this.cMD);
            }
            if (this.title != null) {
                ix += e.a.a.b.b.a.f(5, this.title);
            }
            if (this.kbW != null) {
                ix += e.a.a.b.b.a.f(6, this.kbW);
            }
            if (this.kbX != null) {
                ix += e.a.a.b.b.a.f(7, this.kbX);
            }
            if (this.kdg != null) {
                ix += e.a.a.b.b.a.f(8, this.kdg);
            }
            if (this.kbV != null) {
                ix += e.a.a.b.b.a.f(9, this.kbV);
            }
            if (this.color != null) {
                ix += e.a.a.b.b.a.f(10, this.color);
            }
            ix = (ix + e.a.a.b.b.a.bs(11, this.qsn)) + e.a.a.b.b.a.bs(12, this.qsq);
            if (this.qsr != null) {
                ix += e.a.a.b.b.a.f(13, this.qsr);
            }
            if (this.qss != null) {
                ix += e.a.a.b.b.a.f(14, this.qss);
            }
            if (this.qst != null) {
                ix += e.a.a.b.b.a.f(19, this.qst);
            }
            if (this.qsu != null) {
                ix += e.a.a.b.b.a.f(21, this.qsu);
            }
            ix += e.a.a.b.b.a.bs(22, this.kbZ);
            if (this.qsv != null) {
                ix += e.a.a.b.b.a.f(23, this.qsv);
            }
            int fv = ix + (e.a.a.b.b.a.fv(24) + 1);
            AppMethodBeat.o(28641);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28641);
                throw bVar;
            }
            AppMethodBeat.o(28641);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byl byl = (byl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28641);
                    return 0;
                case 2:
                    byl.kdC = aVar3.BTU.vd();
                    AppMethodBeat.o(28641);
                    return 0;
                case 3:
                    byl.kbU = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 4:
                    byl.cMD = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 5:
                    byl.title = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 6:
                    byl.kbW = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 7:
                    byl.kbX = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 8:
                    byl.kdg = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 9:
                    byl.kbV = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 10:
                    byl.color = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 11:
                    byl.qsn = aVar3.BTU.vd();
                    AppMethodBeat.o(28641);
                    return 0;
                case 12:
                    byl.qsq = aVar3.BTU.vd();
                    AppMethodBeat.o(28641);
                    return 0;
                case 13:
                    byl.qsr = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 14:
                    byl.qss = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 19:
                    byl.qst = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 21:
                    byl.qsu = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 22:
                    byl.kbZ = aVar3.BTU.vd();
                    AppMethodBeat.o(28641);
                    return 0;
                case 23:
                    byl.qsv = aVar3.BTU.readString();
                    AppMethodBeat.o(28641);
                    return 0;
                case 24:
                    byl.qsw = aVar3.BTU.ehX();
                    AppMethodBeat.o(28641);
                    return 0;
                default:
                    AppMethodBeat.o(28641);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28641);
            return -1;
        }
    }
}
