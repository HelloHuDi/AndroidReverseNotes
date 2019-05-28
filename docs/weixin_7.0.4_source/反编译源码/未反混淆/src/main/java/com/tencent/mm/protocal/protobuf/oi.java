package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import java.util.LinkedList;
import org.xwalk.core.XWalkEnvironment;

public final class oi extends a {
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
    public LinkedList<tm> vTW = new LinkedList();
    public LinkedList<tm> vTX = new LinkedList();
    public String vTY;
    public String vTZ;
    public tm vUA;
    public xt vUB;
    public boolean vUC;
    public int vUD;
    public boolean vUE;
    public boolean vUF;
    public lh vUG;
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
    public nz vUk;
    public String vUl;
    public String vUm;
    public int vUn;
    public wy vUo;
    public cma vUp;
    public aci vUq;
    public ax vUr;
    public int vUs;
    public int vUt;
    public String vUu;
    public int vUv;
    public String vUw;
    public int vUx;
    public tm vUy;
    public String vUz;

    public oi() {
        AppMethodBeat.i(89042);
        AppMethodBeat.o(89042);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89043);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kbU != null) {
                aVar.e(1, this.kbU);
            }
            if (this.kbV != null) {
                aVar.e(2, this.kbV);
            }
            if (this.csB != null) {
                aVar.e(3, this.csB);
            }
            if (this.vTT != null) {
                aVar.e(4, this.vTT);
            }
            aVar.iz(5, this.vTU);
            aVar.iz(6, this.iAd);
            if (this.kdg != null) {
                aVar.e(7, this.kdg);
            }
            if (this.title != null) {
                aVar.e(8, this.title);
            }
            if (this.kbW != null) {
                aVar.e(9, this.kbW);
            }
            if (this.color != null) {
                aVar.e(10, this.color);
            }
            if (this.kCx != null) {
                aVar.e(11, this.kCx);
            }
            if (this.vTV != null) {
                aVar.e(12, this.vTV);
            }
            aVar.e(13, 8, this.vTW);
            aVar.e(14, 8, this.vTX);
            if (this.vTY != null) {
                aVar.e(15, this.vTY);
            }
            if (this.vTZ != null) {
                aVar.e(16, this.vTZ);
            }
            if (this.source != null) {
                aVar.e(17, this.source);
            }
            aVar.iz(18, this.vUa);
            if (this.kdf != null) {
                aVar.e(19, this.kdf);
            }
            if (this.vUb != null) {
                aVar.e(20, this.vUb);
            }
            if (this.vUc != null) {
                aVar.e(21, this.vUc);
            }
            aVar.iz(22, this.vUd);
            if (this.vUe != null) {
                aVar.e(23, this.vUe);
            }
            if (this.vUf != null) {
                aVar.e(24, this.vUf);
            }
            aVar.ai(25, this.vUg);
            if (this.vUh != null) {
                aVar.e(26, this.vUh);
            }
            if (this.vUi != null) {
                aVar.e(27, this.vUi);
            }
            if (this.vUj != null) {
                aVar.e(28, this.vUj);
            }
            if (this.vUk != null) {
                aVar.iy(29, this.vUk.computeSize());
                this.vUk.writeFields(aVar);
            }
            if (this.vUl != null) {
                aVar.e(30, this.vUl);
            }
            if (this.vUm != null) {
                aVar.e(31, this.vUm);
            }
            aVar.iz(32, this.vUn);
            if (this.vUo != null) {
                aVar.iy(33, this.vUo.computeSize());
                this.vUo.writeFields(aVar);
            }
            if (this.vUp != null) {
                aVar.iy(34, this.vUp.computeSize());
                this.vUp.writeFields(aVar);
            }
            if (this.vUq != null) {
                aVar.iy(35, this.vUq.computeSize());
                this.vUq.writeFields(aVar);
            }
            if (this.vUr != null) {
                aVar.iy(36, this.vUr.computeSize());
                this.vUr.writeFields(aVar);
            }
            aVar.iz(37, this.vUs);
            aVar.iz(38, this.vUt);
            if (this.vUu != null) {
                aVar.e(39, this.vUu);
            }
            aVar.iz(40, this.vUv);
            if (this.vUw != null) {
                aVar.e(41, this.vUw);
            }
            aVar.iz(42, this.vUx);
            if (this.vUy != null) {
                aVar.iy(43, this.vUy.computeSize());
                this.vUy.writeFields(aVar);
            }
            if (this.vUz != null) {
                aVar.e(44, this.vUz);
            }
            if (this.vUA != null) {
                aVar.iy(45, this.vUA.computeSize());
                this.vUA.writeFields(aVar);
            }
            if (this.vUB != null) {
                aVar.iy(46, this.vUB.computeSize());
                this.vUB.writeFields(aVar);
            }
            aVar.aO(47, this.vUC);
            aVar.iz(48, this.vUD);
            aVar.aO(49, this.vUE);
            aVar.aO(50, this.vUF);
            if (this.vUG != null) {
                aVar.iy(51, this.vUG.computeSize());
                this.vUG.writeFields(aVar);
            }
            if (this.vUH != null) {
                aVar.e(52, this.vUH);
            }
            if (this.vUI != null) {
                aVar.e(53, this.vUI);
            }
            AppMethodBeat.o(89043);
            return 0;
        } else if (i == 1) {
            if (this.kbU != null) {
                f = e.a.a.b.b.a.f(1, this.kbU) + 0;
            } else {
                f = 0;
            }
            if (this.kbV != null) {
                f += e.a.a.b.b.a.f(2, this.kbV);
            }
            if (this.csB != null) {
                f += e.a.a.b.b.a.f(3, this.csB);
            }
            if (this.vTT != null) {
                f += e.a.a.b.b.a.f(4, this.vTT);
            }
            f = (f + e.a.a.b.b.a.bs(5, this.vTU)) + e.a.a.b.b.a.bs(6, this.iAd);
            if (this.kdg != null) {
                f += e.a.a.b.b.a.f(7, this.kdg);
            }
            if (this.title != null) {
                f += e.a.a.b.b.a.f(8, this.title);
            }
            if (this.kbW != null) {
                f += e.a.a.b.b.a.f(9, this.kbW);
            }
            if (this.color != null) {
                f += e.a.a.b.b.a.f(10, this.color);
            }
            if (this.kCx != null) {
                f += e.a.a.b.b.a.f(11, this.kCx);
            }
            if (this.vTV != null) {
                f += e.a.a.b.b.a.f(12, this.vTV);
            }
            f = (f + e.a.a.a.c(13, 8, this.vTW)) + e.a.a.a.c(14, 8, this.vTX);
            if (this.vTY != null) {
                f += e.a.a.b.b.a.f(15, this.vTY);
            }
            if (this.vTZ != null) {
                f += e.a.a.b.b.a.f(16, this.vTZ);
            }
            if (this.source != null) {
                f += e.a.a.b.b.a.f(17, this.source);
            }
            f += e.a.a.b.b.a.bs(18, this.vUa);
            if (this.kdf != null) {
                f += e.a.a.b.b.a.f(19, this.kdf);
            }
            if (this.vUb != null) {
                f += e.a.a.b.b.a.f(20, this.vUb);
            }
            if (this.vUc != null) {
                f += e.a.a.b.b.a.f(21, this.vUc);
            }
            f += e.a.a.b.b.a.bs(22, this.vUd);
            if (this.vUe != null) {
                f += e.a.a.b.b.a.f(23, this.vUe);
            }
            if (this.vUf != null) {
                f += e.a.a.b.b.a.f(24, this.vUf);
            }
            f += e.a.a.b.b.a.o(25, this.vUg);
            if (this.vUh != null) {
                f += e.a.a.b.b.a.f(26, this.vUh);
            }
            if (this.vUi != null) {
                f += e.a.a.b.b.a.f(27, this.vUi);
            }
            if (this.vUj != null) {
                f += e.a.a.b.b.a.f(28, this.vUj);
            }
            if (this.vUk != null) {
                f += e.a.a.a.ix(29, this.vUk.computeSize());
            }
            if (this.vUl != null) {
                f += e.a.a.b.b.a.f(30, this.vUl);
            }
            if (this.vUm != null) {
                f += e.a.a.b.b.a.f(31, this.vUm);
            }
            f += e.a.a.b.b.a.bs(32, this.vUn);
            if (this.vUo != null) {
                f += e.a.a.a.ix(33, this.vUo.computeSize());
            }
            if (this.vUp != null) {
                f += e.a.a.a.ix(34, this.vUp.computeSize());
            }
            if (this.vUq != null) {
                f += e.a.a.a.ix(35, this.vUq.computeSize());
            }
            if (this.vUr != null) {
                f += e.a.a.a.ix(36, this.vUr.computeSize());
            }
            f = (f + e.a.a.b.b.a.bs(37, this.vUs)) + e.a.a.b.b.a.bs(38, this.vUt);
            if (this.vUu != null) {
                f += e.a.a.b.b.a.f(39, this.vUu);
            }
            f += e.a.a.b.b.a.bs(40, this.vUv);
            if (this.vUw != null) {
                f += e.a.a.b.b.a.f(41, this.vUw);
            }
            f += e.a.a.b.b.a.bs(42, this.vUx);
            if (this.vUy != null) {
                f += e.a.a.a.ix(43, this.vUy.computeSize());
            }
            if (this.vUz != null) {
                f += e.a.a.b.b.a.f(44, this.vUz);
            }
            if (this.vUA != null) {
                f += e.a.a.a.ix(45, this.vUA.computeSize());
            }
            if (this.vUB != null) {
                f += e.a.a.a.ix(46, this.vUB.computeSize());
            }
            f = (((f + (e.a.a.b.b.a.fv(47) + 1)) + e.a.a.b.b.a.bs(48, this.vUD)) + (e.a.a.b.b.a.fv(49) + 1)) + (e.a.a.b.b.a.fv(50) + 1);
            if (this.vUG != null) {
                f += e.a.a.a.ix(51, this.vUG.computeSize());
            }
            if (this.vUH != null) {
                f += e.a.a.b.b.a.f(52, this.vUH);
            }
            if (this.vUI != null) {
                f += e.a.a.b.b.a.f(53, this.vUI);
            }
            AppMethodBeat.o(89043);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vTW.clear();
            this.vTX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89043);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oi oiVar = (oi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            tm tmVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    oiVar.kbU = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 2:
                    oiVar.kbV = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 3:
                    oiVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 4:
                    oiVar.vTT = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 5:
                    oiVar.vTU = aVar3.BTU.vd();
                    AppMethodBeat.o(89043);
                    return 0;
                case 6:
                    oiVar.iAd = aVar3.BTU.vd();
                    AppMethodBeat.o(89043);
                    return 0;
                case 7:
                    oiVar.kdg = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 8:
                    oiVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 9:
                    oiVar.kbW = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 10:
                    oiVar.color = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 11:
                    oiVar.kCx = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 12:
                    oiVar.vTV = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vTW.add(tmVar);
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vTX.add(tmVar);
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case 15:
                    oiVar.vTY = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 16:
                    oiVar.vTZ = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 17:
                    oiVar.source = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 18:
                    oiVar.vUa = aVar3.BTU.vd();
                    AppMethodBeat.o(89043);
                    return 0;
                case 19:
                    oiVar.kdf = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 20:
                    oiVar.vUb = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 21:
                    oiVar.vUc = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 22:
                    oiVar.vUd = aVar3.BTU.vd();
                    AppMethodBeat.o(89043);
                    return 0;
                case 23:
                    oiVar.vUe = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 24:
                    oiVar.vUf = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 25:
                    oiVar.vUg = aVar3.BTU.ve();
                    AppMethodBeat.o(89043);
                    return 0;
                case 26:
                    oiVar.vUh = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 27:
                    oiVar.vUi = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    oiVar.vUj = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 29:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nz nzVar = new nz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nzVar.populateBuilderWithField(aVar4, nzVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vUk = nzVar;
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case 30:
                    oiVar.vUl = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 31:
                    oiVar.vUm = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 32:
                    oiVar.vUn = aVar3.BTU.vd();
                    AppMethodBeat.o(89043);
                    return 0;
                case 33:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        wy wyVar = new wy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wyVar.populateBuilderWithField(aVar4, wyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vUo = wyVar;
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case 34:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cma cma = new cma();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cma.populateBuilderWithField(aVar4, cma, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vUp = cma;
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case 35:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aci aci = new aci();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aci.populateBuilderWithField(aVar4, aci, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vUq = aci;
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case 36:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ax axVar = new ax();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axVar.populateBuilderWithField(aVar4, axVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vUr = axVar;
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    oiVar.vUs = aVar3.BTU.vd();
                    AppMethodBeat.o(89043);
                    return 0;
                case 38:
                    oiVar.vUt = aVar3.BTU.vd();
                    AppMethodBeat.o(89043);
                    return 0;
                case 39:
                    oiVar.vUu = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 40:
                    oiVar.vUv = aVar3.BTU.vd();
                    AppMethodBeat.o(89043);
                    return 0;
                case 41:
                    oiVar.vUw = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case 42:
                    oiVar.vUx = aVar3.BTU.vd();
                    AppMethodBeat.o(89043);
                    return 0;
                case 43:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vUy = tmVar;
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    oiVar.vUz = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vUA = tmVar;
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case 46:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xt xtVar = new xt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xtVar.populateBuilderWithField(aVar4, xtVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vUB = xtVar;
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    oiVar.vUC = aVar3.BTU.ehX();
                    AppMethodBeat.o(89043);
                    return 0;
                case 48:
                    oiVar.vUD = aVar3.BTU.vd();
                    AppMethodBeat.o(89043);
                    return 0;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    oiVar.vUE = aVar3.BTU.ehX();
                    AppMethodBeat.o(89043);
                    return 0;
                case 50:
                    oiVar.vUF = aVar3.BTU.ehX();
                    AppMethodBeat.o(89043);
                    return 0;
                case 51:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        lh lhVar = new lh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lhVar.populateBuilderWithField(aVar4, lhVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oiVar.vUG = lhVar;
                    }
                    AppMethodBeat.o(89043);
                    return 0;
                case 52:
                    oiVar.vUH = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    oiVar.vUI = aVar3.BTU.readString();
                    AppMethodBeat.o(89043);
                    return 0;
                default:
                    AppMethodBeat.o(89043);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89043);
            return -1;
        }
    }
}
