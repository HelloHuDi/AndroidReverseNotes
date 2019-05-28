package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public class log_13835 extends a {
    public int clientVersion_;
    public String currChatName_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public LinkedList<IMBehavior> oplist_ = new LinkedList();
    public long time_stamp_;
    public long uin_;

    public log_13835() {
        AppMethodBeat.i(79159);
        AppMethodBeat.o(79159);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79160);
        b bVar;
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.currChatName_ == null) {
                bVar = new b("Not all required fields were included: currChatName_");
                AppMethodBeat.o(79160);
                throw bVar;
            }
            aVar.iz(1, this.import_ds_);
            aVar.iz(2, this.ds_);
            aVar.ai(3, this.uin_);
            aVar.iz(4, this.device_);
            aVar.iz(5, this.clientVersion_);
            aVar.ai(6, this.time_stamp_);
            if (this.currChatName_ != null) {
                aVar.e(7, this.currChatName_);
            }
            aVar.e(8, 8, this.oplist_);
            AppMethodBeat.o(79160);
            return 0;
        } else if (i == 1) {
            bs = (((((e.a.a.b.b.a.bs(1, this.import_ds_) + 0) + e.a.a.b.b.a.bs(2, this.ds_)) + e.a.a.b.b.a.o(3, this.uin_)) + e.a.a.b.b.a.bs(4, this.device_)) + e.a.a.b.b.a.bs(5, this.clientVersion_)) + e.a.a.b.b.a.o(6, this.time_stamp_);
            if (this.currChatName_ != null) {
                bs += e.a.a.b.b.a.f(7, this.currChatName_);
            }
            bs += e.a.a.a.c(8, 8, this.oplist_);
            AppMethodBeat.o(79160);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.oplist_.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.currChatName_ == null) {
                bVar = new b("Not all required fields were included: currChatName_");
                AppMethodBeat.o(79160);
                throw bVar;
            }
            AppMethodBeat.o(79160);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            log_13835 log_13835 = (log_13835) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    log_13835.import_ds_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79160);
                    return 0;
                case 2:
                    log_13835.ds_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79160);
                    return 0;
                case 3:
                    log_13835.uin_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79160);
                    return 0;
                case 4:
                    log_13835.device_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79160);
                    return 0;
                case 5:
                    log_13835.clientVersion_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79160);
                    return 0;
                case 6:
                    log_13835.time_stamp_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79160);
                    return 0;
                case 7:
                    log_13835.currChatName_ = aVar3.BTU.readString();
                    AppMethodBeat.o(79160);
                    return 0;
                case 8:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        IMBehavior iMBehavior = new IMBehavior();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = iMBehavior.populateBuilderWithField(aVar4, iMBehavior, a.getNextFieldNumber(aVar4))) {
                        }
                        log_13835.oplist_.add(iMBehavior);
                    }
                    AppMethodBeat.o(79160);
                    return 0;
                default:
                    AppMethodBeat.o(79160);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79160);
            return -1;
        }
    }
}
