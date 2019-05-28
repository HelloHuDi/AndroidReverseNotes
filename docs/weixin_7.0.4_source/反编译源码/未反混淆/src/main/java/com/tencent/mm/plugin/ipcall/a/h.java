package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.is;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends c<is> {
    public a nvS;

    public interface a {
        void a(bmc bmc);
    }

    public h() {
        AppMethodBeat.i(21760);
        this.xxI = is.class.getName().hashCode();
        AppMethodBeat.o(21760);
    }

    private boolean a(is isVar) {
        AppMethodBeat.i(21761);
        if (isVar instanceof is) {
            byte[] bArr = isVar.cDS.cDT;
            if (bArr == null || bArr.length <= 0) {
                AppMethodBeat.o(21761);
                return false;
            } else if (bArr[0] == (byte) 101) {
                byte[] bArr2 = new byte[(bArr.length - 1)];
                System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
                try {
                    bmc bmc = (bmc) new bmc().parseFrom(bArr2);
                    ab.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", Integer.valueOf(bmc.wem), Long.valueOf(bmc.wen), Integer.valueOf(bmc.nwP));
                    LinkedList linkedList = bmc.wPh;
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            bml bml = (bml) it.next();
                            ab.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", Integer.valueOf(bml.wPr), Integer.valueOf(bml.wPs), Integer.valueOf(bml.wPq));
                        }
                    }
                    if (this.nvS != null) {
                        this.nvS.a(bmc);
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", e.getMessage());
                }
            }
        }
        AppMethodBeat.o(21761);
        return false;
    }
}
