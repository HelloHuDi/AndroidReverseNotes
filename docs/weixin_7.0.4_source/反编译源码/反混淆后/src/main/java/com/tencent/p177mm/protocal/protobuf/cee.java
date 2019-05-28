package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cee */
public final class cee extends C1331a {
    public boolean aIM;
    public int eTb;
    public String eYi;
    public long endTime;
    public boolean fbV;
    public String musicUrl;
    public int rTW;
    public boolean rTZ;
    public cei smk;
    public long startTime;
    public String thumbPath;
    public long timeStamp;
    public String videoPath;
    public String xdR;
    public int xdS;
    public int xdT;
    public int xdU;
    public int xdV;
    public LinkedList<C40526hk> xdW = new LinkedList();
    public int xdX;
    public ced xdY;
    public int xdZ;
    public long xea;

    public cee() {
        AppMethodBeat.m2504i(56513);
        AppMethodBeat.m2505o(56513);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56514);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.videoPath == null) {
                c6092b = new C6092b("Not all required fields were included: videoPath");
                AppMethodBeat.m2505o(56514);
                throw c6092b;
            } else if (this.thumbPath == null) {
                c6092b = new C6092b("Not all required fields were included: thumbPath");
                AppMethodBeat.m2505o(56514);
                throw c6092b;
            } else {
                if (this.videoPath != null) {
                    c6093a.mo13475e(1, this.videoPath);
                }
                c6093a.mo13472ai(2, this.startTime);
                c6093a.mo13472ai(3, this.endTime);
                if (this.xdR != null) {
                    c6093a.mo13475e(4, this.xdR);
                }
                c6093a.mo13480iz(5, this.eTb);
                if (this.thumbPath != null) {
                    c6093a.mo13475e(6, this.thumbPath);
                }
                if (this.eYi != null) {
                    c6093a.mo13475e(7, this.eYi);
                }
                c6093a.mo13480iz(8, this.rTW);
                if (this.musicUrl != null) {
                    c6093a.mo13475e(9, this.musicUrl);
                }
                c6093a.mo13471aO(10, this.aIM);
                c6093a.mo13471aO(11, this.rTZ);
                c6093a.mo13480iz(12, this.xdS);
                c6093a.mo13480iz(13, this.xdT);
                c6093a.mo13480iz(14, this.xdU);
                c6093a.mo13480iz(15, this.xdV);
                c6093a.mo13474e(16, 8, this.xdW);
                c6093a.mo13472ai(17, this.timeStamp);
                c6093a.mo13480iz(18, this.xdX);
                c6093a.mo13471aO(19, this.fbV);
                if (this.smk != null) {
                    c6093a.mo13479iy(20, this.smk.computeSize());
                    this.smk.writeFields(c6093a);
                }
                if (this.xdY != null) {
                    c6093a.mo13479iy(21, this.xdY.computeSize());
                    this.xdY.writeFields(c6093a);
                }
                c6093a.mo13480iz(22, this.xdZ);
                c6093a.mo13472ai(23, this.xea);
                AppMethodBeat.m2505o(56514);
                return 0;
            }
        } else if (i == 1) {
            if (this.videoPath != null) {
                f = C6091a.m9575f(1, this.videoPath) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9578o(2, this.startTime)) + C6091a.m9578o(3, this.endTime);
            if (this.xdR != null) {
                f += C6091a.m9575f(4, this.xdR);
            }
            f += C6091a.m9572bs(5, this.eTb);
            if (this.thumbPath != null) {
                f += C6091a.m9575f(6, this.thumbPath);
            }
            if (this.eYi != null) {
                f += C6091a.m9575f(7, this.eYi);
            }
            f += C6091a.m9572bs(8, this.rTW);
            if (this.musicUrl != null) {
                f += C6091a.m9575f(9, this.musicUrl);
            }
            f = (((((((((f + (C6091a.m9576fv(10) + 1)) + (C6091a.m9576fv(11) + 1)) + C6091a.m9572bs(12, this.xdS)) + C6091a.m9572bs(13, this.xdT)) + C6091a.m9572bs(14, this.xdU)) + C6091a.m9572bs(15, this.xdV)) + C6087a.m9552c(16, 8, this.xdW)) + C6091a.m9578o(17, this.timeStamp)) + C6091a.m9572bs(18, this.xdX)) + (C6091a.m9576fv(19) + 1);
            if (this.smk != null) {
                f += C6087a.m9557ix(20, this.smk.computeSize());
            }
            if (this.xdY != null) {
                f += C6087a.m9557ix(21, this.xdY.computeSize());
            }
            int bs = (f + C6091a.m9572bs(22, this.xdZ)) + C6091a.m9578o(23, this.xea);
            AppMethodBeat.m2505o(56514);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xdW.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.videoPath == null) {
                c6092b = new C6092b("Not all required fields were included: videoPath");
                AppMethodBeat.m2505o(56514);
                throw c6092b;
            } else if (this.thumbPath == null) {
                c6092b = new C6092b("Not all required fields were included: thumbPath");
                AppMethodBeat.m2505o(56514);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(56514);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cee cee = (cee) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cee.videoPath = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 2:
                    cee.startTime = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 3:
                    cee.endTime = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 4:
                    cee.xdR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 5:
                    cee.eTb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 6:
                    cee.thumbPath = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 7:
                    cee.eYi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 8:
                    cee.rTW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 9:
                    cee.musicUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 10:
                    cee.aIM = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 11:
                    cee.rTZ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 12:
                    cee.xdS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 13:
                    cee.xdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 14:
                    cee.xdU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 15:
                    cee.xdV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40526hk c40526hk = new C40526hk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40526hk.populateBuilderWithField(c6086a3, c40526hk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cee.xdW.add(c40526hk);
                    }
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 17:
                    cee.timeStamp = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 18:
                    cee.xdX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 19:
                    cee.fbV = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cei cei = new cei();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cei.populateBuilderWithField(c6086a3, cei, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cee.smk = cei;
                    }
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 21:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ced ced = new ced();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ced.populateBuilderWithField(c6086a3, ced, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cee.xdY = ced;
                    }
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 22:
                    cee.xdZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                case 23:
                    cee.xea = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56514);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56514);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56514);
            return -1;
        }
    }
}
