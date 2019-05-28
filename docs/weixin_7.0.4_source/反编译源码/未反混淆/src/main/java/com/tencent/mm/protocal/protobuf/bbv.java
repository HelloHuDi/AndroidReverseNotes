package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import com.tencent.wcdb.FileUtils;
import e.a.a.b;
import java.util.LinkedList;
import org.xwalk.core.XWalkEnvironment;

public final class bbv extends a {
    public String duq;
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public int guR;
    public String guS;
    public int guT;
    public int guU;
    public String guV;
    public String guW;
    public String guX;
    public String ndT;
    public String vEA;
    public SKBuiltinBuffer_t vEF;
    public int vFH;
    public String vXm;
    public String vXn;
    public int wBT;
    public String wBU;
    public String wBV;
    public String wBW;
    public int wBX;
    public ccl wBZ;
    public uy wCa;
    public bts wFK;
    public bts wFL;
    public bts wFM;
    public int wGb;
    public bts wGf;
    public int wGg;
    public int wGh;
    public String wGi;
    public String wGj;
    public String wGk;
    public String wGl;
    public String wGm;
    public String wGn;
    public String wGo;
    public String wGp;
    public cw wGq;
    public int wGr;
    public int wGs;
    public int wGt;
    public int wGu;
    public String wGv;
    public bkg wGw;
    public int wGx;
    public int wGy;
    public int wGz;
    public int wbA;
    public int wbB;
    public LinkedList<btp> wbC = new LinkedList();
    public int wbE;
    public int wbF;
    public int wbu;
    public int wbv;
    public bts wcB;
    public int wcC;
    public String wcD;
    public bts wce;
    public bts wcf;
    public qe wnN;
    public String wsM;
    public bts wyX;

