package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import com.tencent.wcdb.FileUtils;
import org.xwalk.core.XWalkEnvironment;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.oq */
public final class C40553oq extends C1331a {
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

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56742);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vUZ != null) {
                c6093a.mo13475e(1, this.vUZ);
            }
            if (this.tyG != null) {
                c6093a.mo13475e(2, this.tyG);
            }
            if (this.nuL != null) {
                c6093a.mo13475e(3, this.nuL);
            }
            if (this.tyH != null) {
                c6093a.mo13475e(4, this.tyH);
            }
            if (this.pbn != null) {
                c6093a.mo13475e(5, this.pbn);
            }
            if (this.vJC != null) {
                c6093a.mo13475e(6, this.vJC);
            }
            if (this.vVa != null) {
                c6093a.mo13475e(7, this.vVa);
            }
            if (this.vVb != null) {
                c6093a.mo13475e(8, this.vVb);
            }
            if (this.pbo != null) {
                c6093a.mo13475e(9, this.pbo);
            }
            if (this.vJD != null) {
                c6093a.mo13475e(10, this.vJD);
            }
            if (this.vVc != null) {
                c6093a.mo13475e(11, this.vVc);
            }
            if (this.vVd != null) {
                c6093a.mo13475e(12, this.vVd);
            }
            if (this.vVe != null) {
                c6093a.mo13475e(13, this.vVe);
            }
            if (this.vVf != null) {
                c6093a.mo13475e(14, this.vVf);
            }
            if (this.vVg != null) {
                c6093a.mo13475e(15, this.vVg);
            }
            if (this.cFl != null) {
                c6093a.mo13475e(16, this.cFl);
            }
            if (this.vVh != null) {
                c6093a.mo13475e(17, this.vVh);
            }
            if (this.vVi != null) {
                c6093a.mo13475e(18, this.vVi);
            }
            if (this.vVj != null) {
                c6093a.mo13475e(19, this.vVj);
            }
            if (this.vVk != null) {
                c6093a.mo13475e(20, this.vVk);
            }
            if (this.vVl != null) {
                c6093a.mo13475e(21, this.vVl);
            }
            if (this.pbp != null) {
                c6093a.mo13475e(22, this.pbp);
            }
            if (this.vVm != null) {
                c6093a.mo13475e(23, this.vVm);
            }
            if (this.vVn != null) {
                c6093a.mo13475e(24, this.vVn);
            }
            if (this.vVo != null) {
                c6093a.mo13475e(25, this.vVo);
            }
            if (this.uYI != null) {
                c6093a.mo13475e(26, this.uYI);
            }
            c6093a.mo13480iz(27, this.vVp);
            if (this.vVq != null) {
                c6093a.mo13475e(28, this.vVq);
            }
            if (this.vVr != null) {
                c6093a.mo13475e(29, this.vVr);
            }
            if (this.vVs != null) {
                c6093a.mo13475e(30, this.vVs);
            }
            if (this.vVt != null) {
                c6093a.mo13475e(31, this.vVt);
            }
            if (this.vVu != null) {
                c6093a.mo13475e(32, this.vVu);
            }
            if (this.vVv != null) {
                c6093a.mo13475e(33, this.vVv);
            }
            if (this.vVw != null) {
                c6093a.mo13475e(34, this.vVw);
            }
            if (this.vJE != null) {
                c6093a.mo13475e(35, this.vJE);
            }
            if (this.vVx != null) {
                c6093a.mo13475e(36, this.vVx);
            }
            if (this.vVy != null) {
                c6093a.mo13475e(37, this.vVy);
            }
            if (this.vVz != null) {
                c6093a.mo13475e(38, this.vVz);
            }
            if (this.vVA != null) {
                c6093a.mo13475e(39, this.vVA);
            }
            if (this.vVB != null) {
                c6093a.mo13475e(40, this.vVB);
            }
            if (this.vVC != null) {
                c6093a.mo13475e(41, this.vVC);
            }
            if (this.vVD != null) {
                c6093a.mo13475e(42, this.vVD);
            }
            if (this.vVE != null) {
                c6093a.mo13475e(43, this.vVE);
            }
            c6093a.mo13480iz(44, this.vVF);
            c6093a.mo13480iz(45, this.vVG);
            if (this.vVH != null) {
                c6093a.mo13475e(46, this.vVH);
            }
            if (this.kfM != null) {
                c6093a.mo13475e(47, this.kfM);
            }
            if (this.vVI != null) {
                c6093a.mo13475e(48, this.vVI);
            }
            if (this.vJv != null) {
                c6093a.mo13475e(49, this.vJv);
            }
            if (this.vJw != null) {
                c6093a.mo13475e(50, this.vJw);
            }
            if (this.vVJ != null) {
                c6093a.mo13475e(51, this.vVJ);
            }
            if (this.vVK != null) {
                c6093a.mo13475e(52, this.vVK);
            }
            if (this.vVL != null) {
                c6093a.mo13475e(53, this.vVL);
            }
            c6093a.mo13472ai(54, this.vVM);
            if (this.vVN != null) {
                c6093a.mo13475e(55, this.vVN);
            }
            if (this.vVO != null) {
                c6093a.mo13475e(56, this.vVO);
            }
            c6093a.mo13480iz(57, this.vVP);
            c6093a.mo13480iz(58, this.vVQ);
            c6093a.mo13480iz(59, this.vVR);
            AppMethodBeat.m2505o(56742);
            return 0;
        } else if (i == 1) {
            if (this.vUZ != null) {
                f = C6091a.m9575f(1, this.vUZ) + 0;
            } else {
                f = 0;
            }
            if (this.tyG != null) {
                f += C6091a.m9575f(2, this.tyG);
            }
            if (this.nuL != null) {
                f += C6091a.m9575f(3, this.nuL);
            }
            if (this.tyH != null) {
                f += C6091a.m9575f(4, this.tyH);
            }
            if (this.pbn != null) {
                f += C6091a.m9575f(5, this.pbn);
            }
            if (this.vJC != null) {
                f += C6091a.m9575f(6, this.vJC);
            }
            if (this.vVa != null) {
                f += C6091a.m9575f(7, this.vVa);
            }
            if (this.vVb != null) {
                f += C6091a.m9575f(8, this.vVb);
            }
            if (this.pbo != null) {
                f += C6091a.m9575f(9, this.pbo);
            }
            if (this.vJD != null) {
                f += C6091a.m9575f(10, this.vJD);
            }
            if (this.vVc != null) {
                f += C6091a.m9575f(11, this.vVc);
            }
            if (this.vVd != null) {
                f += C6091a.m9575f(12, this.vVd);
            }
            if (this.vVe != null) {
                f += C6091a.m9575f(13, this.vVe);
            }
            if (this.vVf != null) {
                f += C6091a.m9575f(14, this.vVf);
            }
            if (this.vVg != null) {
                f += C6091a.m9575f(15, this.vVg);
            }
            if (this.cFl != null) {
                f += C6091a.m9575f(16, this.cFl);
            }
            if (this.vVh != null) {
                f += C6091a.m9575f(17, this.vVh);
            }
            if (this.vVi != null) {
                f += C6091a.m9575f(18, this.vVi);
            }
            if (this.vVj != null) {
                f += C6091a.m9575f(19, this.vVj);
            }
            if (this.vVk != null) {
                f += C6091a.m9575f(20, this.vVk);
            }
            if (this.vVl != null) {
                f += C6091a.m9575f(21, this.vVl);
            }
            if (this.pbp != null) {
                f += C6091a.m9575f(22, this.pbp);
            }
            if (this.vVm != null) {
                f += C6091a.m9575f(23, this.vVm);
            }
            if (this.vVn != null) {
                f += C6091a.m9575f(24, this.vVn);
            }
            if (this.vVo != null) {
                f += C6091a.m9575f(25, this.vVo);
            }
            if (this.uYI != null) {
                f += C6091a.m9575f(26, this.uYI);
            }
            f += C6091a.m9572bs(27, this.vVp);
            if (this.vVq != null) {
                f += C6091a.m9575f(28, this.vVq);
            }
            if (this.vVr != null) {
                f += C6091a.m9575f(29, this.vVr);
            }
            if (this.vVs != null) {
                f += C6091a.m9575f(30, this.vVs);
            }
            if (this.vVt != null) {
                f += C6091a.m9575f(31, this.vVt);
            }
            if (this.vVu != null) {
                f += C6091a.m9575f(32, this.vVu);
            }
            if (this.vVv != null) {
                f += C6091a.m9575f(33, this.vVv);
            }
            if (this.vVw != null) {
                f += C6091a.m9575f(34, this.vVw);
            }
            if (this.vJE != null) {
                f += C6091a.m9575f(35, this.vJE);
            }
            if (this.vVx != null) {
                f += C6091a.m9575f(36, this.vVx);
            }
            if (this.vVy != null) {
                f += C6091a.m9575f(37, this.vVy);
            }
            if (this.vVz != null) {
                f += C6091a.m9575f(38, this.vVz);
            }
            if (this.vVA != null) {
                f += C6091a.m9575f(39, this.vVA);
            }
            if (this.vVB != null) {
                f += C6091a.m9575f(40, this.vVB);
            }
            if (this.vVC != null) {
                f += C6091a.m9575f(41, this.vVC);
            }
            if (this.vVD != null) {
                f += C6091a.m9575f(42, this.vVD);
            }
            if (this.vVE != null) {
                f += C6091a.m9575f(43, this.vVE);
            }
            f = (f + C6091a.m9572bs(44, this.vVF)) + C6091a.m9572bs(45, this.vVG);
            if (this.vVH != null) {
                f += C6091a.m9575f(46, this.vVH);
            }
            if (this.kfM != null) {
                f += C6091a.m9575f(47, this.kfM);
            }
            if (this.vVI != null) {
                f += C6091a.m9575f(48, this.vVI);
            }
            if (this.vJv != null) {
                f += C6091a.m9575f(49, this.vJv);
            }
            if (this.vJw != null) {
                f += C6091a.m9575f(50, this.vJw);
            }
            if (this.vVJ != null) {
                f += C6091a.m9575f(51, this.vVJ);
            }
            if (this.vVK != null) {
                f += C6091a.m9575f(52, this.vVK);
            }
            if (this.vVL != null) {
                f += C6091a.m9575f(53, this.vVL);
            }
            f += C6091a.m9578o(54, this.vVM);
            if (this.vVN != null) {
                f += C6091a.m9575f(55, this.vVN);
            }
            if (this.vVO != null) {
                f += C6091a.m9575f(56, this.vVO);
            }
            int bs = ((f + C6091a.m9572bs(57, this.vVP)) + C6091a.m9572bs(58, this.vVQ)) + C6091a.m9572bs(59, this.vVR);
            AppMethodBeat.m2505o(56742);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56742);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40553oq c40553oq = (C40553oq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40553oq.vUZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 2:
                    c40553oq.tyG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 3:
                    c40553oq.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 4:
                    c40553oq.tyH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 5:
                    c40553oq.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 6:
                    c40553oq.vJC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 7:
                    c40553oq.vVa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 8:
                    c40553oq.vVb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 9:
                    c40553oq.pbo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 10:
                    c40553oq.vJD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 11:
                    c40553oq.vVc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 12:
                    c40553oq.vVd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 13:
                    c40553oq.vVe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 14:
                    c40553oq.vVf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 15:
                    c40553oq.vVg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 16:
                    c40553oq.cFl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 17:
                    c40553oq.vVh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 18:
                    c40553oq.vVi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 19:
                    c40553oq.vVj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 20:
                    c40553oq.vVk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 21:
                    c40553oq.vVl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 22:
                    c40553oq.pbp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 23:
                    c40553oq.vVm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 24:
                    c40553oq.vVn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 25:
                    c40553oq.vVo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 26:
                    c40553oq.uYI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 27:
                    c40553oq.vVp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    c40553oq.vVq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 29:
                    c40553oq.vVr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 30:
                    c40553oq.vVs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 31:
                    c40553oq.vVt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 32:
                    c40553oq.vVu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 33:
                    c40553oq.vVv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 34:
                    c40553oq.vVw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 35:
                    c40553oq.vJE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 36:
                    c40553oq.vVx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    c40553oq.vVy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 38:
                    c40553oq.vVz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 39:
                    c40553oq.vVA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 40:
                    c40553oq.vVB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 41:
                    c40553oq.vVC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 42:
                    c40553oq.vVD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 43:
                    c40553oq.vVE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    c40553oq.vVF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    c40553oq.vVG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 46:
                    c40553oq.vVH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    c40553oq.kfM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 48:
                    c40553oq.vVI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    c40553oq.vJv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 50:
                    c40553oq.vJw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 51:
                    c40553oq.vVJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case 52:
                    c40553oq.vVK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    c40553oq.vVL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    c40553oq.vVM = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                    c40553oq.vVN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case FileUtils.S_IRWXG /*56*/:
                    c40553oq.vVO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case C19410e.CTRL_INDEX /*57*/:
                    c40553oq.vVP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case C42464aa.CTRL_INDEX /*58*/:
                    c40553oq.vVQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                case C2206au.CTRL_INDEX /*59*/:
                    c40553oq.vVR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56742);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56742);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56742);
            return -1;
        }
    }
}
