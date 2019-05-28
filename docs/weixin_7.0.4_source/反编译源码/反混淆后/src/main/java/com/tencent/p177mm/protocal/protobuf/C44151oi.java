package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import org.xwalk.core.XWalkEnvironment;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.oi */
public final class C44151oi extends C1331a {
    public String color;
    public String csB;
    public int iAd;
    public String kCx;
    public String kbU;
    public String kbV;
    public String kbW;
    public String kdf;
    public String kdg;
    public String source;
    public String title;
    public String vTT;
    public int vTU;
    public String vTV;
    public LinkedList<C23446tm> vTW = new LinkedList();
    public LinkedList<C23446tm> vTX = new LinkedList();
    public String vTY;
    public String vTZ;
    public C23446tm vUA;
    public C30244xt vUB;
    public boolean vUC;
    public int vUD;
    public boolean vUE;
    public boolean vUF;
    public C40543lh vUG;
    public String vUH;
    public String vUI;
    public int vUa;
    public String vUb;
    public String vUc;
    public int vUd;
    public String vUe;
    public String vUf;
    public long vUg;
    public String vUh;
    public String vUi;
    public String vUj;
    public C15368nz vUk;
    public String vUl;
    public String vUm;
    public int vUn;
    public C15395wy vUo;
    public cma vUp;
    public aci vUq;
    public C15320ax vUr;
    public int vUs;
    public int vUt;
    public String vUu;
    public int vUv;
    public String vUw;
    public int vUx;
    public C23446tm vUy;
    public String vUz;

