package com.tencent.p177mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.kvdata.log_14375 */
public class log_14375 extends C1331a {
    public int clientVersion_;
    public BDStatusInfo dbStatusInfo_;
    public int device_;
    public int ds_;
    public HeavyDetailInfo heavyDetailInfo_;
    public int import_ds_;
    public SDStatusInfo sdStatusInfo_;
    public long time_stamp_;
    public int type_;
    public long uin_;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(79163);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.import_ds_);
            c6093a.mo13480iz(2, this.ds_);
            c6093a.mo13472ai(3, this.uin_);
            c6093a.mo13480iz(4, this.device_);
            c6093a.mo13480iz(5, this.clientVersion_);
            c6093a.mo13472ai(6, this.time_stamp_);
            c6093a.mo13480iz(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                c6093a.mo13479iy(8, this.dbStatusInfo_.computeSize());
                this.dbStatusInfo_.writeFields(c6093a);
            }
            if (this.sdStatusInfo_ != null) {
                c6093a.mo13479iy(9, this.sdStatusInfo_.computeSize());
                this.sdStatusInfo_.writeFields(c6093a);
            }
            if (this.heavyDetailInfo_ != null) {
                c6093a.mo13479iy(10, this.heavyDetailInfo_.computeSize());
                this.heavyDetailInfo_.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(79163);
            return 0;
        } else if (i == 1) {
            bs = ((((((C6091a.m9572bs(1, this.import_ds_) + 0) + C6091a.m9572bs(2, this.ds_)) + C6091a.m9578o(3, this.uin_)) + C6091a.m9572bs(4, this.device_)) + C6091a.m9572bs(5, this.clientVersion_)) + C6091a.m9578o(6, this.time_stamp_)) + C6091a.m9572bs(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                bs += C6087a.m9557ix(8, this.dbStatusInfo_.computeSize());
            }
            if (this.sdStatusInfo_ != null) {
                bs += C6087a.m9557ix(9, this.sdStatusInfo_.computeSize());
            }
            if (this.heavyDetailInfo_ != null) {
                bs += C6087a.m9557ix(10, this.heavyDetailInfo_.computeSize());
            }
            AppMethodBeat.m2505o(79163);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(79163);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            log_14375 log_14375 = (log_14375) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    log_14375.import_ds_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79163);
                    return 0;
                case 2:
                    log_14375.ds_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79163);
                    return 0;
                case 3:
                    log_14375.uin_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79163);
                    return 0;
                case 4:
                    log_14375.device_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79163);
                    return 0;
                case 5:
                    log_14375.clientVersion_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79163);
                    return 0;
                case 6:
                    log_14375.time_stamp_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79163);
                    return 0;
                case 7:
                    log_14375.type_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79163);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BDStatusInfo bDStatusInfo = new BDStatusInfo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bDStatusInfo.populateBuilderWithField(c6086a3, bDStatusInfo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        log_14375.dbStatusInfo_ = bDStatusInfo;
                    }
                    AppMethodBeat.m2505o(79163);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SDStatusInfo sDStatusInfo = new SDStatusInfo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sDStatusInfo.populateBuilderWithField(c6086a3, sDStatusInfo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        log_14375.sdStatusInfo_ = sDStatusInfo;
                    }
                    AppMethodBeat.m2505o(79163);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = heavyDetailInfo.populateBuilderWithField(c6086a3, heavyDetailInfo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        log_14375.heavyDetailInfo_ = heavyDetailInfo;
                    }
                    AppMethodBeat.m2505o(79163);
                    return 0;
                default:
                    AppMethodBeat.m2505o(79163);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(79163);
            return -1;
        }
    }
}
