package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abu */
public final class abu extends C1331a {
    public String canvasPageXml;
    public String desc;
    public int fgt;
    public String thumbUrl;
    public String title;
    public boolean wfS = false;
    public boolean wfT = false;
    public boolean whe = false;
    public String wiY;
    public boolean wiZ = false;
    public boolean wiq = false;
    public int wja;
    public boolean wjb = false;
    public boolean wjc = false;

    public final abu alQ(String str) {
        this.title = str;
        this.wfS = true;
        return this;
    }

    public final abu alR(String str) {
        this.desc = str;
        this.wfT = true;
        return this;
    }

    public final abu alS(String str) {
        this.wiY = str;
        this.wiZ = true;
        return this;
    }

    public final abu alT(String str) {
        this.thumbUrl = str;
        this.wiq = true;
        return this;
    }

    /* renamed from: LO */
    public final abu mo27441LO(int i) {
        this.wja = i;
        this.wjb = true;
        return this;
    }

    /* renamed from: LP */
    public final abu mo27442LP(int i) {
        this.fgt = i;
        this.wjc = true;
        return this;
    }

    public final abu alU(String str) {
        this.canvasPageXml = str;
        this.whe = true;
        return this;
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51424);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(2, this.desc);
            }
            if (this.wiY != null) {
                c6093a.mo13475e(3, this.wiY);
            }
            if (this.thumbUrl != null) {
                c6093a.mo13475e(4, this.thumbUrl);
            }
            if (this.wjb) {
                c6093a.mo13480iz(5, this.wja);
            }
            if (this.wjc) {
                c6093a.mo13480iz(6, this.fgt);
            }
            if (this.canvasPageXml != null) {
                c6093a.mo13475e(7, this.canvasPageXml);
            }
            AppMethodBeat.m2505o(51424);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += C6091a.m9575f(2, this.desc);
            }
            if (this.wiY != null) {
                f += C6091a.m9575f(3, this.wiY);
            }
            if (this.thumbUrl != null) {
                f += C6091a.m9575f(4, this.thumbUrl);
            }
            if (this.wjb) {
                f += C6091a.m9572bs(5, this.wja);
            }
            if (this.wjc) {
                f += C6091a.m9572bs(6, this.fgt);
            }
            if (this.canvasPageXml != null) {
                f += C6091a.m9575f(7, this.canvasPageXml);
            }
            AppMethodBeat.m2505o(51424);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51424);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abu abu = (abu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abu.title = c6086a2.BTU.readString();
                    abu.wfS = true;
                    AppMethodBeat.m2505o(51424);
                    return 0;
                case 2:
                    abu.desc = c6086a2.BTU.readString();
                    abu.wfT = true;
                    AppMethodBeat.m2505o(51424);
                    return 0;
                case 3:
                    abu.wiY = c6086a2.BTU.readString();
                    abu.wiZ = true;
                    AppMethodBeat.m2505o(51424);
                    return 0;
                case 4:
                    abu.thumbUrl = c6086a2.BTU.readString();
                    abu.wiq = true;
                    AppMethodBeat.m2505o(51424);
                    return 0;
                case 5:
                    abu.wja = c6086a2.BTU.mo13458vd();
                    abu.wjb = true;
                    AppMethodBeat.m2505o(51424);
                    return 0;
                case 6:
                    abu.fgt = c6086a2.BTU.mo13458vd();
                    abu.wjc = true;
                    AppMethodBeat.m2505o(51424);
                    return 0;
                case 7:
                    abu.canvasPageXml = c6086a2.BTU.readString();
                    abu.whe = true;
                    AppMethodBeat.m2505o(51424);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51424);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51424);
            return -1;
        }
    }
}
