package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.TimeLineObject */
public class TimeLineObject extends C1331a {
    /* renamed from: Id */
    public String f15074Id;
    public int dtW;
    public int fgt;
    public String ijx;
    public String jBB;
    public int pcX;
    public C7252av qNO;
    public cvi qNQ;
    public String rCK;
    public String rjC;
    public String vjM;
    public int wEJ;
    public String xfF;
    public ayt xfG;
    public C44113ds xfH;
    public C30230uf xfI;
    public String xfJ;
    public int xfK;
    public int xfL;
    public String xfM;
    public cfg xfN;
    public cth xfO;
    public int xfP;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94634);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f15074Id != null) {
                c6093a.mo13475e(1, this.f15074Id);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(2, this.jBB);
            }
            c6093a.mo13480iz(3, this.wEJ);
            c6093a.mo13480iz(4, this.pcX);
            if (this.xfF != null) {
                c6093a.mo13475e(5, this.xfF);
            }
            if (this.xfG != null) {
                c6093a.mo13479iy(6, this.xfG.computeSize());
                this.xfG.writeFields(c6093a);
            }
            if (this.xfH != null) {
                c6093a.mo13479iy(7, this.xfH.computeSize());
                this.xfH.writeFields(c6093a);
            }
            if (this.xfI != null) {
                c6093a.mo13479iy(8, this.xfI.computeSize());
                this.xfI.writeFields(c6093a);
            }
            if (this.ijx != null) {
                c6093a.mo13475e(9, this.ijx);
            }
            if (this.vjM != null) {
                c6093a.mo13475e(10, this.vjM);
            }
            if (this.xfJ != null) {
                c6093a.mo13475e(11, this.xfJ);
            }
            c6093a.mo13480iz(12, this.xfK);
            c6093a.mo13480iz(13, this.xfL);
            if (this.xfM != null) {
                c6093a.mo13475e(14, this.xfM);
            }
            if (this.qNO != null) {
                c6093a.mo13479iy(15, this.qNO.computeSize());
                this.qNO.writeFields(c6093a);
            }
            c6093a.mo13480iz(16, this.fgt);
            if (this.xfN != null) {
                c6093a.mo13479iy(17, this.xfN.computeSize());
                this.xfN.writeFields(c6093a);
            }
            if (this.rjC != null) {
                c6093a.mo13475e(18, this.rjC);
            }
            if (this.rCK != null) {
                c6093a.mo13475e(19, this.rCK);
            }
            if (this.xfO != null) {
                c6093a.mo13479iy(20, this.xfO.computeSize());
                this.xfO.writeFields(c6093a);
            }
            c6093a.mo13480iz(21, this.xfP);
            if (this.qNQ != null) {
                c6093a.mo13479iy(22, this.qNQ.computeSize());
                this.qNQ.writeFields(c6093a);
            }
            c6093a.mo13480iz(23, this.dtW);
            AppMethodBeat.m2505o(94634);
            return 0;
        } else if (i == 1) {
            if (this.f15074Id != null) {
                f = C6091a.m9575f(1, this.f15074Id) + 0;
            } else {
                f = 0;
            }
            if (this.jBB != null) {
                f += C6091a.m9575f(2, this.jBB);
            }
            f = (f + C6091a.m9572bs(3, this.wEJ)) + C6091a.m9572bs(4, this.pcX);
            if (this.xfF != null) {
                f += C6091a.m9575f(5, this.xfF);
            }
            if (this.xfG != null) {
                f += C6087a.m9557ix(6, this.xfG.computeSize());
            }
            if (this.xfH != null) {
                f += C6087a.m9557ix(7, this.xfH.computeSize());
            }
            if (this.xfI != null) {
                f += C6087a.m9557ix(8, this.xfI.computeSize());
            }
            if (this.ijx != null) {
                f += C6091a.m9575f(9, this.ijx);
            }
            if (this.vjM != null) {
                f += C6091a.m9575f(10, this.vjM);
            }
            if (this.xfJ != null) {
                f += C6091a.m9575f(11, this.xfJ);
            }
            f = (f + C6091a.m9572bs(12, this.xfK)) + C6091a.m9572bs(13, this.xfL);
            if (this.xfM != null) {
                f += C6091a.m9575f(14, this.xfM);
            }
            if (this.qNO != null) {
                f += C6087a.m9557ix(15, this.qNO.computeSize());
            }
            f += C6091a.m9572bs(16, this.fgt);
            if (this.xfN != null) {
                f += C6087a.m9557ix(17, this.xfN.computeSize());
            }
            if (this.rjC != null) {
                f += C6091a.m9575f(18, this.rjC);
            }
            if (this.rCK != null) {
                f += C6091a.m9575f(19, this.rCK);
            }
            if (this.xfO != null) {
                f += C6087a.m9557ix(20, this.xfO.computeSize());
            }
            f += C6091a.m9572bs(21, this.xfP);
            if (this.qNQ != null) {
                f += C6087a.m9557ix(22, this.qNQ.computeSize());
            }
            int bs = f + C6091a.m9572bs(23, this.dtW);
            AppMethodBeat.m2505o(94634);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94634);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            TimeLineObject timeLineObject = (TimeLineObject) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    timeLineObject.f15074Id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 2:
                    timeLineObject.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 3:
                    timeLineObject.wEJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 4:
                    timeLineObject.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 5:
                    timeLineObject.xfF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayt ayt = new ayt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayt.populateBuilderWithField(c6086a3, ayt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        timeLineObject.xfG = ayt;
                    }
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44113ds c44113ds = new C44113ds();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44113ds.populateBuilderWithField(c6086a3, c44113ds, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        timeLineObject.xfH = c44113ds;
                    }
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30230uf c30230uf = new C30230uf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30230uf.populateBuilderWithField(c6086a3, c30230uf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        timeLineObject.xfI = c30230uf;
                    }
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 9:
                    timeLineObject.ijx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 10:
                    timeLineObject.vjM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 11:
                    timeLineObject.xfJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 12:
                    timeLineObject.xfK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 13:
                    timeLineObject.xfL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 14:
                    timeLineObject.xfM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7252av c7252av = new C7252av();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7252av.populateBuilderWithField(c6086a3, c7252av, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        timeLineObject.qNO = c7252av;
                    }
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 16:
                    timeLineObject.fgt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cfg cfg = new cfg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfg.populateBuilderWithField(c6086a3, cfg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        timeLineObject.xfN = cfg;
                    }
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 18:
                    timeLineObject.rjC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 19:
                    timeLineObject.rCK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cth cth = new cth();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cth.populateBuilderWithField(c6086a3, cth, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        timeLineObject.xfO = cth;
                    }
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 21:
                    timeLineObject.xfP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvi cvi = new cvi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvi.populateBuilderWithField(c6086a3, cvi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        timeLineObject.qNQ = cvi;
                    }
                    AppMethodBeat.m2505o(94634);
                    return 0;
                case 23:
                    timeLineObject.dtW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94634);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94634);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94634);
            return -1;
        }
    }
}
