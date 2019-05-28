package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bh */
public final class C30169bh extends bsr {
    public String bssid;
    public int cvd;
    public String qEg;
    public int scene;
    public String ssid;
    public C1332b vDA;
    public C1332b vDB;
    public int vDs;
    public String vDt;
    public long vDu;
    public C35906bt vDv;
    public int vDw;
    public int vDx;
    public String vDy;
    public int vDz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94491);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.qEg != null) {
                c6093a.mo13475e(2, this.qEg);
            }
            c6093a.mo13480iz(3, this.vDs);
            if (this.vDt != null) {
                c6093a.mo13475e(4, this.vDt);
            }
            c6093a.mo13480iz(5, this.scene);
            if (this.ssid != null) {
                c6093a.mo13475e(6, this.ssid);
            }
            if (this.bssid != null) {
                c6093a.mo13475e(7, this.bssid);
            }
            c6093a.mo13472ai(8, this.vDu);
            if (this.vDv != null) {
                c6093a.mo13479iy(9, this.vDv.computeSize());
                this.vDv.writeFields(c6093a);
            }
            c6093a.mo13480iz(10, this.vDw);
            c6093a.mo13480iz(11, this.vDx);
            c6093a.mo13480iz(12, this.cvd);
            if (this.vDy != null) {
                c6093a.mo13475e(13, this.vDy);
            }
            c6093a.mo13480iz(14, this.vDz);
            if (this.vDA != null) {
                c6093a.mo13473c(15, this.vDA);
            }
            if (this.vDB != null) {
                c6093a.mo13473c(16, this.vDB);
            }
            AppMethodBeat.m2505o(94491);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.qEg != null) {
                ix += C6091a.m9575f(2, this.qEg);
            }
            ix += C6091a.m9572bs(3, this.vDs);
            if (this.vDt != null) {
                ix += C6091a.m9575f(4, this.vDt);
            }
            ix += C6091a.m9572bs(5, this.scene);
            if (this.ssid != null) {
                ix += C6091a.m9575f(6, this.ssid);
            }
            if (this.bssid != null) {
                ix += C6091a.m9575f(7, this.bssid);
            }
            ix += C6091a.m9578o(8, this.vDu);
            if (this.vDv != null) {
                ix += C6087a.m9557ix(9, this.vDv.computeSize());
            }
            ix = ((ix + C6091a.m9572bs(10, this.vDw)) + C6091a.m9572bs(11, this.vDx)) + C6091a.m9572bs(12, this.cvd);
            if (this.vDy != null) {
                ix += C6091a.m9575f(13, this.vDy);
            }
            ix += C6091a.m9572bs(14, this.vDz);
            if (this.vDA != null) {
                ix += C6091a.m9571b(15, this.vDA);
            }
            if (this.vDB != null) {
                ix += C6091a.m9571b(16, this.vDB);
            }
            AppMethodBeat.m2505o(94491);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94491);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30169bh c30169bh = (C30169bh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
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
                        c30169bh.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 2:
                    c30169bh.qEg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 3:
                    c30169bh.vDs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 4:
                    c30169bh.vDt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 5:
                    c30169bh.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 6:
                    c30169bh.ssid = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 7:
                    c30169bh.bssid = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 8:
                    c30169bh.vDu = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35906bt c35906bt = new C35906bt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35906bt.populateBuilderWithField(c6086a3, c35906bt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30169bh.vDv = c35906bt;
                    }
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 10:
                    c30169bh.vDw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 11:
                    c30169bh.vDx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 12:
                    c30169bh.cvd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 13:
                    c30169bh.vDy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 14:
                    c30169bh.vDz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 15:
                    c30169bh.vDA = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                case 16:
                    c30169bh.vDB = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(94491);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94491);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94491);
            return -1;
        }
    }
}
