package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.exdevice.model.C38950ae;
import com.tencent.p177mm.plugin.exdevice.model.C42997s;
import com.tencent.p177mm.plugin.exdevice.service.C27865m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.exdevice.i.k */
public final class C41266k extends C38950ae implements C1202f {
    private int kWt = -1;
    private String lst = null;
    private String lsu = null;
    private String lxI = null;

    public C41266k(String str, String str2, String str3, int i) {
        this.lst = str;
        this.lxI = str2;
        this.lsu = str3;
        this.kWt = i;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19743);
        C4990ab.m7417i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        C9638aw.m17182Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI, (C1202f) this);
        AppMethodBeat.m2505o(19743);
    }

    /* renamed from: a */
    public final boolean mo23404a(C27865m c27865m, C42990d c42990d) {
        AppMethodBeat.m2504i(19744);
        C4990ab.m7416i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "execute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.lst + ",deviceType=" + this.lxI + ",deviceId=" + this.lsu + ",reqType=" + this.kWt);
        C9638aw.m17182Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI, (C1202f) this);
        C9638aw.m17182Rg().mo14541a(new C42997s(this.lst, this.lxI, this.lsu, this.kWt), 0);
        AppMethodBeat.m2505o(19744);
        return false;
    }
}
