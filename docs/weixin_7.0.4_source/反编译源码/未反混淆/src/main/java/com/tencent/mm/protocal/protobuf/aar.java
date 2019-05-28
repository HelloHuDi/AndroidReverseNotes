package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import java.util.LinkedList;

public final class aar extends a {
    public String cMn;
    public String canvasPageXml;
    public String cvq;
    public int dataType;
    public String desc;
    public int duration;
    public String fgA;
    public String fgB;
    public String fgE;
    public int fgI;
    public int fgJ;
    public String fgv;
    public String mnd;
    public String title;
    public boolean wfS = false;
    public boolean wfT = false;
    public boolean wfU = false;
    public String wfV;
    public boolean wfW = false;
    public boolean wfX = false;
    public boolean wfY = false;
    public String wfZ;
    public boolean wgA = false;
    public String wgB;
    public boolean wgC = false;
    public String wgD;
    public boolean wgE = false;
    public long wgF;
    public boolean wgG = false;
    public String wgH;
    public boolean wgI = false;
    public String wgJ;
    public boolean wgK = false;
    public boolean wgL;
    public boolean wgM = false;
    public boolean wgN;
    public boolean wgO = false;
    public int wgP;
    public boolean wgQ = false;
    public String wgR;
    public boolean wgS = false;
    public aas wgT;
    public boolean wgU = false;
    public String wgV;
    public boolean wgW = false;
    public String wgX;
    public boolean wgY = false;
    public aau wgZ;
    public boolean wga = false;
    public String wgb;
    public boolean wgc = false;
    public int wgd;
    public boolean wge = false;
    public boolean wgf = false;
    public String wgg;
    public boolean wgh = false;
    public String wgi;
    public boolean wgj = false;
    public String wgk;
    public boolean wgl = false;
    public boolean wgm = false;
    public boolean wgn = false;
    public String wgo;
    public boolean wgp = false;
    public String wgq;
    public boolean wgr = false;
    public String wgs;
    public boolean wgt = false;
    public long wgu;
    public boolean wgv = false;
    public boolean wgw = false;
    public String wgx;
    public boolean wgy = false;
    public String wgz;
    public boolean wha = false;
    public String whb;
    public boolean whc = false;
    public boolean whd = false;
    public boolean whe = false;
    public long whf;
    public boolean whg = false;
    public int whh;
    public boolean whi = false;
    public String whj;
    public boolean whk = false;
    public int whl;
    public boolean whm = false;
    public boolean whn = false;
    public String who;
    public boolean whp = false;
    public boolean whq = false;
    public String whr;
    public boolean whs = false;
    public boolean wht = false;
    public String whu;
    public boolean whv = false;

    public final aar akH(String str) {
        this.title = str;
        this.wfS = true;
        return this;
    }

    public final aar akI(String str) {
        this.desc = str;
        this.wfT = true;
        return this;
    }

    public final aar akJ(String str) {
        this.fgE = str;
        this.wfU = true;
        return this;
    }

    public final aar akK(String str) {
        this.wfV = str;
        this.wfW = true;
        return this;
    }

    public final aar LB(int i) {
        this.fgJ = i;
        this.wfX = true;
        return this;
    }

    public final aar LC(int i) {
        this.fgI = i;
        this.wfY = true;
        return this;
    }

    public final aar akL(String str) {
        this.wfZ = str;
        this.wga = true;
        return this;
    }

    public final aar akM(String str) {
        this.wgb = str;
        this.wgc = true;
        return this;
    }

    public final aar LD(int i) {
        this.duration = i;
        this.wgf = true;
        return this;
    }

    public final aar akN(String str) {
        this.wgg = str;
        this.wgh = true;
        return this;
    }

    public final aar akO(String str) {
        this.wgi = str;
        this.wgj = true;
        return this;
    }

    public final aar akP(String str) {
        this.wgk = str;
        this.wgl = true;
        return this;
    }

    public final aar akQ(String str) {
        this.cvq = str;
        this.wgm = true;
        return this;
    }

    public final aar LE(int i) {
        this.dataType = i;
        this.wgn = true;
        return this;
    }

