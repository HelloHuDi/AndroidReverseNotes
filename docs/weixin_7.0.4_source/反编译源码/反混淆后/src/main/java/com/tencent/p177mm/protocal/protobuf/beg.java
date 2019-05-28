package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.ttpic.wav.WavFileHeader;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.beg */
public final class beg extends bsr {
    public String guS;
    public String jBB;
    public String jCH;
    public String luP;
    public String luQ;
    public int vCf;
    public String vCg;
    public String vCh;
    public int vIi;
    public String vIj;
    public SKBuiltinBuffer_t vIl;
    public C7287xu vIr;
    public int vLC;
    public String vLD;
    public String vLJ;
    public int vLw;
    public SKBuiltinBuffer_t vLz;
    public String wDY;
    public int wHV;
    public int wHW;
    public int wHX;
    public String wHY;
    public String wHZ;
    public String wIa;
    public String wIb;
    public String wIc;
    public String wId;
    public int wIe;
    public String wIf;
    public String wIg;
    public String wdB;
    public String wdz;
    public String wfH;
    public String wlq;
    public String wsL;
    public String wsM;
    public int wsN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58920);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(2, this.jBB);
            }
            if (this.vLJ != null) {
                c6093a.mo13475e(3, this.vLJ);
            }
            if (this.jCH != null) {
                c6093a.mo13475e(4, this.jCH);
            }
            c6093a.mo13480iz(5, this.vCf);
            if (this.vCg != null) {
                c6093a.mo13475e(6, this.vCg);
            }
            if (this.vCh != null) {
                c6093a.mo13475e(7, this.vCh);
            }
            if (this.wdB != null) {
                c6093a.mo13475e(8, this.wdB);
            }
            c6093a.mo13480iz(12, this.vIi);
            c6093a.mo13480iz(13, this.wHV);
            c6093a.mo13480iz(14, this.wsN);
            if (this.luP != null) {
                c6093a.mo13475e(15, this.luP);
            }
            if (this.luQ != null) {
                c6093a.mo13475e(16, this.luQ);
            }
            c6093a.mo13480iz(17, this.vLw);
            if (this.wdz != null) {
                c6093a.mo13475e(18, this.wdz);
            }
            if (this.vLz != null) {
                c6093a.mo13479iy(19, this.vLz.computeSize());
                this.vLz.writeFields(c6093a);
            }
            if (this.guS != null) {
                c6093a.mo13475e(20, this.guS);
            }
            if (this.wsL != null) {
                c6093a.mo13475e(21, this.wsL);
            }
            if (this.wsM != null) {
                c6093a.mo13475e(22, this.wsM);
            }
            c6093a.mo13480iz(23, this.wHW);
            c6093a.mo13480iz(24, this.wHX);
            if (this.vIj != null) {
                c6093a.mo13475e(31, this.vIj);
            }
            if (this.wDY != null) {
                c6093a.mo13475e(32, this.wDY);
            }
            if (this.wHY != null) {
                c6093a.mo13475e(33, this.wHY);
            }
            if (this.wfH != null) {
                c6093a.mo13475e(34, this.wfH);
            }
            if (this.wHZ != null) {
                c6093a.mo13475e(35, this.wHZ);
            }
            if (this.wIa != null) {
                c6093a.mo13475e(36, this.wIa);
            }
            if (this.vIr != null) {
                c6093a.mo13479iy(37, this.vIr.computeSize());
                this.vIr.writeFields(c6093a);
            }
            if (this.wIb != null) {
                c6093a.mo13475e(38, this.wIb);
            }
            if (this.wlq != null) {
                c6093a.mo13475e(39, this.wlq);
            }
            if (this.wIc != null) {
                c6093a.mo13475e(40, this.wIc);
            }
            if (this.wId != null) {
                c6093a.mo13475e(41, this.wId);
            }
            c6093a.mo13480iz(42, this.wIe);
            if (this.vIl != null) {
                c6093a.mo13479iy(43, this.vIl.computeSize());
                this.vIl.writeFields(c6093a);
            }
            c6093a.mo13480iz(44, this.vLC);
            if (this.vLD != null) {
                c6093a.mo13475e(45, this.vLD);
            }
            if (this.wIf != null) {
                c6093a.mo13475e(46, this.wIf);
            }
            if (this.wIg != null) {
                c6093a.mo13475e(47, this.wIg);
            }
            AppMethodBeat.m2505o(58920);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBB != null) {
                ix += C6091a.m9575f(2, this.jBB);
            }
            if (this.vLJ != null) {
                ix += C6091a.m9575f(3, this.vLJ);
            }
            if (this.jCH != null) {
                ix += C6091a.m9575f(4, this.jCH);
            }
            ix += C6091a.m9572bs(5, this.vCf);
            if (this.vCg != null) {
                ix += C6091a.m9575f(6, this.vCg);
            }
            if (this.vCh != null) {
                ix += C6091a.m9575f(7, this.vCh);
            }
            if (this.wdB != null) {
                ix += C6091a.m9575f(8, this.wdB);
            }
            ix = ((ix + C6091a.m9572bs(12, this.vIi)) + C6091a.m9572bs(13, this.wHV)) + C6091a.m9572bs(14, this.wsN);
            if (this.luP != null) {
                ix += C6091a.m9575f(15, this.luP);
            }
            if (this.luQ != null) {
                ix += C6091a.m9575f(16, this.luQ);
            }
            ix += C6091a.m9572bs(17, this.vLw);
            if (this.wdz != null) {
                ix += C6091a.m9575f(18, this.wdz);
            }
            if (this.vLz != null) {
                ix += C6087a.m9557ix(19, this.vLz.computeSize());
            }
            if (this.guS != null) {
                ix += C6091a.m9575f(20, this.guS);
            }
            if (this.wsL != null) {
                ix += C6091a.m9575f(21, this.wsL);
            }
            if (this.wsM != null) {
                ix += C6091a.m9575f(22, this.wsM);
            }
            ix = (ix + C6091a.m9572bs(23, this.wHW)) + C6091a.m9572bs(24, this.wHX);
            if (this.vIj != null) {
                ix += C6091a.m9575f(31, this.vIj);
            }
            if (this.wDY != null) {
                ix += C6091a.m9575f(32, this.wDY);
            }
            if (this.wHY != null) {
                ix += C6091a.m9575f(33, this.wHY);
            }
            if (this.wfH != null) {
                ix += C6091a.m9575f(34, this.wfH);
            }
            if (this.wHZ != null) {
                ix += C6091a.m9575f(35, this.wHZ);
            }
            if (this.wIa != null) {
                ix += C6091a.m9575f(36, this.wIa);
            }
            if (this.vIr != null) {
                ix += C6087a.m9557ix(37, this.vIr.computeSize());
            }
            if (this.wIb != null) {
                ix += C6091a.m9575f(38, this.wIb);
            }
            if (this.wlq != null) {
                ix += C6091a.m9575f(39, this.wlq);
            }
            if (this.wIc != null) {
                ix += C6091a.m9575f(40, this.wIc);
            }
            if (this.wId != null) {
                ix += C6091a.m9575f(41, this.wId);
            }
            ix += C6091a.m9572bs(42, this.wIe);
            if (this.vIl != null) {
                ix += C6087a.m9557ix(43, this.vIl.computeSize());
            }
            ix += C6091a.m9572bs(44, this.vLC);
            if (this.vLD != null) {
                ix += C6091a.m9575f(45, this.vLD);
            }
            if (this.wIf != null) {
                ix += C6091a.m9575f(46, this.wIf);
            }
            if (this.wIg != null) {
                ix += C6091a.m9575f(47, this.wIg);
            }
            AppMethodBeat.m2505o(58920);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(58920);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            beg beg = (beg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beg.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 2:
                    beg.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 3:
                    beg.vLJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 4:
                    beg.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 5:
                    beg.vCf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 6:
                    beg.vCg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 7:
                    beg.vCh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 8:
                    beg.wdB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 12:
                    beg.vIi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 13:
                    beg.wHV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 14:
                    beg.wsN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 15:
                    beg.luP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 16:
                    beg.luQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 17:
                    beg.vLw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 18:
                    beg.wdz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 19:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beg.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 20:
                    beg.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 21:
                    beg.wsL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 22:
                    beg.wsM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 23:
                    beg.wHW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 24:
                    beg.wHX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 31:
                    beg.vIj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 32:
                    beg.wDY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 33:
                    beg.wHY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 34:
                    beg.wfH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 35:
                    beg.wHZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 36:
                    beg.wIa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7287xu c7287xu = new C7287xu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7287xu.populateBuilderWithField(c6086a3, c7287xu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beg.vIr = c7287xu;
                    }
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 38:
                    beg.wIb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 39:
                    beg.wlq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 40:
                    beg.wIc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 41:
                    beg.wId = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 42:
                    beg.wIe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 43:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beg.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    beg.vLC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    beg.vLD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case 46:
                    beg.wIf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    beg.wIg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58920);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58920);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58920);
            return -1;
        }
    }
}
