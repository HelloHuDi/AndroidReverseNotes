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
import org.xwalk.core.XWalkEnvironment;

public final class oq extends a {
    public String cFl;
    public String kfM;
    public String nuL;
    public String pbn;
    public String pbo;
    public String pbp;
    public String tyG;
    public String tyH;
    public String uYI;
    public String vJC;
    public String vJD;
    public String vJE;
    public String vJv;
    public String vJw;
    public String vUZ;
    public String vVA;
    public String vVB;
    public String vVC;
    public String vVD;
    public String vVE;
    public int vVF;
    public int vVG;
    public String vVH;
    public String vVI;
    public String vVJ;
    public String vVK;
    public String vVL;
    public long vVM;
    public String vVN;
    public String vVO;
    public int vVP;
    public int vVQ;
    public int vVR;
    public String vVa;
    public String vVb;
    public String vVc;
    public String vVd;
    public String vVe;
    public String vVf;
    public String vVg;
    public String vVh;
    public String vVi;
    public String vVj;
    public String vVk;
    public String vVl;
    public String vVm;
    public String vVn;
    public String vVo;
    public int vVp;
    public String vVq;
    public String vVr;
    public String vVs;
    public String vVt;
    public String vVu;
    public String vVv;
    public String vVw;
    public String vVx;
    public String vVy;
    public String vVz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56742);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vUZ != null) {
                aVar.e(1, this.vUZ);
            }
            if (this.tyG != null) {
                aVar.e(2, this.tyG);
            }
            if (this.nuL != null) {
                aVar.e(3, this.nuL);
            }
            if (this.tyH != null) {
                aVar.e(4, this.tyH);
            }
            if (this.pbn != null) {
                aVar.e(5, this.pbn);
            }
            if (this.vJC != null) {
                aVar.e(6, this.vJC);
            }
            if (this.vVa != null) {
                aVar.e(7, this.vVa);
            }
            if (this.vVb != null) {
                aVar.e(8, this.vVb);
            }
            if (this.pbo != null) {
                aVar.e(9, this.pbo);
            }
            if (this.vJD != null) {
                aVar.e(10, this.vJD);
            }
            if (this.vVc != null) {
                aVar.e(11, this.vVc);
            }
            if (this.vVd != null) {
                aVar.e(12, this.vVd);
            }
            if (this.vVe != null) {
                aVar.e(13, this.vVe);
            }
            if (this.vVf != null) {
                aVar.e(14, this.vVf);
            }
            if (this.vVg != null) {
                aVar.e(15, this.vVg);
            }
            if (this.cFl != null) {
                aVar.e(16, this.cFl);
            }
            if (this.vVh != null) {
                aVar.e(17, this.vVh);
            }
            if (this.vVi != null) {
                aVar.e(18, this.vVi);
            }
            if (this.vVj != null) {
                aVar.e(19, this.vVj);
            }
            if (this.vVk != null) {
                aVar.e(20, this.vVk);
            }
            if (this.vVl != null) {
                aVar.e(21, this.vVl);
            }
            if (this.pbp != null) {
                aVar.e(22, this.pbp);
            }
            if (this.vVm != null) {
                aVar.e(23, this.vVm);
            }
            if (this.vVn != null) {
                aVar.e(24, this.vVn);
            }
            if (this.vVo != null) {
                aVar.e(25, this.vVo);
            }
            if (this.uYI != null) {
                aVar.e(26, this.uYI);
            }
            aVar.iz(27, this.vVp);
            if (this.vVq != null) {
                aVar.e(28, this.vVq);
            }
            if (this.vVr != null) {
                aVar.e(29, this.vVr);
            }
            if (this.vVs != null) {
                aVar.e(30, this.vVs);
            }
            if (this.vVt != null) {
                aVar.e(31, this.vVt);
            }
            if (this.vVu != null) {
                aVar.e(32, this.vVu);
            }
            if (this.vVv != null) {
                aVar.e(33, this.vVv);
            }
            if (this.vVw != null) {
                aVar.e(34, this.vVw);
            }
            if (this.vJE != null) {
                aVar.e(35, this.vJE);
            }
            if (this.vVx != null) {
                aVar.e(36, this.vVx);
            }
            if (this.vVy != null) {
                aVar.e(37, this.vVy);
            }
            if (this.vVz != null) {
                aVar.e(38, this.vVz);
            }
            if (this.vVA != null) {
                aVar.e(39, this.vVA);
            }
            if (this.vVB != null) {
                aVar.e(40, this.vVB);
            }
            if (this.vVC != null) {
                aVar.e(41, this.vVC);
            }
            if (this.vVD != null) {
                aVar.e(42, this.vVD);
            }
            if (this.vVE != null) {
                aVar.e(43, this.vVE);
            }
            aVar.iz(44, this.vVF);
            aVar.iz(45, this.vVG);
            if (this.vVH != null) {
                aVar.e(46, this.vVH);
            }
            if (this.kfM != null) {
                aVar.e(47, this.kfM);
            }
            if (this.vVI != null) {
                aVar.e(48, this.vVI);
            }
            if (this.vJv != null) {
                aVar.e(49, this.vJv);
            }
            if (this.vJw != null) {
                aVar.e(50, this.vJw);
            }
            if (this.vVJ != null) {
                aVar.e(51, this.vVJ);
            }
            if (this.vVK != null) {
                aVar.e(52, this.vVK);
            }
            if (this.vVL != null) {
                aVar.e(53, this.vVL);
            }
            aVar.ai(54, this.vVM);
            if (this.vVN != null) {
                aVar.e(55, this.vVN);
            }
            if (this.vVO != null) {
                aVar.e(56, this.vVO);
            }
            aVar.iz(57, this.vVP);
            aVar.iz(58, this.vVQ);
            aVar.iz(59, this.vVR);
            AppMethodBeat.o(56742);
            return 0;
        } else if (i == 1) {
            if (this.vUZ != null) {
                f = e.a.a.b.b.a.f(1, this.vUZ) + 0;
            } else {
                f = 0;
            }
            if (this.tyG != null) {
                f += e.a.a.b.b.a.f(2, this.tyG);
            }
            if (this.nuL != null) {
                f += e.a.a.b.b.a.f(3, this.nuL);
            }
            if (this.tyH != null) {
                f += e.a.a.b.b.a.f(4, this.tyH);
            }
            if (this.pbn != null) {
                f += e.a.a.b.b.a.f(5, this.pbn);
            }
            if (this.vJC != null) {
                f += e.a.a.b.b.a.f(6, this.vJC);
            }
            if (this.vVa != null) {
                f += e.a.a.b.b.a.f(7, this.vVa);
            }
            if (this.vVb != null) {
                f += e.a.a.b.b.a.f(8, this.vVb);
            }
            if (this.pbo != null) {
                f += e.a.a.b.b.a.f(9, this.pbo);
            }
            if (this.vJD != null) {
                f += e.a.a.b.b.a.f(10, this.vJD);
            }
            if (this.vVc != null) {
                f += e.a.a.b.b.a.f(11, this.vVc);
            }
            if (this.vVd != null) {
                f += e.a.a.b.b.a.f(12, this.vVd);
            }
            if (this.vVe != null) {
                f += e.a.a.b.b.a.f(13, this.vVe);
            }
            if (this.vVf != null) {
                f += e.a.a.b.b.a.f(14, this.vVf);
            }
            if (this.vVg != null) {
                f += e.a.a.b.b.a.f(15, this.vVg);
            }
            if (this.cFl != null) {
                f += e.a.a.b.b.a.f(16, this.cFl);
            }
            if (this.vVh != null) {
                f += e.a.a.b.b.a.f(17, this.vVh);
            }
            if (this.vVi != null) {
                f += e.a.a.b.b.a.f(18, this.vVi);
            }
            if (this.vVj != null) {
                f += e.a.a.b.b.a.f(19, this.vVj);
            }
            if (this.vVk != null) {
                f += e.a.a.b.b.a.f(20, this.vVk);
            }
            if (this.vVl != null) {
                f += e.a.a.b.b.a.f(21, this.vVl);
            }
            if (this.pbp != null) {
                f += e.a.a.b.b.a.f(22, this.pbp);
            }
            if (this.vVm != null) {
                f += e.a.a.b.b.a.f(23, this.vVm);
            }
            if (this.vVn != null) {
                f += e.a.a.b.b.a.f(24, this.vVn);
            }
            if (this.vVo != null) {
                f += e.a.a.b.b.a.f(25, this.vVo);
            }
            if (this.uYI != null) {
                f += e.a.a.b.b.a.f(26, this.uYI);
            }
            f += e.a.a.b.b.a.bs(27, this.vVp);
            if (this.vVq != null) {
                f += e.a.a.b.b.a.f(28, this.vVq);
            }
            if (this.vVr != null) {
                f += e.a.a.b.b.a.f(29, this.vVr);
            }
            if (this.vVs != null) {
                f += e.a.a.b.b.a.f(30, this.vVs);
            }
            if (this.vVt != null) {
                f += e.a.a.b.b.a.f(31, this.vVt);
            }
            if (this.vVu != null) {
                f += e.a.a.b.b.a.f(32, this.vVu);
            }
            if (this.vVv != null) {
                f += e.a.a.b.b.a.f(33, this.vVv);
            }
            if (this.vVw != null) {
                f += e.a.a.b.b.a.f(34, this.vVw);
            }
            if (this.vJE != null) {
                f += e.a.a.b.b.a.f(35, this.vJE);
            }
            if (this.vVx != null) {
                f += e.a.a.b.b.a.f(36, this.vVx);
            }
            if (this.vVy != null) {
                f += e.a.a.b.b.a.f(37, this.vVy);
            }
            if (this.vVz != null) {
                f += e.a.a.b.b.a.f(38, this.vVz);
            }
            if (this.vVA != null) {
                f += e.a.a.b.b.a.f(39, this.vVA);
            }
            if (this.vVB != null) {
                f += e.a.a.b.b.a.f(40, this.vVB);
            }
            if (this.vVC != null) {
                f += e.a.a.b.b.a.f(41, this.vVC);
            }
            if (this.vVD != null) {
                f += e.a.a.b.b.a.f(42, this.vVD);
            }
            if (this.vVE != null) {
                f += e.a.a.b.b.a.f(43, this.vVE);
            }
            f = (f + e.a.a.b.b.a.bs(44, this.vVF)) + e.a.a.b.b.a.bs(45, this.vVG);
            if (this.vVH != null) {
                f += e.a.a.b.b.a.f(46, this.vVH);
            }
            if (this.kfM != null) {
                f += e.a.a.b.b.a.f(47, this.kfM);
            }
            if (this.vVI != null) {
                f += e.a.a.b.b.a.f(48, this.vVI);
            }
            if (this.vJv != null) {
                f += e.a.a.b.b.a.f(49, this.vJv);
            }
            if (this.vJw != null) {
                f += e.a.a.b.b.a.f(50, this.vJw);
            }
            if (this.vVJ != null) {
                f += e.a.a.b.b.a.f(51, this.vVJ);
            }
            if (this.vVK != null) {
                f += e.a.a.b.b.a.f(52, this.vVK);
            }
            if (this.vVL != null) {
                f += e.a.a.b.b.a.f(53, this.vVL);
            }
            f += e.a.a.b.b.a.o(54, this.vVM);
            if (this.vVN != null) {
                f += e.a.a.b.b.a.f(55, this.vVN);
            }
            if (this.vVO != null) {
                f += e.a.a.b.b.a.f(56, this.vVO);
            }
            int bs = ((f + e.a.a.b.b.a.bs(57, this.vVP)) + e.a.a.b.b.a.bs(58, this.vVQ)) + e.a.a.b.b.a.bs(59, this.vVR);
            AppMethodBeat.o(56742);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56742);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oq oqVar = (oq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oqVar.vUZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 2:
                    oqVar.tyG = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 3:
                    oqVar.nuL = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 4:
                    oqVar.tyH = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 5:
                    oqVar.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 6:
                    oqVar.vJC = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 7:
                    oqVar.vVa = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 8:
                    oqVar.vVb = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 9:
                    oqVar.pbo = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 10:
                    oqVar.vJD = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 11:
                    oqVar.vVc = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 12:
                    oqVar.vVd = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 13:
                    oqVar.vVe = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 14:
                    oqVar.vVf = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 15:
                    oqVar.vVg = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 16:
                    oqVar.cFl = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 17:
                    oqVar.vVh = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 18:
                    oqVar.vVi = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 19:
                    oqVar.vVj = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 20:
                    oqVar.vVk = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 21:
                    oqVar.vVl = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 22:
                    oqVar.pbp = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 23:
                    oqVar.vVm = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 24:
                    oqVar.vVn = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 25:
                    oqVar.vVo = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 26:
                    oqVar.uYI = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 27:
                    oqVar.vVp = aVar3.BTU.vd();
                    AppMethodBeat.o(56742);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    oqVar.vVq = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 29:
                    oqVar.vVr = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 30:
                    oqVar.vVs = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 31:
                    oqVar.vVt = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 32:
                    oqVar.vVu = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 33:
                    oqVar.vVv = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 34:
                    oqVar.vVw = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 35:
                    oqVar.vJE = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 36:
                    oqVar.vVx = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    oqVar.vVy = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 38:
                    oqVar.vVz = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 39:
                    oqVar.vVA = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 40:
                    oqVar.vVB = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 41:
                    oqVar.vVC = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 42:
                    oqVar.vVD = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 43:
                    oqVar.vVE = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    oqVar.vVF = aVar3.BTU.vd();
                    AppMethodBeat.o(56742);
                    return 0;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    oqVar.vVG = aVar3.BTU.vd();
                    AppMethodBeat.o(56742);
                    return 0;
                case 46:
                    oqVar.vVH = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    oqVar.kfM = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 48:
                    oqVar.vVI = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    oqVar.vJv = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 50:
                    oqVar.vJw = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 51:
                    oqVar.vVJ = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case 52:
                    oqVar.vVK = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    oqVar.vVL = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    oqVar.vVM = aVar3.BTU.ve();
                    AppMethodBeat.o(56742);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                    oqVar.vVN = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case FileUtils.S_IRWXG /*56*/:
                    oqVar.vVO = aVar3.BTU.readString();
                    AppMethodBeat.o(56742);
                    return 0;
                case e.CTRL_INDEX /*57*/:
                    oqVar.vVP = aVar3.BTU.vd();
                    AppMethodBeat.o(56742);
                    return 0;
                case aa.CTRL_INDEX /*58*/:
                    oqVar.vVQ = aVar3.BTU.vd();
                    AppMethodBeat.o(56742);
                    return 0;
                case au.CTRL_INDEX /*59*/:
                    oqVar.vVR = aVar3.BTU.vd();
                    AppMethodBeat.o(56742);
                    return 0;
                default:
                    AppMethodBeat.o(56742);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56742);
            return -1;
        }
    }
}
