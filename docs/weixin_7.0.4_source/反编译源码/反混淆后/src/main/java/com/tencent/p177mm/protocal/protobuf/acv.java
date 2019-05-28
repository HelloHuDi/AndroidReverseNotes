package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.acv */
public final class acv extends C1331a {
    public String IconUrl;
    public String Name;
    public String fKh;
    public String mZt;
    public String wbw;
    public ade wkA;
    public int wkB;
    public String wkC;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(112420);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.fKh == null) {
                c6092b = new C6092b("Not all required fields were included: AppId");
                AppMethodBeat.m2505o(112420);
                throw c6092b;
            } else if (this.Name == null) {
                c6092b = new C6092b("Not all required fields were included: Name");
                AppMethodBeat.m2505o(112420);
                throw c6092b;
            } else if (this.wbw == null) {
                c6092b = new C6092b("Not all required fields were included: Remark");
                AppMethodBeat.m2505o(112420);
                throw c6092b;
            } else if (this.IconUrl == null) {
                c6092b = new C6092b("Not all required fields were included: IconUrl");
                AppMethodBeat.m2505o(112420);
                throw c6092b;
            } else if (this.wkA == null) {
                c6092b = new C6092b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.m2505o(112420);
                throw c6092b;
            } else {
                if (this.fKh != null) {
                    c6093a.mo13475e(1, this.fKh);
                }
                if (this.Name != null) {
                    c6093a.mo13475e(2, this.Name);
                }
                if (this.wbw != null) {
                    c6093a.mo13475e(3, this.wbw);
                }
                if (this.IconUrl != null) {
                    c6093a.mo13475e(4, this.IconUrl);
                }
                if (this.mZt != null) {
                    c6093a.mo13475e(5, this.mZt);
                }
                if (this.wkA != null) {
                    c6093a.mo13479iy(6, this.wkA.computeSize());
                    this.wkA.writeFields(c6093a);
                }
                c6093a.mo13480iz(7, this.wkB);
                if (this.wkC != null) {
                    c6093a.mo13475e(8, this.wkC);
                }
                AppMethodBeat.m2505o(112420);
                return 0;
            }
        } else if (i == 1) {
            if (this.fKh != null) {
                f = C6091a.m9575f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            if (this.Name != null) {
                f += C6091a.m9575f(2, this.Name);
            }
            if (this.wbw != null) {
                f += C6091a.m9575f(3, this.wbw);
            }
            if (this.IconUrl != null) {
                f += C6091a.m9575f(4, this.IconUrl);
            }
            if (this.mZt != null) {
                f += C6091a.m9575f(5, this.mZt);
            }
            if (this.wkA != null) {
                f += C6087a.m9557ix(6, this.wkA.computeSize());
            }
            f += C6091a.m9572bs(7, this.wkB);
            if (this.wkC != null) {
                f += C6091a.m9575f(8, this.wkC);
            }
            AppMethodBeat.m2505o(112420);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.fKh == null) {
                c6092b = new C6092b("Not all required fields were included: AppId");
                AppMethodBeat.m2505o(112420);
                throw c6092b;
            } else if (this.Name == null) {
                c6092b = new C6092b("Not all required fields were included: Name");
                AppMethodBeat.m2505o(112420);
                throw c6092b;
            } else if (this.wbw == null) {
                c6092b = new C6092b("Not all required fields were included: Remark");
                AppMethodBeat.m2505o(112420);
                throw c6092b;
            } else if (this.IconUrl == null) {
                c6092b = new C6092b("Not all required fields were included: IconUrl");
                AppMethodBeat.m2505o(112420);
                throw c6092b;
            } else if (this.wkA == null) {
                c6092b = new C6092b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.m2505o(112420);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(112420);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            acv acv = (acv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    acv.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112420);
                    return 0;
                case 2:
                    acv.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112420);
                    return 0;
                case 3:
                    acv.wbw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112420);
                    return 0;
                case 4:
                    acv.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112420);
                    return 0;
                case 5:
                    acv.mZt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112420);
                    return 0;
                case 6:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ade ade = new ade();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ade.populateBuilderWithField(c6086a3, ade, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        acv.wkA = ade;
                    }
                    AppMethodBeat.m2505o(112420);
                    return 0;
                case 7:
                    acv.wkB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(112420);
                    return 0;
                case 8:
                    acv.wkC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112420);
                    return 0;
                default:
                    AppMethodBeat.m2505o(112420);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(112420);
            return -1;
        }
    }
}
