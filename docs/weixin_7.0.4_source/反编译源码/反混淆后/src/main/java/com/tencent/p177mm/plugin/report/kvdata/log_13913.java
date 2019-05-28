package com.tencent.p177mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.kvdata.log_13913 */
public class log_13913 extends C1331a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public String error_;
    public int import_ds_;
    public int scene_;
    public long time_stamp_;
    public long uin_;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(79162);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.import_ds_);
            c6093a.mo13480iz(2, this.ds_);
            c6093a.mo13472ai(3, this.uin_);
            c6093a.mo13480iz(4, this.device_);
            c6093a.mo13480iz(5, this.clientVersion_);
            c6093a.mo13472ai(6, this.time_stamp_);
            c6093a.mo13480iz(7, this.scene_);
            if (this.error_ != null) {
                c6093a.mo13475e(8, this.error_);
            }
            AppMethodBeat.m2505o(79162);
            return 0;
        } else if (i == 1) {
            bs = ((((((C6091a.m9572bs(1, this.import_ds_) + 0) + C6091a.m9572bs(2, this.ds_)) + C6091a.m9578o(3, this.uin_)) + C6091a.m9572bs(4, this.device_)) + C6091a.m9572bs(5, this.clientVersion_)) + C6091a.m9578o(6, this.time_stamp_)) + C6091a.m9572bs(7, this.scene_);
            if (this.error_ != null) {
                bs += C6091a.m9575f(8, this.error_);
            }
            AppMethodBeat.m2505o(79162);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(79162);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            log_13913 log_13913 = (log_13913) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    log_13913.import_ds_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79162);
                    return 0;
                case 2:
                    log_13913.ds_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79162);
                    return 0;
                case 3:
                    log_13913.uin_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79162);
                    return 0;
                case 4:
                    log_13913.device_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79162);
                    return 0;
                case 5:
                    log_13913.clientVersion_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79162);
                    return 0;
                case 6:
                    log_13913.time_stamp_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79162);
                    return 0;
                case 7:
                    log_13913.scene_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79162);
                    return 0;
                case 8:
                    log_13913.error_ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(79162);
                    return 0;
                default:
                    AppMethodBeat.m2505o(79162);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(79162);
            return -1;
        }
    }
}
