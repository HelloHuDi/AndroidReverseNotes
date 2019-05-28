package com.tencent.mm.plugin.forcenotify.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/model/CgiGetForceNotifyInfoList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetForcePushResponse;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class a extends com.tencent.mm.ai.a<aja> {
    private final String TAG = "MicroMsg.CgiGetForceNotifyInfoList";

    public a() {
        AppMethodBeat.i(51052);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(new aiz());
        aVar.b(new aja());
        aVar.qq("/cgi-bin/micromsg-bin/getforcepush");
        aVar.kU(691);
        aVar.kV(0);
        aVar.kW(0);
        a(aVar.acD());
        AppMethodBeat.o(51052);
    }

    public final /* synthetic */ void a(int i, int i2, String str, btd btd, m mVar) {
        AppMethodBeat.i(51051);
        aja aja = (aja) btd;
        j.p(aja, "resp");
        super.a(i, i2, str, aja, mVar);
        if (g.RK()) {
            ab.i(this.TAG, "CgiGetForceNotifyInfoList errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                LinkedList linkedList = aja.woU;
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        int i3;
                        ack ack = (ack) it.next();
                        b bVar = new b();
                        bVar.field_UserName = ack.jBB;
                        bVar.field_ExpiredTime = ((long) ack.vAR) * 1000;
                        bVar.field_CreateTime = ((long) ack.pcX) * 1000;
                        if ((cb.aaE() >= bVar.field_ExpiredTime ? 1 : 0) == 1) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        bVar.field_Status = i3;
                        bVar.field_Extinfo = ack.wkg;
                        bVar.field_Description = ack.vEA;
                        bVar.field_UserIcon = ack.wkf;
                        bVar.field_ForcePushId = ack.vEy;
                        boolean a = com.tencent.mm.plugin.forcenotify.d.a.mth.a(bVar);
                        ab.i(this.TAG, "ret:%s item:%s", Boolean.valueOf(a), bVar);
                    }
                }
                AppMethodBeat.o(51051);
                return;
            }
            ab.e(this.TAG, "report fail");
            AppMethodBeat.o(51051);
            return;
        }
        ab.e(this.TAG, "account nor ready");
        AppMethodBeat.o(51051);
    }
}
