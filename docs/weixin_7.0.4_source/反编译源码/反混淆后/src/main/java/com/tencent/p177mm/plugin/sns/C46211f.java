package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C45333id;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.f */
public final class C46211f extends C4884c<C45333id> {
    private C46236n qBY;
    private String qCb;
    private TimeLineObject qCc;

    public C46211f() {
        AppMethodBeat.m2504i(35610);
        this.xxI = C45333id.class.getName().hashCode();
        AppMethodBeat.m2505o(35610);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(35611);
        C45333id c45333id = (C45333id) c4883b;
        if (c45333id instanceof C45333id) {
            this.qCb = c45333id.cDc.cwT;
            this.qBY = C13373af.cnF().mo62918YT(this.qCb);
            this.qCc = this.qBY.cqu();
            if (this.qCc != null) {
                c45333id.cDd.cDe = this.qCc;
                AppMethodBeat.m2505o(35611);
                return true;
            }
        }
        C4990ab.m7414f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        AppMethodBeat.m2505o(35611);
        return false;
    }
}
