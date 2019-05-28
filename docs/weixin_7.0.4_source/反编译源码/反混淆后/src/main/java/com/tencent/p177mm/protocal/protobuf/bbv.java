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
import java.util.LinkedList;
import org.xwalk.core.XWalkEnvironment;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bbv */
public final class bbv extends C1331a {
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
    public C7285uy wCa;
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
    public C7255cw wGq;
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
    public C7280qe wnN;
    public String wsM;
    public bts wyX;

    public bbv() {
        AppMethodBeat.m2504i(60046);
        AppMethodBeat.m2505o(60046);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60047);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(60047);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(60047);
                throw c6092b;
            } else if (this.wce == null) {
                c6092b = new C6092b("Not all required fields were included: PYInitial");
                AppMethodBeat.m2505o(60047);
                throw c6092b;
            } else if (this.wcf == null) {
                c6092b = new C6092b("Not all required fields were included: QuanPin");
                AppMethodBeat.m2505o(60047);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(60047);
                throw c6092b;
            } else {
                if (this.wcB != null) {
                    c6093a.mo13479iy(1, this.wcB.computeSize());
                    this.wcB.writeFields(c6093a);
                }
                if (this.wyX != null) {
                    c6093a.mo13479iy(2, this.wyX.computeSize());
                    this.wyX.writeFields(c6093a);
                }
                if (this.wce != null) {
                    c6093a.mo13479iy(3, this.wce.computeSize());
                    this.wce.writeFields(c6093a);
                }
                if (this.wcf != null) {
                    c6093a.mo13479iy(4, this.wcf.computeSize());
                    this.wcf.writeFields(c6093a);
                }
                c6093a.mo13480iz(5, this.guN);
                if (this.vEF != null) {
                    c6093a.mo13479iy(6, this.vEF.computeSize());
                    this.vEF.writeFields(c6093a);
                }
                c6093a.mo13480iz(7, this.wbu);
                c6093a.mo13480iz(8, this.wbv);
                c6093a.mo13480iz(9, this.wGb);
                if (this.wFK != null) {
                    c6093a.mo13479iy(10, this.wFK.computeSize());
                    this.wFK.writeFields(c6093a);
                }
                if (this.wFL != null) {
                    c6093a.mo13479iy(11, this.wFL.computeSize());
                    this.wFL.writeFields(c6093a);
                }
                if (this.wFM != null) {
                    c6093a.mo13479iy(12, this.wFM.computeSize());
                    this.wFM.writeFields(c6093a);
                }
                c6093a.mo13480iz(13, this.wbA);
                c6093a.mo13480iz(14, this.wbB);
                c6093a.mo13474e(15, 8, this.wbC);
                if (this.wGf != null) {
                    c6093a.mo13479iy(16, this.wGf.computeSize());
                    this.wGf.writeFields(c6093a);
                }
                c6093a.mo13480iz(17, this.wbE);
                c6093a.mo13480iz(18, this.wbF);
                if (this.guO != null) {
                    c6093a.mo13475e(19, this.guO);
                }
                if (this.guP != null) {
                    c6093a.mo13475e(20, this.guP);
                }
                if (this.guQ != null) {
                    c6093a.mo13475e(21, this.guQ);
                }
                c6093a.mo13480iz(22, this.guR);
                c6093a.mo13480iz(23, this.wGg);
                c6093a.mo13480iz(24, this.wBT);
                if (this.wBU != null) {
                    c6093a.mo13475e(25, this.wBU);
                }
                c6093a.mo13480iz(26, this.wGh);
                c6093a.mo13480iz(27, this.vFH);
                if (this.wBV != null) {
                    c6093a.mo13475e(28, this.wBV);
                }
                if (this.wsM != null) {
                    c6093a.mo13475e(29, this.wsM);
                }
                if (this.guS != null) {
                    c6093a.mo13475e(30, this.guS);
                }
                if (this.wGi != null) {
                    c6093a.mo13475e(31, this.wGi);
                }
                if (this.wBW != null) {
                    c6093a.mo13475e(32, this.wBW);
                }
                c6093a.mo13480iz(33, this.wBX);
                c6093a.mo13480iz(34, this.guU);
                c6093a.mo13480iz(35, this.guT);
                if (this.guV != null) {
                    c6093a.mo13475e(36, this.guV);
                }
                if (this.wBZ != null) {
                    c6093a.mo13479iy(37, this.wBZ.computeSize());
                    this.wBZ.writeFields(c6093a);
                }
                if (this.guW != null) {
                    c6093a.mo13475e(38, this.guW);
                }
                if (this.vXm != null) {
                    c6093a.mo13475e(39, this.vXm);
                }
                if (this.vXn != null) {
                    c6093a.mo13475e(40, this.vXn);
                }
                if (this.guX != null) {
                    c6093a.mo13475e(41, this.guX);
                }
                if (this.wCa != null) {
                    c6093a.mo13479iy(42, this.wCa.computeSize());
                    this.wCa.writeFields(c6093a);
                }
                if (this.wGj != null) {
                    c6093a.mo13475e(43, this.wGj);
                }
                if (this.wGk != null) {
                    c6093a.mo13475e(44, this.wGk);
                }
                if (this.wGl != null) {
                    c6093a.mo13475e(45, this.wGl);
                }
                if (this.wGm != null) {
                    c6093a.mo13475e(46, this.wGm);
                }
                if (this.wGn != null) {
                    c6093a.mo13475e(47, this.wGn);
                }
                if (this.wGo != null) {
                    c6093a.mo13475e(48, this.wGo);
                }
                if (this.wGp != null) {
                    c6093a.mo13475e(49, this.wGp);
                }
                if (this.wGq != null) {
                    c6093a.mo13479iy(50, this.wGq.computeSize());
                    this.wGq.writeFields(c6093a);
                }
                c6093a.mo13480iz(53, this.wGr);
                if (this.ndT != null) {
                    c6093a.mo13475e(54, this.ndT);
                }
                c6093a.mo13480iz(55, this.wGs);
                c6093a.mo13480iz(56, this.wGt);
                if (this.wnN != null) {
                    c6093a.mo13479iy(57, this.wnN.computeSize());
                    this.wnN.writeFields(c6093a);
                }
                c6093a.mo13480iz(58, this.wGu);
                if (this.vEA != null) {
                    c6093a.mo13475e(59, this.vEA);
                }
                if (this.wGv != null) {
                    c6093a.mo13475e(60, this.wGv);
                }
                if (this.wcD != null) {
                    c6093a.mo13475e(61, this.wcD);
                }
                if (this.wGw != null) {
                    c6093a.mo13479iy(62, this.wGw.computeSize());
                    this.wGw.writeFields(c6093a);
                }
                if (this.duq != null) {
                    c6093a.mo13475e(63, this.duq);
                }
                c6093a.mo13480iz(64, this.wGx);
                c6093a.mo13480iz(65, this.wcC);
                c6093a.mo13480iz(66, this.wGy);
                c6093a.mo13480iz(67, this.wGz);
                AppMethodBeat.m2505o(60047);
                return 0;
            }
        } else if (i == 1) {
            if (this.wcB != null) {
                ix = C6087a.m9557ix(1, this.wcB.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wyX != null) {
                ix += C6087a.m9557ix(2, this.wyX.computeSize());
            }
            if (this.wce != null) {
                ix += C6087a.m9557ix(3, this.wce.computeSize());
            }
            if (this.wcf != null) {
                ix += C6087a.m9557ix(4, this.wcf.computeSize());
            }
            ix += C6091a.m9572bs(5, this.guN);
            if (this.vEF != null) {
                ix += C6087a.m9557ix(6, this.vEF.computeSize());
            }
            ix = ((ix + C6091a.m9572bs(7, this.wbu)) + C6091a.m9572bs(8, this.wbv)) + C6091a.m9572bs(9, this.wGb);
            if (this.wFK != null) {
                ix += C6087a.m9557ix(10, this.wFK.computeSize());
            }
            if (this.wFL != null) {
                ix += C6087a.m9557ix(11, this.wFL.computeSize());
            }
            if (this.wFM != null) {
                ix += C6087a.m9557ix(12, this.wFM.computeSize());
            }
            ix = ((ix + C6091a.m9572bs(13, this.wbA)) + C6091a.m9572bs(14, this.wbB)) + C6087a.m9552c(15, 8, this.wbC);
            if (this.wGf != null) {
                ix += C6087a.m9557ix(16, this.wGf.computeSize());
            }
            ix = (ix + C6091a.m9572bs(17, this.wbE)) + C6091a.m9572bs(18, this.wbF);
            if (this.guO != null) {
                ix += C6091a.m9575f(19, this.guO);
            }
            if (this.guP != null) {
                ix += C6091a.m9575f(20, this.guP);
            }
            if (this.guQ != null) {
                ix += C6091a.m9575f(21, this.guQ);
            }
            ix = ((ix + C6091a.m9572bs(22, this.guR)) + C6091a.m9572bs(23, this.wGg)) + C6091a.m9572bs(24, this.wBT);
            if (this.wBU != null) {
                ix += C6091a.m9575f(25, this.wBU);
            }
            ix = (ix + C6091a.m9572bs(26, this.wGh)) + C6091a.m9572bs(27, this.vFH);
            if (this.wBV != null) {
                ix += C6091a.m9575f(28, this.wBV);
            }
            if (this.wsM != null) {
                ix += C6091a.m9575f(29, this.wsM);
            }
            if (this.guS != null) {
                ix += C6091a.m9575f(30, this.guS);
            }
            if (this.wGi != null) {
                ix += C6091a.m9575f(31, this.wGi);
            }
            if (this.wBW != null) {
                ix += C6091a.m9575f(32, this.wBW);
            }
            ix = ((ix + C6091a.m9572bs(33, this.wBX)) + C6091a.m9572bs(34, this.guU)) + C6091a.m9572bs(35, this.guT);
            if (this.guV != null) {
                ix += C6091a.m9575f(36, this.guV);
            }
            if (this.wBZ != null) {
                ix += C6087a.m9557ix(37, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                ix += C6091a.m9575f(38, this.guW);
            }
            if (this.vXm != null) {
                ix += C6091a.m9575f(39, this.vXm);
            }
            if (this.vXn != null) {
                ix += C6091a.m9575f(40, this.vXn);
            }
            if (this.guX != null) {
                ix += C6091a.m9575f(41, this.guX);
            }
            if (this.wCa != null) {
                ix += C6087a.m9557ix(42, this.wCa.computeSize());
            }
            if (this.wGj != null) {
                ix += C6091a.m9575f(43, this.wGj);
            }
            if (this.wGk != null) {
                ix += C6091a.m9575f(44, this.wGk);
            }
            if (this.wGl != null) {
                ix += C6091a.m9575f(45, this.wGl);
            }
            if (this.wGm != null) {
                ix += C6091a.m9575f(46, this.wGm);
            }
            if (this.wGn != null) {
                ix += C6091a.m9575f(47, this.wGn);
            }
            if (this.wGo != null) {
                ix += C6091a.m9575f(48, this.wGo);
            }
            if (this.wGp != null) {
                ix += C6091a.m9575f(49, this.wGp);
            }
            if (this.wGq != null) {
                ix += C6087a.m9557ix(50, this.wGq.computeSize());
            }
            ix += C6091a.m9572bs(53, this.wGr);
            if (this.ndT != null) {
                ix += C6091a.m9575f(54, this.ndT);
            }
            ix = (ix + C6091a.m9572bs(55, this.wGs)) + C6091a.m9572bs(56, this.wGt);
            if (this.wnN != null) {
                ix += C6087a.m9557ix(57, this.wnN.computeSize());
            }
            ix += C6091a.m9572bs(58, this.wGu);
            if (this.vEA != null) {
                ix += C6091a.m9575f(59, this.vEA);
            }
            if (this.wGv != null) {
                ix += C6091a.m9575f(60, this.wGv);
            }
            if (this.wcD != null) {
                ix += C6091a.m9575f(61, this.wcD);
            }
            if (this.wGw != null) {
                ix += C6087a.m9557ix(62, this.wGw.computeSize());
            }
            if (this.duq != null) {
                ix += C6091a.m9575f(63, this.duq);
            }
            int bs = (((ix + C6091a.m9572bs(64, this.wGx)) + C6091a.m9572bs(65, this.wcC)) + C6091a.m9572bs(66, this.wGy)) + C6091a.m9572bs(67, this.wGz);
            AppMethodBeat.m2505o(60047);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(60047);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(60047);
                throw c6092b;
            } else if (this.wce == null) {
                c6092b = new C6092b("Not all required fields were included: PYInitial");
                AppMethodBeat.m2505o(60047);
                throw c6092b;
            } else if (this.wcf == null) {
                c6092b = new C6092b("Not all required fields were included: QuanPin");
                AppMethodBeat.m2505o(60047);
                throw c6092b;
            } else if (this.vEF == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuf");
                AppMethodBeat.m2505o(60047);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(60047);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bbv bbv = (bbv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            bts bts;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wcB = bts;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wyX = bts;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wce = bts;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wcf = bts;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 5:
                    bbv.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 7:
                    bbv.wbu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 8:
                    bbv.wbv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 9:
                    bbv.wGb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wFK = bts;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wFL = bts;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wFM = bts;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 13:
                    bbv.wbA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 14:
                    bbv.wbB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btp btp = new btp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btp.populateBuilderWithField(c6086a3, btp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wbC.add(btp);
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wGf = bts;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 17:
                    bbv.wbE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 18:
                    bbv.wbF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 19:
                    bbv.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 20:
                    bbv.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 21:
                    bbv.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 22:
                    bbv.guR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 23:
                    bbv.wGg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 24:
                    bbv.wBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 25:
                    bbv.wBU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 26:
                    bbv.wGh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 27:
                    bbv.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    bbv.wBV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 29:
                    bbv.wsM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 30:
                    bbv.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 31:
                    bbv.wGi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 32:
                    bbv.wBW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 33:
                    bbv.wBX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 34:
                    bbv.guU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 35:
                    bbv.guT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 36:
                    bbv.guV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(c6086a3, ccl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wBZ = ccl;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 38:
                    bbv.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 39:
                    bbv.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 40:
                    bbv.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 41:
                    bbv.guX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 42:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7285uy c7285uy = new C7285uy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7285uy.populateBuilderWithField(c6086a3, c7285uy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wCa = c7285uy;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 43:
                    bbv.wGj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    bbv.wGk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    bbv.wGl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 46:
                    bbv.wGm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    bbv.wGn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 48:
                    bbv.wGo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    bbv.wGp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 50:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7255cw c7255cw = new C7255cw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7255cw.populateBuilderWithField(c6086a3, c7255cw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wGq = c7255cw;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    bbv.wGr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    bbv.ndT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                    bbv.wGs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case FileUtils.S_IRWXG /*56*/:
                    bbv.wGt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case C19410e.CTRL_INDEX /*57*/:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7280qe c7280qe = new C7280qe();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7280qe.populateBuilderWithField(c6086a3, c7280qe, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wnN = c7280qe;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case C42464aa.CTRL_INDEX /*58*/:
                    bbv.wGu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case C2206au.CTRL_INDEX /*59*/:
                    bbv.vEA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 60:
                    bbv.wGv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    bbv.wcD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 62:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkg bkg = new bkg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkg.populateBuilderWithField(c6086a3, bkg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbv.wGw = bkg;
                    }
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 63:
                    bbv.duq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 64:
                    bbv.wGx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 65:
                    bbv.wcC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 66:
                    bbv.wGy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                case 67:
                    bbv.wGz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60047);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60047);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60047);
            return -1;
        }
    }
}
