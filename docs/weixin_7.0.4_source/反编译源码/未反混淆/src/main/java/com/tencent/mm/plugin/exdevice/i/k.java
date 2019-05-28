package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class k extends ae implements f {
    private int kWt = -1;
    private String lst = null;
    private String lsu = null;
    private String lxI = null;

    public k(String str, String str2, String str3, int i) {
        this.lst = str;
        this.lxI = str2;
        this.lsu = str3;
        this.kWt = i;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19743);
        ab.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        aw.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI, (f) this);
        AppMethodBeat.o(19743);
    }

    public final boolean a(com.tencent.mm.plugin.exdevice.service.m mVar, d dVar) {
        AppMethodBeat.i(19744);
        ab.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "execute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.lst + ",deviceType=" + this.lxI + ",deviceId=" + this.lsu + ",reqType=" + this.kWt);
        aw.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI, (f) this);
        aw.Rg().a(new s(this.lst, this.lxI, this.lsu, this.kWt), 0);
        AppMethodBeat.o(19744);
        return false;
    }
}
