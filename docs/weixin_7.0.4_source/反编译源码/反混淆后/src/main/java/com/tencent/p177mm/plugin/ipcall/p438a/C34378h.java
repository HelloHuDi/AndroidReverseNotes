package com.tencent.p177mm.plugin.ipcall.p438a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18301is;
import com.tencent.p177mm.protocal.protobuf.bmc;
import com.tencent.p177mm.protocal.protobuf.bml;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.ipcall.a.h */
public final class C34378h extends C4884c<C18301is> {
    public C34379a nvS;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.h$a */
    public interface C34379a {
        /* renamed from: a */
        void mo46242a(bmc bmc);
    }

    public C34378h() {
        AppMethodBeat.m2504i(21760);
        this.xxI = C18301is.class.getName().hashCode();
        AppMethodBeat.m2505o(21760);
    }

    /* renamed from: a */
    private boolean m56374a(C18301is c18301is) {
        AppMethodBeat.m2504i(21761);
        if (c18301is instanceof C18301is) {
            byte[] bArr = c18301is.cDS.cDT;
            if (bArr == null || bArr.length <= 0) {
                AppMethodBeat.m2505o(21761);
                return false;
            } else if (bArr[0] == (byte) 101) {
                byte[] bArr2 = new byte[(bArr.length - 1)];
                System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
                try {
                    bmc bmc = (bmc) new bmc().parseFrom(bArr2);
                    C4990ab.m7411d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", Integer.valueOf(bmc.wem), Long.valueOf(bmc.wen), Integer.valueOf(bmc.nwP));
                    LinkedList linkedList = bmc.wPh;
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            bml bml = (bml) it.next();
                            C4990ab.m7411d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", Integer.valueOf(bml.wPr), Integer.valueOf(bml.wPs), Integer.valueOf(bml.wPq));
                        }
                    }
                    if (this.nvS != null) {
                        this.nvS.mo46242a(bmc);
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", e.getMessage());
                }
            }
        }
        AppMethodBeat.m2505o(21761);
        return false;
    }
}
