package com.tencent.p177mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.kvdata.log_13905 */
public class log_13905 extends C1331a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public long time_stamp_;
    public long uin_;
    public VoiceInputBehavior viOp_;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(79161);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.viOp_ == null) {
                c6092b = new C6092b("Not all required fields were included: viOp_");
                AppMethodBeat.m2505o(79161);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.import_ds_);
            c6093a.mo13480iz(2, this.ds_);
            c6093a.mo13472ai(3, this.uin_);
            c6093a.mo13480iz(4, this.device_);
            c6093a.mo13480iz(5, this.clientVersion_);
            c6093a.mo13472ai(6, this.time_stamp_);
            if (this.viOp_ != null) {
                c6093a.mo13479iy(7, this.viOp_.computeSize());
                this.viOp_.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(79161);
            return 0;
        } else if (i == 1) {
            bs = (((((C6091a.m9572bs(1, this.import_ds_) + 0) + C6091a.m9572bs(2, this.ds_)) + C6091a.m9578o(3, this.uin_)) + C6091a.m9572bs(4, this.device_)) + C6091a.m9572bs(5, this.clientVersion_)) + C6091a.m9578o(6, this.time_stamp_);
            if (this.viOp_ != null) {
                bs += C6087a.m9557ix(7, this.viOp_.computeSize());
            }
            AppMethodBeat.m2505o(79161);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.viOp_ == null) {
                c6092b = new C6092b("Not all required fields were included: viOp_");
                AppMethodBeat.m2505o(79161);
                throw c6092b;
            }
            AppMethodBeat.m2505o(79161);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            log_13905 log_13905 = (log_13905) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    log_13905.import_ds_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79161);
                    return 0;
                case 2:
                    log_13905.ds_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79161);
                    return 0;
                case 3:
                    log_13905.uin_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79161);
                    return 0;
                case 4:
                    log_13905.device_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79161);
                    return 0;
                case 5:
                    log_13905.clientVersion_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79161);
                    return 0;
                case 6:
                    log_13905.time_stamp_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79161);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = voiceInputBehavior.populateBuilderWithField(c6086a3, voiceInputBehavior, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        log_13905.viOp_ = voiceInputBehavior;
                    }
                    AppMethodBeat.m2505o(79161);
                    return 0;
                default:
                    AppMethodBeat.m2505o(79161);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(79161);
            return -1;
        }
    }
}
