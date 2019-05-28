package com.tencent.p177mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.kvdata.BDStatusInfo */
public class BDStatusInfo extends C1331a {
    public long favDBSize_;
    public long mmDBSize_;
    public int mmDBTableCount_;
    public long snsDBSize_;
    public LinkedList<TableInfo> tableList_ = new LinkedList();

    public BDStatusInfo() {
        AppMethodBeat.m2504i(79146);
        AppMethodBeat.m2505o(79146);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(79147);
        int o;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.mmDBSize_);
            c6093a.mo13472ai(2, this.snsDBSize_);
            c6093a.mo13480iz(3, this.mmDBTableCount_);
            c6093a.mo13474e(4, 8, this.tableList_);
            c6093a.mo13472ai(5, this.favDBSize_);
            AppMethodBeat.m2505o(79147);
            return 0;
        } else if (i == 1) {
            o = ((((C6091a.m9578o(1, this.mmDBSize_) + 0) + C6091a.m9578o(2, this.snsDBSize_)) + C6091a.m9572bs(3, this.mmDBTableCount_)) + C6087a.m9552c(4, 8, this.tableList_)) + C6091a.m9578o(5, this.favDBSize_);
            AppMethodBeat.m2505o(79147);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tableList_.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(79147);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            BDStatusInfo bDStatusInfo = (BDStatusInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bDStatusInfo.mmDBSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79147);
                    return 0;
                case 2:
                    bDStatusInfo.snsDBSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79147);
                    return 0;
                case 3:
                    bDStatusInfo.mmDBTableCount_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79147);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        TableInfo tableInfo = new TableInfo();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = tableInfo.populateBuilderWithField(c6086a3, tableInfo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bDStatusInfo.tableList_.add(tableInfo);
                    }
                    AppMethodBeat.m2505o(79147);
                    return 0;
                case 5:
                    bDStatusInfo.favDBSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79147);
                    return 0;
                default:
                    AppMethodBeat.m2505o(79147);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(79147);
            return -1;
        }
    }
}
