package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class clk extends bsr {
    public String Md5;
    public String fKh;
    public String fKk;
    public int nao;
    public int ptw;
    public int ptx;
    public int pty;
    public SKBuiltinBuffer_t ptz;
    public String vCs;
    public String vCt;
    public String vCu;
    public bts vEB;
    public bts vEC;
    public String vEG;
    public String vRw;
    public int vRx;
    public int vRy;
    public int vRz;
    public int vZF;
    public int wWT;
    public int wdW;
    public int wqw;
    public String wxW;
    public int xbN;
    public bts xja;
    public String xjb;
    public String xjc;
    public int xjd;
    public int xje;
    public String xjf;
    public int xjg;
    public int xjh;
    public int xji;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80203);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xja == null) {
                bVar = new b("Not all required fields were included: ClientImgId");
                AppMethodBeat.o(80203);
                throw bVar;
            } else if (this.vEB == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(80203);
                throw bVar;
            } else if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(80203);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(80203);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.xja != null) {
                    aVar.iy(2, this.xja.computeSize());
                    this.xja.writeFields(aVar);
                }
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
                if (this.ptz != null) {
                    aVar.iy(8, this.ptz.computeSize());
                    this.ptz.writeFields(aVar);
                }
                aVar.iz(9, this.nao);
                if (this.vEG != null) {
                    aVar.e(10, this.vEG);
                }
                aVar.iz(11, this.wqw);
                aVar.iz(12, this.vZF);
                aVar.iz(13, this.xbN);
                if (this.fKk != null) {
                    aVar.e(14, this.fKk);
                }
                if (this.xjb != null) {
                    aVar.e(15, this.xjb);
                }
                if (this.xjc != null) {
                    aVar.e(16, this.xjc);
                }
                if (this.vRw != null) {
                    aVar.e(17, this.vRw);
                }
                aVar.iz(18, this.vRx);
                aVar.iz(19, this.xjd);
                aVar.iz(20, this.xje);
                if (this.xjf != null) {
                    aVar.e(21, this.xjf);
                }
                aVar.iz(22, this.xjg);
                aVar.iz(23, this.xjh);
                aVar.iz(24, this.xji);
                if (this.wxW != null) {
                    aVar.e(25, this.wxW);
                }
                aVar.iz(26, this.wdW);
                if (this.Md5 != null) {
                    aVar.e(27, this.Md5);
                }
                aVar.iz(28, this.vRy);
                aVar.iz(29, this.vRz);
                aVar.iz(30, this.wWT);
                if (this.fKh != null) {
                    aVar.e(31, this.fKh);
                }
                if (this.vCu != null) {
                    aVar.e(32, this.vCu);
                }
                if (this.vCt != null) {
                    aVar.e(33, this.vCt);
                }
                if (this.vCs != null) {
                    aVar.e(34, this.vCs);
                }
                AppMethodBeat.o(80203);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xja != null) {
                ix += e.a.a.a.ix(2, this.xja.computeSize());
            }
            if (this.vEB != null) {
                ix += e.a.a.a.ix(3, this.vEB.computeSize());
            }
            if (this.vEC != null) {
                ix += e.a.a.a.ix(4, this.vEC.computeSize());
            }
            ix = ((ix + e.a.a.b.b.a.bs(5, this.ptw)) + e.a.a.b.b.a.bs(6, this.ptx)) + e.a.a.b.b.a.bs(7, this.pty);
            if (this.ptz != null) {
                ix += e.a.a.a.ix(8, this.ptz.computeSize());
            }
            ix += e.a.a.b.b.a.bs(9, this.nao);
            if (this.vEG != null) {
                ix += e.a.a.b.b.a.f(10, this.vEG);
            }
            ix = ((ix + e.a.a.b.b.a.bs(11, this.wqw)) + e.a.a.b.b.a.bs(12, this.vZF)) + e.a.a.b.b.a.bs(13, this.xbN);
            if (this.fKk != null) {
                ix += e.a.a.b.b.a.f(14, this.fKk);
            }
            if (this.xjb != null) {
                ix += e.a.a.b.b.a.f(15, this.xjb);
            }
            if (this.xjc != null) {
                ix += e.a.a.b.b.a.f(16, this.xjc);
            }
            if (this.vRw != null) {
                ix += e.a.a.b.b.a.f(17, this.vRw);
            }
            ix = ((ix + e.a.a.b.b.a.bs(18, this.vRx)) + e.a.a.b.b.a.bs(19, this.xjd)) + e.a.a.b.b.a.bs(20, this.xje);
            if (this.xjf != null) {
                ix += e.a.a.b.b.a.f(21, this.xjf);
            }
            ix = ((ix + e.a.a.b.b.a.bs(22, this.xjg)) + e.a.a.b.b.a.bs(23, this.xjh)) + e.a.a.b.b.a.bs(24, this.xji);
            if (this.wxW != null) {
                ix += e.a.a.b.b.a.f(25, this.wxW);
            }
            ix += e.a.a.b.b.a.bs(26, this.wdW);
            if (this.Md5 != null) {
                ix += e.a.a.b.b.a.f(27, this.Md5);
            }
            ix = ((ix + e.a.a.b.b.a.bs(28, this.vRy)) + e.a.a.b.b.a.bs(29, this.vRz)) + e.a.a.b.b.a.bs(30, this.wWT);
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(31, this.fKh);
            }
            if (this.vCu != null) {
                ix += e.a.a.b.b.a.f(32, this.vCu);
            }
            if (this.vCt != null) {
                ix += e.a.a.b.b.a.f(33, this.vCt);
            }
            if (this.vCs != null) {
                ix += e.a.a.b.b.a.f(34, this.vCs);
            }
            AppMethodBeat.o(80203);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xja == null) {
                bVar = new b("Not all required fields were included: ClientImgId");
                AppMethodBeat.o(80203);
                throw bVar;
            } else if (this.vEB == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(80203);
                throw bVar;
            } else if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(80203);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(80203);
                throw bVar;
            } else {
                AppMethodBeat.o(80203);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            clk clk = (clk) objArr[1];
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
                        clk.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80203);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clk.xja = bts;
                    }
                    AppMethodBeat.o(80203);
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
                        clk.vEB = bts;
                    }
                    AppMethodBeat.o(80203);
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
                        clk.vEC = bts;
                    }
                    AppMethodBeat.o(80203);
                    return 0;
                case 5:
                    clk.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 6:
                    clk.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 7:
                    clk.pty = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clk.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80203);
                    return 0;
                case 9:
                    clk.nao = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 10:
                    clk.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case 11:
                    clk.wqw = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 12:
                    clk.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 13:
                    clk.xbN = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 14:
                    clk.fKk = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case 15:
                    clk.xjb = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case 16:
                    clk.xjc = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case 17:
                    clk.vRw = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case 18:
                    clk.vRx = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 19:
                    clk.xjd = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 20:
                    clk.xje = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 21:
                    clk.xjf = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case 22:
                    clk.xjg = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 23:
                    clk.xjh = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 24:
                    clk.xji = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 25:
                    clk.wxW = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case 26:
                    clk.wdW = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 27:
                    clk.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    clk.vRy = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 29:
                    clk.vRz = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 30:
                    clk.wWT = aVar3.BTU.vd();
                    AppMethodBeat.o(80203);
                    return 0;
                case 31:
                    clk.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case 32:
                    clk.vCu = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case 33:
                    clk.vCt = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                case 34:
                    clk.vCs = aVar3.BTU.readString();
                    AppMethodBeat.o(80203);
                    return 0;
                default:
                    AppMethodBeat.o(80203);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80203);
            return -1;
        }
    }
}