    public final aar akR(String str) {
        this.wgo = str;
        this.wgp = true;
        return this;
    }

    public final aar akS(String str) {
        this.wgq = str;
        this.wgr = true;
        return this;
    }

    public final aar akT(String str) {
        this.wgs = str;
        this.wgt = true;
        return this;
    }

    public final aar mf(long j) {
        this.wgu = j;
        this.wgv = true;
        return this;
    }

    public final aar akU(String str) {
        this.mnd = str;
        this.wgw = true;
        return this;
    }

    public final aar akV(String str) {
        this.wgx = str;
        this.wgy = true;
        return this;
    }

    public final aar akW(String str) {
        this.wgz = str;
        this.wgA = true;
        return this;
    }

    public final aar akX(String str) {
        this.wgB = str;
        this.wgC = true;
        return this;
    }

    public final aar akY(String str) {
        this.wgD = str;
        this.wgE = true;
        return this;
    }

    public final aar mg(long j) {
        this.wgF = j;
        this.wgG = true;
        return this;
    }

    public final aar akZ(String str) {
        this.wgH = str;
        this.wgI = true;
        return this;
    }

    public final aar ala(String str) {
        this.wgJ = str;
        this.wgK = true;
        return this;
    }

    public final aar oX(boolean z) {
        this.wgL = z;
        this.wgM = true;
        return this;
    }

    public final aar oY(boolean z) {
        this.wgN = z;
        this.wgO = true;
        return this;
    }

    public final aar LF(int i) {
        this.wgP = i;
        this.wgQ = true;
        return this;
    }

    public final aar alb(String str) {
        this.wgR = str;
        this.wgS = true;
        return this;
    }

    public final aar a(aas aas) {
        this.wgT = aas;
        this.wgU = true;
        return this;
    }

    public final aar alc(String str) {
        this.wgV = str;
        this.wgW = true;
        return this;
    }

    public final aar ald(String str) {
        this.wgX = str;
        this.wgY = true;
        return this;
    }

    public final aar a(aau aau) {
        this.wgZ = aau;
        this.wha = true;
        return this;
    }

    public final aar ale(String str) {
        this.whb = str;
        this.whc = true;
        return this;
    }

    public final aar alf(String str) {
        this.cMn = str;
        this.whd = true;
        return this;
    }

    public final aar alg(String str) {
        this.canvasPageXml = str;
        this.whe = true;
        return this;
    }

    public final aar mh(long j) {
        this.whf = j;
        this.whg = true;
        return this;
    }

    public final aar LG(int i) {
        this.whh = i;
        this.whi = true;
        return this;
    }

    public final aar alh(String str) {
        this.whj = str;
        this.whk = true;
        return this;
    }

    public final aar LH(int i) {
        this.whl = i;
        this.whm = true;
        return this;
    }

    public final aar ali(String str) {
        this.who = str;
        this.whp = true;
        return this;
    }

    public final aar alj(String str) {
        this.fgA = str;
        this.whq = true;
        return this;
    }

    public final aar alk(String str) {
        this.whr = str;
        this.whs = true;
        return this;
    }

