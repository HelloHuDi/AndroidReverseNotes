package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class atk extends a {
    public int iAd;
    public String kKZ;
    public int kbK;
    public String kdf;
    public String nSd;
    public String pMg;
    public int state;
    public String vAh;
    public int vNm;
    public String wpp;
    public long wxq;
    public String wxs;
    public int wxu;
    public int wxv;
    public String wxw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48872);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wpp != null) {
                aVar.e(1, this.wpp);
            }
            if (this.vAh != null) {
                aVar.e(2, this.vAh);
            }
            aVar.ai(3, this.wxq);
            aVar.iz(4, this.state);
            aVar.iz(5, this.vNm);
            aVar.iz(6, this.kbK);
            aVar.iz(7, this.wxu);
            aVar.iz(8, this.wxv);
            if (this.wxw != null) {
                aVar.e(9, this.wxw);
            }
            if (this.kdf != null) {
                aVar.e(10, this.kdf);
            }
            if (this.nSd != null) {
                aVar.e(11, this.nSd);
            }
            if (this.kKZ != null) {
                aVar.e(12, this.kKZ);
            }
            if (this.pMg != null) {
                aVar.e(13, this.pMg);
            }
            if (this.wxs != null) {
                aVar.e(14, this.wxs);
            }
            aVar.iz(15, this.iAd);
            AppMethodBeat.o(48872);
            return 0;
        } else if (i == 1) {
            if (this.wpp != null) {
                f = e.a.a.b.b.a.f(1, this.wpp) + 0;
            } else {
                f = 0;
            }
            if (this.vAh != null) {
                f += e.a.a.b.b.a.f(2, this.vAh);
            }
            f = (((((f + e.a.a.b.b.a.o(3, this.wxq)) + e.a.a.b.b.a.bs(4, this.state)) + e.a.a.b.b.a.bs(5, this.vNm)) + e.a.a.b.b.a.bs(6, this.kbK)) + e.a.a.b.b.a.bs(7, this.wxu)) + e.a.a.b.b.a.bs(8, this.wxv);
            if (this.wxw != null) {
                f += e.a.a.b.b.a.f(9, this.wxw);
            }
            if (this.kdf != null) {
                f += e.a.a.b.b.a.f(10, this.kdf);
            }
            if (this.nSd != null) {
                f += e.a.a.b.b.a.f(11, this.nSd);
            }
            if (this.kKZ != null) {
                f += e.a.a.b.b.a.f(12, this.kKZ);
            }
            if (this.pMg != null) {
                f += e.a.a.b.b.a.f(13, this.pMg);
            }
            if (this.wxs != null) {
                f += e.a.a.b.b.a.f(14, this.wxs);
            }
            int bs = f + e.a.a.b.b.a.bs(15, this.iAd);
            AppMethodBeat.o(48872);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48872);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atk atk = (atk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atk.wpp = aVar3.BTU.readString();
                    AppMethodBeat.o(48872);
                    return 0;
                case 2:
                    atk.vAh = aVar3.BTU.readString();
                    AppMethodBeat.o(48872);
                    return 0;
                case 3:
                    atk.wxq = aVar3.BTU.ve();
                    AppMethodBeat.o(48872);
                    return 0;
                case 4:
                    atk.state = aVar3.BTU.vd();
                    AppMethodBeat.o(48872);
                    return 0;
                case 5:
                    atk.vNm = aVar3.BTU.vd();
                    AppMethodBeat.o(48872);
                    return 0;
                case 6:
                    atk.kbK = aVar3.BTU.vd();
                    AppMethodBeat.o(48872);
                    return 0;
                case 7:
                    atk.wxu = aVar3.BTU.vd();
                    AppMethodBeat.o(48872);
                    return 0;
                case 8:
                    atk.wxv = aVar3.BTU.vd();
                    AppMethodBeat.o(48872);
                    return 0;
                case 9:
                    atk.wxw = aVar3.BTU.readString();
                    AppMethodBeat.o(48872);
                    return 0;
                case 10:
                    atk.kdf = aVar3.BTU.readString();
                    AppMethodBeat.o(48872);
                    return 0;
                case 11:
                    atk.nSd = aVar3.BTU.readString();
                    AppMethodBeat.o(48872);
                    return 0;
                case 12:
                    atk.kKZ = aVar3.BTU.readString();
                    AppMethodBeat.o(48872);
                    return 0;
                case 13:
                    atk.pMg = aVar3.BTU.readString();
                    AppMethodBeat.o(48872);
                    return 0;
                case 14:
                    atk.wxs = aVar3.BTU.readString();
                    AppMethodBeat.o(48872);
                    return 0;
                case 15:
                    atk.iAd = aVar3.BTU.vd();
                    AppMethodBeat.o(48872);
                    return 0;
                default:
                    AppMethodBeat.o(48872);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48872);
            return -1;
        }
    }
}