    public C44151oi() {
        AppMethodBeat.m2504i(89042);
        AppMethodBeat.m2505o(89042);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89043);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.kbU != null) {
                c6093a.mo13475e(1, this.kbU);
            }
            if (this.kbV != null) {
                c6093a.mo13475e(2, this.kbV);
            }
            if (this.csB != null) {
                c6093a.mo13475e(3, this.csB);
            }
            if (this.vTT != null) {
                c6093a.mo13475e(4, this.vTT);
            }
            c6093a.mo13480iz(5, this.vTU);
            c6093a.mo13480iz(6, this.iAd);
            if (this.kdg != null) {
                c6093a.mo13475e(7, this.kdg);
            }
            if (this.title != null) {
                c6093a.mo13475e(8, this.title);
            }
            if (this.kbW != null) {
                c6093a.mo13475e(9, this.kbW);
            }
            if (this.color != null) {
                c6093a.mo13475e(10, this.color);
            }
            if (this.kCx != null) {
                c6093a.mo13475e(11, this.kCx);
            }
            if (this.vTV != null) {
                c6093a.mo13475e(12, this.vTV);
            }
            c6093a.mo13474e(13, 8, this.vTW);
            c6093a.mo13474e(14, 8, this.vTX);
            if (this.vTY != null) {
                c6093a.mo13475e(15, this.vTY);
            }
            if (this.vTZ != null) {
                c6093a.mo13475e(16, this.vTZ);
            }
            if (this.source != null) {
                c6093a.mo13475e(17, this.source);
            }
            c6093a.mo13480iz(18, this.vUa);
            if (this.kdf != null) {
                c6093a.mo13475e(19, this.kdf);
            }
            if (this.vUb != null) {
                c6093a.mo13475e(20, this.vUb);
            }
            if (this.vUc != null) {
                c6093a.mo13475e(21, this.vUc);
            }
            c6093a.mo13480iz(22, this.vUd);
            if (this.vUe != null) {
                c6093a.mo13475e(23, this.vUe);
            }
            if (this.vUf != null) {
                c6093a.mo13475e(24, this.vUf);
            }
            c6093a.mo13472ai(25, this.vUg);
            if (this.vUh != null) {
                c6093a.mo13475e(26, this.vUh);
            }
            if (this.vUi != null) {
                c6093a.mo13475e(27, this.vUi);
            }
            if (this.vUj != null) {
                c6093a.mo13475e(28, this.vUj);
            }
            if (this.vUk != null) {
                c6093a.mo13479iy(29, this.vUk.computeSize());
                this.vUk.writeFields(c6093a);
            }
            if (this.vUl != null) {
                c6093a.mo13475e(30, this.vUl);
            }
            if (this.vUm != null) {
                c6093a.mo13475e(31, this.vUm);
            }
            c6093a.mo13480iz(32, this.vUn);
            if (this.vUo != null) {
                c6093a.mo13479iy(33, this.vUo.computeSize());
                this.vUo.writeFields(c6093a);
            }
            if (this.vUp != null) {
                c6093a.mo13479iy(34, this.vUp.computeSize());
                this.vUp.writeFields(c6093a);
            }
            if (this.vUq != null) {
                c6093a.mo13479iy(35, this.vUq.computeSize());
                this.vUq.writeFields(c6093a);
            }
            if (this.vUr != null) {
                c6093a.mo13479iy(36, this.vUr.computeSize());
                this.vUr.writeFields(c6093a);
            }
            c6093a.mo13480iz(37, this.vUs);
            c6093a.mo13480iz(38, this.vUt);
            if (this.vUu != null) {
                c6093a.mo13475e(39, this.vUu);
            }
            c6093a.mo13480iz(40, this.vUv);
            if (this.vUw != null) {
                c6093a.mo13475e(41, this.vUw);
            }
            c6093a.mo13480iz(42, this.vUx);
            if (this.vUy != null) {
                c6093a.mo13479iy(43, this.vUy.computeSize());
                this.vUy.writeFields(c6093a);
            }
            if (this.vUz != null) {
                c6093a.mo13475e(44, this.vUz);
            }
            if (this.vUA != null) {
                c6093a.mo13479iy(45, this.vUA.computeSize());
                this.vUA.writeFields(c6093a);
            }
            if (this.vUB != null) {
                c6093a.mo13479iy(46, this.vUB.computeSize());
                this.vUB.writeFields(c6093a);
            }
            c6093a.mo13471aO(47, this.vUC);
            c6093a.mo13480iz(48, this.vUD);
            c6093a.mo13471aO(49, this.vUE);
            c6093a.mo13471aO(50, this.vUF);
            if (this.vUG != null) {
                c6093a.mo13479iy(51, this.vUG.computeSize());
                this.vUG.writeFields(c6093a);
            }
            if (this.vUH != null) {
                c6093a.mo13475e(52, this.vUH);
            }
            if (this.vUI != null) {
                c6093a.mo13475e(53, this.vUI);
            }
            AppMethodBeat.m2505o(89043);
            return 0;
        } else if (i == 1) {
            if (this.kbU != null) {
                f = C6091a.m9575f(1, this.kbU) + 0;
            } else {
                f = 0;
            }
            if (this.kbV != null) {
                f += C6091a.m9575f(2, this.kbV);
            }
            if (this.csB != null) {
                f += C6091a.m9575f(3, this.csB);
            }
            if (this.vTT != null) {
                f += C6091a.m9575f(4, this.vTT);
            }
            f = (f + C6091a.m9572bs(5, this.vTU)) + C6091a.m9572bs(6, this.iAd);
            if (this.kdg != null) {
                f += C6091a.m9575f(7, this.kdg);
            }
            if (this.title != null) {
                f += C6091a.m9575f(8, this.title);
            }
            if (this.kbW != null) {
                f += C6091a.m9575f(9, this.kbW);
            }
            if (this.color != null) {
                f += C6091a.m9575f(10, this.color);
            }
            if (this.kCx != null) {
                f += C6091a.m9575f(11, this.kCx);
            }
            if (this.vTV != null) {
                f += C6091a.m9575f(12, this.vTV);
            }
            f = (f + C6087a.m9552c(13, 8, this.vTW)) + C6087a.m9552c(14, 8, this.vTX);
            if (this.vTY != null) {
                f += C6091a.m9575f(15, this.vTY);
            }
            if (this.vTZ != null) {
                f += C6091a.m9575f(16, this.vTZ);
            }
            if (this.source != null) {
                f += C6091a.m9575f(17, this.source);
            }
            f += C6091a.m9572bs(18, this.vUa);
            if (this.kdf != null) {
                f += C6091a.m9575f(19, this.kdf);
            }
            if (this.vUb != null) {
                f += C6091a.m9575f(20, this.vUb);
            }
            if (this.vUc != null) {
                f += C6091a.m9575f(21, this.vUc);
            }
            f += C6091a.m9572bs(22, this.vUd);
            if (this.vUe != null) {
                f += C6091a.m9575f(23, this.vUe);
            }
            if (this.vUf != null) {
                f += C6091a.m9575f(24, this.vUf);
            }
            f += C6091a.m9578o(25, this.vUg);
            if (this.vUh != null) {
                f += C6091a.m9575f(26, this.vUh);
            }
            if (this.vUi != null) {
                f += C6091a.m9575f(27, this.vUi);
            }
            if (this.vUj != null) {
                f += C6091a.m9575f(28, this.vUj);
            }
            if (this.vUk != null) {
                f += C6087a.m9557ix(29, this.vUk.computeSize());
            }
            if (this.vUl != null) {
                f += C6091a.m9575f(30, this.vUl);
            }
            if (this.vUm != null) {
                f += C6091a.m9575f(31, this.vUm);
            }
            f += C6091a.m9572bs(32, this.vUn);
            if (this.vUo != null) {
                f += C6087a.m9557ix(33, this.vUo.computeSize());
            }
            if (this.vUp != null) {
                f += C6087a.m9557ix(34, this.vUp.computeSize());
            }
            if (this.vUq != null) {
                f += C6087a.m9557ix(35, this.vUq.computeSize());
            }
            if (this.vUr != null) {
                f += C6087a.m9557ix(36, this.vUr.computeSize());
            }
            f = (f + C6091a.m9572bs(37, this.vUs)) + C6091a.m9572bs(38, this.vUt);
            if (this.vUu != null) {
                f += C6091a.m9575f(39, this.vUu);
            }
            f += C6091a.m9572bs(40, this.vUv);
            if (this.vUw != null) {
                f += C6091a.m9575f(41, this.vUw);
            }
            f += C6091a.m9572bs(42, this.vUx);
            if (this.vUy != null) {
                f += C6087a.m9557ix(43, this.vUy.computeSize());
            }
            if (this.vUz != null) {
                f += C6091a.m9575f(44, this.vUz);
            }
            if (this.vUA != null) {
                f += C6087a.m9557ix(45, this.vUA.computeSize());
            }
            if (this.vUB != null) {
                f += C6087a.m9557ix(46, this.vUB.computeSize());
            }
            f = (((f + (C6091a.m9576fv(47) + 1)) + C6091a.m9572bs(48, this.vUD)) + (C6091a.m9576fv(49) + 1)) + (C6091a.m9576fv(50) + 1);
            if (this.vUG != null) {
                f += C6087a.m9557ix(51, this.vUG.computeSize());
            }
            if (this.vUH != null) {
                f += C6091a.m9575f(52, this.vUH);
            }
            if (this.vUI != null) {
                f += C6091a.m9575f(53, this.vUI);
            }
            AppMethodBeat.m2505o(89043);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vTW.clear();
            this.vTX.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89043);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44151oi c44151oi = (C44151oi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C23446tm c23446tm;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c44151oi.kbU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 2:
                    c44151oi.kbV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 3:
                    c44151oi.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 4:
                    c44151oi.vTT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 5:
                    c44151oi.vTU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 6:
                    c44151oi.iAd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 7:
                    c44151oi.kdg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 8:
                    c44151oi.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 9:
                    c44151oi.kbW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 10:
                    c44151oi.color = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 11:
                    c44151oi.kCx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 12:
                    c44151oi.vTV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vTW.add(c23446tm);
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vTX.add(c23446tm);
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 15:
                    c44151oi.vTY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 16:
                    c44151oi.vTZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 17:
                    c44151oi.source = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 18:
                    c44151oi.vUa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 19:
                    c44151oi.kdf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 20:
                    c44151oi.vUb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 21:
                    c44151oi.vUc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 22:
                    c44151oi.vUd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 23:
                    c44151oi.vUe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 24:
                    c44151oi.vUf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 25:
                    c44151oi.vUg = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 26:
                    c44151oi.vUh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 27:
                    c44151oi.vUi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    c44151oi.vUj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 29:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15368nz c15368nz = new C15368nz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15368nz.populateBuilderWithField(c6086a3, c15368nz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vUk = c15368nz;
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 30:
                    c44151oi.vUl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 31:
                    c44151oi.vUm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 32:
                    c44151oi.vUn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 33:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15395wy c15395wy = new C15395wy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15395wy.populateBuilderWithField(c6086a3, c15395wy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vUo = c15395wy;
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 34:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cma cma = new cma();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cma.populateBuilderWithField(c6086a3, cma, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vUp = cma;
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 35:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aci aci = new aci();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aci.populateBuilderWithField(c6086a3, aci, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vUq = aci;
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 36:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15320ax c15320ax = new C15320ax();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15320ax.populateBuilderWithField(c6086a3, c15320ax, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vUr = c15320ax;
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    c44151oi.vUs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 38:
                    c44151oi.vUt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 39:
                    c44151oi.vUu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 40:
                    c44151oi.vUv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 41:
                    c44151oi.vUw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 42:
                    c44151oi.vUx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 43:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vUy = c23446tm;
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    c44151oi.vUz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vUA = c23446tm;
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 46:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30244xt c30244xt = new C30244xt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30244xt.populateBuilderWithField(c6086a3, c30244xt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vUB = c30244xt;
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    c44151oi.vUC = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 48:
                    c44151oi.vUD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    c44151oi.vUE = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 50:
                    c44151oi.vUF = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 51:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40543lh c40543lh = new C40543lh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40543lh.populateBuilderWithField(c6086a3, c40543lh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44151oi.vUG = c40543lh;
                    }
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case 52:
                    c44151oi.vUH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    c44151oi.vUI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89043);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89043);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89043);
            return -1;
        }
    }
}
