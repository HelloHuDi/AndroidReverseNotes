package com.tencent.p177mm.plugin.forcenotify.p1613c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.forcenotify.p1648d.C45947a;
import com.tencent.p177mm.protocal.protobuf.ack;
import com.tencent.p177mm.protocal.protobuf.aiz;
import com.tencent.p177mm.protocal.protobuf.aja;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/model/CgiGetForceNotifyInfoList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetForcePushResponse;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
/* renamed from: com.tencent.mm.plugin.forcenotify.c.a */
public final class C45946a extends C37440a<aja> {
    private final String TAG = "MicroMsg.CgiGetForceNotifyInfoList";

    public C45946a() {
        AppMethodBeat.m2504i(51052);
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(new aiz());
        c1196a.mo4446b(new aja());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/getforcepush");
        c1196a.mo4447kU(691);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        mo60331a(c1196a.acD());
        AppMethodBeat.m2505o(51052);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
        AppMethodBeat.m2504i(51051);
        aja aja = (aja) btd;
        C25052j.m39376p(aja, "resp");
        super.mo21469a(i, i2, str, aja, c1207m);
        if (C1720g.m3531RK()) {
            C4990ab.m7417i(this.TAG, "CgiGetForceNotifyInfoList errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                LinkedList linkedList = aja.woU;
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        int i3;
                        ack ack = (ack) it.next();
                        C43101b c43101b = new C43101b();
                        c43101b.field_UserName = ack.jBB;
                        c43101b.field_ExpiredTime = ((long) ack.vAR) * 1000;
                        c43101b.field_CreateTime = ((long) ack.pcX) * 1000;
                        if ((C1839cb.aaE() >= c43101b.field_ExpiredTime ? 1 : 0) == 1) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        c43101b.field_Status = i3;
                        c43101b.field_Extinfo = ack.wkg;
                        c43101b.field_Description = ack.vEA;
                        c43101b.field_UserIcon = ack.wkf;
                        c43101b.field_ForcePushId = ack.vEy;
                        boolean a = C45947a.mth.mo10099a(c43101b);
                        C4990ab.m7417i(this.TAG, "ret:%s item:%s", Boolean.valueOf(a), c43101b);
                    }
                }
                AppMethodBeat.m2505o(51051);
                return;
            }
            C4990ab.m7412e(this.TAG, "report fail");
            AppMethodBeat.m2505o(51051);
            return;
        }
        C4990ab.m7412e(this.TAG, "account nor ready");
        AppMethodBeat.m2505o(51051);
    }
}