    public bbv() {
        AppMethodBeat.i(60046);
        AppMethodBeat.o(60046);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60047);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(60047);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(60047);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(60047);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(60047);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(60047);
                throw bVar;
            } else {
                if (this.wcB != null) {
                    aVar.iy(1, this.wcB.computeSize());
                    this.wcB.writeFields(aVar);
                }
                if (this.wyX != null) {
                    aVar.iy(2, this.wyX.computeSize());
                    this.wyX.writeFields(aVar);
                }
                if (this.wce != null) {
                    aVar.iy(3, this.wce.computeSize());
                    this.wce.writeFields(aVar);
                }
                if (this.wcf != null) {
                    aVar.iy(4, this.wcf.computeSize());
                    this.wcf.writeFields(aVar);
                }
                aVar.iz(5, this.guN);
                if (this.vEF != null) {
                    aVar.iy(6, this.vEF.computeSize());
                    this.vEF.writeFields(aVar);
                }
                aVar.iz(7, this.wbu);
                aVar.iz(8, this.wbv);
                aVar.iz(9, this.wGb);
                if (this.wFK != null) {
                    aVar.iy(10, this.wFK.computeSize());
                    this.wFK.writeFields(aVar);
                }
                if (this.wFL != null) {
                    aVar.iy(11, this.wFL.computeSize());
                    this.wFL.writeFields(aVar);
                }
                if (this.wFM != null) {
                    aVar.iy(12, this.wFM.computeSize());
                    this.wFM.writeFields(aVar);
                }
                aVar.iz(13, this.wbA);
                aVar.iz(14, this.wbB);
                aVar.e(15, 8, this.wbC);
                if (this.wGf != null) {
                    aVar.iy(16, this.wGf.computeSize());
                    this.wGf.writeFields(aVar);
                }
                aVar.iz(17, this.wbE);
                aVar.iz(18, this.wbF);
                if (this.guO != null) {
                    aVar.e(19, this.guO);
                }
                if (this.guP != null) {
                    aVar.e(20, this.guP);
                }
                if (this.guQ != null) {
                    aVar.e(21, this.guQ);
                }
                aVar.iz(22, this.guR);
                aVar.iz(23, this.wGg);
                aVar.iz(24, this.wBT);
                if (this.wBU != null) {
                    aVar.e(25, this.wBU);
                }
                aVar.iz(26, this.wGh);
                aVar.iz(27, this.vFH);
                if (this.wBV != null) {
                    aVar.e(28, this.wBV);
                }
                if (this.wsM != null) {
                    aVar.e(29, this.wsM);
                }
                if (this.guS != null) {
                    aVar.e(30, this.guS);
                }
                if (this.wGi != null) {
                    aVar.e(31, this.wGi);
                }
                if (this.wBW != null) {
                    aVar.e(32, this.wBW);
                }
                aVar.iz(33, this.wBX);
                aVar.iz(34, this.guU);
                aVar.iz(35, this.guT);
                if (this.guV != null) {
                    aVar.e(36, this.guV);
                }
                if (this.wBZ != null) {
                    aVar.iy(37, this.wBZ.computeSize());
                    this.wBZ.writeFields(aVar);
                }
                if (this.guW != null) {
                    aVar.e(38, this.guW);
                }
                if (this.vXm != null) {
                    aVar.e(39, this.vXm);
                }
                if (this.vXn != null) {
                    aVar.e(40, this.vXn);
                }
                if (this.guX != null) {
                    aVar.e(41, this.guX);
                }
                if (this.wCa != null) {
                    aVar.iy(42, this.wCa.computeSize());
                    this.wCa.writeFields(aVar);
                }
                if (this.wGj != null) {
                    aVar.e(43, this.wGj);
                }
                if (this.wGk != null) {
                    aVar.e(44, this.wGk);
                }
                if (this.wGl != null) {
                    aVar.e(45, this.wGl);
                }
                if (this.wGm != null) {
                    aVar.e(46, this.wGm);
                }
                if (this.wGn != null) {
                    aVar.e(47, this.wGn);
                }
                if (this.wGo != null) {
                    aVar.e(48, this.wGo);
                }
                if (this.wGp != null) {
                    aVar.e(49, this.wGp);
                }
                if (this.wGq != null) {
                    aVar.iy(50, this.wGq.computeSize());
                    this.wGq.writeFields(aVar);
                }
                aVar.iz(53, this.wGr);
                if (this.ndT != null) {
                    aVar.e(54, this.ndT);
                }
                aVar.iz(55, this.wGs);
                aVar.iz(56, this.wGt);
                if (this.wnN != null) {
                    aVar.iy(57, this.wnN.computeSize());
                    this.wnN.writeFields(aVar);
                }
                aVar.iz(58, this.wGu);
                if (this.vEA != null) {
                    aVar.e(59, this.vEA);
                }
                if (this.wGv != null) {
                    aVar.e(60, this.wGv);
                }
                if (this.wcD != null) {
                    aVar.e(61, this.wcD);
                }
                if (this.wGw != null) {
                    aVar.iy(62, this.wGw.computeSize());
                    this.wGw.writeFields(aVar);
                }
                if (this.duq != null) {
                    aVar.e(63, this.duq);
                }
                aVar.iz(64, this.wGx);
                aVar.iz(65, this.wcC);
                aVar.iz(66, this.wGy);
                aVar.iz(67, this.wGz);
                AppMethodBeat.o(60047);
                return 0;
            }
        } else if (i == 1) {
            if (this.wcB != null) {
                ix = e.a.a.a.ix(1, this.wcB.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wyX != null) {
                ix += e.a.a.a.ix(2, this.wyX.computeSize());
            }
            if (this.wce != null) {
                ix += e.a.a.a.ix(3, this.wce.computeSize());
            }
            if (this.wcf != null) {
                ix += e.a.a.a.ix(4, this.wcf.computeSize());
            }
            ix += e.a.a.b.b.a.bs(5, this.guN);
            if (this.vEF != null) {
                ix += e.a.a.a.ix(6, this.vEF.computeSize());
            }
            ix = ((ix + e.a.a.b.b.a.bs(7, this.wbu)) + e.a.a.b.b.a.bs(8, this.wbv)) + e.a.a.b.b.a.bs(9, this.wGb);
            if (this.wFK != null) {
                ix += e.a.a.a.ix(10, this.wFK.computeSize());
            }
            if (this.wFL != null) {
                ix += e.a.a.a.ix(11, this.wFL.computeSize());
            }
            if (this.wFM != null) {
                ix += e.a.a.a.ix(12, this.wFM.computeSize());
            }
            ix = ((ix + e.a.a.b.b.a.bs(13, this.wbA)) + e.a.a.b.b.a.bs(14, this.wbB)) + e.a.a.a.c(15, 8, this.wbC);
            if (this.wGf != null) {
                ix += e.a.a.a.ix(16, this.wGf.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(17, this.wbE)) + e.a.a.b.b.a.bs(18, this.wbF);
            if (this.guO != null) {
                ix += e.a.a.b.b.a.f(19, this.guO);
            }
            if (this.guP != null) {
                ix += e.a.a.b.b.a.f(20, this.guP);
            }
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(21, this.guQ);
            }
            ix = ((ix + e.a.a.b.b.a.bs(22, this.guR)) + e.a.a.b.b.a.bs(23, this.wGg)) + e.a.a.b.b.a.bs(24, this.wBT);
            if (this.wBU != null) {
                ix += e.a.a.b.b.a.f(25, this.wBU);
            }
            ix = (ix + e.a.a.b.b.a.bs(26, this.wGh)) + e.a.a.b.b.a.bs(27, this.vFH);
            if (this.wBV != null) {
                ix += e.a.a.b.b.a.f(28, this.wBV);
            }
            if (this.wsM != null) {
                ix += e.a.a.b.b.a.f(29, this.wsM);
            }
            if (this.guS != null) {
                ix += e.a.a.b.b.a.f(30, this.guS);
            }
            if (this.wGi != null) {
                ix += e.a.a.b.b.a.f(31, this.wGi);
            }
            if (this.wBW != null) {
                ix += e.a.a.b.b.a.f(32, this.wBW);
            }
            ix = ((ix + e.a.a.b.b.a.bs(33, this.wBX)) + e.a.a.b.b.a.bs(34, this.guU)) + e.a.a.b.b.a.bs(35, this.guT);
            if (this.guV != null) {
                ix += e.a.a.b.b.a.f(36, this.guV);
            }
            if (this.wBZ != null) {
                ix += e.a.a.a.ix(37, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(38, this.guW);
            }
            if (this.vXm != null) {
                ix += e.a.a.b.b.a.f(39, this.vXm);
            }
            if (this.vXn != null) {
                ix += e.a.a.b.b.a.f(40, this.vXn);
            }
            if (this.guX != null) {
                ix += e.a.a.b.b.a.f(41, this.guX);
            }
            if (this.wCa != null) {
                ix += e.a.a.a.ix(42, this.wCa.computeSize());
            }
            if (this.wGj != null) {
                ix += e.a.a.b.b.a.f(43, this.wGj);
            }
            if (this.wGk != null) {
                ix += e.a.a.b.b.a.f(44, this.wGk);
            }
            if (this.wGl != null) {
                ix += e.a.a.b.b.a.f(45, this.wGl);
            }
            if (this.wGm != null) {
                ix += e.a.a.b.b.a.f(46, this.wGm);
            }
            if (this.wGn != null) {
                ix += e.a.a.b.b.a.f(47, this.wGn);
            }
            if (this.wGo != null) {
                ix += e.a.a.b.b.a.f(48, this.wGo);
            }
            if (this.wGp != null) {
                ix += e.a.a.b.b.a.f(49, this.wGp);
            }
            if (this.wGq != null) {
                ix += e.a.a.a.ix(50, this.wGq.computeSize());
            }
            ix += e.a.a.b.b.a.bs(53, this.wGr);
            if (this.ndT != null) {
                ix += e.a.a.b.b.a.f(54, this.ndT);
            }
            ix = (ix + e.a.a.b.b.a.bs(55, this.wGs)) + e.a.a.b.b.a.bs(56, this.wGt);
            if (this.wnN != null) {
                ix += e.a.a.a.ix(57, this.wnN.computeSize());
            }
            ix += e.a.a.b.b.a.bs(58, this.wGu);
            if (this.vEA != null) {
                ix += e.a.a.b.b.a.f(59, this.vEA);
            }
            if (this.wGv != null) {
                ix += e.a.a.b.b.a.f(60, this.wGv);
            }
            if (this.wcD != null) {
                ix += e.a.a.b.b.a.f(61, this.wcD);
            }
            if (this.wGw != null) {
                ix += e.a.a.a.ix(62, this.wGw.computeSize());
            }
            if (this.duq != null) {
                ix += e.a.a.b.b.a.f(63, this.duq);
            }
            int bs = (((ix + e.a.a.b.b.a.bs(64, this.wGx)) + e.a.a.b.b.a.bs(65, this.wcC)) + e.a.a.b.b.a.bs(66, this.wGy)) + e.a.a.b.b.a.bs(67, this.wGz);
            AppMethodBeat.o(60047);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(60047);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(60047);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(60047);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(60047);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(60047);
                throw bVar;
            } else {
                AppMethodBeat.o(60047);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbv bbv = (bbv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wcB = bts;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wyX = bts;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wce = bts;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wcf = bts;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 5:
                    bbv.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 7:
                    bbv.wbu = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 8:
                    bbv.wbv = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 9:
                    bbv.wGb = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wFK = bts;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wFL = bts;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wFM = bts;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 13:
                    bbv.wbA = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 14:
                    bbv.wbB = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btp btp = new btp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btp.populateBuilderWithField(aVar4, btp, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wbC.add(btp);
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wGf = bts;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 17:
                    bbv.wbE = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 18:
                    bbv.wbF = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 19:
                    bbv.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 20:
                    bbv.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 21:
                    bbv.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 22:
                    bbv.guR = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 23:
                    bbv.wGg = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 24:
                    bbv.wBT = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 25:
                    bbv.wBU = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 26:
                    bbv.wGh = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 27:
                    bbv.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    bbv.wBV = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 29:
                    bbv.wsM = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 30:
                    bbv.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 31:
                    bbv.wGi = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 32:
                    bbv.wBW = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 33:
                    bbv.wBX = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 34:
                    bbv.guU = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 35:
                    bbv.guT = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 36:
                    bbv.guV = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(aVar4, ccl, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wBZ = ccl;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 38:
                    bbv.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 39:
                    bbv.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 40:
                    bbv.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 41:
                    bbv.guX = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 42:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        uy uyVar = new uy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uyVar.populateBuilderWithField(aVar4, uyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wCa = uyVar;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 43:
                    bbv.wGj = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    bbv.wGk = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    bbv.wGl = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 46:
                    bbv.wGm = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    bbv.wGn = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 48:
                    bbv.wGo = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    bbv.wGp = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 50:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cw cwVar = new cw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwVar.populateBuilderWithField(aVar4, cwVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wGq = cwVar;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    bbv.wGr = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    bbv.ndT = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                    bbv.wGs = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case FileUtils.S_IRWXG /*56*/:
                    bbv.wGt = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case e.CTRL_INDEX /*57*/:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        qe qeVar = new qe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qeVar.populateBuilderWithField(aVar4, qeVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wnN = qeVar;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case aa.CTRL_INDEX /*58*/:
                    bbv.wGu = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case au.CTRL_INDEX /*59*/:
                    bbv.vEA = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 60:
                    bbv.wGv = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    bbv.wcD = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 62:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkg bkg = new bkg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkg.populateBuilderWithField(aVar4, bkg, a.getNextFieldNumber(aVar4))) {
                        }
                        bbv.wGw = bkg;
                    }
                    AppMethodBeat.o(60047);
                    return 0;
                case 63:
                    bbv.duq = aVar3.BTU.readString();
                    AppMethodBeat.o(60047);
                    return 0;
                case 64:
                    bbv.wGx = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 65:
                    bbv.wcC = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 66:
                    bbv.wGy = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                case 67:
                    bbv.wGz = aVar3.BTU.vd();
                    AppMethodBeat.o(60047);
                    return 0;
                default:
                    AppMethodBeat.o(60047);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60047);
            return -1;
        }
    }
}