    public final aar all(String str) {
        this.whu = str;
        this.whv = true;
        return this;
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51390);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.fgE != null) {
                aVar.e(3, this.fgE);
            }
            if (this.wfV != null) {
                aVar.e(4, this.wfV);
            }
            if (this.wfX) {
                aVar.iz(5, this.fgJ);
            }
            if (this.wfY) {
                aVar.iz(6, this.fgI);
            }
            if (this.wfZ != null) {
                aVar.e(7, this.wfZ);
            }
            if (this.wgb != null) {
                aVar.e(8, this.wgb);
            }
            if (this.wge) {
                aVar.iz(9, this.wgd);
            }
            if (this.wgf) {
                aVar.iz(10, this.duration);
            }
            if (this.wgg != null) {
                aVar.e(11, this.wgg);
            }
            if (this.wgi != null) {
                aVar.e(12, this.wgi);
            }
            if (this.wgk != null) {
                aVar.e(13, this.wgk);
            }
            if (this.cvq != null) {
                aVar.e(14, this.cvq);
            }
            if (this.wgn) {
                aVar.iz(15, this.dataType);
            }
            if (this.wgo != null) {
                aVar.e(16, this.wgo);
            }
            if (this.wgq != null) {
                aVar.e(17, this.wgq);
            }
            if (this.wgs != null) {
                aVar.e(18, this.wgs);
            }
            if (this.wgv) {
                aVar.ai(19, this.wgu);
            }
            if (this.mnd != null) {
                aVar.e(20, this.mnd);
            }
            if (this.wgx != null) {
                aVar.e(21, this.wgx);
            }
            if (this.wgz != null) {
                aVar.e(22, this.wgz);
            }
            if (this.wgB != null) {
                aVar.e(23, this.wgB);
            }
            if (this.wgD != null) {
                aVar.e(24, this.wgD);
            }
            if (this.wgG) {
                aVar.ai(25, this.wgF);
            }
            if (this.wgH != null) {
                aVar.e(26, this.wgH);
            }
            if (this.wgJ != null) {
                aVar.e(27, this.wgJ);
            }
            if (this.wgM) {
                aVar.aO(28, this.wgL);
            }
            if (this.wgO) {
                aVar.aO(29, this.wgN);
            }
            if (this.wgQ) {
                aVar.iz(30, this.wgP);
            }
            if (this.wgR != null) {
                aVar.e(31, this.wgR);
            }
            if (this.wgT != null) {
                aVar.iy(32, this.wgT.computeSize());
                this.wgT.writeFields(aVar);
            }
            if (this.wgV != null) {
                aVar.e(33, this.wgV);
            }
            if (this.wgX != null) {
                aVar.e(34, this.wgX);
            }
            if (this.wgZ != null) {
                aVar.iy(35, this.wgZ.computeSize());
                this.wgZ.writeFields(aVar);
            }
            if (this.whb != null) {
                aVar.e(36, this.whb);
            }
            if (this.cMn != null) {
                aVar.e(37, this.cMn);
            }
            if (this.canvasPageXml != null) {
                aVar.e(38, this.canvasPageXml);
            }
            if (this.whg) {
                aVar.ai(39, this.whf);
            }
            if (this.whi) {
                aVar.iz(40, this.whh);
            }
            if (this.whj != null) {
                aVar.e(41, this.whj);
            }
            if (this.whm) {
                aVar.iz(42, this.whl);
            }
            if (this.fgv != null) {
                aVar.e(43, this.fgv);
            }
            if (this.who != null) {
                aVar.e(44, this.who);
            }
            if (this.fgA != null) {
                aVar.e(45, this.fgA);
            }
            if (this.whr != null) {
                aVar.e(46, this.whr);
            }
            if (this.fgB != null) {
                aVar.e(47, this.fgB);
            }
            if (this.whu != null) {
                aVar.e(48, this.whu);
            }
            AppMethodBeat.o(51390);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            if (this.fgE != null) {
                f += e.a.a.b.b.a.f(3, this.fgE);
            }
            if (this.wfV != null) {
                f += e.a.a.b.b.a.f(4, this.wfV);
            }
            if (this.wfX) {
                f += e.a.a.b.b.a.bs(5, this.fgJ);
            }
            if (this.wfY) {
                f += e.a.a.b.b.a.bs(6, this.fgI);
            }
            if (this.wfZ != null) {
                f += e.a.a.b.b.a.f(7, this.wfZ);
            }
            if (this.wgb != null) {
                f += e.a.a.b.b.a.f(8, this.wgb);
            }
            if (this.wge) {
                f += e.a.a.b.b.a.bs(9, this.wgd);
            }
            if (this.wgf) {
                f += e.a.a.b.b.a.bs(10, this.duration);
            }
            if (this.wgg != null) {
                f += e.a.a.b.b.a.f(11, this.wgg);
            }
            if (this.wgi != null) {
                f += e.a.a.b.b.a.f(12, this.wgi);
            }
            if (this.wgk != null) {
                f += e.a.a.b.b.a.f(13, this.wgk);
            }
            if (this.cvq != null) {
                f += e.a.a.b.b.a.f(14, this.cvq);
            }
            if (this.wgn) {
                f += e.a.a.b.b.a.bs(15, this.dataType);
            }
            if (this.wgo != null) {
                f += e.a.a.b.b.a.f(16, this.wgo);
            }
            if (this.wgq != null) {
                f += e.a.a.b.b.a.f(17, this.wgq);
            }
            if (this.wgs != null) {
                f += e.a.a.b.b.a.f(18, this.wgs);
            }
            if (this.wgv) {
                f += e.a.a.b.b.a.o(19, this.wgu);
            }
            if (this.mnd != null) {
                f += e.a.a.b.b.a.f(20, this.mnd);
            }
            if (this.wgx != null) {
                f += e.a.a.b.b.a.f(21, this.wgx);
            }
            if (this.wgz != null) {
                f += e.a.a.b.b.a.f(22, this.wgz);
            }
            if (this.wgB != null) {
                f += e.a.a.b.b.a.f(23, this.wgB);
            }
            if (this.wgD != null) {
                f += e.a.a.b.b.a.f(24, this.wgD);
            }
            if (this.wgG) {
                f += e.a.a.b.b.a.o(25, this.wgF);
            }
            if (this.wgH != null) {
                f += e.a.a.b.b.a.f(26, this.wgH);
            }
            if (this.wgJ != null) {
                f += e.a.a.b.b.a.f(27, this.wgJ);
            }
            if (this.wgM) {
                f += e.a.a.b.b.a.fv(28) + 1;
            }
            if (this.wgO) {
                f += e.a.a.b.b.a.fv(29) + 1;
            }
            if (this.wgQ) {
                f += e.a.a.b.b.a.bs(30, this.wgP);
            }
            if (this.wgR != null) {
                f += e.a.a.b.b.a.f(31, this.wgR);
            }
            if (this.wgT != null) {
                f += e.a.a.a.ix(32, this.wgT.computeSize());
            }
            if (this.wgV != null) {
                f += e.a.a.b.b.a.f(33, this.wgV);
            }
            if (this.wgX != null) {
                f += e.a.a.b.b.a.f(34, this.wgX);
            }
            if (this.wgZ != null) {
                f += e.a.a.a.ix(35, this.wgZ.computeSize());
            }
            if (this.whb != null) {
                f += e.a.a.b.b.a.f(36, this.whb);
            }
            if (this.cMn != null) {
                f += e.a.a.b.b.a.f(37, this.cMn);
            }
            if (this.canvasPageXml != null) {
                f += e.a.a.b.b.a.f(38, this.canvasPageXml);
            }
            if (this.whg) {
                f += e.a.a.b.b.a.o(39, this.whf);
            }
            if (this.whi) {
                f += e.a.a.b.b.a.bs(40, this.whh);
            }
            if (this.whj != null) {
                f += e.a.a.b.b.a.f(41, this.whj);
            }
            if (this.whm) {
                f += e.a.a.b.b.a.bs(42, this.whl);
            }
            if (this.fgv != null) {
                f += e.a.a.b.b.a.f(43, this.fgv);
            }
            if (this.who != null) {
                f += e.a.a.b.b.a.f(44, this.who);
            }
            if (this.fgA != null) {
                f += e.a.a.b.b.a.f(45, this.fgA);
            }
            if (this.whr != null) {
                f += e.a.a.b.b.a.f(46, this.whr);
            }
            if (this.fgB != null) {
                f += e.a.a.b.b.a.f(47, this.fgB);
            }
            if (this.whu != null) {
                f += e.a.a.b.b.a.f(48, this.whu);
            }
            AppMethodBeat.o(51390);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51390);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aar aar = (aar) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    aar.title = aVar3.BTU.readString();
                    aar.wfS = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 2:
                    aar.desc = aVar3.BTU.readString();
                    aar.wfT = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 3:
                    aar.fgE = aVar3.BTU.readString();
                    aar.wfU = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 4:
                    aar.wfV = aVar3.BTU.readString();
                    aar.wfW = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 5:
                    aar.fgJ = aVar3.BTU.vd();
                    aar.wfX = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 6:
                    aar.fgI = aVar3.BTU.vd();
                    aar.wfY = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 7:
                    aar.wfZ = aVar3.BTU.readString();
                    aar.wga = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 8:
                    aar.wgb = aVar3.BTU.readString();
                    aar.wgc = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 9:
                    aar.wgd = aVar3.BTU.vd();
                    aar.wge = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 10:
                    aar.duration = aVar3.BTU.vd();
                    aar.wgf = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 11:
                    aar.wgg = aVar3.BTU.readString();
                    aar.wgh = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 12:
                    aar.wgi = aVar3.BTU.readString();
                    aar.wgj = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 13:
                    aar.wgk = aVar3.BTU.readString();
                    aar.wgl = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 14:
                    aar.cvq = aVar3.BTU.readString();
                    aar.wgm = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 15:
                    aar.dataType = aVar3.BTU.vd();
                    aar.wgn = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 16:
                    aar.wgo = aVar3.BTU.readString();
                    aar.wgp = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 17:
                    aar.wgq = aVar3.BTU.readString();
                    aar.wgr = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 18:
                    aar.wgs = aVar3.BTU.readString();
                    aar.wgt = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 19:
                    aar.wgu = aVar3.BTU.ve();
                    aar.wgv = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 20:
                    aar.mnd = aVar3.BTU.readString();
                    aar.wgw = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 21:
                    aar.wgx = aVar3.BTU.readString();
                    aar.wgy = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 22:
                    aar.wgz = aVar3.BTU.readString();
                    aar.wgA = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 23:
                    aar.wgB = aVar3.BTU.readString();
                    aar.wgC = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 24:
                    aar.wgD = aVar3.BTU.readString();
                    aar.wgE = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 25:
                    aar.wgF = aVar3.BTU.ve();
                    aar.wgG = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 26:
                    aar.wgH = aVar3.BTU.readString();
                    aar.wgI = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 27:
                    aar.wgJ = aVar3.BTU.readString();
                    aar.wgK = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    aar.wgL = aVar3.BTU.ehX();
                    aar.wgM = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 29:
                    aar.wgN = aVar3.BTU.ehX();
                    aar.wgO = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 30:
                    aar.wgP = aVar3.BTU.vd();
                    aar.wgQ = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 31:
                    aar.wgR = aVar3.BTU.readString();
                    aar.wgS = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 32:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aas aas = new aas();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aas.populateBuilderWithField(aVar4, aas, a.getNextFieldNumber(aVar4))) {
                        }
                        aar.wgT = aas;
                    }
                    aar.wgU = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 33:
                    aar.wgV = aVar3.BTU.readString();
                    aar.wgW = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 34:
                    aar.wgX = aVar3.BTU.readString();
                    aar.wgY = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 35:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aau aau = new aau();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aau.populateBuilderWithField(aVar4, aau, a.getNextFieldNumber(aVar4))) {
                        }
                        aar.wgZ = aau;
                    }
                    aar.wha = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 36:
                    aar.whb = aVar3.BTU.readString();
                    aar.whc = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    aar.cMn = aVar3.BTU.readString();
                    aar.whd = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 38:
                    aar.canvasPageXml = aVar3.BTU.readString();
                    aar.whe = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 39:
                    aar.whf = aVar3.BTU.ve();
                    aar.whg = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 40:
                    aar.whh = aVar3.BTU.vd();
                    aar.whi = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 41:
                    aar.whj = aVar3.BTU.readString();
                    aar.whk = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 42:
                    aar.whl = aVar3.BTU.vd();
                    aar.whm = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 43:
                    aar.fgv = aVar3.BTU.readString();
                    aar.whn = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    aar.who = aVar3.BTU.readString();
                    aar.whp = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    aar.fgA = aVar3.BTU.readString();
                    aar.whq = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 46:
                    aar.whr = aVar3.BTU.readString();
                    aar.whs = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    aar.fgB = aVar3.BTU.readString();
                    aar.wht = true;
                    AppMethodBeat.o(51390);
                    return 0;
                case 48:
                    aar.whu = aVar3.BTU.readString();
                    aar.whv = true;
                    AppMethodBeat.o(51390);
                    return 0;
                default:
                    AppMethodBeat.o(51390);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51390);
            return -1;
        }
    }
}
