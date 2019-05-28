package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public class log_13905 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public long time_stamp_;
    public long uin_;
    public VoiceInputBehavior viOp_;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79161);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.viOp_ == null) {
                bVar = new b("Not all required fields were included: viOp_");
                AppMethodBeat.o(79161);
                throw bVar;
            }
            aVar.iz(1, this.import_ds_);
            aVar.iz(2, this.ds_);
            aVar.ai(3, this.uin_);
            aVar.iz(4, this.device_);
            aVar.iz(5, this.clientVersion_);
            aVar.ai(6, this.time_stamp_);
            if (this.viOp_ != null) {
                aVar.iy(7, this.viOp_.computeSize());
                this.viOp_.writeFields(aVar);
            }
            AppMethodBeat.o(79161);
            return 0;
        } else if (i == 1) {
            bs = (((((e.a.a.b.b.a.bs(1, this.import_ds_) + 0) + e.a.a.b.b.a.bs(2, this.ds_)) + e.a.a.b.b.a.o(3, this.uin_)) + e.a.a.b.b.a.bs(4, this.device_)) + e.a.a.b.b.a.bs(5, this.clientVersion_)) + e.a.a.b.b.a.o(6, this.time_stamp_);
            if (this.viOp_ != null) {
                bs += e.a.a.a.ix(7, this.viOp_.computeSize());
            }
            AppMethodBeat.o(79161);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.viOp_ == null) {
                bVar = new b("Not all required fields were included: viOp_");
                AppMethodBeat.o(79161);
                throw bVar;
            }
            AppMethodBeat.o(79161);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            log_13905 log_13905 = (log_13905) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    log_13905.import_ds_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79161);
                    return 0;
                case 2:
                    log_13905.ds_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79161);
                    return 0;
                case 3:
                    log_13905.uin_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79161);
                    return 0;
                case 4:
                    log_13905.device_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79161);
                    return 0;
                case 5:
                    log_13905.clientVersion_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79161);
                    return 0;
                case 6:
                    log_13905.time_stamp_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79161);
                    return 0;
                case 7:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = voiceInputBehavior.populateBuilderWithField(aVar4, voiceInputBehavior, a.getNextFieldNumber(aVar4))) {
                        }
                        log_13905.viOp_ = voiceInputBehavior;
                    }
                    AppMethodBeat.o(79161);
                    return 0;
                default:
                    AppMethodBeat.o(79161);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79161);
            return -1;
        }
    }
}
