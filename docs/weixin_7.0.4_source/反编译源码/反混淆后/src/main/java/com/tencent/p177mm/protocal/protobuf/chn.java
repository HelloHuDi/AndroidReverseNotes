package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chn */
public final class chn extends C1331a {
    public String cIy;
    public int cdf;
    public String ctj;
    public String cvF;
    public String hlm;
    public String nQB;
    public int offset;
    public int sBd;
    public int scene;
    public LinkedList<C23447tn> tZG = new LinkedList();
    public String tZP;
    public String url;
    public String xgj;
    public LinkedList<chu> xgk = new LinkedList();
    public int xgl;
    public String xgm;
    public String xgn;
    public String xgo;
    public LinkedList<String> xgp = new LinkedList();

    public chn() {
        AppMethodBeat.m2504i(55702);
        AppMethodBeat.m2505o(55702);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55703);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.hlm != null) {
                c6093a.mo13475e(1, this.hlm);
            }
            if (this.cvF != null) {
                c6093a.mo13475e(2, this.cvF);
            }
            if (this.cIy != null) {
                c6093a.mo13475e(3, this.cIy);
            }
            c6093a.mo13480iz(4, this.offset);
            if (this.ctj != null) {
                c6093a.mo13475e(5, this.ctj);
            }
            c6093a.mo13480iz(6, this.scene);
            if (this.url != null) {
                c6093a.mo13475e(7, this.url);
            }
            if (this.nQB != null) {
                c6093a.mo13475e(8, this.nQB);
            }
            c6093a.mo13474e(9, 8, this.tZG);
            if (this.xgj != null) {
                c6093a.mo13475e(10, this.xgj);
            }
            c6093a.mo13474e(11, 8, this.xgk);
            c6093a.mo13480iz(12, this.sBd);
            c6093a.mo13480iz(13, this.cdf);
            if (this.tZP != null) {
                c6093a.mo13475e(14, this.tZP);
            }
            c6093a.mo13480iz(15, this.xgl);
            if (this.xgm != null) {
                c6093a.mo13475e(16, this.xgm);
            }
            if (this.xgn != null) {
                c6093a.mo13475e(17, this.xgn);
            }
            if (this.xgo != null) {
                c6093a.mo13475e(18, this.xgo);
            }
            c6093a.mo13474e(19, 1, this.xgp);
            AppMethodBeat.m2505o(55703);
            return 0;
        } else if (i == 1) {
            if (this.hlm != null) {
                f = C6091a.m9575f(1, this.hlm) + 0;
            } else {
                f = 0;
            }
            if (this.cvF != null) {
                f += C6091a.m9575f(2, this.cvF);
            }
            if (this.cIy != null) {
                f += C6091a.m9575f(3, this.cIy);
            }
            f += C6091a.m9572bs(4, this.offset);
            if (this.ctj != null) {
                f += C6091a.m9575f(5, this.ctj);
            }
            f += C6091a.m9572bs(6, this.scene);
            if (this.url != null) {
                f += C6091a.m9575f(7, this.url);
            }
            if (this.nQB != null) {
                f += C6091a.m9575f(8, this.nQB);
            }
            f += C6087a.m9552c(9, 8, this.tZG);
            if (this.xgj != null) {
                f += C6091a.m9575f(10, this.xgj);
            }
            f = ((f + C6087a.m9552c(11, 8, this.xgk)) + C6091a.m9572bs(12, this.sBd)) + C6091a.m9572bs(13, this.cdf);
            if (this.tZP != null) {
                f += C6091a.m9575f(14, this.tZP);
            }
            f += C6091a.m9572bs(15, this.xgl);
            if (this.xgm != null) {
                f += C6091a.m9575f(16, this.xgm);
            }
            if (this.xgn != null) {
                f += C6091a.m9575f(17, this.xgn);
            }
            if (this.xgo != null) {
                f += C6091a.m9575f(18, this.xgo);
            }
            int c = f + C6087a.m9552c(19, 1, this.xgp);
            AppMethodBeat.m2505o(55703);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tZG.clear();
            this.xgk.clear();
            this.xgp.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55703);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chn chn = (chn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    chn.hlm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 2:
                    chn.cvF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 3:
                    chn.cIy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 4:
                    chn.offset = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 5:
                    chn.ctj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 6:
                    chn.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 7:
                    chn.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 8:
                    chn.nQB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23447tn c23447tn = new C23447tn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23447tn.populateBuilderWithField(c6086a3, c23447tn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chn.tZG.add(c23447tn);
                    }
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 10:
                    chn.xgj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chu chu = new chu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chu.populateBuilderWithField(c6086a3, chu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chn.xgk.add(chu);
                    }
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 12:
                    chn.sBd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 13:
                    chn.cdf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 14:
                    chn.tZP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 15:
                    chn.xgl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 16:
                    chn.xgm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 17:
                    chn.xgn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 18:
                    chn.xgo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55703);
                    return 0;
                case 19:
                    chn.xgp.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(55703);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55703);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55703);
            return -1;
        }
    }
}
