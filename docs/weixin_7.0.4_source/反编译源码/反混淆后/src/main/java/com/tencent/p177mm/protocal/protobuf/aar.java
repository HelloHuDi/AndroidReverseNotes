package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aar */
public final class aar extends C1331a {
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

    /* renamed from: LB */
    public final aar mo27391LB(int i) {
        this.fgJ = i;
        this.wfX = true;
        return this;
    }

    /* renamed from: LC */
    public final aar mo27392LC(int i) {
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

    /* renamed from: LD */
    public final aar mo27393LD(int i) {
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

    /* renamed from: LE */
    public final aar mo27394LE(int i) {
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

    /* renamed from: mf */
    public final aar mo27431mf(long j) {
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

    /* renamed from: mg */
    public final aar mo27432mg(long j) {
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

    /* renamed from: oX */
    public final aar mo27434oX(boolean z) {
        this.wgL = z;
        this.wgM = true;
        return this;
    }

    /* renamed from: oY */
    public final aar mo27435oY(boolean z) {
        this.wgN = z;
        this.wgO = true;
        return this;
    }

    /* renamed from: LF */
    public final aar mo27395LF(int i) {
        this.wgP = i;
        this.wgQ = true;
        return this;
    }

    public final aar alb(String str) {
        this.wgR = str;
        this.wgS = true;
        return this;
    }

    /* renamed from: a */
    public final aar mo27398a(aas aas) {
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

    /* renamed from: a */
    public final aar mo27399a(aau aau) {
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

    /* renamed from: mh */
    public final aar mo27433mh(long j) {
        this.whf = j;
        this.whg = true;
        return this;
    }

    /* renamed from: LG */
    public final aar mo27396LG(int i) {
        this.whh = i;
        this.whi = true;
        return this;
    }

    public final aar alh(String str) {
        this.whj = str;
        this.whk = true;
        return this;
    }

    /* renamed from: LH */
    public final aar mo27397LH(int i) {
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

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51390);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(2, this.desc);
            }
            if (this.fgE != null) {
                c6093a.mo13475e(3, this.fgE);
            }
            if (this.wfV != null) {
                c6093a.mo13475e(4, this.wfV);
            }
            if (this.wfX) {
                c6093a.mo13480iz(5, this.fgJ);
            }
            if (this.wfY) {
                c6093a.mo13480iz(6, this.fgI);
            }
            if (this.wfZ != null) {
                c6093a.mo13475e(7, this.wfZ);
            }
            if (this.wgb != null) {
                c6093a.mo13475e(8, this.wgb);
            }
            if (this.wge) {
                c6093a.mo13480iz(9, this.wgd);
            }
            if (this.wgf) {
                c6093a.mo13480iz(10, this.duration);
            }
            if (this.wgg != null) {
                c6093a.mo13475e(11, this.wgg);
            }
            if (this.wgi != null) {
                c6093a.mo13475e(12, this.wgi);
            }
            if (this.wgk != null) {
                c6093a.mo13475e(13, this.wgk);
            }
            if (this.cvq != null) {
                c6093a.mo13475e(14, this.cvq);
            }
            if (this.wgn) {
                c6093a.mo13480iz(15, this.dataType);
            }
            if (this.wgo != null) {
                c6093a.mo13475e(16, this.wgo);
            }
            if (this.wgq != null) {
                c6093a.mo13475e(17, this.wgq);
            }
            if (this.wgs != null) {
                c6093a.mo13475e(18, this.wgs);
            }
            if (this.wgv) {
                c6093a.mo13472ai(19, this.wgu);
            }
            if (this.mnd != null) {
                c6093a.mo13475e(20, this.mnd);
            }
            if (this.wgx != null) {
                c6093a.mo13475e(21, this.wgx);
            }
            if (this.wgz != null) {
                c6093a.mo13475e(22, this.wgz);
            }
            if (this.wgB != null) {
                c6093a.mo13475e(23, this.wgB);
            }
            if (this.wgD != null) {
                c6093a.mo13475e(24, this.wgD);
            }
            if (this.wgG) {
                c6093a.mo13472ai(25, this.wgF);
            }
            if (this.wgH != null) {
                c6093a.mo13475e(26, this.wgH);
            }
            if (this.wgJ != null) {
                c6093a.mo13475e(27, this.wgJ);
            }
            if (this.wgM) {
                c6093a.mo13471aO(28, this.wgL);
            }
            if (this.wgO) {
                c6093a.mo13471aO(29, this.wgN);
            }
            if (this.wgQ) {
                c6093a.mo13480iz(30, this.wgP);
            }
            if (this.wgR != null) {
                c6093a.mo13475e(31, this.wgR);
            }
            if (this.wgT != null) {
                c6093a.mo13479iy(32, this.wgT.computeSize());
                this.wgT.writeFields(c6093a);
            }
            if (this.wgV != null) {
                c6093a.mo13475e(33, this.wgV);
            }
            if (this.wgX != null) {
                c6093a.mo13475e(34, this.wgX);
            }
            if (this.wgZ != null) {
                c6093a.mo13479iy(35, this.wgZ.computeSize());
                this.wgZ.writeFields(c6093a);
            }
            if (this.whb != null) {
                c6093a.mo13475e(36, this.whb);
            }
            if (this.cMn != null) {
                c6093a.mo13475e(37, this.cMn);
            }
            if (this.canvasPageXml != null) {
                c6093a.mo13475e(38, this.canvasPageXml);
            }
            if (this.whg) {
                c6093a.mo13472ai(39, this.whf);
            }
            if (this.whi) {
                c6093a.mo13480iz(40, this.whh);
            }
            if (this.whj != null) {
                c6093a.mo13475e(41, this.whj);
            }
            if (this.whm) {
                c6093a.mo13480iz(42, this.whl);
            }
            if (this.fgv != null) {
                c6093a.mo13475e(43, this.fgv);
            }
            if (this.who != null) {
                c6093a.mo13475e(44, this.who);
            }
            if (this.fgA != null) {
                c6093a.mo13475e(45, this.fgA);
            }
            if (this.whr != null) {
                c6093a.mo13475e(46, this.whr);
            }
            if (this.fgB != null) {
                c6093a.mo13475e(47, this.fgB);
            }
            if (this.whu != null) {
                c6093a.mo13475e(48, this.whu);
            }
            AppMethodBeat.m2505o(51390);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += C6091a.m9575f(2, this.desc);
            }
            if (this.fgE != null) {
                f += C6091a.m9575f(3, this.fgE);
            }
            if (this.wfV != null) {
                f += C6091a.m9575f(4, this.wfV);
            }
            if (this.wfX) {
                f += C6091a.m9572bs(5, this.fgJ);
            }
            if (this.wfY) {
                f += C6091a.m9572bs(6, this.fgI);
            }
            if (this.wfZ != null) {
                f += C6091a.m9575f(7, this.wfZ);
            }
            if (this.wgb != null) {
                f += C6091a.m9575f(8, this.wgb);
            }
            if (this.wge) {
                f += C6091a.m9572bs(9, this.wgd);
            }
            if (this.wgf) {
                f += C6091a.m9572bs(10, this.duration);
            }
            if (this.wgg != null) {
                f += C6091a.m9575f(11, this.wgg);
            }
            if (this.wgi != null) {
                f += C6091a.m9575f(12, this.wgi);
            }
            if (this.wgk != null) {
                f += C6091a.m9575f(13, this.wgk);
            }
            if (this.cvq != null) {
                f += C6091a.m9575f(14, this.cvq);
            }
            if (this.wgn) {
                f += C6091a.m9572bs(15, this.dataType);
            }
            if (this.wgo != null) {
                f += C6091a.m9575f(16, this.wgo);
            }
            if (this.wgq != null) {
                f += C6091a.m9575f(17, this.wgq);
            }
            if (this.wgs != null) {
                f += C6091a.m9575f(18, this.wgs);
            }
            if (this.wgv) {
                f += C6091a.m9578o(19, this.wgu);
            }
            if (this.mnd != null) {
                f += C6091a.m9575f(20, this.mnd);
            }
            if (this.wgx != null) {
                f += C6091a.m9575f(21, this.wgx);
            }
            if (this.wgz != null) {
                f += C6091a.m9575f(22, this.wgz);
            }
            if (this.wgB != null) {
                f += C6091a.m9575f(23, this.wgB);
            }
            if (this.wgD != null) {
                f += C6091a.m9575f(24, this.wgD);
            }
            if (this.wgG) {
                f += C6091a.m9578o(25, this.wgF);
            }
            if (this.wgH != null) {
                f += C6091a.m9575f(26, this.wgH);
            }
            if (this.wgJ != null) {
                f += C6091a.m9575f(27, this.wgJ);
            }
            if (this.wgM) {
                f += C6091a.m9576fv(28) + 1;
            }
            if (this.wgO) {
                f += C6091a.m9576fv(29) + 1;
            }
            if (this.wgQ) {
                f += C6091a.m9572bs(30, this.wgP);
            }
            if (this.wgR != null) {
                f += C6091a.m9575f(31, this.wgR);
            }
            if (this.wgT != null) {
                f += C6087a.m9557ix(32, this.wgT.computeSize());
            }
            if (this.wgV != null) {
                f += C6091a.m9575f(33, this.wgV);
            }
            if (this.wgX != null) {
                f += C6091a.m9575f(34, this.wgX);
            }
            if (this.wgZ != null) {
                f += C6087a.m9557ix(35, this.wgZ.computeSize());
            }
            if (this.whb != null) {
                f += C6091a.m9575f(36, this.whb);
            }
            if (this.cMn != null) {
                f += C6091a.m9575f(37, this.cMn);
            }
            if (this.canvasPageXml != null) {
                f += C6091a.m9575f(38, this.canvasPageXml);
            }
            if (this.whg) {
                f += C6091a.m9578o(39, this.whf);
            }
            if (this.whi) {
                f += C6091a.m9572bs(40, this.whh);
            }
            if (this.whj != null) {
                f += C6091a.m9575f(41, this.whj);
            }
            if (this.whm) {
                f += C6091a.m9572bs(42, this.whl);
            }
            if (this.fgv != null) {
                f += C6091a.m9575f(43, this.fgv);
            }
            if (this.who != null) {
                f += C6091a.m9575f(44, this.who);
            }
            if (this.fgA != null) {
                f += C6091a.m9575f(45, this.fgA);
            }
            if (this.whr != null) {
                f += C6091a.m9575f(46, this.whr);
            }
            if (this.fgB != null) {
                f += C6091a.m9575f(47, this.fgB);
            }
            if (this.whu != null) {
                f += C6091a.m9575f(48, this.whu);
            }
            AppMethodBeat.m2505o(51390);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51390);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aar aar = (aar) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    aar.title = c6086a2.BTU.readString();
                    aar.wfS = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 2:
                    aar.desc = c6086a2.BTU.readString();
                    aar.wfT = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 3:
                    aar.fgE = c6086a2.BTU.readString();
                    aar.wfU = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 4:
                    aar.wfV = c6086a2.BTU.readString();
                    aar.wfW = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 5:
                    aar.fgJ = c6086a2.BTU.mo13458vd();
                    aar.wfX = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 6:
                    aar.fgI = c6086a2.BTU.mo13458vd();
                    aar.wfY = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 7:
                    aar.wfZ = c6086a2.BTU.readString();
                    aar.wga = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 8:
                    aar.wgb = c6086a2.BTU.readString();
                    aar.wgc = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 9:
                    aar.wgd = c6086a2.BTU.mo13458vd();
                    aar.wge = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 10:
                    aar.duration = c6086a2.BTU.mo13458vd();
                    aar.wgf = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 11:
                    aar.wgg = c6086a2.BTU.readString();
                    aar.wgh = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 12:
                    aar.wgi = c6086a2.BTU.readString();
                    aar.wgj = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 13:
                    aar.wgk = c6086a2.BTU.readString();
                    aar.wgl = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 14:
                    aar.cvq = c6086a2.BTU.readString();
                    aar.wgm = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 15:
                    aar.dataType = c6086a2.BTU.mo13458vd();
                    aar.wgn = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 16:
                    aar.wgo = c6086a2.BTU.readString();
                    aar.wgp = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 17:
                    aar.wgq = c6086a2.BTU.readString();
                    aar.wgr = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 18:
                    aar.wgs = c6086a2.BTU.readString();
                    aar.wgt = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 19:
                    aar.wgu = c6086a2.BTU.mo13459ve();
                    aar.wgv = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 20:
                    aar.mnd = c6086a2.BTU.readString();
                    aar.wgw = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 21:
                    aar.wgx = c6086a2.BTU.readString();
                    aar.wgy = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 22:
                    aar.wgz = c6086a2.BTU.readString();
                    aar.wgA = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 23:
                    aar.wgB = c6086a2.BTU.readString();
                    aar.wgC = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 24:
                    aar.wgD = c6086a2.BTU.readString();
                    aar.wgE = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 25:
                    aar.wgF = c6086a2.BTU.mo13459ve();
                    aar.wgG = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 26:
                    aar.wgH = c6086a2.BTU.readString();
                    aar.wgI = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 27:
                    aar.wgJ = c6086a2.BTU.readString();
                    aar.wgK = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    aar.wgL = c6086a2.BTU.ehX();
                    aar.wgM = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 29:
                    aar.wgN = c6086a2.BTU.ehX();
                    aar.wgO = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 30:
                    aar.wgP = c6086a2.BTU.mo13458vd();
                    aar.wgQ = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 31:
                    aar.wgR = c6086a2.BTU.readString();
                    aar.wgS = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 32:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aas aas = new aas();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aas.populateBuilderWithField(c6086a3, aas, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aar.wgT = aas;
                    }
                    aar.wgU = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 33:
                    aar.wgV = c6086a2.BTU.readString();
                    aar.wgW = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 34:
                    aar.wgX = c6086a2.BTU.readString();
                    aar.wgY = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 35:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aau aau = new aau();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aau.populateBuilderWithField(c6086a3, aau, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aar.wgZ = aau;
                    }
                    aar.wha = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 36:
                    aar.whb = c6086a2.BTU.readString();
                    aar.whc = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    aar.cMn = c6086a2.BTU.readString();
                    aar.whd = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 38:
                    aar.canvasPageXml = c6086a2.BTU.readString();
                    aar.whe = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 39:
                    aar.whf = c6086a2.BTU.mo13459ve();
                    aar.whg = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 40:
                    aar.whh = c6086a2.BTU.mo13458vd();
                    aar.whi = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 41:
                    aar.whj = c6086a2.BTU.readString();
                    aar.whk = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 42:
                    aar.whl = c6086a2.BTU.mo13458vd();
                    aar.whm = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 43:
                    aar.fgv = c6086a2.BTU.readString();
                    aar.whn = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    aar.who = c6086a2.BTU.readString();
                    aar.whp = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    aar.fgA = c6086a2.BTU.readString();
                    aar.whq = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 46:
                    aar.whr = c6086a2.BTU.readString();
                    aar.whs = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    aar.fgB = c6086a2.BTU.readString();
                    aar.wht = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                case 48:
                    aar.whu = c6086a2.BTU.readString();
                    aar.whv = true;
                    AppMethodBeat.m2505o(51390);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51390);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51390);
            return -1;
        }
    }
}
