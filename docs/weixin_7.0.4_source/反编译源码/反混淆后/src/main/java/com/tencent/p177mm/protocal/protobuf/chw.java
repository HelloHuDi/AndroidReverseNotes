package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chw */
public final class chw extends C1331a {
    public long ctk;
    public boolean cui;
    public int fgI;
    public int fgJ;
    public String lvA;
    public String lvz;
    public String phw;
    public String qVw;
    public String source;
    public long timestamp;
    public String title;
    public String uaf;
    public String uag;
    public String uah;
    public String uai;
    public String uaj;
    public String ubA;
    public String videoUrl;
    public int voe;
    public LinkedList<bzs> wiH = new LinkedList();
    public String xgQ;
    public int xgR;
    public String xgS;
    public long xgT;
    public String xgU;
    public String xgV;
    public int xgW;
    public String xgX;
    public String xgY;
    public long xgZ;
    public long xha;
    public LinkedList<chy> xhb = new LinkedList();
    public LinkedList<abz> xhc = new LinkedList();
    public int xhd;
    public long xhe;
    public int xhf;
    public int xhg;
    public boolean xhh;
    public String xhi;

    public chw() {
        AppMethodBeat.m2504i(55710);
        AppMethodBeat.m2505o(55710);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55711);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.videoUrl != null) {
                c6093a.mo13475e(2, this.videoUrl);
            }
            if (this.xgQ != null) {
                c6093a.mo13475e(3, this.xgQ);
            }
            c6093a.mo13480iz(4, this.xgR);
            if (this.xgS != null) {
                c6093a.mo13475e(5, this.xgS);
            }
            c6093a.mo13480iz(6, this.fgJ);
            c6093a.mo13480iz(7, this.fgI);
            if (this.lvz != null) {
                c6093a.mo13475e(8, this.lvz);
            }
            if (this.lvA != null) {
                c6093a.mo13475e(9, this.lvA);
            }
            if (this.qVw != null) {
                c6093a.mo13475e(10, this.qVw);
            }
            if (this.uaf != null) {
                c6093a.mo13475e(11, this.uaf);
            }
            if (this.uag != null) {
                c6093a.mo13475e(12, this.uag);
            }
            if (this.uah != null) {
                c6093a.mo13475e(13, this.uah);
            }
            if (this.source != null) {
                c6093a.mo13475e(14, this.source);
            }
            if (this.phw != null) {
                c6093a.mo13475e(15, this.phw);
            }
            c6093a.mo13472ai(16, this.xgT);
            if (this.xgU != null) {
                c6093a.mo13475e(17, this.xgU);
            }
            if (this.xgV != null) {
                c6093a.mo13475e(18, this.xgV);
            }
            if (this.uai != null) {
                c6093a.mo13475e(19, this.uai);
            }
            if (this.uaj != null) {
                c6093a.mo13475e(20, this.uaj);
            }
            c6093a.mo13480iz(21, this.xgW);
            if (this.xgX != null) {
                c6093a.mo13475e(22, this.xgX);
            }
            if (this.xgY != null) {
                c6093a.mo13475e(23, this.xgY);
            }
            c6093a.mo13474e(24, 8, this.wiH);
            c6093a.mo13472ai(25, this.timestamp);
            c6093a.mo13471aO(26, this.cui);
            if (this.ubA != null) {
                c6093a.mo13475e(27, this.ubA);
            }
            c6093a.mo13472ai(28, this.xgZ);
            c6093a.mo13472ai(29, this.ctk);
            c6093a.mo13472ai(30, this.xha);
            c6093a.mo13474e(31, 8, this.xhb);
            c6093a.mo13474e(32, 8, this.xhc);
            c6093a.mo13480iz(33, this.xhd);
            c6093a.mo13472ai(34, this.xhe);
            c6093a.mo13480iz(35, this.xhf);
            c6093a.mo13480iz(36, this.voe);
            c6093a.mo13480iz(37, this.xhg);
            c6093a.mo13471aO(38, this.xhh);
            if (this.xhi != null) {
                c6093a.mo13475e(39, this.xhi);
            }
            AppMethodBeat.m2505o(55711);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.videoUrl != null) {
                f += C6091a.m9575f(2, this.videoUrl);
            }
            if (this.xgQ != null) {
                f += C6091a.m9575f(3, this.xgQ);
            }
            f += C6091a.m9572bs(4, this.xgR);
            if (this.xgS != null) {
                f += C6091a.m9575f(5, this.xgS);
            }
            f = (f + C6091a.m9572bs(6, this.fgJ)) + C6091a.m9572bs(7, this.fgI);
            if (this.lvz != null) {
                f += C6091a.m9575f(8, this.lvz);
            }
            if (this.lvA != null) {
                f += C6091a.m9575f(9, this.lvA);
            }
            if (this.qVw != null) {
                f += C6091a.m9575f(10, this.qVw);
            }
            if (this.uaf != null) {
                f += C6091a.m9575f(11, this.uaf);
            }
            if (this.uag != null) {
                f += C6091a.m9575f(12, this.uag);
            }
            if (this.uah != null) {
                f += C6091a.m9575f(13, this.uah);
            }
            if (this.source != null) {
                f += C6091a.m9575f(14, this.source);
            }
            if (this.phw != null) {
                f += C6091a.m9575f(15, this.phw);
            }
            f += C6091a.m9578o(16, this.xgT);
            if (this.xgU != null) {
                f += C6091a.m9575f(17, this.xgU);
            }
            if (this.xgV != null) {
                f += C6091a.m9575f(18, this.xgV);
            }
            if (this.uai != null) {
                f += C6091a.m9575f(19, this.uai);
            }
            if (this.uaj != null) {
                f += C6091a.m9575f(20, this.uaj);
            }
            f += C6091a.m9572bs(21, this.xgW);
            if (this.xgX != null) {
                f += C6091a.m9575f(22, this.xgX);
            }
            if (this.xgY != null) {
                f += C6091a.m9575f(23, this.xgY);
            }
            f = ((f + C6087a.m9552c(24, 8, this.wiH)) + C6091a.m9578o(25, this.timestamp)) + (C6091a.m9576fv(26) + 1);
            if (this.ubA != null) {
                f += C6091a.m9575f(27, this.ubA);
            }
            f = ((((((((((f + C6091a.m9578o(28, this.xgZ)) + C6091a.m9578o(29, this.ctk)) + C6091a.m9578o(30, this.xha)) + C6087a.m9552c(31, 8, this.xhb)) + C6087a.m9552c(32, 8, this.xhc)) + C6091a.m9572bs(33, this.xhd)) + C6091a.m9578o(34, this.xhe)) + C6091a.m9572bs(35, this.xhf)) + C6091a.m9572bs(36, this.voe)) + C6091a.m9572bs(37, this.xhg)) + (C6091a.m9576fv(38) + 1);
            if (this.xhi != null) {
                f += C6091a.m9575f(39, this.xhi);
            }
            AppMethodBeat.m2505o(55711);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wiH.clear();
            this.xhb.clear();
            this.xhc.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55711);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chw chw = (chw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    chw.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 2:
                    chw.videoUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 3:
                    chw.xgQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 4:
                    chw.xgR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 5:
                    chw.xgS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 6:
                    chw.fgJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 7:
                    chw.fgI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 8:
                    chw.lvz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 9:
                    chw.lvA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 10:
                    chw.qVw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 11:
                    chw.uaf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 12:
                    chw.uag = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 13:
                    chw.uah = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 14:
                    chw.source = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 15:
                    chw.phw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 16:
                    chw.xgT = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 17:
                    chw.xgU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 18:
                    chw.xgV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 19:
                    chw.uai = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 20:
                    chw.uaj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 21:
                    chw.xgW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 22:
                    chw.xgX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 23:
                    chw.xgY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 24:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzs bzs = new bzs();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzs.populateBuilderWithField(c6086a3, bzs, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chw.wiH.add(bzs);
                    }
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 25:
                    chw.timestamp = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 26:
                    chw.cui = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 27:
                    chw.ubA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    chw.xgZ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 29:
                    chw.ctk = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 30:
                    chw.xha = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 31:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chy chy = new chy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chy.populateBuilderWithField(c6086a3, chy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chw.xhb.add(chy);
                    }
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 32:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abz abz = new abz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abz.populateBuilderWithField(c6086a3, abz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chw.xhc.add(abz);
                    }
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 33:
                    chw.xhd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 34:
                    chw.xhe = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 35:
                    chw.xhf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 36:
                    chw.voe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    chw.xhg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 38:
                    chw.xhh = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                case 39:
                    chw.xhi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55711);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55711);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55711);
            return -1;
        }
    }
}
